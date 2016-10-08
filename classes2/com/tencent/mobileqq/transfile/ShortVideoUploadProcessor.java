package com.tencent.mobileqq.transfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShortVideoTransManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.PicInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoReqExtInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureReqInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.ShortVideoUpHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;
import vbw;
import vbx;
import vcb;
import vcc;
import vcd;
import vce;
import vcf;
import vcg;
import vch;

public class ShortVideoUploadProcessor
  extends BaseUploadProcessor
{
  public static final int aH = 1;
  public static final int aI = 2;
  public static final int aJ = 3;
  static final int aK = 1;
  static final int aL = 2;
  static final int bB = 16;
  static final int bC = 1;
  static final int bD = 2;
  static final int bE = 3;
  static final int bF = 4;
  static final int bG = 5;
  static final int bn = 3;
  public static final int bo = 0;
  public static final int bp = 2;
  public static final int bq = 3;
  public static final int br = 0;
  public static final int bs = 1;
  public static final int bt = 2;
  public static final int bu = 3;
  public static final int bv = 4;
  public static final String d = "ShortVideoUploadProcessor";
  public static boolean f = false;
  public static final String k = "QQ_&_MoblieQQ_&_QQ";
  static final long n = 480000L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  public QQAppInterface a;
  protected ShortVideoTransManager a;
  protected ShortVideoUpInfo a;
  public Bdh_extinfo.PicInfo a;
  public RequestAck a;
  Boolean jdField_a_of_type_JavaLangBoolean;
  public AtomicBoolean a;
  private vch jdField_a_of_type_Vch;
  public RandomAccessFile b;
  public HashMap b;
  public List b;
  public AtomicBoolean b;
  public byte[] b;
  int bA;
  public int bH;
  private int bI;
  private volatile int bJ;
  private volatile int bK;
  private int bL;
  private volatile int bM;
  private int bN;
  private String bl;
  protected int bw;
  protected int bx;
  public int by;
  int bz;
  public List c;
  public AtomicBoolean c;
  private byte[] c;
  private byte[] d;
  public BaseTransProcessor.StepInfo e;
  boolean g;
  private volatile boolean h;
  public long l;
  public String l;
  protected long m;
  public long o;
  public long p;
  public long q;
  public long r;
  private long s;
  
  public ShortVideoUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.bz = -1;
    this.bA = 0;
    this.s = 480000L;
    this.bJ = 0;
    this.bK = 0;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.g = false;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vcb(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.bI = 1;
    f = VideoUpConfigInfo.sIsPreSendSignal;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>is preSendAckToBDHServer :" + f);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
    for (this.bz = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; this.bz = 0)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean)
      {
        paramTransFileController = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
        paramTransferRequest = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
        if (4 == paramTransferRequest.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
        }
        a(9304, "path =" + paramTransFileController);
        b();
        this.jdField_o_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString = paramTransferRequest[0];
    this.jdField_l_of_type_JavaLangString = paramTransferRequest[1];
    this.by = Integer.parseInt(paramTransferRequest[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "Init params videoTime : " + this.by);
    }
    this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(paramTransferRequest[3]);
  }
  
  private RichProto.RichProtoReq.ShortVideoUpReq a()
  {
    int j = 1;
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = new RichProto.RichProtoReq.ShortVideoUpReq();
    localShortVideoUpReq.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localShortVideoUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    String str;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV)))
    {
      Object localObject = (MessageForBlessPTV)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (((MessageForBlessPTV)localObject).uinList != null)
      {
        str = (String)((MessageForBlessPTV)localObject).uinList.get(0);
        localShortVideoUpReq.jdField_d_of_type_JavaLangString = str;
        localShortVideoUpReq.k = 1;
        if (((MessageForBlessPTV)localObject).uinList == null) {
          break label425;
        }
        i = ((MessageForBlessPTV)localObject).uinList.size();
        label113:
        localShortVideoUpReq.l = i;
        label119:
        localShortVideoUpReq.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
        localShortVideoUpReq.i = 0;
        if ((localShortVideoUpReq.jdField_e_of_type_Int != 0) && (1008 != localShortVideoUpReq.jdField_e_of_type_Int)) {
          break label455;
        }
        localShortVideoUpReq.jdField_b_of_type_JavaLangString = null;
        label157:
        if (localShortVideoUpReq.jdField_e_of_type_Int != 0) {
          break label469;
        }
        localShortVideoUpReq.jdField_a_of_type_Int = 0;
        label169:
        localShortVideoUpReq.jdField_b_of_type_Int = 2;
        localObject = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString);
        str = ((File)localObject).getName();
        localShortVideoUpReq.jdField_a_of_type_JavaLangString = str;
        localShortVideoUpReq.jdField_a_of_type_Long = ((File)localObject).length();
        localShortVideoUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        localShortVideoUpReq.jdField_b_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        localShortVideoUpReq.jdField_f_of_type_Int = this.bw;
        localShortVideoUpReq.jdField_d_of_type_Int = this.bx;
        localShortVideoUpReq.h = this.by;
        localShortVideoUpReq.jdField_b_of_type_Long = this.jdField_l_of_type_Long;
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
        long l1 = localShortVideoUpReq.jdField_a_of_type_Long + this.jdField_l_of_type_Long;
        this.jdField_a_of_type_Long = l1;
        ((FileMsg)localObject).jdField_a_of_type_Long = l1;
        str = str.substring(str.lastIndexOf(".") + 1);
        if (!"avi".equals(str)) {
          break label511;
        }
        i = 2;
      }
    }
    for (;;)
    {
      label310:
      localShortVideoUpReq.g = i;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResLength", String.valueOf(this.bx));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResWidth", String.valueOf(this.bw));
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
      for (localShortVideoUpReq.j = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; localShortVideoUpReq.j = 0)
      {
        this.bz = localShortVideoUpReq.j;
        return localShortVideoUpReq;
        str = "0";
        break;
        label425:
        i = 1;
        break label113;
        localShortVideoUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
        localShortVideoUpReq.k = 0;
        localShortVideoUpReq.l = 1;
        break label119;
        label455:
        localShortVideoUpReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
        break label157;
        label469:
        if (1 == localShortVideoUpReq.jdField_e_of_type_Int)
        {
          localShortVideoUpReq.jdField_a_of_type_Int = 1;
          break label169;
        }
        if (3000 == localShortVideoUpReq.jdField_e_of_type_Int)
        {
          localShortVideoUpReq.jdField_a_of_type_Int = 2;
          break label169;
        }
        localShortVideoUpReq.jdField_a_of_type_Int = 3;
        break label169;
        label511:
        if ("mp4".equals(str))
        {
          i = 3;
          break label310;
        }
        if ("wmv".equals(str))
        {
          i = 4;
          break label310;
        }
        if ("mkv".equals(str))
        {
          i = 5;
          break label310;
        }
        if ("rmvb".equals(str))
        {
          i = 6;
          break label310;
        }
        if ("rm".equals(str))
        {
          i = 7;
          break label310;
        }
        if ("afs".equals(str))
        {
          i = 8;
          break label310;
        }
        if ("mov".equals(str))
        {
          i = 9;
          break label310;
        }
        if ("mod".equals(str))
        {
          i = 10;
          break label310;
        }
        i = j;
        if ("ts".equals(str)) {
          break label310;
        }
        if (!"mts".equals(str)) {
          break label683;
        }
        i = 11;
        break label310;
      }
      label683:
      i = -1;
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
        localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString));
        localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f)));
        localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_h_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "mResid uuid=" + this.jdField_h_of_type_JavaLangString);
        }
        localVideoFile.uint32_file_format.set(2);
        localVideoFile.uint32_file_size.set((int)(this.jdField_a_of_type_Long - this.jdField_l_of_type_Long));
        localVideoFile.uint32_file_time.set(this.by);
        localVideoFile.uint32_thumb_width.set(this.bw);
        localVideoFile.uint32_thumb_height.set(this.bx);
        localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
        localVideoFile.uint32_thumb_file_size.set((int)this.jdField_l_of_type_Long);
        localVideoFile.uint32_from_chat_type.set(-1);
        localVideoFile.uint32_to_chat_type.set(-1);
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))
        {
          Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (localObject1 != null)
          {
            localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
            localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
            localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
            localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
            localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
            localVideoFile.uint32_sub_busi_type.set(((MessageForShortVideo)localObject1).subBusiType);
          }
          localVideoFile.uint32_video_attr.set(this.bN);
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
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (!ShortVideoUploadABTest.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString)) {}
    while (!ShortVideoUploadABTest.a()) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (ShortVideoUploadABTest.jdField_a_of_type_JavaLangObject)
      {
        QLog.d("ShortVideoUploadProcessor", 2, "VideoABTest : uinSeq" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " Switcher:" + this.bI + " videoTime:" + this.by);
        this.r = SystemClock.uptimeMillis();
        ShortVideoUploadABTest.ABTestInfo localABTestInfo = ShortVideoUploadABTest.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        localABTestInfo.g = this.bL;
        localABTestInfo.jdField_f_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long);
        localABTestInfo.jdField_f_of_type_Int = this.by;
        localABTestInfo.h = (this.r - this.p);
        localABTestInfo.k = (this.r - this.q);
        localABTestInfo.jdField_l_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
        if (paramBoolean)
        {
          i = 0;
          localABTestInfo.jdField_e_of_type_Int = i;
          localABTestInfo.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
          localABTestInfo.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
          localABTestInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
          localABTestInfo.jdField_d_of_type_JavaLangString = paramString;
          localABTestInfo.jdField_b_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
          localABTestInfo.r = this.by;
          localABTestInfo.n = paramLong;
          localABTestInfo.p = this.jdField_a_of_type_Long;
          if (this.bI != 3)
          {
            localABTestInfo.jdField_e_of_type_Long = ShortVideoUploadABTest.jdField_a_of_type_Long;
            localABTestInfo.jdField_c_of_type_Long = ShortVideoUploadABTest.jdField_b_of_type_Long;
            localABTestInfo.jdField_j_of_type_Long = ShortVideoUploadABTest.jdField_c_of_type_Long;
            localABTestInfo.i = ShortVideoUploadABTest.jdField_d_of_type_Long;
          }
          localABTestInfo.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";");
          paramString = new StringBuilder();
          i = 0;
          if (i < this.jdField_b_of_type_JavaUtilList.size() + 1)
          {
            localObject1 = (BaseTransProcessor.StepInfo)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
            if (localObject1 == null) {
              break label537;
            }
            paramString.append(String.valueOf(((BaseTransProcessor.StepInfo)localObject1).a()));
            paramString.append("_");
            break label537;
          }
        }
        else
        {
          i = this.aU;
          continue;
        }
        Object localObject1 = paramString.toString();
        paramString = (String)localObject1;
        if (((String)localObject1).length() > 0) {
          paramString = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localABTestInfo.jdField_e_of_type_JavaLangString = paramString;
        ShortVideoUploadABTest.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long, this.bI);
        return;
      }
      label537:
      i += 1;
    }
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
  
  private void y()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    int i;
    label76:
    Object localObject2;
    long l2;
    if (this.bI == 3)
    {
      i = 1;
      ((HashMap)localObject1).put("param_isPreUpload", String.valueOf(i));
      if (this.bL != 1) {
        break label496;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rollback", this.bL + "_" + this.bH);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_sessionID", String.valueOf(this.jdField_o_of_type_Long));
      if (this.jdField_b_of_type_ArrayOfByte != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbMd5", HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte));
      }
      localObject1 = ShortVideoPresendStats.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_trans", localObject2);
      if (this.bI != 3) {
        break label517;
      }
      if ((this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long > 0L) && (((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long > 0L) && (this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long / 1000000L - ((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long > 0L))
      {
        l1 = this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long / 1000000L;
        l2 = ((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_wait", String.valueOf(l1 - l2 - 400L));
      }
      label290:
      if ((this.bI == 3) && (((ShortVideoPresendStats.ReportInfo)localObject1).jdField_c_of_type_Long > 0L)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_comp", String.valueOf(((ShortVideoPresendStats.ReportInfo)localObject1).jdField_c_of_type_Long));
      }
      if ((((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long <= 0L) || (((ShortVideoPresendStats.ReportInfo)localObject1).jdField_d_of_type_Long <= 0L)) {
        break label640;
      }
    }
    label496:
    label517:
    label640:
    for (long l1 = ((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long - ((ShortVideoPresendStats.ReportInfo)localObject1).jdField_d_of_type_Long;; l1 = 0L)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_timeBeforeSend", String.valueOf(l1));
      if (((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_recordTimes", String.valueOf(((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Int));
      }
      ShortVideoPresendStats.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
      if (this.bI == 3)
      {
        localObject1 = new StringBuilder();
        i = 0;
        for (;;)
        {
          if (i < this.jdField_b_of_type_JavaUtilList.size() + 1)
          {
            localObject2 = (BaseTransProcessor.StepInfo)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
            if (localObject2 != null)
            {
              ((StringBuilder)localObject1).append(String.valueOf(((BaseTransProcessor.StepInfo)localObject2).a()));
              ((StringBuilder)localObject1).append("_");
            }
            i += 1;
            continue;
            i = 0;
            break;
            this.jdField_a_of_type_JavaUtilHashMap.put("param_rollback", String.valueOf(this.bL));
            break label76;
            if ((this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long <= 0L) || (ShortVideoPresendStats.jdField_b_of_type_Long <= 0L) || (this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long / 1000000L - ShortVideoPresendStats.jdField_b_of_type_Long <= 0L)) {
              break label290;
            }
            l1 = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long / 1000000L;
            l2 = ShortVideoPresendStats.jdField_b_of_type_Long;
            this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_wait", String.valueOf(l1 - l2 - 400L));
            break label290;
          }
        }
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = localObject2;
        if (((String)localObject2).length() > 0) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_s_segs", localObject1);
      }
      return;
    }
  }
  
  private void z()
  {
    w();
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "rollback", "rollBackToSendFileByBDH RollBack with reason:" + this.bL + ",mCancelCode = " + this.bH);
      u();
    } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a == null));
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new vcg(this));
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "resume()  + mIsPause : " + this.k);
    }
    if (this.k)
    {
      this.k = false;
      this.jdField_o_of_type_Boolean = false;
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
      x();
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new vbw(this));
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
    paramArrayOfByte = new StringBuilder();
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
    paramArrayOfByte.append(this.jdField_h_of_type_JavaLangString);
    paramArrayOfByte.append("&filesize=");
    paramArrayOfByte.append(this.jdField_a_of_type_Long);
    paramArrayOfByte.append("&bmd5=");
    paramArrayOfByte.append((String)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- lastukey = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
        QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- lastip = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV))) {
      paramArrayOfByte.append("&subvideotype=").append(1);
    }
    a("getConnUrl", "url = " + paramArrayOfByte.toString());
    return paramArrayOfByte.toString();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 242	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_o_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 36
    //   16: iconst_2
    //   17: ldc_w 946
    //   20: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 947	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	()V
    //   27: aload_0
    //   28: sipush 1001
    //   31: invokevirtual 825	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(I)V
    //   34: aload_0
    //   35: getfield 346	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   38: invokevirtual 948	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   41: invokestatic 586	com/tencent/mobileqq/transfile/ShortVideoUploadABTest:a	()Z
    //   44: ifeq +10 -> 54
    //   47: aload_0
    //   48: invokestatic 603	android/os/SystemClock:uptimeMillis	()J
    //   51: putfield 622	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:p	J
    //   54: aload_0
    //   55: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   58: getfield 223	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_Boolean	Z
    //   61: ifeq +144 -> 205
    //   64: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +12 -> 79
    //   70: ldc 36
    //   72: iconst_2
    //   73: ldc_w 950
    //   76: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_0
    //   80: iconst_3
    //   81: putfield 175	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bI	I
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   89: getfield 951	com/tencent/mobileqq/transfile/TransferRequest:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   92: putfield 244	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   100: getfield 953	com/tencent/mobileqq/transfile/TransferRequest:k	Ljava/lang/String;
    //   103: invokestatic 263	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   106: putfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   109: aload_0
    //   110: invokevirtual 955	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:g	()V
    //   113: aload_0
    //   114: getfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   117: ifnonnull +345 -> 462
    //   120: new 957	java/io/FileInputStream
    //   123: dup
    //   124: aload_0
    //   125: getfield 244	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   128: invokespecial 958	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   131: astore_2
    //   132: aload_2
    //   133: astore_1
    //   134: aload_0
    //   135: aload_2
    //   136: lconst_0
    //   137: invokestatic 961	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   140: putfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   143: aload_2
    //   144: astore_1
    //   145: aload_0
    //   146: getfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   149: ifnonnull +305 -> 454
    //   152: aload_2
    //   153: astore_1
    //   154: aload_0
    //   155: sipush 9041
    //   158: new 190	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 963
    //   168: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: getfield 244	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   175: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokevirtual 238	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   184: aload_2
    //   185: astore_1
    //   186: aload_0
    //   187: invokevirtual 240	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   190: aload_2
    //   191: ifnull -184 -> 7
    //   194: aload_2
    //   195: invokevirtual 966	java/io/FileInputStream:close	()V
    //   198: return
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   204: return
    //   205: aload_0
    //   206: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   209: getfield 444	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   212: invokestatic 973	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +40 -> 255
    //   218: aload_0
    //   219: aload_0
    //   220: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   223: getfield 444	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   226: invokestatic 263	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   229: putfield 327	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   232: aload_0
    //   233: getfield 346	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   236: astore_1
    //   237: aload_0
    //   238: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   241: getfield 444	com/tencent/mobileqq/transfile/TransferRequest:f	Ljava/lang/String;
    //   244: astore_2
    //   245: aload_1
    //   246: aload_2
    //   247: putfield 974	com/tencent/mobileqq/transfile/FileMsg:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   250: aload_0
    //   251: aload_2
    //   252: putfield 636	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   255: aload_0
    //   256: getfield 327	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   259: ifnonnull +15 -> 274
    //   262: aload_0
    //   263: invokevirtual 976	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:f	()Z
    //   266: ifne +8 -> 274
    //   269: aload_0
    //   270: invokevirtual 240	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   273: return
    //   274: aload_0
    //   275: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   278: getfield 225	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   281: invokestatic 981	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   284: ifne +18 -> 302
    //   287: aload_0
    //   288: sipush 9042
    //   291: ldc_w 983
    //   294: invokevirtual 238	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   297: aload_0
    //   298: invokevirtual 240	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   301: return
    //   302: aload_0
    //   303: getfield 985	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   306: ifnonnull +59 -> 365
    //   309: aload_0
    //   310: new 987	java/io/RandomAccessFile
    //   313: dup
    //   314: aload_0
    //   315: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   318: getfield 225	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   321: ldc_w 988
    //   324: invokespecial 990	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: putfield 985	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   330: aload_0
    //   331: getfield 985	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   334: ifnonnull +31 -> 365
    //   337: aload_0
    //   338: sipush 9303
    //   341: ldc_w 992
    //   344: invokevirtual 238	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   347: aload_0
    //   348: invokevirtual 240	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   351: return
    //   352: astore_1
    //   353: aload_1
    //   354: invokevirtual 993	java/io/FileNotFoundException:printStackTrace	()V
    //   357: aload_0
    //   358: aconst_null
    //   359: putfield 985	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   362: goto -32 -> 330
    //   365: aload_0
    //   366: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   369: getfield 215	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   372: checkcast 217	com/tencent/mobileqq/data/MessageForShortVideo
    //   375: getfield 220	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   378: iconst_1
    //   379: if_icmpne +43 -> 422
    //   382: getstatic 996	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sSwitch	I
    //   385: iconst_2
    //   386: if_icmpne +8 -> 394
    //   389: aload_0
    //   390: iconst_2
    //   391: putfield 175	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bI	I
    //   394: getstatic 997	com/tencent/mobileqq/transfile/ShortVideoPresendStats:jdField_a_of_type_Long	J
    //   397: lconst_0
    //   398: lcmp
    //   399: ifle -286 -> 113
    //   402: aload_0
    //   403: getfield 369	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   406: ldc_w 764
    //   409: getstatic 997	com/tencent/mobileqq/transfile/ShortVideoPresendStats:jdField_a_of_type_Long	J
    //   412: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   415: invokevirtual 377	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   418: pop
    //   419: goto -306 -> 113
    //   422: aload_0
    //   423: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   426: getfield 215	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   429: checkcast 217	com/tencent/mobileqq/data/MessageForShortVideo
    //   432: getfield 220	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   435: iconst_2
    //   436: if_icmpne -42 -> 394
    //   439: getstatic 1000	com/tencent/mobileqq/highway/utils/PTVUpConfigInfo:sSwitch	I
    //   442: iconst_2
    //   443: if_icmpne -49 -> 394
    //   446: aload_0
    //   447: iconst_2
    //   448: putfield 175	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bI	I
    //   451: goto -57 -> 394
    //   454: aload_2
    //   455: ifnull +7 -> 462
    //   458: aload_2
    //   459: invokevirtual 966	java/io/FileInputStream:close	()V
    //   462: aload_0
    //   463: getfield 1002	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   466: ifnonnull +123 -> 589
    //   469: aload_0
    //   470: new 987	java/io/RandomAccessFile
    //   473: dup
    //   474: aload_0
    //   475: getfield 244	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   478: ldc_w 988
    //   481: invokespecial 990	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: putfield 1002	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   487: aload_0
    //   488: getfield 1002	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   491: ifnonnull +98 -> 589
    //   494: aload_0
    //   495: sipush 9303
    //   498: ldc_w 1004
    //   501: invokevirtual 238	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   504: aload_0
    //   505: invokevirtual 240	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   508: return
    //   509: astore_1
    //   510: aload_1
    //   511: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   514: goto -52 -> 462
    //   517: astore_3
    //   518: aconst_null
    //   519: astore_2
    //   520: aload_2
    //   521: astore_1
    //   522: aload_0
    //   523: aconst_null
    //   524: putfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   527: aload_2
    //   528: astore_1
    //   529: aload_0
    //   530: aload_3
    //   531: invokevirtual 1007	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/io/IOException;)V
    //   534: aload_2
    //   535: astore_1
    //   536: aload_0
    //   537: invokevirtual 240	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   540: aload_2
    //   541: ifnull -534 -> 7
    //   544: aload_2
    //   545: invokevirtual 966	java/io/FileInputStream:close	()V
    //   548: return
    //   549: astore_1
    //   550: aload_1
    //   551: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   554: return
    //   555: astore_2
    //   556: aconst_null
    //   557: astore_1
    //   558: aload_1
    //   559: ifnull +7 -> 566
    //   562: aload_1
    //   563: invokevirtual 966	java/io/FileInputStream:close	()V
    //   566: aload_2
    //   567: athrow
    //   568: astore_1
    //   569: aload_1
    //   570: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   573: goto -7 -> 566
    //   576: astore_1
    //   577: aload_1
    //   578: invokevirtual 993	java/io/FileNotFoundException:printStackTrace	()V
    //   581: aload_0
    //   582: aconst_null
    //   583: putfield 1002	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   586: goto -99 -> 487
    //   589: aload_0
    //   590: new 312	java/io/File
    //   593: dup
    //   594: aload_0
    //   595: getfield 244	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   598: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   601: invokevirtual 324	java/io/File:length	()J
    //   604: putfield 341	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_Long	J
    //   607: aload_0
    //   608: aload_0
    //   609: getfield 244	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   612: invokevirtual 1009	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(Ljava/lang/String;)V
    //   615: ldc_w 1011
    //   618: monitorenter
    //   619: aload_0
    //   620: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   623: getfield 278	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   626: invokestatic 1015	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   629: invokevirtual 1019	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   632: ifnull +51 -> 683
    //   635: aload_0
    //   636: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   639: getfield 278	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   642: invokestatic 1015	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   645: invokevirtual 1019	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   648: arraylength
    //   649: istore 4
    //   651: aload_0
    //   652: iload 4
    //   654: newarray <illegal type>
    //   656: putfield 695	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   659: aload_0
    //   660: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   663: getfield 278	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   666: invokestatic 1015	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   669: invokevirtual 1019	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   672: iconst_0
    //   673: aload_0
    //   674: getfield 695	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   677: iconst_0
    //   678: iload 4
    //   680: invokestatic 1023	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   683: aload_0
    //   684: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   687: getfield 278	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   690: invokestatic 1015	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   693: invokevirtual 1026	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   696: ifnull +51 -> 747
    //   699: aload_0
    //   700: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   703: getfield 278	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   706: invokestatic 1015	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   709: invokevirtual 1026	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   712: arraylength
    //   713: istore 4
    //   715: aload_0
    //   716: iload 4
    //   718: newarray <illegal type>
    //   720: putfield 698	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   723: aload_0
    //   724: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   727: getfield 278	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   730: invokestatic 1015	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   733: invokevirtual 1026	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   736: iconst_0
    //   737: aload_0
    //   738: getfield 698	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   741: iconst_0
    //   742: iload 4
    //   744: invokestatic 1023	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   747: ldc_w 1011
    //   750: monitorexit
    //   751: aload_0
    //   752: getfield 695	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   755: ifnull +26 -> 781
    //   758: aload_0
    //   759: getfield 695	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   762: arraylength
    //   763: ifeq +18 -> 781
    //   766: aload_0
    //   767: getfield 698	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   770: ifnull +11 -> 781
    //   773: aload_0
    //   774: getfield 698	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   777: arraylength
    //   778: ifne +45 -> 823
    //   781: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   784: ifeq +12 -> 796
    //   787: ldc 36
    //   789: iconst_2
    //   790: ldc_w 1028
    //   793: invokestatic 1030	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   796: aload_0
    //   797: getfield 173	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   800: aload_0
    //   801: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   804: getfield 278	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   807: invokestatic 1036	com/tencent/mobileqq/highway/config/HwServlet:getConfig	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   810: aload_0
    //   811: getfield 175	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bI	I
    //   814: iconst_2
    //   815: if_icmpne +81 -> 896
    //   818: aload_0
    //   819: iconst_1
    //   820: putfield 175	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bI	I
    //   823: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   826: ifeq +32 -> 858
    //   829: ldc 36
    //   831: iconst_2
    //   832: new 190	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   839: ldc_w 1038
    //   842: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload_0
    //   846: getfield 175	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bI	I
    //   849: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   852: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   858: aload_0
    //   859: getfield 175	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bI	I
    //   862: tableswitch	default:+22->884, 2:+62->924, 3:+80->942
    //   884: aload_0
    //   885: invokevirtual 1040	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:s	()V
    //   888: return
    //   889: astore_1
    //   890: ldc_w 1011
    //   893: monitorexit
    //   894: aload_1
    //   895: athrow
    //   896: aload_0
    //   897: getfield 175	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bI	I
    //   900: iconst_3
    //   901: if_icmpne -78 -> 823
    //   904: aload_0
    //   905: monitorenter
    //   906: aload_0
    //   907: iconst_1
    //   908: putfield 117	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bK	I
    //   911: aload_0
    //   912: iconst_3
    //   913: putfield 610	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bL	I
    //   916: aload_0
    //   917: monitorexit
    //   918: return
    //   919: astore_1
    //   920: aload_0
    //   921: monitorexit
    //   922: aload_1
    //   923: athrow
    //   924: aload_0
    //   925: iconst_1
    //   926: putfield 837	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bm	I
    //   929: aload_0
    //   930: aload_0
    //   931: getfield 695	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   934: aload_0
    //   935: getfield 698	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   938: invokevirtual 1043	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	([B[B)V
    //   941: return
    //   942: aload_0
    //   943: aload_0
    //   944: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   947: getfield 274	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   950: putfield 737	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_o_of_type_Long	J
    //   953: aload_0
    //   954: aload_0
    //   955: getfield 244	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   958: aload_0
    //   959: getfield 341	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_l_of_type_Long	J
    //   962: l2i
    //   963: aload_0
    //   964: getfield 695	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   967: aload_0
    //   968: getfield 698	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   971: aload_0
    //   972: getfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   975: aload_0
    //   976: getfield 737	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_o_of_type_Long	J
    //   979: invokevirtual 1046	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/lang/String;I[B[B[BJ)V
    //   982: aload_0
    //   983: iconst_1
    //   984: putfield 837	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bm	I
    //   987: return
    //   988: astore_2
    //   989: goto -431 -> 558
    //   992: astore_3
    //   993: goto -473 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	996	0	this	ShortVideoUploadProcessor
    //   133	53	1	localObject1	Object
    //   199	2	1	localIOException1	IOException
    //   236	10	1	localFileMsg	FileMsg
    //   352	2	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   509	2	1	localIOException2	IOException
    //   521	15	1	localObject2	Object
    //   549	2	1	localIOException3	IOException
    //   557	6	1	localObject3	Object
    //   568	2	1	localIOException4	IOException
    //   576	2	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   889	6	1	localObject4	Object
    //   919	4	1	localObject5	Object
    //   131	414	2	localObject6	Object
    //   555	12	2	localObject7	Object
    //   988	1	2	localObject8	Object
    //   517	14	3	localIOException5	IOException
    //   992	1	3	localIOException6	IOException
    //   649	94	4	i	int
    // Exception table:
    //   from	to	target	type
    //   194	198	199	java/io/IOException
    //   309	330	352	java/io/FileNotFoundException
    //   458	462	509	java/io/IOException
    //   120	132	517	java/io/IOException
    //   544	548	549	java/io/IOException
    //   120	132	555	finally
    //   562	566	568	java/io/IOException
    //   469	487	576	java/io/FileNotFoundException
    //   619	683	889	finally
    //   683	747	889	finally
    //   747	751	889	finally
    //   890	894	889	finally
    //   906	918	919	finally
    //   920	922	919	finally
    //   134	143	988	finally
    //   145	152	988	finally
    //   154	184	988	finally
    //   186	190	988	finally
    //   522	527	988	finally
    //   529	534	988	finally
    //   536	540	988	finally
    //   134	143	992	java/io/IOException
    //   145	152	992	java/io/IOException
    //   154	184	992	java/io/IOException
    //   186	190	992	java/io/IOException
  }
  
  public void a(long paramLong, Bdh_extinfo.PicInfo paramPicInfo, List paramList)
  {
    LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "svrcomp_s", "<BDH_LOG><ShortVideoUploadProcessor>sendAckToBDHServer videoInfos.size : " + paramList.size());
    w();
    Bdh_extinfo.ShortVideoReqExtInfo localShortVideoReqExtInfo = new Bdh_extinfo.ShortVideoReqExtInfo();
    localShortVideoReqExtInfo.uint32_cmd.set(3);
    localShortVideoReqExtInfo.uint64_session_id.set(paramLong);
    Bdh_extinfo.ShortVideoSureReqInfo localShortVideoSureReqInfo;
    long l1;
    label171:
    int i;
    if (f)
    {
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(true);
      localShortVideoSureReqInfo = new Bdh_extinfo.ShortVideoSureReqInfo();
      paramLong = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      localShortVideoSureReqInfo.uint64_fromuin.set(paramLong);
      localShortVideoSureReqInfo.uint64_touin.set(l1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 0) && (1008 != this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)) {
        break label390;
      }
      localShortVideoSureReqInfo.uint64_group_code.set(0L);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 0) {
        break label403;
      }
      i = 0;
      label184:
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {
        break label445;
      }
    }
    label390:
    label403:
    label445:
    for (int j = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; j = 0)
    {
      this.bz = j;
      localShortVideoSureReqInfo.uint32_chat_type.set(i);
      localShortVideoSureReqInfo.uint32_business_type.set(j);
      localShortVideoSureReqInfo.uint32_client_type.set(2);
      localShortVideoSureReqInfo.msg_thumbinfo.set(paramPicInfo);
      localShortVideoSureReqInfo.rpt_msg_merge_videoinfo.set(paramList);
      localShortVideoReqExtInfo.msg_shortvideo_sure_req.set(localShortVideoSureReqInfo);
      paramPicInfo = new Cryptor().encrypt(localShortVideoReqExtInfo.toByteArray(), this.jdField_c_of_type_ArrayOfByte);
      if (ShortVideoUploadABTest.a()) {
        this.q = SystemClock.uptimeMillis();
      }
      paramList = new vbx(this);
      paramPicInfo = new RequestAck(String.valueOf(paramLong), 16, this.jdField_d_of_type_ArrayOfByte, 30000L, paramList, paramPicInfo, this.jdField_b_of_type_ArrayOfByte, this.bM);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().SubmitAckRequest(paramPicInfo);
      this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = paramPicInfo;
      return;
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(false);
      break;
      localShortVideoSureReqInfo.uint64_group_code.set(l1);
      break label171;
      if (1 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)
      {
        i = 1;
        break label184;
      }
      if (3000 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)
      {
        i = 2;
        break label184;
      }
      i = 3;
      break label184;
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.jdField_o_of_type_Boolean) || (this.k)) {
      return;
    }
    a("onResp", "result:" + paramNetResp.jdField_e_of_type_Int + " errCode:" + paramNetResp.jdField_f_of_type_Int + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- result:" + paramNetResp.jdField_e_of_type_Int);
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- errCode:" + paramNetResp.jdField_f_of_type_Int);
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      QLog.d("ShortVideoUploadProcessorTest", 2, "onResp mIpList size ==== = 0" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    int i = paramNetResp.g;
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
            this.bA = 0;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- HttpMsg.RANGE:" + (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- userRetCode:" + l2 + "----mUpBrokenTransferRetryCount=" + this.bA);
          }
          if ((l2 == 0L) || (l2 == Long.MAX_VALUE)) {
            break label542;
          }
          if (-5103065L != l2) {
            break label500;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = null;
          this.jdField_c_of_type_Long = 0L;
          if (this.bA >= 3) {
            break;
          }
          J_();
          this.bA += 1;
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
    label500:
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    if (!ShortVideoUpHandler.a((int)l2))
    {
      a(56009, null, b(i, l2), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
      return;
    }
    label542:
    long l1;
    if (paramNetResp.jdField_e_of_type_Int == 0)
    {
      this.aW = 0;
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null)
      {
        l1 = Long.MAX_VALUE;
        if (l1 != Long.MAX_VALUE) {
          break label1302;
        }
        Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
        if (localObject == null) {
          break label1302;
        }
      }
    }
    label1302:
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
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---------- transferedSize = " + l1);
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_f_of_type_Long = l1;
          this.jdField_c_of_type_Long = l1;
          this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(66));
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
          if (l1 >= this.jdField_a_of_type_Long) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null)
          {
            ShortVideoUpInfo localShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            paramNetResp = localShortVideoUpInfo;
            if (localShortVideoUpInfo == null)
            {
              paramNetResp = new ShortVideoUpInfo();
              paramNetResp.key = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
              paramNetResp.uKey = this.jdField_j_of_type_JavaLangString;
              paramNetResp.lastIp = this.jdField_m_of_type_Long;
            }
            paramNetResp.transferedSize = this.jdField_c_of_type_Long;
            paramNetResp.timeStamp = (MessageCache.a() * 1000L);
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(paramNetResp);
          }
          if (this.jdField_o_of_type_Boolean) {
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
          QLog.d("ShortVideoUploadProcessor", 2, "sendFile() success.");
        }
        d(1007);
        d(false);
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
      this.bA = 0;
      if ((paramNetResp.jdField_f_of_type_Int == 9364) && (this.aW < 3))
      {
        a("[netChg]", "failed.but net change detect.so retry");
        this.aW += 1;
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
        q();
        s();
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
  
  public void a(VideoSliceInfo paramVideoSliceInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new vcd(this, paramVideoSliceInfo));
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.jdField_c_of_type_Int);
        }
        this.jdField_h_of_type_JavaLangString = paramRichProtoReq.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + paramRichProtoReq.jdField_a_of_type_Boolean);
          }
          this.bN = paramRichProtoReq.jdField_a_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.videoAttr = " + paramRichProtoReq.jdField_a_of_type_Int);
          }
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.g = true;
            d(1007);
            d(true);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.jdField_j_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.jdField_b_of_type_Long = paramRichProtoReq.jdField_b_of_type_Long;
          if (this.bm == 2)
          {
            c("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
            this.jdField_m_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mIpList:" + this.jdField_a_of_type_JavaUtilArrayList);
              QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- firstIpInInt:" + this.jdField_m_of_type_Long);
              QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(66));
            if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            }
            this.jdField_c_of_type_Long = 0L;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUploadProcessor", 2, "sendFile()---------- mShortVideoUpInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo);
            }
            J_();
          }
          else if (this.bm == 0)
          {
            c("<BDH_LOG> onBusiProtoResp() start normally, selecting channel...");
            if (!paramRichProtoReq.jdField_b_of_type_Boolean) {
              c("<BDH_LOG> onBusiProtoResp() Server's isUseBdh = false");
            }
            if ((paramRichProtoReq.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_ArrayOfByte != null) && (this.jdField_d_of_type_ArrayOfByte.length > 0) && (this.jdField_c_of_type_ArrayOfByte != null) && (this.jdField_c_of_type_ArrayOfByte.length > 0))
            {
              c("<BDH_LOG> onBusiProtoResp() select BDH channel");
              this.bm = 1;
              a(this.jdField_d_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte);
            }
            else
            {
              if (paramRichProtoReq.jdField_b_of_type_Boolean) {
                HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
              }
              c("<BDH_LOG> onBusiProtoResp() select HTTP channel");
              this.bm = 2;
              this.jdField_m_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
              if (QLog.isColorLevel())
              {
                QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mIpList:" + this.jdField_a_of_type_JavaUtilArrayList);
                QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- firstIpInInt:" + this.jdField_m_of_type_Long);
                QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(66));
              if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
                this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
              }
              this.jdField_c_of_type_Long = 0L;
              if (QLog.isColorLevel()) {
                QLog.d("ShortVideoUploadProcessor", 2, "sendFile()---------- mShortVideoUpInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo);
              }
              J_();
            }
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
            if (this.bm == 1) {}
            for (paramRichProtoReq = "BDH";; paramRichProtoReq = "HTTP")
            {
              c(paramRichProtoReq);
              break;
            }
            b();
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new vce(this, paramString, paramInt));
    }
  }
  
  public void a(String paramString, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendVideoSegByBDH  filePath:" + paramString + " index :" + paramInt2 + " md5:" + HexUtil.bytes2HexStr(paramArrayOfByte2) + "fileSize:" + paramInt1);
    }
    Object localObject = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint32_cmd.set(2);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint64_session_id.set(this.jdField_o_of_type_Long);
    Bdh_extinfo.VideoInfo localVideoInfo;
    if (f)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(true);
      localVideoInfo = new Bdh_extinfo.VideoInfo();
      localVideoInfo.uint32_idx.set(paramInt2);
      localVideoInfo.uint32_size.set(paramInt1);
      localVideoInfo.bytes_bin_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
      localVideoInfo.uint32_format.set(2);
      localVideoInfo.uint32_res_len.set(paramInt3);
      localVideoInfo.uint32_res_width.set(paramInt4);
      localVideoInfo.uint32_time.set(paramInt5);
      if (paramInt2 <= 0) {
        break label292;
      }
      this.jdField_b_of_type_JavaUtilList.add(localVideoInfo);
    }
    for (;;)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_videoinfo.set(localVideoInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo != null) {
        ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_thumbinfo.set(this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo);
      }
      localObject = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject).toByteArray(), this.jdField_c_of_type_ArrayOfByte);
      w();
      a(paramString, this.jdField_d_of_type_ArrayOfByte, paramArrayOfByte1, (byte[])localObject, paramInt2, paramArrayOfByte2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
      break;
      label292:
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUploadProcessor", 2, "video seg index is out of bounds !  index : " + paramInt2);
      }
    }
  }
  
  void a(String paramString, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendVideoThumbByBDH  filePath:" + paramString + " index :" + 0 + " md5:" + HexUtil.bytes2HexStr(paramArrayOfByte3) + " fileSize:" + paramInt);
    }
    this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Bdh_extinfo.ShortVideoReqExtInfo localShortVideoReqExtInfo = new Bdh_extinfo.ShortVideoReqExtInfo();
    localShortVideoReqExtInfo.uint32_cmd.set(1);
    localShortVideoReqExtInfo.uint64_session_id.set(paramLong);
    if (f) {
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Bdh_extinfo.PicInfo localPicInfo = new Bdh_extinfo.PicInfo();
      localPicInfo.uint32_idx.set(0);
      localPicInfo.uint32_size.set(paramInt);
      localPicInfo.uint32_type.set(1);
      localPicInfo.bytes_bin_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte3));
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo = localPicInfo;
      localShortVideoReqExtInfo.msg_thumbinfo.set(localPicInfo);
      a(paramString, paramArrayOfByte1, paramArrayOfByte3, new Cryptor().encrypt(localShortVideoReqExtInfo.toByteArray(), paramArrayOfByte2), 0, paramArrayOfByte3);
      return;
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  /* Error */
  void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, byte[] paramArrayOfByte4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 1434	vci
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 1435	vci:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)V
    //   10: astore 7
    //   12: new 1437	com/tencent/mobileqq/highway/transaction/Transaction
    //   15: dup
    //   16: aload_0
    //   17: getfield 173	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 1439	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   23: bipush 16
    //   25: aload_1
    //   26: iconst_0
    //   27: aload_2
    //   28: aload_3
    //   29: aload 7
    //   31: aload 4
    //   33: invokespecial 1442	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 700	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bM	I
    //   41: ifeq +11 -> 52
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 700	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:bM	I
    //   49: putfield 1445	com/tencent/mobileqq/highway/transaction/Transaction:cacheIp	I
    //   52: aload 7
    //   54: aload_1
    //   55: putfield 1448	vci:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   58: aload 7
    //   60: iload 5
    //   62: putfield 1449	vci:jdField_a_of_type_Int	I
    //   65: aload_0
    //   66: getfield 173	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 1134	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   72: aload_1
    //   73: invokevirtual 1453	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   76: istore 8
    //   78: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +83 -> 164
    //   84: ldc 36
    //   86: iconst_2
    //   87: new 190	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 1455
    //   97: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 8
    //   102: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 1457
    //   108: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 1460	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   115: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: ldc_w 1462
    //   121: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   128: getfield 274	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   131: invokevirtual 594	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: ldc_w 1464
    //   137: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: getfield 1467	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   144: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 1469
    //   150: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: bipush 16
    //   155: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_0
    //   165: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   168: getfield 274	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   171: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   174: ldc_w 1471
    //   177: new 190	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 1473
    //   187: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload 5
    //   192: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 1475
    //   198: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 1477
    //   204: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 6
    //   209: invokestatic 743	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   212: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 1479
    //   218: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_1
    //   222: invokevirtual 1460	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   225: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 799	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   234: new 133	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo
    //   237: dup
    //   238: invokespecial 134	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:<init>	()V
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 1425	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:a	()V
    //   246: aload_0
    //   247: getfield 131	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   250: iload 5
    //   252: invokestatic 667	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: aload_2
    //   256: invokevirtual 377	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: iload 8
    //   262: ifeq +37 -> 299
    //   265: aload_0
    //   266: iload 8
    //   268: new 190	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 1481
    //   278: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: iload 5
    //   283: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokevirtual 238	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   292: aload_0
    //   293: invokevirtual 240	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   296: aload_0
    //   297: monitorexit
    //   298: return
    //   299: aload_0
    //   300: getfield 126	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   303: aload_1
    //   304: invokeinterface 1407 2 0
    //   309: pop
    //   310: goto -14 -> 296
    //   313: astore_1
    //   314: aload_0
    //   315: monitorexit
    //   316: aload_1
    //   317: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	ShortVideoUploadProcessor
    //   0	318	1	paramString	String
    //   0	318	2	paramArrayOfByte1	byte[]
    //   0	318	3	paramArrayOfByte2	byte[]
    //   0	318	4	paramArrayOfByte3	byte[]
    //   0	318	5	paramInt	int
    //   0	318	6	paramArrayOfByte4	byte[]
    //   10	49	7	localvci	vci
    //   76	191	8	i	int
    // Exception table:
    //   from	to	target	type
    //   2	52	313	finally
    //   52	164	313	finally
    //   164	260	313	finally
    //   265	296	313	finally
    //   299	310	313	finally
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aU))) {
      break label14;
    }
    label14:
    while ((this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int j = this.aX;
    int i;
    label61:
    Object localObject1;
    if (paramBoolean)
    {
      i = 2;
      this.aX = (i | j);
      localObject1 = "actShortVideoUpload";
      if (this.bm == 1) {
        localObject1 = "actShortVideoUploadBDH";
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 3000)) {
        break label830;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      localObject1 = "actShortVideoDiscussgroupUpload";
      if (this.bm == 1) {
        localObject1 = "actShortVideoDiscussgroupUploadBDH";
      }
    }
    label285:
    label706:
    label830:
    for (;;)
    {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      long l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.bz + "");
      Object localObject3 = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_h_of_type_JavaLangString == null)
      {
        localObject2 = this.jdField_i_of_type_JavaLangString;
        ((HashMap)localObject3).put("param_uuid", localObject2);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_l_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.g + "");
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 0) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_BDHExistBeforeVideoUpload", String.valueOf(this.jdField_a_of_type_JavaLangBoolean));
        }
        if (this.bI != 3) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.by));
        }
        y();
        this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_BDH_Cache_Diff", String.valueOf(this.jdField_h_of_type_Boolean));
        if (!paramBoolean) {
          break label706;
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      for (;;)
      {
        p();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "AutoMonitor_fragment MineFragment onAttach");
        }
        if (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0) {
          ThreadManager.a(new vcc(this, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString), 5, null, true);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject1 = new StringBuilder();
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject3) != null)
          {
            ((StringBuilder)localObject1).append("&");
            ((StringBuilder)localObject1).append((String)localObject3);
            ((StringBuilder)localObject1).append("=");
            ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3));
          }
        }
        i = 1;
        break label61;
        localObject2 = this.jdField_h_of_type_JavaLangString;
        break label285;
        if (this.aU != 56009) {
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aU));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.bc);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
        StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, false, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "report", ((StringBuilder)localObject1).toString());
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new vcf(this, paramBoolean, paramInt));
    }
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +29 -> 44
    //   18: ldc 36
    //   20: iconst_2
    //   21: new 190	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 1601
    //   31: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: invokevirtual 1345	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: getfield 660	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   48: invokevirtual 1425	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:a	()V
    //   51: aload_0
    //   52: getfield 1603	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   55: ifnull +4 -> 59
    //   58: return
    //   59: invokestatic 603	android/os/SystemClock:uptimeMillis	()J
    //   62: lstore 12
    //   64: aload_0
    //   65: getfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   68: arraylength
    //   69: aload_0
    //   70: getfield 327	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   73: arraylength
    //   74: iadd
    //   75: newarray <illegal type>
    //   77: astore_3
    //   78: aload_0
    //   79: getfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   82: iconst_0
    //   83: aload_3
    //   84: iconst_0
    //   85: aload_0
    //   86: getfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   89: arraylength
    //   90: invokestatic 1023	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   93: aload_0
    //   94: getfield 327	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   97: iconst_0
    //   98: aload_3
    //   99: aload_0
    //   100: getfield 265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   103: arraylength
    //   104: aload_0
    //   105: getfield 327	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   108: arraylength
    //   109: invokestatic 1023	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   112: new 190	java/lang/StringBuilder
    //   115: dup
    //   116: invokestatic 1606	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   119: invokespecial 1607	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_3
    //   123: invokestatic 743	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   126: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 1609
    //   132: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore 8
    //   140: aload_0
    //   141: getfield 1002	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   144: invokevirtual 1610	java/io/RandomAccessFile:length	()J
    //   147: l2i
    //   148: newarray <illegal type>
    //   150: astore_3
    //   151: aload_0
    //   152: getfield 985	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   155: invokevirtual 1610	java/io/RandomAccessFile:length	()J
    //   158: l2i
    //   159: newarray <illegal type>
    //   161: astore 10
    //   163: aload_0
    //   164: getfield 1002	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   167: invokevirtual 1610	java/io/RandomAccessFile:length	()J
    //   170: aload_0
    //   171: getfield 985	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   174: invokevirtual 1610	java/io/RandomAccessFile:length	()J
    //   177: ladd
    //   178: l2i
    //   179: newarray <illegal type>
    //   181: astore 9
    //   183: aload_0
    //   184: getfield 1002	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   187: aload_3
    //   188: invokevirtual 1614	java/io/RandomAccessFile:read	([B)I
    //   191: pop
    //   192: aload_0
    //   193: getfield 985	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   196: aload 10
    //   198: invokevirtual 1614	java/io/RandomAccessFile:read	([B)I
    //   201: pop
    //   202: aload_3
    //   203: iconst_0
    //   204: aload 9
    //   206: iconst_0
    //   207: aload_3
    //   208: arraylength
    //   209: invokestatic 1023	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   212: aload 10
    //   214: iconst_0
    //   215: aload 9
    //   217: aload_3
    //   218: arraylength
    //   219: aload 10
    //   221: arraylength
    //   222: invokestatic 1023	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   225: new 312	java/io/File
    //   228: dup
    //   229: aload 8
    //   231: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   234: invokevirtual 1617	java/io/File:delete	()Z
    //   237: pop
    //   238: new 312	java/io/File
    //   241: dup
    //   242: aload 8
    //   244: invokespecial 315	java/io/File:<init>	(Ljava/lang/String;)V
    //   247: astore_3
    //   248: aload_3
    //   249: invokevirtual 1620	java/io/File:exists	()Z
    //   252: istore 14
    //   254: iload 14
    //   256: ifne +8 -> 264
    //   259: aload_3
    //   260: invokevirtual 1623	java/io/File:createNewFile	()Z
    //   263: pop
    //   264: new 1625	java/io/FileOutputStream
    //   267: dup
    //   268: aload_3
    //   269: invokespecial 1628	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   272: astore_3
    //   273: new 1630	java/io/BufferedOutputStream
    //   276: dup
    //   277: aload_3
    //   278: invokespecial 1633	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   281: astore 4
    //   283: aload 4
    //   285: aload 9
    //   287: invokevirtual 1637	java/io/BufferedOutputStream:write	([B)V
    //   290: aload 4
    //   292: ifnull +8 -> 300
    //   295: aload 4
    //   297: invokevirtual 1638	java/io/BufferedOutputStream:close	()V
    //   300: aload_3
    //   301: ifnull +7 -> 308
    //   304: aload_3
    //   305: invokevirtual 1639	java/io/FileOutputStream:close	()V
    //   308: aload_0
    //   309: invokespecial 1641	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	()Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq;
    //   312: astore_3
    //   313: new 1643	pttcenterservice/PttShortVideo$PttShortVideoUploadReq
    //   316: dup
    //   317: invokespecial 1644	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:<init>	()V
    //   320: astore 4
    //   322: aload 4
    //   324: iconst_1
    //   325: invokevirtual 1645	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:setHasFlag	(Z)V
    //   328: aload 4
    //   330: getfield 1646	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_fromuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   333: aload_3
    //   334: getfield 280	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   337: invokestatic 1076	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   340: invokevirtual 1066	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   343: aload 4
    //   345: getfield 1647	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_touin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   348: aload_3
    //   349: getfield 292	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokestatic 1076	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   355: invokevirtual 1066	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   358: aload 4
    //   360: getfield 1648	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_chat_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   363: aload_3
    //   364: getfield 308	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_a_of_type_Int	I
    //   367: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   370: aload 4
    //   372: getfield 1649	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   375: aload_3
    //   376: getfield 310	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_Int	I
    //   379: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   382: aload_3
    //   383: getfield 307	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   386: ifnull +647 -> 1033
    //   389: aload 4
    //   391: getfield 1650	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   394: aload_3
    //   395: getfield 307	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   398: invokestatic 1076	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   401: invokevirtual 1066	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   404: aload 4
    //   406: getfield 1653	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_agent_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   409: aload_3
    //   410: getfield 306	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:i	I
    //   413: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   416: aload 4
    //   418: getfield 1654	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   421: aload_3
    //   422: getfield 384	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:j	I
    //   425: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   428: new 1656	pttcenterservice/PttShortVideo$PttShortVideoFileInfo
    //   431: dup
    //   432: invokespecial 1657	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:<init>	()V
    //   435: astore 5
    //   437: aload 5
    //   439: getfield 1661	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   442: aload_3
    //   443: getfield 320	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   446: invokevirtual 1665	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   449: aload 5
    //   451: getfield 1666	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   454: aload_3
    //   455: getfield 328	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_a_of_type_ArrayOfByte	[B
    //   458: invokestatic 448	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   461: invokevirtual 439	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   464: aload 5
    //   466: getfield 1667	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   469: aload_3
    //   470: getfield 329	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_ArrayOfByte	[B
    //   473: invokestatic 448	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   476: invokevirtual 439	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   479: aload 5
    //   481: getfield 1670	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   484: aload_3
    //   485: getfield 325	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_a_of_type_Long	J
    //   488: invokevirtual 1066	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   491: aload 5
    //   493: getfield 1673	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_length	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   496: aload_3
    //   497: getfield 337	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_d_of_type_Int	I
    //   500: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   503: aload 5
    //   505: getfield 1676	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   508: aload_3
    //   509: getfield 333	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_f_of_type_Int	I
    //   512: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   515: aload 5
    //   517: getfield 1677	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   520: aload_3
    //   521: getfield 367	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:g	I
    //   524: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   527: aload 5
    //   529: getfield 1678	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   532: aload_3
    //   533: getfield 339	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:h	I
    //   536: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   539: aload 5
    //   541: getfield 1681	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   544: aload_3
    //   545: getfield 343	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_Long	J
    //   548: invokevirtual 1066	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   551: aload 4
    //   553: getfield 1685	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:msg_PttShortVideoFileInfo	Lpttcenterservice/PttShortVideo$PttShortVideoFileInfo;
    //   556: aload 5
    //   558: invokevirtual 1686	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   561: aload 4
    //   563: invokevirtual 1687	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:toByteArray	()[B
    //   566: astore_3
    //   567: new 1113	com/tencent/qphone/base/util/Cryptor
    //   570: dup
    //   571: invokespecial 1114	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   574: aload_3
    //   575: aload_2
    //   576: invokevirtual 1121	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   579: astore_2
    //   580: new 1689	vby
    //   583: dup
    //   584: aload_0
    //   585: lload 12
    //   587: aload 8
    //   589: invokespecial 1692	vby:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;JLjava/lang/String;)V
    //   592: astore_3
    //   593: aload_0
    //   594: new 1437	com/tencent/mobileqq/highway/transaction/Transaction
    //   597: dup
    //   598: aload_0
    //   599: getfield 173	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   602: invokevirtual 1439	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   605: bipush 12
    //   607: aload 8
    //   609: aload_0
    //   610: getfield 1335	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_Long	J
    //   613: l2i
    //   614: aload_1
    //   615: aload_0
    //   616: getfield 327	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   619: aload_3
    //   620: aload_2
    //   621: invokespecial 1442	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   624: putfield 1603	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   627: aload_0
    //   628: getfield 173	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   631: invokevirtual 1134	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   634: aload_0
    //   635: getfield 1603	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   638: invokevirtual 1453	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   641: istore 11
    //   643: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +115 -> 761
    //   649: ldc 36
    //   651: iconst_2
    //   652: new 190	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 1694
    //   662: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: iload 11
    //   667: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   670: ldc_w 1457
    //   673: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload_0
    //   677: getfield 1603	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   680: invokevirtual 1460	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   683: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   686: ldc_w 1462
    //   689: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_0
    //   693: getfield 210	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   696: getfield 274	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   699: invokevirtual 594	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   702: ldc_w 1696
    //   705: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload_0
    //   709: getfield 636	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   712: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: ldc_w 1698
    //   718: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload_0
    //   722: getfield 1506	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   725: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: ldc_w 1464
    //   731: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload_0
    //   735: getfield 1603	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   738: getfield 1467	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   741: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: ldc_w 1700
    //   747: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: bipush 12
    //   752: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   755: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   761: iload 11
    //   763: ifeq -705 -> 58
    //   766: aload_0
    //   767: iload 11
    //   769: ldc_w 1702
    //   772: ldc_w 842
    //   775: aload_0
    //   776: getfield 660	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   779: invokevirtual 1200	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   782: aload_0
    //   783: invokevirtual 240	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	()V
    //   786: return
    //   787: astore 10
    //   789: aload 10
    //   791: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   794: goto -530 -> 264
    //   797: astore 6
    //   799: aconst_null
    //   800: astore 4
    //   802: aload 5
    //   804: astore_3
    //   805: aload 6
    //   807: astore 5
    //   809: aload 5
    //   811: invokevirtual 993	java/io/FileNotFoundException:printStackTrace	()V
    //   814: aload 4
    //   816: ifnull +8 -> 824
    //   819: aload 4
    //   821: invokevirtual 1638	java/io/BufferedOutputStream:close	()V
    //   824: aload_3
    //   825: ifnull -517 -> 308
    //   828: aload_3
    //   829: invokevirtual 1639	java/io/FileOutputStream:close	()V
    //   832: goto -524 -> 308
    //   835: astore_3
    //   836: aload_3
    //   837: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   840: goto -532 -> 308
    //   843: astore 4
    //   845: aload 4
    //   847: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   850: goto -550 -> 300
    //   853: astore_3
    //   854: aload_3
    //   855: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   858: goto -550 -> 308
    //   861: astore 4
    //   863: aload 4
    //   865: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   868: goto -44 -> 824
    //   871: astore 7
    //   873: aconst_null
    //   874: astore 4
    //   876: aload 6
    //   878: astore_3
    //   879: aload_3
    //   880: astore 6
    //   882: aload 4
    //   884: astore 5
    //   886: aload 7
    //   888: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   891: aload 4
    //   893: ifnull +8 -> 901
    //   896: aload 4
    //   898: invokevirtual 1638	java/io/BufferedOutputStream:close	()V
    //   901: aload_3
    //   902: ifnull -594 -> 308
    //   905: aload_3
    //   906: invokevirtual 1639	java/io/FileOutputStream:close	()V
    //   909: goto -601 -> 308
    //   912: astore_3
    //   913: aload_3
    //   914: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   917: goto -609 -> 308
    //   920: astore 4
    //   922: aload 4
    //   924: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   927: goto -26 -> 901
    //   930: astore 5
    //   932: aconst_null
    //   933: astore 4
    //   935: aload 7
    //   937: astore_3
    //   938: aload 5
    //   940: astore 7
    //   942: aload_3
    //   943: astore 6
    //   945: aload 4
    //   947: astore 5
    //   949: aload 7
    //   951: invokevirtual 1703	java/lang/OutOfMemoryError:printStackTrace	()V
    //   954: aload 4
    //   956: ifnull +8 -> 964
    //   959: aload 4
    //   961: invokevirtual 1638	java/io/BufferedOutputStream:close	()V
    //   964: aload_3
    //   965: ifnull -657 -> 308
    //   968: aload_3
    //   969: invokevirtual 1639	java/io/FileOutputStream:close	()V
    //   972: goto -664 -> 308
    //   975: astore_3
    //   976: aload_3
    //   977: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   980: goto -672 -> 308
    //   983: astore 4
    //   985: aload 4
    //   987: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   990: goto -26 -> 964
    //   993: astore_1
    //   994: aconst_null
    //   995: astore_3
    //   996: aload 4
    //   998: astore_2
    //   999: aload_3
    //   1000: ifnull +7 -> 1007
    //   1003: aload_3
    //   1004: invokevirtual 1638	java/io/BufferedOutputStream:close	()V
    //   1007: aload_2
    //   1008: ifnull +7 -> 1015
    //   1011: aload_2
    //   1012: invokevirtual 1639	java/io/FileOutputStream:close	()V
    //   1015: aload_1
    //   1016: athrow
    //   1017: astore_3
    //   1018: aload_3
    //   1019: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   1022: goto -15 -> 1007
    //   1025: astore_2
    //   1026: aload_2
    //   1027: invokevirtual 967	java/io/IOException:printStackTrace	()V
    //   1030: goto -15 -> 1015
    //   1033: aload 4
    //   1035: getfield 1650	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1038: lconst_0
    //   1039: invokevirtual 1066	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1042: goto -638 -> 404
    //   1045: astore_1
    //   1046: aconst_null
    //   1047: astore 4
    //   1049: aload_3
    //   1050: astore_2
    //   1051: aload 4
    //   1053: astore_3
    //   1054: goto -55 -> 999
    //   1057: astore_1
    //   1058: aload_3
    //   1059: astore_2
    //   1060: aload 4
    //   1062: astore_3
    //   1063: goto -64 -> 999
    //   1066: astore_1
    //   1067: aload_3
    //   1068: astore_2
    //   1069: aload 4
    //   1071: astore_3
    //   1072: goto -73 -> 999
    //   1075: astore_1
    //   1076: aload 6
    //   1078: astore_2
    //   1079: aload 5
    //   1081: astore_3
    //   1082: goto -83 -> 999
    //   1085: astore 7
    //   1087: aconst_null
    //   1088: astore 4
    //   1090: goto -148 -> 942
    //   1093: astore 7
    //   1095: goto -153 -> 942
    //   1098: astore 7
    //   1100: aconst_null
    //   1101: astore 4
    //   1103: goto -224 -> 879
    //   1106: astore 7
    //   1108: goto -229 -> 879
    //   1111: astore 5
    //   1113: aconst_null
    //   1114: astore 4
    //   1116: goto -307 -> 809
    //   1119: astore 5
    //   1121: goto -312 -> 809
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1124	0	this	ShortVideoUploadProcessor
    //   0	1124	1	paramArrayOfByte1	byte[]
    //   0	1124	2	paramArrayOfByte2	byte[]
    //   77	752	3	localObject1	Object
    //   835	2	3	localIOException1	IOException
    //   853	2	3	localIOException2	IOException
    //   878	28	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   912	2	3	localIOException3	IOException
    //   937	32	3	localIOException4	IOException
    //   975	2	3	localIOException5	IOException
    //   995	9	3	localObject2	Object
    //   1017	33	3	localIOException6	IOException
    //   1053	29	3	localObject3	Object
    //   7	813	4	localObject4	Object
    //   843	3	4	localIOException7	IOException
    //   861	3	4	localIOException8	IOException
    //   874	23	4	localObject5	Object
    //   920	3	4	localIOException9	IOException
    //   933	27	4	localObject6	Object
    //   983	51	4	localIOException10	IOException
    //   1047	68	4	localObject7	Object
    //   10	875	5	localObject8	Object
    //   930	9	5	localOutOfMemoryError1	OutOfMemoryError
    //   947	133	5	localObject9	Object
    //   1111	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   1119	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	1	6	localObject10	Object
    //   797	80	6	localFileNotFoundException4	java.io.FileNotFoundException
    //   880	197	6	localObject11	Object
    //   4	1	7	localObject12	Object
    //   871	65	7	localIOException11	IOException
    //   940	10	7	localObject13	Object
    //   1085	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   1093	1	7	localOutOfMemoryError3	OutOfMemoryError
    //   1098	1	7	localIOException12	IOException
    //   1106	1	7	localIOException13	IOException
    //   138	470	8	str	String
    //   181	105	9	arrayOfByte1	byte[]
    //   161	59	10	arrayOfByte2	byte[]
    //   787	3	10	localIOException14	IOException
    //   641	127	11	i	int
    //   62	524	12	l1	long
    //   252	3	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   259	264	787	java/io/IOException
    //   140	254	797	java/io/FileNotFoundException
    //   259	264	797	java/io/FileNotFoundException
    //   264	273	797	java/io/FileNotFoundException
    //   789	794	797	java/io/FileNotFoundException
    //   828	832	835	java/io/IOException
    //   295	300	843	java/io/IOException
    //   304	308	853	java/io/IOException
    //   819	824	861	java/io/IOException
    //   140	254	871	java/io/IOException
    //   264	273	871	java/io/IOException
    //   789	794	871	java/io/IOException
    //   905	909	912	java/io/IOException
    //   896	901	920	java/io/IOException
    //   140	254	930	java/lang/OutOfMemoryError
    //   259	264	930	java/lang/OutOfMemoryError
    //   264	273	930	java/lang/OutOfMemoryError
    //   789	794	930	java/lang/OutOfMemoryError
    //   968	972	975	java/io/IOException
    //   959	964	983	java/io/IOException
    //   140	254	993	finally
    //   259	264	993	finally
    //   264	273	993	finally
    //   789	794	993	finally
    //   1003	1007	1017	java/io/IOException
    //   1011	1015	1025	java/io/IOException
    //   273	283	1045	finally
    //   283	290	1057	finally
    //   809	814	1066	finally
    //   886	891	1075	finally
    //   949	954	1075	finally
    //   273	283	1085	java/lang/OutOfMemoryError
    //   283	290	1093	java/lang/OutOfMemoryError
    //   273	283	1098	java/io/IOException
    //   283	290	1106	java/io/IOException
    //   273	283	1111	java/io/FileNotFoundException
    //   283	290	1119	java/io/FileNotFoundException
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
    try
    {
      if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() != 0))
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((Transaction)localIterator.next()).cancelTransaction();
        }
        this.jdField_c_of_type_JavaUtilList.clear();
      }
    }
    finally {}
    if (this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().cancelAckRequest(this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck);
      this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = null;
    }
    super.b();
    if ((this.bI == 3) && (this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.length() > 0)) {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label348;
      }
    }
    label348:
    for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;; localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long))
    {
      if ((localObject2 != null) && ((localObject2 instanceof MessageForShortVideo))) {
        ((MessageForShortVideo)localObject2).md5 = this.jdField_e_of_type_JavaLangString;
      }
      d(1005);
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errCode:" + this.aU);
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errDesc:" + this.bc);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
      {
        localObject2 = new UpCallBack.SendResult();
        ((UpCallBack.SendResult)localObject2).jdField_a_of_type_Int = -1;
        ((UpCallBack.SendResult)localObject2).jdField_b_of_type_Int = this.aU;
        ((UpCallBack.SendResult)localObject2).jdField_a_of_type_JavaLangString = this.bc;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b((UpCallBack.SendResult)localObject2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, false, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
        Logger.a("ShortVideoUploadProcessor", "onError", "notifyUI bless ptv send error");
      }
      return;
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
    localMessageForShortVideo.videoFileSize = ((int)(this.jdField_a_of_type_Long - this.jdField_l_of_type_Long));
    if (this.jdField_h_of_type_JavaLangString == null) {}
    for (String str = this.jdField_i_of_type_JavaLangString;; str = this.jdField_h_of_type_JavaLangString)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.jdField_e_of_type_JavaLangString;
      localMessageForShortVideo.videoAttr = this.bN;
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
      this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.f + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = (this.jdField_a_of_type_Long - this.jdField_l_of_type_Long);
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      if (this.jdField_h_of_type_JavaLangString == null)
      {
        str = this.jdField_i_of_type_JavaLangString;
        localSendResult.jdField_c_of_type_JavaLangString = str;
        localSendResult.jdField_c_of_type_Long = this.jdField_l_of_type_Long;
        localSendResult.jdField_c_of_type_Int = this.bN;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      }
    }
    for (;;)
    {
      d(1003);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "onSuccess().");
      }
      return;
      str = this.jdField_h_of_type_JavaLangString;
      break;
      b(true);
    }
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMessageToUpdate------state = " + paramInt + ", str= " + ShortVideoUtils.b(paramInt));
    }
    if ((this.k) && (1004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public void d(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.bw = localOptions.outWidth;
    this.bx = localOptions.outHeight;
  }
  
  public void d(boolean paramBoolean)
  {
    int j = 2002;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start.");
    }
    if (!e()) {}
    Object localObject1;
    label230:
    label257:
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Boolean);
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "message", "sendMsg() start.");
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
          break label257;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label230;
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
      if ((localObject1 instanceof MessageForBlessPTV))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, true, ((MessageRecord)localObject1).frienduin);
        Logger.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI bless ptv data send finished");
        return;
      }
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        b();
        return;
      }
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "message", "sendMsg() []. mr = " + ((MessageRecord)localObject1).toString());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof ShortVideoUploadInfo)));
    Object localObject2 = (ShortVideoUploadInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
    DCShortVideo localDCShortVideo = new DCShortVideo(BaseApplication.getContext());
    int i = j;
    switch (((MessageForShortVideo)localObject1).busiType)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if ((((ShortVideoUploadInfo)localObject2).jdField_i_of_type_JavaLangString == null) || (((ShortVideoUploadInfo)localObject2).jdField_i_of_type_JavaLangString.length() <= 0)) {
        ((ShortVideoUploadInfo)localObject2).jdField_i_of_type_JavaLangString = ((ShortVideoUploadInfo)localObject2).jdField_h_of_type_JavaLangString;
      }
      localDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ShortVideoUploadInfo)localObject2).jdField_i_of_type_JavaLangString, i, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).frienduin, false, paramBoolean, -1, null, ((ShortVideoUploadInfo)localObject2).jdField_f_of_type_Int, ((ShortVideoUploadInfo)localObject2).jdField_e_of_type_JavaLangString);
      return;
      i = 2001;
      continue;
      i = 2003;
    }
  }
  
  public void f(int paramInt)
  {
    try
    {
      this.bK = 1;
      this.bL = paramInt;
      if (this.bJ == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> handleBDHActError mVideoPreUpStatus = " + this.bK + " mVideoRecordStatus = " + this.bJ);
        }
        LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "handleBDHActError", "mVideoPreUpStatus = " + this.bK + " mVideoRecordStatus = " + this.bJ);
        z();
      }
      return;
    }
    finally {}
  }
  
  void g()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PreUploadVideoConfig.name(), "0|0|1.0|5|480000");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length < 5)) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.valueOf(localObject[4]).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> dpcTimeout : " + l1);
        }
        if (l1 > 0L) {
          this.s = l1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>get DpcConfig Erro", localNumberFormatException);
        }
      }
      long l1 = 0L;
    }
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
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = a();
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_up";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoUpReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      b();
    }
    do
    {
      return;
      if (localShortVideoUpReq.jdField_a_of_type_Long == 0L)
      {
        a(9303, "video filesize is 0");
        b();
        return;
      }
      if (this.jdField_l_of_type_Long == 0L)
      {
        a(9303, "thumbfile filesize is 0");
        b();
        return;
      }
      if ((localShortVideoUpReq.j == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().mConnManager.getCurrentConnNum() > 0)) {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
      a("requestStart", localRichProtoReq.toString());
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void t()
  {
    if (this.jdField_o_of_type_Boolean) {
      return;
    }
    if ((this.bm == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    if ((this.jdField_j_of_type_JavaLangString != null) && (this.jdField_h_of_type_JavaLangString != null) && (this.jdField_c_of_type_Long >= this.jdField_a_of_type_Long))
    {
      d(false);
      return;
    }
    a();
  }
  
  public void u()
  {
    if (NetworkUtil.i(BaseApplication.getContext())) {
      return;
    }
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
      i = ((SharedPreferences)localObject).getInt("key_video_rollback_counts", 0);
      long l1 = ((SharedPreferences)localObject).getLong("key_video_rollback_time", 0L);
      long l2 = NetConnInfoCenter.getServerTime();
      if ((i == 0) || (l1 == 0L)) {
        ((SharedPreferences)localObject).edit().putLong("key_video_rollback_time", l2).commit();
      }
      if (l2 - l1 < 0L) {
        ((SharedPreferences)localObject).edit().putLong("key_video_rollback_time", l2).commit();
      }
      ((SharedPreferences)localObject).edit().putInt("key_video_rollback_counts", i + 1).commit();
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "rollback", "recordRollbackCounts ：" + String.valueOf(i + 1));
      return;
    }
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> startTimerForPreUpload");
    }
    if (this.jdField_a_of_type_Vch == null) {
      this.jdField_a_of_type_Vch = new vch(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Vch, this.s);
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> stopTimerForPreUpload");
    }
    if (this.jdField_a_of_type_Vch != null)
    {
      this.jdField_a_of_type_Vch.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Vch);
      this.jdField_a_of_type_Vch = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\ShortVideoUploadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */