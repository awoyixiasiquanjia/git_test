//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.administrator.icome.icomeutils.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.example.administrator.icome.icomeutils.utils.utils.CheckAppPermissionsImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

public class UserAgent {


    @SuppressLint({"MissingPermission"})
    public static String getUUID(Context mContext) {
        TelephonyManager tm = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
        String uuid = "";
        CheckAppPermissions checkAppPermissions = new CheckAppPermissionsImpl();
        boolean isGranted = checkAppPermissions.check(mContext, "android.permission.READ_PHONE_STATE");
        if (tm != null && isGranted) {
            uuid = tm.getDeviceId();
        }
        if (TextUtils.isEmpty(uuid)) {
            String androidId = Secure.getString(mContext.getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(androidId)) {
                uuid = androidId;
            }
        }

        if (TextUtils.isEmpty(uuid)) {
            uuid = Build.SERIAL;
        }

        if (TextUtils.isEmpty(uuid)) {
            uuid =Installation.id(mContext);
        }

        if (TextUtils.isEmpty(uuid)) {
            uuid = UUID.randomUUID().toString();
        }

        uuid = 4 + MD5.get(uuid.toString());
        return uuid;
    }

    public static class Installation {
        private static String sID = null;
        private static final String INSTALLATION = "INSTALLATION";

        public Installation() {
        }

        public static synchronized String id(Context context) {
            if (sID == null) {
                File installation = new File(context.getFilesDir(), "INSTALLATION");

                try {
                    if (!installation.exists()) {
                        writeInstallationFile(installation);
                    }
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

                try {
                    sID = readInstallationFile(installation);
                } catch (IOException var3) {
                    var3.printStackTrace();
                }
            }

            return sID;
        }

        private static String readInstallationFile(File installation) throws IOException {
            RandomAccessFile f = new RandomAccessFile(installation, "r");
            byte[] bytes = new byte[(int)f.length()];
            f.readFully(bytes);

            return new String(bytes);
        }

        private static void writeInstallationFile(File installation) throws IOException {
            FileOutputStream out = new FileOutputStream(installation);
            String id = UUID.randomUUID().toString();
            out.write(id.getBytes());

        }
    }
}
