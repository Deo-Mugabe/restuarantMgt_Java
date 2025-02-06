package com.restuarantMgt.service;

import com.restuarantMgt.domain.dto.request.MenuRequest;
import com.restuarantMgt.domain.dto.response.MenuResponse;

import java.util.List;

public interface MenuService {
    List<MenuResponse> getAllMenus();

    MenuResponse getMenuById(Long id);

    void createMenu(MenuRequest request);
}
