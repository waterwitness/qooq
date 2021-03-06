package cooperation.qqpim;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Window;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.Iterator;
import java.util.List;
import yio;
import yip;

public class QQPimBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private static final int jdField_a_of_type_Int = 0;
  public static long a = 0L;
  private static final int b = 1;
  private static final int c = 2;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  QQPimPluginLoadRunnable.IPluginLoadListener jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener;
  private QQPimPluginLoadRunnable jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable;
  
  public QQPimBridgeActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener = new yip(this);
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:tool".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131427379);
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 800L)
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getResources().getDimensionPixelSize(2131492908));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载，请稍候...");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new yio(this));
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener);
    ThreadManager.a(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    sTopActivity = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramMessage.what)
    {
    }
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在下载组件，请保持网络通畅。");
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return false;
        } while (isFinishing());
        int i = paramMessage.arg1;
        int j = super.getResources().getDimensionPixelSize(2131492908);
        paramMessage = "加载失败，请重试。";
        if (-4 == i) {
          paramMessage = "组件下载失败，请连接网络重试。";
        }
        for (;;)
        {
          QQToast.a(this.app.a(), 1, paramMessage, 0).b(j);
          finish();
          return false;
          if ((-5 == i) || (-1 == i) || (-3 == i) || (-2 == i)) {
            paramMessage = "组件下载失败，建议在WiFi环境下重试。";
          } else if (-6 == i) {
            paramMessage = "加载失败，内部错误。";
          }
        }
      } while (isFinishing());
      localBundle = getIntent().getExtras();
      if (QQPimDefineList.i.equals(localBundle.getString(QQPimDefineList.o)))
      {
        paramMessage = (Message)localObject1;
        if (!a(getApplicationContext())) {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
        }
        QQPimPluginProxyActivity.a(this, localBundle, paramMessage);
        finish();
        return false;
      }
    } while (!QQPimDefineList.j.equals(localBundle.getString(QQPimDefineList.o)));
    paramMessage = (Message)localObject2;
    if (!a(getApplicationContext())) {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    }
    QQPimPluginProxyActivity.b(this, localBundle, paramMessage);
    finish();
    return false;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqpim\QQPimBridgeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */