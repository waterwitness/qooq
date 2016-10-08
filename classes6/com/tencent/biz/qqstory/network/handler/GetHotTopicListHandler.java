package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.GetHotTopicListRequest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import ijy;
import ijz;

public class GetHotTopicListHandler
{
  private static final String a = "Q.qqstory.home.hot.GetHotTopicListHandler";
  
  public GetHotTopicListHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    GetHotTopicListRequest localGetHotTopicListRequest = new GetHotTopicListRequest();
    CmdTaskManger.a().a(localGetHotTopicListRequest, new ijy(this));
  }
  
  public void b()
  {
    Bosses.get().postJob(new ijz(this));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\GetHotTopicListHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */