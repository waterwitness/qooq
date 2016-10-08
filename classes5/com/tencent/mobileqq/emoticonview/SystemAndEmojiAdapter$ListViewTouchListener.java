package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SystemAndEmojiAdapter$ListViewTouchListener
  implements EmotionPanelListViewTouchListener
{
  public SystemAndEmojiAdapter$ListViewTouchListener(SystemAndEmojiAdapter paramSystemAndEmojiAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    SystemAndEmojiAdapter.a(this.a, null);
    SystemAndEmojiAdapter.a(this.a, false);
    if (this.a.a() != null)
    {
      this.a.a().setTouchEventListener(null);
      int i = this.a.a().getScrollY();
      this.a.a().f(i, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\SystemAndEmojiAdapter$ListViewTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */