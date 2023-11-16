package upc.edu.pe.ISA.Connect.inventory.services.impl;

import org.modelmapper.ModelMapper;
import upc.edu.pe.ISA.Connect.inventory.DTO.request.ProductRequestDto;
import upc.edu.pe.ISA.Connect.inventory.DTO.response.ProductResponseDto;
import upc.edu.pe.ISA.Connect.inventory.model.Products;
import upc.edu.pe.ISA.Connect.inventory.repository.ProductsRepository;
import upc.edu.pe.ISA.Connect.inventory.services.ProductService;
import upc.edu.pe.ISA.Connect.shared.exception.ResourceNotFoundException;

public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductsRepository productsRepository, ModelMapper modelMapper){
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto){
        var newProduct = modelMapper.map(productRequestDto, Products.class);
        return modelMapper.map(productsRepository.save(newProduct), ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto getProductById(Long id){
        Products products = productsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for ID: " + id));
        return modelMapper.map(products, ProductResponseDto.class);
    }
}
