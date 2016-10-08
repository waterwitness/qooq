package com.tencent.mobileqq.util;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardBackground;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import mqq.os.MqqHandler;
import vyx;
import vyy;
import vyz;
import vzc;
import vzd;

public class ProfileCardUtil
{
  public static final int A = 12;
  public static final String A = "0X80044E0";
  public static final int B = 13;
  public static final String B = "VIP_profilecard";
  public static final int C = 14;
  public static final String C = "profileCardDownload";
  public static final int D = 15;
  public static final String D = "profileCardSet";
  public static final int E = 16;
  public static final String E = "profileCardGet";
  public static final int F = 17;
  public static final String F = "profileCardSendFavorite";
  public static final int G = 18;
  public static final String G = "profileCardTimeStat";
  public static final int H = 19;
  public static final String H = "inside.myCardBackground";
  public static final int I = 20;
  public static final String I = "inside.myCardButton";
  public static final int J = 21;
  public static final String J = "inside.myIndividuation";
  public static final int K = 22;
  public static final String K = "inside.blackBar";
  public static final int L = 23;
  public static final String L = "inside.friendCardBackground";
  public static final int M = 24;
  public static final String M = "inside.defaultStyle";
  public static final int N = 25;
  public static final String N = "1";
  public static final int O = 26;
  public static final String O = "2";
  public static final int P = 2000;
  public static final String P = "pttcenter_filepath";
  public static final int Q = 1101;
  public static final String Q = "pttcenter_shDuration";
  public static final int R = 1102;
  public static final String R = "pttcenter_cmd";
  public static final int S = 1107;
  public static final String S = "pttcenter_filekey";
  public static final int T = 1105;
  public static final String T = "pttcenter_selfuin";
  public static final int U = 10000;
  public static final String U = "pttcenter_targetuin";
  public static final int V = 160;
  public static final String V = "pttcenter_voice_optype";
  private static final int jdField_W_of_type_Int = 4;
  private static String jdField_W_of_type_JavaLangString;
  public static final int a = 100;
  public static final long a = 0L;
  public static final String a = "Q.profilecard.Troop";
  public static StringBuilder a;
  public static ArrayList a;
  protected static HashMap a;
  public static final boolean a = true;
  public static final int b = 640;
  protected static long b = 0L;
  public static final String b = "Q.profilecard.SummaryCard";
  private static boolean b = false;
  public static final int c = 482;
  private static final long c = 614400L;
  public static final String c = "Q.profilecard.FrdProfileCard";
  public static final int d = -1;
  public static final String d = "Q.profilecard.MicroPhone";
  public static final int e = 0;
  public static final String e = "Q.profilecard.VoicePlayer";
  public static final int f = 1;
  public static final String f = "Q.profilecard.Avatar";
  public static final int g = 2;
  public static final String g = "Q.profilecard.TResource";
  public static final int h = 3;
  public static final String h = "Q.profilecard.VoiceIntro";
  public static final int i = 0;
  public static final String i = "Q.profilecard.PhotoWall";
  public static final int j = 1;
  public static final String j = "Q.profilecard.PhotoWall.Bg";
  public static final int k = 1;
  public static final String k = "Q.profilecard.Detail";
  public static final int l = 3;
  public static final String l = "Q.profilecard.PhotoWall.Trans";
  public static final int m = 0;
  public static final String m = "Q.profilecard.VoiceIntro.Trans";
  public static final int n = 1;
  public static final String n = "Q.profilecard.Visitor";
  public static final int o = 0;
  public static final String o = "ProfileCard.setcard";
  public static final int p = 1;
  public static final String p = "mvip.gongneng.android.mingpian_zhuangbanopen";
  public static final int q = 2;
  public static final String q = "mvip.gongneng.android.mingpian_urlopen";
  public static final int r = 3;
  public static final String r = "profilecard";
  public static final int s = 4;
  public static final String s = "is_template_list_loaded";
  public static final int t = 5;
  public static final String t = "labelList";
  public static final int u = 6;
  public static final String u = "profilecard_sp_file";
  public static final int v = 7;
  public static final String v = "user_visited_profile_browser";
  public static final int w = 8;
  public static String w = "";
  public static final int x = 9;
  public static final String x = "0X8004436";
  public static final int y = 10;
  public static final String y = "0X8004437";
  public static final int z = 11;
  public static final String z = "0X80044DF";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.min(640, Math.min(paramInt1, paramInt2) - 10);
  }
  
  public static int a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return a(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
  
  public static int a(Context paramContext)
  {
    int i1 = a(paramContext.getResources());
    return (int)((paramContext.getResources().getDisplayMetrics().heightPixels - i1) * 0.75F);
  }
  
  public static final int a(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static final int a(Context paramContext, int paramInt)
  {
    return (int)Math.ceil(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static final int a(Resources paramResources)
  {
    try
    {
      int i1 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i1;
    }
    catch (Exception localException) {}
    return (int)(paramResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public static int a(ProfileActivity.AllInOne paramAllInOne)
  {
    int i1 = 0;
    if (paramAllInOne == null) {
      return 1001;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {}
    for (;;)
    {
      return i1;
      if ((paramAllInOne.jdField_a_of_type_Int == 22) || (paramAllInOne.jdField_a_of_type_Int == 21)) {
        i1 = 1000;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 42)) {
        i1 = 1001;
      } else if (paramAllInOne.jdField_a_of_type_Int == 3) {
        i1 = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 2) {
        i1 = 1005;
      } else if (paramAllInOne.jdField_a_of_type_Int == 74) {
        i1 = 1023;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 32) || (paramAllInOne.jdField_a_of_type_Int == 31) || (paramAllInOne.jdField_a_of_type_Int == 51) || (paramAllInOne.jdField_a_of_type_Int == 50) || (paramAllInOne.jdField_a_of_type_Int == 34)) {
        i1 = 1006;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 46) || (paramAllInOne.jdField_a_of_type_Int == 47)) {
        i1 = 1004;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 56) || (paramAllInOne.jdField_a_of_type_Int == 57)) {
        i1 = 1009;
      } else if (paramAllInOne.jdField_a_of_type_Int == 58) {
        i1 = 1020;
      } else if ((paramAllInOne.jdField_a_of_type_Int == 71) || (paramAllInOne.jdField_a_of_type_Int == 72)) {
        i1 = 1021;
      } else if (paramAllInOne.jdField_a_of_type_Int != 70) {
        if ((paramAllInOne.jdField_a_of_type_Int == 27) || (paramAllInOne.jdField_a_of_type_Int == 25)) {
          i1 = 1022;
        } else if ((paramAllInOne.jdField_a_of_type_Int == 75) || (paramAllInOne.jdField_a_of_type_Int == 76)) {
          i1 = 1010;
        } else if (paramAllInOne.jdField_a_of_type_Int == 80) {
          i1 = 25;
        } else {
          i1 = 1001;
        }
      }
    }
  }
  
  public static int a(String paramString)
  {
    int i6 = 0;
    int i2 = 0;
    long l1 = System.currentTimeMillis();
    paramString = a(paramString, 100, 0.5633803F);
    if (paramString == null) {}
    int i1;
    do
    {
      return i2;
      int i3 = 0;
      int i5 = 0;
      i2 = 0;
      while (i3 < paramString.getHeight())
      {
        int i4 = 0;
        i1 = i5;
        if (i4 < paramString.getWidth())
        {
          i5 = paramString.getPixel(i4, i3);
          int i7 = Color.red(i5);
          int i8 = Color.green(i5);
          if ((Color.blue(i5) + (i7 + i8)) / 3 > 127)
          {
            i5 = i2 + 1;
            i2 = i1;
          }
          for (i1 = i5;; i1 = i5)
          {
            i5 = i4 + 1;
            i4 = i1;
            i1 = i2;
            i2 = i4;
            i4 = i5;
            break;
            i5 = i2;
            i2 = i1 + 1;
          }
        }
        i3 += 1;
        i5 = i1;
      }
      i1 = i6;
      if (i2 >= i5) {
        i1 = 1;
      }
      paramString.recycle();
      i2 = i1;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCardUtil", 2, "-->calculate background color cost:" + (System.currentTimeMillis() - l1) + "(ms)");
    return i1;
  }
  
  public static long a()
  {
    return System.currentTimeMillis() - jdField_b_of_type_Long;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramQQAppInterface == null) || (paramAllInOne == null)) {
      return 0L;
    }
    if ((paramAllInOne.c != null) && (paramAllInOne.c.length() > 0)) {
      paramQQAppInterface = paramAllInOne.c;
    }
    for (;;)
    {
      paramAllInOne = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramAllInOne = "0";
      }
      try
      {
        long l1 = Long.valueOf(paramAllInOne).longValue();
        return l1;
      }
      catch (Exception paramQQAppInterface)
      {
        return 0L;
      }
      if ((paramAllInOne.d != null) && (paramAllInOne.d.length() > 0))
      {
        paramQQAppInterface = (TroopInfo)paramQQAppInterface.a().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { paramAllInOne.d });
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.troopuin;
          continue;
        }
      }
      paramQQAppInterface = "0";
    }
  }
  
  public static Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    paramString = new File(paramString);
    if ((paramString == null) || (!paramString.exists()) || (paramString.length() <= 0L) || (paramString.isDirectory())) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeStream(new FileInputStream(paramString));
        if (localBitmap == null) {
          return null;
        }
        int i1 = localBitmap.getWidth();
        int i2 = localBitmap.getHeight();
        paramString = localBitmap;
        if (i1 > paramInt)
        {
          int i3 = (int)(paramInt / paramFloat);
          paramString = new Matrix();
          paramString.postScale(paramInt / i1, i3 / i2);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, i1, i2, paramString, true);
          localBitmap.recycle();
          return paramString;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  /* Error */
  public static SpannableString a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +66 -> 67
    //   4: new 470	android/text/SpannableString
    //   7: dup
    //   8: ldc_w 472
    //   11: invokespecial 475	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   14: astore 4
    //   16: aload_0
    //   17: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: ldc_w 476
    //   23: invokevirtual 480	android/content/res/Resources:getDimension	(I)F
    //   26: f2i
    //   27: istore_1
    //   28: aload_0
    //   29: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   32: ldc_w 481
    //   35: invokevirtual 485	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   38: astore_0
    //   39: aload_0
    //   40: iconst_0
    //   41: iconst_0
    //   42: iload_1
    //   43: iload_1
    //   44: invokevirtual 491	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   47: aload 4
    //   49: new 493	android/text/style/ImageSpan
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 496	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   57: iconst_0
    //   58: iconst_1
    //   59: bipush 33
    //   61: invokevirtual 500	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   64: aload 4
    //   66: areturn
    //   67: iload_2
    //   68: bipush 64
    //   70: idiv
    //   71: istore 13
    //   73: iload_2
    //   74: bipush 64
    //   76: irem
    //   77: istore_2
    //   78: iload_2
    //   79: bipush 16
    //   81: idiv
    //   82: istore 14
    //   84: iload_2
    //   85: bipush 16
    //   87: irem
    //   88: istore 16
    //   90: iload 16
    //   92: iconst_4
    //   93: idiv
    //   94: istore 15
    //   96: ldc -46
    //   98: astore 5
    //   100: iconst_0
    //   101: istore 11
    //   103: iload 11
    //   105: iconst_4
    //   106: if_icmpge +137 -> 243
    //   109: iconst_0
    //   110: istore_2
    //   111: ldc -46
    //   113: astore 4
    //   115: iload 11
    //   117: tableswitch	default:+31->148, 0:+71->188, 1:+82->199, 2:+93->210, 3:+104->221
    //   148: iconst_0
    //   149: istore 12
    //   151: iload 12
    //   153: iload_2
    //   154: if_icmpge +80 -> 234
    //   157: new 363	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   164: aload 5
    //   166: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 4
    //   171: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 5
    //   179: iload 12
    //   181: iconst_1
    //   182: iadd
    //   183: istore 12
    //   185: goto -34 -> 151
    //   188: ldc_w 502
    //   191: astore 4
    //   193: iload 13
    //   195: istore_2
    //   196: goto -48 -> 148
    //   199: ldc_w 504
    //   202: astore 4
    //   204: iload 14
    //   206: istore_2
    //   207: goto -59 -> 148
    //   210: ldc_w 506
    //   213: astore 4
    //   215: iload 15
    //   217: istore_2
    //   218: goto -70 -> 148
    //   221: ldc_w 508
    //   224: astore 4
    //   226: iload 16
    //   228: iconst_4
    //   229: irem
    //   230: istore_2
    //   231: goto -83 -> 148
    //   234: iload 11
    //   236: iconst_1
    //   237: iadd
    //   238: istore 11
    //   240: goto -137 -> 103
    //   243: iload_3
    //   244: ifeq +489 -> 733
    //   247: aload 5
    //   249: invokevirtual 392	java/lang/String:length	()I
    //   252: iload_1
    //   253: if_icmple +480 -> 733
    //   256: aload 5
    //   258: iconst_0
    //   259: iload_1
    //   260: invokevirtual 512	java/lang/String:substring	(II)Ljava/lang/String;
    //   263: astore 4
    //   265: aload 4
    //   267: astore 8
    //   269: new 470	android/text/SpannableString
    //   272: dup
    //   273: aload 8
    //   275: invokespecial 475	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   278: astore 10
    //   280: aload_0
    //   281: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   284: ldc_w 476
    //   287: invokevirtual 480	android/content/res/Resources:getDimension	(I)F
    //   290: f2i
    //   291: istore 11
    //   293: iconst_0
    //   294: istore_2
    //   295: iload_2
    //   296: aload 8
    //   298: invokevirtual 392	java/lang/String:length	()I
    //   301: if_icmpge +404 -> 705
    //   304: aconst_null
    //   305: astore 7
    //   307: aconst_null
    //   308: astore 9
    //   310: aconst_null
    //   311: astore 6
    //   313: iload_2
    //   314: iload_1
    //   315: iconst_1
    //   316: isub
    //   317: if_icmpne +97 -> 414
    //   320: iload_3
    //   321: iconst_1
    //   322: if_icmpne +92 -> 414
    //   325: aload 7
    //   327: astore 4
    //   329: aload 9
    //   331: astore 5
    //   333: aload_0
    //   334: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 513
    //   340: invokevirtual 485	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   343: astore 6
    //   345: aload 6
    //   347: ifnull +50 -> 397
    //   350: aload 6
    //   352: astore 4
    //   354: aload 6
    //   356: astore 5
    //   358: aload 6
    //   360: iconst_0
    //   361: iconst_0
    //   362: iload 11
    //   364: iload 11
    //   366: invokevirtual 491	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   369: aload 6
    //   371: astore 4
    //   373: aload 6
    //   375: astore 5
    //   377: aload 10
    //   379: new 493	android/text/style/ImageSpan
    //   382: dup
    //   383: aload 6
    //   385: invokespecial 496	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   388: iload_2
    //   389: iload_2
    //   390: iconst_1
    //   391: iadd
    //   392: bipush 33
    //   394: invokevirtual 500	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   397: aload 10
    //   399: areturn
    //   400: astore 4
    //   402: aload 4
    //   404: invokevirtual 516	java/lang/Exception:printStackTrace	()V
    //   407: aload 5
    //   409: astore 8
    //   411: goto -142 -> 269
    //   414: aload 7
    //   416: astore 4
    //   418: aload 9
    //   420: astore 5
    //   422: ldc_w 502
    //   425: aload 8
    //   427: iload_2
    //   428: iload_2
    //   429: iconst_1
    //   430: iadd
    //   431: invokevirtual 512	java/lang/String:substring	(II)Ljava/lang/String;
    //   434: invokevirtual 520	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   437: ifeq +23 -> 460
    //   440: aload 7
    //   442: astore 4
    //   444: aload 9
    //   446: astore 5
    //   448: aload_0
    //   449: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   452: ldc_w 521
    //   455: invokevirtual 485	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   458: astore 6
    //   460: aload 6
    //   462: astore 7
    //   464: aload 6
    //   466: astore 4
    //   468: aload 6
    //   470: astore 5
    //   472: ldc_w 504
    //   475: aload 8
    //   477: iload_2
    //   478: iload_2
    //   479: iconst_1
    //   480: iadd
    //   481: invokevirtual 512	java/lang/String:substring	(II)Ljava/lang/String;
    //   484: invokevirtual 520	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   487: ifeq +23 -> 510
    //   490: aload 6
    //   492: astore 4
    //   494: aload 6
    //   496: astore 5
    //   498: aload_0
    //   499: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   502: ldc_w 522
    //   505: invokevirtual 485	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   508: astore 7
    //   510: aload 7
    //   512: astore 4
    //   514: aload 7
    //   516: astore 5
    //   518: ldc_w 506
    //   521: aload 8
    //   523: iload_2
    //   524: iload_2
    //   525: iconst_1
    //   526: iadd
    //   527: invokevirtual 512	java/lang/String:substring	(II)Ljava/lang/String;
    //   530: invokevirtual 520	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   533: ifeq +193 -> 726
    //   536: aload 7
    //   538: astore 4
    //   540: aload 7
    //   542: astore 5
    //   544: aload_0
    //   545: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   548: ldc_w 523
    //   551: invokevirtual 485	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   554: astore 6
    //   556: aload 6
    //   558: astore 4
    //   560: aload 4
    //   562: astore 5
    //   564: ldc_w 508
    //   567: aload 8
    //   569: iload_2
    //   570: iload_2
    //   571: iconst_1
    //   572: iadd
    //   573: invokevirtual 512	java/lang/String:substring	(II)Ljava/lang/String;
    //   576: invokevirtual 520	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   579: ifeq +15 -> 594
    //   582: aload_0
    //   583: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   586: ldc_w 524
    //   589: invokevirtual 485	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   592: astore 5
    //   594: aload 5
    //   596: astore 4
    //   598: aload 4
    //   600: ifnull +34 -> 634
    //   603: aload 4
    //   605: iconst_0
    //   606: iconst_0
    //   607: iload 11
    //   609: iload 11
    //   611: invokevirtual 491	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   614: aload 10
    //   616: new 493	android/text/style/ImageSpan
    //   619: dup
    //   620: aload 4
    //   622: invokespecial 496	android/text/style/ImageSpan:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   625: iload_2
    //   626: iload_2
    //   627: iconst_1
    //   628: iadd
    //   629: bipush 33
    //   631: invokevirtual 500	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   634: iload_2
    //   635: iconst_1
    //   636: iadd
    //   637: istore_2
    //   638: goto -343 -> 295
    //   641: astore 6
    //   643: aload 4
    //   645: astore 5
    //   647: aload 5
    //   649: astore 4
    //   651: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq -56 -> 598
    //   657: ldc 117
    //   659: iconst_2
    //   660: aload 6
    //   662: invokevirtual 525	java/lang/Error:toString	()Ljava/lang/String;
    //   665: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: aload 5
    //   670: astore 4
    //   672: goto -74 -> 598
    //   675: astore 6
    //   677: aload 5
    //   679: astore 4
    //   681: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   684: ifeq -86 -> 598
    //   687: ldc 117
    //   689: iconst_2
    //   690: aload 6
    //   692: invokevirtual 526	java/lang/Exception:toString	()Ljava/lang/String;
    //   695: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: aload 5
    //   700: astore 4
    //   702: goto -104 -> 598
    //   705: aload 10
    //   707: areturn
    //   708: astore 6
    //   710: aload 4
    //   712: astore 5
    //   714: goto -37 -> 677
    //   717: astore 6
    //   719: aload 4
    //   721: astore 5
    //   723: goto -76 -> 647
    //   726: aload 7
    //   728: astore 4
    //   730: goto -170 -> 560
    //   733: aload 5
    //   735: astore 4
    //   737: goto -472 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	740	0	paramContext	Context
    //   0	740	1	paramInt1	int
    //   0	740	2	paramInt2	int
    //   0	740	3	paramBoolean	boolean
    //   14	358	4	localObject1	Object
    //   400	3	4	localException1	Exception
    //   416	320	4	localObject2	Object
    //   98	636	5	localObject3	Object
    //   311	246	6	localDrawable	Drawable
    //   641	20	6	localError1	Error
    //   675	16	6	localException2	Exception
    //   708	1	6	localException3	Exception
    //   717	1	6	localError2	Error
    //   305	422	7	localObject4	Object
    //   267	301	8	localObject5	Object
    //   308	137	9	localObject6	Object
    //   278	428	10	localSpannableString	SpannableString
    //   101	509	11	i1	int
    //   149	35	12	i2	int
    //   71	123	13	i3	int
    //   82	123	14	i4	int
    //   94	122	15	i5	int
    //   88	142	16	i6	int
    // Exception table:
    //   from	to	target	type
    //   247	265	400	java/lang/Exception
    //   333	345	641	java/lang/Error
    //   358	369	641	java/lang/Error
    //   377	397	641	java/lang/Error
    //   422	440	641	java/lang/Error
    //   448	460	641	java/lang/Error
    //   472	490	641	java/lang/Error
    //   498	510	641	java/lang/Error
    //   518	536	641	java/lang/Error
    //   544	556	641	java/lang/Error
    //   333	345	675	java/lang/Exception
    //   358	369	675	java/lang/Exception
    //   377	397	675	java/lang/Exception
    //   422	440	675	java/lang/Exception
    //   448	460	675	java/lang/Exception
    //   472	490	675	java/lang/Exception
    //   498	510	675	java/lang/Exception
    //   518	536	675	java/lang/Exception
    //   544	556	675	java/lang/Exception
    //   564	594	708	java/lang/Exception
    //   564	594	717	java/lang/Error
  }
  
  public static Card a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = null;
    byte b1 = 0;
    int i2 = 1;
    byte b2 = 1;
    FriendsManager localFriendsManager;
    OlympicManager localOlympicManager;
    try
    {
      localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
      localOlympicManager = (OlympicManager)paramQQAppInterface.getManager(166);
      if (localFriendsManager == null) {
        break label540;
      }
      localObject1 = localFriendsManager.c(paramString);
      paramQQAppInterface = localFriendsManager.a(paramString);
      if (paramQQAppInterface == null)
      {
        paramQQAppInterface = new Card();
        paramQQAppInterface.uin = paramString;
        paramQQAppInterface.shGender = -1;
        if (localOlympicManager.a(paramString))
        {
          b1 = 1;
          paramQQAppInterface.olympicTorch = b1;
          if (localObject1 == null) {
            break label317;
          }
          paramQQAppInterface.strSign = ((Friends)localObject1).signature;
          paramQQAppInterface.strNick = ((Friends)localObject1).name;
          paramQQAppInterface.strReMark = ((Friends)localObject1).remark;
          paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
            break label302;
          }
          b1 = 1;
          label148:
          paramQQAppInterface.bQQVipOpen = b1;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label307;
          }
          b1 = 1;
          label166:
          paramQQAppInterface.bSuperVipOpen = b1;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
            break label312;
          }
          b1 = b2;
          label184:
          paramQQAppInterface.bSuperQQOpen = b1;
          paramQQAppInterface.iQQVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_QQVIP);
          paramQQAppInterface.iSuperVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERVIP);
          paramQQAppInterface.iSuperQQType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERQQ);
          paramQQAppInterface.iQQVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          paramQQAppInterface.iSuperVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
          paramQQAppInterface.iSuperQQLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERQQ);
          paramQQAppInterface.lUserFlag = ((Friends)localObject1).cSpecialFlag;
        }
        for (;;)
        {
          if (localFriendsManager == null) {
            break label537;
          }
          localFriendsManager.a(paramQQAppInterface);
          label283:
          if (paramQQAppInterface != null) {
            paramQQAppInterface.getBusiEntrys();
          }
          return paramQQAppInterface;
          b1 = 0;
          break;
          label302:
          b1 = 0;
          break label148;
          label307:
          b1 = 0;
          break label166;
          label312:
          b1 = 0;
          break label184;
          label317:
          paramQQAppInterface.strSign = "";
          paramQQAppInterface.strNick = "";
          paramQQAppInterface.strReMark = "";
        }
      }
      if (localObject1 == null) {
        break label475;
      }
    }
    finally {}
    int i1;
    label376:
    boolean bool2;
    boolean bool1;
    if (!Utils.a(((Friends)localObject1).signature, paramQQAppInterface.strSign))
    {
      paramQQAppInterface.strSign = ((Friends)localObject1).signature;
      i1 = 1;
      if (!Utils.a(((Friends)localObject1).alias, paramQQAppInterface.strShowName))
      {
        paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
        i1 = 1;
      }
      if ((((Friends)localObject1).cSpecialFlag & 0x1) == 1) {
        paramQQAppInterface.lUserFlag |= 1L;
      }
      bool2 = localOlympicManager.a(paramString);
      if (paramQQAppInterface.olympicTorch != 1) {
        break label573;
      }
      bool1 = true;
      break label553;
      label446:
      paramQQAppInterface.olympicTorch = b1;
      i1 = i2;
      label455:
      if ((localFriendsManager == null) || (i1 == 0)) {
        break label570;
      }
      localFriendsManager.a(paramQQAppInterface);
      break label570;
      label475:
      bool2 = localOlympicManager.a(paramString);
      if (paramQQAppInterface.olympicTorch == 1)
      {
        bool1 = true;
        break label579;
      }
    }
    for (;;)
    {
      label497:
      paramQQAppInterface.olympicTorch = b1;
      if (localFriendsManager != null) {
        localFriendsManager.a(paramQQAppInterface);
      }
      label514:
      break label283;
      bool1 = false;
      label537:
      label540:
      label553:
      label570:
      label573:
      label577:
      label579:
      do
      {
        b1 = 0;
        break label497;
        for (;;)
        {
          break label455;
          i1 = 0;
          break label376;
          break label283;
          Object localObject2 = null;
          paramQQAppInterface = (QQAppInterface)localObject1;
          localObject1 = localObject2;
          break;
          for (;;)
          {
            if (bool1 == bool2) {
              break label577;
            }
            if (!bool2) {
              break label446;
            }
            b1 = 1;
            break label446;
            break;
            bool1 = false;
          }
        }
        if (bool1 == bool2) {
          break label514;
        }
      } while (!bool2);
      b1 = 1;
    }
  }
  
  public static ProfileCardTemplate a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    int i3 = 0;
    if (paramLong == ProfileCardTemplate.jdField_a_of_type_Long) {
      return null;
    }
    ArrayList localArrayList = a(paramQQAppInterface, true, paramBoolean);
    int i4 = localArrayList.size();
    int i1 = 0;
    paramQQAppInterface = null;
    int i2 = i3;
    if (i1 < i4)
    {
      paramQQAppInterface = (ProfileCardTemplate)localArrayList.get(i1);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.jdField_i_of_type_Long == paramLong)) {
        i2 = 1;
      }
    }
    else
    {
      if ((i2 != 1) || (paramQQAppInterface == null)) {
        break label92;
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      i1 += 1;
      break;
      label92:
      paramQQAppInterface = null;
    }
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.c).append("temp").append("/").append(System.currentTimeMillis()).append("_portrait.tmp");
    return localStringBuilder.toString();
  }
  
  public static String a(byte paramByte)
  {
    switch (paramByte)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return "水瓶座";
    case 2: 
      return "双鱼座";
    case 3: 
      return "白羊座";
    case 4: 
      return "金牛座";
    case 5: 
      return "双子座";
    case 6: 
      return "巨蟹座";
    case 7: 
      return "狮子座";
    case 8: 
      return "处女座";
    case 9: 
      return "天秤座";
    case 10: 
      return "天蝎座";
    case 11: 
      return "射手座";
    }
    return "摩羯座";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 2: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    case 3: 
      return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
    case 4: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 5: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    }
    return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "parseUrl() ip = " + paramInt1 + ", port = " + paramInt2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(paramInt1 & 0xFF).append('.');
    localStringBuilder.append(paramInt1 >> 8 & 0xFF).append('.');
    localStringBuilder.append(paramInt1 >> 16 & 0xFF).append('.');
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    localStringBuilder.append(':').append(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "parseUrl() url = " + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getDir("profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_label_config.json" + "6.5.5";
  }
  
  public static String a(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i1 = -1;
    Object localObject = "";
    if (localCard != null)
    {
      i1 = localCard.age;
      if (i1 > 0) {
        localObject = i1 + paramContext.getString(2131368211);
      }
      paramProfileCardInfo = "";
      if (localCard == null) {
        break label337;
      }
      paramContext = paramProfileCardInfo;
      if (!TextUtils.isEmpty(localCard.strCountry))
      {
        paramContext = paramProfileCardInfo;
        if (!"中国".equals(localCard.strCountry)) {
          paramContext = "" + localCard.strCountry;
        }
      }
      paramProfileCardInfo = paramContext;
      if (!TextUtils.isEmpty(localCard.strProvince))
      {
        paramProfileCardInfo = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramProfileCardInfo = paramContext + " ";
        }
        paramProfileCardInfo = paramProfileCardInfo + localCard.strProvince;
      }
      paramContext = paramProfileCardInfo;
      if (!TextUtils.isEmpty(localCard.strCity))
      {
        paramContext = paramProfileCardInfo;
        if (!TextUtils.isEmpty(paramProfileCardInfo)) {
          paramContext = paramProfileCardInfo + " ";
        }
        paramContext = paramContext + localCard.strCity;
      }
      label243:
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label532;
      }
    }
    label337:
    label532:
    for (paramProfileCardInfo = "" + " " + (String)localObject;; paramProfileCardInfo = "")
    {
      localObject = paramProfileCardInfo;
      if (paramContext != null)
      {
        localObject = paramProfileCardInfo;
        if (paramContext.length() > 0) {
          localObject = paramProfileCardInfo + " " + paramContext;
        }
      }
      return (String)localObject;
      if (localContactCard == null) {
        break;
      }
      i1 = localContactCard.bAge;
      break;
      paramContext = paramProfileCardInfo;
      if (localContactCard == null) {
        break label243;
      }
      paramContext = paramProfileCardInfo;
      if (!TextUtils.isEmpty(localContactCard.strCountry))
      {
        paramContext = paramProfileCardInfo;
        if (!"中国".equals(localContactCard.strCountry)) {
          paramContext = "" + localContactCard.strCountry;
        }
      }
      paramProfileCardInfo = paramContext;
      if (!TextUtils.isEmpty(localContactCard.strProvince))
      {
        paramProfileCardInfo = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramProfileCardInfo = paramContext + " ";
        }
        paramProfileCardInfo = paramProfileCardInfo + localContactCard.strProvince;
      }
      paramContext = paramProfileCardInfo;
      if (TextUtils.isEmpty(localContactCard.strCity)) {
        break label243;
      }
      paramContext = paramProfileCardInfo;
      if (!TextUtils.isEmpty(paramProfileCardInfo)) {
        paramContext = paramProfileCardInfo + " ";
      }
      paramContext = paramContext + localContactCard.strCity;
      break label243;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return c(paramContext) + d(paramString);
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    String str = "";
    Object localObject = str;
    if (paramAllInOne != null)
    {
      localObject = str;
      if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = str;
        if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject = (ProfileActivity.CardContactInfo)paramAllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
          if (localObject == null) {
            break label99;
          }
        }
      }
    }
    label99:
    for (str = ((ProfileActivity.CardContactInfo)localObject).b + ((ProfileActivity.CardContactInfo)localObject).c;; str = "")
    {
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) {
          localObject = paramAllInOne.jdField_a_of_type_JavaLangString;
        }
      }
      return (String)localObject;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.cK);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i1 = localCalendar.get(2) + 1;
    if (i1 < 10)
    {
      paramQQAppInterface = "0" + i1;
      localStringBuilder.append(paramQQAppInterface);
      i1 = localCalendar.get(5);
      if (i1 >= 10) {
        break label301;
      }
      paramQQAppInterface = "0" + i1;
      label107:
      localStringBuilder.append(paramQQAppInterface);
      i1 = localCalendar.get(11);
      if (i1 >= 10) {
        break label309;
      }
      paramQQAppInterface = "0" + i1;
      label147:
      localStringBuilder.append(paramQQAppInterface);
      i1 = localCalendar.get(12);
      if (i1 >= 10) {
        break label317;
      }
      paramQQAppInterface = "0" + i1;
      label187:
      localStringBuilder.append(paramQQAppInterface);
      i1 = localCalendar.get(13);
      if (i1 >= 10) {
        break label325;
      }
    }
    label301:
    label309:
    label317:
    label325:
    for (paramQQAppInterface = "0" + i1;; paramQQAppInterface = Integer.valueOf(i1))
    {
      localStringBuilder.append(paramQQAppInterface);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label333;
      }
      return localStringBuilder.toString() + ".jpg";
      paramQQAppInterface = Integer.valueOf(i1);
      break;
      paramQQAppInterface = Integer.valueOf(i1);
      break label107;
      paramQQAppInterface = Integer.valueOf(i1);
      break label147;
      paramQQAppInterface = Integer.valueOf(i1);
      break label187;
    }
    label333:
    paramQQAppInterface = new StringBuilder(localStringBuilder);
    int i2 = localStringBuilder.length();
    i1 = 1;
    for (;;)
    {
      if (i1 < Integer.MAX_VALUE)
      {
        paramQQAppInterface.append('(');
        paramQQAppInterface.append(i1);
        paramQQAppInterface.append(')');
        paramQQAppInterface.append(".jpg");
        if (new File(paramQQAppInterface.toString()).exists()) {}
      }
      else
      {
        return paramQQAppInterface.toString();
      }
      paramQQAppInterface.delete(i2, paramQQAppInterface.length());
      i1 += 1;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    String str = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    if (paramLong == -1L) {
      return str + File.separator + "common_" + "583";
    }
    if ((paramLong != ProfileCardTemplate.jdField_a_of_type_Long) && (paramLong > 0L))
    {
      paramQQAppInterface = a(paramQQAppInterface, paramLong, false);
      if (paramQQAppInterface != null) {
        return str + File.separator + paramQQAppInterface.jdField_i_of_type_Long + "_" + paramQQAppInterface.f;
      }
    }
    return null;
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    if (paramByteStringMicro != null)
    {
      byte[] arrayOfByte = new byte[paramByteStringMicro.size()];
      paramByteStringMicro.copyTo(arrayOfByte, 0);
      return c(HexUtil.a(arrayOfByte));
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(CardHandler.c).append("HDAvatar").append("/").append(paramString).append(".jpg");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString1 = MD5.toMD5(paramString1 + paramString2);
    localStringBuilder.append(CardHandler.c).append("voice").append("/").append(paramString1).append(".amr");
    return localStringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open427";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open429";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open4210";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open428";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open426";
        }
      }
    }
    else if (!paramBoolean2) {
      if (paramInt3 == 2)
      {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open422";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open424";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open425";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open423";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open421";
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open413";
          }
          return "mvip.gongneng.android.mingpian_open412";
        }
        if (paramInt2 == 2) {
          return "mvip.gongneng.android.mingpian_open411";
        }
      }
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return c(HexUtil.a(paramArrayOfByte));
  }
  
  /* Error */
  public static ArrayList a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 117
    //   10: iconst_2
    //   11: ldc_w 914
    //   14: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: invokevirtual 838	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: astore_0
    //   22: aload_0
    //   23: invokestatic 916	com/tencent/mobileqq/util/ProfileCardUtil:b	(Landroid/content/Context;)Ljava/lang/String;
    //   26: astore 4
    //   28: new 432	java/io/File
    //   31: dup
    //   32: aload 4
    //   34: invokespecial 435	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aload_3
    //   39: invokevirtual 438	java/io/File:exists	()Z
    //   42: istore 11
    //   44: iload 11
    //   46: ifne +8 -> 54
    //   49: ldc_w 918
    //   52: astore 4
    //   54: getstatic 212	com/tencent/mobileqq/util/ProfileCardUtil:w	Ljava/lang/String;
    //   57: aload 4
    //   59: invokestatic 921	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   62: ifeq +20 -> 82
    //   65: getstatic 208	com/tencent/mobileqq/util/ProfileCardUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   68: invokevirtual 923	java/util/ArrayList:isEmpty	()Z
    //   71: ifne +11 -> 82
    //   74: iload_1
    //   75: ifne +7 -> 82
    //   78: getstatic 208	com/tencent/mobileqq/util/ProfileCardUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   81: areturn
    //   82: invokestatic 359	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +12 -> 97
    //   88: ldc 117
    //   90: iconst_2
    //   91: ldc_w 925
    //   94: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: new 203	java/util/ArrayList
    //   100: dup
    //   101: invokespecial 206	java/util/ArrayList:<init>	()V
    //   104: astore 6
    //   106: iload 11
    //   108: ifeq +94 -> 202
    //   111: new 445	java/io/FileInputStream
    //   114: dup
    //   115: aload_3
    //   116: invokespecial 448	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   119: astore_0
    //   120: new 927	java/io/ByteArrayOutputStream
    //   123: dup
    //   124: invokespecial 928	java/io/ByteArrayOutputStream:<init>	()V
    //   127: astore_3
    //   128: sipush 4096
    //   131: newarray <illegal type>
    //   133: astore_2
    //   134: aload_0
    //   135: aload_2
    //   136: iconst_0
    //   137: sipush 4096
    //   140: invokevirtual 934	java/io/InputStream:read	([BII)I
    //   143: istore 8
    //   145: iload 8
    //   147: iconst_m1
    //   148: if_icmpeq +68 -> 216
    //   151: aload_3
    //   152: aload_2
    //   153: iconst_0
    //   154: iload 8
    //   156: invokevirtual 938	java/io/ByteArrayOutputStream:write	([BII)V
    //   159: goto -25 -> 134
    //   162: astore 5
    //   164: aload_3
    //   165: astore_2
    //   166: aload 5
    //   168: astore_3
    //   169: aload_3
    //   170: invokevirtual 939	java/lang/Throwable:printStackTrace	()V
    //   173: aload_0
    //   174: ifnull +7 -> 181
    //   177: aload_0
    //   178: invokevirtual 942	java/io/InputStream:close	()V
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 943	java/io/ByteArrayOutputStream:close	()V
    //   189: aload 4
    //   191: putstatic 212	com/tencent/mobileqq/util/ProfileCardUtil:w	Ljava/lang/String;
    //   194: aload 6
    //   196: putstatic 208	com/tencent/mobileqq/util/ProfileCardUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   199: aload 6
    //   201: areturn
    //   202: aload_0
    //   203: invokevirtual 947	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   206: ldc_w 949
    //   209: invokevirtual 955	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   212: astore_0
    //   213: goto -93 -> 120
    //   216: new 389	java/lang/String
    //   219: dup
    //   220: aload_3
    //   221: invokevirtual 959	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   224: ldc_w 961
    //   227: invokespecial 964	java/lang/String:<init>	([BLjava/lang/String;)V
    //   230: astore_2
    //   231: aload_2
    //   232: invokevirtual 392	java/lang/String:length	()I
    //   235: ifle +539 -> 774
    //   238: new 966	org/json/JSONObject
    //   241: dup
    //   242: aload_2
    //   243: invokespecial 967	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   246: astore_2
    //   247: aload_2
    //   248: ldc_w 969
    //   251: invokevirtual 972	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   254: ifeq +520 -> 774
    //   257: aload_2
    //   258: ldc_w 969
    //   261: invokevirtual 976	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   264: astore_2
    //   265: aload_2
    //   266: invokevirtual 979	org/json/JSONArray:length	()I
    //   269: istore 9
    //   271: iconst_0
    //   272: istore 8
    //   274: iload 8
    //   276: iload 9
    //   278: if_icmpge +496 -> 774
    //   281: aload_2
    //   282: iload 8
    //   284: invokevirtual 983	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   287: astore 5
    //   289: new 652	com/tencent/mobileqq/profile/ProfileCardTemplate
    //   292: dup
    //   293: invokespecial 984	com/tencent/mobileqq/profile/ProfileCardTemplate:<init>	()V
    //   296: astore 7
    //   298: aload 7
    //   300: aload 5
    //   302: ldc_w 986
    //   305: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   308: i2l
    //   309: putfield 666	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_i_of_type_Long	J
    //   312: aload 7
    //   314: aload 5
    //   316: ldc_w 990
    //   319: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   322: putfield 995	com/tencent/mobileqq/profile/ProfileCardTemplate:e	Ljava/lang/String;
    //   325: aload 7
    //   327: aload 5
    //   329: ldc_w 997
    //   332: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: putfield 853	com/tencent/mobileqq/profile/ProfileCardTemplate:f	Ljava/lang/String;
    //   338: aload 7
    //   340: aload 5
    //   342: ldc_w 999
    //   345: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   348: putfield 1001	com/tencent/mobileqq/profile/ProfileCardTemplate:g	Ljava/lang/String;
    //   351: aload 7
    //   353: aload 5
    //   355: ldc_w 1003
    //   358: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   361: putfield 1004	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Int	I
    //   364: aload 7
    //   366: aload 5
    //   368: ldc_w 1006
    //   371: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   374: putfield 1008	com/tencent/mobileqq/profile/ProfileCardTemplate:b	I
    //   377: aload 7
    //   379: aload 5
    //   381: ldc_w 1010
    //   384: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   387: putfield 1012	com/tencent/mobileqq/profile/ProfileCardTemplate:c	I
    //   390: aload 7
    //   392: aload 5
    //   394: ldc_w 1014
    //   397: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: putfield 1016	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   403: aload 7
    //   405: aload 5
    //   407: ldc_w 1018
    //   410: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   413: putfield 1020	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   416: aload 7
    //   418: aload 5
    //   420: ldc_w 1022
    //   423: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   426: putfield 1024	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   429: aload 7
    //   431: aload 5
    //   433: ldc_w 1026
    //   436: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: putfield 1028	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   442: aload 7
    //   444: aload 5
    //   446: ldc_w 1030
    //   449: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   452: putfield 1032	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   455: aload 7
    //   457: aload 5
    //   459: ldc_w 1034
    //   462: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: putfield 1036	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   468: aload 7
    //   470: aload 5
    //   472: ldc_w 1038
    //   475: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   478: putfield 1040	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_n_of_type_JavaLangString	Ljava/lang/String;
    //   481: aload 7
    //   483: aload 5
    //   485: ldc_w 1042
    //   488: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: putfield 1044	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_o_of_type_JavaLangString	Ljava/lang/String;
    //   494: aload 7
    //   496: aload 5
    //   498: ldc_w 1046
    //   501: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   504: putfield 1048	com/tencent/mobileqq/profile/ProfileCardTemplate:d	I
    //   507: aload 7
    //   509: aload 5
    //   511: ldc_w 1050
    //   514: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   517: putfield 1052	com/tencent/mobileqq/profile/ProfileCardTemplate:t	Ljava/lang/String;
    //   520: aload 7
    //   522: aload 5
    //   524: ldc_w 1054
    //   527: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   530: putfield 1056	com/tencent/mobileqq/profile/ProfileCardTemplate:u	Ljava/lang/String;
    //   533: aload 7
    //   535: aload 5
    //   537: ldc_w 1058
    //   540: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   543: putfield 1060	com/tencent/mobileqq/profile/ProfileCardTemplate:v	Ljava/lang/String;
    //   546: aload 7
    //   548: aload 5
    //   550: ldc_w 1062
    //   553: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   556: putfield 1063	com/tencent/mobileqq/profile/ProfileCardTemplate:w	Ljava/lang/String;
    //   559: aload 7
    //   561: aload 5
    //   563: ldc_w 1065
    //   566: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   569: putfield 1067	com/tencent/mobileqq/profile/ProfileCardTemplate:p	Ljava/lang/String;
    //   572: aload 7
    //   574: aload 5
    //   576: ldc_w 1069
    //   579: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   582: putfield 1071	com/tencent/mobileqq/profile/ProfileCardTemplate:r	Ljava/lang/String;
    //   585: aload 7
    //   587: aload 5
    //   589: ldc_w 1073
    //   592: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   595: putfield 1075	com/tencent/mobileqq/profile/ProfileCardTemplate:q	Ljava/lang/String;
    //   598: aload 7
    //   600: aload 5
    //   602: ldc_w 1077
    //   605: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   608: putfield 1079	com/tencent/mobileqq/profile/ProfileCardTemplate:s	Ljava/lang/String;
    //   611: aload 7
    //   613: aload 5
    //   615: ldc_w 1081
    //   618: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   621: putfield 1083	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_k_of_type_Int	I
    //   624: aload 7
    //   626: aload 5
    //   628: ldc_w 1085
    //   631: invokevirtual 993	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   634: putfield 1087	com/tencent/mobileqq/profile/ProfileCardTemplate:x	Ljava/lang/String;
    //   637: aload 7
    //   639: aload 5
    //   641: ldc_w 1089
    //   644: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   647: putfield 1091	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_l_of_type_Int	I
    //   650: aload 7
    //   652: aload 5
    //   654: ldc_w 1093
    //   657: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   660: putfield 1095	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_m_of_type_Int	I
    //   663: aload 7
    //   665: aload 5
    //   667: ldc_w 1097
    //   670: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   673: putfield 1099	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_n_of_type_Int	I
    //   676: aload 7
    //   678: aload 5
    //   680: ldc_w 1101
    //   683: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   686: putfield 1103	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_h_of_type_Int	I
    //   689: aload 7
    //   691: aload 5
    //   693: ldc_w 1105
    //   696: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   699: putfield 1107	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_i_of_type_Int	I
    //   702: aload 7
    //   704: aload 5
    //   706: ldc_w 1109
    //   709: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   712: putfield 1111	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_j_of_type_Int	I
    //   715: aload 5
    //   717: ldc_w 1113
    //   720: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   723: istore 10
    //   725: aload 7
    //   727: aload 5
    //   729: ldc_w 1115
    //   732: invokevirtual 989	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   735: putfield 1117	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_o_of_type_Int	I
    //   738: iload 10
    //   740: iconst_1
    //   741: if_icmpne +28 -> 769
    //   744: iconst_1
    //   745: istore_1
    //   746: aload 7
    //   748: iload_1
    //   749: putfield 1119	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_a_of_type_Boolean	Z
    //   752: aload 6
    //   754: aload 7
    //   756: invokevirtual 1122	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   759: pop
    //   760: iload 8
    //   762: iconst_1
    //   763: iadd
    //   764: istore 8
    //   766: goto -492 -> 274
    //   769: iconst_0
    //   770: istore_1
    //   771: goto -25 -> 746
    //   774: aload_0
    //   775: ifnull +7 -> 782
    //   778: aload_0
    //   779: invokevirtual 942	java/io/InputStream:close	()V
    //   782: aload_3
    //   783: ifnull -594 -> 189
    //   786: aload_3
    //   787: invokevirtual 943	java/io/ByteArrayOutputStream:close	()V
    //   790: goto -601 -> 189
    //   793: astore_0
    //   794: aload_0
    //   795: invokevirtual 1123	java/io/IOException:printStackTrace	()V
    //   798: goto -609 -> 189
    //   801: astore_0
    //   802: aload_0
    //   803: invokevirtual 1123	java/io/IOException:printStackTrace	()V
    //   806: goto -617 -> 189
    //   809: astore_2
    //   810: aconst_null
    //   811: astore_3
    //   812: aconst_null
    //   813: astore_0
    //   814: aload_0
    //   815: ifnull +7 -> 822
    //   818: aload_0
    //   819: invokevirtual 942	java/io/InputStream:close	()V
    //   822: aload_3
    //   823: ifnull +7 -> 830
    //   826: aload_3
    //   827: invokevirtual 943	java/io/ByteArrayOutputStream:close	()V
    //   830: aload_2
    //   831: athrow
    //   832: astore_0
    //   833: aload_0
    //   834: invokevirtual 1123	java/io/IOException:printStackTrace	()V
    //   837: goto -7 -> 830
    //   840: astore_2
    //   841: aconst_null
    //   842: astore_3
    //   843: goto -29 -> 814
    //   846: astore_2
    //   847: goto -33 -> 814
    //   850: astore 4
    //   852: aload_2
    //   853: astore_3
    //   854: aload 4
    //   856: astore_2
    //   857: goto -43 -> 814
    //   860: astore_3
    //   861: aconst_null
    //   862: astore_0
    //   863: goto -694 -> 169
    //   866: astore_3
    //   867: goto -698 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	paramQQAppInterface	QQAppInterface
    //   0	870	1	paramBoolean	boolean
    //   1	281	2	localObject1	Object
    //   809	22	2	localObject2	Object
    //   840	1	2	localObject3	Object
    //   846	7	2	localObject4	Object
    //   856	1	2	localObject5	Object
    //   37	817	3	localObject6	Object
    //   860	1	3	localThrowable1	Throwable
    //   866	1	3	localThrowable2	Throwable
    //   26	164	4	str	String
    //   850	5	4	localObject7	Object
    //   162	5	5	localThrowable3	Throwable
    //   287	441	5	localJSONObject	org.json.JSONObject
    //   104	649	6	localArrayList	ArrayList
    //   296	459	7	localProfileCardTemplate	ProfileCardTemplate
    //   143	622	8	i1	int
    //   269	10	9	i2	int
    //   723	19	10	i3	int
    //   42	65	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   128	134	162	java/lang/Throwable
    //   134	145	162	java/lang/Throwable
    //   151	159	162	java/lang/Throwable
    //   216	271	162	java/lang/Throwable
    //   281	738	162	java/lang/Throwable
    //   746	760	162	java/lang/Throwable
    //   778	782	793	java/io/IOException
    //   786	790	793	java/io/IOException
    //   177	181	801	java/io/IOException
    //   185	189	801	java/io/IOException
    //   111	120	809	finally
    //   202	213	809	finally
    //   818	822	832	java/io/IOException
    //   826	830	832	java/io/IOException
    //   120	128	840	finally
    //   128	134	846	finally
    //   134	145	846	finally
    //   151	159	846	finally
    //   216	271	846	finally
    //   281	738	846	finally
    //   746	760	846	finally
    //   169	173	850	finally
    //   111	120	860	java/lang/Throwable
    //   202	213	860	java/lang/Throwable
    //   120	128	866	java/lang/Throwable
  }
  
  public static ArrayList a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "getProfileTemplateList isReturnHidden=" + paramBoolean1 + ",returnExpire=" + paramBoolean2);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramQQAppInterface, false);
    if (!((ArrayList)localObject).isEmpty())
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ProfileCardTemplate localProfileCardTemplate = (ProfileCardTemplate)((Iterator)localObject).next();
        if ((paramBoolean1) || (!localProfileCardTemplate.jdField_a_of_type_Boolean)) {
          if (paramBoolean2) {
            localArrayList.add(localProfileCardTemplate);
          } else if (a(paramQQAppInterface, localProfileCardTemplate)) {
            localArrayList.add(localProfileCardTemplate);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "initAvatarUploadState");
    }
    jdField_b_of_type_Boolean = false;
    W = null;
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString)
  {
    a(paramActivity, paramView, paramString, false, false);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("curType", paramInt);
    paramView = AnimationUtils.a(paramView);
    localIntent.putExtra("is_from_face2face_add_friend", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    paramView = AnimationUtils.a(paramView);
    localIntent.putExtra("extra_pendant_id", paramLong);
    localIntent.putExtra("extra_action_source", paramInt);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    localIntent.putExtra("requestType", 881);
    localIntent.putExtra("is_hide_actionsheet", paramBoolean1);
    localIntent.putExtra("is_hide_footbar", paramBoolean2);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, "", false);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    a(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramBoolean, false, "");
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("has_red_dot", paramBoolean2);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramString2 = IndividuationUrlHelper.a(paramActivity, "card", paramString2);
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString2 + "&" + paramString3;
    }
    paramString2 = paramString1 + "&entryId=" + paramInt2 + "&isCache=" + paramInt1 + "&tabId=" + paramInt3;
    if ((paramActivity instanceof IndividuationSetActivity))
    {
      localIntent.putExtra("individuation_url_type", 40100);
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString4)) {
        paramString1 = paramString2 + "&rec_id=" + paramString4;
      }
    }
    for (;;)
    {
      localIntent.putExtra("url", paramString1);
      VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, paramString1, -1L, localIntent, paramBoolean1, 1008);
      return;
      paramString1 = paramString2;
      if ((paramActivity instanceof FriendProfileCardActivity)) {
        if (paramInt2 == 0)
        {
          localIntent.putExtra("individuation_url_type", 40202);
          paramString1 = paramString2;
        }
        else if (paramInt2 == 1)
        {
          localIntent.putExtra("individuation_url_type", 40203);
          paramString1 = paramString2;
        }
        else
        {
          paramString1 = paramString2;
          if (paramInt2 == 3)
          {
            localIntent.putExtra("individuation_url_type", 40204);
            paramString1 = paramString2;
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("url", String.format(IndividuationUrlHelper.a("rareCard"), new Object[] { Long.valueOf(paramLong) }));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Resources paramResources, View paramView, StatusManager paramStatusManager, RichStatus paramRichStatus, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i2 = 0;
    TextView localTextView = (TextView)paramView.findViewById(2131297124);
    ImageView localImageView = (ImageView)paramView.findViewById(2131297122);
    if (paramRichStatus != null) {
      localObject1 = paramRichStatus.toSpannableString(null, -8947849, paramResources.getColor(2131427409));
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new SpannableString("");
    }
    int i1;
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
      ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
      if (paramStatusManager != null)
      {
        localObject1 = paramStatusManager.a(paramRichStatus.actionId, 200);
        localObject1 = new StatableBitmapDrawable(paramResources, (Bitmap)localObject1, false, false);
        i1 = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i1, i1);
        localObject1 = new OffsetableImageSpan((Drawable)localObject1, 0);
        ((OffsetableImageSpan)localObject1).a(-0.1F);
        ((SpannableStringBuilder)localObject2).setSpan(localObject1, 0, "[S]".length(), 17);
        localTextView.setText((CharSequence)localObject2);
        label208:
        if (!paramBoolean) {
          break label543;
        }
        if (paramStatusManager != null) {
          break label452;
        }
        paramBoolean = false;
      }
    }
    for (;;)
    {
      label220:
      if (paramBoolean)
      {
        i1 = 2130838325;
        label230:
        paramResources = paramResources.getDrawable(i1);
        if (localImageView.getDrawable() != paramResources)
        {
          localImageView.setImageDrawable(paramResources);
          if ((paramResources instanceof Animatable)) {
            ((Animatable)paramResources).start();
          }
        }
        paramResources = "";
        if (paramRichStatus == null) {
          break label475;
        }
        if (paramRichStatus.actionText != null) {
          paramResources = "" + paramRichStatus.actionText;
        }
        paramStatusManager = paramResources;
        if (paramRichStatus.dataText != null) {
          paramStatusManager = paramResources + paramRichStatus.dataText;
        }
        if (paramRichStatus.plainText == null) {
          break label469;
        }
        i1 = paramRichStatus.plainText.size();
        label352:
        paramResources = paramStatusManager;
        label354:
        paramStatusManager = paramResources;
        if (i2 >= i1) {
          break label478;
        }
        paramStatusManager = (String)paramRichStatus.plainText.get(i2);
        if (TextUtils.isEmpty(paramStatusManager)) {
          break label540;
        }
        paramResources = paramResources + paramStatusManager;
      }
      label452:
      label469:
      label475:
      label478:
      label540:
      for (;;)
      {
        i2 += 1;
        break label354;
        localObject1 = BitmapManager.a(paramResources, 2130842868);
        break;
        if (((SpannableString)localObject2).length() == 0)
        {
          localTextView.setText("无最新签名");
          break label208;
        }
        localTextView.setText((CharSequence)localObject2);
        break label208;
        paramBoolean = paramStatusManager.a();
        break label220;
        i1 = 2130838201;
        break label230;
        i1 = 0;
        break label352;
        paramStatusManager = "";
        if ((paramView.getTag() instanceof DataTag)) {
          ((DataTag)paramView.getTag()).a = paramStatusManager;
        }
        for (;;)
        {
          paramView.setContentDescription("个性签名是" + paramStatusManager);
          return;
          paramView.setTag(new DataTag(3, paramStatusManager));
        }
      }
      label543:
      paramBoolean = false;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "safetyReport param null");
      }
      return;
    }
    paramString3 = new QQProgressDialog(paramBaseActivity, paramBaseActivity.getTitleBarHeight());
    try
    {
      paramString3.show();
      ThreadManager.a(new vyz(paramInt, paramString2, paramBaseActivity, paramString1, paramString3), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.a(new vzd(paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, null, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramQQAppInterface.a(new vzc(paramQQAppInterface, paramLong1, paramLong2, paramString, paramInt));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      DynamicFaceDrawable localDynamicFaceDrawable = ((DynamicAvatarView)paramView).a;
      if ((localDynamicFaceDrawable != null) && (localDynamicFaceDrawable.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localDynamicFaceDrawable.d)))
      {
        b(paramActivity, paramView, localDynamicFaceDrawable.d);
        paramInt1 = 1;
        if (paramInt2 == 0) {
          if (paramInt1 == 0) {
            break label158;
          }
        }
      }
    }
    label158:
    for (paramActivity = "1";; paramActivity = "0")
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, paramActivity, "", "", "");
      return;
      if (paramInt2 == 1)
      {
        a(paramActivity, paramView, paramString, paramInt1);
        paramInt1 = 0;
        break;
      }
      a(paramActivity, paramView, paramString, true, true);
      for (;;)
      {
        paramInt1 = 0;
        break;
        if (paramInt2 == 1)
        {
          a(paramActivity, paramView, paramString, paramInt1);
          paramInt1 = 0;
          break;
        }
        a(paramActivity, paramView, paramString, true, true);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = new URL("profile_img_thumb", null, paramQQAppInterface.a(false, paramString));
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.remove(paramQQAppInterface.toString());
      }
      paramQQAppInterface = new URL("profile_img_big", null, a(paramString));
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.remove(paramQQAppInterface.toString());
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, "", paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir clear old version template dir");
    }
    paramQQAppInterface = paramQQAppInterface.a().getDir("profilecard", 0).getAbsolutePath();
    try
    {
      File[] arrayOfFile = new File(paramQQAppInterface).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
        while (i1 < arrayOfFile.length)
        {
          String str = arrayOfFile[i1].getName();
          if ((str.startsWith(String.valueOf(paramString1))) && (!str.endsWith(paramString2)))
          {
            str = paramQQAppInterface + File.separator + String.valueOf(paramString1) + "_" + str;
            FileUtils.a(str);
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir old dir=" + str);
            }
          }
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "test start");
    }
    String str1 = a(paramByteStringMicro);
    byte[] arrayOfByte1 = a(str1);
    String str2 = a(arrayOfByte1);
    byte[] arrayOfByte2 = new byte[paramByteStringMicro.size()];
    paramByteStringMicro.copyTo(arrayOfByte2, 0);
    if ((Utils.a(str1, str2)) && (QLog.isColorLevel())) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "bsm -> str, str -> bs, bs -> str : 相等");
    }
    if ((a(arrayOfByte1, arrayOfByte2)) && (QLog.isColorLevel())) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "bsm -> str, str -> bs, bsm -> bs : 相等");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, "test end");
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|false");
      }
      jdField_b_of_type_Boolean = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|true");
    }
    W = paramString;
    jdField_b_of_type_Boolean = true;
  }
  
  public static final void a(String paramString1, int paramInt, String paramString2)
  {
    if (jdField_a_of_type_JavaLangStringBuilder == null) {
      jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(120);
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangStringBuilder.append(paramString1).append(", reason = [").append(paramString2).append("], code = [").append(paramInt).append("]");
      QLog.i("UPLOAD_AVATAR_FAIL", 1, jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
  }
  
  public static void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, long paramLong1, int paramInt2, int paramInt3, long paramLong2, String paramString4, String paramString5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doStaticForVoiceTransfer()").append(", uin = ").append(paramString1).append(", nOpType = ").append(paramInt1).append(", isSuccess = ").append(paramBoolean).append(", filekey = ").append(paramString2).append(", ip = ").append(paramString3).append(", duration = ").append(paramLong1).append(", retry_count = ").append(paramInt2).append(", failCode = ").append(paramInt3).append(", fileSize = ").append(paramLong2).append(", errorMsg = ").append(paramString4).append(", rspHeader = ").append(paramString5);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 0) {}
    HashMap localHashMap;
    for (localObject = "actIntroPttUpload";; localObject = "actIntroPttDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("serverip", paramString3);
      localHashMap.put("param_uuid", paramString2);
      if (!paramBoolean) {
        break;
      }
      localHashMap.put("param_retry", String.valueOf(paramInt2));
      StatisticCollector.a(BaseApplication.getContext()).a(paramString1, (String)localObject, paramBoolean, paramLong1, paramLong2, localHashMap, "", false);
      return;
    }
    if (!BaseTransProcessor.a(paramInt3, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt3));
      if ((paramInt3 == 56009) || (paramInt3 == 9311) || (paramInt3 == 9044) || (paramInt3 == 9350) || (paramInt3 == 9351))
      {
        localHashMap.put(BaseTransProcessor.be, paramString4);
        label315:
        if (paramInt1 == 1) {
          localHashMap.put("param_url", paramString3);
        }
        if (paramString5 == null) {
          break label378;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("param_rspHeader", paramString5);
      break;
      localHashMap.put("param_errorDesc", paramString4);
      break label315;
      localHashMap.put("param_errorDesc", paramString4);
      break label315;
      label378:
      paramString5 = "";
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramActivity == null)) {
      return;
    }
    if (((QidianManager)paramQQAppInterface.getManager(164)).a(paramString)) {}
    for (paramString = String.format("http://datacard.qidian.qq.com/static/1_%s_more.htm?appid=%s&version=%s&_wv=1027", new Object[] { paramString, String.valueOf(paramQQAppInterface.a()), "android-6.5.5" });; paramString = String.format("http://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString, String.valueOf(paramQQAppInterface.a()), "android-6.5.5" }))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails() url = " + paramString);
      }
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("uin", paramQQAppInterface.a());
      localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
      localIntent.putExtra("reqType", 1);
      paramActivity.startActivity(localIntent);
      return;
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramActivity == null)) {
      return;
    }
    paramString = String.format("http://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString, String.valueOf(paramQQAppInterface.a()), "android-6.5.5" });
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails() url = " + paramString);
    }
    Intent localIntent = new Intent(paramActivity, FriendProfileMoreInfoActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("uin", paramQQAppInterface.a());
    localIntent.putExtra("AllInOne", paramAllInOne);
    localIntent.putExtra("DynamicAvatarTips", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 1022);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = HexUtil.a(paramArrayOfByte);
      String str = HexUtil.a(paramArrayOfByte);
      ThreadManager.a(new vyx(str, b(paramArrayOfByte)), 8, null, false);
      b(str);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, paramArrayOfByte.toString());
    }
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = a(paramContext, paramString);
    boolean bool1;
    try
    {
      paramContext = new File(paramContext);
      if ((paramContext.exists()) && (paramContext.isFile()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is exists");
        }
      }
      else
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is not exists");
        return false;
      }
    }
    catch (Exception paramContext)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource exception msg=" + paramContext.getMessage());
        return false;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject = a(paramQQAppInterface, -1L);
    if (localObject != null)
    {
      paramQQAppInterface = new File((String)localObject);
      localObject = new File((String)localObject + File.separator + "config_black.json");
      bool1 = bool2;
      if (paramQQAppInterface.isDirectory())
      {
        bool1 = bool2;
        if (((File)localObject).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common dir exists=" + paramQQAppInterface.isDirectory() + " templateConfig exists= " + ((File)localObject).exists());
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common path is null");
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, ProfileCardTemplate paramProfileCardTemplate)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    if (((paramProfileCardTemplate.jdField_m_of_type_Int > 100) && (l1 < paramProfileCardTemplate.jdField_m_of_type_Int)) || ((paramProfileCardTemplate.jdField_n_of_type_Int > 100) && (l1 > paramProfileCardTemplate.jdField_n_of_type_Int)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ProfileCardUtil", 2, "filterTemplate->sytle:" + paramProfileCardTemplate.jdField_i_of_type_Long + ",beginTime:" + paramProfileCardTemplate.jdField_m_of_type_Int + ",endTime:" + paramProfileCardTemplate.jdField_n_of_type_Int);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    File localFile = new File(paramString);
    long l1 = localFile.length();
    if ((!localFile.exists()) || (l1 <= 0L) || (l1 >= 614400L))
    {
      a("onAvatarChanged", 0, String.valueOf(l1));
      return false;
    }
    if (!NetworkUtil.e(paramQQAppInterface.a()))
    {
      a("onAvatarChanged", 1, "net_not_support");
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|start upload : size = " + l1);
    }
    a(paramString);
    paramQQAppInterface.a().a(paramQQAppInterface, paramString);
    return true;
  }
  
  public static boolean a(ProfileCardBackground paramProfileCardBackground)
  {
    return paramProfileCardBackground.jdField_a_of_type_Int == 160;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = a(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.Avatar", 2, paramString.toString());
    }
    return bool1;
    return false;
  }
  
  public static boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(2));
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i1;
    int i2;
    label12:
    label20:
    boolean bool2;
    if (paramArrayOfByte1 == null)
    {
      i1 = 0;
      if (paramArrayOfByte2 != null) {
        break label74;
      }
      i2 = 0;
      if (i1 != i2) {
        break label80;
      }
      bool1 = true;
      bool2 = bool1;
      if (!bool1) {
        break label92;
      }
      i2 = 0;
      label31:
      bool2 = bool1;
      if (!bool1) {
        break label92;
      }
      bool2 = bool1;
      if (i2 >= i1) {
        break label92;
      }
      if (paramArrayOfByte1[i2] != paramArrayOfByte2[i2]) {
        break label86;
      }
    }
    label74:
    label80:
    label86:
    for (boolean bool1 = true;; bool1 = false)
    {
      i2 += 1;
      break label31;
      i1 = paramArrayOfByte1.length;
      break;
      i2 = paramArrayOfByte2.length;
      break label12;
      bool1 = false;
      break label20;
    }
    label92:
    return bool2;
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = null;
    if (!TextUtils.isEmpty(paramString)) {
      arrayOfByte = HexUtil.a(paramString);
    }
    return arrayOfByte;
  }
  
  public static int b(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static int b(Context paramContext)
  {
    return (int)(0.5633803F * a(paramContext));
  }
  
  public static final int b(Context paramContext, int paramInt)
  {
    return (int)Math.floor(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static long b()
  {
    try
    {
      if (Utils.b()) {
        return Utils.a(new File(AppConstants.bh));
      }
      long l1 = Utils.a(new File(Environment.getRootDirectory().getPath()));
      return l1;
    }
    catch (Exception localException) {}
    return -1L;
  }
  
  public static String b()
  {
    return W;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getDir("profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_template.json" + "6.5.5";
  }
  
  public static String b(Context paramContext, ProfileCardInfo paramProfileCardInfo)
  {
    int i2 = -1;
    String str = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i1;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1))
    {
      i1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
      if (i1 != 0) {
        break label151;
      }
      str = paramContext.getString(2131368209);
    }
    for (;;)
    {
      return str + a(paramContext, paramProfileCardInfo);
      if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
      {
        i1 = localCard.shGender;
        break;
      }
      i1 = i2;
      if (localContactCard == null) {
        break;
      }
      if (localContactCard.bSex != 0)
      {
        i1 = i2;
        if (localContactCard.bSex != 1) {
          break;
        }
      }
      i1 = localContactCard.bSex;
      break;
      label151:
      if (i1 == 1) {
        str = paramContext.getString(2131368210);
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public static void b(Activity paramActivity, View paramView, String paramString)
  {
    Object localObject = new PicInfo();
    ((PicInfo)localObject).d = paramString;
    paramString = new ArrayList(1);
    paramString.add(localObject);
    localObject = new Intent(paramActivity, NearbyProfilePicBrowserActivity.class);
    ((Intent)localObject).putExtra("intent_param_index", 0);
    ((Intent)localObject).putExtra("intent_param_pic_infos", paramString);
    ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    ((Intent)localObject).addFlags(536870912);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public static boolean b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(1));
  }
  
  public static int c(Activity paramActivity)
  {
    return b(paramActivity) * 3 / 4;
  }
  
  public static final int c(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.c).append("temp").append("/").append(System.currentTimeMillis()).append("_cardbg.tmp");
    return localStringBuilder.toString();
  }
  
  public static String c(Context paramContext)
  {
    if (Utils.b()) {
      return AppConstants.cK;
    }
    return paramContext.getDir("profilecard", 0).getAbsoluteFile() + File.separator;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = 0;
    while (i1 < paramString.length())
    {
      localStringBuffer.append(Character.toLowerCase(paramString.charAt(i1)));
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.a().post(new vyy(paramString));
  }
  
  public static boolean c(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(3));
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return MD5.toMD5(paramString);
  }
  
  public static boolean d(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    while ((!b(paramArrayList)) && (!c(paramArrayList)) && (!a(paramArrayList))) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\ProfileCardUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */