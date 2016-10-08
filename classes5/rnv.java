import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Random;

public class rnv
  implements View.OnClickListener
{
  public rnv(FilePreviewActivity paramFilePreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.startTitleProgress();
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131370329);
    this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter;
      paramView.a += 1;
    }
    int i = new Random(System.currentTimeMillis()).nextInt(1500);
    new Handler().postDelayed(new rnw(this), i % 1001 + 500);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */