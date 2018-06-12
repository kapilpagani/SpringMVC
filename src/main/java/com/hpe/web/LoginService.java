package com.hpe.web;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
		public boolean validateUser(String user, String password){
			return user.equalsIgnoreCase("kapil") && password.equals("kapil");
		}

}
