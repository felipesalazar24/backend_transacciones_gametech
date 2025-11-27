package gamtetech.transacciones.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gamtetech.transacciones.DTO.PedidoRequestDTO;
import gamtetech.transacciones.DTO.PedidoResponseDTO;
import gamtetech.transacciones.Service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor

public class PedidoController {
    
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> crearPedido(@Valid @RequestBody PedidoRequestDTO request){
        PedidoResponseDTO respuesta = pedidoService.crearPedido(request);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> obtemerPorId(@PathVariable ("id")int id) {
        PedidoResponseDTO pedido = pedidoService.obtenerPedidoPorId(id);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listarTodos() {
        List<PedidoResponseDTO> pedidos = pedidoService.listarTodos();
        return ResponseEntity.ok(pedidos);
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<PedidoResponseDTO>> listarPorUsuario(
            @PathVariable("usuarioId") int usuarioId) {

        List<PedidoResponseDTO> pedidos = pedidoService.listarPedidosPorUsuario(usuarioId);
        return ResponseEntity.ok(pedidos);
    }
    
}
