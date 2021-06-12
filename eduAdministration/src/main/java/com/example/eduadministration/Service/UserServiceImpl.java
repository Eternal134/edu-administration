package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.SecurityRepository;
import com.example.eduadministration.Mapper.Security;
import com.example.eduadministration.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements BaseSqlService{

    private final SecurityRepository securityRepository;

    @Autowired
    public UserServiceImpl(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    /**
     * 验证输入的账号密码
     * @param user 账号密码
     */
    public BaseResponse verifyUser(Security user) {

        Optional<Security> userAccount = securityRepository.findById(user.getUserId());
        if(!userAccount.isPresent()) {
            // 如果查询结果为空
            return new BaseResponse("1", "账号不存在");
        } else if (!userAccount.get().getPassword().equals(user.getPassword())){
            // 如果密码不一致
            return new BaseResponse("1", "账号密码不正确");
        } else {
            return new BaseResponse("0", "");
        }
    }

    @Override
    public void addRecord(Object object) {
        securityRepository.save((Security) object);
    }
}
