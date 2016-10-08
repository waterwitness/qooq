package com.tencent.mobileqq.structmsg;

import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Random;

public class StructMsgTimeReport
{
  public static final String a = "cost";
  public static final String b = "layout";
  public static final String c = "first";
  private long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom;
  
  public StructMsgTimeReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilRandom.nextInt() % 300 != 1) {
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Long == -1L) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("cost", l1 - l2 + "");
    localHashMap.put("layout", paramInt1 + "");
    localHashMap.put("first", paramInt2 + "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "structmsg_builder_getview", true, 0L, 0L, localHashMap, "", false);
    this.jdField_a_of_type_Long = -1L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgTimeReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */