package de.keeyzar.checkimdb.imdbclone.services;

import de.keeyzar.checkimdb.imdbclone.errors.UserAlreadyExistsException;
import de.keeyzar.checkimdb.imdbclone.model.User;
import de.keeyzar.checkimdb.imdbclone.model.UserDTO;
import de.keeyzar.checkimdb.imdbclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserRegisterService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    public void register(UserDTO userDTO) throws UserAlreadyExistsException {

        //Let's check if user already registered with us
        if(checkIfUserExist(userDTO.getUsername())){
            throw new UserAlreadyExistsException("User already exists for this email");
        }
        User user = User.builder()
                .username(userDTO.getUsername())
                .password(encodePassword(userDTO.getPassword()))
                .build();

        userRepository.save(user);
    }

    public boolean checkIfUserExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
