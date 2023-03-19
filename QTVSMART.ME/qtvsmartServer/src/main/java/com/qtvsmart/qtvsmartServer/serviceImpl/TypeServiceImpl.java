package com.qtvsmart.qtvsmartServer.serviceImpl;

import com.qtvsmart.qtvsmartServer.entity.Type;
import com.qtvsmart.qtvsmartServer.repository.TypeRepository;
import com.qtvsmart.qtvsmartServer.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> getAllTypes() {
        return null;
    }

    @Override
    public Type getTypeById(int id) {
        return getOneType(typeRepository.findTypeById(id));
    }

    @Override
    public void saveType(Type type) {
        typeRepository.save(type);

    }

    @Override
    public void deleteType(int id) {

    }

    @Override
    public Type getOneType(Type type) {
        Type type1 = new Type();
        type1.setId(type.getId());
        type1.setName(type.getName());
        return type1;
    }
}
