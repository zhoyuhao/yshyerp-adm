package com.yshyerp.adm.enums;



import java.util.HashMap;
import java.util.Map;


/**
 * @Author: zhoyuhao
 * @Data: 2020-10-30
 * @Description: 货品enum
 */
public enum CommodityEnum {
    //1:化工品,2:动植物油,3:成品油,4:油污水,5:生活污水
    TYPE_NAME1("1","化工品"),
    TYPE_NAME2("2","动植物油"),
    TYPE_NAME3("3","成品油"),
    TYPE_NAME4("4","油污水"),
    TYPE_NAME5("5","生活污水");


    private static Map<String,String> typeMap = null;

    public static  Map<String,String> getTypeMap() {
        CommodityEnum.typeMap = new HashMap();
        typeMap.put(TYPE_NAME1.getValue(),TYPE_NAME1.getName());
        typeMap.put(TYPE_NAME2.getValue(),TYPE_NAME2.getName());
        typeMap.put(TYPE_NAME3.getValue(),TYPE_NAME3.getName());
        typeMap.put(TYPE_NAME4.getValue(),TYPE_NAME4.getName());
        typeMap.put(TYPE_NAME5.getValue(),TYPE_NAME5.getName());
        return CommodityEnum.typeMap;
    }



    private final String value;

    private final String name;

    CommodityEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }


    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static CommodityEnum getByValue(String value) {
        for (CommodityEnum commodityEnum : values()) {
            if (commodityEnum.getValue().equals(value)) {
                return commodityEnum;
            }
        }
        return null;
    }

}
