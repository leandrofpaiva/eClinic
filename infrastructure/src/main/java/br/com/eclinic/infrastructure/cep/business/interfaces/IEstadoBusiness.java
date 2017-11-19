package br.com.eclinic.infrastructure.cep.business.interfaces;

import java.util.List;

import br.com.eclinic.infrastructure.cep.entities.EstadoEntity;

public interface IEstadoBusiness {

    /**
     * Cria o registro de Estados
     * 
     * @param estados
     *            Registro que sera criado
     * @return Estados
     */
    public EstadoEntity create(EstadoEntity estados);

    /**
     * Retorna o Registro com base no ID informado
     * 
     * @param id
     *            Identificador do Registro
     * @return Estados
     */
    public EstadoEntity read(Integer id);

    /**
     * Atualiza o registro de Estados
     * 
     * @param estados
     *            Registro que sera criado
     * @return Estados
     */
    public EstadoEntity update(EstadoEntity estados);

    /**
     * Exclui o registro de Estados
     * 
     * @param id
     *            Identificador do Registro
     * @return Estados
     */
    public void delete(Integer id);

    /**
     * Retorna a Lista de Estados
     * 
     * @return List<Estados>
     */
    public List<EstadoEntity> list();

}
