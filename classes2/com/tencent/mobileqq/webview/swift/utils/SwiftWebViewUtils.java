package com.tencent.mobileqq.webview.swift.utils;

import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.net.URLDecoder;

public class SwiftWebViewUtils
{
  public static final String a = " WebP/0.3.0";
  
  public SwiftWebViewUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static SwiftWebViewUtils.JsInfo a(String paramString)
  {
    SwiftWebViewUtils.JsInfo localJsInfo = new SwiftWebViewUtils.JsInfo();
    paramString = (paramString + "/#").split("/");
    if (paramString.length < 5) {
      if (QLog.isDevelopLevel()) {
        QLog.w("SwiftWebViewUtils", 4, "illegal jsbridge");
      }
    }
    for (;;)
    {
      return null;
      localJsInfo.jdField_a_of_type_JavaLangString = paramString[2];
      localJsInfo.jdField_a_of_type_Boolean = true;
      int j;
      int i;
      if (paramString.length == 5)
      {
        localJsInfo.jdField_a_of_type_Boolean = false;
        paramString = paramString[3].split("#");
        if (paramString.length > 1) {}
        for (;;)
        {
          try
          {
            localJsInfo.jdField_a_of_type_Long = Integer.parseInt(paramString[1]);
            paramString = paramString[0].split("\\?");
            if (paramString.length <= 1) {
              break label220;
            }
            localJsInfo.jdField_a_of_type_ArrayOfJavaLangString = paramString[1].split("&");
            j = localJsInfo.jdField_a_of_type_ArrayOfJavaLangString.length;
            i = 0;
            if (i >= j) {
              break label228;
            }
            int k = localJsInfo.jdField_a_of_type_ArrayOfJavaLangString[i].indexOf('=');
            if (k == -1) {
              break label209;
            }
            localJsInfo.jdField_a_of_type_ArrayOfJavaLangString[i] = URLDecoder.decode(localJsInfo.jdField_a_of_type_ArrayOfJavaLangString[i].substring(k + 1));
            i += 1;
            continue;
            if (!QLog.isDevelopLevel()) {
              break;
            }
          }
          catch (NumberFormatException paramString) {}
          QLog.w("SwiftWebViewUtils", 4, "illegal sn");
          return null;
          label209:
          localJsInfo.jdField_a_of_type_ArrayOfJavaLangString[i] = "";
        }
        label220:
        localJsInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
        label228:
        localJsInfo.b = paramString[0];
        return localJsInfo;
      }
      localJsInfo.b = paramString[3];
      try
      {
        localJsInfo.jdField_a_of_type_Long = Long.parseLong(paramString[4]);
        i = paramString.length - 6;
        localJsInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[i];
        System.arraycopy(paramString, 5, localJsInfo.jdField_a_of_type_ArrayOfJavaLangString, 0, i);
        j = localJsInfo.jdField_a_of_type_ArrayOfJavaLangString.length;
        i = 0;
        while (i < j)
        {
          localJsInfo.jdField_a_of_type_ArrayOfJavaLangString[i] = URLDecoder.decode(localJsInfo.jdField_a_of_type_ArrayOfJavaLangString[i]);
          i += 1;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.w("SwiftWebViewUtils", 4, "illegal sn");
    return null;
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(":");
      if (i > 0) {
        return paramString.substring(0, i);
      }
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str1;
    String str2;
    label57:
    int i;
    Object localObject;
    switch ()
    {
    case 0: 
    default: 
      str1 = "";
      str2 = "";
      if (WebpSoLoader.b())
      {
        str2 = " WebP/0.3.1";
        i = BaseApplicationImpl.a().getResources().getDisplayMetrics().widthPixels;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = paramString1;
        if (paramString1 == null) {
          localObject = "";
        }
        localObject = localStringBuilder.append((String)localObject).append(" ").append(QZoneHelper.a());
        if (!TextUtils.isEmpty(paramString2)) {
          break label270;
        }
      }
      break;
    }
    label270:
    for (paramString1 = "";; paramString1 = " " + paramString2)
    {
      return paramString1 + " " + "QQ/" + "6.5.5" + "." + "2880" + str1 + str2 + " Pixel/" + i;
      str1 = " NetType/UNKNOWN";
      break;
      str1 = " NetType/WIFI";
      break;
      str1 = " NetType/2G";
      break;
      str1 = " NetType/3G";
      break;
      str1 = " NetType/4G";
      break;
      localObject = WebpSoLoader.a();
      if (paramBoolean)
      {
        str2 = " WebP/0.3.0";
        break label57;
      }
      if (localObject == null) {
        break label57;
      }
      str2 = String.format(" WebP/%d.%d.%d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(localObject[2]) });
      break label57;
    }
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("Dalvik/");
    localStringBuilder.append(System.getProperty("java.vm.version"));
    localStringBuilder.append(" (Linux; U; Android ");
    String str = Build.VERSION.RELEASE;
    if (str.length() > 0) {}
    for (;;)
    {
      localStringBuilder.append(str);
      if ("REL".equals(Build.VERSION.CODENAME))
      {
        str = Build.MODEL;
        if (str.length() > 0)
        {
          localStringBuilder.append("; ");
          localStringBuilder.append(str);
        }
      }
      str = Build.ID;
      if (str.length() > 0)
      {
        localStringBuilder.append(" Build/");
        localStringBuilder.append(str);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      str = "1.0";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\utils\SwiftWebViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */