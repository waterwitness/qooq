package com.tencent.biz.qqstory.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.DoodleEmojiItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.Comparator;

public class DoodleEmojiManager$DoodleEmojiItemComparator
  implements Comparator
{
  private final String a;
  
  public DoodleEmojiManager$DoodleEmojiItemComparator(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
  
  public int a(DoodleEmojiItem paramDoodleEmojiItem1, DoodleEmojiItem paramDoodleEmojiItem2)
  {
    if (TextUtils.equals(this.a, paramDoodleEmojiItem2.a)) {}
    label52:
    label65:
    label95:
    label100:
    label105:
    label111:
    long l;
    do
    {
      int i;
      int j;
      do
      {
        return 1;
        paramDoodleEmojiItem1 = paramDoodleEmojiItem1.a();
        paramDoodleEmojiItem2 = paramDoodleEmojiItem2.a();
        if (paramDoodleEmojiItem1 != null)
        {
          paramDoodleEmojiItem1 = new File(paramDoodleEmojiItem1);
          if (paramDoodleEmojiItem2 == null) {
            break label95;
          }
          paramDoodleEmojiItem2 = new File(paramDoodleEmojiItem2);
          if ((paramDoodleEmojiItem1 == null) || (!paramDoodleEmojiItem1.exists())) {
            break label100;
          }
          i = 1;
          if ((paramDoodleEmojiItem2 == null) || (!paramDoodleEmojiItem2.exists())) {
            break label105;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i != 0) || (j != 0)) {
            break label111;
          }
          return 0;
          paramDoodleEmojiItem1 = null;
          break;
          paramDoodleEmojiItem2 = null;
          break label52;
          i = 0;
          break label65;
        }
      } while (i == 0);
      if (j == 0) {
        return -1;
      }
      l = paramDoodleEmojiItem1.lastModified();
    } while (paramDoodleEmojiItem2.lastModified() < l);
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\DoodleEmojiManager$DoodleEmojiItemComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */