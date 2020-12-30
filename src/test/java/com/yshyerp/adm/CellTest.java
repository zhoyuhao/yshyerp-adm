package com.yshyerp.adm;

import com.yshyerp.adm.entity.Cell;
import com.yshyerp.adm.mapper.CellMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author ：tao
 * @date ：Created in 2020/10/26 22:03
 * @description：${description}
 * @modified By：
 * @version: version
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class CellTest {

    @Autowired
    CellMapper cellMapper;

    @Test
    public void getCellById()
    {
        log.info(cellMapper.getCell(5).toString());
    }

    @Test
    public void saveCell()
    {
        Date date=new Date();
        Cell cell=new Cell();
        cell.setCellNumber("测试");
        cell.setCreationDateTime(date);
        cell.setEditDateTime(date);
        cell.setDescription("测试");
        cell.setCreatorId(2);
        cell.setEditorId(2);
        cell.setFactoryId(1);
        cell.setState(1);
        cell.setAreaId(5);
        cellMapper.addCell(cell);
    }

    @Test
    public void updateCell() {
        Date date=new Date();
        Cell cell=new Cell();
        cell.setCellNumber("更改测试");
        cell.setCreationDateTime(date);
        cell.setEditDateTime(date);
        cell.setDescription("更改测试");
        cell.setCreatorId(2);
        cell.setEditorId(2);
        cell.setFactoryId(1);
        cell.setState(1);
        cell.setAreaId(5);
        cell.setId(22);
//        cellMapper.upDateCell(cell);
    }
}
