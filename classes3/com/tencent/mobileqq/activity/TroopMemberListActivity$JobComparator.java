package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class TroopMemberListActivity$JobComparator
  implements Comparator
{
  protected TroopMemberListActivity$JobComparator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(String paramString1, String paramString2)
  {
    return ChnToSpell.a(paramString1, 2).compareToIgnoreCase(ChnToSpell.a(paramString2, 2));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopMemberListActivity$JobComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */