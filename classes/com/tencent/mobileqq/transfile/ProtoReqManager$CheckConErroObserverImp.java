package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.CheckConErroObserver;

public class ProtoReqManager$CheckConErroObserverImp
  extends CheckConErroObserver
{
  ProtoReqManager.ProtoReq jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq;
  ProtoReqManager.ProtoResp jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp;
  
  public ProtoReqManager$CheckConErroObserverImp(ProtoReqManager paramProtoReqManager, ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp = paramProtoResp;
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq = paramProtoReq;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getString("msf_con_erro");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + paramBundle);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp.a;
        if (localObject != null) {
          ((FromServiceMsg)localObject).addAttribute("_tag_socket_connerror", paramBundle);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq.a.a(this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoResp, this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\ProtoReqManager$CheckConErroObserverImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */