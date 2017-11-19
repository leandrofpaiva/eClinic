package br.com.eclinic.infrastructure.medic.business.interfaces;

import java.util.List;

import br.com.eclinic.domain.medic.Cargo;

public interface ICargoBusiness {

	/**
	 * Cria/atualiza o registro de Profissao
	 * 
	 * @param profissao
	 *            Registro que sera criado
	 * @return Profissao
	 */
	public Cargo gravar(Cargo profissao);

	/**
	 * Retorna o Registro com base no ID informado
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Profissao
	 */
	public Cargo consultar(Integer id);

	/**
	 * Exclui o registro de Profissao
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Profissao
	 */
	public void excluir(Integer id);

	/**
	 * Retorna a Lista de Profissoes
	 * 
	 * @return List<Profissao>
	 */
	public List<Cargo> listarTodos();

	/**
	 * Retorna a Lista de todos Profissao Combo
	 * 
	 * @return List<Profissional>
	 */
	public List<Cargo> listarTodosCombo();
}
