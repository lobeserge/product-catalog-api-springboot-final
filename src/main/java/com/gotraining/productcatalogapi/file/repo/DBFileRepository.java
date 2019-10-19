package com.gotraining.productcatalogapi.file.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gotraining.productcatalogapi.file.model.DBFile;



@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
