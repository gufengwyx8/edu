/*
 * @(#)ClsInfoAction.java 2014-2-15 ����01:37:34 Edu
 */
package com.edu.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.edu.model.ClsInfo;
import com.edu.model.Room;
import com.edu.model.User;
import com.edu.model.UserType;

/**
 * ClsInfoAction
 * @author wang
 * @version 1.0
 *
 */
@Component("clsInfoAction")
@Scope("prototype")
public class ClsInfoAction extends BaseAction {
    private List<ClsInfo> clsInfoList;

    private ClsInfo clsInfo;

    private List<User> teacherList;

    private List<Room> roomList;

    private Room room;

    public String listClsInfo() {
        teacherList = userService.list(UserType.TEACHER);
        clsInfoList = clsInfoService.list();
        return SUCCESS;
    }

    public String saveClsInfo() {
        clsInfoList = clsInfoService.list();
        for (ClsInfo cls : clsInfoList) {
            if (!cls.getId().equals(clsInfo.getId())
                    && cls.getName().equals(clsInfo.getName())) {
                msg = "error";
                return SUCCESS;
            }
        }
        clsInfoService.saveOrUpdate(clsInfo);
        msg = "success";
        return SUCCESS;
    }

    public String destoryClsInfo() {
        clsInfoService.delete(clsInfo);
        return SUCCESS;
    }

    public String listRoom() {
        roomList = roomService.list();
        return SUCCESS;
    }

    public String saveRoom() {
        roomList = roomService.list();
        for (Room r : roomList) {
            if (!r.getId().equals(room.getId())
                    && r.getName().equals(room.getName())
                    && r.getMain().equals(room.getMain())) {
                msg = "error";
                return SUCCESS;
            }
        }
        roomService.saveOrUpdate(room);
        msg = "success";
        return SUCCESS;
    }

    public String destoryRoom() {
        roomService.delete(room);
        return SUCCESS;
    }

    /**
     * ����  clsInfoList
     * @return clsInfoList
     */
    public List<ClsInfo> getClsInfoList() {
        return clsInfoList;
    }

    /**
     * ���� clsInfoList
     * @param clsInfoList clsInfoList
     */
    public void setClsInfoList(List<ClsInfo> clsInfoList) {
        this.clsInfoList = clsInfoList;
    }

    /**
     * ����  clsInfo
     * @return clsInfo
     */
    public ClsInfo getClsInfo() {
        return clsInfo;
    }

    /**
     * ���� clsInfo
     * @param clsInfo clsInfo
     */
    public void setClsInfo(ClsInfo clsInfo) {
        this.clsInfo = clsInfo;
    }

    /**
     * ����  teacherList
     * @return teacherList
     */
    public List<User> getTeacherList() {
        return teacherList;
    }

    /**
     * ���� teacherList
     * @param teacherList teacherList
     */
    public void setTeacherList(List<User> teacherList) {
        this.teacherList = teacherList;
    }

    /**
     * ����  roomList
     * @return roomList
     */
    public List<Room> getRoomList() {
        return roomList;
    }

    /**
     * ���� roomList
     * @param roomList roomList
     */
    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    /**
     * ����  room
     * @return room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * ���� room
     * @param room room
     */
    public void setRoom(Room room) {
        this.room = room;
    }
}
