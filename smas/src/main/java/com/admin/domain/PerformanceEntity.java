package com.admin.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("performance")
public class PerformanceEntity implements Serializable {


	@TableId
	private int peid;

	private String emid;

	private String name;

	private String date;

	private String grade;

	private String note;


}
