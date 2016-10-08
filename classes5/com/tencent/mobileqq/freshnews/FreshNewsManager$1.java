package com.tencent.mobileqq.freshnews;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class FreshNewsManager$1
  extends LinkedHashMap
{
  private static final int a = 100;
  private static final long serialVersionUID = 1L;
  
  FreshNewsManager$1(FreshNewsManager paramFreshNewsManager, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > 100;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */