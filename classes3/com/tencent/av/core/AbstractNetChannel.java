package com.tencent.av.core;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.WireFormatMicro;
import java.io.IOException;

public abstract class AbstractNetChannel
{
  public static final byte a = 0;
  public static final byte b = 1;
  public static final byte c = 2;
  public static final byte d = 3;
  public static final byte e = 1;
  public static final byte f = 2;
  public static final byte g = 3;
  public static final byte h = 4;
  public static final byte i = 5;
  public static final byte j = 6;
  public static final byte k = 7;
  public static final byte l = 8;
  public static final byte m = 17;
  private VcControllerImpl a;
  
  public AbstractNetChannel()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static byte a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 3)) {
      return -1;
    }
    return paramArrayOfByte[2];
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = CodedInputStreamMicro.newInstance(paramArrayOfByte);
    try
    {
      for (;;)
      {
        int n = paramArrayOfByte.readTag();
        if (n == 0) {
          break;
        }
        if (WireFormatMicro.getTagFieldNumber(n) == 2) {
          return true;
        }
        paramArrayOfByte.skipField(n);
      }
      return false;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public final byte a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.a == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int n = this.a.onRecvVideoCallBytes(paramArrayOfByte1);
          b1 = b2;
          if (n >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
  
  public int a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.a == null) {
      return -1;
    }
    return this.a.getCmdTypeFromCmdPkg(paramBoolean, paramArrayOfByte, paramInt);
  }
  
  public abstract void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte);
  
  public final void a(VcControllerImpl paramVcControllerImpl)
  {
    this.a = paramVcControllerImpl;
  }
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong);
  
  public final byte b(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.a == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int n = this.a.onRecvVideoCallBytesM2M(paramArrayOfByte1);
          b1 = b2;
          if (n >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
  
  public abstract void b(byte[] paramArrayOfByte, long paramLong);
  
  public final byte c(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return 0;
  }
  
  public abstract void c(byte[] paramArrayOfByte, long paramLong);
  
  public final byte d(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.a == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int n = this.a.onRecvVideoCallBytesForSharp(paramArrayOfByte1);
          b1 = b2;
          if (n >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
  
  public final byte e(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.a == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int n = this.a.onRecvVideoCallBytesForSharpC2SACK(paramArrayOfByte1);
          b1 = b2;
          if (n >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\core\AbstractNetChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */