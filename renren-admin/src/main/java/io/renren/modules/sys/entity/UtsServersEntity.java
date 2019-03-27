package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author will
 * @email goaskwill@163.com
 * @date 2019-03-26 08:41:37
 */
@Data
@TableName("uts_servers")
public class UtsServersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 项目id，每个项目有自己的定价
	 */
	private Long projectId;
	/**
	 * 工单服务的编号
	 */
	private String serverCode;
	/**
	 * 消耗的物料编码。后期对接ERP内物料编号
	 */
	private String goodsCode;
	/**
	 * 服务的名称
	 */
	private String serverName;
	/**
	 * 单位描述
	 */
	private String unit;
	/**
	 * 单价
	 */
	private BigDecimal price;
	/**
	 * 备注信息
	 */
	private String remark;
	/**
	 * 0. 禁用 1.启用
	 */
	private Integer state;
	/**
	 * 数据创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 数据更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date modifyTime;
	/**
	 * 创建人id
	 */
	private Long creatorId;
	/**
	 * 修改人id
	 */
	private Long modifierId;

}
