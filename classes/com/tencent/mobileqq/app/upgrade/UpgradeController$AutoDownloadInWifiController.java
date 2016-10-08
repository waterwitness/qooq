package com.tencent.mobileqq.app.upgrade;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.NetworkUtil;

public class UpgradeController$AutoDownloadInWifiController
  implements INetEventHandler
{
  private Context jdField_a_of_type_AndroidContentContext;
  
  public UpgradeController$AutoDownloadInWifiController(UpgradeController paramUpgradeController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = UpgradeController.a(paramUpgradeController);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/mobileqq/app/upgrade/UpgradeController$AutoDownloadInWifiController:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6: aload_0
    //   7: invokestatic 38	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:registerNetChangeReceiver	(Landroid/content/Context;Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;)V
    //   10: invokestatic 42	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:isWifiConn	()Z
    //   13: ifeq +11 -> 24
    //   16: aload_0
    //   17: getfield 13	com/tencent/mobileqq/app/upgrade/UpgradeController$AutoDownloadInWifiController:jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController	Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   20: iconst_1
    //   21: invokevirtual 46	com/tencent/mobileqq/app/upgrade/UpgradeController:c	(Z)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    //   32: astore_1
    //   33: goto -23 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	AutoDownloadInWifiController
    //   27	4	1	localObject	Object
    //   32	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	10	27	finally
    //   10	24	27	finally
    //   2	10	32	java/lang/Exception
  }
  
  public void b()
  {
    try
    {
      AppNetConnInfo.unregisterNetEventHandler(this);
      this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.c();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    finally {}
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext);
    if (i == 0) {
      if (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController)) {
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.e();
      }
    }
    do
    {
      return;
      if (i == 1)
      {
        if (!UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.c(true);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.d();
        return;
      }
    } while ((i != 0) || (!UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController)));
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeController.e();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\upgrade\UpgradeController$AutoDownloadInWifiController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */