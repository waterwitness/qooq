package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.IInterface;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract interface ICallBack
  extends IInterface
{
  public abstract Bundle a(int paramInt, Bundle paramBundle);
  
  public abstract void a(int paramInt, Bundle paramBundle);
  
  public abstract void a(CompressInfo paramCompressInfo);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\ICallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */