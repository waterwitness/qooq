package com.tencent.mobileqq.vas;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ClubContentJsonTask$TaskInfo
{
  public static final String a = "TaskInfo";
  public JSONObject a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public ClubContentJsonTask$TaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramString1;
    this.d = paramString2;
    this.c = paramString3;
    this.e = paramString4;
    this.f = paramString5;
  }
  
  public JSONObject a(Context paramContext)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (this.a != null)
        {
          paramContext = this.a;
          return paramContext;
        }
        if ((paramContext == null) || (TextUtils.isEmpty(this.b)))
        {
          QLog.e("TaskInfo", 1, "readLocalJsonFile, context or json_name null, context=" + paramContext + ", json_name=" + this.b);
          paramContext = (Context)localObject;
          continue;
        }
        paramContext = new File(paramContext.getFilesDir(), this.b);
      }
      finally {}
      if (paramContext.exists()) {
        paramContext = FileUtils.a(paramContext);
      }
      try
      {
        this.a = new JSONObject(paramContext);
        paramContext = this.a;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          this.a = null;
          QLog.e("TaskInfo", 1, "readLocalJsonFile, exception=" + MsfSdkUtils.getStackTraceString(paramContext));
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\ClubContentJsonTask$TaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */