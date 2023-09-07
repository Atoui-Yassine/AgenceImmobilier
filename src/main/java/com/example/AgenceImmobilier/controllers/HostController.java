package com.example.AgenceImmobilier.controllers;

import com.example.AgenceImmobilier.DTOs.response.BookingDto;
import com.example.AgenceImmobilier.DTOs.response.LogementDto;
import com.example.AgenceImmobilier.models.logement.Logement;
import com.example.AgenceImmobilier.models.logement.TypeLogement;
import com.example.AgenceImmobilier.models.user.UserModel;
import com.example.AgenceImmobilier.services.bookingS.BookingService;
import com.example.AgenceImmobilier.services.logementS.LogementService;
import com.example.AgenceImmobilier.services.user.UserService;
import com.example.AgenceImmobilier.utils.Helpers;
import com.example.AgenceImmobilier.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/host")
@PreAuthorize("hasRole('ROLE_HOST') or hasRole('ROLE_ADMIN')")
public class HostController {
    @Autowired
    private UserService userService;
    @Autowired
     LogementService logementService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    BookingService bookingService;
/*----------Logement------------*/
    @PostMapping("/logement")
    public ResponseEntity<LogementDto> createLogement(@RequestBody LogementDto logementDto) throws Exception {
        System.out.println(logementDto);
        return ResponseEntity.ok().body(logementService.save(logementDto));

    }

    @GetMapping("/logement")
    public ResponseEntity<List<LogementDto>> returnMyLogements(Principal principal){
        UserModel user = userService.findByUsername(principal.getName());
        return ResponseEntity.ok().body(logementService.findByHost(user.getId()));
    }

    @GetMapping("/logement/{id}")
    public ResponseEntity<String> returnLogementById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok().body(Helpers.convertToJson(logementService.findDtoById(id)));
    }

    @PutMapping("/logement/{id}")
    public ResponseEntity<String> updateLogement(@PathVariable("id") Long id, @RequestBody LogementDto logementDto) throws Exception {
        LogementDto logementDto1=logementService.findDtoById(id);

        if(logementDto!=null &&  logementDto1!=null && logementDto1.getHost().getId() == tokenUtils.ExtractId()) {

            return ResponseEntity.ok().body(Helpers.convertToJson(logementService.update(id,logementDto)));
        }
        else
            return ResponseEntity.ok().body("{\"Status\": \"Logement not found\"}");
    }

    @DeleteMapping("/logement/{id}")
    public ResponseEntity<String> deleteLogementById(@PathVariable("id") Long id){
        logementService.deleteById(id);
        return ResponseEntity.ok().body("{\"Status\": \"Successful Deletion\"}");
    }
    /*----------Booking------------*/
    @GetMapping("/listings/{id}/bookings")
    public ResponseEntity<List<BookingDto>> returnLogementBookings(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(bookingService.returnLogementBookings(id));
    }
}
