package br.com.totvs.clienttotvs.repository;

import br.com.totvs.clienttotvs.model.ClientUsers;


import java.util.List;


public interface ClientRepository {

    public List<ClientUsers> getClients();

    public List<ClientUsers> getStatus(String cpf);

}
