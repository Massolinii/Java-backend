package com.gestionePrenotazioni.service;

import com.gestionePrenotazioni.payload.LoginDto;
import com.gestionePrenotazioni.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
