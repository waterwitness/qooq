package com.tencent.biz.qqstory.playvideo;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.WatcherListPagerLoader;
import com.tencent.biz.qqstory.network.handler.WatcherListPagerLoader.GetWatcherListEvent;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListView;
import com.tencent.biz.qqstory.playvideo.watcherlist.WatcherItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoryPlayVideoActivity$GetWatcherListReceiver
  extends QQUIEventReceiver
{
  public StoryPlayVideoActivity$GetWatcherListReceiver(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    super(paramStoryPlayVideoActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      QQUserUIItem localQQUserUIItem = (QQUserUIItem)localIterator.next();
      WatcherItem localWatcherItem = new WatcherItem();
      if (!TextUtils.isEmpty(localQQUserUIItem.remark)) {}
      for (paramList = localQQUserUIItem.remark;; paramList = localQQUserUIItem.nickName)
      {
        localWatcherItem.jdField_a_of_type_JavaLangString = paramList;
        localWatcherItem.b = localQQUserUIItem.headUrl;
        localWatcherItem.jdField_a_of_type_Long = localQQUserUIItem.uid;
        localArrayList.add(localWatcherItem);
        break;
      }
    }
    return localArrayList;
  }
  
  public void a(StoryPlayVideoActivity paramStoryPlayVideoActivity, WatcherListPagerLoader.GetWatcherListEvent paramGetWatcherListEvent)
  {
    if (paramStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a() == null) {}
    label65:
    do
    {
      return;
      if (paramGetWatcherListEvent.jdField_a_of_type_JavaUtilList != null)
      {
        if (!paramGetWatcherListEvent.c) {
          break label65;
        }
        paramStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setData(a(paramGetWatcherListEvent.jdField_a_of_type_JavaUtilList));
      }
      while ((paramGetWatcherListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode != 0) && (paramGetWatcherListEvent.c))
      {
        paramStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.a();
        return;
        paramStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.a(a(paramGetWatcherListEvent.jdField_a_of_type_JavaUtilList));
      }
    } while ((paramGetWatcherListEvent.jdField_a_of_type_Boolean) || (paramStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatcherListPagerLoader == null));
    paramStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatcherListPagerLoader.c();
  }
  
  public Class acceptEventClass()
  {
    return WatcherListPagerLoader.GetWatcherListEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\StoryPlayVideoActivity$GetWatcherListReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */