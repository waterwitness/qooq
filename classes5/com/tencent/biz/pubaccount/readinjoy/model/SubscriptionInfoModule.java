package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import hzi;
import hzj;
import hzk;
import hzl;
import hzm;
import hzn;
import hzo;
import hzp;
import hzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class SubscriptionInfoModule
  extends ReadInJoyEngineModule
  implements Observer
{
  public static final int a = 10002;
  private static final String jdField_a_of_type_JavaLangString = SubscriptionInfoModule.class.getSimpleName();
  protected long a;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new hzp(this);
  private List jdField_a_of_type_JavaUtilList;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new hzq(this, ThreadManager.b());
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SubscriptionInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_Long = 2000L;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hzl(this, paramInt));
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hzo(this, paramInt));
  }
  
  private void g()
  {
    long l2 = Math.abs(System.currentTimeMillis() - this.jdField_b_of_type_Long);
    long l1 = l2;
    if (l2 < 0L) {
      l1 = this.jdField_a_of_type_Long + 1L;
    }
    if (l1 < this.jdField_a_of_type_Long)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(10002);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10002, this.jdField_a_of_type_Long - l1 + 50L);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(10002);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(10002);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = null;
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString)
  {
    int j;
    SubscriptionFeed localSubscriptionFeed;
    if (!TroopBarAssistantManager.a().a(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))
    {
      TroopBarAssistantManager.a().e(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      ReportController.b(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
      j = TroopBarAssistantManager.a().b();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localSubscriptionFeed = (SubscriptionFeed)localIterator.next();
      } while ((localSubscriptionFeed.jdField_a_of_type_JavaLangString == null) || (!localSubscriptionFeed.jdField_a_of_type_JavaLangString.equals(paramString)));
    }
    for (int i = localSubscriptionFeed.h;; i = 0)
    {
      d();
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CD", "0X80064CD", 0, 0, "" + i, "" + j, "", "");
      return;
    }
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hzm(this, paramString, paramContext));
    paramContext = this.jdField_a_of_type_JavaUtilList.iterator();
    SubscriptionFeed localSubscriptionFeed;
    do
    {
      if (!paramContext.hasNext()) {
        break;
      }
      localSubscriptionFeed = (SubscriptionFeed)paramContext.next();
    } while ((localSubscriptionFeed.jdField_a_of_type_JavaLangString == null) || (!localSubscriptionFeed.jdField_a_of_type_JavaLangString.equals(paramString)));
    for (int i = localSubscriptionFeed.h;; i = 0)
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CF", "0X80064CF", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new hzk(this, paramList));
  }
  
  public boolean a()
  {
    if (((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(161)).a(1) > 0) {
      return false;
    }
    Object localObject = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(55)).c();
    if (localObject == null) {
      return true;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
      if (ServiceAccountFolderManager.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(localPublicAccountInfo.uin))) {
        return false;
      }
    }
    return true;
  }
  
  public void b()
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp isn't instanceof QQAppInterface init model failed!");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hzi(this));
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().addObserver(this);
  }
  
  public void b(String paramString)
  {
    TroopBarAssistantManager.a().f(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    int j = TroopBarAssistantManager.a().b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    SubscriptionFeed localSubscriptionFeed;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localSubscriptionFeed = (SubscriptionFeed)localIterator.next();
    } while ((localSubscriptionFeed.jdField_a_of_type_JavaLangString == null) || (!localSubscriptionFeed.jdField_a_of_type_JavaLangString.equals(paramString)));
    for (int i = localSubscriptionFeed.h;; i = 0)
    {
      d();
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CE", "0X80064CE", 0, 0, "" + i, "" + j, "", "");
      return;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().deleteObserver(this);
    }
  }
  
  public void c(String paramString)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    TroopBarAssistantManager.a().d(paramString, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    d();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hzn(this, paramString));
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1014);
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    SubscriptionFeed localSubscriptionFeed;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localSubscriptionFeed = (SubscriptionFeed)((Iterator)localObject).next();
    } while ((localSubscriptionFeed.jdField_a_of_type_JavaLangString == null) || (!localSubscriptionFeed.jdField_a_of_type_JavaLangString.equals(paramString)));
    for (int i = localSubscriptionFeed.h;; i = 0)
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064D0", "0X80064D0", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new hzj(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp isn't instanceof QQAppInterface");
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      QQMessageFacade localQQMessageFacade = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
      if (localQQMessageFacade != null) {
        a(localQQMessageFacade.e());
      }
    }
  }
  
  public void f()
  {
    b(((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(161)).a(1));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!(paramObject instanceof QQMessageFacade.Message)) && ((paramObject instanceof MessageRecord)))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal())
      {
        ((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(161)).a(paramObservable, 1);
        e();
      }
      if (KandianMergeManager.a(paramObservable, (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface) == 1) {
        break label67;
      }
    }
    label67:
    while ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == 63534)) {
      return;
    }
    g();
    b(TroopBarAssistantManager.a().a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\model\SubscriptionInfoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */