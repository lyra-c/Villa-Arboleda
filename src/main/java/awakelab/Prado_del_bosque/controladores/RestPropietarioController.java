package awakelab.Prado_del_bosque.controladores;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import awakelab.Prado_del_bosque.modelos.entity.Propietario;
import awakelab.Prado_del_bosque.modelos.entity.Saldo;
import awakelab.Prado_del_bosque.modelos.servicios.PropietarioService;
import awakelab.Prado_del_bosque.modelos.servicios.SaldoService;

@RestController
@RequestMapping("/api/propietarios")
public class RestPropietarioController {

	@Autowired
	private PropietarioService ps;

	@Autowired
	private SaldoService ss;

	@GetMapping
	public List<Propietario> getPropietarios() {
		return ps.getAll();
	}

	@GetMapping("/{idpropietario}")
	public Propietario getPropietario(@PathVariable("idpropietario") int idpropietario) {
		return ps.getOne(idpropietario);
	}

	@PostMapping("/crear")
	// Crear Propietario
	public ResponseEntity<?> crearPropietario(@RequestBody Map<String, Object> propietarioDetalle) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			// Convertir datos del cuerpo de la solicitud
			int idsaldos = (int) propietarioDetalle.get("idsaldos");
			String nombre = propietarioDetalle.get("nombre").toString();
			String apellido = propietarioDetalle.get("apellido").toString();
			String correo = propietarioDetalle.get("correo").toString();
			String telefono = propietarioDetalle.get("telefono").toString();

			// Buscar el saldo relacionado
			Saldo saldo = ss.getOne(idsaldos);	// De aquí se extrae la magia
			if (saldo == null) {
				map.put("status", 0);
				map.put("message", "Saldo no encontrado");
				return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
			}

			// Crear y guardar el propietario
			Propietario propietario = new Propietario();
			propietario.setNombre(nombre);
			propietario.setApellido(apellido);
			propietario.setCorreo(correo);
			propietario.setTelefono(telefono);
			propietario.setSaldos_idsaldos(saldo);	// Aquí ocurre la magia

			Propietario nuevoPropietario = ps.crearPropietario(propietario);

			map.put("status", 1);
			map.put("message", "Propietario creado exitosamente");
			map.put("data", nuevoPropietario);
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (Exception e) {
			map.put("status", 0);
			map.put("message", "Error al crear el propietario: " + e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/eliminar/{idpropietario}")
	public ResponseEntity<?> borrarPropietario(@PathVariable int idpropietario) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Propietario propietario = ps.getOne(idpropietario);
			if (propietario != null) {
				ps.delete(idpropietario); // Pasa el idpropietario en lugar del objeto propietario
				map.put("status", 1);
				map.put("message", "Se ha eliminado un Propietario exitosamente");
			} else {
				map.put("status", 0);
				map.put("message", "No se ha encontrado el Propietario");
				return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			map.put("status", 0);
			map.put("message", "Error al eliminar el Propietario");
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PutMapping("/actualizar/{idpropietario}")
	public ResponseEntity<?> actualizarPropietarioPorIdPropietario(@PathVariable int idpropietario,
			@RequestBody Propietario propietarioDetalle) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Propietario propietario = ps.getOne(idpropietario);
			propietario.setIdpropietario(propietarioDetalle.getIdpropietario());
			propietario.setNombre(propietarioDetalle.getNombre());
			propietario.setApellido(propietarioDetalle.getApellido());
			propietario.setCorreo(propietarioDetalle.getCorreo());
			propietario.setTelefono(propietarioDetalle.getTelefono());
			
			// Obteniendo el parámetro "idsaldos" a partir del input de la solicitud
			Saldo nuevoSaldo = ss.getOne(propietarioDetalle.getSaldos_idsaldos().getIdsaldos());
			propietario.setSaldos_idsaldos(nuevoSaldo);
			
			ps.crearPropietario(propietario);
			map.put("status", 1);
			map.put("data", ps.getOne(idpropietario));
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.clear();
			map.put("status", 0);
			map.put("message", "No se ha encontrado el Propietario o el Saldo correspondiente");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}

	}

}

/*
 * Crear previo:
 * 
 * @PostMapping("/crear") public ResponseEntity<?> crearPropietario(@RequestBody
 * Propietario propietario) { Map<String, Object> map = new
 * LinkedHashMap<String, Object>(); ps.crearPropietario(propietario);
 * map.put("status", 1); map.put("message",
 * "Se ha añadido un Propietario exitosamente"); return new
 * ResponseEntity<>(map, HttpStatus.CREATED); }
 */
