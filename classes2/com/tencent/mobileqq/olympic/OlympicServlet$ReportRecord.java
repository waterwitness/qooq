package com.tencent.mobileqq.olympic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class OlympicServlet$ReportRecord
  implements Serializable
{
  public long count;
  public long time_stamp;
  
  public OlympicServlet$ReportRecord()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("(");
    localStringBuilder.append("time_stamp=").append(this.time_stamp).append(",");
    localStringBuilder.append("count=").append(this.count);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\OlympicServlet$ReportRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */