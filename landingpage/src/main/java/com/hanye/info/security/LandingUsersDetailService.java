package com.hanye.info.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.hanye.info.model.mysql.Role;
import com.hanye.info.repository.mysql.UserRepository;

@Component
public class LandingUsersDetailService implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.hanye.info.model.mysql.User user = userRepository.findByUid(username);
		return new User(user.getName(), user.getPwd(), genAuthority(user.getRoles()));
	}
	
    private List<GrantedAuthority> genAuthority(Set<Role> roles) {
    	List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
    	for(Role role:roles) {
    		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRid());
    		authorityList.add(authority);
    	}
    	
    	return authorityList;
    }

}
