package com.example.demo.domain.main.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.main.dto.ResMainDTO;
import com.example.demo.model.entity.GalleryEntity;
import com.example.demo.model.repository.GalleryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainService {

    private final GalleryRepository galleryRepository;

    public ResMainDTO getMainData() {

        List<GalleryEntity> galleryEntityList = galleryRepository.findAll();

        return ResMainDTO.of(galleryEntityList);

    }

    @Transactional
    public void saveGallery(MultipartFile multipartFile) throws IOException {

        String imgBase64 = Base64.getEncoder().encodeToString(multipartFile.getBytes());

        String imgUrl = "data:"+ multipartFile.getContentType() + ";base64," + imgBase64;

        GalleryEntity galleryEntity = GalleryEntity.builder()
                .imgUrl(imgUrl)
                .build();

        galleryRepository.save(galleryEntity);

    }

}
