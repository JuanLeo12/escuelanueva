package pe.com.escuelanueva.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.escuelanueva.entity.ApoderadoEntity;
import pe.com.escuelanueva.repository.ApoderadoRepository;

@Service
public class ApoderadoServiceImpl implements ApoderadoService{
    @Autowired
    private ApoderadoRepository repositorioapoderado;
    
    @Override
    public List<ApoderadoEntity> findAll() {
        return repositorioapoderado.findAll();
    }

    @Override
    public List<ApoderadoEntity> findAllCustom() {
        return repositorioapoderado.findAllCustom();
    }

    @Override
    public Optional<ApoderadoEntity> findById(Long id) {
        return repositorioapoderado.findById(id);
    }

    @Override
    public ApoderadoEntity add(ApoderadoEntity a) {
        return repositorioapoderado.save(a);
    }

    @Override
    public ApoderadoEntity update(ApoderadoEntity a) {
        ApoderadoEntity objdistrito= repositorioapoderado.getById(a.getCodigo());
        BeanUtils.copyProperties(a, objdistrito);
        return repositorioapoderado.save(objdistrito);
    }

    @Override
    public ApoderadoEntity delete(ApoderadoEntity a) {
        ApoderadoEntity objdistrito= repositorioapoderado.getById(a.getCodigo());
        objdistrito.setEstado(false);
        return repositorioapoderado.save(objdistrito);
    }
}
