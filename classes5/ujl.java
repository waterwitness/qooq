import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.StatusJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class ujl
  implements BusinessObserver
{
  public ujl(StatusJsHandler paramStatusJsHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      this.a.a(2131364487);
      this.a.a(this.a.c, "false");
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break;
        }
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        localFollowResponse.mergeFrom(paramBundle);
        if ((!localFollowResponse.ret_info.has()) || (!((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.has())) {
          break label303;
        }
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType = 1;
          this.a.a(localBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          ((PublicAccountHandler)localBaseActivity.app.a(11)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
          PublicAccountManager.a().a(localBaseActivity.getApplicationContext(), localBaseActivity.app, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, null, true);
          this.a.a(this.a.c, "true");
          return;
        }
        if (paramInt == 58)
        {
          this.a.a(2131364494);
          break;
        }
        this.a.a(2131364487);
      }
      catch (Exception paramBundle) {}
      break;
      label303:
      paramInt = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ujl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */