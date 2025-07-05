package cl.duoc.ms_ventas_db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.ms_ventas_db.model.dto.PedidoDTO;
import cl.duoc.ms_ventas_db.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Operation(
        summary = "Obtener un pedido por ID",
        description = "Retorna el pedido completo con sus detalles si existe el ID proporcionado."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Pedido no encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedido(
        @Parameter(description = "ID del pedido a consultar", example = "1001")
        @PathVariable("id") Long id
    ) {
        PedidoDTO pedidoDTO = pedidoService.findPedidoById(id);
        return (pedidoDTO != null) ?
            new ResponseEntity<>(pedidoDTO, HttpStatus.OK) :
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(
        summary = "Crear un nuevo pedido",
        description = "Registra un nuevo pedido con sus detalles asociados."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pedido creado exitosamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<PedidoDTO> createPedido(
        @Parameter(description = "DTO del pedido a registrar", required = true)
        @RequestBody PedidoDTO pedidoDTO
    ) {
        PedidoDTO newPedidoDTO = pedidoService.createPedido(pedidoDTO);

        if (newPedidoDTO != null) {
            return new ResponseEntity<>(newPedidoDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
