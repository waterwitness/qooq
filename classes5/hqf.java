import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.PublicAccountManagePopBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

class hqf
  implements Runnable
{
  hqf(hqe paramhqe, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + PublicAccountManagePopBar.a(this.jdField_a_of_type_Hqe.a).app.a(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("public_account_manage_contacts_enter_time", this.jdField_a_of_type_Long);
      ((SharedPreferences.Editor)localObject).putLong("public_account_manage_activity_enter_time", this.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */