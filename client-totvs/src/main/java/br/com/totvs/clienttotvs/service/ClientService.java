package br.com.totvs.clienttotvs.service;

        import br.com.totvs.clienttotvs.model.ClientResponse;

public interface ClientService {

    public ClientResponse.StandardResponse getList();

    public ClientResponse.StandardResponse getStatus(String cpf);

}
