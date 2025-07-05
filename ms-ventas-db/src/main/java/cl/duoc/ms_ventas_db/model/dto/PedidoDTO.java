package cl.duoc.ms_ventas_db.model.dto;


import java.math.BigDecimal;
import java.util.List;
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

@Schema(description = "DTO que representa un pedido realizado por un cliente, incluyendo sus detalles y descuentos aplicados.")
public class PedidoDTO {

    @Schema(description = "Identificador único del pedido", example = "1001")
    @JsonProperty("id_pedido")
    private Long id;

    @Schema(description = "ID del cliente que realizó el pedido", example = "45")
    @JsonProperty("cliente_id")
    private Long clienteId;

    @Schema(description = "Fecha en que se realizó el pedido, en formato yyyy-MM-dd", example = "2025-07-05")
    @JsonProperty("fecha")
    private String fecha;

    @Schema(description = "Estado actual del pedido", example = "PENDIENTE")
    @JsonProperty("estado")
    private String estado;

    @Schema(description = "Monto total del pedido antes de aplicar descuentos", example = "12990.50")
    @JsonProperty("total")
    private BigDecimal total;

    @Schema(description = "ID del descuento aplicado al pedido, si corresponde", example = "2", nullable = true)
    @JsonProperty("descuento_id")
    private Integer descuentoId;

    @Schema(description = "Lista de detalles del pedido, que incluye productos, cantidades y subtotales")
    @JsonProperty("detalles")
    private List<DetallePedidoDTO> detalles;
}
