import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class rop
  implements View.OnClickListener
{
  public rop(LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.c();
    }
    paramView = (Button)paramView.findViewById(2131298227);
    if (paramView.getTag() != null)
    {
      this.a.d = ((Integer)paramView.getTag()).intValue();
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
      }
    }
    this.a.l();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */