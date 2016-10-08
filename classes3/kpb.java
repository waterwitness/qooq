import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XEditTextEx;

public class kpb
  implements View.OnClickListener
{
  public kpb(BaseChatPie paramBaseChatPie, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("0"))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    paramView.insert(i, this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramView.length());
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */