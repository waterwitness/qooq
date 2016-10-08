package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.av.utils.BitmapTools;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NearbyMember;
import com.tencent.mobileqq.troop.utils.NearbyTroopMemMgr;
import com.tencent.mobileqq.troop.utils.NearbyTroopMemMgr.RadarInstanceState;
import com.tencent.mobileqq.troop.widget.RadarMembersView.OnDrawReadyListener;
import com.tencent.mobileqq.troop.widget.RadarView;
import com.tencent.mobileqq.troop.widget.ScaleGallery;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import vdp;
import vdq;
import vdr;
import vds;
import vdt;
import vdu;
import vdv;
import vdw;
import vdx;
import vdy;
import vdz;
import vea;
import veb;
import vec;
import ved;
import vee;
import vef;
import veg;
import veh;
import vei;
import vej;

public class NearbyMemberActivity
  extends BaseActivity
{
  public static final int a = 10;
  protected static final String a = "NearbyMemberActivity.troop.nearby_mem";
  public static final String b = "troop_session";
  protected static final int c = 1;
  public static final String c = "member_uin";
  public static final double d = 10000.0D;
  protected static final int d = 2;
  public static final String d = "member_display_name";
  protected static final int e = 3;
  public static final String e = "insert_words";
  protected static final int f = 4;
  protected static final String f = "process_nearby_mem_rsp";
  protected static final int g = 1;
  public double a;
  float jdField_a_of_type_Float;
  public long a;
  protected BroadcastReceiver a;
  public Handler a;
  protected View a;
  public TextView a;
  public SessionInfo a;
  public BizTroopObserver a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public NearbyMemberAdapter a;
  public NearbyTroopMemMgr a;
  protected RadarMembersView.OnDrawReadyListener a;
  public RadarView a;
  public ScaleGallery a;
  public Runnable a;
  public List a;
  public boolean a;
  public double b;
  public int b;
  public TextView b;
  public List b;
  public boolean b;
  public double c;
  public List c;
  protected boolean c;
  public boolean d;
  protected double e;
  
  public NearbyMemberActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Double = Double.MIN_VALUE;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_AndroidOsHandler = new veh(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnDrawReadyListener = new vds(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new vdu(this);
    this.jdField_a_of_type_JavaLangRunnable = new vdv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new vdw(this);
    this.e = Double.MIN_VALUE;
    this.jdField_a_of_type_Float = Float.MAX_VALUE;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new veb(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new vec(this);
  }
  
  public double a()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return 0.0D;
    }
    this.e = Double.MIN_VALUE;
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      NearbyMember localNearbyMember = (NearbyMember)this.jdField_b_of_type_JavaUtilList.get(i);
      if (localNearbyMember.jdField_c_of_type_Double > this.e) {
        this.e = localNearbyMember.jdField_c_of_type_Double;
      }
      i += 1;
    }
    return this.e / 1000.0D * 100.0D / 100.0D;
  }
  
  protected void a()
  {
    TextView localTextView = (TextView)findViewById(2131297083);
    localTextView.setText(2131369134);
    localTextView.setOnClickListener(new vdp(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297183));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new vea(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297139));
    a(10.0D);
  }
  
  public void a(double paramDouble)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (paramDouble == 10.0D) {
      this.d = true;
    }
    int i = this.jdField_b_of_type_JavaUtilList.size();
    double d1 = paramDouble;
    if (paramDouble >= 10.0D)
    {
      d1 = paramDouble;
      if (paramDouble * 1000.0D < ((NearbyMember)this.jdField_b_of_type_JavaUtilList.get(0)).jdField_c_of_type_Double)
      {
        if (paramDouble == 10.0D) {
          this.d = false;
        }
        d1 = a();
      }
    }
    String str = TroopMemberLbsHelper.a(d1 * 1000.0D);
    if (this.jdField_b_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131364374, new Object[] { str, Integer.valueOf(i), getString(2131364371) }));
    }
    for (;;)
    {
      this.e = d1;
      return;
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131364374, new Object[] { str, Integer.valueOf(i), getString(2131364370) }));
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131364373, new Object[] { str, Integer.valueOf(i) }));
      }
    }
  }
  
  protected void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_JavaUtilList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        NearbyMember localNearbyMember = (NearbyMember)paramList.next();
        if ((localNearbyMember.jdField_c_of_type_Double / 1000.0D * 100.0D) / 100.0D <= 10.0D) {
          this.jdField_b_of_type_JavaUtilList.add(localNearbyMember);
        }
      }
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a();
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setmRadarMembersViewOnDrawListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnDrawReadyListener);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setNearbyMembers(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.notifyDataSetChanged();
      if (paramBoolean)
      {
        this.jdField_b_of_type_JavaUtilList = ((NearbyTroopMemMgr.RadarInstanceState)localObject1).jdField_b_of_type_JavaUtilList;
        d1 = ((NearbyTroopMemMgr.RadarInstanceState)localObject1).jdField_c_of_type_Double;
        if (!paramBoolean) {
          break label124;
        }
      }
      label124:
      for (double d2 = ((NearbyTroopMemMgr.RadarInstanceState)localObject1).d;; d2 = 10.0D)
      {
        a(d2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setShowRange(d1);
        return true;
        a(this.jdField_a_of_type_JavaUtilList);
        d1 = 10000.0D;
        break;
      }
    }
    int j = -1;
    Object localObject2 = new ArrayList();
    int m = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    NearbyMember localNearbyMember;
    while (i < m)
    {
      localNearbyMember = (NearbyMember)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localNearbyMember.e == paramInt)
      {
        k = j;
        if (j == -1) {
          k = i;
        }
        ((List)localObject2).add(localNearbyMember);
      }
      i += 1;
      j = k;
    }
    if (((List)localObject2).size() <= 0)
    {
      localObject2 = getApplicationContext();
      if (paramInt == 0) {}
      for (localObject1 = getString(2131364370);; localObject1 = getString(2131364371))
      {
        QQToast.a((Context)localObject2, 1, getString(2131364377, new Object[] { localObject1 }), 1).b(getResources().getDimensionPixelSize(2131492908));
        return false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setmRadarMembersViewOnDrawListener(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarMembersView$OnDrawReadyListener);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setNearbyMembers((List)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.a((List)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.notifyDataSetChanged();
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilList = ((NearbyTroopMemMgr.RadarInstanceState)localObject1).jdField_b_of_type_JavaUtilList;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setShowRange(((NearbyTroopMemMgr.RadarInstanceState)localObject1).jdField_c_of_type_Double);
      if (!paramBoolean) {
        break label469;
      }
    }
    label469:
    for (double d1 = ((NearbyTroopMemMgr.RadarInstanceState)localObject1).d;; d1 = 10.0D)
    {
      a(d1);
      return true;
      if (((NearbyMember)((List)localObject2).get(0)).jdField_c_of_type_Double <= 10000.0D)
      {
        a((List)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setShowRange(10000.0D);
        break;
      }
      localNearbyMember = (NearbyMember)((List)localObject2).get(((List)localObject2).size() - 1);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setShowRange(localNearbyMember.jdField_c_of_type_Double);
      this.jdField_b_of_type_JavaUtilList = ((List)localObject2);
      break;
    }
  }
  
  public void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131364365, 5);
    localActionSheet.a(2131364366, 5);
    localActionSheet.a(2131364367, 5);
    localActionSheet.d(2131367262);
    localActionSheet.a(new ved(this, localActionSheet));
    if ((!localActionSheet.isShowing()) && (!isFinishing())) {
      localActionSheet.show();
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.getSelectedItemId(), this.jdField_b_of_type_Double, this.jdField_c_of_type_Double, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.a(), this.e);
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter = new NearbyMemberAdapter(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.a(new vee(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter.a(new vef(this));
  }
  
  public void doOnBackPressed()
  {
    setResult(0, null);
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    StartupTracker.a(null, "troop_nearby_mem_on_create");
    setContentView(2130903922);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300663);
    paramBundle = BitmapTools.b(BaseApplication.getContext(), 2130838392);
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)getIntent().getParcelableExtra("troop_session"));
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr = NearbyTroopMemMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      a();
      d();
      f();
      e();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a())
      {
        if (NetworkUtil.h(this)) {
          break label203;
        }
        m();
      }
    }
    for (;;)
    {
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ReportController.b(this.app, "P_CliOper", "Grp_AIO", "", "nearby_mber", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      StartupTracker.a("troop_nearby_mem_on_create", null);
      return true;
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838392);
      break;
      label203:
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
  }
  
  protected void doOnDestroy()
  {
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.c();
    c();
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    n();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    o();
  }
  
  protected void e()
  {
    StartupTracker.a(null, "troop_nearby_mem_gallery_init");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery = ((ScaleGallery)findViewById(2131300665));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.setUnselectedAlpha(0.45F);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.setUnselectedScale(0.65F);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.setOnItemSelectedListener(new veg(this));
    StartupTracker.a("troop_nearby_mem_gallery_init", null);
  }
  
  protected void f()
  {
    double d2 = 0.0D;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView = ((RadarView)findViewById(2131300664));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setApp(this.app);
    RadarView localRadarView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView;
    double d1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a())
    {
      d1 = 0.0D;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a()) {
        break label137;
      }
    }
    for (;;)
    {
      localRadarView.setMyselfGps(d1, d2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setOnBackgroundReadyListener(new vei(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setOnMemberIconClickListener(new vej(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setOnScaleListener(new vdq(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setOnFirstScanFinishListener(new vdr(this));
      return;
      d1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a().jdField_a_of_type_Double;
      break;
      label137:
      d2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a().jdField_b_of_type_Double;
    }
  }
  
  public void g()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(600L);
    localAlphaAnimation.setStartOffset(200L);
    localAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.startAnimation(localAlphaAnimation);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyMemberActivity.troop.nearby_mem", 2, "refreshMemberList, refreshed:" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a())
    {
      ThreadManager.b().post(new vdt(this));
      return;
    }
    j();
  }
  
  protected void i()
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(51);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      NearbyMember localNearbyMember = (NearbyMember)localIterator.next();
      double d1 = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(localNearbyMember.jdField_a_of_type_Long));
      if (d1 != -100.0D) {
        localNearbyMember.jdField_c_of_type_Double = d1;
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void j()
  {
    NearbyTroopMemMgr.RadarInstanceState localRadarInstanceState = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr.a();
    this.jdField_a_of_type_JavaUtilList = localRadarInstanceState.jdField_a_of_type_JavaUtilList;
    i();
    this.jdField_b_of_type_Double = localRadarInstanceState.jdField_a_of_type_Double;
    this.jdField_c_of_type_Double = localRadarInstanceState.jdField_b_of_type_Double;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setMyselfGps(this.jdField_b_of_type_Double, this.jdField_c_of_type_Double);
    this.jdField_b_of_type_Int = localRadarInstanceState.jdField_a_of_type_Int;
    a(this.jdField_b_of_type_Int, true);
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyMemberActivity.troop.nearby_mem", 2, "resumeLastInstanceState==>mOurLat:" + this.jdField_b_of_type_Double + "|mOurLon:" + this.jdField_c_of_type_Double + "|mMembersInScanArea size:" + this.jdField_b_of_type_JavaUtilList.size() + "|LastSelectedMemUin" + localRadarInstanceState.jdField_a_of_type_Long + "|lastRange:" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.a());
    }
  }
  
  public void k()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      NearbyMember localNearbyMember = (NearbyMember)localIterator.next();
      if ((localNearbyMember.e < 0) || (TextUtils.isEmpty(localNearbyMember.jdField_a_of_type_JavaLangString)) || (localNearbyMember.d <= 0))
      {
        localNearbyMember.jdField_a_of_type_JavaLangString = ContactUtils.f(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(localNearbyMember.jdField_a_of_type_Long));
        TroopMemberInfo localTroopMemberInfo = ((TroopManager)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(localNearbyMember.jdField_a_of_type_Long));
        if (localTroopMemberInfo != null)
        {
          localNearbyMember.e = localTroopMemberInfo.sex;
          localNearbyMember.d = localTroopMemberInfo.age;
        }
      }
    }
  }
  
  public void l()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new vdx(this));
    Collections.sort(this.jdField_b_of_type_JavaUtilList, new vdy(this));
  }
  
  public void m()
  {
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetScaleGallery.setVisibility(4);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarView.setVisibility(8);
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setMessage(getString(2131364375));
    localQQCustomDialog.setPositiveButton(getString(2131364376), new vdz(this, localQQCustomDialog));
    if (!isFinishing()) {}
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyMemberActivity.troop.nearby_mem", 2, "showFailedDialog==>BadTokenException");
    }
  }
  
  public void n()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyMemberActivity.troop.nearby_mem", 2, "registerScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("NearbyMemberActivity.troop.nearby_mem", 2, "registerScreenListener:" + localException.toString());
    }
  }
  
  public void o()
  {
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyMemberActivity.troop.nearby_mem", 2, "unRegisterScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("NearbyMemberActivity.troop.nearby_mem", 2, "unRegisterScreenListener:" + localException.toString());
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\NearbyMemberActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */