package com.tencent.mobileqq.shortvideo.hwcodec;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class SVHwCodec
{
  public static int a = 0;
  public static String a;
  protected static Method a;
  protected static boolean a = false;
  public static int b = 0;
  public static String b;
  protected static Method b;
  public static final int c = 0;
  public static String c;
  protected static Method c;
  public static final int d = 1;
  protected static Method d;
  public static final int e = 2;
  public static final int f = 4;
  public static final int g = 8;
  protected MediaCodec a;
  protected MediaFormat a;
  protected ByteBuffer[] a;
  protected MediaFormat b;
  protected ByteBuffer[] b;
  protected int h = jdField_b_of_type_Int;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "video/avc";
    jdField_b_of_type_JavaLangString = "request-sync";
    jdField_c_of_type_JavaLangString = "AndroidCodec";
    jdField_a_of_type_Boolean = true;
  }
  
  public SVHwCodec()
  {
    a();
    if ((Build.VERSION.SDK_INT >= 19) && (d == null)) {}
    try
    {
      d = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      d = null;
    }
  }
  
  public static int a(Context paramContext)
  {
    int k = 0;
    int j = 0;
    if (Build.VERSION.SDK_INT < 16) {}
    int i;
    do
    {
      do
      {
        do
        {
          return j;
          if (Build.VERSION.SDK_INT < 21) {
            break;
          }
          a();
        } while (!jdField_a_of_type_Boolean);
        paramContext = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
        paramContext = paramContext + "MODEL=" + Build.MODEL.toLowerCase() + ";";
        paramContext = paramContext + "SDK=" + Build.VERSION.SDK_INT + ";";
        paramContext = paramContext + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
        paramContext = paramContext + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature:phoneInfo=" + paramContext);
        }
        i = k;
        if (DeviceCheck.b())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in white list.");
          }
          i = k;
          if (DeviceCheck.c()) {
            i = 1;
          }
        }
        j = i;
      } while (!DeviceCheck.a());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in white list.");
      }
      j = i;
    } while (!DeviceCheck.d());
    return i + 2;
  }
  
  public static MediaCodecInfo.CodecCapabilities a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    return paramMediaCodecInfo.getCapabilitiesForType(paramString);
  }
  
  public static MediaCodecInfo a(String paramString)
  {
    int j = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < j)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.getName().equalsIgnoreCase(paramString)) {
        return localMediaCodecInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localMediaCodecInfo.getName().contains(".sw.")) || (localMediaCodecInfo.getName().contains(".SW.")) || (localMediaCodecInfo.getName().contains("google")) || (localMediaCodecInfo.getName().contains("Google")) || (localMediaCodecInfo.getName().contains("GOOGLE")))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE"))))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected static void a()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (jdField_a_of_type_JavaLangReflectMethod == null) {
        jdField_a_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (jdField_b_of_type_JavaLangReflectMethod == null) {
        jdField_b_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (jdField_c_of_type_JavaLangReflectMethod == null) {
        jdField_c_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      }
      return;
    }
    catch (Exception localException)
    {
      jdField_a_of_type_JavaLangReflectMethod = null;
      jdField_b_of_type_JavaLangReflectMethod = null;
      jdField_c_of_type_JavaLangReflectMethod = null;
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public static List b(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!paramBoolean) || ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE"))))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int j = 0;
          while (j < arrayOfString.length)
          {
            if (arrayOfString[j].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            j += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public MediaCodec a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaCodec;
  }
  
  /* Error */
  public SVHwCodec.BufferData a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 227	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 236	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 239	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:<init>	(Lcom/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec;)V
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 227	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   22: lload_1
    //   23: invokevirtual 243	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   26: istore 5
    //   28: iload 5
    //   30: iflt +130 -> 160
    //   33: getstatic 64	android/os/Build$VERSION:SDK_INT	I
    //   36: bipush 20
    //   38: if_icmpgt +31 -> 69
    //   41: aload_0
    //   42: monitorenter
    //   43: aload_3
    //   44: iload 5
    //   46: putfield 244	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 246	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:jdField_a_of_type_ArrayOfJavaNioByteBuffer	[Ljava/nio/ByteBuffer;
    //   54: iload 5
    //   56: aaload
    //   57: putfield 249	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_3
    //   63: areturn
    //   64: astore_3
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_3
    //   68: athrow
    //   69: aload_0
    //   70: monitorenter
    //   71: aload_3
    //   72: iload 5
    //   74: putfield 244	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Int	I
    //   77: aload_3
    //   78: getstatic 208	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   81: aload_0
    //   82: getfield 227	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   85: iconst_1
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: iload 5
    //   93: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: aastore
    //   97: invokevirtual 259	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 261	java/nio/ByteBuffer
    //   103: putfield 249	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_3
    //   109: areturn
    //   110: astore 4
    //   112: aload 4
    //   114: invokevirtual 264	java/lang/IllegalAccessException:printStackTrace	()V
    //   117: aload_3
    //   118: iconst_0
    //   119: putfield 265	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Boolean	Z
    //   122: goto -16 -> 106
    //   125: astore_3
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_3
    //   129: athrow
    //   130: astore 4
    //   132: aload 4
    //   134: invokevirtual 266	java/lang/IllegalArgumentException:printStackTrace	()V
    //   137: aload_3
    //   138: iconst_0
    //   139: putfield 265	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Boolean	Z
    //   142: goto -36 -> 106
    //   145: astore 4
    //   147: aload 4
    //   149: invokevirtual 267	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   152: aload_3
    //   153: iconst_0
    //   154: putfield 265	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Boolean	Z
    //   157: goto -51 -> 106
    //   160: aload_3
    //   161: iload 5
    //   163: putfield 244	com/tencent/mobileqq/shortvideo/hwcodec/SVHwCodec$BufferData:jdField_a_of_type_Int	I
    //   166: aload_3
    //   167: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	SVHwCodec
    //   0	168	1	paramLong	long
    //   17	46	3	localBufferData1	SVHwCodec.BufferData
    //   64	54	3	localBufferData2	SVHwCodec.BufferData
    //   125	42	3	localBufferData3	SVHwCodec.BufferData
    //   110	3	4	localIllegalAccessException	IllegalAccessException
    //   130	3	4	localIllegalArgumentException	IllegalArgumentException
    //   145	3	4	localInvocationTargetException	InvocationTargetException
    //   26	136	5	i	int
    // Exception table:
    //   from	to	target	type
    //   43	62	64	finally
    //   65	67	64	finally
    //   77	106	110	java/lang/IllegalAccessException
    //   71	77	125	finally
    //   77	106	125	finally
    //   106	108	125	finally
    //   112	122	125	finally
    //   126	128	125	finally
    //   132	142	125	finally
    //   147	157	125	finally
    //   77	106	130	java/lang/IllegalArgumentException
    //   77	106	145	java/lang/reflect/InvocationTargetException
  }
  
  public void a(MediaFormat paramMediaFormat, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, paramInt);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    while ((this.jdField_a_of_type_AndroidMediaMediaCodec == null) || (d == null)) {
      return;
    }
    try
    {
      d.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { paramBundle });
      return;
    }
    catch (IllegalArgumentException paramBundle)
    {
      paramBundle.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramBundle)
    {
      paramBundle.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a(SVHwCodec.BufferData paramBufferData)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(paramBufferData.jdField_a_of_type_Int, false);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "releaseOutputBuffer index = " + paramBufferData.jdField_a_of_type_Int);
        }
      }
      return;
    }
    finally
    {
      paramBufferData = finally;
      throw paramBufferData;
    }
  }
  
  public void a(SVHwCodec.BufferData paramBufferData, int paramInt1, long paramLong, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(paramBufferData.jdField_a_of_type_Int, 0, paramInt1, paramLong, paramInt2);
      }
      return;
    }
    finally
    {
      paramBufferData = finally;
      throw paramBufferData;
    }
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
            this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          }
          finally {}
        }
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public boolean a(MediaFormat paramMediaFormat, int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    for (;;)
    {
      try
      {
        if (paramInt == jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime"));
          this.h = paramInt;
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
          {
            if (paramInt != jdField_a_of_type_Int) {
              break label114;
            }
            paramInt = 1;
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, paramInt);
          }
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
            return true;
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType(this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime"));
          continue;
        }
        return false;
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        this.jdField_a_of_type_AndroidMediaMediaCodec = null;
        return false;
      }
      label114:
      paramInt = 0;
    }
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    paramMediaFormat = a(paramString);
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder())) {
      this.h = jdField_a_of_type_Int;
    }
    for (int i = 1;; i = 0) {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createByCodecName(paramString);
        return false;
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, i);
          }
          if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
            continue;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          this.jdField_a_of_type_AndroidMediaMediaCodec = null;
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createByCodecName(paramString);
        paramMediaFormat = a(paramString);
        if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
        {
          this.h = jdField_a_of_type_Int;
          i = 1;
          return false;
        }
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, paramSurface, null, i);
          }
          if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
            break label96;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          this.jdField_a_of_type_AndroidMediaMediaCodec = null;
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
      label96:
      int i = 0;
    }
  }
  
  public SVHwCodec.BufferData b(long paramLong)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject5;
      int i;
      try
      {
        localObject5 = this.jdField_a_of_type_AndroidMediaMediaCodec;
        if (localObject5 == null) {
          return (SVHwCodec.BufferData)localObject1;
        }
        localObject5 = new SVHwCodec.BufferData(this);
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(((SVHwCodec.BufferData)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, paramLong);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "dequeueOutputBuffer ok,index = " + i + ",BufferInfo[flags = " + ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags + ",offset=" + ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + ",size= " + ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size + ",TimeUs=" + ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs + "]");
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label448;
          }
          ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_JavaNioByteBuffer = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
          ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_Int = i;
          ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
          localObject1 = localObject5;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_c_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_Int = -3;
        }
      }
      finally {}
      ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_Int = -2;
      this.jdField_b_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
      if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
      {
        i = this.h;
        int j = jdField_b_of_type_Int;
        if (i == j)
        {
          try
          {
            i = this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("color-format");
            if (!QLog.isColorLevel()) {
              break label566;
            }
            QLog.e(jdField_c_of_type_JavaLangString, 2, "New color format " + i + "[0x" + Integer.toHexString(i) + "]");
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label566;
            }
          }
          QLog.e(jdField_c_of_type_JavaLangString, 2, "Exception,INFO_OUTPUT_FORMAT_CHANGED");
        }
        else if (QLog.isColorLevel())
        {
          QLog.e(jdField_c_of_type_JavaLangString, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
          break label566;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_c_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
          }
          ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_Int = -1;
          Object localObject3 = localObject5;
          continue;
          label448:
          ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_Int = i;
          try
          {
            ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
            ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
            localObject3 = localObject5;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            for (;;)
            {
              localIllegalAccessException.printStackTrace();
              ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_Boolean = false;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              localIllegalArgumentException.printStackTrace();
              ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_Boolean = false;
            }
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            for (;;)
            {
              localInvocationTargetException.printStackTrace();
              ((SVHwCodec.BufferData)localObject5).jdField_a_of_type_Boolean = false;
            }
          }
          continue;
        }
      }
      label566:
      Object localObject4 = localObject5;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
      this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
    }
  }
  
  public void d()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = null;
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = null;
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        this.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\hwcodec\SVHwCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */