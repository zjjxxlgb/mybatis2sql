/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.submitted.awful_table;


import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.Reader;

class TestWljs2 {

    private static SqlSessionFactory sqlSessionFactory;


    public static void main(String args[]) throws Exception {

      String filePath="D:\\搜狗高速下载\\sibu-mall-seller-master\\sibu-mall-seller-persistence\\src\\main\\java\\com\\sibu\\mall\\seller\\persistence\\dao";
      File file = new File(filePath);
      File[] files = file.listFiles(new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
          return name.endsWith(".xml");
        }
      });
      Configuration configuration = new Configuration();
      configuration.setDefaultResultSetType(ResultSetType.SCROLL_INSENSITIVE);
      for (File file2 : files) {
        String resource = "file:///"+filePath+"\\" + file2.getName();
        System.out.println(resource);
        InputStream inputStream = Resources.getUrlAsStream(resource);
        XMLMapperBuilder builder = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
        builder.parse();
        inputStream.close();
      }
    }

}
