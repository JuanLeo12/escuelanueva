package pe.com.escuelanueva.service;

import java.util.List;
import java.util.Optional;
import pe.com.escuelanueva.entity.ApoderadoEntity;

public interface ApoderadoService {

    List<ApoderadoEntity> findAll();

    List<ApoderadoEntity> findAllCustom();

    Optional<ApoderadoEntity> findById(Long id);

    ApoderadoEntity add(ApoderadoEntity a);

    ApoderadoEntity update(ApoderadoEntity a);

    ApoderadoEntity delete(ApoderadoEntity a);
}
