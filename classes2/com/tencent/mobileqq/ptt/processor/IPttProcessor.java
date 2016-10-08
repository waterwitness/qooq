package com.tencent.mobileqq.ptt.processor;

public abstract interface IPttProcessor
{
  public static final int a = 960;
  
  public abstract IPttProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\processor\IPttProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */