package com.tencent.biz.webviewplugin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.freshnews.FreshNewsComment;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsStranger;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NewReportPlugin
{
  private static final String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NewReportPlugin.class.getName();
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 202: 
    case 203: 
      return "http://aq.qq.com/cn2/uniform_impeach/impeach_entry";
    }
    return "http://jubao.qq.com/uniform_impeach/impeach_entry";
  }
  
  public static String a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    Object localObject1 = new JSONObject();
    switch (paramInt)
    {
    default: 
    case 202: 
    case 203: 
      for (;;)
      {
        return ((JSONObject)localObject1).toString();
        try
        {
          if (!(paramObject instanceof FreshNewsInfo)) {
            break;
          }
          localObject2 = (FreshNewsInfo)paramObject;
          ((JSONObject)localObject1).put("name", ((FreshNewsInfo)localObject2).publisherNickname);
          ((JSONObject)localObject1).put("uin", ((FreshNewsInfo)localObject2).publisherID + "");
          paramObject = new JSONArray();
          localJSONObject1 = new JSONObject();
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("count", ((FreshNewsInfo)localObject2).photoUrls.size());
          JSONArray localJSONArray = new JSONArray();
          Iterator localIterator = ((FreshNewsInfo)localObject2).photoUrls.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("strLink", str);
            localJSONArray.put(localJSONObject2);
          }
          ((JSONObject)localObject3).put("IMGList", localJSONArray);
        }
        catch (Exception paramObject)
        {
          ((Exception)paramObject).printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "getReportMessage:" + ((Exception)paramObject).getMessage());
          }
          return null;
        }
        localJSONObject1.put("IMG", localObject3);
        Object localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("strContent", ((FreshNewsInfo)localObject2).feedContent);
        Object localObject2 = new JSONArray();
        ((JSONArray)localObject2).put(localObject3);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("count", 1);
        ((JSONObject)localObject3).put("TXTList", localObject2);
        localJSONObject1.put("TXT", localObject3);
        ((JSONArray)paramObject).put(localJSONObject1);
        ((JSONObject)localObject1).put("ImpeachInfo", paramObject);
        continue;
        if (!(paramObject instanceof FreshNewsComment)) {
          break label633;
        }
        localObject3 = (FreshNewsComment)paramObject;
        ((JSONObject)localObject1).put("name", ((FreshNewsComment)localObject3).a.jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject1).put("uin", ((FreshNewsComment)localObject3).a.jdField_a_of_type_Long + "");
        paramObject = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("strContent", ((FreshNewsComment)localObject3).c);
        localObject3 = new JSONArray();
        ((JSONArray)localObject3).put(localObject2);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("count", 1);
        ((JSONObject)localObject2).put("TXTList", localObject3);
        localJSONObject1.put("TXT", localObject2);
        ((JSONArray)paramObject).put(localJSONObject1);
        ((JSONObject)localObject1).put("ImpeachInfo", paramObject);
      }
    }
    if ((paramObject instanceof HotChatInfo))
    {
      paramObject = (HotChatInfo)paramObject;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("groupid:").append(((HotChatInfo)paramObject).troopUin);
      ((StringBuilder)localObject1).append("|groupname:").append(a(((HotChatInfo)paramObject).name));
      ((StringBuilder)localObject1).append("|groupnotice:").append(a(((HotChatInfo)paramObject).memo));
      ((StringBuilder)localObject1).append("|ownuin:").append(((HotChatInfo)paramObject).ownerUin);
      paramObject = ((StringBuilder)localObject1).toString();
      return (String)paramObject;
    }
    return null;
    return null;
    label633:
    return null;
  }
  
  public static String a(String paramString)
  {
    paramString = new StringBuilder(paramString);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = ":";
    arrayOfString[1] = "|";
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString[i];
      int j = -2;
      for (;;)
      {
        j = paramString.indexOf(str, j + 2);
        if (j < 0) {
          break;
        }
        paramString.insert(j, "\\");
      }
      i += 1;
    }
    return paramString.toString();
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean, String paramString1, int paramInt, String paramString2, Object paramObject)
  {
    a(paramBaseActivity, paramBoolean, paramString1, paramInt, paramString2, paramObject, false);
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, Object paramObject, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "safetyReport useTinyId=" + paramBoolean1);
    }
    if (paramBaseActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "safetyReport activity param null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (TextUtils.isEmpty(paramString1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "safetyReport eviluin param null");
          }
        }
        else if (paramInt < 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "safetyReport invaild sceneID = " + paramInt);
          }
        }
        else
        {
          String str = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            str = "";
          }
          paramString2 = new StringBuilder();
          paramString2.append("system=android&uintype=1");
          paramString2.append("&appname=KQQ");
          paramString2.append("&subapp=").append(str);
          paramString2.append("&scene=").append(paramInt);
          paramString2.append("&eviluin=").append(paramString1);
          if (paramBoolean1) {
            paramString2.append("&use_evil_tinyid=1");
          }
          try
          {
            paramString1 = a(paramInt, paramObject);
            if (paramString1 != null) {
              break label283;
            }
            if (QLog.isColorLevel())
            {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "safetyReport, srv_para is null! sceneId=" + paramInt);
              return;
            }
          }
          catch (Exception paramBaseActivity) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "safetyReport exception" + paramBaseActivity.getMessage());
    return;
    label283:
    paramString2.append("&srv_para=").append(paramString1);
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "safetyReport, srv json =" + paramString1);
    }
    paramString1 = a(paramInt);
    paramObject = new Intent(paramBaseActivity, QQBrowserActivity.class);
    ((Intent)paramObject).putExtra("NewBSafeReportPost", true);
    ((Intent)paramObject).putExtra("hide_more_button", true);
    ((Intent)paramObject).putExtra("ishiderefresh", true);
    ((Intent)paramObject).putExtra("ishidebackforward", true);
    if (!paramBoolean2) {
      paramString1 = paramString1 + "?" + paramString2.toString();
    }
    for (;;)
    {
      ((Intent)paramObject).putExtra("url", paramString1);
      paramBaseActivity.startActivity((Intent)paramObject);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 4, "safetyReport, after startActivity, url= " + paramString1 + ", params=" + paramString2);
      return;
      ((Intent)paramObject).putExtra("BSafeReportPost", true);
      ((Intent)paramObject).putExtra("SafeReportData", paramString2.toString().getBytes("utf-8"));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\NewReportPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */