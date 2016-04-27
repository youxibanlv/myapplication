package org.xutils.config;

/**
 * Created by jacky on 16/1/19.
 * 用于配置的 缓存，以及各种固定路径
 */
public class XConfig {
    /**
     * 图片缓存地址
     */
    public static final String IMG_CACHE_DIR="img";
    /**
     * 图片 缩略图缓存地址
     */
    public static final String IMG_THUMB_CACHE_DIR="img_thumb";
    /**
     * 默认缓存地址，没有指定 缓存路劲的文件均保存在此目录下
     * gatway cache ->gc_cache
     */
    public static final String DEFAULT_CACHE_DIR="gc_cache";

    /**
     * APK下载的目录
     */
    public static final String APK_DOWNLOAD_DIR="apk_download";

    /**
     * DbConfig 中的 http相关数据缓存数据库
     */
    public static final String DEFAULT_HTTP_CACHE_DB="http_cache.db";
    /**
     * DbConfig 中的 http cookie相关数据缓存数据库
     */
    public static final String DEFAULT_HTTP_COOKIE_CACHE_DB="http_cookie_cache.db";

    /**
     * DbConfig 中的 http相关数据缓存数据库 版本号
     */
    public static final int DEFAULT_HTTP_CACHE_DB_VERSION=1;
    /**
     * DbConfig 中的 http cookie相关数据缓存数据库 版本号
     */
    public static final int DEFAULT_HTTP_COOKIE_CACHE_DB_VERSION=1;

    public static final String MSG_SEQ="msg_seq";
}
