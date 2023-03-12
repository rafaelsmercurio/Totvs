package br.com.totvs.clienttotvs.errors;

import br.com.totvs.clienttotvs.model.Meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ResponseError", description = "Modelo de resposta do erro")
@JsonPropertyOrder({"errors", "meta"})
public class ResponseError implements Serializable {

    @ApiModelProperty(position = 0)
    @JsonProperty("errors")
    private List<Errors> errors;

    @ApiModelProperty(position = 1)
    @JsonProperty("meta")
    private Meta meta;

    public String toString() {
        return "ResponseError{" +
                "error=" + errors +
                ", meta=" + meta +
                '}';
    }

}
