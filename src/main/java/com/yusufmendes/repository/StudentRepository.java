package com.yusufmendes.repository;

import com.yusufmendes.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {

    /*
     * HQL -> sınfın ismi ve değişken isimleri kullanılarak sorgular yazılır.
     * SQL -> tablo ismi ve tablo içerisindeki kolon isimleri ile sorgular yazılır.
       @Query(value = "select * from student", nativeQuery = true)
       List<Students> findAllStudent();
     */
    @Query(value = "from Students", nativeQuery = false)
    List<Students> findAllStudent();


}
