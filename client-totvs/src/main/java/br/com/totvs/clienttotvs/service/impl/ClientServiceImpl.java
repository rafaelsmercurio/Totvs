package br.com.totvs.clienttotvs.service.impl;

import br.com.totvs.clienttotvs.model.ClientResponse;
import br.com.totvs.clienttotvs.model.ClientUsers;
import br.com.totvs.clienttotvs.repository.jdbc.ClientRepositoryJdbc;
import br.com.totvs.clienttotvs.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepositoryJdbc clientRepositoryJdbc;

    public ClientResponse.StandardResponse getList() {
        ClientResponse clientResponse = new ClientResponse();

        try {
            List<ClientUsers> clientUsersList = clientRepositoryJdbc.getClients();
            clientResponse.setData(clientUsersList);
        } catch (Exception e) {
            return new ClientResponse.StandardResponse(clientResponse);
        }
        return new ClientResponse.StandardResponse(clientResponse);
    }

    public ClientResponse.StandardResponse getStatus(String cpf) {
        ClientResponse clientResponse = new ClientResponse();

        try {
            List<ClientUsers> clientUsersList = clientRepositoryJdbc.getStatus(cpf);
            clientResponse.setData(clientUsersList);
        } catch (Exception e) {
            return new ClientResponse.StandardResponse(clientResponse);
        }
        return new ClientResponse.StandardResponse(clientResponse);
    }


}
