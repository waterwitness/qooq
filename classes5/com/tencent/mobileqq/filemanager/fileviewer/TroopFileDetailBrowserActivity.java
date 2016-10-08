package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.CanPreviewOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingTroopFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopPhotoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.TroopFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.report.TroopClickReport;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFilePreviewController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import sht;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements IFileBrowser
{
  public static final String b = "is_in_zip";
  public static final String c = "bisId";
  public static final int d = 0;
  public static final String d = "from_webview";
  public static final int e = 1;
  public static final String e = "sender_uin";
  public static final int f = 2;
  public static final String f = "last_time";
  public static final int g = 3;
  public static final String g = "from_type_troop";
  public static final int h = -1;
  public static final int j = 10099;
  protected FMObserver a;
  public ForwardFileInfo b;
  public int i;
  
  public TroopFileDetailBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = -1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new sht(this);
  }
  
  public static int a(Context paramContext)
  {
    if (!NetworkUtil.h(paramContext)) {
      return 2;
    }
    if (NetworkUtil.i(paramContext)) {
      return 0;
    }
    return 1;
  }
  
  protected FileViewBase a()
  {
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) {}
    for (Object localObject = new TroopLocalVideoFileView(this);; localObject = new LocalVideoFileView(this))
    {
      ((FileViewBase)localObject).a(a());
      return (FileViewBase)localObject;
    }
  }
  
  protected void a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
    }
    switch (paramIFileViewerAdapter.d())
    {
    default: 
      super.a(paramIFileViewerAdapter);
      return;
    case 3: 
      if ((FileBrowserActivity.a(this.app, paramIFileViewerAdapter)) && (!getIntent().getBooleanExtra("is_in_zip", false))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.e();
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent instanceof TroopClickReport))
      {
        ((TroopClickReport)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent).d = "1";
        return;
        super.a(paramIFileViewerAdapter);
      }
    }
    if ((FileBrowserActivity.a(this.app, paramIFileViewerAdapter)) && (!getIntent().getBooleanExtra("is_in_zip", false)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.e();
      return;
    }
    if ((paramIFileViewerAdapter.a().isZipInnerFile) && (FileBrowserActivity.a(this.app, paramIFileViewerAdapter)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
      return;
    }
    if (((FileBrowserActivity.a(this.app, paramIFileViewerAdapter)) || (paramIFileViewerAdapter.d())) && (paramIFileViewerAdapter.a() > paramIFileViewerAdapter.d()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.f();
      ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_Clk_onlinepreview", 0, 0, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() + "", "", "", "");
      return;
    }
    if (((FileBrowserActivity.a(this.app, paramIFileViewerAdapter)) || (paramIFileViewerAdapter.d())) && (paramIFileViewerAdapter.a() <= paramIFileViewerAdapter.d()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = g();
      ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_Clk_onlinepreview", 0, 0, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() + "", "", "", "");
      return;
    }
    switch (paramIFileViewerAdapter.b())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.c();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = super.d();
  }
  
  protected void a(boolean paramBoolean)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
      }
      label136:
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.c();
          break;
          if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null) || ((!(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase instanceof PreviewingTroopFileView)) && (!(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase instanceof CanPreviewOfflineFileView)))) {
            break label136;
          }
        } while (!FileUtil.b(super.a().b()));
        if (super.a().d() != 3) {
          break;
        }
        a(paramBoolean, a());
        break;
        if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null) && (LocalSimpleFileView.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase))) {
          break;
        }
        super.a().removeAllViews();
        if ((this.c == 10006) && (super.a().f()) && (!FileBrowserActivity.a(this.app, super.a())))
        {
          localObject = TroopFileUtils.a(super.a(), super.a().a());
          this.app.a().a(new TroopFilePreviewController(this.app, super.a().a().TroopUin, (TroopFileStatusInfo)localObject));
          super.a().a(false);
          localObject = new Intent(this, FilePreviewActivity.class);
          ((Intent)localObject).putExtra("offline_file_type", 0);
          ((Intent)localObject).putExtra("offline_file_name", super.a().a());
          ((Intent)localObject).putExtra("offline_file_size", super.a().a());
          super.startActivity((Intent)localObject);
          super.overridePendingTransition(2130968602, 2130968604);
        }
        a(super.a());
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(super.a());
      super.a().addView((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.d();
      super.d();
    }
  }
  
  protected boolean a(Intent paramIntent)
  {
    if (this.app != null) {
      this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.i = paramIntent.getIntExtra("from_type_troop", -1);
    Object localObject = new TroopFileViewerParamParser(this.app);
    if (!((TroopFileViewerParamParser)localObject).a(paramIntent, this)) {}
    label150:
    do
    {
      do
      {
        return false;
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
        this.jdField_a_of_type_Int = ((TroopFileViewerParamParser)localObject).a();
        switch (this.jdField_a_of_type_Int)
        {
        }
      } while (!QLog.isDevelopLevel());
      throw new NullPointerException("未知的mFileViewerType");
      this.jdField_a_of_type_JavaUtilList = ((TroopFileViewerParamParser)localObject).a();
      this.jdField_b_of_type_Int = 0;
      a(super.a());
      super.setContentViewNoTitle(2130904019);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(super.a());
    super.a().addView(paramIntent);
    if (this.jdField_a_of_type_Int == 1) {
      ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() + "", this.c + "", a(getApplicationContext()) + "", FileManagerUtil.b(FileManagerUtil.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d())));
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_JavaUtilList = ((TroopFileViewerParamParser)localObject).a();
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase = new TroopPhotoFileView(this, this.app, super.a(), this.jdField_b_of_type_Int);
      break label150;
      this.jdField_a_of_type_JavaUtilList = ((TroopFileViewerParamParser)localObject).a();
      this.jdField_b_of_type_Int = 0;
      paramIntent = a();
      if ((paramIntent == null) || (!(paramIntent instanceof TroopFileViewerAdapter))) {
        break;
      }
      localObject = ((TroopFileViewerAdapter)paramIntent).a;
      if ((FileBrowserActivity.a(this.app, paramIntent)) && (!getIntent().getBooleanExtra("is_in_zip", false))) {}
      for (int k = 1;; k = 0)
      {
        if ((k == 0) && (paramIntent.b() != null) && ((localObject == null) || ((((TroopFileStatusInfo)localObject).jdField_b_of_type_Int != 7) && (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int != 9) && (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int != 10) && (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int != 8)))) {
          break label498;
        }
        a(paramIntent);
        break;
      }
      label498:
      setContentViewNoTitle(2130904019);
      if (!a(true, paramIntent)) {
        break label150;
      }
      return true;
      ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a() + "", this.c + "", a(getApplicationContext()) + "", FileManagerUtil.b(FileManagerUtil.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d())));
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getExtras() == null) || (this.c != 10006)) || ((paramInt2 == -1) && (paramInt1 == 10099) && (paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))))
    {
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if ((bool) && (a() != null))
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.a();
      if ((!a().a().isZipInnerFile) && (a(a(), a())))
      {
        paramBundle = paramBundle.a(0);
        paramBundle.setBackgroundResource(2130843127);
        paramBundle.setTextColor(Color.parseColor("#00a5e0"));
      }
    }
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  protected FileViewBase g()
  {
    PreviewingTroopFileView localPreviewingTroopFileView = new PreviewingTroopFileView(this, this.app);
    localPreviewingTroopFileView.a(super.a());
    String str = FMConfig.a(getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    int k;
    if (str != null) {
      k = 0;
    }
    try
    {
      int m = Integer.parseInt(str);
      k = m;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (1 == k) {
      super.setRequestedOrientation(-1);
    }
    return localPreviewingTroopFileView;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent == null) {
      if (super.a().d() != 3) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      TroopClickReport localTroopClickReport = new TroopClickReport(super.a(), getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a(), this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d(), bool);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = localTroopClickReport;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport = localTroopClickReport;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\TroopFileDetailBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */