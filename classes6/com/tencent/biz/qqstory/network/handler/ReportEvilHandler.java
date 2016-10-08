package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.ReportEvilRequest;
import com.tencent.biz.qqstory.network.response.ReportEvilResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class ReportEvilHandler
  implements CmdTaskManger.CommandCallback
{
  public static final String a = "ReportEvilHandler";
  
  public ReportEvilHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ReportEvilRequest paramReportEvilRequest, ReportEvilResponse paramReportEvilResponse, ErrorMessage paramErrorMessage)
  {
    paramReportEvilRequest = new ReportEvilHandler.ReportEvent(this, paramErrorMessage, paramReportEvilRequest.c, paramReportEvilRequest.a);
    Dispatchers.get().dispatch(paramReportEvilRequest);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new ReportEvilRequest(paramString, paramInt);
    CmdTaskManger.a().a(paramString, this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\ReportEvilHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */