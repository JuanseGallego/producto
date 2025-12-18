package co.com.juansegallego.producto.service;

import co.com.juansegallego.producto.model.CategoriaDto;
import co.com.juansegallego.producto.model.entity.CategoriaEntity;

import java.util.List;

public interface ICategoriaService {

    CategoriaEntity create(CategoriaDto categoria);

    CategoriaEntity update(Integer idCategoria, CategoriaDto categoria);

    void delete(Integer idCategoria);

    List<CategoriaEntity> findAll();

}
