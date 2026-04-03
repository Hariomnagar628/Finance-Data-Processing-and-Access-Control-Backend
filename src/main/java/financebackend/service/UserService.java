package financebackend.service;

import financebackend.model.User;
import financebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveuser(User user)
    {
        return  userRepository.save(user);

    }

    public List<User> getAllUsers()
    {

        return userRepository.findAll();
    }

}

