package com.hds.ssm.dao;

import com.hds.ssm.model.Evaluation;

import java.util.List;

public interface EvaluationDao {
    Integer getGoodEval();
    Integer getMiddleEval();
    Integer getBadEval();
    List<Evaluation> getAll();
    List<Evaluation> getGoodEvalList();
    List<Evaluation> getMiddleEvalList();
    List<Evaluation> getBadEvalList();
    List<Evaluation> getAllEvalList();
}
