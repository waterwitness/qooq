import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mty
  extends ImageSpan
  implements View.OnClickListener
{
  public mty(TroopMemberCardActivity paramTroopMemberCardActivity, Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext, paramBitmap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.o == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M == 3)) {}
    do
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t);
    } while (paramView == null);
    paramView = TroopMemberCardActivity.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, QQBrowserActivity.class), paramView, "100", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.f(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.x);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */