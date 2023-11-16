package upc.edu.pe.ISA.Connect.monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.ISA.Connect.monitoring.model.Snapshots;

public interface SnapshotRepository extends JpaRepository<Snapshots, Long> {

    Boolean existsBySnapshotId(String snapshotId);

    Snapshots findBySnapshotId(String snapshotId);
}
