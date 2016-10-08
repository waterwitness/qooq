package com.tencent.mobileqq.unifiedebug;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONArray;
import org.json.JSONException;

public class UnifiedTraceRouter$TraceRouteInfo
{
  public float a;
  public int a;
  public String a;
  public String b;
  
  public UnifiedTraceRouter$TraceRouteInfo(UnifiedTraceRouter paramUnifiedTraceRouter, String paramString, float paramFloat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramString;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(this.b);
      localJSONArray.put(this.jdField_a_of_type_Float);
      return localJSONArray;
    }
    catch (JSONException localJSONException) {}
    return localJSONArray;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedebug\UnifiedTraceRouter$TraceRouteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */