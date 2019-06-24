package com.example.springboot1.service;

import com.example.springboot1.model.AccountEntity;
import com.example.springboot1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceDetails implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Iterable<AccountEntity> getAllAccount() {
        return this.accountRepository.findAll();
    }

    @Override
    public AccountEntity getAccountById(int id) {
        return this.accountRepository.findById(id).get();
    }

    @Override
    public AccountEntity saveAccount(AccountEntity accountEntity) {
        return this.accountRepository.save(accountEntity);
    }

    @Override
    public void deleteAccountById(int id) {
        this.accountRepository.deleteById(id);
    }

    @Override
    public Page<AccountEntity> searchAccountByName(String name,Pageable pageable) {
//        return this.accountRepository.getAccountByName(name);
        return this.accountRepository.getAccountByName(name,pageable);
    }

    @Override
    public Page<AccountEntity> getAllAccountPagination(Pageable pageable) {
        return this.accountRepository.findAll(pageable);
    }

//    @Override
//    public Page<AccountEntity> findPaginated(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int currentPage = pageable.getPageNumber();
//        int startItem = currentPage*pageSize;
//        List<AccountEntity> list;
//        return null;
//    }



}
