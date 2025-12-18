package co.com.juansegallego.producto.service;

import co.com.juansegallego.producto.model.CategoriaDto;
import co.com.juansegallego.producto.model.entity.CategoriaEntity;
import co.com.juansegallego.producto.repository.ICategoriaRepository;
import co.com.juansegallego.producto.shared.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    private ICategoriaRepository iCategoriaRepository;

    @Override
    public CategoriaEntity create(CategoriaDto categoria) {
        CategoriaEntity entity = createEntity(categoria);
        return iCategoriaRepository.save(entity);
    }

    @Override
    public CategoriaEntity update(Integer idCategoria, CategoriaDto categoria) {
        iCategoriaRepository.findById(idCategoria).orElseThrow( () ->
                new CustomException("La categoria con id " + idCategoria + " no existe.", new Date()));
        CategoriaEntity cat = createEntity(categoria);
        cat.setId(idCategoria);
        return iCategoriaRepository.save(cat);
    }

    @Override
    public void delete(Integer idCategoria) {
        iCategoriaRepository.findById(idCategoria).orElseThrow( () ->
                new CustomException("La categoria con id " + idCategoria + " no existe.", new Date()));
        iCategoriaRepository.deleteById(idCategoria);
    }

    @Override
    public List<CategoriaEntity> findAll() {
        return iCategoriaRepository.findAll();
    }

    //Metodo auxiliar
    public CategoriaEntity createEntity(CategoriaDto categoria) {
        CategoriaEntity cat = new CategoriaEntity();
        cat.setNombre(categoria.getNombre());
        cat.setDescripcion(categoria.getDescripcion());
        return cat;
    }
}
