package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetRelatedVideoListRequest;
import com.tencent.biz.qqstory.network.request.GetTopicVideoListRequest;
import com.tencent.biz.qqstory.network.request.GetUserVideoListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import iiy;
import iiz;
import ija;
import ijb;
import ijc;
import ijd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DefaultPlayerVideoListSynchronizer
  implements IEventReceiver
{
  public static final int a = -1;
  public static final String a = "Q.qqstory.player.DefaultPlayerVideoListSynchronizer";
  public static final int b = 2;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int j = 20;
  public long a;
  public ijd a;
  public List a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  protected boolean d;
  public String e;
  protected boolean e;
  public int h;
  public int i;
  public final int k;
  public int l;
  
  public DefaultPlayerVideoListSynchronizer(int paramInt, long paramLong, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = 2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_e_of_type_JavaLangString = paramString;
    this.k = paramInt;
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public DefaultPlayerVideoListSynchronizer(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.h = 2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.k = paramInt;
    this.jdField_e_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString2;
  }
  
  private String a(String paramString)
  {
    return paramString + this.jdField_d_of_type_JavaLangString;
  }
  
  private void a(ErrorMessage paramErrorMessage)
  {
    DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent(this);
    localPlayerVideoListEvent.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localPlayerVideoListEvent.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localPlayerVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    Dispatchers.get().dispatch(localPlayerVideoListEvent);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Long == QQStoryContext.a().a();
  }
  
  private boolean a(int paramInt)
  {
    if (this.jdField_c_of_type_Boolean) {
      SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "not preload for end");
    }
    do
    {
      return false;
      if (this.jdField_b_of_type_Boolean)
      {
        SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "can't preload for loading");
        return false;
      }
      paramInt = this.i - paramInt;
    } while (paramInt >= this.h);
    SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "can preload for left size:%d, preload size:%d", Integer.valueOf(paramInt), Integer.valueOf(this.h));
    return true;
  }
  
  private void c()
  {
    SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "loadNextPage");
    this.jdField_b_of_type_Boolean = true;
    if ((this.k == 1) || (this.k == 4))
    {
      e();
      return;
    }
    if ((this.k == 2) || (this.k == 3))
    {
      d();
      return;
    }
    if (this.k == 5)
    {
      f();
      return;
    }
    throw new IllegalArgumentException("illegal type");
  }
  
  private void c(int paramInt)
  {
    if ((a()) && (!this.jdField_c_of_type_Boolean)) {
      g();
    }
    do
    {
      return;
      if (paramInt == -1) {
        g();
      }
    } while (!a(paramInt));
    c();
  }
  
  private void d()
  {
    if (3 == this.k) {}
    for (GetRelatedVideoListRequest localGetRelatedVideoListRequest = new GetRelatedVideoListRequest("StorySvc.video_hot_story_explore_list");; localGetRelatedVideoListRequest = new GetRelatedVideoListRequest("StorySvc.video_tag_video_search"))
    {
      localGetRelatedVideoListRequest.jdField_a_of_type_Int = 20;
      localGetRelatedVideoListRequest.g = this.jdField_c_of_type_JavaLangString;
      localGetRelatedVideoListRequest.jdField_e_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localGetRelatedVideoListRequest.f = this.jdField_d_of_type_JavaLangString;
      CmdTaskManger.a().a(localGetRelatedVideoListRequest, new iiz(this));
      return;
    }
  }
  
  private void e()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    GetUserVideoListRequest localGetUserVideoListRequest = new GetUserVideoListRequest();
    localGetUserVideoListRequest.d = 20;
    localGetUserVideoListRequest.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localGetUserVideoListRequest.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    if (this.k == 4) {}
    for (localGetUserVideoListRequest.e = 3;; localGetUserVideoListRequest.e = 1)
    {
      CmdTaskManger.a().a(localGetUserVideoListRequest, new ija(this));
      return;
    }
  }
  
  private void f()
  {
    if (!this.jdField_d_of_type_Boolean) {}
    while (this.k == 4) {
      return;
    }
    GetTopicVideoListRequest localGetTopicVideoListRequest = new GetTopicVideoListRequest();
    localGetTopicVideoListRequest.d = 20;
    localGetTopicVideoListRequest.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localGetTopicVideoListRequest.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    CmdTaskManger.a().a(localGetTopicVideoListRequest, new ijb(this));
  }
  
  private void g()
  {
    SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "loadLocalData");
    if ((!a()) && (this.jdField_e_of_type_Boolean)) {
      return;
    }
    DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent(this);
    localPlayerVideoListEvent.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localPlayerVideoListEvent.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localPlayerVideoListEvent.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    localPlayerVideoListEvent.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localPlayerVideoListEvent.jdField_a_of_type_Boolean = true;
    localPlayerVideoListEvent.jdField_b_of_type_Boolean = false;
    Object localObject1;
    Object localObject2;
    if (this.k == 1)
    {
      localObject1 = (StoryManager)SuperManager.a(5);
      if (a())
      {
        localObject1 = ((StoryManager)localObject1).c(this.jdField_a_of_type_Long);
        if (localObject1 != null)
        {
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject2).next();
            if ((!localStoryVideoItem.isUploadFail()) && (!localStoryVideoItem.isUploadSuc())) {
              ((Iterator)localObject2).remove();
            }
          }
        }
        Collections.sort((List)localObject1, new ijc(this));
      }
      for (;;)
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((StoryVideoItem)((Iterator)localObject2).next()).mOwnerUid = this.jdField_a_of_type_Long;
        }
        localObject1 = ((StoryManager)localObject1).b(this.jdField_a_of_type_Long);
      }
      localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      if (localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_c_of_type_Boolean = true;
        localPlayerVideoListEvent.jdField_b_of_type_Boolean = true;
      }
      if (localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label570;
      }
    }
    label570:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = bool;
      localPlayerVideoListEvent.jdField_a_of_type_Int = localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size();
      localPlayerVideoListEvent.c = 0L;
      localObject1 = localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
        localPlayerVideoListEvent.c += ((StoryVideoItem)localObject2).mVideoDuration;
      }
      if (this.k == 2)
      {
        localObject1 = (StoryManager)SuperManager.a(5);
        localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.addAll(((StoryManager)localObject1).a(1, a(this.jdField_b_of_type_JavaLangString)));
        break;
      }
      if (this.k == 3)
      {
        localObject1 = (StoryManager)SuperManager.a(5);
        localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.addAll(((StoryManager)localObject1).a(4, this.jdField_b_of_type_JavaLangString));
        break;
      }
      if (this.k == 5)
      {
        localObject1 = (StoryManager)SuperManager.a(5);
        localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.addAll(((StoryManager)localObject1).a(this.jdField_b_of_type_Long));
        if (localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() <= 0) {
          break;
        }
        this.jdField_c_of_type_Boolean = true;
        localPlayerVideoListEvent.jdField_b_of_type_Boolean = true;
        break;
      }
      if (this.k != 4) {
        break;
      }
      localObject1 = ((StoryManager)SuperManager.a(5)).d(this.jdField_a_of_type_Long);
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StoryVideoItem)((Iterator)localObject2).next()).mOwnerUid = this.jdField_a_of_type_Long;
      }
      localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
      if (localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      this.jdField_c_of_type_Boolean = true;
      localPlayerVideoListEvent.jdField_b_of_type_Boolean = true;
      break;
    }
    Dispatchers.get().dispatch(localPlayerVideoListEvent);
    SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "get video list return:" + localPlayerVideoListEvent);
    SLog.b("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "loadLocalData finish data size:" + localPlayerVideoListEvent.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ijd = new ijd(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_Ijd);
    b(-1);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Ijd);
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("please call start first");
    }
    Bosses.get().postJob(new iiy(this, paramInt));
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\DefaultPlayerVideoListSynchronizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */