package com.example.demo.service.impl;

import com.example.demo.dao.roomsDao;
import com.example.demo.entity.roomType;
import com.example.demo.entity.rooms;
import com.example.demo.service.roomsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wangzhenqin on 2019/7/30.
 */
@Service
public class roomsServiceImpl implements roomsService {
    private roomsDao roomsDao;
    public roomsServiceImpl(roomsDao roomsDao){
        this.roomsDao=roomsDao;
    }
    @Override
    public List<roomType> searchRooms() {
        return roomsDao.searchRooms();
    }
    @Transactional
    @Override
    public rooms checkInRoom(rooms room,int days) {
        if (room.getType()!=null&&!"".equals(room.getType())&&room.getpId()!=null&&!"".equals(room.getpId())){
            Date inDate=new Date();
            room.setInTime(inDate);
            Date outDate= (Date) inDate.clone();
            outDate.setTime(outDate.getTime()+60L * 60 * 24 * 1000 * days);
            room.setOutTime(outDate);
            try{
                int effectedNum=roomsDao.checkInRoom(room);
                if (effectedNum>0)
                    return roomsDao.queryRoom(room.getpId());
                else
                    throw new RuntimeException("入住失败:没有房间");
            }catch(Exception e){
                throw new RuntimeException("入住失败:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("不能为空");
        }
    }
    @Transactional
    @Override
    public boolean moreDays(int rName, int pId, int days) {
        try{
            if (roomsDao.moreDays(rName,pId,days)>0)
                return true;
            else throw new RuntimeException("续住失败:信息有误");
        }catch (Exception e){
            throw new RuntimeException("续住失败:"+e.getMessage());
        }
    }
    @Transactional
    @Override
    public boolean checkOutRoom(int rName, int pId) {
        try{
            if (roomsDao.checkOutRoom(rName,pId)>0)
                return true;
            else throw new RuntimeException("退房失败:信息有误");
        }catch (Exception e){
            throw new RuntimeException("退房失败:"+e.getMessage());
        }
    }
}
