package com.tencent.mfsdk.collector;

import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import kgd;

public class FPSCalculator
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  private final CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = FPSCalculator.class.getSimpleName();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() < 1) {
      return;
    }
    new kgd(this).execute(new Void[0]);
  }
  
  public void a(int paramInt)
  {
    if (this.b != null)
    {
      if (paramInt == 2)
      {
        this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        this.jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Int > 0))
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long;
      if ((l > 1000L) || ((l >= 500L) && ("actFPSRecent".equals(this.b))))
      {
        paramInt = (int)Math.floor(this.jdField_a_of_type_Int * 1000 / ((float)l * 1.0F));
        this.jdField_a_of_type_JavaLangStringBuffer.setLength(0);
        this.jdField_a_of_type_JavaLangStringBuffer.append("FPSCalculator ").append(this.b).append(" frameCount :").append(this.jdField_a_of_type_Int).append(",diffTime :").append(l).append(" fps:").append(paramInt);
        this.jdField_a_of_type_JavaLangStringBuffer.append(",aioBusiness=").append(PerformanceReportUtils.a());
        if (QLog.isDevelopLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 4, this.jdField_a_of_type_JavaLangStringBuffer.toString());
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_JavaLangStringBuffer.toString());
        if ((paramInt > 0) && (!"".equals(this.b))) {
          PerformanceReportUtils.a(this.b, paramInt, PerformanceReportUtils.a());
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 100) {
          a();
        }
      }
    }
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void b()
  {
    if (this.b != null) {
      this.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\collector\FPSCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */