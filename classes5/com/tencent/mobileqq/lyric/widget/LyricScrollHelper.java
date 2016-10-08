package com.tencent.mobileqq.lyric.widget;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LyricScrollHelper
{
  private List a;
  
  public LyricScrollHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = Collections.synchronizedList(new ArrayList());
  }
  
  void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LyricScrollHelper.LyricScrollListener)localIterator.next()).a(paramLong);
    }
  }
  
  public void a(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    this.a.add(paramLyricScrollListener);
  }
  
  void b(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LyricScrollHelper.LyricScrollListener)localIterator.next()).b(paramLong);
    }
  }
  
  public void b(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    this.a.remove(paramLyricScrollListener);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\widget\LyricScrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */