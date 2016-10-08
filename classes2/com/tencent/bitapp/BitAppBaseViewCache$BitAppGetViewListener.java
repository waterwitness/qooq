package com.tencent.bitapp;

import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class BitAppBaseViewCache$BitAppGetViewListener
{
  private WeakReference a;
  
  public BitAppBaseViewCache$BitAppGetViewListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BitAppBaseView a()
  {
    if (this.a != null) {
      return (BitAppBaseView)this.a.get();
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e(BitAppBaseViewCache.a, 4, "BitAppGetViewListener onInvalidViewClick");
    }
  }
  
  public void a(BitAppBaseView paramBitAppBaseView)
  {
    this.a = new WeakReference(paramBitAppBaseView);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BitAppBaseViewCache.a, 2, "BitAppGetViewListener onLoadFail msgId: " + paramString + " | errorCode: " + paramInt);
    }
  }
  
  public void a(String paramString, BitAppBaseView paramBitAppBaseView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BitAppBaseViewCache.a, 2, "BitAppGetViewListener onLoadSuccess msgId: " + paramString + " | " + paramBitAppBaseView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppBaseViewCache$BitAppGetViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */