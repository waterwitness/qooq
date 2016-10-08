package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import sgo;

public class PreviewingTroopFileView
  extends PreviewingOfflineFileViewBase
{
  public static final String a = "PreviewingTroopFileView";
  private final PreviewingOfflineFileViewBase.IControllProxyInterface a;
  
  public PreviewingTroopFileView(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface = new sgo(this, paramQQAppInterface);
  }
  
  protected PreviewingOfflineFileViewBase.IControllProxyInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase$IControllProxyInterface;
  }
  
  public IFileViewerAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\PreviewingTroopFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */