package com.hds.ssm.service.purchase.imp;

import com.hds.ssm.dao.PurchaseDao;
import com.hds.ssm.model.PurchaseRP;
import com.hds.ssm.service.purchase.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service(value = "PurchaseService")
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;
    @Override
    public List<PurchaseRP> getPurchaseMonth() {
        return purchaseDao.getPurchaseMonth();
    }
}
