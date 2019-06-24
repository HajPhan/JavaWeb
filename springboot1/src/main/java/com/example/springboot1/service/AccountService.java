package com.example.springboot1.service;

import com.example.springboot1.model.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    public Iterable<AccountEntity> getAllAccount();
    public AccountEntity getAccountById(int id);
    public AccountEntity saveAccount(AccountEntity accountEntity);
    public void deleteAccountById(int id);
    public Page<AccountEntity> searchAccountByName(String name,Pageable pageable);
    public Page<AccountEntity> getAllAccountPagination(Pageable pageable);
//    public Page<AccountEntity> findPaginated(Pageable pageable);
}
