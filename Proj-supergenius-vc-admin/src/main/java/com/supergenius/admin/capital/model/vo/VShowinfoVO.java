package com.supergenius.admin.capital.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.supergenius.admin.enums.StatusEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="项目展示的基本信息", description="")
public class VShowinfoVO {

    private String pid;
    private String pname;
    private String cname;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    private String area;
    private boolean videobuy;
    private Integer followcount;
    private Integer freezecount;
    private StatusEnum  status;

}
