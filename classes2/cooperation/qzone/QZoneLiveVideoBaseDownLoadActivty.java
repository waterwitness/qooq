package cooperation.qzone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import ykt;
import yku;
import ykv;
import ykw;

public abstract class QZoneLiveVideoBaseDownLoadActivty
  extends BaseActivity
{
  public static final int a = 1003;
  public static final String a = "QZoneLiveVideoBaseDownLoadActivty";
  public static final int b = 1000;
  public static final int c = 1004;
  protected static final int d = 1005;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 3;
  public static final int h = 1;
  protected static final int i = 500;
  private long jdField_a_of_type_Long;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private volatile boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected String b;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  protected int j;
  private String j;
  private int k;
  
  public QZoneLiveVideoBaseDownLoadActivty()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler = new ykt(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ykv(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ykw(this);
  }
  
  protected abstract PluginBaseInfo a(String paramString);
  
  protected String a()
  {
    return "qzone_live_video_plugin_hack.apk";
  }
  
  public void a()
  {
    finish();
  }
  
  public void a(int paramInt)
  {
    setTitle("空间直播");
    setContentView(2130904756);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304051));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131302819));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297818));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301835));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131304050));
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable("http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_live_video_download_bg.png", null);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new yku(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候...");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("立即升级");
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(Handler paramHandler, Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1001: 
    case 1002: 
    default: 
    case 1000: 
    case 1005: 
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 4, "MSG_INIT_UI, mIsUIInited=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          a(paramMessage.arg1);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
        paramHandler.sendEmptyMessage(1005);
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 4, "MSG_QUERY_PLUGIN_STATE");
        }
      } while (isFinishing());
      paramHandler = a(a());
      a(a(), paramHandler);
      return;
    case 1004: 
      b(paramMessage.arg1);
      return;
    }
    QLog.w("QZoneLiveVideoBaseDownLoadActivty", 4, "MSG_INSTALL_PLUGIN_ERROR");
    Toast.makeText(getApplicationContext(), "空间直播安装出错，请重试", 1).show();
    a();
  }
  
  protected void a(PluginBaseInfo paramPluginBaseInfo)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      int m = (int)(paramPluginBaseInfo.mDownloadProgress * 100.0F);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADED, progress=" + m);
      }
      if (m <= 0) {
        break label89;
      }
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004, m, 0).sendToTarget();
      a(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
      return;
      label89:
      a(this.jdField_b_of_type_Boolean);
    }
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (!a(paramPluginBaseInfo)) {}
    do
    {
      return;
      switch (paramPluginBaseInfo.mState)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE=" + paramPluginBaseInfo.mState);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_NODOWNLOAD");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING");
    }
    a(paramPluginBaseInfo);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_INSTALLING");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_INSTALLED");
    }
    e();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_ERROR");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView.getText().toString().contains("升级中，请稍候")) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      return;
    }
    this.k %= 3;
    switch (this.k)
    {
    }
    for (;;)
    {
      this.k += 1;
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候.");
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候..");
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候...");
    }
  }
  
  public boolean a()
  {
    if (!NetworkUtil.h(getApplicationContext()))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "onCreate, no network available");
      QQToast.a(this, "网络无连接，请检查你的网络连接", 0).a();
      finish();
      return false;
    }
    if (!PtvFilterSoLoad.b(BaseApplicationImpl.getContext()))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "PtvFilterSo not exist");
      PtvFilterSoLoad.a((QQAppInterface)getAppRuntime(), BaseApplicationImpl.getContext());
    }
    for (boolean bool = true;; bool = false)
    {
      if (!FileUtils.a(BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/libstlport_shared.so"))
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "LibStlport_Shared not exist");
        bool = true;
      }
      for (;;)
      {
        if (LocalMultiProcConfig.a("state", "idle").equals("installing"))
        {
          QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "onCreate, plugin installing");
          QQToast.a(this, "插件正在升级，请稍候", 0).a();
          finish();
          return false;
        }
        Object localObject = getIntent();
        if (localObject == null)
        {
          QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "intent is null");
          Toast.makeText(getApplicationContext(), "参数错误，无法启动", 1).show();
          finish();
          return false;
        }
        this.jdField_j_of_type_Int = ((Intent)localObject).getIntExtra("mode", 0);
        if ((3 != this.jdField_j_of_type_Int) && (1 != this.jdField_j_of_type_Int))
        {
          QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "mode invalid, mMode=" + this.jdField_j_of_type_Int);
          Toast.makeText(getApplicationContext(), "参数错误，无法启动, mode=" + this.jdField_j_of_type_Int, 1).show();
          finish();
          return false;
        }
        AppRuntime localAppRuntime = getAppRuntime();
        if ((localAppRuntime != null) && (((QQAppInterface)localAppRuntime).d()))
        {
          Toast.makeText(getApplicationContext(), "正在通话中，请结束通话后再试", 1).show();
          finish();
          return false;
        }
        if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
        {
          Toast.makeText(getApplicationContext(), "摄像头正在使用中，请稍候再试", 1).show();
          finish();
          return false;
        }
        this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("backup");
        int m = QzoneConfig.a().a("LiveSetting", "ModualWhiteList", 1);
        if ((3 == this.jdField_j_of_type_Int) && ((m == 0) || (bool)))
        {
          localObject = this.jdField_b_of_type_JavaLangString + "&stayin=1";
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "not in white list, jump to H5, " + (String)localObject + ", needJumpH5=" + bool);
          QZoneHelper.a(this, (String)localObject, -1, null, null);
          finish();
          return false;
        }
        if (bool)
        {
          QQToast.a(getApplicationContext(), "插件准备中，请稍候再试", 0).a();
          finish();
          return false;
        }
        this.c = ((Intent)localObject).getStringExtra("room_id");
        this.i = ((Intent)localObject).getStringExtra("current_uin");
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "mRoomId=" + this.c + ", mBackUrl=" + this.jdField_b_of_type_JavaLangString + ", mCurrentUin=" + this.i);
        this.jdField_a_of_type_Long = ((Intent)localObject).getLongExtra("host_uin", 0L);
        this.d = ((Intent)localObject).getStringExtra("video_play_source");
        this.e = ((Intent)localObject).getStringExtra("feeds_type");
        this.f = ((Intent)localObject).getStringExtra("shuo_id");
        this.g = ((Intent)localObject).getStringExtra("repost_uin");
        this.h = ((Intent)localObject).getStringExtra("video_play_scene");
        this.jdField_j_of_type_JavaLangString = ((Intent)localObject).getStringExtra("entranceReferId");
        return true;
      }
    }
  }
  
  protected boolean a(PluginBaseInfo paramPluginBaseInfo)
  {
    return paramPluginBaseInfo != null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "installPlugin");
    }
    this.jdField_b_of_type_Boolean = true;
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
  }
  
  protected abstract void c();
  
  protected void d() {}
  
  protected void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launch has canceled");
      return;
    }
    String str = "";
    if (getAppRuntime() != null) {
      str = getAppRuntime().getAccount();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "launchLiveVideo, account=" + str);
      }
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      QQToast.a(this, "获取帐号信息失败，请稍候再试", 0).a();
      a();
      return;
      if (!TextUtils.isEmpty(this.i))
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launchLiveVideo, getAppRuntime is null");
        str = this.i;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("room_id", this.c);
    localIntent.putExtra("mode", this.jdField_j_of_type_Int);
    localIntent.putExtra("video_play_source", this.d);
    localIntent.putExtra("feeds_type", this.e);
    localIntent.putExtra("shuo_id", this.f);
    localIntent.putExtra("repost_uin", this.g);
    localIntent.putExtra("video_play_scene", this.h);
    localIntent.putExtra("entranceReferId", this.jdField_j_of_type_JavaLangString);
    QzoneLiveVideoPluginProxyActivity.a(this, str, localIntent, -1);
    a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1005);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt) {
      this.jdField_a_of_type_Boolean = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneLiveVideoBaseDownLoadActivty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */