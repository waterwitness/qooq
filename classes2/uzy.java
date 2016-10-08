import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class uzy
  implements ITransactionCallback
{
  public uzy(BDHCommonUploadProcessor paramBDHCommonUploadProcessor, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.b);
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.b();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms" + " ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.b.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.b.a = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.c = this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if (BDHCommonUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor) == 18) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.a(paramArrayOfByte);
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    BDHCommonUploadProcessor localBDHCommonUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.f = l;
    localBDHCommonUploadProcessor.c = l;
    if ((paramInt < this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.jdField_a_of_type_Long) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.o) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.k)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBDHCommonUploadProcessor.h();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */