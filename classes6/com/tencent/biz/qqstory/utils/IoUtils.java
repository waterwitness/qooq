package com.tencent.biz.qqstory.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Closeable;

public final class IoUtils
{
  public static final int a = 32768;
  public static final int b = 512000;
  public static final int c = 75;
  
  private IoUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  private static boolean a(IoUtils.CopyListener paramCopyListener, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramCopyListener != null) && (!paramCopyListener.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4)) && (paramInt3 * 100 / paramInt4 < 75);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\IoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */