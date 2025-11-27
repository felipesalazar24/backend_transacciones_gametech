package gamtetech.transacciones.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DetallePedidoRequestDTO {
    
    @NotNull
    private Integer productoId;

    @Min(1)
    private int cantidad;

    @Min(1)
    private double precioUnitario;
}
