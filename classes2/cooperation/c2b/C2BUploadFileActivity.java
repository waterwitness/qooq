package cooperation.c2b;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.utils.PopupDialog;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.BaseActivity;
import xzm;
import xzn;
import xzo;
import xzq;
import xzr;
import xzs;
import xzt;
import xzu;
import xzv;

public class C2BUploadFileActivity
  extends BaseActivity
{
  private static final String jdField_a_of_type_JavaLangString = "C2BUploadFileActivity";
  private static final int jdField_b_of_type_Int = 13;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Bundle a;
  public View a;
  public Button a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQAppInterface a;
  INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
  public Long a;
  TimerTask jdField_a_of_type_JavaUtilTimerTask;
  boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long;
  
  public C2BUploadFileActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new xzn(this);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new xzu(this);
    this.jdField_a_of_type_JavaUtilTimerTask = null;
  }
  
  void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", C2BUploadFileActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", getPackageName());
    localIntent.setClassName("com.tencent.mobileqq", PhotoListActivity.class.getName());
    startActivity(localIntent);
    try
    {
      AlbumUtil.a(this, false, true);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    d("updateUploadDialog process=" + paramInt);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
    if (l - this.b < 500L) {}
    do
    {
      return;
      this.b = l;
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + "%");
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("qq.process.param.uploadfile.choose", false))
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("qq.process.param.uploadfile.choose", false);
      a();
      finish();
      return;
    }
    d();
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    d("upload file failed. path=" + this.jdField_a_of_type_AndroidOsBundle.getString("qq.process.param.uploadfile.filepath"));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new xzq(this, paramString));
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("qq.process.param.uploadfile.filepath");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((String)localObject2).equals("")) {}
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("PhotoConst.SINGLE_PHOTO_PATH");
      if ((localObject1 == null) || (((String)localObject1).equals("")))
      {
        c("文件路径为空！");
        d("file path is null.");
        finish();
        return;
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("qq.process.param.uploadfile.filepath", (String)localObject1);
    }
    if (!a((String)localObject1))
    {
      c("文件已被删除！");
      d("file not exist path = " + (String)localObject1);
      finish();
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("work_mode", 0);
    localObject2 = (TextView)findViewById(2131299293);
    if (this.jdField_a_of_type_Int == 0) {
      ((TextView)localObject2).setText("照片正在上传…");
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      localObject2 = new TransferRequest();
      ((TransferRequest)localObject2).jdField_a_of_type_Boolean = true;
      ((TransferRequest)localObject2).i = ((String)localObject1);
      ((TransferRequest)localObject2).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
      ((TransferRequest)localObject2).c = "";
      ((TransferRequest)localObject2).jdField_b_of_type_Int = 34;
      ((TransferRequest)localObject2).jdField_a_of_type_JavaLangString = "C2BUploadFile";
      long l = System.currentTimeMillis() + (Math.random() * 10000.0D);
      this.jdField_a_of_type_Long = l;
      ((TransferRequest)localObject2).jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((TransferRequest)localObject2);
      localObject1 = new xzo(this);
      new Timer().schedule((TimerTask)localObject1, 5000L);
      e();
      return;
      ((TextView)localObject2).setText("视频正在上传…");
    }
  }
  
  public void b(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Int == 0) {
      ReportController.b(null, "CliOper", "", "", "0X80061C6", "0X80061C6", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      a(100);
      setResult(-1);
      Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("destaction");
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = new Intent((String)localObject);
        ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        if (paramString != null) {
          ((Intent)localObject).putExtra("qq.process.param.uploadfile.filepath", paramString);
        }
        ((Intent)localObject).setPackage(getPackageName());
        sendBroadcast((Intent)localObject);
      }
      this.jdField_a_of_type_Boolean = false;
      d("upload file finish. path=" + paramString);
      c("上传文件成功！");
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      finish();
      return;
      ReportController.b(null, "CliOper", "", "", "0X80061C7", "0X80061C7", 0, 0, "", "", "", "");
    }
  }
  
  public void c()
  {
    IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("" + this.jdField_a_of_type_Long);
    if ((localIHttpCommunicatorListener instanceof NearbyPeoplePhotoUploadProcessor)) {
      ((NearbyPeoplePhotoUploadProcessor)localIHttpCommunicatorListener).b();
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    finish();
  }
  
  public void c(String paramString)
  {
    paramString = Toast.makeText(getApplicationContext(), paramString, 0);
    paramString.setGravity(17, 0, 0);
    paramString.show();
  }
  
  void d()
  {
    if (HttpUtil.a() == 0)
    {
      c("网络不可用！");
      finish();
    }
    QQCustomDialog localQQCustomDialog;
    do
    {
      return;
      AppNetConnInfo.registerNetChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
      if (HttpUtil.a() == 1)
      {
        b();
        return;
      }
      localQQCustomDialog = PopupDialog.a(this, 230, "温馨提示", getString(2131363521), 2131363532, 2131363537, new xzr(this), new xzs(this));
    } while (localQQCustomDialog == null);
    localQQCustomDialog.setOnCancelListener(new xzt(this));
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2BUploadFileActivity", 2, paramString);
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimerTask == null)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilTimerTask = new xzv(this);
      new Timer().schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 2000L);
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_JavaUtilTimerTask != null)
    {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
      this.jdField_a_of_type_JavaUtilTimerTask = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getAppRuntime();
    if ((paramBundle instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      d("get app failed!");
      finish();
    }
    setContentView(2130903569);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299070);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298719));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299294));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new xzm(this));
    a(getIntent());
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = C2BDestoryReceiver.a(this, super.getIntent());
  }
  
  protected void onDestroy()
  {
    f();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    super.onDestroy();
    C2BDestoryReceiver.a(this, this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0))
    {
      c();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BUploadFileActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */