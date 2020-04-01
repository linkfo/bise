package com.admin.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("overtime_leave")
public class OvertimeLeaveEntity implements Serializable {

	@TableId
	private String olid;

	private String emid;

	private String name;

	private String day;

	private String hourse;

	private String note;


}