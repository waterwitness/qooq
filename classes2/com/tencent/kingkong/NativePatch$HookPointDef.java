package com.tencent.kingkong;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class NativePatch$HookPointDef
{
  public int a;
  public String a;
  public String b;
  
  public NativePatch$HookPointDef(NativePatch paramNativePatch)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramJSONObject.getString("hookpoint_type"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("hookpoint_lib_name").trim();
      this.b = paramJSONObject.getString("hookpoint_func_name").trim();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Common.Log.a("KingKongNativePatch", "Parse HookPoint error!");
    }
    return false;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Int + ", " + this.jdField_a_of_type_JavaLangString + ", " + this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\NativePatch$HookPointDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */