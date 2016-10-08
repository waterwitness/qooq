package cooperation.huangye;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import yck;
import ycl;

public class HYBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private static final int jdField_a_of_type_Int = 400;
  public static long a = 0L;
  private static final String jdField_a_of_type_JavaLangString = "HYBridgeActivity";
  private static final int jdField_b_of_type_Int = 1001;
  private static final long c = 30000L;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  private long jdField_b_of_type_Long;
  
  public HYBridgeActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(int paramInt)
  {
    QLog.e("HYBridgeActivity", 1, "handleFailed errCode:" + paramInt);
    int i = super.getResources().getDimensionPixelSize(2131492908);
    String str = "加载失败，请重试。";
    if (-4 == paramInt) {
      str = "组件下载失败，请连接网络重试。";
    }
    for (;;)
    {
      QQToast.a(this.app.a(), 1, str, 0).b(i);
      super.finish();
      return;
      if ((-5 == paramInt) || (-1 == paramInt) || (-3 == paramInt) || (-2 == paramInt)) {
        str = "组件下载失败，建议在WiFi环境下重试。";
      } else if (-6 == paramInt) {
        str = "加载失败，内部错误。";
      }
    }
  }
  
  private void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("HYBridgeActivity", 4, "queryPluginInfo!");
    }
    int i = 0;
    if (System.currentTimeMillis() - this.b > 30000L) {
      i = 1;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("HYBridgeActivity", 4, "queryPluginInfo is no ready and query it");
        }
        if (i != 0)
        {
          a(-5);
          return;
        }
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      a(-1);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("HYBridgeActivity", 4, "queryPluginInfo mState : " + paramPluginBaseInfo.mState + " progress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!NetworkUtil.h(getApplicationContext())) && (System.currentTimeMillis() - this.b > 5000L))
    {
      a(-4);
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    default: 
      a(-3);
      return;
    case -1: 
      a(-6);
      return;
    case 0: 
      this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqhuangye.apk");
    case 1: 
    case 2: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 4: 
      b();
      return;
    }
    a(-2);
  }
  
  public static boolean a()
  {
    return System.currentTimeMillis() - jdField_a_of_type_Long < 800L;
  }
  
  private void b()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(getIntent());
    if (HYPluginProxyActivity.a(this))
    {
      HYPluginProxyActivity.a(this, this.app.getAccount(), localIntent, "com.huangye.activity.QQYPHomePageActivity", -1, null);
      super.finish();
      return;
    }
    HYPluginProxyActivity.a(this, this.app.getAccount(), localIntent, "com.huangye.activity.QQYPHomePageActivity", -1, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
  }
  
  private boolean b()
  {
    if (HYPluginProxyActivity.a(this))
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(getIntent());
      HYPluginProxyActivity.a(this, this.app.getAccount(), localIntent, "com.huangye.activity.QQYPHomePageActivity", -1, null);
      super.finish();
      return true;
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    QLog.i("HYBridgeActivity", 1, "onPluginManagerLoaded SUPPORT_NETWORKING:true");
    if (this.jdField_a_of_type_CooperationPluginIPluginManager == null) {
      a(-6);
    }
    for (;;)
    {
      return;
      this.b = System.currentTimeMillis();
      PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqhuangye.apk");
      int j = 0;
      int i = j;
      if (localPluginInfo != null)
      {
        if (localPluginInfo.mState != 4) {
          break label119;
        }
        b();
      }
      for (i = 1; i == 0; i = j)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在下载组件，请保持网络通畅。");
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
        return;
        label119:
        QLog.i("HYBridgeActivity", 1, "onPluginManagerLoaded start down or install...");
        this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqhuangye.apk");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    if (a()) {
      super.finish();
    }
    do
    {
      return true;
      jdField_a_of_type_Long = System.currentTimeMillis();
    } while (b());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getResources().getDimensionPixelSize(2131492908));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载，请稍候...");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new yck(this));
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.postDelayed(new ycl(this), 300L);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1001);
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
      if (QLog.isDevelopLevel()) {
        QLog.d("HYBridgeActivity", 4, "ACTION_QUERY!");
      }
      if (!isFinishing()) {
        a("qqhuangye.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqhuangye.apk"));
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYBridgeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */