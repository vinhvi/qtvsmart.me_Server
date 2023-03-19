package com.qtvsmart.qtvsmartServer.serviceImpl;

import com.qtvsmart.qtvsmartServer.entity.Image;
import com.qtvsmart.qtvsmartServer.repository.ImageRepository;
import com.qtvsmart.qtvsmartServer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image addImage(Image image) {

        return imageRepository.save(image);
    }

    @Override
    public Image getOneImage(Image image) {
        Image image1 = new Image();
        image1.setId(image.getId());
        image1.setUrl(image.getUrl());
        image1.setHienThi(image.isHienThi());
        return image1;
    }
}
