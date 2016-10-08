package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.EcShopADView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import hto;
import htp;
import htq;
import htr;
import hts;
import htt;
import htu;
import htv;
import htw;
import hty;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class EcShopAssistantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, EcShopRecommendView.onRecommendListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, FaceDecoder.DecodeTaskCompletionListener, SwipListView.RightIconMenuListener, Observer
{
  static final int jdField_a_of_type_Int = 10001;
  public static final String a = "pub_account_type";
  public static String[] a;
  static final int b = 10002;
  public static final String b = "type_ecshop_account";
  public static final int c = 10003;
  public static final String c = "ecshop_distance_tip";
  public static final int d = 10004;
  public static String d;
  static int jdField_e_of_type_Int = 0;
  public static String e;
  private static final String f = "EcShopAssistantActivity";
  private long jdField_a_of_type_Long;
  Rect jdField_a_of_type_AndroidGraphicsRect = null;
  Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public EcShopAssistantManager a;
  EcShopHandler jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler;
  public EcShopListAdapter a;
  EcShopObserver jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver = new htw(this);
  EcShopOptPopBar jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopOptPopBar;
  public EcShopRecommendView a;
  public DragFrameLayout a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new htv(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new htu(this);
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new htp(this, 0, true, false, 60000L, false, false, "ecshop");
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("web_ecshop", "com.tencent.mobileqq:web");
  public FaceDecoder a;
  EcShopADView jdField_a_of_type_ComTencentMobileqqWidgetEcShopADView;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  public boolean a;
  View[] jdField_a_of_type_ArrayOfAndroidViewView = null;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  SingleLineTextView[] jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView;
  public ImageView b;
  public boolean b;
  boolean c = false;
  boolean d;
  boolean jdField_e_of_type_Boolean = false;
  public boolean f = false;
  private boolean g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_e_of_type_Int = 600000;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "gouwu.qq.com" };
  }
  
  public EcShopAssistantActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private SharedPreferences a()
  {
    String str2 = this.app.a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return getSharedPreferences("ecshop_sp" + str1, 0);
  }
  
  private void g()
  {
    super.setTitle(2131372083);
    Object localObject2 = this.leftView.getText().toString();
    Object localObject1 = localObject2;
    if (!getString(2131366637).equals(localObject2)) {
      localObject1 = String.format(getResources().getString(2131364512), new Object[] { getResources().getString(2131367566) });
    }
    this.leftView.setContentDescription((CharSequence)localObject1);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131298718));
    localObject1 = View.inflate(this, 2130904538, null);
    ((View)localObject1).findViewById(2131303101).setOnClickListener(this);
    ((View)localObject1).findViewById(2131303105).setOnClickListener(this);
    ((View)localObject1).findViewById(2131303109).setOnClickListener(this);
    ((View)localObject1).findViewById(2131303114).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.a((View)localObject1);
    localObject2 = getLayoutInflater().inflate(2130904527, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetEcShopADView = ((EcShopADView)((View)localObject2).findViewById(2131298831));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.a((View)localObject2);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter = new EcShopListAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetSwipListView, this, 5);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    h();
    if (EcShopAssistantManager.jdField_b_of_type_JavaUtilList.size() <= 0)
    {
      localObject2 = new EcShopAssistantManager.DiscoveryConfig();
      ((EcShopAssistantManager.DiscoveryConfig)localObject2).jdField_a_of_type_Int = 1;
      ((EcShopAssistantManager.DiscoveryConfig)localObject2).jdField_a_of_type_JavaLangString = "http://imgcache.qq.com/zzapp/qqshop/banner/image/ui_icon_search_20150729_v_3.png";
      ((EcShopAssistantManager.DiscoveryConfig)localObject2).jdField_b_of_type_JavaLangString = getString(2131362025);
      ((EcShopAssistantManager.DiscoveryConfig)localObject2).c = "http://gouwu.qq.com/shop/index.html?_wv=1027";
      EcShopAssistantManager.jdField_b_of_type_JavaUtilList.add(localObject2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopOptPopBar = new EcShopOptPopBar(this);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopOptPopBar.a();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297082);
    ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_discovery", "Pv_shopdiscovery", 0, 0, EcShopAssistantManager.jdField_b_of_type_Int + "", "", "", "");
    if (!TextUtils.isEmpty(EcShopAssistantManager.n)) {
      super.setTitle(EcShopAssistantManager.n);
    }
    c((View)localObject1);
  }
  
  private void h()
  {
    if (EcShopAssistantManager.jdField_a_of_type_ArrayOfComTencentBizPubaccountEcshopassitEcShopAssistantManager$BannerConfig == null) {}
    EcShopAssistantManager.BannerConfig[] arrayOfBannerConfig;
    do
    {
      return;
      arrayOfBannerConfig = EcShopAssistantManager.jdField_a_of_type_ArrayOfComTencentBizPubaccountEcshopassitEcShopAssistantManager$BannerConfig;
    } while ((arrayOfBannerConfig == null) || (arrayOfBannerConfig.length <= 0));
    Drawable localDrawable = super.getResources().getDrawable(2130838381);
    localDrawable.mutate().setAlpha(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetEcShopADView.setCircle(false);
    int j = 0;
    int i = 0;
    label53:
    int k;
    if (j < arrayOfBannerConfig.length)
    {
      EcShopAssistantManager.BannerConfig localBannerConfig = arrayOfBannerConfig[j];
      if (localBannerConfig != null) {
        for (;;)
        {
          Object localObject2;
          try
          {
            long l = NetConnInfoCenter.getServerTime();
            if ((localBannerConfig.jdField_a_of_type_Long > l) || (l > localBannerConfig.b))
            {
              k = i;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("EcShopAssistantActivity", 2, "invalid time currTime=" + l + ",startTs=" + localBannerConfig.jdField_a_of_type_Long + ",endTS=" + localBannerConfig.b);
              k = i;
              break;
            }
            Object localObject1 = EcShopAssistantManager.m + localBannerConfig.jdField_a_of_type_JavaLangString;
            Object localObject3 = URLDrawable.getDrawable(new URL("profile_img_icon", "http://imgcache.qq.com/zzapp/qqshop/banner/image/" + localBannerConfig.jdField_a_of_type_JavaLangString, (String)localObject1), localDrawable, localDrawable);
            localObject1 = (FrameLayout)super.getLayoutInflater().inflate(2130904542, null);
            localObject2 = (URLImageView)((FrameLayout)localObject1).findViewById(2131298833);
            ((URLImageView)localObject2).setContentDescription(localBannerConfig.c);
            ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject2).setImageDrawable((Drawable)localObject3);
            if (((URLDrawable)localObject3).getStatus() == 1)
            {
              ((FrameLayout.LayoutParams)((URLImageView)localObject2).getLayoutParams()).height = AIOUtils.a(100.0F, getResources());
              localObject2 = (ImageView)((FrameLayout)localObject1).findViewById(2131298834);
              ((ImageView)localObject2).setTag(localBannerConfig);
              ((ImageView)localObject2).setContentDescription(String.format("点击进入%1$s页面", new Object[] { localBannerConfig.c }));
              ((ImageView)localObject2).setOnClickListener(new htq(this));
              this.jdField_a_of_type_ComTencentMobileqqWidgetEcShopADView.a((View)localObject1, i);
              i += 1;
              break label586;
            }
            if (i <= 0) {
              break label537;
            }
            localObject3 = new ProgressBar(this);
            ((ProgressBar)localObject3).setId(2131296326);
            ((ProgressBar)localObject3).setIndeterminateDrawable(getResources().getDrawable(2130838321));
            k = AIOUtils.a(16.0F, getResources());
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(k, k);
            localLayoutParams.gravity = 17;
            ((FrameLayout)localObject1).addView((View)localObject3, localLayoutParams);
            ((URLImageView)localObject2).setTag(localObject3);
            ((URLImageView)localObject2).setURLDrawableDownListener(new hto(this));
            continue;
            QLog.d("EcShopAssistantActivity", 2, "AdBanner error:" + localException.getMessage());
          }
          catch (Exception localException)
          {
            k = i;
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          k = i;
          break;
          label537:
          ((FrameLayout.LayoutParams)((URLImageView)localObject2).getLayoutParams()).height = 1;
          this.jdField_a_of_type_ComTencentMobileqqWidgetEcShopADView.setNavVisible(-1, true);
          ((URLImageView)localObject2).setTag(this.jdField_a_of_type_ComTencentMobileqqWidgetEcShopADView);
        }
      }
    }
    for (;;)
    {
      j += 1;
      i = k;
      break label53;
      break;
      label586:
      k = i;
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(10001))) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10001);
    }
  }
  
  protected List a()
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a();
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.app.getManager(55);
    int i;
    ArrayList localArrayList;
    SharedPreferences localSharedPreferences;
    int j;
    if (localList == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      localSharedPreferences = a();
      j = 0;
      label45:
      if (j >= i) {
        return localArrayList;
      }
      localObject = (EcShopData)localList.get(j);
      if (localObject != null) {
        break label90;
      }
    }
    label90:
    RecentItemEcShop localRecentItemEcShop;
    for (;;)
    {
      j += 1;
      break label45;
      i = localList.size();
      break;
      localRecentItemEcShop = new RecentItemEcShop((EcShopData)localObject);
      if ((this.f) && (!TextUtils.isEmpty(EcShopAssistantManager.S)) && (EcShopAssistantManager.S.equals(localRecentItemEcShop.a())))
      {
        if (localSharedPreferences.getBoolean("ad_cert", false)) {
          localRecentItemEcShop.I = 2130838906;
        }
        localRecentItemEcShop.jdField_b_of_type_JavaLangString = localSharedPreferences.getString("ad_nick", "");
        localRecentItemEcShop.jdField_b_of_type_JavaLangCharSequence = localSharedPreferences.getString("ad_title", "");
        localArrayList.add(localRecentItemEcShop);
      }
      else
      {
        if (!"ad".equals(((EcShopData)localObject).msgId)) {
          break label230;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a(((EcShopData)localObject).mUin);
      }
    }
    label230:
    localRecentItemEcShop.a(this.app, BaseApplication.getContext());
    if (QLog.isDevelopLevel())
    {
      long l = System.currentTimeMillis();
      QLog.i("Q.recent.cost", 4, "[" + (l - 0L) + ", " + localRecentItemEcShop.a() + "," + localRecentItemEcShop.getClass().getName() + "]");
      localRecentItemEcShop.a();
    }
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    if ((((EcShopData)localObject).bindUin > 9999L) && (localFriendsManager.b(String.valueOf(((EcShopData)localObject).bindUin)))) {
      localRecentItemEcShop.jdField_a_of_type_Long = ((EcShopData)localObject).bindUin;
    }
    Object localObject = localPublicAccountDataManager.b(localRecentItemEcShop.a());
    if ((localObject != null) && (((PublicAccountInfo)localObject).certifiedGrade > 0L)) {}
    for (localRecentItemEcShop.I = 2130838906;; localRecentItemEcShop.I = 0)
    {
      localArrayList.add(localRecentItemEcShop);
      if ((j != 0) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.i("EcShop", 2, "get data from cache first:" + localRecentItemEcShop.jdField_b_of_type_JavaLangString);
      break;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = null;
  }
  
  void a(int paramInt)
  {
    if ((paramInt < -1) || (paramInt > 3)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ArrayOfAndroidViewView == null)
      {
        QLog.e("EcShopAssistantActivity", 1, "reddots == null");
        return;
      }
      int i = 0;
      while (i < 4)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(8);
        i += 1;
      }
    } while (paramInt == -1);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].setVisibility(0);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      paramString = a().getString("recommed_shop_uin", null);
    } while (TextUtils.isEmpty(paramString));
    paramString = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString);
    if (paramString == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838582);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
  }
  
  public void a(View paramView)
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((paramRecentBaseData == null) || (TextUtils.isEmpty(paramRecentBaseData.a()))) {}
    do
    {
      return;
      if (!paramRecentBaseData.a().equals(EcShopAssistantManager.S)) {
        break;
      }
      paramView = a().getString("ad_url", null);
    } while (TextUtils.isEmpty(paramView));
    paramRecentBaseData = new Intent(this, QQBrowserActivity.class);
    paramRecentBaseData.putExtra("url", paramView);
    paramRecentBaseData.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivity(paramRecentBaseData);
    long l = a().getLong("ad_id", 0L);
    ((EcshopReportHandler)this.app.a(88)).a(134246437, null, null, null, null, l, false);
    return;
    int i = paramRecentBaseData.b();
    String str = paramRecentBaseData.a();
    Object localObject = new Intent(this, ChatActivity.class);
    ((Intent)localObject).putExtra("uintype", 1008);
    ((Intent)localObject).putExtra("uin", str);
    ((Intent)localObject).putExtra("uinname", paramString);
    ((Intent)localObject).putExtra("start_time", System.currentTimeMillis());
    ((Intent)localObject).putExtra("red_hot_count", i);
    ((Intent)localObject).putExtra("jump_from", 1);
    int j;
    if (i > 0)
    {
      paramBoolean = true;
      ((Intent)localObject).putExtra("has_unread_msg", paramBoolean);
      if ((paramRecentBaseData instanceof RecentPubAccountAssistantItem))
      {
        j = ((RecentPubAccountAssistantItem)paramRecentBaseData).c();
        if (j > 0)
        {
          if (j / 1000 <= 0) {
            break label528;
          }
          paramView = new BigDecimal(j / 1000.0F);
          paramView = this.app.a().getResources().getString(2131369273) + paramView.setScale(1, 4).floatValue() + "km";
          label331:
          ((Intent)localObject).putExtra("pub_account_type", "type_ecshop_account");
          ((Intent)localObject).putExtra("ecshop_distance_tip", paramView);
        }
      }
      super.startActivity((Intent)localObject);
      ReportController.b(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_helper", "Clk_shopItem", 0, 0, str, "", paramRecentBaseData.b(), "");
      localObject = this.app.a().a(str, 1008);
      paramView = "";
      paramString = paramView;
      if (localObject == null) {
        break label609;
      }
      paramString = XMLMessageUtils.a((MessageRecord)localObject);
      if (paramString != null) {
        paramView = Long.toString(paramString.mMsgId);
      }
      paramString = paramView;
      if (!TextUtils.isEmpty(paramView)) {
        break label609;
      }
    }
    label528:
    label609:
    for (paramView = ((MessageRecord)localObject).getExtInfoFromExtStr("pa_msgId");; paramView = paramString)
    {
      PublicAccountHandler.a(this.app, str, "Pb_account_lifeservice", "mp_msg_sys_3", "msg_aio", paramView, String.valueOf(i));
      if (i > 0)
      {
        ReportController.b(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_Msghelper", "Clk_MsgshopItem", 0, 0, str, "", paramRecentBaseData.jdField_b_of_type_JavaLangString, "");
        return;
        paramBoolean = false;
        break;
        paramView = this.app.a().getResources().getString(2131369273) + j + "m";
        break label331;
      }
      ReportController.b(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_NoMsghelper", "Clk_NoMsgshopItem", 0, 0, str, "", paramRecentBaseData.jdField_b_of_type_JavaLangString, "");
      return;
    }
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (!(paramObject instanceof RecentItemEcShop))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EcShopAssistantActivity", 2, "onclick data=" + paramObject);
      }
      return;
    }
    paramView = (RecentItemEcShop)paramObject;
    paramObject = new Intent();
    ((Intent)paramObject).putExtra("need_finish", true);
    ((Intent)paramObject).putExtra("uinname", paramView.b());
    ((Intent)paramObject).putExtra("uintype", 1008);
    PublicAccountUtil.a((Intent)paramObject, this.app, this, paramView.a(), -1, 2000, 4);
    ReportController.b(this.app, "P_CliOper", "Shop_lifeservice", "", "Shop_helperhead", "Clk_shopItemhead", 0, 0, paramView.a(), "", paramView.b(), "");
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EcShopAssistantActivity", 2, "onRecentBaseDataDelete uin:" + paramRecentBaseData.a());
    }
    paramString = paramRecentBaseData.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a(paramString);
    }
    i();
    ((RecentItemEcShop)paramRecentBaseData).b(this.app);
    MqqHandler localMqqHandler = this.app.a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1014);
    }
    if (paramRecentBaseData.a().equals(EcShopAssistantManager.S))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler.a(3);
      }
      long l = a().getLong("ad_id", 0L);
      ((EcshopReportHandler)this.app.a(88)).a(134246438, null, null, null, null, l, false);
      paramRecentBaseData = a().edit();
      paramRecentBaseData.remove("ad_id");
      paramRecentBaseData.putBoolean("is_ad_added", false);
      paramRecentBaseData.commit();
      return;
    }
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064D2", "0X80064D2", 0, 0, "" + paramRecentBaseData.H, "", "", "");
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131299995))
    {
      paramDragFrameLayout = (RecentItemEcShop)paramDragFrameLayout.a().getTag(2131296585);
      if (paramDragFrameLayout != null)
      {
        paramDragFrameLayout.b(this.app);
        e();
        i();
      }
    }
  }
  
  public void b()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = AIOUtils.a(216.0F, getResources());
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, localDisplayMetrics.heightPixels - i, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
    Object localObject1 = EcShopAssistantManager.jdField_a_of_type_ArrayOfJavaLangString[(paramInt - 1)];
    Object localObject2 = (EcShopAssistantManager.TopBtnInfo)EcShopAssistantManager.c.get(Integer.valueOf(paramInt));
    if ((localObject2 != null) && (!TextUtils.isEmpty(((EcShopAssistantManager.TopBtnInfo)localObject2).c))) {
      localObject1 = ((EcShopAssistantManager.TopBtnInfo)localObject2).c;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramInt == 3)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        if (!((String)localObject1).contains("?")) {
          break label181;
        }
      }
      label181:
      for (localObject1 = "&lat=";; localObject1 = "?lat=")
      {
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(EcShopHandler.a);
        ((StringBuilder)localObject2).append("&lng=");
        ((StringBuilder)localObject2).append(EcShopHandler.b);
        if (!TextUtils.isEmpty(jdField_d_of_type_JavaLangString))
        {
          ((StringBuilder)localObject2).append("&shop=");
          ((StringBuilder)localObject2).append(jdField_d_of_type_JavaLangString);
        }
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity((Intent)localObject1);
        return;
      }
    }
  }
  
  public void b(View paramView)
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void c()
  {
    SharedPreferences localSharedPreferences = a();
    int i;
    if (localSharedPreferences.getBoolean("disc_reddot", false)) {
      i = 0;
    }
    for (;;)
    {
      int j = i;
      if (i != -1)
      {
        int k = localSharedPreferences.getInt("last_show_time1", 0);
        int m = localSharedPreferences.getInt("reddot_start", 0);
        int n = localSharedPreferences.getInt("reddot_end", 0);
        int i1 = localSharedPreferences.getInt("max_reddot_time", 0);
        int i2 = (int)(System.currentTimeMillis() / 1000L);
        j = i;
        if (i2 != 0)
        {
          j = i;
          if (m != 0)
          {
            j = i;
            if (n != 0)
            {
              j = i;
              if (i1 != 0) {
                if ((i2 < m) || (i2 > n) || (i2 - k >= i1)) {
                  break label199;
                }
              }
            }
          }
        }
      }
      for (j = i;; j = -1)
      {
        a(j);
        return;
        if (localSharedPreferences.getBoolean("welfare_reddot", false))
        {
          i = 1;
          break;
        }
        if (localSharedPreferences.getBoolean("nearby_reddot", false))
        {
          i = 2;
          break;
        }
        if (!localSharedPreferences.getBoolean("mine_reddot", false)) {
          break label219;
        }
        i = 3;
        break;
        label199:
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "onresume reddot out of date!");
        }
      }
      label219:
      i = -1;
    }
  }
  
  public void c(View paramView)
  {
    int[] arrayOfInt = new int[4];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 2130841685;
    int[] tmp11_5 = tmp5_4;
    tmp11_5[1] = 2130841688;
    int[] tmp17_11 = tmp11_5;
    tmp17_11[2] = 2130841687;
    int[] tmp23_17 = tmp17_11;
    tmp23_17[3] = 2130841686;
    tmp23_17;
    if (paramView != null)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[4];
      this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView = new SingleLineTextView[4];
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)paramView.findViewById(2131303102));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)paramView.findViewById(2131303106));
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)paramView.findViewById(2131303110));
      this.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2];
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3] = ((ImageView)paramView.findViewById(2131303115));
      this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView[0] = ((SingleLineTextView)paramView.findViewById(2131303103));
      this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView[1] = ((SingleLineTextView)paramView.findViewById(2131303107));
      this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView[2] = ((SingleLineTextView)paramView.findViewById(2131303112));
      this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView[3] = ((SingleLineTextView)paramView.findViewById(2131303116));
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[4];
      this.jdField_a_of_type_ArrayOfAndroidViewView[0] = paramView.findViewById(2131303104);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramView.findViewById(2131303108);
      this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramView.findViewById(2131303113);
      this.jdField_a_of_type_ArrayOfAndroidViewView[3] = paramView.findViewById(2131303117);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303111));
    }
    if (EcShopAssistantManager.c.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantActivity", 2, "no top btn config found!");
      }
      return;
    }
    int i;
    if (this.jdField_a_of_type_ArrayOfAndroidWidgetImageView == null) {
      i = 0;
    }
    for (;;)
    {
      int j = 0;
      label300:
      if (j >= i) {
        break;
      }
      EcShopAssistantManager.TopBtnInfo localTopBtnInfo = (EcShopAssistantManager.TopBtnInfo)EcShopAssistantManager.c.get(Integer.valueOf(j + 1));
      if ((localTopBtnInfo == null) || (TextUtils.isEmpty(localTopBtnInfo.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(localTopBtnInfo.jdField_a_of_type_JavaLangString))) {
        break;
      }
      try
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mLoadingDrawable = super.getResources().getDrawable(arrayOfInt[j]);
        paramView.mFailedDrawable = super.getResources().getDrawable(arrayOfInt[j]);
        paramView = URLDrawable.getDrawable(localTopBtnInfo.jdField_b_of_type_JavaLangString, paramView);
        if (paramView != null) {
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setImageDrawable(paramView);
        }
        this.jdField_a_of_type_ArrayOfComTencentWidgetSingleLineTextView[j].setText(localTopBtnInfo.jdField_a_of_type_JavaLangString);
        j += 1;
        break label300;
        i = this.jdField_a_of_type_ArrayOfAndroidWidgetImageView.length;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EcShopAssistantActivity", 2, "URLDrawable Exception:" + paramView);
          }
          paramView = null;
        }
      }
    }
  }
  
  void d()
  {
    if (this.f) {}
    label124:
    for (;;)
    {
      return;
      int i;
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView == null)
      {
        Object localObject = getWindowManager().getDefaultDisplay();
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView = new EcShopRecommendView(this, this.app, ((Display)localObject).getWidth());
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView.a(this);
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler;
        if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          ((EcShopHandler)localObject).b(i);
        }
      }
      for (;;)
      {
        if (this.c) {
          break label124;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler.b();
        this.c = true;
        return;
        i = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.jdField_a_of_type_JavaUtilList.size();
        break;
        super.runOnUiThread(new htt(this));
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if (((this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) || (this.jdField_d_of_type_Boolean))
      {
        this.jdField_e_of_type_Boolean = true;
        continue;
        if (this.jdField_e_of_type_Boolean)
        {
          ((ViewGroup)this.mContentView).requestDisallowInterceptTouchEvent(true);
          continue;
          this.jdField_e_of_type_Boolean = false;
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      super.getWindow().setFlags(16777216, 16777216);
    }
    super.setContentView(2130903732);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_Long = super.getIntent().getLongExtra("start_time", 0L);
    this.g = super.getIntent().getBooleanExtra("has_red_hot", false);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager = ((EcShopAssistantManager)this.app.getManager(87));
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    g();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a()) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.e();
    }
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    this.app.a().addObserver(this);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler = ((EcShopHandler)this.app.a(68));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10002, 500L);
    WebProcessManager.a(Arrays.asList(jdField_a_of_type_ArrayOfJavaLangString), "ecshop_dns");
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopObserver);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager = null;
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopOptPopBar = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendView.a();
    }
    SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if (!this.g) {
        break label282;
      }
    }
    label282:
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.app, "dc00899", "Pb_account_lifeservice", "1", "0X80064CC", "0X80064CC", 0, 0, "" + i, "" + this.jdField_a_of_type_Long, "", "");
      this.jdField_a_of_type_Long = 0L;
      this.g = false;
      return;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter != null))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter.getItem(0);
      if ((localObject1 instanceof RecentBaseData))
      {
        localObject1 = (RecentBaseData)localObject1;
        Object localObject2 = this.app.a().a(((RecentBaseData)localObject1).a(), ((RecentBaseData)localObject1).a());
        if (localObject2 != null)
        {
          EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.app.getManager(87);
          if (localEcShopAssistantManager != null)
          {
            localEcShopAssistantManager.a(((QQMessageFacade.Message)localObject2).time);
            localObject2 = this.app.a(Conversation.class);
            if (localObject2 != null) {
              ((MqqHandler)localObject2).sendEmptyMessage(1009);
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter.getCount() == 1) && (((RecentBaseData)localObject1).a().equals(EcShopAssistantManager.S)) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager != null))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a(EcShopAssistantManager.S);
          a().edit().putBoolean("is_ad_added", false).commit();
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject = a();
    if (((SharedPreferences)localObject).getBoolean("folder_reddot", false)) {
      ((SharedPreferences)localObject).edit().putBoolean("folder_reddot", false).commit();
    }
    i();
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10004).sendToTarget();
    localObject = getSharedPreferences("ecshop_sp", 0);
    long l = ((SharedPreferences)localObject).getLong("last_refresh_time", 0L);
    if (System.currentTimeMillis() - l > jdField_e_of_type_Int)
    {
      ((SharedPreferences)localObject).edit().putLong("last_refresh_time", System.currentTimeMillis()).commit();
      SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
    c();
    localObject = (WebProcessManager)this.app.getManager(12);
    if ((localObject != null) && (((WebProcessManager)localObject).d())) {}
  }
  
  public void e()
  {
    int i;
    if (this.leftView != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.e();
        if (i <= 0) {
          break label122;
        }
        if (i <= 99) {
          break label79;
        }
        this.leftView.setText(getString(2131367566) + "(" + "99+" + ")");
      }
    }
    return;
    label79:
    this.leftView.setText(getString(2131367566) + "(" + i + ")");
    return;
    label122:
    this.leftView.setText(getString(2131367566));
  }
  
  void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a();
    int i;
    Object localObject2;
    SharedPreferences localSharedPreferences;
    boolean bool;
    long l1;
    int k;
    int m;
    long l2;
    int j;
    if (localObject1 == null)
    {
      i = 0;
      localObject2 = (PublicAccountDataManager)this.app.getManager(55);
      localSharedPreferences = a();
      bool = localSharedPreferences.getBoolean("is_ad_added", false);
      l1 = localSharedPreferences.getLong("ad_puin", 0L);
      EcShopAssistantManager.S = String.valueOf(l1);
      jdField_e_of_type_JavaLangString = localSharedPreferences.getString("ad_icon_url", null);
      k = localSharedPreferences.getInt("ad_start", 0);
      m = localSharedPreferences.getInt("ad_end", 0);
      l2 = System.currentTimeMillis() / 1000L;
      if ((bool) || (!localSharedPreferences.contains("ad_id")) || (i <= 0) || (this.jdField_a_of_type_AndroidGraphicsRect != null)) {
        break label353;
      }
      if ((l2 > k) && (l2 < m) && (!((PublicAccountDataManager)localObject2).a(Long.valueOf(l1))))
      {
        localObject2 = new EcShopData();
        ((EcShopData)localObject2).mUin = String.valueOf(l1);
        ((EcShopData)localObject2).mImgInfo = localSharedPreferences.getString("ad_pics", null);
        ((EcShopData)localObject2).msgId = "ad";
        j = 0;
        label211:
        if ((j < i) && (j < 2)) {
          break label324;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a((EcShopData)localObject2);
        this.f = true;
        localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
      }
    }
    for (;;)
    {
      if ((!this.f) && (localSharedPreferences.getBoolean("is_ad_added", false)))
      {
        localSharedPreferences.edit().putBoolean("is_ad_added", false).commit();
        label299:
        if (this.f) {
          break label551;
        }
        EcShopAssistantManager.S = "";
        return;
        i = ((List)localObject1).size();
        break;
        label324:
        ((EcShopData)localObject2).mLastMsgTime = (((EcShopData)((List)localObject1).get(j)).mLastMsgTime - 1L);
        j += 1;
        break label211;
        label353:
        if (bool)
        {
          j = 0;
          label361:
          if (j >= i) {
            break label589;
          }
          if (!String.valueOf(l1).equals(((EcShopData)((List)localObject1).get(j)).mUin)) {}
        }
      }
    }
    label551:
    label589:
    for (localObject1 = (EcShopData)((List)localObject1).get(j);; localObject1 = null)
    {
      if (((l2 < k) || (l2 > m) || (((PublicAccountDataManager)localObject2).a(Long.valueOf(l1)))) && (localObject1 != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a(((EcShopData)localObject1).mUin);
        this.f = false;
        break;
        j += 1;
        break label361;
      }
      if ((localObject1 == null) || (this.jdField_a_of_type_AndroidGraphicsRect != null)) {
        break;
      }
      this.f = true;
      localSharedPreferences.edit().putBoolean("is_ad_added", true).commit();
      break;
      if ((!this.f) || (!QLog.isColorLevel())) {
        break label299;
      }
      QLog.i("EcShopAssistantActivity", 2, "show ad ,puin=" + EcShopAssistantManager.S);
      break label299;
      l1 = localSharedPreferences.getLong("ad_id", 0L);
      ((EcshopReportHandler)this.app.a(88)).a(134246436, null, null, null, null, l1, false);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (super.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          return true;
          if (paramMessage.what != 10001) {
            break;
          }
          try
          {
            paramMessage = a();
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < paramMessage.size())
            {
              localArrayList.add(Long.valueOf(((RecentBaseData)paramMessage.get(i)).a()));
              i += 1;
            }
            if ((localArrayList.size() > 0) && (!this.jdField_a_of_type_Boolean))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler.a(localArrayList);
              this.jdField_a_of_type_Boolean = true;
            }
            super.runOnUiThread(new htr(this, paramMessage));
            return true;
          }
          catch (Exception paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.i("EcShopAssistantActivity", 2, paramMessage.toString());
        return true;
        if (paramMessage.what != 10002) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager == null);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_AndroidOsHandler;
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.d();
      return true;
      if (paramMessage.what == 10003)
      {
        super.runOnUiThread(new hts(this));
        return true;
      }
    } while (paramMessage.what != 10004);
    d();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int i = 1;
    String str = null;
    Object localObject = a();
    switch (paramView.getId())
    {
    default: 
      i = 0;
      paramView = str;
      if (!TextUtils.isEmpty(paramView))
      {
        localObject = this.app;
        if (i != 0)
        {
          str = "dot";
          ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Shop_folder", paramView, 0, 0, "", "", str, "");
        }
      }
      else
      {
        return;
      }
      break;
    case 2131303101: 
      label90:
      b(1);
      if (((SharedPreferences)localObject).getBoolean("disc_reddot", false))
      {
        ((SharedPreferences)localObject).edit().putBoolean("disc_reddot", false).commit();
        a(-1);
      }
      break;
    }
    for (;;)
    {
      paramView = "Clk_shopdiscover";
      break;
      b(2);
      if (((SharedPreferences)localObject).getBoolean("welfare_reddot", false))
      {
        ((SharedPreferences)localObject).edit().putBoolean("welfare_reddot", false).commit();
        a(-1);
      }
      for (i = j;; i = 0)
      {
        paramView = "Clk_shoppreferential";
        break;
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler != null)) {
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler.a(2);
        }
        b(3);
        if (((SharedPreferences)localObject).getBoolean("nearby_reddot", false))
        {
          ((SharedPreferences)localObject).edit().putBoolean("nearby_reddot", false).commit();
          a(-1);
        }
        for (i = k;; i = 0)
        {
          paramView = "Clk_shopnearby";
          break;
          b(4);
          if (((SharedPreferences)localObject).getBoolean("mine_reddot", false))
          {
            ((SharedPreferences)localObject).edit().putBoolean("mine_reddot", false).commit();
            a(-1);
          }
          for (i = m;; i = 0)
          {
            paramView = "Clk_shopmy";
            break;
            str = "notdot";
            break label90;
          }
        }
      }
      i = 0;
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      List localList = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a();
      localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add(Long.valueOf(((EcShopData)localList.get(i)).mUin));
        i += 1;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler == null);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopHandler.a(localArrayList);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = null;
    boolean bool2 = false;
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      if (!((MessageRecord)paramObject).isSendFromLocal()) {
        super.runOnUiThread(new hty(this));
      }
      if ((!((MessageRecord)paramObject).isSendFromLocal()) || (((MessageRecord)paramObject).msgtype != 63534)) {}
    }
    label154:
    for (;;)
    {
      return;
      paramObservable = ((MessageRecord)paramObject).senderuin;
      boolean bool1 = "2".equals(((MessageRecord)paramObject).getExtInfoFromExtStr("inter_num"));
      for (;;)
      {
        if ((TextUtils.isEmpty(paramObservable)) || ((!bool1) && (!ServiceAccountFolderManager.d(this.app, paramObservable)))) {
          break label154;
        }
        i();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EcShopAssistantActivity", 2, "refresh list for new msg puin: " + paramObservable);
        return;
        bool1 = bool2;
        if ((paramObject instanceof RecentUser))
        {
          paramObservable = ((RecentUser)paramObject).uin;
          bool1 = bool2;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopAssistantActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */