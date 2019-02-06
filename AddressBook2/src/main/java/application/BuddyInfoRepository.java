package application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String name);

    List<BuddyInfo> findByPhone(String phone);

    List<BuddyInfo> findByAddress(String address);

    BuddyInfo findById(long id);

}