package co.com.juansegallego.producto.feign;

import co.com.juansegallego.producto.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Posts", url = "${post.baseUrl}")
public interface IPostRest {

    @GetMapping(value = "/posts")
    List<Post> getPosts();

    @GetMapping(value = "/posts/{id}")
    Post getPost(@PathVariable Integer id);

}
