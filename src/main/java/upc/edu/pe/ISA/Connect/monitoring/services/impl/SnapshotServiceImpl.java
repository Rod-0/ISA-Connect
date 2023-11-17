package upc.edu.pe.ISA.Connect.monitoring.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import upc.edu.pe.ISA.Connect.inventory.model.EMonitoringLevel;
import upc.edu.pe.ISA.Connect.inventory.model.Products;
import upc.edu.pe.ISA.Connect.inventory.repository.ProductsRepository;
import upc.edu.pe.ISA.Connect.monitoring.dto.request.SnapshotRequestDto;
import upc.edu.pe.ISA.Connect.monitoring.dto.response.SnapshotResponseDto;
import upc.edu.pe.ISA.Connect.monitoring.repository.SnapshotRepository;
import upc.edu.pe.ISA.Connect.monitoring.services.SnapshotService;
import upc.edu.pe.ISA.Connect.monitoring.model.Snapshots;
import upc.edu.pe.ISA.Connect.shared.exception.ResourceNotFoundException;
import upc.edu.pe.ISA.Connect.shared.exception.ValidationException;

import java.util.List;
@Service
public class SnapshotServiceImpl implements SnapshotService {

        private final SnapshotRepository snapshotRepository;
        private final ProductsRepository productsRepository;
        private final ModelMapper modelMapper;

        public SnapshotServiceImpl(SnapshotRepository snapshotRepository, ModelMapper modelMapper, ProductsRepository productsRepository){
            this.snapshotRepository = snapshotRepository;
            this.productsRepository = productsRepository;
            this.modelMapper = modelMapper;
        }


        @Override
        public SnapshotResponseDto createSnapshot(Long productId,SnapshotRequestDto snapshotRequestDto) {
            // validate if snapshot id already exists
            if(snapshotRepository.existsBySnapshotId(snapshotRequestDto.getSnapshotId())){
                throw new ResourceNotFoundException("Snapshot already exists");
            }
            // validate if product exists
            var product = productsRepository.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found for ID: " + productId));

            // validate snapshot
            validateSnapshot(product,snapshotRequestDto);

            var newSnapshot = modelMapper.map(snapshotRequestDto, Snapshots.class);
            return modelMapper.map(snapshotRepository.save(newSnapshot), SnapshotResponseDto.class);
        }

        @Override
        public List<SnapshotResponseDto> getSnapshotsByProductId(Long id) {
            // validate if product exists
            var product = productsRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found for ID: " + id));

            List<Snapshots> snapshots = snapshotRepository.findByProductId(id);

            return snapshots.stream()
                    .map(snapshot -> modelMapper.map(snapshot, SnapshotResponseDto.class))
                    .toList();
        }

        private void validateSnapshot (Products product, SnapshotRequestDto snapshotRequestDto){
            if(snapshotRequestDto.getSnapshotId() == null || snapshotRequestDto.getSnapshotId().isEmpty()){
                throw new ValidationException("SnapshotId is required");
            }
            if(snapshotRequestDto.getTemperature() == 0 ) {
                throw new ValidationException("Temperature is required");
            }
            if(product.getMonitoringLevel() == EMonitoringLevel.ADVANCE_MONITORING){
                if(snapshotRequestDto.getEnergy() == 0){
                    throw new ValidationException("Energy is required");
                }
                if(snapshotRequestDto.getLeakage() != 0 && snapshotRequestDto.getLeakage() != 1){
                    throw new ValidationException("Leakage is required");
                }
            }
        }

}
