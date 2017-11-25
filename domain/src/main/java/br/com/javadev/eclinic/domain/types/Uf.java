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

import java.util.Map;

import javax.persistence.Embeddable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

@Embeddable
public enum Uf {

	AC(12, "Acre"),

	AL(27, "Alagoas"),

	AM(13, "Amazonas"),

	AP(16, "Amap\u00e1"),

	BA(29, "Bahia"),

	CE(23, "Cear\u00e1"),

	DF(53, "Distrito Federal"),

	ES(32, "Esp\u00edrito Santo"),

	GO(52, "Goi\u00e1s"),

	MA(21, "Maranh\u00e3o"),

	MG(31, "Minas Gerais"),

	MS(50, "Mato Grosso do Sul"),

	MT(51, "Mato Grosso"),

	PA(15, "Par\u00e1"),

	PB(25, "Para\u00edba"),

	PE(26, "Pernambuco"),

	PI(22, "Piau\u00ed"),

	PR(41, "Paran\u00e1"),

	RJ(33, "Rio de Janeiro"),

	RN(24, "Rio Grande do Norte"),

	RO(11, "Rond\u00f4nia"),

	RR(14, "Roraima"),

	RS(43, "Rio Grande do Sul"),

	SC(42, "Santa Catarina"),

	SE(28, "Sergipe"),

	SP(35, "S\u00e3o Paulo"),

	TO(17, "Tocantins"),

	EX(0, "Exterior");

	private static final Map<Integer, Uf> codigoMap;

	static {
		Builder<Integer, Uf> builder = ImmutableMap.builder();
		for (Uf uf : values()) {
			builder.put(uf.getCodigoIbge(), uf);
		}
		codigoMap = builder.build();
	}

	public static Uf fromCodigoIbge(int codigo) {
		return codigoMap.get(codigo);
	}

	private final String nome;

	private final int codigoIbge;

	private Uf(int codigoIbge, String nome) {
		this.codigoIbge = codigoIbge;
		this.nome = nome;
	}

	public int getCodigoIbge() {
		return codigoIbge;
	}

	public String getNome() {
		return nome;
	}

}
