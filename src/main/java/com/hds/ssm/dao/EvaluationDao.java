package com.hds.ssm.dao;

import com.hds.ssm.model.Evaluation;
import org.apache.ibatis.annotations.Param;

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
    List<Evaluation> searchListById(@Param("project_id") Integer project_id);
    List<Evaluation> searchListByName(@Param("customer_name") String customer_name, @Param("project_id") Integer project_id);

    String[] getSomeContent(@Param("projectId")Integer projectId);
}
