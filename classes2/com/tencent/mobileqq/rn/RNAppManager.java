package com.tencent.mobileqq.rn;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.soloader.SoLoader;
import com.tencent.bitapp.BitAppBundleDownload;
import com.tencent.bitapp.Project;
import com.tencent.bitapp.Project.Builder;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.manager.IPackageFactory;
import com.tencent.bitapp.module.ModuleDetailDownload;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.pre.PreConst;
import com.tencent.bitapp.pre.binder.client.Java2jniClientFactory;
import com.tencent.bitapp.preDownload.RNPreLoader;
import com.tencent.bitapp.report.RNReport;
import com.tencent.bitapp.thread.ThreadManager;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.LolaUpdateRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.UpdateRequestItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0x9d.SubMsgType0x9d.ModuleUpdateNotify;
import ujw;
import ujx;
import ujy;

public class RNAppManager
  implements Manager
{
  public static final String b = RNAppManager.class.getSimpleName();
  AppInterface a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RNAppManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public static int a(Object paramObject, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(String.valueOf(paramObject));
      return i;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return paramInt;
  }
  
  public static BitAppInstanceManager a(AppInterface paramAppInterface, boolean paramBoolean, Class paramClass)
  {
    if (a(paramAppInterface)) {
      a();
    }
    if (TextUtils.isEmpty(BitAppInstanceManager.mAppInterfaceName)) {
      a(paramAppInterface, paramBoolean, paramClass);
    }
    return BitAppInstanceManager.getInstance();
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean, Class paramClass)
  {
    com.tencent.bitapp.Const.isTestPerformance = false;
    FLog.setLoggingDelegate(new RNLoggingDelegate());
    Project.Builder localBuilder = Project.builder().setCacheSaveFolder("/tencent/react/");
    localBuilder.setDebug(false).setIsTestPerformance(false).setIsCheckBundleModify(true);
    localBuilder.build();
    RNReport.setRNReportImpl(new RNReportImpl(paramAppInterface.getAccount()));
    Java2jniClientFactory.setSoStandAlone(paramBoolean);
    try
    {
      paramClass = (IPackageFactory)paramClass.newInstance();
      BitAppInstanceManager.setPackageFactroy(paramClass, paramAppInterface.getClass().getSimpleName());
      ModuleDetailDownload.getInstance().setDownloadAction(new BitAppBundleDownload(paramAppInterface));
      ContextUtils.INSTANCE.setApplicationContext(paramAppInterface.a());
      SoLoader.extSoSource.add(RNPreLoader.a());
      ThreadManager.INSTANCE.execute(new ujw());
      return;
    }
    catch (Exception paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
    }
  }
  
  private void a(List paramList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 4, "checkUpdates");
    }
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((Integer)paramList.next()).intValue();
      mobileqq_mp.UpdateRequestItem localUpdateRequestItem = new mobileqq_mp.UpdateRequestItem();
      localUpdateRequestItem.module_id.set(i);
      ((List)localObject).add(localUpdateRequestItem);
    }
    if (((List)localObject).size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 4, "checkUpdates ... no bundle to update");
      }
      return;
    }
    paramList = new mobileqq_mp.LolaUpdateRequest();
    paramList.versionInfo.set(PublicAccountUtil.a());
    paramList.request_item.addAll((Collection)localObject);
    localObject = new NewIntent(BaseApplicationImpl.a(), PublicAccountServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "lola_update_req");
    ((NewIntent)localObject).putExtra("data", paramList.toByteArray());
    ((NewIntent)localObject).setObserver(new ujy(this, paramBoolean));
    this.a.startServlet((NewIntent)localObject);
  }
  
  public static boolean a()
  {
    BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    if (localBitAppInstanceManager != null)
    {
      localBitAppInstanceManager.onDestroy();
      return true;
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    boolean bool1 = bool2;
    if (localBitAppInstanceManager != null)
    {
      bool1 = bool2;
      if (localBitAppInstanceManager.isInitContextOk())
      {
        bool1 = bool2;
        if (paramAppInterface != null)
        {
          bool1 = bool2;
          if (BitAppInstanceManager.mAppInterfaceName != null)
          {
            bool1 = bool2;
            if (!paramAppInterface.getClass().getSimpleName().equals(BitAppInstanceManager.mAppInterfaceName)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void a(int paramInt, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 4, "handleBundleUpdatePush sumCmd = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(((SubMsgType0x9d.ModuleUpdateNotify)paramList.next()).module_id.get()));
    }
    a(localArrayList, true);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 4, "updateAllBundles");
    }
    Object localObject1 = new File(PreConst.DEFAULT_OUT_MODULES_SAVE_FOLDER).list(new ujx(this));
    if (localObject1 != null)
    {
      localObject2 = Arrays.asList((Object[])localObject1);
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = a(((String)((Iterator)localObject2).next()).replace(".bundle", ""), 0);
        if (i > 0) {
          ((List)localObject1).add(Integer.valueOf(i));
        }
      }
      a((List)localObject1, false);
    }
    while (!QLog.isColorLevel())
    {
      Object localObject2;
      int i;
      return;
    }
    QLog.d(b, 4, "updateAllBundles ... no bundle to update");
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 4, "onDestroyd ...");
    }
    BitAppInstanceManager.setPackageFactroy(null);
    ModuleDetailDownload.getInstance().setDownloadAction(null);
    SoLoader.extSoSource.clear();
    RNReport.setRNReportImpl(null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\RNAppManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */