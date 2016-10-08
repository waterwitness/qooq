package com.tencent.mobileqq.msf.core.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static String a = "LogEvent";
  public static int b = 10;
  public static int c = 11;
  public static int d = 20;
  public static int e = 30;
  public static int f = 40;
  public static int g = 41;
  public static String h = "SetLogLevel";
  public static String i = "UploadLogFile";
  
  public static void a(String paramString)
  {
    Object localObject1 = BaseApplication.getContext().getSharedPreferences(paramString, 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    localObject1 = ((SharedPreferences)localObject1).getAll().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (String)localEntry.getValue();
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (System.currentTimeMillis() - ((JSONObject)localObject2).getLong("time") > 3600000L)
        {
          a(paramString, (JSONObject)localObject2);
          localEditor.remove((String)localEntry.getKey());
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e(a, 1, "", localJSONException);
      }
    }
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1);
    paramString1 = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis());
      localJSONObject.put("stat", b);
      localJSONObject.put("uin", MsfService.getCore().getAccountCenter().i());
      localJSONObject.put("startNet", NetConnInfoCenterImpl.getSystemNetState());
      paramString1.edit().putString(paramString2, localJSONObject.toString()).commit();
      QLog.d(a, 1, "new LogEvent1 " + paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e(a, 1, "", paramString1);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
    Object localObject = localSharedPreferences.getString(paramString2, null);
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        ((JSONObject)localObject).put("stat", paramInt);
        if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramInt == f) || (paramInt == g))) {
          ((JSONObject)localObject).put("fileSize", (Long)paramVarArgs[0]);
        }
        if (paramBoolean)
        {
          ((JSONObject)localObject).put("endNet", NetConnInfoCenterImpl.getSystemNetState());
          a(paramString1, (JSONObject)localObject);
          localSharedPreferences.edit().remove(paramString2).commit();
          QLog.d(a, 1, "changeEventStat " + paramInt + " " + paramString2);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.e(a, 1, "", paramString1);
        return;
      }
      localSharedPreferences.edit().putString(paramString2, ((JSONObject)localObject).toString()).commit();
    }
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    int j = 0;
    try
    {
      if (paramJSONObject.has("stat")) {
        j = paramJSONObject.getInt("stat");
      }
      QLog.d(a, 1, "reportLogEvent, " + j);
      HashMap localHashMap = new HashMap();
      if (paramString.equals(i))
      {
        localHashMap.put("pmStat", String.valueOf(j));
        if (paramJSONObject.has("uin")) {
          localHashMap.put("pmUin", String.valueOf(paramJSONObject.getString("uin")));
        }
        if (paramJSONObject.has("time")) {
          localHashMap.put("pmTime", String.valueOf(paramJSONObject.getLong("time")));
        }
        if (paramJSONObject.has("startNet")) {
          localHashMap.put("pmStartNet", String.valueOf(paramJSONObject.getInt("startNet")));
        }
        if (paramJSONObject.has("endNet")) {
          localHashMap.put("pmEndNet", String.valueOf(paramJSONObject.getInt("endNet")));
        }
        if (paramJSONObject.has("fileSize")) {
          localHashMap.put("pmFileSize", String.valueOf(paramJSONObject.getInt("fileSize")));
        }
      }
      MsfService.getCore().getStatReporter().a(paramString, true, 0L, 0L, localHashMap, false, false);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(a, 1, "", paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */