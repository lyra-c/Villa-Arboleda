package awakelab.Prado_del_bosque.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import awakelab.Prado_del_bosque.modelos.entity.Saldo;
import awakelab.Prado_del_bosque.modelos.repositorios.ISaldoRepository;

@Service
public class SaldoService {

	@Autowired
	private ISaldoRepository saldoRepo;
	
	public SaldoService() {
		super();
	}
	
	public Saldo crearSaldo(Saldo saldo) {
		Saldo nuevoSaldo = saldoRepo.save(saldo);
		saldoRepo.flush();
		return nuevoSaldo;
	}
	
	public void update(Saldo s) {
		saldoRepo.save(s);
	}
	
	public List<Saldo> getAll() {
		return saldoRepo.findAll();
	}
	
	public Saldo getOne(int idsaldos) {
		return saldoRepo.findById(idsaldos).orElse(null);
	}
	
	public void delete(int idsaldos) {
		saldoRepo.delete(saldoRepo.getOne(idsaldos));
	}
	
}
