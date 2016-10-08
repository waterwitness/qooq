package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShortVideoTransManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoForwardReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.ShortVideoUpHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;
import vbq;
import vbu;

public class ShortVideoForwardProcessor
  extends BaseUploadProcessor
{
  public static final String d = "ShortVideoForwardProcessor";
  public static final String k = "QQ_&_MoblieQQ_&_QQ";
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ShortVideoTransManager a;
  protected ShortVideoUpInfo a;
  protected int aH;
  protected int aI;
  protected int aJ;
  int aK;
  int aL;
  protected RandomAccessFile b;
  protected byte[] b;
  private String bl;
  private int bn;
  private byte[] c;
  private byte[] d;
  boolean f;
  protected long l;
  protected String l;
  protected long m;
  private long n;
  
  public ShortVideoForwardProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.aK = -1;
    this.aL = 0;
    this.f = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vbu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
    String[] arrayOfString;
    for (this.aK = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; this.aK = 0)
    {
      paramTransFileController = paramTransferRequest.jdField_i_of_type_JavaLangString;
      arrayOfString = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
      if (4 == arrayOfString.length) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
      }
      a(9304, "path =" + paramTransFileController);
      b();
      this.o = true;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "init ShortVideoForwardProcessor=> " + Arrays.toString(arrayOfString));
    }
    paramTransferRequest.jdField_i_of_type_JavaLangString = arrayOfString[0];
    this.jdField_l_of_type_JavaLangString = arrayOfString[1];
    this.aJ = Integer.parseInt(arrayOfString[2]);
    this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(arrayOfString[3]);
  }
  
  private RichProto.RichProtoReq.ShortVideoForwardReq a()
  {
    RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = new RichProto.RichProtoReq.ShortVideoForwardReq();
    localShortVideoForwardReq.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localShortVideoForwardReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoForwardReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoForwardReq.e = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localShortVideoForwardReq.jdField_l_of_type_Int = 0;
    localShortVideoForwardReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoForwardReq.jdField_f_of_type_Int = 2;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof ShortVideoForwardInfo)))
    {
      localObject = (ShortVideoForwardInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
      localShortVideoForwardReq.jdField_a_of_type_Int = ((ShortVideoForwardInfo)localObject).jdField_c_of_type_Int;
      localShortVideoForwardReq.jdField_b_of_type_Int = ((ShortVideoForwardInfo)localObject).jdField_d_of_type_Int;
      localShortVideoForwardReq.jdField_c_of_type_Int = ((ShortVideoForwardInfo)localObject).i;
      localShortVideoForwardReq.jdField_d_of_type_Int = ((ShortVideoForwardInfo)localObject).j;
      this.aK = localShortVideoForwardReq.jdField_c_of_type_Int;
      int i = ((ShortVideoForwardInfo)localObject).n;
      this.aJ = i;
      localShortVideoForwardReq.jdField_k_of_type_Int = i;
      localShortVideoForwardReq.jdField_f_of_type_JavaLangString = ((ShortVideoForwardInfo)localObject).jdField_a_of_type_JavaLangString;
      localShortVideoForwardReq.jdField_a_of_type_JavaLangString = ((ShortVideoForwardInfo)localObject).jdField_k_of_type_JavaLangString;
      localShortVideoForwardReq.j = ((ShortVideoForwardInfo)localObject).p;
      localShortVideoForwardReq.jdField_g_of_type_JavaLangString = ((ShortVideoForwardInfo)localObject).jdField_l_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(localShortVideoForwardReq.j));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResLength", String.valueOf(this.aI));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResWidth", String.valueOf(this.aH));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromChatType", String.valueOf(localShortVideoForwardReq.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toChatType", String.valueOf(localShortVideoForwardReq.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromBusiType", String.valueOf(localShortVideoForwardReq.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toBusiType", String.valueOf(localShortVideoForwardReq.jdField_d_of_type_Int));
      if ((this.bl != null) && (this.bl.length() > 0)) {
        localShortVideoForwardReq.jdField_a_of_type_JavaLangString = this.bl;
      }
      localShortVideoForwardReq.jdField_a_of_type_Long = this.n;
      localShortVideoForwardReq.jdField_b_of_type_Long = this.jdField_l_of_type_Long;
      localShortVideoForwardReq.i = this.aH;
      localShortVideoForwardReq.h = this.aI;
      if (localShortVideoForwardReq.jdField_a_of_type_JavaLangString != null) {
        break label417;
      }
    }
    label417:
    for (Object localObject = "";; localObject = localShortVideoForwardReq.jdField_a_of_type_JavaLangString)
    {
      localShortVideoForwardReq.jdField_a_of_type_JavaLangString = ((String)localObject);
      localShortVideoForwardReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      localShortVideoForwardReq.jdField_b_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      return localShortVideoForwardReq;
      a("sendRequest", "Error => mUiRequest.mExtraObj not ShortVideoForwardInfo");
      return null;
    }
  }
  
  private im_msg_body.RichText a()
  {
    for (;;)
    {
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        if (this.jdField_a_of_type_ArrayOfByte != null) {
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        }
        localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.h));
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoForwardProcessor", 2, "constructRichText(): mResid uuid=" + this.h);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))
        {
          Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (localObject1 != null)
          {
            localVideoFile.uint32_file_format.set(((MessageForShortVideo)localObject1).videoFileFormat);
            localVideoFile.uint32_file_time.set(((MessageForShortVideo)localObject1).videoFileTime);
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).videoFileName));
            localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
            localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
            localVideoFile.uint32_from_chat_type.set(((MessageForShortVideo)localObject1).fromChatType);
            localVideoFile.uint32_to_chat_type.set(((MessageForShortVideo)localObject1).toChatType);
            localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
            localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
            localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          }
          localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
          localVideoFile.uint32_thumb_file_size.set((int)this.jdField_l_of_type_Long);
          localVideoFile.uint32_file_size.set((int)this.n);
          localVideoFile.uint32_thumb_width.set(this.aH);
          localVideoFile.uint32_thumb_height.set(this.aI);
          if ((this.bl != null) && (this.bl.length() > 0)) {
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.bl));
          }
          localVideoFile.uint32_video_attr.set(this.bn);
          Object localObject3 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject3).setHasFlag(true);
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8("你的QQ暂不支持查看视频短片，请期待后续版本。"));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
          localRichText.elems.add((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject3);
          return localRichText;
        }
      }
      catch (Exception localException)
      {
        a("Construct richtext", "Construct richtext error");
        localException.printStackTrace();
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  private void t()
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
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)) || (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)))
    {
      a(9042, "sendFile=> video file not exists");
      b();
      return;
    }
    if ((TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) || (!FileUtils.a(this.jdField_l_of_type_JavaLangString)))
    {
      a(9303, "sendFile=> thumb file not exists");
      b();
      return;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          a(9303, "read video file error");
          b();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          localFileNotFoundException1.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_l_of_type_JavaLangString, "r");
        if (this.jdField_b_of_type_JavaIoRandomAccessFile == null)
        {
          a(9303, "read thumb file error");
          b();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          localFileNotFoundException2.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    super.J_();
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "resume()  + mIsPause : " + this.k);
    }
    if (this.k)
    {
      this.k = false;
      this.o = false;
      d(1002);
      this.bg = 0;
      this.bf = 0;
      this.be = 0;
      if (this.bm != 1)
      {
        this.jdField_j_of_type_JavaLangString = null;
        this.jdField_c_of_type_Long = 0L;
      }
      this.aU = 0;
      this.bc = "";
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      t();
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new vbq(this));
    }
    return 0;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.jdField_c_of_type_Long, -1));; paramLong = Math.min(paramLong, this.jdField_j_of_type_Long)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    int j = 0;
    Object localObject2 = MD5.toMD5Byte(paramArrayOfByte, 0, paramArrayOfByte.length);
    if (localObject2 != null)
    {
      paramArrayOfByte = "";
      i = 0;
      for (;;)
      {
        localObject1 = paramArrayOfByte;
        if (i >= localObject2.length) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte + MD5.byteHEX(localObject2[i]);
        i += 1;
      }
    }
    Object localObject1 = "";
    paramArrayOfByte = new StringBuilder(512);
    localObject2 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((ServerAddr)localObject2).jdField_a_of_type_JavaLangString);
    if (((ServerAddr)localObject2).jdField_b_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((ServerAddr)localObject2).jdField_b_of_type_Int);
    }
    paramArrayOfByte.append("/qqupload?ver=");
    paramArrayOfByte.append("2880");
    paramArrayOfByte.append("&ukey=");
    paramArrayOfByte.append(this.jdField_j_of_type_JavaLangString);
    paramArrayOfByte.append("&filekey=");
    paramArrayOfByte.append(this.h);
    paramArrayOfByte.append("&filesize=");
    paramArrayOfByte.append(this.jdField_a_of_type_Long);
    paramArrayOfByte.append("&bmd5=");
    paramArrayOfByte.append((String)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoForwardProcessor", 2, "getConnUrl()---------- lastukey = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
        QLog.d("ShortVideoForwardProcessor", 2, "getConnUrl()---------- lastip = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
      }
      paramArrayOfByte.append("&lastukey=");
      paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
      paramArrayOfByte.append("&lastip=");
      paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
    }
    paramArrayOfByte.append("&mType=shortVideo");
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        i = j;
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) {
          i = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
        }
      }
    }
    paramArrayOfByte.append("&videotype=").append(i);
    a("getConnUrl", "url = " + paramArrayOfByte.toString());
    return paramArrayOfByte.toString();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 120	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:o	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 8
    //   16: iconst_2
    //   17: ldc_w 666
    //   20: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 667	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	()V
    //   27: aload_0
    //   28: sipush 1001
    //   31: invokevirtual 519	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(I)V
    //   34: aload_0
    //   35: getfield 442	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   38: invokevirtual 668	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   41: aload_0
    //   42: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   45: getfield 669	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   48: invokestatic 482	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +40 -> 91
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   59: getfield 669	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokestatic 143	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   65: putfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   68: aload_0
    //   69: getfield 442	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   77: getfield 669	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: aload_2
    //   83: putfield 670	com/tencent/mobileqq/transfile/FileMsg:h	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 672	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   95: getfield 175	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   98: ifnull +97 -> 195
    //   101: aload_0
    //   102: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   105: getfield 175	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   108: instanceof 177
    //   111: ifeq +84 -> 195
    //   114: aload_0
    //   115: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   118: getfield 175	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   121: checkcast 177	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo
    //   124: astore_1
    //   125: aload_0
    //   126: aload_1
    //   127: getfield 674	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:jdField_m_of_type_Int	I
    //   130: i2l
    //   131: putfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:n	J
    //   134: aload_0
    //   135: aload_1
    //   136: getfield 677	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:q	I
    //   139: i2l
    //   140: putfield 251	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_Long	J
    //   143: aload_0
    //   144: aload_1
    //   145: getfield 678	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:jdField_k_of_type_Int	I
    //   148: putfield 232	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:aH	I
    //   151: aload_0
    //   152: aload_1
    //   153: getfield 679	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:jdField_l_of_type_Int	I
    //   156: putfield 228	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:aI	I
    //   159: aload_0
    //   160: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   163: ifnull +20 -> 183
    //   166: aload_0
    //   167: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   170: arraylength
    //   171: ifeq +12 -> 183
    //   174: aload_0
    //   175: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:n	J
    //   178: lconst_0
    //   179: lcmp
    //   180: ifgt +79 -> 259
    //   183: aload_0
    //   184: invokevirtual 681	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:f	()Z
    //   187: ifne +33 -> 220
    //   190: aload_0
    //   191: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   194: return
    //   195: aload_0
    //   196: ldc_w 683
    //   199: ldc_w 267
    //   202: invokevirtual 270	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_0
    //   206: sipush 9302
    //   209: ldc_w 685
    //   212: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   215: aload_0
    //   216: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   219: return
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   225: putfield 687	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   228: new 689	java/io/File
    //   231: dup
    //   232: aload_0
    //   233: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   236: getfield 80	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   239: invokespecial 692	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: astore_1
    //   243: aload_0
    //   244: aload_1
    //   245: invokevirtual 694	java/io/File:length	()J
    //   248: putfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:n	J
    //   251: aload_0
    //   252: aload_1
    //   253: invokevirtual 697	java/io/File:getName	()Ljava/lang/String;
    //   256: putfield 242	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:bl	Ljava/lang/String;
    //   259: aload_0
    //   260: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   263: ifnull +34 -> 297
    //   266: aload_0
    //   267: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   270: arraylength
    //   271: ifeq +26 -> 297
    //   274: aload_0
    //   275: getfield 251	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_Long	J
    //   278: lconst_0
    //   279: lcmp
    //   280: ifle +17 -> 297
    //   283: aload_0
    //   284: getfield 232	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:aH	I
    //   287: ifle +10 -> 297
    //   290: aload_0
    //   291: getfield 228	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:aI	I
    //   294: ifgt +132 -> 426
    //   297: new 699	java/io/FileInputStream
    //   300: dup
    //   301: aload_0
    //   302: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   305: invokespecial 700	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   308: astore_2
    //   309: aload_2
    //   310: astore_1
    //   311: aload_0
    //   312: aload_2
    //   313: lconst_0
    //   314: invokestatic 703	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   317: putfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   320: aload_2
    //   321: astore_1
    //   322: aload_0
    //   323: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   326: ifnonnull +56 -> 382
    //   329: aload_2
    //   330: astore_1
    //   331: aload_0
    //   332: sipush 9041
    //   335: new 94	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 705
    //   345: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_0
    //   349: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   361: aload_2
    //   362: astore_1
    //   363: aload_0
    //   364: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   367: aload_2
    //   368: ifnull -361 -> 7
    //   371: aload_2
    //   372: invokevirtual 708	java/io/FileInputStream:close	()V
    //   375: return
    //   376: astore_1
    //   377: aload_1
    //   378: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   381: return
    //   382: aload_2
    //   383: astore_1
    //   384: aload_0
    //   385: aload_0
    //   386: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   389: putfield 711	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   392: aload_2
    //   393: ifnull +7 -> 400
    //   396: aload_2
    //   397: invokevirtual 708	java/io/FileInputStream:close	()V
    //   400: aload_0
    //   401: new 689	java/io/File
    //   404: dup
    //   405: aload_0
    //   406: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   409: invokespecial 692	java/io/File:<init>	(Ljava/lang/String;)V
    //   412: invokevirtual 694	java/io/File:length	()J
    //   415: putfield 251	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_Long	J
    //   418: aload_0
    //   419: aload_0
    //   420: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   423: invokevirtual 713	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(Ljava/lang/String;)V
    //   426: aload_0
    //   427: invokevirtual 715	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:g	()V
    //   430: return
    //   431: astore_1
    //   432: aload_1
    //   433: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   436: goto -36 -> 400
    //   439: astore_3
    //   440: aconst_null
    //   441: astore_2
    //   442: aload_2
    //   443: astore_1
    //   444: aload_0
    //   445: aconst_null
    //   446: putfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   449: aload_2
    //   450: astore_1
    //   451: aload_0
    //   452: aload_3
    //   453: invokevirtual 718	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(Ljava/io/IOException;)V
    //   456: aload_2
    //   457: astore_1
    //   458: aload_0
    //   459: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   462: aload_2
    //   463: ifnull -456 -> 7
    //   466: aload_2
    //   467: invokevirtual 708	java/io/FileInputStream:close	()V
    //   470: return
    //   471: astore_1
    //   472: aload_1
    //   473: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   476: return
    //   477: astore_2
    //   478: aconst_null
    //   479: astore_1
    //   480: aload_1
    //   481: ifnull +7 -> 488
    //   484: aload_1
    //   485: invokevirtual 708	java/io/FileInputStream:close	()V
    //   488: aload_2
    //   489: athrow
    //   490: astore_1
    //   491: aload_1
    //   492: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   495: goto -7 -> 488
    //   498: astore_2
    //   499: goto -19 -> 480
    //   502: astore_3
    //   503: goto -61 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	this	ShortVideoForwardProcessor
    //   72	291	1	localObject1	Object
    //   376	2	1	localIOException1	IOException
    //   383	1	1	localObject2	Object
    //   431	2	1	localIOException2	IOException
    //   443	15	1	localObject3	Object
    //   471	2	1	localIOException3	IOException
    //   479	6	1	localObject4	Object
    //   490	2	1	localIOException4	IOException
    //   80	387	2	localObject5	Object
    //   477	12	2	localObject6	Object
    //   498	1	2	localObject7	Object
    //   439	14	3	localIOException5	IOException
    //   502	1	3	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   371	375	376	java/io/IOException
    //   396	400	431	java/io/IOException
    //   297	309	439	java/io/IOException
    //   466	470	471	java/io/IOException
    //   297	309	477	finally
    //   484	488	490	java/io/IOException
    //   311	320	498	finally
    //   322	329	498	finally
    //   331	361	498	finally
    //   363	367	498	finally
    //   384	392	498	finally
    //   444	449	498	finally
    //   451	456	498	finally
    //   458	462	498	finally
    //   311	320	502	java/io/IOException
    //   322	329	502	java/io/IOException
    //   331	361	502	java/io/IOException
    //   363	367	502	java/io/IOException
    //   384	392	502	java/io/IOException
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.o) || (this.k)) {
      return;
    }
    a("onResp", "result:" + paramNetResp.e + " errCode:" + paramNetResp.jdField_f_of_type_Int + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
    int i = paramNetResp.jdField_g_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    long l2;
    for (;;)
    {
      try
      {
        if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null)
        {
          l2 = Long.MAX_VALUE;
          if (-5103065L != l2) {
            this.aL = 0;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoForwardProcessor", 2, "onResp()---- HttpMsg.RANGE:" + (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
            QLog.d("ShortVideoForwardProcessor", 2, "onResp()---- userRetCode:" + l2 + "----mUpBrokenTransferRetryCount=" + this.aL);
          }
          if ((l2 == 0L) || (l2 == Long.MAX_VALUE)) {
            break label416;
          }
          if (-5103065L != l2) {
            break label374;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = null;
          this.jdField_c_of_type_Long = 0L;
          if (this.aL >= 3) {
            break;
          }
          J_();
          this.aL += 1;
          return;
        }
      }
      catch (Exception paramNetResp)
      {
        a(9343, "decode reponse unknown exception", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      l2 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
    }
    a((int)l2, "续传过期重试超过3次.");
    b();
    return;
    label374:
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    if (!ShortVideoUpHandler.a((int)l2))
    {
      a(56009, null, b(i, l2), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    label416:
    long l1;
    if (paramNetResp.e == 0)
    {
      this.aW = 0;
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null)
      {
        l1 = Long.MAX_VALUE;
        if (l1 != Long.MAX_VALUE) {
          break label1176;
        }
        Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
        if (localObject == null) {
          break label1176;
        }
      }
    }
    label1176:
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range"));
        l1 = i;
        if (l1 == Long.MAX_VALUE)
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
        localException2.printStackTrace();
        l1 = Long.MAX_VALUE;
        continue;
        a("decodeHttpResp", "from " + this.jdField_c_of_type_Long + " to " + l1 + " userReturnCode:" + l2);
        if (l1 <= this.jdField_c_of_type_Long)
        {
          if (this.bg < 3)
          {
            a("procHttpRespBody", "server offset rollback");
            this.bg += 1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "onResp()---------- transferedSize = " + l1);
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = l1;
          this.jdField_c_of_type_Long = l1;
          this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(66));
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
          if (l1 >= this.jdField_a_of_type_Long) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null)
          {
            ShortVideoUpInfo localShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            paramNetResp = localShortVideoUpInfo;
            if (localShortVideoUpInfo == null)
            {
              paramNetResp = new ShortVideoUpInfo();
              paramNetResp.key = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
              paramNetResp.uKey = this.jdField_j_of_type_JavaLangString;
              paramNetResp.lastIp = this.jdField_m_of_type_Long;
            }
            paramNetResp.transferedSize = this.jdField_c_of_type_Long;
            paramNetResp.timeStamp = (MessageCache.a() * 1000L);
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(paramNetResp);
          }
          if (this.o) {
            break;
          }
          h();
          J_();
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l2);
        a(56009, "", a(this.bb, this.aQ), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoForwardProcessor", 2, "sendFile() success.");
        }
        d(1007);
        d(false);
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
      this.aL = 0;
      if ((paramNetResp.jdField_f_of_type_Int == 9364) && (this.aW < 3))
      {
        a("[netChg]", "failed.but net change detect.so retry");
        this.aW += 1;
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
        q();
        g();
        return;
      }
      if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ArrayOfByte.length >= 32768) && (RichMediaStrategy.a(paramNetResp.jdField_f_of_type_Int)))
      {
        this.jdField_b_of_type_Boolean = true;
        q();
        J_();
        return;
      }
      a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
      a(paramNetResp.jdField_f_of_type_Int, paramNetResp.jdField_a_of_type_JavaLangString);
      b();
      return;
    }
  }
  
  /* Error */
  public void a(RichProto.RichProtoReq paramRichProtoReq, com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp paramRichProtoResp)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 879	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq	Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq;
    //   5: aload_2
    //   6: ifnull +383 -> 389
    //   9: iconst_0
    //   10: istore 7
    //   12: iload 7
    //   14: aload_2
    //   15: getfield 884	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   18: invokeinterface 889 1 0
    //   23: if_icmpge +366 -> 389
    //   26: aload_2
    //   27: getfield 884	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: iload 7
    //   32: invokeinterface 890 2 0
    //   37: checkcast 892	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp
    //   40: astore 4
    //   42: aload_0
    //   43: ldc_w 894
    //   46: aload 4
    //   48: invokevirtual 895	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:toString	()Ljava/lang/String;
    //   51: invokevirtual 270	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 897	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   59: aload 4
    //   61: invokevirtual 900	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   64: aload_0
    //   65: aload 4
    //   67: getfield 901	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: putfield 304	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:h	Ljava/lang/String;
    //   73: aload_0
    //   74: aload 4
    //   76: getfield 902	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   79: putfield 604	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   82: aload 4
    //   84: getfield 903	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_c_of_type_Int	I
    //   87: ifne +1539 -> 1626
    //   90: aload_0
    //   91: aload 4
    //   93: getfield 904	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Int	I
    //   96: putfield 398	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:bn	I
    //   99: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +33 -> 135
    //   105: ldc 8
    //   107: iconst_2
    //   108: new 94	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 906
    //   118: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 4
    //   123: getfield 904	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Int	I
    //   126: invokevirtual 621	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload 4
    //   137: getfield 908	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Boolean	Z
    //   140: ifeq +44 -> 184
    //   143: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +12 -> 158
    //   149: ldc 8
    //   151: iconst_2
    //   152: ldc_w 910
    //   155: invokestatic 912	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_0
    //   159: iconst_1
    //   160: putfield 50	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:f	Z
    //   163: aload_0
    //   164: sipush 1007
    //   167: invokevirtual 519	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(I)V
    //   170: aload_0
    //   171: iconst_1
    //   172: invokevirtual 861	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(Z)V
    //   175: iload 7
    //   177: iconst_1
    //   178: iadd
    //   179: istore 7
    //   181: goto -169 -> 12
    //   184: aload_0
    //   185: getfield 46	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:aK	I
    //   188: ifne +281 -> 469
    //   191: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +35 -> 229
    //   197: ldc 8
    //   199: iconst_2
    //   200: new 94	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 914
    //   210: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   217: getfield 80	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   220: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 912	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: new 916	android/media/MediaPlayer
    //   232: dup
    //   233: invokespecial 917	android/media/MediaPlayer:<init>	()V
    //   236: astore_3
    //   237: new 699	java/io/FileInputStream
    //   240: dup
    //   241: aload_0
    //   242: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   245: getfield 80	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   248: invokespecial 700	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   251: astore_1
    //   252: aload_3
    //   253: aload_1
    //   254: invokevirtual 921	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   257: invokevirtual 925	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   260: aload_3
    //   261: invokevirtual 928	android/media/MediaPlayer:prepare	()V
    //   264: aload_3
    //   265: ifnull +7 -> 272
    //   268: aload_3
    //   269: invokevirtual 931	android/media/MediaPlayer:release	()V
    //   272: aload_1
    //   273: ifnull +7 -> 280
    //   276: aload_1
    //   277: invokevirtual 708	java/io/FileInputStream:close	()V
    //   280: iconst_0
    //   281: istore 6
    //   283: iload 6
    //   285: ifeq +184 -> 469
    //   288: invokestatic 935	com/tencent/mobileqq/shortvideo/ShortVideoUtils:d	()Z
    //   291: ifeq +178 -> 469
    //   294: aload_0
    //   295: sipush 9305
    //   298: ldc_w 937
    //   301: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   304: aload_0
    //   305: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   308: new 220	java/util/HashMap
    //   311: dup
    //   312: invokespecial 938	java/util/HashMap:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: getstatic 943	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   320: ldc_w 259
    //   323: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   326: pop
    //   327: aload_1
    //   328: ldc_w 945
    //   331: aload_0
    //   332: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   335: getfield 80	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   338: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   341: pop
    //   342: aload_1
    //   343: ldc_w 947
    //   346: aload_0
    //   347: getfield 948	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   350: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   353: pop
    //   354: aload_1
    //   355: ldc_w 950
    //   358: aload_0
    //   359: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   362: getfield 669	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   365: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   368: pop
    //   369: invokestatic 576	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   372: invokestatic 955	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   375: aconst_null
    //   376: ldc_w 957
    //   379: iconst_1
    //   380: lconst_0
    //   381: lconst_0
    //   382: aload_1
    //   383: ldc_w 259
    //   386: invokevirtual 960	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   389: return
    //   390: astore_1
    //   391: iconst_0
    //   392: istore 6
    //   394: goto -111 -> 283
    //   397: astore_1
    //   398: aconst_null
    //   399: astore_3
    //   400: aconst_null
    //   401: astore_1
    //   402: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +12 -> 417
    //   408: ldc 8
    //   410: iconst_2
    //   411: ldc_w 962
    //   414: invokestatic 912	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_3
    //   418: ifnull +7 -> 425
    //   421: aload_3
    //   422: invokevirtual 931	android/media/MediaPlayer:release	()V
    //   425: aload_1
    //   426: ifnull +7 -> 433
    //   429: aload_1
    //   430: invokevirtual 708	java/io/FileInputStream:close	()V
    //   433: iconst_1
    //   434: istore 6
    //   436: goto -153 -> 283
    //   439: astore_1
    //   440: iconst_1
    //   441: istore 6
    //   443: goto -160 -> 283
    //   446: astore_2
    //   447: aconst_null
    //   448: astore_3
    //   449: aconst_null
    //   450: astore_1
    //   451: aload_3
    //   452: ifnull +7 -> 459
    //   455: aload_3
    //   456: invokevirtual 931	android/media/MediaPlayer:release	()V
    //   459: aload_1
    //   460: ifnull +7 -> 467
    //   463: aload_1
    //   464: invokevirtual 708	java/io/FileInputStream:close	()V
    //   467: aload_2
    //   468: athrow
    //   469: aload_0
    //   470: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   473: getfield 80	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   476: ifnull +395 -> 871
    //   479: aload_0
    //   480: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   483: getfield 80	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   486: invokevirtual 246	java/lang/String:length	()I
    //   489: ifle +382 -> 871
    //   492: aload_0
    //   493: getfield 687	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   496: ifnull +11 -> 507
    //   499: aload_0
    //   500: getfield 687	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   503: arraylength
    //   504: ifne +20 -> 524
    //   507: aload_0
    //   508: aload_0
    //   509: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   512: getfield 80	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   515: invokestatic 965	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   518: invokestatic 143	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   521: putfield 687	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   524: new 689	java/io/File
    //   527: dup
    //   528: aload_0
    //   529: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   532: getfield 80	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   535: invokespecial 692	java/io/File:<init>	(Ljava/lang/String;)V
    //   538: astore_1
    //   539: aload_1
    //   540: invokevirtual 968	java/io/File:exists	()Z
    //   543: ifeq +313 -> 856
    //   546: aload_1
    //   547: invokevirtual 694	java/io/File:length	()J
    //   550: lconst_0
    //   551: lcmp
    //   552: ifle +304 -> 856
    //   555: aload_0
    //   556: aload_1
    //   557: invokevirtual 694	java/io/File:length	()J
    //   560: putfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:n	J
    //   563: aload_0
    //   564: aload_1
    //   565: invokevirtual 697	java/io/File:getName	()Ljava/lang/String;
    //   568: putfield 242	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:bl	Ljava/lang/String;
    //   571: aload_0
    //   572: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   575: ifnull +326 -> 901
    //   578: aload_0
    //   579: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   582: invokevirtual 246	java/lang/String:length	()I
    //   585: ifle +316 -> 901
    //   588: aload_0
    //   589: getfield 711	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   592: ifnull +11 -> 603
    //   595: aload_0
    //   596: getfield 711	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   599: arraylength
    //   600: ifne +17 -> 617
    //   603: aload_0
    //   604: aload_0
    //   605: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   608: invokestatic 965	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   611: invokestatic 143	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   614: putfield 711	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   617: new 689	java/io/File
    //   620: dup
    //   621: aload_0
    //   622: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   625: invokespecial 692	java/io/File:<init>	(Ljava/lang/String;)V
    //   628: astore_1
    //   629: aload_1
    //   630: invokevirtual 968	java/io/File:exists	()Z
    //   633: ifeq +253 -> 886
    //   636: aload_1
    //   637: invokevirtual 694	java/io/File:length	()J
    //   640: lconst_0
    //   641: lcmp
    //   642: ifle +244 -> 886
    //   645: aload_0
    //   646: aload_1
    //   647: invokevirtual 694	java/io/File:length	()J
    //   650: putfield 251	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_Long	J
    //   653: aload_0
    //   654: aload_0
    //   655: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   658: invokevirtual 713	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(Ljava/lang/String;)V
    //   661: aload_0
    //   662: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   665: ifnull +251 -> 916
    //   668: aload_0
    //   669: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   672: arraylength
    //   673: ifle +243 -> 916
    //   676: aload_0
    //   677: getfield 687	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   680: ifnull +236 -> 916
    //   683: aload_0
    //   684: getfield 687	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   687: arraylength
    //   688: ifle +228 -> 916
    //   691: aload_0
    //   692: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   695: ifnull +221 -> 916
    //   698: aload_0
    //   699: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   702: arraylength
    //   703: ifle +213 -> 916
    //   706: aload_0
    //   707: getfield 711	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   710: ifnull +206 -> 916
    //   713: aload_0
    //   714: getfield 711	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   717: arraylength
    //   718: ifle +198 -> 916
    //   721: aload_0
    //   722: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   725: aload_0
    //   726: getfield 687	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   729: invokestatic 972	java/util/Arrays:equals	([B[B)Z
    //   732: ifeq +17 -> 749
    //   735: aload_0
    //   736: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   739: aload_0
    //   740: getfield 711	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   743: invokestatic 972	java/util/Arrays:equals	([B[B)Z
    //   746: ifne +170 -> 916
    //   749: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +83 -> 835
    //   755: ldc 8
    //   757: iconst_2
    //   758: new 94	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 974
    //   768: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_0
    //   772: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   775: invokestatic 977	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   778: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: ldc_w 979
    //   784: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload_0
    //   788: getfield 687	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   791: invokestatic 977	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   794: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: ldc_w 981
    //   800: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload_0
    //   804: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   807: invokestatic 977	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   810: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: ldc_w 983
    //   816: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: aload_0
    //   820: getfield 711	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   823: invokestatic 977	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   826: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   835: aload_0
    //   836: aload_0
    //   837: getfield 687	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   840: putfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   843: aload_0
    //   844: aload_0
    //   845: getfield 711	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   848: putfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   851: aload_0
    //   852: invokevirtual 715	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:g	()V
    //   855: return
    //   856: aload_0
    //   857: sipush 9042
    //   860: ldc_w 985
    //   863: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   866: aload_0
    //   867: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   870: return
    //   871: aload_0
    //   872: sipush 9302
    //   875: ldc_w 987
    //   878: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   881: aload_0
    //   882: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   885: return
    //   886: aload_0
    //   887: sipush 9042
    //   890: ldc_w 989
    //   893: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   896: aload_0
    //   897: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   900: return
    //   901: aload_0
    //   902: sipush 9302
    //   905: ldc_w 991
    //   908: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   911: aload_0
    //   912: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   915: return
    //   916: aload_0
    //   917: getfield 442	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   920: astore_1
    //   921: aload_0
    //   922: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:n	J
    //   925: aload_0
    //   926: getfield 251	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_Long	J
    //   929: ladd
    //   930: lstore 8
    //   932: aload_0
    //   933: lload 8
    //   935: putfield 568	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Long	J
    //   938: aload_1
    //   939: lload 8
    //   941: putfield 992	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Long	J
    //   944: aload_0
    //   945: aload 4
    //   947: getfield 993	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_Long	J
    //   950: putfield 994	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_Long	J
    //   953: aload_0
    //   954: aload 4
    //   956: getfield 995	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   959: putfield 533	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   962: aload_0
    //   963: getfield 531	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:bm	I
    //   966: iconst_2
    //   967: if_icmpne +236 -> 1203
    //   970: aload_0
    //   971: ldc_w 997
    //   974: invokevirtual 999	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:c	(Ljava/lang/String;)V
    //   977: aload_0
    //   978: aload 4
    //   980: getfield 1000	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Long	J
    //   983: putfield 835	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_m_of_type_Long	J
    //   986: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   989: ifeq +93 -> 1082
    //   992: ldc 8
    //   994: iconst_2
    //   995: new 94	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1002: ldc_w 1002
    //   1005: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: aload_0
    //   1009: getfield 604	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1012: invokevirtual 1005	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: ldc 8
    //   1023: iconst_2
    //   1024: new 94	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1031: ldc_w 1007
    //   1034: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload_0
    //   1038: getfield 835	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_m_of_type_Long	J
    //   1041: invokevirtual 634	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1044: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1050: ldc 8
    //   1052: iconst_2
    //   1053: new 94	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1060: ldc_w 1009
    //   1063: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: aload_0
    //   1067: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1070: getfield 669	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1073: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1082: aload_0
    //   1083: aload_0
    //   1084: getfield 64	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1087: bipush 66
    //   1089: invokevirtual 826	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1092: checkcast 760	com/tencent/mobileqq/app/ShortVideoTransManager
    //   1095: putfield 758	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1098: aload_0
    //   1099: getfield 758	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1102: ifnull +54 -> 1156
    //   1105: aload_0
    //   1106: aload_0
    //   1107: getfield 758	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1110: new 94	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1117: aload_0
    //   1118: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1121: getfield 669	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1124: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: aload_0
    //   1128: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1131: getfield 160	com/tencent/mobileqq/transfile/TransferRequest:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1134: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: aload_0
    //   1138: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1141: getfield 152	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   1144: invokevirtual 634	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1147: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: invokevirtual 829	com/tencent/mobileqq/app/ShortVideoTransManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1153: putfield 638	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo	Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1156: aload_0
    //   1157: lconst_0
    //   1158: putfield 535	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_Long	J
    //   1161: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1164: ifeq +32 -> 1196
    //   1167: ldc 8
    //   1169: iconst_2
    //   1170: new 94	java/lang/StringBuilder
    //   1173: dup
    //   1174: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1177: ldc_w 1011
    //   1180: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: aload_0
    //   1184: getfield 638	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo	Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1187: invokevirtual 1005	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1190: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1196: aload_0
    //   1197: invokevirtual 762	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:J_	()V
    //   1200: goto -1025 -> 175
    //   1203: aload_0
    //   1204: getfield 531	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:bm	I
    //   1207: ifne +371 -> 1578
    //   1210: aload_0
    //   1211: ldc_w 1013
    //   1214: invokevirtual 999	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:c	(Ljava/lang/String;)V
    //   1217: aload 4
    //   1219: getfield 1014	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_Boolean	Z
    //   1222: ifne +10 -> 1232
    //   1225: aload_0
    //   1226: ldc_w 1016
    //   1229: invokevirtual 999	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:c	(Ljava/lang/String;)V
    //   1232: aconst_null
    //   1233: astore_1
    //   1234: aconst_null
    //   1235: astore_3
    //   1236: ldc_w 1018
    //   1239: monitorenter
    //   1240: aload_0
    //   1241: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1244: getfield 157	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1247: invokestatic 1022	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1250: invokevirtual 1026	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   1253: ifnull +45 -> 1298
    //   1256: aload_0
    //   1257: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1260: getfield 157	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1263: invokestatic 1022	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1266: invokevirtual 1026	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   1269: arraylength
    //   1270: istore 6
    //   1272: iload 6
    //   1274: newarray <illegal type>
    //   1276: astore_1
    //   1277: aload_0
    //   1278: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1281: getfield 157	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1284: invokestatic 1022	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1287: invokevirtual 1026	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   1290: iconst_0
    //   1291: aload_1
    //   1292: iconst_0
    //   1293: iload 6
    //   1295: invokestatic 1030	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1298: aload_0
    //   1299: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1302: getfield 157	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1305: invokestatic 1022	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1308: invokevirtual 1033	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   1311: ifnull +45 -> 1356
    //   1314: aload_0
    //   1315: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1318: getfield 157	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1321: invokestatic 1022	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1324: invokevirtual 1033	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   1327: arraylength
    //   1328: istore 6
    //   1330: iload 6
    //   1332: newarray <illegal type>
    //   1334: astore_3
    //   1335: aload_0
    //   1336: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1339: getfield 157	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1342: invokestatic 1022	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1345: invokevirtual 1033	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   1348: iconst_0
    //   1349: aload_3
    //   1350: iconst_0
    //   1351: iload 6
    //   1353: invokestatic 1030	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1356: ldc_w 1018
    //   1359: monitorexit
    //   1360: aload 4
    //   1362: getfield 1014	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_Boolean	Z
    //   1365: ifeq +49 -> 1414
    //   1368: aload_1
    //   1369: ifnull +45 -> 1414
    //   1372: aload_1
    //   1373: arraylength
    //   1374: ifle +40 -> 1414
    //   1377: aload_3
    //   1378: ifnull +36 -> 1414
    //   1381: aload_3
    //   1382: arraylength
    //   1383: ifle +31 -> 1414
    //   1386: aload_0
    //   1387: ldc_w 1035
    //   1390: invokevirtual 999	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:c	(Ljava/lang/String;)V
    //   1393: aload_0
    //   1394: iconst_1
    //   1395: putfield 531	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:bm	I
    //   1398: aload_0
    //   1399: aload_1
    //   1400: aload_3
    //   1401: invokevirtual 1038	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	([B[B)V
    //   1404: goto -1229 -> 175
    //   1407: astore_1
    //   1408: ldc_w 1018
    //   1411: monitorexit
    //   1412: aload_1
    //   1413: athrow
    //   1414: aload 4
    //   1416: getfield 1014	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_Boolean	Z
    //   1419: ifeq +17 -> 1436
    //   1422: aload_0
    //   1423: getfield 64	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1426: aload_0
    //   1427: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1430: getfield 157	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1433: invokestatic 1044	com/tencent/mobileqq/highway/config/HwServlet:getConfig	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   1436: aload_0
    //   1437: ldc_w 1046
    //   1440: invokevirtual 999	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:c	(Ljava/lang/String;)V
    //   1443: aload_0
    //   1444: iconst_2
    //   1445: putfield 531	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:bm	I
    //   1448: aload_0
    //   1449: aload 4
    //   1451: getfield 1000	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Long	J
    //   1454: putfield 835	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_m_of_type_Long	J
    //   1457: aload_0
    //   1458: aload_0
    //   1459: getfield 64	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1462: bipush 66
    //   1464: invokevirtual 826	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1467: checkcast 760	com/tencent/mobileqq/app/ShortVideoTransManager
    //   1470: putfield 758	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1473: aload_0
    //   1474: getfield 758	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1477: ifnull +54 -> 1531
    //   1480: aload_0
    //   1481: aload_0
    //   1482: getfield 758	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1485: new 94	java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1492: aload_0
    //   1493: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1496: getfield 669	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1499: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: aload_0
    //   1503: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1506: getfield 160	com/tencent/mobileqq/transfile/TransferRequest:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1509: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: aload_0
    //   1513: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1516: getfield 152	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   1519: invokevirtual 634	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1522: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1525: invokevirtual 829	com/tencent/mobileqq/app/ShortVideoTransManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1528: putfield 638	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo	Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1531: aload_0
    //   1532: lconst_0
    //   1533: putfield 535	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_Long	J
    //   1536: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1539: ifeq +32 -> 1571
    //   1542: ldc 8
    //   1544: iconst_2
    //   1545: new 94	java/lang/StringBuilder
    //   1548: dup
    //   1549: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1552: ldc_w 1011
    //   1555: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: aload_0
    //   1559: getfield 638	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo	Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1562: invokevirtual 1005	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1565: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1568: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1571: aload_0
    //   1572: invokevirtual 762	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:J_	()V
    //   1575: goto -1400 -> 175
    //   1578: new 94	java/lang/StringBuilder
    //   1581: dup
    //   1582: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1585: ldc_w 1048
    //   1588: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: astore_3
    //   1592: aload_0
    //   1593: getfield 531	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:bm	I
    //   1596: iconst_1
    //   1597: if_icmpne +22 -> 1619
    //   1600: ldc_w 1050
    //   1603: astore_1
    //   1604: aload_0
    //   1605: aload_3
    //   1606: aload_1
    //   1607: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1610: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1613: invokevirtual 999	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:c	(Ljava/lang/String;)V
    //   1616: goto -1441 -> 175
    //   1619: ldc_w 1052
    //   1622: astore_1
    //   1623: goto -19 -> 1604
    //   1626: ldc_w 1053
    //   1629: aload_0
    //   1630: getfield 538	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:aU	I
    //   1633: if_icmpne +43 -> 1676
    //   1636: aload_0
    //   1637: ldc_w 1053
    //   1640: new 94	java/lang/StringBuilder
    //   1643: dup
    //   1644: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1647: ldc_w 1055
    //   1650: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1653: aload_0
    //   1654: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1657: getfield 669	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1660: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1663: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1666: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   1669: aload_0
    //   1670: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   1673: goto -1498 -> 175
    //   1676: aload_0
    //   1677: sipush 9045
    //   1680: ldc_w 1057
    //   1683: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   1686: goto -17 -> 1669
    //   1689: astore_1
    //   1690: goto -1223 -> 467
    //   1693: astore_2
    //   1694: aconst_null
    //   1695: astore_1
    //   1696: goto -1245 -> 451
    //   1699: astore_2
    //   1700: goto -1249 -> 451
    //   1703: astore_2
    //   1704: goto -1253 -> 451
    //   1707: astore_1
    //   1708: aconst_null
    //   1709: astore_1
    //   1710: goto -1308 -> 402
    //   1713: astore 5
    //   1715: goto -1313 -> 402
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1718	0	this	ShortVideoForwardProcessor
    //   0	1718	1	paramRichProtoReq	RichProto.RichProtoReq
    //   0	1718	2	paramRichProtoResp	com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp
    //   236	1370	3	localObject	Object
    //   40	1410	4	localShortVideoForwardResp	com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoForwardResp
    //   1713	1	5	localException	Exception
    //   281	1071	6	i	int
    //   10	170	7	j	int
    //   930	10	8	l1	long
    // Exception table:
    //   from	to	target	type
    //   268	272	390	java/lang/Exception
    //   276	280	390	java/lang/Exception
    //   229	237	397	java/lang/Exception
    //   421	425	439	java/lang/Exception
    //   429	433	439	java/lang/Exception
    //   229	237	446	finally
    //   1240	1298	1407	finally
    //   1298	1356	1407	finally
    //   1356	1360	1407	finally
    //   1408	1412	1407	finally
    //   455	459	1689	java/lang/Exception
    //   463	467	1689	java/lang/Exception
    //   237	252	1693	finally
    //   252	264	1699	finally
    //   402	417	1703	finally
    //   237	252	1707	java/lang/Exception
    //   252	264	1713	java/lang/Exception
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aU))) {}
    while ((this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int j = this.aX;
    int i;
    String str1;
    long l1;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.aX = (i | j);
      str1 = "actShortVideoForward";
      if (this.bm == 1) {
        str1 = "actShortVideoForwardBDH";
      }
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.h != null) {
        break label468;
      }
      str2 = this.jdField_i_of_type_JavaLangString;
      label193:
      localHashMap.put("param_uuid", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.aK + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_l_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.aJ));
      if (!paramBoolean) {
        break label476;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      p();
      Log.i("AutoMonitor", "ShortVideoForward, cost=" + (this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long - this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long) / 1000000L + ", richTag = " + str1);
      return;
      i = 1;
      break;
      label468:
      str2 = this.h;
      break label193;
      label476:
      if (this.aU != 56009) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +29 -> 41
    //   15: ldc 8
    //   17: iconst_2
    //   18: new 94	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 1136
    //   28: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: invokevirtual 1005	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: getfield 767	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   45: invokevirtual 1137	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:a	()V
    //   48: aload_0
    //   49: getfield 1140	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   52: ifnull +4 -> 56
    //   55: return
    //   56: aload_0
    //   57: getfield 495	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   60: ifnonnull +59 -> 119
    //   63: aload_0
    //   64: new 497	java/io/RandomAccessFile
    //   67: dup
    //   68: aload_0
    //   69: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   72: getfield 80	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   75: ldc_w 499
    //   78: invokespecial 501	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: putfield 495	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   84: aload_0
    //   85: getfield 495	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   88: ifnonnull +31 -> 119
    //   91: aload_0
    //   92: sipush 9303
    //   95: ldc_w 503
    //   98: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   105: return
    //   106: astore_3
    //   107: aload_3
    //   108: invokevirtual 504	java/io/FileNotFoundException:printStackTrace	()V
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 495	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   116: goto -32 -> 84
    //   119: aload_0
    //   120: getfield 506	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   123: ifnonnull +56 -> 179
    //   126: aload_0
    //   127: new 497	java/io/RandomAccessFile
    //   130: dup
    //   131: aload_0
    //   132: getfield 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   135: ldc_w 499
    //   138: invokespecial 501	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: putfield 506	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   144: aload_0
    //   145: getfield 506	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   148: ifnonnull +31 -> 179
    //   151: aload_0
    //   152: sipush 9303
    //   155: ldc_w 508
    //   158: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   161: aload_0
    //   162: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   165: return
    //   166: astore_3
    //   167: aload_3
    //   168: invokevirtual 504	java/io/FileNotFoundException:printStackTrace	()V
    //   171: aload_0
    //   172: aconst_null
    //   173: putfield 506	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   176: goto -32 -> 144
    //   179: invokestatic 1145	android/os/SystemClock:uptimeMillis	()J
    //   182: lstore 11
    //   184: aload_0
    //   185: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   188: arraylength
    //   189: aload_0
    //   190: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   193: arraylength
    //   194: iadd
    //   195: newarray <illegal type>
    //   197: astore_3
    //   198: aload_0
    //   199: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   202: iconst_0
    //   203: aload_3
    //   204: iconst_0
    //   205: aload_0
    //   206: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   209: arraylength
    //   210: invokestatic 1030	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   213: aload_0
    //   214: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   217: iconst_0
    //   218: aload_3
    //   219: aload_0
    //   220: getfield 145	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   223: arraylength
    //   224: aload_0
    //   225: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   228: arraylength
    //   229: invokestatic 1030	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   232: new 94	java/lang/StringBuilder
    //   235: dup
    //   236: invokestatic 1147	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   239: invokespecial 1148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: aload_3
    //   243: invokestatic 977	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   246: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc_w 1150
    //   252: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore 7
    //   260: aload_0
    //   261: getfield 506	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   264: invokevirtual 1151	java/io/RandomAccessFile:length	()J
    //   267: l2i
    //   268: newarray <illegal type>
    //   270: astore_3
    //   271: aload_0
    //   272: getfield 495	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   275: invokevirtual 1151	java/io/RandomAccessFile:length	()J
    //   278: l2i
    //   279: newarray <illegal type>
    //   281: astore 9
    //   283: aload_0
    //   284: getfield 506	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   287: invokevirtual 1151	java/io/RandomAccessFile:length	()J
    //   290: aload_0
    //   291: getfield 495	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   294: invokevirtual 1151	java/io/RandomAccessFile:length	()J
    //   297: ladd
    //   298: l2i
    //   299: newarray <illegal type>
    //   301: astore 8
    //   303: aload_0
    //   304: getfield 506	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   307: aload_3
    //   308: invokevirtual 1155	java/io/RandomAccessFile:read	([B)I
    //   311: pop
    //   312: aload_0
    //   313: getfield 495	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   316: aload 9
    //   318: invokevirtual 1155	java/io/RandomAccessFile:read	([B)I
    //   321: pop
    //   322: aload_3
    //   323: iconst_0
    //   324: aload 8
    //   326: iconst_0
    //   327: aload_3
    //   328: arraylength
    //   329: invokestatic 1030	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   332: aload 9
    //   334: iconst_0
    //   335: aload 8
    //   337: aload_3
    //   338: arraylength
    //   339: aload 9
    //   341: arraylength
    //   342: invokestatic 1030	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   345: new 689	java/io/File
    //   348: dup
    //   349: aload 7
    //   351: invokespecial 692	java/io/File:<init>	(Ljava/lang/String;)V
    //   354: invokevirtual 1158	java/io/File:delete	()Z
    //   357: pop
    //   358: new 689	java/io/File
    //   361: dup
    //   362: aload 7
    //   364: invokespecial 692	java/io/File:<init>	(Ljava/lang/String;)V
    //   367: astore_3
    //   368: aload_3
    //   369: invokevirtual 968	java/io/File:exists	()Z
    //   372: istore 13
    //   374: iload 13
    //   376: ifne +8 -> 384
    //   379: aload_3
    //   380: invokevirtual 1161	java/io/File:createNewFile	()Z
    //   383: pop
    //   384: new 1163	java/io/FileOutputStream
    //   387: dup
    //   388: aload_3
    //   389: invokespecial 1166	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   392: astore_3
    //   393: new 1168	java/io/BufferedOutputStream
    //   396: dup
    //   397: aload_3
    //   398: invokespecial 1171	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   401: astore 4
    //   403: aload 4
    //   405: aload 8
    //   407: invokevirtual 1175	java/io/BufferedOutputStream:write	([B)V
    //   410: aload 4
    //   412: ifnull +8 -> 420
    //   415: aload 4
    //   417: invokevirtual 1176	java/io/BufferedOutputStream:close	()V
    //   420: aload_3
    //   421: ifnull +7 -> 428
    //   424: aload_3
    //   425: invokevirtual 1177	java/io/FileOutputStream:close	()V
    //   428: aload_0
    //   429: invokespecial 1179	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	()Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq;
    //   432: astore 4
    //   434: aload 4
    //   436: ifnonnull +194 -> 630
    //   439: aload_0
    //   440: sipush 9302
    //   443: ldc_w 1181
    //   446: invokevirtual 115	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;)V
    //   449: aload_0
    //   450: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   453: return
    //   454: astore 9
    //   456: aload 9
    //   458: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   461: goto -77 -> 384
    //   464: astore 6
    //   466: aconst_null
    //   467: astore 4
    //   469: aload 5
    //   471: astore_3
    //   472: aload 6
    //   474: astore 5
    //   476: aload 5
    //   478: invokevirtual 504	java/io/FileNotFoundException:printStackTrace	()V
    //   481: aload 4
    //   483: ifnull +8 -> 491
    //   486: aload 4
    //   488: invokevirtual 1176	java/io/BufferedOutputStream:close	()V
    //   491: aload_3
    //   492: ifnull -64 -> 428
    //   495: aload_3
    //   496: invokevirtual 1177	java/io/FileOutputStream:close	()V
    //   499: goto -71 -> 428
    //   502: astore_3
    //   503: aload_3
    //   504: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   507: goto -79 -> 428
    //   510: astore 4
    //   512: aload 4
    //   514: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   517: goto -97 -> 420
    //   520: astore_3
    //   521: aload_3
    //   522: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   525: goto -97 -> 428
    //   528: astore 4
    //   530: aload 4
    //   532: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   535: goto -44 -> 491
    //   538: astore 5
    //   540: aconst_null
    //   541: astore 4
    //   543: aload 6
    //   545: astore_3
    //   546: aload 5
    //   548: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   551: aload 4
    //   553: ifnull +8 -> 561
    //   556: aload 4
    //   558: invokevirtual 1176	java/io/BufferedOutputStream:close	()V
    //   561: aload_3
    //   562: ifnull -134 -> 428
    //   565: aload_3
    //   566: invokevirtual 1177	java/io/FileOutputStream:close	()V
    //   569: goto -141 -> 428
    //   572: astore_3
    //   573: aload_3
    //   574: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   577: goto -149 -> 428
    //   580: astore 4
    //   582: aload 4
    //   584: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   587: goto -26 -> 561
    //   590: astore_1
    //   591: aconst_null
    //   592: astore_3
    //   593: aload 4
    //   595: astore_2
    //   596: aload_3
    //   597: ifnull +7 -> 604
    //   600: aload_3
    //   601: invokevirtual 1176	java/io/BufferedOutputStream:close	()V
    //   604: aload_2
    //   605: ifnull +7 -> 612
    //   608: aload_2
    //   609: invokevirtual 1177	java/io/FileOutputStream:close	()V
    //   612: aload_1
    //   613: athrow
    //   614: astore_3
    //   615: aload_3
    //   616: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   619: goto -15 -> 604
    //   622: astore_2
    //   623: aload_2
    //   624: invokevirtual 709	java/io/IOException:printStackTrace	()V
    //   627: goto -15 -> 612
    //   630: new 1183	pttcenterservice/PttShortVideo$PttShortVideoUploadReq
    //   633: dup
    //   634: invokespecial 1184	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:<init>	()V
    //   637: astore 5
    //   639: aload 5
    //   641: iconst_1
    //   642: invokevirtual 1185	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:setHasFlag	(Z)V
    //   645: aload 5
    //   647: getfield 1189	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_fromuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   650: aload_0
    //   651: getfield 64	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   654: invokevirtual 1190	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   657: invokestatic 776	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   660: invokevirtual 1195	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   663: aload 5
    //   665: getfield 1198	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_touin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   668: aload 4
    //   670: getfield 162	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   673: invokestatic 776	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   676: invokevirtual 1195	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   679: aload 5
    //   681: getfield 1201	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_chat_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   684: aload 4
    //   686: getfield 184	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_Int	I
    //   689: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   692: aload 5
    //   694: getfield 1204	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   697: aload 4
    //   699: getfield 172	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_f_of_type_Int	I
    //   702: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   705: aload 4
    //   707: getfield 170	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   710: ifnull +497 -> 1207
    //   713: aload 5
    //   715: getfield 1207	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   718: aload 4
    //   720: getfield 170	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   723: invokestatic 776	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   726: invokevirtual 1195	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   729: aload 5
    //   731: getfield 1210	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_agent_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   734: aload 4
    //   736: getfield 169	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_l_of_type_Int	I
    //   739: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   742: aload 5
    //   744: getfield 1213	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   747: aload 4
    //   749: getfield 191	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_d_of_type_Int	I
    //   752: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   755: new 1215	pttcenterservice/PttShortVideo$PttShortVideoFileInfo
    //   758: dup
    //   759: invokespecial 1216	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:<init>	()V
    //   762: astore 6
    //   764: aload 6
    //   766: getfield 1220	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   769: astore 8
    //   771: aload 4
    //   773: getfield 202	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   776: ifnonnull +443 -> 1219
    //   779: ldc_w 259
    //   782: astore_3
    //   783: aload 8
    //   785: aload_3
    //   786: invokevirtual 1224	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   789: aload 6
    //   791: getfield 1225	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   794: aload 4
    //   796: getfield 262	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_ArrayOfByte	[B
    //   799: invokestatic 293	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   802: invokevirtual 299	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   805: aload 6
    //   807: getfield 1226	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   810: aload 4
    //   812: getfield 263	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_ArrayOfByte	[B
    //   815: invokestatic 293	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   818: invokevirtual 299	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   821: aload 6
    //   823: getfield 1229	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   826: aload 4
    //   828: getfield 249	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_Long	J
    //   831: invokevirtual 1195	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   834: aload 6
    //   836: getfield 1232	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_length	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   839: aload 4
    //   841: getfield 257	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:h	I
    //   844: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   847: aload 6
    //   849: getfield 1235	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   852: aload 4
    //   854: getfield 254	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:i	I
    //   857: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   860: aload 6
    //   862: getfield 1236	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   865: aload 4
    //   867: getfield 206	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:j	I
    //   870: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   873: aload 6
    //   875: getfield 1237	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   878: aload 4
    //   880: getfield 195	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_k_of_type_Int	I
    //   883: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   886: aload 6
    //   888: getfield 1240	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   891: aload 4
    //   893: getfield 253	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_Long	J
    //   896: invokevirtual 1195	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   899: aload 5
    //   901: getfield 1244	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:msg_PttShortVideoFileInfo	Lpttcenterservice/PttShortVideo$PttShortVideoFileInfo;
    //   904: aload 6
    //   906: invokevirtual 1245	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   909: aload 5
    //   911: invokevirtual 1248	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:toByteArray	()[B
    //   914: astore_3
    //   915: new 1250	com/tencent/qphone/base/util/Cryptor
    //   918: dup
    //   919: invokespecial 1251	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   922: aload_3
    //   923: aload_2
    //   924: invokevirtual 1255	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   927: astore_2
    //   928: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: ifeq +69 -> 1000
    //   934: ldc 8
    //   936: iconst_2
    //   937: new 94	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   944: ldc_w 1257
    //   947: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: aload 4
    //   952: getfield 262	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_ArrayOfByte	[B
    //   955: invokestatic 977	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   958: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: ldc_w 1259
    //   964: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: aload 4
    //   969: getfield 263	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_ArrayOfByte	[B
    //   972: invokestatic 977	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   975: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: ldc_w 1261
    //   981: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload_0
    //   985: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   988: invokestatic 977	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   991: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1000: new 1263	vbr
    //   1003: dup
    //   1004: aload_0
    //   1005: lload 11
    //   1007: aload 7
    //   1009: invokespecial 1266	vbr:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoForwardProcessor;JLjava/lang/String;)V
    //   1012: astore_3
    //   1013: aload_0
    //   1014: new 1268	com/tencent/mobileqq/highway/transaction/Transaction
    //   1017: dup
    //   1018: aload_0
    //   1019: getfield 64	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1022: invokevirtual 1190	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1025: bipush 12
    //   1027: aload 7
    //   1029: aload_0
    //   1030: getfield 994	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_Long	J
    //   1033: l2i
    //   1034: aload_1
    //   1035: aload_0
    //   1036: getfield 261	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   1039: aload_3
    //   1040: aload_2
    //   1041: invokespecial 1271	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   1044: putfield 1140	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1047: aload_0
    //   1048: getfield 64	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1051: invokevirtual 1274	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   1054: aload_0
    //   1055: getfield 1140	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1058: invokevirtual 1280	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   1061: istore 10
    //   1063: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1066: ifeq +115 -> 1181
    //   1069: ldc 8
    //   1071: iconst_2
    //   1072: new 94	java/lang/StringBuilder
    //   1075: dup
    //   1076: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1079: ldc_w 1282
    //   1082: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: iload 10
    //   1087: invokevirtual 621	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1090: ldc_w 1284
    //   1093: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: aload_0
    //   1097: getfield 1140	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1100: invokevirtual 1287	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   1103: invokevirtual 621	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1106: ldc_w 1289
    //   1109: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: aload_0
    //   1113: getfield 67	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1116: getfield 152	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   1119: invokevirtual 634	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1122: ldc_w 1291
    //   1125: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: aload_0
    //   1129: getfield 672	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1132: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: ldc_w 1293
    //   1138: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: aload_0
    //   1142: getfield 948	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1145: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: ldc_w 1295
    //   1151: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload_0
    //   1155: getfield 1140	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1158: getfield 1297	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   1161: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: ldc_w 1299
    //   1167: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: bipush 12
    //   1172: invokevirtual 621	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1181: iload 10
    //   1183: ifeq -1128 -> 55
    //   1186: aload_0
    //   1187: iload 10
    //   1189: ldc_w 1301
    //   1192: ldc_w 259
    //   1195: aload_0
    //   1196: getfield 767	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   1199: invokevirtual 770	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   1202: aload_0
    //   1203: invokevirtual 117	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	()V
    //   1206: return
    //   1207: aload 5
    //   1209: getfield 1207	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1212: lconst_0
    //   1213: invokevirtual 1195	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1216: goto -487 -> 729
    //   1219: aload 4
    //   1221: getfield 202	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1224: astore_3
    //   1225: goto -442 -> 783
    //   1228: astore_1
    //   1229: aconst_null
    //   1230: astore 4
    //   1232: aload_3
    //   1233: astore_2
    //   1234: aload 4
    //   1236: astore_3
    //   1237: goto -641 -> 596
    //   1240: astore_1
    //   1241: aload_3
    //   1242: astore_2
    //   1243: aload 4
    //   1245: astore_3
    //   1246: goto -650 -> 596
    //   1249: astore_1
    //   1250: aload_3
    //   1251: astore_2
    //   1252: aload 4
    //   1254: astore_3
    //   1255: goto -659 -> 596
    //   1258: astore_1
    //   1259: aload_3
    //   1260: astore_2
    //   1261: aload 4
    //   1263: astore_3
    //   1264: goto -668 -> 596
    //   1267: astore 5
    //   1269: aconst_null
    //   1270: astore 4
    //   1272: goto -726 -> 546
    //   1275: astore 5
    //   1277: goto -731 -> 546
    //   1280: astore 5
    //   1282: aconst_null
    //   1283: astore 4
    //   1285: goto -809 -> 476
    //   1288: astore 5
    //   1290: goto -814 -> 476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1293	0	this	ShortVideoForwardProcessor
    //   0	1293	1	paramArrayOfByte1	byte[]
    //   0	1293	2	paramArrayOfByte2	byte[]
    //   106	2	3	localFileNotFoundException1	FileNotFoundException
    //   166	2	3	localFileNotFoundException2	FileNotFoundException
    //   197	299	3	localObject1	Object
    //   502	2	3	localIOException1	IOException
    //   520	2	3	localIOException2	IOException
    //   545	21	3	localFileNotFoundException3	FileNotFoundException
    //   572	2	3	localIOException3	IOException
    //   592	9	3	localObject2	Object
    //   614	2	3	localIOException4	IOException
    //   782	482	3	localObject3	Object
    //   4	483	4	localObject4	Object
    //   510	3	4	localIOException5	IOException
    //   528	3	4	localIOException6	IOException
    //   541	16	4	localObject5	Object
    //   580	640	4	localIOException7	IOException
    //   1230	54	4	localObject6	Object
    //   7	470	5	localFileNotFoundException4	FileNotFoundException
    //   538	9	5	localIOException8	IOException
    //   637	571	5	localPttShortVideoUploadReq	pttcenterservice.PttShortVideo.PttShortVideoUploadReq
    //   1267	1	5	localIOException9	IOException
    //   1275	1	5	localIOException10	IOException
    //   1280	1	5	localFileNotFoundException5	FileNotFoundException
    //   1288	1	5	localFileNotFoundException6	FileNotFoundException
    //   1	1	6	localObject7	Object
    //   464	80	6	localFileNotFoundException7	FileNotFoundException
    //   762	143	6	localPttShortVideoFileInfo	pttcenterservice.PttShortVideo.PttShortVideoFileInfo
    //   258	770	7	str	String
    //   301	483	8	localObject8	Object
    //   281	59	9	arrayOfByte	byte[]
    //   454	3	9	localIOException11	IOException
    //   1061	127	10	i	int
    //   182	824	11	l1	long
    //   372	3	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   63	84	106	java/io/FileNotFoundException
    //   126	144	166	java/io/FileNotFoundException
    //   379	384	454	java/io/IOException
    //   260	374	464	java/io/FileNotFoundException
    //   379	384	464	java/io/FileNotFoundException
    //   384	393	464	java/io/FileNotFoundException
    //   456	461	464	java/io/FileNotFoundException
    //   495	499	502	java/io/IOException
    //   415	420	510	java/io/IOException
    //   424	428	520	java/io/IOException
    //   486	491	528	java/io/IOException
    //   260	374	538	java/io/IOException
    //   384	393	538	java/io/IOException
    //   456	461	538	java/io/IOException
    //   565	569	572	java/io/IOException
    //   556	561	580	java/io/IOException
    //   260	374	590	finally
    //   379	384	590	finally
    //   384	393	590	finally
    //   456	461	590	finally
    //   600	604	614	java/io/IOException
    //   608	612	622	java/io/IOException
    //   393	403	1228	finally
    //   403	410	1240	finally
    //   476	481	1249	finally
    //   546	551	1258	finally
    //   393	403	1267	java/io/IOException
    //   403	410	1275	java/io/IOException
    //   393	403	1280	java/io/FileNotFoundException
    //   403	410	1288	java/io/FileNotFoundException
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int j;
      try
      {
        if ((!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)) || (!FileUtils.b(this.jdField_l_of_type_JavaLangString)))
        {
          a(9303, "read file error");
          b();
          return null;
        }
        if (paramInt1 >= this.jdField_l_of_type_Long) {
          break label161;
        }
        this.jdField_b_of_type_JavaIoRandomAccessFile.seek(paramInt1);
        if (this.jdField_l_of_type_Long >= paramInt1 + paramInt2) {
          break label245;
        }
        paramInt1 = (int)(this.jdField_l_of_type_Long - paramInt1);
        byte[] arrayOfByte1 = new byte[paramInt1];
        i = 0;
        paramInt2 = paramInt1;
        if (i >= paramInt1) {
          break label159;
        }
        j = this.jdField_b_of_type_JavaIoRandomAccessFile.read(arrayOfByte1, i, paramInt2);
        if (j == -1)
        {
          a(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
      }
      catch (IOException localIOException)
      {
        a(localIOException);
        localIOException.printStackTrace();
        return null;
      }
      i += j;
      paramInt2 -= j;
      continue;
      label159:
      return localIOException;
      label161:
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(paramInt1 - this.jdField_l_of_type_Long);
      byte[] arrayOfByte2 = new byte[paramInt2];
      int i = 0;
      paramInt1 = paramInt2;
      while (i < paramInt2)
      {
        j = this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte2, i, paramInt1);
        if (j == -1)
        {
          a(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
        i += j;
        paramInt1 -= j;
      }
      return arrayOfByte2;
      label245:
      paramInt1 = paramInt2;
    }
  }
  
  public void b()
  {
    super.b();
    if (-5100026 == this.aU) {
      d(5001);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
      {
        UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
        localSendResult.jdField_a_of_type_Int = -1;
        localSendResult.jdField_b_of_type_Int = this.aU;
        localSendResult.jdField_a_of_type_JavaLangString = this.bc;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      }
      return;
      if (9042 == this.aU) {
        d(5002);
      } else {
        d(1005);
      }
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
    while (!(localMessageRecord instanceof MessageForShortVideo))
    {
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      a("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
    localMessageForShortVideo.videoFileSize = ((int)this.jdField_a_of_type_Long);
    if (this.h == null) {}
    for (String str = this.jdField_i_of_type_JavaLangString;; str = this.h)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoAttr = this.bn;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      return;
    }
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.jdField_m_of_type_Boolean = true;
    }
    return 0;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.n;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      if (this.h == null)
      {
        str = this.jdField_i_of_type_JavaLangString;
        localSendResult.jdField_c_of_type_JavaLangString = str;
        localSendResult.jdField_c_of_type_Long = this.jdField_l_of_type_Long;
        localSendResult.jdField_c_of_type_Int = this.bn;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      }
    }
    for (;;)
    {
      d(1003);
      return;
      str = this.h;
      break;
      b(true);
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if ((this.k) && (1004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  protected void d(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.aH = localOptions.outWidth;
    this.aI = localOptions.outHeight;
  }
  
  public void d(boolean paramBoolean)
  {
    int i1 = 2002;
    int j = 5;
    if (!e()) {}
    Object localObject1;
    label199:
    label226:
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
          break label226;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label199;
        }
      }
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
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof ShortVideoForwardInfo)));
    Object localObject2 = (ShortVideoForwardInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
    DCShortVideo localDCShortVideo = new DCShortVideo(BaseApplication.getContext());
    int i = j;
    switch (((ShortVideoForwardInfo)localObject2).jdField_c_of_type_Int)
    {
    default: 
      i = j;
    case 3: 
      j = i1;
      switch (((ShortVideoForwardInfo)localObject2).j)
      {
      default: 
        j = i1;
      }
      break;
    }
    for (;;)
    {
      localDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ShortVideoForwardInfo)localObject2).h, j, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).frienduin, true, paramBoolean, i, ((ShortVideoForwardInfo)localObject2).jdField_m_of_type_JavaLangString, ((ShortVideoForwardInfo)localObject2).n, ((ShortVideoForwardInfo)localObject2).jdField_e_of_type_JavaLangString);
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 3000;
      break;
      j = 2001;
      continue;
      j = 2003;
    }
  }
  
  void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = a();
    if (localShortVideoForwardReq == null) {}
    do
    {
      return;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_fw";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoForwardReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      a("requestStart", localRichProtoReq.toString());
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void k()
  {
    if (!this.k)
    {
      this.k = true;
      if (QLog.isColorLevel()) {
        a("pause", "");
      }
      d(1004);
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
    if (this.o) {
      return;
    }
    if ((this.jdField_j_of_type_JavaLangString != null) && (this.h != null))
    {
      if (this.jdField_c_of_type_Long >= this.jdField_a_of_type_Long)
      {
        d(false);
        return;
      }
      if ((this.bm == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      a();
      return;
    }
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\ShortVideoForwardProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */