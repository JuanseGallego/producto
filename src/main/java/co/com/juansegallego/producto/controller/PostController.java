package co.com.juansegallego.producto.controller;

import co.com.juansegallego.producto.feign.IPostRest;
import co.com.juansegallego.producto.model.Post;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostRest iPostRest;

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Integer id) {
        return iPostRest.getPost(id);
    }

    @GetMapping
    public List<Post> getPosts() {
        return iPostRest.getPosts();
    }
}
