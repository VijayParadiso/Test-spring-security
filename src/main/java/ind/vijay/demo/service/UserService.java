package ind.vijay.demo.service;

import com.alibaba.fastjson.JSON;
import ind.vijay.demo.bean.Role;
import ind.vijay.demo.bean.User;
import ind.vijay.demo.dao.RoleMapper;
import ind.vijay.demo.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userMapper.selectByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(new String(String.format("%s 用户名不对!", s)));
        }

        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;

        //装载权限到 grantedAuthorities
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        org.springframework.security.core.userdetails.User authUser =
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(), user.getPassword(),
                        enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities
                );

//        log.info("authUser: " + JSON.toJSONString(authUser));

        user.setUser(authUser);

//        log.info("user: " + JSON.toJSONString(user));

        return user;
    }
}
