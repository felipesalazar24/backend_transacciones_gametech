package gamtetech.transacciones.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255 )
    private String direccion;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;

    @Column(nullable = false)
    private double total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<DetallePedido> detalles = new ArrayList<>();
}
