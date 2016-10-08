package com.facebook.stetho.websocket;

class MaskingHelper
{
  public static void unmask(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      if (paramInt2 <= 0) {
        return;
      }
      paramArrayOfByte2[paramInt1] = ((byte)(paramArrayOfByte2[paramInt1] ^ paramArrayOfByte1[(i % paramArrayOfByte1.length)]));
      i += 1;
      paramInt2 -= 1;
      paramInt1 += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\websocket\MaskingHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */