package com.devweb.delivery.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class PedidoDTO {

    private String uuid;

    private RestauranteDTO restaurante;

    private ClienteDTO cliente;

    private UsuarioDTO usuario;

    List<PedidoItemDTO> pedidoItem;
    

    private BigDecimal total;

}
