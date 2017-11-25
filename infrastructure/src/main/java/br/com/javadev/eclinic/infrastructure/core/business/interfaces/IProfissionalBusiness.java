package br.com.javadev.eclinic.infrastructure.core.business.interfaces;

import java.util.List;

import br.com.javadev.eclinic.domain.core.Profissional;

public interface IProfissionalBusiness {

	/**
	 * Cria/atualiza o registro do Profissional
	 * 
	 * @param profissional
	 *            Registro que sera criado
	 * @return Profissional
	 */
	public Profissional gravar(Profissional profissional);

	/**
	 * Retorna o Registro com base no ID informado
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Profissional
	 */
	public Profissional consultar(Integer id);

	/**
	 * Exclui o registro do Profissional
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Profissional
	 */
	public void excluir(Integer id);

	/**
	 * Retorna a Lista de todos Profissionais
	 * 
	 * @return List<Profissional>
	 */
	public List<Profissional> listarTodos();

	/**
	 * Retorna a Lista de todos Profissionais Combo
	 * 
	 * @return List<Profissional>
	 */
	public List<Profissional> listarTodosCombo();

}
