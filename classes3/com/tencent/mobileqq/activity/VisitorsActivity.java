package com.tencent.mobileqq.activity;

import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.hotchat.ui.FloatViewBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import nar;
import nas;
import nat;
import nau;
import nav;
import naw;
import nax;
import nay;
import naz;
import nba;
import nbb;
import nbc;
import nbd;
import nbe;
import nbg;
import nbh;

public class VisitorsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, OverScrollViewListener
{
  static final int A = 3;
  static final int B = 4;
  static final int C = 4;
  static int D = 1;
  static int E = 2;
  static int F = 3;
  static int G = 4;
  protected static final int a = 0;
  public static final Object a;
  static final String jdField_a_of_type_JavaLangString = "VisitorsActivity";
  static StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  static Calendar jdField_a_of_type_JavaUtilCalendar;
  protected static final int b = 1;
  public static final Object b;
  static Map jdField_b_of_type_JavaUtilMap = new HashMap();
  protected static final int c = 3;
  public static String c;
  protected static final int d = 4;
  public static String d;
  protected static final int e = 5;
  static final int f = 0;
  static final int jdField_g_of_type_Int = 1;
  static final long jdField_g_of_type_Long = 800L;
  public static final String i = "intent_key_has_ever_vote";
  private static final String j = "visitors_last_refresh_time";
  private static final String k = "favoritors_last_refresh_time";
  static final int l = 1;
  static final int m = 2;
  static final int n = 3;
  static final int o = 4;
  static final int p = 5;
  static final int q = 6;
  static final int r = 7;
  static final int s = 8;
  static final int t = 800;
  static final int u = 1000;
  static final int w = 0;
  static final int x = 1;
  static final int y = 2;
  static final int z = 3;
  private int H;
  public long a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new nbc(this);
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  public CardHandler a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new nas(this);
  protected FriendsManager a;
  FloatViewBuilder jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder;
  NearbyZanAnimLayout jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout;
  NearbyCardHandler jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler;
  NearbyCardObserver jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new nat(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new nbb(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new naw(this);
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  public PinnedHeaderExpandableListView a;
  public ArrayList a;
  public HashMap a;
  public Map a;
  public nbh a;
  public boolean a;
  public long b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new nbd(this);
  View jdField_b_of_type_AndroidViewView;
  public CardHandler b;
  private PullRefreshHeader jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public PinnedHeaderExpandableListView b;
  protected String b;
  public ArrayList b;
  public nbh b;
  public boolean b;
  long jdField_c_of_type_Long = 0L;
  private PullRefreshHeader jdField_c_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public ArrayList c;
  public volatile boolean c;
  long jdField_d_of_type_Long;
  public ArrayList d;
  boolean jdField_d_of_type_Boolean = true;
  long e;
  public String e;
  public long f;
  public String f;
  public String g;
  public int h = 0;
  public String h;
  protected int i;
  public int j;
  public int k;
  public int v = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = "sp_key_vote_max_friend";
    jdField_d_of_type_JavaLangString = "sp_key_vote_max_stranger";
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  }
  
  public VisitorsActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new nar(this);
    this.jdField_f_of_type_Long = 0L;
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("visitors_last_refresh_time", 0).getLong("visitors_last_refresh_time", 0L);
  }
  
  private Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, TextView paramTextView)
  {
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131428297));
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label86;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130843363);
      paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131428329));
    }
    label86:
    do
    {
      return;
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130843496);
    paramTextView.setTextColor(paramTextView.getResources().getColorStateList(2131428329));
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramInt, 200), false, false);
    if (this.H == 0) {
      this.H = ((int)(paramTextView.getTextSize() * 1.1F + 0.5F));
    }
    localStatableBitmapDrawable.setBounds(0, 0, this.H, this.H);
    paramTextView.setCompoundDrawables(localStatableBitmapDrawable, null, null, null);
  }
  
  private void a(CardProfile paramCardProfile)
  {
    int i3 = 0;
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject1 = (Pair)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramCardProfile.lEctID));
        int i1;
        if (localObject1 == null)
        {
          i1 = 0;
          break label436;
          if (i2 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label431;
          }
          if (((CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(i2)).lEctID != paramCardProfile.lEctID) {
            break label442;
          }
          localObject1 = (CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          i2 = i3;
          if (localObject1 != null)
          {
            ((CardProfile)localObject1).bTodayVotedCnt = (paramCardProfile.bTodayVotedCnt + i1);
            ((CardProfile)localObject1).bAvailableCnt = (paramCardProfile.bAvailableCnt - i1);
            i2 = i3;
          }
          if (i2 >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
            break label426;
          }
          if (((CardProfile)this.jdField_b_of_type_JavaUtilArrayList.get(i2)).lEctID != paramCardProfile.lEctID) {
            break label451;
          }
          localObject1 = (CardProfile)this.jdField_b_of_type_JavaUtilArrayList.remove(i2);
          ((CardProfile)localObject1).updateTime(paramCardProfile.lTime);
          ((CardProfile)localObject1).bTodayVotedCnt = (paramCardProfile.bTodayVotedCnt + i1);
          ((CardProfile)localObject1).bAvailableCnt = (paramCardProfile.bAvailableCnt - i1);
          ((CardProfile)localObject1).bVoteCnt = ((short)(int)((CardProfile)localObject1).bTodayVotedCnt);
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = paramCardProfile.clone();
            ((CardProfile)localObject2).type = 3;
            ((CardProfile)localObject2).bTodayVotedCnt = (paramCardProfile.bTodayVotedCnt + i1);
            ((CardProfile)localObject2).bAvailableCnt = (paramCardProfile.bAvailableCnt - i1);
            ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
          }
          if ((((CardProfile)localObject2).bTodayVotedCnt > 0L) && (((CardProfile)localObject2).bVoteCnt > 0)) {
            this.jdField_b_of_type_JavaUtilArrayList.add(0, localObject2);
          }
          if (this.h == 0)
          {
            a(paramCardProfile.lEctID);
            if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(7)) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
            }
            if (QLog.isColorLevel()) {
              QLog.i("VisitorsActivity", 2, "updateCardProfileToList. uin:" + paramCardProfile.lEctID + " todayCount:" + paramCardProfile.bTodayVotedCnt);
            }
          }
        }
        else
        {
          i1 = ((AtomicInteger)((Pair)localObject1).second).get();
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      continue;
      label426:
      Object localObject1 = null;
      continue;
      label431:
      localObject1 = null;
      continue;
      label436:
      int i2 = 0;
      continue;
      label442:
      i2 += 1;
      continue;
      label451:
      i2 += 1;
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    int i1 = 0;
    if (i1 < paramArrayList.size())
    {
      if (localFriendsManager.b(Long.toString(((Long)paramArrayList.get(i1)).longValue()))) {
        this.jdField_c_of_type_JavaUtilArrayList.add(paramArrayList.get(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_d_of_type_JavaUtilArrayList.add(paramArrayList.get(i1));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, "fillTodayVoteArray " + paramArrayList.size() + " friend:" + this.jdField_c_of_type_JavaUtilArrayList.size() + " stranger:" + this.jdField_d_of_type_JavaUtilArrayList.size());
    }
  }
  
  private long b()
  {
    return getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).getLong("favoritors_last_refresh_time", 0L);
  }
  
  private void b(CardProfile paramCardProfile)
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(String.valueOf(paramCardProfile.lEctID), 41);
    localAllInOne.h = paramCardProfile.strNick;
    localAllInOne.b = paramCardProfile.bAage;
    localAllInOne.jdField_a_of_type_Byte = paramCardProfile.bSex;
    localAllInOne.jdField_a_of_type_Short = paramCardProfile.wFace;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(localAllInOne.jdField_a_of_type_JavaLangString);
    if (QLog.isDevelopLevel()) {
      QLog.i("VisitorsActivity", 4, "openProfileCard, nick = " + paramCardProfile.strNick + ", isFriend= " + bool + ", likeSource:" + paramCardProfile.uSource);
    }
    if (bool)
    {
      localAllInOne.jdField_a_of_type_Int = 1;
      localAllInOne.jdField_a_of_type_Long = 1L;
      ProfileActivity.a(this, localAllInOne, 1023);
      return;
    }
    if (this.h == 0)
    {
      localAllInOne.g = 16;
      if ((paramCardProfile.uSource > 0L) && (paramCardProfile.uSource <= 48L)) {
        break label240;
      }
    }
    label240:
    for (localAllInOne.jdField_a_of_type_Long = 6L;; localAllInOne.jdField_a_of_type_Long = paramCardProfile.uSource)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("param_mode", 3);
      NearbyPeopleProfileActivity.a(this, localAllInOne, localBundle, getIntent().getIntExtra("frome_where", 6), 1023);
      this.jdField_e_of_type_Long = paramCardProfile.lEctID;
      return;
      localAllInOne.g = 38;
      break;
    }
  }
  
  private void c(long paramLong)
  {
    getActivity().getSharedPreferences("visitors_last_refresh_time", 0).edit().putLong("visitors_last_refresh_time", paramLong).commit();
  }
  
  private void d(long paramLong)
  {
    getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).edit().putLong("favoritors_last_refresh_time", paramLong).commit();
  }
  
  private void g()
  {
    setRightButton(2131370943, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131299602));
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new nax(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131297692));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131369213));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131369214));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131305288));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setContentBackground(2130837958);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Nbh);
    this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903499, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollHeader(this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setSelector(2131427379);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOnGroupClickListener(new nay(this));
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131305289));
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setContentBackground(2130837958);
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Nbh);
    this.jdField_c_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903499, this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false));
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollHeader(this.jdField_c_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOverScrollListener(this);
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setSelector(2131427379);
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setOnGroupClickListener(new naz(this));
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)findViewById(2131305290));
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
  }
  
  private void h()
  {
    a();
    this.jdField_a_of_type_Nbh = new nbh(this, this, this.app, this.jdField_a_of_type_AndroidViewView$OnClickListener, 0);
    this.jdField_b_of_type_Nbh = new nbh(this, this, this.app, this.jdField_b_of_type_AndroidViewView$OnClickListener, 1);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init visitors");
    }
    this.jdField_a_of_type_Nbh.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet init favorite");
    }
    this.jdField_b_of_type_Nbh.a(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Nbh.jdField_a_of_type_JavaLangString = getString(2131371563);
    this.jdField_b_of_type_Nbh.jdField_a_of_type_JavaLangString = getString(2131371564);
    startTitleProgress();
    ThreadManager.a(new nba(this), null, true);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2130905098, null);
    this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2130904264, null);
  }
  
  public int a(String paramString, int paramInt)
  {
    paramInt = this.app.getPreferences().getInt(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, "getSp key:" + paramString + " value:" + paramInt);
    }
    return paramInt;
  }
  
  public nbg a(CardProfile paramCardProfile)
  {
    if ((paramCardProfile == null) || (paramCardProfile.strTime == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "profile2Group null");
      }
      return null;
    }
    Integer localInteger = (Integer)jdField_b_of_type_JavaUtilMap.get(paramCardProfile.strTime);
    if (localInteger != null) {
      return new nbg(localInteger.intValue(), paramCardProfile.strTime);
    }
    return null;
  }
  
  void a()
  {
    jdField_b_of_type_JavaUtilMap.put(getString(2131368833), Integer.valueOf(D));
    jdField_b_of_type_JavaUtilMap.put(getString(2131368834), Integer.valueOf(E));
    jdField_b_of_type_JavaUtilMap.put(getString(2131368843), Integer.valueOf(F));
    jdField_b_of_type_JavaUtilMap.put(getString(2131368844), Integer.valueOf(G));
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
      FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 1);
      ReportController.a(this.app, "CliOper", "", "", "0X8004448", "0X8004448", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
      FloatViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout);
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(7))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      }
    } while (!this.jdField_d_of_type_Boolean);
    this.jdField_d_of_type_Boolean = false;
    startTitleProgress();
    if (!NetworkUtil.e(this))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
      return;
    }
    b(true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis() - this.jdField_f_of_type_Long;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if ((paramInt1 == 0) || (l1 >= 800L))
    {
      this.jdField_f_of_type_Long = SystemClock.uptimeMillis();
      if (this.h == 0)
      {
        this.jdField_a_of_type_Nbh.notifyDataSetChanged();
        return;
      }
      this.jdField_b_of_type_Nbh.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L - l1);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(b());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(long paramLong)
  {
    PinnedHeaderExpandableListView localPinnedHeaderExpandableListView;
    nbh localnbh;
    int i2;
    int i1;
    if (this.h == 1)
    {
      localPinnedHeaderExpandableListView = this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
      localnbh = this.jdField_b_of_type_Nbh;
      i2 = localPinnedHeaderExpandableListView.getChildCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < i2)
      {
        Object localObject = localPinnedHeaderExpandableListView.getChildAt(i1).getTag();
        if ((localObject != null) && ((localObject instanceof nbe)))
        {
          localObject = (nbe)localObject;
          if (((((nbe)localObject).jdField_a_of_type_JavaLangObject instanceof CardProfile)) && (((CardProfile)((nbe)localObject).jdField_a_of_type_JavaLangObject).lEctID == paramLong)) {
            nbh.a(localnbh, ((nbe)localObject).jdField_a_of_type_JavaLangObject, (nbe)localObject);
          }
        }
      }
      else
      {
        return;
        localPinnedHeaderExpandableListView = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
        localnbh = this.jdField_a_of_type_Nbh;
        break;
      }
      i1 += 1;
    }
  }
  
  public void a(CardProfile paramCardProfile, ImageView paramImageView)
  {
    int i1 = 0;
    if (!NetworkUtil.e(this)) {
      a("网络连接不可用，请稍候再试");
    }
    while (!a(paramCardProfile)) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        paramCardProfile.bAvailableCnt -= 1L;
        paramCardProfile.bTodayVotedCnt += 1L;
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramCardProfile.lEctID)))
        {
          localObject1 = new AtomicInteger(0);
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramCardProfile.lEctID), new Pair(paramCardProfile, localObject1));
          ((AtomicInteger)localObject1).incrementAndGet();
          if (i1 >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
            break label373;
          }
          if (((CardProfile)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).lEctID != paramCardProfile.lEctID) {
            break label378;
          }
          localObject1 = (CardProfile)this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
          ((CardProfile)localObject1).bTodayVotedCnt += 1L;
          ((CardProfile)localObject1).bVoteCnt = ((short)(int)((CardProfile)localObject1).bTodayVotedCnt);
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = paramCardProfile.clone();
            ((CardProfile)localObject2).type = 3;
            ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
          }
          ((CardProfile)localObject2).updateTime(System.currentTimeMillis() / 1000L);
          this.jdField_b_of_type_JavaUtilArrayList.add(0, localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity", 2, "onVoteClick add to FavList. uin:" + ((CardProfile)localObject2).lEctID);
          }
          a(paramCardProfile.lEctID);
          if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(7)) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
          }
          b(paramCardProfile, paramImageView);
          if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 2000L);
          return;
        }
        localObject1 = (AtomicInteger)((Pair)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramCardProfile.lEctID))).second;
      }
      label373:
      Object localObject1 = null;
      continue;
      label378:
      i1 += 1;
    }
  }
  
  public void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_d_of_type_Long > 2000L)
    {
      a(0, paramString);
      this.jdField_d_of_type_Long = l1;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, "saveSp key:" + paramString + " value:" + paramInt);
    }
    this.app.getPreferences().edit().putInt(paramString, paramInt).commit();
  }
  
  public void a(String paramString, int paramInt, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString))
    {
      localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString);
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 1, false);
        localBitmap1 = a();
      }
      paramImageView.setImageBitmap(localBitmap1);
      return;
    }
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, paramString, 200);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 200, true, false);
      localBitmap1 = a();
    }
    paramImageView.setImageBitmap(localBitmap1);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i2 = 0;
    long l1 = Long.valueOf(paramString).longValue();
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, "onVoteError, uin:" + paramString + " voteNum:" + paramInt);
    }
    paramString = jdField_a_of_type_JavaLangObject;
    for (int i1 = 0;; i1 = 0)
    {
      try
      {
        if (i1 >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
          continue;
        }
        CardProfile localCardProfile;
        if (((CardProfile)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).lEctID == l1)
        {
          localCardProfile = (CardProfile)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
          localCardProfile.bTodayVotedCnt -= paramInt;
          localCardProfile.bAvailableCnt += paramInt;
          localCardProfile.bVoteCnt = ((short)(localCardProfile.bVoteCnt - paramInt));
          if ((localCardProfile.bTodayVotedCnt > 0L) && (localCardProfile.bVoteCnt > 0)) {
            continue;
          }
          this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
          i1 = 1;
        }
        for (;;)
        {
          if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(i2)).lEctID == l1)
            {
              localCardProfile = (CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
              localCardProfile.bTodayVotedCnt -= paramInt;
              localCardProfile.bAvailableCnt += paramInt;
            }
          }
          else
          {
            if (this.h != 0) {
              break label324;
            }
            a(l1);
            if ((i1 != 0) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(7))) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 5000L);
            }
            return;
            i1 += 1;
            break;
          }
          i2 += 1;
        }
        if (i1 == 0) {
          break label349;
        }
      }
      finally {}
      label324:
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      return;
      label349:
      a(l1);
      return;
    }
  }
  
  public void a(ArrayList paramArrayList, long paramLong)
  {
    if (paramArrayList.size() > 0) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet onVisitorListOk");
      }
      this.jdField_a_of_type_Nbh.a(this.jdField_a_of_type_JavaUtilArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "expandGroup onVisitorListOk");
      }
      this.jdField_a_of_type_Nbh.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      if (paramLong == 0L) {
        a(true);
      }
      this.jdField_a_of_type_Nbh.notifyDataSetChanged();
      b(0);
      return;
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  void a(boolean paramBoolean)
  {
    c(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
        this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
    }
    else {
      return;
    }
    a(1, getString(2131368597));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.H();
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Visitor", 2, "onViewCompleteVisableAndReleased");
    }
    if (!this.jdField_c_of_type_Boolean) {
      if (this.h == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        a(0, "正在加载，请稍候。");
      }
    }
    label116:
    do
    {
      do
      {
        return true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        break;
        if (paramListView != this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView) {
          break label116;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
      } while (stopTitleProgress());
      if (!NetworkUtil.e(this))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
        return true;
      }
      a(true);
      return true;
      this.jdField_c_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(b());
    } while (stopTitleProgress());
    if (!NetworkUtil.e(this))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
      return true;
    }
    b(true);
    return true;
  }
  
  public boolean a(CardProfile paramCardProfile)
  {
    boolean bool3 = ((FriendsManager)this.app.getManager(50)).b(Long.toString(paramCardProfile.lEctID));
    Object localObject1;
    int i2;
    label45:
    boolean bool2;
    int i4;
    if (bool3)
    {
      localObject1 = this.jdField_c_of_type_JavaUtilArrayList;
      if (!bool3) {
        break label228;
      }
      i2 = this.j;
      bool2 = false;
      i4 = 0;
    }
    for (;;)
    {
      boolean bool1;
      label228:
      int i3;
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        if (((ArrayList)localObject1).size() < i2)
        {
          bool1 = true;
          i1 = 1;
          if ((bool1) || (i1 != 0)) {
            break label306;
          }
          if (!bool3) {
            break label291;
          }
          localObject1 = this.jdField_e_of_type_JavaLangString;
          a(String.format((String)localObject1, new Object[] { Integer.valueOf(i2) }));
          if (!bool3) {
            break label299;
          }
          i2 = 5;
          ReportController.b(this.app, "CliOper", "", "0X8006579", "0X8006579", "", i2, 1, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity", 2, "checkVote " + paramCardProfile.lEctID + " logLevel:" + i1 + " can:" + bool1);
          }
          return bool1;
          localObject1 = this.jdField_d_of_type_JavaUtilArrayList;
          break;
          i2 = this.k;
          break label45;
        }
        i3 = 0;
        i1 = i4;
        bool1 = bool2;
        if (i3 >= ((ArrayList)localObject1).size()) {
          continue;
        }
        if (((Long)((ArrayList)localObject1).get(i3)).longValue() != paramCardProfile.lEctID) {
          break label431;
        }
        bool1 = true;
        i1 = 2;
      }
      label291:
      localObject1 = this.jdField_f_of_type_JavaLangString;
      continue;
      label299:
      i2 = 6;
      continue;
      label306:
      i2 = i1;
      bool2 = bool1;
      if (bool1)
      {
        i2 = i1;
        bool2 = bool1;
        if (paramCardProfile.bAvailableCnt <= 0L)
        {
          i2 = 4;
          bool2 = false;
          a(String.format(this.g, new Object[] { Long.valueOf(paramCardProfile.bTodayVotedCnt) }));
          if (!bool3) {
            break label424;
          }
        }
      }
      label424:
      for (int i1 = 5;; i1 = 6)
      {
        ReportController.b(this.app, "CliOper", "", "0X8006578", "0X8006578", "", i1, 1, 0, "", "", "", "");
        i1 = i2;
        bool1 = bool2;
        break;
      }
      label431:
      i3 += 1;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    String str = this.app.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_b_of_type_JavaLangString, 0L, 30);
    }
    while (this.jdField_a_of_type_Long <= -1L) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(str, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, 30);
    return true;
  }
  
  public void b()
  {
    if (!NetworkUtil.e(this))
    {
      a(1, getString(2131369008));
      return;
    }
    a(false);
    this.jdField_a_of_type_Nbh.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Nbh.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    nbg localnbg;
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "expandGroup-favoritor");
      }
      paramInt = 0;
      if (paramInt < this.jdField_b_of_type_Nbh.getGroupCount())
      {
        if (QLog.isColorLevel())
        {
          localnbg = (nbg)this.jdField_b_of_type_Nbh.getGroup(paramInt);
          if (localnbg != null) {
            break label103;
          }
          QLog.d("VisitorsActivity", 2, "expandGroup-favoritor, i:" + paramInt + ", group null");
        }
        for (;;)
        {
          this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.a(paramInt);
          paramInt += 1;
          break;
          label103:
          QLog.d("VisitorsActivity", 2, "expandGroup-favoritor, i:" + paramInt + ", groupId:" + localnbg.jdField_a_of_type_Int + ", groupName:" + localnbg.jdField_a_of_type_JavaLangString);
        }
      }
    }
    else if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "expandGroup-visitor");
      }
      paramInt = 0;
      if (paramInt < this.jdField_a_of_type_Nbh.getGroupCount())
      {
        if (QLog.isColorLevel())
        {
          localnbg = (nbg)this.jdField_a_of_type_Nbh.getGroup(paramInt);
          if (localnbg != null) {
            break label260;
          }
          QLog.d("VisitorsActivity", 2, "expandGroup-visitor, i:" + paramInt + ", group null");
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.a(paramInt);
          paramInt += 1;
          break;
          label260:
          QLog.d("VisitorsActivity", 2, "expandGroup-visitor, i:" + paramInt + ", groupId:" + localnbg.jdField_a_of_type_Int + ", groupName:" + localnbg.jdField_a_of_type_JavaLangString);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "expandGroup, invalid type:" + paramInt);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(b());
  }
  
  public void b(long paramLong)
  {
    ThreadManager.a(new nav(this, paramLong), null, true);
  }
  
  void b(CardProfile paramCardProfile, ImageView paramImageView)
  {
    paramImageView.setVisibility(0);
    paramCardProfile = new int[2];
    paramImageView.getLocationInWindow(paramCardProfile);
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder = new FloatViewBuilder(paramImageView.getContext(), 2130841113);
    }
    float f1 = paramImageView.getResources().getDisplayMetrics().density;
    int i1 = (int)(32.0F * f1);
    i1 = (int)(f1 * 27.0F);
    this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiFloatViewBuilder.a(), paramCardProfile[0] + paramImageView.getPaddingLeft(), paramCardProfile[1] - this.v + paramImageView.getPaddingTop());
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean)
  {
    ThreadManager.a(new nau(this, paramString, paramInt, paramBoolean), null, false);
  }
  
  public void b(ArrayList paramArrayList, long paramLong)
  {
    if (paramArrayList.size() == 0) {
      this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "setDataSet onFavoriteListOk");
    }
    this.jdField_b_of_type_Nbh.a(this.jdField_b_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "expandGroup onFavoriteListOk");
    }
    this.jdField_b_of_type_Nbh.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (paramLong == 0L) {
      b(true);
    }
    this.jdField_b_of_type_Nbh.notifyDataSetChanged();
    b(1);
  }
  
  void b(boolean paramBoolean)
  {
    d(System.currentTimeMillis());
    if (!stopTitleProgress())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 800L);
        this.jdField_c_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
    }
    else {
      return;
    }
    a(1, getString(2131368597));
    this.jdField_b_of_type_ComTencentWidgetPinnedHeaderExpandableListView.H();
  }
  
  boolean b(boolean paramBoolean)
  {
    String str = this.app.a();
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_b_of_type_JavaLangString, 0L, 30);
    }
    while (this.jdField_b_of_type_Long <= -1L) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(str, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, 30);
    return true;
  }
  
  public void c()
  {
    if (!NetworkUtil.e(this))
    {
      a(1, getString(2131369008));
      return;
    }
    b(false);
    this.jdField_b_of_type_Nbh.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Nbh.notifyDataSetChanged();
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    QQToast.a(this, 1, 2131368597, 0).b(getTitleBarHeight());
    a(false);
    if (this.jdField_a_of_type_Nbh.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Nbh.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Nbh.notifyDataSetChanged();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1023) {}
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    paramBundle = this.app.a();
    this.jdField_b_of_type_JavaLangString = String.valueOf(getIntent().getLongExtra("toUin", 0L));
    if ((this.jdField_b_of_type_JavaLangString != null) && (!paramBundle.equals(this.jdField_b_of_type_JavaLangString))) {}
    this.jdField_a_of_type_Long = getIntent().getLongExtra("nextMidVoter", -1L);
    setContentView(2130905099);
    i();
    h();
    g();
    this.jdField_b_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler = ((NearbyCardHandler)this.app.a(60));
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
      f();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout.clearAnimation();
    }
    super.doOnStop();
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    QQToast.a(this, 1, 2131368597, 0).b(getTitleBarHeight());
    b(false);
    if (this.jdField_b_of_type_Nbh.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Nbh.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Nbh.notifyDataSetChanged();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity", 2, "reqestVote");
    }
    long l1 = this.app.getLongAccountUin();
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    long l2;
    Pair localPair;
    boolean bool;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ??? = (Map.Entry)localIterator.next();
      l2 = ((Long)((Map.Entry)???).getKey()).longValue();
      localPair = (Pair)((Map.Entry)???).getValue();
      bool = localFriendsManager.b(Long.toString(l2));
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (((AtomicInteger)localPair.second).get() > 0) {
          break;
        }
      }
    }
    if (bool) {
      this.jdField_b_of_type_ComTencentMobileqqAppCardHandler.a(l1, l2, null, 1, ((AtomicInteger)localPair.second).get(), 1);
    }
    for (;;)
    {
      ((AtomicInteger)localPair.second).set(0);
      break;
      this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(l1, l2, null, (int)((CardProfile)localPair.first).uSource, ((AtomicInteger)localPair.second).get(), 1);
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Nbh != null) && (this.jdField_a_of_type_Nbh.jdField_a_of_type_Int > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004446", "0X8004446", 0, 0, String.valueOf(this.jdField_a_of_type_Nbh.jdField_a_of_type_Int), "", "", "");
    }
    if ((this.jdField_b_of_type_Nbh != null) && (this.jdField_b_of_type_Nbh.jdField_a_of_type_Int > 0)) {
      ReportController.a(this.app, "CliOper", "", "", "0X8004449", "0X8004449", 0, 0, String.valueOf(this.jdField_b_of_type_Nbh.jdField_a_of_type_Int), "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText) {
      startActivity(new Intent(this, LikeSettingActivity.class));
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (!(paramView instanceof ImageView));
      localObject = paramView.getTag();
    } while ((localObject == null) || (!(localObject instanceof CardProfile)));
    a((CardProfile)localObject, (ImageView)paramView);
  }
  
  protected View onCreateCenterView()
  {
    super.onCreateCenterView();
    this.centerView.setText(2131369210);
    return this.centerView;
  }
  
  protected View onCreateRightView()
  {
    super.onCreateRightView();
    this.rightViewText.setVisibility(8);
    return this.rightViewText;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\VisitorsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */