package com.ubivelox.oracle_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.UbiveloxException;

public class CrudTest
{

    static final Logger logger = LoggerFactory.getLogger(CrudTest.class);





    @Test
    public void insertTest() throws UbiveloxException
    {

        assertEquals("DB 저장 성공", Crud.insertDB("김준기", "그룹장", "01011111111"));
        assertEquals("DB 저장 성공", Crud.insertDB("임운혁", "팀잠", "01022222222"));
        assertEquals("DB 저장 성공", Crud.insertDB("송석일", "수석연구원", "01033333333"));
        assertEquals("DB 저장 성공", Crud.insertDB("정성호", "책임연구원", "01044444444"));
        assertEquals("DB 저장 성공", Crud.insertDB("제영호", "책임연구원", "01055555555"));
        assertEquals("DB 저장 성공", Crud.insertDB("유영규", "선임연구원", "01066666666"));
        assertEquals("DB 저장 성공", Crud.insertDB("이태규", "연구원", "01077777777"));
        assertEquals("DB 저장 성공", Crud.insertDB("김동건", "연구원", "01077777777"));
    }





    @Test
    public void deleteTest() throws UbiveloxException
    {
        assertEquals("DB 삭제 성공", Crud.deleteDB("김준기"));
        assertEquals("DB 삭제 성공", Crud.deleteDB("임운혁"));
        assertEquals("DB 삭제 성공", Crud.deleteDB("송석일"));
        assertEquals("DB 삭제 성공", Crud.deleteDB("정성호"));
        assertEquals("DB 삭제 성공", Crud.deleteDB("제영호"));
        assertEquals("DB 삭제 성공", Crud.deleteDB("유영규"));
        assertEquals("DB 삭제 성공", Crud.deleteDB("이태규"));
        assertEquals("DB 삭제 성공", Crud.deleteDB("김동건"));
    }





    @Test
    public void updateTest() throws UbiveloxException
    {

        assertEquals("DB 수정 성공", Crud.updateDB("김준기", "그룹장2", "01011111111"));
        assertEquals("DB 수정 성공", Crud.updateDB("임운혁", "팀잠2", "01022222222"));
        assertEquals("DB 수정 성공", Crud.updateDB("송석일", "수석연구원2", "01033333333"));
        assertEquals("DB 수정 성공", Crud.updateDB("송123석일", "수석연구원2", "01033333333"));
    }





    @Test
    public void selectTest() throws UbiveloxException
    {
        assertEquals("DB 출력 성공", Crud.selectDB());
    }

}
