import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class klz
  extends FriendListObserver
{
  private klz(AutoRemarkActivity paramAutoRemarkActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.d == 1)
    {
      if (paramString != null) {
        break label40;
      }
      AutoRemarkActivity.h(this.a);
      AutoRemarkActivity.a(this.a, this.a.getString(2131368654));
    }
    label40:
    while (!paramString.equals(this.a.jdField_f_of_type_JavaLangString)) {
      return;
    }
    this.a.setResult(-1);
    this.a.finish();
    this.a.overridePendingTransition(2130968589, 2130968795);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((this.a.d == 1) && (TextUtils.equals(paramString1, this.a.jdField_f_of_type_JavaLangString)))
    {
      this.a.getIntent().getLongExtra("k_msg_key", 0L);
      if ((paramBoolean) && (NetworkUtil.e(this.a)))
      {
        this.a.h = 0;
        this.a.jdField_f_of_type_JavaLangString = paramString1;
        this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_f_of_type_JavaLangString, (byte)this.a.jdField_f_of_type_Int, (byte)0);
      }
    }
    else
    {
      return;
    }
    if ((this.a.h == 2) || (!NetworkUtil.e(this.a)))
    {
      AutoRemarkActivity.g(this.a);
      AutoRemarkActivity.a(this.a, this.a.getString(2131368654));
      return;
    }
    paramString2 = this.a;
    paramString2.h += 1;
    this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(paramString1, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(this.a.jdField_f_of_type_JavaLangString, paramString1)) {
      return;
    }
    if (paramBoolean)
    {
      if (!AutoRemarkActivity.a(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo remark = " + paramString2);
        }
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString2);
      }
      try
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
        if (AppSetting.j) {
          AutoRemarkActivity.a(this.a).setContentDescription(this.a.getResources().getString(2131367739) + this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
        }
        this.a.jdField_f_of_type_Int = paramInt;
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.a(this.a.jdField_f_of_type_Int));
        return;
      }
      catch (IndexOutOfBoundsException paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AutoRemarkActivity", 2, "onGetAutoInfo | IndexOutOfBoundsException");
          }
        }
      }
    }
    this.a.jdField_f_of_type_Int = 0;
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.a(this.a.jdField_f_of_type_Int));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.equals(paramString, this.a.jdField_f_of_type_JavaLangString)) {}
    do
    {
      return;
      if (paramBoolean1)
      {
        if (paramBundle.getInt("resultCode") == 0)
        {
          int i = paramBundle.getInt("friend_setting");
          if (paramBundle.getString("nick_name") == null) {}
          switch (i)
          {
          default: 
            AutoRemarkActivity.d(this.a);
            QQToast.a(this.a, 2, 2131368655, 0).b(this.a.getTitleBarHeight());
            this.a.a();
            return;
          case 0: 
          case 100: 
            AutoRemarkActivity.b(this.a);
            QQToast.a(this.a, 2, 2131369493, 0).b(this.a.getTitleBarHeight());
            this.a.a();
            return;
          }
          AutoRemarkActivity.c(this.a);
          QQToast.a(this.a, 2, 2131368655, 0).b(this.a.getTitleBarHeight());
          this.a.a();
          return;
        }
        AutoRemarkActivity.e(this.a);
        paramBundle = paramBundle.getString("ErrorString");
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "add friend response error and ErroString = " + paramBundle);
        }
        paramString = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          paramString = this.a.getString(2131368654);
        }
        AutoRemarkActivity.a(this.a, paramString);
        return;
      }
      AutoRemarkActivity.f(this.a);
      AutoRemarkActivity.a(this.a, this.a.getString(2131368654));
    } while (!QLog.isColorLevel());
    QLog.d("AutoRemarkActivity", 2, "add friend response error and isSuccuss = NO");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */