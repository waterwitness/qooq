package cooperation.qqreader;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.comic.PluginPreloadReportUtils;
import cooperation.comic.PluginPreloadReportUtils.HitRateHelper;
import cooperation.comic.VipComicRemoteCommand;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import yix;
import yiy;
import yiz;

public class QRBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener
{
  public static final String A = "com.tencent.mobileqq.middlePagePreloadProcess";
  public static final int a = 400;
  public static final String a = "AbcStartTime";
  public static boolean a = false;
  public static final int b = 1000;
  public static final String b = "VIP_QQREADER";
  public static boolean b = false;
  public static final int c = 1001;
  public static final String c = "ChannelID";
  public static final int d = 1002;
  public static final String d = "100020";
  public static final int e = 1003;
  public static final String e = "100021";
  public static final int f = 1004;
  public static final String f = "100022";
  public static final int g = 90;
  public static final String g = "100023";
  public static final int h = 99;
  public static final String h = "100029";
  public static final String i = "-1";
  public static final int j = 100;
  public static final String j = "QRBridgeActivity";
  public static final String k = "action_type";
  public static final String l = "action_from_list";
  public static final String m = "key_params_qq";
  public static final String n = "qq_adv";
  public static final String o = "qqreaderplugin.apk";
  public static final String z = "com.tencent.mobileqq.closeQRBridgeActivity";
  public long a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  public ViewStub a;
  public Button a;
  public TextView a;
  public URLImageView a;
  public WeakReferenceHandler a;
  public IPluginManager a;
  private QRBridgeActivity.PluginLaunchReceiver jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver;
  public QRNumberCircleProgressBar a;
  public QRPluginBooks a;
  public JSONObject a;
  public long b;
  public TextView b;
  private long c;
  public boolean c;
  private long d;
  public boolean d;
  private long e;
  public boolean e;
  private long f;
  public boolean f;
  volatile boolean g;
  private boolean h;
  public int i;
  private boolean i;
  public String p;
  public final String q;
  public final String r;
  public final String s;
  public final String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  
  public QRBridgeActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.q = "qr_recommend_bookname";
    this.r = "qr_recommend_book_author";
    this.s = "qr_recommend_book_type";
    this.t = "qr_recommend_slogan";
    this.u = "";
    this.v = "";
    this.w = "";
    this.x = "";
    this.y = "";
    this.jdField_i_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.g = false;
  }
  
  private void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, VipProxyRreLoadReaderProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("isMiddlePagePreloadProcess", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qqreaderplugin.apk";
    localPluginParams.d = "qqreader";
    localPluginParams.jdField_a_of_type_JavaLangString = this.app.a();
    localPluginParams.e = "com.qqreader.ReaderPreloadReaderProcess";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(paramContext, localPluginParams);
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|0|0|0|0");
    if (QLog.isColorLevel()) {
      QLog.d("QRBridgeActivity", 2, "isNeedMiddlePagePreloadProcess dpc = " + str);
    }
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(str))
    {
      Integer[] arrayOfInteger = new Integer[5];
      Arrays.fill(arrayOfInteger, Integer.valueOf(0));
      bool1 = bool3;
      if (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser()) >= arrayOfInteger.length) {
        if (arrayOfInteger[4].intValue() != 1) {
          break label110;
        }
      }
    }
    label110:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public int a()
  {
    int i1 = (int)(Math.random() * 100.0D) + 1;
    if (i1 <= 30) {
      return 0;
    }
    if (i1 <= 60) {
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    ThreadManager.a(new yix(this), 8, null, false);
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new yiz(this, paramInt));
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QRBridgeActivity", 4, "QRBridgeActivity launch " + paramString);
    }
    Object localObject = new Intent(this, QRPluginProxyActivity.class);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    ((Intent)localObject).putExtra("useSkinEngine", false);
    ((Intent)localObject).putExtra("is_follow_publicaccount", QRUtility.a(this.app));
    ((Intent)localObject).putExtra("userQqResources", 2);
    ((Intent)localObject).putExtra("startOpenPageTime", this.f);
    ((Intent)localObject).putExtra("pluginFinished", this.jdField_b_of_type_Long);
    long l2;
    long l1;
    if (this.jdField_c_of_type_Long > 0L) {
      if (this.jdField_e_of_type_Long > 0L) {
        if (this.jdField_e_of_type_Long - this.jdField_c_of_type_Long > 0L)
        {
          l2 = this.jdField_e_of_type_Long - this.jdField_c_of_type_Long;
          if (this.jdField_d_of_type_Long - this.jdField_e_of_type_Long <= 0L) {
            break label618;
          }
          l1 = this.jdField_d_of_type_Long - this.jdField_e_of_type_Long;
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("install_time", l1);
      ((Intent)localObject).putExtra("download_time", l2);
      int i1;
      if (this.jdField_e_of_type_Boolean)
      {
        i1 = 1;
        label214:
        ((Intent)localObject).putExtra("plugin_isExist", i1);
        ((Intent)localObject).putExtra("is_new_user", this.h);
        MqqHandler localMqqHandler = this.app.a(Conversation.class);
        if (localMqqHandler != null)
        {
          localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(1134028), 1000L);
          localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(1134040), 1000L);
        }
        VipComicRemoteCommand.a(null);
        ((Intent)localObject).putExtra("redtouch_type", this.jdField_a_of_type_AndroidOsBundle.getInt("redtouch_type", -1));
        ((Intent)localObject).putExtra("redtouch_push_ts", this.jdField_a_of_type_AndroidOsBundle.getInt("redtouch_push_ts", 0));
        ((Intent)localObject).putExtra("redtouch_pull_ts", this.jdField_a_of_type_AndroidOsBundle.getInt("redtouch_pull_ts", 0));
        ((Intent)localObject).putExtra("redtouch_click_ts", this.jdField_a_of_type_AndroidOsBundle.getInt("redtouch_click_ts", 0));
        ((Intent)localObject).putStringArrayListExtra("redtouch_taskid", this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("redtouch_taskid"));
        if (paramString != null)
        {
          ((Intent)localObject).putExtra("plugin_data", paramString);
          ((Intent)localObject).putExtra("account", this.p);
          ((Intent)localObject).putExtra("load_from_third_app", true);
          ((Intent)localObject).putExtra("param_plugin_gesturelock", true);
          ((Intent)localObject).putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
        }
        if (jdField_a_of_type_Boolean) {
          break label676;
        }
        i1 = 1;
        paramString = new IPluginManager.PluginParams(i1);
        paramString.b = "qqreaderplugin.apk";
        paramString.d = "阅读中心";
        paramString.jdField_a_of_type_JavaLangString = this.app.a();
        PluginCommunicationHandler.getInstance().register(new QRRemoteCommond());
        PluginCommunicationHandler.getInstance().register(new QRRemoteAsynCommond());
        paramString.e = "com.qqreader.SplashActivity";
        paramString.jdField_a_of_type_JavaLangClass = QRPluginProxyActivity.class;
        ((Intent)localObject).putExtra("urlMap", (Serializable)IndividuationUrlHelper.a());
        ((Intent)localObject).putExtra("readerDpcConfig", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|0|0|0|0|0"));
        ((Intent)localObject).putExtra("start_plugin_time", System.currentTimeMillis());
        paramString.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
        localObject = PluginPreloadReportUtils.a(1);
        if (localObject != null)
        {
          ((PluginPreloadReportUtils.HitRateHelper)localObject).a();
          paramString.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = ((PluginPreloadReportUtils.HitRateHelper)localObject).jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession;
        }
      }
      try
      {
        IPluginManager.a(this, paramString);
        if (QLog.isDevelopLevel()) {
          QLog.d("QRBridgeActivity", 4, "QRBridgeActivity com.qqreader.SplashActivity");
        }
        return;
        l2 = 0L;
        break;
        label618:
        l1 = 0L;
        continue;
        if (this.jdField_d_of_type_Long > 0L)
        {
          if (this.jdField_d_of_type_Long - this.jdField_c_of_type_Long > 0L) {}
          for (l1 = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;; l1 = 0L)
          {
            l2 = 0L;
            break;
          }
          i1 = 0;
          break label214;
          label676:
          i1 = 0;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("QRBridgeActivity", 4, paramString.toString());
          }
        }
      }
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isReady()) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      }
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1003);
      return;
    case 0: 
      this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk");
    case 1: 
    case 2: 
      int i1 = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1000, i1, 0).sendToTarget();
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1002);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    }
    long l1 = System.currentTimeMillis();
    this.jdField_d_of_type_Long = l1;
    this.jdField_b_of_type_Long = l1;
    this.jdField_d_of_type_Boolean = true;
    a(100);
    this.jdField_i_of_type_Boolean = false;
    g();
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b()
  {
    try
    {
      if ((QRUtility.a(this) == -1) && (this.jdField_i_of_type_Int != -1))
      {
        this.h = true;
        QRUtility.a(this, this.jdField_i_of_type_Int, true);
        if (QLog.isColorLevel()) {
          QLog.d("QRBridgeActivity", 2, "set prefer by net " + this.jdField_i_of_type_Int);
        }
        ReportController.b(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8005875", "0X8005875", 0, 0, "" + this.jdField_i_of_type_Int, "", "", "");
      }
      if (this.jdField_i_of_type_Int != -1) {
        QRUtility.b(this, this.jdField_i_of_type_Int);
      }
      if (isFinishing()) {
        return;
      }
      if (this.jdField_a_of_type_AndroidViewViewStub != null)
      {
        View localView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131303021));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131303023));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131303024));
        this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131303020));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.u);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.w + "|" + this.v);
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable(this.x));
      }
      if ((this.jdField_a_of_type_CooperationQqreaderQRPluginBooks != null) && (this.jdField_a_of_type_OrgJsonJSONObject != null) && (this.jdField_a_of_type_CooperationQqreaderQRPluginBooks.a(this.jdField_a_of_type_OrgJsonJSONObject.optInt("id"))))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk");
    int i2 = 0;
    int i1 = i2;
    if (localPluginInfo != null)
    {
      if (localPluginInfo.mState != 4) {
        break label72;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QRBridgeActivity", 2, "initPlugin STATE_INSTALLED");
      }
      a(100);
      i1 = 1;
    }
    while (i1 == 0)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      d();
      return;
      label72:
      if (localPluginInfo.mState == 1)
      {
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("QRBridgeActivity", 2, "initPlugin STATE_DOWNLOADING");
          i1 = i2;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QRBridgeActivity", 2, "initPlugin installPlugin");
        }
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("qqreaderplugin.apk", new yiy(this));
        i1 = i2;
      }
    }
    if (QRUtility.a(this) == -1) {
      d();
    }
    this.jdField_i_of_type_Boolean = true;
    g();
  }
  
  public void d()
  {
    a();
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.f = getIntent().getLongExtra("click_start_time", 0L);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    this.jdField_a_of_type_AndroidOsBundle.putLong("qrbright_create_time", System.currentTimeMillis());
    if (!this.app.isLogin())
    {
      finish();
      return false;
    }
    setContentView(2130904518);
    e();
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    if (QLog.isDevelopLevel()) {
      QLog.d("QRBridgeActivity", 4, "QRBridgeActivity onCreate");
    }
    getWindow().setBackgroundDrawableResource(2131427379);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.closeQRBridgeActivity");
    paramBundle.addAction("com.tencent.mobileqq.middlePagePreloadProcess");
    this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver = new QRBridgeActivity.PluginLaunchReceiver(this);
    getApplicationContext().registerReceiver(this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver, paramBundle);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_e_of_type_Boolean = a("com.tencent.mobileqq:tool");
    this.jdField_c_of_type_Boolean = true;
    paramBundle = (QRProcessManager)this.app.getManager(128);
    paramBundle.a(this.app.f(), System.currentTimeMillis());
    paramBundle.b();
    c();
    return true;
  }
  
  public void e()
  {
    setTitle("阅读中心");
    this.jdField_a_of_type_CooperationQqreaderQRNumberCircleProgressBar = ((QRNumberCircleProgressBar)findViewById(2131303014));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131303016));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_CooperationQqreaderQRPluginBooks = new QRPluginBooks(this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    int i1;
    Object localObject;
    if (QRUtility.a(this) == -1)
    {
      i1 = -1;
      localObject = ((FriendsManager)this.app.getManager(50)).a(this.app.a());
      if (localObject != null) {
        i1 = ((Card)localObject).shGender;
      }
      if ((i1 == 0) || (i1 == 1)) {
        break label260;
      }
      i1 = a();
      if (QLog.isColorLevel()) {
        QLog.d("QRBridgeActivity", 2, "set prefer by random " + i1);
      }
      ReportController.b(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8005877", "0X8005877", 0, 0, "" + i1, "", "", "");
    }
    boolean bool;
    for (;;)
    {
      QRUtility.a(this, i1);
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("key_params_qq");
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("auto_launch", this.jdField_i_of_type_Boolean);
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qq_adv");
      if (!"action_from_list".equals(this.jdField_a_of_type_AndroidOsBundle.get("action_type"))) {
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).setClass(this, EditActivity.class);
      ((Intent)localObject).putExtra("k_source", 3);
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      ((Intent)localObject).setFlags(67108864);
      startActivity((Intent)localObject);
      finish();
      if (QLog.isDevelopLevel()) {
        QLog.d("QRBridgeActivity", 4, "QRBridgeActivity start EditActivity");
      }
      return;
      label260:
      if (QLog.isColorLevel()) {
        QLog.d("QRBridgeActivity", 2, "set prefer by gender " + i1);
      }
      ReportController.b(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8005876", "0X8005876", 0, 0, "" + i1, "", "", "");
    }
    if ((localObject != null) && (((String)localObject).contains("id")) && (((String)localObject).contains("name")) && (((String)localObject).contains("uin")))
    {
      localObject = ((String)localObject).split("&");
      if (localObject.length >= 3)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readtype=3&");
        localStringBuilder.append(localObject[0]);
        i1 = localObject[2].indexOf("=");
        this.p = localObject[2].substring(i1 + 1);
        a(localStringBuilder.toString());
        return;
      }
      a(null);
      return;
    }
    if (bool)
    {
      localObject = new StringBuilder();
      this.p = this.jdField_a_of_type_AndroidOsBundle.getString("account");
      ((StringBuilder)localObject).append("readtype=4");
      a(((StringBuilder)localObject).toString());
      return;
    }
    a(null);
  }
  
  public void g()
  {
    if ((!this.jdField_e_of_type_Boolean) && (a()))
    {
      a(this);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1004, 5000L);
      return;
    }
    f();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = 99;
    switch (paramMessage.what)
    {
    case 1003: 
    default: 
    case 1004: 
    case 1000: 
    case 1002: 
    case 1001: 
      do
      {
        do
        {
          return true;
          if (!this.g)
          {
            this.g = true;
            f();
          }
        } while (!QLog.isColorLevel());
        QLog.d("QRBridgeActivity", 2, "not have reader process launch BroadcastReceiver");
        return true;
        a(paramMessage.arg1);
        return true;
        int i2 = this.jdField_a_of_type_CooperationQqreaderQRNumberCircleProgressBar.a();
        if (i2 < 99) {}
        for (;;)
        {
          a(i1);
          return true;
          i1 = i2 + 1;
        }
      } while (isFinishing());
      a("qqreaderplugin.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk"));
      return true;
    }
    b();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    try
    {
      if (this.jdField_a_of_type_CooperationPluginIPluginManager != null)
      {
        PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("qqreaderplugin.apk");
        if (localPluginInfo != null)
        {
          float f1 = localPluginInfo.mDownloadProgress;
          int i1 = (int)(f1 * 90.0F);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_CooperationQqreaderQRPluginBooks == null) || (this.jdField_a_of_type_OrgJsonJSONObject == null));
    this.jdField_a_of_type_CooperationQqreaderQRPluginBooks.a(this.jdField_a_of_type_OrgJsonJSONObject);
    this.jdField_a_of_type_CooperationQqreaderQRPluginBooks.a();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText("已加书架");
    ReportController.b(this.app, "P_CliOper", "VIP_QQREADER", "", "0X8006C8C", "0X8006C8C", 0, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1004);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
    }
    if ((this.jdField_a_of_type_CooperationPluginIPluginManager == null) || (QLog.isDevelopLevel())) {
      QLog.d("QRBridgeActivity", 4, "QRBridgeActivity onDestroy");
    }
    if (this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver != null) {
      getApplicationContext().unregisterReceiver(this.jdField_a_of_type_CooperationQqreaderQRBridgeActivity$PluginLaunchReceiver);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRBridgeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */