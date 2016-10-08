package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import qjb;

public class EcShopFirstRunMsgConfigs
  extends AsyncStep
{
  public EcShopFirstRunMsgConfigs()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "EcShopFirstRunMsgConfigs start in addEcShopAssistToRUFirstTime...");
    }
    ((EcShopAssistantManager)this.a.b.getManager(87)).b();
    qjb localqjb = new qjb(this);
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.a.b.getManager(46)).a(1);
    if (localDownloaderInterface != null)
    {
      Object localObject = EmosmUtils.a("VIP_shop_assit_cfg", EcShopAssistantManager.E);
      if (localDownloaderInterface.a((String)localObject) == null)
      {
        File localFile = new File(EcShopAssistantManager.F);
        localObject = new DownloadTask((String)localObject, localFile);
        if (localFile.exists())
        {
          long l = localFile.lastModified();
          ((DownloadTask)localObject).i = this.a.b.a().getSharedPreferences("ecshop_sp", 0).getLong(EcShopAssistantManager.D, 0L);
          if (Long.valueOf(l).longValue() != ((DownloadTask)localObject).i) {
            ((DownloadTask)localObject).k = true;
          }
        }
        ((DownloadTask)localObject).h = true;
        ((DownloadTask)localObject).n = false;
        localDownloaderInterface.a((DownloadTask)localObject, localqjb, new Bundle());
      }
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\EcShopFirstRunMsgConfigs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */