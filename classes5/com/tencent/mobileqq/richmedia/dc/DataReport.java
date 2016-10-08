package com.tencent.mobileqq.richmedia.dc;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ugy;

public class DataReport
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static DataReport jdField_a_of_type_ComTencentMobileqqRichmediaDcDataReport = new DataReport();
  private static final String jdField_a_of_type_JavaLangString = "DataReport";
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Reportor-Tasker");
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public static DataReport a()
  {
    return jdField_a_of_type_ComTencentMobileqqRichmediaDcDataReport;
  }
  
  public void a(ugy paramugy)
  {
    if (paramugy == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramugy);
  }
  
  public void a(ugy paramugy, long paramLong)
  {
    if (paramugy == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramugy, paramLong);
  }
  
  public void b(ugy paramugy, long paramLong)
  {
    if (paramugy == null) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\dc\DataReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */