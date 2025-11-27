package gamtetech.transacciones.DTO;


import gamtetech.transacciones.Model.DetallePedido;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetallePedidoResponseDTO {
    
    private int id;
    private int productoId;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public static DetallePedidoResponseDTO fromEntity(DetallePedido d) {
        return DetallePedidoResponseDTO.builder()
                .id(d.getId())
                .productoId(d.getProductoId())
                .cantidad(d.getCantidad())
                .precioUnitario(d.getPrecioUnitario())
                .subtotal(d.getSubtotal())
                .build();
    }
}
