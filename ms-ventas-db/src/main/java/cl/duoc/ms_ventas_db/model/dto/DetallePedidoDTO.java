package cl.duoc.ms_ventas_db.model.dto;

import java.math.BigDecimal;

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

public class DetallePedidoDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("pedido_id")
    private Long pedidoId;

    @JsonProperty("producto_id")
    private Long productoId;

    @JsonProperty("cantidad")
    private Integer cantidad;

    @JsonProperty("precio_unitario")
    private BigDecimal precioUnitario;
}
