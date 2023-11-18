package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.service.*;
import lombok.*;
import org.modelmapper.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TestResponseByIdDto getTestById(@PathVariable long id) {
        var test = testService.getTestById(id);
        var testDto = modelMapper.map(test, TestResponseByIdDto.class);

        return testDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TestCreationResponseDto createTest(
        @RequestBody TestCreationDto creationDto
    ) {
        var newTest = modelMapper.map(creationDto, Test.class);
        testService.createTest(newTest);

        var testId = newTest.getId();
        var testCreationResponseDto = new TestCreationResponseDto().setId(testId);
        return testCreationResponseDto;
    }

    @PatchMapping("/{id}/name")
    public void updateTest(
        @PathVariable long id,
        @RequestBody TestNameUpdateDto testNameUpdateDto
    ) {
        var test = testService.getTestById(id);
        var newName = testNameUpdateDto.getName();

        testService.updateTest(test, newName);
    }

    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable long id) {
        testService.deleteTest(id);
    }

}
