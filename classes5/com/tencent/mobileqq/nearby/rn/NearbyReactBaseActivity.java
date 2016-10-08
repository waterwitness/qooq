package com.tencent.mobileqq.nearby.rn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.tencent.bitapp.BitAppAbilityUtils;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.preDownload.IRNPreDownloadListener;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.bitapp.report.RNReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyBaseActivity;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.rn.QQBaseModule.RNPageListener;
import com.tencent.mobileqq.rn.RNAppManager;
import com.tencent.mobileqq.rn.RNTest;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import tpo;
import tpp;
import tpq;
import tpr;
import tps;
import tpt;
import tpu;
import tpv;
import tpw;
import tpx;

public class NearbyReactBaseActivity
  extends NearbyBaseActivity
  implements DefaultHardwareBackBtnHandler, IRNPreDownloadListener, NearbyBaseRRV.INearbyBaseRRVListener, QQBaseModule.RNPageListener
{
  static final int jdField_a_of_type_Int = 1;
  public static final String a;
  static final int jdField_b_of_type_Int = 2;
  static final int jdField_c_of_type_Int = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  static final int h = 8;
  static final int i = 9;
  static final int j = 10;
  public View.OnClickListener a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public BaseBusi a;
  NRNReportUtil.NRNReportAction jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
  NearbyBaseRRV jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV;
  NearbyRNAppManager jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyRNAppManager;
  Boolean jdField_a_of_type_JavaLangBoolean = null;
  public List a;
  public tpx a;
  boolean jdField_a_of_type_Boolean = false;
  NRNReportUtil.NRNReportAction jdField_b_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
  String jdField_b_of_type_JavaLangString = "正在加载...";
  public boolean b;
  NRNReportUtil.NRNReportAction jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
  String jdField_c_of_type_JavaLangString = "网络不可用，请检查网络连接。";
  public NRNReportUtil.NRNReportAction d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyReactBaseActivity.class.getSimpleName();
  }
  
  public NearbyReactBaseActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Tpx = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new tpp(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "onLoadSoSuc has destroy", new Object[0]);
      }
      return;
    }
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "onLoadSoSuc", new Object[0]);
    }
    NRNReportUtil.NRNReportAction localNRNReportAction = this.jdField_b_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
    this.jdField_b_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = null;
    if (localNRNReportAction != null)
    {
      localNRNReportAction.jdField_a_of_type_Long = Math.abs(SystemClock.elapsedRealtime() - localNRNReportAction.b);
      localNRNReportAction.jdField_a_of_type_Boolean = true;
      a(localNRNReportAction);
    }
    runOnUiThread(new tpv(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "onLoadSoFail has destroy", new Object[0]);
      }
      return;
    }
    boolean bool = NetworkUtil.e(BaseApplicationImpl.getContext());
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "onLoadSoFail", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    }
    if (!bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this.jdField_a_of_type_AndroidViewView$OnClickListener, 2, this.jdField_c_of_type_JavaLangString);
      return;
    }
    NRNReportUtil.NRNReportAction localNRNReportAction = this.jdField_b_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
    this.jdField_b_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = null;
    if (localNRNReportAction != null)
    {
      localNRNReportAction.jdField_a_of_type_Long = Math.abs(SystemClock.elapsedRealtime() - localNRNReportAction.b);
      localNRNReportAction.jdField_a_of_type_Boolean = false;
      localNRNReportAction.jdField_a_of_type_Int = paramInt;
      a(localNRNReportAction);
    }
    b(3);
  }
  
  public void a(int paramInt1, int paramInt2, ReadableMap paramReadableMap)
  {
    if (paramReadableMap != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramReadableMap);
    }
    runOnUiThread(new tpr(this, paramInt1, paramInt2));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int k = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "onProgress", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(k) });
    }
    runOnUiThread(new tpu(this, String.format("正在加载...[%d%s]", new Object[] { Integer.valueOf(k), "%" })));
  }
  
  public void a(NRNReportUtil.NRNReportAction paramNRNReportAction)
  {
    if ((paramNRNReportAction == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      return;
    }
    runOnUiThread(new tpw(this, paramNRNReportAction));
  }
  
  public void a(String paramString)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "setImmerseColor", paramString, Long.valueOf(SystemClock.elapsedRealtime()) });
    }
    runOnUiThread(new tps(this, paramString));
    if ((this.d != null) && (this.d.jdField_a_of_type_ArrayOfLong[5] == 0L)) {
      this.d.jdField_a_of_type_ArrayOfLong[5] = SystemClock.elapsedRealtime();
    }
    RNReport.reportStageEnd("RNINIT_" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.r), 6, 0, 0);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "onLoadBundleFail has destroy", new Object[0]);
      }
      return;
    }
    boolean bool = NetworkUtil.e(BaseApplicationImpl.getContext());
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "onLoadBundleFail", new Object[] { Boolean.valueOf(bool), paramString1, Integer.valueOf(paramInt), paramString2 });
    }
    if (!bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this.jdField_a_of_type_AndroidViewView$OnClickListener, 2, this.jdField_c_of_type_JavaLangString);
      return;
    }
    b(5);
    paramString1 = this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
    if (paramString1 != null)
    {
      paramString1.jdField_a_of_type_Long = Math.abs(SystemClock.elapsedRealtime() - paramString1.b);
      paramString1.jdField_a_of_type_Boolean = false;
      paramString1.jdField_a_of_type_Int = paramInt;
      a(paramString1);
    }
    this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = null;
  }
  
  public boolean a()
  {
    String str = getCurrentAccountUin();
    int k = ((Integer)NearbySPUtil.a(str, "key_rn_ask_loadso_totalcount", Integer.valueOf(0))).intValue();
    boolean bool;
    if (k > 5)
    {
      if (!NearbyUtils.a()) {
        break label296;
      }
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "checkNeedToAsk", new Object[] { Integer.valueOf(k) });
      bool = false;
    }
    for (;;)
    {
      str = getCurrentAccountUin();
      BaseBusi localBaseBusi = this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi;
      if (bool) {
        k = 0;
      }
      for (;;)
      {
        a(new NRNReportUtil.NRNReportAction("actNAAskUser", str, localBaseBusi, bool, k));
        return bool;
        long l = ((Long)NearbySPUtil.a(str, "key_rn_ask_loadso_lasttime", Long.valueOf(0L))).longValue();
        int m = ((Integer)NearbySPUtil.a(str, "key_rn_ask_loadso_lastcount", Integer.valueOf(0))).intValue();
        if (NearbyUtils.a()) {
          NearbyUtils.a(jdField_a_of_type_JavaLangString, "checkNeedToAsk", new Object[] { Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(m) });
        }
        if (Math.abs(l - System.currentTimeMillis()) > 86400000L)
        {
          l = System.currentTimeMillis();
          k += 1;
          m = 1;
          bool = true;
        }
        for (;;)
        {
          if (bool)
          {
            NearbySPUtil.a(str, "key_rn_ask_loadso_totalcount", Integer.valueOf(k));
            NearbySPUtil.a(str, "key_rn_ask_loadso_lasttime", Long.valueOf(l));
            NearbySPUtil.a(str, "key_rn_ask_loadso_lastcount", Integer.valueOf(m));
          }
          break;
          if (m < 2)
          {
            bool = true;
            m += 1;
            k += 1;
          }
          else
          {
            bool = false;
          }
        }
        if (k > 5) {
          k = 1;
        } else {
          k = 2;
        }
      }
      label296:
      bool = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getIntent(), this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV);
  }
  
  public void b(int paramInt)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "useH5", new Object[] { Integer.valueOf(paramInt) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = null;
    if (localObject != null)
    {
      ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Long = Math.abs(SystemClock.elapsedRealtime() - ((NRNReportUtil.NRNReportAction)localObject).b);
      ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Boolean = false;
      ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Int = paramInt;
      a((NRNReportUtil.NRNReportAction)localObject);
    }
    try
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(getIntent(), this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      if (NearbyUtils.b()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "useH5", localObject });
      }
      setResult(-1);
      finish();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        startActivity(localIntent);
        return;
      }
      QQToast.a(BaseApplicationImpl.getContext(), "打开页面失败，请稍后再试...", 0).b(getTitleBarHeight());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "onPageToShow", paramString, Long.valueOf(SystemClock.elapsedRealtime()) });
    }
    if ((this.d != null) && (this.d.jdField_a_of_type_ArrayOfLong[6] == 0L)) {
      this.d.jdField_a_of_type_ArrayOfLong[6] = SystemClock.elapsedRealtime();
    }
    runOnUiThread(new tpt(this, paramString));
  }
  
  public void c()
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "init", new Object[0]);
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(RNPreDownloadFacade.a());
    if (!BitAppAbilityUtils.e())
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        b(2);
        return;
      }
      b(1);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c())
    {
      b(10);
      return;
    }
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      d();
      return;
    }
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this.jdField_a_of_type_AndroidViewView$OnClickListener, 2, this.jdField_c_of_type_JavaLangString);
      return;
    }
    if (NRNReportUtil.a())
    {
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this.jdField_a_of_type_AndroidViewView$OnClickListener, 1, this.jdField_b_of_type_JavaLangString);
    ThreadManager.a(new tpo(this), 5, null, true);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "onLoadBundleSuc has destroy", new Object[0]);
      }
    }
    do
    {
      return;
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "onLoadBundleSuc", new Object[] { String.format("load bundle suc key: %s", new Object[] { paramString }) });
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new tpq(this), 1000L);
      paramString = this.jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = null;
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Long = Math.abs(SystemClock.elapsedRealtime() - paramString.b);
        paramString.jdField_a_of_type_Boolean = true;
        a(paramString);
      }
      paramString = this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
      this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = null;
      if (paramString != null)
      {
        paramString.jdField_a_of_type_Long = Math.abs(SystemClock.elapsedRealtime() - paramString.b);
        paramString.jdField_a_of_type_Boolean = true;
        a(paramString);
      }
    } while ((this.d == null) || (this.d.jdField_a_of_type_ArrayOfLong[4] != 0L));
    this.d.jdField_a_of_type_ArrayOfLong[4] = SystemClock.elapsedRealtime();
  }
  
  public void d()
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, "initApp", new Object[0]);
    }
    if (this.d != null) {
      this.d.jdField_a_of_type_ArrayOfLong[3] = SystemClock.elapsedRealtime();
    }
    this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = new NRNReportUtil.NRNReportAction("actNALoadBundle", getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi, SystemClock.elapsedRealtime());
    this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction.jdField_a_of_type_ArrayOfLong = new long[3];
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this.jdField_a_of_type_AndroidViewView$OnClickListener, 0, this.jdField_b_of_type_JavaLangString);
    if (RNAppManager.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyRNAppManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyRNAppManager == null)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyRNAppManager = ((NearbyRNAppManager)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(217));
      }
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "initApp init NearbyRNAppManager", new Object[] { this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyRNAppManager });
      }
    }
    NearbyBaseRRV localNearbyBaseRRV = this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV;
    int k = this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.r;
    int m = this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.s;
    int n = this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.r;
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {}
    for (String str = null;; str = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount())
    {
      localNearbyBaseRRV.initViews(k, m, RNTest.a(n, str), this);
      return;
    }
  }
  
  public void d(String paramString)
  {
    paramString = this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
    if ((paramString != null) && (paramString.jdField_a_of_type_ArrayOfLong != null) && (paramString.jdField_a_of_type_ArrayOfLong.length > 0)) {
      paramString.jdField_a_of_type_ArrayOfLong[0] = SystemClock.elapsedRealtime();
    }
  }
  
  public void doOnBackPressed()
  {
    Object localObject = BitAppInstanceManager.getInstance();
    if (localObject != null)
    {
      ((ReactInstanceManager)localObject).onBackPressed();
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = null;
      if (localObject != null)
      {
        ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Long = Math.abs(SystemClock.elapsedRealtime() - ((NRNReportUtil.NRNReportAction)localObject).b);
        if (NetworkUtil.e(BaseApplicationImpl.getContext())) {
          break label74;
        }
        ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Int = 7;
      }
    }
    for (;;)
    {
      ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Boolean = false;
      a((NRNReportUtil.NRNReportAction)localObject);
      return;
      super.doOnBackPressed();
      break;
      label74:
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction != null) {
        ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Int = 8;
      } else if (this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction != null) {
        ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Int = 9;
      } else {
        ((NRNReportUtil.NRNReportAction)localObject).jdField_a_of_type_Int = 4;
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    NearbyRNAppManager.a();
    this.jdField_a_of_type_Boolean = false;
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi = BaseBusi.a(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi == null)
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "busi type is not validate", new Object[0]);
      }
      finish();
      return bool;
    }
    this.d = new NRNReportUtil.NRNReportAction("actNAOpenCost", this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi, paramBundle.getLongExtra("enterTime", SystemClock.elapsedRealtime()));
    this.d.jdField_a_of_type_ArrayOfLong = new long[7];
    this.d.jdField_a_of_type_ArrayOfLong[0] = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV = new NearbyBaseRRV(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV.setOnFactSizeChangedListener(null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.p);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.mSystemBarComp = new SystemBarCompact(this, true, this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.o);
    this.mSystemBarComp.init();
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV, paramBundle);
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    View localView = this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this);
    if (localView != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView, paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this.jdField_a_of_type_AndroidViewView$OnClickListener, 0, this.jdField_b_of_type_JavaLangString);
    setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = new NRNReportUtil.NRNReportAction("actNAUseRN", getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi, SystemClock.elapsedRealtime());
    c();
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV.onDestroy();
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_JavaUtilList = null;
    if (localList != null) {
      NRNReportUtil.a(localList);
    }
    this.jdField_a_of_type_Boolean = true;
    NearbyRNAppManager.b();
    NRNReportUtil.a(getCurrentAccountUin(), this.jdField_a_of_type_JavaLangBoolean.booleanValue());
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV.onPause();
    }
    NearbyRNAppManager.c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnNearbyBaseRRV.onResume();
    }
    NearbyRNAppManager.a(this);
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_b_of_type_Boolean))
    {
      if (NearbyUtils.a()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, "window first focused", new Object[0]);
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_Tpx != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.post(this.jdField_a_of_type_Tpx);
      }
      if ((this.d != null) && (this.d.jdField_a_of_type_ArrayOfLong[1] == 0L)) {
        this.d.jdField_a_of_type_ArrayOfLong[1] = SystemClock.elapsedRealtime();
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(this.jdField_a_of_type_AndroidViewView$OnClickListener, 1, this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction = new NRNReportUtil.NRNReportAction("actNALoadSo", getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi, SystemClock.elapsedRealtime());
    if (this.d != null) {
      this.d.jdField_a_of_type_ArrayOfLong[2] = SystemClock.elapsedRealtime();
    }
    RNPreDownloadFacade.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this, false, this);
  }
  
  public void e(String paramString)
  {
    paramString = this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
    if ((paramString != null) && (paramString.jdField_a_of_type_ArrayOfLong != null) && (paramString.jdField_a_of_type_ArrayOfLong.length > 1)) {
      paramString.jdField_a_of_type_ArrayOfLong[1] = SystemClock.elapsedRealtime();
    }
  }
  
  public void f(String paramString)
  {
    paramString = this.jdField_c_of_type_ComTencentMobileqqNearbyRnNRNReportUtil$NRNReportAction;
    if ((paramString != null) && (paramString.jdField_a_of_type_ArrayOfLong != null) && (paramString.jdField_a_of_type_ArrayOfLong.length > 2)) {
      paramString.jdField_a_of_type_ArrayOfLong[2] = SystemClock.elapsedRealtime();
    }
  }
  
  public void finish()
  {
    super.finish();
    InputMethodUtil.a(this);
  }
  
  public void g(String paramString)
  {
    try
    {
      k = Color.parseColor(paramString);
      k |= 0xFF000000;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int k = 0;
        paramString.printStackTrace();
      }
    }
    if ((k != 0) && (k != this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.o))
    {
      if (this.mSystemBarComp != null)
      {
        this.mSystemBarComp.a(k);
        this.mSystemBarComp.b(k);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a(k);
    }
  }
  
  public void h(String paramString)
  {
    if (NearbyUtils.b()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "removeLoadingView", paramString });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a);
      this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.a = null;
    }
  }
  
  public void invokeDefaultOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  public boolean showPreview()
  {
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      this.mSystemBarComp.a(this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.o);
      this.mSystemBarComp.b(this.jdField_a_of_type_ComTencentMobileqqNearbyRnBaseBusi.o);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyReactBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */