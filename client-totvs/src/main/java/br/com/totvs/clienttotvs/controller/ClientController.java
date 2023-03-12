package br.com.totvs.clienttotvs.controller;

import br.com.totvs.clienttotvs.errors.ResponseError;
import br.com.totvs.clienttotvs.model.ClientResponse;
import br.com.totvs.clienttotvs.service.ClientService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/")
@Api(tags = "Totvs")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("client")
    @ApiOperation(value = "Consulta todos os clientes")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ClientResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ResponseError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Not found", response = ResponseError.class),
            @ApiResponse(code = 422, message = "Unprocessable Entity", response = ResponseError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = ResponseError.class),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "x-transaction-id", value = "UUID da transação", paramType = "header", type = "String", required = true)
    })
    public @ResponseBody
    ResponseEntity<ClientResponse.StandardResponse> getUsersList() {

        return ResponseEntity.status(HttpStatus.OK).body(clientService.getList());
    }

    @GetMapping("client/status")
    @ApiOperation(value = "Consulta todos os clientes")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ClientResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ResponseError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Not found", response = ResponseError.class),
            @ApiResponse(code = 422, message = "Unprocessable Entity", response = ResponseError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ResponseError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = ResponseError.class),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "x-transaction-id", value = "UUID da transação", paramType = "header", type = "String", required = true)
    })
    public @ResponseBody
    ResponseEntity<ClientResponse.StandardResponse> getUserStatus(@ApiParam(value = "Cpf do client", type = "String")
                                                                  @RequestHeader(value = "Numero do cpf do usuário", required = true) String cpf) throws IOException {

        return ResponseEntity.status(HttpStatus.OK).body(clientService.getStatus(cpf));
    }
}
