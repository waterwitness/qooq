package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatBackground
{
  public static final int a = -1;
  public static final String a = "ChatBackground";
  public static final int b = -10395552;
  public static final String c = "_is_c2c_set";
  public ColorStateList a;
  public Drawable a;
  public boolean a;
  public String b;
  
  public ChatBackground()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int n = paramBitmap.getHeight();
      int[] arrayOfInt = new int[n];
      paramBitmap.getPixels(arrayOfInt, 0, 1, j / 2, 0, 1, n);
      j = 0;
      int k = 0;
      int m = 0;
      while (i < n)
      {
        int i1 = arrayOfInt[i];
        m += Color.red(i1);
        k += Color.green(i1);
        j += Color.blue(i1);
        i += 1;
      }
      if ((j + (m + k)) / n / 3 > 220) {
        return -10395552;
      }
      return -1;
    }
    return -10395552;
  }
  
  /* Error */
  static void a(Context paramContext, ChatBackground paramChatBackground, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 65	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   5: astore 4
    //   7: aload_0
    //   8: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: ldc 72
    //   13: invokevirtual 78	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   16: astore 5
    //   18: aload 5
    //   20: ifnonnull +12 -> 32
    //   23: ldc 10
    //   25: iconst_1
    //   26: ldc 80
    //   28: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: return
    //   32: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +38 -> 73
    //   38: ldc 10
    //   40: iconst_2
    //   41: new 92	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   48: ldc 95
    //   50: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 5
    //   55: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: ldc 104
    //   60: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload 5
    //   75: instanceof 113
    //   78: ifeq +192 -> 270
    //   81: aload 5
    //   83: checkcast 113	android/graphics/drawable/BitmapDrawable
    //   86: invokevirtual 117	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   89: astore_3
    //   90: aload 5
    //   92: checkcast 113	android/graphics/drawable/BitmapDrawable
    //   95: invokevirtual 121	android/graphics/drawable/BitmapDrawable:getTileModeX	()Landroid/graphics/Shader$TileMode;
    //   98: astore_2
    //   99: aload 5
    //   101: checkcast 113	android/graphics/drawable/BitmapDrawable
    //   104: invokevirtual 124	android/graphics/drawable/BitmapDrawable:getGravity	()I
    //   107: istore 6
    //   109: aload_3
    //   110: ifnull +17 -> 127
    //   113: aload_2
    //   114: getstatic 65	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   117: if_acmpeq +10 -> 127
    //   120: iload 6
    //   122: bipush 48
    //   124: if_icmpeq +185 -> 309
    //   127: aload_1
    //   128: aload 5
    //   130: putfield 126	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   133: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +62 -> 198
    //   139: new 92	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   146: ldc -128
    //   148: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_3
    //   152: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: ldc -126
    //   157: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: astore 4
    //   162: aload_2
    //   163: getstatic 65	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   166: if_acmpne +401 -> 567
    //   169: iconst_1
    //   170: istore 7
    //   172: ldc 10
    //   174: iconst_2
    //   175: aload 4
    //   177: iload 7
    //   179: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: ldc -121
    //   184: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: iload 6
    //   189: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_3
    //   199: ifnonnull +58 -> 257
    //   202: new 140	java/util/HashMap
    //   205: dup
    //   206: invokespecial 141	java/util/HashMap:<init>	()V
    //   209: astore_2
    //   210: aload_2
    //   211: ldc -113
    //   213: ldc -111
    //   215: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   218: pop
    //   219: aload_2
    //   220: ldc -105
    //   222: invokestatic 156	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   225: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   228: pop
    //   229: aload_0
    //   230: invokestatic 161	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   233: getstatic 166	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   236: invokevirtual 169	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   239: checkcast 171	com/tencent/mobileqq/app/QQAppInterface
    //   242: invokevirtual 174	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   245: ldc -80
    //   247: iconst_0
    //   248: lconst_1
    //   249: lconst_0
    //   250: aload_2
    //   251: ldc -78
    //   253: iconst_0
    //   254: invokevirtual 181	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   257: aload_1
    //   258: getfield 126	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   261: ifnull +283 -> 544
    //   264: aload_1
    //   265: iconst_1
    //   266: putfield 183	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_Boolean	Z
    //   269: return
    //   270: aload 5
    //   272: instanceof 185
    //   275: ifeq +282 -> 557
    //   278: aload 5
    //   280: checkcast 185	com/tencent/theme/SkinnableBitmapDrawable
    //   283: invokevirtual 186	com/tencent/theme/SkinnableBitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   286: astore_3
    //   287: aload 5
    //   289: checkcast 185	com/tencent/theme/SkinnableBitmapDrawable
    //   292: invokevirtual 187	com/tencent/theme/SkinnableBitmapDrawable:getTileModeX	()Landroid/graphics/Shader$TileMode;
    //   295: astore_2
    //   296: aload 5
    //   298: checkcast 185	com/tencent/theme/SkinnableBitmapDrawable
    //   301: invokevirtual 188	com/tencent/theme/SkinnableBitmapDrawable:getGravity	()I
    //   304: istore 6
    //   306: goto -197 -> 109
    //   309: new 190	com/tencent/mobileqq/drawable/ChatBackgroundDrawable
    //   312: dup
    //   313: aload_0
    //   314: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   317: aload_3
    //   318: invokespecial 193	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   321: astore_2
    //   322: aload_2
    //   323: iload 6
    //   325: invokevirtual 197	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:setGravity	(I)V
    //   328: aload_1
    //   329: aload_2
    //   330: putfield 126	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   333: goto -135 -> 198
    //   336: astore_2
    //   337: ldc 10
    //   339: iconst_1
    //   340: new 92	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   347: ldc -57
    //   349: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_2
    //   353: invokevirtual 202	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   356: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload_1
    //   366: aload_0
    //   367: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   370: ldc -53
    //   372: invokevirtual 78	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   375: putfield 126	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   378: new 140	java/util/HashMap
    //   381: dup
    //   382: invokespecial 141	java/util/HashMap:<init>	()V
    //   385: astore_2
    //   386: aload_2
    //   387: ldc -113
    //   389: ldc -51
    //   391: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   394: pop
    //   395: aload_2
    //   396: ldc -105
    //   398: invokestatic 156	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   401: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   404: pop
    //   405: aload_0
    //   406: invokestatic 161	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   409: getstatic 166	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   412: invokevirtual 169	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   415: checkcast 171	com/tencent/mobileqq/app/QQAppInterface
    //   418: invokevirtual 174	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   421: ldc -80
    //   423: iconst_0
    //   424: lconst_1
    //   425: lconst_0
    //   426: aload_2
    //   427: ldc -78
    //   429: iconst_0
    //   430: invokevirtual 181	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   433: goto -176 -> 257
    //   436: astore_0
    //   437: goto -180 -> 257
    //   440: astore_2
    //   441: ldc 10
    //   443: iconst_1
    //   444: new 92	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   451: ldc -49
    //   453: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload_2
    //   457: invokevirtual 208	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   460: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_1
    //   470: aload_0
    //   471: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   474: ldc -53
    //   476: invokevirtual 78	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   479: putfield 126	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   482: new 140	java/util/HashMap
    //   485: dup
    //   486: invokespecial 141	java/util/HashMap:<init>	()V
    //   489: astore_2
    //   490: aload_2
    //   491: ldc -113
    //   493: ldc -46
    //   495: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   498: pop
    //   499: aload_2
    //   500: ldc -105
    //   502: invokestatic 156	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   505: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   508: pop
    //   509: aload_0
    //   510: invokestatic 161	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   513: getstatic 166	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   516: invokevirtual 169	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   519: checkcast 171	com/tencent/mobileqq/app/QQAppInterface
    //   522: invokevirtual 174	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   525: ldc -80
    //   527: iconst_0
    //   528: lconst_1
    //   529: lconst_0
    //   530: aload_2
    //   531: ldc -78
    //   533: iconst_0
    //   534: invokevirtual 181	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   537: goto -280 -> 257
    //   540: astore_0
    //   541: goto -284 -> 257
    //   544: ldc 10
    //   546: iconst_1
    //   547: ldc -44
    //   549: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: return
    //   553: astore_0
    //   554: goto -297 -> 257
    //   557: aload 4
    //   559: astore_2
    //   560: bipush 119
    //   562: istore 6
    //   564: goto -455 -> 109
    //   567: iconst_0
    //   568: istore 7
    //   570: goto -398 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	paramContext	Context
    //   0	573	1	paramChatBackground	ChatBackground
    //   0	573	2	paramString	String
    //   1	317	3	localBitmap	Bitmap
    //   5	553	4	localObject	Object
    //   16	281	5	localDrawable	Drawable
    //   107	456	6	i	int
    //   170	399	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	336	java/lang/OutOfMemoryError
    //   23	31	336	java/lang/OutOfMemoryError
    //   32	73	336	java/lang/OutOfMemoryError
    //   73	109	336	java/lang/OutOfMemoryError
    //   113	120	336	java/lang/OutOfMemoryError
    //   127	169	336	java/lang/OutOfMemoryError
    //   172	198	336	java/lang/OutOfMemoryError
    //   202	257	336	java/lang/OutOfMemoryError
    //   270	306	336	java/lang/OutOfMemoryError
    //   309	333	336	java/lang/OutOfMemoryError
    //   378	433	436	java/lang/Exception
    //   2	18	440	java/lang/Exception
    //   23	31	440	java/lang/Exception
    //   32	73	440	java/lang/Exception
    //   73	109	440	java/lang/Exception
    //   113	120	440	java/lang/Exception
    //   127	169	440	java/lang/Exception
    //   172	198	440	java/lang/Exception
    //   270	306	440	java/lang/Exception
    //   309	333	440	java/lang/Exception
    //   482	537	540	java/lang/Exception
    //   202	257	553	java/lang/Exception
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("chat_background_path_" + paramString, 0).edit().clear().commit();
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0).edit();
    if (paramString2 == null) {
      paramContext.putString("chat_uniform_bg", paramString3);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString2, paramString3);
    }
  }
  
  /* Error */
  public static final boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ChatBackground paramChatBackground)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnonnull +13 -> 15
    //   5: ldc 10
    //   7: iconst_1
    //   8: ldc -13
    //   10: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: invokestatic 248	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   19: ldc -41
    //   21: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: iconst_0
    //   32: invokevirtual 219	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   35: astore 7
    //   37: aload 7
    //   39: aload_2
    //   40: aconst_null
    //   41: invokeinterface 252 3 0
    //   46: astore_2
    //   47: aload_2
    //   48: astore_1
    //   49: aload_2
    //   50: ifnonnull +1240 -> 1290
    //   53: aload 7
    //   55: ldc -20
    //   57: aconst_null
    //   58: invokeinterface 252 3 0
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: aload_2
    //   67: ifnonnull +1223 -> 1290
    //   70: ldc -2
    //   72: astore 5
    //   74: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +58 -> 135
    //   80: ldc 10
    //   82: iconst_2
    //   83: new 92	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 256
    //   93: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 4
    //   98: getfield 183	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_Boolean	Z
    //   101: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   104: ldc_w 258
    //   107: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 5
    //   112: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 260
    //   118: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 4
    //   123: getfield 262	com/tencent/mobileqq/activity/aio/ChatBackground:b	Ljava/lang/String;
    //   126: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload 4
    //   137: getfield 126	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   140: ifnull +35 -> 175
    //   143: aload 4
    //   145: getfield 183	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_Boolean	Z
    //   148: ifeq +27 -> 175
    //   151: aload 4
    //   153: getfield 262	com/tencent/mobileqq/activity/aio/ChatBackground:b	Ljava/lang/String;
    //   156: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +16 -> 175
    //   162: aload 4
    //   164: getfield 262	com/tencent/mobileqq/activity/aio/ChatBackground:b	Ljava/lang/String;
    //   167: aload 5
    //   169: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifne +1072 -> 1244
    //   175: aload 5
    //   177: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +24 -> 204
    //   183: ldc -2
    //   185: aload 5
    //   187: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifne +14 -> 204
    //   193: ldc_w 276
    //   196: aload 5
    //   198: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifeq +52 -> 253
    //   204: aload 4
    //   206: ldc -2
    //   208: putfield 262	com/tencent/mobileqq/activity/aio/ChatBackground:b	Ljava/lang/String;
    //   211: aload 4
    //   213: aload_0
    //   214: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   217: ldc_w 277
    //   220: invokevirtual 281	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   223: putfield 283	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidContentResColorStateList	Landroid/content/res/ColorStateList;
    //   226: aload_0
    //   227: aload 4
    //   229: aload 5
    //   231: invokestatic 285	com/tencent/mobileqq/activity/aio/ChatBackground:a	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/ChatBackground;Ljava/lang/String;)V
    //   234: aload 4
    //   236: getfield 126	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   239: ifnonnull +12 -> 251
    //   242: ldc 10
    //   244: iconst_1
    //   245: ldc_w 287
    //   248: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: iconst_1
    //   252: ireturn
    //   253: getstatic 290	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   256: aload 5
    //   258: invokevirtual 296	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   261: ifnull +351 -> 612
    //   264: getstatic 290	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   267: aload 5
    //   269: invokevirtual 296	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: checkcast 31	android/graphics/Bitmap
    //   275: astore_1
    //   276: aload_1
    //   277: astore_2
    //   278: aload_1
    //   279: ifnonnull +1004 -> 1283
    //   282: new 298	java/io/File
    //   285: dup
    //   286: aload 5
    //   288: invokespecial 301	java/io/File:<init>	(Ljava/lang/String;)V
    //   291: astore_2
    //   292: aload_2
    //   293: ifnull +17 -> 310
    //   296: aload_2
    //   297: invokevirtual 304	java/io/File:exists	()Z
    //   300: ifeq +10 -> 310
    //   303: aload_2
    //   304: invokevirtual 307	java/io/File:isFile	()Z
    //   307: ifne +321 -> 628
    //   310: ldc 10
    //   312: iconst_1
    //   313: new 92	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 309
    //   323: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 5
    //   328: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: new 140	java/util/HashMap
    //   340: dup
    //   341: invokespecial 141	java/util/HashMap:<init>	()V
    //   344: astore_2
    //   345: aload_2
    //   346: ldc -113
    //   348: ldc_w 311
    //   351: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   354: pop
    //   355: aload_2
    //   356: ldc -105
    //   358: invokestatic 156	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   361: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   364: pop
    //   365: aload_0
    //   366: invokestatic 161	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   369: astore 6
    //   371: getstatic 166	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   374: invokevirtual 169	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   377: checkcast 171	com/tencent/mobileqq/app/QQAppInterface
    //   380: invokevirtual 174	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   383: astore 8
    //   385: aload_1
    //   386: ifnull +231 -> 617
    //   389: iconst_1
    //   390: istore_3
    //   391: aload 6
    //   393: aload 8
    //   395: ldc -80
    //   397: iload_3
    //   398: lconst_1
    //   399: lconst_0
    //   400: aload_2
    //   401: ldc -78
    //   403: iconst_0
    //   404: invokevirtual 181	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   407: iconst_1
    //   408: istore_3
    //   409: aload_1
    //   410: ifnull +754 -> 1164
    //   413: getstatic 290	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   416: aload 5
    //   418: aload_1
    //   419: invokevirtual 312	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   422: pop
    //   423: aload 4
    //   425: aload 5
    //   427: putfield 262	com/tencent/mobileqq/activity/aio/ChatBackground:b	Ljava/lang/String;
    //   430: aload 4
    //   432: new 190	com/tencent/mobileqq/drawable/ChatBackgroundDrawable
    //   435: dup
    //   436: aload_0
    //   437: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   440: aload_1
    //   441: invokespecial 193	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   444: putfield 126	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   447: new 92	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   454: ldc_w 314
    //   457: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 5
    //   462: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: astore_2
    //   469: aload 7
    //   471: aload_2
    //   472: invokeinterface 318 2 0
    //   477: ifeq +647 -> 1124
    //   480: aload 4
    //   482: aload 7
    //   484: aload_2
    //   485: ldc 12
    //   487: invokeinterface 322 3 0
    //   492: invokestatic 327	android/content/res/ColorStateList:valueOf	(I)Landroid/content/res/ColorStateList;
    //   495: putfield 283	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidContentResColorStateList	Landroid/content/res/ColorStateList;
    //   498: aload 4
    //   500: iconst_1
    //   501: putfield 183	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_Boolean	Z
    //   504: goto -270 -> 234
    //   507: astore_1
    //   508: ldc 10
    //   510: iconst_1
    //   511: new 92	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   518: ldc_w 329
    //   521: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: aload 5
    //   526: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload 4
    //   537: aload_0
    //   538: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   541: ldc -53
    //   543: invokevirtual 78	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   546: putfield 126	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   549: new 140	java/util/HashMap
    //   552: dup
    //   553: invokespecial 141	java/util/HashMap:<init>	()V
    //   556: astore_1
    //   557: aload_1
    //   558: ldc -113
    //   560: ldc_w 331
    //   563: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   566: pop
    //   567: aload_1
    //   568: ldc -105
    //   570: invokestatic 156	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   573: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   576: pop
    //   577: aload_0
    //   578: invokestatic 161	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   581: getstatic 166	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   584: invokevirtual 169	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   587: checkcast 171	com/tencent/mobileqq/app/QQAppInterface
    //   590: invokevirtual 174	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   593: ldc -80
    //   595: iconst_0
    //   596: lconst_1
    //   597: lconst_0
    //   598: aload_1
    //   599: ldc -78
    //   601: iconst_0
    //   602: invokevirtual 181	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   605: goto -371 -> 234
    //   608: astore_0
    //   609: goto -375 -> 234
    //   612: aconst_null
    //   613: astore_1
    //   614: goto -338 -> 276
    //   617: iconst_0
    //   618: istore_3
    //   619: goto -228 -> 391
    //   622: astore_2
    //   623: iconst_1
    //   624: istore_3
    //   625: goto -216 -> 409
    //   628: new 333	android/graphics/BitmapFactory$Options
    //   631: dup
    //   632: invokespecial 334	android/graphics/BitmapFactory$Options:<init>	()V
    //   635: astore 8
    //   637: ldc_w 336
    //   640: getstatic 341	android/os/Build:BRAND	Ljava/lang/String;
    //   643: invokevirtual 344	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   646: ifeq +448 -> 1094
    //   649: aload 8
    //   651: getstatic 350	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   654: putfield 353	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   657: aload 8
    //   659: iconst_1
    //   660: putfield 356	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   663: aload 5
    //   665: aload 8
    //   667: invokestatic 361	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   670: pop
    //   671: aload_0
    //   672: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   675: invokevirtual 365	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   678: getfield 370	android/util/DisplayMetrics:heightPixels	I
    //   681: aload_0
    //   682: invokestatic 375	com/tencent/widget/immersive/ImmersiveUtils:a	(Landroid/content/Context;)I
    //   685: isub
    //   686: aload_0
    //   687: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   690: ldc_w 376
    //   693: invokevirtual 379	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   696: isub
    //   697: aload_0
    //   698: ldc_w 380
    //   701: invokestatic 385	com/tencent/mobileqq/utils/DisplayUtils:a	(Landroid/content/Context;F)F
    //   704: f2i
    //   705: isub
    //   706: istore 12
    //   708: aload_0
    //   709: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   712: invokevirtual 365	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   715: getfield 388	android/util/DisplayMetrics:widthPixels	I
    //   718: istore 13
    //   720: iload 12
    //   722: istore 11
    //   724: iload 12
    //   726: sipush 400
    //   729: if_icmpge +567 -> 1296
    //   732: sipush 400
    //   735: istore 11
    //   737: goto +559 -> 1296
    //   740: aload 8
    //   742: getfield 391	android/graphics/BitmapFactory$Options:outHeight	I
    //   745: iload 11
    //   747: idiv
    //   748: i2d
    //   749: invokestatic 397	java/lang/Math:ceil	(D)D
    //   752: d2i
    //   753: istore 11
    //   755: aload 8
    //   757: getfield 400	android/graphics/BitmapFactory$Options:outWidth	I
    //   760: iload 12
    //   762: idiv
    //   763: i2d
    //   764: invokestatic 397	java/lang/Math:ceil	(D)D
    //   767: d2i
    //   768: istore 12
    //   770: iload 11
    //   772: iconst_1
    //   773: if_icmpgt +9 -> 782
    //   776: iload 12
    //   778: iconst_1
    //   779: if_icmple +336 -> 1115
    //   782: iload 11
    //   784: iload 12
    //   786: if_icmple +319 -> 1105
    //   789: aload 8
    //   791: iload 11
    //   793: putfield 403	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   796: aload 8
    //   798: iconst_0
    //   799: putfield 356	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   802: aload 5
    //   804: aload 8
    //   806: invokestatic 406	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   809: astore 6
    //   811: aload 6
    //   813: getfield 411	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   816: astore_1
    //   817: new 140	java/util/HashMap
    //   820: dup
    //   821: invokespecial 141	java/util/HashMap:<init>	()V
    //   824: astore_2
    //   825: aload_2
    //   826: ldc -113
    //   828: new 92	java/lang/StringBuilder
    //   831: dup
    //   832: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   835: ldc_w 413
    //   838: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload 6
    //   843: getfield 415	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   846: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   849: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   855: pop
    //   856: aload_2
    //   857: ldc -105
    //   859: invokestatic 156	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   862: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   865: pop
    //   866: aload_0
    //   867: invokestatic 161	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   870: astore 9
    //   872: getstatic 166	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   875: invokevirtual 169	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   878: checkcast 171	com/tencent/mobileqq/app/QQAppInterface
    //   881: invokevirtual 174	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   884: astore 10
    //   886: aload_1
    //   887: ifnull +429 -> 1316
    //   890: iconst_1
    //   891: istore_3
    //   892: aload 9
    //   894: aload 10
    //   896: ldc -80
    //   898: iload_3
    //   899: lconst_1
    //   900: lconst_0
    //   901: aload_2
    //   902: ldc -78
    //   904: iconst_0
    //   905: invokevirtual 181	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   908: aload_1
    //   909: astore_2
    //   910: aload 6
    //   912: getfield 415	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   915: iconst_1
    //   916: if_icmpne +367 -> 1283
    //   919: ldc 10
    //   921: iconst_1
    //   922: new 92	java/lang/StringBuilder
    //   925: dup
    //   926: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   929: ldc_w 417
    //   932: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: aload 5
    //   937: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   943: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: aload 8
    //   948: getfield 403	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   951: iconst_2
    //   952: imul
    //   953: istore 11
    //   955: aload 6
    //   957: astore_2
    //   958: iload 11
    //   960: bipush 32
    //   962: if_icmpgt +35 -> 997
    //   965: aload 8
    //   967: iload 11
    //   969: putfield 403	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   972: aload 5
    //   974: aload 8
    //   976: invokestatic 406	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   979: astore_2
    //   980: aload_2
    //   981: getfield 411	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   984: astore_1
    //   985: aload_2
    //   986: getfield 415	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   989: istore 12
    //   991: iload 12
    //   993: iconst_1
    //   994: if_icmpeq +327 -> 1321
    //   997: new 140	java/util/HashMap
    //   1000: dup
    //   1001: invokespecial 141	java/util/HashMap:<init>	()V
    //   1004: astore 6
    //   1006: aload 6
    //   1008: ldc -113
    //   1010: new 92	java/lang/StringBuilder
    //   1013: dup
    //   1014: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1017: ldc_w 419
    //   1020: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: aload_2
    //   1024: getfield 415	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   1027: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1030: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1033: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1036: pop
    //   1037: aload 6
    //   1039: ldc -105
    //   1041: invokestatic 156	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   1044: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1047: pop
    //   1048: aload_0
    //   1049: invokestatic 161	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1052: astore_2
    //   1053: getstatic 166	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1056: invokevirtual 169	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   1059: checkcast 171	com/tencent/mobileqq/app/QQAppInterface
    //   1062: invokevirtual 174	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1065: astore 8
    //   1067: aload_1
    //   1068: ifnull +262 -> 1330
    //   1071: iconst_1
    //   1072: istore_3
    //   1073: aload_2
    //   1074: aload 8
    //   1076: ldc -80
    //   1078: iload_3
    //   1079: lconst_1
    //   1080: lconst_0
    //   1081: aload 6
    //   1083: ldc -78
    //   1085: iconst_0
    //   1086: invokevirtual 181	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1089: iconst_0
    //   1090: istore_3
    //   1091: goto -682 -> 409
    //   1094: aload 8
    //   1096: getstatic 422	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   1099: putfield 353	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   1102: goto -445 -> 657
    //   1105: aload 8
    //   1107: iload 12
    //   1109: putfield 403	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1112: goto -316 -> 796
    //   1115: aload 8
    //   1117: iconst_1
    //   1118: putfield 403	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1121: goto -325 -> 796
    //   1124: aload_1
    //   1125: invokestatic 424	com/tencent/mobileqq/activity/aio/ChatBackground:a	(Landroid/graphics/Bitmap;)I
    //   1128: istore 11
    //   1130: aload 4
    //   1132: iload 11
    //   1134: invokestatic 327	android/content/res/ColorStateList:valueOf	(I)Landroid/content/res/ColorStateList;
    //   1137: putfield 283	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidContentResColorStateList	Landroid/content/res/ColorStateList;
    //   1140: aload 7
    //   1142: invokeinterface 225 1 0
    //   1147: aload_2
    //   1148: iload 11
    //   1150: invokeinterface 428 3 0
    //   1155: invokeinterface 233 1 0
    //   1160: pop
    //   1161: goto -663 -> 498
    //   1164: ldc 10
    //   1166: iconst_2
    //   1167: new 92	java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1174: ldc_w 430
    //   1177: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: aload 5
    //   1182: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: ldc_w 432
    //   1188: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: iload_3
    //   1192: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1195: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1198: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1201: aload 4
    //   1203: ldc -2
    //   1205: putfield 262	com/tencent/mobileqq/activity/aio/ChatBackground:b	Ljava/lang/String;
    //   1208: aload 4
    //   1210: aload_0
    //   1211: invokevirtual 71	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1214: ldc_w 277
    //   1217: invokevirtual 281	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   1220: putfield 283	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidContentResColorStateList	Landroid/content/res/ColorStateList;
    //   1223: aload_0
    //   1224: aload 4
    //   1226: aload 5
    //   1228: invokestatic 285	com/tencent/mobileqq/activity/aio/ChatBackground:a	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/ChatBackground;Ljava/lang/String;)V
    //   1231: iload_3
    //   1232: ifne -998 -> 234
    //   1235: aload 4
    //   1237: iconst_0
    //   1238: putfield 183	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_Boolean	Z
    //   1241: goto -1007 -> 234
    //   1244: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1247: ifeq +30 -> 1277
    //   1250: ldc 10
    //   1252: iconst_2
    //   1253: new 92	java/lang/StringBuilder
    //   1256: dup
    //   1257: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   1260: ldc_w 434
    //   1263: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: aload 5
    //   1268: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1277: iconst_0
    //   1278: ireturn
    //   1279: astore_2
    //   1280: goto -372 -> 908
    //   1283: iconst_0
    //   1284: istore_3
    //   1285: aload_2
    //   1286: astore_1
    //   1287: goto -878 -> 409
    //   1290: aload_1
    //   1291: astore 5
    //   1293: goto -1219 -> 74
    //   1296: iload 13
    //   1298: istore 12
    //   1300: iload 13
    //   1302: sipush 300
    //   1305: if_icmpge -565 -> 740
    //   1308: sipush 300
    //   1311: istore 12
    //   1313: goto -573 -> 740
    //   1316: iconst_0
    //   1317: istore_3
    //   1318: goto -426 -> 892
    //   1321: iload 11
    //   1323: iconst_2
    //   1324: imul
    //   1325: istore 11
    //   1327: goto -369 -> 958
    //   1330: iconst_0
    //   1331: istore_3
    //   1332: goto -259 -> 1073
    //   1335: astore_2
    //   1336: iconst_0
    //   1337: istore_3
    //   1338: goto -929 -> 409
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1341	0	paramContext	Context
    //   0	1341	1	paramString1	String
    //   0	1341	2	paramString2	String
    //   0	1341	3	paramBoolean	boolean
    //   0	1341	4	paramChatBackground	ChatBackground
    //   72	1220	5	str1	String
    //   369	713	6	localObject1	Object
    //   35	1106	7	localSharedPreferences	SharedPreferences
    //   383	733	8	localObject2	Object
    //   870	23	9	localStatisticCollector	com.tencent.mobileqq.statistics.StatisticCollector
    //   884	11	10	str2	String
    //   722	604	11	i	int
    //   706	606	12	j	int
    //   718	588	13	k	int
    // Exception table:
    //   from	to	target	type
    //   175	204	507	java/lang/OutOfMemoryError
    //   204	234	507	java/lang/OutOfMemoryError
    //   253	276	507	java/lang/OutOfMemoryError
    //   282	292	507	java/lang/OutOfMemoryError
    //   296	310	507	java/lang/OutOfMemoryError
    //   310	337	507	java/lang/OutOfMemoryError
    //   337	385	507	java/lang/OutOfMemoryError
    //   391	407	507	java/lang/OutOfMemoryError
    //   413	498	507	java/lang/OutOfMemoryError
    //   498	504	507	java/lang/OutOfMemoryError
    //   628	657	507	java/lang/OutOfMemoryError
    //   657	720	507	java/lang/OutOfMemoryError
    //   740	770	507	java/lang/OutOfMemoryError
    //   789	796	507	java/lang/OutOfMemoryError
    //   796	817	507	java/lang/OutOfMemoryError
    //   817	886	507	java/lang/OutOfMemoryError
    //   892	908	507	java/lang/OutOfMemoryError
    //   910	955	507	java/lang/OutOfMemoryError
    //   965	991	507	java/lang/OutOfMemoryError
    //   997	1067	507	java/lang/OutOfMemoryError
    //   1073	1089	507	java/lang/OutOfMemoryError
    //   1094	1102	507	java/lang/OutOfMemoryError
    //   1105	1112	507	java/lang/OutOfMemoryError
    //   1115	1121	507	java/lang/OutOfMemoryError
    //   1124	1161	507	java/lang/OutOfMemoryError
    //   1164	1231	507	java/lang/OutOfMemoryError
    //   1235	1241	507	java/lang/OutOfMemoryError
    //   549	605	608	java/lang/Exception
    //   337	385	622	java/lang/Exception
    //   391	407	622	java/lang/Exception
    //   817	886	1279	java/lang/Exception
    //   892	908	1279	java/lang/Exception
    //   997	1067	1335	java/lang/Exception
    //   1073	1089	1335	java/lang/Exception
  }
  
  public static final void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0);
    paramString1 = paramContext.edit();
    if (paramString2 == null)
    {
      paramString1.putString("chat_uniform_bg", paramString3);
      paramString2 = paramContext.getAll();
      if (paramString2 != null)
      {
        paramString2 = paramString2.keySet().iterator();
        while (paramString2.hasNext())
        {
          String str1 = (String)paramString2.next();
          if (Pattern.compile("[0-9]*").matcher(str1).matches())
          {
            String str2 = paramContext.getString(str1, "null");
            boolean bool = paramContext.getBoolean(str1 + "_is_c2c_set", false);
            if ((str2 == null) || (str2.trim().length() == 0) || (str2.equals("null")) || (str2.equals("none")) || (!bool)) {
              paramString1.putString(str1, paramString3);
            }
          }
        }
      }
    }
    else
    {
      paramString1.putString(paramString2, paramString3);
      if (!paramString3.equals("null")) {
        break label255;
      }
      paramString1.putBoolean(paramString2 + "_is_c2c_set", false);
    }
    for (;;)
    {
      paramString1.commit();
      return;
      label255:
      paramString1.putBoolean(paramString2 + "_is_c2c_set", true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\ChatBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */