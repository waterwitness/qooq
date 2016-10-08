package com.tencent.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRULinkedHashMap
  extends LinkedHashMap
{
  private static final float a = 0.75F;
  private static final long serialVersionUID = 1L;
  private final int maxCapacity;
  
  public LRULinkedHashMap(int paramInt)
  {
    super(paramInt, 0.75F, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.maxCapacity = paramInt;
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.maxCapacity;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\LRULinkedHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */