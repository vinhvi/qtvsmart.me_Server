package com.qtvsmart.qtvsmartServer;

import com.qtvsmart.qtvsmartServer.entity.Customer;
import com.qtvsmart.qtvsmartServer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class QtvsmartServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(QtvsmartServerApplication.class, args);

    }

}
