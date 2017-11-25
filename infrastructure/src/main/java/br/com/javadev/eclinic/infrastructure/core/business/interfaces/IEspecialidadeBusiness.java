package br.com.javadev.eclinic.infrastructure.core.business.interfaces;

import java.util.List;

import br.com.javadev.eclinic.domain.core.Especialidade;

public interface IEspecialidadeBusiness {

	/**
	 * Cria/atualiza o registro de Especialidades
	 * 
	 * @param especialidade
	 *            Registro que sera criado
	 * @return Especialidade
	 */
	public Especialidade gravar(Especialidade especialidade);

	/**
	 * Retorna o Registro com base no ID informado
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Especialidade
	 */
	public Especialidade consultar(Integer id);

	/**
	 * Exclui o registro de Especialidades
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Especialidade
	 */
	public void excluir(Integer id);

	/**
	 * Retorna a Lista de todas as Especialidades
	 * 
	 * @return List<Especialidade>
	 */
	public List<Especialidade> listarTodos();

	/**
	 * Retorna a Lista de todos Especialidades Combo
	 * 
	 * @return List<Profissional>
	 */
	public List<Especialidade> listarTodosCombo();

}
