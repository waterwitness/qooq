package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.DeleteVideoRequest;
import com.tencent.biz.qqstory.network.response.DeleteVideoRespond;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class DeleteStoryVideoHandler
  implements CmdTaskManger.CommandCallback
{
  public static final String a = "Q.qqstory.player:DeleteStoryVideoHandler";
  
  public DeleteStoryVideoHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(DeleteVideoRequest paramDeleteVideoRequest, DeleteVideoRespond paramDeleteVideoRespond, ErrorMessage paramErrorMessage)
  {
    SLog.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramDeleteVideoRespond = new DeleteStoryVideoEvent(paramErrorMessage, paramDeleteVideoRequest.b, false);
    if (paramErrorMessage.isFail())
    {
      Dispatchers.get().dispatch(paramDeleteVideoRespond);
      return;
    }
    ((StoryManager)SuperManager.a(5)).a(paramDeleteVideoRequest.b);
    Dispatchers.get().dispatch(paramDeleteVideoRespond);
  }
  
  public void a(String paramString)
  {
    paramString = new DeleteVideoRequest(paramString);
    CmdTaskManger.a().a(paramString, this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\DeleteStoryVideoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */