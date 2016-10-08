package com.tencent.mobileqq.app;

import QQService.UserProfile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class LBSHandler$UserProfileComparator
  implements Comparator
{
  public LBSHandler$UserProfileComparator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(UserProfile paramUserProfile1, UserProfile paramUserProfile2)
  {
    return paramUserProfile2.lTime - paramUserProfile1.lTime;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\LBSHandler$UserProfileComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */