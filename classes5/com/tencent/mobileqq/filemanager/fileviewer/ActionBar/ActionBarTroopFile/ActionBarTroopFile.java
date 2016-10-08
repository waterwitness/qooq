package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.DownloadFileConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import scu;
import scv;
import scw;
import scx;
import scy;
import scz;
import sda;
import sdb;
import sdc;

public class ActionBarTroopFile
  extends BaseActionBar
{
  public static final String a = "troopFileActionbar";
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  public FileManagerEntity a;
  public IFileBrowser a;
  private TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  private boolean jdField_a_of_type_Boolean;
  private LinearLayout b;
  public String b;
  
  public ActionBarTroopFile(View paramView)
  {
    super(paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = true;
  }
  
  private View.OnClickListener a()
  {
    return new sdb(this);
  }
  
  private BizTroopObserver a()
  {
    return new scv(this);
  }
  
  private View.OnClickListener b()
  {
    return new sdc(this);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.c.findViewById(2131300909));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.c.findViewById(2131300913));
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300912)).setOnClickListener(new scu(this));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300911));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300910));
  }
  
  private void g()
  {
    boolean bool2 = true;
    super.a(1, "转发", b());
    if (FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
      super.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "收藏", 2130840330, 2130840331, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    if (DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
      super.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "发送到电脑", 2130840326, 2130840327, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    super.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "存到微云", 2130840340, 2130840341, a());
    super.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
    super.a(0, true);
    if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2c2cOrDiscItem()) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2DatalineItem()))
    {
      bool1 = true;
      super.a(1, bool1);
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2c2cOrDiscItem()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2DatalineItem())) {
        break label256;
      }
    }
    label256:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      super.a(2, bool1);
      a(TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      return;
      bool1 = false;
      break;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
  }
  
  private void i()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (localTroopFileStatusInfo.jdField_b_of_type_Int == 8)) {
      localTroopFileTransferManager.f(UUID.fromString(this.jdField_b_of_type_JavaLangString));
    }
  }
  
  protected void H_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("troopFileActionbar", 4, String.format("update file info: status:%d fileName:%s errorCode:%d", new Object[] { Integer.valueOf(paramTroopFileStatusInfo.jdField_b_of_type_Int), paramTroopFileStatusInfo.g, Integer.valueOf(paramTroopFileStatusInfo.jdField_c_of_type_Int) }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2c2cOrDiscItem()) {
      super.a(0, "继续上传", new scw(this));
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isFromProcessingForward2DatalineItem())
      {
        super.a(0, "继续上传", new scx(this));
        return;
      }
      switch (paramTroopFileStatusInfo.jdField_b_of_type_Int)
      {
      default: 
        return;
      case 7: 
        super.a(0, "下载(" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a()) + ")", new scy(this, paramTroopFileStatusInfo));
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
        {
          a(1, false);
          a(2, false);
        }
        b();
        return;
      case 8: 
        e();
        localObject = new StringBuilder(20);
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131362804));
        ((StringBuilder)localObject).append(String.format("(%s/%s)", new Object[] { FileUtil.a(paramTroopFileStatusInfo.jdField_c_of_type_Long), FileUtil.a(paramTroopFileStatusInfo.jdField_b_of_type_Long) }));
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        if (paramTroopFileStatusInfo.jdField_b_of_type_Long > 0L) {
          this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramTroopFileStatusInfo.jdField_c_of_type_Long * 100L / paramTroopFileStatusInfo.jdField_b_of_type_Long));
        }
        break;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile);
    a(1, false);
    a(2, false);
    return;
    super.a(0, "继续下载", new scz(this));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
    {
      a(1, false);
      a(2, false);
    }
    b();
    return;
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().lastTime;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().selfUin;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().bSend;
    paramTroopFileStatusInfo = FileManagerUtil.a(paramTroopFileStatusInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().copyFrom(paramTroopFileStatusInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().lastTime = l;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().selfUin = ((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().bSend = bool;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().d() == 3) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.postDelayed(new sda(this), 10L);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
    {
      a(1, true);
      a(2, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("troopFileActionbar", 2, "file download finished, but file not exist.");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().finish();
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IFileBrowser)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = ((IFileBrowser)paramObject);
    }
    while (!QLog.isDevelopLevel())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
        break;
      }
      if (!QLog.isDevelopLevel()) {
        return;
      }
      throw new NullPointerException("丫的类型是不是搞错了？！");
    }
    throw new NullPointerException("init类型错误,请检查堆栈");
    paramObject = ZipPreviewFileView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a());
    paramObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getManager(51)).a((String)paramObject);
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
    if ((this.jdField_a_of_type_Boolean) && (((FileManagerUtil.a()) && (l < ((TroopManager.DownloadFileConfig)paramObject).jdField_c_of_type_Int)) || ((FileManagerUtil.b()) && (l < ((TroopManager.DownloadFileConfig)paramObject).a))))
    {
      this.jdField_a_of_type_Boolean = false;
      d();
      FileManagerReporter.a("0X8005BFF");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), "dc00899", "Grp_files", "", "detail", "num_down", 0, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin + "", "", TroopFileDetailBrowserActivity.a(this.c.getContext()) + "", FileManagerUtil.b(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName)));
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFileID;
    f();
    g();
    h();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void c()
  {
    i();
  }
  
  public void d()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (localTroopFileStatusInfo.a != null)) {
      this.jdField_b_of_type_JavaLangString = localTroopFileStatusInfo.a.toString();
    }
    TroopFileItemOperation localTroopFileItemOperation = new TroopFileItemOperation(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
    if ((localTroopFileStatusInfo.jdField_b_of_type_Int == 10) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 9)) {
      if (localTroopFileStatusInfo.a != null) {
        localTroopFileItemOperation.b(localTroopFileStatusInfo.a);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      return;
      if (localTroopFileStatusInfo.jdField_b_of_type_Int == 7) {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile) {
          localTroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        } else {
          localTroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_b_of_type_Long, localTroopFileStatusInfo.e);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\ActionBarTroopFile\ActionBarTroopFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */