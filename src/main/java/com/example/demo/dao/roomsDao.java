package com.example.demo.dao;

import com.example.demo.entity.roomType;

import java.util.List;

/**
 * Created by wangzhenqin on 2019/7/23.
 */
public interface roomsDao {
    //查询空房间
    List<roomType> searchRooms();
    //入住
    int checkInRoom(int type);
    //续住
    int moreDays(int days);
    //退房
    int checkOutRoom(String rName,String pName);
}
