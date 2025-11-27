package gamtetech.transacciones.DTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import gamtetech.transacciones.Model.Pedido;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PedidoResponseDTO {
    
    private int id;
    private String direccion;
    private LocalDate fecha;
    private int usuarioId;
    private double total;
    private List<DetallePedidoResponseDTO> detalles;

    public static PedidoResponseDTO fromEntity(Pedido pedido) {
        return PedidoResponseDTO.builder()
                .id(pedido.getId())
                .direccion(pedido.getDireccion())
                .fecha(pedido.getFecha())
                .usuarioId(pedido.getUsuarioId())
                .total(pedido.getTotal())
                .detalles(
                        pedido.getDetalles().stream()
                                .map(DetallePedidoResponseDTO::fromEntity)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
