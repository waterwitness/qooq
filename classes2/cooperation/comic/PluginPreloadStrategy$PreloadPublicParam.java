package cooperation.comic;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginPreloadStrategy$PreloadPublicParam
{
  public static final String a = "switch";
  public static final String b = "pppid";
  public static final String c = "timecontrol";
  public static final String d = "dayofweek";
  public static final String e = "hourofday";
  public static final String f = "reddot";
  public static final String g = "apponly";
  public static final String h = "app";
  public static final String i = "leba";
  public static final String j = "cdperiod";
  public static final String k = "time";
  public static final String l = "reverse";
  public static final String m = "lebalist";
  public static final String n = "activetime";
  public static final String o = "hour";
  public static final String p = "usedtimes";
  public static final String q = "times";
  public static final String r = "userlearn";
  public static final String s = "timearea";
  public static final String t = "methodid";
  public static final String u = "clusternum";
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public boolean j;
  public boolean k;
  
  public PluginPreloadStrategy$PreloadPublicParam()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static PreloadPublicParam a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return a(paramString);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadPublicParam", 2, "PreloadPublicParam parseJson Exception");
        }
        paramString = null;
      }
    }
  }
  
  public static PreloadPublicParam a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    PreloadPublicParam localPreloadPublicParam = new PreloadPublicParam();
    try
    {
      if (paramJSONObject.has("pppid")) {
        localPreloadPublicParam.jdField_a_of_type_Int = paramJSONObject.getInt("pppid");
      }
      if (paramJSONObject.has("timecontrol"))
      {
        localObject = paramJSONObject.getJSONObject("timecontrol");
        localPreloadPublicParam.jdField_a_of_type_Boolean = ((JSONObject)localObject).getBoolean("switch");
        localPreloadPublicParam.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("dayofweek");
        localPreloadPublicParam.jdField_c_of_type_Int = ((JSONObject)localObject).getInt("hourofday");
      }
      if (paramJSONObject.has("reddot"))
      {
        localObject = paramJSONObject.getJSONObject("reddot");
        localPreloadPublicParam.jdField_b_of_type_Boolean = ((JSONObject)localObject).getBoolean("switch");
        localPreloadPublicParam.jdField_c_of_type_Boolean = ((JSONObject)localObject).optBoolean("apponly");
        localPreloadPublicParam.jdField_d_of_type_Boolean = ((JSONObject)localObject).getBoolean("app");
        localPreloadPublicParam.jdField_e_of_type_Boolean = ((JSONObject)localObject).getBoolean("leba");
      }
      if (paramJSONObject.has("lebalist")) {
        localPreloadPublicParam.jdField_h_of_type_Boolean = paramJSONObject.getJSONObject("lebalist").getBoolean("switch");
      }
      if (paramJSONObject.has("activetime"))
      {
        localObject = paramJSONObject.getJSONObject("activetime");
        localPreloadPublicParam.jdField_i_of_type_Boolean = ((JSONObject)localObject).getBoolean("switch");
        localPreloadPublicParam.jdField_e_of_type_Int = ((JSONObject)localObject).getInt("hour");
      }
      if (paramJSONObject.has("usedtimes"))
      {
        localObject = paramJSONObject.getJSONObject("usedtimes");
        localPreloadPublicParam.j = ((JSONObject)localObject).getBoolean("switch");
        localPreloadPublicParam.jdField_f_of_type_Int = ((JSONObject)localObject).getInt("times");
      }
      if (paramJSONObject.has("userlearn"))
      {
        localObject = paramJSONObject.getJSONObject("userlearn");
        localPreloadPublicParam.k = ((JSONObject)localObject).getBoolean("switch");
        localPreloadPublicParam.jdField_g_of_type_Int = ((JSONObject)localObject).getInt("timearea");
        localPreloadPublicParam.jdField_h_of_type_Int = ((JSONObject)localObject).getInt("methodid");
        localPreloadPublicParam.jdField_i_of_type_Int = ((JSONObject)localObject).getInt("clusternum");
      }
      localObject = localPreloadPublicParam;
      if (paramJSONObject.has("cdperiod"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("cdperiod");
        localPreloadPublicParam.jdField_f_of_type_Boolean = paramJSONObject.optBoolean("switch");
        localPreloadPublicParam.jdField_d_of_type_Int = paramJSONObject.optInt("time");
        localPreloadPublicParam.jdField_g_of_type_Boolean = paramJSONObject.optBoolean("reverse");
        localObject = localPreloadPublicParam;
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadPublicParam", 2, "PreloadPublicParam parseJson Exception");
        }
        Object localObject = null;
      }
    }
    return (PreloadPublicParam)localObject;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\PluginPreloadStrategy$PreloadPublicParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */