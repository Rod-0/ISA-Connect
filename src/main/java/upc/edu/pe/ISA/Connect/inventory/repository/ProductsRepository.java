package upc.edu.pe.ISA.Connect.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.ISA.Connect.inventory.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    Boolean existsByCode(String code);

    Products findByCode(String code);

    Boolean existsBySerialNumber(String serialNumber);

    Products findBySerialNumber(String serialNumber);


}
