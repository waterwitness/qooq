package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import sbj;
import sbl;
import sbo;

public class ActionBarDataLineCloudFile
  extends BaseQfileActionBar
{
  private static final String jdField_a_of_type_JavaLangString = ActionBarDataLineCloudFile.class.getSimpleName();
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ActionBarDataLineCloudFile(View paramView)
  {
    super(paramView);
    if (FileManagerUtil.b()) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 31) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 29);
  }
  
  private void e()
  {
    long l = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 8) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 1)) {}
    for (localObject = ((Activity)localObject).getString(2131362803) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";; localObject = ((Activity)localObject).getString(2131362804) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")")
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  private void f()
  {
    DataLineHandler localDataLineHandler;
    int i;
    DataLineMsgRecord localDataLineMsgRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
    {
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
      i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(i).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      if (localDataLineMsgRecord != null) {}
    }
    else
    {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localDataLineHandler.b(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          break label184;
        }
        DataLineReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
      if (!localDataLineHandler.a(localArrayList)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(i).c(localDataLineMsgRecord.msgId);
      return;
      label184:
      DataLineReportUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    }
    FMToastUtil.a(2131362191);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
    {
      int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(i).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      if (localDataLineMsgRecord == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(localDataLineMsgRecord);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
  }
  
  public void a()
  {
    String str;
    if (a()) {
      str = "继续上传";
    }
    for (boolean bool = true;; bool = false)
    {
      a(0, str, new sbl(this, bool));
      return;
      str = "继续下载";
    }
  }
  
  public void a(Activity paramActivity)
  {
    a(0, "下载(" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a()) + ")", new sbj(this));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("丫的类型是不是搞错了？！");
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a() <= this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().d()))
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
        {
          int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
          paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(i).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
          if (paramObject != null) {
            ((DataLineMsgSet)paramObject).setPaused(false);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
        f();
        k();
        FileManagerReporter.a("0X8005BFF");
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 2) {
        break label423;
      }
      k();
      a(1, "转发", ActionBarUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 10009, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      a(1, false);
      if (FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
        super.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "收藏", 2130840330, 2130840331, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      }
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromrMolo) {
        break label479;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
        a(1, false);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16)
      {
        a(0, false);
        a(1, false);
        a(2, false);
      }
      return;
      label423:
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 0) || ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 3) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress != 0.0F)))
      {
        a();
        break;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      break;
      label479:
      if ((a()) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0))
        {
          a(0, false);
          a(1, false);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 1)
      {
        a(0, false);
        a(1, false);
      }
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("丫的类型是不是搞错了？！");
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new sbo(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
  }
  
  protected void d()
  {
    DataLineHandler localDataLineHandler;
    DataLineMsgRecord localDataLineMsgRecord;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 6) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L))
    {
      localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
      int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(i).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      if (localDataLineMsgRecord == null) {
        return;
      }
      if ((localDataLineMsgRecord.strMoloKey == null) || (!DataLineMsgSet.isSingle(localDataLineMsgRecord))) {
        break label145;
      }
      if (!localDataLineMsgRecord.isReportPause)
      {
        localDataLineMsgRecord.isReportPause = true;
        DataLineReportUtil.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      }
    }
    for (;;)
    {
      localDataLineHandler.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
      return;
      label145:
      if ((!localDataLineMsgRecord.isReportPause) && (localDataLineMsgRecord.msgtype == 63201))
      {
        localDataLineMsgRecord.isReportPause = true;
        DataLineReportUtil.m(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\ActionBarDataLineFile\ActionBarDataLineCloudFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */