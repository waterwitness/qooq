package com.tencent.mobileqq.activity.aio;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;
import nda;
import ndb;

public class FileTransferManager
  implements Manager
{
  public static final String a = "FileTransferManager";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public FileTransferManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new nda(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPicDownloadProcessor.class, GroupPicDownloadProcessor.class, ForwardImageProcessor.class, ShortVideoUploadProcessor.class, ShortVideoDownloadProcessor.class, ShortVideoForwardProcessor.class, PAAudioPttDownloadProcessor.class });
    a(paramQQAppInterface);
  }
  
  public static FileTransferManager a(QQAppInterface paramQQAppInterface)
  {
    return (FileTransferManager)paramQQAppInterface.getManager(22);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
  }
  
  public void a(Message paramMessage)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!QLog.isColorLevel()) {
          break label191;
        }
        QLog.d("FileTransferManager", 2, "handleMessage" + ((FileMsg)paramMessage.obj).c + " status " + paramMessage.what + "retCode " + paramMessage.arg1);
      }
      finally {}
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject2 = (ndb)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject1 = ((ndb)localObject2).a();
        localObject2 = ((ndb)localObject2).a();
        if ((localObject1 != null) && (localObject2 != null))
        {
          ((FileTransferManager.Callback)localObject2).a((View)localObject1, (FileMsg)paramMessage.obj, paramMessage.what, paramMessage.arg1);
        }
        else
        {
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
          int j = i - 1;
          ((ArrayList)localObject1).remove(i);
          i = j;
        }
      }
      else
      {
        OpenApiManager.a().a((FileMsg)paramMessage.obj, paramMessage.what, paramMessage.arg1);
        return;
        label191:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  /* Error */
  public void a(View paramView, FileTransferManager.Callback paramCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/mobileqq/activity/aio/FileTransferManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 193	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface 198 1 0
    //   16: ifeq +39 -> 55
    //   19: aload_3
    //   20: invokeinterface 202 1 0
    //   25: checkcast 166	ndb
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 169	ndb:a	()Landroid/view/View;
    //   35: aload_1
    //   36: if_acmpne -26 -> 10
    //   39: aload 4
    //   41: new 204	java/lang/ref/WeakReference
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 207	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   49: putfield 210	ndb:b	Ljava/lang/ref/WeakReference;
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield 42	com/tencent/mobileqq/activity/aio/FileTransferManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   59: new 166	ndb
    //   62: dup
    //   63: aload_0
    //   64: aload_1
    //   65: aload_2
    //   66: invokespecial 213	ndb:<init>	(Lcom/tencent/mobileqq/activity/aio/FileTransferManager;Landroid/view/View;Lcom/tencent/mobileqq/activity/aio/FileTransferManager$Callback;)V
    //   69: invokevirtual 217	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: goto -21 -> 52
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	FileTransferManager
    //   0	81	1	paramView	View
    //   0	81	2	paramCallback	FileTransferManager.Callback
    //   9	11	3	localIterator	java.util.Iterator
    //   28	12	4	localndb	ndb
    // Exception table:
    //   from	to	target	type
    //   2	10	76	finally
    //   10	52	76	finally
    //   55	73	76	finally
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\FileTransferManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */