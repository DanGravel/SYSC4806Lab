package application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @Autowired
    private BuddyInfoRepository repository;


    @RequestMapping("/addressbook")
    public Iterable<BuddyInfo> AddressBookController(){
        return repository.findAll();
    }
}
