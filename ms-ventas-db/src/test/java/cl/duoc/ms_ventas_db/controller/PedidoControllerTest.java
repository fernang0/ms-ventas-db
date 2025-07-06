package cl.duoc.ms_ventas_db.controller;

import cl.duoc.ms_ventas_db.model.dto.PedidoDTO;
import cl.duoc.ms_ventas_db.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class PedidoControllerTest {

    @InjectMocks
    PedidoController pedidoController;

    @Mock
    PedidoService pedidoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerPedidoExistenteTest() {
        Long idPedido = 1001L;
        PedidoDTO pedidoMock = new PedidoDTO();
        pedidoMock.setId(idPedido);
        pedidoMock.setClienteId(3L); // corregido
        pedidoMock.setTotal(new BigDecimal("50000.00")); // corregido

        when(pedidoService.findPedidoById(idPedido)).thenReturn(pedidoMock);

        ResponseEntity<PedidoDTO> response = pedidoController.obtenerPedido(idPedido);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(idPedido);
        assertThat(response.getBody().getClienteId()).isEqualTo(3L);
        assertThat(response.getBody().getTotal()).isEqualByComparingTo("50000.00");
    }

    @Test
    void obtenerPedidoInexistenteTest() {
        Long idPedido = 9999L;

        when(pedidoService.findPedidoById(idPedido)).thenReturn(null);

        ResponseEntity<PedidoDTO> response = pedidoController.obtenerPedido(idPedido);

        assertThat(response.getStatusCodeValue()).isEqualTo(404);
        assertThat(response.getBody()).isNull();
    }
}
