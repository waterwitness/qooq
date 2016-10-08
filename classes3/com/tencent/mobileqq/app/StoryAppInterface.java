package com.tencent.mobileqq.app;

import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.startup.step.LoadDex;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class StoryAppInterface
  extends AppInterface
{
  static final String jdField_a_of_type_JavaLangString = "Q.qqstory.StoryAppInterface";
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private ProcessExitReceiver jdField_a_of_type_ComTencentMobileqqAppProcessExitReceiver;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  
  public StoryAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppProcessExitReceiver = new ProcessExitReceiver(this);
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppProcessExitReceiver, localIntentFilter);
  }
  
  public int a()
  {
    return AppSetting.a;
  }
  
  public QQStoryContext a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  }
  
  public EntityManagerFactory a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public INetEngine a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = new NetEngineFactory();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new LoadDex().c();
    new InitMemoryCache().c();
    new InitUrlDrawable().c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.StoryAppInterface", 2, "Application OnCreate complete");
    }
    RichmediaClient.a().a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.StoryAppInterface", 2, "onCreate");
    }
    PtvTemplateManager.a(this);
    PtvTemplateManager.a(this);
    if (!PtvTemplateManager.a()) {
      PtvTemplateManager.a(this).a();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = new QQStoryContext();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppProcessExitReceiver);
      RichmediaClient.a().b(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
      if (localPresendPicMgr != null) {
        localPresendPicMgr.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      try
      {
        do
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.StoryAppInterface", 2, "onDestroy");
          }
          PtvTemplateManager.b();
          return;
          localIllegalArgumentException = localIllegalArgumentException;
        } while (!QLog.isColorLevel());
        QLog.d("PEAK", 2, "unregisterReceiver: ", localIllegalArgumentException);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\StoryAppInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */