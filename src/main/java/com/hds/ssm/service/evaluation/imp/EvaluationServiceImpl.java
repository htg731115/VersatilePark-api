package com.hds.ssm.service.evaluation.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.EvaluationDao;
import com.hds.ssm.model.Evaluation;
import com.hds.ssm.service.evaluation.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="EvaluationService")
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvaluationDao evaluationDao;

    @Override
    public PageInfo<Evaluation> getAll() {
        PageHelper.startPage(1,10);
        List<Evaluation> evalautionList = evaluationDao.getAll();
        PageInfo<Evaluation> pageInfo = new PageInfo<>(evalautionList);
        return pageInfo;
    }

    @Override
    public Integer getGoodEval() {
        return evaluationDao.getGoodEval();
    }

    @Override
    public Integer getMiddleEval() {
        return evaluationDao.getMiddleEval();
    }

    @Override
    public Integer getBadEval() {
        return evaluationDao.getBadEval();
    }

    @Override
    public PageInfo<Evaluation> getGoodEvalList(Integer pageNum) {
        PageHelper.startPage(10,10);
        List<Evaluation> goodEvalList = evaluationDao.getGoodEvalList();
        PageInfo<Evaluation> pageInfo = new PageInfo<>(goodEvalList);
        return pageInfo;
    }


    @Override
    public PageInfo<Evaluation> getMiddleEvalList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Evaluation> middleEvalList = evaluationDao.getMiddleEvalList();
        PageInfo<Evaluation> pageInfo = new PageInfo<>(middleEvalList);
        return pageInfo;
    }

    @Override
    public PageInfo<Evaluation> getBadEvalList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Evaluation> badEvalList = evaluationDao.getBadEvalList();
        PageInfo<Evaluation> pageInfo = new PageInfo<>(badEvalList);
        return pageInfo;
    }

    @Override
    public PageInfo<Evaluation> getAllEvalList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Evaluation> allEvalList = evaluationDao.getAllEvalList();
        PageInfo<Evaluation> pageInfo = new PageInfo<>(allEvalList);
        return pageInfo;
    }

    @Override
    public PageInfo<Evaluation> searchListById(Integer pageNum, Integer project_id) {
        PageHelper.startPage(pageNum,10);
        List<Evaluation> evalList = evaluationDao.searchListById(project_id);
        PageInfo<Evaluation> pageInfo = new PageInfo<>(evalList);
        return pageInfo;
    }

    @Override
    public PageInfo<Evaluation> searchListByName(Integer pageNum, String customer_name, Integer project_id) {
        PageHelper.startPage(pageNum,10);
        List<Evaluation> evalList = evaluationDao.searchListByName(customer_name,project_id);
        PageInfo<Evaluation> pageInfo = new PageInfo<>(evalList);
        return pageInfo;
    }

    @Override
    public String[] getSomeContent(Integer projectId) {
        return evaluationDao.getSomeContent(projectId);
    }


}
