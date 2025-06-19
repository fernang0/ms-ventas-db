package cl.duoc.ms_ventas_db.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.ms_ventas_db.model.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
