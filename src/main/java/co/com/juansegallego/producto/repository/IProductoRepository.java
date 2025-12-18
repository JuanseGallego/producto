package co.com.juansegallego.producto.repository;

import co.com.juansegallego.producto.model.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, Integer> {
}
