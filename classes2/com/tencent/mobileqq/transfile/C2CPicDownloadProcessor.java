package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPicDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.PicDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class C2CPicDownloadProcessor
  extends BasePicDownloadProcessor
{
  public C2CPicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Long;
  }
  
  public void a()
  {
    super.a();
    try
    {
      t();
      return;
    }
    catch (Exception localException)
    {
      a("reportFailed", ChatImageDownloader.a(localException));
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.PicDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        this.j = paramRichProtoReq.jdField_e_of_type_Boolean;
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_e_of_type_JavaLangString = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          this.jdField_d_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          f();
          i += 1;
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
    Object localObject;
    if (!paramBoolean)
    {
      localObject = "Q.richmedia." + RichMediaUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int) + "." + RichMediaUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + "  ");
      localStringBuilder.append("errCode:" + this.aU + "  ");
      localStringBuilder.append("errDesc:" + this.bc);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (RichMediaStrategy.c(this.aU))) || (this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int j = this.aX;
    int i;
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.aX = (i | j);
      l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
      localObject = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.j));
      localObject = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo != null) {
        break label757;
      }
      i = 0;
      label446:
      ((HashMap)localObject).put("param_recvDataLen", String.valueOf(l2 - i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailCode", String.valueOf(this.aJ));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailDesc", "" + this.k);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_inQueueCost", "" + this.jdField_i_of_type_Long);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromDns", "" + this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromSave", "" + this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encryptRollback", "" + this.jdField_h_of_type_Boolean + ",decryptErrorMsg:" + this.l);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && (((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder != null))
      {
        localObject = (HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder).jdField_a_of_type_Long));
      }
      if (!paramBoolean) {
        break label769;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, b(), true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      p();
      return;
      i = 1;
      break;
      label757:
      i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
      break label446;
      label769:
      if (this.aU != 56009) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
      StatisticCollector.a(BaseApplication.getContext()).a(null, b(), false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  public int c()
  {
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.c(str)) || (str.startsWith("http")))
    {
      a(9302, a(new Exception("uuid illegal " + str)));
      b();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream == null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean))
    {
      a(9302, a(new Exception("no output stream")));
      b();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicDownExtraInfo)))
    {
      a(9302, a(new Exception("extra obj")));
      b();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
    return 0;
  }
  
  void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    this.jdField_b_of_type_Boolean = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.C2CPicDownReq localC2CPicDownReq = new RichProto.RichProtoReq.C2CPicDownReq();
    localC2CPicDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localC2CPicDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localC2CPicDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localC2CPicDownReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localC2CPicDownReq.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
    localC2CPicDownReq.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Long);
    MessageRecord localMessageRecord2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.jdField_h_of_type_JavaLangString = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localC2CPicDownReq.jdField_b_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localC2CPicDownReq.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1006) {
        break label296;
      }
      bool = true;
      label207:
      localC2CPicDownReq.jdField_a_of_type_Boolean = bool;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_pic_dw";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localC2CPicDownReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break label302;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
    }
    label296:
    label302:
    do
    {
      return;
      this.jdField_h_of_type_JavaLangString = "picplatform";
      a("findDbRec", "not found");
      break;
      bool = false;
      break label207;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  void f()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    if (this.o) {
      return;
    }
    Object localObject1;
    if (((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) && (this.jdField_e_of_type_JavaLangString != null)) {
      localObject1 = "http://" + this.jdField_e_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject1 = a(a((String)localObject1 + this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g), this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localHttpNetReq.jdField_c_of_type_Int = 0;
      localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localHttpNetReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_h_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean) {
        localHttpNetReq.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream;
      }
      localHttpNetReq.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      localHttpNetReq.o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      localHttpNetReq.jdField_a_of_type_Long = 0L;
      localHttpNetReq.jdField_f_of_type_Boolean = true;
      int i = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
      Object localObject2;
      if (i == 4)
      {
        localHttpNetReq.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
        localHttpNetReq.jdField_b_of_type_Long = 0L;
        localHttpNetReq.jdField_e_of_type_Boolean = false;
        localObject2 = "bytes=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + "-";
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject2);
        label308:
        a(localHttpNetReq, (String)localObject1);
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCd");
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
        localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Int;
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam = jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile.a();
        localHttpNetReq.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
        localHttpNetReq.g = false;
        localHttpNetReq.jdField_c_of_type_Boolean = true;
        if (this.jdField_b_of_type_Boolean) {
          localHttpNetReq.jdField_d_of_type_Long = 0L;
        }
        localObject2 = null;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            localObject1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
          }
        }
        a("httpDown", "directMsgUrlDown:" + this.jdField_b_of_type_Boolean + " ipList:" + (String)localObject1 + " uniSeq:" + localHttpNetReq.jdField_d_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString + ",downOffset:" + localHttpNetReq.jdField_a_of_type_Long + ",isEncryptUrl:" + this.g + ",isEncryptPic:" + this.jdField_f_of_type_Boolean + ",isEncryptRollbackReq:" + this.jdField_h_of_type_Boolean);
        if (!e()) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
        return;
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label859;
        }
        localObject2 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localObject1 = "http://" + ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString;
        if (((ServerAddr)localObject2).jdField_b_of_type_Int == 80) {
          break label856;
        }
        localObject1 = (String)localObject1 + ":" + ((ServerAddr)localObject2).jdField_b_of_type_Int;
      }
      label856:
      for (;;)
      {
        FMTSrvAddrProvider.a().a().a((String)localObject1, 1);
        break;
        if ((i == 3) || (i == 2))
        {
          localHttpNetReq.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
          localHttpNetReq.jdField_b_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.j - 1);
          localHttpNetReq.jdField_e_of_type_Boolean = false;
          localObject2 = "bytes=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + "-" + localHttpNetReq.jdField_b_of_type_Long;
          localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", localObject2);
          break label308;
        }
        localHttpNetReq.jdField_b_of_type_Long = 0L;
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-");
        break label308;
      }
      label859:
      localObject1 = "http://";
    }
  }
  
  void s()
  {
    this.jdField_a_of_type_JavaUtilArrayList = FMTSrvAddrProvider.a().b(11);
  }
  
  void t()
  {
    int i = 0;
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    Object localObject1;
    if ((this.jdField_d_of_type_JavaLangString != null) && (!this.jdField_d_of_type_JavaLangString.equals("")))
    {
      s();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
        f();
        return;
      }
      localObject1 = InnerDns.a().a("c2cpicdw.qpic.cn", 1004);
      if (!StringUtil.b((String)localObject1))
      {
        this.jdField_d_of_type_Boolean = true;
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        Object localObject2 = new ServerAddr();
        ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        this.jdField_b_of_type_Boolean = true;
        this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
        f();
        return;
        localObject2 = FMTSrvAddrProvider.a().a().a(1);
        if (QLog.isColorLevel()) {
          QLog.d(PttIpSaver.jdField_a_of_type_JavaLangString, 2, "get PIC_C2C_IP:" + (String)localObject2);
        }
        localObject1 = localObject2;
        if (StringUtil.b((String)localObject2)) {
          continue;
        }
        this.jdField_e_of_type_Boolean = true;
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("http://")) {
          localObject1 = ((String)localObject2).substring("http://".length(), ((String)localObject2).length());
        }
        if (((String)localObject1).endsWith("/"))
        {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          i = 1;
        }
      }
      else
      {
        for (this.aJ = 2;; this.aJ = 1)
        {
          e();
          return;
        }
      }
      i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\C2CPicDownloadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */