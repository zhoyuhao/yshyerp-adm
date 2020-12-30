package com.yshyerp.adm.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.adm.entity.SerVice;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.mapper.SerViceMapper;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.ServiceService;
import com.yshyerp.adm.utils.DropDownBoxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ServiceImpl implements ServiceService {
    @Resource
    private SerViceMapper serViceMapper;

    @Override
    public Response qyery() {
        JSONObject jsonObject = new JSONObject();
        String strList = JSON.toJSONString(DropDownBoxUtils.toDropDownBoxJSON
                (serViceMapper.qyery())).replaceAll("\\s", "");
        jsonObject.put("lisType", JSON.parse(strList));
        return Response.success("查询成功", jsonObject);
    }

    @Override
    public Response getService(Request<SerVice> req) {
        Response response = null;
        if (!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize())) {
            PageHelper.startPage(req.getPageNum(), req.getPageSize());
        }
        List<SerVice> listData = serViceMapper.getService(req.getData().getServiceid(), req.getData().getName());
        return Response.success("查询成功", new PageInfo<>(listData));
    }

    @Override
    public Response addService(SerVice serVice) {

        return Response.success("添加成功", serViceMapper.addService(serVice));
    }

    @Override
    public Response updateservice(SerVice serVice) {
        return Response.success("修改成功", serViceMapper.updateById(serVice));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response deleteService(List<String> serviceid) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), serViceMapper.deleteService(serviceid));
        } catch (Exception e) {
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
            log.error("deleteService接口操作失败：{}", e.getMessage());
        }
        return response;

    }

    @Override
    public Response getDropDownInit() {
        JSONObject jsonObjec = new JSONObject();
        jsonObjec.put("isNotTypeList", DropDownBoxUtils.toDropDownBoxJSON(MessageEnum.getStatucMap()));
        jsonObjec.put("nameTypeList", DropDownBoxUtils.toDropDownBoxJSON(serViceMapper.selectDropDownBox()));
        return Response.success(MessageEnum.SELECT_SUCCESS.getVal(),jsonObjec);
    }
}
