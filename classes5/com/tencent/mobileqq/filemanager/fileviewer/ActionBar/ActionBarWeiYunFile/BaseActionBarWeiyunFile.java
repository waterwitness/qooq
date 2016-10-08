package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarWeiYunFile;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import sdt;
import sdv;

public class BaseActionBarWeiyunFile
  extends BaseQfileActionBar
{
  protected String a;
  private boolean a;
  
  public BaseActionBarWeiyunFile(View paramView)
  {
    super(paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "BaseActionBarWeiyunFile<FileAssistant>";
    if (FileManagerUtil.b()) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {}
    for (String str = "继续发送";; str = "继续下载")
    {
      a(0, str, new sdv(this));
      return;
    }
  }
  
  public void a(Activity paramActivity)
  {
    a(0, "下载(" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a()) + ")", new sdt(this));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = ((IFileViewerAdapter)paramObject).a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      paramObject = ((IFileViewerAdapter)paramObject).a();
      if (paramObject == null)
      {
        if (QLog.isDevelopLevel()) {
          throw new NullPointerException("丫的类型是不是搞错了？！");
        }
      }
      else
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "###get Entity null###");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileManagerUtil.a((WeiYunFileInfo)paramObject);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 2) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 1) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 4) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 20)) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a() <= this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().d()))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getId() == -1L)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
        k();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
        FileManagerReporter.a("0X8005BFF");
      }
      a(1, "转发", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 10003, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 3)) {
        break label364;
      }
      a();
    }
    for (;;)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      a(2, FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      if (16 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
      {
        a(0, false);
        a(1, false);
        a(2, false);
      }
      return;
      label364:
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 2) {
        k();
      } else {
        a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      }
    }
  }
  
  public void b(Activity paramActivity)
  {
    if (FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
      b(paramActivity, "收藏", 2130840330, 2130840331, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    super.b(paramActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\ActionBarWeiYunFile\BaseActionBarWeiyunFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */