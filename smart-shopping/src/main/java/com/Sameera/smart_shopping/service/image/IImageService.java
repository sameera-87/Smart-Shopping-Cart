package com.Sameera.smart_shopping.service.image;

import com.Sameera.smart_shopping.dto.ImageDto;
import com.Sameera.smart_shopping.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
    Image updateImage(MultipartFile file, Long imageId);


}
