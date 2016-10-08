package com.tencent.mobileqq.ar;

import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class ARNativeBridge
{
  private static boolean globalInitialized;
  private static boolean loadSoSuccess;
  public static int sIdCount;
  public String basePath;
  public int id;
  public ARNativeBridge.ActionCallback sActionCallback;
  
  public ARNativeBridge()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    initSoEnvirontMent();
    int i = sIdCount;
    sIdCount = i + 1;
    this.id = i;
  }
  
  private static boolean initSoEnvirontMent()
  {
    boolean bool = false;
    if (!ArNativeSoLoader.a("ARGLRenderer"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArNativeSoLoader", 2, "native so is not exist!");
      }
      return false;
    }
    if (!globalInitialized) {
      globalInitialized = true;
    }
    try
    {
      int i = ArNativeSoLoader.a("ARGLRenderer");
      setAssetManager(BaseApplicationImpl.a().getAssets(), "arnative" + File.separator);
      if (i == 0) {
        bool = true;
      }
      loadSoSuccess = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "initSoEnvirontMent loadSoSuccess = " + loadSoSuccess);
    }
    return loadSoSuccess;
  }
  
  public static boolean loadNativeLibrary()
  {
    return initSoEnvirontMent();
  }
  
  private native void nativeConfig(String paramString1, String paramString2);
  
  private native void nativeCreateEngine();
  
  private native String nativeGetConfig(String paramString);
  
  private native void nativeOnDestroy();
  
  private native void nativeOnDrawFrame(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private native void nativeOnPause();
  
  private native void nativeOnResume();
  
  private native void nativeSetupScene(int paramInt1, int paramInt2, ArrayList paramArrayList);
  
  public static void qqColorLog(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d(paramString1, 2, paramString2);
        return;
      } while (!QLog.isColorLevel());
      QLog.w(paramString1, 2, paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(paramString1, 2, paramString2);
  }
  
  private static native void setAssetManager(AssetManager paramAssetManager, String paramString);
  
  public void config(String paramString1, String paramString2)
  {
    if (loadSoSuccess) {}
    try
    {
      nativeConfig(paramString1, paramString2);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void createEngine()
  {
    if (loadSoSuccess) {}
    try
    {
      nativeCreateEngine();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void fNativeDoActionCallback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine", 2, "fNativeDoActionCallback action=" + paramInt1 + ", params=" + paramString1 + ", callbackId=" + paramInt2 + ", result=" + paramString2);
    }
    ARNativeBridge.ActionCallback localActionCallback = this.sActionCallback;
    if (localActionCallback != null) {
      localActionCallback.a(paramInt1, paramString1, paramInt2, paramString2);
    }
  }
  
  public String getConfig(String paramString)
  {
    if (loadSoSuccess) {
      try
      {
        paramString = nativeGetConfig(paramString);
        return paramString;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        paramString.printStackTrace();
      }
    }
    return "";
  }
  
  public void handleDrawFrame(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (!loadSoSuccess) {
      return;
    }
    try
    {
      nativeOnDrawFrame(paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    catch (UnsatisfiedLinkError paramArrayOfFloat1)
    {
      paramArrayOfFloat1.printStackTrace();
    }
  }
  
  public void handleOnSurfaceCreate(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if (!loadSoSuccess) {
      return;
    }
    try
    {
      nativeSetupScene(paramInt1, paramInt2, paramArrayList);
      return;
    }
    catch (UnsatisfiedLinkError paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  /* Error */
  public android.graphics.Bitmap loadBitmapFromNative(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 95
    //   10: iconst_2
    //   11: new 71	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   18: ldc -80
    //   20: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: invokestatic 182	java/lang/System:currentTimeMillis	()J
    //   36: lstore 7
    //   38: aload_1
    //   39: getstatic 83	java/io/File:separator	Ljava/lang/String;
    //   42: invokevirtual 187	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   45: istore 9
    //   47: iload 9
    //   49: ifne +323 -> 372
    //   52: invokestatic 65	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   55: invokevirtual 191	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   58: invokevirtual 194	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   61: new 71	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   68: ldc 74
    //   70: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: getstatic 83	java/io/File:separator	Ljava/lang/String;
    //   76: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 200	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   89: astore 4
    //   91: aload 4
    //   93: astore_3
    //   94: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +31 -> 128
    //   100: aload 4
    //   102: astore_3
    //   103: ldc 95
    //   105: iconst_2
    //   106: new 71	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   113: ldc -54
    //   115: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload 4
    //   130: astore_3
    //   131: aload_3
    //   132: invokestatic 208	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   135: astore 4
    //   137: aload 4
    //   139: astore 5
    //   141: aload 4
    //   143: ifnull +51 -> 194
    //   146: aload 4
    //   148: astore 5
    //   150: iload_2
    //   151: ifne +43 -> 194
    //   154: new 210	android/graphics/Matrix
    //   157: dup
    //   158: invokespecial 211	android/graphics/Matrix:<init>	()V
    //   161: astore 5
    //   163: aload 5
    //   165: fconst_1
    //   166: ldc -44
    //   168: invokevirtual 216	android/graphics/Matrix:preScale	(FF)Z
    //   171: pop
    //   172: aload 4
    //   174: iconst_0
    //   175: iconst_0
    //   176: aload 4
    //   178: invokevirtual 222	android/graphics/Bitmap:getWidth	()I
    //   181: aload 4
    //   183: invokevirtual 225	android/graphics/Bitmap:getHeight	()I
    //   186: aload 5
    //   188: iconst_1
    //   189: invokestatic 229	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   192: astore 5
    //   194: aload 5
    //   196: astore 6
    //   198: aload_3
    //   199: ifnull +11 -> 210
    //   202: aload_3
    //   203: invokevirtual 234	java/io/InputStream:close	()V
    //   206: aload 5
    //   208: astore 6
    //   210: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +52 -> 265
    //   216: ldc 95
    //   218: iconst_2
    //   219: new 71	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   226: ldc -80
    //   228: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc -20
    //   237: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 6
    //   242: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: ldc -15
    //   247: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokestatic 182	java/lang/System:currentTimeMillis	()J
    //   253: lload 7
    //   255: lsub
    //   256: invokevirtual 244	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   259: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload 6
    //   267: areturn
    //   268: astore_3
    //   269: aconst_null
    //   270: astore 4
    //   272: aload 4
    //   274: astore_3
    //   275: new 71	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   282: aload_0
    //   283: getfield 246	com/tencent/mobileqq/ar/ARNativeBridge:basePath	Ljava/lang/String;
    //   286: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_1
    //   290: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: astore 5
    //   298: aload 4
    //   300: astore_3
    //   301: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +32 -> 336
    //   307: aload 4
    //   309: astore_3
    //   310: ldc 95
    //   312: iconst_2
    //   313: new 71	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   320: ldc -8
    //   322: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 5
    //   327: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload 4
    //   338: astore_3
    //   339: new 250	java/io/FileInputStream
    //   342: dup
    //   343: aload 5
    //   345: invokespecial 253	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   348: astore 5
    //   350: aload 5
    //   352: astore_3
    //   353: goto -222 -> 131
    //   356: astore 5
    //   358: aload 4
    //   360: astore_3
    //   361: aload 5
    //   363: invokevirtual 254	java/io/FileNotFoundException:printStackTrace	()V
    //   366: aload 4
    //   368: astore_3
    //   369: goto -16 -> 353
    //   372: new 250	java/io/FileInputStream
    //   375: dup
    //   376: aload_1
    //   377: invokespecial 253	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   380: astore 4
    //   382: aload 4
    //   384: astore_3
    //   385: aload 4
    //   387: astore 5
    //   389: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +35 -> 427
    //   395: aload 4
    //   397: astore_3
    //   398: aload 4
    //   400: astore 5
    //   402: ldc 95
    //   404: iconst_2
    //   405: new 71	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   412: ldc -8
    //   414: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_1
    //   418: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: aload 4
    //   429: astore_3
    //   430: goto -299 -> 131
    //   433: astore 6
    //   435: aconst_null
    //   436: astore 4
    //   438: aload 4
    //   440: astore_3
    //   441: aload 4
    //   443: astore 5
    //   445: aload 6
    //   447: invokevirtual 254	java/io/FileNotFoundException:printStackTrace	()V
    //   450: aload 4
    //   452: astore_3
    //   453: goto -322 -> 131
    //   456: astore 4
    //   458: aload 4
    //   460: invokevirtual 255	java/lang/OutOfMemoryError:printStackTrace	()V
    //   463: aconst_null
    //   464: astore 4
    //   466: goto -329 -> 137
    //   469: astore_3
    //   470: aload_3
    //   471: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   474: aload 5
    //   476: astore 6
    //   478: goto -268 -> 210
    //   481: astore 5
    //   483: aconst_null
    //   484: astore 6
    //   486: aload_3
    //   487: astore 4
    //   489: aload 6
    //   491: astore_3
    //   492: aload 5
    //   494: invokevirtual 257	java/lang/Exception:printStackTrace	()V
    //   497: aload_3
    //   498: astore 6
    //   500: aload 4
    //   502: ifnull -292 -> 210
    //   505: aload 4
    //   507: invokevirtual 234	java/io/InputStream:close	()V
    //   510: aload_3
    //   511: astore 6
    //   513: goto -303 -> 210
    //   516: astore 4
    //   518: aload 4
    //   520: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   523: aload_3
    //   524: astore 6
    //   526: goto -316 -> 210
    //   529: astore_1
    //   530: aconst_null
    //   531: astore_3
    //   532: aload_3
    //   533: ifnull +7 -> 540
    //   536: aload_3
    //   537: invokevirtual 234	java/io/InputStream:close	()V
    //   540: aload_1
    //   541: athrow
    //   542: astore_3
    //   543: aload_3
    //   544: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   547: goto -7 -> 540
    //   550: astore_1
    //   551: goto -19 -> 532
    //   554: astore_1
    //   555: goto -23 -> 532
    //   558: astore_1
    //   559: aload 4
    //   561: astore_3
    //   562: goto -30 -> 532
    //   565: astore 5
    //   567: aconst_null
    //   568: astore_3
    //   569: goto -77 -> 492
    //   572: astore 6
    //   574: aconst_null
    //   575: astore_3
    //   576: aload 5
    //   578: astore 4
    //   580: aload 6
    //   582: astore 5
    //   584: goto -92 -> 492
    //   587: astore 5
    //   589: aconst_null
    //   590: astore 6
    //   592: aload_3
    //   593: astore 4
    //   595: aload 6
    //   597: astore_3
    //   598: goto -106 -> 492
    //   601: astore 5
    //   603: aload_3
    //   604: astore 6
    //   606: aload 4
    //   608: astore_3
    //   609: aload 6
    //   611: astore 4
    //   613: goto -121 -> 492
    //   616: astore 6
    //   618: goto -180 -> 438
    //   621: astore_3
    //   622: goto -350 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	625	0	this	ARNativeBridge
    //   0	625	1	paramString	String
    //   0	625	2	paramInt	int
    //   1	202	3	localObject1	Object
    //   268	1	3	localException1	Exception
    //   274	179	3	localObject2	Object
    //   469	18	3	localIOException1	java.io.IOException
    //   491	46	3	localObject3	Object
    //   542	2	3	localIOException2	java.io.IOException
    //   561	48	3	localObject4	Object
    //   621	1	3	localException2	Exception
    //   89	362	4	localObject5	Object
    //   456	3	4	localOutOfMemoryError	OutOfMemoryError
    //   464	42	4	localIOException3	java.io.IOException
    //   516	44	4	localIOException4	java.io.IOException
    //   578	34	4	localObject6	Object
    //   139	212	5	localObject7	Object
    //   356	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   387	88	5	localObject8	Object
    //   481	12	5	localException3	Exception
    //   565	12	5	localException4	Exception
    //   582	1	5	localObject9	Object
    //   587	1	5	localException5	Exception
    //   601	1	5	localException6	Exception
    //   196	70	6	localObject10	Object
    //   433	13	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   476	49	6	localObject11	Object
    //   572	9	6	localException7	Exception
    //   590	20	6	localObject12	Object
    //   616	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   36	218	7	l	long
    //   45	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   52	91	268	java/lang/Exception
    //   339	350	356	java/io/FileNotFoundException
    //   372	382	433	java/io/FileNotFoundException
    //   131	137	456	java/lang/OutOfMemoryError
    //   202	206	469	java/io/IOException
    //   38	47	481	java/lang/Exception
    //   372	382	481	java/lang/Exception
    //   505	510	516	java/io/IOException
    //   38	47	529	finally
    //   52	91	529	finally
    //   372	382	529	finally
    //   536	540	542	java/io/IOException
    //   94	100	550	finally
    //   103	128	550	finally
    //   275	298	550	finally
    //   301	307	550	finally
    //   310	336	550	finally
    //   339	350	550	finally
    //   361	366	550	finally
    //   389	395	550	finally
    //   402	427	550	finally
    //   445	450	550	finally
    //   131	137	554	finally
    //   154	194	554	finally
    //   458	463	554	finally
    //   492	497	558	finally
    //   275	298	565	java/lang/Exception
    //   301	307	565	java/lang/Exception
    //   310	336	565	java/lang/Exception
    //   339	350	565	java/lang/Exception
    //   361	366	565	java/lang/Exception
    //   389	395	572	java/lang/Exception
    //   402	427	572	java/lang/Exception
    //   445	450	572	java/lang/Exception
    //   131	137	587	java/lang/Exception
    //   458	463	587	java/lang/Exception
    //   154	194	601	java/lang/Exception
    //   389	395	616	java/io/FileNotFoundException
    //   402	427	616	java/io/FileNotFoundException
    //   94	100	621	java/lang/Exception
    //   103	128	621	java/lang/Exception
  }
  
  public void onDestroy()
  {
    if (loadSoSuccess) {}
    try
    {
      nativeOnDestroy();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void onPause()
  {
    if (loadSoSuccess) {}
    try
    {
      nativeOnPause();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void onResume()
  {
    if (loadSoSuccess) {}
    try
    {
      nativeOnResume();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public void setupActionCallback(ARNativeBridge.ActionCallback paramActionCallback)
  {
    this.sActionCallback = paramActionCallback;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ARNativeBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */