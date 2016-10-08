package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.ptt.PttSSCMPool;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeParams.IOnCompressFinish;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.TmpPtt;
import vak;

public class C2CPttUploadProcessor
  extends BaseUploadProcessor
  implements INetEventHandler, VoiceChangeParams.IOnCompressFinish
{
  public static final String d = "C2CPicUploadProcessor";
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean f;
  private boolean g;
  String k;
  private long l;
  private long m;
  
  public C2CPttUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vak(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM = PttSSCMPool.a();
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  private byte[] a()
  {
    Object localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    byte[] arrayOfByte1 = a((MessageForPtt)localObject);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 3 + 15];
    arrayOfByte2[0] = 3;
    arrayOfByte2[1] = 8;
    byte[] arrayOfByte3 = PkgTools.a((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 2, arrayOfByte3.length);
    int i = arrayOfByte3.length + 2;
    arrayOfByte3 = PkgTools.c(((MessageForPtt)localObject).voiceType);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, arrayOfByte3.length);
    i += arrayOfByte3.length;
    arrayOfByte2[i] = 9;
    i += 1;
    arrayOfByte3 = PkgTools.a((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, 2);
    i += arrayOfByte3.length;
    localObject = PkgTools.c(Utils.a(((MessageForPtt)localObject).voiceLength));
    System.arraycopy(localObject, 0, arrayOfByte2, i, localObject.length);
    i = localObject.length + i;
    arrayOfByte2[i] = 10;
    i += 1;
    localObject = PkgTools.a((short)arrayOfByte1.length);
    System.arraycopy(localObject, 0, arrayOfByte2, i, 2);
    i += localObject.length;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i, arrayOfByte1.length);
    i = arrayOfByte1.length;
    return arrayOfByte2;
  }
  
  private byte[] a(MessageForPtt paramMessageForPtt)
  {
    ptt_reserve.ReserveStruct localReserveStruct = new ptt_reserve.ReserveStruct();
    localReserveStruct.uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
    return localReserveStruct.toByteArray();
  }
  
  private void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      b();
      return;
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
    MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
    int i;
    if (localMessageForPtt == null)
    {
      i = 0;
      if (localMessageForPtt != null) {
        break label155;
      }
    }
    label155:
    for (long l1 = 0L;; l1 = localMessageForPtt.fileSize)
    {
      PttInfoCollector.a(str, false, false, i, l1);
      g();
      return;
      i = localMessageForPtt.voiceChangeFlag;
      break;
    }
  }
  
  private int h()
  {
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
    if ((str == null) || ("".equals(str)))
    {
      a(9302, a(new Exception("filePath null")));
      b();
      return -1;
    }
    if (str != null)
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        a(9042, a(new Exception("sendFile not exist " + str)));
        b();
        return -1;
      }
      if (!localFile.canRead())
      {
        a(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString)));
        b();
        return -1;
      }
      this.jdField_g_of_type_JavaLangString = "amr";
      long l1 = localFile.length();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Long = l1;
      if (l1 <= 0L)
      {
        a(9071, a(new Exception("file size 0 " + str)));
        b();
        return -1;
      }
    }
    return 0;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.o))
    {
      h();
      s();
    }
    return super.a();
  }
  
  protected long a(long paramLong)
  {
    long l1;
    if (!PttOptimizeParams.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      l1 = this.jdField_a_of_type_Long;
      paramLong = Math.min(this.jdField_j_of_type_Long, l1 - paramLong);
      return paramLong;
    }
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.jdField_b_of_type_Boolean)
    {
      l1 = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.jdField_c_of_type_Long, -1);
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "sscm size =" + l1);
      }
    }
    for (paramLong = Math.min(paramLong, l1);; paramLong = Math.min(paramLong, 14600L))
    {
      l1 = Math.min(paramLong, 131072L);
      paramLong = l1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("C2CPicUploadProcessor", 2, "real sscm size=" + l1);
      return l1;
    }
  }
  
  protected HttpNetReq a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = super.a(paramArrayOfByte);
    paramArrayOfByte.c = true;
    return paramArrayOfByte;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.b != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localServerAddr.b);
    }
    localStringBuilder.append("/?ver=");
    localStringBuilder.append(2);
    localStringBuilder.append("&ukey=");
    localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
    localStringBuilder.append("&filekey=");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("&filesize=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("&bmd5=");
    localStringBuilder.append(MD5.toMD5(paramArrayOfByte));
    localStringBuilder.append("&range=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    paramArrayOfByte = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    localStringBuilder.append("&voice_codec=" + paramArrayOfByte.voiceType);
    paramArrayOfByte = a(localStringBuilder.toString(), this.jdField_a_of_type_JavaUtilArrayList);
    BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
    return paramArrayOfByte;
  }
  
  protected im_msg_body.RichText a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 0)
      {
        localObject1 = new im_msg_body.Ptt();
        ((im_msg_body.Ptt)localObject1).uint32_file_type.set(4);
        ((im_msg_body.Ptt)localObject1).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b));
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject2 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.Ptt)localObject1).uint32_server_ip.set(GroupPicUploadProcessor.a(((ServerAddr)localObject2).jdField_a_of_type_JavaLangString));
          ((im_msg_body.Ptt)localObject1).uint32_server_port.set(((ServerAddr)localObject2).b);
        }
        i = MessageUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject2 = new im_msg_body.Elem();
        Object localObject3 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject3).uint32_vip_status.set(i);
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject3);
        ((im_msg_body.Ptt)localObject1).bool_valid.set(true);
        ((im_msg_body.Ptt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.h));
        ((im_msg_body.Ptt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        ((im_msg_body.Ptt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
        ((im_msg_body.Ptt)localObject1).uint32_file_size.set((int)this.jdField_a_of_type_Long);
        localObject3 = a();
        if (localObject3 != null) {
          ((im_msg_body.Ptt)localObject1).bytes_reserve.set(ByteStringMicro.copyFrom((byte[])localObject3));
        }
        localObject3 = new im_msg_body.RichText();
        ((im_msg_body.RichText)localObject3).ptt.set((MessageMicro)localObject1);
        ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
        return (im_msg_body.RichText)localObject3;
      }
      Object localObject1 = new im_msg_body.TmpPtt();
      ((im_msg_body.TmpPtt)localObject1).uint32_file_type.set(4);
      ((im_msg_body.TmpPtt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.h));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
      ((im_msg_body.TmpPtt)localObject1).uint32_file_size.set((int)this.jdField_a_of_type_Long);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      int i = MessageUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
      ((im_msg_body.TmpPtt)localObject1).uint32_user_type.set(i);
      ((im_msg_body.TmpPtt)localObject1).uint64_ptt_times.set(QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1008) {
        ((im_msg_body.TmpPtt)localObject1).uint32_busi_type.set(3);
      }
      localObject2 = a((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      if (localObject2 != null) {
        ((im_msg_body.TmpPtt)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).tmp_ptt.set((MessageMicro)localObject1);
      return (im_msg_body.RichText)localObject2;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error");
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.l)
    {
      if (VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, this)) {
        try
        {
          if (this.jdField_f_of_type_Boolean)
          {
            d(1001);
            this.jdField_f_of_type_Boolean = true;
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
  
  public void a(NetResp paramNetResp)
  {
    Object localObject1 = null;
    super.a(paramNetResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    int i = paramNetResp.g;
    for (;;)
    {
      long l2;
      try
      {
        if (paramNetResp.jdField_e_of_type_Int != 0) {
          break label611;
        }
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
        if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null) {
          break label730;
        }
        l3 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
        if ((l3 != 0L) && (l3 != Long.MAX_VALUE))
        {
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
          a(56009, null, b(i, l3), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          b();
          return;
        }
        str2 = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range");
        if (str2 == null) {
          break label738;
        }
      }
      catch (Exception paramNetResp)
      {
        String str2;
        String str1;
        a(9343, AbstractImageDownloader.a(new Exception("decode unknown exception")), "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      try
      {
        i = Integer.parseInt(str2);
        l1 = i;
        l2 = l1;
        if (l1 == Long.MAX_VALUE)
        {
          str1 = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
          localObject1 = str1;
          l2 = l1;
          if (str1 == null) {}
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      label422:
      label466:
      label506:
      try
      {
        i = Integer.parseInt(str1);
        l2 = i;
        localObject1 = str1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        l2 = Long.MAX_VALUE;
        localObject2 = localException2;
        continue;
        a("decodeHttpResp", "from " + this.jdField_c_of_type_Long + " to " + l2 + " userReturnCode:" + l3);
        if (l2 > this.jdField_c_of_type_Long) {
          break label422;
        }
        if (this.bg >= 3) {
          break label466;
        }
        a("procHttpRespBody", "server offset rollback");
        this.bg += 1;
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = l2;
        this.jdField_c_of_type_Long = l2;
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
        if (l2 >= this.jdField_a_of_type_Long) {
          break label506;
        }
        h();
        J_();
        return;
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        a(56009, "", a(this.bb, this.aQ), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      if (l2 == Long.MAX_VALUE)
      {
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        a(56009, "no header range:" + str2 + " x-range:" + (String)localObject1, a(this.bb, this.aR), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        PttInfoCollector.b(true);
        b();
        return;
      }
      for (;;)
      {
        try
        {
          Object localObject2;
          if ((!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.o))
          {
            h();
            s();
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d(PttPreSendManager.jdField_a_of_type_JavaLangString, 4, "presend file success, can send msg, direct send");
              }
              PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(a());
            }
            return;
          }
        }
        finally {}
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.o = true;
        if (QLog.isDevelopLevel()) {
          QLog.d(PttPreSendManager.jdField_a_of_type_JavaLangString, 4, "presend file success, wait for send msg");
        }
      }
      label611:
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
        J_();
        return;
      }
      a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
      a(paramNetResp.f, paramNetResp.jdField_a_of_type_JavaLangString);
      b();
      return;
      label730:
      long l3 = Long.MAX_VALUE;
      continue;
      label738:
      long l1 = Long.MAX_VALUE;
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    int i;
    if (paramRichProtoResp != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPttUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_j_of_type_Boolean = paramRichProtoReq.e;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_j_of_type_Boolean);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.h = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            try
            {
              if ((!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.o))
              {
                s();
                if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean)
                {
                  if (QLog.isDevelopLevel()) {
                    QLog.d(PttPreSendManager.jdField_a_of_type_JavaLangString, 4, "upResp.isExist, can send msg, direct send");
                  }
                  PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(a());
                }
              }
              for (;;)
              {
                break;
                if (QLog.isDevelopLevel()) {
                  QLog.d(PttPreSendManager.jdField_a_of_type_JavaLangString, 4, "upResp.isExist, can't send msg, wait can send");
                }
                this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.o = true;
              }
              this.h = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            }
            finally {}
          }
          this.jdField_j_of_type_JavaLangString = paramRichProtoReq.b;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_c_of_type_Long = 0L;
          this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Int;
          J_();
        }
        else
        {
          b();
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   6: iconst_1
    //   7: putfield 536	com/tencent/mobileqq/transfile/TransferRequest:l	Z
    //   10: aload_0
    //   11: getfield 84	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   14: getfield 89	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 91	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 116	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 109	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 543	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:jdField_f_of_type_Boolean	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokespecial 545	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:h	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokespecial 547	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:d	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokespecial 545	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:h	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokespecial 547	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:d	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	C2CPttUploadProcessor
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
    PttSSCMPool.a(this.jdField_a_of_type_ComTencentWsttSSCMSSCM);
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aU))) {}
    while ((this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int j = this.aX;
    int i;
    long l2;
    Object localObject1;
    label215:
    label412:
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.aX = (i | j);
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      l2 = (System.nanoTime() - this.d) / 1000000L;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(this.d);
        this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(this.d);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.h != null) {
        break label475;
      }
      localObject1 = this.jdField_i_of_type_JavaLangString;
      ((HashMap)localObject2).put("param_uuid", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(PttOptimizeParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_pttNetDown", String.valueOf(this.l / 1000000L));
        if (QLog.isColorLevel()) {
          QLog.d("weak_net", 2, String.valueOf(this.l / 1000000L));
        }
      }
      PttInfoCollector.a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, l2, this.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString))
      {
        localObject1 = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
        if (localObject1 != null) {
          break label483;
        }
        i = 0;
        if (localObject1 != null) {
          break label492;
        }
        l1 = 0L;
        label419:
        PttInfoCollector.a((String)localObject2, true, paramBoolean, i, l1);
      }
      if (!paramBoolean) {
        break label501;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CPttUpload", true, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      p();
      AppNetConnInfo.unregisterNetEventHandler(this);
      return;
      i = 1;
      break;
      label475:
      localObject1 = this.h;
      break label215;
      label483:
      i = ((MessageForPtt)localObject1).voiceChangeFlag;
      break label412;
      label492:
      l1 = ((MessageForPtt)localObject1).fileSize;
      break label419;
      label501:
      if (this.aU != 56009) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CPttUpload", false, l2, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void b()
  {
    super.b();
    d(1005);
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
    while (!(localMessageRecord instanceof MessageForPtt))
    {
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      a("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)localMessageRecord;
    if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) {
      localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString);
    }
    localMessageForPtt.fileSize = this.jdField_a_of_type_Long;
    localMessageForPtt.urlAtServer = this.h;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForPtt.msgData);
  }
  
  public int c()
  {
    super.c();
    if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.l) {
      return 0;
    }
    return h();
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.l) {
      return super.c();
    }
    return 7000L;
  }
  
  public void c()
  {
    super.c();
    b(true);
    d(1003);
  }
  
  void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PttUpReq localPttUpReq = new RichProto.RichProtoReq.PttUpReq();
    localPttUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b;
    localPttUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localPttUpReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localPttUpReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localPttUpReq.jdField_a_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    localPttUpReq.b = ((int)this.jdField_a_of_type_Long);
    localPttUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    localPttUpReq.jdField_c_of_type_Int = localMessageForPtt.voiceType;
    localPttUpReq.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Int;
    localPttUpReq.jdField_a_of_type_Int = localMessageForPtt.voiceLength;
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_ptt_up";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPttUpReq);
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
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.m > 0L) {
        this.l += System.nanoTime() - this.m;
      }
    }
    for (this.m = 0L;; this.m = System.nanoTime())
    {
      this.jdField_g_of_type_Boolean = true;
      return;
    }
  }
  
  protected void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
    }
  }
  
  void s()
  {
    if (!e()) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    im_msg_body.RichText localRichText = a();
    if (localRichText == null)
    {
      a(9360, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    }
    while (!(localMessageRecord instanceof MessageForPtt))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("accost_ptt", 4, "mr not ptt?......");
      }
      a(9360, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      a("updateDb", "findmsgbyMsgId,need fix");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("accost_ptt", 4, "mr is ptt......");
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)localMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "<---sendC2CMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
    }
    localMessageForPtt.richText = localRichText;
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\C2CPttUploadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */