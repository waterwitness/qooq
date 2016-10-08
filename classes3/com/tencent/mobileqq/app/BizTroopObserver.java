package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class BizTroopObserver
  implements BusinessObserver
{
  private final String a;
  
  public BizTroopObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "BizTroopObserver";
  }
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {}
    for (Object[] arrayOfObject = (Object[])paramObject;; arrayOfObject = null)
    {
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 7: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 23: 
      case 35: 
      case 37: 
      default: 
      case 2: 
      case 9: 
      case 4: 
      case 6: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 20: 
      case 18: 
      case 19: 
      case 27: 
      case 28: 
      case 29: 
      case 21: 
      case 22: 
      case 25: 
      case 30: 
      case 26: 
      case 24: 
      case 32: 
      case 34: 
      case 33: 
      case 31: 
      case 36: 
      case 38: 
      case 39: 
      case 40: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          d(paramBoolean, paramObject);
                          return;
                          a(paramObject);
                          return;
                          g(paramBoolean, paramObject);
                          return;
                        } while (arrayOfObject == null);
                        if (paramBoolean)
                        {
                          a(paramBoolean, (String)arrayOfObject[0], ((Boolean)arrayOfObject[1]).booleanValue(), (List)arrayOfObject[2]);
                          return;
                        }
                        a(paramBoolean, (String)arrayOfObject[0], ((Boolean)arrayOfObject[1]).booleanValue(), null);
                        return;
                        e(paramBoolean, paramObject);
                        return;
                        f(paramBoolean, paramObject);
                        return;
                        a(paramBoolean, (List)paramObject);
                        return;
                      } while (arrayOfObject == null);
                      if (paramBoolean)
                      {
                        a(true, ((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue(), (ArrayList)arrayOfObject[3], 0);
                        return;
                      }
                      a(false, ((Integer)arrayOfObject[2]).intValue(), 0, 0, null, ((Integer)arrayOfObject[4]).intValue());
                      return;
                      b(paramObject);
                      return;
                      c(paramObject);
                      return;
                    } while (arrayOfObject == null);
                    a((String)arrayOfObject[0], ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue(), (String)arrayOfObject[3]);
                    return;
                    h(paramBoolean, paramObject);
                    return;
                    i(paramBoolean, paramObject);
                    return;
                    j(paramBoolean, paramObject);
                    return;
                    if ((arrayOfObject == null) || (arrayOfObject.length == 0))
                    {
                      a(false, -1L, "");
                      return;
                    }
                    a(paramBoolean, ((Long)arrayOfObject[0]).longValue(), (String)arrayOfObject[1]);
                    return;
                    b(paramBoolean, paramObject);
                    return;
                    if (QLog.isDevelopLevel()) {
                      QLog.d("BizTroopObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
                    }
                    a((TroopGagMgr.GagStatus)paramObject);
                    return;
                  } while (arrayOfObject == null);
                  a((String)arrayOfObject[0], (List)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
                  return;
                  a(paramBoolean, ((Boolean)paramObject).booleanValue());
                  return;
                  c(paramBoolean, ((Boolean)paramObject).booleanValue());
                  return;
                  c(paramBoolean, paramObject);
                  return;
                } while (arrayOfObject == null);
                a(paramBoolean, ((Long)arrayOfObject[0]).longValue(), ((Long)arrayOfObject[1]).longValue());
                return;
              } while ((arrayOfObject == null) || (arrayOfObject.length != 2));
              a(paramBoolean, (String)arrayOfObject[0], arrayOfObject[1]);
              return;
            } while (arrayOfObject == null);
            a(paramBoolean, ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
            return;
          } while (arrayOfObject == null);
          b(paramBoolean, ((Boolean)arrayOfObject[1]).booleanValue());
          return;
          a(paramBoolean, paramObject);
          return;
          if ((paramBoolean) && (arrayOfObject != null))
          {
            a(((Long)arrayOfObject[0]).longValue(), ((Long)arrayOfObject[1]).longValue(), ((Long)arrayOfObject[2]).longValue(), (String)arrayOfObject[3]);
            return;
          }
          a(-1L, -1L, -1L, "");
          return;
          k(paramBoolean, paramObject);
          return;
        } while ((arrayOfObject == null) || (arrayOfObject.length != 2));
        a((String)arrayOfObject[0], (String)arrayOfObject[1]);
        return;
      case 41: 
        l(paramBoolean, paramObject);
        return;
      }
      if ((arrayOfObject != null) && (arrayOfObject.length >= 1)) {}
      for (paramInt = ((Integer)arrayOfObject[0]).intValue(); (paramBoolean) && (arrayOfObject != null) && (arrayOfObject.length >= 4); paramInt = 2131364297)
      {
        a(paramBoolean, paramInt, (String)arrayOfObject[1], (String)arrayOfObject[2], (Boolean)arrayOfObject[3]);
        return;
      }
      a(paramBoolean, paramInt, null, null, Boolean.valueOf(true));
      return;
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  protected void a(TroopGagMgr.GagStatus paramGagStatus) {}
  
  protected void a(Object paramObject) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(String paramString1, String paramString2) {}
  
  protected void a(String paramString, List paramList, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList, int paramInt4) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString, Object paramObject) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, List paramList) {}
  
  protected void a(boolean paramBoolean, List paramList) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c(Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  protected void h(boolean paramBoolean, Object paramObject) {}
  
  protected void i(boolean paramBoolean, Object paramObject) {}
  
  protected void j(boolean paramBoolean, Object paramObject) {}
  
  protected void k(boolean paramBoolean, Object paramObject) {}
  
  protected void l(boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\BizTroopObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */