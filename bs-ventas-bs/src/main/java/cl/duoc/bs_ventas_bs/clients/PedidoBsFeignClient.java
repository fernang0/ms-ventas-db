package cl.duoc.bs_ventas_bs.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.duoc.bs_ventas_bs.model.dto.PedidoDTO;

@FeignClient(name = "ms-pedido-bd", url = "http://localhost:8080")
public interface PedidoBsFeignClient {

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<PedidoDTO> findPedidoById(@PathVariable("id") Long id);

}
