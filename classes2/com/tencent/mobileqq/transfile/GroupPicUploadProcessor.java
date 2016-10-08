package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.ptt.PttSSCMPool;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ReqCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeParams.IOnCompressFinish;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import vaw;
import vax;
import vba;
import vbb;

public class GroupPicUploadProcessor
  extends BaseUploadProcessor
  implements INetEventHandler, VoiceChangeParams.IOnCompressFinish
{
  public static final String d = "GroupPicUploadProcessor";
  public static final boolean q = true;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  boolean f;
  boolean g;
  boolean h;
  String k;
  long l;
  private long m;
  private long n;
  private long o;
  private boolean r;
  private boolean s;
  private boolean t;
  
  public GroupPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.h = false;
    this.jdField_o_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vbb(this);
    if (!this.h) {
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM = PttSSCMPool.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int j = arrayOfByte[2];
      int i1 = arrayOfByte[1];
      int i2 = arrayOfByte[0];
      return i2 << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | i1 << 16 & 0xFF0000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/cgi-bin/httpconn?htcmd=0x6ff0071&ver=5468&term=android&ukey=");
    paramStringBuilder.append(this.jdField_j_of_type_JavaLangString);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_a_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.jdField_c_of_type_Long);
    paramStringBuilder.append("&uin=");
    paramStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
    paramStringBuilder.append("&groupcode=");
    paramStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c);
  }
  
  private byte[] a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = new ptt_reserve.ReserveStruct();
    ((ptt_reserve.ReserveStruct)localObject).uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
    localObject = ((ptt_reserve.ReserveStruct)localObject).toByteArray();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("change flag is ");
      if (paramMessageForPtt != null) {
        break label67;
      }
    }
    label67:
    for (int i = -1;; i = paramMessageForPtt.voiceChangeFlag)
    {
      QLog.d("pttchangevoice", 2, i);
      return (byte[])localObject;
    }
  }
  
  private void b(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/?ver=4679&ukey=");
    paramStringBuilder.append(this.jdField_j_of_type_JavaLangString);
    paramStringBuilder.append("&filekey=");
    paramStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_a_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.jdField_c_of_type_Long);
    paramStringBuilder.append("&bmd5=");
    paramStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    paramStringBuilder.append("&mType=");
    if (this.jdField_g_of_type_Boolean)
    {
      paramStringBuilder.append("pttGu");
      return;
    }
    paramStringBuilder.append("pttDu");
  }
  
  private void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    d(1001);
    Object localObject1 = a();
    if ((localObject1 != null) && (((TransferRequest)localObject1).h))
    {
      this.aM = ((TransferRequest)localObject1).jdField_l_of_type_Int;
      this.aN = ((TransferRequest)localObject1).m;
      this.jdField_a_of_type_Long = ((TransferRequest)localObject1).jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = HexUtil.a(((TransferRequest)localObject1).jdField_f_of_type_JavaLangString);
      this.jdField_f_of_type_JavaLangString = ((TransferRequest)localObject1).jdField_f_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.h = this.jdField_f_of_type_JavaLangString;
      this.jdField_f_of_type_JavaLangString = (this.jdField_f_of_type_JavaLangString + "." + this.jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().preConnect();
      g();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      b();
      return;
    }
    Object localObject2;
    if ((this.h) && ((this.aN == 0) || (this.aM == 0)))
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
      this.aN = ((BitmapFactory.Options)localObject1).outHeight;
      this.aM = ((BitmapFactory.Options)localObject1).outWidth;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
      if ((localObject2 != null) && ((localObject2 instanceof TransferRequest.PicUpExtraInfo)) && (((TransferRequest.PicUpExtraInfo)localObject2).jdField_a_of_type_Boolean) && (RichMediaUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)))
      {
        this.aN = ((BitmapFactory.Options)localObject1).outWidth;
        this.aM = ((BitmapFactory.Options)localObject1).outHeight;
        if (QLog.isColorLevel()) {
          a("doStart", "raw pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject1).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject1).outHeight + ",mWidth = " + this.aM + ",mHeight = " + this.aN);
        }
      }
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          a(9303, "read file error");
          b();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    MessageForPtt localMessageForPtt;
    int i;
    if (!this.h)
    {
      localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
      if (localMessageForPtt != null) {
        break label505;
      }
      i = 0;
      if (localMessageForPtt != null) {
        break label514;
      }
    }
    label505:
    label514:
    for (long l1 = 0L;; l1 = localMessageForPtt.fileSize)
    {
      PttInfoCollector.a((String)localObject2, false, false, i, l1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().preConnect();
      g();
      return;
      i = localMessageForPtt.voiceChangeFlag;
      break;
    }
  }
  
  private int h()
  {
    boolean bool = true;
    int j = 0;
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    int i;
    switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_g_of_type_Boolean = false;
      if (2 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int) {
        bool = false;
      }
      this.h = bool;
      if ((!this.h) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null))
      {
        a(9302, a(new Exception("message null")));
        b();
        i = -1;
      }
      break;
    }
    label194:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            this.jdField_g_of_type_Boolean = true;
            break;
            localObject = a();
            if ((localObject == null) || (!((TransferRequest)localObject).h)) {
              break label194;
            }
            i = j;
          } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null);
          i = j;
        } while (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo));
        this.jdField_l_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
        return 0;
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
        if (this.h)
        {
          localObject = FileUtils.a((String)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if ((((String)localObject).contains(FileUtils.jdField_i_of_type_JavaLangString)) || (!FileUtils.f((String)localObject)))
            {
              a(9072, (String)localObject, c((String)localObject), null);
              b();
              new Handler(Looper.getMainLooper()).post(new vaw(this));
              return -1;
            }
            this.jdField_g_of_type_JavaLangString = ((String)localObject);
          }
          if (l1 >= 19922944L)
          {
            a(9063, (String)localObject, c((String)localObject), null);
            b();
            return -1;
          }
        }
        else
        {
          this.jdField_g_of_type_JavaLangString = "amr";
        }
        i = j;
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null);
      i = j;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo));
    this.jdField_l_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c.a();
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l1 = System.nanoTime();
    localFileMsg.i = l1;
    this.jdField_d_of_type_Long = l1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_j_of_type_Long = 0L;
  }
  
  public void J_()
  {
    if (this.jdField_o_of_type_Long == -1L) {
      this.jdField_o_of_type_Long = SystemClock.uptimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    int i;
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      byte[] arrayOfByte = HexUtil.a(this.jdField_j_of_type_JavaLangString);
      vax localvax = new vax(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_b_of_type_Long, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, localvax);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_i_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 2);
      }
    } while (i == 0);
    a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
    b();
  }
  
  public int a()
  {
    if ((!this.h) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_o_of_type_Boolean))
    {
      h();
      t();
    }
    while (!this.jdField_k_of_type_Boolean) {
      return 0;
    }
    this.jdField_k_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    d(1002);
    if (this.bm != 1)
    {
      this.jdField_c_of_type_Long = 0L;
      this.jdField_j_of_type_JavaLangString = null;
    }
    this.bg = 0;
    this.bf = 0;
    this.be = 0;
    this.aU = 0;
    this.bc = "";
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
    x();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new vba(this));
    return 0;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    long l1;
    if (!this.jdField_f_of_type_Boolean)
    {
      l1 = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.jdField_c_of_type_Long, -1);
      if (QLog.isColorLevel()) {
        QLog.e("GroupPicUploadProcessor", 2, "get sscm size =" + l1);
      }
    }
    for (paramLong = Math.min(paramLong, l1);; paramLong = Math.min(paramLong, 14600L))
    {
      paramLong = Math.min(paramLong, 131072L);
      if (QLog.isColorLevel()) {
        QLog.e("GroupPicUploadProcessor", 2, "real sscm=" + paramLong);
      }
      return paramLong;
    }
  }
  
  protected HttpNetReq a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = super.a(paramArrayOfByte);
    paramArrayOfByte.jdField_c_of_type_Boolean = true;
    paramArrayOfByte.jdField_c_of_type_Boolean = true;
    return paramArrayOfByte;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    Object localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((ServerAddr)localObject).jdField_a_of_type_JavaLangString);
    if (((ServerAddr)localObject).jdField_b_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((ServerAddr)localObject).jdField_b_of_type_Int);
    }
    if (!this.h) {
      b(paramArrayOfByte);
    }
    for (;;)
    {
      if (!this.h)
      {
        localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        paramArrayOfByte.append("&voice_codec=" + ((MessageForPtt)localObject).voiceType);
      }
      paramArrayOfByte = a(paramArrayOfByte.toString(), this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      return paramArrayOfByte;
      a(paramArrayOfByte);
    }
  }
  
  /* Error */
  protected im_msg_body.RichText a()
  {
    // Byte code:
    //   0: new 637	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 638	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getfield 641	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_2
    //   17: getfield 645	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   24: getfield 146	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 651	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 656	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_2
    //   34: getfield 659	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 661	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_l_of_type_Long	J
    //   41: l2i
    //   42: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 663	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +23 -> 74
    //   54: aload_2
    //   55: getfield 667	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 663	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   62: ldc_w 669
    //   65: invokevirtual 672	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 678	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 683	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 597	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   78: ifnull +50 -> 128
    //   81: aload_0
    //   82: getfield 597	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: invokevirtual 686	java/util/ArrayList:size	()I
    //   88: ifle +40 -> 128
    //   91: aload_0
    //   92: getfield 597	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: iconst_0
    //   96: invokevirtual 603	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   99: checkcast 605	com/tencent/mobileqq/transfile/ServerAddr
    //   102: astore_1
    //   103: aload_2
    //   104: getfield 689	tencent/im/msg/im_msg_body$Ptt:uint32_server_ip	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: aload_1
    //   108: getfield 609	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokestatic 691	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;)I
    //   114: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   117: aload_2
    //   118: getfield 694	tencent/im/msg/im_msg_body$Ptt:uint32_server_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   121: aload_1
    //   122: getfield 610	com/tencent/mobileqq/transfile/ServerAddr:jdField_b_of_type_Int	I
    //   125: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   128: aload_0
    //   129: getfield 75	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: aload_0
    //   133: getfield 75	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: invokevirtual 486	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   139: invokestatic 699	com/tencent/mobileqq/service/message/MessageUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   142: istore 4
    //   144: new 701	tencent/im/msg/im_msg_body$Elem
    //   147: dup
    //   148: invokespecial 702	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   151: astore_3
    //   152: new 704	tencent/im/msg/im_msg_body$ElemFlags2
    //   155: dup
    //   156: invokespecial 705	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   159: astore_1
    //   160: aload_1
    //   161: getfield 708	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: iload 4
    //   166: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   169: aload_3
    //   170: getfield 712	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   173: aload_1
    //   174: invokevirtual 715	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   177: aload_2
    //   178: getfield 719	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   181: iconst_1
    //   182: invokevirtual 723	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   185: aload_2
    //   186: getfield 726	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: aload_0
    //   190: getfield 128	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_Long	J
    //   193: l2i
    //   194: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   197: aload_2
    //   198: getfield 729	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: aload_0
    //   202: getfield 249	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   205: invokestatic 678	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   208: invokevirtual 683	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   211: aload_2
    //   212: getfield 732	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: aload_0
    //   216: getfield 250	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   219: invokestatic 736	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   222: invokevirtual 683	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   225: aload_0
    //   226: aload_0
    //   227: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   230: getfield 335	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   233: checkcast 161	com/tencent/mobileqq/data/MessageForPtt
    //   236: invokespecial 738	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/data/MessageForPtt;)[B
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +14 -> 255
    //   244: aload_2
    //   245: getfield 741	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   248: aload_1
    //   249: invokestatic 678	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   252: invokevirtual 683	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   255: new 743	tencent/im/msg/im_msg_body$RichText
    //   258: dup
    //   259: invokespecial 744	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   262: astore_1
    //   263: aload_1
    //   264: getfield 748	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   267: aload_2
    //   268: invokevirtual 749	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   271: aload_1
    //   272: getfield 753	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   275: aload_3
    //   276: invokevirtual 758	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   279: aload_1
    //   280: areturn
    //   281: astore_2
    //   282: aconst_null
    //   283: astore_1
    //   284: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq -8 -> 279
    //   290: ldc 12
    //   292: iconst_2
    //   293: ldc_w 760
    //   296: aload_2
    //   297: invokestatic 763	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   300: aconst_null
    //   301: areturn
    //   302: astore_1
    //   303: goto -229 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	GroupPicUploadProcessor
    //   49	235	1	localObject	Object
    //   302	1	1	localUnsupportedEncodingException	UnsupportedEncodingException
    //   7	261	2	localPtt	im_msg_body.Ptt
    //   281	16	2	localException	Exception
    //   151	125	3	localElem	im_msg_body.Elem
    //   142	23	4	i	int
    // Exception table:
    //   from	to	target	type
    //   0	50	281	java/lang/Exception
    //   54	74	281	java/lang/Exception
    //   74	128	281	java/lang/Exception
    //   128	240	281	java/lang/Exception
    //   244	255	281	java/lang/Exception
    //   255	279	281	java/lang/Exception
    //   54	74	302	java/io/UnsupportedEncodingException
  }
  
  public void a()
  {
    super.a();
    if ((!this.h) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_l_of_type_Boolean))
    {
      if (VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, this)) {
        try
        {
          if (this.s)
          {
            d(1001);
            this.s = true;
          }
          return;
        }
        finally {}
      }
      if (h() == 0) {
        d(false);
      }
    }
    else
    {
      d(false);
    }
  }
  
  /* Error */
  public void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 779	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   7: aload_0
    //   8: getfield 532	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_o_of_type_Boolean	Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: getfield 531	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_k_of_type_Boolean	Z
    //   18: ifeq +4 -> 22
    //   21: return
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 782	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   27: aload_1
    //   28: getfield 786	com/tencent/mobileqq/transfile/NetResp:g	I
    //   31: istore 5
    //   33: aload_0
    //   34: ldc_w 788
    //   37: new 117	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 790
    //   47: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: getfield 792	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   54: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc_w 794
    //   60: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: getfield 796	com/tencent/mobileqq/transfile/NetResp:f	I
    //   67: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 798
    //   73: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 799	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 318	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_1
    //   90: getfield 792	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   93: ifne +665 -> 758
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 802	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aW	I
    //   101: aload_0
    //   102: getfield 66	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentWsttSSCMSSCM	Lcom/tencent/wstt/SSCM/SSCM;
    //   105: invokevirtual 803	com/tencent/wstt/SSCM/SSCM:b	()V
    //   108: aload_1
    //   109: getfield 806	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   112: ldc_w 808
    //   115: invokevirtual 813	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: ifnull +752 -> 870
    //   121: aload_1
    //   122: getfield 806	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   125: ldc_w 808
    //   128: invokevirtual 813	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 95	java/lang/String
    //   134: invokestatic 651	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   137: lstore 10
    //   139: lload 10
    //   141: lconst_0
    //   142: lcmp
    //   143: ifeq +88 -> 231
    //   146: lload 10
    //   148: ldc2_w 814
    //   151: lcmp
    //   152: ifeq +79 -> 231
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 476	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   160: aload_1
    //   161: iconst_0
    //   162: invokevirtual 818	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   165: lload 10
    //   167: l2i
    //   168: invokestatic 823	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:a	(I)Z
    //   171: ifne +60 -> 231
    //   174: aload_0
    //   175: sipush 56009
    //   178: aconst_null
    //   179: iload 5
    //   181: lload 10
    //   183: invokestatic 826	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	(IJ)Ljava/lang/String;
    //   186: aload_0
    //   187: getfield 476	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   190: invokevirtual 406	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   193: aload_0
    //   194: invokevirtual 269	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	()V
    //   197: return
    //   198: astore_1
    //   199: aload_0
    //   200: sipush 9343
    //   203: new 91	java/lang/Exception
    //   206: dup
    //   207: ldc_w 828
    //   210: invokespecial 356	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   213: invokestatic 831	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   216: ldc_w 521
    //   219: aload_0
    //   220: getfield 476	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   223: invokevirtual 406	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   226: aload_0
    //   227: invokevirtual 269	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	()V
    //   230: return
    //   231: aload_1
    //   232: getfield 806	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   235: ldc_w 833
    //   238: invokevirtual 813	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   241: checkcast 95	java/lang/String
    //   244: astore 4
    //   246: aload 4
    //   248: ifnull +630 -> 878
    //   251: aload 4
    //   253: invokestatic 104	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   256: istore 5
    //   258: iload 5
    //   260: i2l
    //   261: lstore 6
    //   263: lload 6
    //   265: lstore 8
    //   267: lload 6
    //   269: ldc2_w 814
    //   272: lcmp
    //   273: ifne +40 -> 313
    //   276: aload_1
    //   277: getfield 806	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   280: ldc_w 835
    //   283: invokevirtual 813	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   286: checkcast 95	java/lang/String
    //   289: astore_3
    //   290: aload_3
    //   291: astore_2
    //   292: lload 6
    //   294: lstore 8
    //   296: aload_3
    //   297: ifnull +16 -> 313
    //   300: aload_3
    //   301: invokestatic 104	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   304: istore 5
    //   306: iload 5
    //   308: i2l
    //   309: lstore 8
    //   311: aload_3
    //   312: astore_2
    //   313: lload 8
    //   315: ldc2_w 814
    //   318: lcmp
    //   319: ifne +117 -> 436
    //   322: aload_0
    //   323: aload_0
    //   324: getfield 476	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   327: aload_1
    //   328: iconst_0
    //   329: invokevirtual 818	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   332: aload_0
    //   333: sipush 56009
    //   336: new 117	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 837
    //   346: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 4
    //   351: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: ldc_w 839
    //   357: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_2
    //   361: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: aload_0
    //   368: getfield 842	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:bb	Ljava/lang/String;
    //   371: aload_0
    //   372: getfield 845	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aR	I
    //   375: i2l
    //   376: invokestatic 848	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   379: aload_0
    //   380: getfield 476	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   383: invokevirtual 406	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   386: aload_0
    //   387: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   390: ifnull +18 -> 408
    //   393: aload_0
    //   394: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   397: getfield 351	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   400: iconst_2
    //   401: if_icmpne +7 -> 408
    //   404: iconst_0
    //   405: invokestatic 850	com/tencent/mobileqq/transfile/PttInfoCollector:b	(Z)V
    //   408: aload_0
    //   409: invokevirtual 269	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	()V
    //   412: return
    //   413: astore_3
    //   414: aload_3
    //   415: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   418: goto +460 -> 878
    //   421: astore_2
    //   422: aload_2
    //   423: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   426: ldc2_w 814
    //   429: lstore 8
    //   431: aload_3
    //   432: astore_2
    //   433: goto -120 -> 313
    //   436: aload_0
    //   437: ldc_w 852
    //   440: new 117	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 854
    //   450: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_0
    //   454: getfield 136	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_c_of_type_Long	J
    //   457: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   460: ldc_w 856
    //   463: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: lload 8
    //   468: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   471: ldc_w 858
    //   474: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: lload 10
    //   479: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   482: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokevirtual 318	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: lload 8
    //   490: aload_0
    //   491: getfield 136	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_c_of_type_Long	J
    //   494: lcmp
    //   495: ifgt +31 -> 526
    //   498: aload_0
    //   499: getfield 538	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:bg	I
    //   502: iconst_3
    //   503: if_icmpge +74 -> 577
    //   506: aload_0
    //   507: ldc_w 860
    //   510: ldc_w 862
    //   513: invokevirtual 318	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: aload_0
    //   517: aload_0
    //   518: getfield 538	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:bg	I
    //   521: iconst_1
    //   522: iadd
    //   523: putfield 538	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:bg	I
    //   526: aload_0
    //   527: getfield 219	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   530: lload 8
    //   532: putfield 864	com/tencent/mobileqq/transfile/FileMsg:f	J
    //   535: aload_0
    //   536: lload 8
    //   538: putfield 136	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_c_of_type_Long	J
    //   541: aload_0
    //   542: aload_0
    //   543: getfield 476	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   546: aload_1
    //   547: iconst_1
    //   548: invokevirtual 818	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   551: lload 8
    //   553: aload_0
    //   554: getfield 128	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_Long	J
    //   557: lcmp
    //   558: ifge +92 -> 650
    //   561: aload_0
    //   562: getfield 532	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_o_of_type_Boolean	Z
    //   565: ifne -544 -> 21
    //   568: aload_0
    //   569: invokevirtual 527	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:h	()V
    //   572: aload_0
    //   573: invokevirtual 866	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:s	()V
    //   576: return
    //   577: aload_0
    //   578: aload_0
    //   579: getfield 476	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   582: aload_1
    //   583: iconst_0
    //   584: invokevirtual 818	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   587: aload_0
    //   588: getfield 867	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   591: ldc_w 869
    //   594: new 117	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 521
    //   604: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: lload 10
    //   609: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   612: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokevirtual 873	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   618: pop
    //   619: aload_0
    //   620: sipush 56009
    //   623: ldc_w 521
    //   626: aload_0
    //   627: getfield 842	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:bb	Ljava/lang/String;
    //   630: aload_0
    //   631: getfield 876	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aQ	I
    //   634: i2l
    //   635: invokestatic 848	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   638: aload_0
    //   639: getfield 476	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   642: invokevirtual 406	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   645: aload_0
    //   646: invokevirtual 269	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	()V
    //   649: return
    //   650: aload_0
    //   651: monitorenter
    //   652: aload_0
    //   653: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   656: getfield 523	com/tencent/mobileqq/transfile/TransferRequest:jdField_n_of_type_Boolean	Z
    //   659: ifeq +13 -> 672
    //   662: aload_0
    //   663: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   666: getfield 525	com/tencent/mobileqq/transfile/TransferRequest:jdField_o_of_type_Boolean	Z
    //   669: ifeq +62 -> 731
    //   672: aload_0
    //   673: invokevirtual 529	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:t	()V
    //   676: aload_0
    //   677: getfield 219	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   680: invokevirtual 223	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   683: aload_0
    //   684: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   687: getfield 523	com/tencent/mobileqq/transfile/TransferRequest:jdField_n_of_type_Boolean	Z
    //   690: ifeq +33 -> 723
    //   693: invokestatic 879	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   696: ifeq +13 -> 709
    //   699: getstatic 882	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   702: iconst_4
    //   703: ldc_w 884
    //   706: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   709: aload_0
    //   710: getfield 75	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   713: invokestatic 887	com/tencent/mobileqq/ptt/preop/PttPreSendManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/ptt/preop/PttPreSendManager;
    //   716: aload_0
    //   717: invokevirtual 888	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	()Ljava/lang/String;
    //   720: invokevirtual 890	com/tencent/mobileqq/ptt/preop/PttPreSendManager:a	(Ljava/lang/String;)V
    //   723: aload_0
    //   724: monitorexit
    //   725: return
    //   726: astore_1
    //   727: aload_0
    //   728: monitorexit
    //   729: aload_1
    //   730: athrow
    //   731: aload_0
    //   732: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   735: iconst_1
    //   736: putfield 525	com/tencent/mobileqq/transfile/TransferRequest:jdField_o_of_type_Boolean	Z
    //   739: invokestatic 879	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   742: ifeq -19 -> 723
    //   745: getstatic 882	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   748: iconst_4
    //   749: ldc_w 892
    //   752: invokestatic 196	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   755: goto -32 -> 723
    //   758: aload_1
    //   759: getfield 796	com/tencent/mobileqq/transfile/NetResp:f	I
    //   762: sipush 9364
    //   765: if_icmpne +40 -> 805
    //   768: aload_0
    //   769: getfield 802	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aW	I
    //   772: iconst_3
    //   773: if_icmpge +32 -> 805
    //   776: aload_0
    //   777: ldc_w 894
    //   780: ldc_w 896
    //   783: invokevirtual 318	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   786: aload_0
    //   787: aload_0
    //   788: getfield 802	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aW	I
    //   791: iconst_1
    //   792: iadd
    //   793: putfield 802	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aW	I
    //   796: aload_0
    //   797: invokevirtual 898	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:q	()V
    //   800: aload_0
    //   801: invokevirtual 266	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:g	()V
    //   804: return
    //   805: aload_1
    //   806: getfield 899	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   809: getfield 902	com/tencent/mobileqq/transfile/NetReq:jdField_a_of_type_ArrayOfByte	[B
    //   812: arraylength
    //   813: ldc_w 903
    //   816: if_icmplt +27 -> 843
    //   819: aload_1
    //   820: getfield 796	com/tencent/mobileqq/transfile/NetResp:f	I
    //   823: invokestatic 906	com/tencent/mobileqq/transfile/RichMediaStrategy:a	(I)Z
    //   826: ifeq +17 -> 843
    //   829: aload_0
    //   830: iconst_1
    //   831: putfield 43	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_f_of_type_Boolean	Z
    //   834: aload_0
    //   835: invokevirtual 898	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:q	()V
    //   838: aload_0
    //   839: invokevirtual 866	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:s	()V
    //   842: return
    //   843: aload_0
    //   844: aload_0
    //   845: getfield 476	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   848: aload_1
    //   849: iconst_0
    //   850: invokevirtual 818	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   853: aload_0
    //   854: aload_1
    //   855: getfield 796	com/tencent/mobileqq/transfile/NetResp:f	I
    //   858: aload_1
    //   859: getfield 799	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   862: invokevirtual 331	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;)V
    //   865: aload_0
    //   866: invokevirtual 269	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	()V
    //   869: return
    //   870: ldc2_w 814
    //   873: lstore 10
    //   875: goto -736 -> 139
    //   878: ldc2_w 814
    //   881: lstore 6
    //   883: goto -620 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	886	0	this	GroupPicUploadProcessor
    //   0	886	1	paramNetResp	NetResp
    //   1	360	2	localObject1	Object
    //   421	2	2	localException1	Exception
    //   432	1	2	localObject2	Object
    //   289	23	3	str1	String
    //   413	19	3	localException2	Exception
    //   244	106	4	str2	String
    //   31	276	5	i	int
    //   261	621	6	l1	long
    //   265	287	8	l2	long
    //   137	737	10	l3	long
    // Exception table:
    //   from	to	target	type
    //   89	139	198	java/lang/Exception
    //   155	197	198	java/lang/Exception
    //   231	246	198	java/lang/Exception
    //   276	290	198	java/lang/Exception
    //   322	408	198	java/lang/Exception
    //   408	412	198	java/lang/Exception
    //   414	418	198	java/lang/Exception
    //   422	426	198	java/lang/Exception
    //   436	526	198	java/lang/Exception
    //   526	576	198	java/lang/Exception
    //   577	649	198	java/lang/Exception
    //   650	652	198	java/lang/Exception
    //   729	731	198	java/lang/Exception
    //   758	804	198	java/lang/Exception
    //   805	842	198	java/lang/Exception
    //   843	869	198	java/lang/Exception
    //   251	258	413	java/lang/Exception
    //   300	306	421	java/lang/Exception
    //   652	672	726	finally
    //   672	709	726	finally
    //   709	723	726	finally
    //   723	725	726	finally
    //   727	729	726	finally
    //   731	755	726	finally
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    int i;
    if (paramRichProtoResp != null)
    {
      i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_j_of_type_Boolean = paramRichProtoReq.e;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_j_of_type_Boolean);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (!(paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp)) {
          break label535;
        }
        if (!this.r)
        {
          this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
          this.r = true;
        }
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq;
        if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
          break label492;
        }
        d(1002);
        if (paramRichProtoReq.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp GroupPicUpResp.isExist.");
          }
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
          this.jdField_l_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          t();
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h)
      {
        a(9333, "Server MD5 fast forward missed");
        b();
        return;
      }
      this.jdField_l_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
      this.jdField_j_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_c_of_type_Long = paramRichProtoReq.jdField_b_of_type_Int;
      this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramRichProtoReq.jdField_b_of_type_Long;
      boolean bool = paramRichProtoReq.jdField_c_of_type_Boolean;
      if ((paramRichProtoReq.jdField_a_of_type_Int != 0) && (this.jdField_c_of_type_Boolean) && (!paramRichProtoReq.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(paramRichProtoReq.jdField_a_of_type_Int);
      }
      if (this.bm == 2)
      {
        c("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
        s();
        continue;
      }
      if (this.bm == 0)
      {
        c("<BDH_LOG> onBusiProtoResp() start normally, selecting channel...");
        if (!bool) {
          c("<BDH_LOG> onBusiProtoResp() Server's isUseBdh = false");
        }
        if (bool)
        {
          c("<BDH_LOG> onBusiProtoResp() select BDH channel");
          this.bm = 1;
          J_();
          continue;
        }
        c("<BDH_LOG> onBusiProtoResp() select HTTP channel");
        this.bm = 2;
        s();
        continue;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
      if (this.bm == 1) {}
      for (paramRichProtoReq = "BDH";; paramRichProtoReq = "HTTP")
      {
        c(paramRichProtoReq);
        break;
      }
      label492:
      c("<BDH_LOG> onBusiProtoResp() error : " + paramRichProtoReq.jdField_c_of_type_Int + " ,select HTTP channel");
      this.bm = 2;
      b();
      return;
      label535:
      if (!(paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPttUpResp)) {
        continue;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1026) && (QLog.isColorLevel())) {
        QLog.i("PttShow", 2, "onBusiProtoResp, UIN_TYPE_HOTCHAT_TOPIC");
      }
      if (!this.r)
      {
        this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
        this.r = true;
      }
      paramRichProtoReq = (RichProto.RichProtoResp.GroupPttUpResp)paramRichProtoReq;
      if (paramRichProtoReq.jdField_c_of_type_Int == 0) {
        if (paramRichProtoReq.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
          this.jdField_l_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
          if (paramRichProtoReq.jdField_a_of_type_ArrayOfByte == null) {}
        }
      }
      try
      {
        this.jdField_k_of_type_JavaLangString = new String(paramRichProtoReq.jdField_a_of_type_ArrayOfByte, "utf-8");
        for (;;)
        {
          try
          {
            if ((!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_o_of_type_Boolean))
            {
              t();
              if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d(PttPreSendManager.jdField_a_of_type_JavaLangString, 4, "group group  upResp.isExist, can send msg, direct send");
                }
                PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(a());
              }
              break;
            }
          }
          finally {}
          if (QLog.isDevelopLevel()) {
            QLog.d(PttPreSendManager.jdField_a_of_type_JavaLangString, 4, "group group  upResp.isExist, can't send msg, wait");
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_o_of_type_Boolean = true;
        }
        this.jdField_l_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
        if (paramRichProtoReq.jdField_a_of_type_ArrayOfByte != null) {}
        try
        {
          this.jdField_k_of_type_JavaLangString = new String(paramRichProtoReq.jdField_a_of_type_ArrayOfByte, "utf-8");
          this.jdField_j_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_c_of_type_Long = paramRichProtoReq.jdField_b_of_type_Int;
          this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Int;
          a("OnProtoResp", " TryUpload response GrpFileKey:" + this.jdField_k_of_type_JavaLangString);
          s();
          continue;
          b();
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;) {}
        }
      }
      catch (UnsupportedEncodingException paramRichProtoReq)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   6: iconst_1
    //   7: putfield 765	com/tencent/mobileqq/transfile/TransferRequest:jdField_l_of_type_Boolean	Z
    //   10: aload_0
    //   11: getfield 141	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   14: getfield 335	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 161	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 1029	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 619	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 772	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:s	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokespecial 774	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:h	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokespecial 776	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokespecial 774	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:h	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokespecial 776	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	GroupPicUploadProcessor
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.bl == 1))
    {
      this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Int = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (!this.h) {
        PttSSCMPool.a(this.jdField_a_of_type_ComTencentWsttSSCMSSCM);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(this.jdField_d_of_type_Long);
        this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(this.jdField_d_of_type_Long);
      }
      String str1 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (!paramBoolean)
      {
        if (this.aU == 9004) {
          break label192;
        }
        if (g()) {}
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1030) {}
      label192:
      Object localObject1;
      while (((!paramBoolean) && (RichMediaStrategy.c(this.aU))) || (this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0)))
      {
        return;
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
        if ("connError_unreachable".equalsIgnoreCase((String)localObject1))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
          break;
        }
        if (!"connError_noroute".equalsIgnoreCase((String)localObject1)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_2");
        break;
      }
      int j = this.aX;
      int i;
      Object localObject2;
      if (paramBoolean)
      {
        i = 2;
        this.aX = (i | j);
        if (!this.jdField_g_of_type_Boolean) {
          break label1242;
        }
        if (!this.h) {
          break label1234;
        }
        localObject2 = "actGroupPicUploadV1";
        label351:
        localObject1 = localObject2;
        if (!this.h) {
          break label1446;
        }
        localObject1 = localObject2;
        if (this.bm != 1) {
          break label1446;
        }
        localObject1 = "actGroupPicUploadV2";
      }
      label428:
      label436:
      label1234:
      label1242:
      label1303:
      label1313:
      label1446:
      for (;;)
      {
        long l1;
        long l2;
        if ((!this.h) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)))
        {
          localObject2 = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
          if (localObject2 == null)
          {
            i = 0;
            if (localObject2 != null) {
              break label1303;
            }
            l1 = 0L;
            PttInfoCollector.a(str2, true, paramBoolean, i, l1);
          }
        }
        else
        {
          this.jdField_e_of_type_Long = System.currentTimeMillis();
          long l3 = System.nanoTime();
          l2 = (l3 - this.jdField_d_of_type_Long) / 1000000L;
          Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long - this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long) / 1000000L);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str1);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_fileid", String.valueOf(this.jdField_l_of_type_Long));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_f_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_d_of_type_Boolean + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", StatisticConstants.a() + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", NetworkUtil.a(BaseApplication.getContext()) + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.jdField_l_of_type_Boolean + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.bk));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int));
          if ((this.t) && (!this.h))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put("param_pttNetDown", String.valueOf(this.m / 1000000L));
            if (QLog.isColorLevel()) {
              QLog.d("weak_net", 2, String.valueOf(this.m / 1000000L));
            }
          }
          if (!this.h) {
            this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(PttOptimizeParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
          }
          if (!paramBoolean) {
            break label1313;
          }
          e();
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean)
          {
            l1 = 0L;
            if (this.jdField_k_of_type_Long != 0L) {
              l1 = (l3 - this.jdField_k_of_type_Long) / 1000000L;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_j_of_type_Boolean) {
              l1 = l2;
            }
            double d1 = l1 / l2;
            StatisticConstants.a(l1, this.jdField_a_of_type_Long, this.jdField_d_of_type_Boolean, d1);
            if ((d1 >= 0.0D) && (d1 <= 1.0D)) {
              this.jdField_a_of_type_JavaUtilHashMap.put("param_AIOPercent", d1 + "");
            }
            this.jdField_a_of_type_JavaUtilHashMap.put("param_AIODuration", l1 + "");
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_d_of_type_Long + ",mEnterAioTime = " + this.jdField_k_of_type_Long + ",finishTime  = " + l3 + ", aioDuration = " + l1 + ", duration = " + l2 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_j_of_type_Boolean + ",Percent = " + d1);
            }
          }
          StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, true, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        }
        for (;;)
        {
          p();
          AppNetConnInfo.unregisterNetEventHandler(this);
          return;
          i = 1;
          break;
          localObject2 = "actGrpPttUp";
          break label351;
          if (this.h) {}
          for (localObject2 = "actDiscussPicUpload";; localObject2 = "actDisscusPttUp")
          {
            localObject1 = localObject2;
            if (!this.h) {
              break label1446;
            }
            localObject1 = localObject2;
            if (this.bm != 1) {
              break label1446;
            }
            localObject1 = "actDiscussPicUploadV2";
            break;
          }
          i = ((MessageForPtt)localObject2).voiceChangeFlag;
          break label428;
          l1 = ((MessageForPtt)localObject2).fileSize;
          break label436;
          if (this.aU != 56009) {
            this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
          }
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
          StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, false, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        }
      }
    }
  }
  
  public int b()
  {
    return super.b();
  }
  
  protected im_msg_body.RichText b()
  {
    for (;;)
    {
      Object localObject2;
      Object localObject4;
      Object localObject3;
      try
      {
        localObject2 = new im_msg_body.CustomFace();
        ((im_msg_body.CustomFace)localObject2).uint32_file_id.set((int)this.jdField_l_of_type_Long);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject1 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.CustomFace)localObject2).uint32_server_ip.set(a(((ServerAddr)localObject1).jdField_a_of_type_JavaLangString));
          ((im_msg_body.CustomFace)localObject2).uint32_server_port.set(((ServerAddr)localObject1).jdField_b_of_type_Int);
        }
        ((im_msg_body.CustomFace)localObject2).uint32_file_type.set(Integer.valueOf(66).intValue());
        ((im_msg_body.CustomFace)localObject2).uint32_useful.set(1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          ((im_msg_body.CustomFace)localObject2).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        }
        ((im_msg_body.CustomFace)localObject2).bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        ((im_msg_body.CustomFace)localObject2).str_file_path.set(this.jdField_f_of_type_JavaLangString);
        Object localObject1 = ((im_msg_body.CustomFace)localObject2).uint32_origin;
        if (!this.jdField_l_of_type_Boolean) {
          break label994;
        }
        i = 1;
        ((PBUInt32Field)localObject1).set(i);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject4 != null) && (MessageForPic.class.isInstance(localObject4)))
        {
          localObject1 = (MessageForPic)localObject4;
          ((im_msg_body.CustomFace)localObject2).uint32_show_len.set(((MessageForPic)localObject1).mShowLength);
          ((im_msg_body.CustomFace)localObject2).uint32_download_len.set(((MessageForPic)localObject1).mDownloadLength);
          ((im_msg_body.CustomFace)localObject2).image_type.set(((MessageForPic)localObject1).imageType);
        }
        i = 200;
        switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int)
        {
        case 1008: 
          ((im_msg_body.CustomFace)localObject2).uint32_width.set(this.aM);
          ((im_msg_body.CustomFace)localObject2).uint32_height.set(this.aN);
          ((im_msg_body.CustomFace)localObject2).uint32_size.set((int)this.jdField_a_of_type_Long);
          ((im_msg_body.CustomFace)localObject2).uint32_source.set(i);
          if (QLog.isColorLevel()) {
            a("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int + " protoBusiType:" + ((im_msg_body.CustomFace)localObject2).biz_type.get());
          }
          localObject1 = new im_msg_body.RichText();
          localObject3 = new im_msg_body.Elem();
          if (!HotChatHelper.a((MessageRecord)localObject4)) {
            break label829;
          }
          ((im_msg_body.Elem)localObject3).hc_flash_pic.set((MessageMicro)localObject2);
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
          localObject2 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8("发送了一张[闪照]，请更新版本查看。"));
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).text.set((MessageMicro)localObject2);
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          if (!(localObject3 instanceof MessageForStructing)) {
            break label992;
          }
          localObject2 = (MessageForStructing)localObject3;
          if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare))) {
            break label992;
          }
          localObject4 = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
          if (localObject4 == null) {
            break label992;
          }
          ((StructMsgItemImage)localObject4).q = this.jdField_e_of_type_JavaLangString;
          ((StructMsgItemImage)localObject4).p = this.jdField_f_of_type_JavaLangString;
          ((StructMsgItemImage)localObject4).jdField_c_of_type_Long = this.jdField_l_of_type_Long;
          ((StructMsgItemImage)localObject4).jdField_e_of_type_Long = ((MessageRecord)localObject3).time;
          ((StructMsgItemImage)localObject4).jdField_d_of_type_Long = this.jdField_a_of_type_Long;
          localObject3 = ((MessageForStructing)localObject2).structingMsg.getXmlBytes();
          if ((TextUtils.isEmpty(((MessageForStructing)localObject2).frienduin)) || (localObject3 == null)) {
            break label992;
          }
          localObject2 = new im_msg_body.RichMsg();
          ((im_msg_body.RichMsg)localObject2).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject3));
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject2);
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
        localException.printStackTrace();
        return null;
      }
      ((im_msg_body.CustomFace)localObject2).biz_type.set(2);
      int i = 105;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(3);
      i = 101;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(4);
      i = 104;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(5);
      i = 103;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(6);
      i = 106;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(7);
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(8);
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(9);
      continue;
      label829:
      if (FlashPicHelper.a((MessageRecord)localObject4))
      {
        localObject4 = new im_msg_body.CommonElem();
        ((im_msg_body.CommonElem)localObject4).uint32_service_type.set(3);
        hummer_commelem.MsgElemInfo_servtype3 localMsgElemInfo_servtype3 = new hummer_commelem.MsgElemInfo_servtype3();
        localMsgElemInfo_servtype3.flash_troop_pic.set((MessageMicro)localObject2);
        ((im_msg_body.CommonElem)localObject4).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype3.toByteArray()));
        ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject4);
        localException.elems.add((MessageMicro)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("flash", 2, "GroupPicUploadProcessor constructPicRichText send flash");
        }
        localObject2 = new im_msg_body.Text();
        ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8("[闪照]请使用新版手机QQ查看闪照。"));
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).text.set((MessageMicro)localObject2);
        localException.elems.add((MessageMicro)localObject3);
      }
      else
      {
        ((im_msg_body.Elem)localObject3).custom_face.set((MessageMicro)localObject2);
        localException.elems.add((MessageMicro)localObject3);
        continue;
        continue;
        label992:
        return localException;
        label994:
        i = 0;
      }
    }
  }
  
  public void b()
  {
    super.b();
    d(1005);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.aU;
      localSendResult.jdField_a_of_type_JavaLangString = this.bc;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) {
      PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(a());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      a("updateDb", "msg null");
    }
    label78:
    Object localObject;
    StructMsgItemImage localStructMsgItemImage;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          a("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            a("updateDb", "is multiMsg");
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2) && ((localMessageRecord instanceof MessageForPtt)))
          {
            localObject = (MessageForPtt)localMessageRecord;
            if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) {
              ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString);
            }
            ((MessageForPtt)localObject).fileSize = this.jdField_a_of_type_Long;
            ((MessageForPtt)localObject).urlAtServer = this.jdField_f_of_type_JavaLangString;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.jdField_l_of_type_Long;
            ((MessageForPtt)localObject).groupFileKeyStr = this.jdField_k_of_type_JavaLangString;
            ((MessageForPtt)localObject).md5 = this.jdField_e_of_type_JavaLangString;
            ((MessageForPtt)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
            ((MessageForPic)localObject).size = this.jdField_a_of_type_Long;
            ((MessageForPic)localObject).uuid = this.jdField_f_of_type_JavaLangString;
            ((MessageForPic)localObject).groupFileID = this.jdField_l_of_type_Long;
            ((MessageForPic)localObject).md5 = this.jdField_e_of_type_JavaLangString;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localStructMsgItemImage == null);
    localStructMsgItemImage.q = this.jdField_e_of_type_JavaLangString;
    localStructMsgItemImage.p = this.jdField_f_of_type_JavaLangString;
    localStructMsgItemImage.jdField_d_of_type_Long = this.jdField_a_of_type_Long;
    localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_l_of_type_Long;
    localStructMsgItemImage.jdField_e_of_type_Long = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
  
  public int c()
  {
    super.c();
    if ((!this.h) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_l_of_type_Boolean)) {
      return 0;
    }
    return h();
  }
  
  public long c()
  {
    if ((this.h) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_l_of_type_Boolean)) {
      return super.c();
    }
    return 7000L;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localSendResult.d = this.jdField_e_of_type_JavaLangString;
      localSendResult.c = this.jdField_f_of_type_JavaLangString;
      localSendResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
      localSendResult.jdField_b_of_type_Long = this.jdField_l_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
    for (;;)
    {
      if (!this.h) {
        d(1003);
      }
      return;
      b(true);
    }
  }
  
  void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    Object localObject1;
    Object localObject2;
    if (this.h)
    {
      localObject1 = new RichProto.RichProtoReq.PicUpReq();
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_c_of_type_Int = this.aM;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).d = this.aN;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_b_of_type_Boolean = this.jdField_l_of_type_Boolean;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localObject2))
      {
        ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_a_of_type_Int = ((MessageForPic)localObject2).imageType;
        this.bk = ((MessageForPic)localObject2).imageType;
      }
      ((RichProto.RichProtoReq.ReqCommon)localObject1).c = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject1).d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c;
      ((RichProto.RichProtoReq.ReqCommon)localObject1).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d;
      ((RichProto.RichProtoReq.ReqCommon)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1026)
      {
        ((RichProto.RichProtoReq.ReqCommon)localObject1).jdField_e_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
        }
      }
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      if (!this.h) {
        break label355;
      }
      localObject2 = "grp_pic_up";
      label223:
      localRichProtoReq.jdField_a_of_type_JavaLangString = ((String)localObject2);
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localObject1);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break label362;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
    }
    label355:
    label362:
    do
    {
      return;
      localObject1 = new RichProto.RichProtoReq.PttUpReq();
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Long);
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_a_of_type_Int = QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      ((RichProto.RichProtoReq.PttUpReq)localObject1).d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Int;
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_c_of_type_Int = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).voiceType;
      break;
      localObject2 = "grp_ptt_up";
      break label223;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void k()
  {
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        a("pause", "");
      }
      d(1006);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
    }
    switch (this.bm)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        c("<BDH_LOG> pause() BUT current status is INIT");
        return;
        c("<BDH_LOG> pause() pause HTTP channel");
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq == null);
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      c("<BDH_LOG> pause() pause BDH channel, transation id=" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().stopTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    c("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.n > 0L) {
        this.m += System.nanoTime() - this.n;
      }
    }
    for (this.n = 0L;; this.n = System.nanoTime())
    {
      this.t = true;
      return;
    }
  }
  
  protected void r()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      if (!this.jdField_g_of_type_Boolean) {
        break label58;
      }
      if (i != 2) {
        break label31;
      }
    }
    label31:
    label58:
    while (i == 2)
    {
      return;
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picGu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picDu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
  }
  
  public void s()
  {
    if (this.jdField_o_of_type_Long == -1L) {
      this.jdField_o_of_type_Long = SystemClock.uptimeMillis();
    }
    super.J_();
  }
  
  public void t()
  {
    if (!e()) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if (this.h) {
      d(1003);
    }
    if (this.jdField_g_of_type_Boolean)
    {
      u();
      return;
    }
    v();
  }
  
  void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject1 instanceof MessageForPtt)) {
          break label203;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label176;
        }
      }
      label176:
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        break;
      }
      label203:
      MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((im_msg_body.RichText)localObject2).ptt.uint32_format.set(localMessageForPtt.voiceType);
      ((im_msg_body.RichText)localObject2).ptt.uint32_time.set(Utils.a(localMessageForPtt.voiceLength));
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendGroupMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1026) && (QLog.isColorLevel())) {
        QLog.i("PttShow", 2, "sendGroupMsg, UIN_TYPE_HOTCHAT_TOPIC");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_c_of_type_Long;
      }
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
          ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
        }
        c();
        return;
        if (!d())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          b();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label746;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label719;
      }
    }
    label719:
    for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      break;
    }
    label746:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
          break label207;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label180;
        }
      }
      label180:
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        break;
      }
      label207:
      MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((im_msg_body.RichText)localObject2).ptt.uint32_format.set(localMessageForPtt.voiceType);
      ((im_msg_body.RichText)localObject2).ptt.uint32_time.set(Utils.a(localMessageForPtt.voiceLength));
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendDiscussMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_c_of_type_Long;
      }
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
          ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
        }
        c();
        return;
        if (!d())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          b();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label721;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label694;
      }
    }
    label694:
    for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      break;
    }
    label721:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void w()
  {
    if (this.jdField_o_of_type_Boolean) {
      return;
    }
    if ((this.jdField_j_of_type_JavaLangString != null) && (this.jdField_l_of_type_Long != 0L))
    {
      if (this.jdField_c_of_type_Long >= this.jdField_a_of_type_Long)
      {
        t();
        return;
      }
      if ((this.bm == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        c("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      a();
      return;
    }
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\GroupPicUploadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */