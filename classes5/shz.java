import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.List;

public class shz
  implements Runnable
{
  public shz(FMSettings paramFMSettings, Activity paramActivity, List paramList, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    View localView = RelativeLayout.inflate(this.jdField_a_of_type_AndroidAppActivity, 2130904010, null);
    TextView localTextView = (TextView)localView.findViewById(2131299765);
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b);
    ((TextView)localView.findViewById(2131300983)).setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.c);
    ProgressBar localProgressBar = (ProgressBar)localView.findViewById(2131297885);
    localProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2130903237, "下载通知", this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b + '\n' + this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.c, "取消", "确定", new sia(this, localTextView, localProgressBar), new sif(this)).addView(localView);
    FileManagerReporter.a("0X8005BE1");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.show();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */