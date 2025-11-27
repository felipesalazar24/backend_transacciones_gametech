package gamtetech.transacciones.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import gamtetech.transacciones.Model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByUsuarioId(int usuarioId);
}
