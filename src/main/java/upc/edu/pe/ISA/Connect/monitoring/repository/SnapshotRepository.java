package upc.edu.pe.ISA.Connect.monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.ISA.Connect.inventory.model.Products;
import upc.edu.pe.ISA.Connect.monitoring.model.Snapshots;

import java.util.List;

public interface SnapshotRepository extends JpaRepository<Snapshots, Long> {

    Boolean existsBySnapshotId(String snapshotId);

    List<Snapshots> findByProductId(Long productId);
}
