package service.impl;

import org.springframework.stereotype.Component;
import service.SQLLiteService;

@Component("landlord")
public class SQLLiteServiceImpl implements SQLLiteService {

    public void insertService() {
        System.out.println("数据库插入操作");
    }

    public void deleteService() {
        System.out.println("数据库删除操作");
    }
}
