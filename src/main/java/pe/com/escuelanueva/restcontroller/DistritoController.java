package pe.com.escuelanueva.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.escuelanueva.entity.DistritoEntity;
import pe.com.escuelanueva.service.DistritoService;

//@RestController define que es un controlador Rest
//Aparece a partir de la versión 4 se Spring
@RestController
//@Controller --> Es un controlador de Spring
//@ResponseBody --> Se volvía un controlador rest
//@RestController --> @Controller + @ResponseBody
//@RequestMapping --> Asignar un nombre al endpoint
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    private DistritoService servicio;

    //@GetMapping --> Permite obtener valores
    @GetMapping
    public List<DistritoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<DistritoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<DistritoEntity> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public DistritoEntity add(@RequestBody DistritoEntity d) {
        return servicio.add(d);
    }

    @PutMapping("/{id}")
    public DistritoEntity update(@PathVariable Long id, @RequestBody DistritoEntity d) {
        d.setCodigo(id);
        return servicio.add(d);
    }

    @DeleteMapping("/{id}")
    public DistritoEntity delete(@PathVariable Long id) {
        DistritoEntity objdistrito = new DistritoEntity();
        objdistrito.setEstado(false);
        return servicio.delete(DistritoEntity.builder().codigo(id).build());
    }

}
