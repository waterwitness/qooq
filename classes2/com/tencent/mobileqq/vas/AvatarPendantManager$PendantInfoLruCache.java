package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class AvatarPendantManager$PendantInfoLruCache
  extends AvatarPendantManager.LruLinkedHashMap
{
  private static final long serialVersionUID = 1L;
  
  public AvatarPendantManager$PendantInfoLruCache(AvatarPendantManager paramAvatarPendantManager, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void clear()
  {
    Iterator localIterator = values().iterator();
    while (localIterator.hasNext()) {
      ((PendantInfo)localIterator.next()).a(true);
    }
    super.clear();
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    if (size() > this.maxCapacity)
    {
      if (QLog.isColorLevel()) {
        QLog.d(AvatarPendantManager.a, 2, "entryRemoved key=" + paramEntry.getKey());
      }
      ((PendantInfo)paramEntry.getValue()).a(true);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\AvatarPendantManager$PendantInfoLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */