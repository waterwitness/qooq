package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.BDHCommonUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamExtendInfo;
import uzy;

public class BDHCommonUploadProcessor
  extends BaseUploadProcessor
{
  public static final int aH = 7;
  public static final int aI = 9;
  public static final int aJ = 10;
  public static final int aK = 18;
  public static final int aL = 20;
  public static final String d = "BDHCommonUploadProcessor";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Bdh_extinfo.UploadPicExtInfo jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo;
  Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private cmd0x388.ExpRoamExtendInfo jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo;
  private byte[] b;
  private int bn;
  private String k;
  private long jdField_l_of_type_Long;
  private String jdField_l_of_type_JavaLangString;
  
  public BDHCommonUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo = new cmd0x388.ExpRoamExtendInfo();
    this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.bn = paramTransferRequest.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = paramTransferRequest.jdField_c_of_type_Int;
    this.jdField_l_of_type_JavaLangString = paramTransferRequest.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_ArrayOfByte = paramTransferRequest.jdField_a_of_type_ArrayOfByte;
  }
  
  private final void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = a();
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
    } while ((!e()) || (localRichProtoReq == null));
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public final void J_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHNormalUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    uzy localuzy = new uzy(this, SystemClock.uptimeMillis());
    if (this.bn == 9) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.bn, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_b_of_type_Long, PkgTools.a(this.k), this.jdField_a_of_type_ArrayOfByte, localuzy, this.jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo.toByteArray());
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_i_of_type_JavaLangString + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 3);
      }
      if (i != 0)
      {
        a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
      }
      return;
      if (this.bn == 20) {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.bn, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_b_of_type_Long, PkgTools.a(this.k), this.jdField_a_of_type_ArrayOfByte, localuzy, this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo.toByteArray());
      } else {
        this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.bn, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_b_of_type_Long, PkgTools.a(this.k), this.jdField_a_of_type_ArrayOfByte, localuzy);
      }
    }
  }
  
  public final int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.resume()");
    }
    b();
    g();
    return 0;
  }
  
  protected final long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.c, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected RichProto.RichProtoReq a()
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.jdField_a_of_type_JavaLangString = this.f;
    localPicUpReq.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localPicUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localPicUpReq.jdField_c_of_type_Int = this.aM;
    localPicUpReq.jdField_d_of_type_Int = this.aN;
    localPicUpReq.jdField_b_of_type_Boolean = this.jdField_l_of_type_Boolean;
    localPicUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localPicUpReq.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.k;
    localPicUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "bdh_common_up";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPicUpReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localRichProtoReq.jdField_a_of_type_Int = this.bn;
    localRichProtoReq.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    return localRichProtoReq;
  }
  
  public final void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "BDHCommonUploadProcessor.start()");
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      b();
      return;
    }
    if (18 == this.bn)
    {
      this.k = "null";
      J_();
    }
    for (;;)
    {
      d(1001);
      return;
      g();
    }
  }
  
  protected final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  public final void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
  }
  
  public final void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.BDHCommonUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.jdField_c_of_type_Int);
        }
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.k = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.c = this.jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- sessionKey: " + this.k);
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.n = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.o = paramRichProtoReq.jdField_e_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.p = paramRichProtoReq.jdField_c_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.q = paramRichProtoReq.jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k = ("http://" + paramRichProtoReq.jdField_b_of_type_JavaLangString + paramRichProtoReq.jdField_e_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_l_of_type_JavaLangString = ("http://" + paramRichProtoReq.jdField_b_of_type_JavaLangString + paramRichProtoReq.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.m = ("http://" + paramRichProtoReq.jdField_b_of_type_JavaLangString + paramRichProtoReq.jdField_d_of_type_JavaLangString);
          if (this.bn == 9)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_i_of_type_JavaLangString = paramRichProtoReq.f;
            label327:
            if (!paramRichProtoReq.jdField_a_of_type_Boolean) {
              break label483;
            }
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
            c();
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString);
            }
            label383:
            this.jdField_l_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = this.jdField_l_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.d("BDHCommonUploadProcessor", 2, "mFileID->" + this.jdField_l_of_type_Long + " groupUin->" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.bn != 20) {
            break label327;
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_i_of_type_JavaLangString = paramRichProtoReq.f;
          break label327;
          label483:
          if ((this.bn == 9) && (paramRichProtoReq.f != null)) {
            this.jdField_a_of_type_TencentImCsCmd0x388Cmd0x388$ExpRoamExtendInfo.bytes_resid.set(ByteStringMicro.copyFrom(paramRichProtoReq.f.getBytes()));
          }
          if ((this.bn == 20) && (paramRichProtoReq.f != null)) {
            this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$UploadPicExtInfo.bytes_file_resid.set(ByteStringMicro.copyFrom(paramRichProtoReq.f.getBytes()));
          }
          this.j = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.c = paramRichProtoReq.jdField_b_of_type_Int;
          this.jdField_b_of_type_Long = paramRichProtoReq.jdField_b_of_type_Long;
          J_();
          break label383;
          b();
        }
      }
    }
  }
  
  public final void a(HashMap paramHashMap)
  {
    long l1 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l2 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    String str6 = (String)paramHashMap.get("param_conf_connNum");
    paramHashMap = (String)paramHashMap.get("param_fin_lost");
    if (str1 != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    }
    if (paramHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", paramHashMap);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str6);
    a(l1, l2, l3, l4);
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aU))) {}
    while ((this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int j = this.aX;
    int i;
    long l1;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.aX = (i | j);
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      l1 = (System.nanoTime() - this.d) / 1000000L;
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.k != null) {
        break label158;
      }
      str = "null";
      label107:
      localHashMap.put("param_sessionKey", str);
      if (!paramBoolean) {
        break label166;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, this.jdField_l_of_type_JavaLangString, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      p();
      return;
      i = 1;
      break;
      label158:
      str = this.k;
      break label107;
      label166:
      if (this.aU != 56009) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      StatisticCollector.a(BaseApplication.getContext()).a(null, this.jdField_l_of_type_JavaLangString, false, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte.length > 0)
    {
      int j = ByteBuffer.wrap(paramArrayOfByte).get();
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("BDHCommonUploadProcessor", 2, "ret > 0" + j);
        i = j;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "parseRespData(), business result code = " + i);
    }
    if (i == 0)
    {
      c();
      return;
    }
    d(1005);
  }
  
  public final int b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
    return 0;
  }
  
  public final void b()
  {
    super.b();
    d(1005);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "onError()---- errCode: " + this.aU + ", errDesc:" + this.bc);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.aU;
      localSendResult.jdField_a_of_type_JavaLangString = this.bc;
      if ((this.bn == 20) && (BaseTransProcessor.a(120509L).equals(this.jdField_a_of_type_JavaUtilHashMap.get("param_reason")))) {
        localSendResult.jdField_b_of_type_Int = 120509;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public final int c()
  {
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      this.aN = ((BitmapFactory.Options)localObject).outHeight;
      this.aM = ((BitmapFactory.Options)localObject).outWidth;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      a(9302, a(new Exception("filePath null")));
      b();
      return -1;
    }
    File localFile = new File((String)localObject);
    if (!localFile.exists())
    {
      a(9042, a(new Exception("sendFile not exist " + (String)localObject)));
      b();
      return -1;
    }
    if (!localFile.canRead())
    {
      a(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString)));
      b();
      return -1;
    }
    long l1 = localFile.length();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l1;
    this.jdField_a_of_type_Long = l1;
    if (l1 <= 0L)
    {
      a(9071, a(new Exception("file size 0 " + (String)localObject)));
      b();
      return -1;
    }
    localObject = FileUtils.a((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.g = ((String)localObject);
    }
    if (l1 >= 19922944L)
    {
      a(9063, (String)localObject, c((String)localObject), null);
      b();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo))) {
      this.jdField_l_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  public final void c()
  {
    super.c();
    d(1003);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "onSuccess().");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      if (this.bn == 20) {
        localSendResult.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_i_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\BDHCommonUploadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */