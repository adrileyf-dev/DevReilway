package dev.app.devreilway.Controller;

import dev.app.devreilway.Repository.UserRepository;
import dev.app.devreilway.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
   public  final UserRepository userRepository;
    @PostMapping("/create")
      public User save(@RequestBody User user){
       userRepository.save(user);
       return  user;
    }
    @GetMapping("/all")
       public List<User> list(){
       return  userRepository.findAll();
    }
}
