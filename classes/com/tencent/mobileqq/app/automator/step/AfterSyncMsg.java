package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.bitapp.BitAppManager;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyChannelRecommendManager;
import com.tencent.biz.pubaccount.util.PAReportManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.memory.MemoryReporter;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.RedPacketServlet;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.Hashtable;
import java.util.List;
import mqq.os.MqqHandler;
import qio;

public class AfterSyncMsg
  extends AsyncStep
{
  public AfterSyncMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void c()
  {
    if (this.a.c) {
      ((TroopHandler)this.a.b.a(20)).a();
    }
    ((FriendListHandler)this.a.b.a(1)).b();
    e();
    ((CircleManager)this.a.b.getManager(34)).a();
    Object localObject = (PortalManager)this.a.b.getManager(78);
    RedPacketServlet.a(this.a.b, ((PortalManager)localObject).c());
    localObject = (OlympicManager)this.a.b.getManager(166);
    if (localObject != null)
    {
      OlympicServlet.b(this.a.b, ((OlympicManager)localObject).b());
      ((OlympicManager)localObject).n();
    }
    localObject = (PrecoverManager)this.a.b.getManager(178);
    int i;
    if (localObject != null)
    {
      if (((PrecoverManager)localObject).a()) {
        ConfigServlet.i(this.a.b, this.a.b.a());
      }
    }
    else
    {
      localObject = (ArResourceManager)this.a.b.getManager(167);
      if (localObject != null) {
        ((ArResourceManager)localObject).a(true, false);
      }
      ((PhoneContactManagerImp)this.a.b.getManager(10)).a(true, true);
      ((MyBusinessManager)this.a.b.getManager(48)).a();
      localObject = (DingdongPluginManager)this.a.b.getManager(114);
      ((DingdongPluginManager)localObject).b();
      ((DingdongPluginManager)localObject).c();
      this.a.b.a().m();
      ((PAReportManager)this.a.b.getManager(100)).a();
      ((BitAppManager)this.a.b.getManager(143)).a();
      localObject = (PasswdRedBagManager)this.a.b.getManager(124);
      ((PasswdRedBagManager)localObject).b();
      ((PasswdRedBagManager)localObject).a();
      ((PreloadManager)this.a.b.getManager(150)).b();
      QWalletCommonManager.a(this.a.b);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg onReconnect");
      }
      this.a.b.a().r();
      i = NetworkUtil.a(BaseApplicationImpl.a());
      switch (i)
      {
      }
    }
    for (;;)
    {
      if (i == 1) {
        ((PhotoPlusManager)this.a.b.getManager(168)).a(false);
      }
      long l1 = SharedPreUtils.a(BaseApplicationImpl.a());
      long l2 = System.currentTimeMillis();
      if (Math.abs(l2 - l1) > 21600000L)
      {
        ConfigServlet.a(this.a.b, this.a.b.a(), -1, "doOnReconnect");
        SharedPreUtils.a(BaseApplicationImpl.a(), l2);
      }
      ReadInJoyChannelRecommendManager.a().a(this.a.b);
      QWalletHelper.c(this.a.b);
      return;
      ((PrecoverManager)localObject).a();
      break;
      ((BlessManager)this.a.b.getManager(137)).f();
    }
  }
  
  private void d()
  {
    this.a.b.a().a();
    this.a.b.a().b();
    this.a.b.a().a(0, false);
    ((QQStoryHandler)this.a.b.a(98)).a();
    ((SVIPHandler)this.a.b.a(13)).a();
    this.a.b.l = true;
    this.a.b.A();
    this.a.b.a(false);
    if (this.a.c) {
      ((TroopHandler)this.a.b.a(20)).a();
    }
    e();
    ((EqqDetailDataManager)this.a.b.getManager(68)).a();
    ThreadManager.b().post(new qio(this));
    ((PublicAccountDataManager)this.a.b.getManager(55)).a();
    Object localObject = (AccountDetailDynamicDataManager)this.a.b.getManager(172);
    localObject = (PhoneContactManagerImp)this.a.b.getManager(10);
    ((PhoneContactManagerImp)localObject).d();
    ConfigServlet.c(this.a.b, this.a.b.a());
    ((PhoneContactManagerImp)localObject).a(true, true);
    ((CircleManager)this.a.b.getManager(34)).a();
    localObject = (ActivateFriendsManager)this.a.b.getManager(84);
    if (localObject != null) {
      ((ActivateFriendsManager)localObject).a();
    }
    PublicAccountConfigUtil.d(this.a.b);
    PublicAccountConfigUtil.a(this.a.b);
    PublicAccountConfigUtil.a(this.a.b, PublicAccountConfigUtil.a(this.a.b));
    localObject = (DingdongPluginManager)this.a.b.getManager(114);
    ((DingdongPluginManager)localObject).b();
    ((DingdongPluginManager)localObject).c();
    PublicAccountConfigUtil.e(this.a.b);
    this.a.b.a().p();
    this.a.b.a().m();
    SQLiteFTSUtils.b();
    ((PAReportManager)this.a.b.getManager(100)).a();
    localObject = (PhoneUnityManager)this.a.b.getManager(101);
    ((PhoneUnityManager)localObject).b();
    ((PhoneUnityManager)localObject).c();
    localObject = (BitAppManager)this.a.b.getManager(143);
    ((BitAppManager)localObject).a();
    ((BitAppManager)localObject).d();
    localObject = (PasswdRedBagManager)this.a.b.getManager(124);
    ((PasswdRedBagManager)localObject).b();
    ((PasswdRedBagManager)localObject).a();
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg afterLogin");
    }
    this.a.b.a().r();
    this.a.b.H();
    SearchConfigManager.a(this.a.b);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
    ((FTSTroopOperator)this.a.b.a().a(2)).f();
    MemoryReporter.a().a();
    QWalletCommonManager.a(this.a.b);
    QWalletHelper.c(this.a.b);
  }
  
  private void e()
  {
    boolean bool2 = true;
    Object localObject = (FriendListHandler)this.a.b.a(1);
    this.a.b.a().k();
    f();
    ((DiscussionHandler)this.a.b.a(6)).d();
    ((FriendListHandler)localObject).c();
    ((FriendListHandler)localObject).a();
    localObject = this.a.b.a();
    boolean bool1;
    if (!this.a.d)
    {
      bool1 = true;
      if (this.a.e) {
        break label131;
      }
    }
    for (;;)
    {
      ((MessageHandler)localObject).a(bool1, bool2);
      this.a.b.a().n();
      this.a.b.a().m();
      return;
      bool1 = false;
      break;
      label131:
      bool2 = false;
    }
  }
  
  private void f()
  {
    if (SystemUtil.a())
    {
      com.tencent.mobileqq.utils.FileUtils.b(AppConstants.bj + "head/" + ".nomedia");
      com.tencent.mobileqq.utils.FileUtils.b(AppConstants.bG + ".nomedia");
    }
    if (this.a.a.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    EntityManager localEntityManager = this.a.b.a().createEntityManager();
    List localList = localEntityManager.a(Setting.class, new Setting().getTableName(), false, "bHeadType=? or (bHeadType<>? and bUsrType=?)", new String[] { "0", "0", "4" }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject2 = (Setting)localList.get(i);
        if ((((Setting)localObject2).uin != null) && (((Setting)localObject2).uin.length() > 0))
        {
          if (((Setting)localObject2).bUsrType != 4) {
            break label390;
          }
          if ((((Setting)localObject2).bHeadType != 0) || (((Setting)localObject2).systemHeadID != 0)) {
            break label250;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label250:
          label275:
          int j;
          label278:
          String str1;
          String str2;
          if (((Setting)localObject2).uin.startsWith("troop_"))
          {
            localObject1 = ((Setting)localObject2).uin.substring(6);
            j = 4;
            str1 = this.a.b.a(j, (String)localObject1);
            str2 = this.a.b.a(j, (String)localObject1, 0);
            if (((Setting)localObject2).bHeadType != 0) {
              break label402;
            }
          }
          label390:
          label402:
          for (localObject1 = "sys_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label411;
            }
            if (!((File)localObject2).exists()) {
              break;
            }
            ((File)localObject2).delete();
            break;
            localObject1 = ((Setting)localObject2).uin;
            break label275;
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
            break label278;
          }
          label411:
          if (((File)localObject2).exists())
          {
            com.tencent.mobileqq.transfile.filebrowser.FileUtils.a(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localEntityManager.a();
    Object localObject1 = new File(AppConstants.bj + "head/" + "_thd/");
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    this.a.a.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  protected int a()
  {
    switch (this.h)
    {
    default: 
      this.a.b.a().a(false);
      this.a.a(6008, false, null, true);
    }
    for (;;)
    {
      return 7;
      d();
      continue;
      c();
      continue;
      e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\AfterSyncMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */