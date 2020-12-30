package com.yshyerp.adm.serviceImpl;

import com.yshyerp.adm.entity.tankc;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.mapper.TankcMapper;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.TankcService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class TankcImpl implements TankcService {
    @Resource
    private TankcMapper tankcMapper;

    @Override
    public Response getTankc(Request<tankc> req) {
        Resource resource = null;
        if (!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize())) {
            PageHelper.startPage(req.getPageNum(), req.getPageSize());
        }
        List<tankc> ListData = tankcMapper.getTankc(req.getData());
        return Response.success("查询成功", new PageInfo<>(ListData));
    }

    @Override
    public Response addTankc(tankc tankc) {
        return Response.success("添加成功", tankcMapper.addTankc(tankc));
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response dateleTankc(List<Integer> id) {
        Response response = null;
        try {
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), tankcMapper.dateleTankc(id));
        } catch (Exception e) {
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
            log.error("daleteOtherDict接口操作失败：{}", e.getMessage());
        }
        return response;
    }

    @Override
    public Response updateTankc(tankc tankc) {
        return Response.success("修改成功", tankcMapper.updateTankc(tankc));
    }

}
