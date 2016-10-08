package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetVideoWatcherListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoWatcherListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class WatcherListPagerLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public static final int a = 20;
  public static final String a = "Q.qqstory.player.WatcherListPagerLoader";
  public String b;
  public String c;
  
  public WatcherListPagerLoader(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = paramString;
  }
  
  private void d()
  {
    GetVideoWatcherListRequest localGetVideoWatcherListRequest = new GetVideoWatcherListRequest();
    localGetVideoWatcherListRequest.a = 20;
    localGetVideoWatcherListRequest.c = this.b;
    localGetVideoWatcherListRequest.d = this.c;
    CmdTaskManger.a().a(localGetVideoWatcherListRequest, this);
  }
  
  public void a(GetVideoWatcherListRequest paramGetVideoWatcherListRequest, GetVideoWatcherListResponse paramGetVideoWatcherListResponse, ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.player.WatcherListPagerLoader", "get watcher list return :" + paramErrorMessage);
    WatcherListPagerLoader.GetWatcherListEvent localGetWatcherListEvent = new WatcherListPagerLoader.GetWatcherListEvent(paramErrorMessage);
    if ((paramGetVideoWatcherListResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localGetWatcherListEvent);
      return;
    }
    localGetWatcherListEvent.jdField_a_of_type_JavaUtilList = paramGetVideoWatcherListResponse.jdField_a_of_type_JavaUtilList;
    localGetWatcherListEvent.jdField_a_of_type_Boolean = paramGetVideoWatcherListResponse.jdField_a_of_type_Boolean;
    localGetWatcherListEvent.c = TextUtils.isEmpty(paramGetVideoWatcherListRequest.c);
    this.b = paramGetVideoWatcherListResponse.b;
    localGetWatcherListEvent.d = this.jdField_a_of_type_Boolean;
    Dispatchers.get().dispatch(localGetWatcherListEvent);
    SLog.b("Q.qqstory.player.WatcherListPagerLoader", "dispatch watchers result: " + localGetWatcherListEvent);
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
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\WatcherListPagerLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */