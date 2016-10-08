package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class VideoGetUrlReportData
{
  public long a;
  public String a;
  public boolean a;
  
  public VideoGetUrlReportData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HashMap a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_vid", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_success", String.valueOf(this.jdField_a_of_type_Boolean).toLowerCase());
    localHashMap.put("param_costTime", String.valueOf(this.jdField_a_of_type_Long));
    return localHashMap;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\struct\VideoGetUrlReportData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */