package br.com.eclinic.domain.types;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.FormattableFlags.ALTERNATE;
import static java.util.FormattableFlags.LEFT_JUSTIFY;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;

import javax.persistence.Embeddable;

import com.google.common.base.Objects;

@Embeddable
public class Agencia implements Serializable, Formattable {

	private static final long serialVersionUID = 1L;

	private final String numero;

	private final String dv;

	private Agencia(String numero, String dv) {
		this.numero = numero;
		this.dv = dv;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Agencia) {
			Agencia other = (Agencia) obj;
			return Objects.equal(this.numero, other.numero) && Objects.equal(this.dv, other.dv);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.numero, this.dv);
	}

	@Override
	public String toString() {
		return String.format("%s%s", numero, dv);
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		StringBuilder sb = new StringBuilder();
		boolean alternate = (flags & ALTERNATE) == ALTERNATE;
		if (alternate) {
			sb.append(numero);
			sb.append(dv);
		} else {
			sb.append(numero);
			sb.append("-");
			sb.append(dv);
		}
		int length = sb.length();
		if (length < width) {
			for (int i = 0; i < width - length; i++) {
				if (alternate) {
					sb.insert(0, '0');
				} else {
					boolean leftJustified = (flags & LEFT_JUSTIFY) == LEFT_JUSTIFY;
					if (leftJustified) {
						sb.append(' ');
					} else {
						sb.insert(0, ' ');
					}
				}
			}
		}
		formatter.format(sb.toString());
	}

	public static Agencia fromString(String s) {
		checkNotNull(s);
		String digits = s.replaceAll("\\W", "").replaceAll("^0*", "");
		checkArgument(digits.matches("\\d+\\w"));

		int length = digits.length();
		return new Agencia(digits.substring(0, length - 1), digits.substring(length - 1));
	}

	public String getNumero() {
		return numero;
	}

	public String getDv() {
		return dv;
	}

}