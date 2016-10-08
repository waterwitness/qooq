package com.tencent.av.app;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ggj;
import java.util.Observable;
import java.util.Observer;

public class VideoObserver
  implements Observer
{
  static final String jdField_a_of_type_JavaLangString = "VideoObserver";
  Handler jdField_a_of_type_AndroidOsHandler;
  
  public VideoObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = null;
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    int j = -1;
    try
    {
      i = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      j = k;
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      for (;;)
      {
        paramArrayOfObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
        }
        int i = -5;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Before send, ivrRequestSeq = %d", new Object[] { Integer.valueOf(j) }));
    }
    a(i, j);
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    int i = -1;
    str = "";
    try
    {
      j = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      i = j;
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      i = j;
      paramArrayOfObject = String.valueOf(paramArrayOfObject[3]);
      i = j;
      j = k;
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      for (;;)
      {
        paramArrayOfObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
        }
        int j = -4;
        paramArrayOfObject = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Receive request ivrRequestSeq = %d, errorCode = %d, errorMsg = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramArrayOfObject }));
    }
    a(i, j, paramArrayOfObject);
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    j = -1;
    long l1 = -1L;
    String str3 = "";
    String str4 = "";
    int i = j;
    String str2 = str3;
    String str1 = str4;
    try
    {
      int k = Integer.parseInt(String.valueOf(paramArrayOfObject[1]));
      i = j;
      str2 = str3;
      str1 = str4;
      j = Integer.parseInt(String.valueOf(paramArrayOfObject[2]));
      i = j;
      str2 = str3;
      str1 = str4;
      str3 = String.valueOf(paramArrayOfObject[3]);
      i = j;
      str2 = str3;
      str1 = str4;
      str4 = String.valueOf(paramArrayOfObject[4]);
      i = j;
      str2 = str3;
      str1 = str4;
      long l2 = Long.parseLong(String.valueOf(paramArrayOfObject[5]));
      l1 = l2;
      str1 = str4;
      str2 = str3;
      i = j;
      j = k;
    }
    catch (NumberFormatException paramArrayOfObject)
    {
      for (;;)
      {
        paramArrayOfObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("VideoObserver", 2, "Data transfer error", paramArrayOfObject);
        }
        j = -3;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoObserver", 2, String.format("Get data from VideoController, errorCode = %d, seq = %d, url = %s, str = %s, roomId = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), str2, str1, Long.valueOf(l1) }));
    }
    a(j, i, str2, str1, l1);
  }
  
  protected void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(long paramLong) {}
  
  protected void a(long paramLong1, long paramLong2) {}
  
  public void a(RecvMsg paramRecvMsg) {}
  
  public void a(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    int i;
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    default: 
      return;
    case 10: 
      b();
      return;
    case 32: 
      a();
      return;
    case 11: 
      c();
      return;
    case 12: 
      a((RecvMsg)arrayOfObject[1]);
      return;
    case 13: 
      d();
      return;
    case 14: 
      i = ((Integer)arrayOfObject[1]).intValue();
      if (arrayOfObject.length <= 2) {
        break;
      }
    }
    for (paramObject = (String)arrayOfObject[2];; paramObject = null)
    {
      a(i, (String)paramObject);
      return;
      e();
      return;
      f();
      return;
      g();
      return;
      h();
      return;
      a((String)arrayOfObject[1]);
      return;
      i();
      return;
      a(((Integer)arrayOfObject[1]).intValue());
      return;
      b(((Integer)arrayOfObject[1]).intValue());
      return;
      a(true, ((Boolean)arrayOfObject[1]).booleanValue());
      return;
      a(false, ((Boolean)arrayOfObject[1]).booleanValue());
      return;
      a(((Boolean)arrayOfObject[1]).booleanValue());
      return;
      b(((Boolean)arrayOfObject[1]).booleanValue());
      return;
      b((String)arrayOfObject[1]);
      return;
      c((String)arrayOfObject[1]);
      return;
      a((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
      return;
      k();
      return;
      String str = (String)arrayOfObject[1];
      paramObject = localObject;
      try
      {
        if (arrayOfObject.length > 2)
        {
          paramObject = localObject;
          if (arrayOfObject[2] != null)
          {
            paramObject = localObject;
            if ((arrayOfObject[2] instanceof String)) {
              paramObject = (String)arrayOfObject[2];
            }
          }
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          boolean bool;
          paramObject = localObject;
        }
      }
      a(str, (String)paramObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoObserver", 2, "TYPE_NOTIFY_CHANGE_DOUBLE_TITLE");
      }
      try
      {
        if ((arrayOfObject.length <= 1) || (arrayOfObject[1] == null) || (!(arrayOfObject[1] instanceof String))) {
          break;
        }
        paramObject = (String)arrayOfObject[1];
        if (QLog.isColorLevel()) {
          QLog.d("VideoObserver", 2, "TYPE_NOTIFY_CHANGE_DOUBLE_TITLE :" + (String)paramObject);
        }
        d((String)paramObject, true);
        return;
      }
      catch (Exception paramObject)
      {
        return;
      }
      b(((Integer)arrayOfObject[1]).intValue(), (String)arrayOfObject[2]);
      return;
      c(arrayOfObject);
      return;
      a(arrayOfObject);
      return;
      b(arrayOfObject);
      return;
      bool = ((Boolean)arrayOfObject[2]).booleanValue();
      c((String)arrayOfObject[1], bool);
      return;
      b(((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
      return;
      l();
      return;
      m();
      return;
      c(((Integer)arrayOfObject[1]).intValue());
      return;
      b((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
      return;
      a(((Long)arrayOfObject[1]).longValue());
      return;
      a((String)arrayOfObject[1], (Bitmap)arrayOfObject[2]);
      return;
      e((String)arrayOfObject[1], ((Boolean)arrayOfObject[2]).booleanValue());
      return;
      j();
      return;
      e((String)arrayOfObject[1]);
      return;
      f((String)arrayOfObject[1]);
      return;
      g((String)arrayOfObject[1]);
      return;
      h((String)arrayOfObject[1]);
      return;
      a((String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
      return;
      a((RecvGVideoLevelInfo[])arrayOfObject[1]);
      return;
      a(((Long)arrayOfObject[1]).longValue(), ((Long)arrayOfObject[2]).longValue());
      return;
      d((String)arrayOfObject[1]);
      return;
    }
  }
  
  public void a(String paramString) {}
  
  protected void a(String paramString, int paramInt) {}
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo) {}
  
  public void b() {}
  
  protected void b(int paramInt) {}
  
  protected void b(int paramInt1, int paramInt2) {}
  
  public void b(int paramInt, String paramString) {}
  
  public void b(String paramString) {}
  
  public void b(String paramString, boolean paramBoolean) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  protected void c(int paramInt) {}
  
  public void c(String paramString) {}
  
  protected void c(String paramString, boolean paramBoolean) {}
  
  public void d() {}
  
  public void d(String paramString) {}
  
  public void d(String paramString, boolean paramBoolean) {}
  
  public void e() {}
  
  protected void e(String paramString) {}
  
  public void e(String paramString, boolean paramBoolean) {}
  
  public void f() {}
  
  protected void f(String paramString) {}
  
  public void g() {}
  
  protected void g(String paramString) {}
  
  public void h() {}
  
  public void h(String paramString) {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  protected void l() {}
  
  protected void m() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new ggj(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\app\VideoObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */