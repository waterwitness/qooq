import android.content.ClipData;
import android.os.Build.VERSION;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class mjg
  extends ClickableSpan
{
  public mjg(RegisterSendUpSms paramRegisterSendUpSms, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Selection.removeSelection(SpannableString.valueOf(this.jdField_a_of_type_JavaLangString));
    if (Build.VERSION.SDK_INT < 11)
    {
      paramView = (android.text.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms.getSystemService("clipboard");
      if (paramView != null) {
        paramView.setText(RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms));
      }
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms, 2, 2131368532, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms.getTitleBarHeight());
      return;
      paramView = (android.content.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms.getSystemService("clipboard");
      if (paramView != null) {
        paramView.setPrimaryClip(ClipData.newPlainText(RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms), RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms)));
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-15550475);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */