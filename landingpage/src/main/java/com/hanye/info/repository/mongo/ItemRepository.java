package com.hanye.info.repository.mongo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.hanye.info.model.mongo.GroceryItem;

public interface ItemRepository extends MongoRepository<GroceryItem, String> {
    
    @Query("{name:'?0'}")
    public GroceryItem findItemByName(String name);
    
    @Query(value="{category:'?0'}", fields="{'name' : 0  }")
    public List<GroceryItem> findAll(String category);
    
    public long count();

}
