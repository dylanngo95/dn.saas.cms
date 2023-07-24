package dn.sass.cms.user.repository;

import dn.sass.cms.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "Select * From users u Where u.username = ?", nativeQuery = true)
    public User getUserByName(@Param("name") String name);

    @Query(value = "Select * From users u Where u.email = ?", nativeQuery = true)
    public User getUserByEmail(@Param("email") String email);
}
