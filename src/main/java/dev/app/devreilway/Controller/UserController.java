package dev.app.devreilway.Controller;

import dev.app.devreilway.model.User;
import dev.app.devreilway.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/Users")
public class UserController {
    private  final UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return  ResponseEntity.ok(user);
    }
    @PostMapping("/create")
    public  ResponseEntity<User> create(@RequestBody  User user){
        var userCreate = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(userCreate.getId())
                .toUri();
        return  ResponseEntity.created(location).body(user);
    }
}
