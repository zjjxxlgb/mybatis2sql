package org.apache.ibatis.submitted.dynsql2;

import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by EDZ on 2020/4/3.
 */
public class TestWljs {

  protected static SqlSessionFactory sqlSessionFactory;
  public static void main(String args[]) throws  Exception{
    System.out.println("Hello World!");
    try (Reader reader = Resources.getResourceAsReader("org/apache/ibatis/submitted/dynsql2/MapperConfig.xml")) {
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    BaseDataTest.runScript(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource(),
      "org/apache/ibatis/submitted/dynsql2/CreateDB.sql");
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      List<Name> names = new ArrayList<>();

      Name name = new Name();
      name.setFirstName("Fred");
      name.setLastName("Flintstone");
      names.add(name);

      name = new Name();
      name.setFirstName("Barney");
      name.setLastName("Rubble");
      names.add(name);

      Parameter parameter = new Parameter();
      parameter.setNames(names);

      List<Map<String, Object>> answer = sqlSession.selectList("org.apache.ibatis.submitted.dynsql2.dynamicSelectWithTypeHandler", parameter);
      System.out.print( answer.size());
      assertEquals(2, answer.size());
    }

  }
}
