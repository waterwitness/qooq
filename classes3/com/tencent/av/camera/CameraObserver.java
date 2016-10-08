package com.tencent.av.camera;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ggm;
import java.util.Observable;
import java.util.Observer;

public class CameraObserver
  implements Observer
{
  Handler a;
  
  public CameraObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (Object[])paramObject;
    switch (((Integer)paramObject[0]).intValue())
    {
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
      a(((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 3: 
      b();
      return;
    case 4: 
      a(((Boolean)paramObject[1]).booleanValue());
      return;
    case 5: 
      c();
      return;
    case 6: 
      b(((Boolean)paramObject[1]).booleanValue());
      return;
    }
    try
    {
      paramObject = (byte[])paramObject[1];
      a((byte[])paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        ((Exception)paramObject).printStackTrace();
        paramObject = null;
      }
    }
  }
  
  protected void a() {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(byte[] paramArrayOfByte) {}
  
  protected void b() {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void c() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new ggm(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\camera\CameraObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */