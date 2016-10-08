package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class DatingManager$2
  extends LinkedHashMap
{
  private static final int a = 50;
  private static final long serialVersionUID = 3550610065979495878L;
  
  DatingManager$2(DatingManager paramDatingManager, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > 50;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingManager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */