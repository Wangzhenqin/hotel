package com.example.demo.dao;

import com.example.demo.entity.roomType;
import com.example.demo.entity.rooms;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wangzhenqin on 2019/7/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class roomsDaoTest {
    @Autowired
    private roomsDao roomsDao;
    @Test
    public void searchRooms() throws Exception {
        List<roomType> list=roomsDao.searchRooms();
        assertEquals(3,list.size());
    }
    @Test
    public void checkInRoom() throws Exception {
        rooms room=new rooms();
        Date date =new Date();
        room.setInTime(date);
        Date outDate= (Date) date.clone();
        outDate.setTime(outDate.getTime()+60 * 60 * 24 * 1000 * 10L);
        room.setOutTime(outDate);
        room.setpId(1);
        room.setType(1);
        assertEquals(1,roomsDao.checkInRoom(room));
    }
    @Test
    public void moreDays() throws Exception {
        assertEquals(1,roomsDao.moreDays(203,1,10));
    }
    @Test
    public void checkOutRoom() throws Exception {
        assertEquals(1,roomsDao.checkOutRoom(203,1));
    }

}