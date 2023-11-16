package upc.edu.pe.ISA.Connect.monitoring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import upc.edu.pe.ISA.Connect.inventory.model.Products;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="snapshots")
public class Snapshots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="snapshot_id", nullable = false)
    private String snapshotId;

    @Column(name="temperature", nullable = false)
    private double temperature;

    @Column(name="energy", nullable = false)
    private double energy;

    @Column(name="leakage", nullable = false)
    private int leakage;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false, foreignKey = @ForeignKey(name="FK_product_id"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Products product;

}
