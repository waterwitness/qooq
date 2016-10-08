package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import sci;

public class ActionBarLocalMusciFile
  extends BaseActionBarLocalFile
{
  public ActionBarLocalMusciFile(View paramView)
  {
    super(paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    a(0, "恢复上传", new sci(this));
  }
  
  public void a(Activity paramActivity)
  {
    c(paramActivity, "用QQ音乐打开", 2130840387, 2130840388, ActionBarUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    c(paramActivity, "用其他应用打开", 2130840332, 2130840333, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    d(paramActivity);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    super.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().e();
    if ((i == 3) || (i == 0))
    {
      a();
      return;
    }
    if (i == 2)
    {
      k();
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\ActionBarLocalFile\ActionBarLocalMusciFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */