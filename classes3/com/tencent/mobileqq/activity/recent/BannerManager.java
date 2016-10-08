package com.tencent.mobileqq.activity.recent;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.UserInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.UITools;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityBannerData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.WorkState;
import cooperation.qqhotspot.QQHotSpotHelper.APConnInfo;
import cooperation.qqhotspot.WifiConversationManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import ovk;
import ovl;
import ovm;
import ovn;
import ovo;
import ovp;
import ovq;
import ovr;
import ovs;
import ovt;
import ovu;
import ovv;
import ovw;
import ovx;
import ovy;
import ovz;
import owa;
import owc;
import owe;
import owf;
import owg;
import owh;
import owj;
import owk;
import owl;
import owm;
import own;
import owo;
import owp;
import owq;

public class BannerManager
  implements Handler.Callback
{
  public static final int A = 23;
  public static final int B = 23;
  public static final int C = 24;
  public static final int D = 24;
  public static final int E = 25;
  public static final int F = 26;
  public static final int G = 26;
  public static final int H = 26;
  public static final int I = 3;
  public static final int J = 0;
  public static final int K = 1;
  public static final int L = 2;
  public static final int M = 900000;
  public static final int O = 0;
  public static final int P = 1;
  public static final int Q = 4;
  public static final int R = 6;
  public static final int S = 8;
  public static final int T = 7;
  public static final int U = 9;
  public static final int V = 10;
  public static final int W = 12;
  private static final int X = 11;
  private static final int Y = 13;
  private static final int Z = 14;
  public static final int a = 1;
  public static final String a = "0X8004028";
  public static final boolean a;
  private static final int aa = 15;
  private static final int ab = 101;
  public static final int b = 1;
  public static final String b = "0X8004029";
  public static final int c = 1;
  public static final String c = "Q.recent.banner";
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  private static final boolean f = false;
  public static final int g = 5;
  public static final int h = 6;
  private static final String h = "0X80040AA";
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 10;
  public static final int m = 11;
  public static final int n = 12;
  public static final int o = 13;
  public static final int p = 14;
  public static final int q = 15;
  public static final int r = 16;
  public static final int s = 17;
  public static final int t = 18;
  public static final int u = 19;
  public static final int v = 19;
  public static final int w = 20;
  public static final int x = 20;
  public static final int y = 21;
  public static final int z = 22;
  public int N;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private PollBanner jdField_a_of_type_ComTencentMobileqqActivityRecentPollBanner;
  public RecentCallHelper a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private PhoneContactManager.IPhoneContactListener jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(this);
  private Banner[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner = new Banner[27];
  private SparseArray b;
  public boolean b;
  boolean c = false;
  public String d;
  private boolean d;
  public String e;
  private boolean e;
  public String f;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = AppSetting.j;
  }
  
  public BannerManager(BaseActivity paramBaseActivity, XListView paramXListView, RecentCallHelper paramRecentCallHelper)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper = paramRecentCallHelper;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentPollBanner = new PollBanner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void a(SparseArray paramSparseArray)
  {
    if (paramSparseArray == null) {}
    for (;;)
    {
      return;
      int i1 = a(paramSparseArray, 0);
      int i2 = a(paramSparseArray, 1);
      int i3 = a(paramSparseArray, 2);
      if ((i2 >= 20) && (i1 >= 1)) {
        switch (i1)
        {
        }
      }
      while ((i3 >= 24) && (i1 >= 1))
      {
        switch (i1)
        {
        case 10: 
        case 11: 
        case 12: 
        case 14: 
        case 15: 
        default: 
          return;
        }
        ((ArrayList)paramSparseArray.get(0)).clear();
        return;
        ((ArrayList)paramSparseArray.get(0)).clear();
      }
    }
  }
  
  private void a(View paramView)
  {
    paramView.findViewById(2131298527).setVisibility(0);
    ((TextView)paramView.findViewById(2131297821)).setText(2131370154);
  }
  
  private void a(View paramView, Message paramMessage)
  {
    paramView.findViewById(2131298527).setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131297821);
    localTextView.setText(2131372243);
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if (paramView != null) {
        break label51;
      }
    }
    label51:
    while ((paramMessage == null) || (paramMessage.obj == null))
    {
      return;
      paramView = null;
      break;
    }
    localTextView.setOnClickListener(new ovv(this, (String)paramMessage.obj));
  }
  
  private void a(View paramView, Message paramMessage, int paramInt)
  {
    if ((paramMessage == null) || (paramMessage.obj == null) || (!(paramMessage.obj instanceof PhoneUnityBannerData))) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005B72", "0X8005B72", 0, 0, "", "", "", "");
    paramView.findViewById(2131301307).setVisibility(0);
    paramMessage = (PhoneUnityBannerData)paramMessage.obj;
    ((TextView)paramView.findViewById(2131301309)).setText(paramMessage.jdField_b_of_type_JavaLangString);
    paramView.setOnClickListener(new owj(this, paramMessage));
  }
  
  private void a(Banner paramBanner)
  {
    if ((paramBanner == null) || (paramBanner.jdField_a_of_type_AndroidViewView != null)) {
      return;
    }
    for (;;)
    {
      try
      {
        int i1 = paramBanner.d;
        switch (i1)
        {
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = i();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = a();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = k();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = h();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = f();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = d();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = g();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = j();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = m();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = l();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = l();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = s();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = n();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = v();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = u();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = e();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = x();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = o();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = p();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = r();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = q();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = t();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = w();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = c();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = b();
        continue;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("Q.recent.banner", 4, "initBannerView | banner = " + paramBanner);
      return;
      paramBanner.jdField_a_of_type_AndroidViewView = g();
    }
  }
  
  private void a(Banner paramBanner, Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent.banner", 4, "updateBanner| banner = " + paramBanner + ", msg = " + paramMessage);
    }
    if ((paramBanner == null) || (paramBanner.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    try
    {
      switch (paramBanner.d)
      {
      case 13: 
      case 1: 
        b(paramBanner.jdField_a_of_type_AndroidViewView);
        return;
      }
    }
    catch (Throwable paramBanner)
    {
      paramBanner.printStackTrace();
      return;
    }
    f(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    c(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    e(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    b(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    a(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    g(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    c(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131305252).setVisibility(0);
    return;
    paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131305252).setVisibility(0);
    return;
    k(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131304891).setVisibility(0);
    return;
    e(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    h(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    j(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    i(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    l(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    f(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    b(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage, paramBanner.e);
    return;
    a(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage, paramBanner.e);
    return;
    h(paramBanner.jdField_a_of_type_AndroidViewView);
    return;
    a(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
    d(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
    return;
  }
  
  private boolean a(int paramInt, View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a());
    PushBanner localPushBanner = new PushBanner(((Config)localObject1).a(0, paramInt), ((Config)localObject1).c(0, paramInt), ((Config)localObject1).a(0, paramInt));
    String str = ((Config)localObject1).b(0, paramInt);
    localPushBanner.l = str;
    localPushBanner.m = ((Config)localObject1).d(0, paramInt);
    boolean bool = localPushBanner.a(((Config)localObject1).b(0, paramInt));
    if ((localPushBanner.c != null) && (localPushBanner.c.contains("|")) && (!CommonUtil.a(Long.parseLong(localPushBanner.c.substring(0, localPushBanner.c.indexOf("|"))), Long.parseLong(localPushBanner.c.substring(localPushBanner.c.indexOf("|") + 1))))) {}
    label483:
    for (;;)
    {
      return false;
      if ((bool) && (!"".equals(localPushBanner.j)))
      {
        localPushBanner.a = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localPushBanner.j);
        if (localPushBanner.a == null) {}
        for (int i1 = 0;; i1 = 1)
        {
          if (i1 == 0) {
            break label483;
          }
          Object localObject2 = ((Config)localObject1).a(0, paramInt);
          if (QLog.isDevelopLevel()) {
            QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + localObject2);
          }
          if (localObject2 == null) {
            break;
          }
          localObject1 = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903501, null);
          ImageView localImageView = (ImageView)((FrameLayout)localObject1).findViewById(2131298833);
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localImageView.setImageBitmap((Bitmap)localObject2);
          DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
          i1 = ((Bitmap)localObject2).getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / ((Bitmap)localObject2).getWidth();
          localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, i1));
          localImageView.setLayoutParams(localLayoutParams);
          localObject2 = (ImageView)((FrameLayout)localObject1).findViewById(2131298834);
          ((ImageView)localObject2).setTag(localPushBanner);
          ((ImageView)localObject2).setContentDescription("图片推广位");
          ((ImageView)localObject2).setOnClickListener(new owh(this, paramView, paramInt, (FrameLayout)localObject1, str));
          ((FrameLayout)localObject1).setTag(localPushBanner);
          ((ADView)paramView.findViewById(2131298831)).a((View)localObject1, paramInt);
          return true;
        }
      }
    }
  }
  
  private boolean a(View paramView)
  {
    int i4 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a()).a(0);
    if (i4 > 0)
    {
      ((ADView)paramView.findViewById(2131298831)).g();
      int i1 = 0;
      int i3;
      for (int i2 = 0; i1 < i4; i2 = i3)
      {
        i3 = i2;
        if (a(i1, paramView)) {
          i3 = i2 + 1;
        }
        i1 += 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "loadPushBanner, addnum = " + i2);
      }
      if (i2 > 0)
      {
        j();
        return true;
      }
    }
    return false;
  }
  
  private View b()
  {
    return View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130905113, null);
  }
  
  private void b(View paramView)
  {
    paramView.findViewById(2131298527).setVisibility(0);
    ((TextView)paramView.findViewById(2131297821)).setText(2131370153);
    if (a(8))
    {
      a(8, 0);
      this.jdField_e_of_type_JavaLangString = null;
    }
  }
  
  private void b(View paramView, Message paramMessage)
  {
    paramMessage = paramView.findViewById(2131298481);
    paramView = (TextView)paramView.findViewById(2131298483);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      if (FileViewMusicService.a().a())
      {
        String str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370595);
        String str2 = FileViewMusicService.a().a();
        if (str2 != null)
        {
          paramView.setText(Html.fromHtml(str1 + " " + str2));
          paramMessage.setVisibility(0);
          return;
        }
        paramMessage.setVisibility(8);
        return;
      }
      paramMessage.setVisibility(8);
      return;
    }
    paramMessage.setVisibility(8);
  }
  
  private void b(View paramView, Message paramMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateMissedCallBar state: " + paramInt);
    }
    paramMessage = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(37);
    if (paramMessage != null) {}
    for (int i1 = paramMessage.a();; i1 = 0)
    {
      if (i1 == 0) {}
      do
      {
        do
        {
          return;
          if (paramInt != 0) {
            break;
          }
        } while (paramView.getVisibility() != 0);
        paramView.setVisibility(8);
        return;
        paramView.findViewById(2131301305).setVisibility(0);
        ((TextView)paramView.findViewById(2131301306)).setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131371140), new Object[] { Integer.valueOf(i1) }));
      } while (i1 > 0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(7);
      return;
    }
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 1;
  }
  
  private View c()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903419, null);
    ((TextView)localView.findViewById(2131297821)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131372243));
    localView.findViewById(2131298527).setVisibility(8);
    return localView;
  }
  
  private void c(View paramView)
  {
    if ((this.f != null) && ("1600000104".equals(this.f.trim())))
    {
      paramView.findViewById(2131298554).setVisibility(8);
      paramView.findViewById(2131298557).setVisibility(0);
      return;
    }
    paramView.findViewById(2131298557).setVisibility(8);
    paramView.findViewById(2131298554).setVisibility(0);
  }
  
  private void c(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.arg1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateNetNeedSignOn return, msg == null || msg.arg1==HIDE");
      }
      return;
    }
    if ((paramMessage != null) && ((paramMessage.obj instanceof String))) {}
    for (paramMessage = String.valueOf(paramMessage.obj);; paramMessage = "http://qq.com")
    {
      paramView = paramView.findViewById(2131298527);
      if (paramView.getVisibility() != 0) {
        paramView.setVisibility(0);
      }
      paramView.setOnClickListener(new owl(this, paramMessage));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false);
  }
  
  private View d()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903412, null);
    localView.setOnClickListener(new owm(this, localView));
    localView.findViewById(2131298481).setVisibility(8);
    return localView;
  }
  
  private void d(View paramView)
  {
    paramView.findViewById(2131297823).setVisibility(0);
    if (this.jdField_d_of_type_Boolean)
    {
      TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_g_of_type_JavaLangString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "P_CliOper", "Grp_msg", "", "Msglist", "exp_setmsg", 0, 0, "", "", "", "");
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void d(View paramView, Message paramMessage)
  {
    paramMessage = (TextView)paramView.findViewById(2131305330);
    WifiConversationManager localWifiConversationManager = WifiConversationManager.a();
    String str1 = localWifiConversationManager.b();
    String str2 = localWifiConversationManager.a();
    String str3 = localWifiConversationManager.c();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (localWifiConversationManager.a() == null))
    {
      a(3, 0);
      return;
    }
    int i1 = localWifiConversationManager.a().ConnStatus;
    int i2 = localWifiConversationManager.a().ConnErrorCode;
    if ((i1 != 2) && (i1 != 7))
    {
      a(3, 0);
      return;
    }
    paramMessage.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366381), new Object[] { str1 }));
    paramView.setOnClickListener(new owo(this, str3, localWifiConversationManager.a()));
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), true);
  }
  
  private View e()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904960, null);
    ((TextView)localView.findViewById(2131304892)).setText(this.jdField_d_of_type_JavaLangString);
    localView.setOnClickListener(new own(this));
    localView.findViewById(2131304891).setVisibility(8);
    return localView;
  }
  
  private void e(View paramView)
  {
    if (QQPlayerService.a())
    {
      paramView.findViewById(2131298481).setVisibility(0);
      paramView = (TextView)paramView.findViewById(2131298483);
      SongInfo localSongInfo = QQPlayerService.a();
      if (localSongInfo != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370595);
        paramView.setText(Html.fromHtml(str + " " + localSongInfo.jdField_b_of_type_JavaLangString));
      }
      return;
    }
    paramView.findViewById(2131298481).setVisibility(8);
    a(20, 0);
    a(-1, null);
  }
  
  private void e(View paramView, Message paramMessage)
  {
    View localView = paramView.findViewById(2131301212);
    paramMessage = (TextView)paramView.findViewById(2131301213);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
      if (i1 != 0)
      {
        localView.setVisibility(0);
        int i2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a().mMode;
        paramView = "传输";
        if (1 == i2) {
          paramView = "发送";
        }
        for (;;)
        {
          paramMessage.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366257) + paramView + String.valueOf(i1) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366258));
          return;
          if (2 == i2) {
            paramView = "接收";
          }
        }
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private View f()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904055, null);
    localView.setOnClickListener(new owp(this));
    localView.findViewById(2131301212).setVisibility(8);
    return localView;
  }
  
  private void f(View paramView)
  {
    paramView.findViewById(2131298830).setVisibility(0);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131298829);
    paramView = (ADView)paramView.findViewById(2131298831);
    if (b())
    {
      localRelativeLayout.setPadding(0, 0, 0, 0);
      paramView.h();
      return;
    }
    localRelativeLayout.setPadding(0, -1, 0, 0);
  }
  
  private void f(View paramView, Message paramMessage)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131301056);
    if (paramMessage != null)
    {
      if (paramMessage.arg1 != 1) {
        break label42;
      }
      localTextView.setText(2131362177);
    }
    for (;;)
    {
      paramView.findViewById(2131301055).setVisibility(0);
      return;
      label42:
      if (paramMessage.arg1 == 2) {
        localTextView.setText(2131362176);
      }
    }
  }
  
  private View g()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903419, null);
    ((TextView)localView.findViewById(2131297821)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370153));
    localView.setOnClickListener(new owq(this));
    localView.findViewById(2131298527).setVisibility(8);
    return localView;
  }
  
  private void g(View paramView)
  {
    paramView.findViewById(2131301444).setVisibility(0);
  }
  
  private void g(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 8)) {
      if ((paramMessage.obj instanceof VipBannerInfo))
      {
        paramMessage = (VipBannerInfo)paramMessage.obj;
        localObject2 = paramMessage.jdField_b_of_type_JavaLangString;
        localObject1 = (TextView)paramView.findViewById(2131303361);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        if ((paramMessage.jdField_e_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramMessage.jdField_e_of_type_JavaLangString)))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().getResources().getDrawable(2130841856);
          localObject2 = URLDrawable.getDrawable(paramMessage.jdField_e_of_type_JavaLangString, (Drawable)localObject2, (Drawable)localObject2);
          if (localObject2 != null)
          {
            ((Drawable)localObject2).setBounds(0, 0, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 22.0F));
            ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
        }
        localObject1 = (Button)paramView.findViewById(2131303362);
        if ((paramMessage.f != null) && (!TextUtils.isEmpty(paramMessage.f))) {
          ((Button)localObject1).setText(paramMessage.f);
        }
        localObject2 = paramMessage.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
        localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35);
        if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (localObject2 != null) && (localRedTouchManager != null))
        {
          ((Button)localObject1).setOnClickListener(new ovn(this, localRedTouchManager, paramMessage, (BusinessInfoCheckUpdate.AppInfo)localObject2));
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(9, paramMessage.jdField_b_of_type_Long);
          localRedTouchManager.a((BusinessInfoCheckUpdate.AppInfo)localObject2, paramMessage.jdField_a_of_type_JavaLangString);
          paramView.setVisibility(0);
        }
      }
    }
    while (paramView.getVisibility() != 8)
    {
      Object localObject2;
      Object localObject1;
      RedTouchManager localRedTouchManager;
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(9);
  }
  
  private View h()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903419, null);
    ((TextView)localView.findViewById(2131297821)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367482));
    localView.findViewById(2131298527).setVisibility(8);
    return localView;
  }
  
  private void h(View paramView)
  {
    paramView.findViewById(2131303000).setVisibility(0);
    ((TextView)paramView.findViewById(2131303001)).setText("当前有免费的QQ WiFi，点击连接");
  }
  
  private void h(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1134027)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReaderBar", 2, "updateReaderBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ReaderBar", 2, "updateReaderBar msg.obj = " + paramMessage.obj);
        }
        localTextView = (TextView)paramView.findViewById(2131297047);
      } while ((!(paramMessage.obj instanceof String)) || (localTextView == null));
      paramMessage = ((String)paramMessage.obj).split("@#");
    } while (paramMessage.length != 2);
    String str = paramMessage[0];
    long l1 = Long.parseLong(paramMessage[1]);
    localTextView.setText("正在阅读《" + str + "》");
    paramView.setOnClickListener(new ovt(this, l1));
    paramView.findViewById(2131297037).setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(13, 900000L);
  }
  
  private View i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initMissedCallBar");
    }
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904084, null);
    ((TextView)localView.findViewById(2131301306)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131371140));
    localView.setOnClickListener(new ovl(this));
    localView.findViewById(2131301305).setVisibility(8);
    return localView;
  }
  
  private void i(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || ((paramMessage.what != 1134041) && (paramMessage.what != 1134042))) {
      if (QLog.isColorLevel()) {
        QLog.d("BrowserBar", 2, "updateBrowserBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BrowserBar", 2, "updateBrowserBar msg.obj = " + paramMessage.obj);
        }
        if (paramMessage.what == 1134042)
        {
          paramView.setVisibility(8);
          return;
        }
        localTextView = (TextView)paramView.findViewById(2131297036);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      paramMessage = (Bundle)paramMessage.obj;
      str = (String)paramMessage.getCharSequence("tips");
      int i1 = paramMessage.getInt("icon");
      if (i1 != -1) {
        ((ImageView)paramView.findViewById(2131297034)).setImageResource(i1);
      }
    } while (TextUtils.isEmpty(str));
    localTextView.setText(str);
    paramView.setOnClickListener(new ovu(this, paramMessage));
    paramView.findViewById(2131297033).setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(15);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(15, paramMessage.getInt("timeout", 120000));
  }
  
  private View j()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904618, null);
    localView.setVisibility(8);
    return localView;
  }
  
  private void j()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
    long l1 = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 0);
    localCalendar.clear(12);
    localCalendar.clear(13);
    localCalendar.clear(14);
    l1 = localCalendar.getTimeInMillis() - (l1 - 10L) + 300000L;
    if (QLog.isColorLevel()) {
      QLog.d("PushBanner", 2, "Check banner delay: " + l1);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(101, l1);
  }
  
  private void j(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 1134039)) {
      if (QLog.isColorLevel()) {
        QLog.d("ComicBar", 2, "updateComicBar msg " + paramMessage);
      }
    }
    TextView localTextView;
    String str;
    int i2;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ComicBar", 2, "updateComicBar msg.obj = " + paramMessage.obj);
        }
        localTextView = (TextView)paramView.findViewById(2131297040);
      } while ((!(paramMessage.obj instanceof Bundle)) || (localTextView == null));
      localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("comicName");
      str = ((Bundle)localObject).getString("comicId");
      i2 = ((Bundle)localObject).getInt("type", -1);
    } while (TextUtils.isEmpty(paramMessage));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    int i3 = (int)(localTextView.getPaint().measureText(paramMessage) / paramMessage.length());
    int i1;
    if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels)
    {
      i1 = ((DisplayMetrics)localObject).heightPixels;
      i1 = (int)((i1 - ((DisplayMetrics)localObject).density * 65.0F) / i3) - 8;
      if (paramMessage.length() <= i1) {
        break label399;
      }
      paramMessage = paramMessage.substring(0, i1) + "...";
    }
    label399:
    for (;;)
    {
      if ((i2 >= 100) && (i2 <= 300)) {
        localTextView.setText("正在观看《" + paramMessage + "》");
      }
      for (;;)
      {
        paramView.setOnClickListener(new ovw(this, str));
        paramView.findViewById(2131297037).setVisibility(0);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(14);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(14, 900000L);
        return;
        i1 = ((DisplayMetrics)localObject).widthPixels;
        break;
        localTextView.setText("正在阅读《" + paramMessage + "》");
      }
    }
  }
  
  private View k()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904032, null);
    localView.findViewById(2131301056).setOnClickListener(new ovm(this));
    localView.findViewById(2131301055).setVisibility(8);
    return localView;
  }
  
  private void k()
  {
    a(12, 0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener != null)
    {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(10)).b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = null;
    }
  }
  
  private void k(View paramView, Message paramMessage)
  {
    paramView.findViewById(2131305252).setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131305253);
    if (paramMessage != null)
    {
      if (!ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app))
      {
        paramMessage = "新版本QQ ";
        UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
        paramView = paramMessage;
        if (localUpgradeDetailWrapper != null)
        {
          paramView = paramMessage;
          if (localUpgradeDetailWrapper.a != null)
          {
            paramView = paramMessage;
            if (localUpgradeDetailWrapper.a.jdField_a_of_type_JavaLangString != null) {
              paramView = localUpgradeDetailWrapper.a.jdField_a_of_type_JavaLangString + " ";
            }
          }
        }
        localTextView.setText(String.format("已下载%s,点击安装", new Object[] { paramView }));
      }
    }
    else {
      return;
    }
    localTextView.setText("已通过Wi-Fi下载手机新版本，点击安装");
  }
  
  private View l()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130905089, null);
    TextView localTextView = (TextView)localView.findViewById(2131305253);
    localTextView.setOnClickListener(new ovo(this));
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368063));
    ((ImageView)localView.findViewById(2131305254)).setOnClickListener(new ovp(this));
    localView.findViewById(2131305252).setVisibility(8);
    return localView;
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    int i1;
    for (;;)
    {
      return;
      i1 = 0;
      while (i1 < 3)
      {
        localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
        if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
          break label45;
        }
        i1 += 1;
      }
    }
    label45:
    Object localObject = ((ArrayList)localObject).iterator();
    label50:
    Banner localBanner;
    while (((Iterator)localObject).hasNext())
    {
      int i2 = ((Integer)((Iterator)localObject).next()).intValue();
      localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i2];
      if ((localBanner != null) && (localBanner.jdField_a_of_type_AndroidViewView != null) && (localBanner.jdField_a_of_type_Boolean))
      {
        if (i1 == 1) {
          break label136;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.a(localBanner.jdField_a_of_type_AndroidViewView);
      }
    }
    for (;;)
    {
      localBanner.jdField_a_of_type_Boolean = false;
      if (localBanner.a()) {
        break label50;
      }
      localBanner.jdField_a_of_type_AndroidViewView = null;
      break label50;
      break;
      label136:
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentPollBanner.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentPollBanner.b();
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentPollBanner.a());
      }
    }
  }
  
  private void l(View paramView, Message paramMessage)
  {
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    }
    View localView;
    TextView localTextView;
    ImageView localImageView;
    long l1;
    int i1;
    Object localObject;
    int i2;
    boolean bool;
    while ((localQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
    {
      localView = paramView.findViewById(2131298475);
      localTextView = (TextView)paramView.findViewById(2131298477);
      localImageView = (ImageView)paramView.findViewById(2131298476);
      if ((paramMessage != null) && (paramMessage.obj != null))
      {
        l1 = ((Long)paramMessage.obj).longValue();
        i1 = localQQAppInterface.a().b(l1);
        localObject = (LinearLayout)paramView.findViewById(2131298479);
        if (i1 != 2) {
          break label560;
        }
        paramMessage = localQQAppInterface.a().a(l1);
        ((LinearLayout)localObject).setVisibility(0);
        localObject = new ImageView[3];
        localObject[0] = ((ImageView)paramView.findViewById(2131296984));
        localObject[1] = ((ImageView)paramView.findViewById(2131296985));
        localObject[2] = ((ImageView)paramView.findViewById(2131296986));
        if ((paramMessage == null) || (paramMessage.size() == 0))
        {
          i2 = localObject.length;
          i1 = 0;
        }
        for (;;)
        {
          if (i1 < i2)
          {
            localObject[i1].setVisibility(8);
            i1 += 1;
            continue;
            localQQAppInterface = null;
            break;
            if (paramMessage.size() != 1) {
              break label415;
            }
            localObject[0].setVisibility(0);
            localObject[1].setVisibility(8);
            localObject[2].setVisibility(8);
            localObject[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(0)).a), localQQAppInterface));
          }
        }
      }
      i1 = localQQAppInterface.a().g();
      i2 = localQQAppInterface.a().b();
      l1 = localQQAppInterface.a().b();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateMultiVideoBar randomstatus:" + i2 + ", session:" + i1);
      }
      if (localQQAppInterface.a().i() != 2) {
        break label569;
      }
      bool = true;
    }
    for (;;)
    {
      if (l1 > 0L)
      {
        i2 = localQQAppInterface.a().d();
        if (i2 < 2)
        {
          localTextView.setText(2131368028);
          SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
          return;
          label415:
          if (paramMessage.size() == 2)
          {
            localObject[0].setVisibility(0);
            localObject[1].setVisibility(0);
            localObject[2].setVisibility(8);
            localObject[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(0)).a), localQQAppInterface));
            localObject[1].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(1)).a), localQQAppInterface));
            break;
          }
          i1 = 0;
          while (i1 < localObject.length)
          {
            localObject[i1].setVisibility(0);
            localObject[i1].setImageBitmap(a(String.valueOf(((AVNotifyCenter.UserInfo)paramMessage.get(i1)).a), localQQAppInterface));
            i1 += 1;
          }
          break;
          label560:
          ((LinearLayout)localObject).setVisibility(0);
          break;
          label569:
          bool = false;
          continue;
        }
        paramView = localQQAppInterface.a().b();
        if ((paramView != null) && (paramView.equals("1")))
        {
          i1 = 1;
          label600:
          if (i1 == 0) {
            break label683;
          }
        }
        label683:
        for (i1 = 2131363815;; i1 = 2131363811)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i1);
          paramMessage = localQQAppInterface.a().h();
          paramView = String.format(paramView, new Object[] { Integer.valueOf(i2) });
          localTextView.setText(paramView + " " + paramMessage);
          break;
          i1 = 0;
          break label600;
        }
      }
    }
    if (i2 == 6)
    {
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363812));
      SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      return;
    }
    if (i2 >= 5)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363811);
      paramView = paramView + " ";
      localTextView.setText(paramView + localQQAppInterface.a().h());
      SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      return;
    }
    if ((i2 >= 1) && (i2 < 5))
    {
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363817));
      SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      return;
    }
    label950:
    label1006:
    int i3;
    if (i1 == 3)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b(l1);
      i2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().h();
      if (localQQAppInterface.a().e())
      {
        localTextView.setText(2131368028);
        if ((i1 == 2) && (!localQQAppInterface.a().a(String.valueOf(l1)))) {
          localImageView.setImageDrawable(null);
        }
        if (i2 == 1)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363386);
          paramView = paramMessage;
          if (i1 == 2) {
            paramView = paramMessage.replace(localQQAppInterface.a().getString(2131368098), localQQAppInterface.a().getString(2131368099));
          }
          UITools.a(localView, paramView);
          SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
        }
      }
      else
      {
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
        i3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a();
        localObject = localQQAppInterface.a().h();
        if (i2 == 3000)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368026);
          paramView = paramMessage;
          if (i1 == 2) {
            paramView = paramMessage.replace(localQQAppInterface.a().getString(2131368098), localQQAppInterface.a().getString(2131368099));
          }
        }
      }
    }
    label1642:
    for (;;)
    {
      l1 = localQQAppInterface.a().a(i3, l1);
      if ((localView != null) && (l1 == 0L))
      {
        SmallScreenUtils.a(localView, false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
        return;
        if (i2 == 1)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368027);
          if (i1 != 2) {
            break label1642;
          }
          paramView = paramView.replace(localQQAppInterface.a().getString(2131368098), localQQAppInterface.a().getString(2131368099));
          localImageView.setImageDrawable(null);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.recent.banner", 2, "updateMultiVideoBar-->wrong type of UinType.uintype=" + i2);
        return;
      }
      if (localView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.recent.banner", 2, "updateMultiVideoBar-->multiVideoBar is null");
        return;
      }
      paramView = String.format(paramView, new Object[] { Long.valueOf(l1) });
      localTextView.setText(paramView + " " + (String)localObject);
      break label950;
      if (i2 != 3000) {
        break label1006;
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363385);
      paramView = paramMessage;
      if (i1 == 2) {
        paramView = paramMessage.replace(localQQAppInterface.a().getString(2131368098), localQQAppInterface.a().getString(2131368099));
      }
      UITools.a(localView, paramView);
      break label1006;
      if (i1 == 1)
      {
        if (localQQAppInterface.a().e()) {
          localTextView.setText(2131363572);
        }
        for (;;)
        {
          UITools.a(localView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363373));
          SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
          return;
          paramView = localQQAppInterface.a().h();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363572);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      if (i1 == 5)
      {
        localTextView.setText(2131364013);
        UITools.a(localView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364014));
        SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
        return;
      }
      if (i1 == 2)
      {
        if (localQQAppInterface.a().e()) {
          localTextView.setText(2131363573);
        }
        for (;;)
        {
          UITools.a(localView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363373));
          SmallScreenUtils.a(localView, bool, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
          return;
          paramView = localQQAppInterface.a().h();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131363573);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      SmallScreenUtils.a(localView, false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      return;
    }
  }
  
  private View m()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903427, null);
    View localView2 = localView1.findViewById(2131298555);
    View localView3 = localView1.findViewById(2131298556);
    localView1.findViewById(2131298558);
    View localView4 = localView1.findViewById(2131298559);
    ovq localovq = new ovq(this);
    localView2.setOnClickListener(localovq);
    localView3.setOnClickListener(localovq);
    localView4.setOnClickListener(localovq);
    localView1.findViewById(2131298554).setVisibility(8);
    localView1.findViewById(2131298557).setVisibility(8);
    return localView1;
  }
  
  private View n()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903230, null);
    View localView2 = localView1.findViewById(2131297823);
    localView1.setOnClickListener(new ovr(this));
    localView2.setVisibility(8);
    return localView1;
  }
  
  private View o()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903412, null);
    localView.setOnClickListener(new ovs(this));
    localView.findViewById(2131298481).setVisibility(8);
    return localView;
  }
  
  private View p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReaderBar", 2, "initReaderBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903092, null);
    localView.findViewById(2131297037).setVisibility(8);
    return localView;
  }
  
  private View q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BrowserBar", 2, "initBrowserBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903089, null);
    localView.findViewById(2131297033).setVisibility(8);
    return localView;
  }
  
  private View r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComicBar", 2, "initComicBar");
    }
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903090, null);
    localView.findViewById(2131297037).setVisibility(8);
    return localView;
  }
  
  private View s()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130905089, null);
    TextView localTextView = (TextView)localView.findViewById(2131305253);
    localTextView.setOnClickListener(new ovx(this));
    localTextView.setText("");
    if (AppSetting.j) {
      localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368072));
    }
    ((ImageView)localView.findViewById(2131305254)).setOnClickListener(new ovy(this));
    localView.findViewById(2131305252).setVisibility(8);
    return localView;
  }
  
  private View t()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903411, null);
    localView.setOnClickListener(new ovz(this));
    localView.findViewById(2131298475).setVisibility(8);
    return localView;
  }
  
  private View u()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903229, null);
    localView.setOnClickListener(new owa(this));
    return localView;
  }
  
  private View v()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903500, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localView.findViewById(2131298830).setVisibility(8);
    ((LinearLayout)localView.findViewById(2131296906)).setOnClickListener(new owc(this));
    return localView;
  }
  
  private View w()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130904112, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    localView.setOnClickListener(new owe(this));
    return localView;
  }
  
  private View x()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904513, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131303002);
    localView.setOnClickListener(new owf(this));
    localImageView.setOnClickListener(new owg(this));
    return localView;
  }
  
  public int a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return ((Banner)localObject1).e;
  }
  
  public int a(SparseArray paramSparseArray, int paramInt)
  {
    int i3 = 0;
    int i2 = 0;
    int i1;
    if (paramSparseArray == null) {
      i1 = i2;
    }
    do
    {
      do
      {
        return i1;
        paramSparseArray = (ArrayList)paramSparseArray.get(paramInt);
        i1 = i2;
      } while (paramSparseArray == null);
      i1 = i2;
    } while (paramSparseArray.size() <= 0);
    paramSparseArray = paramSparseArray.iterator();
    for (paramInt = i3;; paramInt = ((Integer)paramSparseArray.next()).intValue() + paramInt)
    {
      i1 = paramInt;
      if (!paramSparseArray.hasNext()) {
        break;
      }
    }
  }
  
  protected Bitmap a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a(1, paramString, (byte)2, true, 0);
    paramString = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      paramString = ImageUtil.a();
    }
    return paramString;
  }
  
  public View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904085, null);
    localView.findViewById(2131301307).setVisibility(8);
    return localView;
  }
  
  public MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().b() <= 0) {
        break label34;
      }
      a(24, 2);
    }
    label34:
    int i1;
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.d()) {
        break;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().g();
      if (i1 == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a() > 0L)
        {
          a(24, 2);
          return;
        }
        a(24, 0);
        return;
      }
      if (i1 == 1)
      {
        a(24, 2);
        return;
      }
      if (i1 == 2)
      {
        a(24, 2);
        return;
      }
    } while (i1 != 5);
    a(24, 2);
    return;
    a(24, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 1) && (paramInt1 <= 26))
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1] == null) {
        break label31;
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1].e = paramInt2;
    }
    label31:
    while ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1] != null) || (!Banner.a(paramInt2))) {
      return;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1] = new Banner(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (paramLong > 0L)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, paramLong);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(int paramInt, Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent.banner", 4, "refreshBanner");
    }
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(3);
    }
    int i1 = 0;
    Object localObject1;
    if (i1 < 3)
    {
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList(1);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, localObject1);
      }
      for (;;)
      {
        i1 += 1;
        break;
        ((ArrayList)localObject1).clear();
      }
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    }
    i1 = 1;
    for (;;)
    {
      if (i1 <= 19)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1] == null) || (!this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1].a())) {
          break label248;
        }
        localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(0);
        if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
          ((ArrayList)localObject1).add(Integer.valueOf(i1));
        }
      }
      i1 = 20;
      while (i1 <= 23)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1].a()))
        {
          localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(1);
          if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
            ((ArrayList)localObject1).add(Integer.valueOf(i1));
          }
        }
        i1 += 1;
      }
      label248:
      i1 += 1;
    }
    i1 = 24;
    if (i1 <= 26)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1] == null) || (!this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1].a())) {
        break label406;
      }
      localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(2);
      if (localObject1 != null) {
        ((ArrayList)localObject1).add(Integer.valueOf(i1));
      }
    }
    a(this.jdField_b_of_type_AndroidUtilSparseArray);
    int i4 = 0;
    i1 = 1;
    int i3 = 0;
    int i2 = 0;
    label337:
    int i5;
    int i6;
    if (i4 < 3)
    {
      i5 = a(this.jdField_b_of_type_AndroidUtilSparseArray, i4);
      i6 = a(this.jdField_a_of_type_AndroidUtilSparseArray, i4);
      if (1 == i4) {
        if (i5 != i6) {
          i1 = 0;
        }
      }
    }
    label406:
    Object localObject2;
    label658:
    label666:
    label976:
    for (;;)
    {
      i4 += 1;
      i3 += i6;
      i2 += i5;
      break label337;
      i1 += 1;
      break;
      localObject2 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(1);
      localObject1 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
      if (localObject2 == null) {}
      for (;;)
      {
        return;
        localObject2 = ((ArrayList)localObject2).iterator();
        Integer localInteger;
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localInteger = (Integer)((Iterator)localObject2).next();
        } while ((localObject1 == null) || (((ArrayList)localObject1).contains(localInteger)));
        i1 = 0;
        break;
        if (i5 == i6) {
          break label976;
        }
        i1 = 0;
        break;
        if ((i2 != 0) || (i3 != 0))
        {
          if ((i2 == 0) && (i3 != 0))
          {
            l();
            return;
          }
          i5 = a(this.jdField_b_of_type_AndroidUtilSparseArray, 1) - a(this.jdField_a_of_type_AndroidUtilSparseArray, 1);
          if (i1 == 0)
          {
            l();
            i1 = 0;
            while (i1 < 3)
            {
              localObject1 = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
              if (localObject1 != null) {
                this.jdField_a_of_type_AndroidUtilSparseArray.put(i1, (ArrayList)((ArrayList)localObject1).clone());
              }
              i1 += 1;
            }
          }
          i4 = 0;
          while (i4 < 3)
          {
            localObject1 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i4);
            if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
              break label658;
            }
            i4 += 1;
          }
        }
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      i1 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        i2 = ((Integer)((Iterator)localObject1).next()).intValue();
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i2];
        if (localObject2 != null)
        {
          a((Banner)localObject2);
          i3 = i1;
          i2 = i1;
        }
      }
      for (;;)
      {
        try
        {
          if (((Banner)localObject2).jdField_a_of_type_AndroidViewView != null)
          {
            i3 = i1;
            i2 = i1;
            if (!((Banner)localObject2).jdField_a_of_type_Boolean)
            {
              if (i4 == 1) {
                continue;
              }
              i2 = i1;
              this.jdField_a_of_type_ComTencentWidgetXListView.a(((Banner)localObject2).jdField_a_of_type_AndroidViewView);
              i2 = i1;
              ((Banner)localObject2).jdField_a_of_type_Boolean = true;
              i3 = i1;
            }
          }
          i1 = i3;
        }
        catch (Exception localException)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("Q.recent.banner", 4, "initBanner|" + localException.toString());
          i1 = i2;
          continue;
          if (i1 != 0) {
            continue;
          }
          boolean bool = true;
          i3 = 1;
          continue;
          if (paramInt != ((Banner)localObject2).d) {
            continue;
          }
          a((Banner)localObject2, paramMessage);
          continue;
          bool = false;
          i3 = i1;
          continue;
        }
        if ((paramMessage != null) && (paramInt == ((Banner)localObject2).d)) {
          continue;
        }
        a((Banner)localObject2, null);
        break label666;
        break;
        if (i5 <= 0) {
          continue;
        }
        i2 = i1;
        if (((Banner)localObject2).d != i5) {
          continue;
        }
        bool = true;
        i3 = i1;
        i2 = i3;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentPollBanner.a((Banner)localObject2, bool);
        i1 = i3;
        i2 = i3;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentPollBanner.b())
        {
          i2 = i3;
          this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentPollBanner.a());
          i1 = i3;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((a(13)) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (this.jdField_g_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_g_of_type_JavaLangString = "";
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[12] != null) {
      a(12, 0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    if (paramBoolean)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(10);
      int i1;
      if (localPhoneContactManagerImp != null)
      {
        i1 = localPhoneContactManagerImp.c();
        if (i1 == 0) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11, 1000L);
        }
      }
      else
      {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener == null) && (!this.c))
      {
        this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = new ovk(this);
        localPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
      }
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), 0).getBoolean("key_show_contact_banner", true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "checkContactBanner, state = " + i1 + ", isFirstShow = " + paramBoolean);
      }
      if ((i1 == 1) && (paramBoolean))
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[12] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[12].e != 2)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
        }
        a(12, 2);
        return;
      }
      a(12, 0);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(11, 1000L);
  }
  
  public boolean a()
  {
    boolean bool1 = true;
    boolean bool2 = c();
    if ((this.jdField_b_of_type_Boolean) && (!bool2)) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "isNeedShowPushBanner, isNeedShow = " + bool1);
      }
      return bool1;
      if (d())
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[16] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[16] = new Banner(16, 0);
        }
        a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[16]);
        View localView = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[16].jdField_a_of_type_AndroidViewView;
        if (localView != null) {}
        for (bool1 = a(localView);; bool1 = false)
        {
          if (bool1)
          {
            localView.findViewById(2131298830).setVisibility(0);
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getAccount(), false).commit();
          }
          break;
        }
      }
      bool1 = false;
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt];
      }
    }
    return (localObject1 != null) && (((Banner)localObject1).a());
  }
  
  public void b()
  {
    if (a(8))
    {
      a(8, 0);
      this.jdField_e_of_type_JavaLangString = null;
      a(-1, null);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[16];
    ViewGroup localViewGroup;
    int i2;
    int i1;
    if ((localObject != null) && (((Banner)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      localObject = (ADView)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131298831);
      localViewGroup = ((ADView)localObject).a(0);
      if (localViewGroup != null)
      {
        i2 = localViewGroup.getChildCount();
        i1 = 0;
        i2 -= 1;
        if (i2 >= 0)
        {
          View localView = localViewGroup.getChildAt(i2);
          PushBanner localPushBanner = (PushBanner)localView.getTag();
          String str = localPushBanner.c;
          int i3 = str.indexOf("|");
          if (CommonUtil.a(Long.parseLong(str.substring(0, i3)), Long.parseLong(str.substring(i3 + 1)))) {
            break label290;
          }
          ((ADView)localObject).a(0, i2, localView);
          Config.a.b(localPushBanner.l);
          i1 = 1;
        }
      }
    }
    label290:
    for (;;)
    {
      i2 -= 1;
      break;
      if (i1 != 0)
      {
        if (localViewGroup.getChildCount() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().getAccount(), false).commit();
          ((ADView)localObject).g();
          a(16, 0);
          a(-1, null);
          this.jdField_b_of_type_Boolean = false;
        }
        for (;;)
        {
          localObject = new ConfigManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ConfigServlet.h);
          if (localObject != null)
          {
            ((ConfigManager)localObject).b();
            ((ConfigManager)localObject).c();
          }
          return;
          j();
        }
      }
      j();
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(101);
    a(9, 0);
    a(11, 0);
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[16];
    if ((localObject != null) && (((Banner)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131298829);
      localObject = (ADView)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131298831);
      if (localObject != null)
      {
        ((ADView)localObject).i();
        ((ADView)localObject).g();
      }
      if (localRelativeLayout != null) {
        localRelativeLayout.setPadding(0, -1, 0, 0);
      }
    }
    this.jdField_b_of_type_Boolean = false;
    b();
    a(13, 0);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangString = "";
    a(5, 0);
    a(14, 0);
    a(18, 0);
    a(4, 0);
    a();
    h();
    a(-1, null);
    a(false);
  }
  
  public void e()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDestroy");
      }
      this.c = true;
      if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener != null)
      {
        ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(10)).b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
        this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = null;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.recent.banner", 2, "onDestroy", localException);
    }
  }
  
  public void f()
  {
    k();
  }
  
  public void g()
  {
    int i4 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "checkIsShowTroopTip");
    }
    QQAppInterface localQQAppInterface;
    List localList;
    int i1;
    label77:
    int i2;
    label80:
    int i3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      if ((localQQAppInterface != null) && ((TroopAssistantManager.a().c(localQQAppInterface, this.jdField_g_of_type_JavaLangString)) || (this.jdField_e_of_type_Boolean)))
      {
        localList = localQQAppInterface.a().a().a(false);
        if (localList != null) {
          break label133;
        }
        i1 = 0;
        i2 = 0;
        i3 = i4;
        if (i2 >= i1) {
          break label153;
        }
        if (((RecentUser)localList.get(i2)).type != 5000) {
          break label144;
        }
        if (this.jdField_e_of_type_Boolean) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        }
      }
    }
    label133:
    label144:
    label153:
    do
    {
      return;
      localQQAppInterface = null;
      break;
      i1 = localList.size();
      break label77;
      i2 += 1;
      break label80;
      if (i3 < i1)
      {
        RecentUser localRecentUser = (RecentUser)localList.get(i3);
        if (localRecentUser.type != 1) {}
        do
        {
          do
          {
            i3 += 1;
            break;
          } while ((TextUtils.isEmpty(localRecentUser.uin)) || (TroopAssistantManager.a().b(localQQAppInterface, localRecentUser.uin)) || (TroopAssistantManager.a().a(localQQAppInterface, localRecentUser.uin) != 1));
          if (localQQAppInterface.a().a(localRecentUser.uin, localRecentUser.type) > 99)
          {
            if ((this.jdField_e_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (this.jdField_g_of_type_JavaLangString.equals(localRecentUser.uin))) {
              break;
            }
            this.jdField_g_of_type_JavaLangString = localRecentUser.uin;
            if ((!this.jdField_d_of_type_Boolean) || (!TroopAssistantManager.a().c(localQQAppInterface, this.jdField_g_of_type_JavaLangString))) {
              break;
            }
            return;
          }
        } while ((TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) || (!this.jdField_g_of_type_JavaLangString.equals(localRecentUser.uin)));
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        return;
      }
    } while ((!this.jdField_e_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)));
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    boolean bool;
    do
    {
      return;
      bool = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.m;
      if (!bool) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.recent.banner", 2, "checkShowMissedCall, isShowMissedCallBanner=" + bool);
    return;
    ThreadManager.a(new owk(this), 8, null, false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 0: 
    default: 
    case 1: 
    case 4: 
    case 6: 
    case 7: 
    case 12: 
    case 8: 
    case 9: 
    case 101: 
      do
      {
        return true;
        a(13, 0);
        this.jdField_g_of_type_JavaLangString = "";
        a(13, paramMessage);
        return true;
        a(14, 0);
        a(14, paramMessage);
        return true;
        a(2, 2);
        a(2, paramMessage);
        return true;
        a(2, 0);
        a(2, paramMessage);
        return true;
        a(19, 0);
        a(19, paramMessage);
        return true;
        a(18, 2);
        a(18, paramMessage);
        return true;
        a(18, 0);
        a(18, paramMessage);
        return true;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("PushBanner", 2, "checkAndClosePushBanner");
          }
          c();
          return true;
        }
        catch (Exception paramMessage) {}
      } while (!QLog.isColorLevel());
      QLog.d("PushBanner", 2, "checkAndClosePushBanner Exception:", paramMessage);
      return true;
    case 11: 
      a(true);
      return true;
    case 13: 
      a(21, 0);
      a(21, paramMessage);
      return true;
    case 14: 
      a(22, 0);
      a(22, paramMessage);
      return true;
    }
    a(23, 0);
    a(23, paramMessage);
    return true;
  }
  
  public void i()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(7, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\BannerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */