package com.tencent.mobileqq.hotchat;

import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import sux;

public class PttShowRoomMng
{
  public static final int a = 8;
  public static final long a = 5000L;
  final LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final List jdField_a_of_type_JavaUtilList;
  final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public PttShowRoomMng(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(3);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new sux(this, 20);
  }
  
  public static final int a(QQAppInterface paramQQAppInterface)
  {
    int i = ((Integer)NearbySPUtil.a(paramQQAppInterface.getAccount(), "self_gender", Integer.valueOf(0))).intValue();
    if (i == 2) {
      return 1;
    }
    if (i == 1) {
      return 0;
    }
    return 2;
  }
  
  private PttShowRoomMng.Guest a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null)
      {
        paramString = (PttShowRoomMng.Guest)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(String paramString, PttShowRoomMng.Guest paramGuest)
  {
    try
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, paramGuest);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private PttShowRoomMng.CancelSeat[] a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = null;
    }
    for (;;)
    {
      return (PttShowRoomMng.CancelSeat[])localObject;
      try
      {
        PttShowRoomMng.CancelSeat[] arrayOfCancelSeat = (PttShowRoomMng.CancelSeat[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = arrayOfCancelSeat;
        if (arrayOfCancelSeat == null) {
          localThrowable1.printStackTrace();
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject = new PttShowRoomMng.CancelSeat[8];
        }
        catch (Throwable localThrowable4)
        {
          for (;;)
          {
            paramString = localThrowable1;
            Throwable localThrowable2 = localThrowable4;
          }
        }
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
          paramString = (PttShowRoomMng.CancelSeat[])this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          return paramString;
        }
        catch (Throwable localThrowable3)
        {
          paramString = localThrowable4;
          break;
        }
        localThrowable1 = localThrowable1;
        paramString = null;
      }
    }
    return paramString;
  }
  
  public int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null)) {
      return -1;
    }
    paramString = a(paramString, 1);
    if ((paramString instanceof Integer)) {
      return ((Integer)paramString).intValue();
    }
    return 2;
  }
  
  public long a(String paramString, int paramInt)
  {
    Object localObject = a(paramString);
    long l2;
    if ((localObject == null) || (paramInt < 0) || (paramInt >= localObject.length))
    {
      l2 = 0L;
      return l2;
    }
    localObject = localObject[paramInt];
    if (localObject != null)
    {
      l1 = ((PttShowRoomMng.CancelSeat)localObject).jdField_a_of_type_Long;
      if (l1 == 0L) {
        break label128;
      }
    }
    label128:
    for (long l1 = 5000L - Math.abs(System.nanoTime() - l1) / 1000000L;; l1 = 0L)
    {
      if (l1 >= 0L)
      {
        l2 = l1;
        if (l1 <= 5000L) {
          break;
        }
      }
      ((PttShowRoomMng.CancelSeat)localObject).jdField_a_of_type_Long = 0L;
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "getSeatCancelDelayTime", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(0L) });
      }
      return 0L;
    }
  }
  
  public PttShowRoomMng.PendingCmd a(String paramString, int paramInt)
  {
    PttShowRoomMng.PendingCmd localPendingCmd = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (paramString == null) {
        localObject1 = localObject2;
      }
    }
    else {
      return (PttShowRoomMng.PendingCmd)localObject1;
    }
    localObject2 = localObject3;
    for (;;)
    {
      int i;
      try
      {
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        localObject1 = localPendingCmd;
        localObject2 = localObject1;
        if (i >= 0)
        {
          localObject2 = localObject1;
          localPendingCmd = (PttShowRoomMng.PendingCmd)this.jdField_a_of_type_JavaUtilList.get(i);
          if (localPendingCmd == null)
          {
            localObject2 = localObject1;
            this.jdField_a_of_type_JavaUtilList.remove(i);
          }
          else
          {
            localObject2 = localObject1;
            if (localPendingCmd.jdField_a_of_type_Int == paramInt)
            {
              localObject2 = localObject1;
              if (paramString.equals(localPendingCmd.jdField_a_of_type_JavaLangString))
              {
                localObject2 = localObject1;
                localObject1 = (PttShowRoomMng.PendingCmd)this.jdField_a_of_type_JavaUtilList.remove(i);
              }
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        localObject1 = localObject2;
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      NearbyUtils.a("PttShow", "removePendingAction", new Object[] { Integer.valueOf(paramInt), localObject2 });
      return (PttShowRoomMng.PendingCmd)localObject2;
      i -= 1;
    }
  }
  
  public Object a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null))
    {
      paramString = null;
      return paramString;
    }
    int i = 2;
    PttShowRoomMng.Guest localGuest = a(paramString);
    if (localGuest == null) {
      if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        paramString = (String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_nick", String.valueOf(""));
        i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString, i, NetConnInfoCenter.getServerTime());
      }
    }
    for (;;)
    {
      switch (paramInt)
      {
      case 2: 
      default: 
        return null;
        if (QLog.isDevelopLevel())
        {
          NearbyUtils.a("PttShow", "getGender no cache", new Object[] { paramString });
          paramString = null;
          continue;
          i = localGuest.jdField_a_of_type_Int;
          paramString = localGuest.b;
        }
        break;
      case 1: 
        return Integer.valueOf(i);
        paramString = null;
      }
    }
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null)) {
      return null;
    }
    paramString = a(paramString, 2);
    if ((paramString instanceof String)) {
      return (String)paramString;
    }
    return null;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.extLong & 0x1) == 0) || (paramMessageRecord.senderuin == null)) {}
    label213:
    do
    {
      Object localObject1;
      do
      {
        return;
        localObject1 = a(paramMessageRecord.senderuin);
      } while ((localObject1 != null) && (((PttShowRoomMng.Guest)localObject1).jdField_a_of_type_Long >= paramMessageRecord.time));
      try
      {
        String str1 = paramMessageRecord.getExtInfoFromExtStr("hotchat_nick");
        i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("hotchat_gender"));
        l1 = paramMessageRecord.time;
        localObject2 = str1;
        j = i;
        if (!paramMessageRecord.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
          break label213;
        }
        str2 = (String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_nick", String.valueOf(""));
        k = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = str1;
        if (str2 == null) {
          break;
        }
        localObject1 = str1;
        if (str2.length() <= 0) {
          break;
        }
        localObject1 = str2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          long l1;
          Object localObject2;
          int j;
          String str2;
          int k;
          long l2;
          localException.printStackTrace();
          continue;
          if (k != 2) {
            i = k;
          }
        }
      }
      l2 = NetConnInfoCenter.getServerTime();
      localObject2 = localObject1;
      j = i;
      l1 = l2;
      if (QLog.isDevelopLevel())
      {
        NearbyUtils.a("PttShow", "cacheSelfGender", new Object[] { str2, Integer.valueOf(k), Long.valueOf(l2) });
        l1 = l2;
        j = i;
        localObject2 = localObject1;
      }
      a(paramMessageRecord.senderuin, (String)localObject2, j, l1);
    } while (!QLog.isDevelopLevel());
    NearbyUtils.a("PttShow", "cacheGender", new Object[] { paramMessageRecord.extStr });
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      PttShowRoomMng.PendingCmd localPendingCmd = new PttShowRoomMng.PendingCmd();
      localPendingCmd.jdField_a_of_type_JavaLangString = paramString;
      localPendingCmd.jdField_a_of_type_Int = paramInt;
      localPendingCmd.jdField_a_of_type_Long = System.currentTimeMillis();
      try
      {
        this.jdField_a_of_type_JavaUtilList.add(localPendingCmd);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        NearbyUtils.a("PttShow", "addPendingAction", new Object[] { localPendingCmd });
        return;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    do
    {
      do
      {
        do
        {
          return;
          localGuest = a(paramString1);
          if ((localGuest == null) || (localGuest.jdField_a_of_type_Long > paramLong)) {
            break;
          }
          localGuest.jdField_a_of_type_Int = paramInt;
          if ((paramString2 != null) && (paramString2.length() > 0)) {
            localGuest.b = paramString2;
          }
          localGuest.jdField_a_of_type_Long = paramLong;
        } while (!QLog.isDevelopLevel());
        NearbyUtils.a("PttShow", "cacheGender_update", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      } while (localGuest != null);
      PttShowRoomMng.Guest localGuest = new PttShowRoomMng.Guest();
      localGuest.jdField_a_of_type_JavaLangString = paramString1;
      localGuest.jdField_a_of_type_Int = paramInt;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        localGuest.b = paramString2;
      }
      localGuest.jdField_a_of_type_Long = paramLong;
      a(paramString1, localGuest);
    } while (!QLog.isDevelopLevel());
    NearbyUtils.a("PttShow", "cacheGender_add", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public void b(String paramString, int paramInt)
  {
    PttShowRoomMng.CancelSeat[] arrayOfCancelSeat = a(paramString);
    if ((arrayOfCancelSeat == null) || (paramInt < 0) || (paramInt >= arrayOfCancelSeat.length)) {}
    PttShowRoomMng.CancelSeat localCancelSeat1;
    do
    {
      return;
      PttShowRoomMng.CancelSeat localCancelSeat2 = arrayOfCancelSeat[paramInt];
      localCancelSeat1 = localCancelSeat2;
      if (localCancelSeat2 == null)
      {
        localCancelSeat1 = new PttShowRoomMng.CancelSeat();
        localCancelSeat1.jdField_a_of_type_Int = paramInt;
        arrayOfCancelSeat[paramInt] = localCancelSeat1;
        localCancelSeat1 = arrayOfCancelSeat[paramInt];
      }
      if (localCancelSeat1 != null) {
        localCancelSeat1.jdField_a_of_type_Long = System.nanoTime();
      }
    } while (!QLog.isDevelopLevel());
    NearbyUtils.a("PttShow", "addCancelSeat", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(localCancelSeat1.jdField_a_of_type_Long) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\PttShowRoomMng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */