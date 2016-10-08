package com.tencent.mobileqq.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build;
import android.util.Pair;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import vxs;

public class BitmapManager
{
  public static final String a = "BitmapManager";
  private static ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private static Map jdField_a_of_type_JavaUtilMap;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int i = 1;
    if ((j > paramInt2) || (k > paramInt1))
    {
      if (k > j) {
        i = Math.round(j / paramInt2);
      }
    }
    else {
      return i;
    }
    return Math.round(k / paramInt1);
  }
  
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    a();
    localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    for (;;)
    {
      try
      {
        localObject = new BitmapFactory.Options();
        if (((!"Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("MI 2"))) && ((!"BBK".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("VIVO")))) {
          continue;
        }
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
        localBitmapDecodeResult.a = BitmapFactory.decodeResource(paramResources, paramInt, (BitmapFactory.Options)localObject);
      }
      catch (OutOfMemoryError paramResources)
      {
        Object localObject;
        localBitmapDecodeResult.e = 1;
        continue;
      }
      catch (Throwable paramResources)
      {
        localBitmapDecodeResult.e = 3;
        continue;
      }
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramResources = String.valueOf(localBitmapDecodeResult.a.hashCode());
        localObject = new vxs(paramResources, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramResources, localObject);
      }
      return localBitmapDecodeResult.a;
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
    }
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt2, paramInt3);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    if (paramResources != null)
    {
      localObject = String.valueOf(paramResources.hashCode());
      vxs localvxs = new vxs((String)localObject, paramResources, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localvxs);
    }
    return paramResources;
  }
  
  public static Bitmap a(InputStream paramInputStream)
  {
    a();
    localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if ((!"Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("MI 2"))) {
          continue;
        }
        localObject = Bitmap.Config.ARGB_8888;
        localOptions.inPreferredConfig = ((Bitmap.Config)localObject);
        localBitmapDecodeResult.a = SafeBitmapFactory.decodeStream(paramInputStream, null, localOptions);
      }
      catch (OutOfMemoryError paramInputStream)
      {
        Object localObject;
        localBitmapDecodeResult.e = 1;
        continue;
      }
      catch (Throwable paramInputStream)
      {
        localBitmapDecodeResult.e = 3;
        continue;
      }
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramInputStream = String.valueOf(localBitmapDecodeResult.a.hashCode());
        localObject = new vxs(paramInputStream, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramInputStream, localObject);
      }
      return localBitmapDecodeResult.a;
      localObject = Bitmap.Config.RGB_565;
    }
  }
  
  public static Bitmap a(InputStream paramInputStream, Rect paramRect, int paramInt1, int paramInt2)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    SafeBitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramInputStream = SafeBitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
    if (paramInputStream != null)
    {
      paramRect = String.valueOf(paramInputStream.hashCode());
      localObject = new vxs(paramRect, paramInputStream, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(paramRect, localObject);
    }
    return paramInputStream;
  }
  
  public static Bitmap a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramString = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (paramString != null)
    {
      localObject = String.valueOf(paramString.hashCode());
      vxs localvxs = new vxs((String)localObject, paramString, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localvxs);
    }
    return paramString;
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    a(paramString, paramOptions, localBitmapDecodeResult);
    return localBitmapDecodeResult.a;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a();
    localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if ((!"Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("MI 2"))) {
          continue;
        }
        localObject = Bitmap.Config.ARGB_8888;
        localOptions.inPreferredConfig = ((Bitmap.Config)localObject);
        localBitmapDecodeResult.a = SafeBitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        Object localObject;
        localBitmapDecodeResult.e = 1;
        continue;
      }
      catch (Throwable paramArrayOfByte)
      {
        localBitmapDecodeResult.e = 3;
        continue;
      }
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramArrayOfByte = String.valueOf(localBitmapDecodeResult.a.hashCode());
        localObject = new vxs(paramArrayOfByte, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramArrayOfByte, localObject);
      }
      return localBitmapDecodeResult.a;
      localObject = Bitmap.Config.RGB_565;
    }
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    SafeBitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt3, paramInt4);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramArrayOfByte = SafeBitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, (BitmapFactory.Options)localObject);
    if (paramArrayOfByte != null)
    {
      localObject = String.valueOf(paramArrayOfByte.hashCode());
      vxs localvxs = new vxs((String)localObject, paramArrayOfByte, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localvxs);
    }
    return paramArrayOfByte;
  }
  
  public static BitmapManager.BitmapDecodeResult a(String paramString, BitmapFactory.Options paramOptions)
  {
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    a(paramString, paramOptions, localBitmapDecodeResult);
    return localBitmapDecodeResult;
  }
  
  public static String a()
  {
    a();
    long l = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.format("heap used=%s\n", new Object[] { Long.valueOf(l) }));
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    l = 0L;
    if (localIterator.hasNext())
    {
      Object localObject = (Reference)((Map.Entry)localIterator.next()).getValue();
      if (localObject == null) {
        break label199;
      }
      localObject = (Bitmap)((Reference)localObject).get();
      if (localObject == null) {
        break label199;
      }
      int i = ((Bitmap)localObject).getRowBytes();
      l += ((Bitmap)localObject).getHeight() * i;
    }
    label199:
    for (;;)
    {
      break;
      localStringBuffer.append("usedSize " + l / 1024L + "\n");
      localStringBuffer.append("images:" + jdField_a_of_type_JavaUtilMap);
      return localStringBuffer.toString();
    }
  }
  
  public static ArrayList a()
  {
    a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = (Reference)localEntry.getValue();
      if (localObject != null)
      {
        localObject = (Bitmap)((Reference)localObject).get();
        if (localObject != null)
        {
          int i = ((Bitmap)localObject).getRowBytes();
          long l = ((Bitmap)localObject).getHeight() * i;
          localArrayList.add(Pair.create(localEntry.getKey(), Long.valueOf(l)));
        }
      }
    }
    return localArrayList;
  }
  
  private static void a()
  {
    for (;;)
    {
      vxs localvxs = (vxs)jdField_a_of_type_JavaLangRefReferenceQueue.poll();
      if (localvxs == null) {
        break;
      }
      jdField_a_of_type_JavaUtilMap.remove(vxs.a(localvxs));
    }
  }
  
  /* Error */
  public static void a(String paramString, BitmapFactory.Options paramOptions, BitmapManager.BitmapDecodeResult paramBitmapDecodeResult)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore 7
    //   18: invokestatic 61	com/tencent/mobileqq/util/BitmapManager:a	()V
    //   21: new 299	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 302	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 10
    //   31: aload 10
    //   33: ifnull +11 -> 44
    //   36: aload 10
    //   38: invokevirtual 305	java/io/File:exists	()Z
    //   41: ifne +32 -> 73
    //   44: aload_2
    //   45: iconst_2
    //   46: putfield 115	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   49: iconst_0
    //   50: ifeq +11 -> 61
    //   53: new 307	java/lang/NullPointerException
    //   56: dup
    //   57: invokespecial 308	java/lang/NullPointerException:<init>	()V
    //   60: athrow
    //   61: iconst_0
    //   62: ifeq +10 -> 72
    //   65: invokestatic 314	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   68: aconst_null
    //   69: invokevirtual 318	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   72: return
    //   73: new 320	java/io/BufferedInputStream
    //   76: dup
    //   77: new 322	java/io/FileInputStream
    //   80: dup
    //   81: aload 10
    //   83: invokespecial 325	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: invokespecial 328	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   89: astore_3
    //   90: aload 4
    //   92: astore 9
    //   94: aload 5
    //   96: astore 8
    //   98: aload 6
    //   100: astore 7
    //   102: aload 10
    //   104: invokevirtual 331	java/io/File:length	()J
    //   107: l2i
    //   108: istore 11
    //   110: aload 4
    //   112: astore 9
    //   114: aload 5
    //   116: astore 8
    //   118: aload 6
    //   120: astore 7
    //   122: invokestatic 314	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   125: iload 11
    //   127: invokevirtual 335	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   130: astore 6
    //   132: aload 6
    //   134: astore 4
    //   136: aload_3
    //   137: astore 5
    //   139: aload 6
    //   141: astore 9
    //   143: aload 6
    //   145: astore 8
    //   147: aload 6
    //   149: astore 7
    //   151: iload 11
    //   153: aload_3
    //   154: aload 6
    //   156: invokevirtual 341	java/io/InputStream:read	([B)I
    //   159: if_icmpeq +49 -> 208
    //   162: aload 6
    //   164: astore 4
    //   166: aload_3
    //   167: astore 5
    //   169: aload 6
    //   171: astore 9
    //   173: aload 6
    //   175: astore 8
    //   177: aload 6
    //   179: astore 7
    //   181: aload_2
    //   182: iconst_3
    //   183: putfield 115	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   186: aload_3
    //   187: ifnull +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 344	java/io/InputStream:close	()V
    //   194: aload 6
    //   196: ifnull -124 -> 72
    //   199: invokestatic 314	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   202: aload 6
    //   204: invokevirtual 318	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   207: return
    //   208: aload 6
    //   210: astore 4
    //   212: aload_3
    //   213: astore 5
    //   215: aload 6
    //   217: astore 9
    //   219: aload 6
    //   221: astore 8
    //   223: aload 6
    //   225: astore 7
    //   227: aload_2
    //   228: aload 6
    //   230: iconst_0
    //   231: aload 6
    //   233: arraylength
    //   234: aload_1
    //   235: invokestatic 170	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   238: putfield 112	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   241: aload_3
    //   242: ifnull +7 -> 249
    //   245: aload_3
    //   246: invokevirtual 344	java/io/InputStream:close	()V
    //   249: aload 6
    //   251: ifnull +11 -> 262
    //   254: invokestatic 314	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   257: aload 6
    //   259: invokevirtual 318	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   262: aload_2
    //   263: getfield 112	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   266: ifnull -194 -> 72
    //   269: aload_2
    //   270: iconst_0
    //   271: putfield 115	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   274: new 125	vxs
    //   277: dup
    //   278: aload_0
    //   279: aload_2
    //   280: getfield 112	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   283: getstatic 36	com/tencent/mobileqq/util/BitmapManager:jdField_a_of_type_JavaLangRefReferenceQueue	Ljava/lang/ref/ReferenceQueue;
    //   286: invokespecial 128	vxs:<init>	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   289: astore_1
    //   290: getstatic 31	com/tencent/mobileqq/util/BitmapManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   293: aload_0
    //   294: aload_1
    //   295: invokeinterface 134 3 0
    //   300: pop
    //   301: return
    //   302: astore_1
    //   303: aconst_null
    //   304: astore_3
    //   305: aload 7
    //   307: astore 4
    //   309: aload_3
    //   310: astore 5
    //   312: aload_2
    //   313: iconst_2
    //   314: putfield 115	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   317: aload_3
    //   318: ifnull +7 -> 325
    //   321: aload_3
    //   322: invokevirtual 344	java/io/InputStream:close	()V
    //   325: aload 7
    //   327: ifnull -65 -> 262
    //   330: invokestatic 314	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   333: aload 7
    //   335: invokevirtual 318	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   338: goto -76 -> 262
    //   341: astore_1
    //   342: aconst_null
    //   343: astore_3
    //   344: aload 8
    //   346: astore 4
    //   348: aload_3
    //   349: astore 5
    //   351: aload_2
    //   352: iconst_1
    //   353: putfield 115	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   356: aload_3
    //   357: ifnull +7 -> 364
    //   360: aload_3
    //   361: invokevirtual 344	java/io/InputStream:close	()V
    //   364: aload 8
    //   366: ifnull -104 -> 262
    //   369: invokestatic 314	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   372: aload 8
    //   374: invokevirtual 318	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   377: goto -115 -> 262
    //   380: astore_1
    //   381: aconst_null
    //   382: astore_3
    //   383: aload 9
    //   385: astore 4
    //   387: aload_3
    //   388: astore 5
    //   390: aload_2
    //   391: iconst_3
    //   392: putfield 115	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   395: aload_3
    //   396: ifnull +7 -> 403
    //   399: aload_3
    //   400: invokevirtual 344	java/io/InputStream:close	()V
    //   403: aload 9
    //   405: ifnull -143 -> 262
    //   408: invokestatic 314	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   411: aload 9
    //   413: invokevirtual 318	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   416: goto -154 -> 262
    //   419: astore_0
    //   420: aconst_null
    //   421: astore_2
    //   422: aconst_null
    //   423: astore_1
    //   424: aload_2
    //   425: ifnull +7 -> 432
    //   428: aload_2
    //   429: invokevirtual 344	java/io/InputStream:close	()V
    //   432: aload_1
    //   433: ifnull +10 -> 443
    //   436: invokestatic 314	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   439: aload_1
    //   440: invokevirtual 318	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   443: aload_0
    //   444: athrow
    //   445: astore_0
    //   446: goto -385 -> 61
    //   449: astore_0
    //   450: goto -256 -> 194
    //   453: astore_1
    //   454: goto -205 -> 249
    //   457: astore_1
    //   458: goto -133 -> 325
    //   461: astore_1
    //   462: goto -98 -> 364
    //   465: astore_1
    //   466: goto -63 -> 403
    //   469: astore_2
    //   470: goto -38 -> 432
    //   473: astore_0
    //   474: aload_3
    //   475: astore_2
    //   476: aconst_null
    //   477: astore_1
    //   478: goto -54 -> 424
    //   481: astore_0
    //   482: aload 5
    //   484: astore_2
    //   485: aload 4
    //   487: astore_1
    //   488: goto -64 -> 424
    //   491: astore_1
    //   492: goto -109 -> 383
    //   495: astore_1
    //   496: goto -152 -> 344
    //   499: astore_1
    //   500: goto -195 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	paramString	String
    //   0	503	1	paramOptions	BitmapFactory.Options
    //   0	503	2	paramBitmapDecodeResult	BitmapManager.BitmapDecodeResult
    //   89	386	3	localBufferedInputStream	java.io.BufferedInputStream
    //   7	479	4	localObject1	Object
    //   10	473	5	localObject2	Object
    //   13	245	6	arrayOfByte1	byte[]
    //   16	318	7	arrayOfByte2	byte[]
    //   1	372	8	localObject3	Object
    //   4	408	9	localObject4	Object
    //   29	74	10	localFile	java.io.File
    //   108	52	11	i	int
    // Exception table:
    //   from	to	target	type
    //   21	31	302	java/io/FileNotFoundException
    //   36	44	302	java/io/FileNotFoundException
    //   44	49	302	java/io/FileNotFoundException
    //   73	90	302	java/io/FileNotFoundException
    //   21	31	341	java/lang/OutOfMemoryError
    //   36	44	341	java/lang/OutOfMemoryError
    //   44	49	341	java/lang/OutOfMemoryError
    //   73	90	341	java/lang/OutOfMemoryError
    //   21	31	380	java/lang/Throwable
    //   36	44	380	java/lang/Throwable
    //   44	49	380	java/lang/Throwable
    //   73	90	380	java/lang/Throwable
    //   21	31	419	finally
    //   36	44	419	finally
    //   44	49	419	finally
    //   73	90	419	finally
    //   53	61	445	java/io/IOException
    //   190	194	449	java/io/IOException
    //   245	249	453	java/io/IOException
    //   321	325	457	java/io/IOException
    //   360	364	461	java/io/IOException
    //   399	403	465	java/io/IOException
    //   428	432	469	java/io/IOException
    //   102	110	473	finally
    //   122	132	473	finally
    //   151	162	481	finally
    //   181	186	481	finally
    //   227	241	481	finally
    //   312	317	481	finally
    //   351	356	481	finally
    //   390	395	481	finally
    //   102	110	491	java/lang/Throwable
    //   122	132	491	java/lang/Throwable
    //   151	162	491	java/lang/Throwable
    //   181	186	491	java/lang/Throwable
    //   227	241	491	java/lang/Throwable
    //   102	110	495	java/lang/OutOfMemoryError
    //   122	132	495	java/lang/OutOfMemoryError
    //   151	162	495	java/lang/OutOfMemoryError
    //   181	186	495	java/lang/OutOfMemoryError
    //   227	241	495	java/lang/OutOfMemoryError
    //   102	110	499	java/io/FileNotFoundException
    //   122	132	499	java/io/FileNotFoundException
    //   151	162	499	java/io/FileNotFoundException
    //   181	186	499	java/io/FileNotFoundException
    //   227	241	499	java/io/FileNotFoundException
  }
  
  public static Bitmap b(Resources paramResources, int paramInt)
  {
    a();
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
    try
    {
      localBitmapDecodeResult.a = BitmapFactory.decodeResource(paramResources, paramInt, new BitmapFactory.Options());
      if (localBitmapDecodeResult.a != null)
      {
        localBitmapDecodeResult.e = 0;
        paramResources = String.valueOf(localBitmapDecodeResult.a.hashCode());
        vxs localvxs = new vxs(paramResources, localBitmapDecodeResult.a, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramResources, localvxs);
      }
      return localBitmapDecodeResult.a;
    }
    catch (OutOfMemoryError paramResources)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 1;
      }
    }
    catch (Throwable paramResources)
    {
      for (;;)
      {
        localBitmapDecodeResult.e = 3;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\util\BitmapManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */