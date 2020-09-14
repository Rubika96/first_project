package com.sgic.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.productservice.entities.Feature;


public interface FeaturesRepository extends JpaRepository<Feature, Long> {

}
