package com.duylong.laptopshop2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duylong.laptopshop2.domain.User;
import com.duylong.laptopshop2.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    // DI : Dependency Injection
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("duylong", "from model with controller");
        return "hello";
    }

    // Hiển thị form tạo user
    @RequestMapping("/admin/user/create") // GET
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "/admin/user/create";
    }

    // Xử lý tạo mới user
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User duylong) {
        this.userService.handleSaveUser(duylong);
        return "redirect:/admin/user";
    }

    // Hiển thị danh sách user
    @RequestMapping("/admin/user")
    public String listUserPage(Model model) {
        List<User> listUsers = this.userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "/admin/user/table-user";
    }

    // Xử lý hiển thị chi tiết user
    @RequestMapping("/admin/user/{id}") // GET
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "/admin/user/show";
    }

    @RequestMapping("/admin/user/update/{id}") // GET
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("user", currentUser);
        return "/admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("user") User duylong) {
        User currentUser = this.userService.getUserById(duylong.getId());
        if (currentUser != null) {
            currentUser.setFullName(duylong.getFullName());
            currentUser.setAddress(duylong.getAddress());
            currentUser.setPhone(duylong.getPhone());

            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        // User currentUser = this.userService.getUserById(id);

        // User user = new User();
        // user.setId(id);

        model.addAttribute("newUser", new User());
        return "/admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User user) {
        this.userService.deleteAUser(user.getId());
        return "redirect:/admin/user";
    }
}
