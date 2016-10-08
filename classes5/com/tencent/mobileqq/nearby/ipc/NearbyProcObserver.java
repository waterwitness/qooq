package com.tencent.mobileqq.nearby.ipc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class NearbyProcObserver
{
  public NearbyProcObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 4120: 
    case 4133: 
      do
      {
        do
        {
          return;
        } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
        a((List)paramVarArgs[0], (List)paramVarArgs[1]);
        return;
      } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
      a(((Integer)paramVarArgs[0]).intValue(), ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    case 4115: 
      a(((Boolean)paramVarArgs[0]).booleanValue(), (List)paramVarArgs[1]);
      return;
    case 4116: 
      b(((Boolean)paramVarArgs[0]).booleanValue(), (List)paramVarArgs[1]);
      return;
    case 4117: 
      a(((Boolean)paramVarArgs[0]).booleanValue(), null);
      return;
    }
    a(((Boolean)paramVarArgs[0]).booleanValue(), null);
  }
  
  public void a(List paramList1, List paramList2) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, List paramList) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void b(boolean paramBoolean, List paramList) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\ipc\NearbyProcObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */