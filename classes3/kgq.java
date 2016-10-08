import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;

public class kgq
  implements Runnable
{
  public kgq(AccountManageActivity paramAccountManageActivity, SimpleAccount paramSimpleAccount, String paramString, ImageView paramImageView1, TextView paramTextView1, TextView paramTextView2, View paramView, ImageView paramImageView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.getManager(60);
    if (localObject1 != null) {}
    Object localObject3;
    Object localObject2;
    for (localObject1 = ((SubAccountManager)localObject1).a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());; localObject2 = null)
    {
      localObject3 = this.jdField_a_of_type_JavaLangString;
      try
      {
        if (((!this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.isLogined()) && ((localObject1 == null) || (((SubAccountInfo)localObject1).subuin == null) || (!((SubAccountInfo)localObject1).subuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin())))) || ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin())))) {
          continue;
        }
        localObject1 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject2 = localObject3;
        }
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.runOnUiThread(new kgr(this, (String)localObject3));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */