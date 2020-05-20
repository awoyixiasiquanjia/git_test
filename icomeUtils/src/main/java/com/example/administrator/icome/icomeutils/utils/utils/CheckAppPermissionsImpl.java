//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.administrator.icome.icomeutils.utils.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.administrator.icome.icomeutils.utils.CheckAppPermissions;

import cn.enn.icom.lib.base.Logger;
import java.util.ArrayList;
import java.util.List;

public class CheckAppPermissionsImpl implements CheckAppPermissions {
    public CheckAppPermissionsImpl() {
    }

    public boolean check(Context activity, String permission) {
        int hasPermission = ContextCompat.checkSelfPermission(activity, permission);
        if (hasPermission != 0) {
            Logger.d(this + " 检查" + permission.toString() + "的权限， 不可以访问 --- no");
            return false;
        } else {
            Logger.d(this + " 检查" + permission.toString() + "的权限， 可以访问 --- yes");
            return true;
        }
    }

    public boolean check(Context activity, String[] permissions) {
        StringBuilder logMsg = new StringBuilder("");
        List<String> permissionNeededList = new ArrayList();
        String[] var5 = permissions;
        int var6 = permissions.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String permission = var5[var7];
            logMsg.append(permission.toString());
            int hasPermission = ContextCompat.checkSelfPermission(activity, permission);
            if (hasPermission != 0) {
                permissionNeededList.add(permission);
            }
        }

        if (permissionNeededList.isEmpty()) {
            Logger.d(this + " 检查" + logMsg.toString() + "的权限， 可以访问 --- yes");
            return true;
        } else {
            Logger.d(this + " 检查" + logMsg.toString() + "的权限， 不可以访问 --- no");
            return false;
        }
    }
}
