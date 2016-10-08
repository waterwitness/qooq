package com.tencent.biz.qqstory.base.preload.storylist.strategy;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.List;

public class NetConditionPolicy
  implements IPolicy
{
  protected static final int a = 50;
  private static final String a = "Q.qqstory.download.preload.NetConditionPolicy";
  protected boolean a;
  
  public NetConditionPolicy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    int i = ((QQStoryManager)QQStoryContext.a().a().getManager(180)).a();
    if (i == 3) {
      return 0;
    }
    if (NetworkState.c())
    {
      this.a = true;
      if ((i == 1) || (i == 2)) {
        return 50;
      }
      return 0;
    }
    this.a = false;
    if (i == 1) {
      return 50;
    }
    return 0;
  }
  
  public void a(PreloadVideoSource paramPreloadVideoSource, List paramList)
  {
    int j = a();
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    ArrayList localArrayList2;
    if (i < j)
    {
      localArrayList2 = new ArrayList();
      if (this.a)
      {
        paramPreloadVideoSource.a(i, localArrayList2);
        label48:
        if (localArrayList2.size() != 0) {
          break label112;
        }
      }
    }
    else
    {
      if (!a(localArrayList1)) {
        break label130;
      }
      SLog.d("Q.qqstory.download.preload.NetConditionPolicy", "this time preload too much , size = " + localArrayList1.size());
    }
    for (;;)
    {
      a(paramList);
      return;
      paramPreloadVideoSource.b(i, localArrayList2);
      break label48;
      label112:
      localArrayList1.addAll(localArrayList2);
      i += 1;
      break;
      label130:
      paramList.addAll(localArrayList1);
    }
  }
  
  public void a(List paramList) {}
  
  protected boolean a(List paramList)
  {
    return paramList.size() > FileUtils.b() / 1024L / 1024L * 0.33D;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\strategy\NetConditionPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */