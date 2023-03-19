package com.qtvsmart.qtvsmartServer.service;

import com.qtvsmart.qtvsmartServer.entity.Image;

public interface ImageService {
    Image addImage(Image image);

    Image getOneImage(Image image);
}
