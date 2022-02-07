package com.nepalaya.onlineauction.services.impl;

import com.nepalaya.onlineauction.builder.ResponseBuilder;
import com.nepalaya.onlineauction.model.Product;
import com.nepalaya.onlineauction.repository.ProductRepository;
import com.nepalaya.onlineauction.repository.dtos.Response;
import com.nepalaya.onlineauction.repository.dtos.request.ProductRequest;
import com.nepalaya.onlineauction.repository.dtos.response.ProductResponse;
import com.nepalaya.onlineauction.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Response saveProduct(ProductRequest request) {
        try {
            Product product = this.buildProducts(request);
            productRepository.save(product);
            return ResponseBuilder.success("Product added successfully!");
        } catch (Exception ex) {
            throw new IllegalArgumentException("invalid input");
        }
    }

    @Override
    public Response getProduct(Long productId) {
        try {
            ProductResponse productResponse = this.mapProduct(productRepository
                    .findById(productId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

            return ResponseBuilder.success("Product detail fetched successfully", productResponse);
        } catch (Exception ex) {
            throw new IllegalArgumentException("invalid");
        }
    }

    private ProductResponse mapProduct(Product product) {
       ProductResponse response = new ProductResponse();
        response.setProductName(product.getProductName());
        response.setProductCategory(product.getProductCategory());
        response.setProductDescription(product.getProductDescription());
        response.setImage(product.getImage());
        response.setQuantity(product.getQuantity());
        response.setActualPrice(product.getActualPrice());
        response.setQuantity(product.getQuantity());
        return response;
    }

    @Override
    public Response getAllProduct() {
        try {
            List<Product> products = productRepository.findAll();
            if (products != null) {
                List<ProductResponse> productResponses = products.stream()
                        .map(this::mapProduct)
                        .collect(Collectors.toList());
                return ResponseBuilder.success("Product details fetched successfully", productResponses);
            } else {
                return ResponseBuilder.failure("Product details not found");
            }

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public Response updateProduct(Long productId, ProductRequest request) {

        try {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
////            Product updatedProduct = this.buildProducts(product,request);
//            productRepository.save(updatedProduct);
            return ResponseBuilder.success("Product updated successfully");
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    private Product buildProducts(ProductRequest request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setProductCategory(request.getProductCategory());
        product.setProductDescription(request.getProductDescription());
        product.setActualPrice(request.getActualPrice());
        product.setImage(request.getImage());
        product.setQuantity(request.getQuantity());
        product.setSellerId(request.getSellerId());
        return product;
    }

    @Override
    public Response deleteProduct(Long productId) {

        try {
            Product product = productRepository.findById(productId)
                     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            product.setActive(false);
            productRepository.save(product);
            return ResponseBuilder.success("Product deleted successfully");
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }
}

