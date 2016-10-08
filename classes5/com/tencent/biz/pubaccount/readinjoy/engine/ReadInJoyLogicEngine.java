package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import hxx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadInJoyLogicEngine
{
  private static final int jdField_a_of_type_Int = 10;
  private static final long jdField_a_of_type_Long = 129600000L;
  private static ReadInJoyLogicEngine jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArticleInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule;
  private ArticleReadInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule;
  private ChannelInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule;
  private InterestLabelInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule;
  private SubscriptionInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule;
  private UserOperationModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule;
  private ReadInJoyMSFService jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String jdField_a_of_type_JavaLangString;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private boolean jdField_a_of_type_Boolean;
  
  private ReadInJoyLogicEngine()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static ReadInJoyLogicEngine a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine == null)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = new ReadInJoyLogicEngine();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine;
    }
    finally {}
  }
  
  private EntityManagerFactory a()
  {
    Object localObject1 = ReadInJoyUtils.a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null)
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ((ReadInJoyEntityManagerFactory)localObject1).verifyAuthentication();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a();
  }
  
  public int a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInteger);
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInteger);
  }
  
  public SQLiteOpenHelper a()
  {
    if (!ReadInJoyUtils.a().equals("0")) {
      return a().build(ReadInJoyUtils.a());
    }
    return null;
  }
  
  public HashMap a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastSetInterestLabelInfoMap mInterestLabelInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a();
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAllInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a();
  }
  
  protected void a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1) > 0) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdownNow();
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule = null;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule = null;
  }
  
  public void a(int paramInt)
  {
    QLog.d(ReadInJoyLogicEngine.class.getSimpleName(), 1, "execute delete outdate article task !");
    EntityManager localEntityManager = a().createEntityManager();
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    long l2 = (NetConnInfoCenter.getServerTimeMillis() - 129600000L) / 1000L;
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null)
    {
      QLog.d(ReadInJoyLogicEngine.class.getSimpleName(), 2, "executorService is null ! ");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hxx(this, paramInt, l2, l1, localEntityManager));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelListFromServer mChannelInfoModule is null!");
      }
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.b();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule.a(paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(paramBaseArticleInfo.mArticleID);
      return;
      QLog.d(ArticleInfoModule.jdField_a_of_type_JavaLangString, 2, "ReadinjoyLogicEngine articleInfoModule is null !");
    }
    QLog.d(ArticleInfoModule.jdField_a_of_type_JavaLangString, 2, "ReadinjoyLogicEngine articleReadInfoModule is null !");
  }
  
  public void a(int paramInt1, List paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString1, long paramLong1, String paramString2, int paramInt3, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(paramInt1));
    Object localObject2 = new ReadInJoyRequestParams.Request0x68bParams();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_b_of_type_Int = paramInt1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_a_of_type_Long = -1L;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_b_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_a_of_type_JavaUtilList = ((List)localObject1);
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_c_of_type_Boolean = false;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_b_of_type_JavaUtilList = paramList;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_d_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_e_of_type_Boolean = true;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).f = paramBoolean1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(paramInt1));
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).g = paramBoolean2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_b_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a();
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_c_of_type_Int = paramInt2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_a_of_type_JavaLangString = paramString1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_c_of_type_Long = paramLong1;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_b_of_type_JavaLangString = paramString2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_d_of_type_Int = paramInt3;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_d_of_type_Long = paramLong2;
    ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_e_of_type_Long = paramLong3;
    if (l == -1L)
    {
      ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a((ReadInJoyRequestParams.Request0x68bParams)localObject2);
    }
    for (;;)
    {
      localObject1 = new StringBuilder("SelectedKandianArticleIds : ");
      if (paramList == null) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (Long)paramList.next();
        ((StringBuilder)localObject1).append(localObject2 + " , ");
      }
      ((ReadInJoyRequestParams.Request0x68bParams)localObject2).jdField_b_of_type_Long = (l + 1L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a((ReadInJoyRequestParams.Request0x68bParams)localObject2);
    }
    QLog.i(ArticleInfoModule.jdField_a_of_type_JavaLangString, 1, "refreshChannelArticlesFormServer kandianArticleID : " + ((StringBuilder)localObject1).toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + ReadInJoyUtils.c(paramString2));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, 1);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong, DislikeParam paramDislikeParam)
  {
    if (paramDislikeParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramDislikeParam);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramLong, paramList);
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = ReadInJoyUtils.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str))) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
    paramAppInterface = a().createEntityManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = ReadInJoyMSFService.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule = new ArticleInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule = new UserOperationModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule = new ArticleReadInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule = new InterestLabelInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule = new SubscriptionInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelChannelInfoModule = new ChannelInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramAppInterface, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a(paramString);
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a(paramString, paramContext);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "likeUnlike mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramString, paramBoolean);
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule.a(paramList);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return true;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a();
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreArticle mArticleInfoModule is null!");
      }
      return false;
    }
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(Integer.valueOf(paramInt1));
    if (l == -1L) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(paramInt1, 20, l - 1L, true, paramInt2);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(paramLong);
  }
  
  public boolean a(Long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b(paramLong);
  }
  
  public List b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "clearSubscriptionArticles mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.d();
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.b(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updatelikeUnlike mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, paramBoolean);
  }
  
  public void b(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "saveInterestLabelListToDB mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.b(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.c(paramList);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.b();
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.c(paramString);
  }
  
  public void c(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestSetInterestLabelList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a(paramList);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.e();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a(1, 1, 1, false);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelInterestLabelInfoModule.a(0, 0, 1, true);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.d();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.f();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.f();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.b();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\engine\ReadInJoyLogicEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */