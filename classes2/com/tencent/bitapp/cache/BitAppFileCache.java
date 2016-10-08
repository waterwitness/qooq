package com.tencent.bitapp.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.rookery.translate.model.ICache;
import com.rookery.translate.model.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class BitAppFileCache
  implements ICache
{
  public static final int a = 40;
  private static BitAppFileCache jdField_a_of_type_ComTencentBitappCacheBitAppFileCache;
  private static final String jdField_a_of_type_JavaLangString = "BitAppFileCache";
  private static final ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 1;
  private static final int e = 8192;
  private static final int f = 50;
  public LruCache a;
  private DiskLruCache jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
  private File jdField_a_of_type_JavaIoFile;
  public LruCache b = new LruCache(40);
  private int g;
  private int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BitAppFileCache(Context paramContext)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(40);
    int i = ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass() * 1048576 / 8;
    try
    {
      paramContext = a(paramContext);
      this.jdField_a_of_type_JavaIoFile = paramContext;
      this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache = DiskLruCache.open(paramContext, 1, 1, i);
      a();
      paramContext = BaseApplicationImpl.a().getResources().getDisplayMetrics();
      this.g = paramContext.widthPixels;
      this.h = paramContext.heightPixels;
      return;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BitAppFileCache", 4, "create BitAppFileCache error: " + paramContext);
        }
      }
    }
  }
  
  public static BitAppFileCache a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      if (jdField_a_of_type_ComTencentBitappCacheBitAppFileCache == null) {
        jdField_a_of_type_ComTencentBitappCacheBitAppFileCache = new BitAppFileCache(paramContext);
      }
      return jdField_a_of_type_ComTencentBitappCacheBitAppFileCache;
    }
    finally {}
  }
  
  private File a(Context paramContext)
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFile != null)
      {
        paramContext = this.jdField_a_of_type_JavaIoFile;
        return paramContext;
      }
      paramContext = a(paramContext);
      StringBuilder localStringBuilder = a();
      localStringBuilder.append(paramContext);
      if (!paramContext.endsWith("/")) {
        localStringBuilder.append("/");
      }
      localStringBuilder.append("tencent/react/view_thumbnail");
      paramContext = new File(localStringBuilder.toString());
      if (!paramContext.exists())
      {
        paramContext.mkdirs();
        return paramContext;
      }
    }
    finally {}
    return paramContext;
  }
  
  private static String a(Context paramContext)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) || (!Utils.a())) {
      return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    return paramContext.getCacheDir().getAbsolutePath();
  }
  
  private static StringBuilder a()
  {
    StringBuilder localStringBuilder = (StringBuilder)jdField_a_of_type_JavaLangThreadLocal.get();
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder();
      jdField_a_of_type_JavaLangThreadLocal.set(localStringBuilder);
      return localStringBuilder;
    }
    localStringBuilder.setLength(0);
    return localStringBuilder;
  }
  
  private boolean a(Bitmap paramBitmap, DiskLruCache.Editor paramEditor)
  {
    if (!this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.mkdirs();
    }
    try
    {
      paramEditor = new BufferedOutputStream(paramEditor.newOutputStream(0), 8192);
      boolean bool;
      if (paramEditor == null) {
        break label66;
      }
    }
    finally
    {
      try
      {
        bool = paramBitmap.compress(Bitmap.CompressFormat.PNG, 50, paramEditor);
        if (paramEditor != null) {
          paramEditor.close();
        }
        return bool;
      }
      finally {}
      paramBitmap = finally;
      paramEditor = null;
    }
    paramEditor.close();
    label66:
    throw paramBitmap;
  }
  
  public static void c()
  {
    if (jdField_a_of_type_ComTencentBitappCacheBitAppFileCache == null) {
      return;
    }
    Object localObject = jdField_a_of_type_ComTencentBitappCacheBitAppFileCache;
    if (localObject != null)
    {
      if (((BitAppFileCache)localObject).jdField_a_of_type_AndroidSupportV4UtilLruCache != null) {
        ((BitAppFileCache)localObject).jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
      }
      if (((BitAppFileCache)localObject).b != null) {
        ((BitAppFileCache)localObject).b.evictAll();
      }
      localObject = ((BitAppFileCache)localObject).jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache;
      if ((localObject == null) || (((DiskLruCache)localObject).isClosed())) {}
    }
    try
    {
      ((DiskLruCache)localObject).close();
      jdField_a_of_type_ComTencentBitappCacheBitAppFileCache = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BitAppFileCache", 4, "destroy BitAppFileCache error: " + localIOException);
        }
      }
    }
  }
  
  /* Error */
  public Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 85	com/tencent/bitapp/cache/BitAppFileCache:jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   4: aload_1
    //   5: invokevirtual 253	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +240 -> 250
    //   13: new 255	android/graphics/BitmapFactory$Options
    //   16: dup
    //   17: invokespecial 256	android/graphics/BitmapFactory$Options:<init>	()V
    //   20: astore 4
    //   22: new 258	java/io/BufferedInputStream
    //   25: dup
    //   26: aload_3
    //   27: iconst_0
    //   28: invokevirtual 264	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   31: invokespecial 267	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload 4
    //   39: aload_2
    //   40: aload_0
    //   41: getfield 109	com/tencent/bitapp/cache/BitAppFileCache:g	I
    //   44: aload_0
    //   45: getfield 114	com/tencent/bitapp/cache/BitAppFileCache:h	I
    //   48: invokestatic 272	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   51: d2i
    //   52: putfield 275	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aconst_null
    //   59: aload 4
    //   61: invokestatic 281	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   64: astore 4
    //   66: aload 4
    //   68: astore_1
    //   69: aload_2
    //   70: ifnull +10 -> 80
    //   73: aload_2
    //   74: invokevirtual 284	java/io/InputStream:close	()V
    //   77: aload 4
    //   79: astore_1
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 285	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   88: aload_1
    //   89: areturn
    //   90: astore 4
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_2
    //   95: astore_1
    //   96: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +16 -> 115
    //   102: aload_2
    //   103: astore_1
    //   104: ldc 13
    //   106: iconst_2
    //   107: ldc_w 287
    //   110: aload 4
    //   112: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_2
    //   116: ifnull +199 -> 315
    //   119: aload_2
    //   120: invokevirtual 284	java/io/InputStream:close	()V
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -45 -> 80
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -51 -> 80
    //   134: astore 4
    //   136: aconst_null
    //   137: astore_2
    //   138: aload_2
    //   139: astore_1
    //   140: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +31 -> 174
    //   146: aload_2
    //   147: astore_1
    //   148: ldc 13
    //   150: iconst_4
    //   151: new 122	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   158: ldc 125
    //   160: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 4
    //   165: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_2
    //   175: ifnull +140 -> 315
    //   178: aload_2
    //   179: invokevirtual 284	java/io/InputStream:close	()V
    //   182: aconst_null
    //   183: astore_1
    //   184: goto -104 -> 80
    //   187: astore_1
    //   188: aconst_null
    //   189: astore_1
    //   190: goto -110 -> 80
    //   193: astore_2
    //   194: aconst_null
    //   195: astore_1
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 284	java/io/InputStream:close	()V
    //   204: aload_2
    //   205: athrow
    //   206: astore_2
    //   207: aload_3
    //   208: astore_1
    //   209: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +28 -> 240
    //   215: ldc 13
    //   217: iconst_4
    //   218: new 122	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   225: ldc 125
    //   227: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_2
    //   231: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_1
    //   241: ifnull +7 -> 248
    //   244: aload_1
    //   245: invokevirtual 285	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   248: aconst_null
    //   249: areturn
    //   250: aload_3
    //   251: ifnull -3 -> 248
    //   254: aload_3
    //   255: invokevirtual 285	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   258: goto -10 -> 248
    //   261: astore_2
    //   262: aconst_null
    //   263: astore_1
    //   264: aload_1
    //   265: ifnull +7 -> 272
    //   268: aload_1
    //   269: invokevirtual 285	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   272: aload_2
    //   273: athrow
    //   274: astore_1
    //   275: aload 4
    //   277: astore_1
    //   278: goto -198 -> 80
    //   281: astore_1
    //   282: goto -78 -> 204
    //   285: astore_2
    //   286: aload_3
    //   287: astore_1
    //   288: goto -24 -> 264
    //   291: astore_2
    //   292: goto -28 -> 264
    //   295: astore_2
    //   296: aconst_null
    //   297: astore_1
    //   298: goto -89 -> 209
    //   301: astore_2
    //   302: goto -106 -> 196
    //   305: astore 4
    //   307: goto -169 -> 138
    //   310: astore 4
    //   312: goto -218 -> 94
    //   315: aconst_null
    //   316: astore_1
    //   317: goto -237 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	BitAppFileCache
    //   0	320	1	paramString	String
    //   34	145	2	localBufferedInputStream	java.io.BufferedInputStream
    //   193	12	2	localObject1	Object
    //   206	25	2	localIOException1	IOException
    //   261	12	2	localObject2	Object
    //   285	1	2	localObject3	Object
    //   291	1	2	localObject4	Object
    //   295	1	2	localIOException2	IOException
    //   301	1	2	localObject5	Object
    //   8	279	3	localSnapshot	com.jakewharton.disklrucache.DiskLruCache.Snapshot
    //   20	58	4	localObject6	Object
    //   90	21	4	localOutOfMemoryError1	OutOfMemoryError
    //   134	142	4	localException1	Exception
    //   305	1	4	localException2	Exception
    //   310	1	4	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   22	35	90	java/lang/OutOfMemoryError
    //   119	123	128	java/lang/Exception
    //   22	35	134	java/lang/Exception
    //   178	182	187	java/lang/Exception
    //   22	35	193	finally
    //   13	22	206	java/io/IOException
    //   73	77	206	java/io/IOException
    //   119	123	206	java/io/IOException
    //   178	182	206	java/io/IOException
    //   200	204	206	java/io/IOException
    //   204	206	206	java/io/IOException
    //   0	9	261	finally
    //   73	77	274	java/lang/Exception
    //   200	204	281	java/lang/Exception
    //   13	22	285	finally
    //   73	77	285	finally
    //   119	123	285	finally
    //   178	182	285	finally
    //   200	204	285	finally
    //   204	206	285	finally
    //   209	240	291	finally
    //   0	9	295	java/io/IOException
    //   37	55	301	finally
    //   57	66	301	finally
    //   96	102	301	finally
    //   104	115	301	finally
    //   140	146	301	finally
    //   148	174	301	finally
    //   37	55	305	java/lang/Exception
    //   57	66	305	java/lang/Exception
    //   37	55	310	java/lang/OutOfMemoryError
    //   57	66	310	java/lang/OutOfMemoryError
  }
  
  public File a(String paramString)
  {
    File localFile = (File)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    Object localObject = localFile;
    if (localFile == null)
    {
      localObject = a();
      ((StringBuilder)localObject).append(paramString).append(".").append(0);
      localObject = new File(this.jdField_a_of_type_JavaIoFile, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject);
    }
    return (File)localObject;
  }
  
  public URL a(String paramString)
  {
    URL localURL = (URL)this.b.get(paramString);
    Object localObject2 = localURL;
    Object localObject1;
    if (localURL == null)
    {
      localObject1 = a();
      ((StringBuilder)localObject1).append(paramString).append(".").append(0);
      localObject2 = new File(this.jdField_a_of_type_JavaIoFile, ((StringBuilder)localObject1).toString());
      localObject1 = null;
    }
    try
    {
      localObject2 = ((File)localObject2).toURL();
      localObject1 = localObject2;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;) {}
    }
    localObject2 = localURL;
    if (localObject1 != null)
    {
      this.b.put(paramString, localObject1);
      localObject2 = localObject1;
    }
    return (URL)localObject2;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.remove(paramString);
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BitAppFileCache", 4, "remove key = " + paramString + " error!");
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null))
    {
      Object localObject = null;
      try
      {
        DiskLruCache.Editor localEditor = this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.edit(paramString);
        if (localEditor == null) {
          return;
        }
        localObject = localEditor;
        a(paramBitmap, localEditor);
        localObject = localEditor;
        localEditor.commit();
        return;
      }
      catch (IOException localIOException2)
      {
        if (localObject != null) {
          try
          {
            ((DiskLruCache.Editor)localObject).abort();
            return;
          }
          catch (IOException localIOException1)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("BitAppFileCache", 4, "put key = " + paramString + ", bitmap = " + paramBitmap + ", IOException and abort error");
              return;
            }
          }
          catch (IllegalStateException paramString)
          {
            throw paramString;
          }
        }
      }
      catch (IllegalStateException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BitAppFileCache", 4, "exception = " + paramString + ", may throw on out of filesystem space!");
        }
      }
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_ComJakewhartonDisklrucacheDiskLruCache.delete();
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BitAppFileCache", 4, "clear BitAppFileCache error!");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\cache\BitAppFileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */