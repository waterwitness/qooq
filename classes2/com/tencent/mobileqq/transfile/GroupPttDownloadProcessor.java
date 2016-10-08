package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.os.MqqHandler;

public class GroupPttDownloadProcessor
  extends BaseDownloadProcessor
  implements INetEngine.IBreakDownFix, Runnable
{
  public static final int aJ = 1;
  public static final int aK = 2;
  public static final int aL = 3;
  public static final int aM = 4;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  private TransferRequest.PttDownExtraInfo jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo;
  byte[] jdField_a_of_type_ArrayOfByte;
  long c;
  boolean d;
  private boolean e;
  String i;
  private long jdField_j_of_type_Long;
  String jdField_j_of_type_JavaLangString;
  private long jdField_k_of_type_Long;
  String jdField_k_of_type_JavaLangString;
  private String l;
  
  public GroupPttDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
  }
  
  private void d(boolean paramBoolean)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        if (this.l != null)
        {
          boolean bool = f();
          if (bool)
          {
            if (m != 0)
            {
              if (!this.jdField_e_of_type_Boolean) {
                continue;
              }
              FMTSrvAddrProvider.a().a().a(0);
            }
            this.l = null;
            if (!paramBoolean) {
              break label140;
            }
            f(4);
            if (QLog.isDevelopLevel()) {
              QLog.d("SPD", 4, "directDownloadIfCan error");
            }
            if (!bool) {
              break label148;
            }
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = 2005L;
            a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
            b();
          }
        }
        else
        {
          return;
        }
        if (this.aU == 9366) {
          continue;
        }
        m = 1;
        continue;
        FMTSrvAddrProvider.a().a(16, this.l);
        continue;
        f(3);
      }
      finally {}
      label140:
      continue;
      label148:
      e();
    }
  }
  
  private void f(int paramInt)
  {
    boolean bool = true;
    String str = "DiscussPTTDirectUrl";
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {
        str = "GroupPTTDirectUrl";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
      if (paramInt == 0) {}
      for (;;)
      {
        localStatisticCollector.a(null, str, bool, 0L, 0L, localHashMap, null);
        return;
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.aU == 56009)
    {
      bool1 = bool2;
      if (this.bc != null) {
        if ((!this.bc.equals("T_203")) && (!this.bc.equals("H_400_-5103017")))
        {
          bool1 = bool2;
          if (!this.bc.equals("H_400_-5103039")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void s()
  {
    int n = 0;
    MessageForPtt localMessageForPtt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
    int m;
    if (localMessageForPtt.directUrl != null) {
      if (localMessageForPtt.directUrl.length() == 0) {
        m = 0;
      }
    }
    for (;;)
    {
      if (m == 0) {
        f(1);
      }
      label154:
      label160:
      while (n != 0)
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "directDownloadIfCan pttUrl: " + localMessageForPtt.directUrl);
        }
        Object localObject2 = FMTSrvAddrProvider.a().b();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = FMTSrvAddrProvider.a().a().a(0);
          if (localObject1 == null) {
            break label154;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          this.jdField_e_of_type_Boolean = bool;
          if (localObject1 != null) {
            break label160;
          }
          if (!QLog.isDevelopLevel()) {
            break label318;
          }
          QLog.e("SPD", 4, "directDownloadIfCan no ip error " + localMessageForPtt.directUrl);
          m = 1;
          break;
        }
        if (((String)localObject1).endsWith("/")) {}
        for (localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);; localObject2 = localObject1)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan ipStr: " + (String)localObject1);
          }
          localObject1 = (String)localObject2 + localMessageForPtt.directUrl;
          this.l = ((String)localObject1);
          if (QLog.isDevelopLevel()) {
            QLog.d("SPD", 4, "directDownloadIfCan for GroupPtt: " + (String)localObject1);
          }
          c((String)localObject1);
          this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
          ThreadManager.b().postDelayed(this, 30000L);
          n = 1;
          m = 1;
          break;
        }
      }
      f(2);
      return;
      label318:
      m = 1;
      continue;
      m = 0;
    }
  }
  
  public QQMessageFacade.Message a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag == -1L) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.extFlag = 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo.jdField_a_of_type_Int == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.a();
    d(2001);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {}
    for (int m = 3;; m = 2)
    {
      PttInfoCollector.a((QQAppInterface)localObject, m, false, 2);
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
        a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      }
      if (PttOptimizeParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        s();
      }
      if (this.l == null) {
        e();
      }
      return;
    }
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      paramNetReq = (HttpNetReq)paramNetReq;
      paramNetReq.jdField_a_of_type_Long += paramNetResp.jdField_c_of_type_Long;
    } while (0L != paramNetReq.jdField_b_of_type_Long);
    paramNetResp.jdField_c_of_type_Long = 0L;
    paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
    paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    Object localObject;
    FileMsg.StepTransInfo localStepTransInfo;
    boolean bool1;
    if (this.l != null)
    {
      localObject = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b;
      ThreadManager.b().removeCallbacks(this);
      if (paramNetResp.jdField_e_of_type_Int != 0) {
        break label199;
      }
      bool1 = true;
      label40:
      a((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramNetResp.jdField_e_of_type_Int != 0) {
        break label205;
      }
      bool1 = bool2;
      label73:
      a("onHttpResp", bool1);
      this.jdField_a_of_type_Long = paramNetResp.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = null;
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramNetResp.jdField_b_of_type_Long + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_Long);
      }
      localStepTransInfo.jdField_e_of_type_JavaLangString = ((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if (paramNetResp.jdField_e_of_type_Int != 0) {
        break label211;
      }
      c();
      if (this.l != null) {
        f(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      return;
      localObject = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a;
      break;
      label199:
      bool1 = false;
      break label40;
      label205:
      bool1 = false;
      break label73;
      label211:
      if (this.l != null)
      {
        d(false);
      }
      else
      {
        if ((paramNetResp.f == 9364) && (this.aW < 3))
        {
          a("[netChg]", "failed.but net change detect.so retry");
          this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
          this.aW += 1;
          q();
          e();
          return;
        }
        b();
      }
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int m = 0;
      while (m < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPttDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(m);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_j_of_type_Boolean = paramRichProtoReq.jdField_e_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_j_of_type_Boolean);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_e_of_type_JavaLangString = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          this.jdField_d_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          g();
          m += 1;
        }
        else
        {
          b();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aU))) {
      break label14;
    }
    label14:
    while ((this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int n = this.aX;
    label61:
    label85:
    long l1;
    Object localObject2;
    boolean bool;
    if (paramBoolean)
    {
      m = 2;
      this.aX = (m | n);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label399;
      }
      localObject1 = "actGrpPttDown";
      l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
      localObject2 = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(4);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(PttOptimizeParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_e_of_type_Boolean)));
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder().append("GroupPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.l == null) {
          break label406;
        }
        bool = true;
        label314:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label412;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    label399:
    label406:
    label412:
    do
    {
      p();
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt == null) {
        break;
      }
      PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBoolean, this.aU, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      return;
      m = 1;
      break label61;
      localObject1 = "actDisscusPttDown";
      break label85;
      bool = false;
      break label314;
      if (this.aU != 56009) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
      {
        localObject2 = RichMediaUtil.a(((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
        if (localObject2 != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reqIp", ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString);
        }
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while ((this.aU != 56009) || (this.bc == null));
    int m = 0;
    if (this.bc.equals("T_203"))
    {
      m = 1;
      label565:
      if (m == 0) {
        break label805;
      }
      if (this.jdField_k_of_type_Long > this.jdField_j_of_type_Long) {
        if (!this.jdField_d_of_type_Boolean) {
          break label807;
        }
      }
    }
    label805:
    label807:
    for (Object localObject1 = "actGroupPTTOutOfTime";; localObject1 = "actDiscussionPTTOutOfTime")
    {
      localObject2 = new HashMap();
      long l3 = System.currentTimeMillis() / 1000L;
      l1 = (this.jdField_k_of_type_Long - this.jdField_j_of_type_Long) / 86400L;
      long l2 = (l3 - this.jdField_j_of_type_Long) / 86400L;
      l3 = (l3 - this.jdField_k_of_type_Long) / 86400L;
      ((HashMap)localObject2).put("MsgOff", String.valueOf(l1));
      ((HashMap)localObject2).put("PttOff", String.valueOf(l3));
      ((HashMap)localObject2).put("OutOfTimeReason", String.valueOf(m));
      ((HashMap)localObject2).put("param_FailCode", String.valueOf(l2));
      StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, false, 0L, 0L, (HashMap)localObject2, null);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) {
        break;
      }
      localObject1 = (TransferRequest.PttDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B3", "0X80059B3", PttInfoCollector.a(((TransferRequest.PttDownExtraInfo)localObject1).jdField_a_of_type_Int, ((TransferRequest.PttDownExtraInfo)localObject1).jdField_b_of_type_Int), 0, "", "", "", "6.5.5");
      break;
      if (!this.bc.equals("H_400_-5103017")) {
        break label565;
      }
      m = 16;
      break label565;
      break;
    }
  }
  
  void b()
  {
    super.b();
    d(2005);
  }
  
  public int c()
  {
    int m = 0;
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.c(str)) || (str.startsWith("http://")))
    {
      a(9302, a(new Exception("uuid illegal " + str)));
      b();
      m = -1;
      return m;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PttDownExtraInfo = ((TransferRequest.PttDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject);
    this.jdField_j_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgTime;
    this.jdField_k_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime;
    int n = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h == null) || (!FileUtils.c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath.equals("")))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h = a("group", str, n);
        label233:
        this.jdField_i_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h + "~tmp");
      }
    }
    else {
      if (1 != this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int) {
        break label416;
      }
    }
    label416:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = bool;
      this.jdField_a_of_type_ArrayOfByte = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long;
      this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break;
      }
      a(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + "  uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString)));
      b();
      return -1;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fullLocalPath;
      break label233;
    }
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url = MessageForPtt.getMsgFilePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
    super.c();
    QQMessageFacade.Message localMessage = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if ((localMessage != null) && (localMessage.pttUrl != null) && (localMessage.pttUrl.equals(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString))) {
      localMessage.pttUrl = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    }
    d(2003);
  }
  
  void c(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.contains("voice_codec="))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      localObject = paramString + "&voice_codec=" + ((MessageForPtt)localObject).voiceType;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = ((String)localObject);
    localHttpNetReq.jdField_c_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localHttpNetReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_c_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
    localHttpNetReq.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localHttpNetReq.jdField_a_of_type_Long = 0L;
    localHttpNetReq.f = true;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    if (this.l != null)
    {
      localHttpNetReq.jdField_d_of_type_Long = 60000L;
      localHttpNetReq.k = 0;
    }
    localHttpNetReq.g = false;
    localHttpNetReq.jdField_c_of_type_Boolean = true;
    localObject = null;
    paramString = (String)localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramString = (String)localObject;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        paramString = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
      }
    }
    a("httpDown", "directMsgUrlDown:" + this.jdField_b_of_type_Boolean + " ipList:" + paramString + " uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long + " downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
    if (!e()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    r();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  void e()
  {
    d(2001);
    f();
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPttDownReq localGroupPttDownReq = new RichProto.RichProtoReq.GroupPttDownReq();
    localGroupPttDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localGroupPttDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localGroupPttDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localGroupPttDownReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localGroupPttDownReq.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    a("SendRequest", " SendRequest GrpFileKey:" + this.jdField_k_of_type_JavaLangString);
    localGroupPttDownReq.jdField_a_of_type_JavaLangString = this.jdField_k_of_type_JavaLangString;
    localGroupPttDownReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localGroupPttDownReq.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceType;
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "grp_ptt_dw";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localGroupPttDownReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  void g()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    String str;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.jdField_e_of_type_JavaLangString != null)) {
      str = this.jdField_e_of_type_JavaLangString;
    }
    for (;;)
    {
      FMTSrvAddrProvider.a().a().a(str, 0);
      str = "http://" + str;
      str = a(str + this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      c(str);
      return;
      ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      str = localServerAddr.jdField_a_of_type_JavaLangString;
      if (localServerAddr.jdField_b_of_type_Int != 80) {
        str = str + ":" + localServerAddr.jdField_b_of_type_Int;
      }
    }
  }
  
  protected void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (this.jdField_d_of_type_Boolean) {
        ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttGd", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttDd", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.l);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    }
    d(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\GroupPttDownloadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */