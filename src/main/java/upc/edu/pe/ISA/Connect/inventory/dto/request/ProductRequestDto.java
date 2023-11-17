package upc.edu.pe.ISA.Connect.inventory.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import upc.edu.pe.ISA.Connect.inventory.model.EMonitoringLevel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    private String brand;
    private String model;
    private String serialNumber;
    private EMonitoringLevel monitoringLevel;

}
