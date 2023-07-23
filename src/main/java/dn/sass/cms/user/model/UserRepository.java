package dn.sass.cms.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query( value = "Select * From users u Where u.name = ?", nativeQuery = true)
    public User getUserByName(@Param("name") String name);
}
