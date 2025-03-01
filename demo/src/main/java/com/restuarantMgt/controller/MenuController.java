package com.restuarantMgt.controller;

import com.restuarantMgt.domain.dto.request.MenuRequest;
import com.restuarantMgt.domain.dto.response.MenuResponse;
import com.restuarantMgt.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseEntity<List<MenuResponse>> getAllMenus(){
        List<MenuResponse> responses = menuService.getAllMenus();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{menu_id}")
    public ResponseEntity<MenuResponse> getMenuById(@PathVariable("menu_id") Long id){
        MenuResponse response = menuService.getMenuById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createMenu(@RequestBody MenuRequest request){
        menuService.createMenu(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
