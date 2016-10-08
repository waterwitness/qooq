package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ResourceIdMapper;

public class QQResourceIdMapper
  extends ResourceIdMapper
{
  public QQResourceIdMapper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getHostResourceId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 2130968620;
    case 1: 
      return 2130968621;
    case 2: 
      return 2130968793;
    case 7: 
      return 2130968795;
    case 3: 
      return 2130968590;
    case 6: 
      return 2130968588;
    case 5: 
      return 2130968587;
    case 4: 
      return 2130968591;
    }
    return 2131558789;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\QQResourceIdMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */