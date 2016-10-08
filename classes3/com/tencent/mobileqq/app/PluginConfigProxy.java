package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import mqq.os.MqqHandler;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;
import qcx;

public class PluginConfigProxy
  extends ServerConfigObserver
{
  private int jdField_a_of_type_Int;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ArrayList b;
  
  public PluginConfigProxy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.b = new ArrayList();
  }
  
  public void a(int paramInt, List paramList, ServerConfigObserver paramServerConfigObserver)
  {
    this.b.addAll(paramList);
    this.jdField_a_of_type_Int |= paramInt;
    if (paramServerConfigObserver != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramServerConfigObserver);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ((ServerConfigManager)paramQQAppInterface.getManager(4)).getPluginConfig(this.jdField_a_of_type_Int, localReqUserInfo, this.b, this);
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    if ((this.jdField_a_of_type_Int & paramInt) == 0) {}
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ServerConfigObserver localServerConfigObserver = (ServerConfigObserver)localIterator.next();
          ThreadManager.b().post(new qcx(this, localServerConfigObserver, paramBoolean, paramInt, paramGetResourceRespV2));
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\PluginConfigProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */