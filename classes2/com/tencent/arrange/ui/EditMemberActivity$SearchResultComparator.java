package com.tencent.arrange.ui;

import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class EditMemberActivity$SearchResultComparator
  implements Comparator
{
  public EditMemberActivity$SearchResultComparator(EditMemberActivity paramEditMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(TroopMemberListActivity.ATroopMember paramATroopMember1, TroopMemberListActivity.ATroopMember paramATroopMember2)
  {
    return paramATroopMember1.g.compareToIgnoreCase(paramATroopMember2.g);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\arrange\ui\EditMemberActivity$SearchResultComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */