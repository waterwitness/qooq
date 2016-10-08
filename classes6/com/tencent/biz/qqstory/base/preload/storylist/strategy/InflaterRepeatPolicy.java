package com.tencent.biz.qqstory.base.preload.storylist.strategy;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class InflaterRepeatPolicy
  implements IPolicy
{
  private static final String a = "Q.qqstory.download.preload.InflaterRepeatPolicy";
  
  public InflaterRepeatPolicy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList)
  {
    SLog.b("Q.qqstory.download.preload.InflaterRepeatPolicy", "=== begin , size = " + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      SLog.b("Q.qqstory.download.preload.InflaterRepeatPolicy", "video , vid = " + localStoryVideoItem.mVid);
    }
    SLog.b("Q.qqstory.download.preload.InflaterRepeatPolicy", " === end");
  }
  
  public void b(List paramList)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (!localHashSet.add((StoryVideoItem)localIterator.next())) {
        localIterator.remove();
      }
    }
    a(paramList);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\strategy\InflaterRepeatPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */