package com.tencent.mobileqq.intervideo.now;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import svs;

public class JumpConfigUpdater
  implements HttpWebCgiAsyncTask.Callback
{
  private static final int jdField_a_of_type_Int = 9001;
  private static final String jdField_b_of_type_JavaLangString = "XProxy|JumpConfigUpdater";
  private static final String c = "http://now.qq.com/cgi-bin/now/web/h5/get_h5_live_url";
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  svs jdField_a_of_type_Svs;
  boolean jdField_a_of_type_Boolean;
  boolean jdField_b_of_type_Boolean;
  
  public JumpConfigUpdater()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "http://now.qq.com/h5/index.html?bid=2336&_wv=16778245&from=50016";
    this.jdField_a_of_type_Long = 0L;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, svs paramsvs)
  {
    this.jdField_a_of_type_Svs = paramsvs;
    if ((a()) && (!this.jdField_a_of_type_Boolean) && (paramsvs != null))
    {
      paramsvs.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Svs = null;
    }
    paramsvs = paramQQAppInterface.f();
    paramContext = (TicketManager)paramQQAppInterface.getManager(2);
    if (paramContext != null) {}
    for (paramContext = paramContext.getSkey(paramsvs);; paramContext = null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("Cookie", "uin=" + paramsvs + ";skey=" + paramContext);
      localBundle.putString("Referer", "http://now.qq.com");
      paramContext = new HashMap();
      paramContext.put("BUNDLE", localBundle);
      paramContext.put("CONTEXT", paramQQAppInterface.a().getApplicationContext());
      paramQQAppInterface = "http://now.qq.com/cgi-bin/now/web/h5/get_h5_live_url";
      if (paramLong != 0L) {
        paramQQAppInterface = "http://now.qq.com/cgi-bin/now/web/h5/get_h5_live_url?roomid = " + paramLong;
      }
      new HttpWebCgiAsyncTask2(paramQQAppInterface, "", this, 9001, null).a(paramContext);
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject == null) {
      if (this.jdField_a_of_type_Svs != null) {
        this.jdField_a_of_type_Svs.a(this.jdField_a_of_type_Boolean);
      }
    }
    label154:
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramInt = paramJSONObject.optInt("retcode", -1);
      if (QLog.isColorLevel()) {
        QLog.i("XProxy|JumpConfigUpdater", 2, "拉取撑量开关 retcode = " + paramInt);
      }
      boolean bool;
      if (paramInt == 0)
      {
        paramJSONObject = paramJSONObject.optJSONObject("result");
        paramInt = paramJSONObject.optInt("use_h5");
        if (paramInt == 0)
        {
          bool = false;
          this.jdField_a_of_type_Boolean = bool;
          if (paramInt > 0) {
            this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
          }
          this.b = true;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Svs == null) {
          break label154;
        }
        this.jdField_a_of_type_Svs.a(this.jdField_a_of_type_Boolean);
        return;
        bool = true;
        break;
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\JumpConfigUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */