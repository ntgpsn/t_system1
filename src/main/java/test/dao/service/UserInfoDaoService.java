package test.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import test.dao.model.UserInfo;

import java.util.List;

/**
 * @Author zhaobinr
 * @Date 2018/7/13 11 08
 * @Description
 */
@Service
public class UserInfoDaoService {
    @Autowired
    private MongoTemplate template;

    /**
     * 添加或更新用户信息
     * @param userInfo
     */
    public void save(UserInfo userInfo) {
        template.save(userInfo);
    }

    public void deleteUser(UserInfo userInfo) {

        template.remove(userInfo);
    }

    /**
     * 根据Id查找用户
     * @param id
     * @return
     */
    public UserInfo findById(String id) {
        Criteria criteria = new Criteria();
        criteria.and("userId").is(id);
        Query query = new Query(criteria);
        return template.findOne(query, UserInfo.class);
    }

    /**
     * 根据账号查找用户
     * @param userAccount
     * @return
     */
    public UserInfo findByAccount(String userAccount) {
        Criteria criteria = new Criteria();
        criteria.and("userAccount").is(userAccount);
        Query query = new Query(criteria);
        return template.findOne(query, UserInfo.class);
    }


    public List<UserInfo> findAll() {
        return template.findAll(UserInfo.class);
    }
}
