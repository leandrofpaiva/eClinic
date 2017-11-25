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

import javax.persistence.Embeddable;

import com.google.common.base.Objects;

@Embeddable
public class Cep implements Serializable, Formattable, Comparable<Cep> {

	private static final long serialVersionUID = 1L;

	private final String cep;

	public Cep() {
		this.cep = "";
	}

	private Cep(String cep) {
		this.cep = cep;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Cep) {
			Cep other = (Cep) obj;
			return Objects.equal(this.cep, other.cep);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.cep);
	}

	@Override
	public String toString() {
		return this.cep;
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		StringBuilder sb = new StringBuilder();
		boolean alternate = (flags & ALTERNATE) == ALTERNATE;
		if (alternate) {
			sb.append(cep);
		} else {
			sb.append(cep.substring(0, 5));
			sb.append("-");
			sb.append(cep.substring(5));
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
	public int compareTo(Cep o) {
		return this.cep.compareTo(o.cep);
	}

	public static Cep fromString(String s) {
		checkNotNull(s);
		String digits = s.replaceAll("\\D", "");
		checkArgument(digits.matches("\\d{8}"));

		return new Cep(digits);
	}

	public String getCep() {
		return cep;
	}
}
