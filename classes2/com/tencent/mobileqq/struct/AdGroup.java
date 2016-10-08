package com.tencent.mobileqq.struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AdGroup
  implements Serializable
{
  public int currentIndex;
  public List listAD;
  
  public AdGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.listAD = new LinkedList();
  }
  
  public boolean add(AdData paramAdData)
  {
    if ((paramAdData != null) && (paramAdData.jump_url != null) && (paramAdData.jump_url.length() > 0))
    {
      Iterator localIterator = this.listAD.iterator();
      AdData localAdData;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localAdData = (AdData)localIterator.next();
      } while (!paramAdData.jump_url.equals(localAdData.jump_url));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.listAD.add(paramAdData);
      }
      for (boolean bool = true;; bool = false)
      {
        if ((QLog.isColorLevel()) && (paramAdData != null)) {
          QLog.d("AdGroup", 2, "add AD=" + bool + " pos=" + paramAdData.position + " jumpUrl=" + paramAdData.jump_url);
        }
        return bool;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\struct\AdGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */