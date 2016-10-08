package com.tencent.mobileqq.freshnews;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class FreshNewsManager$FreshNewsComparator
  implements Comparator
{
  public FreshNewsManager$FreshNewsComparator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(FreshNewsInfo paramFreshNewsInfo1, FreshNewsInfo paramFreshNewsInfo2)
  {
    if (paramFreshNewsInfo1.publishTime < paramFreshNewsInfo2.publishTime) {
      return 1;
    }
    if (paramFreshNewsInfo1.publishTime > paramFreshNewsInfo2.publishTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsManager$FreshNewsComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */