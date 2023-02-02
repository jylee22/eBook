package com.ebook.user.service;


import com.ebook.user.dao.UsersDAO;
import com.ebook.user.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    UsersDAO usersDAO;

    //    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public void register(UsersVO usersVO) throws Exception {
//        String rawPassword = usersVO.getUserPass();
//        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
//        usersVO.setUserPass(encPassword);
        usersDAO.register(usersVO);
    }

    @Override
    public UsersVO login(UsersVO usersVO) throws Exception {

        return usersDAO.login(usersVO);
    }

    @Override
    public void update(UsersVO usersVO) throws Exception {
        usersDAO.update(usersVO);
    }

    @Override
    public void delete(UsersVO usersVO) throws Exception {
        usersDAO.delete(usersVO);
    }

    @Override
    public int idcheck(UsersVO usersVO) throws Exception {
        return usersDAO.idcheck(usersVO);
    }


}
