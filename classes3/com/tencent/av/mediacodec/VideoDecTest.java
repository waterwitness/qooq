package com.tencent.av.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoDecTest
  implements IMediaCodecCallback, Runnable
{
  static final String jdField_a_of_type_JavaLangString = VideoDecTest.class.getSimpleName();
  static final String jdField_b_of_type_JavaLangString = "crop-left";
  static final String jdField_c_of_type_JavaLangString = "crop-top";
  static final String jdField_d_of_type_JavaLangString = "crop-right";
  static final String jdField_e_of_type_JavaLangString = "crop-bottom";
  static final String jdField_f_of_type_JavaLangString = "stride";
  static final String g = "slice-height";
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  AndroidCodec jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = null;
  VideoDecTest.PlayerCallback jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback;
  Thread jdField_a_of_type_JavaLangThread;
  Map jdField_a_of_type_JavaUtilMap = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = -1L;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  boolean jdField_c_of_type_Boolean = false;
  boolean jdField_d_of_type_Boolean;
  boolean jdField_e_of_type_Boolean;
  private volatile boolean jdField_f_of_type_Boolean;
  String h;
  String i = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VideoDecTest(String paramString, boolean paramBoolean, VideoDecTest.PlayerCallback paramPlayerCallback)
  {
    this.d = false;
    this.e = false;
    this.h = paramString;
    this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback = paramPlayerCallback;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private static int a(MediaExtractor paramMediaExtractor)
  {
    int k = paramMediaExtractor.getTrackCount();
    int j = 0;
    while (j < k)
    {
      if (paramMediaExtractor.getTrackFormat(j).getString("mime").startsWith("video/")) {
        return j;
      }
      j += 1;
    }
    return -1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangThread == null) || (!this.jdField_a_of_type_JavaLangThread.isAlive()))
    {
      this.jdField_a_of_type_JavaLangThread = new Thread(this, "Movie Player");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    if ((paramInt1 != 0) && (this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback != null)) {
      this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback.a(paramInt1, paramString, paramInt2, paramInt3);
    }
  }
  
  public int b()
  {
    if ((a() == 0) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      return 0;
    }
    return a();
  }
  
  public void b()
  {
    this.f = true;
  }
  
  void c()
  {
    if (this.e) {
      if ((this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback != null) && (a() == 0)) {
        this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback.a(b(), this.i, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.d();
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.e();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onError(MediaCodec paramMediaCodec, Exception paramException) {}
  
  public void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
  {
    if (this.d) {}
    do
    {
      return;
      paramMediaCodec = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(paramInt);
      if (paramMediaCodec != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "getInputBuffer null, index:" + paramInt);
    return;
    int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(paramMediaCodec, 0);
    if (j < 0)
    {
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(paramInt, 0, 0L, 4);
      this.d = true;
      if (QLog.isDevelopLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 4, "sent input EOS");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      return;
      long l = this.jdField_c_of_type_Long * 30000L;
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), Long.valueOf(System.currentTimeMillis()));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "put,key:" + l + ", value:" + this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l)));
      }
      this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(paramInt, j, l, 0);
      this.jdField_c_of_type_Long += 1L;
    }
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.e) {
      return;
    }
    paramMediaCodec = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.b(paramInt);
    label203:
    int i3;
    int i2;
    int n;
    int i5;
    int i4;
    int m;
    int i7;
    int j;
    int i1;
    if ((paramMediaCodec != null) && (paramBufferInfo != null))
    {
      Object localObject;
      if ((paramBufferInfo.flags & 0x4) != 0)
      {
        this.e = true;
        localObject = (Long)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
        if (localObject == null) {
          break label203;
        }
        this.jdField_b_of_type_Long = (System.currentTimeMillis() - ((Long)localObject).longValue());
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "get, key:" + paramBufferInfo.presentationTimeUs + ", value:" + localObject + ", delay:" + this.jdField_b_of_type_Long);
        }
      }
      while (paramInt >= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(paramInt);
        if (localObject != null)
        {
          this.jdField_c_of_type_Int = ((MediaFormat)localObject).getInteger("color-format");
          if (!DeviceCheck.a(this.jdField_c_of_type_Int))
          {
            a(-6, this.i, this.jdField_c_of_type_Int, -1);
            this.jdField_a_of_type_Boolean = false;
            c();
            return;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "get FAIL, key:" + paramBufferInfo.presentationTimeUs);
            }
          }
          else
          {
            this.jdField_a_of_type_Boolean = true;
          }
        }
        else if ((!this.e) && (paramMediaCodec != null) && (localObject != null))
        {
          i3 = ((MediaFormat)localObject).getInteger("width");
          i2 = ((MediaFormat)localObject).getInteger("height");
          n = ((MediaFormat)localObject).getInteger("crop-left");
          i5 = ((MediaFormat)localObject).getInteger("crop-right");
          int i6 = ((MediaFormat)localObject).getInteger("crop-top");
          i4 = ((MediaFormat)localObject).getInteger("crop-bottom");
          m = ((MediaFormat)localObject).getInteger("stride");
          k = ((MediaFormat)localObject).getInteger("slice-height");
          i7 = ((MediaFormat)localObject).getInteger("color-format");
          j = k;
          if (k < i2) {
            j = i2;
          }
          k = m;
          if (m < i3) {
            k = i3;
          }
          i1 = j;
          m = i6;
          if (i7 == 2130706688)
          {
            i1 = j - i6 / 2;
            m = 0;
            n = 0;
          }
          j = k;
          if (k < i3) {
            j = i3;
          }
          if (((2141391876 != i7) && (2130706433 != i7) && (2130706944 != i7)) || (i2 >= i1)) {
            break label737;
          }
        }
      }
    }
    label730:
    label737:
    for (int k = i1;; k = i2)
    {
      if (n + i5 + m + i4 == 0)
      {
        n = 0;
        i1 = i3 - 1;
        i2 -= 1;
        m = 0;
        if ((j <= 0) || (k <= 0) || (i1 <= 0) || (i2 <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "error decoderInfomations.");
          }
          a(-7, this.i, i7, -1);
          c();
        }
      }
      else
      {
        i3 = i5 - n + 1;
        i2 = i4 - m + 1;
        i1 = j;
        if (j < i3) {
          i1 = i3;
        }
        if (k >= i2) {
          break label730;
        }
      }
      for (j = i2;; j = k)
      {
        k = j;
        j = i1;
        i1 = i5;
        i2 = i4;
        break;
        try
        {
          GraphicRenderMgr.getInstance();
          i3 = paramBufferInfo.size;
          i4 = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i4 + 1);
          j = GraphicRenderMgr.checkhwyuv(paramMediaCodec, i3, j, k, n, i1, m, i2, i7, i4);
          if (j != 0)
          {
            a(-8, this.i, i7, j);
            this.jdField_b_of_type_Boolean = false;
            c();
            return;
          }
        }
        catch (Exception paramMediaCodec)
        {
          a(-10, this.i, i7, 0);
          this.jdField_b_of_type_Boolean = false;
          c();
          return;
        }
        this.jdField_b_of_type_Boolean = true;
        if (paramMediaCodec != null) {
          this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(paramInt);
        }
        c();
        return;
      }
    }
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec = new AndroidCodec();
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    Object localObject2;
    Object localObject3;
    label182:
    label378:
    label396:
    do
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.h);
        j = a(this.jdField_a_of_type_AndroidMediaMediaExtractor);
        if (j < 0)
        {
          a(-2, this.i, this.jdField_c_of_type_Int, -1);
          return;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        a(-1, this.i, this.jdField_c_of_type_Int, -1);
        return;
      }
      this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(j);
      MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(j);
      localObject2 = localMediaFormat.getString("mime");
      localObject3 = AndroidCodec.a((String)localObject2);
      j = 0;
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      if (j < ((List)localObject3).size())
      {
        this.i = ((MediaCodecInfo)((List)localObject3).get(j)).getName();
        localCodecCapabilities = AndroidCodec.a((MediaCodecInfo)((List)localObject3).get(j), (String)localObject2);
        if (ArrayUtils.a(localCodecCapabilities.colorFormats, 19)) {
          this.jdField_c_of_type_Int = 19;
        }
      }
      else
      {
        if (this.jdField_c_of_type_Int == 0)
        {
          this.i = ((MediaCodecInfo)((List)localObject3).get(0)).getName();
          localObject2 = AndroidCodec.a((MediaCodecInfo)((List)localObject3).get(0), (String)localObject2);
          if ((((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats != null) && (((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length > 0)) {
            this.jdField_c_of_type_Int = localObject2.colorFormats[0];
          }
        }
        localMediaFormat.setInteger("color-format", this.jdField_c_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "useAsyncMode:" + this.jdField_c_of_type_Boolean);
        }
        if (!this.jdField_c_of_type_Boolean) {
          break label378;
        }
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      for (boolean bool = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localMediaFormat, this.i, this);; bool = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localMediaFormat, this.i, null))
      {
        if (bool) {
          break label396;
        }
        a(-3, this.i, this.jdField_c_of_type_Int, -1);
        return;
        if (ArrayUtils.a(localCodecCapabilities.colorFormats, 21))
        {
          this.jdField_c_of_type_Int = 21;
          break label182;
        }
        j += 1;
        break;
      }
      try
      {
        bool = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
        if (!bool)
        {
          a(-4, this.i, this.jdField_c_of_type_Int, -1);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          bool = false;
        }
      }
    } while (this.jdField_c_of_type_Boolean);
    int m = 0;
    int i2 = 0;
    long l2 = 0L;
    int n = 0;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    long l1 = l2;
    int j = m;
    int i1 = n;
    int k = i2;
    if (k == 0) {}
    for (;;)
    {
      try
      {
        if (this.f) {
          break;
        }
        if (j != 0) {
          break label1260;
        }
        localBufferData1 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
        m = 0;
        localObject2 = localBufferData1;
        if (localBufferData1 == null) {
          localObject3 = localBufferData1;
        }
      }
      catch (Exception localException4)
      {
        AndroidCodec.BufferData localBufferData1;
        label545:
        Object localObject1;
        localException4.printStackTrace();
        a(-9, this.i, this.jdField_c_of_type_Int, -1);
        continue;
        m = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(((AndroidCodec.BufferData)localObject2).jdField_a_of_type_JavaNioByteBuffer, 0);
        if (m >= 0) {
          break label850;
        }
      }
      try
      {
        Thread.sleep(50L);
        localObject3 = localBufferData1;
        localObject2 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a();
        n = m + 1;
        if (localObject2 == null) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      if (localObject2 != null) {
        continue;
      }
      if ((this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback != null) && (a() == 0)) {
        this.jdField_a_of_type_ComTencentAvMediacodecVideoDecTest$PlayerCallback.a(b(), this.i, this.jdField_c_of_type_Int, this.jdField_b_of_type_Long);
      }
      try
      {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.d();
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.e();
        this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        return;
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        return;
      }
      m = n;
      localObject1 = localObject2;
      if (n > 8)
      {
        localObject3 = localObject2;
        a(-5, this.i, this.jdField_c_of_type_Int, -1);
      }
    }
    this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject2).jdField_a_of_type_Int, 0, 0L, 4);
    j = 1;
    label737:
    AndroidCodec.BufferData localBufferData2;
    label785:
    label850:
    label879:
    label884:
    int i6;
    int i5;
    int i3;
    int i8;
    int i7;
    int i10;
    label1035:
    int i4;
    if (QLog.isDevelopLevel())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 4, "sent input EOS");
      for (;;)
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
        i2 = k;
        n = i1;
        l2 = l1;
        m = j;
        if (k != 0) {
          break;
        }
        localBufferData2 = this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.b();
        if (localBufferData2 == null) {
          break label1250;
        }
        if ((localBufferData2.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
          break label1247;
        }
        k = 1;
        m = i1;
        if (localBufferData2.jdField_a_of_type_Int < 0) {
          break label1194;
        }
        if (localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat == null) {
          break label884;
        }
        this.jdField_c_of_type_Int = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("color-format");
        if (DeviceCheck.a(this.jdField_c_of_type_Int)) {
          break label879;
        }
        a(-6, this.i, this.jdField_c_of_type_Int, -1);
        this.jdField_a_of_type_Boolean = false;
        break label545;
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(((AndroidCodec.BufferData)localObject2).jdField_a_of_type_Int, m, 30000L * l1, 0);
        l1 += 1L;
      }
      this.jdField_a_of_type_Boolean = true;
      m = i1;
      if (k == 0)
      {
        m = i1;
        if (localBufferData2.jdField_a_of_type_JavaNioByteBuffer != null)
        {
          m = i1;
          if (localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat != null)
          {
            i6 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("width");
            i5 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("height");
            i3 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("crop-left");
            i8 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("crop-right");
            int i9 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("crop-top");
            i7 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("crop-bottom");
            i2 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("stride");
            n = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("slice-height");
            i10 = localBufferData2.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("color-format");
            m = n;
            if (n >= i5) {
              break label1263;
            }
            m = i5;
            break label1263;
            i4 = m;
            i2 = i9;
            if (i10 != 2130706688) {
              break label1281;
            }
            i4 = m - i9 / 2;
            i2 = 0;
            i3 = 0;
            break label1281;
          }
        }
      }
    }
    label1101:
    label1194:
    label1218:
    label1233:
    label1247:
    label1250:
    label1260:
    label1263:
    label1281:
    label1331:
    label1430:
    label1447:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "error decoderInfomations.");
      }
      a(-7, this.i, i10, -1);
      break label545;
      if (this.jdField_b_of_type_Long == -1L) {
        this.jdField_b_of_type_Long = ((l1 - 1L) * 30L);
      }
      m = GraphicRenderMgr.checkhwyuv(localBufferData2.jdField_a_of_type_JavaNioByteBuffer, localBufferData2.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size, m, n, i3, i4, i2, i5, i10, i1);
      if (m != 0)
      {
        a(-8, this.i, i10, m);
        this.jdField_b_of_type_Boolean = false;
        break label545;
      }
      this.jdField_b_of_type_Boolean = true;
      m = i1 + 1;
      if (localBufferData2.jdField_a_of_type_JavaNioByteBuffer != null) {
        this.jdField_a_of_type_ComTencentAvMediacodecAndroidCodec.a(localBufferData2.jdField_a_of_type_Int);
      }
      try
      {
        Thread.sleep(30L);
        i1 = m;
      }
      catch (InterruptedException localInterruptedException2)
      {
        for (;;)
        {
          localInterruptedException2.printStackTrace();
        }
      }
      m = n;
      break label1430;
      do
      {
        n = i5;
        break label1331;
        break label785;
        m = i1;
        break label1218;
        break;
        break label737;
        n = i2;
        if (i2 >= i6) {
          break label1035;
        }
        n = i6;
        break label1035;
        m = n;
        if (n < i6) {
          m = i6;
        }
      } while (((2141391876 != i10) && (2130706433 != i10) && (2130706944 != i10)) || (i5 >= i4));
      n = i4;
      if (i3 + i8 + i2 + i7 == 0)
      {
        i3 = 0;
        i4 = i6 - 1;
        i5 -= 1;
        i2 = 0;
      }
      for (;;)
      {
        if ((m <= 0) || (n <= 0) || (i4 <= 0)) {
          break label1447;
        }
        if (i5 > 0) {
          break label1101;
        }
        break;
        i6 = i8 - i3 + 1;
        i5 = i7 - i2 + 1;
        i4 = m;
        if (m < i6) {
          i4 = i6;
        }
        if (n >= i5) {
          break label1233;
        }
        m = i5;
        n = m;
        m = i4;
        i4 = i8;
        i5 = i7;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\mediacodec\VideoDecTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */