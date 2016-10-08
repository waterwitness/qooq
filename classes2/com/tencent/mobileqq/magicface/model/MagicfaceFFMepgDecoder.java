package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceFFMepgDecoder
  extends MagicfaceDecoder
{
  private static final String a = "MagicfaceFFMepgDecoder";
  public DecoderUtil a;
  public byte[] a;
  public int[] a;
  public byte[] b;
  public byte[] c;
  public byte[] d;
  public byte[] e;
  public byte[] f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  public MagicfaceFFMepgDecoder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new byte[51200];
    this.i = -1;
    this.j = -1;
    this.e = new byte[51200];
    this.m = -1;
    this.n = -1;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder begins");
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends");
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1;
    if (paramInt == paramArrayOfByte.length) {
      i1 = -1;
    }
    do
    {
      return i1;
      int i2 = paramInt + 1;
      int i3 = 0;
      int i4 = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
      i1 = i3;
      paramInt = i2;
      if (i4 != 7)
      {
        i1 = i3;
        paramInt = i2;
        if (i4 != 8)
        {
          i1 = 1;
          paramInt = i2;
        }
      }
      while (paramInt < paramArrayOfByte.length - 4) {
        if ((paramArrayOfByte[paramInt] == 0) && (paramArrayOfByte[(paramInt + 1)] == 0) && (paramArrayOfByte[(paramInt + 2)] == 0) && (paramArrayOfByte[(paramInt + 3)] == 1))
        {
          i2 = (byte)(paramArrayOfByte[(paramInt + 4)] & 0xF);
          if ((i2 != 7) && (i2 != 8))
          {
            if (i1 != 0) {
              break;
            }
            paramInt += 1;
            i1 = 1;
          }
          else
          {
            paramInt += 1;
          }
        }
        else
        {
          paramInt += 1;
        }
      }
      i1 = paramInt;
    } while (paramInt != paramArrayOfByte.length - 4);
    return paramArrayOfByte.length;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceFFMepgDecoder", 2, "func maigcfaceDecoder begins:,isStartDecodr:" + this.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
        if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder() == 0) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder() != 0)) {}
        this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.b;
        byte[] arrayOfByte1 = this.jdField_a_of_type_ArrayOfByte;
        if (arrayOfByte1 != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicfaceFFMepgDecoder", 2, "===MagicfaceDecoder=Exception==" + localException.getMessage());
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError4) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError4.getMessage());
        return;
        i1 = 1;
        l2 = 0L;
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        l1 = System.currentTimeMillis();
        i2 = a(this.jdField_a_of_type_ArrayOfByte, this.h);
        this.g = (i2 - this.h);
        i3 = this.g;
        if (i3 > 0) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError5) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError5.getMessage());
        return;
        a(this.g, this.h, this.jdField_a_of_type_ArrayOfByte);
        this.h = i2;
        l3 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoder(this.b, this.g, this.c);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicfaceFFMepgDecoder", 2, "decodeVideoDecoder==usetime=" + (System.currentTimeMillis() - l3) + "==videoFrameLength==" + this.g);
        try
        {
          if (this.i == -1)
          {
            this.i = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
            this.j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
            if ((this.i > 500) || (this.j > 500))
            {
              this.i = -1;
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
                continue;
              }
              try
              {
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
                return;
              }
              catch (UnsatisfiedLinkError localUnsatisfiedLinkError6) {}
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError6.getMessage());
              return;
            }
            this.jdField_a_of_type_ArrayOfInt = new int[this.j * this.i];
          }
          i2 = a(this.d, this.l);
          this.k = (i2 - this.l);
          b(this.k, this.l, this.d);
          this.l = i2;
          l3 = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoder(this.e, this.k, this.jdField_f_of_type_ArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "decodeAlphaDecoder==usetime=" + (System.currentTimeMillis() - l3) + "==alphaFrameLength==" + this.k);
          }
          l3 = System.currentTimeMillis();
          arrayOfInt = a(this.c, this.jdField_f_of_type_ArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "convertByteToColor==usetime=" + (System.currentTimeMillis() - l3));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener.a(arrayOfInt, this.i, this.j);
          }
          l3 = System.currentTimeMillis() - l1;
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceFFMepgDecoder", 2, "==============frameTime=============" + l3);
          }
          if (l3 >= this.jdField_f_of_type_Int) {
            continue;
          }
          if (l2 <= 0L) {
            continue;
          }
          l1 = this.jdField_f_of_type_Int - l3;
          if (l1 <= l2) {
            continue;
          }
          Thread.sleep(l1 - l2);
          l1 = l2;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MagicfaceFFMepgDecoder", 2, "magicfaceffMepgDecoder outofMemoryError");
          }
          this.i = -1;
          System.gc();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError7) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError7.getMessage());
        return;
        l1 = l2 - l1;
        break label1159;
        Thread.sleep(this.jdField_f_of_type_Int - l3);
        l1 = l2;
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        localOutOfMemoryError3.printStackTrace();
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError8) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError8.getMessage());
        return;
        l1 = l2;
        if (i1 != 0) {
          break label1159;
        }
        i1 = this.jdField_f_of_type_Int;
        l1 = l2 + (l3 - i1);
      }
      finally
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
          break label1137;
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError1.getMessage());
        return;
      }
      this.d = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_ArrayOfByte;
      arrayOfByte2 = this.d;
      if (arrayOfByte2 == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
            return;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2) {}
          if (QLog.isColorLevel()) {
            QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError2.getMessage());
          }
        }
      }
      else {
        try
        {
          this.c = new byte[480000];
          this.jdField_f_of_type_ArrayOfByte = new byte[480000];
          byte[] arrayOfByte3 = this.c;
          if (arrayOfByte3 == null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
              continue;
            }
            try
            {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
              return;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError3) {}
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError3.getMessage());
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localOutOfMemoryError1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("MagicfaceFFMepgDecoder", 2, "func MagicfaceFFMepgDecoder ends, OOM.");
          }
        }
      }
    }
    for (;;)
    {
      long l1;
      try
      {
        int i2;
        int i3;
        long l3;
        int[] arrayOfInt;
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
        label1137:
        throw ((Throwable)localObject);
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError9)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MagicfaceFFMepgDecoder", 2, localUnsatisfiedLinkError9.getMessage());
        continue;
      }
      label1159:
      int i1 = 0;
      long l2 = l1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.b.length < paramInt1)
    {
      this.b = new byte[paramInt1];
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceFFMepgDecoder", 2, "videoFrame.length = " + this.b.length + "new framelength = " + paramInt1);
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.b, 0, paramInt1);
  }
  
  public int[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i2 = 0;
    if (i2 < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int i4 = i2 * 3;
      int i3 = paramArrayOfByte2[i4] & 0xFF;
      int i1;
      if (i3 <= 50) {
        i1 = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfInt[i2] = (i1 << 24 & 0xFF000000 | paramArrayOfByte1[(i4 + 2)] << 16 & 0xFF0000 | paramArrayOfByte1[(i4 + 1)] << 8 & 0xFF00 | paramArrayOfByte1[i4] & 0xFF);
        i2 += 1;
        break;
        i1 = i3;
        if (i3 >= 235) {
          i1 = 255;
        }
      }
    }
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (this.e.length < paramInt1)
    {
      this.e = new byte[paramInt1];
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceFFMepgDecoder", 2, "alphaFrame.length = " + this.e.length + " new fillFrameAlpha = " + paramInt1);
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt2, this.e, 0, paramInt1);
  }
  
  public void c()
  {
    super.c();
    this.b = null;
    this.e = null;
    this.jdField_f_of_type_ArrayOfByte = null;
    this.c = null;
    this.jdField_a_of_type_ArrayOfInt = null;
    System.gc();
  }
  
  protected void f()
  {
    super.f();
    this.h = 0;
    this.l = 0;
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\model\MagicfaceFFMepgDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */