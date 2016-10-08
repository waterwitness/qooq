package com.tencent.av.ui;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import grj;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ControlUIObserver
  implements Observer
{
  public static final int a = 100;
  public static final int b = 101;
  public static final int c = 102;
  public static final int d = 103;
  public static final int e = 104;
  public static final int f = 105;
  public static final int g = 106;
  public static final int h = 107;
  public static final int i = 108;
  public static final int j = 109;
  public static final int k = 110;
  public static final int l = 111;
  public static final int m = 112;
  public static final int n = 113;
  public static final int o = 114;
  public static final int p = 115;
  public static final int q = 116;
  public static final int r = 117;
  public static final int s = 118;
  public static final int t = 120;
  public static final int u = 121;
  public static final int v = 122;
  public static final int w = 123;
  public static final int x = 124;
  public static final int y = 125;
  public static final int z = 126;
  Handler a;
  
  public ControlUIObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(Object paramObject) {}
  
  protected void a(String paramString) {}
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  protected void a(ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong) {}
  
  protected void b() {}
  
  protected void b(int paramInt) {}
  
  public void b(Object paramObject)
  {
    int i1 = -1;
    paramObject = (Object[])paramObject;
    switch (((Integer)paramObject[0]).intValue())
    {
    case 119: 
    default: 
      return;
    case 100: 
      b();
      return;
    case 101: 
      c();
      return;
    case 102: 
      d();
      return;
    case 103: 
      a((ArrayList)paramObject[1]);
      return;
    case 104: 
      b((ArrayList)paramObject[1]);
      return;
    case 105: 
      a(((Boolean)paramObject[1]).booleanValue());
      return;
    case 106: 
      e();
      return;
    case 107: 
      g();
      return;
    case 108: 
      h();
      return;
    case 109: 
      i();
      return;
    case 110: 
      a();
      return;
    case 120: 
      a(((Integer)paramObject[1]).intValue());
      return;
    case 111: 
      b(((Boolean)paramObject[1]).booleanValue());
      return;
    case 112: 
      j();
      return;
    case 113: 
      l();
      return;
    case 114: 
      f();
      return;
    case 115: 
      a((String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], ((Integer)paramObject[4]).intValue());
      return;
    case 117: 
      if (paramObject.length <= 1) {
        break;
      }
    }
    for (i1 = ((Integer)paramObject[1]).intValue();; i1 = -1)
    {
      c(i1);
      return;
      throw new IllegalArgumentException("美颜需要重新响应, 记得加break");
      k();
      return;
      if (paramObject.length > 1) {
        i1 = ((Integer)paramObject[1]).intValue();
      }
      b(i1);
      return;
      if (paramObject.length != 4) {
        break;
      }
      a(((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Long)paramObject[3]).longValue());
      return;
      n();
      return;
      a(paramObject[1]);
      return;
      m();
      return;
      a((String)paramObject[1]);
      return;
    }
  }
  
  protected void b(ArrayList paramArrayList) {}
  
  protected void b(boolean paramBoolean) {}
  
  public void c() {}
  
  protected void c(int paramInt) {}
  
  protected void d() {}
  
  protected void e() {}
  
  protected void f() {}
  
  protected void g() {}
  
  protected void h() {}
  
  protected void i() {}
  
  protected void j() {}
  
  protected void k() {}
  
  protected void l() {}
  
  protected void m() {}
  
  protected void n() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new grj(this, paramObject));
      return;
    }
    b(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\ControlUIObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */