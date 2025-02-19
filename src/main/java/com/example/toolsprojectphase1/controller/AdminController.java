package com.example.toolsprojectphase1.controller;
import com.example.toolsprojectphase1.entities.Admin;
import com.example.toolsprojectphase1.entities.Station;
import com.example.toolsprojectphase1.entities.Trip;
import com.example.toolsprojectphase1.services.AdminService;
import com.example.toolsprojectphase1.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")

public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/signup")
    @CrossOrigin(origins = "http://localhost:4200")
    public void signup(@RequestBody Admin a){
        adminService.signup(a);
    }
    @GetMapping("/getUser/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public  Admin getAdmin(@PathVariable long id){
        return adminService.getAdmin(id);}
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public Admin login(@RequestBody Admin a){

        return adminService.login(a);
    }
    @GetMapping("/getAllUsers")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }
    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:4200")
    public void createTrip(@RequestBody Trip t){
        adminService.createTrip(t);

    }

    @DeleteMapping("/deleteTrip/{id}")
    public void deleteTrip(@PathVariable Long id){
        adminService.deleteTrip(id);
    }

    @GetMapping("/getAllTrips")
    public List<Trip> showAllTrips(){
        return adminService.showAlltrips();
    }
    @GetMapping("/getAllStations")
    public List<Station> showAllStations(){
        return adminService.showAllstations();
    }
    @PutMapping("/updateTrip/{id}")
    public Trip updateTrip(@RequestBody Trip t,@PathVariable long id){
        return adminService.updateTrip(t,id);
    }



}
