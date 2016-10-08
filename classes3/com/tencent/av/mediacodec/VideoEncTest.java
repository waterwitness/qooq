package com.tencent.av.mediacodec;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.List;

public class VideoEncTest
  implements Runnable
{
  static final String jdField_a_of_type_JavaLangString = VideoEncTest.class.getSimpleName();
  int jdField_a_of_type_Int;
  VideoEncTest.PlayerCallback jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback;
  Thread jdField_a_of_type_JavaLangThread;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VideoEncTest(String paramString, boolean paramBoolean, VideoEncTest.PlayerCallback paramPlayerCallback)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback = paramPlayerCallback;
    this.jdField_a_of_type_Boolean = paramBoolean;
    AndroidCodec.b();
    paramString = BaseApplicationImpl.getContext();
    paramPlayerCallback = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "MODEL=" + Build.MODEL.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "SDK=" + Build.VERSION.SDK_INT + ";";
    paramPlayerCallback = paramPlayerCallback + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
    paramPlayerCallback = paramPlayerCallback + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
    paramString = paramString.getApplicationInfo();
    paramPlayerCallback = paramPlayerCallback + "DATADIR=" + paramString.dataDir + ";";
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramString = paramPlayerCallback + "LIBDIR=" + paramString.nativeLibraryDir + ";";; paramString = paramPlayerCallback + "LIBDIR=" + paramString.dataDir + "/lib" + ";")
    {
      this.jdField_a_of_type_Int = QuaCreate(paramString);
      return;
    }
  }
  
  public static native void QuaClose(int paramInt);
  
  public static native int QuaCreate(String paramString);
  
  public static native int Quacaculatessim(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static int a(InputStream paramInputStream, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramInputStream == null) {}
    for (;;)
    {
      return 0;
      try
      {
        if (paramInputStream.read(paramArrayOfByte1, 0, paramInt) != -1)
        {
          System.out.write(paramArrayOfByte1, 0, paramInt);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "read file to byte write 0");
          }
          if (paramInputStream.read(paramArrayOfByte2, 0, paramInt) == -1) {
            break label107;
          }
          System.out.write(paramArrayOfByte2, 0, paramInt);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "read file to byte write 1");
          }
        }
        try
        {
          paramInputStream.close();
          return 1;
          try
          {
            paramInputStream.close();
            return 0;
          }
          catch (IOException paramInputStream) {}
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "close input stream error!!!", paramInputStream);
            return 0;
            try
            {
              label107:
              paramInputStream.close();
              return 0;
            }
            catch (IOException paramInputStream) {}
            if (QLog.isColorLevel())
            {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "close input stream error!!!", paramInputStream);
              return 0;
            }
          }
        }
        catch (IOException paramInputStream)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "close input stream error!!!", paramInputStream);
            }
          }
        }
      }
      catch (Exception paramArrayOfByte1)
      {
        paramArrayOfByte1 = paramArrayOfByte1;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "read input stream error!!!", paramArrayOfByte1);
        }
        try
        {
          paramInputStream.close();
          return 0;
        }
        catch (IOException paramInputStream) {}
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "close input stream error!!!", paramInputStream);
          return 0;
        }
      }
      finally {}
    }
    try
    {
      paramInputStream.close();
      throw paramArrayOfByte1;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "close input stream error!!!", paramInputStream);
        }
      }
    }
  }
  
  static void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    int k = paramInt1 / 2;
    int m = paramInt2 / 2;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 0, paramInt1 * paramInt2);
    int i = 0;
    int j;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        paramArrayOfByte3[(paramInt1 * paramInt2 + i * paramInt1 + j * 2)] = paramArrayOfByte1[(paramInt1 * paramInt2 + i * k + j)];
        paramArrayOfByte3[(paramInt1 * paramInt2 + i * paramInt1 + j * 2 + 1)] = paramArrayOfByte1[(paramInt1 * paramInt2 * 5 / 4 + i * k + j)];
        j += 1;
      }
      i += 1;
    }
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte4, 0, paramInt1 * paramInt2);
    i = 0;
    while (i < m)
    {
      j = 0;
      while (j < k)
      {
        paramArrayOfByte4[(paramInt1 * paramInt2 + i * paramInt1 + j * 2)] = paramArrayOfByte2[(paramInt1 * paramInt2 + i * k + j)];
        paramArrayOfByte4[(paramInt1 * paramInt2 + i * paramInt1 + j * 2 + 1)] = paramArrayOfByte2[(paramInt1 * paramInt2 * 5 / 4 + i * k + j)];
        j += 1;
      }
      i += 1;
    }
  }
  
  public static boolean a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte;
    do
    {
      arrayOfByte = a(paramByteBuffer, true);
      if (arrayOfByte == null) {
        break;
      }
    } while ((arrayOfByte[0] & 0x1F) != 5);
    return true;
    return false;
  }
  
  static byte[] a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if (paramByteBuffer == null) {
      return null;
    }
    int m = paramByteBuffer.remaining();
    if (m <= 0) {
      return null;
    }
    int i = 0;
    while ((i < m) && (paramByteBuffer.get(i) == 0)) {
      i += 1;
    }
    if (i == m) {
      return null;
    }
    if ((i < 2) || (paramByteBuffer.get(i) != 1)) {
      return null;
    }
    int k = i + 1;
    i = k;
    int j;
    for (;;)
    {
      if ((i < m) && (paramByteBuffer.get(i) != 1))
      {
        i += 1;
      }
      else
      {
        if (i == m) {
          if (paramBoolean) {
            j = m + 2;
          }
        }
        do
        {
          i = j - 2;
          while (paramByteBuffer.get(i - 1) == 0) {
            i -= 1;
          }
          return null;
          if (paramByteBuffer.get(i - 1) != 0) {
            break;
          }
          j = i;
        } while (paramByteBuffer.get(i - 2) == 0);
        i += 1;
      }
    }
    i -= k;
    byte[] arrayOfByte = new byte[i];
    paramByteBuffer.position(k);
    paramByteBuffer.get(arrayOfByte, 0, i);
    if (j + 2 < m) {
      paramByteBuffer.position(j - 2);
    }
    for (;;)
    {
      return arrayOfByte;
      paramByteBuffer.position(paramByteBuffer.limit());
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangThread == null) || (!this.jdField_a_of_type_JavaLangThread.isAlive()))
    {
      this.jdField_a_of_type_JavaLangThread = new Thread(this, "Movie Player");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_b_of_type_Int = paramInt1;
    if ((paramInt1 != 0) && (this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback != null)) {
      this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback.a(paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
  }
  
  public int b()
  {
    return a();
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    QuaClose(this.jdField_a_of_type_Int);
  }
  
  public void run()
  {
    int i8 = 0;
    int i9 = -1;
    int i10 = -1;
    Object localObject5 = AndroidCodec.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "useAsyncMode:" + this.jdField_a_of_type_Boolean);
    }
    List localList = AndroidCodec.b((String)localObject5);
    int i = 0;
    int i3;
    label99:
    label177:
    int j;
    label603:
    int i1;
    int n;
    if (i < localList.size())
    {
      Object localObject3 = AndroidCodec.a((MediaCodecInfo)localList.get(i), (String)localObject5);
      if (ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject3).colorFormats, 21))
      {
        i3 = 21;
        if ((i3 == 19) || (i3 == 21)) {
          break label177;
        }
        a(-1, "", i3, 0, 0, -1, -1);
      }
      for (;;)
      {
        return;
        if ("OMX.IMG.TOPAZ.VIDEO.Encoder".equals(""))
        {
          i3 = 0;
          i = 0;
          break label99;
        }
        if (ArrayUtils.a(((MediaCodecInfo.CodecCapabilities)localObject3).colorFormats, 19))
        {
          i3 = 19;
          break label99;
        }
        i += 1;
        break;
        int i11 = 200;
        AndroidCodec localAndroidCodec = new AndroidCodec();
        localObject3 = MediaFormat.createVideoFormat((String)localObject5, 320, 240);
        ((MediaFormat)localObject3).setInteger("color-format", i3);
        ((MediaFormat)localObject3).setInteger("frame-rate", 10);
        ((MediaFormat)localObject3).setInteger("bitrate", 204800);
        ((MediaFormat)localObject3).setInteger("i-frame-interval", 300);
        localObject5 = AndroidCodec.a((MediaCodecInfo)localList.get(i), (String)localObject5);
        j = 16;
        int m = 0;
        int k;
        if (m < ((MediaCodecInfo.CodecCapabilities)localObject5).profileLevels.length)
        {
          switch (localObject5.profileLevels[m].profile)
          {
          }
          for (;;)
          {
            m += 1;
            break;
            ((MediaFormat)localObject3).setInteger("profile", 1);
            k = j;
            if (j < localObject5.profileLevels[m].level) {
              k = localObject5.profileLevels[m].level;
            }
            ((MediaFormat)localObject3).setInteger("level", k);
            j = k;
          }
        }
        String str = ((MediaCodecInfo)localList.get(i)).getName();
        if (!localAndroidCodec.a((MediaFormat)localObject3, str, null))
        {
          a(-3, str, i3, 0, 0, -1, -1);
          return;
        }
        int i12;
        int i13;
        long l2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        byte[][] arrayOfByte1;
        try
        {
          bool = localAndroidCodec.a();
          if (!bool)
          {
            a(-4, str, i3, 0, 0, -1, -1);
            return;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "Exception", localException1);
            }
            boolean bool = false;
          }
          i12 = 0;
          i13 = 0;
          l2 = 0L;
          i14 = 0;
          i15 = 0;
          i16 = 0;
          i17 = 0;
          i18 = 0;
          arrayOfByte1 = new byte[2][];
          arrayOfByte1[0] = null;
          arrayOfByte1[1] = null;
          arrayOfByte1[0] = new byte[115200];
          arrayOfByte1[1] = new byte[115200];
          try
          {
            a(new FileInputStream(new File(this.jdField_b_of_type_JavaLangString)), 115200, arrayOfByte1[0], arrayOfByte1[1]);
            if ((arrayOfByte1[0] != null) && (arrayOfByte1[1] != null)) {
              break label603;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed read file to byte fail");
            return;
          }
          catch (Exception localException2) {}
        }
        byte[][] arrayOfByte2;
        int i6;
        int i7;
        int i5;
        int i2;
        int i4;
        long l1;
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed read file to byte exception", localException2);
          return;
          arrayOfByte2 = new byte[2][];
          arrayOfByte2[0] = null;
          arrayOfByte2[1] = null;
          i = i8;
          k = i9;
          i1 = i10;
          n = i18;
          i6 = i17;
          i7 = i16;
          i5 = i15;
          i2 = i13;
          i4 = i11;
          j = i14;
          l1 = l2;
          m = i12;
          if (i3 == 21)
          {
            arrayOfByte2[0] = new byte[115200];
            arrayOfByte2[1] = new byte[115200];
            a(arrayOfByte1[0], arrayOfByte1[1], 320, 240, arrayOfByte2[0], arrayOfByte2[1]);
            m = i12;
            l1 = l2;
            j = i14;
            i4 = i11;
            i2 = i13;
            i5 = i15;
            i7 = i16;
            i6 = i17;
            n = i18;
            i1 = i10;
            k = i9;
            i = i8;
          }
          label765:
          if (i2 != 0) {}
        }
        try
        {
          if (this.jdField_b_of_type_Boolean) {
            continue;
          }
          if (m != 0) {
            break label2533;
          }
          localObject1 = localAndroidCodec.a();
          i8 = 0;
          label791:
          if (localObject1 != null) {
            break label2530;
          }
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            Object localObject1;
            label819:
            label985:
            AndroidCodec.BufferData localBufferData;
            Object localObject4;
            localException4.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "Exception", localException4);
            }
            a(-9, str, i3, 0, i, k, i1);
            continue;
            localAndroidCodec.a(localException4.jdField_a_of_type_Int, 0, 0L, 4);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "sent input EOS");
            }
            m = 1;
          }
        }
        try
        {
          Thread.sleep(50L);
          localObject3 = localAndroidCodec.a();
          localObject1 = localObject3;
          i8 += 1;
          if (localObject1 != null)
          {
            if (localObject1 != null) {
              break label1005;
            }
            if ((this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback != null) && (a() == 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "mCallback: " + this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback + ", getLastErr: " + a() + ", ssim: " + i);
              }
              this.jdField_a_of_type_ComTencentAvMediacodecVideoEncTest$PlayerCallback.a(b(), str, i3, n, i, k, i1);
            }
            try
            {
              localAndroidCodec.d();
              localAndroidCodec.e();
              return;
            }
            catch (Exception localException3)
            {
              localException3.printStackTrace();
            }
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "Exception", localException3);
            }
          }
          else
          {
            if (i8 <= 8) {
              break label2548;
            }
            try
            {
              a(-5, str, i3, 0, i, k, i1);
            }
            catch (InterruptedException localInterruptedException2) {}
          }
        }
        catch (InterruptedException localInterruptedException3)
        {
          break label985;
          localObject2 = localInterruptedException3;
          i5 = i15;
          i6 = i14;
          i = i9;
          n = i4;
          i4 = i13;
          i7 = i12;
          break label2237;
          localObject5 = localInterruptedException3;
          i2 = i;
          i7 = i9;
          break label1865;
          i8 = i2;
          break label1189;
          i8 = i5;
          i9 = i4;
          i4 = n;
          i5 = i6;
          i6 = i7;
          i7 = i8;
          n = i9;
          break label2267;
        }
      }
      if (!QLog.isColorLevel()) {
        break label2545;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "InterruptedException", localInterruptedException2);
      break label2545;
      label1005:
      if (j < 100)
      {
        localException3.jdField_a_of_type_JavaNioByteBuffer.clear();
        i8 = j & 0x1;
        if (i3 == 21)
        {
          localException3.jdField_a_of_type_JavaNioByteBuffer.put(arrayOfByte2[i8]);
          label1046:
          localAndroidCodec.a(localException3.jdField_a_of_type_Int, 115200, l1 * 100000L, 0);
          j += 1;
          l1 = 1L + l1;
          label1077:
          if (i2 != 0) {
            break label2527;
          }
          localBufferData = localAndroidCodec.b();
          if (localBufferData == null) {
            break label2496;
          }
          i16 = localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags;
          if ((i16 & 0x4) == 0) {
            break label2489;
          }
          i9 = i7 * 8 * 10 / ((i5 - 50) * 1024);
          i2 = i;
          i10 = k;
          i11 = i9;
        }
      }
      try
      {
        if (!QLog.isColorLevel()) {
          break label2551;
        }
        i2 = i;
        i10 = k;
        i11 = i9;
        QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed testH264EncoderIfNeed avgbit is: " + i9);
      }
      catch (Exception localException5)
      {
        for (;;)
        {
          label1189:
          label1865:
          i1 = i11;
          i = i2;
          k = i10;
        }
      }
      localObject4 = localBufferData;
      i9 = i;
      i13 = n;
      i15 = i6;
      i14 = i7;
      i12 = i5;
      if (i8 == 0)
      {
        i2 = i;
        i10 = k;
        i11 = i1;
        localObject4 = localBufferData;
        i9 = i;
        i13 = n;
        i15 = i6;
        i14 = i7;
        i12 = i5;
        if (localBufferData.jdField_a_of_type_Int >= 0)
        {
          i2 = i;
          i10 = k;
          i11 = i1;
          localObject4 = localBufferData;
          i9 = i;
          i13 = n;
          i15 = i6;
          i14 = i7;
          i12 = i5;
          if (localBufferData.jdField_a_of_type_JavaNioByteBuffer != null)
          {
            i2 = i;
            i10 = k;
            i11 = i1;
            if (QLog.isColorLevel())
            {
              i2 = i;
              i10 = k;
              i11 = i1;
              QLog.d(jdField_a_of_type_JavaLangString, 2, "index: " + localBufferData.jdField_a_of_type_Int + ", flags: " + i16 + ", size: " + localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
            }
            i2 = i;
            i10 = k;
            i11 = i1;
            i9 = i7 + localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size;
            i2 = i;
            i10 = k;
            i11 = i1;
            localObject4 = new byte[localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size];
            i2 = i;
            i10 = k;
            i11 = i1;
            localBufferData.jdField_a_of_type_JavaNioByteBuffer.limit(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
            i2 = i;
            i10 = k;
            i11 = i1;
            localBufferData.jdField_a_of_type_JavaNioByteBuffer.position(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
            i2 = i;
            i10 = k;
            i11 = i1;
            localBufferData.jdField_a_of_type_JavaNioByteBuffer.flip();
            i2 = i;
            i10 = k;
            i11 = i1;
            localBufferData.jdField_a_of_type_JavaNioByteBuffer.get((byte[])localObject4);
            localObject5 = localObject4;
            i2 = i;
            i7 = i9;
            if (i16 == 2)
            {
              i2 = i;
              i10 = k;
              i11 = i1;
              i = Quacaculatessim(this.jdField_a_of_type_Int, (byte[])localObject4, arrayOfByte1[0]);
              i2 = i;
              i10 = k;
              i11 = i1;
              localBufferData = localAndroidCodec.b();
              if ((localBufferData == null) || (i8 != 0)) {
                break label2476;
              }
              i2 = i;
              i10 = k;
              i11 = i1;
              if (localBufferData.jdField_a_of_type_Int < 0) {
                break label2476;
              }
              i2 = i;
              i10 = k;
              i11 = i1;
              if (localBufferData.jdField_a_of_type_JavaNioByteBuffer == null) {
                break label2476;
              }
              i2 = i;
              i10 = k;
              i11 = i1;
              if (QLog.isColorLevel())
              {
                i2 = i;
                i10 = k;
                i11 = i1;
                QLog.d(jdField_a_of_type_JavaLangString, 2, "index: " + localBufferData.jdField_a_of_type_Int + ", flags: " + i16 + ", size: " + localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
              }
              i2 = i;
              i10 = k;
              i11 = i1;
              i7 = i9 + localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size;
              i2 = i;
              i10 = k;
              i11 = i1;
              localObject5 = new byte[localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size];
              i2 = i;
              i10 = k;
              i11 = i1;
              localBufferData.jdField_a_of_type_JavaNioByteBuffer.limit(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
              i2 = i;
              i10 = k;
              i11 = i1;
              localBufferData.jdField_a_of_type_JavaNioByteBuffer.position(localBufferData.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
              i2 = i;
              i10 = k;
              i11 = i1;
              localBufferData.jdField_a_of_type_JavaNioByteBuffer.flip();
              i2 = i;
              i10 = k;
              i11 = i1;
              localBufferData.jdField_a_of_type_JavaNioByteBuffer.get((byte[])localObject5);
              i2 = i;
            }
            localObject4 = localBufferData;
            i9 = i2;
            i13 = n;
            i15 = i6;
            i14 = i7;
            i12 = i5;
            if (localBufferData != null)
            {
              i = i2;
              if (i5 < 50)
              {
                i10 = k;
                i11 = i1;
                i = Quacaculatessim(this.jdField_a_of_type_Int, (byte[])localObject5, arrayOfByte1[i6]);
              }
              i6 ^= 0x1;
              i5 += 1;
              if (i5 == 1)
              {
                i2 = i;
                i10 = k;
                i11 = i1;
                if (!QLog.isColorLevel()) {
                  break label2561;
                }
                i2 = i;
                i10 = k;
                i11 = i1;
                QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed testH264EncoderIfNeed output delay is: " + j);
                break label2561;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject4 = localBufferData;
      i9 = i;
      i13 = n;
      i15 = i6;
      i14 = i7;
      i12 = i5;
      if (i5 == 50)
      {
        i2 = i;
        i10 = k;
        i11 = i1;
        k = i7 * 8 / 1024 / 5;
        i2 = i;
        i10 = k;
        i11 = i1;
        if (QLog.isColorLevel())
        {
          i2 = i;
          i10 = k;
          i11 = i1;
          QLog.d(jdField_a_of_type_JavaLangString, 2, "testHWCodecIfNeed testH264EncoderIfNeed avgbit is: " + k);
        }
        i4 += 100;
        i2 = i;
        i10 = k;
        i11 = i1;
        localObject4 = new Bundle();
        i2 = i;
        i10 = k;
        i11 = i1;
        ((Bundle)localObject4).putInt(AndroidCodec.jdField_b_of_type_JavaLangString, 1);
        i2 = i;
        i10 = k;
        i11 = i1;
        ((Bundle)localObject4).putInt("video-bitrate", i4 * 1024);
        i2 = i;
        i10 = k;
        i11 = i1;
        localAndroidCodec.a((Bundle)localObject4);
        i2 = i6;
        i9 = 0;
        i6 = i4;
        i4 = n;
        n = i6;
        i7 = i5;
        i6 = i9;
        i5 = i2;
        label2237:
        if (localBufferData != null) {}
        for (;;)
        {
          try
          {
            if (localBufferData.jdField_a_of_type_JavaNioByteBuffer != null) {
              localAndroidCodec.a(localBufferData.jdField_a_of_type_Int);
            }
          }
          catch (Exception localException6)
          {
            label2267:
            continue;
          }
          try
          {
            Thread.sleep(30L);
            i2 = i8;
          }
          catch (InterruptedException localInterruptedException1)
          {
            localInterruptedException1.printStackTrace();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(jdField_a_of_type_JavaLangString, 2, "InterruptedException", localInterruptedException1);
            i2 = i8;
          }
        }
        i8 = i6;
        i9 = i7;
        i10 = n;
        n = i4;
        i6 = i5;
        i7 = i8;
        i5 = i9;
        i4 = i10;
        break label765;
        localBufferData.jdField_a_of_type_JavaNioByteBuffer.put(arrayOfByte1[i8]);
        break label1046;
      }
      Object localObject2;
      label2476:
      label2489:
      label2496:
      label2527:
      break label765;
      label2530:
      break label819;
      label2533:
      break label1077;
      i3 = 0;
      i = 0;
      break;
      label2545:
      break label819;
      label2548:
      break label791;
      label2551:
      i8 = 1;
      i1 = i9;
      break label1189;
      label2561:
      n = j;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\mediacodec\VideoEncTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */