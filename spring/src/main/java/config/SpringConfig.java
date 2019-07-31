package config;


import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"pojo" , "aspect"})
@ComponentScan(basePackageClasses = pojo.Landlord.class)
public class SpringConfig {



}
