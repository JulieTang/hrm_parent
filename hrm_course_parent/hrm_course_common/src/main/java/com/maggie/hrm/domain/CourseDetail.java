package com.maggie.hrm.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author MaggieTang
 * @since 2019-09-04
 */
@TableName("t_course_detail")
public class CourseDetail extends Model<CourseDetail> {

    private static final long serialVersionUID = 1L;

    @TableId("course_id")
    private Long courseId;
    /**
     * 课程描述
     */
    private String description;
    /**
     * 课程介绍
     */
    private String intro;


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    protected Serializable pkVal() {
        return this.courseId;
    }

    @Override
    public String toString() {
        return "CourseDetail{" +
        ", courseId=" + courseId +
        ", description=" + description +
        ", intro=" + intro +
        "}";
    }
}
