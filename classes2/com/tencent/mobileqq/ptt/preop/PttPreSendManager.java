package com.tencent.mobileqq.ptt.preop;

import android.os.SystemClock;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tyq;
import tys;

public class PttPreSendManager
  implements Manager
{
  public static final int a = 100000;
  public static final long a = 86399999L;
  public static final String a;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static final int b = 10000000;
  public static boolean b = false;
  public static final int c = 4000;
  public static final int d = 10000;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  PreSendTypeStrategy jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy;
  PttPreVoiceChanger jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger;
  tyq jdField_a_of_type_Tyq;
  boolean jdField_a_of_type_Boolean;
  String b;
  String jdField_c_of_type_JavaLangString;
  volatile boolean jdField_c_of_type_Boolean = false;
  private volatile boolean d;
  int e = -1;
  int f = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PttPreSendManager.class.getSimpleName();
  }
  
  public PttPreSendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static PttPreSendManager a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (PttPreSendManager)paramQQAppInterface.getManager(127);
    if (!paramQQAppInterface.d) {
      try
      {
        if (!paramQQAppInterface.d)
        {
          paramQQAppInterface.a();
          paramQQAppInterface.d = true;
        }
        return paramQQAppInterface;
      }
      finally {}
    }
    return paramQQAppInterface;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    return PttOptimizeParams.d(paramQQAppInterface) == 1;
  }
  
  public void a()
  {
    if (!jdField_b_of_type_Boolean) {
      switch (VcSystemInfo.f())
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Tyq = new tyq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 100000, 10000000, 86399999L);
      this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy = new PreSendTypeStrategy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger = new PttPreVoiceChanger();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "init manager end ");
      }
      return;
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i = 1;
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.a();
    this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.a();
    this.f = ((int)new File(this.jdField_c_of_type_JavaLangString).length());
    if ((this.f > 0) && (this.jdField_a_of_type_Tyq.a(this.jdField_a_of_type_Boolean, this.f)))
    {
      MessageForPtt localMessageForPtt = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, paramSessionInfo, -2, paramRecorderParam.c);
      if (localMessageForPtt == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "createPttMessage null");
        }
        c();
        return;
      }
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localTransferRequest.jdField_c_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localTransferRequest.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
      localTransferRequest.jdField_b_of_type_Int = 2;
      localTransferRequest.jdField_a_of_type_Long = localMessageForPtt.uniseq;
      localTransferRequest.jdField_a_of_type_Boolean = true;
      localTransferRequest.i = this.jdField_c_of_type_JavaLangString;
      localTransferRequest.e = 1002;
      localTransferRequest.l = true;
      localTransferRequest.jdField_n_of_type_Int = 3;
      localTransferRequest.jdField_n_of_type_Boolean = true;
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localMessageForPtt;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localMessageForPtt;
      paramSessionInfo = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      paramSessionInfo.voiceType = paramRecorderParam.c;
      paramSessionInfo.voiceLength = QQRecorder.a(j);
      if (this.e > 0) {}
      for (;;)
      {
        paramSessionInfo.voiceChangeFlag = i;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
        paramSessionInfo = localTransferRequest.jdField_c_of_type_JavaLangString + localTransferRequest.jdField_a_of_type_Long;
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramSessionInfo, new tys(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doPreSendIfIcan ：true");
        return;
        i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "doPreSendIfIcan : false, flow don't enough or size < 0, seiz : " + this.f);
    }
    c();
  }
  
  public void a(String paramString)
  {
    paramString = (tys)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (paramString != null)
    {
      File localFile1 = new File(paramString.jdField_b_of_type_JavaLangString);
      if (localFile1.exists())
      {
        File localFile2 = new File(paramString.jdField_a_of_type_JavaLangString);
        if (localFile2.exists()) {
          localFile2.delete();
        }
        localFile1.renameTo(localFile2);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "rename presend file ! , from " + paramString.jdField_b_of_type_JavaLangString + " to " + paramString.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    this.jdField_c_of_type_Boolean = false;
    this.e = -1;
    boolean bool4 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1 = bool3;
    long l;
    if (jdField_b_of_type_Boolean)
    {
      bool1 = bool3;
      if (bool4)
      {
        this.e = this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy.a();
        l = SystemClock.uptimeMillis();
        if (NetworkUtil.a(BaseApplicationImpl.a) != 1) {
          break label312;
        }
      }
    }
    label312:
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "get network type cost " + (SystemClock.uptimeMillis() - l));
      }
      bool1 = this.jdField_a_of_type_Tyq.a(this.jdField_a_of_type_Boolean);
      if ((bool1) && (this.e != -1))
      {
        this.jdField_b_of_type_JavaLangString = paramString1;
        int i = this.jdField_b_of_type_JavaLangString.lastIndexOf(".");
        this.jdField_c_of_type_JavaLangString = paramString1.substring(0, i);
        this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.concat("_pre").concat(paramString1.substring(i, paramString1.length()));
        this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_c_of_type_JavaLangString, this.e, paramRecorderParam, paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, " startPreSendIfNeed : " + this.jdField_c_of_type_Boolean + ", cpu : " + jdField_b_of_type_Boolean + ", flow enough : " + bool1 + ", type : " + this.e + ", cfg : " + bool4);
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.a(paramArrayOfByte, paramInt)) {
      return;
    }
    c();
  }
  
  /* Error */
  public boolean a(com.tencent.mobileqq.activity.BaseChatPie paramBaseChatPie, int paramInt)
  {
    // Byte code:
    //   0: getstatic 81	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_b_of_type_Boolean	Z
    //   3: ifeq +48 -> 51
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 62	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokespecial 267	com/tencent/mobileqq/ptt/preop/PttPreSendManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   14: ifeq +37 -> 51
    //   17: aload_0
    //   18: getfield 99	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy	Lcom/tencent/mobileqq/ptt/preop/PreSendTypeStrategy;
    //   21: aload_0
    //   22: getfield 62	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: iload_2
    //   26: invokevirtual 338	com/tencent/mobileqq/ptt/preop/PreSendTypeStrategy:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   29: aload_0
    //   30: getfield 56	com/tencent/mobileqq/ptt/preop/PttPreSendManager:e	I
    //   33: iload_2
    //   34: if_icmpne +17 -> 51
    //   37: aload_0
    //   38: getfield 93	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_Tyq	Ltyq;
    //   41: aload_0
    //   42: getfield 132	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_Boolean	Z
    //   45: ldc2_w 339
    //   48: invokevirtual 343	tyq:a	(ZJ)V
    //   51: aload_0
    //   52: getfield 60	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_c_of_type_Boolean	Z
    //   55: ifne +13 -> 68
    //   58: iconst_0
    //   59: istore 6
    //   61: aload_0
    //   62: invokevirtual 150	com/tencent/mobileqq/ptt/preop/PttPreSendManager:c	()V
    //   65: iload 6
    //   67: ireturn
    //   68: aload_0
    //   69: getfield 62	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   72: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   75: astore 4
    //   77: new 215	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   84: aload_0
    //   85: getfield 189	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   88: getfield 346	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   91: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: getfield 189	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   98: getfield 171	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   101: invokevirtual 223	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   104: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 5
    //   109: aload 4
    //   111: aload 5
    //   113: invokevirtual 349	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   116: checkcast 351	com/tencent/mobileqq/transfile/BaseUploadProcessor
    //   119: astore_3
    //   120: aload_3
    //   121: ifnonnull +9 -> 130
    //   124: iconst_0
    //   125: istore 6
    //   127: goto -66 -> 61
    //   130: iload_2
    //   131: aload_0
    //   132: getfield 56	com/tencent/mobileqq/ptt/preop/PttPreSendManager:e	I
    //   135: if_icmpeq +54 -> 189
    //   138: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +13 -> 154
    //   144: getstatic 44	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   147: iconst_2
    //   148: ldc_w 353
    //   151: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_3
    //   155: invokevirtual 355	com/tencent/mobileqq/transfile/BaseUploadProcessor:b	()I
    //   158: pop
    //   159: aload 4
    //   161: aload 5
    //   163: invokevirtual 358	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;)Z
    //   166: pop
    //   167: getstatic 51	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   170: aload 5
    //   172: invokevirtual 248	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: aload_0
    //   177: getfield 104	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger	Lcom/tencent/mobileqq/ptt/preop/PttPreVoiceChanger;
    //   180: invokevirtual 360	com/tencent/mobileqq/ptt/preop/PttPreVoiceChanger:b	()V
    //   183: iconst_0
    //   184: istore 6
    //   186: goto -125 -> 61
    //   189: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +36 -> 228
    //   195: getstatic 44	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   198: iconst_2
    //   199: new 215	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 362
    //   209: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_3
    //   213: getfield 365	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   216: getfield 368	com/tencent/mobileqq/transfile/TransferRequest:o	Z
    //   219: invokevirtual 322	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   222: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: getfield 93	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_Tyq	Ltyq;
    //   232: aload_0
    //   233: getfield 132	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_Boolean	Z
    //   236: aload_0
    //   237: getfield 58	com/tencent/mobileqq/ptt/preop/PttPreSendManager:f	I
    //   240: i2l
    //   241: invokevirtual 343	tyq:a	(ZJ)V
    //   244: aload_0
    //   245: getfield 62	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   248: invokevirtual 371	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   251: aload_0
    //   252: getfield 189	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   255: aload_0
    //   256: getfield 62	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   259: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   262: invokevirtual 378	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   265: aload_0
    //   266: getfield 62	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   269: aload_1
    //   270: getfield 383	com/tencent/mobileqq/activity/BaseChatPie:a	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   273: aload_0
    //   274: getfield 137	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   277: bipush -3
    //   279: aload_0
    //   280: getfield 189	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   283: getfield 171	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   286: invokestatic 386	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;IJ)V
    //   289: new 388	tyr
    //   292: dup
    //   293: aload_0
    //   294: aload_1
    //   295: invokespecial 391	tyr:<init>	(Lcom/tencent/mobileqq/ptt/preop/PttPreSendManager;Lcom/tencent/mobileqq/activity/BaseChatPie;)V
    //   298: aconst_null
    //   299: iconst_0
    //   300: invokestatic 396	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   303: aload_3
    //   304: invokevirtual 398	com/tencent/mobileqq/transfile/BaseUploadProcessor:f	()V
    //   307: aload_3
    //   308: monitorenter
    //   309: aload_3
    //   310: getfield 365	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   313: getfield 368	com/tencent/mobileqq/transfile/TransferRequest:o	Z
    //   316: ifeq +27 -> 343
    //   319: aload 4
    //   321: aload_3
    //   322: getfield 365	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   325: invokevirtual 213	com/tencent/mobileqq/transfile/TransFileController:a	(Lcom/tencent/mobileqq/transfile/TransferRequest;)Z
    //   328: pop
    //   329: aload_0
    //   330: aload 5
    //   332: invokevirtual 400	com/tencent/mobileqq/ptt/preop/PttPreSendManager:a	(Ljava/lang/String;)V
    //   335: aload_3
    //   336: monitorexit
    //   337: iconst_1
    //   338: istore 6
    //   340: goto -279 -> 61
    //   343: aload_3
    //   344: getfield 365	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   347: iconst_1
    //   348: putfield 368	com/tencent/mobileqq/transfile/TransferRequest:o	Z
    //   351: goto -16 -> 335
    //   354: astore_1
    //   355: aload_3
    //   356: monitorexit
    //   357: aload_1
    //   358: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	PttPreSendManager
    //   0	359	1	paramBaseChatPie	com.tencent.mobileqq.activity.BaseChatPie
    //   0	359	2	paramInt	int
    //   119	237	3	localBaseUploadProcessor	BaseUploadProcessor
    //   75	245	4	localTransFileController	TransFileController
    //   107	224	5	str	String
    //   59	280	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   309	335	354	finally
    //   335	337	354	finally
    //   343	351	354	finally
    //   355	357	354	finally
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy.a(null, -1);
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 4, "doOnCancelSend");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
    localObject = (BaseUploadProcessor)((TransFileController)localObject).a(str);
    if (localObject != null) {
      ((BaseUploadProcessor)localObject).b();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.b();
    c();
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    } while (!QLog.isDevelopLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 4, "clean up");
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Tyq != null) {
      this.jdField_a_of_type_Tyq.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\preop\PttPreSendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */