import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.PublicAccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class hpx
  implements Runnable
{
  public hpx(PublicAccountManageActivity paramPublicAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.a.app.a(), 0);
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putLong("public_account_manage_status_close_time", PublicAccountManageActivity.a(this.a));
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManageActivity", 2, "closeStatusBar->mLastCloseTime:" + PublicAccountManageActivity.a(this.a));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */