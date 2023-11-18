package com.example.demo.dto;

import lombok.*;
import lombok.experimental.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TestCreationDto {
    private long id;
    private String name;

}
