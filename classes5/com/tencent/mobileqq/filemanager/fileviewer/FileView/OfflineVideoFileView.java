package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqDownloadFileObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import sfy;
import sga;
import sgb;
import sgc;
import sgd;

public class OfflineVideoFileView
  extends OfflineVideoFileViewBase
  implements View.OnClickListener
{
  protected static final int a = 1;
  public static final String a = "troop_troopfile_video_cloudPlay";
  protected static final int b = 2;
  protected static final int c = 3;
  protected static final int d = 4;
  private static final String d = "OfflineVideoFileView";
  protected static final int e = 5;
  public Handler a;
  public TextView a;
  public TroopFileProtocol.ReqDownloadFileObserver a;
  public IphoneTitleBarActivity a;
  public FileManagerEntity a;
  private final OfflineVideoFileViewBase.IControllProxyInterface a;
  public boolean a;
  public TextView b;
  public String b;
  public String c;
  public int f;
  
  public OfflineVideoFileView(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new sga(this);
    this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver = new sgb(this);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = ((IphoneTitleBarActivity)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileViewBase$IControllProxyInterface = new sgd(this, paramQQAppInterface);
    a().a();
  }
  
  protected OfflineVideoFileViewBase.IControllProxyInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewOfflineVideoFileViewBase$IControllProxyInterface;
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.c = null;
    super.a();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app.getManager(51);
    if (localTroopManager == null) {
      return false;
    }
    TroopInfo localTroopInfo = localTroopManager.a(String.valueOf(paramFileManagerEntity.TroopUin));
    if (localTroopInfo == null) {
      return false;
    }
    if (NetConnInfoCenter.getServerTimeMillis() <= localTroopInfo.mTroopFileVideoReqInterval)
    {
      this.f = localTroopInfo.mTroopFileVideoIsWhite;
      if (localTroopInfo.mTroopFileVideoIsWhite != 0) {
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3));
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4));
      }
    }
    TroopFileVideoOnlinePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app, paramFileManagerEntity.TroopUin, new sgc(this, localTroopInfo, localTroopManager));
    return true;
  }
  
  public void b() {}
  
  public boolean b()
  {
    this.jdField_b_of_type_AndroidAppActivity.setRequestedOrientation(1);
    return false;
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b() != 2) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d() != 4))
    {
      super.f();
      return;
    }
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
    super.f();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300891));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301027));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1));
    ThreadManager.a(new sfy(this), 8, null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity == null);
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131362941, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "clickPlay url = " + this.jdField_b_of_type_JavaLangString + ", cookie = " + this.c);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, VipVideoPlayActivity.class);
      paramView.putExtra("vtype", 2);
      paramView.putExtra("video_url", this.jdField_b_of_type_JavaLangString);
      paramView.putExtra("video_url_cookies", "FTN5K=" + this.c);
      paramView.putExtra("screenOrientation", "portrait");
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivityForResult(paramView, 100);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
        break label278;
      }
    }
    label278:
    for (String str = FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType);; str = "unknow")
    {
      ReportController.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramView, "", str, "1");
      return;
      paramView = "";
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\FileView\OfflineVideoFileView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */