package com.example.demo.service;

import com.example.demo.entity.roomType;
import com.example.demo.entity.rooms;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangzhenqin on 2019/7/30.
 */
public interface roomsService {
    //查询空房间
    List<roomType> searchRooms();
    //入住
    rooms checkInRoom(rooms room,int days);
    //续住
    boolean moreDays(int rName,int pId,int days);
    //退房
    boolean checkOutRoom(int rName,int pId);
}
