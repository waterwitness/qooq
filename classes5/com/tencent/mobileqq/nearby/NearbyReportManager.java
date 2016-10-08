package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import mqq.manager.Manager;
import tij;

public class NearbyReportManager
  implements Manager
{
  static final String jdField_a_of_type_JavaLangString = "NearbyReportManager";
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  LongSparseArray jdField_a_of_type_ComTencentUtilLongSparseArray;
  public boolean a;
  
  public NearbyReportManager(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    LongSparseArray localLongSparseArray = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    NearbyHandler localNearbyHandler = (NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    ThreadManager.a(new tij(this, localLongSparseArray, localNearbyHandler, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "addData ,already exist! tinyID = " + paramLong);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "addData ,tinyID = " + paramLong + ",position = " + paramInt1 + ",ruleID = " + paramInt2);
    }
    NearbyReportManager.ReportRecord localReportRecord = new NearbyReportManager.ReportRecord(paramLong);
    localReportRecord.a = paramInt1;
    localReportRecord.b = paramInt2;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong, localReportRecord);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    NearbyReportManager.ReportRecord localReportRecord = (NearbyReportManager.ReportRecord)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong);
    if (localReportRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localReportRecord.c += 1;
    localReportRecord.d += paramInt1;
    if (paramInt2 > localReportRecord.e) {
      localReportRecord.e = paramInt2;
    }
    localReportRecord.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyReportManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */