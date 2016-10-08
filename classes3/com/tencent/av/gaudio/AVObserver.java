package com.tencent.av.gaudio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gib;
import java.util.Observable;
import java.util.Observer;

public class AVObserver
  implements Observer
{
  public static final String a = "GAudioObserver";
  Handler a;
  
  public AVObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  public void a(int paramInt, long paramLong) {}
  
  public void a(int paramInt, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
  
  public void a(long paramLong1, int paramInt, long paramLong2, String paramString) {}
  
  public void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i;
    switch (((Integer)paramObject[0]).intValue())
    {
    default: 
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
      return;
    case 21: 
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
      return;
    case 22: 
      b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
      return;
    case 23: 
      c(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
      return;
    case 28: 
      a(((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3]);
      return;
    case 29: 
      a((String)paramObject[2], (String)paramObject[3]);
      return;
    case 32: 
      i = ((Integer)paramObject[1]).intValue();
      a(((Long)paramObject[2]).longValue(), i, ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 33: 
      i = ((Integer)paramObject[1]).intValue();
      a(((Long)paramObject[2]).longValue(), i, ((Long)paramObject[3]).longValue(), (String)paramObject[4]);
      return;
    case 36: 
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
      return;
    case 37: 
      b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
      return;
    case 408: 
      a(((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2]);
      return;
    }
    a((String)paramObject[1]);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  public void b(int paramInt, long paramLong) {}
  
  public void b(int paramInt, long paramLong1, long paramLong2) {}
  
  public void c(int paramInt, long paramLong1, long paramLong2) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new gib(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gaudio\AVObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */