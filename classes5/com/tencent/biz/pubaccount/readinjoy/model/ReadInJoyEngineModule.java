package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;

public abstract class ReadInJoyEngineModule
{
  public static final String b = "ReadInJoyEngineModule";
  protected static String c = "NotifyType";
  protected static String d = "BeginSeq";
  protected static String e = "EndSeq";
  protected static final int f = 1;
  protected static String f = "SubscriptionArticles";
  protected static final int g = 2;
  protected static String g = "CountOfRequest_0x68b";
  protected static final int h = 3;
  protected static final int i = 4;
  protected static final int j = 5;
  protected static final int k = 6;
  protected static final int l = 7;
  protected static final int m = 8;
  protected static final int n = 9;
  protected static final int o = 10;
  protected static final int p = 11;
  protected static final int q = 12;
  protected static final int r = 13;
  public static final int s = 14;
  public static final int t = 154;
  public Handler a;
  protected ReadInJoyMSFService a;
  public AppInterface a;
  public EntityManager a;
  protected ExecutorService a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReadInJoyEngineModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService = paramReadInJoyMSFService;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public abstract void a();
  
  public void a(Entity paramEntity)
  {
    ArticleInfo localArticleInfo = null;
    Object localObject;
    if ((paramEntity instanceof ArticleInfo))
    {
      localObject = localArticleInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(ArticleInfo.class.getSimpleName()))
      {
        localArticleInfo = (ArticleInfo)paramEntity;
        paramEntity = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleInfo.class, "mArticleID = ? and mChannelID = ?", new String[] { String.valueOf(localArticleInfo.mArticleID), String.valueOf(localArticleInfo.mChannelID) });
        localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleInfo.class, "mRecommendSeq = ? and mChannelID = ?", new String[] { String.valueOf(localArticleInfo.mRecommendSeq), String.valueOf(localArticleInfo.mChannelID) });
        if (paramEntity == null) {
          break label189;
        }
        localObject = paramEntity;
        if (QLog.isColorLevel())
        {
          localObject = paramEntity;
          if (paramEntity != null)
          {
            QLog.e("ReadInJoyEngineModule", 2, "removeEntityIfExistsInDB, article duplicated, article been channelID=" + localArticleInfo.mChannelID + "articleID=" + localArticleInfo.mArticleID + "recommendSeq=" + localArticleInfo.mRecommendSeq);
            localObject = paramEntity;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject);
      }
      return;
      label189:
      paramEntity = (Entity)localObject;
      break;
      if ((paramEntity instanceof ArticleReadInfo))
      {
        localObject = localArticleInfo;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(ArticleInfo.class.getSimpleName()))
        {
          paramEntity = (ArticleReadInfo)paramEntity;
          localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleReadInfo.class, "mArticleID = ?", new String[] { String.valueOf(paramEntity.mArticleID) });
        }
      }
      else
      {
        localObject = localArticleInfo;
        if ((paramEntity instanceof ChannelInfo))
        {
          localObject = localArticleInfo;
          if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(ChannelInfo.class.getSimpleName()))
          {
            paramEntity = (ChannelInfo)paramEntity;
            localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ChannelInfo.class, "mChannelID = ?", new String[] { String.valueOf(paramEntity.mChannelID) });
          }
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l1 = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyMSFService.a(paramToServiceMsg, this);
    }
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  /* Error */
  public boolean a(Entity paramEntity)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual 212	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   8: sipush 1000
    //   11: if_icmpne +34 -> 45
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 214	com/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   19: aload_0
    //   20: getfield 89	com/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: aload_1
    //   24: invokevirtual 216	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   27: aload_1
    //   28: invokevirtual 212	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   31: istore_2
    //   32: iload_2
    //   33: sipush 1001
    //   36: if_icmpne +5 -> 41
    //   39: iconst_1
    //   40: istore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: aload_1
    //   46: invokevirtual 212	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   49: sipush 1001
    //   52: if_icmpeq +13 -> 65
    //   55: aload_1
    //   56: invokevirtual 212	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   59: sipush 1002
    //   62: if_icmpne -21 -> 41
    //   65: aload_0
    //   66: getfield 89	com/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: aload_1
    //   70: invokevirtual 218	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   73: istore_3
    //   74: goto -33 -> 41
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReadInJoyEngineModule
    //   0	82	1	paramEntity	Entity
    //   31	6	2	i1	int
    //   1	73	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	32	77	finally
    //   45	55	77	finally
    //   55	65	77	finally
    //   65	74	77	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\model\ReadInJoyEngineModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */