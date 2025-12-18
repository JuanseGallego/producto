package co.com.juansegallego.producto.controller;

import co.com.juansegallego.producto.model.ProductoDto;
import co.com.juansegallego.producto.model.entity.ProductoEntity;
import co.com.juansegallego.producto.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "API para gestión de productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "Extraer productos", description = "Metodo para extraer todos los productos")
    public List<ProductoEntity> findAll() {
        return productoService.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear un producto", description = "Metodo para crear un producto")
    public ProductoEntity createProduct(@Valid @RequestBody ProductoDto producto) {
        return productoService.create(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto", description = "Metodo para actualizar un producto")
    public ProductoEntity update(@PathVariable Integer id, @Valid @RequestBody ProductoDto producto) {
        return productoService.update(id, producto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Metodo para eliminar un producto")
    public void delete(@PathVariable Integer id) {
        productoService.delete(id);
    }
}
