package com.nag.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nag.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization,Long> {

}
