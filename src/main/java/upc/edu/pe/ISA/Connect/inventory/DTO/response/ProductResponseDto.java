package upc.edu.pe.ISA.Connect.inventory.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import upc.edu.pe.ISA.Connect.inventory.model.EMonitoringLevel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;
    private String brand;
    private String model;
    private String serialNumber;
    private EMonitoringLevel monitoringLevel;
}
