package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import vqn;
import vqo;

public class TroopFileUtils
{
  public static final int a = 102;
  public static final long a = 8888L;
  public static final String a = "BizTechReport";
  private static String[] a = { "\\", "/", ":", "*", "?", "\"", "<", ">", "|" };
  public static final int b = 104;
  public static final String b = "troop_troopfile";
  public static final int c = 105;
  public static final String c = "upload";
  public static final int d = 106;
  public static final String d = "download";
  public static final int e = 3;
  public static final String e = "0";
  public static final int f = 38;
  public static final String f = "1";
  public static final int g = 25;
  public static int h = 0;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    h = 48;
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong2 == 0L) {
      return 0;
    }
    long l1 = paramLong1;
    long l2 = paramLong2;
    if (paramLong1 > paramLong2)
    {
      l1 = paramLong2;
      l2 = paramLong2;
    }
    while (l2 > 2147483647L)
    {
      l2 >>= 1;
      l1 >>= 1;
    }
    return (int)(l1 / l2 * 100.0D);
  }
  
  public static int a(Context paramContext)
  {
    int m = 2;
    int n = NetworkUtil.a(paramContext);
    if (n == 0) {
      m = 0;
    }
    while ((2 != n) && (3 != n) && (4 != n)) {
      return m;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong)
  {
    int m = a(paramContext);
    if (m == 0) {
      TroopFileError.a(paramQQAppInterface, paramLong, 106);
    }
    return m;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt, String paramString4, long paramLong2)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt, paramString4, paramLong2, 0, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, int paramInt2, int paramInt3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(63519);
    localMessageRecord.selfuin = paramQQAppInterface.a();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramQQAppInterface.a();
    localMessageRecord.msgUid = MessageUtils.a(paramInt1);
    localMessageRecord.msg = MsgUtils.a(null);
    localMessageRecord.msgtype = 63519;
    localMessageRecord.isread = true;
    localMessageRecord.issend = 1;
    localMessageRecord.istroop = 1;
    paramString1 = paramQQAppInterface.a().a(localMessageRecord.senderuin, 1);
    if ((paramString1 != null) && (!paramString1.isEmpty())) {}
    for (localMessageRecord.shmsgseq = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;; localMessageRecord.shmsgseq = Math.abs(new Random().nextInt()))
    {
      localMessageRecord.time = MessageCache.a();
      paramString1 = (MessageForTroopFile)localMessageRecord;
      paramString1.fileName = paramString2;
      paramString1.uuid = paramString3;
      paramString1.fileSize = paramLong1;
      paramString1.FromUin = paramString4;
      paramString1.entitySessionId = paramLong2;
      paramString1.width = paramInt2;
      paramString1.height = paramInt3;
      if (localMessageRecord.isSend()) {
        ((SVIPHandler)paramQQAppInterface.a(13)).a(localMessageRecord);
      }
      paramString1.serial();
      ThreadManager.a(new vqn(paramQQAppInterface, localMessageRecord), 8, null, false);
      QLog.i("TroopFile", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + FileManagerUtil.e(localMessageRecord.selfuin) + "], frienduin[" + FileManagerUtil.e(localMessageRecord.frienduin) + "], senderuin[" + FileManagerUtil.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "], vipBubbleID[" + String.valueOf(-1) + "]");
      return localMessageRecord.uniseq;
    }
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    int m;
    if (paramInt2 < paramInt1) {
      m = paramInt2;
    }
    for (;;)
    {
      Object localObject = ImageUtil.a(paramString, m);
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if (paramString == null)
        {
          return null;
          m = paramInt1;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        int i1 = paramString.getWidth();
        int i2 = paramString.getHeight();
        if ((i1 <= 0) || (i2 <= 0)) {
          return null;
        }
        int n;
        if (i1 <= paramInt1)
        {
          localObject = paramString;
          n = i1;
          m = i2;
          if (i2 <= paramInt2) {}
        }
        else
        {
          float f1 = Math.min(paramInt1 / i1, paramInt2 / i2);
          localObject = new Matrix();
          ((Matrix)localObject).setScale(f1, f1);
        }
        try
        {
          localObject = Bitmap.createBitmap(paramString, 0, 0, i1, i2, (Matrix)localObject, true);
          ((Bitmap)localObject).setDensity(BaseApplicationImpl.a().getResources().getDisplayMetrics().densityDpi);
          if (paramString != localObject) {
            paramString.recycle();
          }
          n = ((Bitmap)localObject).getWidth();
          m = ((Bitmap)localObject).getHeight();
          paramString = new Rect();
          i1 = n;
          if (n >= paramInt1)
          {
            paramString.left = ((n - paramInt1) / 2);
            i1 = paramInt1;
          }
          n = m;
          if (m >= paramInt2)
          {
            paramString.top = 0;
            n = paramInt2;
          }
          paramString.bottom = (paramString.top + n);
          paramString.right = (paramString.left + i1);
          Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          localBitmap.setDensity(BaseApplicationImpl.a().getResources().getDisplayMetrics().densityDpi);
          if (localBitmap != null) {
            new Canvas(localBitmap).drawBitmap((Bitmap)localObject, paramString, new Rect(0, 0, paramInt1, paramInt2), null);
          }
          ((Bitmap)localObject).recycle();
          return localBitmap;
        }
        catch (Throwable paramString) {}
      }
    }
    return null;
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt)
  {
    Object localObject = null;
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong1);
    paramQQAppInterface = (QQAppInterface)localObject;
    if (localTroopFileTransferManager != null)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!TextUtils.isEmpty(paramString1)) {
        paramQQAppInterface = localTroopFileTransferManager.a(UUID.fromString(paramString1));
      }
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      paramString1 = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = localTroopFileTransferManager.a(paramString2);
      }
    }
    paramQQAppInterface = new TroopFileStatusInfo(paramString1);
    if (TextUtils.isEmpty(paramQQAppInterface.g)) {
      paramQQAppInterface.g = paramString3;
    }
    if (paramQQAppInterface.b == 0L) {
      paramQQAppInterface.b = paramLong2;
    }
    if (paramInt != 0) {
      paramQQAppInterface.jdField_e_of_type_Int = paramInt;
    }
    if (TextUtils.isEmpty(paramQQAppInterface.jdField_e_of_type_JavaLangString)) {
      paramQQAppInterface.jdField_e_of_type_JavaLangString = paramString2;
    }
    return paramQQAppInterface;
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    Object localObject = null;
    if (paramMessageForTroopFile == null) {
      return null;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramMessageForTroopFile.frienduin));
    paramQQAppInterface = (QQAppInterface)localObject;
    if (localTroopFileTransferManager != null)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!TextUtils.isEmpty(paramMessageForTroopFile.uuid)) {
        paramQQAppInterface = localTroopFileTransferManager.a(UUID.fromString(paramMessageForTroopFile.uuid));
      }
    }
    localObject = paramQQAppInterface;
    if (localTroopFileTransferManager != null)
    {
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null)
      {
        localObject = paramQQAppInterface;
        if (!TextUtils.isEmpty(paramMessageForTroopFile.url)) {
          localObject = localTroopFileTransferManager.a(paramMessageForTroopFile.url);
        }
      }
    }
    paramQQAppInterface = new TroopFileStatusInfo((TroopFileStatusInfo)localObject);
    if (TextUtils.isEmpty(paramQQAppInterface.g)) {
      paramQQAppInterface.g = paramMessageForTroopFile.fileName;
    }
    if (paramQQAppInterface.b == 0L) {
      paramQQAppInterface.b = paramMessageForTroopFile.fileSize;
    }
    if (paramMessageForTroopFile.bisID != 0) {
      paramQQAppInterface.jdField_e_of_type_Int = paramMessageForTroopFile.bisID;
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.url)) {
      paramQQAppInterface.jdField_e_of_type_JavaLangString = paramMessageForTroopFile.url;
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.frienduin)) {
      paramQQAppInterface.jdField_a_of_type_Long = Long.valueOf(paramMessageForTroopFile.frienduin).longValue();
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.sha1)) {
      paramQQAppInterface.f = paramMessageForTroopFile.sha1;
    }
    return paramQQAppInterface;
  }
  
  public static TroopFileStatusInfo a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return a(paramQQAppInterface, paramFileManagerEntity.TroopUin, paramFileManagerEntity.strTroopFileID, paramFileManagerEntity.strTroopFilePath, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.busId);
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("##0.0");
    double d1 = 1024.0D * 1024.0D;
    double d2 = 1024.0D * d1;
    if (paramLong < d1) {
      return localDecimalFormat.format(paramLong / 1024.0D) + "K";
    }
    if (paramLong < d2) {
      return localDecimalFormat.format(paramLong / d1) + "M";
    }
    return localDecimalFormat.format(paramLong / d2) + "G";
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramLong = 1000L * paramLong;
    long l = System.currentTimeMillis();
    if (paramLong <= l) {
      return paramContext.getString(2131364086);
    }
    paramLong = (paramLong - l) / 86400000L;
    return paramLong + 1L + paramContext.getString(2131364085);
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = "";
    }
    int m;
    do
    {
      do
      {
        return (String)localObject;
        m = paramString.lastIndexOf(".");
        if (m == -1) {
          break;
        }
        localObject = paramString;
      } while (m <= 9);
      if (m != -1) {
        break;
      }
      localObject = paramString;
    } while (paramString.length() <= 13);
    String str;
    if (m == -1)
    {
      str = "";
      localObject = paramString;
      paramString = str;
    }
    for (;;)
    {
      localObject = ((String)localObject).substring(0, 3) + "..." + ((String)localObject).substring(((String)localObject).length() - 3);
      return (String)localObject + paramString;
      localObject = paramString.substring(m);
      str = paramString.substring(0, m);
      paramString = (String)localObject;
      localObject = str;
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopFile))) {}
    TroopFileTransferManager localTroopFileTransferManager;
    do
    {
      do
      {
        return;
        localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
      } while (localTroopFileTransferManager == null);
      paramQQAppInterface = a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.jdField_e_of_type_JavaLangString == null));
    FMToastUtil.b(FileManagerUtil.d(paramQQAppInterface.g) + paramActivity.getString(2131362814));
    localTroopFileTransferManager.a(paramQQAppInterface.jdField_e_of_type_JavaLangString, paramQQAppInterface.g, paramQQAppInterface.b, paramQQAppInterface.jdField_e_of_type_Int);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    label98:
    for (;;)
    {
      return;
      paramActivity = paramList.iterator();
      for (;;)
      {
        if (!paramActivity.hasNext()) {
          break label98;
        }
        Object localObject = (ChatMessage)paramActivity.next();
        paramList = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(((ChatMessage)localObject).frienduin));
        if (paramList == null) {
          break;
        }
        localObject = a(paramQQAppInterface, (MessageForTroopFile)localObject);
        if ((localObject == null) || (((TroopFileStatusInfo)localObject).jdField_e_of_type_JavaLangString == null)) {
          break;
        }
        paramList.b(((TroopFileStatusInfo)localObject).jdField_e_of_type_JavaLangString, ((TroopFileStatusInfo)localObject).g, ((TroopFileStatusInfo)localObject).b, ((TroopFileStatusInfo)localObject).jdField_e_of_type_Int);
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopFile))) {}
    Object localObject;
    int m;
    do
    {
      do
      {
        do
        {
          return;
        } while (TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramChatMessage.frienduin)) == null);
        localObject = a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
      } while (localObject == null);
      paramChatMessage = new Bundle();
      paramChatMessage.putInt("dataline_forward_type", 100);
      paramChatMessage.putString("dataline_forward_path", ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString);
      paramQQAppInterface = (DataLineHandler)paramQQAppInterface.a(8);
      localObject = new vqo(paramContext);
      m = paramQQAppInterface.a().b(AppConstants.aj, paramChatMessage, (DirectForwarder.CallBack)localObject);
    } while ((((DirectForwarder.CallBack)localObject).a) && (m != 0));
    DirectForwarder.b(paramContext, m);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    TroopFileError.a(paramQQAppInterface, paramLong, 106);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean, long paramLong1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong2, long paramLong3, String paramString6, String paramString7, int paramInt2)
  {
    long l1 = paramLong1;
    if (paramLong1 == 0L) {
      l1 = System.currentTimeMillis();
    }
    long l2;
    label34:
    int m;
    if (l1 < 1L)
    {
      paramLong1 = 0L;
      if (paramLong1 > 0L) {
        break label479;
      }
      paramLong1 = 0L;
      l2 = 0L;
      m = HttpUtil.a();
      if ((m >= AppConstants.b.length) || (m < 0)) {
        break label500;
      }
    }
    label479:
    label500:
    for (String str = AppConstants.b[m];; str = "NONE")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("netType", str);
      localHashMap.put("serverip", String.valueOf(paramString2));
      localHashMap.put("troopUin", String.valueOf(paramString3));
      localHashMap.put("filePath", paramString5);
      localHashMap.put("errorCode", String.valueOf(paramInt1));
      localHashMap.put("transferedSize", String.valueOf(paramLong2));
      localHashMap.put("fileSize", String.valueOf(paramLong3));
      localHashMap.put("url", String.valueOf(paramString6));
      localHashMap.put("rspHeader", String.valueOf(paramString7));
      localHashMap.put("retry", String.valueOf(paramInt2));
      if (paramBoolean == true) {}
      for (m = 0;; m = 1)
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "troop_troopfile", paramString1, 0, m, paramString3, paramString4, paramLong1 + "KB/s", localHashMap.toString());
        if (QLog.isColorLevel()) {
          QLog.d("BizTechReport", 2, "ReportTransferFailedInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(paramBoolean) + "], errorCode[" + String.valueOf(paramInt1) + "], startTime[" + String.valueOf(l1) + "], duration[" + String.valueOf(l2) + "],  transferSize[" + String.valueOf(paramLong2) + "], fileSize[" + String.valueOf(paramLong3) + "], fileType[" + paramString4 + "], netType[" + str + "], fileTransferSpeed[" + String.valueOf(paramLong1) + " KB/s], serverip[" + paramString2 + "], url[" + String.valueOf(paramString6) + "], rspHeader[" + String.valueOf(paramString7) + "], retryTimes[" + String.valueOf(paramInt2) + "]");
        }
        return;
        paramLong1 = System.currentTimeMillis() - l1;
        break;
        long l3 = paramLong2 / paramLong1;
        l2 = paramLong1;
        paramLong1 = l3;
        break label34;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramLong + "");
    return (localTroopInfo != null) && (((localTroopInfo.troopowneruin != null) && (paramQQAppInterface.a().equals(localTroopInfo.troopowneruin))) || ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(paramQQAppInterface.a()))));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = a;
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        if (paramString.contains(arrayOfString[m])) {
          return true;
        }
        m += 1;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = a(paramString1, paramInt1, paramInt2);
    if (localBitmap == null) {}
    for (;;)
    {
      return false;
      paramString1 = new File(paramString2);
      if (paramString1.exists()) {
        paramString1.delete();
      }
      try
      {
        paramString1.createNewFile();
      }
      catch (IOException paramString2)
      {
        try
        {
          for (;;)
          {
            paramString1 = new BufferedOutputStream(new FileOutputStream(paramString1));
            if (paramString1 == null) {
              break;
            }
            localBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString1);
            localBitmap.recycle();
            try
            {
              paramString1.flush();
              paramString1.close();
              return true;
            }
            catch (IOException paramString1)
            {
              paramString1.printStackTrace();
            }
            paramString2 = paramString2;
            paramString2.printStackTrace();
          }
        }
        catch (FileNotFoundException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            paramString1 = null;
          }
        }
      }
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    int i1 = paramString.length();
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    if (m < i1)
    {
      int i2 = paramString.codePointAt(m);
      int n;
      if (EmotcationConstants.a.get(i2, -1) < 0)
      {
        localStringBuilder.append(arrayOfChar[m]);
        n = m;
      }
      for (;;)
      {
        m = n + 1;
        break;
        n = m;
        if (i2 > 65535)
        {
          n = m;
          if (i1 >= m + 2) {
            n = m + 1;
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean b(String paramString)
  {
    return paramString.trim().length() == 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */