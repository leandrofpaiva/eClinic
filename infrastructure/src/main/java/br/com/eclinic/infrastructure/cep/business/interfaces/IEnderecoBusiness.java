package br.com.eclinic.infrastructure.cep.business.interfaces;

import java.util.List;

import br.com.eclinic.domain.cep.Endereco;
import br.com.eclinic.domain.types.Cep;
import br.com.eclinic.infrastructure.cep.entities.EnderecoEntity;

public interface IEnderecoBusiness {

    /**
     * Cria o registro de Enderecos
     * 
     * @param enderecos
     *            Registro que sera criado
     * @return Enderecos
     */
    public Endereco create(Endereco endereco);

    /**
     * Retorna o Registro com base no ID informado
     * 
     * @param id
     *            Identificador do Registro
     * @return Enderecos
     */
    public EnderecoEntity read(Integer id);

    /**
     * Atualiza o registro de Enderecos
     * 
     * @param enderecos
     *            Registro que sera criado
     * @return Enderecos
     */
    public Endereco update(Endereco endereco);

    /**
     * Exclui o registro de Enderecos
     * 
     * @param id
     *            Identificador do Registro
     * @return Enderecos
     */
    public void delete(Integer id);

    /**
     * Retorna a Lista de Enderecos
     * 
     * @return List<Enderecos>
     */
    public List<Endereco> list();
    
    /**
     * Retorna o Cep informado
     * 
     * @return EnderecoEntity
     */
    public Endereco findByCep(Cep cep);

}
