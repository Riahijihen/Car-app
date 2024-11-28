package com.jihen.MyProject.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.jihen.MyProject.entities.Image;

public interface ImageService {
	 Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id) ;
	 
	 Image uplaodImageCom(MultipartFile file,Long idCom) throws IOException;
	 List<Image> getImagesParCom(Long comId);


}
