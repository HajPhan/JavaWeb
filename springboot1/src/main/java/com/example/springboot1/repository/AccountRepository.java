package com.example.springboot1.repository;

import com.example.springboot1.model.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer>, PagingAndSortingRepository<AccountEntity,Integer> {
    @Query(value = "SELECT a.* FROM account a WHERE a.a_Name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    Page<AccountEntity> getAccountByName(@Param("name") String name, Pageable pageable);

}
