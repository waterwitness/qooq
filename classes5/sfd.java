import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.TbsReaderView;

class sfd
  implements View.OnClickListener
{
  sfd(sfc paramsfc, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 5018)
    {
      paramView = this.jdField_a_of_type_Sfc.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
      if (paramView.getWidth() > paramView.getHeight()) {}
      for (int i = 0; i != 0; i = 1)
      {
        this.jdField_a_of_type_Sfc.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
        return;
      }
      this.jdField_a_of_type_Sfc.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      return;
    }
    LocalTbsViewManager.a(this.jdField_a_of_type_Sfc.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager).doCommand(Integer.valueOf(this.jdField_a_of_type_Int), null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */