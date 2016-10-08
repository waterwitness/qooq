import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.PublicAccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class hpu
  implements Runnable
{
  public hpu(PublicAccountManageActivity paramPublicAccountManageActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageActivity.app.a(), 0);
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putBoolean("public_account_manage_notify", this.jdField_a_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManageActivity", 2, "changeNotification->isOpen:" + this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */