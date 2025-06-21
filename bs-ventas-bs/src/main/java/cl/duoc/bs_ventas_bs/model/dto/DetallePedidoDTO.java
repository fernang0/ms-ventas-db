package cl.duoc.bs_ventas_bs.model.dto;

import java.math.BigDecimal;
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

    private Long id;

    private PedidoDTO pedidoId;

    private ProductoDTO productoId;

    private Integer cantidad;

    private BigDecimal precioUnitario;
}
