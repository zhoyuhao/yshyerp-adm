package com.yshyerp.adm.service;

import com.yshyerp.adm.entity.Cell;

/**
 * @author ：tao
 * @date ：Created in 2020/10/26 22:31
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface CellService {
    /**
     * 根据Id查找岛区
     * @param id 岛区Id
     * @return 返回岛区
     */
    Cell getCell(int id);
}
