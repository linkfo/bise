package com.admin.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@TableName("attendance")
public class AttendanceEntity implements Serializable {

	@TableId
	private String atid;

	private String emid;

	private String name;

	private String day;

	private String am;

	private String pm;

	private String note;


}
