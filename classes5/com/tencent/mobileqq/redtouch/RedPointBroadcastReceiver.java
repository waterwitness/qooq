package com.tencent.mobileqq.redtouch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class RedPointBroadcastReceiver
  extends BroadcastReceiver
{
  public static final String a = "com.tencent.redpoint.get";
  public static final String b = "com.tencent.redpoint.get.resp";
  public static final String c = "com.tencent.redpoint.report";
  public static final String d = "com.tencent.redpoint.clear";
  public static final String e = "redPointResp";
  public static final String f = "RedPointBroadcastReceiver";
  private QQAppInterface a;
  
  public RedPointBroadcastReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "path = " + paramString);
    }
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "qqapp = null");
      }
      return null;
    }
    paramString = ((RedTouchManager)this.a.getManager(35)).a(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "appinfo = null");
      }
      return null;
    }
    int j = paramString.iNewFlag.get();
    paramString = paramString.red_display_info.red_type_info.get();
    if ((paramString != null) && (paramString.size() >= 2))
    {
      paramString = (BusinessInfoCheckUpdate.RedTypeInfo)paramString.get(1);
      if (paramString == null) {}
    }
    for (int i = paramString.red_type.get();; i = 0)
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("iNewFlag", j);
        paramString.put("type", i);
        paramString = paramString.toString();
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "jsonexception");
        }
        return null;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointBroadcastReceiver clearRed", 2, "path = " + paramString);
    }
    ((RedTouchManager)paramQQAppInterface.getManager(35)).b(paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointBroadcastReceiver reportRedInfo", 2, "path = " + paramString);
    }
    try
    {
      if (paramString.contains("\\.")) {}
      for (i = Integer.parseInt(paramString.split("\\.")[0]);; i = Integer.parseInt(paramString))
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          paramString = ((RedTouchManager)paramQQAppInterface.getManager(35)).a(paramString);
          localJSONObject.put("service_type", 0);
          localJSONObject.put("act_id", paramInt);
          localJSONObject.put("obj_id", "");
          localJSONObject.put("pay_amt", 0);
          localJSONObject.put("service_id", i);
          ((RedTouchManager)paramQQAppInterface.getManager(35)).b(paramString, localJSONObject.toString());
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = ((MobileQQ)paramContext.getApplicationContext()).waitAppRuntime(null);
    if ((paramContext instanceof QQAppInterface)) {
      this.a = ((QQAppInterface)paramContext);
    }
    String str = paramIntent.getAction();
    if ("com.tencent.redpoint.get".equals(str))
    {
      paramIntent.setAction("com.tencent.redpoint.get.resp");
      if (this.a != null)
      {
        paramIntent.putExtra("redPointResp", a(paramIntent.getStringExtra("path")));
        this.a.getApplication().sendBroadcast(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
        paramIntent.putExtra("redPointResp", "");
        paramContext.getApplication().sendBroadcast(paramIntent);
        return;
        if (!"com.tencent.redpoint.report".equals(str)) {
          break;
        }
      } while (this.a == null);
      paramContext = paramIntent.getStringExtra("path");
      int i = paramIntent.getIntExtra("act_id", 1001);
      a(this.a, paramContext, i);
      return;
    } while ((!"com.tencent.redpoint.clear".equals(str)) || (this.a == null));
    paramContext = paramIntent.getStringExtra("path");
    a(this.a, paramContext);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\RedPointBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */