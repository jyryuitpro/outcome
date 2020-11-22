package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.application.MenuItemService;
import com.blackoperations.outcome.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/restaurants/{restaurantId}/menuitems")
    public List<MenuItem> list(@PathVariable Long restaurantId) {
        List<MenuItem> menuItems = menuItemService.getMenuItems(restaurantId);

        return menuItems;
    }

    @PatchMapping("/restaurants/{id}/menuitems")
    public String bulkUpdate(@PathVariable("id") Long id, @RequestBody List<MenuItem> menuItems) {
        menuItemService.bulkUpdate(id, menuItems);

        return "";
    }
}
