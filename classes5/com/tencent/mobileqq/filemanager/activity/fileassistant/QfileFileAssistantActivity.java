package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import cooperation.qlink.QQProxyForQlink;
import cooperation.weiyun.WeiyunHelper;
import cooperation.weiyun.WeiyunRemoteCommand;
import cooperation.weiyun.WeiyunRemoteCommand.OnStateChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rrv;
import rrx;
import rry;
import rsa;

public class QfileFileAssistantActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static final int d = 4;
  public static String e = "FileAssistantActivity<FileAssistant>";
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  QfileFileAssistantActivity.BroadcastMain jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain;
  public FileCategoryAdapter a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private WeiyunRemoteCommand.OnStateChangeListener jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener = new rsa(this);
  private WeiyunRemoteCommand jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private FMObserver jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new rry(this);
  public boolean h = false;
  private volatile boolean i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QfileFileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new rrx(this);
  }
  
  private void l()
  {
    String str1 = getString(2131370351);
    String str2 = getString(2131370352);
    String str3 = getString(2131372710);
    String str4 = getString(2131362725);
    String str5 = getString(2131362723);
    String str6 = getString(2131362731);
    String str7 = getString(2131366108);
    String str8 = getString(2131362722);
    String str9 = getString(2131362719);
    a(2130903992, 2130840841, 2, "", 0, false, 0, "video", 1, false, false);
    a(2130903989, 2130840318, 0, str1, 0, false, 12, "offline", 2, true, false);
    a(2130903989, 2130840468, 0, str7, 0, false, 17, "other", 3, true, false);
    a(2130903989, 2130843514, 0, str3, 0, false, 16, "offline", 4, true, false);
    a(2130904007, 2130840841, 1, str8, 0, true, 0, "other", 1, false, false);
    a(2130903990, 2130840355, 0, str6, 0, false, 13, "picture", 2, false, false);
    a(2130903990, 2130840357, 0, str5, 0, false, 15, "other", 3, false, false);
    a(2130903990, 2130840319, 0, str2, 0, false, 19, "music", 3, false, false);
    a(2130903990, 2130840352, 0, str4, 0, false, 14, "music", 4, false, false);
    if (!getSharedPreferences("Offline_Flags", 0).getBoolean("TMPFLAG", false)) {
      if (!QQUtils.a(this, new String[] { getString(2131362722) }))
      {
        a(2130904007, 2130840841, 4, str9, 0, false, 0, "other", 1, false, false);
        a(2130904007, 2130840841, 4, str9, 0, true, 21, "other", 1, false, false);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
  }
  
  private void m()
  {
    this.app.a().a("0X800474E", 1);
    QQProxyForQlink.a(this, 2, null);
  }
  
  private void n()
  {
    this.i = false;
    if (this.app.a().c() == true)
    {
      this.app.a().e();
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    FMToastUtil.a(BaseApplication.getContext().getString(2131367481));
  }
  
  private void o()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void p()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  private void q()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = this.centerView;
    setTitle(2131362716);
    d();
  }
  
  private void r()
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a(String.valueOf("100160.100162"));
    JSONObject localJSONObject;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag != null) && (localAppInfo.iNewFlag.get() != 0)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("service_type", 2);
      localJSONObject.put("act_id", 1001);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localRedTouchManager.b(localAppInfo, localJSONObject.toString());
      localRedTouchManager.a(localAppInfo);
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand == null) {
      return;
    }
    int j = this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)localIterator.next();
      if (localFileCategoryEntity.J == 16)
      {
        if (j == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d(e, 2, "AlbumBackup:updateBackupInfo, upload state");
          }
          localFileCategoryEntity.jdField_b_of_type_JavaLangString = getResources().getString(2131372743);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(e, 2, "AlbumBackup:updateBackupInfo, other state");
          }
          localFileCategoryEntity.jdField_b_of_type_JavaLangString = null;
        }
      }
      else if (localFileCategoryEntity.J == 13) {
        localFileCategoryEntity.jdField_c_of_type_Boolean = this.app.a().d();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
  }
  
  private void t()
  {
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand = new WeiyunRemoteCommand();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand);
    WeiyunHelper.a(this.app.getApplication());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean1, int paramInt5, String paramString2, int paramInt6, boolean paramBoolean2, boolean paramBoolean3)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.G = paramInt1;
    localFileCategoryEntity.H = paramInt2;
    localFileCategoryEntity.F = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString1;
    localFileCategoryEntity.I = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean1;
    localFileCategoryEntity.J = paramInt5;
    localFileCategoryEntity.jdField_c_of_type_JavaLangString = paramString2;
    localFileCategoryEntity.K = paramInt6;
    localFileCategoryEntity.jdField_b_of_type_Boolean = paramBoolean2;
    localFileCategoryEntity.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true)) && (paramInt2 == 4))
    {
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903994);
    this.h = getIntent().getBooleanExtra("COMEFROMDESK", false);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131300950));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    q();
    l();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain = new QfileFileAssistantActivity.BroadcastMain(this);
    registerReceiver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain, new IntentFilter("com.tencent.process.stopping"));
    paramBundle = new FileManagerReporter.fileAssistantReportData();
    paramBundle.jdField_b_of_type_JavaLangString = "file_asst_in";
    paramBundle.a = 11;
    FileManagerReporter.a(this.app.a(), paramBundle);
    this.app.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    t();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    WeiyunHelper.b(this.app.getApplication());
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(null);
    unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileFileAssistantActivity$BroadcastMain);
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.i = true;
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(null);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    s();
    r();
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    String str = getString(2131362719);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (str.equalsIgnoreCase(((FileCategoryEntity)localIterator.next()).jdField_a_of_type_JavaLangString) == true) {
        return;
      }
    }
    ThreadManager.c(new rrv(this, str));
  }
  
  public void finish()
  {
    super.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\fileassistant\QfileFileAssistantActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */