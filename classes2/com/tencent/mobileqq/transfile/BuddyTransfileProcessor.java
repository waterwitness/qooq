package com.tencent.mobileqq.transfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Time;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import vab;
import vac;

public class BuddyTransfileProcessor
  extends BaseTransProcessor
{
  private static List jdField_b_of_type_JavaUtilList = new ArrayList();
  public static final int be = 0;
  public static final int bf = 1;
  public static final int bg = 2;
  private static final String bl = "photo/";
  private static final String bm = "file/";
  public static final String d = "streamptt";
  public static boolean d = false;
  public static final String e = "streamptt.recv";
  public static final String f = "streamptt.send";
  public static final String g = "ftn";
  public static final String h = "pttcenter";
  public static final String i = "picplatform";
  long jdField_a_of_type_Long = -1L;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vab(this);
  public QQAppInterface a;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  public boolean a;
  int aH = 0;
  int aI = 1;
  int aJ = 0;
  int aK = -1;
  int aL = -1;
  public int aM = 0;
  public int aN = 0;
  private long jdField_b_of_type_Long;
  public boolean b;
  private int bh;
  public boolean c;
  public boolean e = false;
  public boolean f = false;
  private boolean g;
  private String j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
  private String k;
  private String l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_d_of_type_Boolean = true;
  }
  
  public BuddyTransfileProcessor(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, int paramInt1, int paramInt2, boolean paramBoolean2, TransFileController paramTransFileController, long paramLong)
  {
    super(paramString1, paramString2, paramBoolean1, paramTransFileController);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    paramInt2 = paramInt1;
    if (paramInt1 == 131075)
    {
      paramInt2 = 1;
      this.jdField_a_of_type_Boolean = true;
    }
    this.l = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.u = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.v = this.j;
    if ((!paramBoolean1) && (paramBoolean2))
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.r = this.j;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.s = paramString1;
    }
    for (this.k = this.j;; this.k = paramString1)
    {
      c(false);
      e(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.bv = 0;
      if (FileUtils.c(paramString3)) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString = paramString3;
      }
      if ((paramString4 != null) && (!FileUtils.c(paramString4))) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = paramString4;
      }
      if (paramInt2 == 65538)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.h = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = "gif";
      }
      if (paramInt2 == 2) {
        RichMediaUtil.c(AppSetting.jdField_a_of_type_Int);
      }
      if ((paramInt2 == 2) && (paramBoolean1))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.k, 0, paramLong);
        if (paramString1 != null)
        {
          this.jdField_b_of_type_Long = MessageUtils.a(paramString1.msgUid);
          this.bh = ((int)paramString1.shmsgseq);
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt", 2, "random:" + this.jdField_b_of_type_Long + " msgseq:" + this.bh);
        }
      }
      return;
    }
  }
  
  public static BuddyTransfileProcessor.A9Message a(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    BuddyTransfileProcessor.A9Message localA9Message = new BuddyTransfileProcessor.A9Message();
    long l1 = paramArrayOfLong[0];
    byte[] arrayOfByte;
    if (paramArrayOfByte[0] == 1)
    {
      localA9Message.jdField_a_of_type_Byte = paramArrayOfByte[1];
      int i1 = PkgTools.a(paramArrayOfByte, 2) + 4;
      int n = paramArrayOfByte[i1];
      int m = n;
      if (n < 0) {
        m = n + 256;
      }
      n = i1 + 1;
      arrayOfByte = new byte[m];
      PkgTools.a(arrayOfByte, 0, paramArrayOfByte, n, m);
      m += n;
      l1 = PkgTools.a(paramArrayOfByte, m + 2 + PkgTools.a(paramArrayOfByte, m));
      if (arrayOfByte != null) {
        if (l1 > 10000L) {
          paramArrayOfLong[0] = l1;
        }
      }
    }
    for (paramArrayOfByte = new String(arrayOfByte);; paramArrayOfByte = null)
    {
      localA9Message.jdField_a_of_type_JavaLangString = paramArrayOfByte;
      return localA9Message;
    }
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult a(byte[] paramArrayOfByte, short paramShort, long[] paramArrayOfLong)
  {
    BuddyTransfileProcessor.C2CPicMsgParseResult localC2CPicMsgParseResult;
    long l1;
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getFileUuid msgHex:" + HexUtil.bytes2HexStr(paramArrayOfByte));
      }
      localC2CPicMsgParseResult = new BuddyTransfileProcessor.C2CPicMsgParseResult();
      if (paramShort != 169) {
        break label375;
      }
      localC2CPicMsgParseResult.jdField_a_of_type_Int = 1;
      if (paramArrayOfByte[0] != 1) {
        break label402;
      }
      paramShort = paramArrayOfByte[1];
      int m = PkgTools.a(paramArrayOfByte, 2);
      localC2CPicMsgParseResult.jdField_a_of_type_ArrayOfByte = new byte[m];
      PkgTools.a(localC2CPicMsgParseResult.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, 4, m);
      int n = m + 4;
      m = paramArrayOfByte[n];
      n += 1;
      localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte = new byte[m];
      PkgTools.a(localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte, n, m);
      n += m;
      m = PkgTools.a(paramArrayOfByte, n);
      n += 2;
      localC2CPicMsgParseResult.jdField_c_of_type_ArrayOfByte = new byte[m];
      PkgTools.a(localC2CPicMsgParseResult.jdField_c_of_type_ArrayOfByte, 0, paramArrayOfByte, n, m);
      l1 = PkgTools.a(paramArrayOfByte, n + m);
    }
    for (;;)
    {
      if (localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte != null)
      {
        localC2CPicMsgParseResult.jdField_a_of_type_Long = 0L;
        if (l1 > 10000L) {
          paramArrayOfLong[0] = l1;
        }
        localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString = new String(localC2CPicMsgParseResult.jdField_b_of_type_ArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "analysisFileC2cMsg  dwReserved: " + l1 + " serverPath:" + localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        if (localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString != null)
        {
          localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString = TransfileUtile.a(localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString, localC2CPicMsgParseResult.jdField_a_of_type_Long, paramShort, false, localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString);
          }
        }
        return localC2CPicMsgParseResult;
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getFriendPhotoMsg vMsg is null");
        }
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "analysisFileC2cMsg fail");
        }
        return null;
        label375:
        if ((paramArrayOfByte[0] == 22) && (paramArrayOfByte[1] == 32)) {
          return a(paramArrayOfByte, false);
        }
        paramShort = 0;
      }
      label402:
      l1 = 0L;
      paramShort = 0;
    }
  }
  
  public static BuddyTransfileProcessor.C2CPicMsgParseResult a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    BuddyTransfileProcessor.C2CPicMsgParseResult localC2CPicMsgParseResult = new BuddyTransfileProcessor.C2CPicMsgParseResult();
    localC2CPicMsgParseResult.jdField_a_of_type_Int = 2;
    PkgTools.a(paramArrayOfByte, 2, 3).longValue();
    int n;
    int m;
    if ((paramArrayOfByte[5] == 49) && (paramArrayOfByte[6] == 48))
    {
      PkgTools.a(paramArrayOfByte, 7, 3).longValue();
      if (paramArrayOfByte[10] != 50) {
        break label304;
      }
      n = 11;
      localC2CPicMsgParseResult.jdField_b_of_type_Int = (paramArrayOfByte[11] - 65);
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path repeat");
        m = n;
      }
    }
    for (;;)
    {
      if (paramArrayOfByte[m] == 65)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "parse down file path success");
        }
        if ((paramArrayOfByte.length <= m + 1) || (paramArrayOfByte[(m + 1)] != 10)) {}
      }
      try
      {
        localC2CPicMsgParseResult.d = new String(paramArrayOfByte, "utf-8").substring(m + 2);
        if (localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString != null)
        {
          paramArrayOfByte = null;
          if (localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString.length() > 0) {
            paramArrayOfByte = localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString.split("\\.")[0];
          }
          localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString = TransfileUtile.a(localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString, localC2CPicMsgParseResult.jdField_a_of_type_Long, 1, false, localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString, paramArrayOfByte, null);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "<---decodeOffLinePic : md5Str:" + paramArrayOfByte + ",afterDecode:" + TransfileUtile.a(localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString));
          }
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.jdField_c_of_type_JavaLangString);
          }
        }
        return localC2CPicMsgParseResult;
        label304:
        if (paramArrayOfByte[10] == 49)
        {
          m = paramArrayOfByte[11];
          m = 12;
          if (paramArrayOfByte[12] - 65 == 0)
          {
            localC2CPicMsgParseResult.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 13, 10).longValue();
            n = 23;
            m = n;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("streamptt", 2, "getFriendPhotoMsg offline file path fail");
            m = n;
            continue;
          }
          if (paramArrayOfByte[12] - 65 != 1) {
            continue;
          }
          localC2CPicMsgParseResult.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 13, 10).longValue();
          m = paramArrayOfByte[23] - 65;
          byte[] arrayOfByte = new byte[m];
          PkgTools.a(arrayOfByte, 0, paramArrayOfByte, 24, m);
          localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString = new String(arrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt", 2, "<---decodeOffLinePic : ret.fileName:" + localC2CPicMsgParseResult.jdField_b_of_type_JavaLangString);
          }
          n = m + 24;
          m = paramArrayOfByte[n] - 65;
          n += 1;
          arrayOfByte = new byte[m];
          PkgTools.a(arrayOfByte, 0, paramArrayOfByte, n, m);
          n += m;
          try
          {
            localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString = new String(arrayOfByte, "utf-8");
            m = n;
            if (QLog.isColorLevel())
            {
              QLog.d("streamptt", 2, "getFriendPhotoMsg serverPath:" + localC2CPicMsgParseResult.jdField_a_of_type_JavaLangString);
              m = n;
            }
          }
          catch (Exception localException)
          {
            m = n;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          QLog.w("streamptt", 2, "buddy_mixed, decode action error");
        }
        m = 10;
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    return a(paramString1, paramString2, paramInt, paramArrayOfByte, true);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Object localObject = AppConstants.bj + paramString1 + "/";
    switch (paramInt)
    {
    default: 
      paramArrayOfByte = "";
      paramString1 = null;
      paramString2 = (String)localObject;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getTransferFilePath dir: " + paramString2);
      }
      localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString1 = new File(paramString2 + paramArrayOfByte + paramString1);
      if (paramInt == 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
        }
        return paramString1.getAbsoluteFile().toString();
        paramArrayOfByte = (String)localObject + "ptt/" + c() + "/";
        String str2 = ".amr";
        localObject = str2;
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label619;
        }
        if (QLog.isColorLevel()) {
          QLog.i("streamptt", 2, "pttdown,33333");
        }
        String str1 = "stream_" + d();
        paramString2 = str2;
        paramString1 = paramArrayOfByte;
        localObject = str1;
        if (!QLog.isColorLevel()) {
          break label631;
        }
        QLog.i("streamptt", 2, "pttdown,name = " + str1);
        paramString1 = ".amr";
        paramString2 = paramArrayOfByte;
        paramArrayOfByte = str1;
        break;
        str1 = (String)localObject + "photo/";
        str2 = ".jpg";
        localObject = str2;
        paramString1 = str1;
        if (paramString2 != null) {
          break label619;
        }
        String str3 = d();
        paramString2 = str2;
        paramString1 = str1;
        localObject = str3;
        if (paramArrayOfByte == null) {
          break label631;
        }
        paramArrayOfByte = str3 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
        paramString1 = ".jpg";
        paramString2 = str1;
        break;
        str1 = AppConstants.bv;
        localObject = paramString2;
        if (paramString2 == null)
        {
          paramString1 = d();
          localObject = paramString1;
          if (paramArrayOfByte != null) {
            localObject = paramString1 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
          }
        }
        paramString1 = "";
        paramString2 = str1;
        paramArrayOfByte = (byte[])localObject;
        break;
        paramArrayOfByte = (String)localObject + "ptt/";
        localObject = ".slk";
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label619;
        }
        localObject = "buluo_" + d();
        paramString1 = ".slk";
        paramString2 = paramArrayOfByte;
        paramArrayOfByte = (byte[])localObject;
        break;
        if ((paramBoolean) && (!paramString1.exists())) {
          try
          {
            paramString1.createNewFile();
          }
          catch (IOException paramString2) {}
        }
      }
      label619:
      paramArrayOfByte = "";
      paramString2 = paramString1;
      paramString1 = (String)localObject;
      continue;
      label631:
      paramArrayOfByte = paramString1;
      paramString1 = paramString2;
      paramString2 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject;
    }
  }
  
  private void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramLong);
    if ((localMessage != null) && (localMessage.uniseq == paramLong)) {
      localMessage.extraflag = 32768;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramLong, 32768, paramInt2);
  }
  
  private void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    int i1 = 0;
    int m = paramUploadStreamStruct.jdField_a_of_type_Short;
    int n = (short)paramUploadStreamStruct.jdField_a_of_type_Int;
    String str = paramUploadStreamStruct.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {
      if (paramUploadStreamStruct.jdField_b_of_type_Int != 0)
      {
        this.aL = paramUploadStreamStruct.jdField_b_of_type_Int;
        a(this.l, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, this.aL);
        a(2, 9312, "friend_block");
        b();
        StreamDataManager.b(str);
        StreamDataManager.a(str);
        if (paramUploadStreamStruct.jdField_b_of_type_Int == 58) {
          f();
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt.send", 2, "respCode = " + this.aL);
        }
      }
    }
    do
    {
      int i2;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (m == -1)
              {
                this.e = true;
                c(2);
                this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(StreamDataManager.b(str)));
                this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString).length();
                StreamDataManager.a(str);
                this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.fileKey;
                if (paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.pttTransFlag == 1) {
                  i1 = 1;
                }
                this.aK = i1;
                this.jdField_a_of_type_Long = paramUploadStreamStruct.jdField_a_of_type_QQServiceStreamInfo.msgTime;
                c();
                return;
              }
            } while (this.e);
            i1 = StreamDataManager.a(str);
            if (i1 > 10)
            {
              if (QLog.isColorLevel()) {
                QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: preLayer > 10");
              }
              a(2, 9310, "retry overflow");
              b();
              StreamDataManager.b(str);
              StreamDataManager.a(str);
              return;
            }
            i2 = StreamDataManager.c(str);
            int i3 = StreamDataManager.b(str);
            this.aI = m;
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.send", 2, "server reset.ResetSeq: " + m + " packnum: " + i3 + ",slices:" + i2 + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long + ",flowLayer:" + n + ",prelayer:" + i1);
            }
          } while (i1 >= n);
          StreamDataManager.a(str, n);
          a(true, m, (short)i2);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(2, 2);
          return;
        } while (this.e);
        i1 = StreamDataManager.c(str);
        i2 = StreamDataManager.a(str);
        if (paramUploadStreamStruct.jdField_a_of_type_Int >= i2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: info.layer < flowlayer");
      return;
      if (this.aJ == m)
      {
        if (this.aH < 8)
        {
          this.aH += 1;
          this.aJ = 0;
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.send", 2, "client check timeout.retry:severAckSlice:" + this.aI + " packnum: " + i1 + " maxSendSeq:" + this.aJ + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long + ",retryCount:" + this.aH + ",flowLayer:" + i2);
          }
          a(true, (short)this.aI, (short)i1);
          return;
        }
        a(2, 9310, "timeout");
        b();
        StreamDataManager.a(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: sendSeqMax != shResetSeq");
  }
  
  public static String c()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if (localTime.month + 1 > 9) {}
    for (String str = "" + (localTime.month + 1);; str = "0" + (localTime.month + 1)) {
      return "" + localTime.year + str + "/" + localTime.monthDay;
    }
  }
  
  private static String d()
  {
    try
    {
      Thread.sleep(1L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l1 = MessageCache.a();
    MessageRecord localMessageRecord = MessageRecordFactory.a(63524);
    localMessageRecord.init(str, this.l, str, "你已屏蔽%s的会话", l1, 0, 0, l1);
    localMessageRecord.msgtype = 63524;
    localMessageRecord.isread = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, str);
  }
  
  public MessageRecord a(long paramLong, StreamInfo paramStreamInfo)
  {
    Object localObject1 = new byte[3];
    PkgTools.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i.length(), (byte[])localObject1, 0, 3, "utf-8");
    localObject1 = (MessageForPtt)MessageRecordFactory.a(63534);
    ((MessageForPtt)localObject1).voiceType = ((int)paramStreamInfo.pttFormat);
    ((MessageForPtt)localObject1).voiceLength = ((int)paramStreamInfo.pttTime);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "voiceLength createMessageDataBaseContent " + ((MessageForPtt)localObject1).voiceLength);
    }
    ((MessageForPtt)localObject1).selfuin = this.j;
    ((MessageForPtt)localObject1).frienduin = this.l;
    ((MessageForPtt)localObject1).senderuin = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.r;
    ((MessageForPtt)localObject1).isread = false;
    ((MessageForPtt)localObject1).time = paramStreamInfo.msgTime;
    ((MessageForPtt)localObject1).setPttStreamFlag(10001);
    ((MessageForPtt)localObject1).msgtype = 63534;
    ((MessageForPtt)localObject1).istroop = 0;
    ((MessageForPtt)localObject1).urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i;
    ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject1).voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString);
    Object localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString);
    int m;
    if (((File)localObject2).exists())
    {
      ((MessageForPtt)localObject1).fileSize = ((File)localObject2).length();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800610E", "0X800610E", 1, 0, "", "", "", "6.5.5");
      ((MessageForPtt)localObject1).itemType = 2;
      ((MessageForPtt)localObject1).isread = false;
      ((MessageForPtt)localObject1).shmsgseq = ((short)paramStreamInfo.msgSeq);
      ((MessageForPtt)localObject1).msgUid = MessageUtils.a((int)paramStreamInfo.random);
      if ((paramStreamInfo.pttTransFlag != 1) && (!SttManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label703;
      }
      m = 1;
      label318:
      ((MessageForPtt)localObject1).sttAbility = m;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((MessageForPtt)localObject1).isSend()) {
        break label709;
      }
    }
    label703:
    label709:
    for (paramStreamInfo = this.j;; paramStreamInfo = this.l)
    {
      ((MessageForPtt)localObject1).longPttVipFlag = MessageUtils.a((QQAppInterface)localObject2, paramStreamInfo);
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = ((MessageForPtt)localObject1).time;
      ((MessageForPtt)localObject1).msgRecTime = l1;
      ((MessageForPtt)localObject1).msgTime = l2;
      ((MessageForPtt)localObject1).serial();
      l1 = paramLong;
      if (paramLong == 4294967295L)
      {
        paramLong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPtt)localObject1).frienduin);
        l1 = paramLong;
        if (QLog.isColorLevel())
        {
          QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent: invalid bubbleID 0xffffffff. get one from cache:" + paramLong);
          l1 = paramLong;
        }
      }
      ((MessageForPtt)localObject1).vipBubbleID = l1;
      if (QLog.isColorLevel()) {
        QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent:time" + ((MessageForPtt)localObject1).time + " urlAtServer:" + ((MessageForPtt)localObject1).urlAtServer + " bubbleId:" + l1 + " msgseq:" + ((MessageForPtt)localObject1).shmsgseq + " msgUid:" + ((MessageForPtt)localObject1).msgUid);
      }
      paramStreamInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageForPtt)localObject1).frienduin, ((MessageForPtt)localObject1).istroop);
      if ((paramStreamInfo == null) || (paramStreamInfo.size() <= 0)) {
        break label717;
      }
      paramStreamInfo = paramStreamInfo.iterator();
      do
      {
        if (!paramStreamInfo.hasNext()) {
          break;
        }
      } while (!MsgProxyUtils.a((MessageRecord)paramStreamInfo.next(), (MessageRecord)localObject1, true));
      if (QLog.isColorLevel()) {
        QLog.w("streamptt", 2, "same Ptt :" + ((MessageForPtt)localObject1).getBaseInfoString());
      }
      return null;
      ((MessageForPtt)localObject1).fileSize = 1000L;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800610E", "0X800610E", 2, 0, "", "", "", "6.5.5");
      break;
      m = 0;
      break label318;
    }
    label717:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.j);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(((MessageForPtt)localObject1).uniseq);
    return (MessageRecord)localObject1;
  }
  
  public void a() {}
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_d_of_type_Boolean = true;
    b(2);
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startReceiveOneStreamPack:" + paramStreamInfo.pttFormat + ", " + paramStreamInfo.pttTime);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(4, paramStreamData.vData.length);
    switch (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
          {
            if (!Environment.getExternalStorageState().equals("mounted")) {
              a(9039, "not mounted");
            }
            for (;;)
            {
              paramStreamInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
              paramStreamInfo.putBoolean("sdcard_related_download_failed", true);
              paramStreamInfo.commit();
              b();
              return;
              a(9040, "no enough storage");
            }
          }
          m = StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.recv", 2, "curFlowLayer: " + m + " received shFlowLayer:" + paramStreamInfo.shFlowLayer + ",seq" + paramStreamData.shPackSeq + ",packNum:" + paramStreamInfo.shPackNum + " lkey:" + paramLong1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 2, 0, paramStreamData.vData.length);
          StreamDataManager.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramLong1);
          if (m != paramStreamInfo.shFlowLayer)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.j, this.k, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, StreamDataManager.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i), paramLong1);
            return;
          }
          if (StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramStreamData.shPackSeq))
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(2, 2);
            short s = (short)(StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i) + 1);
            StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, s);
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack JudgeReceiveError flowLayer: " + s);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.j, this.k, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, StreamDataManager.c(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i), paramLong1);
            return;
          }
          if (paramStreamInfo.oprType == 1) {}
          for (m = 1; m != 0; m = 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "cancelled:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.l, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
            StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, true);
            StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
            return;
          }
          StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramStreamInfo.shFlowLayer);
          StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, paramStreamData.vData, paramStreamData.vData.length, paramStreamData.shPackSeq);
        } while (paramStreamInfo.shPackNum <= 0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.l, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
        StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, false);
        StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
        paramStreamData = this.j + "_" + this.k + "_" + paramStreamInfo.iMsgId;
        if (!jdField_b_of_type_JavaUtilList.contains(paramStreamData)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.recv", 2, "find stream stream duplicate,discard it ,key:" + paramStreamData);
      return;
      jdField_b_of_type_JavaUtilList.add(paramStreamData);
      long l1 = paramStreamInfo.iSendTime;
      paramStreamData = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(l1 * 1000L));
      paramStreamData = this.k + "_" + paramStreamData;
      if (QLog.isColorLevel()) {
        QLog.d("streamptt.recv", 2, "stream duplicateKey:" + paramStreamData);
      }
      if (!StreamDataManager.e(paramStreamData)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.recv", 2, "find stream offline duplicate,stop stream recv");
    return;
    StreamDataManager.c(paramStreamData);
    c(2);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack received success path: " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.j, this.k, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, (short)-1, paramLong1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = paramStreamInfo.fileKey;
    if (paramStreamInfo.pttTransFlag == 1) {}
    for (int m = 1;; m = 0)
    {
      this.aK = m;
      if (a(paramLong2, paramStreamInfo) != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
      }
      c();
      PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, true, 3);
      PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, true, 2);
      return;
    }
  }
  
  public void a(short paramShort, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.aM = paramInt2;
    this.aN = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startSendOneStreamPack:" + paramInt2 + ", " + paramInt1 + ", " + paramShort);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_d_of_type_Boolean = true;
    String str = "";
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ("0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.Z = 1001;
      b(2);
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      }
      b(2);
      if (paramShort > this.aJ) {
        this.aJ = paramShort;
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int)
      {
      default: 
        return;
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new vac(this, str, paramShort, paramBoolean));
  }
  
  protected void a(boolean paramBoolean)
  {
    if (RichMediaStrategy.c(this.aU)) {
      break label10;
    }
    label10:
    label581:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int == 2) && (!this.g) && (!RichMediaStrategy.c(this.aU)))
      {
        long l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
        HashMap localHashMap = new HashMap();
        if (!this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_d_of_type_Boolean) {
          localHashMap.put("param_step", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a(1) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a(2) + ";" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a(3));
        }
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0)
          {
            localHashMap.put("param_toUin", this.k);
            localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_a_of_type_JavaUtilHashMap);
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", true, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString)) {
              break;
            }
            PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString, true, paramBoolean, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
            return;
          }
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttDownload", true, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
          if (!BaseTransProcessor.a(this.aU, localHashMap))
          {
            localHashMap.put("param_FailCode", Integer.toString(this.aU));
            if ((this.aU == 56009) || (this.aU == 9311) || (this.aU == 9044) || (this.aU == 9350) || (this.aU == 9351))
            {
              localHashMap.put(BaseTransProcessor.be, this.bc);
              localHashMap.put("param_toUin", this.k);
              StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", false, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString)) {
                PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString, true, paramBoolean, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
              }
            }
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 2) {
            break label581;
          }
          RichMediaUtil.c(true, String.valueOf(this.aU) + "_" + this.bc);
          return;
          localHashMap.put("param_errorDesc", this.bc);
          break;
          this.aU = 56009;
          localHashMap.put("param_errorDesc", this.bc);
          break;
          localHashMap.put("param_FailCode", String.valueOf(this.aU));
          localHashMap.put("param_errorDesc", this.bc);
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actC2CStreamPttDownload", false, l1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long, localHashMap, "");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    while (paramShort1 <= paramShort2)
    {
      a((short)paramShort1, true, this.aN, this.aM);
      paramShort1 += 1;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      a(9366, "account switch");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onError elapsed:" + l1 + " errCode:" + this.aU + " errDesc:" + this.bc + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason") + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      a(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int != 0) {
        break;
      }
      d(1005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.l, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      return;
    }
    d(2005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.l, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
  }
  
  public void b(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int != 2) {
          break label335;
        }
        MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.l, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
        localMessageForPtt.url = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString;
        localMessageForPtt.fileSize = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f;
        localMessageForPtt.itemType = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.aC != 1) {
          break label336;
        }
        paramBoolean = true;
        localMessageForPtt.isread = paramBoolean;
        localMessageForPtt.urlAtServer = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i;
        if (SttManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localMessageForPtt.sttAbility = 1;
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (localMessageForPtt.isSend())
          {
            Object localObject = this.j;
            localMessageForPtt.longPttVipFlag = MessageUtils.a(localQQAppInterface, (String)localObject);
            localMessageForPtt.serial();
            if (QLog.isColorLevel()) {
              QLog.e("streamptt.send", 2, "Stream ptt:updataMessageDataBaseContent:time" + localMessageForPtt.time + " urlAtServer:" + localMessageForPtt.urlAtServer);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.l, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, localMessageForPtt.msgData);
            localMessageForPtt.time = this.jdField_a_of_type_Long;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.l, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long, this.jdField_a_of_type_Long);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.l, 0);
            if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i == null) || (!this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
              break label335;
            }
            ((QQMessageFacade.Message)localObject).pttUrl = localMessageForPtt.url;
          }
        }
        else
        {
          localMessageForPtt.sttAbility = this.aK;
          continue;
        }
        String str = this.l;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      continue;
      label335:
      return;
      label336:
      paramBoolean = false;
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l1 = (System.nanoTime() - this.jdField_d_of_type_Long) / 1000000L;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onSuccess elapsed:" + l1 + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int == 0) {
        b(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int != 0) {
        break;
      }
      d(1003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.r, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
      return;
    }
    d(2003);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.l, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long);
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\BuddyTransfileProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */