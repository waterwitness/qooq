package com.tencent.biz.qqstory.base.preload.storylist;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader;
import com.tencent.biz.qqstory.base.preload.VideoPreloader;
import com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner;
import com.tencent.biz.qqstory.base.preload.storylist.strategy.StrategySet;
import com.tencent.biz.qqstory.base.preload.storylist.strategy.StrategySet.OnDownloadQueuePrepareListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import ihy;
import ihz;
import iia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PreloadVideoSource
  implements IPreloadVideoSource, ISource
{
  protected static final String f = "Q.qqstory.download.preload.PreloadVideoSource";
  protected IVideoPreloader a;
  public DelayUpdateDownloadQueueJob a;
  public UserClickManager a;
  protected StrategySet a;
  protected INetEventHandler a;
  protected ihy a;
  protected iia a;
  protected List a;
  public boolean a;
  
  public PreloadVideoSource()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new ihz(this, null);
    this.jdField_a_of_type_Iia = new iia(this, null);
    this.jdField_a_of_type_Ihy = new ihy(this, null);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyStrategySet = new StrategySet();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader = new VideoPreloader();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(0);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(this.jdField_a_of_type_Ihy);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistDelayUpdateDownloadQueueJob = new DelayUpdateDownloadQueueJob(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager = new UserClickManager(this);
    while (i < 5)
    {
      localObject = new CategorySource(this, String.valueOf(i));
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      i += 1;
    }
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    Object localObject = QQStoryContext.a().a();
    ((QQAppInterface)localObject).a(this.jdField_a_of_type_Iia);
    ((QQStoryHandler)((QQAppInterface)localObject).a(98)).b();
  }
  
  private CategorySource a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      CategorySource localCategorySource = (CategorySource)localIterator.next();
      if (localCategorySource.a().equals(paramString)) {
        return localCategorySource;
      }
    }
    return null;
  }
  
  public IVideoPreloader a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader;
  }
  
  public UserClickManager a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager;
  }
  
  public String a()
  {
    return "";
  }
  
  /* Error */
  public List a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 159	com/tencent/biz/qqstory/base/preload/storylist/PreloadVideoSource:a	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/base/preload/storylist/CategorySource;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull +9 -> 20
    //   14: aload_3
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 162	com/tencent/biz/qqstory/base/preload/storylist/CategorySource:a	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/base/preload/storylist/StorySource;
    //   25: astore_2
    //   26: aload_3
    //   27: astore_1
    //   28: aload_2
    //   29: ifnull -13 -> 16
    //   32: aload_2
    //   33: invokevirtual 167	com/tencent/biz/qqstory/base/preload/storylist/StorySource:a	()Ljava/util/List;
    //   36: astore_1
    //   37: goto -21 -> 16
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	PreloadVideoSource
    //   0	45	1	paramString1	String
    //   0	45	2	paramString2	String
    //   1	26	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	10	40	finally
    //   20	26	40	finally
    //   32	37	40	finally
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((CategorySource)localIterator.next()).a();
      }
    }
    finally {}
  }
  
  public void a(int paramInt, List paramList)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((CategorySource)localIterator.next()).a(paramInt, paramList);
      }
    }
    finally {}
  }
  
  public void a(StrategySet.OnDownloadQueuePrepareListener paramOnDownloadQueuePrepareListener)
  {
    try
    {
      CacheCleaner.a().a();
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyStrategySet.a(this, paramOnDownloadQueuePrepareListener);
      return;
    }
    finally
    {
      paramOnDownloadQueuePrepareListener = finally;
      throw paramOnDownloadQueuePrepareListener;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistStrategyStrategySet.a(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistDelayUpdateDownloadQueueJob.a(1);
  }
  
  public void a(String paramString1, String paramString2, List paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (;;)
    {
      try
      {
        SLog.d("Q.qqstory.download.preload.PreloadVideoSource", "setVideoList uinList is empty!");
        return;
      }
      finally {}
      SLog.b("Q.qqstory.download.preload.PreloadVideoSource", "setVideoList , category = " + paramString1 + " ,uin = " + paramString2 + " , size = " + paramList.size());
      paramString1 = a(paramString1);
      if (paramString1 != null)
      {
        paramString1.a(paramString2, paramList, paramBoolean);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistDelayUpdateDownloadQueueJob.a(4000);
      }
    }
  }
  
  public void a(String paramString, List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      try
      {
        SLog.d("Q.qqstory.download.preload.PreloadVideoSource", "setUserList uinList is empty!");
        return;
      }
      finally {}
      paramString = a(paramString);
      if (paramString != null) {
        paramString.b(paramList);
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistDelayUpdateDownloadQueueJob.a(true);
  }
  
  public void b(int paramInt, List paramList)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((CategorySource)localIterator.next()).b(paramInt, paramList);
      }
    }
    finally {}
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistDelayUpdateDownloadQueueJob.a(false);
  }
  
  public void d()
  {
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    QQStoryContext.a().a().b(this.jdField_a_of_type_Iia);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\PreloadVideoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */