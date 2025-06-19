package cl.duoc.ms_ventas_db.model.dto;


import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PedidoDTO {

    @JsonProperty("id_pedido")
    private Long id;

    @JsonProperty("cliente_id")
    private Long clienteId;

    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("total")
    private BigDecimal   total;

    @JsonProperty("descuento_id")
    private Integer descuentoId;

    @JsonProperty("detalles")
    private List<DetallePedidoDTO> detalles;


}
