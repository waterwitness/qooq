package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class Uin2QQItemStep$QQUserUIItemComparator
  implements Comparator
{
  public Uin2QQItemStep$QQUserUIItemComparator()
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
    if ((c == '[') && (paramChar1 == '[')) {
      return String.valueOf(c).compareTo(String.valueOf(paramChar1));
    }
    if (c > paramChar1) {
      return 1;
    }
    if (c < paramChar1) {
      return -1;
    }
    return 0;
  }
  
  public int a(QQUserUIItem paramQQUserUIItem1, QQUserUIItem paramQQUserUIItem2)
  {
    int k = 0;
    int j;
    if (paramQQUserUIItem1.specialCare != paramQQUserUIItem2.specialCare)
    {
      if (paramQQUserUIItem1.specialCare)
      {
        j = -1;
        return j;
      }
      return 1;
    }
    String str = String.valueOf(paramQQUserUIItem1.uid);
    label52:
    label75:
    int i;
    if (!TextUtils.isEmpty(paramQQUserUIItem1.remark))
    {
      str = paramQQUserUIItem1.remark;
      paramQQUserUIItem1 = String.valueOf(paramQQUserUIItem2.uid);
      if (TextUtils.isEmpty(paramQQUserUIItem2.remark)) {
        break label163;
      }
      paramQQUserUIItem1 = paramQQUserUIItem2.remark;
      paramQQUserUIItem2 = ChnToSpell.a(str, 1).toUpperCase().toCharArray();
      paramQQUserUIItem1 = ChnToSpell.a(paramQQUserUIItem1, 1).toUpperCase().toCharArray();
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i >= paramQQUserUIItem2.length) {
        break;
      }
      j = k;
      if (i >= paramQQUserUIItem1.length) {
        break;
      }
      j = a(paramQQUserUIItem2[i], paramQQUserUIItem1[i]);
      if (j != 0)
      {
        return j;
        if (TextUtils.isEmpty(paramQQUserUIItem1.nickName)) {
          break label52;
        }
        str = paramQQUserUIItem1.nickName;
        break label52;
        label163:
        if (TextUtils.isEmpty(paramQQUserUIItem2.nickName)) {
          break label75;
        }
        paramQQUserUIItem1 = paramQQUserUIItem2.nickName;
        break label75;
      }
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\Uin2QQItemStep$QQUserUIItemComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */