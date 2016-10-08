package com.tencent.mobileqq.highway.api;

import java.util.HashMap;

public abstract interface ITransactionCallback
{
  public abstract void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap);
  
  public abstract void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap);
  
  public abstract void onSwitch2BackupChannel();
  
  public abstract void onTransStart();
  
  public abstract void onUpdateProgress(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\api\ITransactionCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */