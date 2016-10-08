package com.tencent.bitapp;

import android.text.TextUtils;
import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.bundle.BundleListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Set;

class BitAppHandlerThread$HandlerBundleListener
  extends BundleListener
{
  private WeakReference bitappHandlerThread;
  private Set itemSet;
  private int mCount;
  private int mSuccessCount;
  private MessageForBitAppTmp message;
  
  public BitAppHandlerThread$HandlerBundleListener(BitAppHandlerThread paramBitAppHandlerThread, Set paramSet, MessageForBitAppTmp paramMessageForBitAppTmp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.itemSet = paramSet;
    this.message = paramMessageForBitAppTmp;
    this.mCount = paramSet.size();
    this.bitappHandlerThread = new WeakReference(paramBitAppHandlerThread);
  }
  
  public void onLoadFail(String paramString, int paramInt)
  {
    super.onLoadFail(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("BitAppHandlerThread", 2, "onLoadFail rkey: " + paramString + this.message.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.itemSet.contains(paramString))) {
      this.itemSet.remove(paramString);
    }
    updateDatabase();
  }
  
  public void onLoadSuccess(String paramString, Bundle paramBundle)
  {
    super.onLoadSuccess(paramString, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("BitAppHandlerThread", 2, "onLoadSuccess rkey: " + paramString + this.message.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.itemSet.contains(paramString)))
    {
      this.itemSet.remove(paramString);
      this.mSuccessCount += 1;
      updateDatabase();
    }
  }
  
  public void updateDatabase()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("BitAppHandlerThread", 4, "mCount = " + this.mCount);
      QLog.d("BitAppHandlerThread", 4, "mSuccessCount = " + this.mSuccessCount);
      QLog.d("BitAppHandlerThread", 4, "tryCounts = " + this.message.tryCounts);
      QLog.d("BitAppHandlerThread", 4, "iteSet.size() = " + this.itemSet.size());
    }
    BitAppHandlerThread localBitAppHandlerThread = null;
    if (this.bitappHandlerThread != null) {
      localBitAppHandlerThread = (BitAppHandlerThread)this.bitappHandlerThread.get();
    }
    if (localBitAppHandlerThread != null) {
      if (this.mSuccessCount == this.mCount)
      {
        if ((this.message.bitAppMsg != null) && (!BitAppAbilityUtils.a(BaseApplication.getContext(), this.message.bitAppMsg.mRequiredVersionAndroid))) {
          BitAppHandlerThread.a(localBitAppHandlerThread, new MessageForBitApp(this.message));
        }
        localBitAppHandlerThread.a.b(this.message);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (this.itemSet.size() != 0);
      MessageForBitAppTmp localMessageForBitAppTmp = this.message;
      localMessageForBitAppTmp.tryCounts += 1;
      this.message.saveExtInfoToExtStr("tryCounts", String.valueOf(this.message.tryCounts));
      localBitAppHandlerThread.a.c(this.message);
      return;
    }
    QLog.d("BitAppHandlerThread", 4, "BitAppHandlerThread is null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppHandlerThread$HandlerBundleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */