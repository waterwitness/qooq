package com.tencent.mobileqq.unifiedebug;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class UnifiedDebugManager$TerminalInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public UnifiedDebugManager$TerminalInfo(UnifiedDebugManager paramUnifiedDebugManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("mobile_mode", this.jdField_a_of_type_JavaLangString);
    localJSONObject.put("os_version", this.jdField_b_of_type_JavaLangString);
    localJSONObject.put("app_version", this.c);
    localJSONObject.put("net_type", this.d);
    localJSONObject.put("carrier_type", this.e);
    localJSONObject.put("cpu_num", this.jdField_a_of_type_Int);
    localJSONObject.put("cpu_freq", this.jdField_a_of_type_Long);
    localJSONObject.put("total_ram", this.jdField_b_of_type_Long);
    localJSONObject.put("cpu_type", this.f);
    localJSONObject.put("is_proxy", this.jdField_a_of_type_Boolean);
    localJSONObject.put("is_X5_support", this.jdField_b_of_type_Boolean);
    localJSONObject.put("X5_version", this.jdField_b_of_type_Int);
    return localJSONObject;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedebug\UnifiedDebugManager$TerminalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */