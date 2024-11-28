package com.jihen.MyProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihen.MyProject.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long>  {

}
