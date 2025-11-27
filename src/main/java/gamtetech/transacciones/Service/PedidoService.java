package gamtetech.transacciones.Service;

import java.util.List;
import gamtetech.transacciones.DTO.PedidoRequestDTO;
import gamtetech.transacciones.DTO.PedidoResponseDTO;

public interface PedidoService {
    
    PedidoResponseDTO crearPedido(PedidoRequestDTO request);

    PedidoResponseDTO obtenerPedidoPorId(int id);

    List<PedidoResponseDTO> listarPedidosPorUsuario(int usuarioId);
    
    List<PedidoResponseDTO>listarTodos();
    
}
