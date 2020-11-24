package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.domain.Region;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController {

    @GetMapping("/regions")
    public List<Region> list() {
        return null;
    }
}
