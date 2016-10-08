package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.IInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;

public abstract interface IAIOImageProvider
  extends IInterface
{
  public static final String d = "IAIOImageProvider";
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  
  public abstract Intent a(long paramLong, int paramInt);
  
  public abstract Intent a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract MessageForShortVideo a(long paramLong);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, int paramInt);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void b(long paramLong);
  
  public abstract void b(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void c(long paramLong);
  
  public abstract void d();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\IAIOImageProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */