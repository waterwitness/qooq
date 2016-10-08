import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sed
  implements View.OnClickListener
{
  public sed(BaseQfileActionBar paramBaseQfileActionBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = null;
    paramView = (View)localObject;
    switch (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType)
    {
    default: 
      paramView = (View)localObject;
    }
    for (;;)
    {
      if (paramView != null) {
        FileManagerReporter.a(paramView);
      }
      this.a.d();
      this.a.j();
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f())
      {
        paramView = "0X8004BB7";
      }
      else
      {
        paramView = "0X8004BCD";
        continue;
        if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f())
        {
          paramView = "0X8004BB8";
        }
        else
        {
          paramView = "0X8004BCE";
          continue;
          if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f()) {
            paramView = "0X8004BB9";
          } else {
            paramView = "0X8004BCF";
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */