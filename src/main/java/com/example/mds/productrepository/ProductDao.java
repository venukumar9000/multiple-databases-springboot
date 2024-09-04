package com.example.mds.productrepository;

import com.example.mds.productentity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Integer> {
}
