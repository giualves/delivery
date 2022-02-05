package com.devweb.delivery.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PedidoResumoDTO {
    private String uuid;
    private ClienteDTO cliente;
    private PedidoItemDTO pedidoItem;
    private BigDecimal total;
    
}
