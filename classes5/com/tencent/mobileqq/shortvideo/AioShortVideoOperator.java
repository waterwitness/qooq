package com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import tencent.im.msg.im_msg_body.RichText;

public class AioShortVideoOperator
  extends BaseShortVideoOprerator
{
  private static final String a = "AioShortVideoOperator";
  
  public AioShortVideoOperator() {}
  
  public AioShortVideoOperator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoForwardInfo.jdField_c_of_type_JavaLangString, paramShortVideoForwardInfo.jdField_d_of_type_JavaLangString, paramShortVideoForwardInfo.jdField_b_of_type_Int);
    localMessageForShortVideo.videoFileName = paramShortVideoForwardInfo.jdField_h_of_type_JavaLangString;
    if (paramShortVideoForwardInfo.jdField_a_of_type_JavaLangString == null) {
      paramShortVideoForwardInfo.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.uuid = paramShortVideoForwardInfo.jdField_a_of_type_JavaLangString;
    if (paramShortVideoForwardInfo.jdField_e_of_type_JavaLangString == null) {
      paramShortVideoForwardInfo.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForShortVideo.md5 = paramShortVideoForwardInfo.jdField_e_of_type_JavaLangString;
    localMessageForShortVideo.mLocalMd5 = paramShortVideoForwardInfo.f;
    localMessageForShortVideo.videoFileName = paramShortVideoForwardInfo.jdField_k_of_type_JavaLangString;
    localMessageForShortVideo.videoFileFormat = paramShortVideoForwardInfo.p;
    localMessageForShortVideo.videoFileSize = paramShortVideoForwardInfo.jdField_m_of_type_Int;
    localMessageForShortVideo.videoFileTime = paramShortVideoForwardInfo.n;
    localMessageForShortVideo.thumbWidth = paramShortVideoForwardInfo.jdField_k_of_type_Int;
    localMessageForShortVideo.thumbHeight = paramShortVideoForwardInfo.jdField_l_of_type_Int;
    localMessageForShortVideo.videoFileStatus = 999;
    localMessageForShortVideo.videoFileProgress = 0;
    if (paramShortVideoForwardInfo.jdField_b_of_type_Int == 0)
    {
      localMessageForShortVideo.fileType = 6;
      localMessageForShortVideo.thumbMD5 = paramShortVideoForwardInfo.jdField_g_of_type_JavaLangString;
      if (paramShortVideoForwardInfo.jdField_j_of_type_JavaLangString == null) {
        paramShortVideoForwardInfo.jdField_j_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = paramShortVideoForwardInfo.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      localMessageForShortVideo.thumbFileSize = paramShortVideoForwardInfo.q;
      localMessageForShortVideo.busiType = paramShortVideoForwardInfo.jdField_j_of_type_Int;
      localMessageForShortVideo.fromChatType = paramShortVideoForwardInfo.jdField_c_of_type_Int;
      localMessageForShortVideo.toChatType = paramShortVideoForwardInfo.jdField_d_of_type_Int;
      localMessageForShortVideo.uiOperatorFlag = 2;
      localMessageForShortVideo.supportProgressive = paramShortVideoForwardInfo.jdField_b_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramShortVideoForwardInfo.r;
      localMessageForShortVideo.fileHeight = paramShortVideoForwardInfo.s;
      if (paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo == null) {
        break label433;
      }
      label260:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.b;
        localMessageForShortVideo.msgUid = paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo$RetryInfo.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label438;
      }
    }
    label433:
    label438:
    for (localMessageForShortVideo.msg = "[视频对讲]";; localMessageForShortVideo.msg = "[视频]")
    {
      localMessageForShortVideo.serial();
      paramShortVideoForwardInfo.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "packForwardMsg", "mr: " + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      if (paramShortVideoForwardInfo.jdField_b_of_type_Int == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break;
      }
      if (paramShortVideoForwardInfo.jdField_b_of_type_Int != 1) {
        break;
      }
      localMessageForShortVideo.fileType = 9;
      break;
      i = 0;
      break label260;
    }
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo;
    if (paramShortVideoUploadInfo.jdField_d_of_type_Boolean)
    {
      localMessageForShortVideo = MessageRecordFactory.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 1;
      localMessageForShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_h_of_type_JavaLangString;
      if (paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString == null) {
        paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.uuid = paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString;
      if (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) {
        paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.md5 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoFileFormat = 2;
      localMessageForShortVideo.videoFileSize = paramShortVideoUploadInfo.jdField_e_of_type_Int;
      localMessageForShortVideo.videoFileTime = paramShortVideoUploadInfo.f;
      localMessageForShortVideo.thumbWidth = paramShortVideoUploadInfo.jdField_c_of_type_Int;
      localMessageForShortVideo.thumbHeight = paramShortVideoUploadInfo.jdField_d_of_type_Int;
      localMessageForShortVideo.mThumbFilePath = paramShortVideoUploadInfo.jdField_j_of_type_JavaLangString;
      localMessageForShortVideo.mVideoFileSourceDir = paramShortVideoUploadInfo.jdField_k_of_type_JavaLangString;
      localMessageForShortVideo.videoFileStatus = 999;
      localMessageForShortVideo.videoFileProgress = 0;
      localMessageForShortVideo.extraflag = 32772;
      localMessageForShortVideo.thumbMD5 = paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString;
      if (paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString == null) {
        paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString = "";
      }
      localMessageForShortVideo.fileSource = paramShortVideoUploadInfo.jdField_l_of_type_JavaLangString;
      localMessageForShortVideo.lastModified = 0L;
      if (localMessageForShortVideo.istroop != 0) {
        break label451;
      }
      localMessageForShortVideo.fileType = 6;
      label208:
      if (paramShortVideoUploadInfo.jdField_b_of_type_Int != 1008) {
        break label487;
      }
      localMessageForShortVideo.busiType = 1007;
      label225:
      localMessageForShortVideo.fromChatType = -1;
      localMessageForShortVideo.toChatType = -1;
      localMessageForShortVideo.uiOperatorFlag = 1;
      localMessageForShortVideo.supportProgressive = paramShortVideoUploadInfo.jdField_c_of_type_Boolean;
      localMessageForShortVideo.fileWidth = paramShortVideoUploadInfo.jdField_h_of_type_Int;
      localMessageForShortVideo.fileHeight = paramShortVideoUploadInfo.jdField_i_of_type_Int;
      if (paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo == null) {
        break label527;
      }
      label271:
      if (i != 0)
      {
        localMessageForShortVideo.msgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForShortVideo.shmsgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.b;
        localMessageForShortVideo.msgUid = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_c_of_type_Long;
      }
      if (localMessageForShortVideo.busiType != 2) {
        break label532;
      }
    }
    label451:
    label487:
    label527:
    label532:
    for (localMessageForShortVideo.msg = "[视频对讲]";; localMessageForShortVideo.msg = "[视频]")
    {
      localMessageForShortVideo.serial();
      paramShortVideoUploadInfo.jdField_a_of_type_Long = localMessageForShortVideo.uniseq;
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForShortVideo.toLogString() + "-" + localMessageForShortVideo.toString());
      return localMessageForShortVideo;
      localMessageForShortVideo = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
      localMessageForShortVideo.subBusiType = 0;
      break;
      if (localMessageForShortVideo.istroop == 3000)
      {
        localMessageForShortVideo.fileType = 17;
        break label208;
      }
      if (localMessageForShortVideo.istroop != 1) {
        break label208;
      }
      localMessageForShortVideo.fileType = 9;
      break label208;
      if (2 == paramShortVideoUploadInfo.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 1;
        break label225;
      }
      if (3 == paramShortVideoUploadInfo.jdField_a_of_type_Int)
      {
        localMessageForShortVideo.busiType = 2;
        break label225;
      }
      localMessageForShortVideo.busiType = 0;
      break label225;
      i = 0;
      break label271;
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText)) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public ShortVideoDownloadInfo a(Object paramObject)
  {
    return null;
  }
  
  public ShortVideoForwardInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.b("AioShortVideoOperator", this.f, "createShortVideoForwardInfo", "input == null");
      return null;
    }
    if (paramShortVideoReq == null)
    {
      Logger.b("AioShortVideoOperator", this.f, "createShortVideoForwardInfo", "ShortVideoReq == null");
      return null;
    }
    String str10 = "0";
    String str9 = "0";
    int i1 = 0;
    int i7 = 0;
    int i6 = 0;
    Object localObject2 = "";
    String str8 = "";
    String str7 = "";
    String str6 = "";
    int i5 = 0;
    int i4 = 0;
    String str5 = "";
    String str4 = "";
    int i9 = -1;
    String str3 = "";
    String str2 = "";
    int i3 = 2;
    int i2 = 0;
    int j = 0;
    int n = 0;
    int k = 0;
    String str1 = "0";
    Object localObject3 = "0";
    boolean bool = false;
    int m = 0;
    int i = 0;
    int i8;
    Object localObject1;
    if ((paramObject instanceof Intent))
    {
      localObject3 = (Intent)paramObject;
      str10 = ((Intent)localObject3).getStringExtra("uin");
      str9 = ((Intent)localObject3).getStringExtra("troop_uin");
      i1 = ((Intent)localObject3).getIntExtra("uintype", -1);
      str1 = ((Intent)localObject3).getStringExtra("from_uin");
      i8 = ((Intent)localObject3).getIntExtra("from_uin_type", -1);
      localObject1 = ((Intent)localObject3).getStringExtra("from_session_uin");
      ((Intent)localObject3).getIntExtra("from_busi_type", -1);
      i7 = ((Intent)localObject3).getIntExtra("file_send_size", 0);
      i6 = ((Intent)localObject3).getIntExtra("file_send_duration", -1);
      localObject2 = ((Intent)localObject3).getStringExtra("file_send_path");
      str8 = ((Intent)localObject3).getStringExtra("thumbfile_send_path");
      str7 = ((Intent)localObject3).getStringExtra("file_shortvideo_md5");
      str6 = ((Intent)localObject3).getStringExtra("file_shortvideo_local_md5");
      i5 = ((Intent)localObject3).getIntExtra("thumbfile_send_width", 0);
      i4 = ((Intent)localObject3).getIntExtra("thumbfile_send_height", 0);
      str5 = ((Intent)localObject3).getStringExtra("thumbfile_md5");
      str4 = ((Intent)localObject3).getStringExtra("file_source");
      str3 = ((Intent)localObject3).getStringExtra("file_uuid");
      str2 = ((Intent)localObject3).getStringExtra("file_name");
      i3 = ((Intent)localObject3).getIntExtra("file_format", 2);
      i2 = ((Intent)localObject3).getIntExtra("file_thumb_Size", 0);
      bool = ((Intent)localObject3).getBooleanExtra("support_progressive", false);
      m = ((Intent)localObject3).getIntExtra("file_width", 0);
      i = ((Intent)localObject3).getIntExtra("file_height", 0);
    }
    while (TextUtils.isEmpty(str7))
    {
      Logger.b(paramShortVideoReq.b, paramShortVideoReq.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "md5 shouldn't be empty ");
      return null;
      localObject1 = localObject3;
      i8 = i9;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject1 = (MessageForShortVideo)paramObject;
        str10 = ((MessageForShortVideo)localObject1).frienduin;
        str9 = ((MessageForShortVideo)localObject1).frienduin;
        i1 = ((MessageForShortVideo)localObject1).istroop;
        i7 = ((MessageForShortVideo)localObject1).videoFileSize;
        i6 = ((MessageForShortVideo)localObject1).videoFileTime;
        str2 = ((MessageForShortVideo)localObject1).videoFileName;
        str8 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
        str7 = ((MessageForShortVideo)localObject1).md5;
        str6 = ((MessageForShortVideo)localObject1).mLocalMd5;
        i5 = ((MessageForShortVideo)localObject1).thumbWidth;
        i4 = ((MessageForShortVideo)localObject1).thumbHeight;
        str5 = ((MessageForShortVideo)localObject1).thumbMD5;
        str4 = ((MessageForShortVideo)localObject1).fileSource;
        str3 = ((MessageForShortVideo)localObject1).uuid;
        i3 = ((MessageForShortVideo)localObject1).videoFileFormat;
        i2 = ((MessageForShortVideo)localObject1).thumbFileSize;
        j = ((MessageForShortVideo)localObject1).fromChatType;
        n = ((MessageForShortVideo)localObject1).toChatType;
        k = ((MessageForShortVideo)localObject1).busiType;
        str1 = ShortVideoUtils.c((MessageForShortVideo)localObject1);
        bool = ((MessageForShortVideo)localObject1).supportProgressive;
        m = ((MessageForShortVideo)localObject1).fileWidth;
        i = ((MessageForShortVideo)localObject1).fileHeight;
        localObject2 = str2;
        localObject1 = localObject3;
        i8 = i9;
      }
    }
    localObject3 = new ShortVideoForwardInfo();
    ((ShortVideoForwardInfo)localObject3).jdField_c_of_type_JavaLangString = str10;
    ((ShortVideoForwardInfo)localObject3).jdField_h_of_type_JavaLangString = ((String)localObject2);
    ((ShortVideoForwardInfo)localObject3).jdField_i_of_type_JavaLangString = str8;
    ((ShortVideoForwardInfo)localObject3).jdField_b_of_type_Int = i1;
    ((ShortVideoForwardInfo)localObject3).jdField_d_of_type_JavaLangString = str9;
    ((ShortVideoForwardInfo)localObject3).jdField_m_of_type_Int = i7;
    ((ShortVideoForwardInfo)localObject3).n = i6;
    ((ShortVideoForwardInfo)localObject3).jdField_e_of_type_JavaLangString = str7;
    ((ShortVideoForwardInfo)localObject3).f = str6;
    ((ShortVideoForwardInfo)localObject3).jdField_k_of_type_Int = i5;
    ((ShortVideoForwardInfo)localObject3).jdField_l_of_type_Int = i4;
    ((ShortVideoForwardInfo)localObject3).o = paramShortVideoReq.f;
    ((ShortVideoForwardInfo)localObject3).jdField_a_of_type_JavaLangObject = paramObject;
    ((ShortVideoForwardInfo)localObject3).jdField_g_of_type_JavaLangString = str5;
    ((ShortVideoForwardInfo)localObject3).jdField_j_of_type_JavaLangString = str4;
    ((ShortVideoForwardInfo)localObject3).jdField_a_of_type_JavaLangString = str3;
    ((ShortVideoForwardInfo)localObject3).jdField_k_of_type_JavaLangString = str2;
    ((ShortVideoForwardInfo)localObject3).p = i3;
    ((ShortVideoForwardInfo)localObject3).q = i2;
    ((ShortVideoForwardInfo)localObject3).jdField_b_of_type_Boolean = bool;
    ((ShortVideoForwardInfo)localObject3).r = m;
    ((ShortVideoForwardInfo)localObject3).s = i;
    ((ShortVideoForwardInfo)localObject3).jdField_l_of_type_JavaLangString = str1;
    if (localObject1 != null)
    {
      ((ShortVideoForwardInfo)localObject3).jdField_m_of_type_JavaLangString = ((String)localObject1);
      if (!(paramObject instanceof Intent)) {
        break label975;
      }
      if (i8 != 0) {
        break label899;
      }
      j = 0;
      label799:
      if (i1 != 0) {
        break label931;
      }
      i = 0;
      m = j;
      label811:
      if (i8 != 1008) {
        break label1063;
      }
      j = 1007;
    }
    for (;;)
    {
      ((ShortVideoForwardInfo)localObject3).jdField_c_of_type_Int = m;
      ((ShortVideoForwardInfo)localObject3).jdField_d_of_type_Int = i;
      ((ShortVideoForwardInfo)localObject3).jdField_i_of_type_Int = j;
      ((ShortVideoForwardInfo)localObject3).jdField_j_of_type_Int = k;
      Logger.a(paramShortVideoReq.b, paramShortVideoReq.jdField_a_of_type_JavaLangString, "createShortVideoForwardInfo", "" + ((ShortVideoForwardInfo)localObject3).toLogString());
      return (ShortVideoForwardInfo)localObject3;
      localObject1 = "0";
      break;
      label899:
      if (i8 == 1)
      {
        j = 1;
        break label799;
      }
      if (i8 == 3000)
      {
        j = 2;
        break label799;
      }
      j = 3;
      break label799;
      label931:
      if (i1 == 1)
      {
        i = 1;
        m = j;
        break label811;
      }
      if (i1 == 3000)
      {
        i = 2;
        m = j;
        break label811;
      }
      i = 3;
      m = j;
      break label811;
      label975:
      i = n;
      m = j;
      if (!(paramObject instanceof MessageForShortVideo)) {
        break label811;
      }
      i = n;
      m = j;
      if (n != -1) {
        break label811;
      }
      if (i1 == 0)
      {
        i = 0;
        m = j;
        break label811;
      }
      if (i1 == 1)
      {
        i = 1;
        m = j;
        break label811;
      }
      if (i1 == 3000)
      {
        i = 2;
        m = j;
        break label811;
      }
      i = 3;
      m = j;
      break label811;
      label1063:
      if (2 == paramShortVideoReq.jdField_g_of_type_Int)
      {
        k = 1;
        j = 1;
      }
      else if (3 == paramShortVideoReq.jdField_g_of_type_Int)
      {
        k = 2;
        j = 2;
      }
      else
      {
        k = 0;
        j = 0;
      }
    }
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    String str8 = "0";
    String str7 = "0";
    int i2 = 0;
    long l = 0L;
    int i1 = 0;
    int n = 0;
    String str6 = "";
    String str5 = "";
    String str4 = "";
    String str3 = "";
    int m = 0;
    int k = 0;
    String str2 = "";
    String str1 = "";
    boolean bool = false;
    int j = 0;
    int i = 0;
    Object localObject;
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      str8 = ((Intent)localObject).getStringExtra("uin");
      str7 = ((Intent)localObject).getStringExtra("troop_uin");
      i2 = ((Intent)localObject).getIntExtra("uintype", 1003);
      l = ((Intent)localObject).getLongExtra("file_send_size", 0L);
      i1 = ((Intent)localObject).getIntExtra("file_send_business_type", 0);
      n = ((Intent)localObject).getIntExtra("file_send_duration", -1);
      str6 = ((Intent)localObject).getStringExtra("file_send_path");
      str5 = ((Intent)localObject).getStringExtra("thumbfile_send_path");
      str3 = ((Intent)localObject).getStringExtra("file_shortvideo_md5");
      m = ((Intent)localObject).getIntExtra("thumbfile_send_width", 0);
      k = ((Intent)localObject).getIntExtra("thumbfile_send_height", 0);
      str2 = ((Intent)localObject).getStringExtra("thumbfile_md5");
      str1 = ((Intent)localObject).getStringExtra("file_source");
      str4 = ((Intent)localObject).getStringExtra("file_video_source_dir");
      bool = ((Intent)localObject).getBooleanExtra("support_progressive", false);
      j = ((Intent)localObject).getIntExtra("file_width", 0);
      i = ((Intent)localObject).getIntExtra("file_height", 0);
    }
    for (;;)
    {
      localObject = new ShortVideoUploadInfo();
      ((ShortVideoUploadInfo)localObject).jdField_c_of_type_JavaLangString = str8;
      ((ShortVideoUploadInfo)localObject).jdField_h_of_type_JavaLangString = str6;
      ((ShortVideoUploadInfo)localObject).jdField_j_of_type_JavaLangString = str5;
      ((ShortVideoUploadInfo)localObject).jdField_b_of_type_Int = i2;
      ((ShortVideoUploadInfo)localObject).jdField_d_of_type_JavaLangString = str7;
      ((ShortVideoUploadInfo)localObject).jdField_e_of_type_Int = ((int)l);
      ((ShortVideoUploadInfo)localObject).f = n;
      ((ShortVideoUploadInfo)localObject).jdField_e_of_type_JavaLangString = str3;
      ((ShortVideoUploadInfo)localObject).jdField_c_of_type_Int = m;
      ((ShortVideoUploadInfo)localObject).jdField_d_of_type_Int = k;
      ((ShortVideoUploadInfo)localObject).jdField_g_of_type_Int = paramShortVideoReq.f;
      ((ShortVideoUploadInfo)localObject).jdField_a_of_type_JavaLangObject = paramObject;
      ((ShortVideoUploadInfo)localObject).jdField_g_of_type_JavaLangString = str2;
      ((ShortVideoUploadInfo)localObject).jdField_l_of_type_JavaLangString = str1;
      ((ShortVideoUploadInfo)localObject).jdField_k_of_type_JavaLangString = str4;
      ((ShortVideoUploadInfo)localObject).jdField_a_of_type_Int = i1;
      ((ShortVideoUploadInfo)localObject).jdField_c_of_type_Boolean = bool;
      ((ShortVideoUploadInfo)localObject).jdField_h_of_type_Int = j;
      ((ShortVideoUploadInfo)localObject).jdField_i_of_type_Int = i;
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return (ShortVideoUploadInfo)localObject;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        str8 = ((MessageForShortVideo)localObject).frienduin;
        str7 = ((MessageForShortVideo)localObject).frienduin;
        i2 = ((MessageForShortVideo)localObject).istroop;
        l = ((MessageForShortVideo)localObject).videoFileSize;
        i1 = paramShortVideoReq.jdField_g_of_type_Int;
        n = ((MessageForShortVideo)localObject).videoFileTime;
        str6 = ((MessageForShortVideo)localObject).videoFileName;
        str5 = ShortVideoUtils.a(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        str3 = ((MessageForShortVideo)localObject).md5;
        m = ((MessageForShortVideo)localObject).thumbWidth;
        k = ((MessageForShortVideo)localObject).thumbHeight;
        str2 = ((MessageForShortVideo)localObject).thumbMD5;
        str1 = ((MessageForShortVideo)localObject).fileSource;
        str4 = ((MessageForShortVideo)localObject).mVideoFileSourceDir;
        bool = ((MessageForShortVideo)localObject).supportProgressive;
        j = ((MessageForShortVideo)localObject).fileWidth;
        i = ((MessageForShortVideo)localObject).fileHeight;
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "updateMsg", "resut:" + paramSendResult);
    if (paramSendResult != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramSendResult.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramSendResult.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.thumbFileSize = ((int)paramSendResult.jdField_c_of_type_Long);
      localMessageForShortVideo.videoAttr = paramSendResult.jdField_c_of_type_Int;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\AioShortVideoOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */