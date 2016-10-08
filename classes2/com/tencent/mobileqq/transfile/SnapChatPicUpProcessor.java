package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
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
import java.util.HashMap;
import java.util.List;
import vcj;

public class SnapChatPicUpProcessor
  extends BaseUploadProcessor
{
  private static final int aH = 1001;
  private static final int aI = 1002;
  public static final String d = "SnapChatPicUpProcessor";
  QQAppInterface a;
  public Transaction a;
  private String k;
  private long l;
  
  public SnapChatPicUpProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.g = paramTransferRequest.f;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
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
    localRichProtoReq.jdField_a_of_type_JavaLangString = "snap_pic_up";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPicUpReq);
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
  
  public void J_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SnapChatPicUpProcessor", 2, "SnapChatPicUpProcessor.sendFile()");
    }
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    vcj localvcj = new vcj(this, SystemClock.uptimeMillis());
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.k) {}
    for (int i = 1002;; i = 1001)
    {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_b_of_type_Long, PkgTools.a(this.k), this.jdField_a_of_type_ArrayOfByte, localvcj);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("SnapChatPicUpProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_i_of_type_JavaLangString + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 3);
      }
      if (i != 0)
      {
        a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
      }
      return;
    }
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SnapChatPicUpProcessor", 2, "SnapChatPicUpProcessor.resume()");
    }
    b();
    g();
    return 0;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.c, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("SnapChatPicUpProcessor", 2, "SnapChatPicUpProcessor.start()");
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      b();
      return;
    }
    g();
    d(1001);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, 23, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, 23, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, 23, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, 23, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
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
          QLog.d("SnapChatPicUpProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.jdField_c_of_type_Int);
        }
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          this.k = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.c = this.jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("SnapChatPicUpProcessor", 2, "onBusiProtoResp()---- sessionKey: " + this.k);
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k = ("http://" + paramRichProtoReq.jdField_b_of_type_JavaLangString + paramRichProtoReq.jdField_e_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.l = ("http://" + paramRichProtoReq.jdField_b_of_type_JavaLangString + paramRichProtoReq.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.m = ("http://" + paramRichProtoReq.jdField_b_of_type_JavaLangString + paramRichProtoReq.jdField_d_of_type_JavaLangString);
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
            c();
            if (QLog.isColorLevel()) {
              QLog.d("SnapChatPicUpProcessor", 2, "onBusiProtoResp()---- file is Exsit! " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString);
            }
            label319:
            this.jdField_l_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.d("SnapChatPicUpProcessor", 2, "mFileID->" + this.jdField_l_of_type_Long + " groupUin->" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.j = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.c = paramRichProtoReq.jdField_b_of_type_Int;
          this.jdField_b_of_type_Long = paramRichProtoReq.jdField_b_of_type_Long;
          J_();
          break label319;
          b();
        }
      }
    }
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
        break label157;
      }
      str = "null";
      label107:
      localHashMap.put("param_sessionKey", str);
      if (!paramBoolean) {
        break label165;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actSnapChatPicUpload", true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      p();
      return;
      i = 1;
      break;
      label157:
      str = this.k;
      break label107;
      label165:
      if (this.aU != 56009) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actSnapChatPicUpload", false, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public int b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
    return 0;
  }
  
  public void b()
  {
    super.b();
    d(1005);
    a(false);
    if (QLog.isColorLevel()) {
      QLog.d("SnapChatPicUpProcessor", 2, "onError()---- errCode: " + this.aU + ", errDesc:" + this.bc);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.aU;
      localSendResult.jdField_a_of_type_JavaLangString = this.bc;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public int c()
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
  
  public void c()
  {
    super.c();
    d(1003);
    if (QLog.isColorLevel()) {
      QLog.d("SnapChatPicUpProcessor", 2, "onSuccess().");
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SnapChatPicUpProcessor", 2, paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\SnapChatPicUpProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */