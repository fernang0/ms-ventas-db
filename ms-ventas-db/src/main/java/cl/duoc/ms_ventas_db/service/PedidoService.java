package cl.duoc.ms_ventas_db.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.ms_ventas_db.model.dto.DetallePedidoDTO;
import cl.duoc.ms_ventas_db.model.dto.PedidoDTO;
import cl.duoc.ms_ventas_db.model.entities.DetallePedido;
import cl.duoc.ms_ventas_db.model.entities.Pedido;
import cl.duoc.ms_ventas_db.model.repository.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoDTO findPedidoById(Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        PedidoDTO pedidoDTO = null;
        if(pedido.isPresent()){
            pedidoDTO = translateEntityToDto(pedido.get());
        }
        return pedidoDTO;
    }
    public Pedido translateDtoToEntity(PedidoDTO pedidoDTO){
        Pedido pedido = null;

        return pedido;

    }
    public PedidoDTO translateEntityToDto(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setClienteId(pedido.getClienteId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pedidoDTO.setFecha(format.format(pedido.getFecha()));
        pedidoDTO.setEstado(pedido.getEstado().toString());
        pedidoDTO.setTotal(pedido.getTotal());
        pedidoDTO.setDescuentoId(pedido.getDescuentoId());
        //pedidoDTO tiene lista de detalles con detallepedidoDTO
        //pedido tiene lista de detalles con detallepedido solamente
        //Hay que hacer un conversor con un for de detallepedido a detallepedido dto, con listas
        pedidoDTO.setDetalles(translateListEntityToDtoDetalle(pedido.getDetalles()));
        return pedidoDTO;
    }
    public List<DetallePedidoDTO> translateListEntityToDtoDetalle(List<DetallePedido> detalles) {
        List<DetallePedidoDTO> lista = new ArrayList<>();
        for (DetallePedido detalle : detalles) {
            DetallePedidoDTO dto = new DetallePedidoDTO();
            dto.setId(detalle.getId());
            dto.setPedidoId(detalle.getPedido().getId());
            dto.setProductoId(detalle.getProductoId());
            dto.setCantidad(detalle.getCantidad());
            dto.setPrecioUnitario(detalle.getPrecioUnitario());
            lista.add(dto);
        }
        return lista;
    }
}
