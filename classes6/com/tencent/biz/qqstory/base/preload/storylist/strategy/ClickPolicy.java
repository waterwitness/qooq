package com.tencent.biz.qqstory.base.preload.storylist.strategy;

import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClickPolicy
  implements IPolicy
{
  private static final int jdField_a_of_type_Int = 3;
  private static final String jdField_a_of_type_JavaLangString = "Q.qqstory.download.preload.ClickPolicy";
  private List jdField_a_of_type_JavaUtilList;
  
  public ClickPolicy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  private boolean a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!((StoryVideoItem)paramList.next()).isPreloadSuc(false)) {
        return false;
      }
    }
    return true;
  }
  
  public void a(PreloadVideoSource paramPreloadVideoSource, List paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ClickPolicy.ClickBean localClickBean = (ClickPolicy.ClickBean)localIterator.next();
      List localList = paramPreloadVideoSource.a(localClickBean.a, localClickBean.b);
      if (localList != null)
      {
        int j = localList.size();
        int i = j;
        if (!localClickBean.a.equals(IPreloadVideoSource.c))
        {
          i = j;
          if (j > 3) {
            i = 3;
          }
        }
        localList = localList.subList(0, i);
        if (a(localList)) {
          localArrayList2.add(localClickBean);
        } else {
          localArrayList1.addAll(localList);
        }
      }
      else
      {
        localArrayList2.add(localClickBean);
      }
    }
    paramList.addAll(0, localArrayList1);
    this.a.removeAll(localArrayList2);
    a(paramList);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = new ClickPolicy.ClickBean(paramString1, paramString2);
    if (this.a.indexOf(paramString1) >= 0) {
      return;
    }
    this.a.add(paramString1);
  }
  
  public void a(List paramList)
  {
    SLog.b("Q.qqstory.download.preload.ClickPolicy", "=== begin");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      SLog.b("Q.qqstory.download.preload.ClickPolicy", "video , vid = " + localStoryVideoItem.mVid);
    }
    SLog.b("Q.qqstory.download.preload.ClickPolicy", " === end");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\strategy\ClickPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */