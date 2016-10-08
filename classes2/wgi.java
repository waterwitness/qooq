import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class wgi
  implements DialogInterface.OnClickListener
{
  public wgi(String paramString, BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("isShowAd", false);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramDialogInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */