package com.coderstory.Purify.module;

import android.content.Context;
import com.coderstory.Purify.plugins.IModule;
import java.io.File;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;



public class ThemePather8 implements IModule {
    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam resparam) {

    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {

       if (lpparam.packageName.equals("com.android.thememanager")) {
            XposedBridge.log("start thememanager Patch");
            //设计师资格
            findAndHookMethod("com.android.thememanager.util.ThemeOperationHandler", lpparam.classLoader, "isTrialable", XC_MethodReplacement.returnConstant(true));
            //是否合法
            findAndHookMethod("com.android.thememanager.util.ThemeOperationHandler", lpparam.classLoader, "isLegal", XC_MethodReplacement.returnConstant(true));
            //是否被篡改（本地导入修改的主题）
            findAndHookMethod("com.android.thememanager.util.ThemeOperationHandler", lpparam.classLoader, "isAuthorizedResource", XC_MethodReplacement.returnConstant(true));
            //判断是有权限使用
            findAndHookMethod("com.android.thememanager.util.ThemeOperationHandler", lpparam.classLoader, "isPermanentRights", XC_MethodReplacement.returnConstant(true));
        }
    }

    @Override
    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) {
        findAndHookMethod("miui.drm.DrmManager", "isLegal", new Object[]{Context.class, File.class, File.class, XC_MethodReplacement.returnConstant(getDrmResultSUCCESS())});
        findAndHookMethod("miui.drm.DrmManager", "isLegal", new Object[]{Context.class, String.class, File.class, XC_MethodReplacement.returnConstant(getDrmResultSUCCESS())});
        findAndHookMethod("miui.drm.DrmManager", "isLegal", new Object[]{Context.class, String.class, "miui.drm.DrmManager$RightObject", XC_MethodReplacement.returnConstant(getDrmResultSUCCESS())});
        findAndHookMethod("miui.drm.DrmManager", "isPermanentRights", new Object[]{File.class, XC_MethodReplacement.returnConstant(true)});
        findAndHookMethod("miui.drm.DrmManager", "isLegal", new Object[]{"miui.drm.DrmManager$RightObject", XC_MethodReplacement.returnConstant(true)});
    }

    private static Object getDrmResultSUCCESS() {
        try {
            Class<Enum> drmSuccess = (Class<Enum>) Class.forName("miui.drm.DrmManager$DrmResult");
            return Enum.valueOf(drmSuccess, "DRM_SUCCESS");
        } catch (Throwable localString4) {
            XposedBridge.log(localString4.toString());
            return null;
        }
    }

    private static void findAndHookMethod(String p1, ClassLoader lpparam, String p2, Object... parameterTypesAndCallback) {
        try {
            XposedHelpers.findAndHookMethod(p1, lpparam, p2, parameterTypesAndCallback);
        } catch (Throwable localString3) {
            XposedBridge.log(localString3.toString());
        }
    }

    private static void findAndHookMethod(String p1, String p2, Object[] p3) {
        try {
            XposedHelpers.findAndHookMethod(Class.forName(p1), p2, p3);
        } catch (Throwable localString3) {
            XposedBridge.log(localString3.toString());
        }
    }
}
