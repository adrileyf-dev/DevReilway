package dev.app.devreilway.service.imple;
import dev.app.devreilway.Repository.UserRepository;
import dev.app.devreilway.model.User;
import dev.app.devreilway.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

   private  final UserRepository userRepository;
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    @Override
    public User create(User create) {
        if(userRepository.existsByAccountNumber(create.getAccount().getNumber())){
           throw new IllegalArgumentException("this user id already exists!");
        }
        return userRepository.save(create);
    }
}
