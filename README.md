mybatis2sql 基于mybatis-3.5.4定制支持静态分析XML文件输出SQL指纹。

## 使用办法：
cd release

unzip mybatis_jar.zip

cd mybatis_jar

java -jar mybatis.jar ll.xml

![案例](https://github.com/zjjxxlgb/mybatis2sql/raw/master/release/help.PNG)

## 特点：
1、基于mybatis定制，支持更多标签，更多属性。

2、避免一些语法解析不兼容，语法错误，语义不对等情况。

3、分析结果多个SQL用@@@分割，ID和SQL指纹内容通过:分割
