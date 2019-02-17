package com.hds.ssm.service.evaluation;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Evaluation;

public interface EvaluationService {
    PageInfo<Evaluation> getAll();
    Integer getGoodEval();
    Integer getMiddleEval();
    Integer getBadEval();
    PageInfo<Evaluation> getGoodEvalList(Integer pageNum);
    PageInfo<Evaluation> getMiddleEvalList(Integer pageNum);
    PageInfo<Evaluation> getBadEvalList(Integer pageNum);
    PageInfo<Evaluation> getAllEvalList(Integer pageNum);
}
