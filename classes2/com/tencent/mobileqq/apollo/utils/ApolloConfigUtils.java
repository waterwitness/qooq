package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class ApolloConfigUtils
{
  public static final String a = "ApolloConfigUtils";
  public static ArrayList a;
  public static JSONObject a;
  public static JSONObject b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject == null) {
          break;
        }
        SharedPreUtils.k(paramContext, Integer.parseInt(localJSONObject.optString("apolloSwitch")));
        if (localJSONObject.has("default"))
        {
          paramString = localJSONObject.optJSONObject("default").optJSONObject("rules");
          jdField_a_of_type_OrgJsonJSONObject = paramString;
          if (localJSONObject.has("switchSet")) {
            b = localJSONObject.optJSONObject("switchSet");
          }
          if (!localJSONObject.has("errorAction")) {
            break;
          }
          paramString = localJSONObject.optString("errorAction");
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          paramContext = paramString.split(",");
          if (paramContext == null) {
            break;
          }
          i = 0;
          if (i >= paramString.length()) {
            break;
          }
          jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt(paramContext[i])));
          if (!QLog.isColorLevel()) {
            break label223;
          }
          QLog.d("ApolloConfigUtils", 2, "errorAction =" + paramContext[i]);
          break label223;
        }
        paramString = localJSONObject.optJSONObject("rules");
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramString) {}
      QLog.e("ApolloConfigUtils", 2, "aplloConfig parse json exception = " + paramString.toString());
      return;
      label223:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\utils\ApolloConfigUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */