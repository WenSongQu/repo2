package com.supergenius.admin.capital.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supergenius.admin.capital.mapper.VCContentDao;
import com.supergenius.admin.capital.mapper.VCOrdersDao;
import com.supergenius.admin.capital.mapper.VCProjectDao;
import com.supergenius.admin.capital.mapper.VCUserinfoDao;
import com.supergenius.admin.capital.model.VCContentDO;
import com.supergenius.admin.capital.model.vo.VCImageUploadVO;
import com.supergenius.admin.capital.model.vo.VCInvoicePrintVO;
import com.supergenius.admin.capital.model.vo.VCMemberOrderDisplayVO;
import com.supergenius.admin.capital.model.vo.VCRefundTradeInfoVO;
import com.supergenius.admin.capital.service.IVCContentService;
import com.supergenius.admin.capital.service.IVCProjectService;
import com.supergenius.admin.capital.service.IVCUserService;
import com.supergenius.admin.constants.Consts;
import com.supergenius.admin.constants.SysConst;
import com.supergenius.admin.enums.*;
import com.supergenius.admin.utils.DownFile;
import com.supergenius.admin.utils.FileUtil;
import com.supergenius.admin.utils.ImgUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
//import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {
    @Autowired
    IVCProjectService ivcProjectService;
    @Autowired
    VCProjectDao vcProjectDao;
    @Autowired
    VCOrdersDao vcOrdersDao;
    @Autowired
    IVCUserService ivcUserService;
    @Autowired
    VCUserinfoDao vcUserDao;
    @Autowired
    VCContentDao vcContentDao;
    @Autowired
    IVCContentService contentService;


    @RequestMapping("/projectPage")
    public Object selectAllProjectByPage(HttpServletResponse response, @RequestParam(required = false, defaultValue = "1") Integer pageNum, @RequestParam(required = false, defaultValue = "9") Integer pageCount, @RequestParam(required = false)Map<String,Object>map1 ) {
       // vcOrdersDao.invoice(Arrays.asList("2526249dfe294eeb8fd749928658712d","3526223dfe294eeb8fd71149928658712d"));
      //  List<VCInvoicePrintVO> vcInvoicePrintDO = vcOrdersDao.getVCInvoicePrintDO(Arrays.asList("2526249dfe294eeb8fd749928658712d"));
       // map1.put("ordercode","o20190101");
        map1.put("endtime","2019-1-1");
       // map1.put("begintime","2019-1-1");
      //  map1.put("site","2");
       // System.out.println(map1);
       // IPage<VCMemberOrderDisplayVO> vcMemberOrderDisplayVOIPage = vcOrdersDao.selectMemberOrderDisplayDO(new Page(pageNum, pageCount), map1);
        DownFile.downZip("aaaa","C:\\Users\\20930\\Documents\\Tencent Files\\2093007810\\FileRecv\\虎哥\\abc.txt",response);


        return  "下载完成";

    }

    @PostMapping("/test")
    public String upload(@RequestParam(value = "file", required = true) MultipartFile file){
        if(file.isEmpty()){
            return "null";
        }
        String fileName=file.getOriginalFilename();
        String filePath="D:\\file\\";
        File file1=new File(filePath+fileName);
        try {
            file.transferTo(file1);
            return "上传成g";
        } catch (IOException e) {

            e.printStackTrace();
            return "上传shibai1";
        }
    }

    @PostMapping("/testwwwwwwww1")
    public String upload2(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException{
       // EUpload eUpload = FileUtil.uploadPic(file, "G:\\images", 100, 200);
       // VCImageUploadVO vcImageUploadVO = FileUtil.uploadPic(file, "D:\\images\\", 20, 20);
     //   System.out.println(vcImageUploadVO.getStatus().toString());
        String s = ImgUtil.resizeImage(100, 200, "D:\\Images\\63b3a0901322958e3fef806d76bf5555.png");
        return s;

    }
    @GetMapping("/test3")
    public String test3(){
        VCContentDO vcContentDO = new VCContentDO();
        vcContentDO.setSide(ESide.venture);
        vcContentDO.setType(EContentType.incubator);
        vcContentDao.insert(vcContentDO);
        return "success";
    }
    @GetMapping("/test4")
    public Integer test(){
        contentService.upOrder(ESide.capital, EContentType.index);
        return 1;
    }
    @GetMapping("/test5")
    public Integer test23(EForm form){
      // contentService.upOrder(ESide.capital, EContentType.index);
        System.out.println(form.getValue());
        return 1;
    }
    @GetMapping("/test6")
    public Integer test231(String form){
        // contentService.upOrder(ESide.capital, EContentType.index);
        System.out.println(form);

        return 1;
    }
    @GetMapping("/test7")
    public String test5(){
        IPage<VCRefundTradeInfoVO> allRefundTradeInfo = vcOrdersDao.getAllRefundTradeInfo(new Page(10, 10), EOrder.pendingrefund);
        allRefundTradeInfo.getRecords().forEach(System.out::println);
        return "ss";
    }
    @PostMapping("/test2")
    public List<Integer> testss(@RequestParam("ids") Integer...id){
        return Arrays.asList(id);
    }




}
