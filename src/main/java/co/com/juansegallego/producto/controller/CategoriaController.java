package co.com.juansegallego.producto.controller;

import co.com.juansegallego.producto.model.CategoriaDto;
import co.com.juansegallego.producto.model.entity.CategoriaEntity;
import co.com.juansegallego.producto.service.ICategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias", description = "API para gestión de categorias")
@SecurityRequirement(name = "token")
public class CategoriaController {

    @Autowired
    private ICategoriaService iCategoriaService;

    @PostMapping
    @Operation(summary = "Crear una categoria", description = "Metodo para crear una categoria")
    public CategoriaEntity create(@Valid @RequestBody CategoriaDto categoriaDto) {
        return iCategoriaService.create(categoriaDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una categoria", description = "Metodo para actualizar una categoria")
    public CategoriaEntity update(@PathVariable("id") Integer idCategoria, @Valid @RequestBody CategoriaDto categoriaDto) {
        return iCategoriaService.update(idCategoria, categoriaDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una categoria", description = "Metodo para eliminar una categoria")
    public void delete(@PathVariable("id") Integer idCategoria) {
        iCategoriaService.delete(idCategoria);
    }

    @GetMapping
    @Operation(summary = "Extraer categorias", description = "Metodo para extraer todas las categorias")
    public List<CategoriaEntity> findAll() {
        return iCategoriaService.findAll();
    }
}
