package cl.duoc.bs_ventas_bs.model.dto;



import java.math.BigDecimal;
import java.util.List;
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

    private Long id;

    private ClienteDTO clienteId;

    private String fecha;
 
    private String estado;

    private BigDecimal total;

    private Integer descuentoId;

    private List<DetallePedidoDTO> detalles;

}
