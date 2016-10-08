package com.tencent.mobileqq.app;

import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class LebaUtil$LebaItemComparator
  implements Comparator
{
  public LebaUtil$LebaItemComparator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private boolean a(LebaViewItem paramLebaViewItem)
  {
    return (paramLebaViewItem != null) && (paramLebaViewItem.a != null);
  }
  
  public int a(LebaViewItem paramLebaViewItem1, LebaViewItem paramLebaViewItem2)
  {
    if ((a(paramLebaViewItem1)) && (a(paramLebaViewItem2))) {
      if (paramLebaViewItem1.a.sPriority <= paramLebaViewItem2.a.sPriority) {}
    }
    while (a(paramLebaViewItem1))
    {
      return -1;
      if (paramLebaViewItem1.a.sPriority < paramLebaViewItem2.a.sPriority) {
        return 1;
      }
      return 0;
    }
    if (a(paramLebaViewItem2)) {
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\LebaUtil$LebaItemComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */