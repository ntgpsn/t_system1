package test.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import test.dao.model.CaseInfo;

import java.util.List;

/**
 * @Author zhaobinr
 * @Date 2018/7/13 11 18
 * @Description
 */

@Service
public class CaseInfoDaoService {

    @Autowired
    private MongoTemplate template;

    public void saveCase(CaseInfo caseInfo) {
        template.save(caseInfo);
    }

    public CaseInfo findCaseById(String id) {
        Criteria criteria = new Criteria();
        criteria.and("id").is(id);
        Query query = new Query(criteria);
        return template.findOne(query, CaseInfo.class);
    }

    public List<CaseInfo> findCaseByOrgId(String orgId) {
        Criteria criteria = new Criteria();
        criteria.and("orgId").is(orgId);
        Query query = new Query(criteria);
        return template.find(query, CaseInfo.class);
    }

    public List<CaseInfo> findCaseByProjectId(String projectId) {
        Criteria criteria = new Criteria();
        criteria.and("projectId").is(projectId);
        Query query = new Query(criteria);
        return template.find(query, CaseInfo.class);
    }

    public List<CaseInfo> findCaseByCreateUserIdAndProjectId(String userId, String projectId) {
        Criteria criteria = new Criteria();
        criteria.and("projectId").is(projectId);
        criteria.and("createUserId").is(userId);
        Query query = new Query(criteria);
        return template.find(query, CaseInfo.class);
    }

    public List<CaseInfo> findCaseByOperateUserId(String userId) {
        Criteria criteria = new Criteria();
        criteria.and("operateUserId").is(userId);
        Query query = new Query(criteria);
        return template.find(query, CaseInfo.class);
    }


    public List<CaseInfo> findAll() {
        return template.findAll(CaseInfo.class);
    }

}
