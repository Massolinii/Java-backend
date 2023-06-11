package com.GestioneDispositivi3.Serivice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestioneDispositivi3.Repository.DispositivoRepository;
import com.GestioneDispositivi3.model.Dispositivo;

@Service
public class DispositivoService {

@Autowired DispositivoRepository disporepo;

public Dispositivo createDispositivo (Dispositivo dispositivo) {
	disporepo.save(dispositivo);
	return dispositivo;
}

public Dispositivo getDispositvoid (Long id) {
	return disporepo.findById(id).get();

}

public List<Dispositivo> getAlldispositivo() {
	return (List<Dispositivo>) disporepo.findAll();
	
}
	
public String removed(Long id)	{
	disporepo.deleteById(id);
	return "hai eliminato un dispositivo";
	
}



	
	
	
	
	
	
	
	
	
	
}
