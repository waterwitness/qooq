package com.tencent.kingkong;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class NativePatch$ParameterDef
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public NativePatch$ParameterDef(NativePatch paramNativePatch)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Int = Integer.parseInt(paramJSONObject.getString("param_index"));
      this.jdField_b_of_type_Int = Integer.parseInt(paramJSONObject.getString("param_type"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("param_value1").trim();
      this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("param_value2").trim();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Common.Log.a("KingKongNativePatch", "Parse parameter error!");
    }
    return false;
  }
  
  public String toString()
  {
    return "Index " + this.jdField_a_of_type_Int + ": " + this.jdField_b_of_type_Int + ", " + this.jdField_a_of_type_JavaLangString + ", " + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\NativePatch$ParameterDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */