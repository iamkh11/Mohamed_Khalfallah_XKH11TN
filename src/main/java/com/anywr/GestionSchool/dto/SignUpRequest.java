package com.anywr.GestionSchool.dto;

import lombok.Data;

@Data
public class SignUpRequest {
		private String fullname;
		private String username;
	    private String email;
	    private String password;
	    private String filter;
}
