package com.example.hajibootthymeleaf;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class GeneratePassword {
	public static void main(String[] args) {
		System.out.println(new Pbkdf2PasswordEncoder().encode("demo"));
	}
}
