package test.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import test.dao.model.ProjectInfo;

import java.util.List;

/**
 * @Author zhaobinr
 * @Date 2018/7/13 12 02
 * @Description
 */
@Service
public class ProjectInfoDaoService {
    @Autowired
    private MongoTemplate template;

    public void save(ProjectInfo projectInfo) {
        template.save(projectInfo);
    }

    public ProjectInfo findById(String id) {
        Criteria criteria = new Criteria();
        if (id.contains(",")) {
            criteria.and("id").in(id.split(","));
        }else {
            criteria.and("id").is(id);
        }
        Query query = new Query(criteria);
        return template.findOne(query, ProjectInfo.class);
    }

    public List<ProjectInfo> findAllByOrgId(String orgId) {
        Criteria criteria = new Criteria();
        criteria.and("orgId").is(orgId);
        Query query = new Query(criteria);
        return template.find(query, ProjectInfo.class);
    }

    public List<ProjectInfo> findAll() {
        return template.findAll(ProjectInfo.class);
    }
}
