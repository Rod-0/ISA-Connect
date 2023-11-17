package upc.edu.pe.ISA.Connect.monitoring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SnapshotRequestDto {

    private String snapshotId;
    private double temperature;
    private double energy;
    private int leakage;
}
