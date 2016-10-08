package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class BubbleManager$BubbleInfoLruCache
  extends BubbleManager.LruLinkedHashMap
{
  private static final long serialVersionUID = 1L;
  
  public BubbleManager$BubbleInfoLruCache(BubbleManager paramBubbleManager, int paramInt)
  {
    super(paramBubbleManager, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void clear()
  {
    Iterator localIterator = values().iterator();
    while (localIterator.hasNext()) {
      ((BubbleInfo)localIterator.next()).a();
    }
    super.clear();
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    if (size() > this.maxCapacity)
    {
      if (QLog.isColorLevel()) {
        QLog.d(BubbleManager.a, 2, "entryRemoved key=" + paramEntry.getKey());
      }
      ((BubbleInfo)paramEntry.getValue()).a();
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\bubble\BubbleManager$BubbleInfoLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */