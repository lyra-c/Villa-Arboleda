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

import awakelab.Prado_del_bosque.modelos.entity.Saldo;
import awakelab.Prado_del_bosque.modelos.servicios.SaldoService;

@RestController
@RequestMapping("/api/saldos")
public class RestSaldoController {

    @Autowired
    private SaldoService saldoService;

    // Obtener todos los saldos
    @GetMapping
    public List<Saldo> getSaldos() {
        return saldoService.getAll();
    }

    // Obtener un saldo por ID
    @GetMapping("/{idsaldos}")
    public ResponseEntity<?> getSaldo(@PathVariable("idsaldos") int idsaldos) {
        Saldo saldo = saldoService.getOne(idsaldos);
        if (saldo != null) {
            return new ResponseEntity<>(saldo, HttpStatus.OK);
        } else {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("status", 0);
            map.put("message", "Saldo no encontrado");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    // Crear un nuevo saldo
    @PostMapping("/crear")
    public ResponseEntity<?> crearSaldo(@RequestBody Saldo saldo) {
        Map<String, Object> map = new LinkedHashMap<>();
        Saldo nuevoSaldo = saldoService.crearSaldo(saldo);
        map.put("status", 1);
        map.put("message", "Saldo creado exitosamente");
        map.put("data", nuevoSaldo);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    // Eliminar un saldo por ID
    @DeleteMapping("/eliminar/{idsaldos}")
    public ResponseEntity<?> borrarSaldo(@PathVariable int idsaldos) {
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            Saldo saldo = saldoService.getOne(idsaldos);
            if (saldo != null) {
                saldoService.delete(idsaldos);
                map.put("status", 1);
                map.put("message", "Saldo eliminado exitosamente");
            } else {
                map.put("status", 0);
                map.put("message", "Saldo no encontrado");
                return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            map.put("status", 0);
            map.put("message", "Error al eliminar el saldo");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    // Actualizar un saldo por ID
    @PutMapping("/actualizar/{idsaldos}")
    public ResponseEntity<?> actualizarSaldo(@PathVariable int idsaldos, @RequestBody Saldo saldoDetalle) {
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            Saldo saldo = saldoService.getOne(idsaldos);
            if (saldo != null) {
                saldo.setRut(saldoDetalle.getRut());
                saldo.setSaldo(saldoDetalle.getSaldo());
                saldo.setEstado(saldoDetalle.getEstado());
                saldoService.update(saldo);
                map.put("status", 1);
                map.put("data", saldo);
                return new ResponseEntity<>(map, HttpStatus.OK);
            } else {
                map.put("status", 0);
                map.put("message", "Saldo no encontrado");
                return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            map.put("status", 0);
            map.put("message", "Error al actualizar el saldo");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
