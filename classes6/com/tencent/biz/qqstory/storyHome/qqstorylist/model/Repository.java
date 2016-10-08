package com.tencent.biz.qqstory.storyHome.qqstorylist.model;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.preload.storylist.FirstVideoManager;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.HotTopicItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.UserVideoListPagerLoader.GetStoryVideoListEvent;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler.WatchVideoEvent;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetMediaStory;
import com.tencent.biz.qqstory.network.response.GetOfficialRecommendStoryListResponse;
import com.tencent.biz.qqstory.pgc.model.RecommendItem;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.AsyncStepExector;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetFriendsVideoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetHotTopicVideoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetPreloadVideoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetRecentVideoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.StepExector;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.IMyStroyPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import irq;
import irr;
import irw;
import irx;
import iry;
import isc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Repository
  implements IEventReceiver
{
  public static final int a = 50;
  public static final String a = "Q.qqstory.home.Repository";
  public long a;
  public Context a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  protected StoryManager a;
  protected UserManager a;
  protected MyStorys a;
  protected Repository.DeleteStoryVideoReceiver a;
  public Repository.RecentStoryFinishReceiver a;
  public Repository.ShieldFriendStoryReceiver a;
  protected Repository.StoryVideoPublishStatusReceiver a;
  protected Repository.WatchVideoReceiver a;
  public AsyncStepExector a;
  public StepExector a;
  private IMyStroyPresenter jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter;
  protected ArrayList a;
  protected HashMap a;
  public boolean a;
  protected Handler b;
  protected StoryManager b;
  public StepExector b;
  protected ArrayList b;
  protected HashMap b;
  public StepExector c;
  protected ArrayList c;
  public HashMap c;
  protected ArrayList d;
  public ArrayList e;
  public ArrayList f;
  
  public Repository(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(paramContext.getMainLooper());
    this.jdField_b_of_type_ComTencentBizQqstoryModelStoryManager = ((StoryManager)SuperManager.a(5));
    this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager = ((UserManager)SuperManager.a(2));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys = new MyStorys();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.d = new ArrayList();
    this.e = new ArrayList();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$StoryVideoPublishStatusReceiver = new Repository.StoryVideoPublishStatusReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$DeleteStoryVideoReceiver = new Repository.DeleteStoryVideoReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$WatchVideoReceiver = new Repository.WatchVideoReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$RecentStoryFinishReceiver = new Repository.RecentStoryFinishReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$ShieldFriendStoryReceiver = new Repository.ShieldFriendStoryReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager = ((StoryManager)SuperManager.a(5));
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.a("QQ_Story_Sub", 0);
  }
  
  private void a(long paramLong)
  {
    SLog.b("Q.qqstory.home.Repository", "receiver Recent story finish event,uin=" + paramLong);
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        Object localObject1 = (StoryItem)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (((StoryItem)localObject1).user.uid == paramLong)
        {
          if (this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) != null)
          {
            this.jdField_c_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
            Object localObject2 = new StoryItem();
            ((StoryItem)localObject2).copy(localObject1);
            ((StoryItem)localObject2).key = StoryItem.makeFriendKey(((StoryItem)localObject1).user.uid);
            ((StoryItem)localObject2).type = 0;
            ((StoryItem)localObject2).user.specialCare = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.a().contains(String.valueOf(((StoryItem)localObject2).user.uid));
            b((StoryItem)localObject2);
            Collections.sort(this.jdField_c_of_type_JavaUtilArrayList, new FriendsListComparator());
            localObject1 = new ArrayList();
            localObject2 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((List)localObject1).add(String.valueOf(((StoryItem)((Iterator)localObject2).next()).user.uid));
            }
            ((StoryManager)SuperManager.a(5)).a().a(IPreloadVideoSource.b, (List)localObject1);
            this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(this.jdField_c_of_type_JavaUtilArrayList, 0, true);
          }
          a(i);
          b(paramLong);
          a(true, true);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    StoryVideoItem localStoryVideoItem2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(paramStoryVideoPublishStatusEvent.a.mVid);
    StoryVideoItem localStoryVideoItem1 = localStoryVideoItem2;
    if (localStoryVideoItem2 == null)
    {
      localStoryVideoItem1 = paramStoryVideoPublishStatusEvent.a;
      SLog.b("Q.qqstory.home.Repository", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(paramStoryVideoPublishStatusEvent.a);
    }
    SLog.b("Q.qqstory.home.Repository", "handleStoryVideoPublishEvent fake vid = " + paramStoryVideoPublishStatusEvent.a.mVid + ",item.mUploadStatus=" + localStoryVideoItem1.mUploadStatus);
    switch (localStoryVideoItem1.mUploadStatus)
    {
    }
    for (;;)
    {
      a(true, true);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b(localStoryVideoItem1);
      j();
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b(localStoryVideoItem1);
      j();
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(localStoryVideoItem1.mVid, paramStoryVideoPublishStatusEvent.b);
      j();
    }
  }
  
  private void a(DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    if (paramDeleteStoryVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      SLog.d("Q.qqstory.home.Repository", "deleted story failed");
      return;
    }
    a(paramDeleteStoryVideoEvent.jdField_a_of_type_JavaLangString);
  }
  
  private void a(UserVideoListPagerLoader.GetStoryVideoListEvent paramGetStoryVideoListEvent) {}
  
  private void a(WatchVideoHandler.WatchVideoEvent paramWatchVideoEvent)
  {
    int i = 0;
    if (paramWatchVideoEvent == null) {
      SLog.e("Q.qqstory.home.Repository", "handleWatchVideoStoryEvent is null!");
    }
    for (;;)
    {
      return;
      if ((paramWatchVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (paramWatchVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        SLog.d("Q.qqstory.home.Repository", "handleWatchVideoStoryEvent uid:" + paramWatchVideoEvent.jdField_a_of_type_Long + ", error:" + paramWatchVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage());
      }
      SLog.b("Q.qqstory.home.Repository", "handleWatchVideoStoryEvent uid:" + paramWatchVideoEvent.jdField_a_of_type_Long + ", isLive:" + paramWatchVideoEvent.jdField_a_of_type_Boolean);
      if (paramWatchVideoEvent.jdField_a_of_type_Boolean)
      {
        while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          if (((StoryItem)this.jdField_b_of_type_JavaUtilArrayList.get(i)).user.uid == paramWatchVideoEvent.jdField_a_of_type_Long)
          {
            SLog.b("Q.qqstory.home.Repository", "deleted the recentItem id=" + i);
            a(i);
          }
          i += 1;
        }
      }
      else
      {
        i = 0;
        while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          Object localObject = (StoryItem)this.jdField_b_of_type_JavaUtilArrayList.get(i);
          if (((StoryItem)localObject).user.uid == paramWatchVideoEvent.jdField_a_of_type_Long)
          {
            ((StoryItem)localObject).makeRead(paramWatchVideoEvent.jdField_a_of_type_JavaLangString);
            ((StoryItem)localObject).unReadCount = paramWatchVideoEvent.jdField_a_of_type_Int;
            if (((StoryItem)localObject).unReadCount == 0)
            {
              SLog.b("Q.qqstory.home.Repository", "deleted the recentItem id=" + i);
              a(i);
            }
            if (this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramWatchVideoEvent.jdField_a_of_type_Long)) != null)
            {
              this.jdField_c_of_type_JavaUtilHashMap.remove(Long.valueOf(paramWatchVideoEvent.jdField_a_of_type_Long));
              paramWatchVideoEvent = new StoryItem();
              paramWatchVideoEvent.copy(localObject);
              paramWatchVideoEvent.key = StoryItem.makeFriendKey(((StoryItem)localObject).user.uid);
              paramWatchVideoEvent.type = 0;
              paramWatchVideoEvent.user.specialCare = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.a().contains(String.valueOf(paramWatchVideoEvent.user.uid));
              b(paramWatchVideoEvent);
              Collections.sort(this.jdField_c_of_type_JavaUtilArrayList, new FriendsListComparator());
              paramWatchVideoEvent = new ArrayList();
              localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject).hasNext()) {
                paramWatchVideoEvent.add(String.valueOf(((StoryItem)((Iterator)localObject).next()).user.uid));
              }
              ((StoryManager)SuperManager.a(5)).a().a(IPreloadVideoSource.b, paramWatchVideoEvent);
              this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(this.jdField_c_of_type_JavaUtilArrayList, 0, true);
            }
            a(true, true);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.e == null) || (this.e.size() == 0)) {
      return;
    }
    SLog.d("Q.qqstory.home.Repository", "requestNextPageFriendsStoryData loopToLast=%s,uinList count=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.e.size()) });
    if (!b())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "当前网络不可用，请检查你的网络设置", 0).a();
      return;
    }
    a(new iry(this, paramBoolean));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Repository.RepositoryUpdateEvent localRepositoryUpdateEvent = new Repository.RepositoryUpdateEvent();
    localRepositoryUpdateEvent.b = paramBoolean2;
    localRepositoryUpdateEvent.jdField_a_of_type_Boolean = paramBoolean1;
    SLog.a("Q.qqstory.home.Repository", "sendUpdateEvent isLocale=%s,repositoryUpdated=%s", Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1));
    Dispatchers.get().dispatch(localRepositoryUpdateEvent);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Repository.RepositoryUpdateEvent localRepositoryUpdateEvent = new Repository.RepositoryUpdateEvent();
    localRepositoryUpdateEvent.b = paramBoolean2;
    localRepositoryUpdateEvent.jdField_a_of_type_Boolean = paramBoolean1;
    localRepositoryUpdateEvent.d = paramBoolean3;
    SLog.a("Q.qqstory.home.Repository", "sendUpdateEvent isLocale=%s,repositoryUpdated=%s,allDataRequestStepCompleted=%s", Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3));
    Dispatchers.get().dispatch(localRepositoryUpdateEvent);
  }
  
  private boolean a()
  {
    ArrayList localArrayList = ((StoryManager)SuperManager.a(5)).a();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.d.clear();
      this.d.addAll(localArrayList);
      SLog.d("Q.qqstory.home.Repository", "updateHotTopicListFromDB have %s data", new Object[] { Integer.valueOf(this.d.size()) });
      return true;
    }
    SLog.d("Q.qqstory.home.Repository", "updateHotTopicListFromDB have no data");
    return false;
  }
  
  private void b(long paramLong)
  {
    SLog.b("Q.qqstory.home.Repository", "deleteRecentStoryCacheInDB:" + paramLong);
    this.jdField_b_of_type_ComTencentBizQqstoryModelStoryManager.a(paramLong, 1);
  }
  
  private boolean b()
  {
    return NetworkUtils.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private boolean c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject = ((QQStoryManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(180)).a("StorySvc.pgc_subscribe_media_list");
    if (localObject != null)
    {
      qqstory_pgc.RspGetMediaStory localRspGetMediaStory = new qqstory_pgc.RspGetMediaStory();
      try
      {
        localRspGetMediaStory.mergeFrom((byte[])localObject);
        localObject = new GetOfficialRecommendStoryListResponse(localRspGetMediaStory, true).a;
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          return true;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        SLog.d("Q.qqstory.home.Repository", "" + localInvalidProtocolBufferMicroException);
        return false;
      }
    }
    return false;
  }
  
  private boolean d()
  {
    Object localObject1 = ((StoryManager)SuperManager.a(5)).a(0);
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      SLog.d("Q.qqstory.home.Repository", "updateFriendStoryFromDB have no data!");
      return false;
    }
    Object localObject2 = ((QQStoryManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(180)).a(false);
    HashMap localHashMap = new HashMap(((List)localObject2).size());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      QQStoryUserInfo localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject2).next();
      localHashMap.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
    }
    f();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryItem)((Iterator)localObject1).next();
      if ((((StoryItem)localObject2).user != null) && (((StoryItem)localObject2).user.uid != 0L) && (localHashMap.get(String.valueOf(((StoryItem)localObject2).user.uid)) == null)) {
        b((StoryItem)localObject2);
      }
    }
    Collections.sort(this.jdField_c_of_type_JavaUtilArrayList, new FriendsListComparator());
    SLog.d("Q.qqstory.home.Repository", "updateFriendStoryFromDB have %s data", new Object[] { Integer.valueOf(this.jdField_c_of_type_JavaUtilArrayList.size()) });
    return true;
  }
  
  private boolean e()
  {
    Object localObject1 = ((StoryManager)SuperManager.a(5)).a(1);
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      SLog.d("Q.qqstory.home.Repository", "updateRecentStoryFromDB have no data!");
      return false;
    }
    Object localObject2 = ((QQStoryManager)QQStoryContext.a().a().getManager(180)).a(false);
    HashMap localHashMap = new HashMap(((List)localObject2).size());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      QQStoryUserInfo localQQStoryUserInfo = (QQStoryUserInfo)((Iterator)localObject2).next();
      localHashMap.put(localQQStoryUserInfo.uin, localQQStoryUserInfo);
    }
    e();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StoryItem)((Iterator)localObject1).next();
      if ((((StoryItem)localObject2).user != null) && (((StoryItem)localObject2).user.uid != 0L)) {
        if (localHashMap.get(String.valueOf(((StoryItem)localObject2).user.uid)) == null)
        {
          if (((StoryItem)localObject2).unReadCount > 0) {
            a((StoryItem)localObject2);
          } else {
            SLog.e("Q.qqstory.home.Repository", "query the item %s which is unReadCount less than 0 !", new Object[] { Long.valueOf(((StoryItem)localObject2).user.uid) });
          }
        }
        else {
          SLog.d("Q.qqstory.home.Repository", "updateRecentStoryFromDB item %s was be shielded!", new Object[] { Long.valueOf(((StoryItem)localObject2).user.uid) });
        }
      }
    }
    Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new RecentFriendListComparator());
    SLog.d("Q.qqstory.home.Repository", "updateRecentStoryFromDB have %s data", new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
    return true;
  }
  
  private boolean f()
  {
    List localList = ((StoryManager)SuperManager.a(5)).c(QQStoryContext.a().a());
    if (localList.size() == 0)
    {
      SLog.d("Q.qqstory.home.Repository", "Story DB have no mystory data!");
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(localList);
    Collections.sort(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a());
    SLog.d("Q.qqstory.home.Repository", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a()) });
    return true;
  }
  
  private void g()
  {
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$StoryVideoPublishStatusReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$DeleteStoryVideoReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$WatchVideoReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$RecentStoryFinishReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$ShieldFriendStoryReceiver);
  }
  
  private void h()
  {
    ((StoryConfigManager)SuperManager.a(10)).b("story_list_request_data_from_net_running_state", Integer.valueOf(0));
    new irq(this).a(new Void[0]);
  }
  
  private void i()
  {
    int j = 0;
    SLog.b("Q.qqstory.home.Repository", "start preLoadStep");
    Object localObject1 = (StoryManager)SuperManager.a(5);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.b();
    localObject1 = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      ((ArrayList)localObject1).add(Long.valueOf(((StoryItem)this.jdField_b_of_type_JavaUtilArrayList.get(i)).user.uid));
      localObject2 = localObject1;
      if (((ArrayList)localObject1).size() >= 10)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetPreloadVideoStep(this, IPreloadVideoSource.jdField_a_of_type_JavaLangString, (List)localObject1, null));
        localObject2 = new ArrayList();
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (((ArrayList)localObject1).size() > 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetPreloadVideoStep(this, IPreloadVideoSource.jdField_a_of_type_JavaLangString, (List)localObject1, null));
    }
    localObject1 = new ArrayList();
    i = 0;
    while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      ((ArrayList)localObject1).add(Long.valueOf(((StoryItem)this.jdField_c_of_type_JavaUtilArrayList.get(i)).user.uid));
      localObject2 = localObject1;
      if (((ArrayList)localObject1).size() >= 10)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetPreloadVideoStep(this, IPreloadVideoSource.b, (List)localObject1, null));
        localObject2 = new ArrayList();
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (((ArrayList)localObject1).size() > 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetPreloadVideoStep(this, IPreloadVideoSource.b, (List)localObject1, null));
    }
    localObject1 = new ArrayList(6);
    i = 0;
    while (i < this.d.size())
    {
      ((ArrayList)localObject1).add(Long.valueOf(((HotTopicItem)this.d.get(i)).topicId));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetPreloadVideoStep(this, IPreloadVideoSource.d, (List)localObject1, null));
    Object localObject2 = new ArrayList();
    i = j;
    Object localObject3;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject3 = (RecommendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((RecommendItem)localObject3).a != null) {
        ((ArrayList)localObject2).add(((RecommendItem)localObject3).a.unionId);
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetPreloadVideoStep(this, IPreloadVideoSource.e, null, (List)localObject2));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new irw(this)).a();
    localObject2 = b().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (StoryItem)((Iterator)localObject2).next();
      SLog.b("Q.qqstory.home.Repository", "add GetRecentVideoStep:" + ((StoryItem)localObject3).user.uid);
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetRecentVideoStep(this, ((StoryItem)localObject3).user.uid));
    }
    localObject2 = this.f.iterator();
    long l;
    while (((Iterator)localObject2).hasNext())
    {
      l = ((Long)((Iterator)localObject2).next()).longValue();
      SLog.b("Q.qqstory.home.Repository", "add GetRecentVideoStep:" + l);
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetFriendsVideoStep(this, l));
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      l = ((Long)((Iterator)localObject1).next()).longValue();
      SLog.b("Q.qqstory.home.Repository", "add GetHotTopicVideoStep:" + l);
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new GetHotTopicVideoStep(this, l));
    }
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.a(new irx(this)).a();
  }
  
  private void j()
  {
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() - 1);
    ((FirstVideoManager)SuperManager.a(12)).a(IPreloadVideoSource.c, String.valueOf(QQStoryContext.a().a()), localStoryVideoItem.mVid);
  }
  
  public MyStorys a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    SLog.d("Q.qqstory.home.Repository", "-----------start------------");
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null) {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.a("QQ_Story_Sub", 0);
    }
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector = new StepExector(this);
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector = new StepExector(this);
      g();
      this.jdField_a_of_type_Boolean = true;
      h();
      return;
    }
    catch (IllegalThreadStateException localIllegalThreadStateException)
    {
      for (;;)
      {
        SLog.e("Q.qqstory.home.Repository", "start mWorkThread occur exception:" + localIllegalThreadStateException);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > paramInt)
    {
      long l = ((StoryItem)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).user.uid;
      this.jdField_b_of_type_JavaUtilArrayList.remove(paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l));
    }
  }
  
  public void a(StoryItem paramStoryItem)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramStoryItem.user.uid)) == null)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramStoryItem);
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramStoryItem.user.uid), paramStoryItem);
      return;
    }
    SLog.d("Q.qqstory.home.Repository", "Item %s is duplicate in recentList !!", new Object[] { Long.valueOf(paramStoryItem.user.uid) });
  }
  
  public void a(StoryListPresenter paramStoryListPresenter)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter = paramStoryListPresenter;
  }
  
  public void a(Runnable paramRunnable)
  {
    SLog.b("Q.qqstory.home.Repository", "executeRunnableOnWorkThread");
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      paramRunnable = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramRunnable);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramRunnable);
      return;
    }
    paramRunnable = Message.obtain(this.jdField_b_of_type_AndroidOsHandler, paramRunnable);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramRunnable);
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.c(paramString);
    a(true, true);
  }
  
  public void a(ArrayList paramArrayList)
  {
    int n = 0;
    HashMap localHashMap = new HashMap(paramArrayList.size());
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      localHashMap.put(Long.valueOf(str), str);
    }
    int j = 0;
    int i = 0;
    int k = n;
    int m = i;
    if (j < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (localHashMap.size() != 0) {
        break label135;
      }
      m = i;
      k = n;
    }
    for (;;)
    {
      if ((k >= this.jdField_b_of_type_JavaUtilArrayList.size()) || (localHashMap.size() == 0))
      {
        if (m != 0) {
          a(true, true);
        }
        return;
        label135:
        if (localHashMap.get(Long.valueOf(((StoryItem)this.jdField_c_of_type_JavaUtilArrayList.get(j)).user.uid)) != null)
        {
          localStoryManager.a(((StoryItem)this.jdField_c_of_type_JavaUtilArrayList.get(j)).user.uid, 0);
          b(j);
          i = 1;
        }
        j += 1;
        break;
      }
      if (localHashMap.get(Long.valueOf(((StoryItem)this.jdField_b_of_type_JavaUtilArrayList.get(k)).user.uid)) != null)
      {
        localStoryManager.a(((StoryItem)this.jdField_b_of_type_JavaUtilArrayList.get(k)).user.uid, 1);
        a(k);
        m = 1;
      }
      k += 1;
    }
  }
  
  public ArrayList b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    SLog.d("Q.qqstory.home.Repository", "-----------stop------------");
    if ((this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive()))
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label177;
      }
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        SLog.e("Q.qqstory.home.Repository", "remove mSubThreadHandler");
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.b();
      }
      if (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector != null) {
        this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStepExector.b();
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestAsyncStepExector != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestAsyncStepExector.b();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidContentContext = null;
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$StoryVideoPublishStatusReceiver);
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$DeleteStoryVideoReceiver);
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$WatchVideoReceiver);
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$RecentStoryFinishReceiver);
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository$ShieldFriendStoryReceiver);
      return;
      label177:
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > paramInt)
    {
      long l = ((StoryItem)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt)).user.uid;
      this.jdField_c_of_type_JavaUtilArrayList.remove(paramInt);
      this.jdField_b_of_type_JavaUtilHashMap.remove(Long.valueOf(l));
    }
  }
  
  public void b(StoryItem paramStoryItem)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramStoryItem.user.uid)) == null)
    {
      this.jdField_c_of_type_JavaUtilArrayList.add(paramStoryItem);
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramStoryItem.user.uid), paramStoryItem);
      return;
    }
    SLog.d("Q.qqstory.home.Repository", "Item %s is duplicate in friendList !!", new Object[] { Long.valueOf(paramStoryItem.user.uid) });
  }
  
  public ArrayList c()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public void c()
  {
    if (!b())
    {
      SLog.e("Q.qqstory.home.Repository", "request all data from server when network status is unable!");
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "当前网络不可用，请检查你的网络设置", 0).a();
      return;
    }
    a(new irr(this));
  }
  
  public ArrayList d()
  {
    return this.d;
  }
  
  public void d()
  {
    if (!b())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "当前网络不可用，请检查你的网络设置", 0).a();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestAsyncStepExector != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestAsyncStepExector.a() == 1))
    {
      SLog.d("Q.qqstory.home.Repository", "Skip the requestMoreData() when pull refreshing");
      return;
    }
    a(new isc(this));
  }
  
  public ArrayList e()
  {
    return this.e;
  }
  
  public void e()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void f()
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\Repository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */