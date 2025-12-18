package co.com.juansegallego.producto.repository;

import co.com.juansegallego.producto.model.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
}
