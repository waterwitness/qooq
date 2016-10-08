package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class TroopMemberListActivity$SearchResultComparator
  implements Comparator
{
  public TroopMemberListActivity$SearchResultComparator(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopMemberListActivity.ATroopMember paramATroopMember1, TroopMemberListActivity.ATroopMember paramATroopMember2)
  {
    return paramATroopMember1.g.compareToIgnoreCase(paramATroopMember2.g);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopMemberListActivity$SearchResultComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */