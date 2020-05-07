package com.project.demo.repositories;

import com.project.demo.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();
    Page<Product> findAll(Pageable pageable);
    Optional<Product> findById(Long id);
    Page<Product> findAllByCategoryId(Long id, Pageable pageable);


    Page<Product> findAllByCategoryName(String name, Pageable pageable);
   @Query(value = "select * from t_products e where e.name like %:keyword%  or e.content like %:keyword%",nativeQuery = true)
   List<Product> findByKeyword(@Param("keyword") String keyword);

}
