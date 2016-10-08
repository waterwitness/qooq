package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.bitapp.BitAppManager;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgFactory;
import com.tencent.bitapp.MessageForBitAppTmp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.LongStructMessageDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.LongStructMessageDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class StructLongMessageDownloadProcessor
  extends BaseDownloadProcessor
  implements Runnable
{
  public static final int aJ = 0;
  public static final int aK = 1;
  public static final int aL = 2;
  public static final int aM = 3;
  public static final int aN = 4;
  private static ConcurrentHashMap b = new ConcurrentHashMap();
  private static final int bA = 13;
  private static final int bB = 14;
  private static final int bC = 15;
  public static final int be = 5;
  public static final int bf = 6;
  public static final int bg = 7;
  public static final int bh = 8;
  public static final int bi = 9;
  public static final int bj = 10;
  public static final int bk = 11;
  public static final int bl = 12;
  public static final int bm = 13;
  public static final int bn = 14;
  public static final int bo = 15;
  public static final int bp = 16;
  private static final int bs = 5;
  private static final int bt = 6;
  private static final int bu = 7;
  private static final int bv = 8;
  private static final int bw = 9;
  private static final int bx = 10;
  private static final int by = 11;
  private static final int bz = 12;
  private static final ArrayList jdField_c_of_type_JavaUtilArrayList;
  public static final String i = "StructLongMessageDownloadProcessor";
  public static final String j = "StructLongMessageDownloadProcessorForReport";
  BitAppMsg jdField_a_of_type_ComTencentBitappBitAppMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private int bD = 5;
  private int bE;
  String bl = "";
  int bq = 4;
  int br = 200;
  private long jdField_c_of_type_Long;
  boolean d;
  private long j;
  String k = "";
  String l = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public StructLongMessageDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_d_of_type_Boolean = true;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int m = 0;
    while (m < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[m] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong, String paramString)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString;
    localHttpNetReq.c = 0;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
    b.put(Long.valueOf(paramLong), localHttpNetReq);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    FMTSrvAddrProvider.a().a().b(RichMediaUtil.a(paramString));
    this.k = paramString;
    this.j = System.nanoTime();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      if ((jdField_c_of_type_JavaUtilArrayList == null) || (jdField_c_of_type_JavaUtilArrayList.size() == 0) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask msgid" + paramLong);
      }
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (localTransferRequest.jdField_a_of_type_Long == paramLong)
          {
            paramQQAppInterface.c(localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long);
            jdField_c_of_type_JavaUtilArrayList.remove(localTransferRequest);
            a(false, localTransferRequest.jdField_b_of_type_JavaLangString, localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long);
          }
        }
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      Object localObject = jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((TransferRequest)((Iterator)localObject).next()).jdField_a_of_type_Long == paramMessageRecord.uniseq) {
          return;
        }
      }
      localObject = new TransferRequest();
      ((TransferRequest)localObject).jdField_a_of_type_Boolean = false;
      ((TransferRequest)localObject).c = paramMessageRecord.frienduin;
      ((TransferRequest)localObject).e = 131079;
      ((TransferRequest)localObject).jdField_b_of_type_Int = 131079;
      ((TransferRequest)localObject).jdField_a_of_type_Long = paramMessageRecord.uniseq;
      ((TransferRequest)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      ((TransferRequest)localObject).jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
      if (paramQQAppInterface.a().a((TransferRequest)localObject)) {
        jdField_c_of_type_JavaUtilArrayList.add(localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "getStructLongMessage , messageRecord,msgid= " + paramMessageRecord.uniseq);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download time start: " + System.currentTimeMillis());
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList2;
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      if ((jdField_c_of_type_JavaUtilArrayList == null) || (jdField_c_of_type_JavaUtilArrayList.size() == 0) || (paramString == null) || (paramQQAppInterface == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "deleteAllTask uin" + paramString);
      }
      localArrayList2 = new ArrayList();
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (paramString.equalsIgnoreCase(localTransferRequest.c))
          {
            paramQQAppInterface.c(localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long);
            localArrayList2.add(localTransferRequest);
            a(true, localTransferRequest.jdField_b_of_type_JavaLangString, localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long);
          }
        }
      }
    }
    jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList2);
  }
  
  private static void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramString1);
    localHashMap.put("param_puin", paramString2);
    localHashMap.put("param_channel", "0");
    if (paramBoolean) {
      localHashMap.put("param_errcode", String.valueOf(11));
    }
    for (;;)
    {
      localHashMap.put("param_resid", "" + paramLong);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramString1 = localHashMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        Object localObject = (Map.Entry)paramString1.next();
        paramString2 = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, paramString2 + (String)localObject);
      }
      localHashMap.put("param_errcode", String.valueOf(10));
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actLongMessageDownload", false, 0L, 0L, localHashMap, "", true);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return false;
      str1 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
      str2 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
      str3 = paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
    } while ((StringUtil.b(str1)) || (StringUtil.b(str2)) || (StringUtil.b(str3)));
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "isPALongMsg , messageRecord,msgid= " + paramMessageRecord.msgId + " uid= " + paramMessageRecord.msgUid + " msgseq= " + paramMessageRecord.msgseq + " uniseq=" + paramMessageRecord.uniseq);
    }
    return true;
  }
  
  private void f()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)) || ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBitAppTmp))) {
      synchronized (jdField_c_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (localTransferRequest.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq) {
            jdField_c_of_type_JavaUtilArrayList.remove(localTransferRequest);
          }
        }
        return;
      }
    }
  }
  
  private void f(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localObject1 != null)
      {
        if (paramInt != 2003) {
          break label267;
        }
        ((MessageForStructing)localObject1).removeExtInfoToExtStr("pub_long_msg_url");
        ((MessageForStructing)localObject1).removeExtInfoToExtStr("pub_long_msg_download_key");
        ((MessageForStructing)localObject1).removeExtInfoToExtStr("pub_long_msg_resid");
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare))
        {
          localObject2 = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mWarningTips;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((MessageForStructing)localObject1).saveExtInfoToExtStr("pa_phone_msg_tip", (String)localObject2);
          }
        }
        long l1 = 0L;
        if (((MessageForStructing)localObject1).structingMsg != null) {
          l1 = ((MessageForStructing)localObject1).structingMsg.msgId;
        }
        ((MessageForStructing)localObject1).structingMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        ((MessageForStructing)localObject1).structingMsg.msgId = l1;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage data size: " + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getBytes().length);
        }
        ((MessageForStructing)localObject1).msgData = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getBytes();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, ((MessageForStructing)localObject1).uniseq, ((MessageForStructing)localObject1).msgData);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, ((MessageForStructing)localObject1).uniseq, "extStr", ((MessageForStructing)localObject1).extStr);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, true, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c);
      }
    }
    label266:
    label267:
    do
    {
      do
      {
        do
        {
          break label266;
          do
          {
            return;
          } while (paramInt != 2005);
          ((MessageForStructing)localObject1).saveExtInfoToExtStr("longMsg_State", "2");
          ((MessageForStructing)localObject1).structingMsg.mMsgBrief = "消息下载失败";
          ((MessageForStructing)localObject1).msgData = ((MessageForStructing)localObject1).structingMsg.getBytes();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, ((MessageForStructing)localObject1).uniseq, ((MessageForStructing)localObject1).msgData);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, ((MessageForStructing)localObject1).uniseq, "extStr", ((MessageForStructing)localObject1).extStr);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, true, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c);
          return;
        } while (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBitAppTmp));
        localObject1 = (MessageForBitAppTmp)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      } while (localObject1 == null);
      localObject2 = (BitAppManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(143);
      if (paramInt == 2003)
      {
        ((MessageForBitAppTmp)localObject1).removeExtInfoToExtStr("pub_long_msg_url");
        ((MessageForBitAppTmp)localObject1).removeExtInfoToExtStr("pub_long_msg_download_key");
        ((MessageForBitAppTmp)localObject1).removeExtInfoToExtStr("pub_long_msg_resid");
        ((MessageForBitAppTmp)localObject1).removeExtInfoToExtStr("longMsg_State");
        if (((MessageForBitAppTmp)localObject1).bitAppMsg != null) {
          this.jdField_a_of_type_ComTencentBitappBitAppMsg.setMsgId(((MessageForBitAppTmp)localObject1).bitAppMsg.getMsgId());
        }
        ((MessageForBitAppTmp)localObject1).bitAppMsg = this.jdField_a_of_type_ComTencentBitappBitAppMsg;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage data size: " + this.jdField_a_of_type_ComTencentBitappBitAppMsg.getBytes().length);
        }
        ((MessageForBitAppTmp)localObject1).msgData = this.jdField_a_of_type_ComTencentBitappBitAppMsg.getBytes();
        ((BitAppManager)localObject2).a((MessageRecord)localObject1, "msgData", ((MessageForBitAppTmp)localObject1).msgData);
        ((BitAppManager)localObject2).a((MessageRecord)localObject1, "extStr", ((MessageForBitAppTmp)localObject1).extStr);
        ((BitAppManager)localObject2).d((MessageForBitAppTmp)localObject1);
        return;
      }
    } while (paramInt != 2005);
    ((MessageForBitAppTmp)localObject1).saveExtInfoToExtStr("longMsg_State", "2");
  }
  
  private boolean f()
  {
    this.jdField_d_of_type_Boolean = true;
    this.bD = 5;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localMessageRecord == null) {}
    do
    {
      return false;
      localObject = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_url");
      str1 = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
      this.l = localMessageRecord.selfuin;
      this.bl = localMessageRecord.frienduin;
    } while ((localObject == null) || ("".equals(localObject)) || (str1 == null) || ("".equals(str1)));
    String str2 = (String)localObject + "&rkey=" + str1;
    String str1 = FMTSrvAddrProvider.a().b();
    Object localObject = str1;
    if (str1 == null)
    {
      localObject = FMTSrvAddrProvider.a().a().a();
      this.bD = 10;
      this.bE = FMTSrvAddrProvider.a().a().a();
    }
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      switch (FMTSrvAddrProvider.a().a())
      {
      default: 
        this.bD = 7;
        return false;
      }
      this.bD = 6;
      return false;
    }
    localObject = (String)localObject + str2;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "directUrl = " + str2 + ",url:" + (String)localObject);
    }
    a(localMessageRecord.uniseq, (String)localObject);
    ThreadManager.b().postDelayed(this, 30000L);
    return true;
  }
  
  private void g()
  {
    this.jdField_d_of_type_Boolean = false;
    this.bE = 0;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localMessageRecord == null)
    {
      this.bq = 15;
      b();
    }
    String str;
    RichProto.RichProtoReq localRichProtoReq;
    do
    {
      do
      {
        return;
        str = localMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
        if ((str != null) && (!str.equals(""))) {
          break;
        }
      } while (!b(localMessageRecord));
      this.bq = 13;
      b();
      return;
      localRichProtoReq = new RichProto.RichProtoReq();
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "pa_long_message";
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        this.bq = 16;
        b();
        return;
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProto.RichProtoReq.LongStructMessageDownReq localLongStructMessageDownReq = new RichProto.RichProtoReq.LongStructMessageDownReq();
    localLongStructMessageDownReq.jdField_a_of_type_JavaLangString = str;
    localLongStructMessageDownReq.d = localMessageRecord.frienduin;
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localLongStructMessageDownReq);
    RichProtoProc.a(localRichProtoReq);
    this.jdField_c_of_type_Long = System.nanoTime();
  }
  
  private void s()
  {
    g();
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Cancel");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", this.l);
    localHashMap.put("param_puin", this.bl);
    localHashMap.put("param_channel", "0");
    localHashMap.put("param_errcode", String.valueOf(7));
    localHashMap.put("param_url", this.k);
    if (QLog.isColorLevel())
    {
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str + (String)localObject);
      }
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actLongMessageDownload", false, 0L, 0L, localHashMap, "", true);
  }
  
  public void a()
  {
    super.a();
    if (!f()) {
      g();
    }
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Beacon Report Expired");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", paramMessageRecord.selfuin);
    localHashMap.put("param_puin", paramMessageRecord.frienduin);
    localHashMap.put("param_resid", paramMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
    localHashMap.put("param_channel", "0");
    localHashMap.put("param_errcode", String.valueOf(paramInt));
    localHashMap.put("param_url", this.k);
    if (QLog.isColorLevel())
    {
      paramMessageRecord = localHashMap.entrySet().iterator();
      while (paramMessageRecord.hasNext())
      {
        Object localObject = (Map.Entry)paramMessageRecord.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str + (String)localObject);
      }
    }
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actLongMessageDownload", false, 0L, 0L, localHashMap, "", true);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    this.bq = 3;
    paramMessageRecord.saveExtInfoToExtStr("longMsg_State", "3");
    Object localObject;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)paramMessageRecord;
      ((MessageForStructing)localObject).structingMsg.mMsgBrief = "消息下载失败";
      ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, ((MessageForStructing)localObject).uniseq, ((MessageForStructing)localObject).msgData);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, ((MessageForStructing)localObject).uniseq, "extStr", ((MessageForStructing)localObject).extStr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, true, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.c);
    }
    for (;;)
    {
      f();
      a(this.bq, paramMessageRecord);
      return;
      if ((paramMessageRecord instanceof MessageForBitAppTmp))
      {
        localObject = (MessageForBitAppTmp)paramMessageRecord;
        ((BitAppManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(143)).b((MessageForBitAppTmp)localObject);
      }
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    int m = 1;
    if (this.jdField_d_of_type_Boolean) {
      ThreadManager.b().removeCallbacks(this);
    }
    if (paramNetResp == null) {
      return;
    }
    super.a(paramNetResp);
    this.aU = paramNetResp.f;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download time end: " + System.currentTimeMillis());
    }
    if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      a("onResp", "result:" + paramNetResp.e + " errCode:" + paramNetResp.g + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      this.br = paramNetResp.g;
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      if (localHttpNetReq.jdField_a_of_type_JavaLangString != null)
      {
        Iterator localIterator = b.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localHttpNetReq.jdField_a_of_type_JavaLangString.equals(((HttpNetReq)localEntry.getValue()).jdField_a_of_type_JavaLangString)) {
            b.remove(localEntry.getKey());
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    if ((paramNetResp.e == 0) && (paramNetResp.jdField_a_of_type_ArrayOfByte != null) && (paramNetResp.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      paramNetResp = paramNetResp.jdField_a_of_type_ArrayOfByte;
      this.jdField_a_of_type_Long = paramNetResp.length;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing))
      {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = StructMsgFactory.a(paramNetResp, -1);
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 1008) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgBrief)) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mEmptyMsgBriefModified))) {
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgBrief = "你有新消息";
        }
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) || (this.jdField_a_of_type_ComTencentBitappBitAppMsg != null))
      {
        this.bq = 0;
        c();
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actLongMessageTimeDownload", true, (System.nanoTime() - this.j) / 1000000L, 0L, null, "", true);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBitAppTmp)) {
          this.jdField_a_of_type_ComTencentBitappBitAppMsg = BitAppMsgFactory.a(paramNetResp, -1);
        }
      }
      if ((this.k != null) && (!"".equals(this.k))) {
        FMTSrvAddrProvider.a().a().a(RichMediaUtil.a(this.k));
      }
      if (this.jdField_d_of_type_Boolean)
      {
        if (this.bD == 5) {}
        for (m = 9;; m = 12)
        {
          this.bD = m;
          s();
          return;
        }
      }
      this.bq = 12;
      b();
      return;
    }
    if ((this.k != null) && (!"".equals(this.k))) {
      FMTSrvAddrProvider.a().a().a(RichMediaUtil.a(this.k));
    }
    if ((((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)) || ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBitAppTmp))) && (a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) && (399 < this.br) && (this.br < 500)) {}
    for (;;)
    {
      if (m != 0)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
      }
      if ((paramNetResp.f == 9364) && (this.aW < 3))
      {
        this.aW += 1;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageDownloadProcessor", 2, "LongMessage Download Fail. Net Changed. Retry " + this.aW);
        }
        q();
        this.bD = 15;
        g();
        return;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        if (this.bD == 5) {}
        for (m = 8;; m = 11)
        {
          this.bD = m;
          s();
          return;
        }
      }
      this.bq = 14;
      b();
      return;
      m = 0;
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if ((paramRichProtoResp != null) && (paramRichProtoResp.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoResp.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(0) instanceof RichProto.RichProtoResp.LongStructMessageDownResp)))
    {
      paramRichProtoReq = (RichProto.RichProtoResp.LongStructMessageDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
      if ((paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo.ret_code.get() == 0))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, paramRichProtoReq.jdField_a_of_type_JavaLangString);
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actLongMessageTimeSSO", true, (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L, 0L, null, "", true);
        return;
      }
      this.bq = 1;
      b();
      return;
    }
    this.bq = 1;
    b();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongMessageDownloadProcessor", 2, String.format("LongMessage Download Beacon Report ErrCode=%d mReportedFlag=%x ", new Object[] { Integer.valueOf(this.bq), Integer.valueOf(this.aX) }) + hashCode());
    }
    if ((this.i) || ((paramBoolean) && ((this.aX & 0x2) > 0)) || ((!paramBoolean) && ((this.aX & 0x1) > 0))) {
      return;
    }
    int n = this.aX;
    if (paramBoolean) {}
    long l1;
    for (int m = 2;; m = 1)
    {
      this.aX = (m | n);
      this.e = System.currentTimeMillis();
      l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.selfuin);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_puin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_resid", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_ip_source", "" + this.bD);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_channel", "0");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errcode", String.valueOf(this.bq));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", this.k);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_http_error_code", String.valueOf(this.br));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_android_error_code", String.valueOf(this.aU));
      if (!QLog.isColorLevel()) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        QLog.d("StructLongMessageDownloadProcessorForReport", 2, str + (String)localObject);
      }
    }
    if (paramBoolean) {
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actLongMessageDownload", true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "", true);
    }
    for (;;)
    {
      p();
      return;
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actLongMessageDownload", false, l1, 0L, this.jdField_a_of_type_JavaUtilHashMap, "", true);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    long l1;
    do
    {
      return false;
      l1 = NetConnInfoCenter.getServerTime();
    } while (paramMessageRecord.time >= l1 - 604800L);
    return true;
  }
  
  public void b()
  {
    super.b();
    f(2005);
    d(2005);
    f();
  }
  
  public int c()
  {
    return super.c();
  }
  
  public void c()
  {
    super.c();
    f(2003);
    d(2003);
    f();
  }
  
  public void d()
  {
    d(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    this.bq = 7;
    e();
  }
  
  public void d(long paramLong)
  {
    synchronized (jdField_c_of_type_JavaUtilArrayList)
    {
      if ((jdField_c_of_type_JavaUtilArrayList == null) || (jdField_c_of_type_JavaUtilArrayList.size() == 0)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageDownloadProcessor", 2, "cancelAllTask msgid" + paramLong);
      }
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localTransFileController != null)
      {
        Iterator localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
          if (localTransferRequest.jdField_a_of_type_Long == paramLong)
          {
            localTransFileController.c(localTransferRequest.c, localTransferRequest.jdField_a_of_type_Long);
            jdField_c_of_type_JavaUtilArrayList.remove(localTransferRequest);
          }
        }
      }
      return;
    }
  }
  
  public void e()
  {
    t();
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StructLongMessageDownloadProcessor", 2, "Direct download failed timeout");
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    }
    if (this.bD == 5) {}
    for (int m = 13;; m = 14)
    {
      this.bD = m;
      if ((this.k != null) && (!"".equals(this.k))) {
        FMTSrvAddrProvider.a().a().a(RichMediaUtil.a(this.k));
      }
      g();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\StructLongMessageDownloadProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */