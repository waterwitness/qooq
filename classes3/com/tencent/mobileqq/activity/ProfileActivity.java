package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.io.File;

public abstract class ProfileActivity
  extends BaseActivity
  implements AppConstants
{
  public static final int A = 1011;
  public static final String A = "profile_extres";
  public static final int B = 1012;
  public static final int C = 1013;
  public static final int D = 1014;
  public static final int E = 1015;
  public static final int F = 1016;
  public static final int G = 1017;
  public static final int H = 1018;
  public static final int I = 1019;
  public static final int J = 1020;
  public static final int K = 1021;
  public static final int L = 1022;
  public static final int M = 1023;
  public static final int N = 1019;
  public static final int O = 0;
  public static final int P = 1;
  public static final int Q = 2;
  public static final int R = 3;
  public static final int S = 4;
  public static final int T = 5;
  public static final int U = 19;
  public static final int V = 20;
  public static final int W = 21;
  public static final int X = 22;
  public static final int Y = 23;
  public static final int Z = 24;
  private static final int a = 22578;
  public static final int[][] a;
  public static final int aA = 61;
  public static final int aB = 70;
  public static final int aC = 71;
  public static final int aD = 72;
  public static final int aE = 73;
  public static final int aF = 74;
  public static final int aG = 75;
  public static final int aH = 75;
  public static final int aI = 76;
  public static final int aJ = 77;
  public static final int aK = 78;
  public static final int aL = 79;
  public static final int aM = 80;
  public static final int aN = 81;
  public static final int aO = 82;
  public static final int aP = 83;
  public static final int aQ = 84;
  public static final int aR = 7;
  public static final int aS = 800;
  public static final int aT = 880;
  public static final int aU = 881;
  public static final int aV = 1;
  public static final int aW = 2;
  public static final int aX = 3;
  public static final int aY = 4;
  public static final int aZ = 1;
  public static final int aa = 25;
  public static final int ab = 26;
  public static final int ac = 27;
  public static final int ad = 28;
  public static final int ae = 30;
  public static final int af = 31;
  public static final int ag = 32;
  public static final int ah = 33;
  public static final int ai = 34;
  public static final int aj = 35;
  public static final int ak = 36;
  public static final int al = 37;
  public static final int am = 40;
  public static final int an = 41;
  public static final int ao = 42;
  public static final int ap = 45;
  public static final int aq = 46;
  public static final int ar = 47;
  public static final int as = 50;
  public static final int at = 51;
  public static final int au = 52;
  public static final int av = 55;
  public static final int aw = 56;
  public static final int ax = 57;
  public static final int ay = 58;
  public static final int az = 60;
  public static final int bA = 57;
  public static final int bB = 59;
  public static final int bC = 60;
  public static final int bD = 61;
  public static final int bE = 64;
  public static final int bF = 65;
  public static final int bG = 66;
  public static final int bH = 67;
  public static final int bI = 68;
  public static final int bJ = 84;
  public static final int bK = 87;
  public static final int bL = 88;
  public static final int bM = 98;
  public static final int bN = 99;
  public static final int bO = 100;
  public static final int bP = 999;
  public static final int bQ = 1;
  public static final int bR = 2;
  public static final int bS = 3;
  public static final int bT = 4;
  public static final int bU = 5;
  public static final int bV = 6;
  public static final int bW = 100;
  public static final int bX = 101;
  public static final int bY = 102;
  public static final int bZ = 103;
  public static final int ba = 4;
  public static final int bb = 5;
  public static final int bc = 6;
  public static final int bd = 7;
  public static final int be = 8;
  public static final int bf = 10;
  public static final int bg = 11;
  public static final int bh = 12;
  public static final int bi = 13;
  public static final int bj = 14;
  public static final int bk = 15;
  public static final int bl = 16;
  public static final int bm = 17;
  public static final int bn = 18;
  public static final int bo = 19;
  public static final int bp = 20;
  public static final int bq = 21;
  public static final int br = 30;
  public static final int bs = 31;
  public static final int bt = 32;
  public static final int bu = 33;
  public static final int bv = 34;
  public static final int bw = 35;
  public static final int bx = 36;
  public static final int by = 37;
  public static final int bz = 38;
  public static final int ca = 104;
  public static final String i = "http://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027";
  protected static final String j = "http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&qq=%s&aid=%s&_wv=5123";
  protected static final String k = "http://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka";
  protected static final String l = "http://m.vip.qq.com/redirect/?go=androidqlevel&qq=%s&aid=mvip.pingtai.mobileqq.androidziliaoka.fromkerentaiQQlevelicon";
  protected static final String m = "http://ti.qq.com/xman/self.html?_wv=1027&adtag=setting&_bid=297";
  protected static final String n = "http://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297";
  protected static final String o = "http://ti.qq.com/xman/view.html?_wv=1027&uin=%s&_bid=297";
  public static final int p = 1000;
  public static final String p = "http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017";
  public static final int q = 1001;
  public static final String q = "http://ti.qq.com/lightalk/info.html?_wv=1027&uin=%s&nick=%s";
  public static final int r = 1002;
  protected static final String r = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
  public static final int s = 1003;
  protected static final String s = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
  public static final int t = 1004;
  protected static final String t = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
  public static final int u = 1005;
  protected static final String u = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
  public static final int v = 1006;
  protected static final String v = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
  public static final int w = 1007;
  public static final String w = "com.tencent.mobileqq.action.template_setup";
  public static final int x = 1008;
  public static final String x = "action_cover_pick_gallery";
  public static final int y = 1009;
  public static final String y = "AllInOne";
  public static final int z = 1010;
  public static final String z = "source_to_profile";
  protected boolean h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    int[] arrayOfInt1 = { 2130843392, 2131427442 };
    int[] arrayOfInt2 = { 2130843395, 2131427443 };
    a = new int[][] { { 2130843389, 2131427441 }, arrayOfInt1, arrayOfInt2 };
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {}
    while (((paramInt >= 4) && (paramInt <= 21)) || ((paramInt >= 30) && (paramInt <= 37)) || (paramInt == 57) || (paramInt == 59) || ((paramInt >= 60) && (paramInt <= 61)) || ((paramInt >= 64) && (paramInt <= 68)) || (paramInt == 84) || ((paramInt >= 87) && (paramInt <= 88)) || (paramInt == 98)) {
      return paramInt;
    }
    return 999;
  }
  
  public static int a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.jdField_a_of_type_Int == 0) {
      return 2;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {
      return 0;
    }
    return 1;
  }
  
  public static long a(ProfileActivity.AllInOne paramAllInOne, boolean paramBoolean)
  {
    long l1 = 0L;
    if (ProfileActivity.AllInOne.a(paramAllInOne)) {
      l1 = 0L | 1L;
    }
    long l2 = l1 | 0x4;
    l1 = l2;
    if (ProfileActivity.AllInOne.f(paramAllInOne)) {
      l1 = l2 | 0x8;
    }
    l2 = l1 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800;
    l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramAllInOne.jdField_a_of_type_Int == 1) {
        l1 = l2 | 0x2000;
      }
    }
    return l1;
  }
  
  public static Intent a(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramAllInOne != null) && (BmqqSegmentUtil.c(paramAllInOne.jdField_a_of_type_JavaLangString))) {
      return new Intent(paramContext, QidianProfileCardActivity.class);
    }
    if ((paramAllInOne != null) && ((paramContext instanceof BaseActivity)) && (((BaseActivity)paramContext).app != null) && (CrmUtils.c(((BaseActivity)paramContext).app, paramAllInOne.jdField_a_of_type_JavaLangString)))
    {
      Intent localIntent = new Intent(paramContext, EqqAccountDetailActivity.class);
      localIntent.putExtra("uin", paramAllInOne.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", 1024);
      if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity)))
      {
        localIntent.putExtra("need_finish", true);
        return localIntent;
      }
      localIntent.putExtra("need_finish", false);
      return localIntent;
    }
    paramContext = new Intent(paramContext, FriendProfileCardActivity.class);
    ProfilePerformanceReport.c();
    return paramContext;
  }
  
  public static Uri a(Activity paramActivity, int paramInt)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return null;
    }
    Object localObject = new File(AppConstants.bj + "photo/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = Uri.fromFile(new File(AppConstants.bj + "photo/" + System.currentTimeMillis() + ".jpg"));
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", (Parcelable)localObject);
    localIntent.putExtra("android.intent.extra.videoQuality", 100);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return (Uri)localObject;
  }
  
  public static void a(Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtra("requestCode", paramInt);
      localIntent.addFlags(536870912);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(paramInt);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      if (paramBundle != null) {
        localIntent.putExtra("profile_extres", paramBundle);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 12: 
    case 14: 
    case 16: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1500L;
  }
  
  public static void b(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean c(int paramInt)
  {
    switch (paramInt)
    {
    case 33: 
    default: 
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ProfileActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */