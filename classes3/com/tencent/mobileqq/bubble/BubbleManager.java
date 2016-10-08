package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qtw;
import qtx;
import qty;

public class BubbleManager
  implements Manager
{
  public static volatile int a = 0;
  public static long a = 0L;
  public static final String a;
  public static volatile boolean a = false;
  public static final int b = 9999;
  public static final String b = "%04d.png";
  public static final String c = "bubble_info";
  public static final String d = "file:///android_assets/bubbles/";
  public static final String e = "aio_user_bg_nor.9.png";
  public static final String f = "aio_user_pic_nor.9.png";
  public static final String g = "chat_bubble_thumbnail.png";
  public static final String h = "chartlet.png";
  protected static final String i = "Bubble_download_succ";
  protected static final String j = "Bubble_download_cancel";
  protected static final String k = "Bubble_download";
  public static final String l = "bubble_local.cfg";
  public static final String m = "id";
  public static final String n = "version";
  public static final String o = "update";
  public static final String p = "full_download";
  public static final String q = "updatelist";
  private static final String r = "http://i.gtimg.cn/club/item/avatar/zip/%1$d/a%2$d/%3$s";
  private static final String s = "http://i.gtimg.cn/club/item/avatar/json/%1$d/a%2$d/%3$s";
  float jdField_a_of_type_Float = 1.0F;
  protected Context a;
  protected AppInterface a;
  public BubbleManager.BubbleInfoLruCache a;
  public BubbleManager.LruLinkedHashMap a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new qtw(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  public IPCDownloadListener a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  protected Vector a;
  public ConcurrentHashMap a;
  JSONArray jdField_a_of_type_OrgJsonJSONArray = null;
  DownloadListener b = new qtx(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private int c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BubbleManager.class.getSimpleName();
    jdField_a_of_type_Long = 1000L;
  }
  
  public BubbleManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_c_of_type_Int = 2000000;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache = new BubbleManager.BubbleInfoLruCache(this, 10);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = new BubbleManager.LruLinkedHashMap(this, 6);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramAppInterface.getManager(46));
    paramAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    if (paramAppInterface.density == 160.0F) {}
    for (float f1 = 1.0F;; f1 = paramAppInterface.density)
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_a_of_type_OrgJsonJSONArray = a();
      this.jdField_a_of_type_JavaUtilVector = new Vector(16);
      return;
    }
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("T")) {
        if (paramBoolean) {}
      }
      do
      {
        return 3;
        return 4;
        if (paramString.equals("L"))
        {
          if (!paramBoolean) {
            return 2;
          }
          return 7;
        }
        if (paramString.equals("TL"))
        {
          if (!paramBoolean) {
            return 0;
          }
          return 5;
        }
        if (!paramString.equals("B")) {
          break;
        }
      } while (paramBoolean);
      return 4;
      if (paramString.equals("BL"))
      {
        if (!paramBoolean) {
          return 1;
        }
        return 6;
      }
      if (paramString.equals("R"))
      {
        if (!paramBoolean) {
          return 7;
        }
        return 2;
      }
      if (paramString.equals("TR"))
      {
        if (!paramBoolean) {
          return 5;
        }
        return 0;
      }
      if (paramString.equals("BR"))
      {
        if (!paramBoolean) {
          return 6;
        }
        return 1;
      }
    }
    return -1;
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    localRect.set((int)(paramInt1 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt2 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt3 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt4 / 2.0F * this.jdField_a_of_type_Float));
    return localRect;
  }
  
  private AnimationConfig.AnimationStep a(String paramString, JSONObject paramJSONObject)
  {
    paramString = new AnimationConfig.AnimationStep();
    if (paramJSONObject.has("count")) {
      paramString.jdField_d_of_type_Int = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("cycle_count")) {
      paramString.jdField_e_of_type_Int = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("prefix_name")) {
      paramString.jdField_a_of_type_JavaLangString = paramJSONObject.getString("prefix_name");
    }
    return paramString;
  }
  
  private AnimationConfig a(int paramInt, JSONObject paramJSONObject)
  {
    AnimationConfig localAnimationConfig = new AnimationConfig();
    localAnimationConfig.j = paramInt;
    if (paramJSONObject.has("rect"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
      localAnimationConfig.jdField_a_of_type_ArrayOfInt = new int[4];
      paramInt = 0;
      while (paramInt < localJSONArray.length())
      {
        localAnimationConfig.jdField_a_of_type_ArrayOfInt[paramInt] = localJSONArray.getInt(paramInt);
        paramInt += 1;
      }
    }
    if (paramJSONObject.has("cycle_count")) {
      localAnimationConfig.k = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("count")) {
      localAnimationConfig.l = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localAnimationConfig.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("second_zip_name")) {
      localAnimationConfig.jdField_c_of_type_JavaLangString = paramJSONObject.getString("second_zip_name");
    }
    if (paramJSONObject.has("align")) {
      localAnimationConfig.jdField_d_of_type_JavaLangString = paramJSONObject.getString("align");
    }
    if ((!paramJSONObject.has("count_stiil")) || (paramJSONObject.has("alpha"))) {
      localAnimationConfig.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("alpha");
    }
    if (paramJSONObject.has("displayChartlet")) {
      localAnimationConfig.jdField_d_of_type_Boolean = paramJSONObject.getBoolean("displayChartlet");
    }
    if (paramJSONObject.has("mirror")) {
      localAnimationConfig.e = paramJSONObject.getBoolean("mirror");
    }
    a(localAnimationConfig, paramJSONObject);
    localAnimationConfig.m = paramJSONObject.getInt("time");
    return localAnimationConfig;
  }
  
  private BubbleInfo.CommonAttrs a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AnimationConfig localAnimationConfig = a(paramInt, paramString);
    if (localAnimationConfig == null) {
      return null;
    }
    Object localObject2 = new BubbleInfo.CommonAttrs();
    ((BubbleInfo.CommonAttrs)localObject2).jdField_c_of_type_Int = localAnimationConfig.l;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_e_of_type_Int = localAnimationConfig.m;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_d_of_type_Int = localAnimationConfig.k;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_c_of_type_Boolean = localAnimationConfig.jdField_c_of_type_Boolean;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_g_of_type_Int = localAnimationConfig.n;
    ((BubbleInfo.CommonAttrs)localObject2).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig = localAnimationConfig;
    File localFile;
    Object localObject1;
    int i1;
    label146:
    boolean bool;
    if (((BubbleInfo.CommonAttrs)localObject2).jdField_d_of_type_Int <= 1)
    {
      ((BubbleInfo.CommonAttrs)localObject2).jdField_b_of_type_Boolean = true;
      localFile = new File(a(paramInt, false), localAnimationConfig.jdField_a_of_type_JavaLangString);
      localObject1 = new String[localAnimationConfig.l];
      if (localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray != null) {
        break label493;
      }
      i1 = 0;
      if (i1 >= localObject1.length) {
        break label847;
      }
      localObject1[i1] = (localFile.getAbsolutePath() + File.separatorChar + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) }));
      bool = new File(localObject1[i1]).exists();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleSource|pngs[" + i1 + "]=" + localObject1[i1] + ",isFileExists=" + bool);
      }
      if (bool) {
        break label484;
      }
      i1 = 1;
    }
    for (;;)
    {
      label484:
      label493:
      int i3;
      int i2;
      label512:
      AnimationConfig.AnimationStep localAnimationStep;
      int i4;
      if ((paramBoolean1) && ((i1 != 0) || (a(paramInt, localAnimationConfig.jdField_a_of_type_JavaLangString).booleanValue())))
      {
        localObject1 = a(paramInt, localAnimationConfig.jdField_a_of_type_JavaLangString + ".zip");
        localObject2 = new File(a(paramInt, true), localAnimationConfig.jdField_a_of_type_JavaLangString + ".zip");
        paramString = new Bundle();
        paramString.putString("name", localAnimationConfig.jdField_a_of_type_JavaLangString + ".zip");
        paramString.putInt("id", paramInt);
        localObject1 = new DownloadTask((String)localObject1, (File)localObject2);
        ((DownloadTask)localObject1).e = this.jdField_c_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, this.b, paramString);
        return null;
        ((BubbleInfo.CommonAttrs)localObject2).jdField_b_of_type_Boolean = false;
        break;
        i1 += 1;
        break label146;
        int i5 = localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.size();
        i3 = 0;
        i2 = 0;
        i1 = 0;
        if (i3 >= i5) {
          break label844;
        }
        localAnimationStep = (AnimationConfig.AnimationStep)localAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i3);
        i4 = 0;
        label537:
        if (i4 >= localAnimationStep.jdField_d_of_type_Int) {
          break label841;
        }
        localObject1[(i4 + i2)] = (localFile.getAbsolutePath() + File.separatorChar + localAnimationStep.jdField_a_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i4 + 1) }));
        bool = new File(localObject1[(i4 + i2)]).exists();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleSource|pngs[" + i4 + "]=" + localObject1[i4] + ",isFileExists=" + bool);
        }
        if (!bool) {
          i1 = 1;
        }
      }
      label841:
      for (;;)
      {
        if (i1 != 0)
        {
          break;
          i4 += 1;
          break label537;
        }
        i4 = localAnimationStep.jdField_d_of_type_Int;
        i3 += 1;
        i2 += i4;
        break label512;
        if (i1 != 0) {
          return null;
        }
        if (localObject1.length > 0) {}
        for (;;)
        {
          ((BubbleInfo.CommonAttrs)localObject2).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
          ((BubbleInfo.CommonAttrs)localObject2).jdField_b_of_type_JavaLangString = paramString;
          ((BubbleInfo.CommonAttrs)localObject2).jdField_f_of_type_Int = a(localAnimationConfig.jdField_d_of_type_JavaLangString, paramBoolean2);
          if ((localAnimationConfig.jdField_a_of_type_ArrayOfInt != null) && (localAnimationConfig.jdField_a_of_type_ArrayOfInt.length > 0)) {
            ((BubbleInfo.CommonAttrs)localObject2).jdField_a_of_type_AndroidGraphicsRect = a(localAnimationConfig.jdField_a_of_type_ArrayOfInt[0], localAnimationConfig.jdField_a_of_type_ArrayOfInt[1], localAnimationConfig.jdField_a_of_type_ArrayOfInt[2], localAnimationConfig.jdField_a_of_type_ArrayOfInt[3]);
          }
          return (BubbleInfo.CommonAttrs)localObject2;
          localObject1 = null;
        }
      }
      label844:
      continue;
      label847:
      i1 = 0;
    }
  }
  
  private BubbleNewAnimConf a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = null;
    }
    BubbleNewAnimConf.PendantAnimConf localPendantAnimConf;
    do
    {
      return (BubbleNewAnimConf)localObject;
      localPendantAnimConf = new BubbleNewAnimConf.PendantAnimConf();
      if (paramJSONObject.has("key")) {
        localPendantAnimConf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("duration")) {
        localPendantAnimConf.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("repeat")) {
        localPendantAnimConf.jdField_d_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("pendent_prefix")) {
        localPendantAnimConf.jdField_b_of_type_JavaLangString = paramJSONObject.getString("pendent_prefix");
      }
      if (paramJSONObject.has("img_count")) {
        localPendantAnimConf.jdField_e_of_type_Int = paramJSONObject.getInt("img_count");
      }
      localObject = localPendantAnimConf;
    } while (!paramJSONObject.has("play_with"));
    localPendantAnimConf.jdField_c_of_type_JavaLangString = paramJSONObject.getString("play_with");
    return localPendantAnimConf;
  }
  
  /* Error */
  private Boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 119	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   14: ifnonnull +10 -> 24
    //   17: iconst_0
    //   18: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: astore_1
    //   22: aload_1
    //   23: areturn
    //   24: new 357	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokevirtual 514	com/tencent/mobileqq/bubble/BubbleManager:a	()Ljava/io/File;
    //   32: ldc 48
    //   34: invokespecial 363	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 402	java/io/File:exists	()Z
    //   42: ifeq +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 517	java/io/File:delete	()Z
    //   49: pop
    //   50: new 519	java/io/RandomAccessFile
    //   53: dup
    //   54: aload_2
    //   55: ldc_w 521
    //   58: invokespecial 522	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 119	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   66: astore 4
    //   68: aload 4
    //   70: monitorenter
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 119	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   76: invokevirtual 523	org/json/JSONArray:toString	()Ljava/lang/String;
    //   79: invokevirtual 527	java/lang/String:getBytes	()[B
    //   82: invokevirtual 531	java/io/RandomAccessFile:write	([B)V
    //   85: aload_2
    //   86: invokevirtual 534	java/io/RandomAccessFile:close	()V
    //   89: aload 5
    //   91: astore_3
    //   92: aload 4
    //   94: monitorexit
    //   95: iconst_1
    //   96: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   99: astore_2
    //   100: aload_2
    //   101: astore_1
    //   102: iconst_0
    //   103: ifeq -81 -> 22
    //   106: new 536	java/lang/NullPointerException
    //   109: dup
    //   110: invokespecial 537	java/lang/NullPointerException:<init>	()V
    //   113: athrow
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 540	java/io/IOException:printStackTrace	()V
    //   119: aload_2
    //   120: areturn
    //   121: astore_3
    //   122: aload_2
    //   123: astore_1
    //   124: aload_3
    //   125: astore_2
    //   126: aload_1
    //   127: astore_3
    //   128: aload 4
    //   130: monitorexit
    //   131: aload_1
    //   132: astore_3
    //   133: aload_1
    //   134: astore 4
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: aload_3
    //   140: astore_1
    //   141: aload_2
    //   142: invokevirtual 541	java/io/FileNotFoundException:printStackTrace	()V
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 534	java/io/RandomAccessFile:close	()V
    //   153: iconst_0
    //   154: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   157: areturn
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 540	java/io/IOException:printStackTrace	()V
    //   163: goto -10 -> 153
    //   166: astore_2
    //   167: aload 4
    //   169: astore_1
    //   170: aload_2
    //   171: invokevirtual 540	java/io/IOException:printStackTrace	()V
    //   174: aload 4
    //   176: ifnull -23 -> 153
    //   179: aload 4
    //   181: invokevirtual 534	java/io/RandomAccessFile:close	()V
    //   184: goto -31 -> 153
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 540	java/io/IOException:printStackTrace	()V
    //   192: goto -39 -> 153
    //   195: astore_3
    //   196: aload_1
    //   197: astore_2
    //   198: aload_3
    //   199: astore_1
    //   200: aload_2
    //   201: ifnull +7 -> 208
    //   204: aload_2
    //   205: invokevirtual 534	java/io/RandomAccessFile:close	()V
    //   208: aload_1
    //   209: athrow
    //   210: astore_2
    //   211: aload_2
    //   212: invokevirtual 540	java/io/IOException:printStackTrace	()V
    //   215: goto -7 -> 208
    //   218: astore_1
    //   219: goto -19 -> 200
    //   222: astore_1
    //   223: aload_2
    //   224: astore 4
    //   226: aload_1
    //   227: astore_2
    //   228: goto -61 -> 167
    //   231: astore_1
    //   232: aload_2
    //   233: astore_3
    //   234: aload_1
    //   235: astore_2
    //   236: goto -97 -> 139
    //   239: astore_2
    //   240: aload_3
    //   241: astore_1
    //   242: goto -116 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	BubbleManager
    //   4	98	1	localObject1	Object
    //   114	2	1	localIOException1	java.io.IOException
    //   123	18	1	localObject2	Object
    //   158	2	1	localIOException2	java.io.IOException
    //   169	1	1	localObject3	Object
    //   187	10	1	localIOException3	java.io.IOException
    //   199	10	1	localObject4	Object
    //   218	1	1	localObject5	Object
    //   222	5	1	localIOException4	java.io.IOException
    //   231	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   241	1	1	localObject6	Object
    //   37	100	2	localObject7	Object
    //   138	4	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   166	5	2	localIOException5	java.io.IOException
    //   197	8	2	localIOException6	java.io.IOException
    //   210	14	2	localIOException7	java.io.IOException
    //   227	9	2	localObject8	Object
    //   239	1	2	localObject9	Object
    //   9	83	3	localObject10	Object
    //   121	4	3	localObject11	Object
    //   127	23	3	localObject12	Object
    //   195	4	3	localObject13	Object
    //   233	8	3	localObject14	Object
    //   1	224	4	localObject15	Object
    //   6	84	5	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   106	114	114	java/io/IOException
    //   71	89	121	finally
    //   50	62	138	java/io/FileNotFoundException
    //   136	138	138	java/io/FileNotFoundException
    //   149	153	158	java/io/IOException
    //   50	62	166	java/io/IOException
    //   136	138	166	java/io/IOException
    //   179	184	187	java/io/IOException
    //   50	62	195	finally
    //   136	138	195	finally
    //   141	145	195	finally
    //   170	174	195	finally
    //   204	208	210	java/io/IOException
    //   62	71	218	finally
    //   62	71	222	java/io/IOException
    //   62	71	231	java/io/FileNotFoundException
    //   92	95	239	finally
    //   128	131	239	finally
  }
  
  private Boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return Boolean.valueOf(true);
    }
    paramString = paramString.split(",");
    int i1 = 0;
    String[] arrayOfString;
    while (i1 < paramString.length)
    {
      arrayOfString = paramString[i1].split("\\|");
      if ((arrayOfString.length == 4) && (Long.parseLong(arrayOfString[1]) == 1L)) {
        return Boolean.valueOf(false);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < paramString.length)
    {
      arrayOfString = paramString[i1].split("\\|");
      if ((arrayOfString.length == 4) && (Long.parseLong(arrayOfString[3]) == 0L)) {
        return Boolean.valueOf(false);
      }
      i1 += 1;
    }
    return Boolean.valueOf(true);
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = FileUtils.b(new File(paramString));
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
      }
    }
    return null;
  }
  
  private ArrayList a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int i1 = 0;
    if (i1 < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.getJSONObject(i1);
      if (((JSONObject)localObject).has("pendent_prefix")) {}
      for (localObject = a((JSONObject)localObject);; localObject = b((JSONObject)localObject))
      {
        localArrayList.add(localObject);
        i1 += 1;
        break;
      }
    }
    return localArrayList;
  }
  
  private JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("animations")) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONObject("animations");
    } while (paramJSONObject == null);
    return paramJSONObject.getJSONObject(paramString);
  }
  
  private void a(int paramInt)
  {
    File localFile1 = b();
    Object localObject = Integer.toString(paramInt);
    localFile1 = new File(localFile1, (String)localObject);
    if (localFile1.exists())
    {
      File[] arrayOfFile1 = localFile1.listFiles();
      paramInt = 0;
      if (paramInt < arrayOfFile1.length)
      {
        File localFile2 = arrayOfFile1[paramInt];
        if (localFile2.isDirectory())
        {
          File[] arrayOfFile2 = localFile2.listFiles();
          if (arrayOfFile2 != null)
          {
            int i2 = arrayOfFile2.length;
            int i1 = 0;
            while (i1 < i2)
            {
              arrayOfFile2[i1].delete();
              i1 += 1;
            }
            localFile2.delete();
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          arrayOfFile1[paramInt].delete();
        }
      }
      localFile1.delete();
    }
    localObject = new File(c(), (String)localObject);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
  }
  
  private void a(AnimationConfig paramAnimationConfig, JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject.has("type"))
    {
      localObject = paramJSONObject.getString("type");
      if ("line".equalsIgnoreCase((String)localObject)) {
        paramAnimationConfig.n = 10;
      }
      if ("circle".equalsIgnoreCase((String)localObject)) {
        paramAnimationConfig.n = 11;
      }
      if ("static".equalsIgnoreCase((String)localObject)) {
        paramAnimationConfig.n = 1;
      }
    }
    if (paramJSONObject.has("padding"))
    {
      localObject = paramJSONObject.getJSONArray("padding");
      paramAnimationConfig.o = ((JSONArray)localObject).getInt(0);
      paramAnimationConfig.q = ((JSONArray)localObject).getInt(1);
      paramAnimationConfig.p = ((JSONArray)localObject).getInt(2);
      paramAnimationConfig.r = ((JSONArray)localObject).getInt(3);
    }
    if (!paramJSONObject.has("step")) {}
    do
    {
      return;
      if (paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray == null) {
        paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
      }
      paramJSONObject = paramJSONObject.getJSONObject("step");
      if (paramJSONObject.has("static"))
      {
        localObject = paramJSONObject.getJSONObject("static");
        paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(0, a("static", (JSONObject)localObject));
      }
      if (paramJSONObject.has("moving"))
      {
        localObject = paramJSONObject.getJSONObject("moving");
        paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(1, a("moving", (JSONObject)localObject));
      }
    } while (!paramJSONObject.has("turnback"));
    paramJSONObject = paramJSONObject.getJSONObject("turnback");
    paramAnimationConfig.jdField_a_of_type_AndroidUtilSparseArray.put(2, a("turnback", paramJSONObject));
  }
  
  private boolean a(BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|bubbleInfo is null");
      }
      return false;
    }
    Object localObject1 = a(paramBubbleInfo.jdField_c_of_type_Int, false).getAbsolutePath() + File.separatorChar + "chartlet" + File.separatorChar;
    localObject1 = (String)localObject1 + "chartlet.png";
    boolean bool = new File((String)localObject1).exists();
    if (((!bool) || (!TextUtils.isEmpty(paramBubbleInfo.jdField_e_of_type_JavaLangString))) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|bubbleId=" + paramBubbleInfo.jdField_c_of_type_Int + ",chkStaticSrcAndUpdate is ok | not empty");
      }
      return true;
    }
    String str3 = a(paramBubbleInfo.jdField_c_of_type_Int, false).getAbsolutePath() + File.separatorChar + "static" + File.separatorChar;
    String str1 = str3 + "aio_user_bg_nor.9.png";
    String str2 = str3 + "aio_user_pic_nor.9.png";
    str3 = str3 + "chat_bubble_thumbnail.png";
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(str1);
    ((List)localObject2).add(str2);
    ((List)localObject2).add(str3);
    if (bool) {
      ((List)localObject2).add(localObject1);
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str4 = (String)((Iterator)localObject2).next();
      if (!new File(str4).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|file is not exists,bubbleId=" + paramBubbleInfo.jdField_c_of_type_Int + ",strFilePath=" + str4);
        }
        return false;
      }
    }
    paramBubbleInfo.jdField_d_of_type_JavaLangString = str3;
    paramBubbleInfo.jdField_a_of_type_JavaLangString = str1;
    paramBubbleInfo.jdField_b_of_type_JavaLangString = str2;
    paramBubbleInfo.jdField_e_of_type_JavaLangString = ((String)localObject1);
    try
    {
      localObject1 = a(str3, null);
      if (localObject1 != null)
      {
        int i1 = ((Bitmap)localObject1).getPixel(((Bitmap)localObject1).getWidth() / 2, ((Bitmap)localObject1).getHeight() / 2);
        if (paramBubbleInfo.jdField_d_of_type_Int == i1)
        {
          paramBubbleInfo.jdField_d_of_type_Int = Color.rgb(255 - Color.red(i1), 255 - Color.green(i1), 255 - Color.blue(i1));
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "text color:" + Integer.toHexString(i1) + ",  now chage to " + Integer.toHexString(paramBubbleInfo.jdField_d_of_type_Int));
          }
        }
        if (paramBubbleInfo.jdField_e_of_type_Int == i1)
        {
          paramBubbleInfo.jdField_e_of_type_Int = Color.rgb(255 - Color.red(i1), 255 - Color.green(i1), 255 - Color.blue(i1));
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "mLinkColor :" + Integer.toHexString(i1) + ",  now chage to " + Integer.toHexString(paramBubbleInfo.jdField_e_of_type_Int));
          }
        }
      }
    }
    catch (OutOfMemoryError paramBubbleInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "bubble change color out of memory error!", paramBubbleInfo);
        }
      }
    }
    catch (Exception paramBubbleInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "bubble change color throws exception!", paramBubbleInfo);
        }
      }
    }
    return true;
  }
  
  private BubbleNewAnimConf b(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = null;
    }
    BubbleNewAnimConf.PathAnimConf localPathAnimConf;
    do
    {
      return (BubbleNewAnimConf)localObject;
      localPathAnimConf = new BubbleNewAnimConf.PathAnimConf();
      if (paramJSONObject.has("key")) {
        localPathAnimConf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("key");
      }
      if (paramJSONObject.has("start_end"))
      {
        localObject = paramJSONObject.getJSONArray("start_end");
        localPathAnimConf.jdField_a_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localPathAnimConf.jdField_b_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localPathAnimConf.c = ((float)((JSONArray)localObject).getDouble(2));
        localPathAnimConf.jdField_d_of_type_Float = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("bezier"))
      {
        localObject = paramJSONObject.getJSONArray("bezier");
        localPathAnimConf.jdField_e_of_type_Float = ((float)((JSONArray)localObject).getDouble(0));
        localPathAnimConf.jdField_f_of_type_Float = ((float)((JSONArray)localObject).getDouble(1));
        localPathAnimConf.jdField_g_of_type_Float = ((float)((JSONArray)localObject).getDouble(2));
        localPathAnimConf.jdField_h_of_type_Float = ((float)((JSONArray)localObject).getDouble(3));
      }
      if (paramJSONObject.has("duration")) {
        localPathAnimConf.jdField_a_of_type_Long = paramJSONObject.getInt("duration");
      }
      if (paramJSONObject.has("speed")) {
        localPathAnimConf.jdField_f_of_type_Int = paramJSONObject.getInt("speed");
      }
      if (paramJSONObject.has("img_prefix")) {
        localPathAnimConf.jdField_b_of_type_JavaLangString = paramJSONObject.getString("img_prefix");
      }
      if (paramJSONObject.has("img_reverse")) {
        localPathAnimConf.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("img_reverse");
      }
      if (paramJSONObject.has("img_alpha"))
      {
        localObject = paramJSONObject.getJSONArray("img_alpha");
        localPathAnimConf.jdField_g_of_type_Int = ((JSONArray)localObject).getInt(0);
        localPathAnimConf.jdField_h_of_type_Int = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("repeat")) {
        localPathAnimConf.jdField_d_of_type_Int = paramJSONObject.getInt("repeat");
      }
      if (paramJSONObject.has("img_rotate"))
      {
        localObject = paramJSONObject.getJSONArray("img_rotate");
        localPathAnimConf.i = ((JSONArray)localObject).getInt(0);
        localPathAnimConf.j = ((JSONArray)localObject).getInt(1);
      }
      if (paramJSONObject.has("img_count")) {
        localPathAnimConf.jdField_e_of_type_Int = paramJSONObject.getInt("img_count");
      }
      if (paramJSONObject.has("periodical")) {
        localPathAnimConf.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("periodical");
      }
      localObject = localPathAnimConf;
    } while (!paramJSONObject.has("period_length"));
    localPathAnimConf.k = paramJSONObject.getInt("period_length");
    return localPathAnimConf;
  }
  
  private JSONObject b(String paramString, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("animation_sets")) {}
    do
    {
      return null;
      paramJSONObject = paramJSONObject.getJSONObject("animation_sets");
    } while (paramJSONObject == null);
    return paramJSONObject.getJSONObject(paramString);
  }
  
  /* Error */
  Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 793	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 794	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: new 796	java/io/BufferedInputStream
    //   15: dup
    //   16: aload_3
    //   17: invokespecial 799	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 6
    //   22: aload_2
    //   23: ifnull +44 -> 67
    //   26: aload_3
    //   27: astore 5
    //   29: aload 6
    //   31: astore 4
    //   33: aload 6
    //   35: aconst_null
    //   36: aload_2
    //   37: invokestatic 805	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: ifnull +7 -> 51
    //   47: aload_3
    //   48: invokevirtual 808	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: astore_3
    //   53: aload 6
    //   55: ifnull +10 -> 65
    //   58: aload 6
    //   60: invokevirtual 808	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: astore_3
    //   65: aload_3
    //   66: areturn
    //   67: aload_3
    //   68: astore 5
    //   70: aload 6
    //   72: astore 4
    //   74: aload 6
    //   76: invokestatic 811	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   79: astore_2
    //   80: aload_2
    //   81: astore_1
    //   82: goto -39 -> 43
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_3
    //   91: astore 5
    //   93: aload_1
    //   94: astore 4
    //   96: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: iconst_1
    //   100: new 368	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 813
    //   110: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_2
    //   114: invokevirtual 816	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_3
    //   124: ifnull +7 -> 131
    //   127: aload_3
    //   128: invokevirtual 808	java/io/InputStream:close	()V
    //   131: aload 8
    //   133: astore_3
    //   134: aload_1
    //   135: ifnull -70 -> 65
    //   138: aload_1
    //   139: invokevirtual 808	java/io/InputStream:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: areturn
    //   147: astore 7
    //   149: aconst_null
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_2
    //   153: aload_3
    //   154: astore 5
    //   156: aload_2
    //   157: astore 4
    //   159: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: iconst_1
    //   163: new 368	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 818
    //   173: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: aload 7
    //   185: invokestatic 731	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 808	java/io/InputStream:close	()V
    //   196: aload 8
    //   198: astore_3
    //   199: aload_2
    //   200: ifnull -135 -> 65
    //   203: aload_2
    //   204: invokevirtual 808	java/io/InputStream:close	()V
    //   207: aconst_null
    //   208: areturn
    //   209: astore_1
    //   210: aconst_null
    //   211: areturn
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_3
    //   215: aconst_null
    //   216: astore 4
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 808	java/io/InputStream:close	()V
    //   226: aload 4
    //   228: ifnull +8 -> 236
    //   231: aload 4
    //   233: invokevirtual 808	java/io/InputStream:close	()V
    //   236: aload_1
    //   237: athrow
    //   238: astore_2
    //   239: goto -188 -> 51
    //   242: astore_2
    //   243: aload_1
    //   244: areturn
    //   245: astore_2
    //   246: goto -115 -> 131
    //   249: astore_1
    //   250: goto -54 -> 196
    //   253: astore_2
    //   254: goto -28 -> 226
    //   257: astore_2
    //   258: goto -22 -> 236
    //   261: astore_1
    //   262: aconst_null
    //   263: astore 4
    //   265: goto -47 -> 218
    //   268: astore_1
    //   269: aload 5
    //   271: astore_3
    //   272: goto -54 -> 218
    //   275: astore 7
    //   277: aconst_null
    //   278: astore_2
    //   279: goto -126 -> 153
    //   282: astore 7
    //   284: aload 6
    //   286: astore_2
    //   287: goto -134 -> 153
    //   290: astore_2
    //   291: aconst_null
    //   292: astore_1
    //   293: goto -203 -> 90
    //   296: astore_2
    //   297: aload 6
    //   299: astore_1
    //   300: goto -210 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	BubbleManager
    //   0	303	1	paramString	String
    //   0	303	2	paramOptions	BitmapFactory.Options
    //   11	261	3	localObject1	Object
    //   31	233	4	localObject2	Object
    //   27	243	5	localObject3	Object
    //   20	278	6	localBufferedInputStream	java.io.BufferedInputStream
    //   147	37	7	localOutOfMemoryError1	OutOfMemoryError
    //   275	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   282	1	7	localOutOfMemoryError3	OutOfMemoryError
    //   1	196	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	85	java/lang/Exception
    //   138	142	144	java/io/IOException
    //   3	12	147	java/lang/OutOfMemoryError
    //   203	207	209	java/io/IOException
    //   3	12	212	finally
    //   47	51	238	java/io/IOException
    //   58	63	242	java/io/IOException
    //   127	131	245	java/io/IOException
    //   192	196	249	java/io/IOException
    //   222	226	253	java/io/IOException
    //   231	236	257	java/io/IOException
    //   12	22	261	finally
    //   33	41	268	finally
    //   74	80	268	finally
    //   96	123	268	finally
    //   159	188	268	finally
    //   12	22	275	java/lang/OutOfMemoryError
    //   33	41	282	java/lang/OutOfMemoryError
    //   74	80	282	java/lang/OutOfMemoryError
    //   12	22	290	java/lang/Exception
    //   33	41	296	java/lang/Exception
    //   74	80	296	java/lang/Exception
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject = (Pair)BaseApplicationImpl.a.get("bubble_thumb_" + paramInt);
    if (localObject != null) {
      return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    if (paramInt < 0) {
      return null;
    }
    BubbleInfo localBubbleInfo = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
    localObject = localBubbleInfo;
    if (localBubbleInfo == null)
    {
      localObject = localBubbleInfo;
      if (a(paramInt, true)) {
        localObject = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
      }
    }
    if ((localObject != null) && (!TextUtils.isEmpty(((BubbleInfo)localObject).jdField_d_of_type_JavaLangString)))
    {
      localObject = BubbleInfo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((BubbleInfo)localObject).jdField_d_of_type_JavaLangString);
      if (localObject != null)
      {
        BaseApplicationImpl.a.put("bubble_thumb_" + paramInt, new Pair(((Drawable)((Pair)localObject).first).getConstantState(), ((Pair)localObject).second));
        return (Drawable)((Pair)localObject).first;
      }
    }
    if (0 == 0) {
      return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838121);
    }
    return null;
  }
  
  public AnimationConfig a(int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInt1, false);
    if (localObject1 == null) {
      return null;
    }
    switch (paramInt2)
    {
    case 4: 
    default: 
      localObject1 = null;
    }
    Object localObject2;
    Object localObject3;
    File localFile;
    int i1;
    for (;;)
    {
      if (localObject1 != null) {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(((AnimationConfig)localObject1).jdField_b_of_type_JavaLangString))
        {
          return (AnimationConfig)localObject1;
          localObject1 = ((BubbleConfig)localObject1).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig;
          AnimationConfig.a((AnimationConfig)localObject1);
          continue;
          localObject1 = ((BubbleConfig)localObject1).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig;
          continue;
          localObject1 = ((BubbleConfig)localObject1).jdField_d_of_type_ComTencentMobileqqBubbleAnimationConfig;
        }
        else if ((localObject1 != null) && (((AnimationConfig)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (((AnimationConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject2 = ((AnimationConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
          paramInt2 = 1;
          if (!((Iterator)localObject2).hasNext()) {
            break label301;
          }
          localObject3 = (BubbleNewAnimConf)((Iterator)localObject2).next();
          localFile = new File(a(paramInt1, false), ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString);
          i1 = 0;
          label170:
          if (i1 >= ((BubbleNewAnimConf)localObject3).jdField_e_of_type_Int) {
            break label494;
          }
          String str = localFile.getAbsolutePath() + File.separatorChar + ((BubbleNewAnimConf)localObject3).jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
          if (!new File(str).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "pendent anim conf, file is not exit, " + str);
            }
            paramInt2 = 0;
          }
        }
      }
    }
    label301:
    label494:
    for (;;)
    {
      break;
      i1 += 1;
      break label170;
      return null;
      if ((paramInt2 == 0) || (a(paramInt1, ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString).booleanValue()))
      {
        localObject3 = a(paramInt1, ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString + ".zip");
        localFile = new File(a(paramInt1, true), ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString + ".zip");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("name", ((AnimationConfig)localObject1).jdField_a_of_type_JavaLangString + ".zip");
        ((Bundle)localObject2).putInt("id", paramInt1);
        localObject1 = new DownloadTask((String)localObject3, localFile);
        ((DownloadTask)localObject1).e = this.jdField_c_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, this.b, (Bundle)localObject2);
        return null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((AnimationConfig)localObject1).jdField_b_of_type_JavaLangString, localObject1);
      return (AnimationConfig)localObject1;
    }
  }
  
  public AnimationConfig a(int paramInt, String paramString)
  {
    Object localObject = a(paramInt, true);
    if (localObject == null) {
      return null;
    }
    if ((((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if ((((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if ((((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig != null) && (((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return ((BubbleConfig)localObject).jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if (((BubbleConfig)localObject).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = ((BubbleConfig)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AnimationConfig localAnimationConfig = (AnimationConfig)((Iterator)localObject).next();
        if (localAnimationConfig.jdField_b_of_type_JavaLangString.equals(paramString)) {
          return localAnimationConfig;
        }
      }
    }
    return null;
  }
  
  /* Error */
  public BubbleConfig a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 213	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_2
    //   11: invokespecial 908	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_3
    //   15: aload_3
    //   16: invokestatic 213	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +30 -> 57
    //   30: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: iconst_2
    //   34: new 368	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 910
    //   44: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_3
    //   48: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_3
    //   58: astore_2
    //   59: getstatic 915	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 10
    //   64: if_icmpgt +32 -> 96
    //   67: aload_3
    //   68: astore_2
    //   69: aload_3
    //   70: invokevirtual 543	java/lang/String:length	()I
    //   73: iconst_1
    //   74: if_icmple +22 -> 96
    //   77: aload_3
    //   78: astore_2
    //   79: aload_3
    //   80: iconst_0
    //   81: invokevirtual 919	java/lang/String:charAt	(I)C
    //   84: ldc_w 920
    //   87: if_icmpne +9 -> 96
    //   90: aload_3
    //   91: iconst_1
    //   92: invokevirtual 923	java/lang/String:substring	(I)Ljava/lang/String;
    //   95: astore_2
    //   96: new 880	com/tencent/mobileqq/bubble/BubbleConfig
    //   99: dup
    //   100: iload_1
    //   101: invokespecial 924	com/tencent/mobileqq/bubble/BubbleConfig:<init>	(I)V
    //   104: astore 4
    //   106: new 251	org/json/JSONObject
    //   109: dup
    //   110: aload_2
    //   111: invokespecial 925	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   114: astore 5
    //   116: aload 4
    //   118: aload 5
    //   120: ldc_w 438
    //   123: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   126: putfield 927	com/tencent/mobileqq/bubble/BubbleConfig:n	Ljava/lang/String;
    //   129: aload 5
    //   131: ldc_w 929
    //   134: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   137: ifeq +58 -> 195
    //   140: aload 5
    //   142: ldc_w 929
    //   145: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore_3
    //   149: aload_3
    //   150: astore_2
    //   151: aload_3
    //   152: ldc_w 931
    //   155: invokevirtual 934	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   158: ifeq +9 -> 167
    //   161: aload_3
    //   162: iconst_2
    //   163: invokevirtual 923	java/lang/String:substring	(I)Ljava/lang/String;
    //   166: astore_2
    //   167: aload 4
    //   169: new 368	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 936
    //   179: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_2
    //   183: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 939	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   192: putfield 941	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_Int	I
    //   195: aload 5
    //   197: ldc_w 943
    //   200: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   203: ifeq +58 -> 261
    //   206: aload 5
    //   208: ldc_w 943
    //   211: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore_3
    //   215: aload_3
    //   216: astore_2
    //   217: aload_3
    //   218: ldc_w 931
    //   221: invokevirtual 934	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   224: ifeq +9 -> 233
    //   227: aload_3
    //   228: iconst_2
    //   229: invokevirtual 923	java/lang/String:substring	(I)Ljava/lang/String;
    //   232: astore_2
    //   233: aload 4
    //   235: new 368	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 936
    //   245: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_2
    //   249: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 939	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   258: putfield 944	com/tencent/mobileqq/bubble/BubbleConfig:jdField_c_of_type_Int	I
    //   261: aload 5
    //   263: ldc_w 946
    //   266: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   269: ifeq +64 -> 333
    //   272: aload 4
    //   274: iconst_1
    //   275: putfield 947	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_Boolean	Z
    //   278: aload 5
    //   280: ldc_w 946
    //   283: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: astore_3
    //   287: aload_3
    //   288: astore_2
    //   289: aload_3
    //   290: ldc_w 931
    //   293: invokevirtual 934	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   296: ifeq +9 -> 305
    //   299: aload_3
    //   300: iconst_2
    //   301: invokevirtual 923	java/lang/String:substring	(I)Ljava/lang/String;
    //   304: astore_2
    //   305: aload 4
    //   307: new 368	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   314: ldc_w 936
    //   317: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_2
    //   321: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 939	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   330: putfield 948	com/tencent/mobileqq/bubble/BubbleConfig:jdField_d_of_type_Int	I
    //   333: aload 5
    //   335: ldc_w 950
    //   338: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   341: ifeq +36 -> 377
    //   344: aload 5
    //   346: ldc_w 950
    //   349: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   352: astore_2
    //   353: aload 4
    //   355: iconst_2
    //   356: newarray <illegal type>
    //   358: dup
    //   359: iconst_0
    //   360: aload_2
    //   361: iconst_0
    //   362: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   365: iastore
    //   366: dup
    //   367: iconst_1
    //   368: aload_2
    //   369: iconst_1
    //   370: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   373: iastore
    //   374: putfield 951	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ArrayOfInt	[I
    //   377: aload 5
    //   379: ldc_w 953
    //   382: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   385: ifeq +64 -> 449
    //   388: aload 5
    //   390: ldc_w 953
    //   393: invokevirtual 590	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   396: astore_2
    //   397: aload_2
    //   398: ldc_w 955
    //   401: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   404: ifeq +45 -> 449
    //   407: aload_0
    //   408: aload_2
    //   409: ldc_w 955
    //   412: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   415: aload 5
    //   417: invokespecial 957	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   420: astore_3
    //   421: aload_3
    //   422: ifnull +27 -> 449
    //   425: aload_0
    //   426: iconst_0
    //   427: aload_3
    //   428: invokespecial 959	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   431: astore_3
    //   432: aload_3
    //   433: aload_2
    //   434: ldc_w 955
    //   437: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   440: putfield 875	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   443: aload 4
    //   445: aload_3
    //   446: putfield 902	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   449: aload 5
    //   451: ldc_w 961
    //   454: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   457: ifeq +102 -> 559
    //   460: aload 5
    //   462: ldc_w 961
    //   465: invokevirtual 590	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   468: astore_2
    //   469: aload_2
    //   470: ldc_w 955
    //   473: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   476: ifeq +83 -> 559
    //   479: aload_0
    //   480: aload_2
    //   481: ldc_w 955
    //   484: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   487: aload 5
    //   489: invokespecial 957	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   492: astore 6
    //   494: aload 6
    //   496: ifnull +63 -> 559
    //   499: aload_0
    //   500: iconst_2
    //   501: aload 6
    //   503: invokespecial 959	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   506: astore_3
    //   507: aload 6
    //   509: ldc_w 963
    //   512: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   515: astore 6
    //   517: aload_3
    //   518: iconst_2
    //   519: newarray <illegal type>
    //   521: dup
    //   522: iconst_0
    //   523: aload 6
    //   525: iconst_0
    //   526: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   529: iastore
    //   530: dup
    //   531: iconst_1
    //   532: aload 6
    //   534: iconst_1
    //   535: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   538: iastore
    //   539: putfield 965	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfInt	[I
    //   542: aload_3
    //   543: aload_2
    //   544: ldc_w 955
    //   547: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   550: putfield 875	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   553: aload 4
    //   555: aload_3
    //   556: putfield 887	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   559: aload 5
    //   561: ldc_w 967
    //   564: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   567: ifeq +118 -> 685
    //   570: aload 5
    //   572: ldc_w 967
    //   575: invokevirtual 590	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   578: astore_2
    //   579: aload_2
    //   580: ldc_w 955
    //   583: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   586: ifeq +99 -> 685
    //   589: aload_0
    //   590: aload_2
    //   591: ldc_w 955
    //   594: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   597: aload 5
    //   599: invokespecial 957	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   602: astore_3
    //   603: aload_3
    //   604: ifnull +81 -> 685
    //   607: aload_0
    //   608: iconst_3
    //   609: aload_3
    //   610: invokespecial 959	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   613: astore_3
    //   614: aload_3
    //   615: aload_2
    //   616: ldc_w 955
    //   619: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   622: putfield 875	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   625: aload_2
    //   626: ldc_w 969
    //   629: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   632: ifeq +47 -> 679
    //   635: aload_2
    //   636: ldc_w 969
    //   639: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   642: istore 9
    //   644: aload_3
    //   645: aload_0
    //   646: getfield 158	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   649: ldc_w 971
    //   652: invokevirtual 975	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   655: checkcast 977	android/view/WindowManager
    //   658: invokeinterface 981 1 0
    //   663: invokevirtual 984	android/view/Display:getWidth	()I
    //   666: i2d
    //   667: iload 9
    //   669: i2d
    //   670: ldc2_w 985
    //   673: ddiv
    //   674: dmul
    //   675: d2i
    //   676: putfield 988	com/tencent/mobileqq/bubble/AnimationConfig:s	I
    //   679: aload 4
    //   681: aload_3
    //   682: putfield 882	com/tencent/mobileqq/bubble/BubbleConfig:jdField_c_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   685: aload 5
    //   687: ldc_w 990
    //   690: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   693: ifeq +385 -> 1078
    //   696: aload 5
    //   698: ldc_w 990
    //   701: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   704: astore_2
    //   705: new 572	java/util/ArrayList
    //   708: dup
    //   709: invokespecial 663	java/util/ArrayList:<init>	()V
    //   712: astore_3
    //   713: iconst_0
    //   714: istore 9
    //   716: iload 9
    //   718: aload_2
    //   719: invokevirtual 293	org/json/JSONArray:length	()I
    //   722: if_icmpge +350 -> 1072
    //   725: aload_2
    //   726: iload 9
    //   728: invokevirtual 577	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   731: astore 6
    //   733: aload 6
    //   735: ldc_w 955
    //   738: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   741: ifeq +1323 -> 2064
    //   744: aload_0
    //   745: aload 6
    //   747: ldc_w 955
    //   750: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   753: aload 5
    //   755: invokespecial 957	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   758: astore 7
    //   760: aload 7
    //   762: ifnonnull +198 -> 960
    //   765: goto +1299 -> 2064
    //   768: astore_2
    //   769: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   772: ifeq -577 -> 195
    //   775: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   778: iconst_2
    //   779: ldc_w 992
    //   782: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   785: goto -590 -> 195
    //   788: astore_2
    //   789: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   792: ifeq +36 -> 828
    //   795: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   798: iconst_2
    //   799: new 368	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   806: ldc_w 994
    //   809: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: iload_1
    //   813: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   816: ldc_w 996
    //   819: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokestatic 999	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: aconst_null
    //   829: areturn
    //   830: astore_2
    //   831: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq -573 -> 261
    //   837: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   840: iconst_2
    //   841: ldc_w 1001
    //   844: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: goto -586 -> 261
    //   850: astore_2
    //   851: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   854: ifeq -26 -> 828
    //   857: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   860: iconst_2
    //   861: new 368	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   868: ldc_w 994
    //   871: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: iload_1
    //   875: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   878: ldc_w 1003
    //   881: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 999	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   890: goto -62 -> 828
    //   893: astore_2
    //   894: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   897: ifeq -564 -> 333
    //   900: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   903: iconst_2
    //   904: ldc_w 1005
    //   907: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: goto -577 -> 333
    //   913: astore_2
    //   914: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   917: ifeq -89 -> 828
    //   920: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   923: iconst_2
    //   924: new 368	java/lang/StringBuilder
    //   927: dup
    //   928: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   931: ldc_w 994
    //   934: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: iload_1
    //   938: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   941: ldc_w 1007
    //   944: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload_2
    //   948: invokevirtual 816	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   951: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: invokestatic 999	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   957: goto -129 -> 828
    //   960: aload_0
    //   961: iconst_1
    //   962: aload 7
    //   964: invokespecial 959	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   967: astore 7
    //   969: aload 6
    //   971: ldc_w 1009
    //   974: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   977: astore 8
    //   979: aload 7
    //   981: aload 8
    //   983: invokevirtual 293	org/json/JSONArray:length	()I
    //   986: anewarray 217	java/lang/String
    //   989: putfield 1011	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   992: iconst_0
    //   993: istore 10
    //   995: iload 10
    //   997: aload 8
    //   999: invokevirtual 293	org/json/JSONArray:length	()I
    //   1002: if_icmpge +27 -> 1029
    //   1005: aload 7
    //   1007: getfield 1011	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1010: iload 10
    //   1012: aload 8
    //   1014: iload 10
    //   1016: invokevirtual 1013	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1019: aastore
    //   1020: iload 10
    //   1022: iconst_1
    //   1023: iadd
    //   1024: istore 10
    //   1026: goto -31 -> 995
    //   1029: aload 7
    //   1031: aload 6
    //   1033: ldc_w 955
    //   1036: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1039: putfield 875	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1042: aload_3
    //   1043: aload 7
    //   1045: invokevirtual 582	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1048: pop
    //   1049: goto +1015 -> 2064
    //   1052: astore_2
    //   1053: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1056: ifeq -228 -> 828
    //   1059: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1062: iconst_2
    //   1063: ldc_w 1015
    //   1066: invokestatic 999	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1069: goto -241 -> 828
    //   1072: aload 4
    //   1074: aload_3
    //   1075: putfield 903	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1078: aload 5
    //   1080: ldc_w 1017
    //   1083: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1086: ifeq +147 -> 1233
    //   1089: aload 5
    //   1091: ldc_w 1017
    //   1094: invokevirtual 590	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1097: astore_2
    //   1098: new 1019	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet
    //   1101: dup
    //   1102: invokespecial 1020	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:<init>	()V
    //   1105: astore_3
    //   1106: aload_2
    //   1107: ldc_w 1022
    //   1110: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1113: ifeq +60 -> 1173
    //   1116: aload_2
    //   1117: ldc_w 1022
    //   1120: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1123: astore 6
    //   1125: aload_3
    //   1126: aload 6
    //   1128: invokevirtual 293	org/json/JSONArray:length	()I
    //   1131: anewarray 217	java/lang/String
    //   1134: putfield 1023	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1137: iconst_0
    //   1138: istore 9
    //   1140: iload 9
    //   1142: aload 6
    //   1144: invokevirtual 293	org/json/JSONArray:length	()I
    //   1147: if_icmpge +26 -> 1173
    //   1150: aload_3
    //   1151: getfield 1023	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1154: iload 9
    //   1156: aload 6
    //   1158: iload 9
    //   1160: invokevirtual 1013	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1163: aastore
    //   1164: iload 9
    //   1166: iconst_1
    //   1167: iadd
    //   1168: istore 9
    //   1170: goto -30 -> 1140
    //   1173: aload_2
    //   1174: ldc_w 969
    //   1177: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1180: ifeq +47 -> 1227
    //   1183: aload_2
    //   1184: ldc_w 969
    //   1187: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1190: istore 9
    //   1192: aload_3
    //   1193: aload_0
    //   1194: getfield 158	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1197: ldc_w 971
    //   1200: invokevirtual 975	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1203: checkcast 977	android/view/WindowManager
    //   1206: invokeinterface 981 1 0
    //   1211: invokevirtual 984	android/view/Display:getWidth	()I
    //   1214: i2d
    //   1215: iload 9
    //   1217: i2d
    //   1218: ldc2_w 985
    //   1221: ddiv
    //   1222: dmul
    //   1223: d2i
    //   1224: putfield 1025	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_Int	I
    //   1227: aload 4
    //   1229: aload_3
    //   1230: putfield 1028	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet	Lcom/tencent/mobileqq/bubble/BubbleConfig$Chartlet;
    //   1233: aload 5
    //   1235: ldc_w 1030
    //   1238: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1241: ifeq +57 -> 1298
    //   1244: aload 5
    //   1246: ldc_w 1030
    //   1249: invokevirtual 590	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1252: astore_2
    //   1253: aload 4
    //   1255: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1258: ifnonnull +15 -> 1273
    //   1261: aload 4
    //   1263: new 1035	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig
    //   1266: dup
    //   1267: invokespecial 1036	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:<init>	()V
    //   1270: putfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1273: aload_2
    //   1274: ldc_w 1038
    //   1277: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1280: ifeq +18 -> 1298
    //   1283: aload 4
    //   1285: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1288: aload_2
    //   1289: ldc_w 1038
    //   1292: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1295: putfield 1039	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1298: aload 5
    //   1300: ldc_w 791
    //   1303: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1306: ifeq +548 -> 1854
    //   1309: aload 5
    //   1311: ldc_w 791
    //   1314: invokevirtual 590	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1317: astore_2
    //   1318: aload 4
    //   1320: getfield 1028	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet	Lcom/tencent/mobileqq/bubble/BubbleConfig$Chartlet;
    //   1323: ifnull +163 -> 1486
    //   1326: aload 4
    //   1328: getfield 1028	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet	Lcom/tencent/mobileqq/bubble/BubbleConfig$Chartlet;
    //   1331: getfield 1023	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1334: ifnull +152 -> 1486
    //   1337: aload 4
    //   1339: getfield 1028	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet	Lcom/tencent/mobileqq/bubble/BubbleConfig$Chartlet;
    //   1342: getfield 1023	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1345: arraylength
    //   1346: ifle +140 -> 1486
    //   1349: aload_2
    //   1350: aload 4
    //   1352: getfield 1028	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet	Lcom/tencent/mobileqq/bubble/BubbleConfig$Chartlet;
    //   1355: getfield 1023	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1358: iconst_0
    //   1359: aaload
    //   1360: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1363: ifeq +123 -> 1486
    //   1366: aload_2
    //   1367: aload 4
    //   1369: getfield 1028	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet	Lcom/tencent/mobileqq/bubble/BubbleConfig$Chartlet;
    //   1372: getfield 1023	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1375: iconst_0
    //   1376: aaload
    //   1377: invokevirtual 590	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1380: astore_3
    //   1381: aload_3
    //   1382: ldc_w 280
    //   1385: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1388: ifeq +73 -> 1461
    //   1391: aload_3
    //   1392: ldc_w 280
    //   1395: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1398: astore 6
    //   1400: aload 4
    //   1402: getfield 1028	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet	Lcom/tencent/mobileqq/bubble/BubbleConfig$Chartlet;
    //   1405: iconst_4
    //   1406: newarray <illegal type>
    //   1408: putfield 1040	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_ArrayOfInt	[I
    //   1411: iconst_0
    //   1412: istore 9
    //   1414: iload 9
    //   1416: aload 6
    //   1418: invokevirtual 293	org/json/JSONArray:length	()I
    //   1421: if_icmpge +40 -> 1461
    //   1424: aload 4
    //   1426: getfield 1028	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet	Lcom/tencent/mobileqq/bubble/BubbleConfig$Chartlet;
    //   1429: getfield 1040	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_ArrayOfInt	[I
    //   1432: iload 9
    //   1434: aload_0
    //   1435: getfield 158	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1438: aload 6
    //   1440: iload 9
    //   1442: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   1445: iconst_2
    //   1446: idiv
    //   1447: i2f
    //   1448: invokestatic 1045	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1451: iastore
    //   1452: iload 9
    //   1454: iconst_1
    //   1455: iadd
    //   1456: istore 9
    //   1458: goto -44 -> 1414
    //   1461: aload_3
    //   1462: ldc_w 309
    //   1465: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1468: ifeq +18 -> 1486
    //   1471: aload 4
    //   1473: getfield 1028	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet	Lcom/tencent/mobileqq/bubble/BubbleConfig$Chartlet;
    //   1476: aload_3
    //   1477: ldc_w 309
    //   1480: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1483: putfield 1046	com/tencent/mobileqq/bubble/BubbleConfig$Chartlet:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1486: aload 4
    //   1488: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1491: ifnull +363 -> 1854
    //   1494: aload 4
    //   1496: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1499: getfield 1039	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1502: ifnull +352 -> 1854
    //   1505: aload_2
    //   1506: aload 4
    //   1508: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1511: getfield 1039	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1514: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1517: ifeq +337 -> 1854
    //   1520: aload_2
    //   1521: aload 4
    //   1523: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1526: getfield 1039	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1529: invokevirtual 590	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1532: astore 6
    //   1534: aload 6
    //   1536: ldc_w 309
    //   1539: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1542: ifeq +19 -> 1561
    //   1545: aload 4
    //   1547: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1550: aload 6
    //   1552: ldc_w 309
    //   1555: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1558: putfield 1047	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1561: aload 6
    //   1563: ldc_w 1049
    //   1566: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1569: ifeq +29 -> 1598
    //   1572: aload 4
    //   1574: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1577: aload_0
    //   1578: getfield 158	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1581: aload 6
    //   1583: ldc_w 1049
    //   1586: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1589: iconst_2
    //   1590: idiv
    //   1591: i2f
    //   1592: invokestatic 1051	com/tencent/mobileqq/util/DisplayUtil:c	(Landroid/content/Context;F)I
    //   1595: putfield 1052	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_b_of_type_Int	I
    //   1598: aload 6
    //   1600: ldc_w 1054
    //   1603: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1606: ifeq +19 -> 1625
    //   1609: aload 4
    //   1611: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1614: aload 6
    //   1616: ldc_w 1054
    //   1619: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1622: putfield 1055	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1625: aload 6
    //   1627: ldc_w 1057
    //   1630: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1633: ifeq +61 -> 1694
    //   1636: aload 6
    //   1638: ldc_w 1057
    //   1641: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1644: astore_3
    //   1645: aload_3
    //   1646: astore_2
    //   1647: aload_3
    //   1648: ldc_w 931
    //   1651: invokevirtual 934	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1654: ifeq +9 -> 1663
    //   1657: aload_3
    //   1658: iconst_2
    //   1659: invokevirtual 923	java/lang/String:substring	(I)Ljava/lang/String;
    //   1662: astore_2
    //   1663: aload 4
    //   1665: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1668: new 368	java/lang/StringBuilder
    //   1671: dup
    //   1672: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   1675: ldc_w 936
    //   1678: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: aload_2
    //   1682: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: invokestatic 939	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1691: putfield 1058	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_a_of_type_Int	I
    //   1694: aload 6
    //   1696: ldc_w 280
    //   1699: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1702: ifeq +91 -> 1793
    //   1705: aload 6
    //   1707: ldc_w 280
    //   1710: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1713: astore_2
    //   1714: aload 4
    //   1716: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1719: iconst_4
    //   1720: newarray <illegal type>
    //   1722: putfield 1059	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_a_of_type_ArrayOfInt	[I
    //   1725: iconst_0
    //   1726: istore 9
    //   1728: iload 9
    //   1730: aload_2
    //   1731: invokevirtual 293	org/json/JSONArray:length	()I
    //   1734: if_icmpge +59 -> 1793
    //   1737: aload 4
    //   1739: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1742: getfield 1059	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_a_of_type_ArrayOfInt	[I
    //   1745: iload 9
    //   1747: aload_0
    //   1748: getfield 158	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1751: aload_2
    //   1752: iload 9
    //   1754: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   1757: iconst_2
    //   1758: idiv
    //   1759: i2f
    //   1760: invokestatic 1045	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1763: iastore
    //   1764: iload 9
    //   1766: iconst_1
    //   1767: iadd
    //   1768: istore 9
    //   1770: goto -42 -> 1728
    //   1773: astore_2
    //   1774: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1777: ifeq -83 -> 1694
    //   1780: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1783: iconst_2
    //   1784: ldc_w 1061
    //   1787: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1790: goto -96 -> 1694
    //   1793: aload 6
    //   1795: ldc_w 1063
    //   1798: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1801: ifeq +19 -> 1820
    //   1804: aload 4
    //   1806: getfield 1033	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig	Lcom/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig;
    //   1809: aload 6
    //   1811: ldc_w 1063
    //   1814: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1817: putfield 1064	com/tencent/mobileqq/bubble/BubbleConfig$DiyTextConfig:jdField_c_of_type_Int	I
    //   1820: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1823: ifeq +31 -> 1854
    //   1826: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1829: iconst_2
    //   1830: new 368	java/lang/StringBuilder
    //   1833: dup
    //   1834: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   1837: ldc_w 1066
    //   1840: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: aload 6
    //   1845: invokevirtual 816	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1848: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1851: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1854: aload 5
    //   1856: ldc_w 1068
    //   1859: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1862: ifeq +199 -> 2061
    //   1865: aload 5
    //   1867: ldc_w 1068
    //   1870: invokevirtual 590	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1873: astore_3
    //   1874: new 275	com/tencent/mobileqq/bubble/AnimationConfig
    //   1877: dup
    //   1878: invokespecial 276	com/tencent/mobileqq/bubble/AnimationConfig:<init>	()V
    //   1881: astore_2
    //   1882: aload_3
    //   1883: ldc_w 1070
    //   1886: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1889: ifeq +14 -> 1903
    //   1892: aload_2
    //   1893: aload_3
    //   1894: ldc_w 1070
    //   1897: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1900: putfield 1073	com/tencent/mobileqq/bubble/AnimationConfig:t	I
    //   1903: aload_3
    //   1904: ldc_w 1022
    //   1907: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1910: ifeq +151 -> 2061
    //   1913: aload_3
    //   1914: ldc_w 1022
    //   1917: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1920: astore_3
    //   1921: aload_2
    //   1922: aload_3
    //   1923: putfield 875	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1926: aload_0
    //   1927: aload_3
    //   1928: aload 5
    //   1930: invokespecial 1075	com/tencent/mobileqq/bubble/BubbleManager:b	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1933: astore 5
    //   1935: aload 5
    //   1937: ifnull +124 -> 2061
    //   1940: aload_2
    //   1941: aload 5
    //   1943: ldc_w 302
    //   1946: invokevirtual 271	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1949: putfield 303	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1952: aload 5
    //   1954: ldc_w 1077
    //   1957: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1960: astore_3
    //   1961: aload 5
    //   1963: ldc_w 617
    //   1966: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1969: ifeq +66 -> 2035
    //   1972: aload 5
    //   1974: ldc_w 617
    //   1977: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1980: astore 5
    //   1982: aload 5
    //   1984: ifnull +51 -> 2035
    //   1987: aload 5
    //   1989: invokevirtual 293	org/json/JSONArray:length	()I
    //   1992: ifle +43 -> 2035
    //   1995: aload_2
    //   1996: aload 5
    //   1998: iconst_0
    //   1999: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   2002: putfield 619	com/tencent/mobileqq/bubble/AnimationConfig:o	I
    //   2005: aload_2
    //   2006: aload 5
    //   2008: iconst_1
    //   2009: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   2012: putfield 621	com/tencent/mobileqq/bubble/AnimationConfig:q	I
    //   2015: aload_2
    //   2016: aload 5
    //   2018: iconst_2
    //   2019: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   2022: putfield 623	com/tencent/mobileqq/bubble/AnimationConfig:p	I
    //   2025: aload_2
    //   2026: aload 5
    //   2028: iconst_3
    //   2029: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   2032: putfield 625	com/tencent/mobileqq/bubble/AnimationConfig:r	I
    //   2035: aload_3
    //   2036: ifnull +19 -> 2055
    //   2039: aload_3
    //   2040: invokevirtual 293	org/json/JSONArray:length	()I
    //   2043: ifle +12 -> 2055
    //   2046: aload_2
    //   2047: aload_0
    //   2048: aload_3
    //   2049: invokespecial 1079	com/tencent/mobileqq/bubble/BubbleManager:a	(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    //   2052: putfield 892	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2055: aload 4
    //   2057: aload_2
    //   2058: putfield 889	com/tencent/mobileqq/bubble/BubbleConfig:jdField_d_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   2061: aload 4
    //   2063: areturn
    //   2064: iload 9
    //   2066: iconst_1
    //   2067: iadd
    //   2068: istore 9
    //   2070: goto -1354 -> 716
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2073	0	this	BubbleManager
    //   0	2073	1	paramInt	int
    //   0	2073	2	paramString	String
    //   14	2035	3	localObject1	Object
    //   104	1958	4	localBubbleConfig	BubbleConfig
    //   114	1913	5	localObject2	Object
    //   492	1352	6	localObject3	Object
    //   758	286	7	localObject4	Object
    //   977	36	8	localJSONArray	JSONArray
    //   642	1427	9	i1	int
    //   993	32	10	i2	int
    // Exception table:
    //   from	to	target	type
    //   167	195	768	java/lang/Exception
    //   9	22	788	java/io/FileNotFoundException
    //   24	57	788	java/io/FileNotFoundException
    //   59	67	788	java/io/FileNotFoundException
    //   69	77	788	java/io/FileNotFoundException
    //   79	96	788	java/io/FileNotFoundException
    //   96	149	788	java/io/FileNotFoundException
    //   151	167	788	java/io/FileNotFoundException
    //   167	195	788	java/io/FileNotFoundException
    //   195	215	788	java/io/FileNotFoundException
    //   217	233	788	java/io/FileNotFoundException
    //   233	261	788	java/io/FileNotFoundException
    //   261	287	788	java/io/FileNotFoundException
    //   289	305	788	java/io/FileNotFoundException
    //   305	333	788	java/io/FileNotFoundException
    //   333	377	788	java/io/FileNotFoundException
    //   377	421	788	java/io/FileNotFoundException
    //   425	449	788	java/io/FileNotFoundException
    //   449	494	788	java/io/FileNotFoundException
    //   499	559	788	java/io/FileNotFoundException
    //   559	603	788	java/io/FileNotFoundException
    //   607	679	788	java/io/FileNotFoundException
    //   679	685	788	java/io/FileNotFoundException
    //   685	713	788	java/io/FileNotFoundException
    //   716	760	788	java/io/FileNotFoundException
    //   769	785	788	java/io/FileNotFoundException
    //   831	847	788	java/io/FileNotFoundException
    //   894	910	788	java/io/FileNotFoundException
    //   960	992	788	java/io/FileNotFoundException
    //   995	1020	788	java/io/FileNotFoundException
    //   1029	1049	788	java/io/FileNotFoundException
    //   1072	1078	788	java/io/FileNotFoundException
    //   1078	1137	788	java/io/FileNotFoundException
    //   1140	1164	788	java/io/FileNotFoundException
    //   1173	1227	788	java/io/FileNotFoundException
    //   1227	1233	788	java/io/FileNotFoundException
    //   1233	1273	788	java/io/FileNotFoundException
    //   1273	1298	788	java/io/FileNotFoundException
    //   1298	1411	788	java/io/FileNotFoundException
    //   1414	1452	788	java/io/FileNotFoundException
    //   1461	1486	788	java/io/FileNotFoundException
    //   1486	1561	788	java/io/FileNotFoundException
    //   1561	1598	788	java/io/FileNotFoundException
    //   1598	1625	788	java/io/FileNotFoundException
    //   1625	1645	788	java/io/FileNotFoundException
    //   1647	1663	788	java/io/FileNotFoundException
    //   1663	1694	788	java/io/FileNotFoundException
    //   1694	1725	788	java/io/FileNotFoundException
    //   1728	1764	788	java/io/FileNotFoundException
    //   1774	1790	788	java/io/FileNotFoundException
    //   1793	1820	788	java/io/FileNotFoundException
    //   1820	1854	788	java/io/FileNotFoundException
    //   1854	1903	788	java/io/FileNotFoundException
    //   1903	1935	788	java/io/FileNotFoundException
    //   1940	1982	788	java/io/FileNotFoundException
    //   1987	2035	788	java/io/FileNotFoundException
    //   2039	2055	788	java/io/FileNotFoundException
    //   2055	2061	788	java/io/FileNotFoundException
    //   233	261	830	java/lang/Exception
    //   9	22	850	java/io/IOException
    //   24	57	850	java/io/IOException
    //   59	67	850	java/io/IOException
    //   69	77	850	java/io/IOException
    //   79	96	850	java/io/IOException
    //   96	149	850	java/io/IOException
    //   151	167	850	java/io/IOException
    //   167	195	850	java/io/IOException
    //   195	215	850	java/io/IOException
    //   217	233	850	java/io/IOException
    //   233	261	850	java/io/IOException
    //   261	287	850	java/io/IOException
    //   289	305	850	java/io/IOException
    //   305	333	850	java/io/IOException
    //   333	377	850	java/io/IOException
    //   377	421	850	java/io/IOException
    //   425	449	850	java/io/IOException
    //   449	494	850	java/io/IOException
    //   499	559	850	java/io/IOException
    //   559	603	850	java/io/IOException
    //   607	679	850	java/io/IOException
    //   679	685	850	java/io/IOException
    //   685	713	850	java/io/IOException
    //   716	760	850	java/io/IOException
    //   769	785	850	java/io/IOException
    //   831	847	850	java/io/IOException
    //   894	910	850	java/io/IOException
    //   960	992	850	java/io/IOException
    //   995	1020	850	java/io/IOException
    //   1029	1049	850	java/io/IOException
    //   1072	1078	850	java/io/IOException
    //   1078	1137	850	java/io/IOException
    //   1140	1164	850	java/io/IOException
    //   1173	1227	850	java/io/IOException
    //   1227	1233	850	java/io/IOException
    //   1233	1273	850	java/io/IOException
    //   1273	1298	850	java/io/IOException
    //   1298	1411	850	java/io/IOException
    //   1414	1452	850	java/io/IOException
    //   1461	1486	850	java/io/IOException
    //   1486	1561	850	java/io/IOException
    //   1561	1598	850	java/io/IOException
    //   1598	1625	850	java/io/IOException
    //   1625	1645	850	java/io/IOException
    //   1647	1663	850	java/io/IOException
    //   1663	1694	850	java/io/IOException
    //   1694	1725	850	java/io/IOException
    //   1728	1764	850	java/io/IOException
    //   1774	1790	850	java/io/IOException
    //   1793	1820	850	java/io/IOException
    //   1820	1854	850	java/io/IOException
    //   1854	1903	850	java/io/IOException
    //   1903	1935	850	java/io/IOException
    //   1940	1982	850	java/io/IOException
    //   1987	2035	850	java/io/IOException
    //   2039	2055	850	java/io/IOException
    //   2055	2061	850	java/io/IOException
    //   305	333	893	java/lang/Exception
    //   9	22	913	org/json/JSONException
    //   24	57	913	org/json/JSONException
    //   59	67	913	org/json/JSONException
    //   69	77	913	org/json/JSONException
    //   79	96	913	org/json/JSONException
    //   96	149	913	org/json/JSONException
    //   151	167	913	org/json/JSONException
    //   167	195	913	org/json/JSONException
    //   195	215	913	org/json/JSONException
    //   217	233	913	org/json/JSONException
    //   233	261	913	org/json/JSONException
    //   261	287	913	org/json/JSONException
    //   289	305	913	org/json/JSONException
    //   305	333	913	org/json/JSONException
    //   333	377	913	org/json/JSONException
    //   377	421	913	org/json/JSONException
    //   425	449	913	org/json/JSONException
    //   449	494	913	org/json/JSONException
    //   499	559	913	org/json/JSONException
    //   559	603	913	org/json/JSONException
    //   607	679	913	org/json/JSONException
    //   679	685	913	org/json/JSONException
    //   685	713	913	org/json/JSONException
    //   716	760	913	org/json/JSONException
    //   769	785	913	org/json/JSONException
    //   831	847	913	org/json/JSONException
    //   894	910	913	org/json/JSONException
    //   960	992	913	org/json/JSONException
    //   995	1020	913	org/json/JSONException
    //   1029	1049	913	org/json/JSONException
    //   1072	1078	913	org/json/JSONException
    //   1078	1137	913	org/json/JSONException
    //   1140	1164	913	org/json/JSONException
    //   1173	1227	913	org/json/JSONException
    //   1227	1233	913	org/json/JSONException
    //   1233	1273	913	org/json/JSONException
    //   1273	1298	913	org/json/JSONException
    //   1298	1411	913	org/json/JSONException
    //   1414	1452	913	org/json/JSONException
    //   1461	1486	913	org/json/JSONException
    //   1486	1561	913	org/json/JSONException
    //   1561	1598	913	org/json/JSONException
    //   1598	1625	913	org/json/JSONException
    //   1625	1645	913	org/json/JSONException
    //   1647	1663	913	org/json/JSONException
    //   1663	1694	913	org/json/JSONException
    //   1694	1725	913	org/json/JSONException
    //   1728	1764	913	org/json/JSONException
    //   1774	1790	913	org/json/JSONException
    //   1793	1820	913	org/json/JSONException
    //   1820	1854	913	org/json/JSONException
    //   1854	1903	913	org/json/JSONException
    //   1903	1935	913	org/json/JSONException
    //   1940	1982	913	org/json/JSONException
    //   1987	2035	913	org/json/JSONException
    //   2039	2055	913	org/json/JSONException
    //   2055	2061	913	org/json/JSONException
    //   9	22	1052	java/lang/Exception
    //   24	57	1052	java/lang/Exception
    //   59	67	1052	java/lang/Exception
    //   69	77	1052	java/lang/Exception
    //   79	96	1052	java/lang/Exception
    //   96	149	1052	java/lang/Exception
    //   151	167	1052	java/lang/Exception
    //   195	215	1052	java/lang/Exception
    //   217	233	1052	java/lang/Exception
    //   261	287	1052	java/lang/Exception
    //   289	305	1052	java/lang/Exception
    //   333	377	1052	java/lang/Exception
    //   377	421	1052	java/lang/Exception
    //   425	449	1052	java/lang/Exception
    //   449	494	1052	java/lang/Exception
    //   499	559	1052	java/lang/Exception
    //   559	603	1052	java/lang/Exception
    //   607	679	1052	java/lang/Exception
    //   679	685	1052	java/lang/Exception
    //   685	713	1052	java/lang/Exception
    //   716	760	1052	java/lang/Exception
    //   769	785	1052	java/lang/Exception
    //   831	847	1052	java/lang/Exception
    //   894	910	1052	java/lang/Exception
    //   960	992	1052	java/lang/Exception
    //   995	1020	1052	java/lang/Exception
    //   1029	1049	1052	java/lang/Exception
    //   1072	1078	1052	java/lang/Exception
    //   1078	1137	1052	java/lang/Exception
    //   1140	1164	1052	java/lang/Exception
    //   1173	1227	1052	java/lang/Exception
    //   1227	1233	1052	java/lang/Exception
    //   1233	1273	1052	java/lang/Exception
    //   1273	1298	1052	java/lang/Exception
    //   1298	1411	1052	java/lang/Exception
    //   1414	1452	1052	java/lang/Exception
    //   1461	1486	1052	java/lang/Exception
    //   1486	1561	1052	java/lang/Exception
    //   1561	1598	1052	java/lang/Exception
    //   1598	1625	1052	java/lang/Exception
    //   1625	1645	1052	java/lang/Exception
    //   1647	1663	1052	java/lang/Exception
    //   1694	1725	1052	java/lang/Exception
    //   1728	1764	1052	java/lang/Exception
    //   1774	1790	1052	java/lang/Exception
    //   1793	1820	1052	java/lang/Exception
    //   1820	1854	1052	java/lang/Exception
    //   1854	1903	1052	java/lang/Exception
    //   1903	1935	1052	java/lang/Exception
    //   1940	1982	1052	java/lang/Exception
    //   1987	2035	1052	java/lang/Exception
    //   2039	2055	1052	java/lang/Exception
    //   2055	2061	1052	java/lang/Exception
    //   1663	1694	1773	java/lang/Exception
  }
  
  public BubbleConfig a(int paramInt, boolean paramBoolean)
  {
    BubbleConfig localBubbleConfig = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.get(Integer.valueOf(paramInt));
    Object localObject = localBubbleConfig;
    if (localBubbleConfig == null)
    {
      localObject = a(paramInt, false).getAbsolutePath() + File.separatorChar + "config.json";
      localBubbleConfig = a(paramInt, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleConfig bubbleId=" + paramInt + ",filePath=" + (String)localObject + ",bubbleConfig=" + localBubbleConfig);
      }
      if (localBubbleConfig == null) {
        break label194;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.put(Integer.valueOf(paramInt), localBubbleConfig);
      localObject = localBubbleConfig;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleConfig bubbleId=" + paramInt + ",autoDownload=" + paramBoolean + ",bubbleConfig=" + localObject);
      }
      return (BubbleConfig)localObject;
      label194:
      localObject = localBubbleConfig;
      if (paramBoolean)
      {
        a(paramInt, "config.json");
        localObject = localBubbleConfig;
      }
    }
  }
  
  public BubbleInfo a(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {
      ??? = null;
    }
    Object localObject2;
    do
    {
      return (BubbleInfo)???;
      localObject2 = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
      if (localObject2 == null) {
        break;
      }
      ??? = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleInfo, from cache, bubbleId=" + paramInt);
    return (BubbleInfo)localObject2;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        localObject2 = new qty(this, paramInt);
        this.jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(paramInt));
        ThreadManager.a((Runnable)localObject2, 8, null, true);
      }
    }
    return null;
  }
  
  public Pair a(int paramInt, AnimationConfig paramAnimationConfig, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramAnimationConfig == null) || (TextUtils.isEmpty(paramAnimationConfig.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramAnimationConfig.jdField_b_of_type_JavaLangString))) {
      return null;
    }
    BubbleInfo.CommonAttrs localCommonAttrs = a(paramInt, paramAnimationConfig.jdField_b_of_type_JavaLangString, paramBoolean, false);
    if (localCommonAttrs == null) {
      return null;
    }
    if (paramAnimationConfig.jdField_a_of_type_JavaLangString.equals(paramAnimationConfig.jdField_c_of_type_JavaLangString)) {
      bool = true;
    }
    return new Pair(localCommonAttrs, a(paramInt, paramAnimationConfig.jdField_c_of_type_JavaLangString, paramBoolean, bool));
  }
  
  public Pair a(int paramInt, String paramString, Pair paramPair)
  {
    Object localObject = paramPair;
    if (paramPair == null)
    {
      paramString = a(paramInt, a(paramInt, paramString), true);
      localObject = paramString;
      if (paramString != null)
      {
        paramPair = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
        localObject = paramString;
        if (paramPair != null)
        {
          paramPair.jdField_a_of_type_JavaUtilList.add(paramString);
          localObject = paramString;
        }
      }
    }
    return (Pair)localObject;
  }
  
  public File a()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "bubble_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File a(int paramInt)
  {
    String str = this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath() + File.separatorChar + "bubble_info" + File.separatorChar + "unzip_temp" + File.separatorChar + paramInt;
    File localFile = new File(str);
    if (localFile.exists()) {
      FileUtils.a(str);
    }
    localFile.mkdirs();
    return localFile;
  }
  
  public File a(int paramInt, boolean paramBoolean)
  {
    String str = a().getAbsolutePath();
    Object localObject = str;
    if (paramBoolean) {
      localObject = str + "/temp";
    }
    localObject = new File((String)localObject + File.separatorChar + paramInt);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return (File)localObject;
  }
  
  /* Error */
  public Boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 119	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   4: ifnonnull +8 -> 12
    //   7: iconst_0
    //   8: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   11: areturn
    //   12: new 357	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokevirtual 514	com/tencent/mobileqq/bubble/BubbleManager:a	()Ljava/io/File;
    //   20: iload_1
    //   21: invokestatic 595	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   24: invokespecial 363	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokevirtual 402	java/io/File:exists	()Z
    //   30: ifne +41 -> 71
    //   33: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +30 -> 66
    //   39: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: iconst_2
    //   43: new 368	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 1134
    //   53: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_1
    //   57: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iconst_0
    //   67: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: areturn
    //   71: aload_0
    //   72: getfield 119	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   75: astore_2
    //   76: aload_2
    //   77: monitorenter
    //   78: iconst_0
    //   79: istore 4
    //   81: aload_0
    //   82: getfield 119	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   85: invokevirtual 293	org/json/JSONArray:length	()I
    //   88: istore 5
    //   90: iload 4
    //   92: iload 5
    //   94: if_icmpge +63 -> 157
    //   97: aload_0
    //   98: getfield 119	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   101: iload 4
    //   103: invokevirtual 577	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   106: astore_3
    //   107: aload_3
    //   108: ldc 51
    //   110: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   113: iload_1
    //   114: if_icmpne +50 -> 164
    //   117: aload_3
    //   118: ldc 60
    //   120: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   123: iconst_1
    //   124: if_icmpne +19 -> 143
    //   127: iconst_1
    //   128: istore 6
    //   130: aload_2
    //   131: monitorexit
    //   132: iload 6
    //   134: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   137: areturn
    //   138: astore_3
    //   139: aload_2
    //   140: monitorexit
    //   141: aload_3
    //   142: athrow
    //   143: iconst_0
    //   144: istore 6
    //   146: goto -16 -> 130
    //   149: astore_3
    //   150: aload_3
    //   151: invokevirtual 1135	java/lang/Exception:printStackTrace	()V
    //   154: goto +10 -> 164
    //   157: aload_2
    //   158: monitorexit
    //   159: iconst_0
    //   160: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   163: areturn
    //   164: iload 4
    //   166: iconst_1
    //   167: iadd
    //   168: istore 4
    //   170: goto -89 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	BubbleManager
    //   0	173	1	paramInt	int
    //   75	83	2	localJSONArray	JSONArray
    //   106	12	3	localJSONObject	JSONObject
    //   138	4	3	localObject	Object
    //   149	2	3	localException	Exception
    //   79	90	4	i1	int
    //   88	7	5	i2	int
    //   128	17	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   81	90	138	finally
    //   97	127	138	finally
    //   130	138	138	finally
    //   139	141	138	finally
    //   150	154	138	finally
    //   157	159	138	finally
    //   97	127	149	java/lang/Exception
  }
  
  /* Error */
  public Boolean a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: iload_1
    //   7: invokevirtual 1137	com/tencent/mobileqq/bubble/BubbleManager:b	(I)Lorg/json/JSONObject;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +18 -> 30
    //   15: iconst_0
    //   16: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   19: astore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: areturn
    //   24: iload 5
    //   26: iconst_1
    //   27: iadd
    //   28: istore 5
    //   30: iload 5
    //   32: aload_0
    //   33: getfield 119	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   36: invokevirtual 293	org/json/JSONArray:length	()I
    //   39: if_icmpge +131 -> 170
    //   42: aload_0
    //   43: getfield 119	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   46: iload 5
    //   48: invokevirtual 577	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   51: astore 4
    //   53: aload 4
    //   55: ldc 51
    //   57: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: iload_1
    //   61: if_icmpne -37 -> 24
    //   64: aload 4
    //   66: aload_2
    //   67: invokevirtual 255	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   70: ifne +11 -> 81
    //   73: iconst_0
    //   74: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   77: astore_2
    //   78: goto -58 -> 20
    //   81: aload 4
    //   83: aload_2
    //   84: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   87: aload_3
    //   88: aload_2
    //   89: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   92: if_icmpge -68 -> 24
    //   95: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +46 -> 144
    //   101: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   104: iconst_2
    //   105: new 368	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 1139
    //   115: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload_1
    //   119: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: ldc_w 1141
    //   125: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 1143
    //   135: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: iconst_1
    //   145: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   148: astore_2
    //   149: goto -129 -> 20
    //   152: astore_2
    //   153: invokestatic 407	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +14 -> 170
    //   159: getstatic 96	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: iconst_2
    //   163: aload_2
    //   164: invokevirtual 1144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   167: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: iconst_0
    //   171: invokestatic 111	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   174: astore_2
    //   175: goto -155 -> 20
    //   178: astore_2
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_2
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	BubbleManager
    //   0	183	1	paramInt	int
    //   0	183	2	paramString	String
    //   10	78	3	localJSONObject1	JSONObject
    //   51	31	4	localJSONObject2	JSONObject
    //   1	46	5	i1	int
    // Exception table:
    //   from	to	target	type
    //   30	78	152	java/lang/Exception
    //   81	144	152	java/lang/Exception
    //   5	11	178	finally
    //   30	78	178	finally
    //   81	144	178	finally
    //   153	170	178	finally
  }
  
  protected String a(int paramInt, String paramString)
  {
    return EmosmUtils.a("VIP_bubble", String.format("http://i.gtimg.cn/club/item/avatar/zip/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), paramString }));
  }
  
  public JSONArray a()
  {
    Object localObject3;
    if ((this.jdField_a_of_type_OrgJsonJSONArray != null) && (this.jdField_a_of_type_OrgJsonJSONArray.length() > 0))
    {
      localObject3 = this.jdField_a_of_type_OrgJsonJSONArray;
      return (JSONArray)localObject3;
    }
    Object localObject1 = new File(a(), "bubble_local.cfg");
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      try
      {
        localObject1 = a(((File)localObject1).getAbsolutePath());
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONArray((String)localObject1);
          localObject3 = localObject1;
          if (localObject1 != null) {
            break;
          }
          return new JSONArray();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = null;
    }
  }
  
  public JSONObject a(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject;
    for (;;)
    {
      try
      {
        if (!a(paramInt).booleanValue()) {
          continue;
        }
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "已经下载");
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
        switch (((DownloadTask)localObject).a())
        {
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "queryInfo bubbleId=" + paramInt + ",json=" + localJSONObject1.toString());
      }
      return localJSONObject1;
      localObject = a(paramInt, "all.zip");
      localObject = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((String)localObject);
      if ((localObject != null) && (!((DownloadTask)localObject).b())) {
        continue;
      }
      localJSONObject2.put("status", 1);
      localJSONObject2.put("progress", 0);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", "未在下载");
    }
    for (;;)
    {
      localJSONException.put("status", 1);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", "未知状态");
      for (;;)
      {
        localJSONException.put("progress", ((DownloadTask)localObject).jdField_a_of_type_Float);
        break;
        localJSONException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", "下载中");
        continue;
        localJSONException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", "下载失败");
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return;
    }
    String str = b(paramInt, paramString);
    File localFile = new File(a(paramInt, true), paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("name", paramString);
    localBundle.putInt("id", paramInt);
    paramString = new DownloadTask(str, localFile);
    paramString.e = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramString, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(String paramString)
  {
    try
    {
      jdField_a_of_type_Int = 0;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, "bubble file" + paramString, 0).a();
      Object localObject = new File("/storage/emulated/0/Tencent/bubble_temp/");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      if (!DownloaderFactory.a(new File(paramString), (File)localObject, false))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "unzip test bubble fail", 0).a();
        return;
      }
      paramString = new File(a().getAbsolutePath() + File.separatorChar + 9999);
      if (paramString.exists()) {
        FileUtils.a(paramString.getAbsolutePath());
      }
      if (DownloaderFactory.a(new File("/storage/emulated/0/Tencent/bubble_temp/" + "android.zip"), paramString, false))
      {
        a(9999, false);
        if (!this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.containsKey(Integer.valueOf(9999))) {
          break label370;
        }
        jdField_a_of_type_Int = 9999;
        paramString = "bubblebg://" + 9999 + "_" + "local";
        localObject = "bubblechartlet://" + "0_bubble_chartlet_" + "/data/data/com.tencent.mobileqq/files/bubble_info/9999/chartlet/chartlet.png";
        if (BaseApplicationImpl.a != null)
        {
          BaseApplicationImpl.a.remove(paramString);
          BaseApplicationImpl.a.remove(localObject);
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "check bubble resource success", 1).a();
      }
    }
    catch (Exception paramString)
    {
      jdField_a_of_type_Int = 0;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramString.getMessage(), 0).a();
        return;
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "unzip test bubble fail", 0).a();
        return;
        label370:
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "check bubble res fail", 1).a();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    int i1 = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
    String str = "0";
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      str = VipUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
    }
    ReportController.b(null, "CliOper", "", "", "Bubble", paramString1, 0, (int)paramLong, String.valueOf(paramInt), str, Integer.toString(i1), paramString2);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = DownloaderFactory.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext());
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!a(paramInt).booleanValue()) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "bubbleId=" + paramInt + ",isQualityNetwork=" + bool3 + ",canFullDown=" + bool1);
    }
    return bool1;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    long l1 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "createBubbleInfo, bubbleId=" + paramInt + ", autoAsyncDownload=" + paramBoolean);
    }
    Object localObject1 = a(paramInt, paramBoolean);
    if (localObject1 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "createBubbleInfo, no config, bubbleId=" + paramInt);
      this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
      return false;
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new HashMap();
    int i1;
    Object localObject4;
    int i2;
    if (((BubbleConfig)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      i1 = 0;
      while (i1 < ((BubbleConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject4 = (AnimationConfig)((BubbleConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i1);
        i2 = 0;
        while (i2 < ((AnimationConfig)localObject4).jdField_b_of_type_ArrayOfJavaLangString.length)
        {
          String str = localObject4.jdField_b_of_type_ArrayOfJavaLangString[i2];
          ((ArrayList)localObject2).add(str);
          ((HashMap)localObject3).put(str, ((AnimationConfig)localObject4).jdField_b_of_type_JavaLangString);
          i2 += 1;
        }
        i1 += 1;
      }
    }
    localObject1 = new BubbleInfo(paramInt, "", "", "", "", ((BubbleConfig)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$Chartlet, ((BubbleConfig)localObject1).jdField_b_of_type_Int, ((BubbleConfig)localObject1).jdField_c_of_type_Int, ((BubbleConfig)localObject1).jdField_d_of_type_Int, ((BubbleConfig)localObject1).jdField_a_of_type_Boolean, (String[])((ArrayList)localObject2).toArray(new String[0]), null, 0, 0, null, null, (HashMap)localObject3, ((BubbleConfig)localObject1).jdField_a_of_type_ComTencentMobileqqBubbleBubbleConfig$DiyTextConfig);
    boolean bool1;
    if (paramBoolean)
    {
      bool1 = a(paramInt, "static").booleanValue();
      boolean bool2 = false;
      if (!bool1) {
        bool2 = a((BubbleInfo)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createBubbleInfo, hasUpdate=" + bool1 + ", isCheckOk=" + bool2 + ", bubbleId=" + paramInt);
      }
      if (bool2) {
        break label582;
      }
      if (paramBoolean)
      {
        if (!a(paramInt)) {
          break label557;
        }
        localObject2 = "all.zip";
      }
    }
    for (localObject1 = new File(a(paramInt, true), "all.zip");; localObject1 = new File(a(paramInt, true), "static.zip"))
    {
      localObject4 = a(paramInt, (String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createBubbleInfo, download bubble resource, bubbleId=" + paramInt + ", url=" + (String)localObject4 + ", local path=" + localObject1);
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("name", (String)localObject2);
      ((Bundle)localObject3).putInt("id", paramInt);
      localObject1 = new DownloadTask((String)localObject4, (File)localObject1);
      ((DownloadTask)localObject1).e = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject1, this.b, (Bundle)localObject3);
      this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
      return false;
      bool1 = false;
      break;
      label557:
      localObject2 = "static.zip";
    }
    label582:
    if (!TextUtils.isEmpty(((BubbleInfo)localObject1).jdField_a_of_type_JavaLangString))
    {
      i1 = 1;
      if (TextUtils.isEmpty(((BubbleInfo)localObject1).jdField_b_of_type_JavaLangString)) {
        break label840;
      }
      i2 = 1;
      label608:
      if ((i1 == 0) || (i2 == 0)) {
        break label846;
      }
      i2 = 1;
      label621:
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inDensity = 320;
      ((BitmapFactory.Options)localObject2).inTargetDensity = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
      i1 = i2;
      if (i2 != 0)
      {
        localObject3 = a(((BubbleInfo)localObject1).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject2);
        if (localObject3 == null) {
          break label896;
        }
        localObject4 = ((Bitmap)localObject3).getNinePatchChunk();
        if ((localObject4 == null) || (!NinePatch.isNinePatchChunk((byte[])localObject4))) {
          break label852;
        }
        ((BubbleInfo)localObject1).jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject3, (byte[])localObject4, null);
        i1 = i2;
      }
      label722:
      i2 = i1;
      if (i1 != 0)
      {
        localObject2 = a(((BubbleInfo)localObject1).jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject2);
        if (localObject2 == null) {
          break label973;
        }
        localObject3 = ((Bitmap)localObject2).getNinePatchChunk();
        if ((localObject3 == null) || (!NinePatch.isNinePatchChunk((byte[])localObject3))) {
          break label929;
        }
        ((BubbleInfo)localObject1).jdField_b_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject2, (byte[])localObject3, null);
        i2 = i1;
      }
    }
    for (;;)
    {
      if (i2 != 0) {
        break label1006;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "createBubbleInfo, load nine patch failed, abort, bubbleId=" + paramInt);
      this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
      return false;
      i1 = 0;
      break;
      label840:
      i2 = 0;
      break label608;
      label846:
      i2 = 0;
      break label621;
      label852:
      i1 = 0;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "createBubbleInfo, normal bg chunk null or not nine patch, chunk=" + localObject4 + ", bubbleId=" + paramInt);
      break label722;
      label896:
      i1 = 0;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "createBubbleInfo, decode normal bg null, bubbleId=" + paramInt);
      break label722;
      label929:
      i2 = 0;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "createBubbleInfo, animation bg chunk null or not nine patch, chunk=" + localObject3 + ", bubbleId=" + paramInt);
      continue;
      label973:
      i2 = 0;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "createBubbleInfo, decode animation bg null, bubbleId=" + paramInt);
    }
    label1006:
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.put(Integer.valueOf(paramInt), localObject1);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      VasUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(FontSettingActivity.class);
      if (localObject1 != null)
      {
        ((MqqHandler)localObject1).removeMessages(16711697);
        ((MqqHandler)localObject1).sendMessageDelayed(((MqqHandler)localObject1).obtainMessage(16711697), jdField_a_of_type_Long);
      }
    }
    this.jdField_a_of_type_JavaUtilVector.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "createBubbleInfo, duration=" + (SystemClock.uptimeMillis() - l1) + ", bubbleId=" + paramInt);
    }
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.containsKey(Integer.valueOf((int)paramLong)));
  }
  
  public File b()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "bubble_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  protected String b(int paramInt, String paramString)
  {
    return EmosmUtils.a("VIP_bubble_json", String.format("http://i.gtimg.cn/club/item/avatar/json/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), paramString }));
  }
  
  public JSONObject b(int paramInt)
  {
    Object localObject1 = a(paramInt, false).getAbsolutePath() + File.separatorChar + "version.json";
    try
    {
      localObject1 = a((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      localObject1 = new JSONObject((String)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
    return (JSONObject)localObject1;
  }
  
  public void b(int paramInt, String paramString)
  {
    int i1 = 0;
    Object localObject = new JSONObject();
    JSONObject localJSONObject1 = b(paramInt);
    if (localJSONObject1 != null) {}
    for (;;)
    {
      try
      {
        if (!localJSONObject1.has("global_version")) {
          break label256;
        }
        i2 = localJSONObject1.getInt("global_version");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        continue;
        i1 = -1;
        continue;
      }
      synchronized (this.jdField_a_of_type_OrgJsonJSONArray)
      {
        if (i1 < this.jdField_a_of_type_OrgJsonJSONArray.length())
        {
          JSONObject localJSONObject2 = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i1);
          if (localJSONObject2.getInt("id") == paramInt)
          {
            localObject = localJSONObject2;
            if (paramString == null)
            {
              if (localJSONObject1 == null) {
                break label262;
              }
              localJSONObject1.put("full_download", 1);
              paramString = localJSONObject1;
              paramString.put("id", paramInt);
              paramString.put("version", i2);
              if (paramString.has("updatelist")) {
                paramString.remove("updatelist");
              }
              if (paramString.has("update")) {
                paramString.remove("update");
              }
              if (i1 == -1) {
                continue;
              }
              this.jdField_a_of_type_OrgJsonJSONArray.put(i1, paramString);
              a();
            }
          }
          else
          {
            i1 += 1;
            continue;
          }
          if ((localJSONObject1 == null) || (!localJSONObject1.has(paramString))) {
            break label262;
          }
          ((JSONObject)localObject).put(paramString, localJSONObject1.getString(paramString));
          break label262;
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
        }
      }
      label256:
      int i2 = 0;
      continue;
      label262:
      paramString = (String)localObject;
    }
  }
  
  public File c()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath() + File.separatorChar + "bubble_info" + File.separatorChar + "temp");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public JSONObject c(int paramInt)
  {
    String str = a(paramInt, "all.zip");
    int i1 = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(false, str);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("status", i1);
        if (i1 != 0) {
          continue;
        }
        str = "设置成功";
        localJSONObject.put("message", str);
        localJSONObject.put("id", paramInt);
        localJSONObject.put("result", 0);
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "stopDownload id=" + paramInt + ",status=" + i1);
      }
      return localJSONObject;
      str = "未启动下载";
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownload id=" + paramInt);
    }
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      localBundle.putInt("srcType", 3);
      localBundle.putString("callbackId", paramString);
    }
    if (a(paramInt).booleanValue()) {
      if ((this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramString != null)) {
        this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramInt, 3, localBundle);
      }
    }
    do
    {
      return;
      if (NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener == null) || (paramString == null));
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramInt, -1, localBundle);
    return;
    paramString = a(paramInt, "all.zip");
    File localFile = new File(c(), paramInt + ".zip");
    localBundle.putString("name", "all.zip");
    localBundle.putInt("id", paramInt);
    paramString = new DownloadTask(paramString, localFile);
    paramString.jdField_b_of_type_Boolean = true;
    paramString.e = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramString, this.b, localBundle);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy...");
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.clear();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.clear();
    jdField_a_of_type_Int = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */