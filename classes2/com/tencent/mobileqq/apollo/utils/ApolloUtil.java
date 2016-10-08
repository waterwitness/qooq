package com.tencent.mobileqq.apollo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.UnsupportedCharsetException;
import mqq.os.MqqHandler;
import pst;

public class ApolloUtil
{
  static long a = 0L;
  public static final String a = "ApolloUtil";
  static long b = 0L;
  public static final String b = "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/action_android_v3.json";
  static long c = 0L;
  public static final String c = ApolloConstant.l + "action_v3.json";
  public static final String d = "extra_key_from_apollo";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static final int a(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public static int a(float paramFloat, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {
      return 24;
    }
    Object localObject = new TextView(BaseApplicationImpl.getContext());
    ((TextView)localObject).setTextSize(51.0F / DeviceInfoUtil.a);
    ((TextView)localObject).setText(paramString);
    localObject = ((TextView)localObject).getPaint();
    paramString = paramString.replaceAll("\r", "").split("\n");
    int i1 = paramString.length;
    int m = 0;
    int k = 0;
    if (m < i1)
    {
      String str = paramString[m];
      int i;
      float f1;
      if (((Paint)localObject).measureText(str) > paramFloat)
      {
        i = 0;
        f1 = 0.0F;
      }
      for (int j = 0;; j = k)
      {
        k = j;
        if (i != str.length())
        {
          float f2 = f1 + ((Paint)localObject).measureText(String.valueOf(str.charAt(i)));
          n = i;
          f1 = f2;
          k = j;
          if (f2 <= paramFloat) {
            break label186;
          }
          k = j + 1;
          if (k < 3) {}
        }
        else
        {
          m += 1;
          break;
        }
        int n = i - 1;
        f1 = 0.0F;
        label186:
        i = n + 1;
      }
    }
    if (k == 0) {
      return 22;
    }
    if (k == 1) {
      return 23;
    }
    return 24;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static String a(Paint paramPaint, float paramFloat, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPaint == null) || (paramFloat <= 0.0F)) {
      return "";
    }
    String[] arrayOfString = paramString.replaceAll("\r", "").split("\n");
    StringBuilder localStringBuilder = new StringBuilder();
    int n = arrayOfString.length;
    int m = 0;
    int i = 0;
    if (m < n)
    {
      String str = arrayOfString[m];
      if (paramPaint.measureText(str) <= paramFloat) {
        localStringBuilder.append(str);
      }
      float f;
      int k;
      label114:
      do
      {
        localStringBuilder.append("\n");
        m += 1;
        break;
        j = 0;
        f = 0.0F;
        k = 0;
        i = k;
      } while (j == str.length());
      char c1 = str.charAt(j);
      f += paramPaint.measureText(String.valueOf(c1));
      if (f <= paramFloat) {
        localStringBuilder.append(c1);
      }
      for (;;)
      {
        j += 1;
        break label114;
        k += 1;
        i = k;
        if (k >= paramInt) {
          break;
        }
        localStringBuilder.append("\n");
        j -= 1;
        f = 0.0F;
      }
    }
    if (!paramString.endsWith("\n")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    int j = localStringBuilder.length();
    paramFloat = paramPaint.measureText(String.valueOf("…"));
    if (i >= paramInt) {
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt >= 1)
      {
        if (paramPaint.measureText(localStringBuilder.substring(paramInt - 1, j)) >= paramFloat) {
          localStringBuilder.replace(paramInt - 1, j, "…");
        }
      }
      else {
        return localStringBuilder.toString();
      }
      paramInt -= 1;
    }
  }
  
  public static String a(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(ApolloConstant.l).append(paramApolloActionData.actionId).append(File.separator).append("panelView.png");
      continue;
      localStringBuilder.append("http://cmshow.qq.com/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.png");
      continue;
      localStringBuilder.append(ApolloConstant.l).append(paramApolloActionData.actionId).append(File.separator).append("panelGif.gif");
      continue;
      localStringBuilder.append("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.gif");
      continue;
      localStringBuilder.append(ApolloConstant.l).append(paramApolloActionData.actionId).append(File.separator).append("actionRes.zip");
      continue;
      localStringBuilder.append("http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/d.zip");
      continue;
      localStringBuilder.append(ApolloConstant.l).append(paramApolloActionData.actionId).append(File.separator);
      continue;
      localStringBuilder.append(ApolloConstant.l).append(paramApolloActionData.actionId).append(File.separator).append("config.json");
    }
  }
  
  public static String a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(ApolloConstant.p).append(paramApolloActionPackage.packageId).append(File.separator).append("tab.png");
    return localStringBuilder.toString();
  }
  
  public static String a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.mApolloMessage.name != null) && (paramMessageForApollo.mApolloMessage.name.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(new String(paramMessageForApollo.mApolloMessage.name));
      if ((paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
      {
        localStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
        if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          localStringBuilder.append(" ").append(paramMessageForApollo.inputText);
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          localStringBuilder.append("：").append(paramMessageForApollo.inputText);
        }
      }
    }
    return "[动作消息]";
  }
  
  public static String a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = URLEncoder.encode(paramString, "UTF-8");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, paramString.getMessage());
    }
    return "";
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    if ((paramString1 == null) || (!new File(paramString1).exists())) {}
    for (;;)
    {
      return;
      String str;
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (new File(paramString2).exists()) {}
      }
      else
      {
        str = ImageUtil.a(paramActivity, paramString1);
      }
      try
      {
        if ((Utils.b()) && (ImageUtil.b(paramString1))) {
          Utils.b(paramString1, str, true, "", 0);
        }
        while ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
        {
          localBundle.putBoolean("isFromShare", true);
          localBundle.putString("forward_thumb", str);
          localBundle.putString("forward_filepath", paramString1);
          localBundle.putString("forward_extra", paramString1);
          localBundle.putBoolean("k_favorites", false);
          localBundle.putBoolean("isFromFavorites", true);
          localBundle.putInt("extra_key_from_apollo", paramInt);
          localIntent.putExtras(localBundle);
          paramActivity.startActivityForResult(localIntent, 103);
          return;
          Utils.a(paramString1, str, true, "", 0);
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          QLog.e("ApolloUtil", 2, paramString2.getMessage());
        }
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    if (!ApolloManager.b(paramContext))
    {
      paramIntent = new Intent(paramContext, QQBrowserActivity.class);
      VasWebviewUtil.openQQBrowserActivity(paramContext, ApolloConstant.O, -1L, paramIntent, false, -1);
      return;
    }
    if (1 != ApolloManager.a((AppInterface)BaseApplicationImpl.a.a()))
    {
      paramIntent = new Intent(paramContext, QQBrowserActivity.class);
      VasWebviewUtil.openQQBrowserActivity(paramContext, ApolloConstant.P + "0", -1L, paramIntent, false, -1);
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, ApolloStoreActivity.class);
    paramIntent = BaseApplicationImpl.a();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.a();
      if (!(paramIntent instanceof QQAppInterface)) {}
    }
    for (paramIntent = ((QQAppInterface)paramIntent).b();; paramIntent = "")
    {
      localIntent.putExtra("extra_key_nickname", paramIntent);
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("extra_key_adtag", paramString);
      }
      localIntent.putExtra("extra_key_click_time", System.currentTimeMillis());
      paramContext.startActivity(localIntent);
      return;
    }
  }
  
  public static void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      paramView.setBackgroundResource(2130837903);
      return;
    case 1: 
      paramView.setBackgroundResource(2130837903);
      return;
    case 2: 
      paramView.setBackgroundResource(2130837904);
      return;
    case 3: 
      paramView.setBackgroundResource(2130837905);
      return;
    case 4: 
      paramView.setBackgroundResource(2130837906);
      return;
    case 5: 
      paramView.setBackgroundResource(2130837907);
      return;
    case 6: 
      paramView.setBackgroundResource(2130837908);
      return;
    }
    paramView.setBackgroundResource(2130837909);
  }
  
  public static void a(View paramView, QQAppInterface paramQQAppInterface, QQCustomMenu paramQQCustomMenu) {}
  
  public static void a(View paramView, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface) {}
  
  public static void a(MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramMessageForApollo != null) && (paramQQAppInterface != null)) {
      ThreadManager.a().post(new pst(paramMessageForApollo, paramQQAppInterface, paramString, paramInt));
    }
  }
  
  /* Error */
  public static void a(java.io.BufferedInputStream paramBufferedInputStream, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 423	java/util/zip/ZipInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 426	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore_3
    //   9: new 163	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 263	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 429	java/io/File:mkdirs	()Z
    //   20: pop
    //   21: sipush 8192
    //   24: newarray <illegal type>
    //   26: astore 9
    //   28: aconst_null
    //   29: astore 5
    //   31: aconst_null
    //   32: astore 6
    //   34: aload_3
    //   35: invokevirtual 433	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnonnull +52 -> 94
    //   45: aload_3
    //   46: ifnull +7 -> 53
    //   49: aload_3
    //   50: invokevirtual 436	java/util/zip/ZipInputStream:close	()V
    //   53: aload_0
    //   54: ifnull +7 -> 61
    //   57: aload_0
    //   58: invokevirtual 439	java/io/BufferedInputStream:close	()V
    //   61: iconst_0
    //   62: ifeq +11 -> 73
    //   65: new 441	java/lang/NullPointerException
    //   68: dup
    //   69: invokespecial 442	java/lang/NullPointerException:<init>	()V
    //   72: athrow
    //   73: aload 6
    //   75: ifnull +8 -> 83
    //   78: aload 6
    //   80: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   83: aload 5
    //   85: ifnull +8 -> 93
    //   88: aload 5
    //   90: invokevirtual 448	java/io/BufferedOutputStream:close	()V
    //   93: return
    //   94: aload 4
    //   96: invokevirtual 453	java/util/zip/ZipEntry:isDirectory	()Z
    //   99: ifne -65 -> 34
    //   102: aload 4
    //   104: invokevirtual 456	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   107: astore 4
    //   109: aload 4
    //   111: ifnull -77 -> 34
    //   114: aload 4
    //   116: ldc_w 458
    //   119: invokevirtual 461	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   122: ifne -88 -> 34
    //   125: aload 4
    //   127: getstatic 465	java/io/File:separatorChar	C
    //   130: invokevirtual 468	java/lang/String:lastIndexOf	(I)I
    //   133: istore 10
    //   135: iload 10
    //   137: aload 4
    //   139: invokevirtual 114	java/lang/String:length	()I
    //   142: iconst_1
    //   143: isub
    //   144: if_icmpne +89 -> 233
    //   147: new 470	java/lang/IllegalArgumentException
    //   150: dup
    //   151: new 28	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 472
    //   161: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 4
    //   166: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokespecial 473	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   175: athrow
    //   176: astore_1
    //   177: aload_3
    //   178: astore 4
    //   180: aload 6
    //   182: astore_3
    //   183: aload 4
    //   185: ifnull +8 -> 193
    //   188: aload 4
    //   190: invokevirtual 436	java/util/zip/ZipInputStream:close	()V
    //   193: aload_0
    //   194: ifnull +7 -> 201
    //   197: aload_0
    //   198: invokevirtual 439	java/io/BufferedInputStream:close	()V
    //   201: iconst_0
    //   202: ifeq +11 -> 213
    //   205: new 441	java/lang/NullPointerException
    //   208: dup
    //   209: invokespecial 442	java/lang/NullPointerException:<init>	()V
    //   212: athrow
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   221: aload 5
    //   223: ifnull +8 -> 231
    //   226: aload 5
    //   228: invokevirtual 448	java/io/BufferedOutputStream:close	()V
    //   231: aload_1
    //   232: athrow
    //   233: iload 10
    //   235: ifgt +183 -> 418
    //   238: iload 10
    //   240: ifge +164 -> 404
    //   243: aload_1
    //   244: astore 7
    //   246: aload 4
    //   248: astore 8
    //   250: iload_2
    //   251: ifeq +32 -> 283
    //   254: aload 4
    //   256: ldc_w 475
    //   259: invokevirtual 478	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   262: istore 10
    //   264: aload 4
    //   266: astore 8
    //   268: iload 10
    //   270: ifle +13 -> 283
    //   273: aload 4
    //   275: iconst_0
    //   276: iload 10
    //   278: invokevirtual 479	java/lang/String:substring	(II)Ljava/lang/String;
    //   281: astore 8
    //   283: new 163	java/io/File
    //   286: dup
    //   287: aload 7
    //   289: aload 8
    //   291: invokespecial 481	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: astore 4
    //   296: aload 4
    //   298: invokevirtual 485	java/io/File:getParentFile	()Ljava/io/File;
    //   301: invokevirtual 267	java/io/File:exists	()Z
    //   304: ifne +12 -> 316
    //   307: aload 4
    //   309: invokevirtual 485	java/io/File:getParentFile	()Ljava/io/File;
    //   312: invokevirtual 429	java/io/File:mkdirs	()Z
    //   315: pop
    //   316: aload 4
    //   318: invokevirtual 267	java/io/File:exists	()Z
    //   321: ifeq +9 -> 330
    //   324: aload 4
    //   326: invokevirtual 488	java/io/File:delete	()Z
    //   329: pop
    //   330: new 444	java/io/FileOutputStream
    //   333: dup
    //   334: aload 4
    //   336: invokespecial 491	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   339: astore 4
    //   341: new 447	java/io/BufferedOutputStream
    //   344: dup
    //   345: aload 4
    //   347: aload 9
    //   349: arraylength
    //   350: invokespecial 494	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   353: astore 6
    //   355: aload_3
    //   356: aload 9
    //   358: iconst_0
    //   359: aload 9
    //   361: arraylength
    //   362: invokevirtual 498	java/util/zip/ZipInputStream:read	([BII)I
    //   365: istore 10
    //   367: iload 10
    //   369: iconst_m1
    //   370: if_icmpeq +135 -> 505
    //   373: aload 6
    //   375: aload 9
    //   377: iconst_0
    //   378: iload 10
    //   380: invokevirtual 502	java/io/BufferedOutputStream:write	([BII)V
    //   383: goto -28 -> 355
    //   386: astore_1
    //   387: aload 6
    //   389: astore 5
    //   391: aload 4
    //   393: astore 6
    //   395: aload_3
    //   396: astore 4
    //   398: aload 6
    //   400: astore_3
    //   401: goto -218 -> 183
    //   404: aload 4
    //   406: iconst_1
    //   407: invokevirtual 505	java/lang/String:substring	(I)Ljava/lang/String;
    //   410: astore 4
    //   412: aload_1
    //   413: astore 7
    //   415: goto -169 -> 246
    //   418: aload 4
    //   420: iconst_0
    //   421: iload 10
    //   423: invokevirtual 479	java/lang/String:substring	(II)Ljava/lang/String;
    //   426: astore 7
    //   428: aload 7
    //   430: iconst_0
    //   431: invokevirtual 118	java/lang/String:charAt	(I)C
    //   434: getstatic 465	java/io/File:separatorChar	C
    //   437: if_icmpne +38 -> 475
    //   440: new 28	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   447: aload_1
    //   448: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 7
    //   453: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: astore 7
    //   461: aload 4
    //   463: iload 10
    //   465: iconst_1
    //   466: iadd
    //   467: invokevirtual 505	java/lang/String:substring	(I)Ljava/lang/String;
    //   470: astore 4
    //   472: goto -226 -> 246
    //   475: new 28	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   482: aload_1
    //   483: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: getstatic 465	java/io/File:separatorChar	C
    //   489: invokevirtual 127	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   492: aload 7
    //   494: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: astore 7
    //   502: goto -41 -> 461
    //   505: aload 6
    //   507: invokevirtual 508	java/io/BufferedOutputStream:flush	()V
    //   510: aload 6
    //   512: invokevirtual 448	java/io/BufferedOutputStream:close	()V
    //   515: aload 4
    //   517: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   520: aload 6
    //   522: astore 5
    //   524: aload 4
    //   526: astore 6
    //   528: goto -494 -> 34
    //   531: astore_1
    //   532: goto -479 -> 53
    //   535: astore_0
    //   536: goto -475 -> 61
    //   539: astore_0
    //   540: goto -467 -> 73
    //   543: astore_0
    //   544: goto -461 -> 83
    //   547: astore_0
    //   548: return
    //   549: astore 4
    //   551: goto -358 -> 193
    //   554: astore_0
    //   555: goto -354 -> 201
    //   558: astore_0
    //   559: goto -346 -> 213
    //   562: astore_0
    //   563: goto -342 -> 221
    //   566: astore_0
    //   567: goto -336 -> 231
    //   570: astore_1
    //   571: aconst_null
    //   572: astore 5
    //   574: aconst_null
    //   575: astore_3
    //   576: aconst_null
    //   577: astore 4
    //   579: goto -396 -> 183
    //   582: astore_1
    //   583: aconst_null
    //   584: astore 5
    //   586: aconst_null
    //   587: astore 6
    //   589: aload_3
    //   590: astore 4
    //   592: aload 6
    //   594: astore_3
    //   595: goto -412 -> 183
    //   598: astore_1
    //   599: aload_3
    //   600: astore 6
    //   602: aload 4
    //   604: astore_3
    //   605: aload 6
    //   607: astore 4
    //   609: goto -426 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	paramBufferedInputStream	java.io.BufferedInputStream
    //   0	612	1	paramString	String
    //   0	612	2	paramBoolean	boolean
    //   8	597	3	localObject1	Object
    //   38	487	4	localObject2	Object
    //   549	1	4	localIOException	java.io.IOException
    //   577	31	4	localObject3	Object
    //   29	556	5	localObject4	Object
    //   32	574	6	localObject5	Object
    //   244	257	7	str	String
    //   248	42	8	localObject6	Object
    //   26	350	9	arrayOfByte	byte[]
    //   133	334	10	i	int
    // Exception table:
    //   from	to	target	type
    //   34	40	176	finally
    //   94	109	176	finally
    //   114	176	176	finally
    //   254	264	176	finally
    //   273	283	176	finally
    //   283	316	176	finally
    //   316	330	176	finally
    //   330	341	176	finally
    //   404	412	176	finally
    //   418	461	176	finally
    //   461	472	176	finally
    //   475	502	176	finally
    //   355	367	386	finally
    //   373	383	386	finally
    //   505	520	386	finally
    //   49	53	531	java/io/IOException
    //   57	61	535	java/io/IOException
    //   65	73	539	java/io/IOException
    //   78	83	543	java/io/IOException
    //   88	93	547	java/io/IOException
    //   188	193	549	java/io/IOException
    //   197	201	554	java/io/IOException
    //   205	213	558	java/io/IOException
    //   217	221	562	java/io/IOException
    //   226	231	566	java/io/IOException
    //   0	9	570	finally
    //   9	28	582	finally
    //   341	355	598	finally
  }
  
  public static boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isRoleRelatedActionExist], roleId:" + paramInt);
    }
    String str;
    int i;
    if (paramInt == 0)
    {
      str = ApolloConstant.k + "/def/role/";
      i = 1;
    }
    for (;;)
    {
      if (i >= 5) {
        break label330;
      }
      File localFile1 = new File(str, paramInt + "/" + i);
      if (!localFile1.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
        }
        return false;
        str = ApolloConstant.n;
        break;
      }
      File localFile2 = new File(localFile1, ApolloConstant.r);
      if (!localFile2.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "ACTION_FILE_JSON_NAME NOT exist." + localFile2.getPath());
        }
        return false;
      }
      localFile2 = new File(localFile1, ApolloConstant.s);
      if (!localFile2.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "ACTION_FILE_ATLAS_NAME NOT exist." + localFile2.getPath());
        }
        return false;
      }
      localFile1 = new File(localFile1, ApolloConstant.q);
      if (!localFile1.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "ACTION_FILE_PNG_NAME NOT exist." + localFile1.getPath());
        }
        return false;
      }
      i += 1;
    }
    label330:
    return true;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isActionResDone], actionId:" + paramInt1 + ",personNum:" + paramInt2);
    }
    File localFile = new File(ApolloConstant.l + paramInt1);
    if (paramInt1 < 21) {
      localFile = new File(ApolloConstant.k, "/def/role/0/" + paramInt1);
    }
    if (!localFile.isDirectory())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
      return false;
    }
    if ((a(localFile.getAbsolutePath() + "/" + ApolloConstant.r)) && (a(localFile.getAbsolutePath() + "/" + ApolloConstant.s)) && (a(localFile.getAbsolutePath() + "/" + ApolloConstant.q))) {}
    for (paramInt1 = 1; (paramInt1 != 0) && (paramInt2 == 0); paramInt1 = 0) {
      return true;
    }
    if ((a(localFile.getAbsolutePath() + "/" + ApolloConstant.u)) && (a(localFile.getAbsolutePath() + "/" + ApolloConstant.v)) && (a(localFile.getAbsolutePath() + "/" + ApolloConstant.t))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {}
    boolean bool;
    do
    {
      return false;
      bool = true;
      if (!FileUtil.a(a(paramApolloActionData, 0))) {
        bool = false;
      }
    } while (!a(paramApolloActionData.actionId, paramApolloActionData.personNum));
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
      if (localFile.exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + " NOT exist.");
    return false;
    if (localFile.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + ",lenght is 0.");
      }
      localFile.delete();
      return false;
    }
    return true;
  }
  
  public static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null)) {}
    while (paramArrayOfInt1.length != paramArrayOfInt2.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfInt2.length) {
        break label41;
      }
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        break;
      }
      i += 1;
    }
    label41:
    return true;
  }
  
  public static final byte[] a()
  {
    try
    {
      byte[] arrayOfByte = "[动作消息]消息接收失败".getBytes();
      return arrayOfByte;
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      QLog.e("ApolloUtil", 1, localUnsupportedCharsetException.getMessage());
      return null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloUtil", 1, localThrowable.getMessage());
      }
    }
  }
  
  public static String b(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {}
    return null;
  }
  
  public static boolean b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkDressRes], dressId:" + paramInt);
    }
    File localFile = new File(ApolloConstant.m + paramInt);
    if (paramInt < 21) {
      localFile = new File(ApolloConstant.k, "/def/dress/" + paramInt);
    }
    if (!localFile.isDirectory())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
      return false;
    }
    if ((a(localFile.getAbsolutePath() + "/" + ApolloConstant.x)) && (a(localFile.getAbsolutePath() + "/" + ApolloConstant.y)) && (a(localFile.getAbsolutePath() + "/" + ApolloConstant.w))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isBubbleRscExist], roleId:" + paramInt1 + ",bubbleId:" + paramInt2);
    }
    if (paramInt1 == 0) {}
    for (File localFile1 = new File(ApolloConstant.k, "/def/role/" + paramInt1);; localFile1 = new File(ApolloConstant.n + paramInt1))
    {
      localFile1 = new File(localFile1, ApolloConstant.z + "/" + paramInt2);
      if (localFile1.exists()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
      }
      return false;
    }
    File localFile2 = new File(localFile1, ApolloConstant.x);
    if (!localFile2.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "BUBBLE_FILE_ATLAS_NAME NOT exist. " + localFile2.getPath());
      }
      return false;
    }
    if (localFile2.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + localFile2.getPath() + ",lenght is 0.");
      }
      localFile2.delete();
      return false;
    }
    localFile2 = new File(localFile1, ApolloConstant.y);
    if (!localFile2.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "BUBBLE_FILE_ATLAS_NAME NOT exist." + localFile2.getPath());
      }
      return false;
    }
    if (localFile2.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + localFile2.getPath() + ",lenght is 0.");
      }
      localFile2.delete();
      return false;
    }
    localFile1 = new File(localFile1, ApolloConstant.w);
    if (!localFile1.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "BUBBLE_FILE_PNG_NAME NOT exist." + localFile1.getPath());
      }
      return false;
    }
    if (localFile1.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + localFile1.getPath() + ",lenght is 0.");
      }
      localFile1.delete();
      return false;
    }
    return true;
  }
  
  public static boolean c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkRoleRes], roleId:" + paramInt);
    }
    File localFile1;
    if (paramInt == 0)
    {
      localFile1 = new File(ApolloConstant.k, "/def/role/" + paramInt);
      if (localFile1.isDirectory()) {
        break label142;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
      }
    }
    label142:
    File localFile2;
    do
    {
      return false;
      localFile1 = new File(ApolloConstant.n + paramInt);
      break;
      localFile2 = new File(localFile1, ApolloConstant.E);
      if (localFile2.exists()) {
        break label198;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ROLE_FILE_CONFIG_NAME NOT exist." + localFile2.getPath());
    return false;
    label198:
    if ((a(localFile1.getAbsolutePath() + "/" + ApolloConstant.C)) && (a(localFile1.getAbsolutePath() + "/" + ApolloConstant.D)) && (a(localFile1.getAbsolutePath() + "/" + ApolloConstant.B))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\utils\ApolloUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */