package com.yshyerp.adm.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.adm.mapper.VesselMapper;
import com.yshyerp.adm.entity.Vessel;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.service.VesselService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yinsongjia
 * @Data: 2020/11/3
 * @Description: VesselImpl
 */
@Service
public class VesselImpl implements VesselService {
    @Resource
    private VesselMapper vesselMapper;

    @Override
    public Response getVessel(Request<Vessel> req) {
        Resource resource = null;
        if (!StringUtils.isEmpty(req.getPageNum()) && !StringUtils.isEmpty(req.getPageSize())) {
            PageHelper.startPage(req.getPageNum(), req.getPageSize());
        }
        QueryWrapper<Vessel> qw = Wrappers.query();

        if (!StringUtils.isEmpty(req.getData().getVessel())) qw.eq("vessel", req.getData().getVessel());
        if (!StringUtils.isEmpty(req.getData().getDesc())) qw.eq("[desc]", req.getData().getDesc());
        List<Vessel> list = vesselMapper.selectList(qw);
        if(list!=null && list.size()!=0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setKey(1+i);
            }
        }
        return Response.success("查询成功", new PageInfo(list));
    }

    @Override
    public Response addVessel(Vessel vessel) {
        return Response.success("添加成功", vesselMapper.insert(vessel));
    }

    @Override
    public Response deleteVessel(List<String> list) {

        return Response.success("删除成功", vesselMapper.deleteVessel(list));
    }

    @Override
    public Response update(Vessel vessel) {
        return Response.success("修改成功", vesselMapper.updateById(vessel));
    }
}
