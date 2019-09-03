package ftn.XMLWSiBezbednost.security;

import ftn.XMLWSiBezbednost.utils.data.User;

public interface  SecurityService {
	
	User getLoggedInUser();

    void autologin(String username, String password);

}
