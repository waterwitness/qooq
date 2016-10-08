import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.GuideViewBuilder;

public class wmh
  implements View.OnClickListener
{
  public wmh(GuideViewBuilder paramGuideViewBuilder, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */