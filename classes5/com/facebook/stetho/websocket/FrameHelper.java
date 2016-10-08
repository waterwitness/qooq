package com.facebook.stetho.websocket;

import com.facebook.stetho.common.Utf8Charset;

class FrameHelper
{
  public static Frame createBinaryFrame(byte[] paramArrayOfByte)
  {
    return createSimpleFrame(, paramArrayOfByte);
  }
  
  public static Frame createCloseFrame(int paramInt, String paramString)
  {
    byte[] arrayOfByte = null;
    int i = 2;
    if (paramString != null)
    {
      arrayOfByte = Utf8Charset.encodeUTF8(paramString);
      i = 2 + arrayOfByte.length;
    }
    paramString = new byte[i];
    paramString[0] = ((byte)(paramInt >> 8 & 0xFF));
    paramString[1] = ((byte)(paramInt & 0xFF));
    if (arrayOfByte != null) {
      System.arraycopy(arrayOfByte, 0, paramString, 2, arrayOfByte.length);
    }
    return createSimpleFrame((byte)8, paramString);
  }
  
  public static Frame createPingFrame(byte[] paramArrayOfByte, int paramInt)
  {
    return createSimpleFrame(, paramArrayOfByte, paramInt);
  }
  
  public static Frame createPongFrame(byte[] paramArrayOfByte, int paramInt)
  {
    return createSimpleFrame(, paramArrayOfByte, paramInt);
  }
  
  private static Frame createSimpleFrame(byte paramByte, byte[] paramArrayOfByte)
  {
    return createSimpleFrame(paramByte, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  private static Frame createSimpleFrame(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    Frame localFrame = new Frame();
    localFrame.fin = true;
    localFrame.hasMask = false;
    localFrame.opcode = paramByte;
    localFrame.payloadLen = paramInt;
    localFrame.payloadData = paramArrayOfByte;
    return localFrame;
  }
  
  public static Frame createTextFrame(String paramString)
  {
    return createSimpleFrame(, Utf8Charset.encodeUTF8(paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\websocket\FrameHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */