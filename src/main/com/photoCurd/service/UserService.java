package photoCurd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photoCurd.bean.User;
import photoCurd.bean.UserExample;
import photoCurd.dao.UserMapper;

import java.util.List;


/**
 * @author lixuefeng
 * @date 2021-08-21 22:53
 * @description:
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean checkLogin(String email,String password){
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email).andPasswordEqualTo(password);
        return userMapper.countByExample(userExample)>=1;
    }

    public void addUser(User user) {

        userMapper.insert(user);
    }

    public void deleteUser(Integer id) {

        userMapper.deleteByPrimaryKey(id);
    }

    public void updateUser(User user) {

        userMapper.updateByPrimaryKey(user);
    }

    public List<User> getAll() {
        return userMapper.selectByExample(null);
    }

    public User getUserByEmail(String email) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> list=userMapper.selectByExample(example);
        if(list==null||list.size()==0){
            return null;
        }else{
            return userMapper.selectByExample(example).get(0);
        }
    }
}
