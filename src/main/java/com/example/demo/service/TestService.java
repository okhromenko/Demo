package com.example.demo.service;

import com.example.demo.exception.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public void createTest(Test test) {
        testRepository.save(test);
    }

    public Test getTestById(Long id) {
        var test = testRepository.findById(id)
            .orElseThrow(() -> new TestNotFoundException(
                "Тест с указанным id не найден"
            ));

        return test;
    }

    public void updateTest(Test test, String newName) {
        var updateTest = getTestById(test.getId());
        updateTest.setName(newName);

        testRepository.save(updateTest);
    }

    public void deleteTest(Long id) {
        var test = getTestById(id);
        testRepository.delete(test);
    }

}
