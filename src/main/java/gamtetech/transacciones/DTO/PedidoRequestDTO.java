package gamtetech.transacciones.DTO;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class PedidoRequestDTO {
    @NotBlank
    private String direccion;

    @NotNull
    private Integer usuarioId;

    @NotNull
    private List<DetallePedidoRequestDTO> detalles;
}
