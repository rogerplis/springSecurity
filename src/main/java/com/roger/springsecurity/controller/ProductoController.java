package com.roger.springsecurity.controller;

import com.roger.springsecurity.ProductRepo;
import com.roger.springsecurity.dtos.ProductoRecordDto;
import com.roger.springsecurity.model.Product;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProductoController {


    @Autowired
    ProductRepo productRepo;

    @PostMapping("produtos")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductoRecordDto productoRecordDto) {
        var producto = new Product();
        BeanUtils.copyProperties(productoRecordDto, producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepo.save(producto));
    }
    @GetMapping("/produtos")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepo.findAll());
    }

}
