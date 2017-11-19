package br.com.eclinic.infrastructure.config.business.interfaces;

import java.util.List;

import br.com.eclinic.domain.config.Parametro;

public interface IParametroBusiness {

	/**
	 * Cria/atualiza o registro do Parametro
	 * 
	 * @param parametro
	 *            Registro que sera criado
	 * @return Parametro
	 */
	public Parametro gravar(Parametro parametro);

	/**
	 * Retorna o Registro com base no ID informado
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Parametro
	 */
	public Parametro consultar(Integer id);

	/**
	 * Exclui o registro do Parametro
	 * 
	 * @param id
	 *            Identificador do Registro
	 * @return Parametro
	 */
	public void excluir(Integer id);

	/**
	 * Retorna a Lista de todos Parametros
	 * 
	 * @return List<Parametro>
	 */
	public List<Parametro> listarTodos();

}
