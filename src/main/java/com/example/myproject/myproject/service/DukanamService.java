package com.example.myproject.myproject.service;

import com.example.myproject.myproject.model.Dukanam;
import com.example.myproject.myproject.model.UpdateRequest;
import com.example.myproject.myproject.repo.DukanamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DukanamService {
    @Autowired
    DukanamRepo repo;
    @Autowired
    private Dukanam dukanam;
    public List<Dukanam> getAllDukanams() {
        return repo.findAll();
    }

    public Optional<Dukanam> getDukanamById(int id) {

       return repo.findById(id);
    }



    public  void addDukanam(Dukanam dukanam) {
         repo.save(dukanam);
    }

    public Dukanam updateDukanam(int id, Dukanam dukanam) {
        repo.findById(id).map(existing-> {
            existing.setUserId(dukanam.getUserId());
//        existing.setAvailableDrinks(dukanam.getAvailableDrinks());
//        existing.setCurrentStatus(dukanam.getCurrentStatus());
//        existing.setOwnerName(dukanam.getOwnerName());
        existing.setFirstName(dukanam.getFirstName());
        existing.setLastName(dukanam.getLastName());
        existing.setMandal(dukanam.getMandal());
        existing.setBusinessType(dukanam.getBusinessType());
        existing.setEmail(dukanam.getEmail());
        existing.setVillage(dukanam.getVillage());
        existing.setState(dukanam.getState());
        existing.setDistrict(dukanam.getDistrict());
        existing.setMobile(dukanam.getMobile());
//        existing.setAvailable_non_vegFood_Items(dukanam.getAvailable_non_vegFood_Items());
//        existing.setAvailableVegetables(dukanam.getAvailableVegetables());

        return repo.save(existing);
        });
        return dukanam;
    }

    public void deleteDukanam(int Id) {
        repo.findById(Id).map(caught->{
            if(caught.getId()==Id){
                repo.deleteById(Id);

            }
            return true ;
        });
    }
    public Optional<Dukanam> updateByUserId(String userId, UpdateRequest updateRequest) {
        return repo.findByUserId(userId).map(existing -> {
            existing.setFirstName(updateRequest.getFirstName());
            existing.setLastName(updateRequest.getLastName());
            existing.setEmail(updateRequest.getEmail());
            existing.setBusinessType(updateRequest.getBusinessType());
            existing.setDistrict(updateRequest.getDistrict());
            existing.setMandal(updateRequest.getMandal());
            existing.setVillage(updateRequest.getVillage());
            existing.setState(updateRequest.getState());
            existing.setMobile(updateRequest.getMobile());
            return repo.save(existing);
        });
    }


    public Dukanam findByUserIdAndPasswrod(String userId, String password) {
     Optional<Dukanam> user =  repo.findByUserId(userId);
     if(user.isPresent()){
            Dukanam user1 =user.get();
            if(user1.getPassword().equals(password)){
                return user1;
                                                   }
     }
         return null;
    }
}
