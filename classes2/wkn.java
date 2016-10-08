import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnSingleClick;

public class wkn
  implements Runnable
{
  public wkn(AnimationTextView paramAnimationTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.getTag(2131296654) != null) {}
    for (boolean bool = ((Boolean)this.a.getTag(2131296654)).booleanValue();; bool = false)
    {
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick != null) && (!bool)) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnSingleClick.a(this.a);
      }
      this.a.setTag(2131296654, Boolean.valueOf(false));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */