package com.tencent.mobileqq.activity.aio.photo;

import android.os.IInterface;

public abstract interface IAIOImageProviderCallBack
  extends IInterface
{
  public static final String a = "IAIOImageProviderCallBack";
  
  public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean);
  
  public abstract void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\IAIOImageProviderCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */