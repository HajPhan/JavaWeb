package com.example.springboot1.controller;

import com.example.springboot1.model.AccountEntity;
import com.example.springboot1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    protected AccountService accountService;

    @RequestMapping(value = "/account-view/{id}")
    public String viewAccount(Model model, @PathVariable int id){
        model.addAttribute("accountList",this.accountService.getAccountById(id));
        return "account-view";
    }


    @RequestMapping(value = "/account-save")
    public String saveAccount(Model model){
        model.addAttribute("account",new AccountEntity());
        return "account-save";
    }

    @RequestMapping(value = "/saveAccount")
    public String doSaveAccount(@ModelAttribute("AccountEntity") AccountEntity accountEntity,Model model){
        this.accountService.saveAccount(accountEntity);
        return "redirect:/";
    }


    @RequestMapping(value = "/account-update/{id}")
    public String updateAccount(@PathVariable int id, Model model){
        model.addAttribute("account",this.accountService.getAccountById(id));
        return "account-update";
    }

    @RequestMapping(value = "/updateAccount/{id}")
    public String doUpdateAccount(@ModelAttribute("AccountEntity") AccountEntity accountEntity, @PathVariable int id, Model model){
        accountEntity.setId(id);
        this.accountService.saveAccount(accountEntity);
        model.addAttribute("accountList",this.accountService.getAllAccount());
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteAccount/{id}")
    public String doDeleteAccount(@PathVariable int id, Model model){
        this.accountService.deleteAccountById(id);
        model.addAttribute("accountList",this.accountService.getAllAccount());
        return "redirect:/";
    }

    @RequestMapping(value = "/searchAccount")
    public String doSearchAccount(Pageable pageable, Model model, @RequestParam("searchString") String searchString,@RequestParam(defaultValue = "0") int nPage){
        pageable = PageRequest.of(nPage,5);
        Page page = this.accountService.searchAccountByName(searchString,pageable);
        model.addAttribute("page",page);
//        model.addAttribute("accountList",model);
//        model.addAttribute("accountList",page.getContent());
//        model.addAttribute("pageNumber",page.getTotalPages());
//        model.addAttribute("data",page.getTotalPages()-1);
        return "account-list";
    }

    @RequestMapping(value = "/")
    public String getAccountPagination(Pageable pageable, Model model,@RequestParam(defaultValue = "0") int nPage){
        pageable = PageRequest.of(nPage,5);
        Page page = this.accountService.getAllAccountPagination(pageable);
        model.addAttribute("page",page);
//        List<AccountEntity> listAccount = page.getContent();
//        model.addAttribute("accountList",page.getContent());
//        model.addAttribute("pageNumber",page.getTotalPages());
//        model.addAttribute("data",page.getTotalPages()-1);
        return "account-list";
    }
}
