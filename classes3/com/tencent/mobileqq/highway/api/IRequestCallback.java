package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.highway.segment.HwResponse;

public abstract interface IRequestCallback
{
  public abstract void onFailed(int paramInt);
  
  public abstract void onResponse(HwResponse paramHwResponse);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\api\IRequestCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */