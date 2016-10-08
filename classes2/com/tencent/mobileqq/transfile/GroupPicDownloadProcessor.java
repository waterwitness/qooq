package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPicDownReq;
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

public class GroupPicDownloadProcessor
  extends BasePicDownloadProcessor
{
  byte[] c;
  long j;
  boolean q;
  
  public GroupPicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.q = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Long;
  }
  
  public void a()
  {
    super.a();
    t();
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
        this.jdField_j_of_type_Boolean = paramRichProtoReq.jdField_e_of_type_Boolean;
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
    String str;
    Object localObject;
    if (!paramBoolean)
    {
      str = "Q.richmedia." + RichMediaUtil.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int) + "." + RichMediaUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject).append("errCode:" + this.aU + "  ");
      ((StringBuilder)localObject).append("errDesc:" + this.bc);
      QLog.d(str, 1, ((StringBuilder)localObject).toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1030) || ((!paramBoolean) && (RichMediaStrategy.c(this.aU))) || (this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int k = this.aX;
    int i;
    label281:
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.aX = (i | k);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label860;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 65537) {
        break label853;
      }
      str = "actGroupPicSmallDownV1";
      l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
      localObject = this.jdField_d_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_DownMode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
      localObject = this.jdField_a_of_type_JavaUtilHashMap;
      long l2 = this.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo != null) {
        break label886;
      }
      i = 0;
      label472:
      ((HashMap)localObject).put("param_recvDataLen", String.valueOf(l2 - i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailCode", String.valueOf(this.aJ));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_directFailDesc", "" + this.k);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_inQueueCost", "" + this.jdField_i_of_type_Long);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromDns", "" + this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("ipFromSave", "" + this.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_encryptRollback", "" + this.h + ",decryptErrorMsg:" + this.l);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && (((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder != null))
      {
        localObject = (HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picDecryptTime", String.valueOf(((PicCryptor)((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq$IFlowDecoder).jdField_a_of_type_Long));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) {
        break label898;
      }
      i = 1;
      label753:
      if (i != 0)
      {
        i = -1;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_groupPolicy", String.valueOf(i));
      }
      localObject = new HashMap();
      ((HashMap)localObject).putAll(this.jdField_a_of_type_JavaUtilHashMap);
      if (!paramBoolean) {
        break label904;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, l1, this.jdField_a_of_type_Long, (HashMap)localObject, "");
    }
    for (;;)
    {
      p();
      return;
      i = 1;
      break;
      label853:
      str = "actGroupPicDownloadV1";
      break label281;
      label860:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 65537) {}
      for (str = "actDiscussPicSmallDown";; str = "actDiscussPicDown") {
        break;
      }
      label886:
      i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
      break label472;
      label898:
      i = 0;
      break label753;
      label904:
      if (this.aU != 56009) {
        ((HashMap)localObject).remove("param_rspHeader");
      }
      ((HashMap)localObject).put("param_FailCode", String.valueOf(this.aU));
      ((HashMap)localObject).put("param_errorDesc", this.bc);
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, false, l1, 0L, (HashMap)localObject, "");
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.m) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x2) != 0);
  }
  
  public int c()
  {
    int i = 0;
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
    if ((str1 == null) || (str1.equals("")) || (str1.equals("null")) || (FileUtils.c(str1)) || (str1.startsWith("http://")))
    {
      if ((str1 == null) || (!str1.startsWith("http://"))) {
        break label188;
      }
      String str2 = d(str1);
      if (str2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString = str2;
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream != null) || (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean)) {
        break label231;
      }
      a(9302, a(new Exception("no output stream")));
      b();
      i = -1;
      return i;
    }
    a(9302, a(new Exception("uuid illegal " + str1)));
    b();
    return -1;
    label188:
    a(9302, a(new Exception("uuid illegal " + str1)));
    b();
    return -1;
    label231:
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicDownExtraInfo)))
    {
      a(9302, a(new Exception("extra obj")));
      b();
      return -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo = ((TransferRequest.PicDownExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.q = bool;
      try
      {
        this.c = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
        this.jdField_j_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long;
        if (this.c != null) {
          break;
        }
        a(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString)));
        b();
        return -1;
      }
      catch (Exception localException)
      {
        a(9302, a(new Exception("convert md5 error,md5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + "  uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString)));
        b();
      }
    }
    return -1;
  }
  
  String d(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null) {
      localObject = paramString;
    }
    try
    {
      if (paramString.startsWith("/")) {
        localObject = paramString.substring(1);
      }
      if ((localObject != null) && (!((String)localObject).equals("null")) && (!((String)localObject).startsWith("http://"))) {}
      do
      {
        do
        {
          do
          {
            return null;
          } while ((localObject == null) || (((String)localObject).length() <= 0) || (!((String)localObject).contains("?")));
          i = ((String)localObject).indexOf("?");
        } while ((i < 0) || (i >= ((String)localObject).length() - 1));
        localObject = ((String)localObject).substring(i + 1).split("\\&");
      } while (localObject == null);
      paramString = null;
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].startsWith("pic=")) {
          paramString = localObject[i].substring(4);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = paramString;
      }
    }
    return paramString;
  }
  
  void e()
  {
    u();
  }
  
  void f()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    String str1;
    Object localObject;
    int i;
    String str2;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.jdField_e_of_type_JavaLangString != null))
    {
      str1 = "http://" + this.jdField_e_of_type_JavaLangString;
      str1 = a(a(str1 + this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g), this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      localObject = new HttpNetReq();
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = str1;
      ((HttpNetReq)localObject).jdField_c_of_type_Int = 0;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam = jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile.a();
      ((HttpNetReq)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Boolean) {
        ((HttpNetReq)localObject).jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaIoOutputStream;
      }
      ((HttpNetReq)localObject).jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      ((HttpNetReq)localObject).o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      ((HttpNetReq)localObject).n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      ((HttpNetReq)localObject).jdField_f_of_type_Boolean = true;
      ((HttpNetReq)localObject).jdField_a_of_type_Long = 0L;
      ((HttpNetReq)localObject).jdField_a_of_type_ArrayOfJavaLangString = new String[] { "image" };
      i = a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
      if (i == 4)
      {
        ((HttpNetReq)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
        ((HttpNetReq)localObject).jdField_b_of_type_Long = 0L;
        ((HttpNetReq)localObject).jdField_e_of_type_Boolean = false;
        str2 = "bytes=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + "-";
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Range", str2);
        label317:
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
        ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Referer", "http://im.qq.com/mobileqq");
        a((HttpNetReq)localObject, str1);
        ((HttpNetReq)localObject).g = false;
        ((HttpNetReq)localObject).jdField_c_of_type_Boolean = true;
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
        ((HttpNetReq)localObject).m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_Int;
        if (this.jdField_b_of_type_Boolean) {
          ((HttpNetReq)localObject).k = 0;
        }
        str1 = null;
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          str1 = Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray());
        }
        a("httpDown", "directMsgUrlDown:" + this.jdField_b_of_type_Boolean + " ipList:" + str1 + " uuid:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString + " FileID:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Long + " downOffset:" + ((HttpNetReq)localObject).jdField_a_of_type_Long + ",isEncryptUrl:" + this.g + ",isEncryptPic:" + this.jdField_f_of_type_Boolean + ",isEncryptRollbackReq:" + this.h);
        if (e()) {
          break label801;
        }
      }
    }
    else
    {
      localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      str1 = "http://" + ((ServerAddr)localObject).jdField_a_of_type_JavaLangString;
      if (((ServerAddr)localObject).jdField_b_of_type_Int == 80) {
        break label821;
      }
      str1 = str1 + ":" + ((ServerAddr)localObject).jdField_b_of_type_Int;
    }
    label801:
    label821:
    for (;;)
    {
      FMTSrvAddrProvider.a().a().a(str1, 2);
      break;
      if ((i == 3) || (i == 2))
      {
        ((HttpNetReq)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
        ((HttpNetReq)localObject).jdField_b_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.j - 1);
        ((HttpNetReq)localObject).jdField_e_of_type_Boolean = false;
        str2 = "bytes=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i + "-" + ((HttpNetReq)localObject).jdField_b_of_type_Long;
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Range", str2);
        break label317;
      }
      ((HttpNetReq)localObject).jdField_b_of_type_Long = 0L;
      ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + ((HttpNetReq)localObject).jdField_a_of_type_Long + "-");
      break label317;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
      r();
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
      return;
    }
  }
  
  protected void r()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      if (!this.q) {
        break label72;
      }
      if (i == 2) {
        ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttGd");
      }
    }
    else
    {
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "picGd");
    return;
    label72:
    if (i == 2)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttDd");
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "picDd");
  }
  
  void s()
  {
    this.jdField_a_of_type_JavaUtilArrayList = FMTSrvAddrProvider.a().b(2);
  }
  
  void t()
  {
    int i = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$PicDownExtraInfo.jdField_a_of_type_JavaLangString;
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
      localObject1 = InnerDns.a().a("gchat.qpic.cn", 1000);
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
        localObject2 = FMTSrvAddrProvider.a().a().a(2);
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
  
  void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    this.jdField_b_of_type_Boolean = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPicDownReq localGroupPicDownReq = new RichProto.RichProtoReq.GroupPicDownReq();
    localGroupPicDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localGroupPicDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localGroupPicDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localGroupPicDownReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localGroupPicDownReq.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localGroupPicDownReq.jdField_a_of_type_Long = this.jdField_j_of_type_Long;
    localGroupPicDownReq.jdField_a_of_type_ArrayOfByte = this.c;
    localGroupPicDownReq.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Long);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "grp_pic_dw";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localGroupPicDownReq);
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
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\GroupPicDownloadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */