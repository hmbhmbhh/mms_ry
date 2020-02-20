package com.ruoyi.common.mms;

import com.ruoyi.common.utils.security.Md5Utils;
import org.apache.commons.codec.binary.Base64;

/**
 * @author hmbfe
 * @version：
 * @date 2020-02-20 23:22
 * @description：
 */
public class Md5Baes64Utils {
    public static void main(String[] args) {
        String data = "125";
        mdBase64(data);
    }

    public static String mdBase64(String s) {
        byte[] encodeBase641 = Base64.encodeBase64(Md5Utils.hash(s).getBytes());
        String str2 = new String(encodeBase641);
        System.out.println(str2);
        return str2;

    }
}
