package upc.edu.pe.ISA.Connect.monitoring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.ISA.Connect.monitoring.dto.request.SnapshotRequestDto;
import upc.edu.pe.ISA.Connect.monitoring.dto.response.SnapshotResponseDto;
import upc.edu.pe.ISA.Connect.monitoring.services.SnapshotService;

import java.util.List;

@Tag(name = "Snapshots Controller", description = "Controller to manage snapshots")
@RestController
@RequestMapping("/api/v1/products")
public class SnapshotsController {

    private final SnapshotService snapshotService;
    public SnapshotsController(SnapshotService snapshotService) {
        this.snapshotService = snapshotService;
    }

    //create
    @PostMapping("/{productId}/snapshots")
    public ResponseEntity<SnapshotResponseDto> createSnapshot(@PathVariable Long productId, @RequestBody SnapshotRequestDto snapshotRequestDto){
        var res = snapshotService.createSnapshot(productId,snapshotRequestDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}/snapshots")
    public ResponseEntity<List<SnapshotResponseDto>> getSnapshotsByProductId(@PathVariable Long productId){
        return new ResponseEntity<>(snapshotService.getSnapshotsByProductId(productId), HttpStatus.OK);
    }

}
