package br.com.totvs.clienttotvs.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "ErrorDetails", description = "Informações detalhadas dos erros ocorridos.")
@JsonPropertyOrder({"uniqueId, informationCode, message, field, args"})
public class Errors implements Serializable {
    @ApiModelProperty(position = 1, example = "String")
    @JsonProperty("code")
    private String code;

    @ApiModelProperty(position = 2, example = "String")
    @JsonProperty("title")
    private String title;

    @ApiModelProperty(position = 3, example = "String")
    @JsonProperty("detail")
    private String detail;

    @Override
    public String toString() {
        return "Errors{" +
                "code=" + code +
                ", title =" + title +
                ", detail =" + detail + '}';
    }
}
