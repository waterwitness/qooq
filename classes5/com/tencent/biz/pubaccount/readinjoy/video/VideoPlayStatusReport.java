package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class VideoPlayStatusReport
  implements VideoPlayStatusChangeListenner
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public VideoPlayStatusReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public String a(int paramInt, String paramString)
  {
    String str2 = "1";
    String str1 = str2;
    if (paramInt != -1)
    {
      str1 = str2;
      if (paramInt != 1)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(paramString)) {
          str1 = Integer.toString(paramString.hashCode());
        }
      }
    }
    return str1;
  }
  
  public void a(long paramLong, Long paramLong1, Long paramLong2, Long paramLong3, String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramString1))) {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 0L) {
        break label137;
      }
    }
    label137:
    for (long l = 0L;; l = System.currentTimeMillis() - this.jdField_a_of_type_Long)
    {
      ReportController.b(null, "CliOper", "", "", "0X80069C0", "0X80069C0", 0, 0, "", a(paramInt, paramString2), Long.toString(l), paramString1);
      if ((int)paramLong == 56) {
        ReportController.b(null, "CliOper", "", "", "0X80069BA", "0X80069BA", 0, 0, Long.toString(l), Long.toString(paramLong2.longValue()), Long.toString(paramLong1.longValue()), paramString1);
      }
      VideoReporter.a(paramLong3.longValue(), (int)paramLong, 12, paramLong2.longValue());
      this.jdField_a_of_type_JavaLangString = "";
      return;
    }
  }
  
  public void b(long paramLong, Long paramLong1, Long paramLong2, Long paramLong3, String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void c(long paramLong, Long paramLong1, Long paramLong2, Long paramLong3, String paramString1, int paramInt, String paramString2)
  {
    long l1;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 0L) {
        break label157;
      }
      l1 = 0L;
      paramString2 = a(paramInt, paramString2);
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 0L) {
        break label170;
      }
    }
    label157:
    label170:
    for (long l2 = 0L;; l2 = System.currentTimeMillis() - this.jdField_a_of_type_Long)
    {
      ReportController.b(null, "CliOper", "", "", "0X80069C0", "0X80069C0", 0, 0, "", paramString2, Long.toString(l2), paramString1);
      if ((int)paramLong == 56) {
        ReportController.b(null, "CliOper", "", "", "0X80069BA", "0X80069BA", 0, 0, Long.toString(l1), Long.toString(paramLong2.longValue()), Long.toString(paramLong1.longValue()), paramString1);
      }
      VideoReporter.a(paramLong3.longValue(), (int)paramLong, 12, paramLong2.longValue());
      this.jdField_a_of_type_JavaLangString = "";
      return;
      l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      break;
    }
  }
  
  public void d(long paramLong, Long paramLong1, Long paramLong2, Long paramLong3, String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ReportController.b(null, "CliOper", "", "", "0X8006754", "0X8006754", 0, 0, "", a(paramInt, paramString2), "", paramString1);
    if ((int)paramLong == 56) {
      ReportController.b(null, "CliOper", "", "", "0X80069B8", "0X80069B8", 0, 0, "", VideoReporter.a(), "", ReadInJoyUtils.a(paramString1, Long.toString(paramLong3.longValue())));
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\video\VideoPlayStatusReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */