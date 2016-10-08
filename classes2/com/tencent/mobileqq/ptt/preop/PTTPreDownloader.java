package com.tencent.mobileqq.ptt.preop;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PttDownExtraInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import mqq.manager.Manager;
import tyn;
import typ;

public final class PTTPreDownloader
  implements Handler.Callback, Manager
{
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "PTTPreDownloader";
  public static final int b = 2;
  public static final int c = 3;
  private static final int d = 3;
  private static final int e = 0;
  private static final int f = 1;
  private static final int g = 2;
  private static final int h = 3;
  private static final int i = 4;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PTTPreDownloader.IPreDownloadStrategy jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private final typ jdField_a_of_type_Typ;
  private boolean jdField_a_of_type_Boolean;
  private final typ jdField_b_of_type_Typ;
  private boolean jdField_b_of_type_Boolean;
  private final typ c;
  
  public PTTPreDownloader(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Typ = new typ();
    this.jdField_b_of_type_Typ = new typ();
    this.c = new typ();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.b(), this);
    a(new tyn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler));
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.url == null) {}
    int j;
    do
    {
      return 2005;
      if ((paramMessageForPtt.url.startsWith(AppConstants.bh)) && (FileUtils.a(paramMessageForPtt.getLocalFilePath()))) {
        return 2003;
      }
      j = paramQQAppInterface.a().b(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
    } while ((j == -1) && (paramMessageForPtt.fileSize == -4L));
    return j;
  }
  
  public static PTTPreDownloader a(QQAppInterface paramQQAppInterface)
  {
    return (PTTPreDownloader)paramQQAppInterface.getManager(126);
  }
  
  private typ a(MessageForPtt paramMessageForPtt)
  {
    typ localtyp = null;
    if (paramMessageForPtt.istroop == 0) {
      localtyp = this.jdField_a_of_type_Typ;
    }
    do
    {
      return localtyp;
      if (paramMessageForPtt.istroop == 1) {
        return this.jdField_b_of_type_Typ;
      }
    } while (paramMessageForPtt.istroop != 3000);
    return this.c;
  }
  
  private void a(typ paramtyp)
  {
    int j = 0;
    if (j < paramtyp.jdField_a_of_type_JavaUtilArrayList.size())
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)paramtyp.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy.b(localMessageForPtt)) {
        if (localMessageForPtt.extFlag != -1L) {
          break label98;
        }
      }
      label98:
      for (long l = localMessageForPtt.extFlag;; l = (0x3 ^ 0xFFFFFFFFFFFFFFFF) & localMessageForPtt.extFlag)
      {
        localMessageForPtt.extFlag = l;
        localMessageForPtt.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
        j += 1;
        break;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "handleAddrReady:" + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      a(this.jdField_a_of_type_Typ);
      a(this.jdField_b_of_type_Typ);
      a(this.c);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, MessageForPtt paramMessageForPtt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "handleDownloadFinish uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", sucess:" + paramBoolean);
    }
    if ((paramMessageForPtt.extFlag > 0L) && ((paramMessageForPtt.extFlag & 1L) > 0L))
    {
      if (!paramBoolean) {
        break label129;
      }
      this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy.b(paramMessageForPtt);
    }
    label129:
    while (((paramMessageForPtt.extFlag & 0x2) != 0L) || (!this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy.a(paramMessageForPtt, 3)))
    {
      paramMessageForPtt = a(paramMessageForPtt);
      if (paramMessageForPtt != null)
      {
        paramMessageForPtt.jdField_a_of_type_Int -= 1;
        if (paramMessageForPtt.jdField_a_of_type_Int < 0) {
          paramMessageForPtt.jdField_a_of_type_Int = 0;
        }
        a(paramMessageForPtt);
      }
      return;
    }
    if (paramMessageForPtt.extFlag == -1L) {}
    for (long l = paramMessageForPtt.extFlag;; l = (0x3 ^ 0xFFFFFFFFFFFFFFFF) & paramMessageForPtt.extFlag)
    {
      paramMessageForPtt.extFlag = l;
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      break;
    }
  }
  
  private boolean a(typ paramtyp)
  {
    boolean bool = false;
    if ((paramtyp.jdField_a_of_type_Int < 3) && (paramtyp.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)paramtyp.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy.a(localMessageForPtt))
      {
        long l;
        if (!g(localMessageForPtt)) {
          if (this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy.b(localMessageForPtt))
          {
            if (localMessageForPtt.extFlag != -1L) {
              break label121;
            }
            l = localMessageForPtt.extFlag;
            label83:
            localMessageForPtt.extFlag = l;
            localMessageForPtt.serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
          }
        }
        for (;;)
        {
          break;
          label121:
          l = (0x3 ^ 0xFFFFFFFFFFFFFFFF) & localMessageForPtt.extFlag;
          break label83;
          paramtyp.jdField_a_of_type_Int += 1;
          paramtyp.jdField_a_of_type_JavaUtilArrayList.remove(0);
          bool = true;
        }
      }
    }
    return bool;
  }
  
  private boolean d(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.istroop == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramMessageForPtt.frienduin) != 1)) {}
    int j;
    typ localtyp;
    label289:
    label350:
    do
    {
      for (;;)
      {
        return true;
        if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(paramMessageForPtt.frienduin))
        {
          j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (QLog.isDevelopLevel()) {
            QLog.d("PTTPreDownloader", 4, "handleReceivedPTT uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", status:" + j);
          }
          if ((j == 0) || (j == -1))
          {
            localtyp = a(paramMessageForPtt);
            if (localtyp != null)
            {
              if (!this.jdField_b_of_type_Boolean) {
                break;
              }
              long l;
              if ((localtyp.jdField_a_of_type_Int < 3) && (this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy.a(paramMessageForPtt))) {
                if (!g(paramMessageForPtt)) {
                  if (this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy.b(paramMessageForPtt))
                  {
                    if (paramMessageForPtt.extFlag != -1L) {
                      break label289;
                    }
                    l = paramMessageForPtt.extFlag;
                    paramMessageForPtt.extFlag = l;
                    paramMessageForPtt.serial();
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
                  }
                }
              }
              for (;;)
              {
                if (paramMessageForPtt.voiceChangeFlag != 1) {
                  break label350;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7D", 0, 0, "" + paramMessageForPtt.istroop, "", "", "");
                return true;
                l = (0x3 ^ 0xFFFFFFFFFFFFFFFF) & paramMessageForPtt.extFlag;
                break;
                localtyp.jdField_a_of_type_Int += 1;
                continue;
                j = localtyp.jdField_a_of_type_JavaUtilArrayList.size();
                localtyp.getClass();
                if (j + 1 < 99) {
                  localtyp.jdField_a_of_type_JavaUtilArrayList.add(paramMessageForPtt);
                }
              }
            }
          }
        }
      }
      j = localtyp.jdField_a_of_type_JavaUtilArrayList.size();
      localtyp.getClass();
    } while (j + 1 >= 99);
    localtyp.jdField_a_of_type_JavaUtilArrayList.add(paramMessageForPtt);
    return true;
  }
  
  private boolean e(MessageForPtt paramMessageForPtt)
  {
    return true;
  }
  
  private boolean f(MessageForPtt paramMessageForPtt)
  {
    long l = 2L;
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "handleViewPTT uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy.a(paramMessageForPtt, 1)) {
      if (paramMessageForPtt.extFlag != -1L) {
        break label113;
      }
    }
    for (;;)
    {
      paramMessageForPtt.extFlag = l;
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      return true;
      label113:
      l = 0x2 | paramMessageForPtt.extFlag;
    }
  }
  
  private boolean g(MessageForPtt paramMessageForPtt)
  {
    boolean bool2 = false;
    int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
    boolean bool1;
    TransferRequest localTransferRequest;
    if (j != 0)
    {
      bool1 = bool2;
      if (j != -1) {}
    }
    else
    {
      localTransferRequest = new TransferRequest();
      localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localTransferRequest.jdField_c_of_type_JavaLangString = paramMessageForPtt.frienduin;
      localTransferRequest.jdField_a_of_type_Int = paramMessageForPtt.istroop;
      localTransferRequest.jdField_b_of_type_Int = 2;
      localTransferRequest.jdField_a_of_type_Long = paramMessageForPtt.uniseq;
      localTransferRequest.jdField_a_of_type_Boolean = false;
      localTransferRequest.e = paramMessageForPtt.urlAtServer;
      localTransferRequest.h = paramMessageForPtt.getLocalFilePath();
      if ((!paramMessageForPtt.isSendFromOtherTerminal()) && (!paramMessageForPtt.isSend())) {
        break label242;
      }
      bool1 = true;
    }
    for (;;)
    {
      localTransferRequest.jdField_b_of_type_Boolean = bool1;
      localTransferRequest.f = paramMessageForPtt.md5;
      localTransferRequest.jdField_c_of_type_Long = paramMessageForPtt.groupFileID;
      localTransferRequest.g = paramMessageForPtt.groupFileKeyStr;
      localTransferRequest.d = paramMessageForPtt.subVersion;
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForPtt;
      localTransferRequest.jdField_a_of_type_JavaLangObject = new TransferRequest.PttDownExtraInfo(6, 0);
      try
      {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
        if (QLog.isDevelopLevel()) {
          QLog.d("PTTPreDownloader", 4, "startDownload uin:" + paramMessageForPtt.frienduin + ", seq:" + paramMessageForPtt.uniseq + ", doIt:" + bool1);
        }
        return bool1;
        label242:
        bool1 = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bool1 = bool2;
        }
      }
    }
  }
  
  public void a(PTTPreDownloader.IPreDownloadStrategy paramIPreDownloadStrategy)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy = paramIPreDownloadStrategy;
  }
  
  public void a(boolean paramBoolean, int paramInt, TransferRequest.PttDownExtraInfo paramPttDownExtraInfo, MessageForPtt paramMessageForPtt)
  {
    paramPttDownExtraInfo = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (paramBoolean) {}
    for (int j = 1;; j = 0)
    {
      paramPttDownExtraInfo.obtainMessage(2, j, paramInt, paramMessageForPtt).sendToTarget();
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    int j = 1;
    if (!paramBoolean1) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PTTPreDownloader", 4, "onAddrProviderReady delay:" + paramBoolean2);
    }
    if (paramBoolean2)
    {
      localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
      if (paramBoolean1) {}
      for (;;)
      {
        localObject = ((WeakReferenceHandler)localObject).obtainMessage(3, j, 0);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject, 30000L);
        return;
        j = 0;
      }
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (paramBoolean1) {}
    for (j = k;; j = 0)
    {
      ((WeakReferenceHandler)localObject).obtainMessage(3, j, 0).sendToTarget();
      return;
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(0, paramMessageForPtt).sendToTarget();
    return true;
  }
  
  public boolean b(MessageForPtt paramMessageForPtt)
  {
    long l = 2L;
    int k = 0;
    int j;
    if (paramMessageForPtt.isSendFromLocal()) {
      j = k;
    }
    while (j == 0)
    {
      return true;
      j = k;
      if (paramMessageForPtt.getPttStreamFlag() != 10001)
      {
        j = k;
        if (paramMessageForPtt.extFlag != -1L)
        {
          j = k;
          if ((paramMessageForPtt.extFlag & 0x2) <= 0L)
          {
            j = k;
            if (paramMessageForPtt.fileSize > 0L) {
              j = 1;
            }
          }
        }
      }
    }
    if (paramMessageForPtt.extFlag == -1L) {}
    for (;;)
    {
      paramMessageForPtt.extFlag = l;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(4, paramMessageForPtt).sendToTarget();
      return true;
      l = 0x2 | paramMessageForPtt.extFlag;
    }
  }
  
  public boolean c(MessageForPtt paramMessageForPtt)
  {
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      d((MessageForPtt)paramMessage.obj);
      return true;
    case 1: 
      e((MessageForPtt)paramMessage.obj);
      return true;
    case 3: 
      if (paramMessage.arg1 != 0) {
        bool = true;
      }
      a(bool);
      return true;
    case 2: 
      if (paramMessage.arg1 != 0) {}
      for (bool = true;; bool = false)
      {
        a(bool, paramMessage.arg2, (MessageForPtt)paramMessage.obj);
        return true;
      }
    }
    f((MessageForPtt)paramMessage.obj);
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
    a(this.jdField_a_of_type_Typ);
    a(this.jdField_b_of_type_Typ);
    a(this.c);
    this.jdField_a_of_type_ComTencentMobileqqPttPreopPTTPreDownloader$IPreDownloadStrategy.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\preop\PTTPreDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */