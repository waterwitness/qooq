package com.tencent.mobileqq.webview.swift.component;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.Html;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.webso.SHA1Util;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class SwiftWebViewHttpBridgeUtils
{
  public static final String a = "SwiftWebViewHttpBridgeUtils";
  public static final String b = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent/MobileQQ/swiftHttp/offline/";
  public static final String c = BaseApplication.getContext().getFilesDir() + "/swiftHttp/offline/";
  public static final String d = "swift_html_etags";
  public static final String e = "_template.txt";
  public static final String f = "_data.txt";
  public static final String g = ".txt";
  public static final String h = "tagsEmpty";
  public static final String i = "noCookie";
  public static final String j = "mkdirError";
  public static final String k = "oom";
  public static final String l = "302";
  public static final String m = "timeout";
  public static final String n = "mergeDiffError";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    paramString = paramString.replace(" ", "");
    try
    {
      paramString = Uri.parse(paramString);
      int i1;
      int i2;
      if ((paramString != null) && (paramString.isHierarchical()))
      {
        paramString = paramString.getQueryParameter("asyncMode");
        if (!TextUtils.isEmpty(paramString))
        {
          i1 = Integer.parseInt(paramString);
          i2 = i1;
        }
      }
      return 0;
    }
    catch (Exception paramString)
    {
      do
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("SwiftWebViewHttpBridgeUtils", 2, "mode : " + i1);
            i2 = i1;
          }
          return i2;
        }
        catch (Exception paramString)
        {
          for (;;) {}
        }
        paramString = paramString;
        i1 = 0;
        i2 = i1;
      } while (!QLog.isColorLevel());
      QLog.e("SwiftWebViewHttpBridgeUtils", 2, new Object[] { "get asyncMode error!", paramString.getMessage() });
      return i1;
    }
  }
  
  public static String a(Uri paramUri)
  {
    try
    {
      String str = MD5Utils.d(paramUri.getAuthority() + paramUri.getPath());
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridgeUtils", 2, "getUrlKey..uri", localThrowable);
      }
    }
    return paramUri.toString();
  }
  
  public static String a(Uri paramUri, String paramString, File paramFile)
  {
    if (paramUri == null) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      try
      {
        l1 = System.currentTimeMillis();
        paramFile = FileUtils.b(paramFile);
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridgeUtils", 2, "readFileToString cost=" + (System.currentTimeMillis() - l1));
        }
        if (!TextUtils.isEmpty(paramFile))
        {
          l1 = System.currentTimeMillis();
          if (SHA1Util.a(paramFile).equals(paramString))
          {
            paramString = paramFile;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("SwiftWebViewHttpBridgeUtils", 2, "verify html success cost=" + (System.currentTimeMillis() - l1));
            return paramFile;
          }
        }
      }
      catch (IOException paramString)
      {
        long l1;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridgeUtils", 2, "handle eTag exception=" + paramString.getMessage());
        }
        a(paramUri);
        return "";
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridgeUtils", 2, "verify html fail cost=" + (System.currentTimeMillis() - l1));
        }
        a(paramUri);
        return "";
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridgeUtils", 2, "verify load data exception=" + paramString.getMessage());
        }
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "oom", 0, 0, 3, 0, paramUri.toString(), "");
        return "";
      }
    }
    return "";
  }
  
  public static void a()
  {
    if (FileUtils.a()) {}
    for (String str = b;; str = c)
    {
      File localFile = new File(str);
      if ((localFile.exists()) && (!FileUtil.a(localFile))) {
        QLog.d("SwiftWebViewHttpBridgeUtils", 1, "delete sonic error: " + str);
      }
      return;
    }
  }
  
  public static void a(Uri paramUri)
  {
    if (paramUri == null) {}
    do
    {
      return;
      localObject = b(paramUri);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    FileUtils.d((String)localObject + ".txt");
    FileUtils.d((String)localObject + "_template.txt");
    FileUtils.d((String)localObject + "_data.txt");
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("swift_html_etags", 0).edit();
    String str = String.valueOf(BaseApplicationImpl.a().a().getLongAccountUin());
    paramUri = a(paramUri);
    ((SharedPreferences.Editor)localObject).remove("eTag_" + str + paramUri);
    ((SharedPreferences.Editor)localObject).remove("templateTag_" + str + paramUri);
    ((SharedPreferences.Editor)localObject).remove("htmlSha1_" + str + paramUri);
    if (Build.VERSION.SDK_INT < 9)
    {
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Uri paramUri, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftWebViewHttpBridgeUtils", 2, "save tag info, url: " + paramUri + " result: " + paramBoolean);
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("swift_html_etags", 0).edit();
    String str = String.valueOf(BaseApplicationImpl.a().a().getLongAccountUin());
    paramUri = a(paramUri);
    if (paramBoolean)
    {
      localEditor.putString("eTag_" + str + paramUri, paramString1);
      localEditor.putString("templateTag_" + str + paramUri, paramString2);
      localEditor.putString("htmlSha1_" + str + paramUri, paramString3);
    }
    while (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
      localEditor.putString("eTag_" + str + paramUri, "");
      localEditor.putString("templateTag_" + str + paramUri, "");
      localEditor.putString("htmlSha1_" + str + paramUri, "");
    }
    localEditor.apply();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((a(paramString) != 3) || (b(paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      paramBoolean2 = false;
    }
    long l1;
    do
    {
      return paramBoolean2;
      l1 = System.currentTimeMillis();
      Uri localUri = Uri.parse(paramString2);
      String str1 = paramString1;
      if (paramBoolean1) {
        str1 = Html.fromHtml(paramString1).toString();
      }
      JSONObject localJSONObject = new JSONObject();
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        i2 = str1.indexOf("<title>");
        i1 = str1.indexOf("</title>") + 8;
        if ((i2 == -1) || (i2 >= i1)) {
          break label789;
        }
        localJSONObject.put("{title}", str1.substring(i2, i1));
        localStringBuilder.append(str1.substring(0, i2));
        localStringBuilder.append("{title}");
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          int i2;
          Matcher localMatcher;
          boolean bool;
          paramBoolean1 = false;
          QLog.d("SwiftWebViewHttpBridgeUtils", 1, "parse exception: " + paramString1.getMessage());
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramBoolean1 = false;
          QLog.d("SwiftWebViewHttpBridgeUtils", 1, "splitTemplateAndData exception: " + paramString1.getMessage());
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        for (;;)
        {
          QLog.d("SwiftWebViewHttpBridgeUtils", 1, "html is too large: " + paramString1.getMessage());
          VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "oom", 0, 0, 2, 0, paramString2, "");
          paramBoolean1 = false;
          continue;
          paramBoolean2 = false;
          continue;
          paramBoolean1 = true;
          continue;
          int i1 = 0;
        }
      }
      localMatcher = Pattern.compile("<!--wnsdiff-?(\\w*)-->([\\s\\S]+?)<!--wnsdiff-?(\\w*)-end-->", 8).matcher(str1);
      while (localMatcher.find())
      {
        String str2 = localMatcher.group();
        i2 = "<!--wnsdiff-".length();
        int i3 = str2.indexOf("<!--wnsdiff-");
        int i4 = str2.indexOf("-->");
        Object localObject = null;
        paramString1 = (String)localObject;
        if (i3 != -1)
        {
          paramString1 = (String)localObject;
          if (i3 + i2 < i4) {
            paramString1 = str2.substring(i3 + i2, i4);
          }
        }
        paramString1 = "{" + paramString1 + "}";
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridgeUtils", 2, "matcher-> key:" + paramString1);
        }
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(str2)))
        {
          localJSONObject.put(paramString1, str2);
          localStringBuilder.append(str1.substring(i1, localMatcher.start()));
          localStringBuilder.append(paramString1);
          i1 = localMatcher.end();
        }
      }
      if ((i1 < str1.length()) && (localStringBuilder.length() > 0)) {
        localStringBuilder.append(str1.substring(i1, str1.length()));
      }
      paramString1 = b(localUri);
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      if (!paramBoolean2) {
        break label784;
      }
      bool = WebSoUtils.a(str1.getBytes(), paramString1 + ".txt");
      if (!bool) {
        QLog.e("SwiftWebViewHttpBridgeUtils", 1, "save html error");
      }
      paramBoolean1 = bool;
      if (bool)
      {
        paramBoolean1 = bool;
        if (localJSONObject.length() > 0)
        {
          bool = WebSoUtils.a(localJSONObject.toString().getBytes(), paramString1 + "_data.txt");
          paramBoolean1 = bool;
          if (!bool)
          {
            QLog.e("SwiftWebViewHttpBridgeUtils", 1, "save data error");
            paramBoolean1 = bool;
          }
        }
        if (localStringBuilder.length() >= 0)
        {
          bool = WebSoUtils.a(localStringBuilder.toString().getBytes(), paramString1 + "_template.txt");
          paramBoolean1 = bool;
          if (!bool)
          {
            QLog.e("SwiftWebViewHttpBridgeUtils", 1, "save template error");
            paramBoolean1 = bool;
          }
        }
      }
      paramString1 = SHA1Util.a(str1);
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break;
      }
      paramBoolean2 = true;
      a(paramString3, paramString4, paramString1, localUri, paramBoolean2);
      paramBoolean2 = paramBoolean1;
    } while (!QLog.isColorLevel());
    QLog.d("SwiftWebViewHttpBridgeUtils", 2, "splitTemplateAndData time: " + (System.currentTimeMillis() - l1));
    return paramBoolean1;
  }
  
  public static String b(Uri paramUri)
  {
    if (paramUri == null) {
      return "";
    }
    if (FileUtils.a()) {}
    for (Object localObject1 = b;; localObject1 = c)
    {
      Object localObject2 = new File((String)localObject1);
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs()))
      {
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "mkdirError", 0, 0, 0, 0, paramUri.toString(), "");
        QLog.d("SwiftWebViewHttpBridgeUtils", 1, "mkdirs error: " + (String)localObject1);
      }
      localObject2 = ((File)localObject2).getAbsolutePath();
      localObject1 = localObject2;
      if (!((String)localObject2).endsWith(File.separator)) {
        localObject1 = (String)localObject2 + File.separator;
      }
      paramUri = paramUri.getAuthority() + paramUri.getPath();
      paramUri = MD5Utils.d(paramUri + String.valueOf(BaseApplicationImpl.a().a().getLongAccountUin()));
      return (String)localObject1 + paramUri;
    }
  }
  
  public static void b(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    a(paramUri);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("swift_html_etags", 0).edit();
    long l1 = BaseApplicationImpl.a().a().getLongAccountUin();
    paramUri = WebSoUtils.a(paramUri);
    localEditor.putLong("swiftHttp_" + String.valueOf(l1) + paramUri + "_503", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    Object localObject = Uri.parse(paramString);
    paramString = BaseApplicationImpl.getContext().getSharedPreferences("swift_html_etags", 0);
    long l1 = BaseApplicationImpl.a().a().getLongAccountUin();
    localObject = WebSoUtils.a((Uri)localObject);
    l1 = paramString.getLong("swiftHttp_" + String.valueOf(l1) + (String)localObject + "_503", -1L);
    boolean bool1 = bool2;
    if (l1 != -1L)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - l1 < 21600000L)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwiftWebViewHttpBridgeUtils", 2, "503 happened in 6 hours, return false");
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.equals("store")) || (paramString.equals("true")));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftWebViewHttpBridgeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */