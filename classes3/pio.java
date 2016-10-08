import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pio
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public pio(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.c);
    Bitmap localBitmap = TroopMemberListInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.c);
    if (localBitmap == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.c.setTag(localBitmap);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.a == null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopMemberListInnerFrame.a.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */