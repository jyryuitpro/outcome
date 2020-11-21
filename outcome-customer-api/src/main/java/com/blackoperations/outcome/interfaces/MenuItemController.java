package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.application.MenuItemService;
import com.blackoperations.outcome.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PatchMapping("/restaurants/{id}/menuitems")
    public String bulkUpdate(@PathVariable("id") Long id, @RequestBody List<MenuItem> menuItems) {
        menuItemService.bulkUpdate(id, menuItems);

        return "";
    }
}
