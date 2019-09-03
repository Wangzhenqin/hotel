package com.example.demo.web;

import com.example.demo.entity.roomType;
import com.example.demo.entity.rooms;
import com.example.demo.service.roomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhenqin on 2019/8/21.
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private roomsService roomsService;
    @RequestMapping(value = "/searchrooms",method = RequestMethod.GET)
    private Map<String,Object> searchRooms(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<roomType> list=roomsService.searchRooms();
        modelMap.put("roomslist",list);
        return modelMap;
    }
    @RequestMapping(value = "/checkinroom",method = RequestMethod.POST)
    private Map<String,Object> checkInRoom(@RequestBody rooms room, int days){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",roomsService.checkInRoom(room,days));
        return modelMap;
    }
    @RequestMapping(value = "/moredays",method = RequestMethod.GET)
    private Map<String,Object> moreDays(int rName,int pId,int days){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",roomsService.moreDays(rName,pId,days));
        return modelMap;
    }
    @RequestMapping(value = "/checkoutroom",method = RequestMethod.GET)
    private Map<String,Object> checkOutRoom(int rName,int pId){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",roomsService.checkOutRoom(rName,pId));
        return modelMap;
    }
}
