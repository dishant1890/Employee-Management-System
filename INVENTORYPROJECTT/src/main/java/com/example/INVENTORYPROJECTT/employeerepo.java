package com.example.INVENTORYPROJECTT;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  employeerepo extends JpaRepository<employee, Integer> {
    @Query("select s from employee s where s.department.id=:depart_id")
    employee getbydepart(@Param("depart_id") int depart_id);
    @Query("select f from employee f where f.name like %:name%")
    List<employee> getbyname(@Param("name") String name);
    
}
