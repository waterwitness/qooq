package com.tencent.mobileqq.app;

import VIP.AIOSendReq;
import VIP.AIOSendRes;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VIPAioSendHandler
  extends BusinessHandler
{
  public static int a;
  public static String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "AIOSendSvc.CheckPopGrayStips";
  }
  
  protected VIPAioSendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return VIPAioSendObserver.class;
  }
  
  public void a(AIOSendReq paramAIOSendReq)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putSerializable("VIPAioSendRequest", paramAIOSendReq);
    super.a(localToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      a(jdField_a_of_type_Int, false, null);
      return;
    }
    paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    if (jdField_a_of_type_JavaLangString.equals(paramToServiceMsg))
    {
      paramToServiceMsg = (AIOSendRes)paramObject;
      AioVipDonateHelper.a().a(this.b, paramToServiceMsg);
    }
    a(jdField_a_of_type_Int, true, paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\VIPAioSendHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */