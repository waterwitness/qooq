package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BaseTransFileController$ProcHandler
  extends Handler
{
  public static final int a = 0;
  
  public BaseTransFileController$ProcHandler(BaseTransFileController paramBaseTransFileController, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(BaseTransProcessor paramBaseTransProcessor)
  {
    sendMessage(obtainMessage(0, paramBaseTransProcessor));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof BaseTransProcessor))) {
      paramMessage = (BaseTransProcessor)paramMessage.obj;
    }
    try
    {
      TransferRequest localTransferRequest = paramMessage.a();
      if ((localTransferRequest != null) && (localTransferRequest.jdField_a_of_type_Long != 0L) && (localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) && ((paramMessage.a instanceof QQAppInterface))) {
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQAppInterface)paramMessage.a).a().b(localTransferRequest.c, localTransferRequest.jdField_a_of_type_Int, localTransferRequest.jdField_a_of_type_Long);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    paramMessage.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\BaseTransFileController$ProcHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */