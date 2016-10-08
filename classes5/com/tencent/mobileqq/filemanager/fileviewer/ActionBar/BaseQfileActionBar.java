package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import sed;
import see;

public abstract class BaseQfileActionBar
  extends BaseActionBar
{
  protected Button a;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  protected FMObserver a;
  public FileManagerEntity a;
  public IFileBrowser a;
  private final String jdField_a_of_type_JavaLangString;
  LinearLayout b;
  
  public BaseQfileActionBar(View paramView)
  {
    super(paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "BaseActionBar<FileAssistant>";
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.b = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.c.findViewById(2131300909));
    this.b = ((LinearLayout)this.c.findViewById(2131300913));
  }
  
  public void H_()
  {
    c();
  }
  
  public abstract void a();
  
  public abstract void a(Activity paramActivity);
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IFileBrowser))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = ((IFileBrowser)paramObject);
      b();
    }
    while (!QLog.isDevelopLevel()) {
      return;
    }
    throw new NullPointerException("init类型错误,请检查堆栈");
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseActionBar<FileAssistant>", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is added");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new see(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseActionBar<FileAssistant>", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is delete");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.b.setVisibility(0);
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    a();
  }
  
  public void k()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.b.setVisibility(8);
    if (this.jdField_a_of_type_AndroidWidgetButton == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300912));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new sed(this));
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300911));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
    }
    long l;
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300910));
      l = ((float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 29) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType != 6) && ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 8) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 1) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType == 5))) {
        break label295;
      }
    }
    label295:
    for (String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131362803) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")";; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131362804) + "(" + FileUtil.a(l) + "/" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + ")")
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\BaseQfileActionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */