package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.Manager;

public class TroopBindPublicAccountMgr
  implements Manager
{
  public static final String a = "TroopBindPublicAccountMgr";
  private static final ArrayList a;
  public static final String b = "TroopBindPublicAccountMgr.bottom";
  public static final String c = "TroopBindPublicAccountMgr.redDot";
  public static final String d = "TroopBindPublicAccountMgr.tempFollow";
  protected static final String f = "_troop_bind_pb";
  protected static final String g = "_btm_pbmsg_seq";
  protected static final String h = "_unread_pbmsg_cnt";
  protected static final String i = "_pbmsg_redDot";
  protected static final String j = "_temp_follow_state";
  protected SharedPreferences a;
  protected LruCache a;
  protected QQAppInterface a;
  protected TroopManager a;
  protected HashMap a;
  protected String e = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public TroopBindPublicAccountMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_troop_bind_pb", 0);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == 62530)) {
      return true;
    }
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if ((localMessageForStructing.istroop == 1) && (localMessageForStructing.structingMsg != null) && (localMessageForStructing.structingMsg.mMsgServiceID == 43)) {
        return true;
      }
      if ((localMessageForStructing.istroop == 1) && (localMessageForStructing.msgData != null) && (localMessageForStructing.structingMsg == null) && (StructMsgFactory.a(paramMessageRecord.msgData).mMsgServiceID == 43)) {
        return true;
      }
    }
    return false;
  }
  
  public int a(String paramString)
  {
    paramString = paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_temp_follow_state";
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, -1);
  }
  
  public Bundle a(String paramString)
  {
    return (Bundle)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
  }
  
  public String a()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(long paramLong)
  {
    if (!jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) {
      jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_temp_follow_state";
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.remove(paramString);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.tempFollow", 2, "deletePubAccTempFollowState:" + paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.tempFollow", 2, "deletePubAccTempFollowState:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_temp_follow_state";
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        paramInt1 = paramInt1 << 4 | paramInt2;
        localEditor.putInt(paramString, paramInt1);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.tempFollow", 2, "saveTroopTempFollowState:" + paramString + ", " + paramInt1);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.tempFollow", 2, "saveTroopTempFollowState:" + paramString.toString());
          }
        }
      }
      return;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_btm_pbmsg_seq";
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putLong(paramString, paramLong);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, "setTroopLastPubAccountMsgUniseq:" + paramString + ", " + paramLong);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.bottom", 2, "setTroopLastPubAccountMsgUniseq:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, paramBundle);
  }
  
  public void a(String paramString, List arg2)
  {
    Object localObject2;
    boolean bool;
    try
    {
      localObject2 = paramString + "_btm_pbmsg_seq";
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong((String)localObject2, -1L);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("checkMovePubMsg2Bottom:").append(paramString).append(", hasPubMsg=");
          if (l <= 0L) {
            break label224;
          }
          bool = true;
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, bool);
        }
        if ((l >= 0L) && (??? != null))
        {
          k = ???.size();
          if (k != 0) {
            break label230;
          }
        }
        return;
      }
      ??? = paramString + "_unread_pbmsg_cnt";
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopBindPublicAccountMgr.bottom", 2, "checkMoveLastPubMsgToBottom:" + ???.toString());
      }
      b(paramString);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt((String)???, 0) == 1) {
          d(paramString);
        }
        return;
      }
      label224:
      bool = false;
      break;
      label230:
      m = ???.size();
      k = 0;
      label241:
      if (k >= m) {
        break label755;
      }
      if (((ChatMessage)???.get(k)).uniseq != l) {
        break label764;
      }
      label268:
      bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBindPublicAccountMgr.bottom", 2, "lastPubMsgIdxInList: lastPubMsgIdx=" + k + ", listSize=" + m + ", inBottomBefore=" + bool);
      }
      ??? = null;
      if (k < 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, 1, l);
        if ((localObject2 instanceof ChatMessage)) {
          ??? = (ChatMessage)localObject2;
        }
        if (!QLog.isColorLevel()) {
          break label761;
        }
        QLog.d("TroopBindPublicAccountMgr.bottom", 2, "queryMsgItemByseq:" + (localObject2 instanceof ChatMessage));
        break label761;
      }
      label409:
      while (??? == null)
      {
        b(paramString);
        return;
        ??? = (ChatMessage)???.remove(k);
      }
      if (bool) {
        break label539;
      }
      ???.add(???);
      k = ???.size();
      if (k > 1)
      {
        l = ((ChatMessage)???.get(k - 2)).shmsgseq;
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, "put2InsertSeqMap:" + paramString + "," + l);
        }
      }
    }
    label539:
    long l = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
    int m = ???.size();
    int k = 0;
    for (;;)
    {
      if (k < m)
      {
        if (((ChatMessage)???.get(k)).shmsgseq < l) {}
      }
      else
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopBindPublicAccountMgr.bottom", 2, "inBottomBefore, lastSeq=" + l + ", insertIdx=" + k);
          }
          if (k < 0) {
            ???.add(???);
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "bottom_one", 0, 0, paramString, "", "", "");
            break;
            if (((ChatMessage)???.get(k)).shmsgseq > l) {
              ???.add(k, ???);
            } else if (((ChatMessage)???.get(k)).shmsgseq == l) {
              ???.add(k + 1, ???);
            }
          }
          k = -1;
        }
        label755:
        k = -1;
        break label268;
        label761:
        break label409;
        label764:
        k += 1;
        break label241;
      }
      k += 1;
    }
  }
  
  public boolean a(long paramLong)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      boolean bool2;
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        String str = paramString + "_unread_pbmsg_cnt";
        int k = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(str, 0);
        str = paramString + "_pbmsg_redDot";
        bool2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(str, false);
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, "needShowPbMsgRedDot:" + paramString + "," + k + "," + bool2);
        }
        if (k >= 2)
        {
          if (!bool2) {}
          try
          {
            paramString = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
            paramString.putBoolean(str, true);
            paramString.commit();
            bool1 = true;
            return bool1;
          }
          catch (Exception paramString)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("TroopBindPublicAccountMgr.redDot", 2, "needShowPbMsgRedDot:" + paramString.toString());
            continue;
          }
        }
      }
      if (bool2) {
        bool1 = true;
      }
    }
  }
  
  public boolean a(String arg1, long paramLong)
  {
    String str = ??? + "_btm_pbmsg_seq";
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, -1L);
        if ((l > 0L) && (l == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void b(String paramString)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        String str = paramString + "_btm_pbmsg_seq";
        localEditor.remove(str);
        localEditor.commit();
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, "removeTroopLastPubAccountMsgUniseq:" + str);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.bottom", 2, "removeTroopLastPubAccountMsgUniseq:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if (a(paramMessageRecord)) {
        return (a(paramMessageRecord.frienduin, paramMessageRecord.uniseq)) && (!a(paramMessageRecord.uniseq));
      }
    }
    return false;
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 352	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +62 -> 68
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 63	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:e	Ljava/lang/String;
    //   14: invokevirtual 357	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +51 -> 68
    //   20: iconst_1
    //   21: istore_2
    //   22: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +39 -> 64
    //   28: ldc 10
    //   30: iconst_2
    //   31: new 92	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 359
    //   41: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 294
    //   51: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_2
    //   55: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: iload_2
    //   67: ireturn
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -48 -> 22
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	TroopBindPublicAccountMgr
    //   0	78	1	paramString	String
    //   21	49	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	73	finally
    //   22	64	73	finally
  }
  
  public void c(String paramString)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_unread_pbmsg_cnt";
        int k = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0) + 1;
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putInt(paramString, k);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, "increaseTroopPubMsgUnreadCount:" + paramString + ", " + k);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.redDot", 2, "increaseTroopPubMsgUnreadCount:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
        bool1 = bool2;
      } while (paramString == null);
      bool1 = bool2;
    } while (paramString.associatePubAccount > 0L);
    return false;
  }
  
  public void d(String paramString)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_unread_pbmsg_cnt";
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.remove(paramString);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, "clearTroopPubMsgUnreadCount:" + paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.redDot", 2, "clearTroopPubMsgUnreadCount:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void e(String paramString)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.remove(paramString + "_pbmsg_redDot");
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, "clearPbMsgRedDotFlag:" + paramString);
        }
        d(paramString);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.redDot", 2, "clearPbMsgRedDotFlag:" + paramString.toString());
          }
        }
      }
      return;
    }
  }
  
  public void f(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBindPublicAccountMgr", 2, "setCurentAIOUin:" + paramString);
      }
      this.e = paramString;
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopBindPublicAccountMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */