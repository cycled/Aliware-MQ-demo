//package com.aliyun.openservices.client;
//
//import com.taobao.hsf.standalone.HSFEasyStarter;
//import org.junit.BeforeClass;
//
///**
// * Created by jixiang.jjx on 2014/12/25.
// */
//public class Container {
//
//    @BeforeClass
//    public static void init() {
//        /**
//         * [方法1]---使用Pandora容器
//         *
//         * Pandora容器下载地址 http://ops.jm.taobao.org:9999/pandora-web/sar/sarDetail.html?spm=0.0.0.0.LVC2yP&version=ons-sdk-1.1.5-SNAPSHOT
//         *
//         * Pandora容器使用手册:http://gitlab.alibaba-inc.com/middleware/pandora/wikis/home
//         * 需要先下载taobao-hsf.sar到指定目录下(D:/ons)
//         *
//         * [方法2]---不使用Pandora容器
//         * 注释 HSFEasyStarter.start("D:/", "ons"); 并将pom依赖中将ons-api替换成ons-sdk
//         *
//         */
//        HSFEasyStarter.start("/Users/jixiang/jixiang.jjx", "SAR");
//    }
//}
