package com.example.store.BusinessLayer;

import com.example.store.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.store.Entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public User getSpecificUser(long id){
        if(this.repository.existsById(id)){
            Optional<User> user = this.repository.findById(id);
            User user1 = user.get();
            return user1;
        }else{
            return new User("DOES NOT EXIST","DOES NOT EXIST",LocalDate.of(0,1,1));
        }
    }

    public void addNewUser(User user){
        Optional<User> optionalUser = repository.findByFirstNameAndLastNameAndDateOfBirth(user.getFirstName(), user.getLastName(),user.getDateOfBirth());
        if(optionalUser.isPresent()){
            throw new IllegalStateException("This User already exists!!!");
        }else{
            repository.save(user);
        }
    }

    public void replaceUser(Long id, User user){
        Optional<User> optionalUser = repository.findByFirstNameAndLastNameAndDateOfBirth(user.getFirstName(), user.getLastName(),user.getDateOfBirth());
        if(optionalUser.isPresent()){
            throw new IllegalStateException("User credentials are the same!");
        }else{
            user.setId(id);
            repository.save(user);
        }

    }
}

