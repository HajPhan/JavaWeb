package com.example.springbootbean.controller;

import com.example.springbootbean.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  - @Qualifier: được coi như một định danh cho Bean khi có nhiều Bean cùng kiểu dữ liệu giúp Spring có thể @Autowire Bean
 *
 *  - @Bean(name=""): được dùng để đặt tên cho Bean, được sử dụng khi có nhiều Bean cùng kiểu dữ liệu nhưng không khai báo Qualifier.
 *
 *  - Một số trường hợp:
 *      +) Nếu khi có nhiều Bean cùng kiểu dữ liệu thì khi sử dụng @Autowire thì Spring không thể xác định đươc Inject vào @Bean nào
 *      +) Nếu khi khai báo cả Bean(name="") và @Qualifier("name") và cùng sử dụng chúng thì Spring sẽ sử dụng @Qualifier để @Autowire
 *      +) Nếu khi chỉ dùng một trong hai @Bean(name="") or @Qualifier("name") thì Spring sẽ tự động tìm tới @Bean theo name của Bean hoặc Qulifier.
 *      +) Khi khai báo một Instance của Bean để @Autowire trong trường hợp có nhiều Bean cùng kiểu dữ liệu thì cần phải khai báo tên biến giống với tên
 *         của @Bean(name="") or @Qualifier("name").
 *      +) Khi khai báo một Instance của @Bean mà trong hệ thống có một Bean duy nhất thì không nhất thiết phải khai báo @Bean(name="")
 *         or @Qualifier("name"). vì khi đó Spring sẽ tự động mapping với tên của hoặc kiểu dữ liệu của Bean đó trong hệ thống.
 *      +) Khi sử dụng initMethod="nameInit" và destroyMethod="nameDestroy" thì chúng ta cần phải khai báo method nameInit() và nameDestroy()
 *         trong khi Bean (Class Object)
 *      +) Khi đặt tên cho Bean thì bắt buộc khi tạo một Instance cho Bean đó thì tên biến phải cùng tên với tên Bean đã đặt.
 *         (mặc định thì Spring sẽ mapping theo tên của Method or có thể dụng Qualifier("name") để chỉ định name cho biến của @Bean )
 *
 */

@Controller
public class MainController {

    @Autowired
//    @Qualifier("person1")  // Xác định bean cho Spring có thể @Autowire khi có nhiều bean cùng kiểu dữ liệu
    private Person person2;  // Trường hợp: nếu chúng ta không đặt name cho Bean thi khi @Autowire cần phải sử dụng
    //              @Qualifier được khai báo trong Bean ban đầu
    // Trường hợp: nếu không sử dụng @Qualifier thì cần phải đăt name cho Bean (name=" - ")
    //              trong trường hợp có nhiều Bean cùng kiểu dữ liệu,
    //              nếu không thì khi @Autowire sẽ ko xác định đc Bean nào đang đc dùng
    // Trường hợp: nếu cùng khai báo name cho @Bean (name="") và @Qualifer("name") thì khi
    //             chúng ta cùng sử dụng cả hai cùng một lúc thì Spring sẽ ưu tiên sử dụng name của @Qualifier("name")
    //             nếu không có một trong hai thì Spring sẽ tự động xác định name của @Bean hay @Quatifier để tự động
    //             mapping chúng khi @Autowire.


    @Autowired
    private Person person3; // bien: person3: là tên của Bean (name="person3")

    @Autowired
    @Qualifier("world")
    private String text;   // hello: là tên của Bean(name="hello");

    @Autowired
    private String mail;   // mail: là tên của phương thức Method: mail()

    @Autowired
    private Person person4;

    @RequestMapping(value = "/hello")
    public String hello(Model model){
        model.addAttribute("person",person4);
        return "hello";
    }

    @RequestMapping(value = {"/home", "/"})
    public String home(Model model) {
        model.addAttribute("person", person2);
        return "home";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(Model model) {
        model.addAttribute("person", person3);
        return "welcome";
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("name", text);
        model.addAttribute("mail", mail);
        return "index";
    }
}
