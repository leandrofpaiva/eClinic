package br.com.eclinic.infrastructure.config.business.interfaces;

import java.util.List;

import br.com.eclinic.domain.config.Status;

public interface IStatusBusiness {

	/**
	 * Cria/atualiza o registro do Status
	 * 
	 * @param status
	 *            Registro que sera criado
	 * @return Status
	 */
	public Status gravar(Status status);

	/**
	 * Retorna o Registro com base no ID informado
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Status
	 */
	public Status consultar(Integer id);

	/**
	 * Exclui o registro do Status
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Status
	 */
	public void excluir(Integer id);

	/**
	 * Retorna a Lista de todos Status
	 * 
	 * @return List<Status>
	 */
	public List<Status> listarTodos();

}
