package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.longconn.longmsg.LongMsg.MsgUpReq;
import tencent.im.longconn.longmsg.LongMsg.ReqBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;
import vbd;

public class MultiMsgUpProcessor
  extends BaseUploadProcessor
{
  private static int aJ = 0;
  private static final String jdField_d_of_type_JavaLangString = "MultiMsgUpProcessor";
  public int aH;
  private int aI;
  private SSCM jdField_b_of_type_ComTencentWsttSSCMSSCM;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private byte[] e;
  private boolean jdField_f_of_type_Boolean;
  private byte[] jdField_f_of_type_ArrayOfByte;
  private byte[] g;
  private long l;
  private long m;
  
  public MultiMsgUpProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.m = -1L;
    this.jdField_b_of_type_ComTencentWsttSSCMSSCM = new SSCM();
    this.aI = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    this.jdField_b_of_type_ArrayOfByte = paramTransferRequest.jdField_b_of_type_ArrayOfByte;
    this.aH = paramTransferRequest.h;
    if (this.jdField_b_of_type_ArrayOfByte != null) {}
    for (this.jdField_a_of_type_Long = paramTransferRequest.jdField_b_of_type_ArrayOfByte.length;; this.jdField_a_of_type_Long = 0L) {
      try
      {
        this.l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
        return;
      }
      catch (Exception paramTransFileController)
      {
        paramTransFileController.printStackTrace();
        this.l = 0L;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq.MultiMsgUpReq localMultiMsgUpReq = new RichProto.RichProtoReq.MultiMsgUpReq();
    localMultiMsgUpReq.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localMultiMsgUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localMultiMsgUpReq.jdField_a_of_type_Int = this.aH;
    localMultiMsgUpReq.c = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localMultiMsgUpReq.d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c;
    localMultiMsgUpReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
    localMultiMsgUpReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "multi_msg_up";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localMultiMsgUpReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
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
  
  private static int h()
  {
    int i = aJ;
    aJ = i + 1;
    return i;
  }
  
  private boolean h()
  {
    Object localObject1 = new LongMsg.MsgUpReq();
    ((LongMsg.MsgUpReq)localObject1).setHasFlag(true);
    ((LongMsg.MsgUpReq)localObject1).uint64_dst_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c).longValue());
    ((LongMsg.MsgUpReq)localObject1).bytes_msg_content.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
    ((LongMsg.MsgUpReq)localObject1).bytes_msg_ukey.set(ByteStringMicro.copyFrom(this.jdField_e_of_type_ArrayOfByte));
    ((LongMsg.MsgUpReq)localObject1).uint32_store_type.set(2);
    Object localObject2 = new LongMsg.ReqBody();
    ((LongMsg.ReqBody)localObject2).setHasFlag(true);
    ((LongMsg.ReqBody)localObject2).uint32_subcmd.set(1);
    ((LongMsg.ReqBody)localObject2).uint32_term_type.set(5);
    ((LongMsg.ReqBody)localObject2).uint32_platform_type.set(9);
    ((LongMsg.ReqBody)localObject2).rpt_msg_up_req.add((MessageMicro)localObject1);
    byte[] arrayOfByte = new Cryptor().encrypt(((LongMsg.ReqBody)localObject2).toByteArray(), this.jdField_f_of_type_ArrayOfByte);
    Object localObject3 = new im_msg_head.LoginSig();
    ((im_msg_head.LoginSig)localObject3).uint32_type.set(22);
    ((im_msg_head.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(this.jdField_g_of_type_ArrayOfByte));
    localObject1 = new String();
    int i = 0;
    while (i < "6.5.5".length())
    {
      localObject2 = localObject1;
      if ("6.5.5".charAt(i) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("6.5.5".charAt(i)));
      }
      i += 1;
      localObject1 = localObject2;
    }
    localObject2 = new im_msg_head.HttpConnHead();
    ((im_msg_head.HttpConnHead)localObject2).uint64_uin.set(this.l);
    ((im_msg_head.HttpConnHead)localObject2).uint32_command.set(1791);
    ((im_msg_head.HttpConnHead)localObject2).uint32_sub_command.set(1291);
    ((im_msg_head.HttpConnHead)localObject2).uint32_seq.set(h());
    ((im_msg_head.HttpConnHead)localObject2).uint32_version.set(Integer.parseInt((String)localObject1));
    ((im_msg_head.HttpConnHead)localObject2).uint32_flag.set(1);
    ((im_msg_head.HttpConnHead)localObject2).uint32_compress_type.set(0);
    ((im_msg_head.HttpConnHead)localObject2).uint32_error_code.set(0);
    localObject1 = new im_msg_head.Head();
    ((im_msg_head.Head)localObject1).uint32_head_type.set(4);
    ((im_msg_head.Head)localObject1).msg_login_sig.set((MessageMicro)localObject3);
    ((im_msg_head.Head)localObject1).msg_httpconn_head.set((MessageMicro)localObject2);
    localObject1 = ((im_msg_head.Head)localObject1).toByteArray();
    localObject2 = new ByteArrayOutputStream();
    try
    {
      localObject3 = new DataOutputStream((OutputStream)localObject2);
      ((DataOutputStream)localObject3).write(40);
      ((DataOutputStream)localObject3).writeInt(localObject1.length);
      ((DataOutputStream)localObject3).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject3).write((byte[])localObject1);
      ((DataOutputStream)localObject3).write(arrayOfByte);
      ((DataOutputStream)localObject3).write(41);
      ((DataOutputStream)localObject3).flush();
      this.jdField_c_of_type_ArrayOfByte = ((ByteArrayOutputStream)localObject2).toByteArray();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsgUpProcessor", 2, localException.getMessage());
      }
      a(9360, "constructToSendData() dos.write()");
    }
    return false;
  }
  
  public void J_()
  {
    if (this.m == -1L) {
      this.m = SystemClock.uptimeMillis();
    }
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    long l1 = this.jdField_c_of_type_Long;
    long l2 = a(l1);
    Object localObject = a((int)l1, (int)l2);
    if (localObject == null) {
      b();
    }
    do
    {
      return;
      a("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.jdField_a_of_type_Long) {
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
    r();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
  }
  
  public int a()
  {
    if (this.k)
    {
      this.k = false;
      this.o = false;
      d(1002);
      this.bg = 0;
      this.bf = 0;
      this.jdField_e_of_type_ArrayOfByte = null;
      this.be = 0;
      this.jdField_c_of_type_Long = 0L;
      this.aU = 0;
      this.bc = "";
      this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new vbd(this));
    }
    return 0;
  }
  
  protected long a(long paramLong)
  {
    return this.jdField_c_of_type_ArrayOfByte.length;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.b != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(localServerAddr.b);
    }
    paramArrayOfByte.append("/cgi-bin/httpconn");
    return paramArrayOfByte.toString();
  }
  
  public void a()
  {
    super.a();
    d(1000);
    d(1001);
    if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length == 0))
    {
      a(9042, "data is empty");
      b();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      b();
      return;
    }
    g();
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.o) || (this.k)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    a("onResp", "result:" + paramNetResp.jdField_e_of_type_Int + " errCode:" + paramNetResp.f + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
    try
    {
      if (paramNetResp.jdField_e_of_type_Int == 0)
      {
        this.aW = 0;
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
        long l1 = SystemClock.uptimeMillis();
        long l2 = this.m;
        a("onResp", "Success. SendTotalCost:" + (l1 - l2) + "ms" + " ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
        c();
        return;
      }
    }
    catch (Exception paramNetResp)
    {
      a(9343, AbstractImageDownloader.a(new Exception("decode unknown exception")), "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    a(paramNetResp.f, paramNetResp.jdField_a_of_type_JavaLangString);
    b();
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if ((paramRichProtoResp == null) || (paramRichProtoResp.jdField_a_of_type_JavaUtilList == null) || (paramRichProtoResp.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      a(9006, "resp == null || resp.resps == null || resp.resps.size() == 0");
      b();
    }
    for (;;)
    {
      return;
      paramRichProtoReq = paramRichProtoResp.jdField_a_of_type_JavaUtilList.iterator();
      while (paramRichProtoReq.hasNext())
      {
        paramRichProtoResp = (RichProto.RichProtoResp.RespCommon)paramRichProtoReq.next();
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoResp.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoResp);
        paramRichProtoResp = (RichProto.RichProtoResp.MultiMsgUpResp)paramRichProtoResp;
        if (paramRichProtoResp.jdField_c_of_type_Int != 0) {
          break label171;
        }
        this.jdField_d_of_type_ArrayOfByte = paramRichProtoResp.jdField_a_of_type_ArrayOfByte;
        this.jdField_e_of_type_ArrayOfByte = paramRichProtoResp.jdField_b_of_type_ArrayOfByte;
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoResp.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_f_of_type_ArrayOfByte = paramRichProtoResp.jdField_c_of_type_ArrayOfByte;
        this.jdField_g_of_type_ArrayOfByte = paramRichProtoResp.jdField_d_of_type_ArrayOfByte;
        if (h()) {
          J_();
        } else {
          b();
        }
      }
    }
    label171:
    a(9007, "upResp.result=" + paramRichProtoResp.jdField_c_of_type_Int);
    b();
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = 2;
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsgUpProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1030) {}
    while (((!paramBoolean) && (RichMediaStrategy.c(this.aU))) || (this.i) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int j = this.aX;
    long l1;
    if (paramBoolean)
    {
      this.aX = (i | j);
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c);
      if (!paramBoolean) {
        break label425;
      }
      if ((this.jdField_g_of_type_Long <= 0L) || (this.h <= 0L)) {
        break label420;
      }
      i = 1;
      label244:
      if ((this.p) && (i != 0))
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.bd).append("_").append("tr").append(this.jdField_g_of_type_Long).append("_").append("ht").append(this.jdField_f_of_type_Long).append("_").append("pic").append(this.h).append(";");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
        this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.bd));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actMultiMsgUpload", true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      p();
      return;
      i = 1;
      break;
      label420:
      i = 0;
      break label244;
      label425:
      if (this.aU != 56009) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actMultiMsgUpload", false, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    return this.jdField_c_of_type_ArrayOfByte;
  }
  
  public void b()
  {
    super.b();
    d(1005);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.b = this.aU;
      localSendResult.jdField_a_of_type_JavaLangString = this.bc;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public int c()
  {
    super.c();
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    if ((this.jdField_b_of_type_ArrayOfByte == null) || (0L >= this.jdField_a_of_type_Long) || (0L == this.l)) {
      return -1;
    }
    this.jdField_g_of_type_JavaLangString = "";
    return 0;
  }
  
  public void c()
  {
    super.c();
    UpCallBack.SendResult localSendResult;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localSendResult = new UpCallBack.SendResult();
      localSendResult.b = 0;
      localSendResult.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    }
    try
    {
      localSendResult.c = new String(this.jdField_d_of_type_ArrayOfByte, "UTF-8");
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      d(1003);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localSendResult.b = -1;
        localSendResult.jdField_a_of_type_JavaLangString = ("Failed. Convert ResID to UTF-8 string failed, resID = " + this.jdField_d_of_type_ArrayOfByte.toString());
        a("onSuccess", localSendResult.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public boolean f()
  {
    this.jdField_a_of_type_ArrayOfByte = MD5.toMD5Byte(this.jdField_b_of_type_ArrayOfByte);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      a(9041, "getMd5 error");
      return false;
    }
    this.jdField_f_of_type_JavaLangString = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    this.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.h = this.jdField_f_of_type_JavaLangString;
    this.jdField_f_of_type_JavaLangString = (this.jdField_f_of_type_JavaLangString + "." + this.jdField_g_of_type_JavaLangString);
    return true;
  }
  
  protected void r()
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (!MsgProxyUtils.c(this.aI)) {
        break label56;
      }
      str = "multimsgCu";
    }
    for (;;)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
      label56:
      if (this.aI == 1) {
        str = "multimsgGu";
      } else {
        str = "multimsgDu";
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\MultiMsgUpProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */