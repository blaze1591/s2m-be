package com.s2mbe.controller;

import com.s2mbe.model.science.ScienceUnit;
import com.s2mbe.service.ScienceUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/unit")
public class ScienceUnitController {
    @Autowired
    ScienceUnitService scienceUnitService;

    @GetMapping
    public ResponseEntity<List<ScienceUnit>> showAll() {
        return new ResponseEntity<>(scienceUnitService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScienceUnit> showOne(@PathVariable String id) {
        return ResponseEntity.ok(scienceUnitService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<ScienceUnit> save(@RequestBody Map<String, String> scienceUnitParams) {
        return new ResponseEntity<>(scienceUnitService.save(scienceUnitParams), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScienceUnit> update(@PathVariable String id, @RequestBody Map<String, String> scienceUnitParams) {
        return ResponseEntity.ok(scienceUnitService.update(id, scienceUnitParams));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        scienceUnitService.delete(id);
        return ResponseEntity.ok().build();
    }

}
