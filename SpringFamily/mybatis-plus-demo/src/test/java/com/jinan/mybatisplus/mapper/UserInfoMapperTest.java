package com.jinan.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import com.jinan.mybatisplus.model.UserInfo;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void testSelectById() {
        UserInfo userInfo = userInfoMapper.selectById(2);
        log.info("结果: "+userInfo);
    }

    @Test
    void testInsert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(5);
        userInfo.setUsername("赵六");
        userInfo.setPassword("zhaoliu");
        userInfo.setAge(18);
        userInfo.setGender(1);
        int result = userInfoMapper.insert(userInfo);
        log.info("影响行数: "+ result);
    }

    @Test
    void testUpdate() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("李四");
        userInfoMapper.updateById(userInfo);
    }

    @Test
    void testInsert2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("王五");
        userInfo.setPassword("66666666");
        userInfo.setAge(18);
        userInfo.setGender(1);
        int result = userInfoMapper.insert(userInfo);
        log.info("影响行数: "+ result);
    }

    //查询
    //sql:SELECT id,username,password,age FROM user_info WHERE age = 18 AND username like "%min%"
    @Test
    void testQueryWrapper() {
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<UserInfo>();
        userInfoQueryWrapper.select("id","username","password","age")
                .eq("age",18).like("username","min");
        List<UserInfo> userInfos = userInfoMapper.selectList(userInfoQueryWrapper);
        System.out.println(userInfos);
    }

    //删除
    //sql:DELETE FROM user_info WHERE age = 17
    @Test
    void testDeleteWrapper() {
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<UserInfo>();
        userInfoQueryWrapper.select().eq("age",17);
        userInfoMapper.delete(userInfoQueryWrapper);
    }

    //更新
    //sql:UPDATE user_info SET delete_flag=0, age=5 WHERE id IN (1,2,3)
    @Test
    void testUpdateWrapper() {
        UpdateWrapper<UserInfo> userInfoUpdateWrapper = new UpdateWrapper<UserInfo>()
                .set("delete_flag",1)
                .set("age",5)
                .in("id",1,3,4);
        userInfoMapper.update(userInfoUpdateWrapper);
    }

    //LambdaQueryWrapper查询
    @Test
    void testLambdaQueryWrapper() {
        LambdaQueryWrapper<UserInfo> userInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userInfoLambdaQueryWrapper.select(UserInfo::getId,UserInfo::getUsername,UserInfo::getPassword,UserInfo::getAge)
                .eq(UserInfo::getAge,18).like(UserInfo::getUsername,"min");
        List<UserInfo> userInfos = userInfoMapper.selectList(userInfoLambdaQueryWrapper);
        System.out.println(userInfos);
    }


    //LambdaUpdateWrapper更新
    @Test
    void testLambdaUpdateWrapper() {
        LambdaUpdateWrapper<UserInfo> userInfoLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        userInfoLambdaUpdateWrapper.set(UserInfo::getDeleteFlag,0)
                .set(UserInfo::getAge,5)
                .in(UserInfo::getId,1,5);

        int result = userInfoMapper.update(userInfoLambdaUpdateWrapper);
        log.info("影响行数 "+result);
    }

    @Test
    void queryUserInfoList() {
        List<UserInfo> userInfos = userInfoMapper.queryUserInfoList(5,"min");
        System.out.println(userInfos);
    }


    @Test
    void queryUserInfoLIst2() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age",5)
                .like("username","min");
        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        System.out.println(userInfos);
    }

    @Test
    void queryUserInfoList3() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>()
                .eq("username","admin");
        userInfoMapper.queryUserInfoList3(queryWrapper).forEach(System.out::println);
    }

    @Test
    void updateUserInfo() {
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("id",List.of(1,3,4));
        userInfoMapper.updateUserInfo(10,updateWrapper);
    }
}