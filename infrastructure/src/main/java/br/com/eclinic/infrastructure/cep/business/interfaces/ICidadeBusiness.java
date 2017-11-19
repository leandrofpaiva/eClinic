package br.com.eclinic.infrastructure.cep.business.interfaces;

import java.util.List;

import br.com.eclinic.infrastructure.cep.entities.CidadeEntity;

public interface ICidadeBusiness {

    /**
     * Cria o registro de Cidades
     * 
     * @param cidades
     *            Registro que sera criado
     * @return Cidades
     */
    public CidadeEntity create(CidadeEntity cidades);

    /**
     * Retorna o Registro com base no ID informado
     * 
     * @param id
     *            Identificador do Registro
     * @return Cidades
     */
    public CidadeEntity read(Integer id);

    /**
     * Atualiza o registro de Cidades
     * 
     * @param cidades
     *            Registro que sera criado
     * @return Cidades
     */
    public CidadeEntity update(CidadeEntity cidades);

    /**
     * Exclui o registro de Cidades
     * 
     * @param id
     *            Identificador do Registro
     * @return Cidades
     */
    public void delete(Integer id);

    /**
     * Retorna a Lista de Cidades
     * 
     * @return List<Cidades>
     */
    public List<CidadeEntity> list();

}
