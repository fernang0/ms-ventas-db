package cl.duoc.ms_ventas_db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_ventas_db.model.dto.PedidoDTO;
import cl.duoc.ms_ventas_db.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedido(@PathVariable("id") Long id){
        PedidoDTO pedidoDTO = pedidoService.findPedidoById(id);
        return (pedidoDTO != null)?  new ResponseEntity<>(pedidoDTO, HttpStatus.OK) :
                                     new ResponseEntity<>(HttpStatus.NOT_FOUND);     }
}
