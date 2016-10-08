package com.tencent.biz.qqstory.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class BitmapUtils
{
  public static final int a = -1;
  private static final String a = "BitmapUtils";
  public static final int b = 80;
  public static final int c = 8192;
  
  private BitmapUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    return Integer.highestOneBit(paramInt);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.max(paramInt1 / paramInt3, paramInt2 / paramInt3);
    if (paramInt1 <= 1) {
      return 1;
    }
    if (paramInt1 <= 8) {
      return a(paramInt1);
    }
    return paramInt1 / 8 * 8;
  }
  
  private static Bitmap.Config a(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    paramBitmap = localConfig;
    if (localConfig == null) {
      paramBitmap = Bitmap.Config.ARGB_8888;
    }
    return paramBitmap;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return paramConfig;
    }
    catch (OutOfMemoryError paramConfig)
    {
      SLog.c("BitmapUtils", "OutOfMemoryError", paramConfig);
      Dispatchers.get().dispatch(new BitmapUtils.OutOfMemHandleCommand());
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    int i = Math.round(paramBitmap.getWidth() * paramFloat);
    int j = Math.round(paramBitmap.getHeight() * paramFloat);
    if ((i == paramBitmap.getWidth()) && (j == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    Bitmap localBitmap = a(i, j, a(paramBitmap), false);
    if (localBitmap == null) {
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale(paramFloat, paramFloat);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramBoolean) {
      a(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if (i != paramInt1) {
        break;
      }
      localBitmap = paramBitmap;
    } while (j == paramInt2);
    float f = Math.max(paramInt1 / i, paramInt2 / j);
    Bitmap localBitmap = a(paramInt1, paramInt2, a(paramBitmap), false);
    if (localBitmap == null) {
      return null;
    }
    int i = Math.round(paramBitmap.getWidth() * f);
    int j = Math.round(paramBitmap.getHeight() * f);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.translate((paramInt1 - i) / 2.0F, (paramInt2 - j) / 2.0F);
    localCanvas.scale(f, f);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint(6));
    if (paramBoolean) {
      a(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    Paint localPaint = new Paint();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, localPaint);
    float f1 = i / paramBitmap2.getWidth();
    float f2 = j / paramBitmap2.getHeight();
    paramBitmap1 = new Matrix();
    paramBitmap1.postScale(f1, f2);
    localCanvas.drawBitmap(Bitmap.createBitmap(paramBitmap2, 0, 0, paramBitmap2.getWidth(), paramBitmap2.getHeight(), paramBitmap1, true), 0.0F, 0.0F, null);
    localCanvas.save(31);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, Rect paramRect, boolean paramBoolean)
  {
    if (paramBitmap == null) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = a(paramRect.width(), paramRect.height(), a(paramBitmap), false);
    } while (localBitmap == null);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(6);
    localCanvas.drawBitmap(paramBitmap, paramRect, new Rect(0, 0, paramRect.width(), paramRect.height()), localPaint);
    if (paramBoolean) {
      a(paramBitmap);
    }
    return localBitmap;
  }
  
  public static Bitmap a(View paramView)
  {
    return a(paramView, 0, 0, 0, 0);
  }
  
  public static Bitmap a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView);
    int i;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {
        break label28;
      }
    }
    for (;;)
    {
      try
      {
        i = paramView.getWidth();
        paramInt1 = paramView.getHeight();
        label28:
        if ((i > 0) && (paramInt1 > 0))
        {
          Bitmap localBitmap = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_4444);
          Canvas localCanvas = new Canvas(localBitmap);
          Matrix localMatrix = new Matrix();
          localMatrix.setTranslate(paramInt3, paramInt4);
          localCanvas.setMatrix(localMatrix);
          paramView.draw(localCanvas);
          paramView = localBitmap;
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        return null;
      }
      catch (OutOfMemoryError paramView)
      {
        return null;
      }
      paramView = null;
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: ldc -56
    //   2: invokestatic 206	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: aload_1
    //   7: invokevirtual 210	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   10: astore_2
    //   11: aload_2
    //   12: astore 4
    //   14: aload_1
    //   15: astore_3
    //   16: aload_1
    //   17: ldc -44
    //   19: iconst_1
    //   20: anewarray 202	java/lang/Class
    //   23: dup
    //   24: iconst_0
    //   25: ldc -42
    //   27: aastore
    //   28: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   31: aload_2
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_2
    //   45: astore 4
    //   47: aload_1
    //   48: astore_3
    //   49: getstatic 229	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 9
    //   54: if_icmpgt +62 -> 116
    //   57: aload_2
    //   58: astore 4
    //   60: aload_1
    //   61: astore_3
    //   62: aload_1
    //   63: ldc -25
    //   65: iconst_0
    //   66: anewarray 202	java/lang/Class
    //   69: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: aload_2
    //   73: iconst_0
    //   74: anewarray 4	java/lang/Object
    //   77: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 46	android/graphics/Bitmap
    //   83: astore 5
    //   85: aload 5
    //   87: astore_0
    //   88: aload_2
    //   89: ifnull +25 -> 114
    //   92: aload_1
    //   93: ldc -23
    //   95: iconst_0
    //   96: anewarray 202	java/lang/Class
    //   99: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   102: aload_2
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: aload 5
    //   113: astore_0
    //   114: aload_0
    //   115: areturn
    //   116: aload_2
    //   117: astore 4
    //   119: aload_1
    //   120: astore_3
    //   121: aload_1
    //   122: ldc -21
    //   124: iconst_0
    //   125: anewarray 202	java/lang/Class
    //   128: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   131: aload_2
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 237	[B
    //   142: checkcast 237	[B
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +71 -> 218
    //   150: aload_2
    //   151: astore 4
    //   153: aload_1
    //   154: astore_3
    //   155: aload_0
    //   156: iconst_0
    //   157: aload_0
    //   158: arraylength
    //   159: invokestatic 243	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   162: astore_0
    //   163: aload_0
    //   164: astore_3
    //   165: aload_3
    //   166: ifnull +52 -> 218
    //   169: aload_3
    //   170: astore_0
    //   171: aload_2
    //   172: ifnull -58 -> 114
    //   175: aload_1
    //   176: ldc -23
    //   178: iconst_0
    //   179: anewarray 202	java/lang/Class
    //   182: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   185: aload_2
    //   186: iconst_0
    //   187: anewarray 4	java/lang/Object
    //   190: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: aload_3
    //   195: areturn
    //   196: astore_0
    //   197: aload_3
    //   198: areturn
    //   199: astore_0
    //   200: aload_2
    //   201: astore 4
    //   203: aload_1
    //   204: astore_3
    //   205: ldc 10
    //   207: ldc -11
    //   209: aload_0
    //   210: invokestatic 247	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aconst_null
    //   214: astore_3
    //   215: goto -50 -> 165
    //   218: aload_2
    //   219: astore 4
    //   221: aload_1
    //   222: astore_3
    //   223: aload_1
    //   224: ldc -7
    //   226: iconst_0
    //   227: anewarray 202	java/lang/Class
    //   230: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   233: aload_2
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   241: checkcast 46	android/graphics/Bitmap
    //   244: astore 5
    //   246: aload 5
    //   248: astore_0
    //   249: aload_2
    //   250: ifnull -136 -> 114
    //   253: aload_1
    //   254: ldc -23
    //   256: iconst_0
    //   257: anewarray 202	java/lang/Class
    //   260: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   263: aload_2
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   271: pop
    //   272: aload 5
    //   274: areturn
    //   275: astore_0
    //   276: aload 5
    //   278: areturn
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_1
    //   284: aload_0
    //   285: ifnull +22 -> 307
    //   288: aload_1
    //   289: ldc -23
    //   291: iconst_0
    //   292: anewarray 202	java/lang/Class
    //   295: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   298: aload_0
    //   299: iconst_0
    //   300: anewarray 4	java/lang/Object
    //   303: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   306: pop
    //   307: aconst_null
    //   308: areturn
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_2
    //   312: aconst_null
    //   313: astore_1
    //   314: aload_2
    //   315: ifnull -8 -> 307
    //   318: aload_1
    //   319: ldc -23
    //   321: iconst_0
    //   322: anewarray 202	java/lang/Class
    //   325: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   328: aload_2
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   336: pop
    //   337: goto -30 -> 307
    //   340: astore_0
    //   341: goto -34 -> 307
    //   344: astore_0
    //   345: aconst_null
    //   346: astore_2
    //   347: aconst_null
    //   348: astore_1
    //   349: aload_2
    //   350: astore 4
    //   352: aload_1
    //   353: astore_3
    //   354: ldc 10
    //   356: ldc -5
    //   358: aload_0
    //   359: invokestatic 70	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   362: aload_2
    //   363: ifnull -56 -> 307
    //   366: aload_1
    //   367: ldc -23
    //   369: iconst_0
    //   370: anewarray 202	java/lang/Class
    //   373: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   376: aload_2
    //   377: iconst_0
    //   378: anewarray 4	java/lang/Object
    //   381: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   384: pop
    //   385: goto -78 -> 307
    //   388: astore_0
    //   389: goto -82 -> 307
    //   392: astore_0
    //   393: aconst_null
    //   394: astore_2
    //   395: aconst_null
    //   396: astore_1
    //   397: aload_2
    //   398: astore 4
    //   400: aload_1
    //   401: astore_3
    //   402: ldc 10
    //   404: ldc -5
    //   406: aload_0
    //   407: invokestatic 70	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   410: aload_2
    //   411: ifnull -104 -> 307
    //   414: aload_1
    //   415: ldc -23
    //   417: iconst_0
    //   418: anewarray 202	java/lang/Class
    //   421: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   424: aload_2
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   432: pop
    //   433: goto -126 -> 307
    //   436: astore_0
    //   437: goto -130 -> 307
    //   440: astore_0
    //   441: aconst_null
    //   442: astore_2
    //   443: aconst_null
    //   444: astore_1
    //   445: aload_2
    //   446: astore 4
    //   448: aload_1
    //   449: astore_3
    //   450: ldc 10
    //   452: ldc -5
    //   454: aload_0
    //   455: invokestatic 70	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   458: aload_2
    //   459: ifnull -152 -> 307
    //   462: aload_1
    //   463: ldc -23
    //   465: iconst_0
    //   466: anewarray 202	java/lang/Class
    //   469: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   472: aload_2
    //   473: iconst_0
    //   474: anewarray 4	java/lang/Object
    //   477: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   480: pop
    //   481: goto -174 -> 307
    //   484: astore_0
    //   485: goto -178 -> 307
    //   488: astore_0
    //   489: aconst_null
    //   490: astore_2
    //   491: aconst_null
    //   492: astore_1
    //   493: aload_2
    //   494: astore 4
    //   496: aload_1
    //   497: astore_3
    //   498: ldc 10
    //   500: ldc -5
    //   502: aload_0
    //   503: invokestatic 70	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   506: aload_2
    //   507: ifnull -200 -> 307
    //   510: aload_1
    //   511: ldc -23
    //   513: iconst_0
    //   514: anewarray 202	java/lang/Class
    //   517: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   520: aload_2
    //   521: iconst_0
    //   522: anewarray 4	java/lang/Object
    //   525: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   528: pop
    //   529: goto -222 -> 307
    //   532: astore_0
    //   533: goto -226 -> 307
    //   536: astore_0
    //   537: aconst_null
    //   538: astore_2
    //   539: aconst_null
    //   540: astore_1
    //   541: aload_2
    //   542: astore 4
    //   544: aload_1
    //   545: astore_3
    //   546: ldc 10
    //   548: ldc -5
    //   550: aload_0
    //   551: invokestatic 70	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   554: aload_2
    //   555: ifnull -248 -> 307
    //   558: aload_1
    //   559: ldc -23
    //   561: iconst_0
    //   562: anewarray 202	java/lang/Class
    //   565: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   568: aload_2
    //   569: iconst_0
    //   570: anewarray 4	java/lang/Object
    //   573: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   576: pop
    //   577: goto -270 -> 307
    //   580: astore_0
    //   581: goto -274 -> 307
    //   584: astore_0
    //   585: aconst_null
    //   586: astore 4
    //   588: aconst_null
    //   589: astore_1
    //   590: aload 4
    //   592: ifnull +23 -> 615
    //   595: aload_1
    //   596: ldc -23
    //   598: iconst_0
    //   599: anewarray 202	java/lang/Class
    //   602: invokevirtual 218	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   605: aload 4
    //   607: iconst_0
    //   608: anewarray 4	java/lang/Object
    //   611: invokevirtual 224	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   614: pop
    //   615: aload_0
    //   616: athrow
    //   617: astore_1
    //   618: goto -3 -> 615
    //   621: astore_0
    //   622: aconst_null
    //   623: astore 4
    //   625: goto -35 -> 590
    //   628: astore_0
    //   629: aload_3
    //   630: astore_1
    //   631: goto -41 -> 590
    //   634: astore_0
    //   635: aconst_null
    //   636: astore_2
    //   637: goto -96 -> 541
    //   640: astore_0
    //   641: goto -100 -> 541
    //   644: astore_0
    //   645: aconst_null
    //   646: astore_2
    //   647: goto -154 -> 493
    //   650: astore_0
    //   651: goto -158 -> 493
    //   654: astore_0
    //   655: aconst_null
    //   656: astore_2
    //   657: goto -212 -> 445
    //   660: astore_0
    //   661: goto -216 -> 445
    //   664: astore_0
    //   665: aconst_null
    //   666: astore_2
    //   667: goto -270 -> 397
    //   670: astore_0
    //   671: goto -274 -> 397
    //   674: astore_0
    //   675: aconst_null
    //   676: astore_2
    //   677: goto -328 -> 349
    //   680: astore_0
    //   681: goto -332 -> 349
    //   684: astore_0
    //   685: aconst_null
    //   686: astore_2
    //   687: goto -373 -> 314
    //   690: astore_0
    //   691: goto -377 -> 314
    //   694: astore_0
    //   695: goto -388 -> 307
    //   698: astore_0
    //   699: aconst_null
    //   700: astore_0
    //   701: goto -417 -> 284
    //   704: astore_0
    //   705: aload_2
    //   706: astore_0
    //   707: goto -423 -> 284
    //   710: astore_0
    //   711: aload 5
    //   713: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	714	0	paramString	String
    //   5	591	1	localClass	Class
    //   617	1	1	localException	Exception
    //   630	1	1	localObject1	Object
    //   10	696	2	localObject2	Object
    //   15	615	3	localObject3	Object
    //   12	612	4	localObject4	Object
    //   83	629	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   175	194	196	java/lang/Exception
    //   155	163	199	java/lang/OutOfMemoryError
    //   253	272	275	java/lang/Exception
    //   0	6	279	java/lang/IllegalArgumentException
    //   0	6	309	java/lang/RuntimeException
    //   318	337	340	java/lang/Exception
    //   0	6	344	java/lang/InstantiationException
    //   366	385	388	java/lang/Exception
    //   0	6	392	java/lang/reflect/InvocationTargetException
    //   414	433	436	java/lang/Exception
    //   0	6	440	java/lang/ClassNotFoundException
    //   462	481	484	java/lang/Exception
    //   0	6	488	java/lang/NoSuchMethodException
    //   510	529	532	java/lang/Exception
    //   0	6	536	java/lang/IllegalAccessException
    //   558	577	580	java/lang/Exception
    //   0	6	584	finally
    //   595	615	617	java/lang/Exception
    //   6	11	621	finally
    //   16	44	628	finally
    //   49	57	628	finally
    //   62	85	628	finally
    //   121	146	628	finally
    //   155	163	628	finally
    //   205	213	628	finally
    //   223	246	628	finally
    //   354	362	628	finally
    //   402	410	628	finally
    //   450	458	628	finally
    //   498	506	628	finally
    //   546	554	628	finally
    //   6	11	634	java/lang/IllegalAccessException
    //   16	44	640	java/lang/IllegalAccessException
    //   49	57	640	java/lang/IllegalAccessException
    //   62	85	640	java/lang/IllegalAccessException
    //   121	146	640	java/lang/IllegalAccessException
    //   155	163	640	java/lang/IllegalAccessException
    //   205	213	640	java/lang/IllegalAccessException
    //   223	246	640	java/lang/IllegalAccessException
    //   6	11	644	java/lang/NoSuchMethodException
    //   16	44	650	java/lang/NoSuchMethodException
    //   49	57	650	java/lang/NoSuchMethodException
    //   62	85	650	java/lang/NoSuchMethodException
    //   121	146	650	java/lang/NoSuchMethodException
    //   155	163	650	java/lang/NoSuchMethodException
    //   205	213	650	java/lang/NoSuchMethodException
    //   223	246	650	java/lang/NoSuchMethodException
    //   6	11	654	java/lang/ClassNotFoundException
    //   16	44	660	java/lang/ClassNotFoundException
    //   49	57	660	java/lang/ClassNotFoundException
    //   62	85	660	java/lang/ClassNotFoundException
    //   121	146	660	java/lang/ClassNotFoundException
    //   155	163	660	java/lang/ClassNotFoundException
    //   205	213	660	java/lang/ClassNotFoundException
    //   223	246	660	java/lang/ClassNotFoundException
    //   6	11	664	java/lang/reflect/InvocationTargetException
    //   16	44	670	java/lang/reflect/InvocationTargetException
    //   49	57	670	java/lang/reflect/InvocationTargetException
    //   62	85	670	java/lang/reflect/InvocationTargetException
    //   121	146	670	java/lang/reflect/InvocationTargetException
    //   155	163	670	java/lang/reflect/InvocationTargetException
    //   205	213	670	java/lang/reflect/InvocationTargetException
    //   223	246	670	java/lang/reflect/InvocationTargetException
    //   6	11	674	java/lang/InstantiationException
    //   16	44	680	java/lang/InstantiationException
    //   49	57	680	java/lang/InstantiationException
    //   62	85	680	java/lang/InstantiationException
    //   121	146	680	java/lang/InstantiationException
    //   155	163	680	java/lang/InstantiationException
    //   205	213	680	java/lang/InstantiationException
    //   223	246	680	java/lang/InstantiationException
    //   6	11	684	java/lang/RuntimeException
    //   16	44	690	java/lang/RuntimeException
    //   49	57	690	java/lang/RuntimeException
    //   62	85	690	java/lang/RuntimeException
    //   121	146	690	java/lang/RuntimeException
    //   155	163	690	java/lang/RuntimeException
    //   205	213	690	java/lang/RuntimeException
    //   223	246	690	java/lang/RuntimeException
    //   288	307	694	java/lang/Exception
    //   6	11	698	java/lang/IllegalArgumentException
    //   16	44	704	java/lang/IllegalArgumentException
    //   49	57	704	java/lang/IllegalArgumentException
    //   62	85	704	java/lang/IllegalArgumentException
    //   121	146	704	java/lang/IllegalArgumentException
    //   155	163	704	java/lang/IllegalArgumentException
    //   205	213	704	java/lang/IllegalArgumentException
    //   223	246	704	java/lang/IllegalArgumentException
    //   92	111	710	java/lang/Exception
  }
  
  public static void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    paramBitmap.recycle();
  }
  
  private static void a(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      paramView.destroyDrawingCache();
      paramView.invalidate();
      int i = 0;
      while (i < ((ViewGroup)paramView).getChildCount())
      {
        a(((ViewGroup)paramView).getChildAt(i));
        i += 1;
      }
    }
    paramView.destroyDrawingCache();
    paramView.invalidate();
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: new 276	java/io/File
    //   12: dup
    //   13: aload_3
    //   14: invokespecial 279	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 7
    //   19: aload 4
    //   21: astore_3
    //   22: aload 7
    //   24: invokevirtual 283	java/io/File:exists	()Z
    //   27: ifne +31 -> 58
    //   30: aload 4
    //   32: astore_3
    //   33: aload 7
    //   35: invokevirtual 286	java/io/File:createNewFile	()Z
    //   38: ifne +20 -> 58
    //   41: aload 4
    //   43: astore_3
    //   44: ldc 10
    //   46: ldc_w 288
    //   49: invokestatic 292	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aconst_null
    //   53: invokestatic 297	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   56: iconst_0
    //   57: ireturn
    //   58: aload 4
    //   60: astore_3
    //   61: new 299	java/io/BufferedOutputStream
    //   64: dup
    //   65: new 301	java/io/FileOutputStream
    //   68: dup
    //   69: aload 7
    //   71: invokespecial 304	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: sipush 8192
    //   77: invokespecial 307	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   80: astore 4
    //   82: aload_0
    //   83: aload_1
    //   84: iload_2
    //   85: aload 4
    //   87: invokevirtual 311	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   90: ifne +18 -> 108
    //   93: ldc 10
    //   95: ldc_w 313
    //   98: invokestatic 292	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 4
    //   103: invokestatic 297	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   106: iconst_0
    //   107: ireturn
    //   108: aload 4
    //   110: invokestatic 297	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   113: iconst_1
    //   114: ireturn
    //   115: astore_1
    //   116: aload 5
    //   118: astore_0
    //   119: aload_0
    //   120: astore_3
    //   121: ldc 10
    //   123: aload_1
    //   124: invokevirtual 317	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   127: aload_1
    //   128: invokestatic 70	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: aload_0
    //   132: invokestatic 297	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_1
    //   138: aload 6
    //   140: astore_0
    //   141: aload_0
    //   142: astore_3
    //   143: ldc 10
    //   145: aload_1
    //   146: invokevirtual 318	java/io/IOException:getMessage	()Ljava/lang/String;
    //   149: aload_1
    //   150: invokestatic 70	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_0
    //   154: invokestatic 297	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: aload_3
    //   161: invokestatic 297	com/tencent/biz/qqstory/utils/IoUtils:a	(Ljava/io/Closeable;)V
    //   164: aload_0
    //   165: athrow
    //   166: astore_0
    //   167: aload 4
    //   169: astore_3
    //   170: goto -10 -> 160
    //   173: astore_1
    //   174: aload 4
    //   176: astore_0
    //   177: goto -36 -> 141
    //   180: astore_1
    //   181: aload 4
    //   183: astore_0
    //   184: goto -65 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramBitmap	Bitmap
    //   0	187	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	187	2	paramInt	int
    //   0	187	3	paramString	String
    //   4	178	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   7	110	5	localObject1	Object
    //   1	138	6	localObject2	Object
    //   17	53	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   22	30	115	java/io/FileNotFoundException
    //   33	41	115	java/io/FileNotFoundException
    //   44	52	115	java/io/FileNotFoundException
    //   61	82	115	java/io/FileNotFoundException
    //   22	30	137	java/io/IOException
    //   33	41	137	java/io/IOException
    //   44	52	137	java/io/IOException
    //   61	82	137	java/io/IOException
    //   22	30	159	finally
    //   33	41	159	finally
    //   44	52	159	finally
    //   61	82	159	finally
    //   121	131	159	finally
    //   143	153	159	finally
    //   82	101	166	finally
    //   82	101	173	java/io/IOException
    //   82	101	180	java/io/FileNotFoundException
  }
  
  public static boolean a(Bitmap paramBitmap, String paramString)
  {
    return a(paramBitmap, Bitmap.CompressFormat.JPEG, 80, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */