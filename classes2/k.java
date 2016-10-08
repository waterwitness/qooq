import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import com.dataline.activities.DLRouterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class k
  implements Runnable
{
  public k(DLRouterActivity paramDLRouterActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.jdField_a_of_type_N.notifyDataSetChanged();
      this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837574);
      this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.jdField_a_of_type_AndroidWidgetGridView.requestFocus();
      return;
    }
    this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837560);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */