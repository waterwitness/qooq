package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarAppDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarDataLineCloudFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarMusciDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarOtherDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarPicDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalAppFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalMusciFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalOtherFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalPicFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOfflineFile.BaseActionBarOfflineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOnlineFile.BaseActionBarOnlineFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarWeiYunFile.BaseActionBarWeiyunFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class ActionBarManager
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  BaseActionBar.IActionBarClickEvent jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent;
  BaseActionBar jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar;
  IFileBrowser jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser;
  final String jdField_a_of_type_JavaLangString;
  
  public ActionBarManager(IFileBrowser paramIFileBrowser, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "ActionBarManager<FileAssistant>";
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = paramIFileBrowser;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = paramIActionBarClickEvent;
    c();
  }
  
  public BaseActionBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b().setVisibility(0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b().setVisibility(8);
  }
  
  public void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ActionBarManager<FileAssistant>", 2, "creater actionbar faild, adapteris null!");
      }
    }
    for (;;)
    {
      return;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout)localObject2).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(((RelativeLayout)localObject2).getContext(), 2130903987, null));
      ((RelativeLayout)localObject2).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.H_();
      }
      localObject2 = ((IFileViewerAdapter)localObject1).a();
      if ((localObject2 != null) && (5 != ((FileManagerEntity)localObject2).cloudType)) {
        FileManagerUtil.c((FileManagerEntity)localObject2);
      }
      int i = ((IFileViewerAdapter)localObject1).d();
      int j = ((IFileViewerAdapter)localObject1).b();
      switch (i)
      {
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar == null)
      {
        throw new NullPointerException("your parameter is wrong, pls check your code");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
        switch (j)
        {
        case 2: 
        case 3: 
        case 4: 
        default: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalOtherFile((View)localObject1);
          break;
        case 5: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalAppFile((View)localObject1);
          break;
        case 0: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalPicFile((View)localObject1);
          break;
        case 1: 
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalMusciFile((View)localObject1);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarTroopFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
          continue;
          if (FileUtils.b(((IFileViewerAdapter)localObject1).b()))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
            switch (j)
            {
            case 2: 
            case 3: 
            case 4: 
            default: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarOtherDataLineFile((View)localObject1);
              break;
            case 5: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarAppDataLineFile((View)localObject1);
              break;
            case 0: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarPicDataLineFile((View)localObject1);
              break;
            case 1: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarMusciDataLineFile((View)localObject1);
              break;
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarDataLineCloudFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
            continue;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
            switch (j)
            {
            case 2: 
            case 3: 
            case 4: 
            default: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarOtherDataLineFile((View)localObject1);
              break;
            case 5: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarAppDataLineFile((View)localObject1);
              break;
            case 0: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarPicDataLineFile((View)localObject1);
              break;
            case 1: 
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarMusciDataLineFile((View)localObject1);
              continue;
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new BaseActionBarOfflineFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
              continue;
              if (FileUtil.b(((IFileViewerAdapter)localObject1).b()))
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b();
                switch (j)
                {
                case 2: 
                case 3: 
                case 4: 
                default: 
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalOtherFile((View)localObject1);
                  break;
                case 5: 
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalAppFile((View)localObject1);
                  break;
                case 0: 
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalPicFile((View)localObject1);
                  break;
                case 1: 
                  this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new ActionBarLocalMusciFile((View)localObject1);
                  break;
                }
              }
              else
              {
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new BaseActionBarWeiyunFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
                continue;
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar = new BaseActionBarOnlineFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b());
              }
              break;
            }
          }
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b()) {
        b();
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(1, false);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.a(2, false);
        return;
        a();
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar.H_();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\ActionBarManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */