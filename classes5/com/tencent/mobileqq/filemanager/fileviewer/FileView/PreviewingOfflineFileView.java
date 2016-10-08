package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import sgj;

public class PreviewingOfflineFileView
  extends PreviewingOfflineFileViewBase
{
  private static final String jdField_a_of_type_JavaLangString = "PreviewingOfflineFileView<FileAssistant>";
  private final PreviewingOfflineFileViewBase.IControllProxyInterface jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface;
  
  public PreviewingOfflineFileView(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface = new sgj(this, paramQQAppInterface);
  }
  
  protected PreviewingOfflineFileViewBase.IControllProxyInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface;
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_b_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\PreviewingOfflineFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */