package com.ArisaBonsaiTree.VaccineDatabase.repositories;

import com.ArisaBonsaiTree.VaccineDatabase.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
