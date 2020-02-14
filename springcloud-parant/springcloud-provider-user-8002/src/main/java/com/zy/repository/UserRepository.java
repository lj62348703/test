package com.zy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zy.entity.Userinfo;

public interface UserRepository extends JpaRepository<Userinfo, Integer>
	,JpaSpecificationExecutor<Userinfo>{
}
