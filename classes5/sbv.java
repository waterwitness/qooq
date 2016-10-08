import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView.MPFileVerifyPswEvent;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sbv
  implements MPFileVerifyPwdView.MPFileVerifyPswEvent
{
  public sbv(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeView(this.a.jdField_a_of_type_AndroidViewView);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.a();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = null;
  }
  
  public void a(long paramLong)
  {
    BaseActionBarDataLineFile.a(this.a, paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */