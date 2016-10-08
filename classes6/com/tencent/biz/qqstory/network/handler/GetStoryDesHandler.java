package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetStoryDesRequest;
import com.tencent.biz.qqstory.network.response.GetStoryDesResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.List;

public class GetStoryDesHandler
  implements CmdTaskManger.CommandCallback
{
  public static final String a = "Q.qqstory.home.Repository.GetStoryDesHandler";
  
  public GetStoryDesHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GetStoryDesRequest paramGetStoryDesRequest, GetStoryDesResponse paramGetStoryDesResponse, ErrorMessage paramErrorMessage)
  {
    GetStoryDesHandler.GetStoryDesListEvent localGetStoryDesListEvent = new GetStoryDesHandler.GetStoryDesListEvent();
    localGetStoryDesListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localGetStoryDesListEvent.b = paramGetStoryDesRequest.jdField_a_of_type_JavaUtilList;
    if ((paramGetStoryDesResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localGetStoryDesListEvent);
      return;
    }
    localGetStoryDesListEvent.jdField_a_of_type_JavaUtilList = paramGetStoryDesResponse.jdField_a_of_type_JavaUtilList;
    Dispatchers.get().dispatch(localGetStoryDesListEvent);
  }
  
  public void a(List paramList)
  {
    GetStoryDesRequest localGetStoryDesRequest = new GetStoryDesRequest();
    localGetStoryDesRequest.jdField_a_of_type_JavaUtilList = paramList;
    CmdTaskManger.a().a(localGetStoryDesRequest, this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\GetStoryDesHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */