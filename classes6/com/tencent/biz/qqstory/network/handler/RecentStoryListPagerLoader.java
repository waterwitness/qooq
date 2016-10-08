package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetRecentStoryListRequest;
import com.tencent.biz.qqstory.network.response.GetRecentStoryListResponse;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.Iterator;
import java.util.List;

public class RecentStoryListPagerLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public static final int a = 10;
  public static final String a = "Q.qqstory.home.friend.RecentStoryListPagerLoader";
  public String b;
  
  public RecentStoryListPagerLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(GetRecentStoryListRequest paramGetRecentStoryListRequest, GetRecentStoryListResponse paramGetRecentStoryListResponse, ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.home.friend.RecentStoryListPagerLoader", "get recent story list return :%s", paramErrorMessage);
    RecentStoryListPagerLoader.GetRecentStoryListEvent localGetRecentStoryListEvent = new RecentStoryListPagerLoader.GetRecentStoryListEvent(paramErrorMessage);
    if ((paramGetRecentStoryListResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localGetRecentStoryListEvent);
      return;
    }
    paramErrorMessage = (StoryManager)SuperManager.a(5);
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    paramErrorMessage.a(paramGetRecentStoryListResponse.jdField_a_of_type_JavaUtilList, 1, TextUtils.isEmpty(paramGetRecentStoryListRequest.c));
    QQAppInterface localQQAppInterface = QQStoryContext.a().a();
    Iterator localIterator = paramGetRecentStoryListResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      StoryItem localStoryItem = (StoryItem)localIterator.next();
      QQUserUIItem localQQUserUIItem = StoryListUtils.a(localQQAppInterface, localStoryItem.user.uid, false);
      if (localQQUserUIItem != null)
      {
        localStoryItem.user.copy(localQQUserUIItem);
        localUserManager.a(localQQUserUIItem);
      }
      if (localStoryItem.liveVideo != null) {
        paramErrorMessage.a(localStoryItem.user.uid, localStoryItem.liveVideo);
      } else {
        paramErrorMessage.a(localStoryItem.user.uid);
      }
    }
    localGetRecentStoryListEvent.jdField_a_of_type_JavaUtilList = paramGetRecentStoryListResponse.jdField_a_of_type_JavaUtilList;
    localGetRecentStoryListEvent.jdField_a_of_type_Boolean = paramGetRecentStoryListResponse.jdField_a_of_type_Boolean;
    localGetRecentStoryListEvent.c = TextUtils.isEmpty(paramGetRecentStoryListRequest.c);
    this.b = paramGetRecentStoryListResponse.b;
    localGetRecentStoryListEvent.d = this.jdField_a_of_type_Boolean;
    Dispatchers.get().dispatch(localGetRecentStoryListEvent);
    SLog.a("Q.qqstory.home.friend.RecentStoryListPagerLoader", "dispatch recent story list  result: %s", localGetRecentStoryListEvent);
  }
  
  public void a(TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.b = "";
    d();
  }
  
  public void c()
  {
    super.c();
    d();
  }
  
  public void d()
  {
    GetRecentStoryListRequest localGetRecentStoryListRequest = new GetRecentStoryListRequest();
    localGetRecentStoryListRequest.a = 10;
    localGetRecentStoryListRequest.c = this.b;
    CmdTaskManger.a().a(localGetRecentStoryListRequest, this);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\RecentStoryListPagerLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */