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
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.NewServiceTicket;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicInfoExt;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicRspExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.protohandler.C2CPicUpHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import vad;
import vae;
import vaf;
import vai;
import vaj;

public class C2CPicUploadProcessor
  extends BaseUploadProcessor
{
  public static final String d = "C2CPicUploadProcessor";
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  public QQAppInterface a;
  private CSDataHighwayHead.LoginSigHead jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead;
  protected TransFileController a;
  private int aH;
  private byte[] b;
  private byte[] c;
  private byte[] d;
  private BaseTransProcessor.StepInfo jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
  private byte[] jdField_e_of_type_ArrayOfByte;
  private BaseTransProcessor.StepInfo jdField_f_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo;
  private boolean jdField_f_of_type_Boolean;
  
  public C2CPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_f_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vaj(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.s = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.bv = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
    this.jdField_f_of_type_Boolean = OpenUpConfig.isOpenUpEnable;
    this.aH = OpenUpConfig.getPreSendDots(BaseApplication.getContext());
  }
  
  private CSDataHighwayHead.LoginSigHead a()
  {
    CSDataHighwayHead.LoginSigHead localLoginSigHead = new CSDataHighwayHead.LoginSigHead();
    Object localObject1 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
    {
      localObject1 = ((TicketManager)localObject1).getA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (localObject1 == null) {
        break label102;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).getBytes("utf-8");
        if ((localObject1 == null) || (localObject1.length == 0)) {
          return null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return null;
      }
      localLoginSigHead.bytes_loginsig.set(ByteStringMicro.copyFrom(localUnsupportedEncodingException));
      localLoginSigHead.uint32_loginsig_type.set(8);
      return localLoginSigHead;
      label102:
      Object localObject2 = null;
    }
  }
  
  private im_msg_body.RichText a()
  {
    for (;;)
    {
      im_msg_body.RichText localRichText;
      Object localObject2;
      try
      {
        localRichText = new im_msg_body.RichText();
        localObject1 = new im_msg_body.NotOnlineImage();
        ((im_msg_body.NotOnlineImage)localObject1).file_path.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
        ((im_msg_body.NotOnlineImage)localObject1).file_len.set((int)this.jdField_a_of_type_Long);
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_j_of_type_JavaLangString != null) {
          ((im_msg_body.NotOnlineImage)localObject1).download_path.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_j_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_i_of_type_JavaLangString != null) {
          ((im_msg_body.NotOnlineImage)localObject1).res_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_i_of_type_JavaLangString));
        }
        ((im_msg_body.NotOnlineImage)localObject1).pic_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        ((im_msg_body.NotOnlineImage)localObject1).pic_height.set(this.aN);
        ((im_msg_body.NotOnlineImage)localObject1).pic_width.set(this.aM);
        localObject2 = ((im_msg_body.NotOnlineImage)localObject1).original;
        if (!this.l) {
          break label847;
        }
        i = 1;
        ((PBUInt32Field)localObject2).set(i);
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject3 != null) && (MessageForPic.class.isInstance(localObject3)))
        {
          localObject2 = (MessageForPic)localObject3;
          ((im_msg_body.NotOnlineImage)localObject1).uint32_show_len.set(((MessageForPic)localObject2).mShowLength);
          ((im_msg_body.NotOnlineImage)localObject1).uint32_download_len.set(((MessageForPic)localObject2).mDownloadLength);
          ((im_msg_body.NotOnlineImage)localObject1).img_type.set(((MessageForPic)localObject2).imageType);
        }
        switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int)
        {
        case 1008: 
          if (QLog.isColorLevel()) {
            a("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int + " protoBusiType:" + ((im_msg_body.NotOnlineImage)localObject1).biz_type.get());
          }
          localObject2 = new im_msg_body.Elem();
          if (!FlashPicHelper.a((MessageRecord)localObject3)) {
            break label815;
          }
          localObject3 = new im_msg_body.CommonElem();
          ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(3);
          Object localObject4 = new hummer_commelem.MsgElemInfo_servtype3();
          ((hummer_commelem.MsgElemInfo_servtype3)localObject4).flash_c2c_pic.set((MessageMicro)localObject1);
          ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject4).toByteArray()));
          ((im_msg_body.Elem)localObject2).common_elem.set((MessageMicro)localObject3);
          localRichText.elems.add((MessageMicro)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "C2CPicUploadProcessor constructPicRichText send flash");
          }
          localObject1 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8("[闪照]请使用新版手机QQ查看闪照。"));
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject2);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          if (!(localObject3 instanceof MessageForStructing)) {
            break label845;
          }
          localObject2 = (MessageForStructing)localObject3;
          if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare))) {
            break label845;
          }
          localObject4 = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
          if (localObject4 == null) {
            break label845;
          }
          ((StructMsgItemImage)localObject4).q = this.jdField_e_of_type_JavaLangString;
          if (this.jdField_h_of_type_JavaLangString != null) {
            break label834;
          }
          localObject1 = this.jdField_i_of_type_JavaLangString;
          ((StructMsgItemImage)localObject4).p = ((String)localObject1);
          ((StructMsgItemImage)localObject4).jdField_d_of_type_Long = this.jdField_a_of_type_Long;
          ((StructMsgItemImage)localObject4).jdField_e_of_type_Long = ((MessageRecord)localObject3).time;
          localObject1 = ((MessageForStructing)localObject2).structingMsg.getXmlBytes();
          if ((TextUtils.isEmpty(((MessageForStructing)localObject2).frienduin)) || (localObject1 == null)) {
            break label845;
          }
          localObject2 = new im_msg_body.RichMsg();
          ((im_msg_body.RichMsg)localObject2).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject2);
          localRichText.elems.add((MessageMicro)localObject1);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error", localException);
        localException.printStackTrace();
        return null;
      }
      ((im_msg_body.NotOnlineImage)localObject1).biz_type.set(2);
      continue;
      localException.biz_type.set(3);
      continue;
      localException.biz_type.set(4);
      continue;
      localException.biz_type.set(5);
      continue;
      localException.biz_type.set(6);
      continue;
      localException.biz_type.set(7);
      continue;
      localException.biz_type.set(8);
      continue;
      localException.biz_type.set(9);
      continue;
      label815:
      ((im_msg_body.Elem)localObject2).not_online_image.set(localException);
      localRichText.elems.add((MessageMicro)localObject2);
      continue;
      label834:
      String str = this.jdField_h_of_type_JavaLangString;
      continue;
      continue;
      label845:
      return localRichText;
      label847:
      int i = 0;
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    }
    long l1;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)))
    {
      l1 = ((MessageForPic)localObject1).DSKey;
      if (l1 != 0L) {
        break label48;
      }
    }
    label48:
    Object[] arrayOfObject;
    do
    {
      return;
      arrayOfObject = (Object[])this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b.remove(Long.valueOf(l1));
    } while (arrayOfObject == null);
    String str2 = (String)arrayOfObject[0];
    ((MessageForPic)localObject1).SpeedInfo = paramString;
    Object localObject2 = paramString.split(";");
    Object localObject3 = localObject2[0];
    localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    localObject3 = ((String)localObject3).split("_");
    Object localObject5 = ((String)localObject1).split("_");
    localObject1 = ((String)localObject2).split("_");
    long l2 = Long.valueOf(localObject3[4]).longValue();
    long l3 = Long.valueOf(localObject1[4]).longValue();
    long l4 = Long.valueOf(localObject5[4]).longValue();
    localObject2 = str2.split(";");
    localObject3 = localObject2[0];
    localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    localObject3 = ((String)localObject3).split("_");
    localObject1 = ((String)localObject1).split("_");
    localObject2 = ((String)localObject2).split("_");
    long l5 = Long.valueOf(localObject3[4]).longValue();
    long l6 = Long.valueOf(localObject2[4]).longValue();
    long l7 = Long.valueOf(localObject1[4]).longValue();
    localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_BdhTrans");
    long l8 = Long.valueOf(localObject1[4]).longValue() - ((Integer)arrayOfObject[4]).intValue();
    Object localObject4;
    String str1;
    int k;
    int j;
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      localObject1 = ((String)localObject2).split(";");
      localObject2 = localObject1[0];
      localObject4 = localObject1[2].split(":")[1];
      str1 = localObject1[3].split(":")[1];
      localObject3 = localObject1[4].split(":")[1];
      localObject2 = localObject1[5].split(":")[1];
      localObject1 = localObject1[6].split(":")[1];
      l1 = Long.valueOf(localObject5[4]).longValue() - Integer.valueOf(str1).intValue();
      k = (int)((float)this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long / ((float)l1 / 1000.0F) / 1000.0F);
      j = (int)((float)this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long / ((float)l8 / 1000.0F) / 1000.0F);
      if ((str1 == null) || (l1 < l8)) {
        break label1244;
      }
    }
    label702:
    label732:
    label1228:
    label1236:
    label1244:
    for (int i = 0;; i = 1)
    {
      String str3 = (String)arrayOfObject[2];
      int m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject5 = new SimpleDateFormat("MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()));
      StringBuilder localStringBuilder = new StringBuilder("双发结果:").append("发了第").append(m).append("张").append("\n");
      localStringBuilder.append("时间:").append((String)localObject5).append("\n");
      localStringBuilder.append("图片大小:").append(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long).append("bytes\n");
      localObject5 = localStringBuilder.append("老通道传输:").append(l8).append("ms,").append("速度:");
      if (l8 == 0L) {
        j = 0;
      }
      ((StringBuilder)localObject5).append(j).append("kbps").append("\n");
      localObject5 = localStringBuilder.append("新通道传输:").append(l1).append("ms,").append("速度:");
      if (l1 == 0L)
      {
        j = 0;
        ((StringBuilder)localObject5).append(j).append("kbps").append("\n");
        if (i == 0) {
          break label1228;
        }
        localObject5 = "结果:新通道传输较快\n";
        localStringBuilder.append((String)localObject5);
        localStringBuilder.append("老通道 Step:").append("申请").append(l5).append("ms_").append("传输").append(l7).append("ms_").append("消息").append(l6).append("ms").append("\n");
        localStringBuilder.append("新通道 Step:").append("申请").append(l2).append("ms_").append("传输").append(l4).append("ms_").append("消息").append(l3).append("ms").append("\n");
        localStringBuilder.append("群图Info:").append("接入:").append(arrayOfObject[3]).append("ms;").append("架平:").append(arrayOfObject[4]).append("ms").append("\n");
        localStringBuilder.append("新通道info:").append("接入:").append((String)localObject4).append("ms;").append("架平:").append(str1).append("ms").append("\n");
        localObject4 = localStringBuilder.append("Channel:");
        if (this.bm != 1) {
          break label1236;
        }
      }
      for (str1 = "Tcp";; str1 = "Http")
      {
        ((StringBuilder)localObject4).append(str1).append("\n");
        localStringBuilder.append("网络:").append((String)localObject3).append("\n");
        localStringBuilder.append("Host:").append((String)localObject2).append("\n");
        localStringBuilder.append("连接数:").append((String)localObject1).append("\n");
        localObject1 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str3, str3, 1, (byte)1, (byte)0, (short)0, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, null);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_c2cSpeed", String.valueOf(l1));
        ((HashMap)localObject1).put("param_grpSpeed", String.valueOf(l8));
        ((HashMap)localObject1).put("param_c2cInfo", paramString);
        ((HashMap)localObject1).put("param_grpInfo", str2);
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actSFResult", paramBoolean, l1, this.jdField_a_of_type_Long, (HashMap)localObject1, "");
        return;
        l1 = this.jdField_g_of_type_Long;
        long l9 = this.jdField_h_of_type_Long;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        str1 = String.valueOf(l9);
        localObject4 = null;
        break;
        j = k;
        break label702;
        localObject5 = "结果:老通道传输较快\n";
        break label732;
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      Object localObject = new CSDataHighwayHead.PicRspExtInfo();
      try
      {
        ((CSDataHighwayHead.PicRspExtInfo)localObject).mergeFrom(paramArrayOfByte);
        if (((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.has())
        {
          paramArrayOfByte = ((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.get().toByteArray();
          localObject = new byte[paramArrayOfByte.length];
          System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> byte_skey.length:" + paramArrayOfByte.length);
          }
          Cryptor localCryptor = new Cryptor();
          if (this.jdField_d_of_type_ArrayOfByte != null)
          {
            localObject = localCryptor.decrypt((byte[])localObject, 0, paramArrayOfByte.length, this.jdField_d_of_type_ArrayOfByte);
            if ((localObject != null) && (localObject.length > 36))
            {
              if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> result.length:" + localObject.length);
              }
              paramArrayOfByte = new byte[localObject.length];
              System.arraycopy(localObject, 0, paramArrayOfByte, 0, localObject.length);
              int j = ByteBuffer.wrap(paramArrayOfByte).getShort(34);
              localObject = new char[j];
              while (i < j)
              {
                localObject[i] = ((char)paramArrayOfByte[(i + 36)]);
                i += 1;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, paramArrayOfByte.getMessage());
          }
        }
        paramArrayOfByte = String.valueOf((char[])localObject);
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> fileId_str:" + paramArrayOfByte);
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_i_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_h_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_j_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_i_of_type_JavaLangString = paramArrayOfByte;
      }
    }
  }
  
  private byte[] a()
  {
    this.jdField_d_of_type_ArrayOfByte = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getSessionKey();
    if ((this.jdField_d_of_type_ArrayOfByte == null) || (this.jdField_d_of_type_ArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> sessionKey is null ");
      }
    }
    byte[] arrayOfByte;
    do
    {
      long l1;
      long l2;
      int i;
      int j;
      for (;;)
      {
        return null;
        this.jdField_e_of_type_ArrayOfByte = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getHttpconn_sig_session();
        if ((this.jdField_e_of_type_ArrayOfByte == null) || (this.jdField_e_of_type_ArrayOfByte.length == 0))
        {
          if (QLog.isColorLevel())
          {
            QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> signature is null ");
            return null;
          }
        }
        else {
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).longValue();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
            Object localObject1 = localObject2;
            if (((String)localObject2).startsWith("+")) {
              localObject1 = ((String)localObject2).substring(1);
            }
            l2 = Long.valueOf((String)localObject1).longValue();
            i = (int)this.jdField_a_of_type_Long;
            j = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = this.jdField_a_of_type_ArrayOfByte;
            if ((localObject1 == null) || (localObject1.length == 0))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("C2CPicUploadProcessor", 2, "md5 is null ");
              return null;
            }
          }
          catch (Exception localException)
          {
            QLog.e("C2CPicUploadProcessor", 2, "makeOpenUpTicket error", localException);
            return null;
          }
        }
      }
      localObject2 = ByteBuffer.allocate(localException.length + 56 + 8);
      ((ByteBuffer)localObject2).putInt(0, 1).putLong(4, l1).putLong(12, l2).putInt(20, i).putInt(24, j);
      localObject2 = ((ByteBuffer)localObject2).array();
      System.arraycopy(localException, 0, localObject2, 28, localException.length);
      arrayOfByte = new Cryptor().encrypt((byte[])localObject2, this.jdField_d_of_type_ArrayOfByte);
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CPicUploadProcessor", 2, "ukey is null ");
    return null;
    Object localObject2 = new CSDataHighwayHead.NewServiceTicket();
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_ukey.set(ByteStringMicro.copyFrom(arrayOfByte));
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_e_of_type_ArrayOfByte));
    return ((CSDataHighwayHead.NewServiceTicket)localObject2).toByteArray();
  }
  
  private byte[] b()
  {
    int j = 6;
    int k = 3;
    CSDataHighwayHead.PicInfoExt localPicInfoExt = new CSDataHighwayHead.PicInfoExt();
    localPicInfoExt.uint32_busi_type.set(1);
    localPicInfoExt.uint32_src_term.set(5);
    localPicInfoExt.uint32_plat_type.set(9);
    int i = j;
    switch (NetworkCenter.a().a())
    {
    default: 
      i = j;
    case 2: 
      Object localObject = NetworkCenter.a().a();
      j = i;
      if (localObject != null)
      {
        j = i;
        if (((String)localObject).contains("wap")) {
          j = 5;
        }
      }
      localPicInfoExt.uint32_net_type.set(j);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localObject)) {
        localPicInfoExt.uint32_img_type.set(((MessageForPic)localObject).imageType);
      }
      localPicInfoExt.uint32_app_pic_type.set(1);
      localPicInfoExt.uint32_pic_width.set(this.aM);
      localPicInfoExt.uint32_pic_height.set(this.aN);
      if (!this.l) {
        break;
      }
    }
    for (i = k;; i = 1)
    {
      localPicInfoExt.uint32_pic_flag.set(i);
      return localPicInfoExt.toByteArray();
      i = 3;
      break;
      i = 7;
      break;
      i = 8;
      break;
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new vae(this));
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = System.nanoTime();
    localFileMsg.jdField_i_of_type_Long = l;
    this.jdField_d_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_j_of_type_Long = 0L;
  }
  
  public void J_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    }
    while (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    }
    byte[] arrayOfByte = HexUtil.a(this.jdField_j_of_type_JavaLangString);
    vaf localvaf = new vaf(this, SystemClock.uptimeMillis());
    if (this.jdField_f_of_type_Boolean) {}
    for (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 4, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_b_of_type_Long, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte, localvaf, this.aH, this.jdField_c_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);; this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_b_of_type_Long, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, localvaf))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_e_of_type_JavaLangString + " uuid:" + this.jdField_i_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 1);
      }
      if (i == 0) {
        break;
      }
      a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
  }
  
  public int a()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.o = false;
      this.bg = 0;
      this.bf = 0;
      if (this.bm != 1)
      {
        this.jdField_h_of_type_JavaLangString = null;
        this.jdField_i_of_type_JavaLangString = null;
        this.jdField_c_of_type_Long = 0L;
      }
      this.jdField_j_of_type_JavaLangString = null;
      this.jdField_e_of_type_Boolean = false;
      this.be = 0;
      this.aU = 0;
      this.bc = "";
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      w();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new vai(this));
    }
    return 0;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.jdField_c_of_type_Long, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    String str = c();
    if ((str == null) || (str.equals(""))) {
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_d_of_type_JavaLangString = str;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    if (!this.jdField_e_of_type_Boolean)
    {
      paramArrayOfByte = MD5.toMD5(paramArrayOfByte);
      localStringBuilder.append("?ver=");
      localStringBuilder.append("2");
      localStringBuilder.append("&ukey=");
      localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
      localStringBuilder.append("&filekey=");
      localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
      localStringBuilder.append("&filesize=");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("&bmd5");
      localStringBuilder.append(paramArrayOfByte);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("cgi-bin/httpconn?htcmd=0x6ff0070&ver=5345");
      localStringBuilder.append("&ukey=");
      localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
      localStringBuilder.append("&filesize=");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("&uin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("&range=");
      localStringBuilder.append(this.jdField_c_of_type_Long);
    }
  }
  
  public void a()
  {
    d(1000);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    d(1001);
    Object localObject1 = a();
    if ((localObject1 != null) && (((TransferRequest)localObject1).h))
    {
      this.aM = ((TransferRequest)localObject1).l;
      this.aN = ((TransferRequest)localObject1).m;
      this.jdField_a_of_type_Long = ((TransferRequest)localObject1).jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = HexUtil.a(((TransferRequest)localObject1).jdField_f_of_type_JavaLangString);
      this.jdField_f_of_type_JavaLangString = ((TransferRequest)localObject1).jdField_f_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_f_of_type_JavaLangString = (this.jdField_f_of_type_JavaLangString + "." + this.jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().preConnect();
      g();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      a(9041, "No Local MD5");
      b();
      return;
    }
    if ((this.aN == 0) || (this.aM == 0))
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
      this.aN = ((BitmapFactory.Options)localObject1).outHeight;
      this.aM = ((BitmapFactory.Options)localObject1).outWidth;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().preConnect();
    if (this.jdField_f_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mIsOpenUpEnable: " + this.jdField_f_of_type_Boolean);
      }
      this.jdField_b_of_type_ArrayOfByte = a();
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead = a();
      this.jdField_c_of_type_ArrayOfByte = b();
      if ((this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.jdField_b_of_type_ArrayOfByte + " mLoginSigHead:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);
        }
        g();
        J_();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> set mIsOpenUpEnable false");
      }
      this.jdField_f_of_type_Boolean = false;
      g();
      return;
    }
    g();
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.o) || (this.jdField_k_of_type_Boolean)) {}
    for (;;)
    {
      return;
      a("onResp", "result:" + paramNetResp.jdField_e_of_type_Int + " errCode:" + paramNetResp.f + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      int i = paramNetResp.g;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      long l3;
      for (;;)
      {
        try
        {
          if (paramNetResp.jdField_e_of_type_Int != 0) {
            break label632;
          }
          this.aW = 0;
          this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
          if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null)
          {
            l3 = Long.MAX_VALUE;
            if ((l3 == 0L) || (l3 == Long.MAX_VALUE)) {
              break;
            }
            a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
            if (C2CPicUpHandler.a((int)l3)) {
              break;
            }
            a(56009, null, b(i, l3), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
            b();
            return;
          }
        }
        catch (Exception paramNetResp)
        {
          a(9343, MsfSdkUtils.getStackTraceString(new Exception("decode unknown exception")), "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          b();
          return;
        }
        l3 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
      }
      long l1;
      long l2;
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null)
      {
        l1 = Long.MAX_VALUE;
        l2 = l1;
        if (l1 == Long.MAX_VALUE)
        {
          Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
          l2 = l1;
          if (localObject == null) {}
        }
      }
      try
      {
        i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range"));
        l2 = i;
        if (l2 == Long.MAX_VALUE)
        {
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
          a(56009, "no header range", a(this.bb, this.aR), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          b();
          return;
          try
          {
            i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
            l1 = i;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            l1 = Long.MAX_VALUE;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          l2 = Long.MAX_VALUE;
        }
        a("decodeHttpResp", "from " + this.jdField_c_of_type_Long + " to " + l2 + " userReturnCode:" + l3);
        if (l2 <= this.jdField_c_of_type_Long)
        {
          if (this.bg < 3)
          {
            a("procHttpRespBody", "server offset rollback");
            this.bg += 1;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = l2;
          this.jdField_c_of_type_Long = l2;
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
          if (l2 >= this.jdField_a_of_type_Long) {
            break label620;
          }
          if (this.o) {
            continue;
          }
          h();
          s();
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l3);
        a(56009, "", a(this.bb, this.aQ), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
        label620:
        t();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
    }
    label632:
    if ((paramNetResp.f == 9364) && (this.aW < 3))
    {
      a("[netChg]", "failed.but net change detect.so retry");
      this.aW += 1;
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      q();
      g();
      return;
    }
    if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ArrayOfByte.length >= 32768) && (RichMediaStrategy.a(paramNetResp.f)))
    {
      this.jdField_b_of_type_Boolean = true;
      q();
      s();
      return;
    }
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    a(paramNetResp.f, paramNetResp.jdField_a_of_type_JavaLangString);
    b();
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    Object localObject;
    String str;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_j_of_type_Boolean = paramRichProtoReq.jdField_e_of_type_Boolean;
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
          break label631;
        }
        d(1002);
        if (paramRichProtoReq.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp picUpResp.isExist.");
          }
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
          localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
          str = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          ((FileMsg)localObject).jdField_i_of_type_JavaLangString = str;
          this.jdField_h_of_type_JavaLangString = str;
          localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
          paramRichProtoReq = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          ((FileMsg)localObject).jdField_j_of_type_JavaLangString = paramRichProtoReq;
          this.jdField_i_of_type_JavaLangString = paramRichProtoReq;
          if (this.jdField_f_of_type_Boolean) {
            if ((!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) || (!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()))
            {
              this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
              t();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            t();
          }
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h) {
          break label258;
        }
        a(9333, "Server MD5 fast forward missed");
        b();
      }
    }
    label258:
    label469:
    label631:
    do
    {
      do
      {
        return;
      } while ((this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()));
      if (!this.jdField_f_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
        str = paramRichProtoReq.jdField_a_of_type_JavaLangString;
        ((FileMsg)localObject).jdField_i_of_type_JavaLangString = str;
        this.jdField_h_of_type_JavaLangString = str;
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
        str = paramRichProtoReq.jdField_b_of_type_JavaLangString;
        ((FileMsg)localObject).jdField_j_of_type_JavaLangString = str;
        this.jdField_i_of_type_JavaLangString = str;
      }
      boolean bool;
      for (;;)
      {
        this.jdField_j_of_type_JavaLangString = paramRichProtoReq.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_e_of_type_Boolean = paramRichProtoReq.jdField_b_of_type_Boolean;
        bool = paramRichProtoReq.jdField_d_of_type_Boolean;
        this.jdField_b_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
        if ((paramRichProtoReq.jdField_a_of_type_Int != 0) && (this.jdField_c_of_type_Boolean) && (!paramRichProtoReq.jdField_c_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(paramRichProtoReq.jdField_a_of_type_Int);
        }
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
        }
        if (this.bm != 2) {
          break label469;
        }
        c("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
        s();
        break;
        this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
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
          if (this.jdField_f_of_type_Boolean)
          {
            if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction == null) {
              break;
            }
            this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.continueTrans();
            this.jdField_f_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
            break;
          }
          J_();
          break;
        }
        c("<BDH_LOG> onBusiProtoResp() select HTTP channel");
        this.bm = 2;
        s();
        if (!this.jdField_f_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
        break;
      }
      localObject = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
      if (this.bm == 1) {}
      for (paramRichProtoReq = "BDH";; paramRichProtoReq = "HTTP")
      {
        c(paramRichProtoReq);
        break;
      }
      c("<BDH_LOG> onBusiProtoResp() error : " + paramRichProtoReq.jdField_c_of_type_Int + " ,select HTTP channel");
      this.bm = 2;
    } while ((this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()));
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().cancelTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
    b();
  }
  
  protected void a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (this.bl == 1)
      {
        this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Int = 1;
        bool = true;
      }
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
    Object localObject = this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(21) + ";" + this.jdField_f_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(22);
    if (QLog.isColorLevel())
    {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> stepParam: " + str2);
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> openUpSetpParam: " + (String)localObject);
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mStepUrl: " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";" + "mStepTrans: " + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";" + "mStepMsg: " + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";" + "mStepTransPre: " + this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";" + "mStepTransLeft: " + this.jdField_f_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";");
    }
    if (!bool)
    {
      if (this.aU == 9004) {
        break label350;
      }
      if (g()) {}
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1030) {}
    label350:
    while (((!bool) && (RichMediaStrategy.c(this.aU))) || (this.jdField_i_of_type_Boolean) || ((bool) && ((this.aX & 0x2) > 0)) || ((!bool) && ((this.aX & 0x1) > 0)))
    {
      return;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
      if ("connError_unreachable".equalsIgnoreCase(str1))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
        break;
      }
      if (!"connError_noroute".equalsIgnoreCase(str1)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_2");
      break;
    }
    int j = this.aX;
    int i;
    if (bool)
    {
      i = 2;
      this.aX = (i | j);
      if (this.bm != 1) {
        break label1387;
      }
    }
    label622:
    label1233:
    label1387:
    for (String str1 = "actC2CPicUploadV2";; str1 = "actC2CPicUploadV1")
    {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      long l3 = System.nanoTime();
      long l2 = (l3 - this.jdField_d_of_type_Long) / 1000000L;
      Log.i("AutoMonitor", "SendC2CPic, cost=" + (this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long - this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long) / 1000000L);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_openUpStep", localObject);
      localObject = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_h_of_type_JavaLangString == null)
      {
        str2 = this.jdField_i_of_type_JavaLangString;
        ((HashMap)localObject).put("param_uuid", str2);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_d_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", StatisticConstants.a() + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", NetworkUtil.a(BaseApplication.getContext()) + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.l + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.bk));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_openUp", String.valueOf(this.jdField_f_of_type_Boolean));
        if (!bool) {
          break label1233;
        }
        e();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean)
        {
          long l1 = 0L;
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
            QLog.d("C2CPicUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_d_of_type_Long + ",mEnterAioTime = " + this.jdField_k_of_type_Long + ",finishTime  = " + l3 + ", aioDuration = " + l1 + ", duration = " + l2 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_j_of_type_Boolean + ",Percent = " + d1);
          }
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      for (;;)
      {
        p();
        return;
        i = 1;
        break;
        str2 = this.jdField_h_of_type_JavaLangString;
        break label622;
        if (this.aU != 56009) {
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
        StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
    }
  }
  
  boolean a(int paramInt)
  {
    return false;
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
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          a("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            a("updateDb", "is multiMsg");
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).size = this.jdField_a_of_type_Long;
            if (this.jdField_h_of_type_JavaLangString == null) {}
            for (str = this.jdField_i_of_type_JavaLangString;; str = this.jdField_h_of_type_JavaLangString)
            {
              ((MessageForPic)localObject).uuid = str;
              ((MessageForPic)localObject).serial();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
              return;
            }
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localStructMsgItemImage == null);
    localStructMsgItemImage.q = this.jdField_e_of_type_JavaLangString;
    if (this.jdField_h_of_type_JavaLangString == null) {}
    for (String str = this.jdField_i_of_type_JavaLangString;; str = this.jdField_h_of_type_JavaLangString)
    {
      localStructMsgItemImage.p = str;
      localStructMsgItemImage.jdField_d_of_type_Long = this.jdField_a_of_type_Long;
      localStructMsgItemImage.jdField_e_of_type_Long = localMessageRecord.time;
      ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
      return;
    }
  }
  
  public int c()
  {
    Object localObject = a();
    if ((localObject != null) && (((TransferRequest)localObject).h))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo))) {
        this.l = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
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
    long l = localFile.length();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Long = l;
    if (l <= 0L)
    {
      a(9071, a(new Exception("file size 0 " + (String)localObject)));
      b();
      return -1;
    }
    localObject = FileUtils.a((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((((String)localObject).contains(FileUtils.jdField_i_of_type_JavaLangString)) || (!FileUtils.f((String)localObject)))
      {
        a(9072, (String)localObject, c((String)localObject), null);
        b();
        new Handler(Looper.getMainLooper()).post(new vad(this));
        return -1;
      }
      this.jdField_g_of_type_JavaLangString = ((String)localObject);
    }
    if (l >= 19922944L)
    {
      a(9063, (String)localObject, c((String)localObject), null);
      b();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo))) {
      this.l = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  String c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
      return "";
    }
    int i = this.bf;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(i % j);
    String str = "http://" + localServerAddr.jdField_a_of_type_JavaLangString;
    if (localServerAddr.jdField_b_of_type_Int != 80) {
      str = str + ":" + localServerAddr.jdField_b_of_type_Int;
    }
    for (;;)
    {
      return str + "/";
    }
  }
  
  public void c()
  {
    super.c();
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      if (this.jdField_h_of_type_JavaLangString == null)
      {
        str = this.jdField_i_of_type_JavaLangString;
        localSendResult.jdField_c_of_type_JavaLangString = str;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
      return;
      str = this.jdField_h_of_type_JavaLangString;
      break;
      b(true);
    }
  }
  
  void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localPicUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localPicUpReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localPicUpReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localPicUpReq.jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    localPicUpReq.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localPicUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localPicUpReq.jdField_c_of_type_Int = this.aM;
    localPicUpReq.jdField_d_of_type_Int = this.aN;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localPicUpReq.jdField_c_of_type_Boolean = bool;
      localPicUpReq.jdField_b_of_type_Boolean = this.l;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPicUpReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localPicUpReq.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
        this.bk = ((MessageForPic)localMessageRecord).imageType;
      }
      if (d()) {
        break label243;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
    }
    label243:
    do
    {
      return;
      bool = false;
      break;
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
  
  public void s()
  {
    long l1 = 14600L;
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    long l4 = this.jdField_c_of_type_Long;
    long l2 = this.jdField_a_of_type_Long - l4;
    if (!this.jdField_b_of_type_Boolean)
    {
      long l3 = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.jdField_c_of_type_Long, -1);
      l1 = l3;
      if (l2 < l3) {
        l1 = l2;
      }
    }
    Object localObject2;
    do
    {
      byte[] arrayOfByte;
      for (;;)
      {
        l1 = Math.min(l1, 131072L);
        arrayOfByte = a((int)l4, (int)l1);
        if (arrayOfByte != null) {
          break;
        }
        b();
        return;
        if (l2 < 14600L) {
          l1 = this.jdField_a_of_type_Long - l4;
        }
      }
      a("sendingdata", "pos:" + l4 + "  transferData len:" + arrayOfByte.length);
      localObject2 = a(arrayOfByte);
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = a((String)localObject2, this.jdField_a_of_type_JavaUtilArrayList);
        BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      }
      localObject2 = new HttpNetReq();
      ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((HttpNetReq)localObject2).jdField_c_of_type_Int = 1;
      ((HttpNetReq)localObject2).jdField_a_of_type_ArrayOfByte = arrayOfByte;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((HttpNetReq)localObject2).jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      ((HttpNetReq)localObject2).o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      ((HttpNetReq)localObject2).n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      ((HttpNetReq)localObject2).jdField_f_of_type_Boolean = true;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + this.jdField_c_of_type_Long + "-");
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      ((HttpNetReq)localObject2).jdField_c_of_type_Boolean = true;
      if (l4 + l1 >= this.jdField_a_of_type_Long) {
        ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject2);
  }
  
  public void t()
  {
    if (!e())
    {
      c("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.bm);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).DSKey != 0L))
    {
      c();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    d(1003);
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_c_of_type_Long;
      }
      localObject1 = a();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
      }
      c();
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label471;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label444;
      }
    }
    label444:
    for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      break;
    }
    label471:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void u()
  {
    if (this.o) {
      return;
    }
    if ((this.jdField_h_of_type_JavaLangString != null) || (this.jdField_i_of_type_JavaLangString != null))
    {
      if (this.jdField_c_of_type_Long >= this.jdField_a_of_type_Long)
      {
        t();
        return;
      }
      v();
      return;
    }
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\C2CPicUploadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */