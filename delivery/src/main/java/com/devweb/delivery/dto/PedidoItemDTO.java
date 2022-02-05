package com.devweb.delivery.dto;

import lombok.Data;

@Data
public class PedidoItemDTO {

    private ProdutoResumoDTO produto;
    private Integer quantidade;
    
}
