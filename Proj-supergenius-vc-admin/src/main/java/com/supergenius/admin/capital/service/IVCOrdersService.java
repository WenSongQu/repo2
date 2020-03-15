package com.supergenius.admin.capital.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.model.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.supergenius.admin.capital.model.vo.*;
import com.supergenius.admin.enums.EOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zuoyu
 * @since 2019-12-04
 */
public interface IVCOrdersService extends IService<VCOrdersDO> {
    IPage<VCMemberOrderDisplayVO> selectMemberOrderDisplayDO(Page page, VCFiltrateOrderVO vcFiltrateVO);

    VCOrderinfoVO selectOrderInfo(String oid);

    Integer invoiceed(List<String> oids);

    List<VCInvoicePrintVO> getVCInvoicePrintDO(List<String> list);

    IPage<VCGuaranteeAndRecommendDisplayVO> selectVCGuaranteeDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO);

    IPage<VCGuaranteeAndRecommendDisplayVO> selectVCrecommendDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO);

    int returnOrder(List<String> oids);

    IPage<VCMeetingOrderDisplayVO> selectVCMeetingOrderDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO);

    VCMeetingOrderInfoVO selectVCMeetingOrderInfoDO(String oid);

    IPage<VCTrainactivityDisplayVO> selectVCTrainactivityOrderDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO);

    VCTrainactivityInfoVO selecTrainactivityOrderInfo(String oid);

    IPage<VCVideoVO> selectVCVideoVOOrderDisplayDO(Page page, @Param("map") VCFiltrateOrderVO vcFiltrateVO);

    VCVideoOrderInfoVO selectVideoOrderInfo(String oid);

    List<VCOrdersDO> selectOrdersByUseruid(String uid, Integer pageNum);

    IPage<VCRefundTradeInfoVO> getAllRefundTradeInfo(Page page, @Param("orderstatus") EOrder order );


}
