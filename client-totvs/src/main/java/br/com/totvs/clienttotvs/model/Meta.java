package br.com.totvs.clienttotvs.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meta implements Serializable {

    @ApiModelProperty(position = 0, example = "1", dataType = "integer", notes = "Total de registros encontrados")
    private int totalRecords;

    @ApiModelProperty(position = 1, example = "1", dataType = "integer", notes = "Total de paginas para os registros encontrados")
    private int totalPages;

    @ApiModelProperty(position = 2, example = "2021-05-21T08:30:00Z", dataType = "String", notes = "Data e hora da consulta, conforme especificação RFC-3339, formato UTC.")
    private String requestDateTime;

    @Override
    public String toString() {
        return "Meta{ " +
                "totalRecords=" + totalRecords +
                ", totalPages=" + totalPages +
                ", requestDateTime='" + requestDateTime + '\'' +
                '}';
    }
}
