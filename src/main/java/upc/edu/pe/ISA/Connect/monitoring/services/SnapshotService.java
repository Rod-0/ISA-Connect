package upc.edu.pe.ISA.Connect.monitoring.services;

import upc.edu.pe.ISA.Connect.monitoring.DTO.request.SnapshotRequestDto;
import upc.edu.pe.ISA.Connect.monitoring.DTO.response.SnapshotResponseDto;

public interface SnapshotService {

    //create
    public abstract SnapshotResponseDto createSnapshot(SnapshotRequestDto snapshotRequestDto);

    //read
    public abstract SnapshotResponseDto getSnapshotByProductId(Long id);
}
