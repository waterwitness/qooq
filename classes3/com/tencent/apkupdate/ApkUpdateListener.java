package com.tencent.apkupdate;

import java.util.ArrayList;

public abstract interface ApkUpdateListener
{
  public abstract void onCheckUpdateFailed(String paramString);
  
  public abstract void onCheckUpdateSucceed(ArrayList paramArrayList);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\apkupdate\ApkUpdateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */