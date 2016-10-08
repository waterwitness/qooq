package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetUserVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetUserVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.List;

public class UserVideoListPagerLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public static final int a = 20;
  public static final String a = "VideoListPagerLoader";
  protected final int b;
  protected String b;
  public final long c;
  
  public UserVideoListPagerLoader(long paramLong, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "";
    this.c = paramLong;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void d()
  {
    GetUserVideoListRequest localGetUserVideoListRequest = new GetUserVideoListRequest();
    localGetUserVideoListRequest.d = 20;
    localGetUserVideoListRequest.c = this.jdField_b_of_type_JavaLangString;
    localGetUserVideoListRequest.jdField_a_of_type_Long = this.c;
    localGetUserVideoListRequest.e = this.jdField_b_of_type_Int;
    CmdTaskManger.a().a(localGetUserVideoListRequest, this);
  }
  
  public void a(GetUserVideoListRequest paramGetUserVideoListRequest, GetUserVideoListResponse paramGetUserVideoListResponse, ErrorMessage paramErrorMessage)
  {
    SLog.b("VideoListPagerLoader", "get video list return:" + paramErrorMessage);
    UserVideoListPagerLoader.GetStoryVideoListEvent localGetStoryVideoListEvent = new UserVideoListPagerLoader.GetStoryVideoListEvent(paramErrorMessage);
    localGetStoryVideoListEvent.jdField_b_of_type_Int = paramGetUserVideoListRequest.e;
    if ((paramGetUserVideoListResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localGetStoryVideoListEvent);
      return;
    }
    localGetStoryVideoListEvent.jdField_b_of_type_Long = paramGetUserVideoListResponse.jdField_a_of_type_Long;
    localGetStoryVideoListEvent.jdField_a_of_type_Int = paramGetUserVideoListResponse.jdField_b_of_type_Int;
    paramErrorMessage = (StoryManager)SuperManager.a(5);
    Object localObject = paramErrorMessage.a(paramGetUserVideoListRequest.jdField_a_of_type_Long, 0);
    if (localObject != null)
    {
      ((StoryItem)localObject).totalTime = localGetStoryVideoListEvent.jdField_b_of_type_Long;
      ((StoryItem)localObject).videoCount = localGetStoryVideoListEvent.jdField_a_of_type_Int;
      if (this.jdField_b_of_type_Int != 3) {
        break label310;
      }
      paramErrorMessage.a(paramGetUserVideoListRequest.jdField_a_of_type_Long, 1, (StoryItem)localObject);
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(paramGetUserVideoListRequest.c);
      if ((bool) && (paramGetUserVideoListRequest.jdField_a_of_type_Long == QQStoryContext.a().a()))
      {
        localObject = new ArrayList();
        ((List)localObject).addAll(paramErrorMessage.a());
        ((List)localObject).addAll(paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList);
        paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList = ((List)localObject);
      }
      localGetStoryVideoListEvent.jdField_a_of_type_JavaUtilList = paramGetUserVideoListResponse.jdField_a_of_type_JavaUtilList;
      localGetStoryVideoListEvent.jdField_a_of_type_Long = paramGetUserVideoListRequest.jdField_a_of_type_Long;
      localGetStoryVideoListEvent.jdField_a_of_type_Boolean = paramGetUserVideoListResponse.jdField_a_of_type_Boolean;
      localGetStoryVideoListEvent.c = bool;
      this.jdField_b_of_type_JavaLangString = paramGetUserVideoListResponse.c;
      localGetStoryVideoListEvent.d = this.jdField_a_of_type_Boolean;
      localGetStoryVideoListEvent.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      Dispatchers.get().dispatch(localGetStoryVideoListEvent);
      SLog.b("VideoListPagerLoader", "dispatch video list return:" + localGetStoryVideoListEvent);
      return;
      label310:
      paramErrorMessage.a(paramGetUserVideoListRequest.jdField_a_of_type_Long, 0, (StoryItem)localObject);
    }
  }
  
  public void a(TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_b_of_type_JavaLangString = "";
    d();
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\UserVideoListPagerLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */