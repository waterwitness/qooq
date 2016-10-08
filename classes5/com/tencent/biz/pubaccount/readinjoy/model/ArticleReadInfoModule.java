package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import hyr;
import hys;
import hyt;
import hyu;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ArticleReadInfoModule
  extends ReadInJoyEngineModule
{
  private HashMap a;
  
  public ArticleReadInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  }
  
  public ArticleReadInfoModule(EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(null, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  }
  
  private void a(List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hys(this, paramList));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(long paramLong)
  {
    ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localArticleReadInfo != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyu(this, localArticleReadInfo));
    }
    QLog.d(ArticleInfo.TAG, 2, "DeleteArticle ReadInfo , articleID : " + paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localArticleReadInfo == null)
    {
      localArticleReadInfo = new ArticleReadInfo();
      localArticleReadInfo.mArticleID = paramLong1;
      localArticleReadInfo.mLastReadTime = paramLong2;
    }
    for (localArticleReadInfo.mIsRead = true;; localArticleReadInfo.mIsRead = true)
    {
      a(localArticleReadInfo);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyt(this, localArticleReadInfo));
      return;
      localArticleReadInfo.mLastReadTime = paramLong2;
    }
  }
  
  public void a(ArticleReadInfo paramArticleReadInfo)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramArticleReadInfo.mArticleID), paramArticleReadInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) != null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hyr(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\model\ArticleReadInfoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */