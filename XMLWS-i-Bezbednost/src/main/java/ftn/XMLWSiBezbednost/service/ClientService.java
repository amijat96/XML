package ftn.XMLWSiBezbednost.service;

import ftn.XMLWSiBezbednost.dto.LoginUserDTO;
import ftn.XMLWSiBezbednost.exception.EntityAlreadyExistsException;
import ftn.XMLWSiBezbednost.utils.data.Client;

public interface ClientService {

    Client register(LoginUserDTO dto) throws EntityAlreadyExistsException;

}