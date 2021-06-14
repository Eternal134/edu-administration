package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.SecurityRepository;
import com.example.eduadministration.Exception.LoginException;
import com.example.eduadministration.Mapper.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements BaseService {

    private final SecurityRepository securityRepository;

    @Autowired
    public UserServiceImpl(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    /**
     * 验证输入的账号密码
     * @param user 账号密码
     */
    public void verifyUser(Security user) throws LoginException {

        Optional<Security> userAccount = securityRepository.findById(user.getUserId());
        if(!userAccount.isPresent()) {
            // 如果查询结果为空
            throw new LoginException("账号不存在");
        } else if (!userAccount.get().getPassword().equals(user.getPassword())){
            // 如果密码不一致
            throw new LoginException("账号密码不一致");
        }
    }

    @Override
    public void addRecord(Object object) {
        securityRepository.save((Security) object);
    }

    public List<Security> findAllUser() {
        List<Security> userList = new ArrayList<>();
        securityRepository.findAll().forEach(userList::add);
        return userList;
    }
}
