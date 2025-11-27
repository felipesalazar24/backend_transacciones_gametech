package gamtetech.transacciones.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import gamtetech.transacciones.Model.DetallePedido;

public interface DetallePedidoRepository  extends JpaRepository<DetallePedido, Integer>{
    List<DetallePedido> findByPedidoId(int pedidoId);
}