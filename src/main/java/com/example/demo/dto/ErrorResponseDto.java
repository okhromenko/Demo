package com.example.demo.dto;

import lombok.*;
import lombok.experimental.*;

@Data
@Accessors(chain = true)
public class ErrorResponseDto {
    private ErrorDto error;
}
