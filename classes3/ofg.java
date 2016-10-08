import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ofg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ofg(BlessActivity paramBlessActivity, RelativeLayout paramRelativeLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    BlessActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
    BlessActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth());
    BlessActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */