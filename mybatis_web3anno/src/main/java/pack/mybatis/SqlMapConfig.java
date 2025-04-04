package pack.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pack.business.SqlMapperInter;

import java.io.Reader;

public class SqlMapConfig {
    public static SqlSessionFactory sqlSessionFactory;  //DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.

    static{
    	String resource = "pack/mybatis/Configuration.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();

            // MyBatis Annotation을 사용하려면 Sql Mapper 인터페이스를 등록
            Class[] mappers = {SqlMapperInter.class}; // {**, **}
            for(Class m: mappers){
                sqlSessionFactory.getConfiguration().addMapper(m);
            }
        } catch (Exception e) {
            System.out.println("SqlMapConfig 오류 : " + e);
        }
    }

    public static SqlSessionFactory getSqlSession(){
        return sqlSessionFactory;
    }
}