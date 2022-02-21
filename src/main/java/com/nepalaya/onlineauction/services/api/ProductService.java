package com.nepalaya.onlineauction.services.api;

import com.nepalaya.onlineauction.model.Product;
import com.nepalaya.onlineauction.repository.dtos.Response;
import com.nepalaya.onlineauction.repository.dtos.request.ProductRequest;

public interface ProductService {

    Response saveProduct(ProductRequest request);

    Response getProduct(Long productId);

    Response getAllProduct();

    Response updateProduct(Long productId,ProductRequest request);

    Response deleteProduct(Long productId);
}
