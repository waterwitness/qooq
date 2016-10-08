import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class kiq
  extends FriendListObserver
{
  public kiq(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString1, AddFriendVerifyActivity.a(this.a))) && (!TextUtils.isEmpty(paramString2))) {
      AddFriendVerifyActivity.b(this.a).setText(paramString2);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!AddFriendVerifyActivity.a(this.a).equals(paramString)) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.a.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim(), paramBundle.getByteArray("sig"));
        return;
      }
      if ((paramBundle.getString("ErrorString") != null) && (!paramBundle.getString("ErrorString").trim().equals(""))) {}
      for (paramString = paramBundle.getString("ErrorString");; paramString = this.a.getString(2131368668))
      {
        QQToast.a(this.a, 1, paramString, 1).b(this.a.getTitleBarHeight());
        return;
      }
    }
    QQToast.a(this.a, 1, this.a.getString(2131368654), 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kiq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */