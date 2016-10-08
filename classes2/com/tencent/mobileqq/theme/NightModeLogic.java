package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import uzk;
import uzl;
import uzm;
import uzn;
import uzo;
import uzp;

public class NightModeLogic
{
  public static final int a = 0;
  public static final String a = "ThemeSwitch";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  static final int h = 4097;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Dialog a;
  public Handler.Callback a;
  public NightModeLogic.NightModeCallback a;
  private ThemeSwitchManager jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager;
  private ThemeUtil.ThemeInfo jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  public AppRuntime a;
  boolean jdField_a_of_type_Boolean;
  private Activity jdField_b_of_type_AndroidAppActivity;
  private final String jdField_b_of_type_JavaLangString;
  private final String c;
  
  public NightModeLogic(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "6.5.5night_theme_json.xml";
    this.c = "http://i.gtimg.cn/qqshow/admindata/comdata/vipData_theme_night/xydata.json";
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new uzo(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new uzp(this);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a();
  }
  
  private int a(String paramString1, String paramString2)
  {
    int m = 0;
    int j;
    if ((paramString1 == null) || (paramString2 == null))
    {
      j = 1;
      return j;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int n = Math.max(paramString1.length, paramString2.length);
    int i = 0;
    for (;;)
    {
      j = m;
      if (i >= n) {
        break;
      }
      if (i >= paramString1.length)
      {
        j = 0;
        if (i < paramString2.length) {
          break label93;
        }
      }
      label93:
      for (int k = 0;; k = Integer.valueOf(paramString2[i]).intValue())
      {
        if (j <= k) {
          break label107;
        }
        return 1;
        j = Integer.valueOf(paramString1[i]).intValue();
        break;
      }
      label107:
      if (j < k) {
        return -1;
      }
      i += 1;
    }
  }
  
  private Dialog a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt1);
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt2);
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt3);
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(paramInt4);
    if ((paramString != null) && (!"".equals(paramString))) {}
    for (paramString = String.format((String)localObject1, new Object[] { paramString });; paramString = (String)localObject1)
    {
      localObject1 = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131558973);
      ((Dialog)localObject1).setContentView(2130903236);
      TextView localTextView = (TextView)((Dialog)localObject1).findViewById(2131297840);
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject2);
      }
      localObject2 = (TextView)((Dialog)localObject1).findViewById(2131296852);
      if (localObject2 != null) {
        ((TextView)localObject2).setText(paramString);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131297843);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setOnClickListener(paramOnClickListener1);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131297844);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setOnClickListener(paramOnClickListener2);
      }
      return (Dialog)localObject1;
    }
  }
  
  /* Error */
  private boolean a(org.json.JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +484 -> 485
    //   4: aload_0
    //   5: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   8: aload_1
    //   9: ldc -94
    //   11: invokevirtual 167	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokevirtual 171	java/lang/String:trim	()Ljava/lang/String;
    //   17: putfield 176	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   20: aload_0
    //   21: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   24: aload_1
    //   25: ldc -78
    //   27: invokevirtual 167	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 171	java/lang/String:trim	()Ljava/lang/String;
    //   33: invokestatic 184	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   36: putfield 188	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   39: aload_0
    //   40: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   43: aload_1
    //   44: ldc -66
    //   46: invokevirtual 167	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   49: invokevirtual 171	java/lang/String:trim	()Ljava/lang/String;
    //   52: putfield 192	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   55: aload_0
    //   56: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   59: invokevirtual 198	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   62: invokevirtual 204	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   65: aload_0
    //   66: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   69: getfield 207	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   72: invokestatic 213	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull +63 -> 140
    //   80: aload_3
    //   81: getfield 192	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   84: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +53 -> 140
    //   90: aload_0
    //   91: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   94: getfield 192	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   97: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +40 -> 140
    //   103: aload_3
    //   104: getfield 192	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   107: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   110: invokevirtual 93	java/lang/Integer:intValue	()I
    //   113: aload_0
    //   114: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   117: getfield 192	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   120: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   123: invokevirtual 93	java/lang/Integer:intValue	()I
    //   126: if_icmple +14 -> 140
    //   129: aload_0
    //   130: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   133: aload_3
    //   134: getfield 192	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   137: putfield 192	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   140: aload_2
    //   141: ifnull +69 -> 210
    //   144: aload_0
    //   145: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   148: invokevirtual 198	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   151: invokevirtual 204	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   154: invokestatic 223	com/tencent/mobileqq/theme/ThemeUtil:getThemePreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   157: astore_3
    //   158: new 225	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   165: ldc -28
    //   167: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_2
    //   171: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc -22
    //   176: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc -20
    //   181: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore_2
    //   188: aload_3
    //   189: invokeinterface 245 1 0
    //   194: aload_2
    //   195: aload_1
    //   196: invokevirtual 246	org/json/JSONObject:toString	()Ljava/lang/String;
    //   199: invokeinterface 252 3 0
    //   204: invokeinterface 256 1 0
    //   209: pop
    //   210: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +67 -> 280
    //   216: ldc 10
    //   218: iconst_2
    //   219: new 225	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 263
    //   229: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_0
    //   233: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   236: getfield 176	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downloadUrl	Ljava/lang/String;
    //   239: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 265
    //   245: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_0
    //   249: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   252: getfield 188	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   255: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   258: ldc_w 270
    //   261: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: getfield 160	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo	Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   268: getfield 192	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   271: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: iconst_1
    //   281: ireturn
    //   282: astore_1
    //   283: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +32 -> 318
    //   289: ldc 10
    //   291: iconst_2
    //   292: new 225	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 275
    //   302: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_1
    //   306: invokevirtual 278	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   309: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: ldc_w 280
    //   321: astore_1
    //   322: aload_1
    //   323: ifnull +117 -> 440
    //   326: ldc 10
    //   328: iconst_1
    //   329: new 225	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 282
    //   339: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_1
    //   343: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: new 286	java/util/HashMap
    //   355: dup
    //   356: invokespecial 287	java/util/HashMap:<init>	()V
    //   359: astore_2
    //   360: aload_2
    //   361: ldc_w 289
    //   364: aload_1
    //   365: invokevirtual 293	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   368: pop
    //   369: aload_0
    //   370: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   373: invokevirtual 198	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   376: invokevirtual 204	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   379: invokestatic 298	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   382: aload_0
    //   383: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   386: checkcast 300	com/tencent/mobileqq/app/QQAppInterface
    //   389: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   392: ldc_w 305
    //   395: iconst_0
    //   396: lconst_1
    //   397: lconst_0
    //   398: aload_2
    //   399: ldc 112
    //   401: iconst_0
    //   402: invokevirtual 308	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   405: getstatic 313	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   408: invokevirtual 316	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   411: checkcast 300	com/tencent/mobileqq/app/QQAppInterface
    //   414: ldc_w 318
    //   417: ldc_w 320
    //   420: sipush 151
    //   423: aconst_null
    //   424: invokestatic 325	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   427: bipush -6
    //   429: ldc_w 327
    //   432: ldc 112
    //   434: aload_1
    //   435: ldc 112
    //   437: invokestatic 332	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   440: iconst_0
    //   441: ireturn
    //   442: astore_1
    //   443: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +32 -> 478
    //   449: ldc 10
    //   451: iconst_2
    //   452: new 225	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 334
    //   462: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_1
    //   466: invokevirtual 335	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   469: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: ldc_w 337
    //   481: astore_1
    //   482: goto -160 -> 322
    //   485: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +12 -> 500
    //   491: ldc 10
    //   493: iconst_2
    //   494: ldc_w 339
    //   497: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: ldc_w 341
    //   503: astore_1
    //   504: goto -182 -> 322
    //   507: astore_1
    //   508: goto -68 -> 440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	NightModeLogic
    //   0	511	1	paramJSONObject	org.json.JSONObject
    //   0	511	2	paramString	String
    //   75	114	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	76	282	org/json/JSONException
    //   80	140	282	org/json/JSONException
    //   144	210	282	org/json/JSONException
    //   210	280	282	org/json/JSONException
    //   4	76	442	java/lang/Exception
    //   80	140	442	java/lang/Exception
    //   144	210	442	java/lang/Exception
    //   210	280	442	java/lang/Exception
    //   352	440	507	java/lang/Exception
  }
  
  /* Error */
  private boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   4: ifnonnull +14 -> 18
    //   7: ldc 10
    //   9: iconst_2
    //   10: ldc_w 343
    //   13: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   22: invokevirtual 198	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   25: invokevirtual 204	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   28: invokestatic 347	com/tencent/mobileqq/theme/ThemeUtil:getThemeDensity	(Landroid/content/Context;)Ljava/lang/String;
    //   31: astore 4
    //   33: ldc_w 349
    //   36: astore_3
    //   37: aload_3
    //   38: astore_2
    //   39: iload_1
    //   40: ifne +106 -> 146
    //   43: aload_0
    //   44: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   47: invokevirtual 198	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   50: invokevirtual 204	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   53: invokestatic 223	com/tencent/mobileqq/theme/ThemeUtil:getThemePreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   56: astore_2
    //   57: new 225	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   64: ldc -28
    //   66: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 4
    //   71: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc -22
    //   76: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc -20
    //   81: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 6
    //   89: aload_2
    //   90: aload 6
    //   92: aconst_null
    //   93: invokeinterface 352 3 0
    //   98: astore 5
    //   100: aload 5
    //   102: ifnull +312 -> 414
    //   105: aload_0
    //   106: new 164	org/json/JSONObject
    //   109: dup
    //   110: aload 5
    //   112: invokespecial 355	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   115: aconst_null
    //   116: invokespecial 357	com/tencent/mobileqq/theme/NightModeLogic:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   119: ifeq +5 -> 124
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_2
    //   125: invokeinterface 245 1 0
    //   130: aload 6
    //   132: aconst_null
    //   133: invokeinterface 252 3 0
    //   138: invokeinterface 256 1 0
    //   143: pop
    //   144: aload_3
    //   145: astore_2
    //   146: new 359	java/io/File
    //   149: dup
    //   150: new 225	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   157: getstatic 364	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   160: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 366
    //   166: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: ldc 43
    //   174: invokespecial 369	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: astore_3
    //   178: aload_3
    //   179: invokevirtual 372	java/io/File:exists	()Z
    //   182: ifeq +686 -> 868
    //   185: aload_3
    //   186: invokevirtual 375	java/io/File:isFile	()Z
    //   189: ifeq +679 -> 868
    //   192: aload_3
    //   193: invokestatic 380	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)Ljava/lang/String;
    //   196: astore 5
    //   198: new 164	org/json/JSONObject
    //   201: dup
    //   202: aload 5
    //   204: invokespecial 355	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   207: ldc_w 382
    //   210: invokevirtual 386	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   213: ldc_w 388
    //   216: invokevirtual 392	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   219: astore 6
    //   221: aload 6
    //   223: invokevirtual 397	org/json/JSONArray:length	()I
    //   226: iconst_1
    //   227: isub
    //   228: istore 7
    //   230: aconst_null
    //   231: astore_3
    //   232: iload 7
    //   234: iflt +87 -> 321
    //   237: aload 6
    //   239: iload 7
    //   241: invokevirtual 400	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   244: astore_3
    //   245: aload_3
    //   246: ifnull +190 -> 436
    //   249: ldc_w 402
    //   252: aload_3
    //   253: ldc_w 404
    //   256: invokevirtual 167	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifeq +174 -> 436
    //   265: ldc_w 327
    //   268: aload_3
    //   269: ldc_w 406
    //   272: invokevirtual 167	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifeq +158 -> 436
    //   281: aload_0
    //   282: ldc -20
    //   284: aload_3
    //   285: ldc_w 408
    //   288: invokevirtual 167	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokespecial 410	com/tencent/mobileqq/theme/NightModeLogic:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   294: iflt +142 -> 436
    //   297: aload_0
    //   298: ldc -20
    //   300: aload_3
    //   301: ldc_w 412
    //   304: invokevirtual 167	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   307: invokespecial 410	com/tencent/mobileqq/theme/NightModeLogic:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   310: ifgt +126 -> 436
    //   313: aload_3
    //   314: ldc_w 414
    //   317: invokevirtual 386	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   320: astore_3
    //   321: aload_3
    //   322: ifnull +123 -> 445
    //   325: aload_0
    //   326: aload_3
    //   327: aload 4
    //   329: invokevirtual 386	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   332: aload 4
    //   334: invokespecial 357	com/tencent/mobileqq/theme/NightModeLogic:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   337: istore 8
    //   339: iload 8
    //   341: ifeq +169 -> 510
    //   344: iconst_1
    //   345: ireturn
    //   346: astore_3
    //   347: aload_2
    //   348: invokeinterface 245 1 0
    //   353: aload 6
    //   355: aconst_null
    //   356: invokeinterface 252 3 0
    //   361: invokeinterface 256 1 0
    //   366: pop
    //   367: ldc_w 416
    //   370: astore_2
    //   371: ldc 10
    //   373: iconst_1
    //   374: new 225	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 418
    //   384: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_3
    //   388: invokevirtual 335	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   391: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc_w 420
    //   397: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 5
    //   402: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: goto -265 -> 146
    //   414: aload_3
    //   415: astore_2
    //   416: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq -273 -> 146
    //   422: ldc 10
    //   424: iconst_2
    //   425: ldc_w 422
    //   428: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload_3
    //   432: astore_2
    //   433: goto -287 -> 146
    //   436: iload 7
    //   438: iconst_1
    //   439: isub
    //   440: istore 7
    //   442: goto -212 -> 230
    //   445: new 225	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   452: getstatic 364	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   455: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc_w 366
    //   461: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc 43
    //   466: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 425	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   475: pop
    //   476: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +31 -> 510
    //   482: ldc_w 427
    //   485: iconst_2
    //   486: new 225	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 429
    //   496: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload 5
    //   501: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: iload_1
    //   511: ifne +119 -> 630
    //   514: new 431	com/tencent/mobileqq/vip/DownloadTask
    //   517: dup
    //   518: ldc 47
    //   520: new 359	java/io/File
    //   523: dup
    //   524: new 225	java/lang/StringBuilder
    //   527: dup
    //   528: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   531: getstatic 364	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   534: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc_w 366
    //   540: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: ldc 43
    //   548: invokespecial 369	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: invokespecial 434	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   554: astore_3
    //   555: aload_3
    //   556: iconst_1
    //   557: putfield 437	com/tencent/mobileqq/vip/DownloadTask:l	Z
    //   560: aload_3
    //   561: iconst_0
    //   562: putfield 440	com/tencent/mobileqq/vip/DownloadTask:o	Z
    //   565: aload_0
    //   566: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   569: checkcast 300	com/tencent/mobileqq/app/QQAppInterface
    //   572: bipush 46
    //   574: invokevirtual 444	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   577: checkcast 446	com/tencent/mobileqq/vip/DownloaderFactory
    //   580: iconst_1
    //   581: invokevirtual 449	com/tencent/mobileqq/vip/DownloaderFactory:a	(I)Lcom/tencent/mobileqq/vip/DownloaderInterface;
    //   584: aload_3
    //   585: aload_0
    //   586: getfield 56	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_ComTencentMobileqqVipDownloadListener	Lcom/tencent/mobileqq/vip/DownloadListener;
    //   589: aconst_null
    //   590: invokeinterface 454 4 0
    //   595: getstatic 313	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   598: invokevirtual 316	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   601: checkcast 300	com/tencent/mobileqq/app/QQAppInterface
    //   604: ldc_w 318
    //   607: ldc_w 320
    //   610: sipush 151
    //   613: aconst_null
    //   614: invokestatic 325	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   617: bipush 32
    //   619: ldc 112
    //   621: ldc 112
    //   623: ldc -20
    //   625: ldc 112
    //   627: invokestatic 332	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   630: iload_1
    //   631: ifeq +132 -> 763
    //   634: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   637: ifeq +13 -> 650
    //   640: ldc_w 427
    //   643: iconst_2
    //   644: ldc_w 456
    //   647: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: new 286	java/util/HashMap
    //   653: dup
    //   654: invokespecial 287	java/util/HashMap:<init>	()V
    //   657: astore_3
    //   658: aload_3
    //   659: ldc_w 289
    //   662: aload_2
    //   663: invokevirtual 293	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   666: pop
    //   667: aload_0
    //   668: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   671: invokevirtual 198	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   674: invokevirtual 204	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   677: invokestatic 298	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   680: aload_0
    //   681: getfield 63	com/tencent/mobileqq/theme/NightModeLogic:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   684: checkcast 300	com/tencent/mobileqq/app/QQAppInterface
    //   687: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   690: ldc_w 305
    //   693: iconst_0
    //   694: lconst_1
    //   695: lconst_0
    //   696: aload_3
    //   697: ldc 112
    //   699: iconst_0
    //   700: invokevirtual 308	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   703: getstatic 313	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   706: invokevirtual 316	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   709: checkcast 300	com/tencent/mobileqq/app/QQAppInterface
    //   712: ldc_w 318
    //   715: ldc_w 320
    //   718: sipush 151
    //   721: aconst_null
    //   722: invokestatic 325	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   725: bipush -6
    //   727: ldc 112
    //   729: ldc 112
    //   731: aload_2
    //   732: ldc 112
    //   734: invokestatic 332	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   737: ldc 10
    //   739: iconst_1
    //   740: new 225	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   747: ldc_w 458
    //   750: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: aload_2
    //   754: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   766: ifeq +32 -> 798
    //   769: ldc 10
    //   771: iconst_2
    //   772: new 225	java/lang/StringBuilder
    //   775: dup
    //   776: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   779: ldc_w 460
    //   782: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: iload_1
    //   786: invokestatic 463	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   789: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   798: iconst_0
    //   799: ireturn
    //   800: astore_2
    //   801: new 225	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   808: getstatic 364	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   811: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: ldc_w 366
    //   817: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: ldc 43
    //   822: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 425	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   831: pop
    //   832: ldc 10
    //   834: iconst_1
    //   835: new 225	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 465
    //   845: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_2
    //   849: invokevirtual 335	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   852: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   861: ldc_w 467
    //   864: astore_2
    //   865: goto -355 -> 510
    //   868: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   871: ifeq +12 -> 883
    //   874: ldc 10
    //   876: iconst_2
    //   877: ldc_w 469
    //   880: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   883: goto -373 -> 510
    //   886: astore_3
    //   887: goto -184 -> 703
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	890	0	this	NightModeLogic
    //   0	890	1	paramBoolean	boolean
    //   38	716	2	localObject1	Object
    //   800	49	2	localException1	Exception
    //   864	1	2	str1	String
    //   36	291	3	localObject2	Object
    //   346	86	3	localException2	Exception
    //   554	143	3	localObject3	Object
    //   886	1	3	localException3	Exception
    //   31	302	4	str2	String
    //   98	402	5	str3	String
    //   87	267	6	localObject4	Object
    //   228	213	7	i	int
    //   337	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   105	122	346	java/lang/Exception
    //   124	144	346	java/lang/Exception
    //   192	230	800	java/lang/Exception
    //   237	245	800	java/lang/Exception
    //   249	321	800	java/lang/Exception
    //   325	339	800	java/lang/Exception
    //   445	510	800	java/lang/Exception
    //   634	650	886	java/lang/Exception
    //   650	703	886	java/lang/Exception
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "showDownloadDialog");
    }
    this.jdField_a_of_type_AndroidAppDialog = a(2131368384, 2131368385, 2131367262, 2131368801, (float)Math.round(a(false).size / 1024.0D / 1024.0D * 100.0D) / 100.0F + "", new uzk(this), new uzl(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new uzm(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public int a()
  {
    int i = 1;
    ThemeUtil.ThemeInfo localThemeInfo = a(true);
    if ((a()) || ((localThemeInfo != null) && (localThemeInfo.status.equals("2"))))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitch", 2, "switchRightViewImage status: juhua");
      }
      i = 0;
    }
    do
    {
      return i;
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ThemeSwitch", 2, "switchRightViewImage status: sun");
    return 1;
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "switchRightViewImage status: moon");
    }
    return 2;
  }
  
  public ThemeUtil.ThemeInfo a(boolean paramBoolean)
  {
    int j = 0;
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo;
    }
    ThemeUtil.ThemeInfo localThemeInfo = ThemeUtil.getThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), "1103");
    if ((localThemeInfo != null) && ((paramBoolean) || (a(localThemeInfo, false))))
    {
      int i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.version))
      {
        i = 0;
        if (!TextUtils.isEmpty(localThemeInfo.version)) {
          break label146;
        }
      }
      for (;;)
      {
        if (j < i) {
          break label161;
        }
        if (localThemeInfo.status.equals("2"))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ThemeSwitch", 2, "theme info status update");
          }
          localThemeInfo.status = "5";
          ThemeUtil.setThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext(), localThemeInfo);
        }
        return localThemeInfo;
        i = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.version).intValue();
        break;
        label146:
        j = Integer.valueOf(localThemeInfo.version).intValue();
      }
    }
    label161:
    return this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo = new ThemeUtil.ThemeInfo();
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.isVoiceTheme = false;
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.themeId = "1103";
    ThreadManager.a(new uzn(this), 8, null, true);
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager = ThemeSwitchManager.a(paramActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a(paramActivity);
  }
  
  public void a(NightModeLogic.NightModeCallback paramNightModeCallback)
  {
    a(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a(paramNightModeCallback, true, false);
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = paramNightModeCallback;
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ThemeSwitch", 2, "isDownloadOrSwtich isDownloadingInProgress=" + ThemeSwitchManager.b + "" + ", isSwitchTheme=" + ThemeSwitchManager.jdField_a_of_type_Boolean);
    }
    return (ThemeSwitchManager.b) || (ThemeSwitchManager.jdField_a_of_type_Boolean);
  }
  
  public boolean a(ThemeUtil.ThemeInfo paramThemeInfo, boolean paramBoolean)
  {
    boolean bool1;
    if (paramThemeInfo == null) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      Object localObject1 = ThemeUtil.getThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext(), paramThemeInfo.themeId);
      Object localObject2 = ThemeUtil.getThemeDownloadFilePath(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), paramThemeInfo.themeId, paramThemeInfo.version);
      Object localObject3 = ThemeUtil.getThemeResourcePath(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), paramThemeInfo.themeId, paramThemeInfo.version);
      localObject2 = new File((String)localObject2);
      boolean bool3 = true;
      boolean bool2 = true;
      bool1 = bool3;
      int i;
      if (localObject1 != null) {
        if (!((ThemeUtil.ThemeInfo)localObject1).status.equals("5"))
        {
          bool1 = bool3;
          if (!((ThemeUtil.ThemeInfo)localObject1).status.equals("3")) {}
        }
        else
        {
          File localFile = new File((String)localObject3);
          if (!localFile.exists()) {
            break label766;
          }
          if (QLog.isColorLevel()) {
            QLog.i("ThemeSwitch", 2, "isThemeExist themeResPath exists,themeResPath=" + (String)localObject3 + ",mIsStartNightMode:" + this.jdField_a_of_type_Boolean);
          }
          if (!this.jdField_a_of_type_Boolean) {
            return true;
          }
          i = ThemeJsPlugin.getFileNumInFile(localFile);
          if ((i > 0) && (i >= ((ThemeUtil.ThemeInfo)localObject1).fileNum - 15))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ThemeSwitch", 2, "NightModeLogic isThemeExist fileNum:, info.fileNum:" + ((ThemeUtil.ThemeInfo)localObject1).fileNum + ", fileNum:" + i + ", info.version:" + ((ThemeUtil.ThemeInfo)localObject1).version);
            }
            return true;
          }
          QLog.e("ThemeSwitch", 1, "NightModeLogic isThemeExist fileNum Error:, info.fileNum:" + ((ThemeUtil.ThemeInfo)localObject1).fileNum + ", fileNum:" + i + ", info.version:" + ((ThemeUtil.ThemeInfo)localObject1).version);
        }
      }
      try
      {
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_FailCode", "step_0");
        StatisticCollector.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)BaseApplicationImpl.a.a()).getAccount(), "VipThemeNightLocalFilesNum", false, 1L, 0L, (HashMap)localObject3, "", false);
        bool2 = false;
        label398:
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          if (((File)localObject2).exists())
          {
            if (((File)localObject2).length() != paramThemeInfo.size) {
              break label805;
            }
            bool1 = true;
          }
        }
        label435:
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("ThemeSwitch", 2, "isThemeExist info is null");
          }
          try
          {
            if ((!paramThemeInfo.themeId.equals(this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.themeId)) || (TextUtils.isEmpty(paramThemeInfo.version)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.version))) {
              break label818;
            }
            i = Integer.valueOf(paramThemeInfo.version).intValue();
            int j = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.version).intValue();
            if (i < j) {
              break label818;
            }
            i = 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              label531:
              if (QLog.isColorLevel()) {
                QLog.w("ThemeSwitch", 2, "NumberFormatException:" + localNumberFormatException.getMessage());
              }
              i = 0;
            }
            QLog.e("ThemeSwitch", 1, "NightModeLogic isThemeExist fileNum Error:, themeInfo.fileNum:" + paramThemeInfo.fileNum + ", fileNum:" + i + ", themeInfo.version:" + paramThemeInfo.version);
          }
          if (i != 0) {
            if ((((File)localObject2).exists()) && (((File)localObject2).length() == paramThemeInfo.size))
            {
              paramThemeInfo.isVoiceTheme = this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.isVoiceTheme;
              paramThemeInfo.downloadUrl = this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.downloadUrl;
              paramThemeInfo.size = this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.size;
              localObject1 = new File(ThemeUtil.getThemeResourcePath(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), paramThemeInfo.themeId, paramThemeInfo.version));
              if (((File)localObject1).exists())
              {
                i = ThemeJsPlugin.getFileNumInFile((File)localObject1);
                if ((i > 0) && (i >= paramThemeInfo.fileNum - 15))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("ThemeSwitch", 2, "NightModeLogic isThemeExist fileNum:, themeInfo.fileNum:" + paramThemeInfo.fileNum + ", fileNum:" + i + ", themeInfo.version:" + paramThemeInfo.version);
                  }
                  paramThemeInfo.status = "5";
                }
              }
            }
          }
        }
        for (;;)
        {
          ThemeUtil.setThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext(), paramThemeInfo);
          paramBoolean = true;
          label729:
          bool1 = paramBoolean;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ThemeSwitch", 2, "isThemeExist themePkgFile return:" + paramBoolean);
          return paramBoolean;
          label766:
          if (QLog.isColorLevel()) {
            QLog.w("ThemeSwitch", 2, "isThemeExist themeResPath dir is not exists,themeResPath=" + (String)localObject3);
          }
          if (!paramBoolean) {
            break label398;
          }
          return false;
          label805:
          ((File)localObject2).delete();
          bool1 = bool2;
          break label435;
          label818:
          i = 0;
          break label531;
          try
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("param_FailCode", "step_1");
            StatisticCollector.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)BaseApplicationImpl.a.a()).getAccount(), "VipThemeNightLocalFilesNum", false, 1L, 0L, localHashMap, "", false);
            paramThemeInfo.status = "3";
            continue;
            paramThemeInfo.status = "3";
            continue;
            paramBoolean = false;
            ((File)localObject2).delete();
            break label729;
            paramBoolean = false;
            break label729;
            if (((File)localObject2).exists())
            {
              paramBoolean = bool1;
              if (((File)localObject2).length() == paramThemeInfo.size) {
                break label729;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.w("ThemeSwitch", 2, "isThemeExist themePkgFile is not exists or size is not match");
            }
            paramBoolean = false;
          }
          catch (Exception localException1)
          {
            for (;;) {}
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback, false, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_MqqAppAppRuntime = null;
  }
  
  public void b(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "startNightMode, isNightMode=" + ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime) + ", nowThemeId=" + ThemeUtil.getCurrentThemeId() + ", userThemeId=" + ThemeUtil.getUserCurrentThemeId((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime));
    }
    this.jdField_a_of_type_Boolean = true;
    HashMap localHashMap = new HashMap();
    if (((this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.downloadUrl == null) || (this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.downloadUrl.equals(""))) && (!a(false)))
    {
      this.jdField_b_of_type_AndroidAppActivity = paramActivity;
      QLog.i("ThemeSwitch", 1, "startNightMode, step=waitActivity");
    }
    ThemeUtil.ThemeInfo localThemeInfo;
    do
    {
      try
      {
        localHashMap.put("param_FailCode", "NUrl");
        StatisticCollector.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeStartDown", false, 1L, 0L, localHashMap, "", false);
        return;
      }
      catch (Exception paramActivity)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("ThemeSwitch", 2, "startNightMode, StatisticCollector error=" + paramActivity.toString());
        return;
      }
      localThemeInfo = a(false);
      if ((!a()) && ((localThemeInfo == null) || (!localThemeInfo.status.equals("2")))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitch", 2, "startNightMode is download or switching theme");
      }
      try
      {
        localHashMap.put("param_FailCode", "WAIT");
        StatisticCollector.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeStartDown", false, 1L, 0L, localHashMap, "", false);
        return;
      }
      catch (Exception paramActivity) {}
    } while (!QLog.isColorLevel());
    QLog.i("ThemeSwitch", 2, "startNightMode, StatisticCollector error=" + paramActivity.toString());
    return;
    a(paramActivity);
    if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime)) && (!a(localThemeInfo, false)))
    {
      int i = NetworkUtil.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext());
      if ((1 == i) || (4 == i))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback != null) && (!ThemeSwitchManager.b))
        {
          paramActivity = new Bundle();
          paramActivity.putInt("start_status", 1);
          this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback.c(paramActivity);
        }
        b();
      }
      for (;;)
      {
        ReportController.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "2", "", "", "");
        try
        {
          localHashMap.put("param_FailCode", "Dialog");
          StatisticCollector.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeStartDown", true, 1L, 0L, localHashMap, "", false);
          return;
        }
        catch (Exception paramActivity) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ThemeSwitch", 2, "startNightMode, StatisticCollector error=" + paramActivity.toString());
        return;
        d();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback != null) && (!ThemeSwitchManager.jdField_a_of_type_Boolean))
    {
      paramActivity = new Bundle();
      paramActivity.putInt("start_status", 1);
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback.c(paramActivity);
    }
    boolean bool = c();
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "startNightMode result=" + bool);
    }
    try
    {
      localHashMap.put("param_FailCode", "START");
      StatisticCollector.a(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeStartDown", bool, 1L, 0L, localHashMap, "", false);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "startNightMode, StatisticCollector error=" + paramActivity.toString());
        }
      }
    }
  }
  
  public void b(NightModeLogic.NightModeCallback paramNightModeCallback)
  {
    a(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a(paramNightModeCallback, false, true);
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = null;
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "downLoadNightTheme nightthemeInfo");
    }
    if (ThemeSwitchManager.b)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ThemeSwitch", 2, "downLoadNightTheme is downloading theme");
      }
      return false;
    }
    ThemeUtil.ThemeInfo localThemeInfo = a(false);
    if (TextUtils.isEmpty(localThemeInfo.downloadUrl))
    {
      QLog.i("ThemeSwitch", 1, "TextUtils.isEmpty(themeInfo.downloadUrl) == true");
      localThemeInfo.downloadUrl = this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.downloadUrl;
      localThemeInfo.size = this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.size;
      localThemeInfo.version = this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo.version;
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a(this.jdField_a_of_type_MqqAppAppRuntime, localThemeInfo);
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.a();
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "setupNightTheme");
    }
    if (ThemeSwitchManager.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ThemeSwitch", 2, "is switching theme");
      }
      return false;
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject1 = new ThemeUtil.ThemeInfo();
    if (!bool)
    {
      localObject1 = a(false);
      ReportController.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "1", "", "", "");
      VasWebviewUtil.reportVasStatus("Setting_tab", "Night_mode", "0", 0, 0);
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitch", 2, "setupNightTheme themeID=" + ((ThemeUtil.ThemeInfo)localObject1).themeId);
      }
      a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeSwitchManager.b(this.jdField_a_of_type_MqqAppAppRuntime, (ThemeUtil.ThemeInfo)localObject1);
      return true;
    }
    Object localObject2 = ThemeSwitchUtil.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    localObject2 = ThemeUtil.getThemeInfo(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext(), ((Bundle)localObject2).getString("themeID"));
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!a((ThemeUtil.ThemeInfo)localObject1, false))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ThemeSwitch", 2, "setupNightTheme theme is not exists, so setup default theme");
        }
        ((ThemeUtil.ThemeInfo)localObject1).themeId = "1000";
        ((ThemeUtil.ThemeInfo)localObject1).version = "0";
      }
      ReportController.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "0", "", "", "");
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\NightModeLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */