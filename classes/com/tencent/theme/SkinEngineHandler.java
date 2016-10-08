package com.tencent.theme;

public abstract interface SkinEngineHandler
{
  public abstract boolean onDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean);
  
  public abstract boolean onDecodeReturnNullBitmap(String paramString, boolean paramBoolean);
  
  public abstract boolean onSecondDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\theme\SkinEngineHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */