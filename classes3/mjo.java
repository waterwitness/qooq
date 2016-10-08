import android.content.Intent;
import android.os.Handler;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mjo
  extends ClickableSpan
{
  mjo(mjn parammjn, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Selection.removeSelection(SpannableString.valueOf(this.jdField_a_of_type_JavaLangString));
    if (TextUtils.isEmpty(RegisterVerifyCodeActivity.a(this.jdField_a_of_type_Mjn.a))) {}
    while (!RegisterVerifyCodeActivity.b(this.jdField_a_of_type_Mjn.a)) {
      return;
    }
    RegisterVerifyCodeActivity.b(this.jdField_a_of_type_Mjn.a, false);
    this.jdField_a_of_type_Mjn.a.b.postDelayed(new mjp(this), 1000L);
    paramView = new Intent(this.jdField_a_of_type_Mjn.a, QQBrowserActivity.class);
    paramView.putExtra("url", RegisterVerifyCodeActivity.a(this.jdField_a_of_type_Mjn.a));
    paramView.putExtra("hide_more_button", true);
    this.jdField_a_of_type_Mjn.a.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16734752);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */