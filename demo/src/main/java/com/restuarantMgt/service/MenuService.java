package com.restuarantMgt.service;

import com.restuarantMgt.domain.dto.response.MenuResponse;

import java.util.List;

public interface MenuService {
    List<MenuResponse> getAllMenus();

    MenuResponse getMenuById(Long id);
}
