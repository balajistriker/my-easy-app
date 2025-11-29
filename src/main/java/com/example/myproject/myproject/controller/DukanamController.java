package com.example.myproject.myproject.controller;

import com.example.myproject.myproject.model.Dukanam;
import com.example.myproject.myproject.model.LoginRequest;
import com.example.myproject.myproject.model.UpdateRequest;
import com.example.myproject.myproject.repo.DukanamRepo;
import com.example.myproject.myproject.service.DukanamService;
import com.example.myproject.myproject.service.MailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class DukanamController {
            @Autowired
    private DukanamService service;
            @Autowired
    private Dukanam     dukanam;
    @Autowired
    private MailService mailService;

    @Autowired
    private DukanamRepo repo;
    @GetMapping("dukanams")
    public List<Dukanam> allDukanams(){
        return service.getAllDukanams();
    }


    @GetMapping("dukanam/{id}")
    public Optional<Dukanam> dukanamById(@PathVariable("id") int id){
        return service.getDukanamById(id);
    }
    @GetMapping(value="dukanam/{userId}/{password}" ,produces="application/json")
    public Dukanam dukanamByUserIdAndPassword(@PathVariable("userId") String userId,@PathVariable("password") String password){
        Dukanam dukanam = service.findByUserIdAndPasswrod(userId,password);
       return dukanam;
    }
    @PostMapping("dukanam/register")
    public ResponseEntity<?> dukanamRegister(@RequestBody Dukanam dukanam){

        // Generate userId and password
        String userId = dukanam.getFirstName().toLowerCase() + new Random().nextInt(9999);
        String password = UUID.randomUUID().toString().substring(0, 8); // random 8-char password
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        // (Optional) Save to DB
//        UserRegistrationEntity entity = new UserRegistrationEntity();
//        BeanUtils.copyProperties(dukanam, dukanam1);
        dukanam.setUserId(userId);
        dukanam.setPassword(password);
        dukanam.setId(randomNumber);// consider hashing it
        service.addDukanam(dukanam );
        // Send email
        mailService.sendCredentials(dukanam.getEmail(), userId, password);
        return ResponseEntity.ok("User registered and credentials sent via email.");
      }
    @PostMapping(value="dukanam/login",produces = "application/json")
    public ResponseEntity<Map<String,Object>> login(@RequestBody LoginRequest loginRequest) {
        Optional<Dukanam> user = repo.findByUserId(loginRequest.getUserId());
        Dukanam user1=user.get();
        Map<String,Object> response = new HashMap<>();
        if (user != null && user1.getUserId().equals(loginRequest.getUserId())) {
            if(user1.getPassword().equals(loginRequest.getPassword()))
            {
            response.put("status", "success");
            response.put("message", "Welcome " + user1.getFirstName());
            response.put("user", user1);
            return ResponseEntity.ok(response);
            }
             else {
            response.put("status", "error");
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                 }
        } else{
            response.put("status", "error");
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
    @PutMapping(value = "dukanam/user/update", produces = "application/json")
    public ResponseEntity<Dukanam> updateByUserId(@RequestBody UpdateRequest updateRequest) {
        return service.updateByUserId(updateRequest.getUserId(), updateRequest)
                .map(updated -> ResponseEntity.ok(updated))   // ✅ return plain object
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping(value="dukanam/id/{id}", produces="application/json")
    public Dukanam dukanamUpdate(@PathVariable("id") int id,@RequestBody Dukanam dukanam){
           Dukanam duk = service.updateDukanam(id,dukanam);
//        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
//        Page<Product> productPage = repo.;
           return  duk;

    }

   @DeleteMapping("dukanam/id/{id}")
    public String  dukanamDelete(@PathVariable("id") int id){
         service.deleteDukanam(id);

         return"Deleted";
   }



}
