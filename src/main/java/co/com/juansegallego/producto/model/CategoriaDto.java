package co.com.juansegallego.producto.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, message = "El nombre debe tener más de 2 caracteres")
    private String nombre;

    @NotBlank(message = "La descripcion no puede estar vacia")
    @Size(min = 10, message = "La descripción debe tener más de 10 caracteres")
    private String descripcion;
}
