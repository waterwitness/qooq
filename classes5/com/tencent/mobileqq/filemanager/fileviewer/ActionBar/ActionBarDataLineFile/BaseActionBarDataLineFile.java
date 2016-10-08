package com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.util.DataLineReportUtil;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceGroupChatMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.activity.MPFileFailedView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarUtil;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomSingleButtonDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.MpFileConstant;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import sbp;
import sbq;
import sbr;
import sbs;
import sbt;
import sbu;
import sbv;
import sbw;
import sbx;
import sce;
import scf;

public abstract class BaseActionBarDataLineFile
  extends BaseQfileActionBar
{
  private static final String jdField_c_of_type_JavaLangString = BaseActionBarDataLineFile.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public View a;
  private DeviceFileObserver jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new sbp(this);
  private MPFileFailedView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView;
  public MPFileVerifyPwdView a;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new sbs(this);
  QQCustomSingleButtonDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog;
  protected String a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  public View b;
  protected String b;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BaseActionBarDataLineFile(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = null;
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  private View.OnClickListener a()
  {
    return new sbq(this);
  }
  
  private void a(long paramLong)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
    if (!this.jdField_c_of_type_Boolean)
    {
      QLog.d(jdField_c_of_type_JavaLangString + "[MPFile]", 1, "MPFileDoDownloadWithBuildConnection mConnPCSuc false!");
      return;
    }
    QLog.d(jdField_c_of_type_JavaLangString, 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,connPcSessionId:" + paramLong + ",mEntity.uniseq:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq + ",mEntity.peerDin:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + ",mEntity.fileSize:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    paramLong = localDataLineHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramLong, this.jdField_a_of_type_Int);
    if (paramLong == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "doDownload , plugin service not started");
      }
      FMToastUtil.a(2131362191);
      j();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
  }
  
  private boolean a()
  {
    if (NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getApplication().getApplicationContext()) == 1) {
      return true;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getPreferences().getBoolean("auto_receive_files", false);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.c();
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = new MPFileFailedView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.b();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), new sbw(this), paramInt, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().addView(this.jdField_b_of_type_AndroidViewView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void l()
  {
    a(1, false);
    a(2, false);
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())))
    {
      a(0, false);
      a(1, false);
      a(2, false);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 8)) {}
      return;
      a(0, true);
      a(1, true);
    }
  }
  
  private void n()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new sbu(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction(MpFileConstant.d);
      localIntentFilter.addAction(MpFileConstant.s);
      localIntentFilter.setPriority(200);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void o()
  {
    f();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = new MPFileVerifyPwdView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), new sbv(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().addView(this.jdField_a_of_type_AndroidViewView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new sce(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.dataline.mpfile.download_progress");
      localIntentFilter.addAction("com.dataline.mpfile.download_completed");
      localIntentFilter.setPriority(200);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new scf(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
  }
  
  private void u()
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
  
  private void v()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
    QLog.d(jdField_c_of_type_JavaLangString, 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mConnPCSuc:" + this.jdField_c_of_type_Boolean);
    if (!this.jdField_c_of_type_Boolean)
    {
      if (localDataLineHandler.a().b()) {}
      for (this.jdField_c_of_type_Long = localDataLineHandler.a().a(1);; this.jdField_c_of_type_Long = localDataLineHandler.a().a(2))
      {
        QLog.d(jdField_c_of_type_JavaLangString + "[MPFile]", 1, "MPFile doDownload() mConnPCSuc false,mConnectPcSessionId:" + this.jdField_c_of_type_Long);
        return;
      }
    }
    QLog.d(jdField_c_of_type_JavaLangString, 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mEntity.uniseq:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq + ",mEntity.peerDin:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + ",mEntity.fileSize:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    long l = localDataLineHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    if (l == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "doDownload , plugin service not started");
      }
      FMToastUtil.a(2131362191);
      j();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = l;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
  }
  
  private void w()
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
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
    {
      localObject = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
      int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      ((DataLineHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(i).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq), true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      return;
    }
    Object localObject = (RouterHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(48);
    ArrayList localArrayList = new ArrayList();
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.path = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    localDataLineMsgRecord.msgtype = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0) {
      localDataLineMsgRecord.msgtype = 1;
    }
    for (;;)
    {
      localDataLineMsgRecord.sessionid = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq;
      localDataLineMsgRecord.groupId = 0;
      localDataLineMsgRecord.groupSize = 0;
      localDataLineMsgRecord.groupIndex = 0;
      localArrayList.add(localDataLineMsgRecord);
      ((RouterHandler)localObject).a(localArrayList, true, null, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
        localDataLineMsgRecord.msgtype = 2;
      }
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver == null)
    {
      this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = new sbr(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
    }
    this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {}
    for (Object localObject2 = "恢复发送";; localObject2 = "恢复下载")
    {
      Object localObject1;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 7) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq != 0L))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 6)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0)
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress != 0.0F) {}
            }
          }
        }
      }
      else
      {
        localObject1 = "下载原文件";
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 8)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress == 0.0F)
        {
          localObject2 = localObject1;
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
            localObject2 = "下载原文件";
          }
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131301027);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        l();
      }
      a(0, (String)localObject2, new sbx(this));
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(Activity paramActivity)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend)
    {
      paramActivity = (TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131301027);
      if (paramActivity != null) {
        paramActivity.setVisibility(0);
      }
      paramActivity = (Button)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131299909);
      if (paramActivity != null) {
        paramActivity.setEnabled(true);
      }
      paramActivity = (TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131301023);
      if (paramActivity != null) {
        paramActivity.setVisibility(0);
      }
      paramActivity = (TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131301024);
      if (paramActivity != null) {
        paramActivity.setVisibility(0);
      }
    }
    m();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 7) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1) && (!this.jdField_b_of_type_Boolean)) {
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "重新下载", 2130840338, 2130840339, a());
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = (MessageForDeviceFile)paramMessageRecord;
    DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(49);
    if ("device_groupchat".equals(paramMessageRecord.extStr))
    {
      localDeviceMsgHandle.a().a(paramMessageRecord);
      return;
    }
    localDeviceMsgHandle.a().a(paramMessageRecord);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("丫的类型是不是搞错了？！");
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
      a(1, "转发", ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 10000, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().e();
      if ((i != 3) && (i != 0) && (i != -1)) {
        break label312;
      }
      a();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext != null)
      {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "BaseActionBarDataLineFile init,mEntity.mContext != null");
        this.jdField_c_of_type_Boolean = false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 8) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) && (!FileUtils.b(this.jdField_a_of_type_JavaLangString)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq);
        paramObject = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(49);
        if ((localObject == null) || (!(localObject instanceof MessageForDeviceSingleStruct))) {
          break label402;
        }
        localObject = (MessageForDeviceSingleStruct)localObject;
        if (!a()) {
          break label376;
        }
        ((DeviceMsgHandle)paramObject).a().a((MessageForDeviceSingleStruct)localObject);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = ((MessageForDeviceSingleStruct)localObject).nMediaSessionID;
      }
    }
    for (;;)
    {
      if (16 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
      {
        a(0, false);
        a(1, false);
        a(2, false);
      }
      return;
      label312:
      if (i == 2)
      {
        k();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
          break;
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().findViewById(2131301027);
        if (paramObject == null) {
          break;
        }
        ((View)paramObject).setVisibility(8);
        break;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      break;
      label376:
      if (!((DeviceMsgHandle)paramObject).a().a((MessageForDeviceSingleStruct)localObject))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
        j();
        continue;
        label402:
        if ((localObject != null) && ((localObject instanceof MessageForDeviceFile)))
        {
          localObject = (MessageForDeviceFile)localObject;
          if (a())
          {
            if ("device_groupchat".equals(((MessageForDeviceFile)localObject).extStr)) {
              ((DeviceMsgHandle)paramObject).a().a((MessageRecord)localObject);
            } else {
              ((DeviceMsgHandle)paramObject).a().a((MessageForDeviceFile)localObject);
            }
          }
          else if (("device_groupchat".equals(((MessageForDeviceFile)localObject).extStr)) && (!((DeviceMsgHandle)paramObject).a().a((MessageForDeviceFile)localObject)))
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
            j();
          }
          else if (!((DeviceMsgHandle)paramObject).a().a((MessageForDeviceFile)localObject))
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
            j();
          }
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      i = new JSONObject(paramArrayOfByte).getInt("changePwd");
      if (i == 1)
      {
        FMToastUtil.b(2131362292);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.d();
        }
        return;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          int i = 0;
        }
        FMToastUtil.a(2131362294);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.d();
    }
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      this.jdField_b_of_type_JavaLangString = new JSONObject(paramArrayOfByte).getString("nonce");
      if (paramBoolean) {
        this.jdField_b_of_type_Int += 1;
      }
      if (this.jdField_b_of_type_Int >= 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog = new QQCustomSingleButtonDialog(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 2131558973);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.setContentView(2130903242);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.setTitle(2131362296);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(2131362297);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(0, 0, null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.b(2131362134, new sbt(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.show();
      }
      if ((paramBoolean) && (this.jdField_b_of_type_Int < 3)) {
        FMToastUtil.a(2131362286);
      }
      QLog.d(jdField_c_of_type_JavaLangString + "[MPFile]", 1, "RelayHttpMgrInfo roomno:" + this.jdField_b_of_type_JavaLangString);
      ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().b(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.b().setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView == null) {
        o();
      }
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
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
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 6) {
        break label59;
      }
      s();
    }
    label59:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 7)
      {
        q();
        AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
        n();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, true);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 8);
    y();
  }
  
  public void b(Activity paramActivity)
  {
    if ((FileManagerUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 8)) {
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "收藏", 2130840330, 2130840331, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    if (DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "发送到电脑", 2130840326, 2130840327, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "面对面快传\n(免流量)", 2130840336, 2130840337, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), "存到微云", 2130840340, 2130840341, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b() == 0) {
      b(paramActivity, "保存到手机", 2130840328, 2130840329, ActionBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
    if ((localDataLineHandler != null) && (localDataLineHandler.a != null) && (localDataLineHandler.a.a(this.jdField_a_of_type_JavaLangString))) {
      b(paramActivity, "打印", 2130840334, 2130840335, ActionBarUtil.a(localDataLineHandler, (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent));
    }
    super.b(paramActivity);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 6) {
      t();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 7)
      {
        r();
        AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
        p();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 8);
    z();
  }
  
  protected void d()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 6) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
      {
        localObject1 = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8);
        int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(i).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        if (localObject2 == null) {
          return;
        }
        if ((((DataLineMsgRecord)localObject2).strMoloKey != null) && (DataLineMsgSet.isSingle((DataLineMsgRecord)localObject2)))
        {
          if (!((DataLineMsgRecord)localObject2).isReportPause)
          {
            ((DataLineMsgRecord)localObject2).isReportPause = true;
            DataLineReportUtil.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
          }
          ((DataLineHandler)localObject1).a(((DataLineMsgRecord)localObject2).groupId, ((DataLineMsgRecord)localObject2).sessionid, false);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
      return;
      if ((((DataLineMsgRecord)localObject2).isReportPause) || (((DataLineMsgRecord)localObject2).msgtype != 63201)) {
        break;
      }
      ((DataLineMsgRecord)localObject2).isReportPause = true;
      DataLineReportUtil.m(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a());
      break;
      ((RouterHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(48)).a(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, false);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 7)
      {
        this.jdField_a_of_type_Boolean = true;
        ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(8)).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strDataLineMPFileID);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 8)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "get mr is null ");
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
          return;
        }
        if (((MessageRecord)localObject1).isSendFromLocal())
        {
          if ((localObject1 instanceof MessageForDeviceFile))
          {
            localObject1 = (MessageForDeviceFile)localObject1;
            ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(49)).a().c((MessageForDeviceFile)localObject1);
          }
        }
        else if ((localObject1 instanceof MessageForDeviceSingleStruct))
        {
          localObject1 = (MessageForDeviceSingleStruct)localObject1;
          ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(49)).a().b((MessageForDeviceSingleStruct)localObject1);
        }
        else if ((localObject1 instanceof MessageForDeviceFile))
        {
          localObject2 = (MessageForDeviceFile)localObject1;
          DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(49);
          if ("device_groupchat".equals(((MessageForDeviceFile)localObject2).extStr)) {
            localDeviceMsgHandle.a().a((MessageRecord)localObject1);
          } else {
            localDeviceMsgHandle.a().b((MessageForDeviceFile)localObject2);
          }
        }
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = null;
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeView(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = null;
    }
  }
  
  public void g()
  {
    this.jdField_c_of_type_Boolean = true;
    QLog.d(jdField_c_of_type_JavaLangString, 2, "CLOUD_TYPE_DATALINEMPFILE process_CS_SERVER_OK,mConnPCSuc:" + this.jdField_c_of_type_Boolean);
    this.jdField_b_of_type_Int = 0;
    a(this.jdField_c_of_type_Long);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getContext().getSystemService("input_method");
    boolean bool = localInputMethodManager.isActive();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) && (bool))
    {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.getWindowToken(), 0);
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.c();
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext = new String("needMPFileC2C");
      QLog.d(jdField_c_of_type_JavaLangString, 2, "mConnPCSuc:" + this.jdField_c_of_type_Boolean + ",create mEntity.mContext");
    }
    for (;;)
    {
      e();
      f();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
      return;
      QLog.d(jdField_c_of_type_JavaLangString, 2, "mConnPCSuc:" + this.jdField_c_of_type_Boolean + "mEntity.mContext = null");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext = null;
    }
  }
  
  public void h()
  {
    QLog.d(jdField_c_of_type_JavaLangString, 1, "pc CS_RES_403CHECK!");
  }
  
  public void i()
  {
    this.jdField_c_of_type_Boolean = false;
    QLog.d(jdField_c_of_type_JavaLangString, 1, "pc disconnect!");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ActionBar\ActionBarDataLineFile\BaseActionBarDataLineFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */