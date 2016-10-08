package com.tencent.bitapp.preDownload;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import hdy;
import hdz;

public class RNPreDownloadFacade
{
  private static DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  private static QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "RNPreDownloadFacade";
  private static boolean jdField_a_of_type_Boolean;
  private static DialogInterface.OnClickListener b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static DialogInterface.OnClickListener a(RNPreDownloadHandler paramRNPreDownloadHandler)
  {
    if (jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) {
      jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new hdy(paramRNPreDownloadHandler);
    }
    return jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  }
  
  public static QQCustomDialog a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return DialogUtil.a(paramContext, 230, paramContext.getString(2131372517), paramContext.getString(2131372518), 2131367262, 2131367263, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static void a()
  {
    b = null;
    jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  private static void a(IRNPreDownloadListener paramIRNPreDownloadListener, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RNPreDownloadFacade", 4, "notifyListener listener: " + paramIRNPreDownloadListener + " | isSuccess: " + paramBoolean + " | errorCode: " + paramInt);
    }
    if (paramIRNPreDownloadListener != null)
    {
      if (paramBoolean) {
        paramIRNPreDownloadListener.a();
      }
    }
    else {
      return;
    }
    paramIRNPreDownloadListener.a(paramInt);
  }
  
  private static void a(RNPreDownloadHandler paramRNPreDownloadHandler, Context paramContext, boolean paramBoolean, IRNPreDownloadListener paramIRNPreDownloadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RNPreDownloadFacade", 4, "downloadPreload only support download on wifi isNeedAsk: " + paramBoolean);
    }
    if (paramBoolean)
    {
      paramRNPreDownloadHandler.a(paramIRNPreDownloadListener);
      if ((jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RNPreDownloadFacade", 4, "dialog is showing, wait user choice");
        }
        return;
      }
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = a(paramContext, a(paramRNPreDownloadHandler), b(paramRNPreDownloadHandler));
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    a(paramIRNPreDownloadListener, false, -100);
  }
  
  public static void a(RNPreDownloadHandler paramRNPreDownloadHandler, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RNPreDownloadFacade", 4, "downloadPreload restartDownload isUserClick: " + paramBoolean);
    }
    paramRNPreDownloadHandler.a(paramBoolean);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, boolean paramBoolean, IRNPreDownloadListener paramIRNPreDownloadListener)
  {
    a(paramAppInterface, paramContext, paramBoolean, paramIRNPreDownloadListener, false);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, boolean paramBoolean1, IRNPreDownloadListener paramIRNPreDownloadListener, boolean paramBoolean2)
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("RNPreDownloadFacade", 4, "downloadPreload isNeedAsk: " + paramBoolean1 + " | isPreloaded: " + bool + "| app = " + paramAppInterface + "| acrossProcess:" + paramBoolean2);
    }
    if (bool) {
      a(paramIRNPreDownloadListener, true, 0);
    }
    do
    {
      return;
      if (paramAppInterface == null)
      {
        a(paramIRNPreDownloadListener, false, -101);
        return;
      }
      if ((paramAppInterface instanceof QQAppInterface))
      {
        b(paramAppInterface, paramContext, paramBoolean1, paramIRNPreDownloadListener, paramBoolean2);
        return;
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    ((NearbyAppInterface)paramAppInterface).a().a(paramBoolean1, paramIRNPreDownloadListener);
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    jdField_a_of_type_Boolean = RNPreLoader.a();
    if (QLog.isColorLevel()) {
      QLog.d("RNPreDownloadFacade", 2, "isReady: " + jdField_a_of_type_Boolean);
    }
    return jdField_a_of_type_Boolean;
  }
  
  private static DialogInterface.OnClickListener b(RNPreDownloadHandler paramRNPreDownloadHandler)
  {
    if (b == null) {
      b = new hdz(paramRNPreDownloadHandler);
    }
    return b;
  }
  
  private static void b(AppInterface arg0, Context paramContext, boolean paramBoolean1, IRNPreDownloadListener paramIRNPreDownloadListener, boolean paramBoolean2)
  {
    ??? = (EarlyDownloadManager)???.getManager(76);
    if (??? == null)
    {
      a(paramIRNPreDownloadListener, false, -101);
      return;
    }
    RNPreDownloadHandler localRNPreDownloadHandler = (RNPreDownloadHandler)???.a("qq.android.reactnative.system.resource");
    if (localRNPreDownloadHandler == null)
    {
      a(paramIRNPreDownloadListener, false, -101);
      return;
    }
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (localRNPreDownloadHandler.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("RNPreDownloadFacade", 4, "downloadPreload downloading");
          }
          localRNPreDownloadHandler.a(paramIRNPreDownloadListener);
          return;
        }
      }
      boolean bool = NetworkUtil.i(BaseApplicationImpl.getContext());
      if ((paramBoolean2) || (bool))
      {
        localRNPreDownloadHandler.a(paramIRNPreDownloadListener);
        if (paramBoolean2) {
          ((RNPreDownloadData)localRNPreDownloadHandler.a()).isIngoreNet = true;
        }
        a(localRNPreDownloadHandler, paramBoolean2);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        long l2 = System.currentTimeMillis();
        QLog.d("RNPreDownloadFacade", 4, "Spend time is: " + (l2 - l1));
        return;
        if (paramContext != null) {
          a(localRNPreDownloadHandler, paramContext, paramBoolean1, paramIRNPreDownloadListener);
        } else {
          a(paramIRNPreDownloadListener, false, -101);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\preDownload\RNPreDownloadFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */