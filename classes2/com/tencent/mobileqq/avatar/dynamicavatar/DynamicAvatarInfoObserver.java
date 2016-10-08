package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DynamicAvatarInfoObserver
  implements BusinessObserver
{
  public DynamicAvatarInfoObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool = false;
    int j = -1;
    switch (paramInt)
    {
    default: 
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    paramObject = null;
    long l = -1L;
    int i;
    if ((arrayOfObject != null) && (arrayOfObject.length == 6))
    {
      paramObject = (DynamicAvatarInfo)arrayOfObject[0];
      l = ((Long)arrayOfObject[1]).longValue();
      paramInt = ((Integer)arrayOfObject[2]).intValue();
      i = ((Integer)arrayOfObject[3]).intValue();
      j = ((Integer)arrayOfObject[4]).intValue();
      bool = ((Boolean)arrayOfObject[5]).booleanValue();
    }
    for (;;)
    {
      a(paramBoolean, (DynamicAvatarInfo)paramObject, Long.valueOf(l), paramInt, i, j, bool);
      return;
      i = -1;
      paramInt = -1;
    }
  }
  
  protected void a(boolean paramBoolean1, DynamicAvatarInfo paramDynamicAvatarInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\DynamicAvatarInfoObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */