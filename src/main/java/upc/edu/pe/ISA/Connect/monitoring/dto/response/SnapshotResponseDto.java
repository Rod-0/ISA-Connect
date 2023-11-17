package upc.edu.pe.ISA.Connect.monitoring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SnapshotResponseDto {
    private Long id;
    private String snapshotId;
    private String productId;
    private double temperature;
    private double energy;
    private int leakage;
}
