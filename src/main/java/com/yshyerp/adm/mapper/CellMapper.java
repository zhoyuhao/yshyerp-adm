package com.yshyerp.adm.mapper;

import com.yshyerp.adm.entity.Cell;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：tao
 * @date ：Created in 2020/10/26 21:57
 * @description：${description}
 * @modified By：
 * @version: version
 */
@Transactional
@Repository
public interface CellMapper {
    /**
     * 根据Id查找岛区
     * @param id 岛区Id
     * @return 返回岛区
     */
    Cell getCell(int id);

    /**
     * 添加岛区
     * @param cell 岛区
     */
    void addCell(Cell cell);

    /**
     * 更新岛区
     * @param cell 岛区
     */
    void upDateCell(Cell cell);


    void deleteCell(int id);
}
