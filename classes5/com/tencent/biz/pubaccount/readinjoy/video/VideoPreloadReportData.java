package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class VideoPreloadReportData
{
  public int a;
  public int b;
  
  public VideoPreloadReportData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HashMap a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_triggerCount", String.valueOf(this.a));
    localHashMap.put("param_hitCount", String.valueOf(this.b));
    return localHashMap;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\video\VideoPreloadReportData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */