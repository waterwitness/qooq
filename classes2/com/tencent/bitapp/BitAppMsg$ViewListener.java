package com.tencent.bitapp;

import android.text.TextUtils;
import com.tencent.bitapp.view.BitAppBaseViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class BitAppMsg$ViewListener
  extends BitAppBaseViewListener
{
  private BitAppMsg.CreateViewListener createViewListener;
  private Set viewSet;
  
  public BitAppMsg$ViewListener(Set paramSet, BitAppMsg.CreateViewListener paramCreateViewListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.viewSet = paramSet;
    this.createViewListener = paramCreateViewListener;
  }
  
  public void onInvalidViewClick()
  {
    if (QLog.isColorLevel()) {
      QLog.i(BitAppMsg.TAG, 4, "IBitAppBaseViewListener onInvalidViewClick");
    }
    this.createViewListener.a();
  }
  
  public void onLoadFail(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BitAppMsg.TAG, 4, "IBitAppBaseViewListener onLoadFail key: " + paramString + " | errorCode: " + paramInt);
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.viewSet.contains(paramString))) {
      this.createViewListener.a(paramString, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(BitAppMsg.TAG, 4, "IBitAppBaseViewListener onLoadFail dont' contain this key: " + paramString);
  }
  
  public void onLoadSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(BitAppMsg.TAG, 4, "IBitAppBaseViewListener onLoadSuccess key: " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.viewSet.contains(paramString)))
    {
      this.viewSet.remove(paramString);
      if (QLog.isColorLevel()) {
        QLog.i(BitAppMsg.TAG, 4, "IBitAppBaseViewListener viewSet size: " + this.viewSet.size());
      }
      if (this.viewSet.size() == 0) {
        this.createViewListener.a(paramString);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(BitAppMsg.TAG, 4, "IBitAppBaseViewListener onLoadSuccess dont' contain this key: " + paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMsg$ViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */