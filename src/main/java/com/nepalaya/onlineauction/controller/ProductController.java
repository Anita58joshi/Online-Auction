package com.nepalaya.onlineauction.controller;

import com.nepalaya.onlineauction.repository.dtos.Response;
import com.nepalaya.onlineauction.repository.dtos.request.ProductRequest;
import com.nepalaya.onlineauction.services.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Response addProduct(@RequestBody @Valid ProductRequest request) {
        return productService.saveProduct(request);
    }

    @GetMapping
    public Response getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("{id}")
    public Response getProductById(@PathVariable("id") Long productId) {
        return productService.getProduct(productId);
    }

    @DeleteMapping( "{id}")
    public Response deleteProduct(@PathVariable("id") Long productId) {
        return productService.deleteProduct(productId);
    }

    @PutMapping( "{id}")
    public Response updateProduct(@PathVariable("id") Long productId, @RequestBody ProductRequest request) {
        return productService.updateProduct(productId, request);
    }
}
