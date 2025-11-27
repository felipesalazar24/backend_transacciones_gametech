package gamtetech.transacciones.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gamtetech.transacciones.DTO.DetallePedidoRequestDTO;
import gamtetech.transacciones.DTO.PedidoRequestDTO;
import gamtetech.transacciones.DTO.PedidoResponseDTO;
import gamtetech.transacciones.Model.DetallePedido;
import gamtetech.transacciones.Model.Pedido;
import gamtetech.transacciones.Repository.PedidoRepository;
import gamtetech.transacciones.Service.PedidoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO crearPedido(PedidoRequestDTO request) {
        Pedido pedido = Pedido.builder()
                .direccion(request.getDireccion())
                .fecha(LocalDate.now())
                .usuarioId(request.getUsuarioId())
                .build();

        double total = 0.0;

        for (DetallePedidoRequestDTO d : request.getDetalles()) {
            double subtotal = d.getCantidad() * d.getPrecioUnitario();

            DetallePedido detalle = DetallePedido.builder()
                    .pedido(pedido)
                    .productoId(d.getProductoId())
                    .cantidad(d.getCantidad())
                    .precioUnitario(d.getPrecioUnitario())
                    .subtotal(subtotal)
                    .build();

            pedido.getDetalles().add(detalle);
            total += subtotal;
        }

        pedido.setTotal(total);

        Pedido guardado = pedidoRepository.save(pedido);
        return PedidoResponseDTO.fromEntity(guardado);
    }

    @Override
    public PedidoResponseDTO obtenerPedidoPorId(int id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        return PedidoResponseDTO.fromEntity(pedido);
    }

    @Override
    public List<PedidoResponseDTO> listarTodos() {
        return pedidoRepository.findAll().stream()
                .map(PedidoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDTO> listarPedidosPorUsuario(int usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId).stream()
                .map(PedidoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
