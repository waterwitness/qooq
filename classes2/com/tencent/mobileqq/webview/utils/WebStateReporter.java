package com.tencent.mobileqq.webview.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wjx;

public class WebStateReporter
{
  public static HashMap a;
  private static final String b = "WebStateReporter";
  public static int c;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_Int = 6;
  }
  
  private void a(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), ClubContentJsonTask.i.b);
    if (!paramContext.exists()) {}
    do
    {
      do
      {
        return;
        paramContext = FileUtils.a(paramContext);
      } while (TextUtils.isEmpty(paramContext));
      try
      {
        paramContext = new JSONObject(paramContext);
        int i = paramContext.getInt("sample_rate");
        jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(i));
        JSONArray localJSONArray = paramContext.getJSONArray("rules");
        int j = localJSONArray.length();
        i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          jdField_a_of_type_JavaUtilHashMap.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
          i += 1;
        }
        jdField_c_of_type_Int = paramContext.getInt("tail_number");
        return;
      }
      catch (JSONException paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("WebStateReporter", 2, "" + paramContext);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("WebStateReporter_report", 2, "Current State = " + paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext, long paramLong, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
    b(paramContext, paramLong, paramString, paramBoolean);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("WebStateReporter_report", 2, "Current Reader State = " + paramInt);
    }
  }
  
  public void b(Context paramContext, long paramLong, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramLong <= 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      i = NetworkUtil.a(paramContext);
      switch (i)
      {
      default: 
        String str1 = "Unknown";
        ThreadManager.a(new wjx(this, paramBoolean, paramString, paramContext, paramLong, str1), 5, null, false);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
        continue;
        String str2 = "2G";
        continue;
        str2 = "3G";
        continue;
        str2 = "4G";
        continue;
        str2 = "wifi";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\utils\WebStateReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */