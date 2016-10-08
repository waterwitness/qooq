package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.BytesBufferPool.BytesBuffer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.cache.common.BlobCache;
import common.qzone.component.cache.common.BlobCache.LookupRequest;
import common.qzone.component.util.SecurityUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import oqn;

public class AlbumThumbManager
{
  private static final int jdField_a_of_type_Int = 16;
  private static final BytesBufferPool jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool = new BytesBufferPool(4, 204800);
  private static AlbumThumbManager jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
  private static ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private static oqn jdField_a_of_type_Oqn;
  private static final int b = 70;
  private static final int c = 4;
  private static final int d = 102400;
  private static final int e = 204800;
  private static final int f = 1048576;
  private static final int g = 2500;
  private static final int h = 52428800;
  private static final int i = 1;
  Context jdField_a_of_type_AndroidContentContext;
  BlobCache jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private AlbumThumbManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    a(paramContext);
  }
  
  public static AlbumThumbManager a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager != null) {
      return jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager != null)
      {
        paramContext = jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager;
        return paramContext;
      }
    }
    finally {}
    paramContext = new AlbumThumbManager(paramContext);
    jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumThumbManager = paramContext;
    return paramContext;
  }
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 73	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   21: getstatic 80	com/tencent/mobileqq/app/AppConstants:bm	Ljava/lang/String;
    //   24: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 86
    //   29: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 88
    //   34: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: new 94	java/io/File
    //   44: dup
    //   45: new 73	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   52: getstatic 80	com/tencent/mobileqq/app/AppConstants:bm	Ljava/lang/String;
    //   55: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 86
    //   60: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 101	java/io/File:exists	()Z
    //   74: ifne +8 -> 82
    //   77: aload_2
    //   78: invokevirtual 104	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aload_0
    //   83: new 106	common/qzone/component/cache/common/BlobCache
    //   86: dup
    //   87: aload_1
    //   88: sipush 2500
    //   91: ldc 25
    //   93: iconst_0
    //   94: iconst_1
    //   95: invokespecial 109	common/qzone/component/cache/common/BlobCache:<init>	(Ljava/lang/String;IIZI)V
    //   98: putfield 71	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   101: goto -90 -> 11
    //   104: astore_1
    //   105: ldc 111
    //   107: iconst_2
    //   108: ldc 113
    //   110: aload_1
    //   111: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: goto -103 -> 11
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	AlbumThumbManager
    //   0	122	1	paramContext	Context
    //   69	9	2	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   41	82	104	java/lang/Exception
    //   82	101	104	java/lang/Exception
    //   2	7	117	finally
    //   14	41	117	finally
    //   41	82	117	finally
    //   82	101	117	finally
    //   105	114	117	finally
  }
  
  private boolean a(byte[] paramArrayOfByte, long paramLong, BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    if (paramArrayOfByte == null) {}
    BlobCache.LookupRequest localLookupRequest;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache != null) {
          break;
        }
        a(this.jdField_a_of_type_AndroidContentContext);
      } while (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache == null);
      try
      {
        localLookupRequest = new BlobCache.LookupRequest();
        localLookupRequest.jdField_a_of_type_Long = paramLong;
        localLookupRequest.jdField_a_of_type_ArrayOfByte = paramBytesBuffer.data;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (!this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(localLookupRequest)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!a(paramArrayOfByte, localLookupRequest.jdField_a_of_type_ArrayOfByte));
    paramBytesBuffer.data = localLookupRequest.jdField_a_of_type_ArrayOfByte;
    paramBytesBuffer.offset = paramArrayOfByte.length;
    paramBytesBuffer.length = (localLookupRequest.jdField_a_of_type_Int - paramBytesBuffer.offset);
    return true;
  }
  
  private boolean a(byte[] paramArrayOfByte, long paramLong, oqn paramoqn)
  {
    if (paramArrayOfByte == null) {}
    BlobCache.LookupRequest localLookupRequest;
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache != null) {
          break;
        }
        a(this.jdField_a_of_type_AndroidContentContext);
      } while (this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache == null);
      try
      {
        localLookupRequest = new BlobCache.LookupRequest();
        localLookupRequest.jdField_a_of_type_Long = paramLong;
        localLookupRequest.jdField_a_of_type_ArrayOfByte = paramoqn.jdField_a_of_type_ArrayOfByte;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (!this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(localLookupRequest)) {
            return false;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        QLog.e("AlbumThumbManager", 2, "getCacheData ioexception", paramArrayOfByte);
        return false;
      }
    } while (!a(paramArrayOfByte, localLookupRequest.jdField_a_of_type_ArrayOfByte, localLookupRequest.jdField_a_of_type_Int - 16, 16));
    paramoqn.jdField_a_of_type_ArrayOfByte = localLookupRequest.jdField_a_of_type_ArrayOfByte;
    paramoqn.jdField_a_of_type_Int = 0;
    paramoqn.b = (localLookupRequest.jdField_a_of_type_Int - 16);
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = paramArrayOfByte1.length;
    if (paramArrayOfByte2.length < k) {
      return false;
    }
    int j = 0;
    for (;;)
    {
      if (j >= k) {
        break label34;
      }
      if (paramArrayOfByte1[j] != paramArrayOfByte2[j]) {
        break;
      }
      j += 1;
    }
    label34:
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte1.length < paramInt2) {}
    while (paramArrayOfByte2.length < paramInt1 + paramInt2) {
      return false;
    }
    int j = 0;
    for (;;)
    {
      if (j >= paramInt2) {
        break label47;
      }
      if (paramArrayOfByte1[j] != paramArrayOfByte2[(paramInt1 + j)]) {
        break;
      }
      j += 1;
    }
    label47:
    return true;
  }
  
  private static byte[] a(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(65536);
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public Bitmap a(URL arg1, BitmapDecoder paramBitmapDecoder)
  {
    try
    {
      if (jdField_a_of_type_Oqn == null)
      {
        jdField_a_of_type_Oqn = new oqn(102400, null);
        jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.wrap(jdField_a_of_type_Oqn.jdField_a_of_type_ArrayOfByte);
      }
      jdField_a_of_type_JavaNioByteBuffer.clear();
      byte[] arrayOfByte = SecurityUtil.a(???.toString());
      if (arrayOfByte.length < 16) {
        arrayOfByte = a(arrayOfByte, 16);
      }
      for (;;)
      {
        long l = SecurityUtil.a(arrayOfByte);
        for (;;)
        {
          try
          {
            if (a(arrayOfByte, l, jdField_a_of_type_Oqn)) {
              continue;
            }
            paramBitmapDecoder = paramBitmapDecoder.a(???);
            if (paramBitmapDecoder == null) {
              continue;
            }
            ??? = paramBitmapDecoder;
            if (paramBitmapDecoder.getConfig() == Bitmap.Config.RGB_565)
            {
              ??? = paramBitmapDecoder;
              if (jdField_a_of_type_JavaNioByteBuffer.remaining() >= paramBitmapDecoder.getHeight() * paramBitmapDecoder.getRowBytes() + 16 + 8)
              {
                paramBitmapDecoder.copyPixelsToBuffer(jdField_a_of_type_JavaNioByteBuffer);
                jdField_a_of_type_JavaNioByteBuffer.putInt(paramBitmapDecoder.getWidth());
                jdField_a_of_type_JavaNioByteBuffer.putInt(paramBitmapDecoder.getHeight());
                jdField_a_of_type_JavaNioByteBuffer.put(arrayOfByte, 0, 16);
              }
            }
          }
          catch (Throwable ???)
          {
            QLog.e("AlbumThumbManager", 2, "decode thumb", ???);
            ??? = null;
            continue;
            jdField_a_of_type_JavaNioByteBuffer.clear();
            jdField_a_of_type_JavaNioByteBuffer.put(jdField_a_of_type_Oqn.jdField_a_of_type_ArrayOfByte, 0, jdField_a_of_type_Oqn.b);
            int j = jdField_a_of_type_JavaNioByteBuffer.getInt(jdField_a_of_type_Oqn.b - 8);
            int k = jdField_a_of_type_JavaNioByteBuffer.getInt(jdField_a_of_type_Oqn.b - 4);
            if ((j <= 500) || (k <= 500)) {
              continue;
            }
            QLog.e("AlbumThumbManager", 2, "thumb bitmap is dirty:" + ???.toString());
            ??? = null;
            continue;
            ??? = Bitmap.createBitmap(j, k, Bitmap.Config.RGB_565);
            jdField_a_of_type_JavaNioByteBuffer.limit(jdField_a_of_type_Oqn.b - 8);
            jdField_a_of_type_JavaNioByteBuffer.position(0);
            ???.copyPixelsFromBuffer(jdField_a_of_type_JavaNioByteBuffer);
            continue;
          }
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            try
            {
              j = paramBitmapDecoder.getRowBytes();
              k = paramBitmapDecoder.getHeight();
              this.jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache.a(l, jdField_a_of_type_JavaNioByteBuffer.array(), j * k + 24);
              ??? = paramBitmapDecoder;
              return (Bitmap)???;
            }
            catch (IOException localIOException)
            {
              if (QLog.isColorLevel()) {
                QLog.e("AlbumThumbManager", 2, "decode thumb ioexception", localIOException);
              }
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool.clear();
      jdField_a_of_type_Oqn = null;
      jdField_a_of_type_JavaNioByteBuffer = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt = 0;
    while (paramInt < paramArrayOfByte.length)
    {
      arrayOfByte[paramInt] = paramArrayOfByte[paramInt];
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  /* Error */
  public Bitmap b(URL paramURL, BitmapDecoder paramBitmapDecoder)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 207	java/net/URL:toString	()Ljava/lang/String;
    //   4: invokestatic 212	common/qzone/component/util/SecurityUtil:a	(Ljava/lang/String;)[B
    //   7: astore 4
    //   9: getstatic 46	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   12: invokevirtual 304	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   15: astore_3
    //   16: aload 4
    //   18: invokestatic 218	common/qzone/component/util/SecurityUtil:a	([B)J
    //   21: lstore 6
    //   23: aload_0
    //   24: aload 4
    //   26: lload 6
    //   28: aload_3
    //   29: invokespecial 306	com/tencent/mobileqq/activity/photo/AlbumThumbManager:a	([BJLcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)Z
    //   32: ifne +122 -> 154
    //   35: aload_2
    //   36: aload_1
    //   37: invokeinterface 225 2 0
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +156 -> 200
    //   47: aload_1
    //   48: bipush 70
    //   50: invokestatic 308	com/tencent/mobileqq/activity/photo/AlbumThumbManager:a	(Landroid/graphics/Bitmap;I)[B
    //   53: astore 5
    //   55: aload 4
    //   57: arraylength
    //   58: aload 5
    //   60: arraylength
    //   61: iadd
    //   62: invokestatic 311	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   65: astore_2
    //   66: aload_2
    //   67: aload 4
    //   69: invokevirtual 313	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   72: pop
    //   73: aload_2
    //   74: aload 5
    //   76: invokevirtual 313	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   79: pop
    //   80: aload_0
    //   81: getfield 52	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   84: astore 4
    //   86: aload 4
    //   88: monitorenter
    //   89: aload_0
    //   90: getfield 71	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_CommonQzoneComponentCacheCommonBlobCache	Lcommon/qzone/component/cache/common/BlobCache;
    //   93: lload 6
    //   95: aload_2
    //   96: invokevirtual 263	java/nio/ByteBuffer:array	()[B
    //   99: invokevirtual 316	common/qzone/component/cache/common/BlobCache:a	(J[B)V
    //   102: aload 4
    //   104: monitorexit
    //   105: getstatic 46	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   108: aload_3
    //   109: invokevirtual 320	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   112: aload_1
    //   113: areturn
    //   114: astore_2
    //   115: ldc 111
    //   117: iconst_2
    //   118: ldc_w 271
    //   121: aload_2
    //   122: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: goto -23 -> 102
    //   128: astore_1
    //   129: aload 4
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: ldc 111
    //   137: iconst_2
    //   138: ldc_w 273
    //   141: aload_1
    //   142: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: getstatic 46	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   148: aload_3
    //   149: invokevirtual 320	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   152: aconst_null
    //   153: areturn
    //   154: new 322	android/graphics/BitmapFactory$Options
    //   157: dup
    //   158: invokespecial 323	android/graphics/BitmapFactory$Options:<init>	()V
    //   161: astore_1
    //   162: aload_1
    //   163: getstatic 235	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   166: putfield 326	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   169: aload_1
    //   170: iconst_1
    //   171: putfield 329	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   174: aload_3
    //   175: getfield 133	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   178: aload_3
    //   179: getfield 146	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:offset	I
    //   182: aload_3
    //   183: getfield 151	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:length	I
    //   186: aload_1
    //   187: invokestatic 335	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   190: astore_1
    //   191: getstatic 46	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   194: aload_3
    //   195: invokevirtual 320	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   198: aload_1
    //   199: areturn
    //   200: getstatic 46	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   203: aload_3
    //   204: invokevirtual 320	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   207: goto -55 -> 152
    //   210: astore_1
    //   211: ldc 111
    //   213: iconst_2
    //   214: ldc_w 273
    //   217: aload_1
    //   218: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: getstatic 46	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   224: aload_3
    //   225: invokevirtual 320	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   228: goto -76 -> 152
    //   231: astore_1
    //   232: getstatic 46	com/tencent/mobileqq/activity/photo/AlbumThumbManager:jdField_a_of_type_ComTencentComponentNetworkUtilsBytesBufferPool	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   235: aload_3
    //   236: invokevirtual 320	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   239: aload_1
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	AlbumThumbManager
    //   0	241	1	paramURL	URL
    //   0	241	2	paramBitmapDecoder	BitmapDecoder
    //   15	221	3	localBytesBuffer	BytesBufferPool.BytesBuffer
    //   53	22	5	arrayOfByte	byte[]
    //   21	73	6	l	long
    // Exception table:
    //   from	to	target	type
    //   89	102	114	java/io/IOException
    //   89	102	128	finally
    //   102	105	128	finally
    //   115	125	128	finally
    //   129	132	128	finally
    //   23	43	134	java/lang/OutOfMemoryError
    //   47	89	134	java/lang/OutOfMemoryError
    //   132	134	134	java/lang/OutOfMemoryError
    //   154	191	134	java/lang/OutOfMemoryError
    //   23	43	210	java/lang/Throwable
    //   47	89	210	java/lang/Throwable
    //   132	134	210	java/lang/Throwable
    //   154	191	210	java/lang/Throwable
    //   23	43	231	finally
    //   47	89	231	finally
    //   132	134	231	finally
    //   135	145	231	finally
    //   154	191	231	finally
    //   211	221	231	finally
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\AlbumThumbManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */