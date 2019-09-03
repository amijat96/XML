package ftn.XMLWSiBezbednost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.beans.Client;
import app.util.BeanToDTOConverter;
import ftn.XMLWSiBezbednost.dto.LoginUserDTO;
import ftn.XMLWSiBezbednost.dto.TwoStrings;
import ftn.XMLWSiBezbednost.dto.UserDTO;
import ftn.XMLWSiBezbednost.exception.ActionNotPossibleException;
import ftn.XMLWSiBezbednost.exception.EntityAlreadyExistsException;
import ftn.XMLWSiBezbednost.exception.EntityNotFoundException;
import ftn.XMLWSiBezbednost.exception.NotPermittedException;
import ftn.XMLWSiBezbednost.service.ClientService;
import ftn.XMLWSiBezbednost.service.UserService;
import ftn.XMLWSiBezbednost.utils.data.User;
import ftn.XMLWSiBezbednost.utils.data.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientService clientService;
    

    // -------------------------------------

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> login(@RequestBody LoginUserDTO loginUser) throws EntityNotFoundException{
        User user = userService.findByEmail(loginUser.getUsername());
        if (user != null && userService.checkPassword(user, loginUser.getPassword())){
            System.out.println("here");
            securityService.autologin(user.getEmail(), user.getPassword());
            return new ResponseEntity<>(BeanToDTOConverter.userToDTO(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    
    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getLoggedInUser(){
        User logged = securityService.getLoggedInUser();
        UserDTO dto = BeanToDTOConverter.userToDTO(logged);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> register(@RequestBody LoginUserDTO loginUser) throws EntityAlreadyExistsException {
        Client newClient = clientService.register(loginUser);
        securityService.autologin(newClient.getEmail(), newClient.getPassword());
        return new ResponseEntity<>(BeanToDTOConverter.userToDTO(newClient), HttpStatus.OK);
    }


    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
    public ResponseEntity changePassword(@RequestBody TwoStrings twoStrings) throws NotPermittedException, ActionNotPossibleException {
        User loggedInUser = securityService.getLoggedInUser();
        userService.changePassword(loggedInUser, twoStrings);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
