package com.s2mbe.controller;

import com.s2mbe.model.hirsh.HirshEntity;
import com.s2mbe.model.transfer.DashboardRow;
import com.s2mbe.model.transfer.UserReportDTO;
import com.s2mbe.model.user.User;
import com.s2mbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/topTenDashboard")
    public ResponseEntity<List<DashboardRow>> findTop10ByScopusCitations() {
        List<DashboardRow> rows = userService.findTop10ScopusUsers();
        return new ResponseEntity<>(rows, HttpStatus.OK);
    }

    @GetMapping("/scopusReport")
    public ResponseEntity<Map<String, Object>> findInfoScopus() {
        return new ResponseEntity<>(userService.findInfoForScopusReport(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) throws Exception {
        user.setScopusCitationSumm(summHirshCitationCounts(user.getScopusEntities()));
        user.setGoogleScholarCitationSumm(summHirshCitationCounts(user.getGoogleScholarEntities()));
        user.setWebOfScienceCitationSumm(summHirshCitationCounts(user.getWebOfScienceEntities()));

        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/password/{id}")
    public ResponseEntity changePassword(@PathVariable String id, @RequestParam String newPassword) {
        if (userService.changePassword(id, newPassword)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> showUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    private int summHirshCitationCounts(List<? extends HirshEntity> hirshEntities) {
        final int[] citationCountSumm = {0};
        hirshEntities.forEach(hirshEntity ->
            citationCountSumm[0] += hirshEntity.getCitationCount()
        );
        return citationCountSumm[0];
    }

    @GetMapping("/report/cathedral/{cathedraName}")
    public ResponseEntity<List<UserReportDTO>> findDataForCathedral(@PathVariable String cathedraName) {
        System.err.println(cathedraName);
        return ResponseEntity.ok(userService.findDataForCathedraReport(cathedraName));
    }
}
