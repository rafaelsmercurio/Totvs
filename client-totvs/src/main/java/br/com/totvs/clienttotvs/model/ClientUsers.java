package br.com.totvs.clienttotvs.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
public class ClientUsers {

    @ApiModelProperty(value = "Nome do cliente", example = "Boromir")
    private String name;

    @ApiModelProperty(value = "E-mail do cliente", example = "boromir@totvs.com.br")
    private String mail;

    @ApiModelProperty(value = "CPF do cliente", example = "92871682020")
    private String documentNumber;

    @ApiModelProperty(value = "Status da importação", example = "Entregue")
    private String status;

}
