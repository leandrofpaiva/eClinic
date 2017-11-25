package br.com.javadev.eclinic.infrastructure.core.business.interfaces;

import java.util.List;

import br.com.javadev.eclinic.domain.core.Hospital;

public interface IHospitalBusiness {

	/**
	 * Cria o registro de Hospital
	 * 
	 * @param hospital
	 *            Registro que sera criado
	 * @return Hospital
	 */
	public Hospital gravar(Hospital hospital);

	/**
	 * Retorna o Registro com base no ID informado
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Hospital
	 */
	public Hospital consultar(Integer id);

	/**
	 * Exclui o registro de Hospital
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Hospitals
	 */
	public void excluir(Integer id);

	/**
	 * Retorna a Lista de Hospital
	 * 
	 * @return List<Hospital>
	 */
	public List<Hospital> listarTodos();

	/**
	 * Retorna a Lista de todos Hospital Combo
	 * 
	 * @return List<Profissional>
	 */
	public List<Hospital> listarTodosCombo();

}
