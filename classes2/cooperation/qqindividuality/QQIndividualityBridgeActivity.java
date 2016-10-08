package cooperation.qqindividuality;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import java.util.Iterator;
import java.util.List;
import yik;
import yil;
import yim;
import yin;

public class QQIndividualityBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static long a = 0L;
  public static final int b = 200;
  public static final int c = 1000;
  public static final int d = 1001;
  int jdField_a_of_type_Int;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  String jdField_a_of_type_JavaLangString;
  private yin jdField_a_of_type_Yin;
  public boolean a;
  String b;
  
  public QQIndividualityBridgeActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.b = null;
  }
  
  public static boolean a()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ("com.tencent.mobileqq:tool".compareTo(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_CooperationPluginIPluginManager == null) {
      return;
    }
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqindividuality_plugin.apk");
    if (localPluginInfo != null)
    {
      if (localPluginInfo.mState == 4)
      {
        a();
        return;
      }
      if ((localPluginInfo.mState == 1) || (localPluginInfo.mState == 3))
      {
        this.jdField_a_of_type_Yin.show();
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
        return;
      }
      this.jdField_a_of_type_Yin.show();
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qqindividuality_plugin.apk", new yim(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "initPlugin pluginInfo == null");
    }
    this.jdField_a_of_type_Yin.show();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
  }
  
  public void a()
  {
    if (!a())
    {
      this.jdField_a_of_type_Boolean = false;
      QQIndividualityProxyActivity.a(this, getIntent(), this.app.a(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, this.jdField_a_of_type_Yin, this.jdField_a_of_type_Int);
      overridePendingTransition(2130968662, 0);
    }
    for (;;)
    {
      if (-1 == this.jdField_a_of_type_Int) {
        super.finish();
      }
      return;
      QQIndividualityProxyActivity.a(this, getIntent(), this.app.a(), "com.qqindividuality.activity.QQIndividualityActivity", QQIndividualityProxyActivity.class, null, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQIndividuality", 2, "handlePluginInfo null == pluginInfo");
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "pluginInfo.mState:" + paramPluginBaseInfo.mState + ", pluginInfo.mDownloadProgress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1001);
      return;
    case 0: 
      this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqindividuality_plugin.apk");
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
    case 1: 
    case 2: 
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1000, 200L);
      return;
    }
    a();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_Yin != null) && (this.jdField_a_of_type_Yin.isShowing()))
    {
      this.jdField_a_of_type_Yin.dismiss();
      this.jdField_a_of_type_Yin = null;
    }
    setResult(paramInt2, paramIntent);
    super.finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427379);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 800L)
    {
      super.finish();
      return true;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra(QQIndividualityUtils.f);
    this.b = getIntent().getStringExtra(QQIndividualityUtils.g);
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQIndividuality", 2, "path or name is null , return: " + this.jdField_a_of_type_JavaLangString + " " + this.b);
      }
      super.finish();
    }
    this.jdField_a_of_type_Yin = new yin(this, this, super.getResources().getDimensionPixelSize(2131492908));
    this.jdField_a_of_type_Yin.a("正在加载，请稍候...");
    this.jdField_a_of_type_Yin.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Int = getIntent().getIntExtra(QQIndividualityUtils.j, -1);
    if (this.jdField_a_of_type_Int != -1) {
      this.jdField_a_of_type_Yin.setOnDismissListener(new yik(this));
    }
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new yil(this), 300L);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Yin != null) && (this.jdField_a_of_type_Yin.isShowing()))
    {
      this.jdField_a_of_type_Yin.dismiss();
      this.jdField_a_of_type_Yin = null;
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1000);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "destroy.....");
    }
    sTopActivity = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!isFinishing())
      {
        a("qqindividuality_plugin.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqindividuality_plugin.apk"));
        continue;
        QLog.e("QQIndividuality", 2, "install plugin action error");
        ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8006A99", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqindividuality\QQIndividualityBridgeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */