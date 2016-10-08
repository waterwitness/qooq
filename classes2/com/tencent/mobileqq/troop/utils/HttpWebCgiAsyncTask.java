package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.http.HttpAsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpWebCgiAsyncTask
  extends HttpAsyncTask
{
  public static final int a = 0;
  public static final String a;
  public static final String b = "retcode";
  public static final String c = "result";
  public static final String d = "CONTEXT";
  public static final String e = "BUNDLE";
  public static final String f = "Cookie";
  public static final String g = "Referer";
  public static final String h = "Origin";
  public static final String i = "Host";
  protected Bundle a;
  protected HttpWebCgiAsyncTask.Callback a;
  protected boolean a;
  protected int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = HttpWebCgiAsyncTask.class.getSimpleName();
  }
  
  public HttpWebCgiAsyncTask(String paramString1, String paramString2, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle)
  {
    super(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = paramCallback;
    this.b = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public HttpWebCgiAsyncTask(String paramString1, String paramString2, HttpWebCgiAsyncTask.Callback paramCallback, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    super(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = paramCallback;
    this.b = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected JSONObject a(HashMap... paramVarArgs)
  {
    if (isCancelled()) {
      return null;
    }
    Object localObject = paramVarArgs[0];
    if (((((HashMap)localObject).get("CONTEXT") instanceof Context)) && ((((HashMap)localObject).get("BUNDLE") instanceof Bundle)))
    {
      paramVarArgs = (Context)((HashMap)localObject).get("CONTEXT");
      localObject = (Bundle)((HashMap)localObject).get("BUNDLE");
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        String str1 = ((Bundle)localObject).getString("Cookie");
        String str2 = ((Bundle)localObject).getString("Referer");
        String str3 = ((Bundle)localObject).getString("Host");
        if (str1 != null)
        {
          localBundle.putString("Cookie", str1);
          ((Bundle)localObject).remove("Cookie");
        }
        if (str2 != null)
        {
          localBundle.putString("Referer", str2);
          ((Bundle)localObject).remove("Referer");
        }
        if (str3 != null)
        {
          localBundle.putString("Host", str3);
          ((Bundle)localObject).remove(str3);
        }
        localObject = new JSONObject(HttpUtil.a(paramVarArgs, this.k, this.l, (Bundle)localObject, localBundle));
        paramVarArgs = (HashMap[])localObject;
        if (!this.jdField_a_of_type_Boolean)
        {
          paramVarArgs = (HashMap[])localObject;
          if (((JSONObject)localObject).getInt("retcode") == 0) {
            paramVarArgs = ((JSONObject)localObject).getJSONObject("result");
          }
        }
      }
      catch (IOException paramVarArgs)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, paramVarArgs.getMessage(), paramVarArgs);
        paramVarArgs = null;
        continue;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, paramVarArgs.getMessage(), paramVarArgs);
        paramVarArgs = null;
        continue;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, paramVarArgs.getMessage(), paramVarArgs);
      }
      return paramVarArgs;
      paramVarArgs = null;
    }
  }
  
  public void a(HashMap paramHashMap)
  {
    Executor localExecutor = a();
    if (localExecutor != null)
    {
      executeOnExecutor(localExecutor, new HashMap[] { paramHashMap });
      return;
    }
    execute(new HashMap[] { paramHashMap });
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if (isCancelled()) {}
    while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback.a(paramJSONObject, this.b, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\HttpWebCgiAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */