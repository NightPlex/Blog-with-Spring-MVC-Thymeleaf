package com.webstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SessionRegistry sessionRegistry;

	@Override
	public boolean authenticate(String username, String password) {
		return Objects.equals(username, password);
	}

	@Override
	public List<String> listLoggedInUsers() { // Get all logged in users
		final List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
		List<String> usernames = new ArrayList<String>();

		if (allPrincipals.isEmpty()) {
			
			return null;

		} else {

			for (final Object principal : allPrincipals) { // iterate through
															// possible Objects,
															// if it is User
															// type(UserDetail)
															// we ask info.
				if (principal instanceof User) {
					final User user = (User) principal;
					
					
					usernames.add(user.getUsername()); // Add the username to the list.

					//List<SessionInformation> activeUserSessions = sessionRegistry.getAllSessions(principal,
							/* includeExpiredSessions */ //false); // Should not
																	// return
																	// null;

					//if (!activeUserSessions.isEmpty()) {
						// Do something with user
					//}
				}// end of if loop

			} // end of for loop
			
			
			return usernames;
			
		}
	}

}
