package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.BusiRespHead;

public class NearFieldDiscussObserver
  implements BusinessObserver
{
  public NearFieldDiscussObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      a(paramBoolean, paramObject);
      return;
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (nearfield_discuss.BusiRespHead)paramObject[3]);
        return;
      }
      a(paramBoolean, null, -1, -1, null);
      return;
    } while (!paramBoolean);
    b(paramBoolean, paramObject);
  }
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, nearfield_discuss.BusiRespHead paramBusiRespHead) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearFieldDiscussObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */