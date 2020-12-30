package com.yshyerp.adm.utils;

import org.dozer.DozerBeanMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @Author: zhoyuhao
 * @Data: 2020/11/30
 * @Description: 对象属性映射
 */
public class BeanMapper {
    private static DozerBeanMapper dozer = new DozerBeanMapper();

    /**
     * 普通对象转换 比如: ADO -> AVO
     * @param: [source 源对象, destinationClass 目标对象class]
     * @return: T
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }
        return dozer.map(source, destinationClass);
    }

    /**
     * List转换 比如: List<ADO> -> List<AVO>
     * @param: [sourceList 源对象List, destinationClass 目标对象class]
     * @return: java.util.List<T>
     * @author: zhuoli
     * @date: 2018/9/30 18:14
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList();
        if (sourceList == null) {
            return destinationList;
        }
        for (Object sourceObject : sourceList) {
            if (sourceObject != null) {
                T destinationObject = dozer.map(sourceObject, destinationClass);
                destinationList.add(destinationObject);
            }
        }
        return destinationList;
    }


}
