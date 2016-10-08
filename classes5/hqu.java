import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.PublicAccountManager.refuseAcceptDone;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetRefuseFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class hqu
  implements BusinessObserver
{
  public hqu(PublicAccountManager paramPublicAccountManager, NewIntent paramNewIntent, PublicAccountManager.refuseAcceptDone paramrefuseAcceptDone)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountManager", 2, "success:" + String.valueOf(paramBoolean));
    }
    bool = paramBoolean;
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      mobileqq_mp.SetRefuseFollowResponse localSetRefuseFollowResponse = new mobileqq_mp.SetRefuseFollowResponse();
      localSetRefuseFollowResponse.mergeFrom(paramBundle);
      bool = paramBoolean;
      if (localSetRefuseFollowResponse.ret_info.has())
      {
        bool = paramBoolean;
        if (localSetRefuseFollowResponse.ret_info.ret_code.has())
        {
          paramInt = localSetRefuseFollowResponse.ret_info.ret_code.get();
          bool = paramBoolean;
          if (paramInt != 0L) {
            bool = false;
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bool = false;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$refuseAcceptDone != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$refuseAcceptDone.a(bool);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */