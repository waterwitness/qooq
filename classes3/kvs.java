import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kvs
  implements DialogInterface.OnDismissListener
{
  public kvs(ChatHistory paramChatHistory, View paramView1, int paramInt, View paramView2, TranslateAnimation paramTranslateAnimation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    paramDialogInterface = (MessageSearchDialog)paramDialogInterface;
    int i = paramDialogInterface.a();
    boolean bool = paramDialogInterface.a();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onDismiss, recordCount : " + i);
    }
    if (i <= 0) {}
    int j;
    do
    {
      return;
      j = (i - 1) / 8 + 1;
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "onDismiss, pageIndex = " + j);
      }
    } while (j < 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_Int = ((i - 1) % 8);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(j));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.leftView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131367975));
      return;
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getIntent().getExtras().getString("leftViewText");
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.leftView.setText(paramDialogInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */