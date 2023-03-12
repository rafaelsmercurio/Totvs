package br.com.totvs.clienttotvs.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ClientResponse implements Serializable {

    @ApiModelProperty(position = 0, name = "Lista de clientes")
    private List<ClientUsers> data;

    private Meta meta;

    public static class StandardResponse {


        private ClientResponse data;

        public StandardResponse(ClientResponse data) {
            this.data = data;
        }

        @JsonProperty("data")
        public List<ClientUsers> getData() {
            return data.getData();
        }

        @JsonProperty("meta")
        public Meta getMeta() {
            return this.data.getMeta();
        }
    }
}
