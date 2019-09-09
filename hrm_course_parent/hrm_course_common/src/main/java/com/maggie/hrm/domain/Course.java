package com.maggie.hrm.domain;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.ArrayList;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-04
 */
@TableName("t_course")
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 适用人群
     */
    private String users;
    /**
     * 课程大分类
     */
    @TableField("course_type_id")
    private Long courseTypeId;
    /**
     * 课程等级
     */
    private Long grade;
    /**
     * 课程状态
     */
    private Integer status;
    /**
     * 教育机构
     */
    @TableField("tenant_id")
    private Long tenantId;
    /**
     * 创建用户
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 课程有效期-开始时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 课程有效期-结束时间
     */
    @TableField("end_time")
    private Date endTime;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public Long getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Long courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Course{" +
        ", id=" + id +
        ", name=" + name +
        ", users=" + users +
        ", courseTypeId=" + courseTypeId +
        ", grade=" + grade +
        ", status=" + status +
        ", tenantId=" + tenantId +
        ", userId=" + userId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        "}";
    }
}
