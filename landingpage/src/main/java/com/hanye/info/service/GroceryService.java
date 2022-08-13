package com.hanye.info.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.hanye.info.constant.RoleEnum;
import com.hanye.info.convert.BeanConverter;
import com.hanye.info.model.mongo.GroceryItem;
import com.hanye.info.model.mysql.Role;
import com.hanye.info.model.mysql.User;
import com.hanye.info.repository.mongo.GroceryRepository;
import com.hanye.info.repository.mysql.UserRepository;
import com.hanye.info.vo.GroceryItemVo;
import com.hanye.info.vo.UserVo;

@Service
public class GroceryService {

	@Autowired
	private GroceryRepository groceryRepository;
	
	private static BeanCopier voToEntity = BeanCopier.create(GroceryItemVo.class, GroceryItem.class, false);
	private static BeanCopier entityToVo = BeanCopier.create(GroceryItem.class, GroceryItemVo.class, true);

	public List<GroceryItemVo> findAllGroceryItem() {
		
		List<GroceryItemVo> voList = groceryRepository.findAll().stream().map( grocery -> {
			var vo = new GroceryItemVo();
			entityToVo.copy(grocery, vo, new BeanConverter());
			return vo;
		}).collect(Collectors.toList());
		return voList;
	}

	public GroceryItemVo findGroceryItem(String id) {
		var groceryItem = groceryRepository.findById(id).get();
		var groceryItemVO = new GroceryItemVo();
		entityToVo.copy(groceryItem, groceryItemVO, new BeanConverter());
		return groceryItemVO;
	}

	public void saveGroceryItem(GroceryItemVo groceryItemVo) {
		var groceryItem = new GroceryItem();
		voToEntity.copy(groceryItemVo, groceryItem, null);
		groceryRepository.save(groceryItem);
	}
	
	public void editGroceryItem(GroceryItemVo groceryItemVo) {
		var groceryItem = new GroceryItem();
		voToEntity.copy(groceryItemVo, groceryItem, null);
		groceryRepository.save(groceryItem);
	}
	
	public void deleteGroceryItem(String id) {
		groceryRepository.deleteById(id);
	}
}
