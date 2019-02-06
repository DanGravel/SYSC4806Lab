package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Optional;

@RestController
public class BuddyInfoController {
    @Autowired
    private BuddyInfoRepository repository;


    @GetMapping("/buddyinfo/{id}")
    public Optional<BuddyInfo> buddy(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping("/buddyinfo")
    public BuddyInfo newBuddy(@RequestBody BuddyInfo newBuddy){
        return repository.save(newBuddy);
    }
}
