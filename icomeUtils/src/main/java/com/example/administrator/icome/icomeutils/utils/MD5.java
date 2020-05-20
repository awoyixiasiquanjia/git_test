//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.administrator.icome.icomeutils.utils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MD5 {
    public MD5() {
    }

    public static String get(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] data = digest.digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            byte[] var4 = data;
            int var5 = data.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                byte b = var4[var6];
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }

                sb.append(hexString);
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException var9) {
            var9.printStackTrace();
            return "";
        }
    }

    public static String get(File file) {
        if (file != null && file.isFile()) {
            MessageDigest digest = null;
            FileInputStream in = null;
            byte[] buffer = new byte[1024];

            try {
                digest = MessageDigest.getInstance("MD5");
                in = new FileInputStream(file);

                while(true) {
                    int len;
                    if ((len = in.read(buffer, 0, 1024)) == -1) {
                        in.close();
                        break;
                    }

                    digest.update(buffer, 0, len);
                }
            } catch (Exception var9) {
                var9.printStackTrace();
                return "";
            }

            BigInteger bigInt = new BigInteger(1, digest.digest());
            String md5 = bigInt.toString(16);
            if (md5.length() < 32) {
                String zero = "";

                for(int i = 0; i < 32 - md5.length(); ++i) {
                    zero = zero + "0";
                }

                md5 = zero + md5;
            }

            return md5;
        } else {
            return "";
        }
    }

    public static Map<String, String> getDirMD5(File file, boolean listChild) {
        if (file != null && file.isDirectory()) {
            Map<String, String> map = new HashMap();
            File[] files = file.listFiles();

            for(int i = 0; i < files.length; ++i) {
                File f = files[i];
                if (f.isDirectory() && listChild) {
                    map.putAll(getDirMD5(f, listChild));
                } else {
                    String md5 = get(f);
                    if (md5 != null) {
                        map.put(f.getPath(), md5);
                    }
                }
            }

            return map;
        } else {
            return new HashMap();
        }
    }
}
