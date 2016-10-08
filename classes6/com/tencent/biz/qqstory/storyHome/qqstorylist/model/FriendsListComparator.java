package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class FriendsListComparator
  implements Comparator
{
  public FriendsListComparator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(char paramChar1, char paramChar2)
  {
    char c;
    if (paramChar1 >= 'A')
    {
      c = paramChar1;
      if (paramChar1 <= 'Z') {}
    }
    else
    {
      c = '[';
    }
    if (paramChar2 >= 'A')
    {
      paramChar1 = paramChar2;
      if (paramChar2 <= 'Z') {}
    }
    else
    {
      paramChar1 = '[';
    }
    if (c > paramChar1) {
      return 1;
    }
    if (c < paramChar1) {
      return -1;
    }
    return 0;
  }
  
  public int a(StoryItem paramStoryItem1, StoryItem paramStoryItem2)
  {
    int k = 0;
    int j;
    if (paramStoryItem1.user.specialCare != paramStoryItem2.user.specialCare)
    {
      if (paramStoryItem1.user.specialCare)
      {
        j = -1;
        return j;
      }
      return 1;
    }
    String str = String.valueOf(paramStoryItem1.user.uid);
    label70:
    label102:
    int i;
    if (!TextUtils.isEmpty(paramStoryItem1.user.remark))
    {
      str = paramStoryItem1.user.remark;
      paramStoryItem1 = String.valueOf(paramStoryItem2.user.uid);
      if (TextUtils.isEmpty(paramStoryItem2.user.remark)) {
        break label196;
      }
      paramStoryItem1 = paramStoryItem2.user.remark;
      paramStoryItem2 = ChnToSpell.a(str, 1).toUpperCase().toCharArray();
      paramStoryItem1 = ChnToSpell.a(paramStoryItem1, 1).toUpperCase().toCharArray();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i >= paramStoryItem2.length) {
        break;
      }
      j = k;
      if (i >= paramStoryItem1.length) {
        break;
      }
      j = a(paramStoryItem2[i], paramStoryItem1[i]);
      if (j != 0)
      {
        return j;
        if (TextUtils.isEmpty(paramStoryItem1.user.nickName)) {
          break label70;
        }
        str = paramStoryItem1.user.nickName;
        break label70;
        label196:
        if (TextUtils.isEmpty(paramStoryItem2.user.nickName)) {
          break label102;
        }
        paramStoryItem1 = paramStoryItem2.user.nickName;
        break label102;
      }
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\FriendsListComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */