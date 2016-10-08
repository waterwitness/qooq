package cooperation.comic;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.comic.emoticon.VipComicEmoticonUploadRemoteCmd;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import yag;
import yah;

public class VipComicJumpActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static final int a = 200;
  public static final String a = "com.tencent.mobileqq:tool";
  public static final int b = 1000;
  public static final String b = "com.tencent.mobileqq.PreLoadComicProcess";
  public static final int c = 1001;
  public static final String c = "加载中,（别紧张啊我很小的>_<）";
  public static final int d = 1002;
  public static final String d = "载入中,（我会越来越快的>_<）";
  public static final int e = 1003;
  public static final String e;
  public static final int f = 1004;
  public static final String f = "isSetHardWareLayerForWebview";
  public static final int g = 95;
  public static final String g = "isHandleNavigationBar";
  public static final int h = 98;
  public static final String h = "isCloseHardAcc";
  public static final int i = 99;
  public static final int k = 5;
  public static final int l = 6;
  public static final int m = 7;
  public static final int n = 19;
  public static final int o = 20;
  private static final String o = "com.qqcomic.activity.VipComicMainTabActivity";
  long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  protected ImageView a;
  protected TextView a;
  public WeakReferenceHandler a;
  public VipComicJumpActivity.ComicInfo a;
  public IPluginManager a;
  boolean jdField_a_of_type_Boolean = false;
  long b;
  protected TextView b;
  public volatile boolean b;
  public long c;
  public boolean c;
  public long d;
  boolean d;
  long jdField_e_of_type_Long = 0L;
  boolean jdField_e_of_type_Boolean = false;
  boolean f = true;
  boolean g = false;
  public boolean h;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public String k;
  private boolean k;
  public String l;
  public String m;
  private String n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_e_of_type_JavaLangString = VipComicJumpActivity.class.getSimpleName();
  }
  
  public VipComicJumpActivity()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_i_of_type_JavaLangString = "com.qqcomic.activity.VipComicMainTabActivity";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_j_of_type_Boolean = true;
  }
  
  private void a(int paramInt)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (this.app == null) {
          continue;
        }
        localObject1 = (SVIPHandler)this.app.a(13);
        if (localObject1 == null) {
          continue;
        }
        i1 = ((SVIPHandler)localObject1).h();
        if (i1 != 1) {
          continue;
        }
        localObject1 = "2";
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i1;
        localException.printStackTrace();
        Object localObject2 = "1";
        continue;
        if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_c_of_type_Long == 0L) || (this.jdField_c_of_type_Long <= this.jdField_b_of_type_Long)) {
          continue;
        }
        String str1 = this.jdField_c_of_type_Long - this.jdField_b_of_type_Long + "";
        continue;
        String str4 = "0";
        continue;
        String str3 = "0";
        continue;
        String str2 = "0";
        continue;
        str1 = "0";
        continue;
        str1 = "1";
        continue;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Boolean != true) {
        continue;
      }
      localObject1 = "-1";
      if ((this.jdField_d_of_type_Long == 0L) || (this.jdField_c_of_type_Long == 0L) || (this.jdField_d_of_type_Long <= this.jdField_c_of_type_Long)) {
        continue;
      }
      str2 = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long + "";
      if ((this.jdField_d_of_type_Long == 0L) || (this.jdField_e_of_type_Long == 0L) || (this.jdField_e_of_type_Long <= this.jdField_d_of_type_Long)) {
        continue;
      }
      str3 = this.jdField_e_of_type_Long - this.jdField_d_of_type_Long + "";
      if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_e_of_type_Long == 0L) || (this.jdField_e_of_type_Long <= this.jdField_b_of_type_Long)) {
        continue;
      }
      str4 = this.jdField_e_of_type_Long - this.jdField_b_of_type_Long + "";
      if (QLog.isColorLevel()) {
        QLog.d(jdField_e_of_type_JavaLangString, 2, "downloadCost:" + (String)localObject1 + ", installCost:" + str2 + ", launchCost:" + str3 + ", allCost:" + str4 + ",[startTime-launchTime]=[" + this.jdField_b_of_type_Long + "-" + this.jdField_e_of_type_Long + "]");
      }
      VipUtils.a(null, "VIPCOMIC", "0X80052CA", "0X80052CA", this.jdField_j_of_type_Int, paramInt, new String[] { localObject2 });
      VipUtils.a(null, "VIPCOMIC", "0X8005359", "0X8005359", this.jdField_j_of_type_Int, paramInt, new String[] { localObject1, str2, str3, str4 });
      return;
      if (i1 != 3) {
        continue;
      }
      localObject1 = "3";
    }
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("userQqResources", 2);
    ((Intent)localObject).putExtra("useSkinEngine", false);
    ((Intent)localObject).putExtra("params_remote_connect_at_launch", true);
    ((Intent)localObject).putExtra("begin_to_load_comic_plugin", System.currentTimeMillis());
    ((Intent)localObject).putExtra("startOpenPageTime", this.jdField_b_of_type_Long);
    ((Intent)localObject).putExtra("pluginFinished", this.jdField_c_of_type_Long);
    if ((IndividuationUrlHelper.a() instanceof Serializable)) {
      ((Intent)localObject).putExtra("urlMap", (Serializable)IndividuationUrlHelper.a());
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_e_of_type_JavaLangString, 2, "directStartPlugin System.currentTimeMillis(): " + System.currentTimeMillis());
    }
    if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
      ((Intent)localObject).putExtra("url", this.jdField_j_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo != null)
    {
      ((Intent)localObject).putExtra("key_comic_id", this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("key_section_id", this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("key_pic_id", this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.c);
      ((Intent)localObject).putExtra("key_pic_offset_ratio", this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("key_type", this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_Int);
      ((Intent)localObject).putExtra("key_jump_from_out_plugin", true);
      ((Intent)localObject).putExtra("key_return_to_detail", this.h);
      ((Intent)localObject).putExtra("key_return_to_home_from_detail", this.jdField_i_of_type_Boolean);
    }
    ((Intent)localObject).putExtra("key_source_from", this.jdField_j_of_type_Int);
    ((Intent)localObject).putExtra("key_ext_url_param", this.n);
    if (this.jdField_j_of_type_Int == 6)
    {
      this.m = "动态";
      if (this.jdField_k_of_type_JavaLangString != null) {
        ((Intent)localObject).putExtra("key_maintab", this.jdField_k_of_type_JavaLangString);
      }
      if (this.l != null) {
        ((Intent)localObject).putExtra("key_subtab", this.l);
      }
      if (!TextUtils.isEmpty(this.m)) {
        break label706;
      }
      ((Intent)localObject).putExtra("selfSet_leftViewText", getString(2131367975));
      label358:
      if (!"com.qqcomic.activity.VipComicMainTabActivity".equals(this.jdField_i_of_type_JavaLangString)) {
        break label721;
      }
      ((Intent)localObject).setFlags(((Intent)localObject).getFlags() | 0x4000000 | 0x10000000);
      a((Intent)localObject);
      label392:
      ((Intent)localObject).putExtra("isSetHardWareLayerForWebview", this.jdField_d_of_type_Boolean);
      ((Intent)localObject).putExtra("isHandleNavigationBar", this.f);
      ((Intent)localObject).putExtra("isCloseHardAcc", this.g);
      ((Intent)localObject).putExtra("reportSourceFrom", this.jdField_j_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break label739;
      }
    }
    label706:
    label721:
    label739:
    for (int i1 = 1;; i1 = 0)
    {
      ((Intent)localObject).putExtra("reportProcessExistFlag", i1);
      ((Intent)localObject).putExtra("reportLebaClick", this.jdField_a_of_type_Long);
      ((Intent)localObject).putExtra("reportJumpActivityOnCreate", this.jdField_b_of_type_Long);
      if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_c_of_type_Long != 0L) && (this.jdField_c_of_type_Long > this.jdField_b_of_type_Long)) {
        ((Intent)localObject).putExtra("reportDownloadTime", this.jdField_c_of_type_Long - this.jdField_b_of_type_Long);
      }
      if ((this.jdField_d_of_type_Long != 0L) && (this.jdField_c_of_type_Long != 0L) && (this.jdField_d_of_type_Long > this.jdField_c_of_type_Long)) {
        ((Intent)localObject).putExtra("reportInstallTime", this.jdField_d_of_type_Long - this.jdField_c_of_type_Long);
      }
      ((Intent)localObject).putExtra("reportStartPluginTime", System.currentTimeMillis());
      ((Intent)localObject).putExtra("isFromJumpActivity", true);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
      localPluginParams.d = "comic_plugin";
      localPluginParams.jdField_a_of_type_JavaLangString = this.app.a();
      localPluginParams.jdField_e_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      localPluginParams.jdField_a_of_type_JavaLangClass = VipComicProxyActivity.a(this.jdField_i_of_type_JavaLangString);
      localPluginParams.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
      localPluginParams.c = 10000;
      localObject = PluginPreloadReportUtils.a(2);
      if (localObject != null)
      {
        ((PluginPreloadReportUtils.HitRateHelper)localObject).a();
        localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = ((PluginPreloadReportUtils.HitRateHelper)localObject).jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession;
      }
      IPluginManager.a(paramActivity, localPluginParams);
      return;
      if (this.jdField_j_of_type_Int != 7) {
        break;
      }
      this.m = "更多";
      break;
      ((Intent)localObject).putExtra("selfSet_leftViewText", this.m);
      break label358;
      if (!this.jdField_j_of_type_Boolean) {
        break label392;
      }
      ((Intent)localObject).addFlags(67108864);
      break label392;
    }
  }
  
  private void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, VipProxyPreLoadComicProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    localPluginParams.d = "comic_plugin";
    localPluginParams.jdField_a_of_type_JavaLangString = this.app.a();
    localPluginParams.jdField_e_of_type_JavaLangString = "com.qqcomic.app.VipPreloadComicProcess";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(paramContext, localPluginParams);
  }
  
  private void a(Intent paramIntent)
  {
    boolean bool2 = true;
    if (paramIntent == null) {}
    RedTouchManager localRedTouchManager;
    do
    {
      return;
      localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    } while (localRedTouchManager == null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_e_of_type_JavaLangString, 2, "setupRedAppInfo start");
    }
    Object localObject2 = LebaShowListManager.a().a();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      LebaShowListManager.a().a(this.app.getApplication().getApplicationContext(), this.app);
      localObject1 = LebaShowListManager.a().a();
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (LebaViewItem)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 1113L));
    }
    for (int i1 = ((LebaViewItem)localObject2).jdField_a_of_type_Byte;; i1 = -1)
    {
      label162:
      Object localObject5;
      Object localObject4;
      Object localObject3;
      if (i1 == 0)
      {
        i1 = 1;
        if (i1 == 0) {
          break label491;
        }
        localObject5 = "1113." + 100800;
        localObject4 = "1113." + 100802;
        localObject3 = "1113." + 100803;
        localObject2 = "1113." + 100804;
        localObject1 = "1113." + 100801;
        label285:
        localObject5 = localRedTouchManager.a((String)localObject5);
        localObject4 = localRedTouchManager.a((String)localObject4);
        localObject3 = localRedTouchManager.a((String)localObject3);
        localObject2 = localRedTouchManager.a((String)localObject2);
        localObject1 = localRedTouchManager.a((String)localObject1);
        if (localObject5 != null)
        {
          if (((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get() == 0) {
            break label612;
          }
          bool1 = true;
          label345:
          paramIntent.putExtra("isRedHome", bool1);
        }
        if (localObject4 != null)
        {
          if (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() == 0) {
            break label618;
          }
          bool1 = true;
          label374:
          paramIntent.putExtra("isRedMore", bool1);
        }
        if (localObject3 != null)
        {
          if (((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get() == 0) {
            break label624;
          }
          bool1 = true;
          label403:
          paramIntent.putExtra("isRedGroup", bool1);
        }
        if (localObject2 != null)
        {
          if (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 0) {
            break label630;
          }
          bool1 = true;
          label430:
          paramIntent.putExtra("isRedCategory", bool1);
        }
        if (localObject1 != null) {
          if (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() == 0) {
            break label636;
          }
        }
      }
      label491:
      label612:
      label618:
      label624:
      label630:
      label636:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramIntent.putExtra("isRedFav", bool1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_e_of_type_JavaLangString, 2, "setupRedAppInfo end");
        return;
        i1 = 0;
        break label162;
        localObject5 = "100600.100001113." + 100100800;
        localObject4 = "100600.100001113." + 100100802;
        localObject3 = "100600.100001113." + 100100803;
        localObject2 = "100600.100001113." + 100100804;
        localObject1 = "100600.100001113." + 100100801;
        break label285;
        bool1 = false;
        break label345;
        bool1 = false;
        break label374;
        bool1 = false;
        break label403;
        bool1 = false;
        break label430;
      }
    }
  }
  
  private boolean a()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ("com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_e_of_type_JavaLangString, 2, "Comic Process is exist");
        }
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    boolean bool2 = true;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.comic_plugin_profile.name(), "");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_e_of_type_JavaLangString, 2, "parseDPC config = " + str);
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[4];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        arrayOfInteger[2] = Integer.valueOf(1);
        if (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser()) >= arrayOfInteger.length)
        {
          if (arrayOfInteger[0].intValue() != 1) {
            continue;
          }
          bool1 = true;
          this.jdField_e_of_type_Boolean = bool1;
          if (arrayOfInteger[1].intValue() != 1) {
            continue;
          }
          bool1 = true;
          this.jdField_d_of_type_Boolean = bool1;
          if (arrayOfInteger[2].intValue() != 1) {
            continue;
          }
          bool1 = true;
          this.f = bool1;
          if (arrayOfInteger[3].intValue() != 1) {
            continue;
          }
          bool1 = bool2;
          this.g = bool1;
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_e_of_type_JavaLangString, 2, "parseDPC isPreloadInMiddlePage = " + this.jdField_e_of_type_Boolean + " , isSetHardWareLayerForWebview = " + this.jdField_d_of_type_Boolean + " , isHandleNavigationBar = " + this.f + " , isCloseHardAcc = " + this.g);
      }
      return;
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void f()
  {
    Object localObject = getIntent().getStringExtra("from_leba");
    String str = getIntent().getStringExtra("from_leba_mgr");
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("fromleba"))) {
      this.jdField_j_of_type_Int = 6;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_e_of_type_JavaLangString, 2, "getFromInfoFromIntent sourceFrom = " + this.jdField_j_of_type_Int + ", extUrlParam = " + this.n);
      }
      label91:
      return;
      if ((str != null) && (str.equalsIgnoreCase("fromlebamgr"))) {
        this.jdField_j_of_type_Int = 7;
      } else {
        try
        {
          localObject = getIntent().getStringExtra("options");
          if (localObject == null) {
            break label91;
          }
          localObject = new JSONObject((String)localObject);
          this.jdField_j_of_type_Int = ((JSONObject)localObject).optInt("from");
          this.n = ((JSONObject)localObject).optString("extUrlParam");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void a()
  {
    VipComicRemoteCommand.a(this.app);
    PluginRedTouchRemoteCommand.a(this.app);
    VipComicEmoticonUploadRemoteCmd.a(this.app);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_e_of_type_JavaLangString, 2, "launchCOMICPlugin: begin to start");
    }
    PluginInfo localPluginInfo = this.jdField_a_of_type_CooperationPluginIPluginManager.a("comic_plugin.apk");
    if (localPluginInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_e_of_type_JavaLangString, 2, "initPlugin pluginInfo.mState:" + localPluginInfo.mState + ", pluginInfo.mDownloadProgress:" + localPluginInfo.mDownloadProgress);
      }
      if (localPluginInfo.mState == 4)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1002, 99, 0).sendToTarget();
        b();
        return;
      }
      if ((localPluginInfo.mState == 1) || (localPluginInfo.mState == 3))
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 200L);
        return;
      }
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("comic_plugin.apk", new yag(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_e_of_type_JavaLangString, 2, "initPlugin pluginInfo == null");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 200L);
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_e_of_type_JavaLangString, 2, "handlePluginInfo null == pluginInfo");
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 200L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_e_of_type_JavaLangString, 2, "pluginInfo.mState:" + paramPluginBaseInfo.mState + ", pluginInfo.mDownloadProgress:" + paramPluginBaseInfo.mDownloadProgress);
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
      this.jdField_a_of_type_CooperationPluginIPluginManager.a("comic_plugin.apk");
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 200L);
    case 1: 
    case 2: 
      int i1 = (int)(paramPluginBaseInfo.mDownloadProgress * 95.0F);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1000, i1, 0).sendToTarget();
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 200L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1002, 98, 0).sendToTarget();
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 200L);
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1002, 99, 0).sendToTarget();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = a();
    if (this.jdField_e_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_e_of_type_JavaLangString, 2, "preloadComicProcess start");
        }
        a(this);
        VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", this.jdField_j_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "1" });
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1004, 10000L);
        return;
      }
      c();
      return;
    }
    c();
  }
  
  public void c()
  {
    Object localObject1 = this.app.a(Conversation.class);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((MqqHandler)localObject1).obtainMessage(1134028);
      localObject3 = ((MqqHandler)localObject1).obtainMessage(1134040);
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 1000L);
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject3, 1000L);
    }
    d();
    Object localObject2 = getSharedPreferences("vip_comic_file", 4);
    if (("com.qqcomic.activity.VipComicMainTabActivity".equals(this.jdField_i_of_type_JavaLangString)) && (this.jdField_k_of_type_JavaLangString == null))
    {
      i1 = 1;
      if ((this.jdField_j_of_type_Int != 12) || (i1 == 0) || (!((SharedPreferences)localObject2).getBoolean("restore_flag", false))) {
        break label293;
      }
      localObject1 = ((SharedPreferences)localObject2).getString("base_activity", "");
      i1 = ((SharedPreferences)localObject2).getInt("activity_task_id", -1);
      ((SharedPreferences)localObject2).getString("active_comid_id", "");
      localObject2 = ((ActivityManager)getApplication().getApplicationContext().getSystemService("activity")).getRunningTasks(100);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label293;
      }
      localObject2 = ((List)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (ActivityManager.RunningTaskInfo)((Iterator)localObject2).next();
      } while ((!((ActivityManager.RunningTaskInfo)localObject3).baseActivity.getClassName().equals(localObject1)) || (i1 != ((ActivityManager.RunningTaskInfo)localObject3).id));
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setComponent(new ComponentName(getPackageName(), (String)localObject1));
        ((Intent)localObject2).addFlags(269500416);
        try
        {
          startActivity((Intent)localObject2);
          finish();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        i1 = 0;
        break;
      }
      label293:
      a(this);
      VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", this.jdField_j_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long) });
      return;
    }
  }
  
  public void d()
  {
    Object localObject = VipComicRemoteCommand.a(null);
    int i1;
    if ((localObject != null) && ((this.jdField_j_of_type_Int == 6) || (this.jdField_j_of_type_Int == 19) || (this.jdField_j_of_type_Int == 20)))
    {
      i1 = 1;
      if (i1 == 0) {
        break label176;
      }
      i1 = ((Bundle)localObject).getInt("type", -1);
      if ((i1 < 100) || (i1 > 300)) {
        break label166;
      }
      this.jdField_i_of_type_JavaLangString = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
      label71:
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo = new VipComicJumpActivity.ComicInfo(this);
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("comicId");
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("sectionId");
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.c = ((Bundle)localObject).getString("pictureId");
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_Int = ((Bundle)localObject).getInt("offset", -1);
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_Int = ((Bundle)localObject).getInt("type", -1);
      this.h = true;
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      label166:
      this.jdField_i_of_type_JavaLangString = "com.qqcomic.activity.reader.VipComicPortraitReadingActivity";
      break label71;
      label176:
      localObject = getIntent().getStringExtra("options");
      if (localObject == null) {
        continue;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        label218:
        boolean bool;
        if (localJSONObject.has("jumpto"))
        {
          localObject = localJSONObject.optString("jumpto");
          this.jdField_i_of_type_JavaLangString = ((String)localObject);
          if (localJSONObject.optBoolean("newInstance")) {
            break label449;
          }
          bool = true;
          this.jdField_j_of_type_Boolean = bool;
          if (localJSONObject.has("url")) {
            this.jdField_j_of_type_JavaLangString = localJSONObject.optString("url");
          }
        }
        try
        {
          this.jdField_j_of_type_JavaLangString = URLDecoder.decode(this.jdField_j_of_type_JavaLangString);
          if (localJSONObject.has("comic")) {}
          try
          {
            localObject = new JSONObject(localJSONObject.optString("comic"));
            this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo = new VipComicJumpActivity.ComicInfo(this);
            this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("comicID");
            this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("comicSectionID");
            this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.c = ((JSONObject)localObject).optString("comicPageID");
            this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("comicPageOffset");
            this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type");
            if (localJSONObject.has("maintab")) {
              this.jdField_k_of_type_JavaLangString = localJSONObject.optString("maintab");
            }
            if (localJSONObject.has("subtab")) {
              this.l = localJSONObject.optString("subtab");
            }
            if (!localJSONObject.has("leftViewText")) {
              continue;
            }
            this.m = localJSONObject.optString("leftViewText");
            return;
          }
          catch (JSONException localJSONException1)
          {
            label449:
            return;
          }
          localObject = "com.qqcomic.activity.VipComicMainTabActivity";
          break label218;
          bool = false;
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        return;
      }
      catch (JSONException localJSONException2) {}
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Long = getIntent().getLongExtra("click_start_time", 0L);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long <= 0L) {
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
    paramBundle.addAction("com.tencent.mobileqq.PreLoadComicProcess");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yah(this, null);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_e_of_type_JavaLangString, 2, "VipComicJumpActivity.doOnCreate registerReceiver");
    }
    getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    setContentView(2130905095);
    setTitle(2131372131);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131305272));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305273));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297374));
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_e_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("VipComicJumpActivity onCreate mPluginManager = ");
      if (this.jdField_a_of_type_CooperationPluginIPluginManager != null) {
        break label345;
      }
    }
    label345:
    for (paramBundle = "null";; paramBundle = Boolean.valueOf(this.jdField_a_of_type_CooperationPluginIPluginManager.isReady()))
    {
      QLog.d(str, 2, paramBundle);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
      f();
      e();
      VipUtils.a(null, "VIPCOMIC", "0X8005FC7", "0X8005FC7", this.jdField_j_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long) });
      paramBundle = (QQComicPreloadManager)this.app.getManager(141);
      if (paramBundle != null)
      {
        paramBundle.a(System.currentTimeMillis());
        paramBundle.b();
        if (paramBundle.a.get() != null) {
          this.jdField_k_of_type_Boolean = ((PluginPreloadStrategy.PreloadServerParam)paramBundle.a.get()).jdField_b_of_type_Boolean;
        }
      }
      a();
      return true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
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
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            this.jdField_c_of_type_Boolean = true;
            c();
            VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", this.jdField_j_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "2" });
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_e_of_type_JavaLangString, 2, "not have comic process launch BroadcastReceiver");
        return true;
        int i1 = paramMessage.arg1;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(i1 + "%");
        this.jdField_a_of_type_AndroidWidgetTextView.setText("加载中,（别紧张啊我很小的>_<）");
        return true;
        i1 = paramMessage.arg1;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(i1 + "%");
        this.jdField_a_of_type_AndroidWidgetTextView.setText("载入中,（我会越来越快的>_<）");
        return true;
      } while (isFinishing());
      a("comic_plugin.apk", this.jdField_a_of_type_CooperationPluginIPluginManager.a("comic_plugin.apk"));
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败");
    a(-1);
    return true;
  }
  
  protected boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_CooperationPluginIPluginManager.a("comic_plugin.apk");
    boolean bool = getIntent().getBooleanExtra("has_red_dot", false);
    int i1;
    if (localObject == null)
    {
      i2 = this.jdField_j_of_type_Int;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_Boolean)
      {
        i1 = 0;
        if (!bool) {
          break label141;
        }
      }
      label141:
      for (localObject = "1";; localObject = "0")
      {
        VipUtils.a(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", i2, 0, new String[] { String.valueOf(l1 - l2), "-9999", String.valueOf(i1), localObject });
        return super.onBackEvent();
        if (this.jdField_b_of_type_Boolean)
        {
          if (this.jdField_c_of_type_Boolean)
          {
            i1 = 2;
            break;
          }
          i1 = 3;
          break;
        }
        i1 = 4;
        break;
      }
    }
    int i2 = this.jdField_j_of_type_Int;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    int i3 = ((PluginBaseInfo)localObject).mState;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 0;
      label178:
      if (!bool) {
        break label266;
      }
    }
    label266:
    for (localObject = "1";; localObject = "0")
    {
      VipUtils.a(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", i2, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(i3), String.valueOf(i1), localObject });
      break;
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          i1 = 2;
          break label178;
        }
        i1 = 3;
        break label178;
      }
      i1 = 4;
      break label178;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1004);
      if (this.jdField_a_of_type_CooperationPluginIPluginManager == null) {}
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      getApplicationContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_e_of_type_JavaLangString, 2, "VipComicJumpActivity.doOnCreate unregisterReceiver");
      }
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_e_of_type_JavaLangString, 2, "VipComicJumpActivity onDestroy");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\VipComicJumpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */