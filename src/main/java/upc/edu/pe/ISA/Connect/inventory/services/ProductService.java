package upc.edu.pe.ISA.Connect.inventory.services;

import upc.edu.pe.ISA.Connect.inventory.dto.request.ProductRequestDto;
import upc.edu.pe.ISA.Connect.inventory.dto.response.ProductResponseDto;

public interface ProductService {

    public abstract ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    public abstract ProductResponseDto getProductById(Long id);

}
