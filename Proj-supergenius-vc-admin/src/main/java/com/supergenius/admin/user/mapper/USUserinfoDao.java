package com.supergenius.admin.user.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.supergenius.admin.user.model.USUserinfoDO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@DS(value = "master_user")
@Repository
public interface USUserinfoDao extends BaseMapper<USUserinfoDO> {

}
