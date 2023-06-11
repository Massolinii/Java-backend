package com.GestioneDispositivi3.auth.runners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.GestioneDispositivi3.Repository.DispositivoRepository;
import com.GestioneDispositivi3.auth.roles.ERole;
import com.GestioneDispositivi3.auth.roles.Role;
import com.GestioneDispositivi3.auth.roles.RoleRepository;
import com.GestioneDispositivi3.auth.users.User;
import com.GestioneDispositivi3.auth.users.UserRepository;
import com.GestioneDispositivi3.model.Dispositivo;
import com.GestioneDispositivi3.model.StatoDispositivo;
import com.GestioneDispositivi3.model.TipoDispositivo;

@Component
public class UserRunner implements ApplicationRunner {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	DispositivoRepository drepo;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Dispositivo d1 = new Dispositivo();
		d1.setStatodispositivo(StatoDispositivo.ASSEGNATO);
		d1.setTipodispositivo(TipoDispositivo.SMARTPHONE);

		Dispositivo d2 = new Dispositivo();
		d2.setStatodispositivo(StatoDispositivo.DISPONIBILE);
		d2.setTipodispositivo(TipoDispositivo.TABLET);

		Dispositivo d3 = new Dispositivo();
		d3.setStatodispositivo(StatoDispositivo.MANUTENZIONE);
		d3.setTipodispositivo(TipoDispositivo.LAPTOP);

		drepo.save(d1);
		drepo.save(d2);
		drepo.save(d3);

		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);

		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);

		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);

		Set<Role> adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(moderator);
		adminRole.add(user);

		Set<Role> moderatorRole = new HashSet<Role>();
		moderatorRole.add(moderator);
		moderatorRole.add(user);

		Set<Role> userRole = new HashSet<Role>();
		userRole.add(user);

//		User userAdmin = new User();
//		userAdmin.setNome("Paolo");
//		userAdmin.setCognome("Scavalcacinghie");
//		userAdmin.setUsername("theBoss");
//		userAdmin.setEmail("admin@example.it");
//		userAdmin.setPassword(encoder.encode("admin"));
//		userAdmin.setRoles(adminRole);
//		userAdmin.setDispositivo(d1);
//		userRepository.save(userAdmin);
//
//		User simpleUser = new User();
//		simpleUser.setNome("Mario");
//		simpleUser.setCognome("Rossi");
//		simpleUser.setUsername("mariorossi");
//		simpleUser.setEmail("mr.ossi@example.com");
//		simpleUser.setPassword(encoder.encode("ciufolino33"));
//		simpleUser.setRoles(userRole);
//		simpleUser.setDispositivo(d2);
//		userRepository.save(simpleUser);
//
//		User userModerator = new User();
//		userModerator.setNome("Giuseppe");
//		userModerator.setCognome("Verdi");
//		userModerator.setUsername("giuver");
//		userModerator.setEmail("g.verdi@example.com");
//		userModerator.setPassword(encoder.encode("qwerty123"));
//		userModerator.setRoles(moderatorRole);
//		userModerator.setDispositivo(d3);
//		userRepository.save(userModerator);

//		User userModerator = new User();
//		userModerator.setNome("Bianchi");
//		userModerator.setCognome("Purissimi");
//		userModerator.setUsername("scassacerniere");
//		userModerator.setEmail("puro.puro@puro.net");
//		userModerator.setPassword(encoder.encode("qwerty123456"));
//		userModerator.setRoles(moderatorRole);
//		userModerator.setDispositivo(d1);
//		userRepository.save(userModerator);

	}

}
