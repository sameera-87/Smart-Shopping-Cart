package com.Sameera.smart_shopping.service.image;

import com.Sameera.smart_shopping.exceptions.ResourceNotFoundException;
import com.Sameera.smart_shopping.model.Image;
import com.Sameera.smart_shopping.repository.ImageRepository;
import com.Sameera.smart_shopping.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageService implements IImageService{

    private final ImageRepository imageRepository;
    private final IProductService productService;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No image found with id: " + id));
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse(imageRepository::delete, () -> {
            throw new ResourceNotFoundException("No image with id: " + id);
        });
    }

    @Override
    public Image saveImage(MultipartFile file, Long productId) {
        return null;
    }

    @Override
    public Image updateImage(MultipartFile file, Long imageId) {
        return null;
    }
}
