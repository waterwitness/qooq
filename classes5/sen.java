import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.ImmersiveUtils;

class sen
  implements Runnable
{
  sen(sem paramsem, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localObject = (RelativeLayout)this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.findViewById(2131298651);
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.a(this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity), 0, 0);
    }
    if (this.jdField_a_of_type_Boolean == true) {
      this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = FileBrowserActivity.a(this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity);
    }
    for (;;)
    {
      this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
      localObject = this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.a());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.a().removeAllViews();
      this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.a().addView((View)localObject, 0, localLayoutParams);
      this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.d();
      return;
      switch (this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b())
      {
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = FileBrowserActivity.a(this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity);
        break;
      case 5: 
        this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = FileBrowserActivity.b(this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity);
        break;
      case 1: 
        this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = FileBrowserActivity.c(this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity);
        break;
      case 2: 
        this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.a();
        break;
      case 0: 
        this.jdField_a_of_type_Sem.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.f();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */