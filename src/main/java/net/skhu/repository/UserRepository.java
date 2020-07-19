package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.skhu.domain.User;

public interface UserRepository extends JpaRepository<User, String>  {


    @Modifying(clearAutomatically = true)
    @Query(value="UPDATE user u SET userType = :userType WHERE id = :id", nativeQuery=true)
     void updateUserType( @Param("userType") String userType,@Param("id") String id);

}

