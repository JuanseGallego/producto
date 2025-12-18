package co.com.juansegallego.producto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
