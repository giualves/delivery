package com.devweb.delivery.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PedidoItemInputDTO {

    @NotBlank
    private String prodUuid;

    @NotBlank
    private Integer quantidade;
    
}
