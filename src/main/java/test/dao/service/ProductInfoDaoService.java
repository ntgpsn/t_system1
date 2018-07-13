package test.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import test.dao.model.ProductInfo;

import java.util.List;

/**
 * @Author zhaobinr
 * @Date 2018/7/13 11 27
 * @Description
 */
@Service
public class ProductInfoDaoService {

    @Autowired
    private MongoTemplate template;

    public void save(ProductInfo productInfo) {
        template.save(productInfo);
    }

    public ProductInfo findById(String id) {
        Criteria criteria = new Criteria();
        criteria.and("id").is(id);
        Query query = new Query(criteria);
        return template.findOne(query, ProductInfo.class);
    }

    public List<ProductInfo> findAll() {
        return template.findAll(ProductInfo.class);
    }
}
