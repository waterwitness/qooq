package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class PendantInfo$AnimationLruCache
  extends AvatarPendantManager.LruLinkedHashMap
{
  private static final long serialVersionUID = 1L;
  
  public PendantInfo$AnimationLruCache(PendantInfo paramPendantInfo, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void clear()
  {
    Iterator localIterator = values().iterator();
    while (localIterator.hasNext())
    {
      VipPendantDrawable localVipPendantDrawable = (VipPendantDrawable)localIterator.next();
      localVipPendantDrawable.setCallback(null);
      localVipPendantDrawable.a();
    }
    super.clear();
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    if (size() > this.maxCapacity)
    {
      paramEntry = (VipPendantDrawable)paramEntry.getValue();
      paramEntry.setCallback(null);
      paramEntry.a();
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\PendantInfo$AnimationLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */