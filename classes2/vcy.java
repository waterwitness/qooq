import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;

public class vcy
  implements Runnable
{
  public vcy(AbsPublishActivity paramAbsPublishActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130842147);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(this.a.getString(2131364801));
    if (this.a.b != null) {
      this.a.b.requestLayout();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vcy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */