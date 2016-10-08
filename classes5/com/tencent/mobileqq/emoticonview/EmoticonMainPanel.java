package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import rju;
import rjv;
import rjw;
import rjx;
import rka;
import rkb;
import rkc;
import rke;
import rkf;
import rkh;
import rkj;
import rkk;

public class EmoticonMainPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, EmoticonPackageChangedListener
{
  public static final int a = 1;
  public static final long a = 86400000L;
  protected static final String a = "EmoticonMainPanel";
  public static final int b = 2;
  public static long b = 0L;
  public static final String b = "force_to_recommend_panel_sp";
  public static boolean b = false;
  public static final int c = 3;
  private static final long c = -1702967296L;
  public static final String c = "report_AIOEmoticonPanel_OpenFirstTimeInProcess";
  public static final int d = 10;
  public static final String d = "report_AIOEmoticonPanel_OpenFirstTimeInAIO";
  public static final String e = "report_AIOEmoticonPanel_ReopenInAIO";
  public static final int f = 1;
  public static final String f = "emoticon_panel_";
  public static final int g = 2;
  public static final String g = "panelMode";
  public static final String h = "duration";
  private static boolean jdField_h_of_type_Boolean = true;
  public static final int i = 17;
  public static final String i = "sp_key_emoticon_panel_last_report_time";
  public static final int j = 18;
  public static final String j = "sp_key_emoticon_panel_report_count";
  public static int k = 0;
  public static final String k = "sp_key_market_open_time";
  public static int l = 2;
  public static final String l = "sp_key_send_h5_magic_face_time";
  float jdField_a_of_type_Float;
  public Context a;
  private View jdField_a_of_type_AndroidViewView;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new rkf(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public QQAppInterface a;
  private SyncListener jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener = new rkh(this);
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new rkc(this);
  EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  EmoticonTabAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter;
  public EmotionPanelViewPagerAdapter a;
  private HorizontalListViewEx jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("emoticon_panel", "com.tencent.mobileqq:web");
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  Runnable jdField_a_of_type_JavaLangRunnable = new rke(this);
  public List a;
  public boolean a;
  private ImageView b;
  public List b;
  public boolean c;
  public boolean d = true;
  int e;
  public boolean e;
  private boolean f;
  private boolean g;
  int jdField_h_of_type_Int;
  public int m;
  private int n = 0;
  private int o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    k = -1;
    jdField_b_of_type_Boolean = true;
  }
  
  public EmoticonMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private int a(EmotionPanelInfo paramEmotionPanelInfo)
  {
    int i1 = 1;
    if (paramEmotionPanelInfo == null)
    {
      QLog.e("EmoticonMainPanel", 1, "getMoreBtnStatusByEmotionInfo info = null");
      i1 = -1;
    }
    while ((paramEmotionPanelInfo.jdField_a_of_type_Int != 7) && (paramEmotionPanelInfo.jdField_a_of_type_Int != 10)) {
      return i1;
    }
    return 2;
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx == null) || ("".equals(paramString))) {}
    int i2;
    do
    {
      for (;;)
      {
        return 0;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          if (!paramBoolean) {
            break;
          }
          i2 = this.jdField_a_of_type_JavaUtilList.size();
          i1 = 0;
          while (i1 < i2)
          {
            paramString = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
            if ((paramString != null) && (paramString.jdField_a_of_type_Int == 9)) {
              return i1;
            }
            i1 += 1;
          }
        }
      }
      paramString = paramString.split("\\|");
    } while ((paramString == null) || (paramString.length <= 0));
    int i1 = paramString.length - 1;
    label112:
    CharSequence localCharSequence;
    if (i1 >= 0)
    {
      localCharSequence = paramString[i1];
      if (!TextUtils.isEmpty(localCharSequence)) {
        break label138;
      }
    }
    for (;;)
    {
      i1 -= 1;
      break label112;
      break;
      label138:
      i2 = 0;
      while (i2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i2);
        if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (localCharSequence.equals(localEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
          return i2;
        }
        i2 += 1;
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "initEmoticonView 2");
    }
    long l1 = System.currentTimeMillis();
    int i1 = paramInt;
    if (!EmoticonUtils.c(this.n))
    {
      i1 = paramInt;
      if (paramInt >= 2) {
        i1 = 1;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
    Object localObject = getContext().getSharedPreferences("mobileQQ", 0);
    String str = ((SharedPreferences)localObject).getString("LAST_ADD_EMO_PACKAGE", "");
    boolean bool;
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_e_of_type_Boolean = false;
      this.c = false;
      ((SharedPreferences)localObject).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
      bool = ((SharedPreferences)localObject).getBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", false);
      ((SharedPreferences)localObject).edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").commit();
      b(this.jdField_a_of_type_Boolean);
      if (paramString != null) {
        break label411;
      }
    }
    label252:
    label297:
    label396:
    label403:
    label411:
    for (paramInt = a(str, bool);; paramInt = 0)
    {
      c(paramInt);
      i1 = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonMainPanel", 2, "new pkg downloaded in market, selectIndex:" + paramInt);
        i1 = paramInt;
      }
      if (paramString != null)
      {
        b(this.jdField_a_of_type_Boolean);
        i1 = i2;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          i1 = this.jdField_a_of_type_JavaUtilList.size();
          paramInt = 0;
          if (paramInt >= i1) {
            break label403;
          }
          localObject = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          if ((localObject == null) || (((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (!paramString.equals(((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
            break label396;
          }
          i1 = i2;
          if (paramInt != -1) {
            i1 = paramInt;
          }
        }
        c(i1);
      }
      for (;;)
      {
        b(i1);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - l1));
        }
        return;
        if ((this.jdField_a_of_type_Boolean) && (this.c))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "new pkg downloaded in panel, refresh");
          }
          this.jdField_e_of_type_Boolean = false;
        }
        break;
        paramInt += 1;
        break label252;
        paramInt = -1;
        break label297;
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    EmotionPanelInfo localEmotionPanelInfo = null;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      localEmotionPanelInfo = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (localEmotionPanelInfo != null)
    {
      int i1 = a(localEmotionPanelInfo);
      if (this.jdField_h_of_type_Int != i1)
      {
        this.jdField_h_of_type_Int = i1;
        if (!this.jdField_a_of_type_Boolean) {
          break label90;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841718);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt, false);
      return;
      label90:
      if (this.jdField_h_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841707);
        this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(10.0F * this.jdField_a_of_type_Float), 0, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "onPageSelected, show del pic");
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    ThreadManager.a(new rju(paramQQAppInterface), 8, null, true);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    this.jdField_a_of_type_JavaUtilList = EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_e_of_type_Boolean) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
    } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0));
    if (paramInt == l) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).commit();
    }
    Object localObject1 = "";
    int i2 = this.jdField_a_of_type_JavaUtilList.size();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    label99:
    Object localObject2;
    EmoticonTabAdapter.EmoticonTabItem localEmoticonTabItem;
    if (i1 < i2)
    {
      localObject2 = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
      localEmoticonTabItem = new EmoticonTabAdapter.EmoticonTabItem();
      localEmoticonTabItem.jdField_a_of_type_Int = ((EmotionPanelInfo)localObject2).jdField_a_of_type_Int;
      if (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 8) {
        localObject1 = "推荐面板";
      }
    }
    for (;;)
    {
      localEmoticonTabItem.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localArrayList.add(localEmoticonTabItem);
      i1 += 1;
      break label99;
      if (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 9)
      {
        localObject1 = "魔法表情面板";
      }
      else if (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 4)
      {
        localObject1 = "收藏表情面板";
      }
      else if (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 7)
      {
        localObject1 = "经典表情面板";
      }
      else if (((((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 6) || (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 10)) && (((EmotionPanelInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null))
      {
        EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
        localObject2 = localEmoticonPackage.name + "面板";
        localObject1 = localObject2;
        if (localEmoticonPackage.status != 2) {
          localObject1 = (String)localObject2 + ",未下载";
        }
        localEmoticonTabItem.jdField_a_of_type_JavaLangString = localEmoticonPackage.epId;
        localEmoticonTabItem.jdField_b_of_type_Int = localEmoticonPackage.subType;
        if (localEmoticonPackage.status == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localEmoticonTabItem.jdField_a_of_type_Boolean = bool;
          break;
        }
        if (localArrayList.size() > 0)
        {
          if (this.d) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.a_(paramInt);
          }
          this.d = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter.a(localArrayList);
        }
        this.jdField_e_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonMainPanel", 2, "[Performance] initSecondTabView duration:" + (System.currentTimeMillis() - l1));
        return;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext)) {}
    FavroamingManager localFavroamingManager;
    VipComicMqqHandler localVipComicMqqHandler;
    do
    {
      return;
      localFavroamingManager = (FavroamingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(102);
      localVipComicMqqHandler = (VipComicMqqHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(80);
    } while (!localFavroamingManager.isInSyncing());
    localVipComicMqqHandler.a();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "comicHandler.GetMyComicFavorEmotIcons");
    }
    localFavroamingManager.addSyncListener(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
    localFavroamingManager.syncLocalDel();
    if (paramBoolean) {
      ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 5, null, false);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
  
  private void h()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf("100610.100611"));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag != null) && (localAppInfo.iNewFlag.get() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "emoji mall has redpoint.");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B8", 0, 0, "", "", "", "");
      if (getContext().getSharedPreferences("mobileQQ", 0).getBoolean("emo_panel_mall_new_played", false)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    postDelayed(new rka(this), 200L);
  }
  
  public int a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int i2 = this.jdField_a_of_type_JavaUtilList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 6)
      {
        localObject = ((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
        if ((localObject != null) && (paramString.equals(((EmoticonPackage)localObject).epId)))
        {
          if (jdField_b_of_type_Boolean) {
            return i1 - 3;
          }
          return i1 - 2;
        }
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void a()
  {
    StartupTracker.a(null, "AIO_EmoticonPanel_OnResume");
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    if ((getVisibility() == 0) && (this.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.jdField_e_of_type_Boolean = false;
      k -= this.jdField_e_of_type_Int;
      if (k < 0) {
        k = 0;
      }
      a(k, null);
      this.jdField_e_of_type_Int = 0;
      this.f = false;
    }
    for (;;)
    {
      StartupTracker.a("AIO_EmoticonPanel_OnResume", null);
      return;
      if (isShown())
      {
        if ((EmoticonUtils.c(this.n)) && (!TextUtils.isEmpty(getContext().getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "download in market, initEmoticonView");
          }
          a(0, null);
        }
        e();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload begins.");
    }
    EmotionPanelPayBackListenerManager.a().a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload ends.");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.n = paramInt1;
    this.m = paramInt2;
    this.o = super.getResources().getConfiguration().orientation;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131298164));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter = new EmotionPanelViewPagerAdapter(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298162));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131298170);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = ((HorizontalListViewEx)super.findViewById(2131298171));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter = new EmoticonTabAdapter(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298172));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298169));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131428139));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramContext.getResources().getColor(2131428138));
    super.findViewById(2131296964).setBackgroundColor(paramContext.getResources().getColor(2131428137));
    EmojiListenerManager.a().a(this);
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.g = true;
    a(paramString);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageDeleted");
    }
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    int i2;
    do
    {
      return;
      int i1 = 0;
      int i3;
      for (i2 = -1; i1 < this.jdField_a_of_type_JavaUtilList.size(); i2 = i3)
      {
        Object localObject = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
        i3 = i2;
        if (localObject != null)
        {
          i3 = i2;
          if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 6)
          {
            localObject = ((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
            i3 = i2;
            if (localObject != null)
            {
              i3 = i2;
              if (paramEmoticonPackage.epId.equals(((EmoticonPackage)localObject).epId)) {
                i3 = i1;
              }
            }
          }
        }
        i1 += 1;
      }
    } while (i2 == -1);
    if (i2 < k) {}
    for (this.jdField_e_of_type_Int += 1;; this.jdField_e_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1)) {
      do
      {
        this.f = true;
        return;
      } while ((i2 != k) || (i2 != this.jdField_a_of_type_JavaUtilList.size() - 1));
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageMoved");
    }
    this.f = true;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "initEmoticonView 1");
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("recommendEmotion_sp_name", 0);
    long l1 = localSharedPreferences.getLong("last_get_recommendemotion_time_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 0L);
    int i1 = localSharedPreferences.getInt("recommendSeqinterval", 7200);
    if (System.currentTimeMillis() - l1 >= i1 * 1000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "initEmoticonView send req to recommend");
      }
      ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a();
    }
    a(k, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "switchTabMode selectIndex = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_EnterSecond");
    int i1 = paramInt;
    if (!this.jdField_e_of_type_Boolean)
    {
      b(this.jdField_a_of_type_Boolean);
      i1 = paramInt;
      if (this.c)
      {
        i1 = paramInt;
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          i1 = paramInt;
          if (this.jdField_a_of_type_JavaUtilList.size() > 0)
          {
            if ((this.jdField_a_of_type_JavaUtilList.size() <= l) || (((EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(l)).jdField_a_of_type_Int != 8)) {
              break label396;
            }
            paramInt = 1;
            label141:
            if (paramInt == 0) {
              break label406;
            }
            if (this.jdField_a_of_type_JavaUtilList.size() < 4) {
              break label401;
            }
            i1 = 3;
          }
        }
        label160:
        this.c = false;
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (i1 >= 0))
    {
      paramInt = i1;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size()) {}
    }
    else
    {
      paramInt = 0;
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0);
    if (((SharedPreferences)localObject).getBoolean("force_to_recommend_panel_sp", false)) {
      if ((this.jdField_a_of_type_JavaUtilList == null) || ((this.jdField_a_of_type_JavaUtilList.size() > l) && (((EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(l)).jdField_a_of_type_Int == 8)))
      {
        k = l;
        paramInt = l;
        label279:
        ((SharedPreferences)localObject).edit().putBoolean("force_to_recommend_panel_sp", false).commit();
        label299:
        if (!this.jdField_e_of_type_Boolean) {
          c(paramInt);
        }
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
          break label443;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(null);
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_EmoticonPanel_EnterSecond", null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonMainPanel", 2, "[Performance] switchTabMode to , duration:" + (System.currentTimeMillis() - l1) + ",mSecondTabInited:" + this.jdField_e_of_type_Boolean);
      return;
      label396:
      paramInt = 0;
      break label141;
      label401:
      i1 = 0;
      break label160;
      label406:
      if (this.jdField_a_of_type_JavaUtilList.size() >= 3)
      {
        i1 = 2;
        break label160;
      }
      i1 = 0;
      break label160;
      k = paramInt;
      break label279;
      k = paramInt;
      break label299;
      label443:
      i1 = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.getSelectedItemPosition();
      if ((i1 != paramInt) || (i1 == 0))
      {
        if (paramInt == l) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).commit();
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] switchTabMode to , setAdapter duration: " + (System.currentTimeMillis() - l2));
      }
      a(paramInt, true);
      if ((this.g) && (paramInt == 0))
      {
        localObject = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((EmotionPanelInfo)localObject);
      }
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("EmoticonMainPanel", 1, "onPackageAdded: ep = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageAdded:");
    }
    this.f = true;
    post(new rkb(this, paramEmoticonPackage));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "OnDestory");
    }
    EmojiListenerManager.a().b(this);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    HorizontalListViewEx.b();
    EmotionPanelPayBackListenerManager.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter = null;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject = (FavroamingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(102);
      if (localObject != null) {
        ((FavroamingManager)localObject).removeSyncListener(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
      }
      localObject = (CommonUsedSystemEmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(171);
      if (localObject != null) {
        ((CommonUsedSystemEmojiManager)localObject).b();
      }
      localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (localObject != null)
      {
        ((EmoticonManager)localObject).d();
        ((EmoticonManager)localObject).c();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  public void d()
  {
    if (!isShown()) {
      return;
    }
    postDelayed(new rkj(this), 200L);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    long l1;
    do
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        if (jdField_b_of_type_Long == -1L) {
          return;
        }
      }
      catch (StackOverflowError paramCanvas)
      {
        QLog.e("EmoticonMainPanel", 1, "dispatchDraw, StackOverflowError, stack:" + MsfSdkUtils.getStackTraceString(paramCanvas));
        return;
      }
      l1 = System.currentTimeMillis() - jdField_b_of_type_Long;
    } while (l1 <= 0L);
    paramCanvas = new HashMap(2);
    if (jdField_h_of_type_Boolean)
    {
      i1 = 1;
      paramCanvas.put("panelMode", "2");
      paramCanvas.put("duration", String.valueOf(l1));
      ThreadManager.a(new rjw(this, i1, l1, paramCanvas), 5, null, true);
      StartupTracker.a("AIO_EmoticonPanel_OpenDuration", null);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] dispatchDraw over, duration=" + l1 + ",openCondition=" + i1 + ",panelMode=" + "2");
      }
      jdField_b_of_type_Long = -1L;
      this.g = false;
      jdField_h_of_type_Boolean = false;
      return;
    }
    if (this.g) {}
    for (int i1 = 2;; i1 = 3) {
      break;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "refresh fav emoticon panel");
    }
    postDelayed(new rkk(this), 200L);
  }
  
  public void f()
  {
    postDelayed(new rjv(this), 200L);
  }
  
  public void g()
  {
    ThreadManager.b().post(new rjx(this));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if ((this.jdField_h_of_type_Int != 2) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.b();
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf("100610.100611"));
      getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).commit();
    }
    for (boolean bool = true;; bool = false)
    {
      VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
      EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1, bool, "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("emoticon_panel_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        if (paramView != null) {
          paramView.edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).commit();
        }
      }
      if (WebProcessManager.c()) {}
      for (int i1 = 1;; i1 = 0)
      {
        VasWebviewUtil.reportVasStatus("personal_web_preload_hit_rit", "emoticon_main_panel_plus", "0", 0, 0, i1, 0, "", "");
        return;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i1 == 1) || (i1 == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_PageScroll");
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((localEmotionPanelInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b(localEmotionPanelInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPageSelected, position=" + paramInt + "panelInfo = " + localEmotionPanelInfo);
    }
    int i1 = a(localEmotionPanelInfo);
    if (this.jdField_h_of_type_Int != i1)
    {
      this.jdField_h_of_type_Int = i1;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841718);
      }
    }
    else
    {
      label139:
      if (k == paramInt) {
        break label319;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
      if (paramInt == l) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).commit();
      }
    }
    for (;;)
    {
      k = paramInt;
      StartupTracker.a("AIO_EmoticonPanel_PageScroll", null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonMainPanel", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l1));
      return;
      if (this.jdField_h_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841707);
        this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(10.0F * this.jdField_a_of_type_Float), 0, 0, 0);
        if (!QLog.isColorLevel()) {
          break label139;
        }
        QLog.d("EmoticonMainPanel", 2, "onPageSelected, show del pic");
        break label139;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label139;
      label319:
      if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.jdField_a_of_type_Int == 8))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", paramInt + "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "view times report. cur page:" + paramInt);
        }
      }
    }
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public void setVisibility(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (paramInt != getVisibility())
    {
      super.setVisibility(paramInt);
      if (paramInt == 0)
      {
        paramInt = super.getResources().getConfiguration().orientation;
        if ((this.o != paramInt) && (!this.f)) {
          break label191;
        }
        this.jdField_e_of_type_Boolean = false;
        k -= this.jdField_e_of_type_Int;
        if (k < 0) {
          k = 0;
        }
        a(null);
        this.jdField_e_of_type_Int = 0;
        this.f = false;
      }
    }
    for (;;)
    {
      this.o = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] reopen in aio, duration=" + (System.currentTimeMillis() - l1));
      }
      h();
      File localFile = new File(AppConstants.bU);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "root dir not exist. try to make it. success:" + bool);
        }
      }
      return;
      label191:
      this.jdField_e_of_type_Boolean = false;
      a(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmoticonMainPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */