package com.tencent.av.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.service.RecvMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gft;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GAudioUIObserver
  implements Observer
{
  static final String jdField_a_of_type_JavaLangString = "VideoObserver";
  Handler jdField_a_of_type_AndroidOsHandler;
  
  public GAudioUIObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  public void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, long paramLong, int paramInt2) {}
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4) {}
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4) {}
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, ArrayList paramArrayList) {}
  
  public void a(long paramLong) {}
  
  protected void a(long paramLong, int paramInt) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
  
  protected void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  protected void a(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong1, long paramLong2, String paramString) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(long paramLong, String paramString) {}
  
  public void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(RecvMsg paramRecvMsg) {}
  
  public void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, "OnUpdate，msgType = " + i);
    }
    long l;
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("VideoObserver", 2, "OnUpdate-->Wrong notify type.Type = " + i);
      }
      return;
    case 10: 
      a();
      return;
    case 12: 
      a((RecvMsg)paramObject[1]);
      return;
    case 61: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue(), ((Boolean)paramObject[4]).booleanValue());
      return;
    case 62: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 69: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
    case 70: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 77: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), true, ((Boolean)paramObject[3]).booleanValue());
      return;
    case 78: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), false, ((Boolean)paramObject[3]).booleanValue());
      return;
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
      a(i, ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 96: 
    case 97: 
    case 98: 
      a(i, 0L, ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 63: 
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 64: 
      a(((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 66: 
      c(((Long)paramObject[1]).longValue());
      return;
    case 202: 
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 67: 
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 68: 
      b(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 21: 
      a(((Integer)paramObject[1]).intValue());
      return;
    case 79: 
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 80: 
      b(((Long)paramObject[1]).longValue());
      return;
    case 83: 
      a(((Long)paramObject[1]).longValue());
      return;
    case 200: 
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 81: 
      c(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 82: 
      a((String)paramObject[1], (String[])paramObject[2]);
      return;
    case 84: 
      b();
      return;
    case 85: 
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 86: 
      b(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 87: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 71: 
      l = ((Long)paramObject[1]).longValue();
      i = ((Integer)paramObject[2]).intValue();
      a(l, ((Long)paramObject[3]).longValue(), i, true);
      return;
    case 72: 
      l = ((Long)paramObject[1]).longValue();
      i = ((Integer)paramObject[2]).intValue();
      a(l, ((Long)paramObject[3]).longValue(), i, false);
      return;
    case 73: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), true);
      return;
    case 74: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), false);
      return;
    case 88: 
      b(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 89: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
      return;
    case 138: 
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue());
      return;
    case 139: 
      b(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 140: 
      c(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 141: 
      a((ArrayList)paramObject[1]);
      return;
    case 142: 
      a((ArrayList)paramObject[1], ((Integer)paramObject[2]).intValue());
      return;
    case 301: 
      d(((Long)paramObject[1]).longValue());
      return;
    case 302: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 303: 
      c(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 307: 
      c();
      return;
    case 406: 
      d();
      return;
    case 404: 
      e(((Long)paramObject[1]).longValue());
      return;
    case 407: 
      i = ((Integer)paramObject[1]).intValue();
      if (paramObject[2] == null)
      {
        a(i, null);
        return;
      }
      a(i, (ArrayList)paramObject[2]);
      return;
    case 409: 
      a(((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 500: 
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), ((Long)paramObject[5]).longValue(), ((Long)paramObject[6]).longValue());
      return;
    case 502: 
      a(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Long)paramObject[6]).longValue(), ((Long)paramObject[7]).longValue());
      return;
    case 309: 
      a((String)paramObject[1], (String)paramObject[2]);
      return;
    case 701: 
      b(((Integer)paramObject[1]).intValue());
      return;
    case 702: 
      e();
      return;
    case 703: 
      c(((Integer)paramObject[1]).intValue());
      return;
    case 704: 
      f();
      return;
    case 705: 
      a(((Boolean)paramObject[1]).booleanValue());
      return;
    case 410: 
      f(((Long)paramObject[1]).longValue());
      return;
    case 706: 
      g();
      return;
    case 707: 
      h();
      return;
    case 513: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3]);
      return;
    case 514: 
      g(((Long)paramObject[1]).longValue());
      return;
    case 515: 
      h(((Long)paramObject[1]).longValue());
      return;
    }
    a(((Long)paramObject[1]).longValue(), (String)paramObject[2]);
  }
  
  protected void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, String[] paramArrayOfString) {}
  
  protected void a(ArrayList paramArrayList) {}
  
  protected void a(ArrayList paramArrayList, int paramInt) {}
  
  public void a(boolean paramBoolean) {}
  
  protected void b() {}
  
  public void b(int paramInt) {}
  
  protected void b(int paramInt1, long paramLong, int paramInt2) {}
  
  public void b(long paramLong) {}
  
  public void b(long paramLong, int paramInt) {}
  
  public void b(long paramLong, int paramInt1, int paramInt2) {}
  
  protected void b(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString) {}
  
  public void b(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void c(long paramLong) {}
  
  public void c(long paramLong, int paramInt) {}
  
  public void c(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void c(long paramLong, boolean paramBoolean) {}
  
  public void d() {}
  
  protected void d(long paramLong) {}
  
  public void e() {}
  
  protected void e(long paramLong) {}
  
  public void f() {}
  
  public void f(long paramLong) {}
  
  protected void g() {}
  
  protected void g(long paramLong) {}
  
  protected void h() {}
  
  protected void h(long paramLong) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new gft(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\app\GAudioUIObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */