package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;

public class PublicAccountWebviewPlugin
  extends WebViewPlugin
{
  public static final String a = "PublicAccountWebviewPlugin";
  public static final String b = "PublicAccountJs";
  public static final String c = "publicaccount";
  private static final String d = "/report?";
  
  public PublicAccountWebviewPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "PublicAccountJs";
  }
  
  private int a(Map paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (!TextUtils.isEmpty(paramMap)) {}
    try
    {
      i = Integer.parseInt(paramMap);
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  private String a(Map paramMap, String paramString1, String paramString2)
  {
    paramMap = (String)paramMap.get(paramString1);
    if (paramMap == null) {
      return paramString2;
    }
    return paramMap;
  }
  
  private void a(String paramString)
  {
    paramString = URLUtil.a(paramString);
    String str1 = a(paramString, "sub_action", "");
    String str2 = a(paramString, "action_name", "");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountWebviewPlugin", 2, "subAction[" + str1 + "] or actionName[" + str2 + "] null");
      }
      return;
    }
    ReportController.b(null, a(paramString, "tag", "P_CliOper"), a(paramString, "main_action", "Pb_account_lifeservice"), a(paramString, "to_uin", ""), str1, str2, a(paramString, "from_type", 0), a(paramString, "result", 0), a(paramString, "r2", ""), a(paramString, "r3", ""), a(paramString, "r4", ""), a(paramString, "r5", ""));
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString2))
    {
      bool1 = bool2;
      if (paramString2.equals("publicaccount"))
      {
        bool1 = bool2;
        if (paramString1 != null)
        {
          bool1 = bool2;
          if (paramString1.contains("/report?"))
          {
            a(paramString1);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountWebviewPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */