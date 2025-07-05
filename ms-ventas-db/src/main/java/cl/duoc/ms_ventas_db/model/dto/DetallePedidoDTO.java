package cl.duoc.ms_ventas_db.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

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
@Schema(description = "DTO que representa un detalle específico de un pedido, incluyendo el producto, cantidad y precio unitario.")
public class DetallePedidoDTO {

    @Schema(description = "Identificador único del detalle de pedido", example = "1")
    @JsonProperty("id")
    private Long id;

    @Schema(description = "ID del pedido al que pertenece este detalle", example = "1001")
    @JsonProperty("pedido_id")
    private Long pedidoId;

    @Schema(description = "ID del producto incluido en este detalle", example = "501")
    @JsonProperty("producto_id")
    private Long productoId;

    @Schema(description = "Cantidad solicitada del producto", example = "3")
    @JsonProperty("cantidad")
    private Integer cantidad;

    @Schema(description = "Precio unitario del producto al momento del pedido", example = "2990.00")
    @JsonProperty("precio_unitario")
    private BigDecimal precioUnitario;
}
