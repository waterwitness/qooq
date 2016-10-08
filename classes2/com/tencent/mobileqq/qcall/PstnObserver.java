package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PstnObserver
  implements BusinessObserver
{
  public PstnObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    long l;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, (PstnCardInfo)paramObject);
      return;
    case 2: 
      a(paramBoolean);
      return;
    case 3: 
      l = 0L;
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 2) {
          l = ((Long)paramObject[0]).longValue();
        }
      }
      break;
    }
    for (paramBoolean = ((Boolean)paramObject[1]).booleanValue();; paramBoolean = bool2)
    {
      a(Boolean.valueOf(bool1), l, paramBoolean);
      return;
      if ((paramObject == null) || (!(paramObject instanceof Integer))) {
        break;
      }
      a(Boolean.valueOf(paramBoolean), ((Integer)paramObject).intValue());
      return;
      a(Boolean.valueOf(paramBoolean), paramObject);
      return;
      a();
      return;
      if (paramObject == null) {
        break;
      }
      paramObject = (Object[])paramObject;
      if (paramObject.length != 2) {
        break;
      }
      a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
      if (paramObject == null) {
        break;
      }
      paramObject = (Object[])paramObject;
      if (paramObject.length != 3) {
        break;
      }
      a((String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
      return;
      bool1 = false;
    }
  }
  
  public void a(Boolean paramBoolean, int paramInt) {}
  
  public void a(Boolean paramBoolean, long paramLong, boolean paramBoolean1) {}
  
  public void a(Boolean paramBoolean, Object paramObject) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, PstnCardInfo paramPstnCardInfo) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\PstnObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */