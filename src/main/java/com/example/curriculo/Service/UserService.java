package com.example.curriculo.Service;

import com.example.curriculo.Model.User;
import com.example.curriculo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
 private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public User criarUser(User user) {
        return userRepository.save(user);
    }


    public User atualizarUser(Long id, User userDetails) throws Exception {
        Optional<User> User = userRepository.findById(id);

        if (User.isPresent()) {
            User user = User.get();

            user.setNome(userDetails.getNome());
           user.setEmail(userDetails.getEmail());
           user.setIdade(userDetails.getIdade());
           user.setTelefone(userDetails.getTelefone());
            return userRepository.save(user);
        }
        else {
            throw new Exception("Usuário não encontrado com o id: " + id);
        }
    }

    public void deletarUser(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
        }
    }

}

