package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.MenuItem;
import com.blackoperations.outcome.domain.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getMenuItems(Long restaurantId) {
        return menuItemRepository.findAllByRestaurantId(restaurantId);
    }

    public void bulkUpdate(Long id, List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            update(id, menuItem);
        }
    }

    private void update(Long id, MenuItem menuItem) {
        if (menuItem.isDestroy()) {
            menuItemRepository.deleteById(menuItem.getId());
            return;
        }
        menuItem.setRestaurantId(id);
        menuItemRepository.save(menuItem);
    }
}
