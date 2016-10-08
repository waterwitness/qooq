package com.tencent.av.report;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public class TraeConfigUpdate
{
  private static volatile TraeConfigUpdate jdField_a_of_type_ComTencentAvReportTraeConfigUpdate;
  public static final String a = "request";
  public static final String b = "update";
  public static final String c = "load";
  private Map jdField_a_of_type_JavaUtilMap;
  
  private TraeConfigUpdate()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put("request", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("update", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("load", new String("-1"));
  }
  
  public static TraeConfigUpdate a()
  {
    if (jdField_a_of_type_ComTencentAvReportTraeConfigUpdate == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvReportTraeConfigUpdate == null) {
        jdField_a_of_type_ComTencentAvReportTraeConfigUpdate = new TraeConfigUpdate();
      }
      return jdField_a_of_type_ComTencentAvReportTraeConfigUpdate;
    }
    finally {}
  }
  
  private String a(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    if (paramString1.equals("request")) {
      localStringBuffer.append("|").append(paramString1).append("_").append(paramString2).append("|");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(paramString1).append("_").append(paramString2).append("|");
    }
  }
  
  private String b()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    localStringBuffer.append(a("request", (String)this.jdField_a_of_type_JavaUtilMap.get("request")));
    localStringBuffer.append(a("update", (String)this.jdField_a_of_type_JavaUtilMap.get("update")));
    localStringBuffer.append(a("load", (String)this.jdField_a_of_type_JavaUtilMap.get("load")));
    return localStringBuffer.toString();
  }
  
  public String a()
  {
    return b();
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, String.valueOf(paramInt));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\report\TraeConfigUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */