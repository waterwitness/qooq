package com.tencent.mobileqq.activity;

import VipRecommend.MQQ.CommPayInfo;
import VipRecommend.MQQ.PayParam;
import VipRecommend.MQQ.RecParam;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VIPRecommendPayObserver;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.vas.ChatBackgroundMarketActivity;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.IndividUpdateRedPacketLisener;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.ActivityConfig;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.BizExtraInfo;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.BizRecommendConfig;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.ButtonConfig;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.PayBtnConfig;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.ShapedImgConfig;
import com.tencent.mobileqq.vas.IndividuationManager;
import com.tencent.mobileqq.vas.IndividuationManager.IndividUpdateLisener;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import loy;
import loz;
import lpa;
import lpb;
import lpc;
import lpd;
import lpe;
import lpf;
import lpg;
import lpi;
import lpj;
import lpk;
import lpl;
import lpm;
import mqq.os.MqqHandler;

public class IndividuationSetActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, IndividuationManager.IndividUpdateLisener
{
  private static final int A = 1;
  private static final int B = 0;
  private static final byte jdField_a_of_type_Byte = 0;
  private static final float jdField_a_of_type_Float = 6.0F;
  public static final int a = 0;
  public static final String a = "IndividuationSetActivity";
  private static final byte jdField_b_of_type_Byte = 1;
  public static final int b = 1;
  public static final String b = "尊享装扮";
  private static final byte jdField_c_of_type_Byte = 2;
  public static final int c = 2;
  public static final String c = "IndividuationBtestVIP";
  private static List jdField_c_of_type_JavaUtilList;
  private static final byte jdField_d_of_type_Byte = 3;
  public static final int d = 3;
  private static final byte jdField_e_of_type_Byte = 4;
  public static final int e = 4;
  static boolean jdField_e_of_type_Boolean = false;
  private static final byte jdField_f_of_type_Byte = 5;
  public static final int f = 1;
  private static final byte jdField_g_of_type_Byte = 6;
  public static final int g = 50;
  private static final byte h = 7;
  private static final byte i = 8;
  public static final int i = 1;
  private static final byte j = 9;
  public static final int j = 0;
  private static final byte k = 10;
  public static final int k = 0;
  public static final int l = 1;
  private static final int t = 0;
  private static final int u = 1;
  private static final int v = 2;
  private static final int w = 3;
  private static final int x = 4;
  private static final int y = 5;
  private static final int z = -15158035;
  public CommPayInfo a;
  RecParam jdField_a_of_type_VipRecommendMQQRecParam;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new lpi(this);
  public IndividualRedPacketManager a;
  protected SVIPObserver a;
  protected VIPRecommendPayObserver a;
  public PreloadProcHitSession a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  IndividualRedPacketResDownloader.IndividUpdateRedPacketLisener jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$IndividUpdateRedPacketLisener = new lpa(this);
  IndividuationConfigInfo jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo;
  public IndividuationManager a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  MyGridView jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
  protected BusinessInfoCheckUpdate.AppInfo a;
  public WebView a;
  public ImmersiveTitleBar2 a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  public Vector a;
  lpk jdField_a_of_type_Lpk;
  public final MqqHandler a;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  public BusinessInfoCheckUpdate.AppInfo b;
  public HashMap b;
  public List b;
  boolean jdField_b_of_type_Boolean;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public BusinessInfoCheckUpdate.AppInfo c;
  volatile boolean jdField_c_of_type_Boolean;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public BusinessInfoCheckUpdate.AppInfo d;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = true;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  public BusinessInfoCheckUpdate.AppInfo e;
  public String e;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  public BusinessInfoCheckUpdate.AppInfo f;
  protected String f;
  public boolean f;
  public BusinessInfoCheckUpdate.AppInfo g;
  protected String g;
  boolean jdField_g_of_type_Boolean = false;
  public int h;
  public BusinessInfoCheckUpdate.AppInfo h;
  protected String h;
  public BusinessInfoCheckUpdate.AppInfo i;
  protected String i;
  public BusinessInfoCheckUpdate.AppInfo j;
  public BusinessInfoCheckUpdate.AppInfo k;
  public BusinessInfoCheckUpdate.AppInfo l;
  public int m;
  public BusinessInfoCheckUpdate.AppInfo m;
  protected int n = 3;
  int o = 1;
  int p = 0;
  int q = 0;
  int r = 0;
  int s = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaUtilList = new ArrayList();
    jdField_c_of_type_JavaUtilList.add("i.gtimg.cn");
    jdField_c_of_type_JavaUtilList.add("gxh.vip.qq.com");
    jdField_c_of_type_JavaUtilList.add("zb.vip.qq.com");
    jdField_c_of_type_JavaUtilList.add("imgcache.gtimg.cn");
    jdField_c_of_type_JavaUtilList.add("imgcache.qq.com");
    jdField_c_of_type_JavaUtilList.add("logic.content.qq.com");
  }
  
  public IndividuationSetActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_VipRecommendMQQCommPayInfo = null;
    this.jdField_m_of_type_Int = 1;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "开通QQ会员";
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("individuation_main", "com.tencent.mobileqq:web");
    this.jdField_a_of_type_ComTencentMobileqqAppVIPRecommendPayObserver = new loy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new lpb(this);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt2 == 1)
      {
        if (paramInt3 != 1) {
          break;
        }
        paramInt1 = 4;
      }
      return paramInt1;
      if (paramInt3 == 1) {
        paramInt1 = 3;
      } else {
        paramInt1 = 1;
      }
    }
    return 2;
  }
  
  private BusinessInfoCheckUpdate.AppInfo a()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(this.jdField_b_of_type_JavaUtilList);
    if (localAppInfo != null) {
      return localAppInfo;
    }
    return a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private BusinessInfoCheckUpdate.AppInfo a(int paramInt)
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.app.getManager(35)).a("100005." + paramInt);
      return localAppInfo;
    }
    catch (Exception localException)
    {
      QLog.e("qqBaseActivity", 1, "getNewInfo, exception, appInfoId=" + paramInt, localException);
    }
    return null;
  }
  
  private BusinessInfoCheckUpdate.AppInfo a(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    int i1;
    do
    {
      return null;
      i1 = paramList.size();
      if (i1 == 1) {
        return (BusinessInfoCheckUpdate.AppInfo)paramList.get(0);
      }
    } while (i1 <= 1);
    return (BusinessInfoCheckUpdate.AppInfo)paramList.get(new Random().nextInt(i1 - 1));
  }
  
  private void a(byte paramByte, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    String str1;
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig.jdField_a_of_type_JavaLangString)))
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig.jdField_a_of_type_JavaLangString;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig.c;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationSetActivity", 2, "openMarket currentShapeImgBizName = " + str1 + ";currentShapeImgId = " + (String)localObject1);
      }
      Intent localIntent;
      boolean bool;
      String str2;
      Object localObject2;
      switch (paramByte)
      {
      default: 
        return;
      case 0: 
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("individuation_url_type", 40100);
        bool = false;
        if (this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
        {
          if (this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1) {
            bool = true;
          }
        }
        else
        {
          str2 = IndividuationUrlHelper.a(this, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab");
          localObject2 = str2;
          if (paramBoolean)
          {
            localObject2 = str2;
            if ("bubble".equals(str1))
            {
              localObject2 = str2;
              if (!TextUtils.isEmpty(str2)) {
                if (!str2.contains("?")) {
                  break label384;
                }
              }
            }
          }
        }
        for (localObject2 = str2 + "&rec_id=" + (String)localObject1;; localObject2 = str2 + "?rec_id=" + (String)localObject1)
        {
          localIntent.putExtra("updateFlag", bool);
          localIntent.putExtra("has_red_dot", bool);
          VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject2, 64L, localIntent, false, -1);
          localRedTouchManager.b("100005.100003");
          return;
          bool = false;
          break;
        }
      case 1: 
        if (!Utils.b())
        {
          Toast.makeText(super.getApplicationContext(), getString(2131368967), 0).show();
          return;
        }
        bool = false;
        if (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
        {
          if (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1) {
            bool = true;
          }
        }
        else
        {
          localIntent = new Intent(this, AvatarPendantMarketActivity.class);
          localIntent.putExtra("individuation_url_type", 40100);
          localIntent.putExtra("vasUsePreWebview", true);
          localIntent.putExtra("key_update_flag", bool);
          localIntent.putExtra("has_red_dot", bool);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          str2 = IndividuationUrlHelper.a(this, "pendant", "");
          localObject2 = str2;
          if (paramBoolean)
          {
            localObject2 = str2;
            if ("pendant".equals(str1))
            {
              localObject2 = str2;
              if (!TextUtils.isEmpty(str2)) {
                if (!str2.contains("?")) {
                  break label702;
                }
              }
            }
          }
        }
        for (localObject2 = str2 + "&rec_id=" + (String)localObject1;; localObject2 = str2 + "?rec_id=" + (String)localObject1)
        {
          localIntent.putExtra("url", (String)localObject2);
          localIntent.putExtra("business", 512L);
          VasWebviewUtil.insertVasWbPluginToIntent(512L, localIntent);
          localIntent.putExtra("isShowAd", false);
          super.startActivity(localIntent);
          localRedTouchManager.b("100005.100006");
          return;
          bool = false;
          break;
        }
      case 2: 
        if (BaseApplicationImpl.jdField_a_of_type_Boolean)
        {
          paramByte = 1;
          ThemeReporter.a(null, "theme_detail", "205", 150, 1, paramByte, ThemeUtil.getUserCurrentThemeId(this.app), ThemeUtil.getUserCurrentThemeVersion(this.app), "3", "");
          if (BaseApplicationImpl.jdField_a_of_type_Boolean) {
            break label813;
          }
          Toast.makeText(super.getApplicationContext(), getString(2131368352), 0).show();
        }
        for (;;)
        {
          localRedTouchManager.b("100005.100002");
          return;
          paramByte = -40;
          break;
          if (Utils.b())
          {
            bool = false;
            if (this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
            {
              if (this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1) {
                bool = true;
              }
            }
            else
            {
              localIntent = new Intent(this, QQBrowserActivity.class);
              localIntent.putExtra("individuation_url_type", 40100);
              localIntent.putExtra("updateFlag", bool);
              localIntent.putExtra("has_red_dot", bool);
              str2 = IndividuationUrlHelper.a(this, "theme", "mvip.gongneng.android.theme.index_dynamic_tab");
              localObject2 = str2;
              if (paramBoolean)
              {
                localObject2 = str2;
                if ("theme".equals(str1))
                {
                  localObject2 = str2;
                  if (!TextUtils.isEmpty(str2)) {
                    if (!str2.contains("?")) {
                      break label1000;
                    }
                  }
                }
              }
            }
            for (localObject2 = str2 + "&rec_id=" + (String)localObject1;; localObject2 = str2 + "?rec_id=" + (String)localObject1)
            {
              VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject2, 32L, localIntent, true, -1);
              break;
              bool = false;
              break label846;
            }
          }
          Toast.makeText(super.getApplicationContext(), getString(2131368967), 0).show();
        }
      case 3: 
        label384:
        label702:
        label813:
        label846:
        label1000:
        if (this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) {
          if (this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1) {
            bool = true;
          }
        }
        break;
      }
      for (;;)
      {
        localRedTouchManager.b("100005.100001");
        if ((paramBoolean) && ("emoji".equals(str1))) {}
        for (;;)
        {
          EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.app.getAccount(), 3, bool, (String)localObject1);
          getSharedPreferences("emoticon_panel_" + this.app.a(), 0).edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).commit();
          return;
          bool = false;
          break;
          if (!((FontManager)this.app.getManager(41)).a())
          {
            ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_font_size", 0, 0, "", "", "", "");
            super.startActivity(new Intent(this, ChatTextSizeSettingActivity.class));
            return;
          }
          ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_font_mall", 0, 0, "", "", "", "");
          bool = false;
          if (this.jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
          {
            if (this.jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1) {
              bool = true;
            }
          }
          else
          {
            localIntent = new Intent(this, QQBrowserActivity.class);
            localIntent.putExtra("has_red_dot", bool);
            localIntent.putExtra("updateFlag", bool);
            localIntent.putExtra("hide_left_button", false);
            localIntent.putExtra("show_right_close_button", false);
            localIntent.putExtra("individuation_url_type", 40100);
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            str2 = IndividuationUrlHelper.a(this, "font", "");
            localObject2 = str2;
            if (paramBoolean)
            {
              localObject2 = str2;
              if ("font".equals(str1))
              {
                localObject2 = str2;
                if (!TextUtils.isEmpty(str2)) {
                  if (!str2.contains("?")) {
                    break label1494;
                  }
                }
              }
            }
          }
          label1494:
          for (localObject2 = str2 + "&rec_id=" + (String)localObject1;; localObject2 = str2 + "?rec_id=" + (String)localObject1)
          {
            VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject2, 4096L, localIntent, false, -1);
            localRedTouchManager.b("100005.100011");
            return;
            bool = false;
            break;
          }
          bool = false;
          if (this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
          {
            if (this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1) {
              bool = true;
            }
          }
          else
          {
            localRedTouchManager.b("100005.100012");
            str2 = "";
            localObject2 = str2;
            if (paramBoolean)
            {
              localObject2 = str2;
              if ("card".equals(str1)) {
                localObject2 = localObject1;
              }
            }
            localObject1 = this.app.a();
            if (!bool) {
              break label1629;
            }
          }
          label1629:
          for (paramByte = 0;; paramByte = 1)
          {
            ProfileCardUtil.a(this, (String)localObject1, "inside.myIndividuation", paramByte, 2, 1, "", false, bool, (String)localObject2);
            return;
            bool = false;
            break;
          }
          localIntent = new Intent(this, QQBrowserActivity.class);
          bool = false;
          if (this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
          {
            if (this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1) {
              bool = true;
            }
          }
          else
          {
            localIntent.putExtra("hide_left_button", false);
            localIntent.putExtra("show_right_close_button", false);
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            localIntent.putExtra("individuation_url_type", 40100);
            str2 = IndividuationUrlHelper.a(this, "suit", "mvip.gongneng.android.gxsuit");
            localObject2 = str2;
            if (paramBoolean)
            {
              localObject2 = str2;
              if ("suit".equals(str1))
              {
                localObject2 = str2;
                if (!TextUtils.isEmpty(str2)) {
                  if (!str2.contains("?")) {
                    break label1842;
                  }
                }
              }
            }
          }
          label1842:
          for (localObject2 = str2 + "&rec_id=" + (String)localObject1;; localObject2 = str2 + "?rec_id=" + (String)localObject1)
          {
            localIntent.putExtra("has_red_dot", bool);
            VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject2, 262144L, localIntent, false, -1);
            localRedTouchManager.b("100005.100020");
            return;
            bool = false;
            break;
          }
          bool = false;
          if (this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
          {
            if (this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1) {
              bool = true;
            }
          }
          else
          {
            localIntent = new Intent(this, QQBrowserActivity.class);
            localIntent.putExtra("hide_left_button", false);
            localIntent.putExtra("show_right_close_button", false);
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            localIntent.putExtra("has_red_dot", bool);
            localIntent.putExtra("individuation_url_type", 40100);
            str2 = IndividuationUrlHelper.a(this, "call", "mvip.gongneng.anroid.individuation.web");
            localObject2 = str2;
            if (paramBoolean)
            {
              localObject2 = str2;
              if ("call".equals(str1))
              {
                localObject2 = str2;
                if (!TextUtils.isEmpty(str2)) {
                  if (!str2.contains("?")) {
                    break label2080;
                  }
                }
              }
            }
          }
          label2080:
          for (localObject2 = str2 + "&rec_id=" + (String)localObject1;; localObject2 = str2 + "?rec_id=" + (String)localObject1)
          {
            VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject2, 524288L, localIntent, false, -1);
            localRedTouchManager.b("100005.100019");
            return;
            bool = false;
            break;
          }
          localIntent = new Intent(this, ChatBackgroundMarketActivity.class);
          localIntent.putExtra("vasUsePreWebview", true);
          localIntent.putExtra("bg_replace_entrance", 8);
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          str2 = IndividuationUrlHelper.a(this, "background", "");
          localObject2 = str2;
          if (paramBoolean)
          {
            localObject2 = str2;
            if ("background".equals(str1))
            {
              localObject2 = str2;
              if (!TextUtils.isEmpty(str2))
              {
                if (!str2.contains("?")) {
                  break label2389;
                }
                localObject2 = str2 + "&rec_id=" + (String)localObject1;
              }
            }
          }
          localIntent.putExtra("url", (String)localObject2);
          localIntent.putExtra("individuation_url_type", 40100);
          paramBoolean = false;
          if (this.j != null) {
            if (this.j.iNewFlag.get() != 1) {
              break label2419;
            }
          }
          label2389:
          label2419:
          for (paramBoolean = true;; paramBoolean = false)
          {
            localObject1 = String.valueOf(33554432L);
            if (WebViewPluginFactory.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1)) {
              localIntent.putExtra("insertPluginsArray", new String[] { localObject1 });
            }
            localIntent.putExtra("business", 33554432L);
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            localIntent.putExtra("has_red_dot", paramBoolean);
            localIntent.putExtra("updateFlag", paramBoolean);
            startActivity(localIntent);
            localRedTouchManager.b("100005.100021");
            return;
            localObject2 = str2 + "?rec_id=" + (String)localObject1;
            break;
          }
          bool = false;
          if (this.k != null)
          {
            if (this.k.iNewFlag.get() == 1) {
              bool = true;
            }
          }
          else
          {
            localIntent = new Intent(this, QQBrowserActivity.class);
            localIntent.putExtra("updateFlag", bool);
            localIntent.putExtra("individuation_url_type", 40100);
            localIntent.putExtra("has_red_dot", bool);
            str2 = IndividuationUrlHelper.a(this, "ring", "mvip.gongneng.anroid.individuation.web");
            localObject2 = str2;
            if (paramBoolean)
            {
              localObject2 = str2;
              if ("ring".equals(str1))
              {
                localObject2 = str2;
                if (!TextUtils.isEmpty(str2)) {
                  if (!str2.contains("?")) {
                    break label2611;
                  }
                }
              }
            }
          }
          label2611:
          for (localObject2 = str2 + "&rec_id=" + (String)localObject1;; localObject2 = str2 + "?rec_id=" + (String)localObject1)
          {
            VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject2, 4194304L, localIntent, true, -1);
            localRedTouchManager.b("100005.100018");
            return;
            bool = false;
            break;
          }
          bool = false;
          if (this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
          {
            if (this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1) {
              bool = true;
            }
          }
          else
          {
            str2 = IndividualRedPacketManager.a(2, this.app);
            localObject2 = str2;
            if (paramBoolean)
            {
              localObject2 = str2;
              if ("hongbao".equals(str1))
              {
                localObject2 = str2;
                if (!TextUtils.isEmpty(str2)) {
                  if (!str2.contains("?")) {
                    break label2821;
                  }
                }
              }
            }
          }
          label2821:
          for (localObject2 = str2 + "&rec_id=" + (String)localObject1;; localObject2 = str2 + "?rec_id=" + (String)localObject1)
          {
            localObject1 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("updateFlag", bool);
            ((Intent)localObject1).putExtra("has_red_dot", bool);
            ((Intent)localObject1).putExtra("individuation_url_type", 40100);
            VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject2, 134217728L, (Intent)localObject1, true, -1);
            localRedTouchManager.b("100005.100028");
            return;
            bool = false;
            break;
          }
          localObject1 = "";
        }
        bool = false;
      }
      localObject1 = "";
      str1 = "";
    }
  }
  
  private void a(CommPayInfo paramCommPayInfo)
  {
    String str = null;
    if (paramCommPayInfo != null)
    {
      this.jdField_a_of_type_VipRecommendMQQRecParam = paramCommPayInfo.recParam;
      if (this.jdField_a_of_type_VipRecommendMQQRecParam == null)
      {
        this.jdField_m_of_type_Int = 1;
        this.jdField_e_of_type_JavaLangString = "mvip.gexinghua.android.zbcenter_h5recall";
        paramCommPayInfo = str;
      }
      for (;;)
      {
        a(paramCommPayInfo, true);
        return;
        paramCommPayInfo = this.jdField_a_of_type_VipRecommendMQQRecParam.payParam;
        int i1 = this.jdField_a_of_type_VipRecommendMQQRecParam.h5Pay;
        str = this.jdField_a_of_type_VipRecommendMQQRecParam.buttonText;
        if ((str != null) && (!"".equals(str))) {
          this.jdField_i_of_type_JavaLangString = str;
        }
        this.o = this.jdField_a_of_type_VipRecommendMQQRecParam.canOpen;
        this.p = this.jdField_a_of_type_VipRecommendMQQRecParam.is_vip;
        this.q = this.jdField_a_of_type_VipRecommendMQQRecParam.is_svip;
        this.r = this.jdField_a_of_type_VipRecommendMQQRecParam.is_year;
        if (i1 == 1)
        {
          this.jdField_m_of_type_Int = 1;
          this.jdField_e_of_type_JavaLangString = "mvip.gexinghua.android.zbcenter_h5";
        }
        else if (i1 == 0)
        {
          this.jdField_m_of_type_Int = 0;
          this.jdField_e_of_type_JavaLangString = "mvip.gexinghua.android.zbcenter_qianbao";
        }
        else
        {
          this.jdField_m_of_type_Int = 1;
          this.jdField_e_of_type_JavaLangString = "mvip.gexinghua.android.zbcenter_h5recall";
        }
      }
    }
    this.jdField_m_of_type_Int = 1;
    this.jdField_e_of_type_JavaLangString = "mvip.gexinghua.android.zbcenter_h5recall";
    a(null, false);
  }
  
  private void a(PayParam paramPayParam, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (!paramBoolean)
    {
      this.jdField_m_of_type_Int = 1;
      this.jdField_e_of_type_JavaLangString = "mvip.gexinghua.android.zbcenter_h5recall";
      if (this.o != 1) {
        break label312;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramPayParam = this.jdField_i_of_type_JavaLangString + "尊享装扮";
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramPayParam);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramPayParam);
      switch (a(this.p, this.q, this.r))
      {
      default: 
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(2130839468));
        label145:
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
    }
    for (;;)
    {
      d();
      return;
      if (paramPayParam == null)
      {
        this.jdField_m_of_type_Int = 1;
        this.jdField_e_of_type_JavaLangString = "mvip.gexinghua.android.zbcenter_h5recall";
        break;
      }
      this.n = paramPayParam.openMonth;
      this.jdField_f_of_type_JavaLangString = paramPayParam.serviceType;
      this.jdField_g_of_type_JavaLangString = paramPayParam.serviceName;
      this.jdField_h_of_type_JavaLangString = paramPayParam.offerid;
      break;
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(2130840246));
      break label145;
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(2130840246));
      break label145;
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(2130839582));
      break label145;
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(2130840248));
      break label145;
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(getResources().getDrawable(2130840247));
      break label145;
      label312:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView == null) || (paramView.getVisibility() != 0)) {
      return;
    }
    if (this.jdField_d_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130841736);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.a(this, 10.0F), DisplayUtil.a(this, 10.0F));
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int i1 = Math.min(paramView.width, paramView.height) / 6;
    paramView.leftMargin += paramView.width - i1;
    localLayoutParams.topMargin = (paramView.topMargin + i1 - DisplayUtil.a(this, 10.0F));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_d_of_type_AndroidWidgetImageView.getParent() != null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
        } while (localObject == null);
        localObject = ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.get();
      } while ((localObject == null) || (((List)localObject).size() <= 1));
      localObject = (BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject).get(1);
    } while (localObject == null);
    if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 3)
    {
      this.jdField_b_of_type_JavaUtilList.add(paramAppInfo);
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramAppInfo);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("isShowAd", false);
    startActivity(localIntent);
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      try
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
        if (localLayoutParams == null) {
          break;
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
        localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString.setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
        if (paramString.getStatus() == 2)
        {
          paramString.restartDownload();
          paramImageView.setImageDrawable(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("IndividuationSetActivity", 1, "setBtnDrawable, exception=" + MsfSdkUtils.getStackTraceString(paramString));
        return;
      }
      if (paramString.getStatus() == 1) {
        this.jdField_f_of_type_Boolean = true;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "parseLocalConfig, update=" + paramBoolean);
    }
    ThreadManager.a(new lpe(this, paramBoolean), 8, null, true);
  }
  
  private void b()
  {
    long l1 = SystemClock.uptimeMillis();
    this.jdField_h_of_type_Int = ImmersiveUtils.a(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297123));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297139));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)super.findViewById(2131297137));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131303128));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131303129));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131303124));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131303125));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)super.findViewById(2131303126));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131303127);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131303130);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131303131));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131303133));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131303134));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)super.findViewById(2131297862));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.b(0, 20);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new lpc(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager != null) && (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationSetActivity", 2, "initUI, cache exist");
      }
      b(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo);
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationSetActivity", 2, "[Performance] initUI, duration=" + (SystemClock.uptimeMillis() - l1));
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationSetActivity", 2, "initUI, cache not exist");
      }
    }
  }
  
  private void b(IndividuationConfigInfo paramIndividuationConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "updateHeaderView, config=" + paramIndividuationConfigInfo);
    }
    if (paramIndividuationConfigInfo == null) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    Object localObject1 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    if (!TextUtils.isEmpty(paramIndividuationConfigInfo.o))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = ((DisplayMetrics)localObject1).widthPixels;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.a(this, 431.0F);
      localObject3 = new ColorDrawable(-15158035);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
      localObject2 = URLDrawable.getDrawable(paramIndividuationConfigInfo.o, (URLDrawable.URLDrawableOptions)localObject2);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      localObject2 = this.jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ImageView)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if ((localObject3 != null) && (((ImageView)localObject3).getParent() != null)) {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject3);
        }
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-15158035));
    }
    h();
    Object localObject3 = new HashMap();
    Object localObject2 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
    float f2;
    int i6;
    Iterator localIterator;
    int i1;
    label333:
    Object localObject4;
    int i2;
    if ((paramIndividuationConfigInfo != null) && (paramIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap != null) && (paramIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap.size() > 0))
    {
      f2 = ((DisplayMetrics)localObject2).widthPixels / 750.0F;
      i6 = DisplayUtil.a(super.getApplicationContext(), 370.0F);
      localIterator = paramIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap.values().iterator();
      i1 = 0;
      if (localIterator.hasNext())
      {
        localObject4 = (IndividuationConfigInfo.ButtonConfig)localIterator.next();
        i2 = ((IndividuationConfigInfo.ButtonConfig)localObject4).b;
        i2 = ((IndividuationConfigInfo.ButtonConfig)localObject4).d + i2;
        if (i2 <= i1) {
          break label1757;
        }
        i1 = i2;
      }
    }
    label510:
    label758:
    label1365:
    label1382:
    label1392:
    label1706:
    label1746:
    label1757:
    for (;;)
    {
      break label333;
      float f3 = (i6 - 20) / i1;
      int i3;
      if (f2 > f3)
      {
        localIterator = paramIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
        int i4 = Integer.MAX_VALUE;
        i2 = 0;
        while (localIterator.hasNext())
        {
          localObject4 = (IndividuationConfigInfo.ButtonConfig)((Map.Entry)localIterator.next()).getValue();
          int i5 = (int)(((IndividuationConfigInfo.ButtonConfig)localObject4).a * f3);
          i3 = i4;
          if (i5 < i4) {
            i3 = i5;
          }
          i4 = (int)(((IndividuationConfigInfo.ButtonConfig)localObject4).c * f3) + i5;
          if (i4 <= i2) {
            break label1746;
          }
          i2 = i4;
          i4 = i3;
        }
        i2 = (((DisplayMetrics)localObject1).widthPixels - i2 + i4) / 2 - i4;
      }
      for (float f1 = f3;; f1 = f2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IndividuationSetActivity", 2, "updateHeaderView, screen width=" + ((DisplayMetrics)localObject2).widthPixels + ", btnAreaHeight=" + i6 + ", maxBtnHeight=" + i1 + ", widthScaleFactor=" + f2 + ", heightMaxScaleFactor=" + f3 + ", scaleFactor=" + f1 + ", offsetX=" + i2);
        }
        localIterator = paramIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          localObject4 = (String)((Map.Entry)localObject1).getKey();
          Object localObject5 = (IndividuationConfigInfo.ButtonConfig)((Map.Entry)localObject1).getValue();
          localObject2 = (ImageView)this.jdField_b_of_type_JavaUtilHashMap.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = new ImageView(this);
            i1 = -1;
            localObject1 = null;
            if ("emoji".equals(localObject4))
            {
              i1 = 2131296609;
              localObject1 = "表情";
              if (i1 != -1) {
                ((ImageView)localObject2).setId(i1);
              }
              if (AppSetting.j) {
                ((ImageView)localObject2).setContentDescription((CharSequence)localObject1);
              }
              ((ImageView)localObject2).setOnClickListener(this);
              localObject1 = localObject2;
            }
          }
          else
          {
            i1 = (int)(((IndividuationConfigInfo.ButtonConfig)localObject5).c * f1);
            i3 = (int)(((IndividuationConfigInfo.ButtonConfig)localObject5).d * f1);
            localObject2 = new RelativeLayout.LayoutParams(i1, i3);
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(((IndividuationConfigInfo.ButtonConfig)localObject5).a * f1) + i2);
            ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(((IndividuationConfigInfo.ButtonConfig)localObject5).b * f1));
            ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i1;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i3;
            localObject5 = new ColorDrawable(0);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject5);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject5);
            localObject2 = URLDrawable.getDrawable(paramIndividuationConfigInfo.a(this.app, (String)localObject4), (URLDrawable.URLDrawableOptions)localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("IndividuationSetActivity", 2, "updateHeaderView, bizName = " + (String)localObject4 + "name = " + paramIndividuationConfigInfo.a(this.app, (String)localObject4) + " status: " + ((URLDrawable)localObject2).getStatus());
            }
            ((URLDrawable)localObject2).setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
            if (((URLDrawable)localObject2).getStatus() != 2) {
              break label1365;
            }
            if (QLog.isColorLevel()) {
              QLog.d("IndividuationSetActivity", 2, "drawanle downlaod failed! bizName = " + (String)localObject4);
            }
            ((URLDrawable)localObject2).restartDownload();
          }
          for (;;)
          {
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
            ((HashMap)localObject3).put(localObject4, localObject1);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            if (!"hongbao".equals(localObject4)) {
              break label1392;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager == null) {
              break;
            }
            if ((!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b()) || (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().jdField_b_of_type_Boolean)) {
              break label1382;
            }
            ((ImageView)localObject1).setVisibility(0);
            break;
            if ("bubble".equals(localObject4))
            {
              i1 = 2131296600;
              localObject1 = "气泡";
              break label758;
            }
            if ("theme".equals(localObject4))
            {
              i1 = 2131296601;
              localObject1 = "主题";
              break label758;
            }
            if ("font".equals(localObject4))
            {
              i1 = 2131296602;
              localObject1 = "字体";
              break label758;
            }
            if ("pendant".equals(localObject4))
            {
              i1 = 2131296603;
              localObject1 = "挂件";
              break label758;
            }
            if ("card".equals(localObject4))
            {
              i1 = 2131296604;
              localObject1 = "名片";
              break label758;
            }
            if ("call".equals(localObject4))
            {
              i1 = 2131296605;
              localObject1 = "来电";
              break label758;
            }
            if ("suit".equals(localObject4))
            {
              i1 = 2131296606;
              localObject1 = "套装";
              break label758;
            }
            if ("background".equals(localObject4))
            {
              i1 = 2131296607;
              localObject1 = "背景";
              break label758;
            }
            if ("ring".equals(localObject4))
            {
              i1 = 2131296608;
              localObject1 = "彩铃";
              break label758;
            }
            if (!"hongbao".equals(localObject4)) {
              break label758;
            }
            i1 = 2131296610;
            localObject1 = "红包";
            break label758;
            if (((URLDrawable)localObject2).getStatus() == 1) {
              this.jdField_f_of_type_Boolean = true;
            }
          }
          ((ImageView)localObject1).setVisibility(8);
          continue;
          if ("ring".equals(localObject4)) {
            ((ImageView)localObject1).setVisibility(8);
          }
        }
        this.jdField_b_of_type_JavaUtilHashMap.clear();
        this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)localObject3);
        i1 = 0;
        i3 = 0;
        i2 = i1;
        long l2;
        if (paramIndividuationConfigInfo != null)
        {
          i2 = i1;
          if (!TextUtils.isEmpty(paramIndividuationConfigInfo.p))
          {
            i2 = i1;
            if (Build.VERSION.SDK_INT >= 11)
            {
              l2 = SystemClock.uptimeMillis();
              localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
              if (QLog.isColorLevel()) {
                QLog.d("IndividuationSetActivity", 2, "updateHeaderView, dpc config for animation=" + (String)localObject1 + ", sWebviewCreatedBefore=" + jdField_e_of_type_Boolean);
              }
              i1 = i3;
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                localObject1 = ((String)localObject1).split("\\|");
                i1 = i3;
                if (localObject1 != null)
                {
                  i1 = i3;
                  if (localObject1.length > 0)
                  {
                    i1 = i3;
                    if (!"0".equals(localObject1[0]))
                    {
                      if (!jdField_e_of_type_Boolean) {
                        break label1706;
                      }
                      a(paramIndividuationConfigInfo);
                    }
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          i1 = 1;
          i2 = i1;
          if (QLog.isColorLevel())
          {
            QLog.d("IndividuationSetActivity", 2, "[Performance] updateHeaderView, update webview, duration=" + (SystemClock.uptimeMillis() - l2));
            i2 = i1;
          }
          if ((i2 == 0) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)) {
            this.jdField_a_of_type_ComTencentSmttSdkWebView.setVisibility(8);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("IndividuationSetActivity", 2, "[Performance] updateHeaderView, duration=" + (SystemClock.uptimeMillis() - l1));
          return;
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5);
          localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(5);
          ((Message)localObject1).obj = paramIndividuationConfigInfo;
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, 800L);
        }
        break label510;
        i2 = 0;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "updateUI, forceUpdate=" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo == null) {
      i();
    }
    label509:
    label609:
    label643:
    label655:
    do
    {
      return;
      if ((paramBoolean) || (!this.jdField_b_of_type_Boolean)) {
        b(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo);
      }
      if ((this.jdField_c_of_type_Boolean) && ((paramBoolean) || (!this.jdField_d_of_type_Boolean)))
      {
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          break label509;
        }
        if ((this.jdField_d_of_type_AndroidWidgetImageView != null) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      j();
      int i1;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.q))
      {
        i1 = Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.q);
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundColor(i1);
      }
      Object localObject2;
      Object localObject1;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.o))
      {
        localObject2 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ((DisplayMetrics)localObject2).widthPixels;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = DisplayUtil.a(this, 431.0F);
        localObject2 = new ColorDrawable(-15158035);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      }
      for (;;)
      {
        try
        {
          localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.o, (URLDrawable.URLDrawableOptions)localObject1);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject1);
          if ((this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break label643;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFocusable(false);
          if (this.jdField_a_of_type_Lpk == null) {
            this.jdField_a_of_type_Lpk = new lpk(this);
          }
          this.jdField_a_of_type_Lpk.a(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_JavaUtilArrayList);
          i1 = DisplayUtil.a(this, 10.0F);
          if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() % 4 != 0) {
            break label609;
          }
          i2 = DisplayUtil.a(this, 16.0F);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(4);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(i2, 0, i2, i1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Lpk);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setOnItemClickListener(this.jdField_a_of_type_Lpk);
          this.jdField_a_of_type_Lpk.notifyDataSetChanged();
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
          localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, 1000L);
          d();
          if (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) {
            break label655;
          }
          localObject1 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label655;
          }
          localObject2 = (View)((Iterator)localObject1).next();
          if ((localObject2 == null) || (((View)localObject2).getParent() != this.jdField_a_of_type_AndroidWidgetLinearLayout)) {
            continue;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)localObject2);
          continue;
          localObject1 = (ImageView)this.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
          if (localObject1 == null)
          {
            if ((this.jdField_d_of_type_AndroidWidgetImageView == null) || (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
              break;
            }
            this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            break;
          }
          a((View)localObject1);
          this.jdField_d_of_type_Boolean = true;
        }
        catch (Exception localException)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-15158035));
          continue;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-15158035));
        continue;
        int i2 = DisplayUtil.a(this, 4.0F);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(3);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(i2, 0, i2, i1);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_b_of_type_JavaUtilArrayList == null);
    l();
  }
  
  private void c()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(12);
    if (localWebProcessManager != null) {
      localWebProcessManager.a(100, new lpd(this));
    }
  }
  
  private void d()
  {
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$PayBtnConfig != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$PayBtnConfig.jdField_a_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$PayBtnConfig.b;
    }
    try
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int i1 = AIOUtils.a(6.0F, super.getResources());
        Object localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
        localObject1 = new RoundedColorDrawable(Color.parseColor(((String)localObject1).trim()), ((RelativeLayout.LayoutParams)localObject3).width, ((RelativeLayout.LayoutParams)localObject3).height, i1);
        localObject2 = new RoundedColorDrawable(Color.parseColor(((String)localObject2).trim()), ((RelativeLayout.LayoutParams)localObject3).width, ((RelativeLayout.LayoutParams)localObject3).height, i1);
        localObject3 = new StateListDrawable();
        ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject3).addState(new int[] { 16842910 }, (Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject3);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$PayBtnConfig.c;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(((String)localObject1).trim()));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("IndividuationSetActivity", 1, "updatePayBtnStyle, exception=" + MsfSdkUtils.getStackTraceString(localException));
    }
  }
  
  private void e()
  {
    ThreadManager.a(new lpf(this), 8, null, true);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "handleRedpointInfo");
    }
    if ((this.jdField_d_of_type_AndroidWidgetImageView != null) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidWidgetImageView).a(53).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.l);
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = a();
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_JavaLangString = null;
      this.jdField_d_of_type_Boolean = true;
      j();
    }
    String str1;
    int i1;
    do
    {
      return;
      str1 = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.get();
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationSetActivity", 2, "handleRedpointInfo, redpoint path=" + str1);
      }
      if (TextUtils.isEmpty(str1))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_d_of_type_JavaLangString = null;
        this.jdField_d_of_type_Boolean = true;
        j();
        return;
      }
      i1 = str1.indexOf("100005.");
    } while ((i1 == -1) || (str1.length() <= i1 + 1));
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(str1.substring("100005.".length() + i1));
        switch (i1)
        {
        default: 
          str1 = null;
          if (!TextUtils.isEmpty(str1))
          {
            ImageView localImageView = (ImageView)this.jdField_b_of_type_JavaUtilHashMap.get(str1);
            if (localImageView == null) {
              break label488;
            }
            a(localImageView);
            this.jdField_d_of_type_Boolean = true;
          }
          this.jdField_c_of_type_Boolean = true;
          this.jdField_d_of_type_JavaLangString = str1;
          j();
          return;
        }
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("IndividuationSetActivity", 2, "parse appid error, e=" + MsfSdkUtils.getStackTraceString(localException));
      return;
      String str2 = "bubble";
      continue;
      str2 = "pendant";
      continue;
      str2 = "theme";
      continue;
      str2 = "emoji";
      continue;
      str2 = "font";
      continue;
      str2 = "card";
      continue;
      str2 = "suit";
      continue;
      str2 = "call";
      continue;
      str2 = "background";
      continue;
      str2 = "ring";
      continue;
      str2 = "hongbao";
      continue;
      label488:
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  private void g()
  {
    int i2 = 0;
    int i1 = i2;
    if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo != null)
      {
        IndividuationConfigInfo localIndividuationConfigInfo = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo;
        i1 = i2;
        if (localIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap != null)
        {
          i2 = localIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap.size();
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("IndividuationSetActivity", 2, "addFailureButtonBgCounts size is " + i2);
            i1 = i2;
          }
        }
      }
    }
    do
    {
      try
      {
        this.s += 1;
        if (this.s >= i1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividuationSetActivity", 2, "addFailureButtonBgCounts more than " + i1);
          }
          i();
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationSetActivity", 2, "addFailureButtonBgCount = " + this.s);
      }
    } while ((!this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean));
    this.jdField_g_of_type_Boolean = true;
    QQToast localQQToast = new QQToast(getApplicationContext());
    localQQToast.a(2130838200);
    localQQToast.a("哎呀~受到外星人干扰，请重新加载试试吧");
    localQQToast.c(2000);
    localQQToast.b(getResources().getDimensionPixelSize(2131492908));
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (this.jdField_f_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_f_of_type_AndroidWidgetImageView);
        if (QLog.isColorLevel()) {
          QLog.d("IndividuationSetActivity", 2, "mNetworkError removed!");
        }
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_d_of_type_AndroidWidgetTextView);
        if (QLog.isColorLevel()) {
          QLog.d("IndividuationSetActivity", 2, "mErrorText removed!");
        }
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_e_of_type_AndroidWidgetTextView);
        if (QLog.isColorLevel()) {
          QLog.d("IndividuationSetActivity", 2, "mReload removed!");
        }
      }
    }
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_JavaUtilHashMap != null)
    {
      localObject1 = this.jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ImageView)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if ((localObject2 != null) && (((ImageView)localObject2).getParent() != null)) {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject2);
        }
      }
    }
    Object localObject2 = new ImageView(this);
    ((ImageView)localObject2).setId(2131296611);
    ThreadManager.a(new lpg(this, (ImageView)localObject2), 5, null, true);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2);
    localObject1 = new TextView(this);
    ((TextView)localObject1).setId(2131296612);
    ((TextView)localObject1).setTextColor(Color.rgb(255, 255, 255));
    ((TextView)localObject1).setText("哎呀~受到外星人干扰，请重新加载试试吧");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, ((ImageView)localObject2).getId());
    localLayoutParams.topMargin = 30;
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
    localObject2 = new TextView(this);
    ((TextView)localObject2).setId(2131296613);
    ((TextView)localObject2).setTextColor(Color.rgb(255, 255, 255));
    ((TextView)localObject2).setText("重新加载");
    ((TextView)localObject2).setBackgroundDrawable(getResources().getDrawable(2130841737));
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, ((TextView)localObject1).getId());
    localLayoutParams.addRule(14);
    localLayoutParams.topMargin = 30;
    ((TextView)localObject2).setLayoutParams(localLayoutParams);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getCompoundPaddingTop() - 1, ((TextView)localObject2).getPaddingRight(), ((TextView)localObject2).getPaddingBottom() + 1);
    ((TextView)localObject2).setTextSize(18.0F);
    ((TextView)localObject2).setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2);
  }
  
  private void j()
  {
    String str2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "updateShapeImage, mRedPointPulled=" + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_c_of_type_Boolean) {
      break label45;
    }
    label45:
    while (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo == null) {
      return;
    }
    ImageView localImageView1;
    String str1;
    if ((this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig.jdField_a_of_type_JavaLangString)))
    {
      localImageView1 = (ImageView)this.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig.jdField_a_of_type_JavaLangString);
      str1 = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$ShapedImgConfig.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      IndividuationConfigInfo.ShapedImgConfig localShapedImgConfig = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.a(this.app, this.jdField_d_of_type_JavaLangString);
      ImageView localImageView2;
      if ((localShapedImgConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_b_of_type_JavaUtilHashMap.containsKey(localShapedImgConfig.jdField_a_of_type_JavaLangString)))
      {
        localImageView2 = (ImageView)this.jdField_b_of_type_JavaUtilHashMap.get(localShapedImgConfig.jdField_a_of_type_JavaLangString);
        str2 = localShapedImgConfig.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(str1)) {
          a(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.a(this.app, str1), localImageView1);
        }
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.a(this.app, str2), localImageView2);
        return;
        localImageView2 = null;
      }
      str1 = null;
      localImageView1 = null;
    }
  }
  
  private void k()
  {
    int i2;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView != null) && (this.jdField_a_of_type_Lpk != null))
    {
      i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
      i1 = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_a_of_type_JavaUtilArrayList.size();
      if (i2 == i1) {
        break label107;
      }
      if (QLog.isColorLevel()) {
        QLog.e("IndividuationSetActivity", 2, "startAnimationForActivityGridIcon, viewSize=" + i2 + ", dataSize=" + i1);
      }
    }
    for (;;)
    {
      return;
      label107:
      i1 = 0;
      while (i1 < i2)
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i1);
        if (localObject1 != null)
        {
          Object localObject2 = this.jdField_a_of_type_Lpk.a(i1);
          if ((localObject2 != null) && ("1".equals(((IndividuationConfigInfo.ActivityConfig)localObject2).jdField_g_of_type_JavaLangString)))
          {
            localObject1 = (lpl)((View)localObject1).getTag();
            if ((localObject1 != null) && (((lpl)localObject1).jdField_a_of_type_AndroidWidgetImageView != null))
            {
              localObject2 = new UserScaleAnimation(1.2F, 1.17F, 1.07F);
              ((UserScaleAnimation)localObject2).setDuration(1800L);
              ((lpl)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "updateRecommendView");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_b_of_type_JavaUtilArrayList == null)) {
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_b_of_type_JavaUtilArrayList.size();
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getParent() != null)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidViewView);
    }
    int i1 = 0;
    IndividuationConfigInfo.BizRecommendConfig localBizRecommendConfig;
    Object localObject2;
    Object localObject3;
    label135:
    label230:
    ArrayList localArrayList;
    if (i1 < i2)
    {
      localBizRecommendConfig = (IndividuationConfigInfo.BizRecommendConfig)this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo.jdField_b_of_type_JavaUtilArrayList.get(i1);
      localObject1 = localBizRecommendConfig.jdField_d_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo;
      localObject2 = (IndividuationConfigInfo.BizExtraInfo)IndividuationConfigInfo.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      localObject3 = localBizRecommendConfig.jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {}
      do
      {
        for (;;)
        {
          i1 += 1;
          break;
          if ((!"font".equals(localBizRecommendConfig.jdField_a_of_type_JavaLangString)) || (this.app == null)) {
            break label230;
          }
          localObject1 = (FontManager)this.app.getManager(41);
          if ((localObject1 == null) || (((FontManager)localObject1).a())) {
            break label230;
          }
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject3)) && (this.jdField_a_of_type_JavaUtilHashMap.get(localObject3) != null)) {
            ((View)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3)).setVisibility(8);
          }
        }
        localArrayList = localBizRecommendConfig.jdField_a_of_type_JavaUtilArrayList;
      } while ((localArrayList == null) || (localArrayList.size() <= 0));
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject3)) {
        break label542;
      }
    }
    label418:
    label510:
    label521:
    label542:
    for (Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);; localObject1 = null)
    {
      Object localObject4;
      if (localObject1 == null)
      {
        localObject4 = LayoutInflater.from(this).inflate(2130904547, null);
        localObject1 = (MyGridView)((View)localObject4).findViewById(2131303142);
        ((MyGridView)localObject1).setNumColumns(((IndividuationConfigInfo.BizExtraInfo)localObject2).b);
        ((MyGridView)localObject1).setFocusable(false);
        localObject2 = new lpm(this, (IndividuationConfigInfo.BizExtraInfo)localObject2, localBizRecommendConfig);
        ((View)localObject4).findViewById(2131297557).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject4).findViewById(2131303141).setOnClickListener((View.OnClickListener)localObject2);
        ((MyGridView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)localObject2);
        ((View)localObject4).findViewById(2131303141).setContentDescription("更多");
        TextView localTextView = (TextView)((View)localObject4).findViewById(2131303140);
        localTextView.setText(localBizRecommendConfig.b);
        localTextView.setContentDescription(localBizRecommendConfig.b);
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject3, localObject4);
        localObject3 = localObject2;
        localObject2 = localObject1;
        if (localObject3 == null) {
          break label510;
        }
        ((lpm)localObject3).a(localArrayList);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
        ((MyGridView)localObject2).setAdapter((ListAdapter)localObject3);
        ((lpm)localObject3).notifyDataSetChanged();
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label521;
        }
        QLog.d("IndividuationSetActivity", 2, "updateRecommendView, show view for " + localBizRecommendConfig.b);
        break;
        localObject2 = (MyGridView)((View)localObject1).findViewById(2131303142);
        localObject3 = (lpm)((MyGridView)localObject2).getAdapter();
        localObject4 = localObject1;
        break label418;
        QLog.e("qqBaseActivity", 1, "updaterecommendui: adapter empty");
      }
      break label135;
      if (this.jdField_b_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationSetActivity", 2, "update local config");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(4);
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4);
      localMessage.arg1 = 1;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  void a(IndividuationConfigInfo paramIndividuationConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "[Performance] updateBackgroundAnimation, config=" + paramIndividuationConfigInfo);
    }
    if (paramIndividuationConfigInfo == null) {}
    long l1;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      if (this.jdField_a_of_type_ComTencentSmttSdkWebView == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkWebView = new WebView(this);
        this.jdField_a_of_type_ComTencentSmttSdkWebView.setHorizontalScrollBarEnabled(false);
        this.jdField_a_of_type_ComTencentSmttSdkWebView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_ComTencentSmttSdkWebView.setScrollBarStyle(33554432);
        this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings().setJavaScriptEnabled(true);
        this.jdField_a_of_type_ComTencentSmttSdkWebView.getSettings().setAllowFileAccess(true);
        this.jdField_a_of_type_ComTencentSmttSdkWebView.setBackgroundColor(0);
        if (this.jdField_a_of_type_ComTencentSmttSdkWebView.getBackground() != null) {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.getBackground().setAlpha(0);
        }
        this.jdField_a_of_type_ComTencentSmttSdkWebView.setWebViewClient(new lpj(this));
        this.jdField_a_of_type_ComTencentSmttSdkWebView.setOnCreateContextMenuListener(null);
        localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView.getView();
        if (localObject != null) {
          ((View)localObject).setOnLongClickListener(new loz(this));
        }
        jdField_e_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("IndividuationSetActivity", 2, "[Performance] updateBackgroundAnimation, create webview, duration=" + (SystemClock.uptimeMillis() - l1));
        }
      }
      if (this.jdField_a_of_type_ComTencentSmttSdkWebView.getParent() == null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentSmttSdkWebView, 0, new RelativeLayout.LayoutParams(-1, -1));
      }
      Object localObject = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://").append(paramIndividuationConfigInfo.p).append("?width=" + ((DisplayMetrics)localObject).widthPixels).append("&height=" + DisplayUtil.a(this, 447.0F)).append("&version=6.5.5").append("&platform=android");
      paramIndividuationConfigInfo = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationSetActivity", 2, "updateHeaderView, background animation url=" + paramIndividuationConfigInfo);
      }
      this.jdField_a_of_type_ComTencentSmttSdkWebView.setVisibility(0);
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramIndividuationConfigInfo);
    } while (!QLog.isColorLevel());
    QLog.d("IndividuationSetActivity", 2, "[Performance] updateBackgroundAnimation, duration=" + (SystemClock.uptimeMillis() - l1));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 4001) {
      EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.app.a(), paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
    if ((Build.VERSION.SDK_INT >= 11) && (!AbsBaseWebViewActivity.a.contains(paramBundle))) {
      getWindow().setFlags(16777216, 16777216);
    }
    long l2 = System.currentTimeMillis();
    super.setContentView(2130904544);
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "[Performance] doOnCreate, setContentView, duration=" + (System.currentTimeMillis() - l2));
    }
    this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager = ((IndividuationManager)this.app.getManager(106));
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppVIPRecommendPayObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = ((IndividualRedPacketManager)this.app.getManager(130));
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().a(this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$IndividUpdateRedPacketLisener);
    b();
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      paramBundle = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(4);
      paramBundle.arg1 = 0;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramBundle, 200L);
    }
    c();
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "[Performance] doOnCreate, duration=" + (System.currentTimeMillis() - l1));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppVIPRecommendPayObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    IndividualRedPacketManager localIndividualRedPacketManager = (IndividualRedPacketManager)this.app.getManager(130);
    if (localIndividualRedPacketManager != null) {
      localIndividualRedPacketManager.a().a(null);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.a();
    }
    if (this.jdField_a_of_type_Lpk != null) {
      this.jdField_a_of_type_Lpk.a();
    }
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.removeAllViews();
      this.jdField_a_of_type_ComTencentSmttSdkWebView.destroy();
      this.jdField_a_of_type_ComTencentSmttSdkWebView = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_d_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    long l1 = System.currentTimeMillis();
    super.doOnResume();
    this.jdField_a_of_type_Boolean = false;
    if (this.app != null)
    {
      c();
      e();
    }
    WebProcessManager.a(jdField_c_of_type_JavaUtilList, "key_ind_dns_parse");
    VasWebviewUtil.preparePareAsyncCookie();
    if (this.app != null)
    {
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppVIPRecommendPayObserver);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.a(this);
      this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.b();
      this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationSetActivity", 2, "[Performance] doOnResume, duration=" + (System.currentTimeMillis() - l1));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      f();
      return true;
    case 1: 
      IndividuationConfigInfo localIndividuationConfigInfo = (IndividuationConfigInfo)paramMessage.obj;
      if (localIndividuationConfigInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo = localIndividuationConfigInfo;
      }
      if (paramMessage.arg1 == 1) {}
      for (bool = true;; bool = false)
      {
        b(bool);
        return true;
      }
    case 2: 
      a(this.jdField_a_of_type_VipRecommendMQQCommPayInfo);
      return true;
    case 3: 
      k();
      return true;
    case 4: 
      if (paramMessage.arg1 == 1) {
        bool = true;
      }
      a(bool);
      return true;
    }
    a((IndividuationConfigInfo)paramMessage.obj);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296601: 
      if (AppSetting.j) {
        paramView.setContentDescription("主题");
      }
      a((byte)2, true);
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_theme_mall", 0, 0, "", "", "", "");
      return;
    case 2131296607: 
      if (AppSetting.j) {
        paramView.setContentDescription("背景");
      }
      a((byte)8, true);
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_background", 0, 0, "", "", "", "");
      return;
    case 2131296600: 
      if (AppSetting.j) {
        paramView.setContentDescription("气泡");
      }
      a((byte)0, true);
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_bubble_mall", 0, 0, "", "", "", "");
      return;
    case 2131296602: 
      if (AppSetting.j) {
        paramView.setContentDescription("字体");
      }
      a((byte)4, true);
      return;
    case 2131296609: 
      if (AppSetting.j) {
        paramView.setContentDescription("表情");
      }
      a((byte)3, true);
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_ep_mall", 52, 0, "", "", "", "");
      return;
    case 2131296603: 
      if (AppSetting.j) {
        paramView.setContentDescription("挂件");
      }
      a((byte)1, true);
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_avatar", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "PendantMarket", "NativeEntrance", 0, 0, "", "", "", "");
      return;
    case 2131296604: 
      if (AppSetting.j) {
        paramView.setContentDescription("名片");
      }
      a((byte)5, true);
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_gxcard_tab", 0, 0, "", "", "", "");
      return;
    case 2131296606: 
      if (AppSetting.j) {
        paramView.setContentDescription("套装");
      }
      a((byte)6, true);
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_gxsuit_tab", 0, 0, "", "", "", "");
      return;
    case 2131296608: 
      if (AppSetting.j) {
        paramView.setContentDescription("彩铃");
      }
      a((byte)9, true);
      ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_colorring", 0, 0, "", "", "", "");
      i1 = ((SVIPHandler)this.app.a(13)).h();
      if (i1 == 2) {
        i1 = 0;
      }
      break;
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1E", "0X8004A1E", 0, 0, "" + i1, "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X8004FFF", "0X8004FFF", 0, 0, "" + i1, "", "", "");
      return;
      if (i1 == 3)
      {
        i1 = 2;
        continue;
        if (AppSetting.j) {
          paramView.setContentDescription("来电");
        }
        a((byte)7, true);
        VipUtils.a(this.app, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 1, 0, new String[0]);
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Enter_funcall", 0, 0, "", "", "", "");
        return;
        if (AppSetting.j) {
          paramView.setContentDescription("红包");
        }
        if (((IndividualRedPacketManager)this.app.getManager(130)).a()) {}
        for (paramView = "1";; paramView = "0")
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8006135", "0X8006135", 0, 0, paramView, "1", "", "");
          a((byte)10, true);
          return;
        }
        if (AppSetting.j) {
          paramView.setContentDescription("我的装扮");
        }
        paramView = new Intent();
        paramView.putExtra("portraitOnly", true);
        paramView.putExtra("individuation_url_type", 40101);
        VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a(this, "myIndividuation", ""), -1L, paramView, true, -1);
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Clk_mine_native", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        return;
        if (AppSetting.j) {
          paramView.setContentDescription("搜索");
        }
        paramView = "";
        if (this.app != null) {
          paramView = this.app.a();
        }
        String str = ThemeUtil.getThemeDensity(this);
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        StringBuilder localStringBuilder = new StringBuilder(IndividuationUrlHelper.a(this, "individuationSearch", ""));
        localStringBuilder.append("&uin=" + paramView);
        localStringBuilder.append("&density=" + str);
        localIntent.putExtra("url", localStringBuilder.toString());
        startActivity(localIntent);
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "Clk_search", 0, 0, "", "", "", "");
        return;
        if (AppSetting.j) {
          paramView.setContentDescription("返回");
        }
        finish();
        return;
        ReportController.b(this.app, "CliOper", "", "", "Trends_tab", "ClkTopButton", 0, 0, "", "", "", "");
        VasH5PayUtil.a(this.app, this, this.jdField_e_of_type_JavaLangString, this.n, this.jdField_h_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, "IndividuationBtestVIP");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager == null) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividuationSetActivity", 2, "headerView reload!");
          }
          this.jdField_a_of_type_JavaUtilVector.clear();
          this.jdField_f_of_type_Boolean = false;
          this.jdField_g_of_type_Boolean = false;
          this.s = 0;
          b(this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.b();
        return;
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 != null)
    {
      int i1 = getResources().getColor(2131428295);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(i1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\IndividuationSetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */