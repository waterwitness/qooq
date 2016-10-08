import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class klx
  extends BusinessCardObserver
{
  public klx(AutoRemarkActivity paramAutoRemarkActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.a.d == 1)
    {
      if (!paramBoolean)
      {
        AutoRemarkActivity.j(this.a);
        AutoRemarkActivity.a(this.a, "修改名片备注失败");
      }
    }
    else {
      return;
    }
    paramString = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (paramString.length() != 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.a.jdField_f_of_type_JavaLangString, paramString, false);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_f_of_type_JavaLangString, (byte)this.a.jdField_f_of_type_Int, (byte)0);
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, "isSuccess: " + paramBoolean + " cardId:" + paramString + " result:" + paramInt);
    }
    if (this.a.d == 1)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.b(this.a.jdField_f_of_type_JavaLangString);
      if (!paramBoolean)
      {
        AutoRemarkActivity.i(this.a);
        if (paramInt != 66) {
          AutoRemarkActivity.a(this.a, this.a.getResources().getString(2131371271));
        }
      }
    }
    while (paramBoolean)
    {
      return;
      QQToast.a(this.a, 1, 2131371272, 0).b(this.a.getTitleBarHeight());
      for (;;)
      {
        paramString = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
        if (paramString.length() == 0) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.a.jdField_f_of_type_JavaLangString, paramString, false);
        return;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl))) {
          this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(false);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_f_of_type_JavaLangString, (byte)this.a.jdField_f_of_type_Int, (byte)0);
      return;
    }
    if (paramInt == 66)
    {
      QQToast.a(this.a, 1, "名片数量超过上限", 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, 1, "名片创建失败", 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */