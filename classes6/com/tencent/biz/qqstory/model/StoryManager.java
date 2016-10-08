package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.base.preload.storylist.IPreloadVideoSource;
import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.biz.qqstory.database.HotTopicEntry;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.database.StoryEntry;
import com.tencent.biz.qqstory.database.StoryVideoEntry;
import com.tencent.biz.qqstory.database.StoryVideoListEntry;
import com.tencent.biz.qqstory.model.item.HotTopicItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StoryManager
  implements IManager
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  protected OneObjectCacheList a;
  private IPreloadVideoSource jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Map jdField_a_of_type_JavaUtilMap;
  protected OneObjectCacheList b;
  private IPreloadVideoSource b;
  
  public StoryManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList = new OneObjectCacheList(300);
    this.jdField_b_of_type_ComTencentBizQqstoryBaseOneObjectCacheList = new OneObjectCacheList(300);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  private StoryVideoEntry a(EntityManager paramEntityManager, String paramString)
  {
    paramEntityManager = paramEntityManager.a(StoryVideoEntry.class, StoryVideoEntry.class.getSimpleName(), true, StoryVideoEntry.getVidSelectionNoArgs(), new String[] { paramString }, null, null, null, null);
    if ((paramEntityManager != null) && (paramEntityManager.size() == 1)) {
      return (StoryVideoEntry)paramEntityManager.get(0);
    }
    return null;
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private StoryItem b(long paramLong, int paramInt)
  {
    Object localObject = a(a().a().createEntityManager(), StoryEntry.class, StoryEntry.class.getSimpleName(), StoryEntry.getUidSelectionNoArg(), new String[] { String.valueOf(paramLong), String.valueOf(paramInt) });
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    localObject = (StoryEntry)((List)localObject).get(0);
    StoryItem localStoryItem = new StoryItem((StoryEntry)localObject);
    return (StoryItem)this.jdField_b_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(StoryItem.makeFriendKey(((StoryEntry)localObject).uid), localStoryItem);
  }
  
  private StoryVideoItem b(String paramString)
  {
    paramString = a(a().a().createEntityManager(), StoryVideoEntry.class, StoryVideoEntry.class.getSimpleName(), StoryVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
    if ((paramString == null) || (paramString.size() == 0)) {
      return null;
    }
    paramString = (StoryVideoEntry)paramString.get(0);
    StoryVideoItem localStoryVideoItem = new StoryVideoItem(paramString);
    return (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString.vid, localStoryVideoItem);
  }
  
  public long a()
  {
    List localList = a().a().createEntityManager().a(StoryEntry.class, StoryEntry.class.getSimpleName(), false, StoryEntry.getTypeSelection(1), null, null, null, "updateTime desc", "1");
    if ((localList == null) || (localList.size() == 0)) {
      return 0L;
    }
    return ((StoryEntry)localList.get(0)).updateTime;
  }
  
  public IPreloadVideoSource a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource = new PreloadVideoSource();
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource.b();
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource;
  }
  
  public LiveVideoEntry a(long paramLong)
  {
    return (LiveVideoEntry)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
  }
  
  public StoryItem a(long paramLong, int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = StoryItem.makeFriendKey(paramLong);; localObject = StoryItem.makeRecentKey(paramLong))
    {
      localObject = (StoryItem)this.jdField_b_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localObject);
      if (localObject == null) {
        break;
      }
      return (StoryItem)localObject;
    }
    return b(paramLong, paramInt);
  }
  
  public StoryItem a(long paramLong, int paramInt, StoryItem paramStoryItem)
  {
    a(paramLong, paramInt);
    paramStoryItem = (StoryItem)this.jdField_b_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramStoryItem.key, paramStoryItem);
    a().a().createEntityManager().b(paramStoryItem.cover2StoryEntry());
    return paramStoryItem;
  }
  
  public StoryVideoItem a(String paramString)
  {
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramString);
    if (localStoryVideoItem != null) {
      return localStoryVideoItem;
    }
    return b(paramString);
  }
  
  public StoryVideoItem a(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    a(paramString);
    paramStoryVideoItem.mVid = paramString;
    paramString = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(paramStoryVideoItem.mVid, paramStoryVideoItem);
    a().a().createEntityManager().b(paramString.cover2StoryEntry());
    return paramString;
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      Object localObject = (ArrayList)a(a().a().createEntityManager(), HotTopicEntry.class, HotTopicEntry.class.getSimpleName(), "", null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          HotTopicEntry localHotTopicEntry = (HotTopicEntry)((Iterator)localObject).next();
          this.jdField_a_of_type_JavaUtilArrayList.add(new HotTopicItem(localHotTopicEntry));
        }
      }
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().a().createEntityManager().a(StoryVideoEntry.class, StoryVideoEntry.class.getSimpleName(), false, StoryVideoEntry.getLocalVideo(), null, null, null, null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoEntry localStoryVideoEntry = (StoryVideoEntry)((Iterator)localObject).next();
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoEntry.vid);
      if (localStoryVideoItem == null)
      {
        localStoryVideoEntry.uploadStatus = 3;
        localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoEntry.vid, new StoryVideoItem(localStoryVideoEntry)));
      }
      else
      {
        localArrayList.add(localStoryVideoItem);
      }
    }
    return localArrayList;
  }
  
  public List a(int paramInt)
  {
    Object localObject = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    localObject = a((EntityManager)localObject, StoryEntry.class, StoryEntry.class.getSimpleName(), StoryEntry.getTypeSelection(paramInt), null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryItem localStoryItem = new StoryItem((StoryEntry)((Iterator)localObject).next());
      this.jdField_b_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryItem.key, localStoryItem);
      localArrayList.add(localStoryItem);
    }
    return localArrayList;
  }
  
  public List a(int paramInt, String paramString)
  {
    Object localObject = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    paramString = a((EntityManager)localObject, StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), StoryVideoListEntry.getLabelSelectionNoArg(), new String[] { String.valueOf(paramInt), paramString });
    if (paramString == null) {
      return localArrayList;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject = b(((StoryVideoListEntry)paramString.next()).vid);
      if (localObject != null) {
        localArrayList.add((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(((StoryVideoItem)localObject).mVid, (Copyable)localObject));
      }
    }
    return localArrayList;
  }
  
  public List a(int paramInt, String paramString, List paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList(paramList.size());
    EntityTransaction localEntityTransaction = localEntityManager.a();
    try
    {
      localEntityTransaction.a();
      Object localObject;
      if (paramBoolean)
      {
        localObject = new StoryVideoListEntry();
        ((StoryVideoListEntry)localObject).setStatus(1001);
        localEntityManager.a((Entity)localObject, StoryVideoListEntry.getLabelSelectionNoArg(), new String[] { String.valueOf(paramInt), paramString });
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (StoryVideoItem)paramList.next();
        a(((StoryVideoItem)localObject).mVid);
        localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(((StoryVideoItem)localObject).mVid, (Copyable)localObject);
        localArrayList.add(localObject);
        localEntityManager.b(((StoryVideoItem)localObject).cover2StoryEntry());
        StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
        localStoryVideoListEntry.listType = paramInt;
        localStoryVideoListEntry.label = paramString;
        localStoryVideoListEntry.vid = ((StoryVideoItem)localObject).mVid;
        localEntityManager.b(localStoryVideoListEntry);
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityTransaction.b();
    return localArrayList;
  }
  
  public List a(long paramLong)
  {
    Object localObject = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    localObject = a((EntityManager)localObject, StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), StoryVideoListEntry.getTopicIdSelection(paramLong), null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoItem localStoryVideoItem = b(((StoryVideoListEntry)((Iterator)localObject).next()).vid);
      if (localStoryVideoItem != null) {
        localArrayList.add((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoItem.mVid, localStoryVideoItem));
      }
    }
    return localArrayList;
  }
  
  public List a(long paramLong, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return paramList;
    }
    EntityManager localEntityManager = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList(paramList.size());
    EntityTransaction localEntityTransaction = localEntityManager.a();
    for (;;)
    {
      StoryVideoListEntry localStoryVideoListEntry;
      try
      {
        localEntityTransaction.a();
        Object localObject;
        if (paramBoolean)
        {
          localObject = new StoryVideoListEntry();
          ((StoryVideoListEntry)localObject).setStatus(1001);
          if (paramInt == 1) {
            localEntityManager.a((Entity)localObject, StoryVideoListEntry.getRecentUidSelection(paramLong), null);
          }
        }
        else
        {
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (StoryVideoItem)paramList.next();
          a(((StoryVideoItem)localObject).mVid);
          localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(((StoryVideoItem)localObject).mVid, (Copyable)localObject);
          localArrayList.add(localObject);
          localEntityManager.b(((StoryVideoItem)localObject).cover2StoryEntry());
          localStoryVideoListEntry = new StoryVideoListEntry();
          localStoryVideoListEntry.uid = paramLong;
          localStoryVideoListEntry.vid = ((StoryVideoItem)localObject).mVid;
          if (paramInt != 1) {
            break label240;
          }
          localStoryVideoListEntry.listType = 3;
          localEntityManager.b(localStoryVideoListEntry);
          continue;
        }
        localEntityManager.a((Entity)localObject, StoryVideoListEntry.getUserUidSelection(paramLong), null);
      }
      finally
      {
        localEntityTransaction.b();
      }
      continue;
      label240:
      localStoryVideoListEntry.listType = 0;
    }
    localEntityTransaction.c();
    localEntityTransaction.b();
    return localArrayList;
  }
  
  public List a(long paramLong, List paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList(paramList.size());
    EntityTransaction localEntityTransaction = localEntityManager.a();
    try
    {
      localEntityTransaction.a();
      Object localObject;
      if (paramBoolean)
      {
        localObject = new StoryVideoListEntry();
        ((StoryVideoListEntry)localObject).setStatus(1001);
        localEntityManager.a((Entity)localObject, StoryVideoListEntry.getTopicIdSelection(paramLong), null);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (StoryVideoItem)paramList.next();
        a(((StoryVideoItem)localObject).mVid);
        localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(((StoryVideoItem)localObject).mVid, (Copyable)localObject);
        localArrayList.add(localObject);
        localEntityManager.b(((StoryVideoItem)localObject).cover2StoryEntry());
        StoryVideoListEntry localStoryVideoListEntry = new StoryVideoListEntry();
        localStoryVideoListEntry.listType = 2;
        localStoryVideoListEntry.uid = paramLong;
        localStoryVideoListEntry.vid = ((StoryVideoItem)localObject).mVid;
        localEntityManager.b(localStoryVideoListEntry);
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityTransaction.b();
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a().b();
      b().c();
      return;
    }
    a().c();
    b().b();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, int paramInt)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    StoryEntry localStoryEntry = new StoryEntry();
    localStoryEntry.setStatus(1001);
    localEntityManager.a(localStoryEntry, StoryEntry.getUidSelectionNoArg(), new String[] { String.valueOf(paramLong), String.valueOf(paramInt) });
  }
  
  public void a(long paramLong, LiveVideoEntry paramLiveVideoEntry)
  {
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramLiveVideoEntry);
  }
  
  public void a(String paramString)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    Object localObject = new StoryVideoListEntry();
    ((StoryVideoListEntry)localObject).setStatus(1001);
    localEntityManager.a((Entity)localObject, StoryVideoListEntry.getVidSelectionNoArg(), new String[] { paramString });
    localObject = new StoryVideoEntry();
    ((StoryVideoEntry)localObject).setStatus(1001);
    localEntityManager.a((Entity)localObject, StoryVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.a().a();
    try
    {
      localEntityManager.a(HotTopicEntry.class);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localEntityManager.b(((HotTopicItem)paramArrayList.next()).cover2StoryEntry());
      }
    }
    finally
    {
      localEntityManager.a().b();
    }
    localEntityManager.a().b();
  }
  
  public void a(List paramList, int paramInt, boolean paramBoolean)
  {
    EntityManager localEntityManager = a().a().createEntityManager();
    localEntityManager.a().a();
    Object localObject;
    if (paramBoolean) {
      try
      {
        localObject = a(localEntityManager, StoryEntry.class, StoryEntry.class.getSimpleName(), StoryEntry.getTypeSelection(paramInt), null);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            StoryEntry localStoryEntry = (StoryEntry)((Iterator)localObject).next();
            localStoryEntry.setStatus(1001);
            localEntityManager.b(localStoryEntry);
          }
        }
        paramList = paramList.iterator();
      }
      finally
      {
        localEntityManager.a().b();
      }
    }
    while (paramList.hasNext())
    {
      localObject = (StoryItem)paramList.next();
      this.jdField_b_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(((StoryItem)localObject).key, (Copyable)localObject);
      localEntityManager.b(((StoryItem)localObject).cover2StoryEntry());
      if ((((StoryItem)localObject).liveVideo != null) && (((StoryItem)localObject).liveVideo.roomId > 0)) {
        localEntityManager.b(((StoryItem)localObject).liveVideo);
      }
    }
    localEntityManager.a().c();
    localEntityManager.a().b();
  }
  
  public IPreloadVideoSource b()
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource == null) {
      this.jdField_b_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource = new PreloadVideoSource();
    }
    return this.jdField_b_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource;
  }
  
  public List b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = a().a().createEntityManager();
    Object localObject = localEntityManager.a(StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), true, StoryVideoListEntry.getUserUidSelection(paramLong), null, null, null, null, null);
    if (localObject == null) {
      return localArrayList;
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      StoryVideoListEntry localStoryVideoListEntry = (StoryVideoListEntry)localIterator.next();
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoListEntry.vid);
      localObject = localStoryVideoItem;
      if (localStoryVideoItem == null)
      {
        StoryVideoEntry localStoryVideoEntry = a(localEntityManager, localStoryVideoListEntry.vid);
        localObject = localStoryVideoItem;
        if (localStoryVideoEntry != null) {
          localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(localStoryVideoListEntry.vid, new StoryVideoItem(localStoryVideoEntry));
        }
      }
      if ((localObject != null) && (!StoryVideoItem.isFakeVid(((StoryVideoItem)localObject).mVid))) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource.d();
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource.d();
    }
  }
  
  public List c(long paramLong)
  {
    if (paramLong != QQStoryContext.a().a()) {
      return b(paramLong);
    }
    List localList = a();
    Object localObject = b(paramLong);
    HashSet localHashSet = new HashSet(localList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
      if (localHashSet.add(localStoryVideoItem)) {
        localList.add(localStoryVideoItem);
      }
    }
    return localList;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(20);
    this.jdField_b_of_type_ComTencentBizQqstoryBaseOneObjectCacheList.a(20);
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource.a();
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryBasePreloadStorylistIPreloadVideoSource.a();
    }
  }
  
  public List d(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a().a().createEntityManager().a(StoryVideoListEntry.class, StoryVideoListEntry.class.getSimpleName(), true, StoryVideoListEntry.getRecentUidSelection(paramLong), null, null, null, null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryVideoItem localStoryVideoItem = a(((StoryVideoListEntry)((Iterator)localObject).next()).vid);
      if ((localStoryVideoItem != null) && (!localStoryVideoItem.mHasWatched)) {
        localArrayList.add(localStoryVideoItem);
      }
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\StoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */