package com.devweb.delivery.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PedidoInputDTO {
    
    @NotBlank
    private String cli_uuid;

    private List<PedidoItemInputDTO> pedidoItem;
}
