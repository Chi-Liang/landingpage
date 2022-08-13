package com.hanye.info.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.hanye.info.constant.RoleEnum;
import com.hanye.info.convert.BeanConverter;
import com.hanye.info.model.mysql.Role;
import com.hanye.info.model.mysql.User;
import com.hanye.info.repository.mysql.UserRepository;
import com.hanye.info.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	private static BeanCopier voToEntity = BeanCopier.create(UserVO.class, User.class, false);
	private static BeanCopier entityToVo = BeanCopier.create(User.class, UserVO.class, true);

	public List<UserVO> findAllExcludeAdmin() {
		
		var voList = userRepository.findAll().stream().filter(user -> !user.getUid().equals("admin"))
				.map(user -> {
					var vo = new UserVO();
					entityToVo.copy(user, vo, new BeanConverter());
					return vo;
				}).collect(Collectors.toList());
		
		return voList;
	}

	public UserVO findUser(String uid) {
		var user = userRepository.findById(uid).get();
		var userVO = new UserVO();
		entityToVo.copy(user, userVO, new BeanConverter());
		
		return userVO;
	}

	public void saveUser(UserVO userVO) {
		var user = new User();
		voToEntity.copy(userVO, user, null);
		user.setPwd(new BCryptPasswordEncoder().encode(user.getPwd()));
		user.getRoles().add(new Role(RoleEnum.ROLE_GENERAL.toString()));
		userRepository.save(user);
	}
	
	public void editUser(UserVO userVO) {
		var user = userRepository.findById(userVO.getUid()).get();
		user.setName(userVO.getName());
		userRepository.save(user);
	}
	
	public void changeUserPwd(UserVO userVO) {
		var user = userRepository.findById(userVO.getUid()).get();
		user.setPwd(new BCryptPasswordEncoder().encode(userVO.getPwd()));
		userRepository.save(user);
	}
	
	public void deleteUser(String uid) {
		userRepository.deleteById(uid);
	}
}
