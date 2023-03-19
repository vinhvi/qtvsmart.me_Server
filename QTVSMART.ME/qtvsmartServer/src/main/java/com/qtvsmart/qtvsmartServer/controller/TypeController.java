package com.qtvsmart.qtvsmartServer.controller;

import com.qtvsmart.qtvsmartServer.entity.Type;
import com.qtvsmart.qtvsmartServer.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @PostMapping("/create")
    public void createType(@RequestBody Type type){
        typeService.saveType(type);
    }
}
