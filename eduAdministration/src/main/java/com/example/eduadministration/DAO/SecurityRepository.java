package com.example.eduadministration.DAO;

import com.example.eduadministration.Mapper.Security;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends CrudRepository<Security, String> {

}
