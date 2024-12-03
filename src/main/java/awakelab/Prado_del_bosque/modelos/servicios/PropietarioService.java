package awakelab.Prado_del_bosque.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import awakelab.Prado_del_bosque.modelos.entity.Propietario;
import awakelab.Prado_del_bosque.modelos.repositorios.IPropietarioRepository;

@Service
public class PropietarioService {
	
	@Autowired
	private IPropietarioRepository propRepo;
	
	public PropietarioService() {
		super();
	}
	
	public Propietario crearPropietario(Propietario propietario) {
		Propietario nuevoPropietario = propRepo.save(propietario);
		propRepo.flush();
		return nuevoPropietario;
	}
	
	public void update(Propietario p) {
		propRepo.save(p);
	}
	
	public List<Propietario> getAll() {
		return propRepo.findAll();
	}
	
	public Propietario getOne(int idpropietario) {
		return propRepo.findById(idpropietario).orElse(null);
	}
	
	public void delete(int idpropietario) {
		propRepo.delete(propRepo.getOne(idpropietario));
	}
}
