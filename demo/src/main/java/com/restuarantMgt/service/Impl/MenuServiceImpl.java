package com.restuarantMgt.service.Impl;

import com.restuarantMgt.domain.Menu;
import com.restuarantMgt.domain.dto.response.MenuResponse;
import com.restuarantMgt.exception.NotFoundException;
import com.restuarantMgt.repository.MenuRepository;
import com.restuarantMgt.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

//    private final MenuRepository menuRepository;
//    @Override
//    public List<MenuResponse> getAllMenus() {
//        return menuRepository.findAll()
//                .stream()
//                .map(MenuResponse::from)
//                .toList();
//    }
//
//    @Override
//    public MenuResponse getMenuById(Long id) {
//        Menu menu = menuRepository.findById(id)
//                .orElseThrow(()-> new NotFoundException("Menu not Found"));
//        return MenuResponse.from(menu);
//    }
}
