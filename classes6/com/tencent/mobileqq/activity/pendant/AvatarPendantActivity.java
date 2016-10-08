package com.tencent.mobileqq.activity.pendant;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.PendantGridAdapter.GridItemHolder;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.ViewHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopItemInfo;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import omv;
import omw;
import omx;
import omy;
import omz;
import onc;
import ond;
import onf;
import ong;
import onh;
import oni;
import onj;
import onk;
import onl;
import onn;
import onp;
import onq;
import onr;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarPendantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener
{
  public static int a = 0;
  static final String jdField_a_of_type_JavaLangString = "sp_pendant_market_request";
  public static int b = 0;
  static final String jdField_b_of_type_JavaLangString = "PendantMarketLastJsonTimeSpKey";
  public static int c = 0;
  public static int d = 0;
  static final int r = 1000;
  static final int s = 10;
  static final int t = 11;
  private static final int v = 1;
  double jdField_a_of_type_Double;
  long jdField_a_of_type_Long;
  public Uri a;
  public Handler a;
  SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  public ProfileActivity.AllInOne a;
  public AvatarPendantAdapter a;
  UniPayHandler.UniPayUpdateListener jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener = new onl(this);
  UniPayHandler jdField_a_of_type_ComTencentMobileqqAppUniPayHandler;
  public DynamicAvatarView a;
  AvatarPendantShopItemInfo jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo;
  public AvatarPendantShopSeriesInfo a;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new omz(this);
  public DownloadListener a;
  TipsBar jdField_a_of_type_ComTencentMobileqqWidgetTipsBar;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  boolean jdField_a_of_type_Boolean;
  double jdField_b_of_type_Double;
  View jdField_b_of_type_AndroidViewView;
  public Button b;
  public ImageView b;
  public TextView b;
  boolean jdField_b_of_type_Boolean;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  public boolean d;
  public int e;
  boolean e;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  public int u;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
  }
  
  public AvatarPendantActivity()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new omy(this);
  }
  
  private void a(List paramList1, List paramList2, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new onj(this, paramList1, paramList2));
    localValueAnimator.addListener(new onk(this));
    localValueAnimator.setDuration(paramInt).start();
  }
  
  private void a(boolean paramBoolean)
  {
    String str = this.jdField_c_of_type_JavaLangString;
    ThreadManager.a().post(new omx(this, str, paramBoolean));
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = true;
    if (paramBoolean)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator.setDuration(400L);
      localValueAnimator.setInterpolator(null);
      localValueAnimator.addUpdateListener(new onf(this));
      localValueAnimator.addListener(new ong(this));
      localValueAnimator.start();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void g()
  {
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.app.getManager(46)).a(1);
    Object localObject1 = new File(AvatarPendantUtil.b);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdir();
    }
    Object localObject2 = new File(AvatarPendantUtil.b + "/icon.zip");
    if ((((File)localObject1).exists()) && (!((File)localObject2).exists()) && (localDownloaderInterface != null)) {
      ThreadManager.b().post(new omv(this, localDownloaderInterface, (File)localObject2));
    }
    localObject1 = ((AvatarPendantManager)this.app.getManager(45)).a();
    boolean bool = this.app.a().getSharedPreferences("clubContentPendantMarketJsonUpdate", 0).getBoolean("clubContentPendantMarketJsonUpdate", false);
    if ((((List)localObject1).size() > 0) && (!bool))
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject1);
      e();
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.a(), this);
        if (new File(this.jdField_c_of_type_JavaLangString).exists())
        {
          ((List)localObject1).clear();
          a(true);
          return;
        }
      } while (localDownloaderInterface == null);
      localObject1 = new DownloadTask(ClubContentJsonTask.m.jdField_c_of_type_JavaLangString, new File(this.jdField_c_of_type_JavaLangString));
      ((DownloadTask)localObject1).n = false;
      ((DownloadTask)localObject1).l = true;
      localObject2 = new Bundle();
      localDownloaderInterface.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
    } while (!QLog.isColorLevel());
    QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start download xydata.android.v1.json...");
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131303047);
    View localView = super.findViewById(2131302291);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131303048));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131303046));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)super.findViewById(2131303050));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131303052));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131303053));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131303051);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)super.findViewById(2131298593));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131303056));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131303057));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131303055));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    Object localObject1 = (TextView)super.findViewById(2131297083);
    ((TextView)localObject1).setText(super.getString(2131367975));
    ((TextView)localObject1).setOnClickListener(this);
    localObject1 = (TextView)super.findViewById(2131297139);
    ((TextView)localObject1).setText(super.getString(2131370880));
    ((TextView)localObject1).setFocusable(true);
    ((TextView)localObject1).setFocusableInTouchMode(true);
    ((TextView)localObject1).setClickable(true);
    ((TextView)localObject1).setContentDescription(super.getString(2131370880));
    localObject1 = (RelativeLayout)super.findViewById(2131297138);
    localObject1 = getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject1).getHeight();
    int i2 = ((Display)localObject1).getWidth();
    double d3 = i1 / i2;
    double d1 = d3 - 1.78D;
    this.jdField_f_of_type_Int = (i1 - a());
    this.jdField_e_of_type_Int = jdField_a_of_type_Int;
    double d2 = 0.58D * (d3 - 2.0D * d1) / 1.8D;
    d1 = (1.85D - d1 * 2.0D) * 0.38D / d3;
    Object localObject2;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      d1 = d3 - 1.67D;
      a();
      i1 = super.getResources().getDimensionPixelSize(2131492908);
      localObject2 = (RelativeLayout)super.findViewById(2131303049);
      localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      localLayoutParams.topMargin = (i1 / 2 + 14 - (int)(Math.abs(d1) * 24.0D));
      ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
      d2 = 0.58D * (1.8D + 2.0D * d1) / d3;
      d1 = 0.38D * (d1 * 2.0D + 1.95D) / d3;
    }
    for (;;)
    {
      this.jdField_g_of_type_Int = ((int)(this.jdField_f_of_type_Int * d2));
      this.h = ((int)(this.jdField_f_of_type_Int * d1));
      if (!this.jdField_b_of_type_Boolean)
      {
        super.findViewById(2131303058).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText("没有SD卡无法使用头像挂件");
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.a(false);
        this.jdField_g_of_type_Int = ((int)((d2 + 0.06D) * this.jdField_f_of_type_Int));
        this.h = ((int)(d1 * this.jdField_f_of_type_Int));
        this.jdField_a_of_type_Boolean = true;
        this.i = ((int)(this.jdField_g_of_type_Int * 0.383D));
        this.k = ((int)(186.05F * this.i / 150.0F));
        this.m = ((int)(222.05F * this.k / 186.0F));
        this.o = ((this.k - this.i) / 2);
        this.jdField_a_of_type_Double = ((this.h + 0.05F) / this.jdField_g_of_type_Int);
        this.jdField_a_of_type_Double -= 0.24D;
        this.j = ((int)(this.i * this.jdField_a_of_type_Double));
        this.l = ((int)(this.k * this.jdField_a_of_type_Double));
        this.n = ((int)(this.m * this.jdField_a_of_type_Double));
        this.p = ((int)(this.o * this.jdField_a_of_type_Double));
        this.jdField_b_of_type_Double = ((this.i - this.j + 0.05F) / (this.jdField_g_of_type_Int - this.h));
        localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
        localObject2 = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject1).topMargin = this.h;
        ((FrameLayout.LayoutParams)localObject2).height = this.jdField_g_of_type_Int;
        this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = this.i;
        ((RelativeLayout.LayoutParams)localObject1).height = this.i;
        ((RelativeLayout.LayoutParams)localObject2).width = this.k;
        ((RelativeLayout.LayoutParams)localObject2).height = this.m;
        localLayoutParams.height = this.o;
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, 200, true, true, 7);
        l();
        if (!ThemeUtil.isInNightMode(this.app)) {
          break label1191;
        }
        if (localView != null) {
          localView.setVisibility(0);
        }
      }
      for (;;)
      {
        if ((this.jdField_f_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
          break label1206;
        }
        this.jdField_f_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(new onh(this), 1500L);
        return;
        if (this.jdField_c_of_type_Boolean)
        {
          super.findViewById(2131303058).setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText("SD卡已满，可能无法使用头像挂件");
          this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.a(false);
          this.jdField_g_of_type_Int = ((int)((d2 + 0.06D) * this.jdField_f_of_type_Int));
          this.h = ((int)(d1 * this.jdField_f_of_type_Int));
          this.jdField_a_of_type_Boolean = true;
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter = new AvatarPendantAdapter(this, this, this, ((Display)localObject1).getWidth(), this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, this.jdField_g_of_type_Int - this.h);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter);
        break;
        label1191:
        if (localView != null) {
          localView.setVisibility(8);
        }
      }
      label1206:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void i()
  {
    if ((this.jdField_e_of_type_Int == jdField_a_of_type_Int) || (this.jdField_e_of_type_Int == jdField_d_of_type_Int)) {}
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = this.o;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new onr();
    onr localonr1 = new onr();
    onr localonr2 = new onr();
    ((onr)localObject).jdField_c_of_type_Int = localLayoutParams.height;
    ((onr)localObject).jdField_d_of_type_Int = this.jdField_g_of_type_Int;
    int i1 = localLayoutParams.topMargin;
    ((onr)localObject).jdField_b_of_type_Int = i1;
    ((onr)localObject).jdField_a_of_type_Int = i1;
    ((onr)localObject).jdField_g_of_type_Int = ((int)(Math.abs(this.jdField_g_of_type_Int - localLayoutParams.height) * 1.0D / this.jdField_g_of_type_Int * ((onr)localObject).jdField_g_of_type_Int));
    i1 = localLayoutParams1.topMargin;
    localonr1.jdField_b_of_type_Int = i1;
    localonr1.jdField_a_of_type_Int = i1;
    localonr1.jdField_e_of_type_Int = localLayoutParams1.width;
    localonr1.jdField_f_of_type_Int = this.i;
    localonr1.jdField_c_of_type_Int = localLayoutParams1.height;
    localonr1.jdField_d_of_type_Int = this.i;
    localonr1.jdField_g_of_type_Int = ((onr)localObject).jdField_g_of_type_Int;
    i1 = localLayoutParams2.topMargin;
    localonr2.jdField_b_of_type_Int = i1;
    localonr2.jdField_a_of_type_Int = i1;
    localonr2.jdField_e_of_type_Int = localLayoutParams2.width;
    localonr2.jdField_f_of_type_Int = this.k;
    localonr2.jdField_c_of_type_Int = localLayoutParams2.height;
    localonr2.jdField_d_of_type_Int = this.m;
    localonr2.jdField_g_of_type_Int = ((onr)localObject).jdField_g_of_type_Int;
    localArrayList2.add(this.jdField_a_of_type_AndroidViewView);
    localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView);
    localArrayList2.add(this.jdField_b_of_type_AndroidWidgetImageView);
    localArrayList1.add(localObject);
    localArrayList1.add(localonr1);
    localArrayList1.add(localonr2);
    a(localArrayList2, localArrayList1, ((onr)localObject).jdField_g_of_type_Int);
  }
  
  private void j()
  {
    ThreadManager.a().post(new onn(this));
  }
  
  private void k()
  {
    if (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    Object localObject = ((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
    if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()))
    {
      this.jdField_a_of_type_Long = ((ExtensionInfo)localObject).pendantId;
      localObject = (AvatarPendantManager)this.app.getManager(45);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (AvatarPendantUtil.a(this.jdField_a_of_type_Long)) {
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.o);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "1", "", "", "");
        return;
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.o);
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "0", "", "", "");
  }
  
  private void l()
  {
    Object localObject = new File(AvatarPendantUtil.jdField_c_of_type_JavaLangString + "/widget_display_bg.jpg");
    if (((File)localObject).exists())
    {
      ColorDrawable localColorDrawable = new ColorDrawable(-16741938);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidViewView.getWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidViewView.getHeight();
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localObject = URLDrawable.getDrawable((File)localObject, localURLDrawableOptions);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void m()
  {
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 16, 0, 16, 0 });
    localValueAnimator.setInterpolator(null);
    localValueAnimator.addUpdateListener(new onc(this));
    localValueAnimator.addListener(new ond(this));
    localValueAnimator.setDuration(1200L);
    localValueAnimator.start();
  }
  
  public int a()
  {
    Object localObject1 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int i2 = ((Rect)localObject1).top;
    int i1 = i2;
    if (i2 == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      i1 = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      i1 = super.getResources().getDimensionPixelSize(i1);
      return i1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return i2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return i2;
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
      return i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return i2;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return i2;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return i2;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    return i2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new oni(this));
  }
  
  public void a(TextView paramTextView, View paramView)
  {
    int i2 = getWindowManager().getDefaultDisplay().getWidth();
    int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    paramTextView.measure(i3, i4);
    int i1 = paramTextView.getMeasuredWidth();
    paramView.measure(i3, i4);
    i3 = paramView.getMeasuredWidth();
    float f1 = super.getResources().getDisplayMetrics().density;
    i2 = i2 - i3 - (int)(55 * f1 + 0.5F);
    if (i1 > i2)
    {
      paramTextView.setMaxWidth(i2 - 10);
      paramTextView.setSingleLine(true);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramAdapterView.getId() != 2131303077) {}
    while ((!(paramAdapterView instanceof GridView)) || (paramAdapterView.getTag() == null) || (paramView == null) || (paramView.getTag() == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    f();
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo = ((AvatarPendantShopItemInfo)((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)paramView.getTag()).a.getTag());
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_a_of_type_Int;
    Object localObject = (AvatarPendantManager)this.app.getManager(45);
    List localList = ((AvatarPendantManager)localObject).a();
    AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo1 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo;
    AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo2 = (AvatarPendantShopSeriesInfo)paramAdapterView.getTag();
    int i1 = 0;
    if (i1 < localList.size())
    {
      AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo3 = (AvatarPendantShopSeriesInfo)localList.get(i1);
      if (localAvatarPendantShopSeriesInfo3 != null)
      {
        if (localAvatarPendantShopSeriesInfo3.jdField_a_of_type_Int != localAvatarPendantShopSeriesInfo2.jdField_a_of_type_Int) {
          break label201;
        }
        localAvatarPendantShopSeriesInfo3.jdField_c_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo = localAvatarPendantShopSeriesInfo2;
      }
      for (;;)
      {
        i1 += 1;
        break;
        label201:
        if ((localAvatarPendantShopSeriesInfo1 != null) && (localAvatarPendantShopSeriesInfo3.jdField_a_of_type_Int == localAvatarPendantShopSeriesInfo1.jdField_a_of_type_Int)) {
          localAvatarPendantShopSeriesInfo3.jdField_c_of_type_Int = -1;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(localList);
    i1 = this.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom();
    int i2 = this.jdField_a_of_type_AndroidWidgetButton.getPaddingTop();
    int i3 = this.jdField_a_of_type_AndroidWidgetButton.getPaddingRight();
    int i4 = this.jdField_a_of_type_AndroidWidgetButton.getPaddingLeft();
    label310:
    label404:
    label504:
    int i5;
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1711276033);
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130841834);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131368797);
      this.jdField_a_of_type_AndroidWidgetButton.setPadding(i4, i2, i3, i1);
      ReportController.b(this.app, "CliOper", "", "", "0X8005FD5", "0X8005FD5", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Long), "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_b_of_type_Int != 1) {
        break label641;
      }
      ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.o);
      if (Build.VERSION.SDK_INT < 14) {
        break label663;
      }
      if ((this.jdField_e_of_type_Int == jdField_b_of_type_Int) || (this.jdField_e_of_type_Int == jdField_c_of_type_Int))
      {
        paramAdapterView = (ViewGroup)paramAdapterView.getParent();
        localObject = (ViewGroup)paramAdapterView.getParent();
        i1 = paramAdapterView.getHeight();
        i2 = paramView.getHeight();
        i3 = DisplayUtil.a(this, 7.0F);
        if (!this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean) {
          break label697;
        }
        i4 = (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() - 1) / 4;
        if (paramInt != 0) {
          break label665;
        }
        paramInt = 0;
        i5 = DisplayUtil.a(this, 4.0F);
      }
    }
    label641:
    label663:
    label665:
    label672:
    label697:
    for (paramInt = i1 - (i4 + 1 - paramInt) * (i2 + i5) + i5 - i3;; paramInt = i1 - i2 - i3)
    {
      i2 = this.jdField_g_of_type_Int - this.h;
      i1 = ((ViewGroup)localObject).getTop();
      if (((ViewGroup)localObject).getTag() != null)
      {
        i3 = ((AvatarPendantAdapter.ViewHolder)((ViewGroup)localObject).getTag()).jdField_a_of_type_Int;
        if (i1 >= 0) {
          break label672;
        }
        i1 = paramInt;
        if (paramInt < 0) {
          i1 = 0 - paramInt;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - i1);
      }
      for (;;)
      {
        i();
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130841836);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131368794);
        break label310;
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.o);
        break label404;
        break;
        paramInt /= 4;
        break label504;
        if (paramInt + i1 < i2) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - paramInt);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    String str1;
    if (paramBoolean)
    {
      str1 = "mvip.gxh.android.faceaddon_nati_dft";
      if (!paramBoolean) {
        break label139;
      }
    }
    for (String str2 = "pendantNativeVipDefault";; str2 = "pendantNativeVip" + this.jdField_a_of_type_Long)
    {
      try
      {
        localJSONObject.put("userId", this.app.a());
        localJSONObject.put("openMonth", paramInt);
        localJSONObject.put("aid", str1);
        localJSONObject.put("offerId", "1450000515");
        localJSONObject.put("serviceName", paramString2);
        localJSONObject.put("serviceCode", paramString1);
        PayBridgeActivity.tenpay(this, localJSONObject.toString(), 4, str2);
        return;
      }
      catch (JSONException paramString1)
      {
        label139:
        paramString1.printStackTrace();
      }
      str1 = "mvip.gxh.android.faceaddon_nati_" + this.jdField_a_of_type_Long;
      break;
    }
  }
  
  public boolean a()
  {
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      if ((localExtensionInfo != null) && (localExtensionInfo.pendantId == this.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    int i1 = 0;
    View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int i2 = -localView.getTop();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_ComTencentWidgetXListView.s(), localView.getHeight());
    if (i1 < this.jdField_a_of_type_ComTencentWidgetXListView.s())
    {
      if (this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i1) == 0) {
        this.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        i1 += 1;
        break;
        i2 += this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i1);
      }
    }
    return i2;
  }
  
  public void b()
  {
    int i1 = b();
    int i2 = i1 - this.q;
    this.q = i1;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    if ((i2 >= 0) || ((i2 <= 0) && (this.q <= this.jdField_g_of_type_Int - this.h))) {
      localLayoutParams.height -= i2;
    }
    if (localLayoutParams.height <= this.h)
    {
      localLayoutParams.height = this.h;
      i1 = this.j;
      localLayoutParams1.height = i1;
      localLayoutParams1.width = i1;
      localLayoutParams2.width = this.l;
      localLayoutParams2.height = this.n;
      localLayoutParams3.height = this.p;
      this.jdField_e_of_type_Int = jdField_b_of_type_Int;
      if ((this.jdField_e_of_type_Int == jdField_c_of_type_Int) && ((i2 >= 0) || ((i2 <= 0) && (this.q <= this.jdField_g_of_type_Int - this.h))))
      {
        i1 = i2;
        if (i2 != 0)
        {
          i1 = i2;
          if (i2 != 1) {
            if (i2 != -1) {
              break label432;
            }
          }
        }
      }
    }
    label432:
    for (i1 = i2;; i1 = (int)(i2 * this.jdField_b_of_type_Double))
    {
      localLayoutParams1.width -= i1;
      localLayoutParams1.height = localLayoutParams1.width;
      localLayoutParams2.width -= (int)(i1 * 186.05F / 150.0F);
      localLayoutParams2.height = ((int)(222.05F * localLayoutParams2.width / 186.0F));
      localLayoutParams3.height = ((localLayoutParams2.width - localLayoutParams1.width) / 2);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setLayoutParams(localLayoutParams1);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams3);
      return;
      if (localLayoutParams.height >= this.jdField_g_of_type_Int)
      {
        localLayoutParams.height = this.jdField_g_of_type_Int;
        i1 = this.i;
        localLayoutParams1.height = i1;
        localLayoutParams1.width = i1;
        localLayoutParams2.width = this.k;
        localLayoutParams2.height = this.m;
        localLayoutParams3.height = this.o;
        this.jdField_e_of_type_Int = jdField_a_of_type_Int;
        break;
      }
      this.jdField_e_of_type_Int = jdField_c_of_type_Int;
      b(false);
      break;
    }
  }
  
  public void c()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131303059);
    TextView localTextView = (TextView)super.findViewById(2131303060);
    Button localButton = (Button)super.findViewById(2131303061);
    String str2 = this.app.a();
    SharedPreferences localSharedPreferences = this.app.a().getSharedPreferences("uniPaySp_" + str2, 0);
    String str3 = localSharedPreferences.getString("sUin", "");
    int i1 = localSharedPreferences.getInt("isShowOpen", 0);
    int i2 = localSharedPreferences.getInt("iUinpPayType", 0);
    Object localObject3 = "LTMCLUB";
    String str1 = "QQ会员";
    String str4 = super.getString(2131371063);
    Object localObject2 = str1;
    Object localObject1 = localObject3;
    if (str3 != null)
    {
      localObject2 = str1;
      localObject1 = localObject3;
      if (str2 != null)
      {
        localObject2 = str1;
        localObject1 = localObject3;
        if (str3.equals(str2))
        {
          if (1 == i1)
          {
            localImageView.setVisibility(0);
            localTextView.setVisibility(0);
            localButton.setVisibility(0);
          }
          switch (i2)
          {
          default: 
            localObject1 = "QQ会员";
            localObject2 = "LTMCLUB";
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "UniPayUpdateListener back showTitleBtn isShowOpen:" + i1);
      }
      a(localTextView, localButton);
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localButton.setOnClickListener(new onp(this, (String)localObject1, (String)localObject2, Integer.valueOf(localSharedPreferences.getString("open_month", "3")).intValue()));
      return;
      localButton.setText(2131370381);
      localTextView.setText(super.getString(2131370434, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130839468));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131370382);
      localTextView.setText(super.getString(2131370435, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130840246));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131370381);
      localTextView.setText(super.getString(2131370436, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130839468));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131370382);
      localTextView.setText(super.getString(2131370437, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130839582));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131370382);
      localTextView.setText(super.getString(2131370441, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130840247));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131370383);
      localTextView.setText(super.getString(2131370442, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130840247));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131370383);
      localTextView.setText(super.getString(2131370438, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130839582));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131370382);
      localTextView.setText(super.getString(2131370439, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130840248));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
      continue;
      localButton.setText(2131370383);
      localTextView.setText(super.getString(2131370440, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130840248));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
    }
  }
  
  public void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    String[] arrayOfString = super.getResources().getStringArray(2131230742);
    localActionSheet.a(arrayOfString[22], 2130841021, 0);
    localActionSheet.c(arrayOfString[24]);
    localActionSheet.c(arrayOfString[13]);
    localActionSheet.c(arrayOfString[23]);
    localActionSheet.d(arrayOfString[16]);
    localActionSheet.a(new onq(this, localActionSheet));
    try
    {
      if (!isFinishing()) {
        localActionSheet.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if (paramInt1 == 4) {
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("callbackSn");
        if ((str != null) && (str.startsWith("pendantNativeVip"))) {
          break label35;
        }
      }
    }
    label35:
    label226:
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getStringExtra("result");
        paramInt2 = -1;
        int i2 = -1;
        for (;;)
        {
          try
          {
            paramIntent = new JSONObject(paramIntent);
            paramInt1 = i2;
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              i1 = Integer.parseInt(paramIntent.getString("resultCode"));
              paramInt1 = i2;
              paramInt2 = i1;
              i2 = Integer.parseInt(paramIntent.getString("payState"));
              paramInt1 = i2;
              paramInt2 = i1;
              int i3 = Integer.parseInt(paramIntent.getString("provideState"));
              paramInt1 = i3;
              paramInt2 = i1;
              i1 = paramInt1;
              if ((paramIntent == null) || (paramInt2 != 0) || (i2 != 0) || (i1 != 0)) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler != null) {
                this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
              }
              if (!str.equals("pendantNativeVipDefault")) {
                break label226;
              }
              ReportController.b(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, "", "", "", "");
              this.jdField_d_of_type_Boolean = true;
              return;
            }
            catch (JSONException localJSONException2)
            {
              int i1;
              Intent localIntent;
              for (;;) {}
            }
            localJSONException1 = localJSONException1;
            paramIntent = null;
            paramInt1 = i2;
          }
          localJSONException1.printStackTrace();
          i1 = -1;
          i2 = paramInt1;
          continue;
          ReportController.b(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, str.substring(16, str.length()), "", "", "");
        }
        if (paramInt1 != 1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicAvatar", 2, "record dynamic avatar! resultCode:" + paramInt2);
        }
      } while (paramInt2 != -1);
      j();
      return;
    } while (paramInt2 != -1);
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = ImageUtil.c(this, this.jdField_a_of_type_AndroidNetUri);
    paramInt1 = Math.min(482, ProfileCardUtil.a(this));
    localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("fromWhereClick", 10);
    PhotoUtils.a(localIntent, this, AvatarPendantActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.a());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentViewNoTitle(2130904529);
    getWindow().setBackgroundDrawable(null);
    paramBundle = super.getIntent();
    boolean bool2;
    boolean bool1;
    if (paramBundle.getParcelableExtra("AllInOne") != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)paramBundle.getParcelableExtra("AllInOne"));
      this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("DynamicAvatarTips", false);
      bool2 = paramBundle.getBooleanExtra("showActionSheet", false);
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler = ((UniPayHandler)this.app.a(44));
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
      if ((!NetworkUtil.e(this)) && (QLog.isColorLevel())) {
        QLog.d("AvatarPendantActivity", 2, "net is not connected");
      }
      this.jdField_b_of_type_Boolean = SystemUtil.a();
      if (SystemUtil.a() >= 1024L) {
        break label270;
      }
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_c_of_type_JavaLangString = (this.app.getApplication().getApplicationContext().getFilesDir() + File.separator + ClubContentJsonTask.m.b);
      h();
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
        break label275;
      }
      a();
      g();
    }
    for (;;)
    {
      if (bool2) {
        d();
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "AllinOne info is null");
      }
      finish();
      return true;
      label270:
      bool1 = false;
      break;
      label275:
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "sdcard exist:" + this.jdField_b_of_type_Boolean + " sdcard full:" + this.jdField_c_of_type_Boolean);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
    }
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_c_of_type_Int = -1;
    }
    if ((this.app != null) && (this.jdField_a_of_type_Long != 0L)) {
      ((AvatarPendantManager)this.app.getManager(45)).a(this.jdField_a_of_type_Long).b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a();
      URLDrawable.resume();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (str != null)
    {
      if (!ProfileCardUtil.a(this.app, str)) {
        break label147;
      }
      j();
      switch (paramIntent.getIntExtra("fromWhereClick", -1))
      {
      }
    }
    for (;;)
    {
      k();
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 1, 0, "1", "", "", "");
      continue;
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 0, 0, "0", "", "", "");
      continue;
      label147:
      QQToast.a(this, 1, 2131370143, 0).b(getTitleBarHeight());
    }
  }
  
  protected void doOnPause()
  {
    ((AvatarPendantManager)this.app.getManager(45)).c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    List localList = ((AvatarPendantManager)this.app.getManager(45)).a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter != null) && (localList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(localList);
    }
    k();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void e()
  {
    if (this.app == null) {}
    long l1;
    long l2;
    do
    {
      return;
      SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("sp_pendant_market_request", 0);
      l1 = localSharedPreferences.getLong("PendantMarketLastJsonTimeSpKey", 0L);
      l2 = NetConnInfoCenter.getServerTimeMillis();
      if (l2 - l1 > 1800000L)
      {
        ClubContentUpdateHandler.b(this.app);
        localSharedPreferences.edit().putLong("PendantMarketLastJsonTimeSpKey", l2).commit();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AvatarPendantActivity", 2, "sendCheckUpdateReq, lastRequestTime=" + l1 + ", AppSetting.isDebugVersion=" + false + ",serverTime:" + l2);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      ((AvatarPendantManager)this.app.getManager(45)).a(this.jdField_a_of_type_Long).b();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {}
    while (paramMessage.what != 1000) {
      return true;
    }
    runOnUiThread(new omw(this, ((AvatarPendantManager)this.app.getManager(45)).a()));
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    int i1;
    label596:
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131297083: 
            finish();
            return;
          case 2131303056: 
            if (!NetworkUtil.e(this))
            {
              QQToast.a(this, 2131370621, 0).b(getTitleBarHeight());
              return;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_a_of_type_Boolean))
            {
              paramView = IndividuationUrlHelper.a("linkPendantSet") + this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_a_of_type_Int;
              localObject = new Intent(this, QQBrowserActivity.class);
              ((Intent)localObject).putExtra("url", paramView);
              ((Intent)localObject).putExtra("hide_more_button", true);
              ((Intent)localObject).putExtra("webStyle", "noBottomBar");
              startActivity((Intent)localObject);
              return;
            }
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo == null);
        if (!a())
        {
          ((VasExtensionHandler)this.app.a(71)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131368796);
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130841838);
          this.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(2130838323, 0, 0, 0);
          paramView = this.jdField_a_of_type_AndroidWidgetButton.getCompoundDrawables()[0];
          if ((paramView instanceof Animatable)) {
            ((Animatable)paramView).start();
          }
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
        return;
        if (!NetworkUtil.e(this))
        {
          QQToast.a(this, 2131370621, 0).b(getTitleBarHeight());
          return;
        }
        ((VasExtensionHandler)this.app.a(71)).a(0L, 0);
        ReportController.b(this.app, "CliOper", "", "", "0X8005FD3", "0X8005FD3", 0, 0, "", "", "", "");
        return;
        if (ProfileCardUtil.a()) {
          QQToast.a(this, 1, 2131368762, 0).b(getTitleBarHeight());
        }
        for (;;)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004174", "0X8004174", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int, 0, "", "", "", "");
          return;
          d();
        }
      } while (paramView.getTag() == null);
      long l1 = ((Integer)paramView.getTag()).intValue();
      paramView = ((AvatarPendantManager)this.app.getManager(45)).a();
      i1 = 0;
      if (i1 < paramView.size())
      {
        localObject = (AvatarPendantShopSeriesInfo)paramView.get(i1);
        if ((localObject != null) && (((AvatarPendantShopSeriesInfo)localObject).jdField_a_of_type_Int == l1)) {
          if (((AvatarPendantShopSeriesInfo)localObject).jdField_a_of_type_Boolean) {
            break label596;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ((AvatarPendantShopSeriesInfo)localObject).jdField_a_of_type_Boolean = bool;
          i1 += 1;
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(paramView);
      return;
      i1 = ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height;
    } while ((this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter == null) || (i1 == this.jdField_g_of_type_Int));
    i();
    return;
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", IndividuationUrlHelper.a("rarePendantActivity"));
    paramView.putExtra("isShowAd", false);
    super.startActivity(paramView);
    ReportController.b(this.app, "CliOper", "", "", "0X8006334", "0X8006334", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\pendant\AvatarPendantActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */