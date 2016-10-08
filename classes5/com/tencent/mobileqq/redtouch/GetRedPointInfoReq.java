package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GetRedPointInfoReq
  extends BaseReq
{
  public static final String j = "GetRedPointInfoReq";
  public static final String k = "path";
  public static final String l = "act_id";
  public static final String m = "reportPath";
  public int d;
  public String n;
  public String o;
  
  public GetRedPointInfoReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.n = "";
    this.o = "";
    this.d = 1001;
  }
  
  private RedAppInfo a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq getRedPointInfo", 2, "path = " + paramString);
    }
    return RedTouchUtils.a(((RedTouchManager)paramQQAppInterface.getManager(35)).a(paramString));
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq clearRed", 2, "path = " + paramString);
    }
    ((RedTouchManager)paramQQAppInterface.getManager(35)).b(paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq reportRedInfo", 2, "path = " + paramString + "act_id == " + paramInt);
    }
    if (paramString == null) {
      return;
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
          return;
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
  
  public int a()
  {
    return 1;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("path", this.n);
    paramBundle.putInt("act_id", this.d);
    paramBundle.putString("reportPath", this.o);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("cmd");
    if ("getRedInfo".equals(localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + (String)localObject);
      }
      paramQQAppInterface = a(this.n, paramQQAppInterface);
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("redInfoResp", paramQQAppInterface);
      paramBundle.putBundle("keyResponse", (Bundle)localObject);
      super.a(paramBundle);
    }
    do
    {
      return;
      if ("reportRedInfo".equals(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + (String)localObject);
        }
        a(paramQQAppInterface, this.n, this.d);
        return;
      }
    } while (!"clearRedInfo".equals(localObject));
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + (String)localObject);
    }
    a(paramQQAppInterface, this.n);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.n = paramBundle.getString("path");
    this.d = paramBundle.getInt("act_id");
    this.o = paramBundle.getString("reportPath");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\GetRedPointInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */