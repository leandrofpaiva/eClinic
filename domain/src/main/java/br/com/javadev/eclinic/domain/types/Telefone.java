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
public class Telefone implements Serializable, Formattable,
		Comparable<Telefone> {

	private static final long serialVersionUID = 1L;

	@Column(name = "TELEFONE", length = 14)
	private final String telefone;

	private Telefone(String telefone) {
		this.telefone = telefone;
	}

	public Telefone() {
		telefone = "";
	}

	public static Telefone fromString(String s) {
		checkNotNull(s);
		String digits = s.replaceAll("\\D", "");
		checkArgument(digits
				.matches("1\\d{2}|1\\d{4}|0300\\d{8}|0800\\d{7,8}|\\d{8,13}"));
		return new Telefone(digits);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Telefone) {
			Telefone other = (Telefone) obj;
			return Objects.equal(this.telefone, other.telefone);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.telefone);
	}

	@Override
	public String toString() {
		return this.telefone;
	}

	public boolean isContemDdd() {
		if (telefone.matches("0[3,8]\\d+")) {
			return false;
		} else {
			return telefone.length() > 9;
		}
	}

	public boolean isContemDdi() {
		if (telefone.matches("0[3,8]\\d+")) {
			return false;
		} else {
			return telefone.length() > 11;
		}
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width,
			int precision) {
		StringBuilder sb = new StringBuilder();
		boolean alternate = (flags & ALTERNATE) == ALTERNATE;
		if (alternate) {
			sb.append(telefone);
		} else {
			switch (telefone.length()) {
			case 3:
				sb.append(telefone);
				break;
			case 5:
				sb.append(telefone);
				break;
			case 8:
				sb.append(String.format("%s-%s", telefone.substring(0, 4),
						telefone.substring(4)));
				break;
			case 9:
				sb.append(String.format("%s-%s", telefone.substring(0, 5),
						telefone.substring(5)));
				break;
			case 10:
				if (telefone.matches("0800\\d+")) {
					sb.append(String.format("%s-%s-%s",
							telefone.substring(0, 4), telefone.substring(4, 6),
							telefone.substring(6)));
				} else {
					sb.append(String.format("(%s) %s-%s",
							telefone.substring(0, 2), telefone.substring(2, 6),
							telefone.substring(6)));
				}
				break;
			case 11:
				if (telefone.matches("0[3,8]00\\d+")) {
					sb.append(String.format("%s-%s-%s",
							telefone.substring(0, 4), telefone.substring(4, 7),
							telefone.substring(7)));
				} else {
					sb.append(String.format("(%s) %s-%s",
							telefone.substring(0, 2), telefone.substring(2, 7),
							telefone.substring(7)));
				}
				break;
			case 12:
				sb.append(String.format("+%s (%s) %s-%s",
						telefone.substring(0, 2), telefone.substring(2, 4),
						telefone.substring(4, 8), telefone.substring(8)));
				break;
			case 13:
				sb.append(String.format("+%s (%s) %s-%s",
						telefone.substring(0, 2), telefone.substring(2, 4),
						telefone.substring(4, 9), telefone.substring(9)));
				break;
			}
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
	public int compareTo(Telefone o) {
		return this.telefone.compareTo(o.telefone);
	}

	public String getTelefone() {
		return telefone;
	}

}