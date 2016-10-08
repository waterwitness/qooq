package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager.InnerVideoItem;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.WatchVideoBatchRequest;
import com.tencent.biz.qqstory.network.response.WatchVideoBatchResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WatchVideoBatchHandler
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public static int a = 0;
  private static final String a = "Q.qqstory:WatchVideoBatchHandler";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 20;
  }
  
  public WatchVideoBatchRequest a(int paramInt, ArrayList paramArrayList)
  {
    if (paramArrayList.size() > jdField_a_of_type_Int) {
      SLog.d("Q.qqstory:WatchVideoBatchHandler", "too much data");
    }
    WatchVideoBatchRequest localWatchVideoBatchRequest = new WatchVideoBatchRequest();
    localWatchVideoBatchRequest.jdField_a_of_type_Int = paramInt;
    localWatchVideoBatchRequest.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    CmdTaskManger.a().a(localWatchVideoBatchRequest, this);
    return localWatchVideoBatchRequest;
  }
  
  public void a(WatchVideoBatchRequest paramWatchVideoBatchRequest, WatchVideoBatchResponse paramWatchVideoBatchResponse, ErrorMessage paramErrorMessage)
  {
    ReportWatchVideoManager localReportWatchVideoManager = (ReportWatchVideoManager)SuperManager.a(13);
    if ((paramWatchVideoBatchResponse == null) || (paramErrorMessage.isFail())) {
      paramWatchVideoBatchResponse = paramWatchVideoBatchRequest.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    while (paramWatchVideoBatchResponse.hasNext())
    {
      paramErrorMessage = (ReportWatchVideoManager.InnerVideoItem)paramWatchVideoBatchResponse.next();
      localReportWatchVideoManager.a(paramErrorMessage.jdField_a_of_type_JavaLangString, paramErrorMessage.jdField_a_of_type_Long, paramErrorMessage.jdField_a_of_type_Boolean, paramErrorMessage.b, false);
      continue;
      localReportWatchVideoManager.a(paramWatchVideoBatchResponse.a);
      paramErrorMessage = paramWatchVideoBatchRequest.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramErrorMessage.hasNext())
      {
        ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = (ReportWatchVideoManager.InnerVideoItem)paramErrorMessage.next();
        if (!paramWatchVideoBatchResponse.a.contains(localInnerVideoItem)) {
          localReportWatchVideoManager.a(localInnerVideoItem.jdField_a_of_type_JavaLangString, localInnerVideoItem.jdField_a_of_type_Long, localInnerVideoItem.jdField_a_of_type_Boolean, localInnerVideoItem.b, false);
        }
      }
    }
    localReportWatchVideoManager.a(paramWatchVideoBatchRequest);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\WatchVideoBatchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */