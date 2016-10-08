package com.tencent.av.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gjk;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeCodec
  implements IMediaCodecCallback
{
  static gjk jdField_a_of_type_Gjk;
  static gjk jdField_b_of_type_Gjk;
  public static boolean b = false;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j = "slice-height";
  public static final String k = "AndroidCodec";
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  MediaFormat jdField_a_of_type_AndroidMediaMediaFormat = null;
  AndroidCodec jdField_a_of_type_ComTencentAvMediacodecAndroidCodec;
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  Map jdField_a_of_type_JavaUtilMap = null;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  Map jdField_b_of_type_JavaUtilMap = null;
  int jdField_c_of_type_Int = 320;
  Map jdField_c_of_type_JavaUtilMap = null;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 240;
  boolean jdField_d_of_type_Boolean = false;
  int e;
  int f;
  int g;
  int h;
  int i;
  private int mNativeContext;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = "crop-left";
    jdField_d_of_type_JavaLangString = "crop-top";
    jdField_e_of_type_JavaLangString = "crop-right";
    jdField_f_of_type_JavaLangString = "crop-bottom";
    jdField_g_of_type_JavaLangString = "stride";
    jdField_h_of_type_JavaLangString = "csd-0";
    jdField_i_of_type_JavaLangString = "csd-1";
  }
  
  public NativeCodec()
  {
    this.jdField_f_of_type_Int = 20;
    this.jdField_g_of_type_Int = 40000;
    this.jdField_i_of_type_Int = 0;
  }
  
  public NativeCodec(String paramString, Map paramMap, boolean paramBoolean)
  {
    this.jdField_f_of_type_Int = 20;
    this.jdField_g_of_type_Int = 40000;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = ((Integer)paramMap.get("width")).intValue();
    this.jdField_d_of_type_Int = ((Integer)paramMap.get("height")).intValue();
    if (this.jdField_a_of_type_Boolean)
    {
      try
      {
        int m = this.jdField_c_of_type_Int;
        int n = this.jdField_d_of_type_Int;
        this.jdField_a_of_type_AndroidMediaMediaFormat = MediaFormat.createVideoFormat(paramString, m, n);
        this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("max-input-size", m * n);
        this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("color-format", 21);
        this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("frame-rate", 25);
        if (paramString.contains(AndroidCodec.jdField_a_of_type_JavaLangString))
        {
          paramString = (ByteBuffer)paramMap.get(jdField_h_of_type_JavaLangString);
          paramMap = (ByteBuffer)paramMap.get(jdField_i_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidMediaMediaFormat.setByteBuffer(jdField_h_of_type_JavaLangString, paramString);
          this.jdField_a_of_type_AndroidMediaMediaFormat.setByteBuffer(jdField_i_of_type_JavaLangString, paramMap);
        }
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, "<init>, width =" + m + ",height =" + n);
        }
        c();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label379:
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
        }
      }
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
        this.jdField_b_of_type_JavaUtilMap = new HashMap();
        this.jdField_c_of_type_JavaUtilMap = new HashMap();
        if (!jdField_b_of_type_Boolean) {
          break label483;
        }
        paramString = "Async ";
        this.jdField_b_of_type_JavaLangString = paramString;
        paramMap = new StringBuilder().append(this.jdField_b_of_type_JavaLangString);
        if (!this.jdField_a_of_type_Boolean) {
          break label489;
        }
      }
    }
    label483:
    label489:
    for (paramString = "DEC ";; paramString = "ENC ")
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      return;
      try
      {
        this.jdField_h_of_type_Int = ((Integer)paramMap.get("bitrate")).intValue();
        this.jdField_f_of_type_Int = ((Integer)paramMap.get("frame-rate")).intValue();
        a();
      }
      catch (Exception paramString)
      {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
      }
      break;
      paramString = " Sync ";
      break label379;
    }
  }
  
  private static void a(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, gjk paramgjk)
  {
    switch (paramCodecProfileLevel.level)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                  } while ((paramgjk.jdField_a_of_type_Int >= 176) && (paramgjk.jdField_b_of_type_Int >= 144));
                                  paramgjk.jdField_a_of_type_Int = 176;
                                  paramgjk.jdField_b_of_type_Int = 144;
                                  return;
                                } while ((paramgjk.jdField_a_of_type_Int >= 352) && (paramgjk.jdField_b_of_type_Int >= 288));
                                paramgjk.jdField_a_of_type_Int = 352;
                                paramgjk.jdField_b_of_type_Int = 288;
                                return;
                              } while ((paramgjk.jdField_a_of_type_Int >= 352) && (paramgjk.jdField_b_of_type_Int >= 288));
                              paramgjk.jdField_a_of_type_Int = 352;
                              paramgjk.jdField_b_of_type_Int = 288;
                              return;
                            } while ((paramgjk.jdField_a_of_type_Int >= 352) && (paramgjk.jdField_b_of_type_Int >= 288));
                            paramgjk.jdField_a_of_type_Int = 352;
                            paramgjk.jdField_b_of_type_Int = 288;
                            return;
                          } while ((paramgjk.jdField_a_of_type_Int >= 352) && (paramgjk.jdField_b_of_type_Int >= 288));
                          paramgjk.jdField_a_of_type_Int = 352;
                          paramgjk.jdField_b_of_type_Int = 288;
                          return;
                        } while ((paramgjk.jdField_a_of_type_Int >= 352) && (paramgjk.jdField_b_of_type_Int >= 288));
                        paramgjk.jdField_a_of_type_Int = 352;
                        paramgjk.jdField_b_of_type_Int = 288;
                        return;
                      } while ((paramgjk.jdField_a_of_type_Int >= 352) && (paramgjk.jdField_b_of_type_Int >= 576));
                      paramgjk.jdField_a_of_type_Int = 352;
                      paramgjk.jdField_b_of_type_Int = 576;
                      return;
                    } while ((paramgjk.jdField_a_of_type_Int >= 720) && (paramgjk.jdField_b_of_type_Int >= 576));
                    paramgjk.jdField_a_of_type_Int = 720;
                    paramgjk.jdField_b_of_type_Int = 576;
                    return;
                  } while ((paramgjk.jdField_a_of_type_Int >= 720) && (paramgjk.jdField_b_of_type_Int >= 576));
                  paramgjk.jdField_a_of_type_Int = 720;
                  paramgjk.jdField_b_of_type_Int = 576;
                  return;
                } while ((paramgjk.jdField_a_of_type_Int >= 1280) && (paramgjk.jdField_b_of_type_Int >= 720));
                paramgjk.jdField_a_of_type_Int = 1280;
                paramgjk.jdField_b_of_type_Int = 720;
                return;
              } while ((paramgjk.jdField_a_of_type_Int >= 1280) && (paramgjk.jdField_b_of_type_Int >= 1024));
              paramgjk.jdField_a_of_type_Int = 1280;
              paramgjk.jdField_b_of_type_Int = 1024;
              return;
            } while ((paramgjk.jdField_a_of_type_Int >= 2048) && (paramgjk.jdField_b_of_type_Int >= 1024));
            paramgjk.jdField_a_of_type_Int = 2048;
            paramgjk.jdField_b_of_type_Int = 1024;
            return;
          } while ((paramgjk.jdField_a_of_type_Int >= 2048) && (paramgjk.jdField_b_of_type_Int >= 1024));
          paramgjk.jdField_a_of_type_Int = 2048;
          paramgjk.jdField_b_of_type_Int = 1024;
          return;
        } while ((paramgjk.jdField_a_of_type_Int >= 2048) && (paramgjk.jdField_b_of_type_Int >= 1088));
        paramgjk.jdField_a_of_type_Int = 2048;
        paramgjk.jdField_b_of_type_Int = 1088;
        return;
      } while ((paramgjk.jdField_a_of_type_Int >= 3680) && (paramgjk.jdField_b_of_type_Int >= 1536));
      paramgjk.jdField_a_of_type_Int = 3680;
      paramgjk.jdField_b_of_type_Int = 1536;
      return;
    } while ((paramgjk.jdField_a_of_type_Int >= 4096) && (paramgjk.jdField_b_of_type_Int >= 2304));
    paramgjk.jdField_a_of_type_Int = 4096;
    paramgjk.jdField_b_of_type_Int = 2304;
  }
  
  private boolean a(ByteBuffer paramByteBuffer, int paramInt, MediaFormat paramMediaFormat)
  {
    int i4 = paramMediaFormat.getInteger("width");
    int i5 = paramMediaFormat.getInteger("height");
    int i2 = paramMediaFormat.getInteger(jdField_c_of_type_JavaLangString);
    int i7 = paramMediaFormat.getInteger(jdField_e_of_type_JavaLangString);
    int i8 = paramMediaFormat.getInteger(jdField_d_of_type_JavaLangString);
    int i6 = paramMediaFormat.getInteger(jdField_f_of_type_JavaLangString);
    int i1 = paramMediaFormat.getInteger(jdField_g_of_type_JavaLangString);
    int n = paramMediaFormat.getInteger(j);
    int i9 = paramMediaFormat.getInteger("color-format");
    int m = n;
    if (n < i5) {
      m = i5;
    }
    n = i1;
    if (i1 < i4) {
      n = i4;
    }
    int i3 = m;
    i1 = i8;
    if (i9 == 2130706688)
    {
      i3 = m - i8 / 2;
      i1 = 0;
      i2 = 0;
    }
    m = n;
    if (n < i4) {
      m = i4;
    }
    if (((2141391876 == i9) || (2130706433 == i9) || (2130706944 == i9)) && (i5 < i3)) {}
    for (n = i3;; n = i5)
    {
      if (i2 + i7 + i1 + i6 == 0)
      {
        i2 = 0;
        i5 -= 1;
        i1 = 0;
        i6 = i4 - 1;
        i4 = n;
        i3 = m;
        n = i6;
        m = i5;
        if ((i3 <= 0) || (i4 <= 0) || (n <= 0) || (m <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, "error decoderInfomations.");
          }
          return false;
        }
      }
      else
      {
        i5 = i7 - i2 + 1;
        i4 = i6 - i1 + 1;
        i3 = m;
        if (m < i5) {
          i3 = i5;
        }
        if (n >= i4) {
          break label375;
        }
      }
      label375:
      for (m = i4;; m = n)
      {
        n = i7;
        i4 = m;
        m = i6;
        break;
        SystemClock.elapsedRealtime();
        paramInt = readOutputDataEx(paramByteBuffer, paramInt, i3, i4, i2, i1, n - i2 + 1, m - i1 + 1, i9);
        SystemClock.elapsedRealtime();
        return paramInt > 0;
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 213	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   4: ifnull +82 -> 86
    //   7: aload_0
    //   8: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 105	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   18: iconst_1
    //   19: invokevirtual 257	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   22: aload_0
    //   23: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: invokeinterface 262 1 0
    //   31: aload_0
    //   32: getfield 107	com/tencent/av/mediacodec/NativeCodec:jdField_c_of_type_Boolean	Z
    //   35: ifeq +30 -> 65
    //   38: aload_0
    //   39: getfield 109	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   42: invokeinterface 263 1 0
    //   47: aload_0
    //   48: getfield 111	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   51: invokeinterface 263 1 0
    //   56: aload_0
    //   57: getfield 113	com/tencent/av/mediacodec/NativeCodec:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   60: invokeinterface 263 1 0
    //   65: aload_0
    //   66: getfield 213	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   69: invokevirtual 265	com/tencent/av/mediacodec/AndroidCodec:d	()V
    //   72: aload_0
    //   73: getfield 213	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   76: invokevirtual 267	com/tencent/av/mediacodec/AndroidCodec:e	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 213	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   84: aload_1
    //   85: monitorexit
    //   86: aload_0
    //   87: getfield 126	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_Boolean	Z
    //   90: ifeq +63 -> 153
    //   93: aload_0
    //   94: invokespecial 202	com/tencent/av/mediacodec/NativeCodec:c	()V
    //   97: aload_0
    //   98: lconst_0
    //   99: putfield 76	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_Long	J
    //   102: aload_0
    //   103: lconst_0
    //   104: putfield 78	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   107: aload_0
    //   108: getfield 213	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   111: invokevirtual 269	com/tencent/av/mediacodec/AndroidCodec:a	()Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 105	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   119: iconst_0
    //   120: invokevirtual 257	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   123: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +12 -> 138
    //   129: ldc 23
    //   131: iconst_2
    //   132: ldc_w 271
    //   135: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: return
    //   139: astore_2
    //   140: aload_1
    //   141: monitorexit
    //   142: aload_2
    //   143: athrow
    //   144: astore_1
    //   145: aload_0
    //   146: aconst_null
    //   147: putfield 213	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   150: goto -64 -> 86
    //   153: aload_0
    //   154: invokevirtual 219	com/tencent/av/mediacodec/NativeCodec:a	()V
    //   157: goto -60 -> 97
    //   160: astore_1
    //   161: goto -38 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	NativeCodec
    //   144	1	1	localException1	Exception
    //   160	1	1	localException2	Exception
    //   139	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	65	139	finally
    //   65	86	139	finally
    //   140	142	139	finally
    //   7	14	144	java/lang/Exception
    //   142	144	144	java/lang/Exception
    //   86	97	160	java/lang/Exception
    //   97	123	160	java/lang/Exception
    //   153	157	160	java/lang/Exception
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = new AndroidCodec();
    List localList;
    MediaCodecInfo localMediaCodecInfo;
    int m;
    if (this.jdField_a_of_type_Boolean)
    {
      localList = AndroidCodec.a(this.jdField_a_of_type_JavaLangString);
      localMediaCodecInfo = (MediaCodecInfo)localList.get(0);
      m = 0;
    }
    for (;;)
    {
      Object localObject = localMediaCodecInfo;
      if (m < localList.size())
      {
        localObject = AndroidCodec.a((MediaCodecInfo)localList.get(m), this.jdField_a_of_type_JavaLangString);
        if (!ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19)) {
          break label132;
        }
        localObject = (MediaCodecInfo)localList.get(m);
        this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("color-format", 19);
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(this.jdField_a_of_type_AndroidMediaMediaFormat, ((MediaCodecInfo)localObject).getName(), this)) {
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
        }
        return;
        label132:
        if (!ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {
          break;
        }
        localObject = (MediaCodecInfo)localList.get(m);
        this.jdField_a_of_type_AndroidMediaMediaFormat.setInteger("color-format", 21);
      }
      m += 1;
    }
  }
  
  private static void d()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)AndroidCodec.a(AndroidCodec.jdField_a_of_type_JavaLangString).get(0), AndroidCodec.jdField_a_of_type_JavaLangString);
    jdField_b_of_type_Gjk = new gjk();
    int m = 0;
    if (m < localCodecCapabilities.profileLevels.length)
    {
      switch (localCodecCapabilities.profileLevels[m].profile)
      {
      }
      for (;;)
      {
        m += 1;
        break;
        jdField_b_of_type_Gjk.jdField_c_of_type_Int = 3;
        a(localCodecCapabilities.profileLevels[m], jdField_b_of_type_Gjk);
      }
    }
  }
  
  private static void e()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)AndroidCodec.a(AndroidCodec.jdField_a_of_type_JavaLangString).get(0), AndroidCodec.jdField_a_of_type_JavaLangString);
    jdField_a_of_type_Gjk = new gjk();
    int m = 0;
    if (m < localCodecCapabilities.profileLevels.length)
    {
      switch (localCodecCapabilities.profileLevels[m].profile)
      {
      default: 
        label120:
        switch (localCodecCapabilities.profileLevels[m].level)
        {
        }
        break;
      }
      for (;;)
      {
        m += 1;
        break;
        if (jdField_a_of_type_Gjk.jdField_c_of_type_Int > 3) {
          break label120;
        }
        jdField_a_of_type_Gjk.jdField_c_of_type_Int = 3;
        break label120;
        if (jdField_a_of_type_Gjk.jdField_c_of_type_Int > 5) {
          break label120;
        }
        jdField_a_of_type_Gjk.jdField_c_of_type_Int = 5;
        break label120;
        if (jdField_a_of_type_Gjk.jdField_c_of_type_Int > 5) {
          break label120;
        }
        jdField_a_of_type_Gjk.jdField_c_of_type_Int = 5;
        break label120;
        if (jdField_a_of_type_Gjk.jdField_c_of_type_Int > 5) {
          break label120;
        }
        jdField_a_of_type_Gjk.jdField_c_of_type_Int = 5;
        break label120;
        if (jdField_a_of_type_Gjk.jdField_c_of_type_Int > 5) {
          break label120;
        }
        jdField_a_of_type_Gjk.jdField_c_of_type_Int = 5;
        break label120;
        if (jdField_a_of_type_Gjk.jdField_c_of_type_Int > 5) {
          break label120;
        }
        jdField_a_of_type_Gjk.jdField_c_of_type_Int = 5;
        break label120;
        if (jdField_a_of_type_Gjk.jdField_c_of_type_Int > 4) {
          break label120;
        }
        jdField_a_of_type_Gjk.jdField_c_of_type_Int = 4;
        break label120;
        if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 176) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 144))
        {
          jdField_a_of_type_Gjk.jdField_a_of_type_Int = 176;
          jdField_a_of_type_Gjk.jdField_b_of_type_Int = 144;
          continue;
          if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 288))
          {
            jdField_a_of_type_Gjk.jdField_a_of_type_Int = 352;
            jdField_a_of_type_Gjk.jdField_b_of_type_Int = 288;
            continue;
            if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 288))
            {
              jdField_a_of_type_Gjk.jdField_a_of_type_Int = 352;
              jdField_a_of_type_Gjk.jdField_b_of_type_Int = 288;
              continue;
              if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 288))
              {
                jdField_a_of_type_Gjk.jdField_a_of_type_Int = 352;
                jdField_a_of_type_Gjk.jdField_b_of_type_Int = 288;
                continue;
                if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 288))
                {
                  jdField_a_of_type_Gjk.jdField_a_of_type_Int = 352;
                  jdField_a_of_type_Gjk.jdField_b_of_type_Int = 288;
                  continue;
                  if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 288))
                  {
                    jdField_a_of_type_Gjk.jdField_a_of_type_Int = 352;
                    jdField_a_of_type_Gjk.jdField_b_of_type_Int = 288;
                    continue;
                    if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 352) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 576))
                    {
                      jdField_a_of_type_Gjk.jdField_a_of_type_Int = 352;
                      jdField_a_of_type_Gjk.jdField_b_of_type_Int = 576;
                      continue;
                      if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 720) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 576))
                      {
                        jdField_a_of_type_Gjk.jdField_a_of_type_Int = 720;
                        jdField_a_of_type_Gjk.jdField_b_of_type_Int = 576;
                        continue;
                        if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 720) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 576))
                        {
                          jdField_a_of_type_Gjk.jdField_a_of_type_Int = 720;
                          jdField_a_of_type_Gjk.jdField_b_of_type_Int = 576;
                          continue;
                          if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 1280) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 720))
                          {
                            jdField_a_of_type_Gjk.jdField_a_of_type_Int = 1280;
                            jdField_a_of_type_Gjk.jdField_b_of_type_Int = 720;
                            continue;
                            if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 1280) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 1024))
                            {
                              jdField_a_of_type_Gjk.jdField_a_of_type_Int = 1280;
                              jdField_a_of_type_Gjk.jdField_b_of_type_Int = 1024;
                              continue;
                              if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 2048) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 1024))
                              {
                                jdField_a_of_type_Gjk.jdField_a_of_type_Int = 2048;
                                jdField_a_of_type_Gjk.jdField_b_of_type_Int = 1024;
                                continue;
                                if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 2048) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 1024))
                                {
                                  jdField_a_of_type_Gjk.jdField_a_of_type_Int = 2048;
                                  jdField_a_of_type_Gjk.jdField_b_of_type_Int = 1024;
                                  continue;
                                  if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 2048) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 1088))
                                  {
                                    jdField_a_of_type_Gjk.jdField_a_of_type_Int = 2048;
                                    jdField_a_of_type_Gjk.jdField_b_of_type_Int = 1088;
                                    continue;
                                    if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 3680) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 1536))
                                    {
                                      jdField_a_of_type_Gjk.jdField_a_of_type_Int = 3680;
                                      jdField_a_of_type_Gjk.jdField_b_of_type_Int = 1536;
                                      continue;
                                      if ((jdField_a_of_type_Gjk.jdField_a_of_type_Int < 4096) || (jdField_a_of_type_Gjk.jdField_b_of_type_Int < 2304))
                                      {
                                        jdField_a_of_type_Gjk.jdField_a_of_type_Int = 4096;
                                        jdField_a_of_type_Gjk.jdField_b_of_type_Int = 2304;
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static int getIntValues(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      do
      {
        do
        {
          return 0;
          if (!"supportAsync".equalsIgnoreCase(paramString2)) {
            break;
          }
          jdField_b_of_type_Boolean = DeviceCheck.e();
        } while (!jdField_b_of_type_Boolean);
        return 1;
        if ((!paramString1.equalsIgnoreCase(AndroidCodec.jdField_a_of_type_JavaLangString)) || (!paramBoolean)) {
          break;
        }
        if (jdField_a_of_type_Gjk == null) {
          e();
        }
        if (paramString2.equalsIgnoreCase("width")) {
          return jdField_a_of_type_Gjk.jdField_a_of_type_Int;
        }
        if (paramString2.equalsIgnoreCase("height")) {
          return jdField_a_of_type_Gjk.jdField_b_of_type_Int;
        }
      } while (!paramString2.equalsIgnoreCase("profile"));
      return jdField_a_of_type_Gjk.jdField_c_of_type_Int;
      if (jdField_b_of_type_Gjk == null) {
        d();
      }
      if (paramString2.equalsIgnoreCase("width")) {
        return jdField_b_of_type_Gjk.jdField_a_of_type_Int;
      }
      if (paramString2.equalsIgnoreCase("height")) {
        return jdField_b_of_type_Gjk.jdField_b_of_type_Int;
      }
    } while (!paramString2.equalsIgnoreCase("profile"));
    return jdField_b_of_type_Gjk.jdField_c_of_type_Int;
  }
  
  public static native int getVersion();
  
  private static boolean onAttach(String paramString, int paramInt, boolean paramBoolean, Map paramMap)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      return false;
      paramString = new NativeCodec(paramString, paramMap, paramBoolean);
    } while (paramString.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null);
    paramString.mNativeContext = paramInt;
    paramString.attachCodec(paramString);
    paramString.jdField_a_of_type_Long = 0L;
    paramString.jdField_a_of_type_Int = 0;
    paramString.jdField_b_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.e("AndroidCodec", 2, "onAttach");
    }
    return paramString.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
  }
  
  private boolean onCalcDelay(int paramInt)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, this.jdField_b_of_type_JavaLangString + " frameIndex:" + paramInt);
      }
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
    }
    return true;
  }
  
  private static void onDetach(Object arg0)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    NativeCodec localNativeCodec;
    do
    {
      return;
      localNativeCodec = (NativeCodec)???;
    } while (localNativeCodec == null);
    localNativeCodec.detachCodec();
    localNativeCodec.jdField_a_of_type_Int = 0;
    localNativeCodec.jdField_a_of_type_Long = 0L;
    localNativeCodec.jdField_a_of_type_AndroidMediaMediaFormat = null;
    localNativeCodec.jdField_b_of_type_Long = 0L;
    synchronized (localNativeCodec.jdField_a_of_type_JavaUtilList)
    {
      localNativeCodec.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      localNativeCodec.jdField_a_of_type_JavaUtilList.clear();
      if (localNativeCodec.jdField_c_of_type_Boolean)
      {
        localNativeCodec.jdField_a_of_type_JavaUtilMap.clear();
        localNativeCodec.jdField_b_of_type_JavaUtilMap.clear();
        localNativeCodec.jdField_c_of_type_JavaUtilMap.clear();
      }
      AndroidCodec localAndroidCodec = localNativeCodec.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec;
      if (localAndroidCodec == null) {}
    }
    try
    {
      localNativeCodec.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.d();
      localNativeCodec.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.e();
      localNativeCodec.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "onDetach");
      }
      return;
      localObject = finally;
      throw ((Throwable)localObject);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private boolean onDoCodec(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Int >= 10) && (paramInt1 == 0))
    {
      b();
      if (this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
        paramInt1 = 0;
        if (localObject1 != null) {
          break label834;
        }
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, "inputbuffer not available");
        }
        int n = paramInt1;
        Object localObject5 = localObject1;
        try
        {
          Thread.sleep(50L);
          n = paramInt1;
          localObject5 = localObject1;
          localObject4 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
          int m = paramInt1 + 1;
          if (localObject4 != null)
          {
            if (!this.jdField_a_of_type_Boolean) {
              break label267;
            }
            paramInt1 = writeInputData(((AndroidCodec.BufferData)localObject4).jdField_a_of_type_JavaNioByteBuffer, false);
            if (paramInt1 >= 0) {
              break label285;
            }
            if (QLog.isColorLevel()) {
              QLog.e("AndroidCodec", 2, "writeInputData, SampleSize < 0");
            }
            return false;
          }
          n = m;
          localObject5 = localObject4;
          if (QLog.isColorLevel())
          {
            n = m;
            localObject5 = localObject4;
            QLog.e("AndroidCodec", 2, "inputbuffer not available");
          }
          paramInt1 = m;
          localObject1 = localObject4;
          if (m <= 8) {
            continue;
          }
          n = m;
          localObject5 = localObject4;
          if (QLog.isColorLevel())
          {
            n = m;
            localObject5 = localObject4;
            QLog.e("AndroidCodec", 2, "inputbuffer not available, try count=" + m);
          }
          return false;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          paramInt1 = n;
          Object localObject2 = localObject5;
        }
        continue;
        paramInt1 = writeInputData2(((AndroidCodec.BufferData)localObject4).jdField_a_of_type_JavaNioByteBuffer, this.jdField_e_of_type_Int, false);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, "onDoCodec Exception!");
        }
        return false;
      }
      label267:
      continue;
      label285:
      this.jdField_b_of_type_Long += this.jdField_g_of_type_Int;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(System.currentTimeMillis()));
        this.jdField_c_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(paramInt2));
      }
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject4).jdField_a_of_type_Int, paramInt1, this.jdField_b_of_type_Long, 0);
      Object localObject3 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.b();
      if (localObject3 == null) {
        break label844;
      }
      if (((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Int == -1)
      {
        this.jdField_a_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, "dequeueOutputBuffer, try again later,count =" + this.jdField_a_of_type_Int);
        }
        if (this.jdField_a_of_type_Int < 16) {
          break;
        }
        return false;
      }
      this.jdField_a_of_type_Int = 0;
      if (!((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Boolean)
      {
        if (!QLog.isColorLevel()) {
          break label842;
        }
        QLog.e("AndroidCodec", 2, "onDoCodec err!");
        break label842;
      }
      if ((((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaFormat == null) || (((AndroidCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer == null))
      {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Int);
        return false;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a(true, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        a(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaFormat);
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Int);
        break label844;
      }
      if ((((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags != 1) || (((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags == 2))
      {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_Int);
        readOutputStream(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags);
        localObject4 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.b();
        if (localObject4 != null)
        {
          if (((AndroidCodec.BufferData)localObject4).jdField_a_of_type_Int == -1)
          {
            this.jdField_b_of_type_Int += 1;
            if (QLog.isColorLevel()) {
              QLog.e("AndroidCodec", 2, "re-dequeue dequeueOutputBuffer, try again later,count =" + this.jdField_b_of_type_Int);
            }
            if (this.jdField_b_of_type_Int < 16) {
              break label846;
            }
            return false;
          }
          this.jdField_b_of_type_Int = 0;
          if (!((AndroidCodec.BufferData)localObject4).jdField_a_of_type_Boolean)
          {
            if (!QLog.isColorLevel()) {
              break label848;
            }
            QLog.e("AndroidCodec", 2, "re-dequeue onDoCodec err!");
            break label848;
          }
          if ((((AndroidCodec.BufferData)localObject4).jdField_a_of_type_AndroidMediaMediaFormat == null) || (((AndroidCodec.BufferData)localObject4).jdField_a_of_type_JavaNioByteBuffer == null))
          {
            this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject4).jdField_a_of_type_Int);
            return false;
          }
        }
        localObject3 = localObject4;
        if (QLog.isColorLevel())
        {
          QLog.e("AndroidCodec", 2, "re-dequeue success");
          localObject3 = localObject4;
        }
      }
      for (;;)
      {
        a(true, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        readOutputStream(((AndroidCodec.BufferData)localObject3).jdField_a_of_type_JavaNioByteBuffer, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size, ((AndroidCodec.BufferData)localObject3).jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags);
        break;
      }
      label834:
      Object localObject4 = localObject3;
    }
    return true;
    label842:
    return false;
    label844:
    return true;
    label846:
    return true;
    label848:
    return false;
  }
  
  private int onDoCodecAsync(int paramInt1, int paramInt2)
  {
    if (!jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "NOT in async mode.");
      }
      return -1;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, "hardware coders exit, return.");
          }
          return 2;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, "InputData pendingInputBuffers exist, size:" + this.jdField_a_of_type_JavaUtilList.size());
        }
        AndroidCodec.InputBufferData localInputBufferData = (AndroidCodec.InputBufferData)this.jdField_a_of_type_JavaUtilList.get(0);
        if (localInputBufferData == null) {
          return 2;
        }
        if (localInputBufferData.jdField_a_of_type_JavaNioByteBuffer == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, "inputbuffer null, return");
          }
          return -1;
        }
        if (localInputBufferData.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, "curr buffer is being processed by other thread, return");
          }
          return 2;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          paramInt1 = writeInputData(localInputBufferData.jdField_a_of_type_JavaNioByteBuffer, false);
          if (paramInt1 <= 0) {
            break label361;
          }
          this.jdField_b_of_type_Long += this.jdField_g_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(0);
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(System.currentTimeMillis()));
            this.jdField_c_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(paramInt2));
          }
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localInputBufferData.jdField_a_of_type_Int, paramInt1, this.jdField_b_of_type_Long, 0);
          return 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "call writeInputData2 in onDoCodec");
      }
      paramInt1 = writeInputData2(((AndroidCodec.InputBufferData)localObject).jdField_a_of_type_JavaNioByteBuffer, this.jdField_e_of_type_Int, false);
    }
    for (;;)
    {
      return 0;
      label361:
      do
      {
        return -1;
        return 2;
        if (paramInt1 == 0) {
          break;
        }
      } while (paramInt1 != -1);
    }
  }
  
  public static native boolean putByteArray2ByteBuffer(ByteBuffer paramByteBuffer, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private void setParameters(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramString == null);
        if (!paramString.equalsIgnoreCase("frame-rate")) {
          break;
        }
      } while (paramInt <= 0);
      this.jdField_f_of_type_Int = paramInt;
      this.jdField_g_of_type_Int = (1000000 / this.jdField_f_of_type_Int);
      b();
      QLog.e("AndroidCodec", 2, "HWENC setParameters mFrameRate =" + this.jdField_f_of_type_Int);
    } while (Build.VERSION.SDK_INT < 19);
    Bundle localBundle = new Bundle();
    localBundle.putInt(paramString, paramInt);
    this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localBundle);
  }
  
  public static native void set_device_infos(String paramString);
  
  void a()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec == null) {}
    for (;;)
    {
      Object localObject;
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      try
      {
        List localList = AndroidCodec.b(this.jdField_a_of_type_JavaLangString);
        this.jdField_e_of_type_Int = 21;
        m = 0;
        if (m >= localList.size()) {
          break label449;
        }
        localObject = AndroidCodec.a((MediaCodecInfo)localList.get(m), AndroidCodec.jdField_a_of_type_JavaLangString);
        if (ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21))
        {
          this.jdField_e_of_type_Int = 21;
          i1 = m;
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = new AndroidCodec();
          localObject = MediaFormat.createVideoFormat(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
          ((MediaFormat)localObject).setInteger("color-format", this.jdField_e_of_type_Int);
          ((MediaFormat)localObject).setInteger("frame-rate", this.jdField_f_of_type_Int);
          ((MediaFormat)localObject).setInteger("bitrate", this.jdField_h_of_type_Int);
          m = 30;
          if (this.jdField_f_of_type_Int * 30 > 255) {
            m = 255 / this.jdField_f_of_type_Int;
          }
          QLog.e("AndroidCodec", 2, "KEY_I_FRAME_INTERVAL =" + m + ", mFrameRate = " + this.jdField_f_of_type_Int);
          if (Build.VERSION.SDK_INT >= 19) {
            break label321;
          }
          ((MediaFormat)localObject).setInteger("i-frame-interval", m);
          localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)localList.get(i1), this.jdField_a_of_type_JavaLangString);
          m = 16;
          if (i2 >= localCodecCapabilities.profileLevels.length) {
            break label388;
          }
        }
        switch (localCodecCapabilities.profileLevels[i2].profile)
        {
        case 1: 
          if (ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19))
          {
            this.jdField_e_of_type_Int = 19;
            i1 = m;
            continue;
            return;
          }
          break;
        }
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
      }
      m += 1;
      continue;
      label321:
      ((MediaFormat)localObject).setInteger("i-frame-interval", m);
      continue;
      ((MediaFormat)localObject).setInteger("profile", 1);
      int n = m;
      if (m < localCodecCapabilities.profileLevels[i2].level) {
        n = localCodecCapabilities.profileLevels[i2].level;
      }
      ((MediaFormat)localObject).setInteger("level", n);
      int m = n;
      break label455;
      label388:
      this.jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)localObject);
      if (this.jdField_f_of_type_Int > 0) {}
      for (this.jdField_g_of_type_Int = (1000000 / this.jdField_f_of_type_Int);; this.jdField_g_of_type_Int = 40000)
      {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(this.jdField_a_of_type_AndroidMediaMediaFormat, ((MediaCodecInfo)localException.get(i1)).getName(), this);
        return;
      }
      label449:
      int i1 = 0;
      continue;
      label455:
      i2 += 1;
    }
  }
  
  void a(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      Object localObject = (Long)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AndroidCodec", 2, this.jdField_b_of_type_JavaLangString + " small, " + paramBufferInfo.presentationTimeUs + "      takes:" + (System.currentTimeMillis() - ((Long)localObject).longValue()));
        }
        this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
      localObject = (Integer)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        Long localLong = (Long)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localLong != null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AndroidCodec", 2, this.jdField_b_of_type_JavaLangString + " big  , " + paramBufferInfo.presentationTimeUs + "      takes:" + (System.currentTimeMillis() - localLong.longValue()));
          }
          this.jdField_b_of_type_JavaUtilMap.remove(localObject);
        }
        this.jdField_c_of_type_JavaUtilMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  public native boolean attachCodec(Object paramObject);
  
  public native void detachCodec();
  
  public void onError(MediaCodec paramMediaCodec, Exception paramException)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "codec exit, return onError");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AndroidCodec", 2, "onError", paramException);
  }
  
  /* Error */
  public void onInputBufferAvailable(MediaCodec arg1, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: getfield 213	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   10: iload_2
    //   11: invokevirtual 544	com/tencent/av/mediacodec/AndroidCodec:a	(I)Ljava/nio/ByteBuffer;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +36 -> 52
    //   19: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +29 -> 51
    //   25: ldc 23
    //   27: iconst_2
    //   28: new 181	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 546
    //   38: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_2
    //   42: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: return
    //   52: iload 7
    //   54: istore 5
    //   56: aload_0
    //   57: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   60: astore_1
    //   61: iload 7
    //   63: istore 5
    //   65: aload_1
    //   66: monitorenter
    //   67: aload_0
    //   68: getfield 105	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   71: invokevirtual 473	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   74: ifeq +71 -> 145
    //   77: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +12 -> 92
    //   83: ldc 23
    //   85: iconst_2
    //   86: ldc_w 548
    //   89: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_1
    //   93: monitorexit
    //   94: aload_0
    //   95: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   98: astore_1
    //   99: aload_1
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   105: iconst_0
    //   106: invokeinterface 278 2 0
    //   111: checkcast 479	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   114: iconst_0
    //   115: putfield 483	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Boolean	Z
    //   118: aload_1
    //   119: monitorexit
    //   120: return
    //   121: astore_3
    //   122: aload_1
    //   123: monitorexit
    //   124: aload_3
    //   125: athrow
    //   126: astore_3
    //   127: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq -12 -> 118
    //   133: ldc 23
    //   135: iconst_2
    //   136: ldc_w 550
    //   139: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: goto -24 -> 118
    //   145: aload_0
    //   146: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   149: new 479	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   152: dup
    //   153: aload_3
    //   154: iload_2
    //   155: invokespecial 553	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:<init>	(Ljava/nio/ByteBuffer;I)V
    //   158: invokeinterface 556 2 0
    //   163: pop
    //   164: aload_0
    //   165: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   168: iconst_0
    //   169: invokeinterface 278 2 0
    //   174: checkcast 479	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   177: iconst_1
    //   178: putfield 483	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Boolean	Z
    //   181: aload_1
    //   182: monitorexit
    //   183: iload 7
    //   185: istore 5
    //   187: aload_0
    //   188: getfield 126	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_Boolean	Z
    //   191: ifeq +257 -> 448
    //   194: iload 7
    //   196: istore 5
    //   198: aload_0
    //   199: aload_0
    //   200: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   203: iconst_0
    //   204: invokeinterface 278 2 0
    //   209: checkcast 479	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   212: getfield 480	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   215: iconst_1
    //   216: invokevirtual 406	com/tencent/av/mediacodec/NativeCodec:writeInputData	(Ljava/nio/ByteBuffer;Z)I
    //   219: istore_2
    //   220: iload_2
    //   221: ifle +126 -> 347
    //   224: iload_2
    //   225: istore 5
    //   227: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +32 -> 262
    //   233: iload_2
    //   234: istore 5
    //   236: ldc 23
    //   238: iconst_2
    //   239: new 181	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 558
    //   249: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload_2
    //   253: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: iload_2
    //   263: istore 5
    //   265: aload_0
    //   266: aload_0
    //   267: getfield 78	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   270: aload_0
    //   271: getfield 93	com/tencent/av/mediacodec/NativeCodec:jdField_g_of_type_Int	I
    //   274: i2l
    //   275: ladd
    //   276: putfield 78	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   279: iload_2
    //   280: istore 5
    //   282: aload_0
    //   283: getfield 107	com/tencent/av/mediacodec/NativeCodec:jdField_c_of_type_Boolean	Z
    //   286: ifeq +29 -> 315
    //   289: iload_2
    //   290: istore 5
    //   292: aload_0
    //   293: getfield 109	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   296: aload_0
    //   297: getfield 78	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   300: invokestatic 368	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   303: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   306: invokestatic 368	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   309: invokeinterface 372 3 0
    //   314: pop
    //   315: iload_2
    //   316: istore 5
    //   318: aload_0
    //   319: getfield 213	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_ComTencentAvMediacodecAndroidCodec	Lcom/tencent/av/mediacodec/AndroidCodec;
    //   322: aload_0
    //   323: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   326: iconst_0
    //   327: invokeinterface 278 2 0
    //   332: checkcast 479	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   335: getfield 489	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Int	I
    //   338: iload_2
    //   339: aload_0
    //   340: getfield 78	com/tencent/av/mediacodec/NativeCodec:jdField_b_of_type_Long	J
    //   343: iconst_0
    //   344: invokevirtual 425	com/tencent/av/mediacodec/AndroidCodec:a	(IIJI)V
    //   347: aload_0
    //   348: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   351: astore_1
    //   352: aload_1
    //   353: monitorenter
    //   354: aload_0
    //   355: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   358: iconst_0
    //   359: invokeinterface 278 2 0
    //   364: checkcast 479	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   367: iconst_0
    //   368: putfield 483	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Boolean	Z
    //   371: iload_2
    //   372: ifle +14 -> 386
    //   375: aload_0
    //   376: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   379: iconst_0
    //   380: invokeinterface 488 2 0
    //   385: pop
    //   386: aload_1
    //   387: monitorexit
    //   388: return
    //   389: astore_3
    //   390: aload_1
    //   391: monitorexit
    //   392: aload_3
    //   393: athrow
    //   394: astore_3
    //   395: aload_1
    //   396: monitorexit
    //   397: iload 7
    //   399: istore 5
    //   401: aload_3
    //   402: athrow
    //   403: astore_3
    //   404: aload_0
    //   405: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   408: astore_1
    //   409: aload_1
    //   410: monitorenter
    //   411: aload_0
    //   412: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   415: iconst_0
    //   416: invokeinterface 278 2 0
    //   421: checkcast 479	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   424: iconst_0
    //   425: putfield 483	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_Boolean	Z
    //   428: iload 5
    //   430: ifle +14 -> 444
    //   433: aload_0
    //   434: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   437: iconst_0
    //   438: invokeinterface 488 2 0
    //   443: pop
    //   444: aload_1
    //   445: monitorexit
    //   446: aload_3
    //   447: athrow
    //   448: iload 7
    //   450: istore 5
    //   452: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +16 -> 471
    //   458: iload 7
    //   460: istore 5
    //   462: ldc 23
    //   464: iconst_2
    //   465: ldc_w 560
    //   468: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: iload 7
    //   473: istore 5
    //   475: aload_0
    //   476: aload_0
    //   477: getfield 98	com/tencent/av/mediacodec/NativeCodec:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   480: iconst_0
    //   481: invokeinterface 278 2 0
    //   486: checkcast 479	com/tencent/av/mediacodec/AndroidCodec$InputBufferData
    //   489: getfield 480	com/tencent/av/mediacodec/AndroidCodec$InputBufferData:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   492: aload_0
    //   493: getfield 417	com/tencent/av/mediacodec/NativeCodec:jdField_e_of_type_Int	I
    //   496: iconst_1
    //   497: invokevirtual 421	com/tencent/av/mediacodec/NativeCodec:writeInputData2	(Ljava/nio/ByteBuffer;IZ)I
    //   500: istore_2
    //   501: goto -281 -> 220
    //   504: astore_1
    //   505: iload 6
    //   507: istore_2
    //   508: iload 7
    //   510: istore 5
    //   512: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   515: ifeq -295 -> 220
    //   518: iload 7
    //   520: istore 5
    //   522: ldc 23
    //   524: iconst_2
    //   525: ldc_w 562
    //   528: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: iload 6
    //   533: istore_2
    //   534: goto -314 -> 220
    //   537: astore_1
    //   538: iload_2
    //   539: istore 5
    //   541: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq -197 -> 347
    //   547: iload_2
    //   548: istore 5
    //   550: ldc 23
    //   552: iconst_2
    //   553: ldc_w 564
    //   556: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: goto -212 -> 347
    //   562: astore_3
    //   563: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq -180 -> 386
    //   569: ldc 23
    //   571: iconst_2
    //   572: ldc_w 550
    //   575: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: goto -192 -> 386
    //   581: astore 4
    //   583: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq -142 -> 444
    //   589: ldc 23
    //   591: iconst_2
    //   592: ldc_w 550
    //   595: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: goto -154 -> 444
    //   601: astore_3
    //   602: aload_1
    //   603: monitorexit
    //   604: aload_3
    //   605: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	NativeCodec
    //   0	606	2	paramInt	int
    //   14	2	3	localByteBuffer	ByteBuffer
    //   121	4	3	localObject1	Object
    //   126	28	3	localException1	Exception
    //   389	4	3	localObject2	Object
    //   394	8	3	localObject3	Object
    //   403	44	3	localObject4	Object
    //   562	1	3	localException2	Exception
    //   601	4	3	localObject5	Object
    //   581	1	4	localException3	Exception
    //   54	495	5	m	int
    //   4	528	6	n	int
    //   1	518	7	i1	int
    // Exception table:
    //   from	to	target	type
    //   101	118	121	finally
    //   118	120	121	finally
    //   122	124	121	finally
    //   127	142	121	finally
    //   101	118	126	java/lang/Exception
    //   354	371	389	finally
    //   375	386	389	finally
    //   386	388	389	finally
    //   390	392	389	finally
    //   563	578	389	finally
    //   67	92	394	finally
    //   92	94	394	finally
    //   145	183	394	finally
    //   395	397	394	finally
    //   56	61	403	finally
    //   65	67	403	finally
    //   187	194	403	finally
    //   198	220	403	finally
    //   227	233	403	finally
    //   236	262	403	finally
    //   265	279	403	finally
    //   282	289	403	finally
    //   292	315	403	finally
    //   318	347	403	finally
    //   401	403	403	finally
    //   452	458	403	finally
    //   462	471	403	finally
    //   475	501	403	finally
    //   512	518	403	finally
    //   522	531	403	finally
    //   541	547	403	finally
    //   550	559	403	finally
    //   187	194	504	java/lang/Exception
    //   198	220	504	java/lang/Exception
    //   452	458	504	java/lang/Exception
    //   462	471	504	java/lang/Exception
    //   475	501	504	java/lang/Exception
    //   318	347	537	java/lang/Exception
    //   354	371	562	java/lang/Exception
    //   375	386	562	java/lang/Exception
    //   411	428	581	java/lang/Exception
    //   433	444	581	java/lang/Exception
    //   411	428	601	finally
    //   433	444	601	finally
    //   444	446	601	finally
    //   583	598	601	finally
    //   602	604	601	finally
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "codec exit, return onOutputBufferAvailable");
      }
    }
    do
    {
      return;
      paramMediaCodec = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.b(paramInt);
    } while ((paramMediaCodec == null) || (paramBufferInfo == null));
    if (this.jdField_a_of_type_Boolean)
    {
      MediaFormat localMediaFormat = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(paramInt);
      if (localMediaFormat != null)
      {
        a(false, paramBufferInfo);
        a(paramMediaCodec, paramBufferInfo.size, localMediaFormat);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(paramInt);
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("AndroidCodec", 2, "getOutputFormat null");
        continue;
        if (paramBufferInfo.flags == 1) {}
        a(false, paramBufferInfo);
        readOutputStream(paramMediaCodec, paramBufferInfo.presentationTimeUs, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags);
      }
    }
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (QLog.isColorLevel()) {
        QLog.e("AndroidCodec", 2, "codec exit, return onOutputFormatChanged");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AndroidCodec", 2, "onOutputFormatChanged");
  }
  
  public native int readOutputData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public native int readOutputDataEx(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public native int readOutputStream(ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAVCParams(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  void setParams_impl()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AndroidCodec", 2, "setParams_impl");
    }
    Bundle localBundle;
    if (this.jdField_d_of_type_Boolean)
    {
      localBundle = new Bundle();
      localBundle.putInt(AndroidCodec.jdField_b_of_type_JavaLangString, 1);
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_i_of_type_Int > 0) {
        localBundle.putInt("bitrate", this.jdField_i_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localBundle);
      this.jdField_i_of_type_Int = 0;
    }
    if (this.jdField_i_of_type_Int > 0)
    {
      localBundle = new Bundle();
      localBundle.putInt("bitrate", this.jdField_i_of_type_Int);
      if (this.jdField_d_of_type_Boolean == true) {
        localBundle.putInt(AndroidCodec.jdField_b_of_type_JavaLangString, 1);
      }
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localBundle);
      this.jdField_i_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public native int writeInputData(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public native int writeInputData2(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\mediacodec\NativeCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */