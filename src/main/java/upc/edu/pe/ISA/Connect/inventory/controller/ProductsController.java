package upc.edu.pe.ISA.Connect.inventory.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upc.edu.pe.ISA.Connect.inventory.services.ProductService;

@Tag(name = "Products Controller", description = "Controller to manage products")
@RestController
@RequestMapping("/api/v1")
public class ProductsController {


}
