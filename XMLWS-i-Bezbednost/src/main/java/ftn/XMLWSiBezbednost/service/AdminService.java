package ftn.XMLWSiBezbednost.service;

import ftn.XMLWSiBezbednost.dto.AdminDTO;
import ftn.XMLWSiBezbednost.exception.EntityAlreadyExistsException;
import ftn.XMLWSiBezbednost.utils.data.Admin;

public interface AdminService {

    boolean adminExists();

    Admin create(AdminDTO admin) throws EntityAlreadyExistsException;

}
