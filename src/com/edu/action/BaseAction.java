package com.edu.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.edu.model.User;
import com.edu.service.ArticleService;
import com.edu.service.BookService;
import com.edu.service.CetService;
import com.edu.service.ClassCourseService;
import com.edu.service.ClsInfoService;
import com.edu.service.ComputerService;
import com.edu.service.CourseService;
import com.edu.service.ExamService;
import com.edu.service.MessageService;
import com.edu.service.ResourceService;
import com.edu.service.RoomService;
import com.edu.service.ScheduleService;
import com.edu.service.ScoreService;
import com.edu.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class BaseAction extends ActionSupport implements SessionAware {

    @Resource(name = "userService")
    protected UserService userService;

    @Resource(name = "bookService")
    protected BookService bookService;

    @Resource(name = "cetService")
    protected CetService cetService;

    @Resource(name = "classCourseService")
    protected ClassCourseService classCourseService;

    @Resource(name = "clsInfoService")
    protected ClsInfoService clsInfoService;

    @Resource(name = "computerService")
    protected ComputerService computerService;

    @Resource(name = "courseService")
    protected CourseService courseService;

    @Resource(name = "examService")
    protected ExamService examService;

    @Resource(name = "roomService")
    protected RoomService roomService;

    @Resource(name = "scheduleService")
    protected ScheduleService scheduleService;

    @Resource(name = "scoreService")
    protected ScoreService scoreService;
    
    @Resource(name = "resourceService")
    protected ResourceService resourceService;
    
    @Resource(name = "messageService")
    protected MessageService messageService;
    
    @Resource(name = "articleService")
    protected ArticleService articleService;

    //���õ�ҳ�����
    protected User user;

    protected User loginUser;

    protected String msg = "";
    
    protected String value;

    protected Integer id;

    protected int page;

    protected int rows = 20;

    protected Map<String, Object> session;

    protected ValueStack getValueStack() {
        return ActionContext.getContext().getValueStack();
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(msg.getBytes());
    }

    /**
     * ����  user
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * ���� user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * ����  msg
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * ���� msg
     * @param msg msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * ����  id
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ���� id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ����  loginUser
     * @return loginUser
     */
    public User getLoginUser() {
        return loginUser;
    }

    /**
     * ���� loginUser
     * @param loginUser loginUser
     */
    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * ����  page
     * @return page
     */
    public int getPage() {
        return page;
    }

    /**
     * ���� page
     * @param page page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * ����  rows
     * @return rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * ���� rows
     * @param rows rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * ����  value
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * ���� value
     * @param value value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
