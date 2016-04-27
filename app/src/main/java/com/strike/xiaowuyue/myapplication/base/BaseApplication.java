package com.strike.xiaowuyue.myapplication.base;

import android.app.Application;

import com.strike.xiaowuyue.myapplication.config.DbConfig;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by xiaowuyue on 16/4/27.
 */
public class BaseApplication extends Application {

    public static  DbManager appDb = null;
    /*****获取数据库****/
    public static DbManager getAppDb(){
        if (appDb == null){
            appDb = x.getAppDb(DbConfig.APP_DB_CONFIG);
        }
        return appDb;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }

    /****初始化配置参数***/
    private void initConfig(){

    }
}
