package upc.edu.pe.ISA.Connect.monitoring.services;

import upc.edu.pe.ISA.Connect.monitoring.dto.request.SnapshotRequestDto;
import upc.edu.pe.ISA.Connect.monitoring.dto.response.SnapshotResponseDto;

import java.util.List;

public interface SnapshotService {

    //create
    public abstract SnapshotResponseDto createSnapshot(Long productId,SnapshotRequestDto snapshotRequestDto);

    //read
    public abstract List<SnapshotResponseDto> getSnapshotsByProductId(Long id);
}
