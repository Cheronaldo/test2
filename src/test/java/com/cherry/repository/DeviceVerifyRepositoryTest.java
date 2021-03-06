package com.cherry.repository;

import com.cherry.domain.DeviceVerify;
import com.cherry.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceVerifyRepositoryTest {

   @Autowired
   private DeviceVerifyRepository deviceVerifyRepository;

    @Test
    public void addTest(){
        DeviceVerify deviceVerify = new DeviceVerify();
        deviceVerify.setId(KeyUtil.genUniqueKey());
        deviceVerify.setSnCode(KeyUtil.genUniqueKey());
        deviceVerify.setRegCode("f4r5b3");
        deviceVerify.setGenTime("Mon Oct 25 09:45:42 2017");

        DeviceVerify result = deviceVerifyRepository.save(deviceVerify);
        Assert.assertNotNull(result);
    }


    @Test
    public void findLatestBySnCode() throws Exception {

        DeviceVerify result = deviceVerifyRepository.findLatestBySnCode("1508895952275871545");
        Assert.assertNotNull(result);


    }

}