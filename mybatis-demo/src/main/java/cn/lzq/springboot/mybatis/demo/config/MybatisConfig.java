package cn.lzq.springboot.mybatis.demo.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * mybatis 配置文件
 *
 * @author zhiqi.liu@yoho.cn
 * @create 2016-10-26 14:19
 */
@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
@MapperScan("cn.lzq.springboot.mybatis.demo.mapper")
@EnableTransactionManagement(proxyTargetClass=true)
public class MybatisConfig implements EnvironmentAware{

    private static Log log = LogFactory.getLog(MybatisConfig.class);

    @Autowired
    protected DataSource dataSource;

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        propertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(propertyResolver.getProperty("mapperLocations")));
            SqlSessionFactory sqlSessionFactory =  sqlSessionFactoryBean.getObject();
            org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
            configuration.setMapUnderscoreToCamelCase(true);
            return sqlSessionFactory;
        } catch (Exception e) {
            log.error("初始化SqlSessionFaction异常!");
            return null;
        }
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(){
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sessionTemplate;
    }
}
