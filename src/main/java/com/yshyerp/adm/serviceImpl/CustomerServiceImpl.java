package com.yshyerp.adm.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yshyerp.adm.entity.CusEmail;
import com.yshyerp.adm.entity.CustomerEntity;
import com.yshyerp.adm.entity.vo.CustomerVO;
import com.yshyerp.adm.enums.MessageEnum;
import com.yshyerp.adm.mapper.CusEmailMapper;
import com.yshyerp.adm.mapper.CustomerMapper;
import com.yshyerp.adm.request.Request;
import com.yshyerp.adm.response.Response;
import com.yshyerp.adm.response.dto.CustomerDTO;
import com.yshyerp.adm.service.ICustomerService;
import com.yshyerp.adm.utils.BeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhoyuhao
 * @Data: 2020-11-03
 * @Description: 公司 ServiceImpl
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class CustomerServiceImpl implements ICustomerService {


    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CusEmailMapper cusEmailMapper;

    /**
     * 查看所有公司信息 (支持分页、条件)
     *
     * @param request
     * @return
     */
    @Override
    public Response queryCustomerAll(Request<CustomerEntity> request) {

        Response response = null;
        //判断是否分页 否则查看所有

        try {
            //执行查询SQL操作
            if (!StringUtils.isEmpty(request) && !StringUtils.isEmpty(request.getPageNum()) && !StringUtils.isEmpty(request.getPageSize()))
                PageHelper.startPage(request.getPageNum(), request.getPageSize());
            List<CustomerVO> listData = customerMapper.queryCustomerAll(request.getData());
            List<CustomerDTO> listData2 = this.setListDTO(listData);
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo(listData2));
        } catch (Exception e) {
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("queryCustomerAll接口操作失败：{}", e.getMessage());
        }
        return response;
    }


    /**
     * 修改公司信息
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response updateCustomer(Request<CustomerVO> request) {
        Response response = null;
        try {
            //执行查询SQL操作
            CustomerEntity cus = BeanMapper.map(request.getData(),CustomerEntity.class);
            if(StringUtils.isEmpty(cus.getCustomer())) return  Response.error("Customer不能为空！");
            customerMapper.updateById(cus);
            CustomerVO customerVO =JSON.parseObject(JSON.toJSONString(request.getData()),CustomerVO.class);
            customerMapper.updateEmail(customerVO);
            response = Response.success(MessageEnum.UPDATE_SUCCESS.getVal(),1 );
        } catch (Exception e) {
            response = Response.error(MessageEnum.UPDATE_ERROR.getVal());
            log.error("updateCustomer接口操作失败：{}", e.getMessage());
            throw  new RuntimeException(e);
        }
        return response;
    }


    /**
     * 删除公司
     *
     * @param customer
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response deleteCustomer(Request customer) {

        Response response = null;
        try {
            //执行查询SQL操作
            List<String> stringList = JSON.parseArray(JSON.toJSONString(customer.getData()), String.class);
            response = Response.success(MessageEnum.DELETE_SUCCESS.getVal(), customerMapper.updateByCustomer(stringList));
        } catch (Exception e) {
            response = Response.error(MessageEnum.DELETE_ERROR.getVal());
            log.error("deleteCustomer接口操作失败：{}", e.getMessage());
        }
        return response;
    }


    /**
     * 查看指定公司 (条件：customer)
     *
     * @param request
     * @return
     */
    @Override
    public Response queryByCustomer(String request) {
        Response response = null;
        try {
            //执行查询SQL操作
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setCustomer(request);
            List<CustomerVO> listData = customerMapper.queryCustomerAll(customerEntity);
            List<CustomerDTO> listData2 = this.setListDTO(listData);
            response = Response.success(MessageEnum.SELECT_SUCCESS.getVal(), new PageInfo(listData2));
        } catch (Exception e) {
            response = Response.error(MessageEnum.SELECT_ERROR.getVal());
            log.error("queryByCustomer接口操作失败：{}", e.getMessage());
        }
        return response;
    }


    /**
     * 添加公司信息
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public Response insertCustomer(Request<CustomerVO> request) {
        Response response = null;
        try {
            //执行查询SQL操作
            if (!StringUtils.isEmpty(request.getData())) {
                //映射主表信息数据
                CustomerEntity customerEntity = BeanMapper.map(request.getData(),CustomerEntity.class);
                //映射详表数据(customer,d_enabled,rd_enabled,rd_mail,email1,email2,email3,email4,email5,email6,email7,email8)
                CusEmail cusEmail =  BeanMapper.map(request.getData(),CusEmail.class);
                cusEmail.setdEnabled(Integer.parseInt(request.getData().getDEnabled()));
                cusEmail.setRdEnabled(Integer.parseInt(request.getData().getRdEnabled()));
                if(customerMapper.selectById(customerEntity.getCustomer())==null){
                if (customerMapper.insert(customerEntity) != 0) {
                    if (cusEmailMapper.insertCustEmail(cusEmail) != 0) {
                        response = Response.success(MessageEnum.INSERT_SUCCESS.getVal(), 1);
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            }else{
                response = Response.error("此客户代码已经存在！");
            }

        } catch (Exception e) {
            response = Response.error(MessageEnum.INSERT_ERROR.getVal());
            log.error("insertCustomer接口操作失败：{}", e.getMessage());
            throw new RuntimeException();
        }
        return response;
    }


    private List<CustomerDTO> setListDTO(List<CustomerVO> listData) {
        List<CustomerDTO> data = new ArrayList<>();
        Integer i = 1;
        for (CustomerVO listDatum : listData) {
            CustomerDTO customerDTO = new CustomerDTO();
            if (listDatum.getSCustomer() != null && listDatum.getSCustomer().size() != 0) {
                String sCustomer = listDatum.getSCustomer().toString().replaceAll("\\s", "");
                customerDTO.setSCustomer(sCustomer.substring(sCustomer.indexOf("[") + 1, sCustomer.lastIndexOf("]")));
                ;
            }
            customerDTO.setCustomer(listDatum.getCustomer());
            customerDTO.setCode(listDatum.getCode());
            customerDTO.setFullname(listDatum.getFullname());
            customerDTO.setCname(listDatum.getCname());
            customerDTO.setAddress(listDatum.getAddress());
            customerDTO.setPostcode(listDatum.getPostcode());
            customerDTO.setAreaCode(listDatum.getAreaCode());
            customerDTO.setTelephone1(listDatum.getTelephone1());
            customerDTO.setTelephone2(listDatum.getTelephone2());
            customerDTO.setFaxno(listDatum.getFaxno());
            customerDTO.setContact(listDatum.getContact());
            customerDTO.setTaxno(listDatum.getTaxno());
            customerDTO.setD(listDatum.getD());
            customerDTO.setDrumlock(listDatum.getDrumlock());
            customerDTO.setOrder1(listDatum.getOrder1());
            customerDTO.setKey(i);


            if (listDatum.getCusEmailList() != null && listDatum.getCusEmailList().size() != 0 ){
                CusEmail cusEmail = listDatum.getCusEmailList().get(0);
                customerDTO.setCustomer(cusEmail.getCustomer());
                customerDTO.setD1Enabled( cusEmail.getD1Enabled());
                customerDTO.setDEnabled(cusEmail.getdEnabled()==0?"否":"是");
                customerDTO.setRdEnabled(cusEmail.getRdEnabled()==0?"否":"是");
                customerDTO.setRdMail(cusEmail.getRdMail());
                customerDTO.setEmail1(cusEmail.getEmail1());
                customerDTO.setEmail2(cusEmail.getEmail2());
                customerDTO.setEmail3(cusEmail.getEmail3());
                customerDTO.setEmail4(cusEmail.getEmail4());
                customerDTO.setEmail5(cusEmail.getEmail5());
                customerDTO.setEmail6(cusEmail.getEmail6());
                customerDTO.setEmail7(cusEmail.getEmail7());
                customerDTO.setEmail8(cusEmail.getEmail8());
            }
            i++;
            data.add(customerDTO);
        }
        return data;
    }
}
