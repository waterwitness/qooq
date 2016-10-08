package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

public class NearbyTransFileController
  extends BaseTransFileController
{
  private NearbyAppInterface a;
  
  public NearbyTransFileController(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramNearbyAppInterface;
  }
  
  public BaseTransProcessor a(TransferRequest paramTransferRequest)
  {
    if (paramTransferRequest == null) {}
    do
    {
      return null;
      if ((paramTransferRequest.b == 8) || (paramTransferRequest.b == 21)) {
        return new NearbyPeoplePhotoUploadProcessor(this, paramTransferRequest);
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.TransFileController", 2, paramTransferRequest.toString());
    return null;
  }
  
  public void a() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyTransFileController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */