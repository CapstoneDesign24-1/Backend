package com.boj.guidance.service.implement;

import com.boj.guidance.domain.Problem;
import com.boj.guidance.dto.ProblemDto.ProblemResponseDto;
import com.boj.guidance.repository.ProblemRepository;
import com.boj.guidance.service.ProblemService;
import com.boj.guidance.util.api.ResponseCode;
import com.boj.guidance.util.exception.ProblemException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;

    // 문제 id로 검색하기
    @Override
    public ProblemResponseDto searchProblemById(Integer problemId) {
        return returnProblemById(problemId);
    }

    // 알고리즘 이름으로 문제들 검색
    @Override
    public List<ProblemResponseDto> searchAllProblemByAlgorithm(String name) {
        List<Integer> problemIds = problemRepository.findAllProblemIds(name);
        ArrayList<ProblemResponseDto> problems = new ArrayList<>();
        for (Integer problemId : problemIds) {
            problems.add(returnProblemById(problemId));
        }
        return problems;
    }

    public ProblemResponseDto returnProblemById(Integer problemId) {
        Optional<Problem> problemOptional = problemRepository.findById(problemId);
        if (problemOptional.isPresent()) {
            Problem problem = problemOptional.get();
            List<String> algorithms = problemRepository.findAlgorithmsById(problem.getProblemId());
            return new ProblemResponseDto().toResponse(problem, algorithms);
        } else {
            throw new ProblemException(ResponseCode.PROBLEM_FIND_FAIL);
        }
    }
}
