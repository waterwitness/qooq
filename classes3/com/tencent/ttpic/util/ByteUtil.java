package com.tencent.ttpic.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteUtil
{
  public static byte[] mBytes = new byte[4];
  
  public static byte[] getByteBuffer()
  {
    return mBytes;
  }
  
  public static int readInt()
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(mBytes);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.getInt();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\ByteUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */