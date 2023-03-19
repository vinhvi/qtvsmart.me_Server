package com.qtvsmart.qtvsmartServer.repository;

import com.qtvsmart.qtvsmartServer.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
