import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kgm
  extends ClickableSpan
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  
  public kgm(AboutActivity paramAboutActivity, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.startActivity(paramView.putExtra("url", this.jdField_a_of_type_JavaLangString));
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X8005745", "0X8005745", 0, 0, "", "", "", "");
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X8005746", "0X8005746", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16754769);
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */