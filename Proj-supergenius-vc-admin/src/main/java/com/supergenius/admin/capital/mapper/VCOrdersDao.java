package com.supergenius.admin.capital.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.*;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.enums.EOrder;
import com.supergenius.admin.enums.EOrderType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
@DS(value = "master_capital")
@Repository
public interface VCOrdersDao extends BaseMapper<VCOrdersDO> {
    //  IPage<VCMemberOrderDisplayDO> selectGuaranteeDisplayDO(Page page, @Param("map") Map<String, Object> map);
    //会员订单
    IPage<VCMemberOrderDisplayVO> selectMemberOrderDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO, @Param("type") EOrderType type);

    VCOrderinfoVO selectOrderInfo(String oid);

    VCTrainactivityInfoVO selecTrainactivityOrderInfo(String oid);

    //
    IPage<VCGuaranteeAndRecommendDisplayVO> selectVCGuaranteeDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO,@Param("type") EOrderType type);

    IPage<VCGuaranteeAndRecommendDisplayVO> selectVCrecommendDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO,@Param("type") EOrderType type);

    IPage<VCMeetingOrderDisplayVO> selectVCMeetingOrderDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO,@Param("type") EOrderType type);

    VCMeetingOrderInfoVO selectVCMeetingOrderInfoDO(String oid);

    Integer invoice(@Param("oids") List<String> oids);

    List<VCInvoicePrintVO> getVCInvoicePrintDO(List<String> list);

    int returnOrder(@Param("oids") List<String> oids);

    IPage<VCTrainactivityDisplayVO> selectVCTrainactivityOrderDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO,@Param("type") EOrderType type);

    IPage<VCVideoVO> selectVCVideoVOOrderDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO,@Param("type") EOrderType type);

    VCVideoOrderInfoVO selectVideoOrderInfo(String oid);

    //获取退款
    IPage<VCRefundTradeInfoVO> getAllRefundTradeInfo(Page page, @Param("orderstatus") EOrder order );


}
