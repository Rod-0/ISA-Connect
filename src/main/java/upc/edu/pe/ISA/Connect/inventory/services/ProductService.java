package upc.edu.pe.ISA.Connect.inventory.services;

import upc.edu.pe.ISA.Connect.inventory.DTO.request.ProductRequestDto;
import upc.edu.pe.ISA.Connect.inventory.DTO.response.ProductResponseDto;

public interface ProductService {

    public abstract ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    public abstract ProductResponseDto getProductById(Long id);

}
