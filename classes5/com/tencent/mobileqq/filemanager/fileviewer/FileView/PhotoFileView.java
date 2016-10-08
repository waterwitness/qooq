package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import sgf;

public class PhotoFileView
  extends PhotoFileViewBase
{
  private final PhotoFileViewBase.IControllProxyInterface jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPhotoFileViewBase$IControllProxyInterface;
  private final String jdField_a_of_type_JavaLangString;
  
  public PhotoFileView(Activity paramActivity, QQAppInterface paramQQAppInterface, List paramList, int paramInt)
  {
    super(paramActivity, paramList, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "PhotoFileView";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPhotoFileViewBase$IControllProxyInterface = new sgf(this, paramQQAppInterface);
    a().a();
  }
  
  protected PhotoFileViewBase.IControllProxyInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPhotoFileViewBase$IControllProxyInterface;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\PhotoFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */