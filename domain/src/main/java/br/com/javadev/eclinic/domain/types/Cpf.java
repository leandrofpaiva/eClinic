/*
    This file is part of Opes.

    Opes is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Opes is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Opes.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.javadev.eclinic.domain.types;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.FormattableFlags.ALTERNATE;
import static java.util.FormattableFlags.LEFT_JUSTIFY;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.common.base.Objects;

@Embeddable
public class Cpf implements Serializable, Formattable, Comparable<Cpf> {

	private static final long serialVersionUID = 1L;

	@Column(name = "CPF", length = 14)
	private final String cpf;

	private Cpf(String cpf) {
		this.cpf = cpf;
	}

	public Cpf() {
		cpf = "";
	}

	public static Cpf fromString(String s) {
		checkNotNull(s);
		String digits = s.replaceAll("\\D", "");
		checkArgument(digits.matches("\\d{11}"));
		checkArgument(!digits.matches("(\\d)\\1+"));
		checkArgument(isValid(digits.substring(0, 10)));
		checkArgument(isValid(digits));
		return new Cpf(digits);
	}

	static boolean isValid(String digits) {
		if (Long.parseLong(digits) % 10 == 0) {
			return somaPonderada(digits) % 11 < 2;
		} else {
			return somaPonderada(digits) % 11 == 0;
		}
	}

	static int somaPonderada(String digits) {
		char[] cs = digits.toCharArray();
		int soma = 0;
		for (int i = 0; i < cs.length; i++) {
			soma += Character.digit(cs[i], 10) * (cs.length - i);
		}
		return soma;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Cpf) {
			Cpf other = (Cpf) obj;
			return Objects.equal(this.cpf, other.cpf);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.cpf);
	}

	@Override
	public String toString() {
		return this.cpf;
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width,
			int precision) {
		StringBuilder sb = new StringBuilder();
		boolean alternate = (flags & ALTERNATE) == ALTERNATE;
		if (alternate) {
			sb.append(cpf);
		} else {
			sb.append(String.format("%s.%s.%s-%s", cpf.substring(0, 3),
					cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9)));
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

	@Override
	public int compareTo(Cpf o) {
		return this.cpf.compareTo(o.cpf);
	}

	public String getCpf() {
		return cpf;
	}

}