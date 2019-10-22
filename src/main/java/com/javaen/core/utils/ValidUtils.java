package com.javaen.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Project Name: javaen-core
 * <br>
 * Description:
 * <br>
 * File Name: ValidUtils
 * <br>
 * Copyright: Copyright (C) 2019 All Rights Reserved.
 * <br>
 *
 * @author: vegaxh
 * <p>
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2019/10/22 10:58     |vegaxh      |v1.0.1       |Create
 */

public class ValidUtils {

    public static final String TEL_REGEX = "^[1][3,4,5,6,7,8,9][0-9]{9}$";

    public static boolean isURL(String str){
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
                + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184
                + "|" // 允许IP和DOMAIN（域名）
                + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.
                + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
                + "[a-z]{2,6})" // first level domain- .com or .museum
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        return  str.matches(regex);
    }

    public static boolean isTel(String tel) {
        Pattern pattern = Pattern.compile(TEL_REGEX);
        Matcher isTel = pattern.matcher(tel);
        return isTel.matches();
    }


}
