package com.hanye.info.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hanye.info.model.mongo.GroceryItem;
import com.hanye.info.vo.GroceryItemVo;

public interface GroceryRepository extends MongoRepository<GroceryItem, String> {

    
}
