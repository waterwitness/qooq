package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetTopicVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetTopicVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class TopicVideoListPagerLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public static final int a = 20;
  public static final String a = "Q.qqstory.home.hot:TopicVideoListPagerLoader";
  public String b;
  public final long c;
  
  public TopicVideoListPagerLoader(long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = "";
    this.c = paramLong;
  }
  
  private void d()
  {
    GetTopicVideoListRequest localGetTopicVideoListRequest = new GetTopicVideoListRequest();
    localGetTopicVideoListRequest.d = 20;
    localGetTopicVideoListRequest.c = this.b;
    localGetTopicVideoListRequest.jdField_a_of_type_Long = this.c;
    CmdTaskManger.a().a(localGetTopicVideoListRequest, this);
  }
  
  public void a(GetTopicVideoListRequest paramGetTopicVideoListRequest, GetTopicVideoListResponse paramGetTopicVideoListResponse, ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.home.hot:TopicVideoListPagerLoader", "get video list return:%s", paramErrorMessage);
    TopicVideoListPagerLoader.GetTopicVideoEvent localGetTopicVideoEvent = new TopicVideoListPagerLoader.GetTopicVideoEvent(paramErrorMessage);
    if ((paramGetTopicVideoListResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localGetTopicVideoEvent);
      return;
    }
    localGetTopicVideoEvent.b = paramGetTopicVideoListResponse.jdField_a_of_type_Long;
    localGetTopicVideoEvent.jdField_a_of_type_Int = paramGetTopicVideoListResponse.b;
    boolean bool = TextUtils.isEmpty(paramGetTopicVideoListRequest.c);
    localGetTopicVideoEvent.jdField_a_of_type_JavaUtilList = paramGetTopicVideoListResponse.jdField_a_of_type_JavaUtilList;
    localGetTopicVideoEvent.jdField_a_of_type_Long = paramGetTopicVideoListRequest.jdField_a_of_type_Long;
    localGetTopicVideoEvent.jdField_a_of_type_Boolean = paramGetTopicVideoListResponse.jdField_a_of_type_Boolean;
    localGetTopicVideoEvent.c = bool;
    this.b = paramGetTopicVideoListResponse.c;
    localGetTopicVideoEvent.d = this.jdField_a_of_type_Boolean;
    localGetTopicVideoEvent.jdField_a_of_type_JavaLangString = this.b;
    Dispatchers.get().dispatch(localGetTopicVideoEvent);
    SLog.a("Q.qqstory.home.hot:TopicVideoListPagerLoader", "dispatch video list return from network: %s", localGetTopicVideoEvent);
  }
  
  public void a(TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.b = "";
    d();
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\TopicVideoListPagerLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */