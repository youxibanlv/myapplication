package com.strike.xiaowuyue.myapplication.config;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

/**
 * Created by xiaowuyue on 16/4/27.
 */
public class DbConfig {

    /**
     * 数据库版本号
     ***/
    public static int DB_VERSION = 1;
    /**
     * 数据库名称
     ***/
    public static String DB_NAME = "my_db";

    public static DbManager.DaoConfig APP_DB_CONFIG= new DbManager.DaoConfig().setDbName(DB_NAME).setDbVersion(DB_VERSION)
            .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                @Override
                public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                    try {
                        db.dropDb();
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                }
            });

}
