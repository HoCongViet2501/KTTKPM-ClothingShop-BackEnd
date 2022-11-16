package com.se.backend.ecommerceapp.dto;

import com.se.backend.ecommerceapp.model.entity.Image;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDTO {
    private Long id;
    
    @NotNull(message = "required")
    private String fileURL;
    
    public static ImageDTO build(Image image) {
        return ImageDTO.builder()
                .id(image.getId())
                .fileURL(image.getFileURL())
                .build();
    }
}
