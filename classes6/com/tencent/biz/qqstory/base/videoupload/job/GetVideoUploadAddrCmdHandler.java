package com.tencent.biz.qqstory.base.videoupload.job;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetVideoUploadAddrRequest;
import com.tencent.biz.qqstory.network.response.GetVideoUploadAddrResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class GetVideoUploadAddrCmdHandler
  extends JobSegment
  implements CmdTaskManger.CommandCallback
{
  public GetVideoUploadAddrCmdHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(GetVideoUploadAddrRequest paramGetVideoUploadAddrRequest)
  {
    CmdTaskManger.a().a(paramGetVideoUploadAddrRequest, this);
  }
  
  public void a(GetVideoUploadAddrRequest paramGetVideoUploadAddrRequest, GetVideoUploadAddrResponse paramGetVideoUploadAddrResponse, ErrorMessage paramErrorMessage)
  {
    paramGetVideoUploadAddrRequest = new GetVideoUploadAddrCmdHandler.ApplyUploadResultEvent();
    paramGetVideoUploadAddrRequest.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if (paramErrorMessage.isFail())
    {
      super.notifyError(paramErrorMessage);
      Dispatchers.get().dispatch(paramGetVideoUploadAddrRequest);
      return;
    }
    paramGetVideoUploadAddrRequest.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetVideoUploadAddrResponse = paramGetVideoUploadAddrResponse;
    super.notifyResult(paramGetVideoUploadAddrRequest);
    Dispatchers.get().dispatch(paramGetVideoUploadAddrRequest);
  }
  
  protected void a(JobContext paramJobContext, GetVideoUploadAddrRequest paramGetVideoUploadAddrRequest)
  {
    a(paramGetVideoUploadAddrRequest);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\job\GetVideoUploadAddrCmdHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */