package cooperation.readinjoy;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import ysi;
import ysj;
import ysk;
import ysn;
import yso;
import ysp;
import ysq;

public class ReadInJoyPluginInstallActivity
  extends IphoneTitleBarActivity
{
  public static final String a;
  public static String b;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static final int f = 300;
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new ysk(this);
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  yso jdField_a_of_type_Yso = null;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private Handler b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ReadInJoyPluginInstallActivity.class.getSimpleName();
    jdField_b_of_type_JavaLangString = "readinjoy_loading_dismiss";
  }
  
  public ReadInJoyPluginInstallActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ysn(this, paramActivity));
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent.getExtras().getInt("readinjoy_launch_source") == 4)
    {
      setTitle("");
      return;
    }
    setTitle(2131366416);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "goPlugin from:" + paramString);
    }
    if (this.jdField_a_of_type_CooperationPluginIPluginManager == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "pluginManager is null, may be user click back");
      return;
    }
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("readinjoy_plugin.apk");
    if (this.jdField_b_of_type_AndroidOsHandler == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "goPlugin from:" + paramString + " but thread quit!");
      return;
    }
    if (localPluginInfo == null)
    {
      paramString = new ysq(this, "initPluginManager");
      this.jdField_b_of_type_AndroidOsHandler.post(paramString);
      return;
    }
    if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("readinjoy_plugin.apk"))
    {
      paramString = new ysq(this, "installPlugin");
      this.jdField_b_of_type_AndroidOsHandler.post(paramString);
      return;
    }
    paramString = new ysq(this, "launchPlugin");
    this.jdField_b_of_type_AndroidOsHandler.post(paramString);
  }
  
  private void d()
  {
    Object localObject = (RelativeLayout)findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
    }
    a(getIntent());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302724));
    localObject = new StringBuilder(getResources().getString(2131366418));
    ((StringBuilder)localObject).append("...");
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
  }
  
  private void e()
  {
    try
    {
      Thread.sleep(200L);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "initPluginManager");
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("mPluginManager.SUPPORT_NETWORKING = ");
      IPluginManager localIPluginManager = this.jdField_a_of_type_CooperationPluginIPluginManager;
      QLog.i((String)localObject1, 4, true);
    }
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = localObject1;
    if (i < 300)
    {
      if (this.jdField_a_of_type_CooperationPluginIPluginManager == null)
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "pluginManager is null, may be user click back");
        localObject2 = localObject1;
      }
    }
    else
    {
      label89:
      if (localObject2 != null) {
        break label175;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "fail to load plugin");
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(new ysi(this));
      }
    }
    label175:
    while (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      return;
      localObject1 = this.jdField_a_of_type_CooperationPluginIPluginManager.a("readinjoy_plugin.apk");
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label89;
      }
      if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady()) {}
      try
      {
        Thread.sleep(100L);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ysj(this));
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("readinjoy_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
  }
  
  public void b()
  {
    c();
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838323));
      int i = this.centerView.getId();
      if (i != 0)
      {
        Object localObject = (RelativeLayout)findViewById(2131297082);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(0, i);
        localLayoutParams.addRule(15, -1);
        ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        localObject = (ViewGroup.MarginLayoutParams)this.centerView.getLayoutParams();
        i = DisplayUtil.a(this, 10.0F);
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(i, 0, i, 0);
        this.centerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    ((Animatable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if ((getIntent().getExtras().getInt("readinjoy_launch_style") & 0x2) != 0) {
      getIntent().removeExtra("leftViewText");
    }
    setContentView(2130904433);
    d();
    this.jdField_a_of_type_Yso = new yso(this);
    paramBundle = new IntentFilter(jdField_b_of_type_JavaLangString);
    registerReceiver(this.jdField_a_of_type_Yso, paramBundle);
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    this.jdField_a_of_type_AndroidOsHandler = new ysp(Looper.getMainLooper(), getResources().getString(2131366418), this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 300L);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ReadInJoyPluginInstallActivity");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    return true;
  }
  
  protected void doOnDestroy()
  {
    c();
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = null;
    this.jdField_a_of_type_CooperationPluginIPluginManager = null;
    if (this.jdField_a_of_type_Yso != null) {
      unregisterReceiver(this.jdField_a_of_type_Yso);
    }
    this.jdField_a_of_type_Yso = null;
    super.doOnDestroy();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    b();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      ysq localysq = new ysq(this, "sleepWait");
      this.jdField_b_of_type_AndroidOsHandler.post(localysq);
      a("doOnWindowFocusChanged");
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\readinjoy\ReadInJoyPluginInstallActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */