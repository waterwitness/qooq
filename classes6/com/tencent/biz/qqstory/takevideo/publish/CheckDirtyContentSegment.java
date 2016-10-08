package com.tencent.biz.qqstory.takevideo.publish;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.CheckPublishTextRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import iyl;

public class CheckDirtyContentSegment
  extends JobSegment
{
  private static final String a = "CheckDirtyContentSegment";
  
  public CheckDirtyContentSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    paramJobContext = paramGenerateContext.b();
    String str = paramGenerateContext.a();
    SLog.b("CheckDirtyContentSegment", "checking dirty content : " + paramJobContext + ", " + str);
    CmdTaskManger.a().a(new CheckPublishTextRequest(paramJobContext, str), new iyl(this, paramGenerateContext));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\CheckDirtyContentSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */