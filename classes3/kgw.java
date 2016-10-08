import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.DBUtils;

public class kgw
  implements Runnable
{
  public kgw(AccountManageActivity paramAccountManageActivity, boolean paramBoolean, String paramString, int paramInt)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.a();
      if (localProxyManager != null)
      {
        localProxyManager.c();
        FTSDBManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, this.jdField_a_of_type_JavaLangString, true);
        new MessageRecordManagerImpl().a(this.jdField_a_of_type_JavaLangString);
        DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.a(), this.jdField_a_of_type_JavaLangString, false);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.runOnUiThread(new kgx(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */