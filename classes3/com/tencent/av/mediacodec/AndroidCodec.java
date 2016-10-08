package com.tencent.av.mediacodec;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.mediacodec.config.CodecConfigParser;
import com.tencent.av.utils.ClassLoaderUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class AndroidCodec
{
  public static int a = 0;
  public static String a;
  protected static Method a;
  protected static boolean a = false;
  public static int b = 0;
  public static String b;
  protected static Method b;
  protected static boolean b = false;
  public static int c = 0;
  public static String c;
  protected static Method c;
  public static final int d = 0;
  protected static Method d;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 4;
  public static final int h = 8;
  protected MediaCodec a;
  protected MediaFormat a;
  Object a;
  protected ByteBuffer[] a;
  protected MediaFormat b;
  protected ByteBuffer[] b;
  protected int i = jdField_b_of_type_Int;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "video/avc";
    jdField_b_of_type_JavaLangString = "request-sync";
    jdField_c_of_type_JavaLangString = "AndroidCodec";
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Int = 33000;
  }
  
  public AndroidCodec()
  {
    this.jdField_a_of_type_JavaLangObject = null;
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
    if (Build.VERSION.SDK_INT < 16) {}
    String str;
    do
    {
      do
      {
        do
        {
          return 0;
          if (Build.VERSION.SDK_INT < 21) {
            break;
          }
          a();
        } while (!jdField_b_of_type_Boolean);
      } while (!new File(paramContext.getApplicationInfo().nativeLibraryDir + "/libhwcodec.so").exists());
      if (!jdField_a_of_type_Boolean)
      {
        b();
        if (jdField_a_of_type_Boolean)
        {
          str = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
          str = str + "MODEL=" + Build.MODEL.toLowerCase() + ";";
          str = str + "SDK=" + Build.VERSION.SDK_INT + ";";
          str = str + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
          str = str + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
          paramContext = paramContext.getApplicationInfo();
          str = str + "DATADIR=" + paramContext.dataDir + ";";
          if (Build.VERSION.SDK_INT < 9) {
            break;
          }
          paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";
          NativeCodec.set_device_infos(paramContext);
        }
      }
    } while (!jdField_a_of_type_Boolean);
    int j;
    if (DeviceCheck.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in decoder white list.");
      }
      if (!DeviceCheck.c()) {
        break label617;
      }
      j = 1;
    }
    for (;;)
    {
      label359:
      int k;
      if (DeviceCheck.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature device is in encoder white list.");
        }
        k = j;
        if (DeviceCheck.d()) {
          k = j + 2;
        }
      }
      for (;;)
      {
        return k;
        paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib" + ";";
        break;
        paramContext = ConfigInfo.instance();
        if (paramContext == null) {
          break label617;
        }
        paramContext = paramContext.getSharpConfigPayloadFromFile();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature decoder sharpConfigPayload:\n" + paramContext);
        }
        if (new CodecConfigParser(paramContext).a())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature hwcodec avc decoder enabled.");
          }
          if (!DeviceCheck.c()) {
            break label617;
          }
          j = 1;
          break label359;
        }
        j = 0;
        break label359;
        paramContext = ConfigInfo.instance();
        k = j;
        if (paramContext != null)
        {
          paramContext = paramContext.getSharpConfigPayloadFromFile();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature encoder sharpConfigPayload:\n" + paramContext);
          }
          k = j;
          if (new CodecConfigParser(paramContext).b())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_c_of_type_JavaLangString, 2, "checkSupportMediaCodecFeature hwcodec avc encoder enabled.");
            }
            k = j;
            if (DeviceCheck.d()) {
              k = j + 2;
            }
          }
        }
      }
      label617:
      j = 0;
    }
  }
  
  public static MediaCodecInfo.CodecCapabilities a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    return paramMediaCodecInfo.getCapabilitiesForType(paramString);
  }
  
  public static MediaCodecInfo a(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int j = 0;
    while (j < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(j);
      if (localMediaCodecInfo.getName().equalsIgnoreCase(paramString)) {
        return localMediaCodecInfo;
      }
      j += 1;
    }
    return null;
  }
  
  public static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int m = MediaCodecList.getCodecCount();
    int j = 0;
    if (j < m)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(j);
      if (localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        j += 1;
        break;
        if ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int k = 0;
          while (k < arrayOfString.length)
          {
            if (arrayOfString[k].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            k += 1;
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
      jdField_b_of_type_Boolean = false;
    }
  }
  
  public static List b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int m = MediaCodecList.getCodecCount();
    int j = 0;
    if (j < m)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(j);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        j += 1;
        break;
        if ((!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int k = 0;
          while (k < arrayOfString.length)
          {
            if (arrayOfString[k].equalsIgnoreCase(paramString)) {
              localArrayList.add(localMediaCodecInfo);
            }
            k += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void b()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "stlport_shared", 0, false);
      System.loadLibrary("hwcodec");
      int j = NativeCodec.getVersion();
      if ((QLog.isColorLevel()) || (j > 0)) {
        QLog.e(jdField_c_of_type_JavaLangString, 2, "Native so version =" + j);
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      jdField_a_of_type_Boolean = false;
    }
  }
  
  public MediaFormat a(int paramInt)
  {
    try
    {
      MediaFormat localMediaFormat = (MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString, 2, "invoke getOutputFormat exception", localException);
      }
    }
    return null;
  }
  
  /* Error */
  public AndroidCodec.BufferData a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 352	com/tencent/av/mediacodec/AndroidCodec$BufferData
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 355	com/tencent/av/mediacodec/AndroidCodec$BufferData:<init>	(Lcom/tencent/av/mediacodec/AndroidCodec;)V
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   22: getstatic 52	com/tencent/av/mediacodec/AndroidCodec:jdField_c_of_type_Int	I
    //   25: i2l
    //   26: invokevirtual 359	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   29: istore_3
    //   30: iload_3
    //   31: iflt -24 -> 7
    //   34: getstatic 71	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 20
    //   39: if_icmpgt +29 -> 68
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_1
    //   45: iload_3
    //   46: putfield 360	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Int	I
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 362	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_ArrayOfJavaNioByteBuffer	[Ljava/nio/ByteBuffer;
    //   54: iload_3
    //   55: aaload
    //   56: putfield 365	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: aload_0
    //   69: monitorenter
    //   70: aload_1
    //   71: iload_3
    //   72: putfield 360	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Int	I
    //   75: aload_1
    //   76: getstatic 275	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   79: aload_0
    //   80: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: iload_3
    //   90: invokestatic 330	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: invokevirtual 336	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 367	java/nio/ByteBuffer
    //   100: putfield 365	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: areturn
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 368	java/lang/IllegalAccessException:printStackTrace	()V
    //   112: aload_1
    //   113: iconst_0
    //   114: putfield 369	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Boolean	Z
    //   117: goto -14 -> 103
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 370	java/lang/IllegalArgumentException:printStackTrace	()V
    //   130: aload_1
    //   131: iconst_0
    //   132: putfield 369	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Boolean	Z
    //   135: goto -32 -> 103
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 371	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   143: aload_1
    //   144: iconst_0
    //   145: putfield 369	com/tencent/av/mediacodec/AndroidCodec$BufferData:jdField_a_of_type_Boolean	Z
    //   148: goto -45 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	AndroidCodec
    //   17	45	1	localBufferData1	AndroidCodec.BufferData
    //   63	50	1	localBufferData2	AndroidCodec.BufferData
    //   120	24	1	localObject	Object
    //   107	2	2	localIllegalAccessException	IllegalAccessException
    //   125	2	2	localIllegalArgumentException	IllegalArgumentException
    //   138	2	2	localInvocationTargetException	InvocationTargetException
    //   29	61	3	j	int
    // Exception table:
    //   from	to	target	type
    //   44	61	63	finally
    //   64	66	63	finally
    //   75	103	107	java/lang/IllegalAccessException
    //   70	75	120	finally
    //   75	103	120	finally
    //   103	105	120	finally
    //   108	117	120	finally
    //   121	123	120	finally
    //   126	135	120	finally
    //   139	148	120	finally
    //   75	103	125	java/lang/IllegalArgumentException
    //   75	103	138	java/lang/reflect/InvocationTargetException
  }
  
  public ByteBuffer a(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString, 2, "invoke getInputBuffer exception", localException);
      }
    }
    return null;
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   18: iload_1
    //   19: iconst_0
    //   20: invokevirtual 379	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	AndroidCodec
    //   0	31	1	paramInt	int
    //   6	2	2	localMediaCodec	MediaCodec
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   20: iload_1
    //   21: iconst_0
    //   22: iload_2
    //   23: lload_3
    //   24: iload 5
    //   26: invokevirtual 384	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   29: goto -16 -> 13
    //   32: astore 6
    //   34: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq -24 -> 13
    //   40: getstatic 47	com/tencent/av/mediacodec/AndroidCodec:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   43: iconst_2
    //   44: ldc_w 386
    //   47: aload 6
    //   49: invokestatic 343	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   52: goto -39 -> 13
    //   55: astore 6
    //   57: aload_0
    //   58: monitorexit
    //   59: aload 6
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	AndroidCodec
    //   0	62	1	paramInt1	int
    //   0	62	2	paramInt2	int
    //   0	62	3	paramLong	long
    //   0	62	5	paramInt3	int
    //   6	3	6	localMediaCodec	MediaCodec
    //   32	16	6	localException	Exception
    //   55	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	32	java/lang/Exception
    //   2	8	55	finally
    //   16	29	55	finally
    //   34	52	55	finally
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
  
  public void a(Surface paramSurface) {}
  
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
    catch (Exception localException) {}
    return true;
  }
  
  /* Error */
  public boolean a(MediaFormat paramMediaFormat, int paramInt, IMediaCodecCallback paramIMediaCodecCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: aload_1
    //   5: putfield 403	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   8: iload_2
    //   9: getstatic 62	com/tencent/av/mediacodec/AndroidCodec:jdField_b_of_type_Int	I
    //   12: if_icmpne +150 -> 162
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 403	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   20: ldc_w 405
    //   23: invokevirtual 409	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 413	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   29: putfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   32: aload_0
    //   33: iload_2
    //   34: putfield 64	com/tencent/av/mediacodec/AndroidCodec:i	I
    //   37: aload_0
    //   38: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   41: ifnull +101 -> 142
    //   44: iload_2
    //   45: getstatic 35	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_Int	I
    //   48: if_icmpne +148 -> 196
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_3
    //   54: ifnull +74 -> 128
    //   57: invokestatic 415	com/tencent/av/mediacodec/DeviceCheck:e	()Z
    //   60: ifeq +68 -> 128
    //   63: invokestatic 420	com/tencent/av/utils/ClassLoaderUtil:a	()Ldalvik/system/DexClassLoader;
    //   66: astore_1
    //   67: aload_0
    //   68: aload_1
    //   69: ldc_w 422
    //   72: invokestatic 425	com/tencent/av/utils/ClassLoaderUtil:a	(Ldalvik/system/DexClassLoader;Ljava/lang/String;)Ljava/lang/Object;
    //   75: putfield 60	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   78: aload_0
    //   79: getfield 60	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   88: astore 5
    //   90: aload_1
    //   91: aload 4
    //   93: ldc_w 427
    //   96: iconst_2
    //   97: anewarray 79	java/lang/Class
    //   100: dup
    //   101: iconst_0
    //   102: ldc 75
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: ldc_w 429
    //   110: aastore
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 5
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: aload_3
    //   123: aastore
    //   124: invokestatic 432	com/tencent/av/utils/ClassLoaderUtil:a	(Ldalvik/system/DexClassLoader;Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_0
    //   129: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   132: aload_0
    //   133: getfield 403	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   136: aconst_null
    //   137: aconst_null
    //   138: iload_2
    //   139: invokevirtual 436	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   142: aload_0
    //   143: getfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   146: ifnull +6 -> 152
    //   149: iconst_1
    //   150: istore 6
    //   152: iload 6
    //   154: ireturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 403	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   167: ldc_w 405
    //   170: invokevirtual 409	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   173: invokestatic 440	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   176: putfield 326	com/tencent/av/mediacodec/AndroidCodec:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   179: goto -147 -> 32
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 437	java/lang/Exception:printStackTrace	()V
    //   194: iconst_0
    //   195: ireturn
    //   196: iconst_0
    //   197: istore_2
    //   198: goto -145 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	AndroidCodec
    //   0	201	1	paramMediaFormat	MediaFormat
    //   0	201	2	paramInt	int
    //   0	201	3	paramIMediaCodecCallback	IMediaCodecCallback
    //   82	10	4	localObject	Object
    //   88	30	5	localMediaCodec	MediaCodec
    //   1	152	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   15	32	155	java/lang/Exception
    //   162	179	182	java/lang/Exception
    //   37	51	189	java/lang/Exception
    //   57	128	189	java/lang/Exception
    //   128	142	189	java/lang/Exception
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString, Surface paramSurface, IMediaCodecCallback paramIMediaCodecCallback)
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
          this.i = jdField_a_of_type_Int;
          j = 1;
          MediaCodec localMediaCodec;
          return false;
        }
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
          {
            if ((paramIMediaCodecCallback != null) && (DeviceCheck.e()))
            {
              paramMediaFormat = ClassLoaderUtil.a();
              this.jdField_a_of_type_JavaLangObject = ClassLoaderUtil.a(paramMediaFormat, "com.tencent.av.mediacodec.MediaCodecWrapper");
              paramString = this.jdField_a_of_type_JavaLangObject;
              localMediaCodec = this.jdField_a_of_type_AndroidMediaMediaCodec;
              ClassLoaderUtil.a(paramMediaFormat, paramString, "setCallback", new Class[] { MediaCodec.class, IMediaCodecCallback.class }, new Object[] { localMediaCodec, paramIMediaCodecCallback });
            }
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, paramSurface, null, j);
          }
          if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
            break label159;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
      label159:
      int j = 0;
    }
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString, IMediaCodecCallback paramIMediaCodecCallback)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    paramMediaFormat = a(paramString);
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder())) {
      this.i = jdField_a_of_type_Int;
    }
    for (int j = 1;; j = 0) {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createByCodecName(paramString);
        MediaCodec localMediaCodec;
        return false;
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
          {
            if ((paramIMediaCodecCallback != null) && (DeviceCheck.e()))
            {
              paramMediaFormat = ClassLoaderUtil.a();
              this.jdField_a_of_type_JavaLangObject = ClassLoaderUtil.a(paramMediaFormat, "com.tencent.av.mediacodec.MediaCodecWrapper");
              paramString = this.jdField_a_of_type_JavaLangObject;
              localMediaCodec = this.jdField_a_of_type_AndroidMediaMediaCodec;
              ClassLoaderUtil.a(paramMediaFormat, paramString, "setCallback", new Class[] { MediaCodec.class, IMediaCodecCallback.class }, new Object[] { localMediaCodec, paramIMediaCodecCallback });
            }
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, j);
          }
          if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
            continue;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
  }
  
  public AndroidCodec.BufferData b()
  {
    Object localObject5 = null;
    for (;;)
    {
      AndroidCodec.BufferData localBufferData;
      int j;
      try
      {
        Object localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = localObject5;
          return (AndroidCodec.BufferData)localObject1;
        }
        localBufferData = new AndroidCodec.BufferData(this);
        j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, jdField_c_of_type_Int);
        switch (j)
        {
        case -3: 
          localObject1 = localObject5;
          if (j < 0) {
            continue;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label350;
          }
          localBufferData.jdField_a_of_type_JavaNioByteBuffer = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[j];
          localBufferData.jdField_a_of_type_Int = j;
          localBufferData.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
          localObject1 = localBufferData;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_c_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          localBufferData.jdField_a_of_type_Int = -3;
          localObject1 = localObject5;
          break;
        case -2: 
          localBufferData.jdField_a_of_type_Int = -2;
        }
      }
      finally {}
      this.jdField_b_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
      Object localObject3 = localObject5;
      if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
      {
        j = this.i;
        int k = jdField_b_of_type_Int;
        Object localObject4;
        if (j == k)
        {
          try
          {
            j = this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("color-format");
            localObject3 = localObject5;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(jdField_c_of_type_JavaLangString, 2, "New color format " + j + "[0x" + Integer.toHexString(j) + "]");
            localObject3 = localObject5;
          }
          catch (Exception localException)
          {
            localObject4 = localObject5;
          }
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_c_of_type_JavaLangString, 2, "Exception,INFO_OUTPUT_FORMAT_CHANGED");
            localObject4 = localObject5;
          }
        }
        else
        {
          localObject4 = localObject5;
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_c_of_type_JavaLangString, 2, "EncCodec,INFO_OUTPUT_FORMAT_CHANGED");
            localObject4 = localObject5;
            continue;
            if (QLog.isColorLevel()) {
              QLog.e(jdField_c_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
            }
            localBufferData.jdField_a_of_type_Int = -1;
            localObject4 = localBufferData;
            continue;
            label350:
            localBufferData.jdField_a_of_type_Int = j;
            try
            {
              localBufferData.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(j) }));
              localBufferData.jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(j) }));
              localObject4 = localBufferData;
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              for (;;)
              {
                localIllegalAccessException.printStackTrace();
                localBufferData.jdField_a_of_type_Boolean = false;
              }
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              for (;;)
              {
                localIllegalArgumentException.printStackTrace();
                localBufferData.jdField_a_of_type_Boolean = false;
              }
            }
            catch (InvocationTargetException localInvocationTargetException)
            {
              for (;;)
              {
                localInvocationTargetException.printStackTrace();
                localBufferData.jdField_a_of_type_Boolean = false;
              }
            }
          }
        }
      }
    }
  }
  
  public ByteBuffer b(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString, 2, "invoke getOutputBuffer exception", localException);
      }
    }
    return null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
      this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
    }
  }
  
  public void e()
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
  
  public void f() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\mediacodec\AndroidCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */