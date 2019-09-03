package ftn.XMLWSiBezbednost.service;

import ftn.XMLWSiBezbednost.dto.TwoStrings;
import ftn.XMLWSiBezbednost.exception.ActionNotPossibleException;
import ftn.XMLWSiBezbednost.exception.EntityNotFoundException;
import ftn.XMLWSiBezbednost.exception.NotPermittedException;
import ftn.XMLWSiBezbednost.utils.data.User;

public interface UserService {

    User findByEmail(String email) throws EntityNotFoundException;

    void changePassword(User loggedInUser, TwoStrings twoStrings) throws NotPermittedException, ActionNotPossibleException;

    String generateSalt();

    boolean checkPassword(User user, String sentPassword);

    String hashPassword(String password, String salt);

}