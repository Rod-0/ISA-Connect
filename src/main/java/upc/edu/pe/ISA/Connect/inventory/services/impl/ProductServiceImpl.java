package upc.edu.pe.ISA.Connect.inventory.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import upc.edu.pe.ISA.Connect.inventory.dto.request.ProductRequestDto;
import upc.edu.pe.ISA.Connect.inventory.dto.response.ProductResponseDto;
import upc.edu.pe.ISA.Connect.inventory.model.Products;
import upc.edu.pe.ISA.Connect.inventory.repository.ProductsRepository;
import upc.edu.pe.ISA.Connect.inventory.services.ProductService;
import upc.edu.pe.ISA.Connect.shared.exception.ResourceNotFoundException;

@Service
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
        // validate if product exists
        if(!productsRepository.existsById(id))
            throw new ResourceNotFoundException("Product not found for ID: " + id);

        var products = productsRepository.findById(id);
        return modelMapper.map(products, ProductResponseDto.class);
    }
}
