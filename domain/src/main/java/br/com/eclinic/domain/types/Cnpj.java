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
package br.com.eclinic.domain.types;

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
public class Cnpj implements Serializable, Formattable, Comparable<Cnpj> {

	private static final long serialVersionUID = 1L;

	@Column(name = "CNPJ", length = 20)
	private final String cnpj;

	private Cnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Cnpj() {
		cnpj = "";
	}

	public static Cnpj fromString(String s) {
		checkNotNull(s);
		String digits = s.replaceAll("\\D", "");
		checkArgument(digits.matches("\\d{14}"));
		checkArgument(!digits.matches("(\\d)\\1+"));
		checkArgument(isValid(digits.substring(0, 13)));
		checkArgument(isValid(digits));
		return new Cnpj(digits);
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
			int index = cs.length - i - 1;
			soma += Character.digit(cs[i], 10)
					* ((index % 9 + 1) + (index / 9));
		}
		return soma;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Cnpj) {
			Cnpj other = (Cnpj) obj;
			return Objects.equal(this.cnpj, other.cnpj);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.cnpj);
	}

	@Override
	public String toString() {
		return this.cnpj;
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width,
			int precision) {
		StringBuilder sb = new StringBuilder();
		boolean alternate = (flags & ALTERNATE) == ALTERNATE;
		if (alternate) {
			sb.append(cnpj);
		} else {
			sb.append(String.format("%s.%s.%s/%s-%s", cnpj.substring(0, 2),
					cnpj.substring(2, 5), cnpj.substring(5, 8),
					cnpj.substring(8, 12), cnpj.substring(12)));
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
	public int compareTo(Cnpj o) {
		return this.cnpj.compareTo(o.cnpj);
	}

	public String getCnpj() {
		return cnpj;
	}

}