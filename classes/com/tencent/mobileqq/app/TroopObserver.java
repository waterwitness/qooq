package com.tencent.mobileqq.app;

import KQQ.RespBatchProcess;
import android.os.Bundle;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopreward.TroopRewardInfo;
import com.tencent.mobileqq.troopshare.TroopShareResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qhq;
import qhr;
import tencent.im.hw.group_mgr.CardInfo;

public class TroopObserver
  implements BusinessObserver, mqq.observer.BusinessObserver
{
  public TroopObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt, byte paramByte) {}
  
  protected void a(int paramInt, byte paramByte, String paramString) {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, String paramString, group_mgr.CardInfo paramCardInfo) {}
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2, long paramLong, List paramList) {}
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2, List paramList) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    Object localObject2;
    int i;
    label1746:
    String str;
    int j;
    switch (paramInt)
    {
    case 12: 
    case 14: 
    case 17: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 27: 
    case 31: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 42: 
    case 43: 
    case 49: 
    case 61: 
    case 78: 
    default: 
    case 1: 
    case 80: 
    case 2: 
    case 3: 
    case 4: 
    case 76: 
    case 41: 
    case 6: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    case 50: 
    case 79: 
    case 9: 
    case 16: 
    case 11: 
    case 13: 
    case 28: 
    case 29: 
    case 15: 
    case 18: 
    case 25: 
    case 19: 
    case 20: 
    case 51: 
    case 26: 
    case 30: 
    case 62: 
    case 67: 
    case 33: 
    case 44: 
    case 45: 
    case 32: 
    case 34: 
    case 46: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return;
                                a(paramBoolean);
                                a();
                                return;
                                a();
                                return;
                                b(paramBoolean);
                              } while (paramObject == null);
                              a(paramBoolean, (ArrayList)paramObject);
                              return;
                              c(paramBoolean);
                              return;
                              paramObject = (Object[])paramObject;
                              if (paramObject.length == 1)
                              {
                                a((String)paramObject[0], paramBoolean, null);
                                return;
                              }
                              if (paramObject.length == 2)
                              {
                                a((String)paramObject[0], paramBoolean, (List)paramObject[1]);
                                return;
                              }
                            } while (!QLog.isColorLevel());
                            QLog.e("TroopObserver", 2, "onUpdate,TYPR_GET_TROOP_GETMEMBERLIST datas.length error");
                            return;
                            a(paramBoolean, (List)paramObject);
                            return;
                            a(paramBoolean, ((Integer)paramObject).intValue());
                            return;
                            if (paramBoolean)
                            {
                              paramObject = (Object[])paramObject;
                              a(true, ((Byte)paramObject[0]).byteValue(), (TroopInfo)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
                              return;
                            }
                            a(false, (byte)0, null, false);
                            return;
                            if (paramBoolean)
                            {
                              paramObject = (Object[])paramObject;
                              a(((Integer)paramObject[0]).intValue(), ((Byte)paramObject[1]).byteValue(), (String)paramObject[2]);
                              return;
                            }
                            paramObject = (Object[])paramObject;
                            a(((Integer)paramObject[0]).intValue(), ((Byte)paramObject[1]).byteValue());
                            return;
                            paramObject = (Object[])paramObject;
                            if (paramBoolean)
                            {
                              a(true, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], (String[])paramObject[3]);
                              return;
                            }
                            a(false, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], null);
                            return;
                            a(paramBoolean, (String)paramObject);
                            return;
                            if (paramObject != null)
                            {
                              localObject1 = (Object[])paramObject;
                              paramObject = (ArrayList)localObject1[0];
                              localObject1 = (Boolean)localObject1[1];
                              if (QLog.isColorLevel()) {
                                QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST suc");
                              }
                              if (QLog.isColorLevel()) {
                                QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST bSaved2DBSuccess = " + localObject1);
                              }
                              d(paramBoolean, (ArrayList)paramObject);
                              a(paramBoolean, (ArrayList)paramObject, ((Boolean)localObject1).booleanValue());
                              return;
                            }
                            d(paramBoolean, null);
                            a(paramBoolean, null, false);
                          } while (!QLog.isColorLevel());
                          QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST failed");
                          return;
                          b(paramBoolean, paramObject);
                          return;
                          c(paramBoolean, paramObject);
                          return;
                          b(paramBoolean, (ArrayList)paramObject);
                          return;
                          c(paramBoolean, (ArrayList)paramObject);
                          return;
                          try
                          {
                            paramObject = (Object[])paramObject;
                            a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2]);
                            return;
                          }
                          catch (Exception paramObject) {}
                        } while (!QLog.isColorLevel());
                        QLog.d("Q.troopinfo", 2, ((Exception)paramObject).toString());
                        return;
                        paramObject = (qhr)paramObject;
                        a(((qhr)paramObject).jdField_a_of_type_Int, ((qhr)paramObject).jdField_a_of_type_Boolean, ((qhr)paramObject).b, ((qhr)paramObject).jdField_a_of_type_JavaUtilList);
                        return;
                        paramObject = (qhr)paramObject;
                        a(((qhr)paramObject).jdField_a_of_type_Int, ((qhr)paramObject).jdField_a_of_type_Boolean, ((qhr)paramObject).b, ((qhr)paramObject).jdField_a_of_type_Long, ((qhr)paramObject).jdField_a_of_type_JavaUtilList);
                        return;
                        b(paramBoolean, (ArrayList)paramObject);
                        return;
                        paramObject = (qhq)paramObject;
                        a(((qhq)paramObject).jdField_a_of_type_Long, ((qhq)paramObject).jdField_a_of_type_Int, ((qhq)paramObject).jdField_a_of_type_Boolean, ((qhq)paramObject).jdField_a_of_type_JavaLangString, ((qhq)paramObject).b, ((qhq)paramObject).c);
                        return;
                        paramObject = (Object[])paramObject;
                        localObject1 = new Object[2];
                        if (paramObject.length == 7)
                        {
                          localObject1[0] = paramObject[5];
                          localObject1[1] = paramObject[6];
                        }
                        a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4], (Object[])localObject1);
                        return;
                        paramObject = (Object[])paramObject;
                        a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                        return;
                        paramObject = (Object[])paramObject;
                        a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
                        return;
                        paramObject = (Object[])paramObject;
                        a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                        return;
                        paramObject = (Object[])paramObject;
                        b(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
                        return;
                        if (paramBoolean)
                        {
                          paramObject = (Object[])paramObject;
                          a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                          return;
                        }
                        a(false, null, -1);
                        return;
                      } while (!(paramObject instanceof Object[]));
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1], ((Integer)paramObject[2]).intValue());
                      return;
                    } while (!(paramObject instanceof Object[]));
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue());
                    return;
                  } while (!(paramObject instanceof Object[]));
                  paramObject = (Object[])paramObject;
                } while (paramObject.length != 3);
                a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
                return;
                if (paramBoolean)
                {
                  a(paramBoolean, (RespBatchProcess)paramObject);
                  return;
                }
                a(paramBoolean, null);
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
              a(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1]);
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (long[])paramObject[2]);
            return;
          } while (!(paramObject instanceof Object[]));
          localObject2 = (Object[])paramObject;
          localObject1 = null;
          paramObject = localObject1;
          if (localObject2.length >= 3)
          {
            paramObject = localObject1;
            if ((localObject2[2] instanceof String)) {
              paramObject = (String)localObject2[2];
            }
          }
          b(paramBoolean, (String)paramObject);
          return;
        } while (!(paramObject instanceof Object[]));
        localObject2 = (Object[])paramObject;
        localObject1 = null;
        paramObject = localObject1;
        if (localObject2.length >= 3)
        {
          paramObject = localObject1;
          if ((localObject2[2] instanceof TroopInfo)) {
            paramObject = (TroopInfo)localObject2[2];
          }
        }
        a(paramBoolean, (TroopInfo)paramObject);
        return;
      } while (!(paramObject instanceof Object[]));
      localObject2 = (Object[])paramObject;
      paramObject = null;
      i = -1;
      paramInt = -1;
      if (localObject2.length <= 5) {
        if ((localObject2[4] instanceof List))
        {
          localObject1 = (List)localObject2[4];
          if ((localObject2[3] instanceof Integer)) {
            paramInt = ((Integer)localObject2[3]).intValue();
          }
          if ((localObject2[2] instanceof String)) {
            paramObject = (String)localObject2[2];
          }
          if ((localObject2[1] instanceof Integer)) {
            i = ((Integer)localObject2[1]).intValue();
          }
          if ((localObject2[0] instanceof String))
          {
            str = (String)localObject2[0];
            j = i;
            localObject2 = localObject1;
            i = paramInt;
            localObject1 = paramObject;
            paramInt = j;
            paramObject = str;
          }
        }
      }
      break;
    }
    for (;;)
    {
      a(paramBoolean, (String)paramObject, paramInt, (String)localObject1, i, (List)localObject2);
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      localObject2 = (Object[])paramObject;
      paramObject = null;
      i = -1;
      paramInt = -1;
      if (localObject2.length <= 5) {
        if ((localObject2[4] instanceof List))
        {
          localObject1 = (List)localObject2[4];
          label1909:
          if ((localObject2[3] instanceof Integer)) {
            paramInt = ((Integer)localObject2[3]).intValue();
          }
          if ((localObject2[2] instanceof String)) {
            paramObject = (String)localObject2[2];
          }
          if ((localObject2[1] instanceof Integer)) {
            i = ((Integer)localObject2[1]).intValue();
          }
          if ((localObject2[0] instanceof String))
          {
            str = (String)localObject2[0];
            j = i;
            localObject2 = localObject1;
            i = paramInt;
            localObject1 = paramObject;
            paramInt = j;
            paramObject = str;
          }
        }
      }
      for (;;)
      {
        b(paramBoolean, (String)paramObject, paramInt, (String)localObject1, i, (List)localObject2);
        return;
        a(paramBoolean, (TroopShareResp)paramObject);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (ArrayList)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue());
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (ProfileActivity.AllInOne)paramObject[6]);
        return;
        a(Boolean.valueOf(paramBoolean));
        return;
        b(Boolean.valueOf(paramBoolean));
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(Boolean.valueOf(paramBoolean), (ArrayList)paramObject[0], (List)paramObject[1]);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
        return;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (String)paramObject[6]);
          return;
        }
        a(paramBoolean, null, null, 0, 0, 0, 0, null);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        localObject1 = (String)paramObject[0];
        ((Integer)paramObject[1]).intValue();
        paramInt = -1;
        if (paramBoolean) {
          paramInt = ((Integer)paramObject[2]).intValue();
        }
        b(paramBoolean, (String)localObject1, paramInt);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        paramInt = ((Integer)paramObject[0]).intValue();
        localObject1 = (List)paramObject[1];
        if (paramObject.length >= 3)
        {
          a(paramBoolean, paramInt, (List)localObject1, (List)paramObject[2]);
          return;
        }
        a(paramBoolean, paramInt, (List)localObject1, null);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2], (String)paramObject[3]);
        return;
        a(paramBoolean, paramObject);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        boolean bool1 = ((Boolean)paramObject[0]).booleanValue();
        boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
        boolean bool3 = ((Boolean)paramObject[2]).booleanValue();
        a((String)paramObject[3], paramBoolean, bool1, bool2, bool3);
        return;
        if ((paramObject == null) || (!(paramObject instanceof String))) {
          break;
        }
        b((String)paramObject);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        a((String)paramObject[0], (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue());
        return;
        if ((paramObject instanceof String))
        {
          a((String)paramObject);
          return;
        }
        a(null);
        return;
        if ((paramObject instanceof Long))
        {
          a(paramBoolean, ((Long)paramObject).longValue());
          return;
        }
        a(paramBoolean, 0L);
        return;
        c((String)paramObject);
        return;
        if (paramBoolean)
        {
          a(0, "", (group_mgr.CardInfo)paramObject);
          return;
        }
        paramObject = (Object[])paramObject;
        a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], null);
        return;
        paramObject = (Object[])paramObject;
        a(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
        return;
        paramObject = (Object[])paramObject;
        localObject1 = new RecvGVideoLevelInfo[paramObject.length];
        paramInt = 0;
        while (paramInt < localObject1.length)
        {
          localObject1[paramInt] = ((RecvGVideoLevelInfo)paramObject[paramInt]);
          paramInt += 1;
        }
        a((RecvGVideoLevelInfo[])localObject1);
        return;
        paramObject = (Object[])paramObject;
        b(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
        return;
        paramObject = (Object[])paramObject;
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], (TroopRewardInfo)paramObject[4]);
        return;
        paramObject = (Object[])paramObject;
        a((String)paramObject[0], (String)paramObject[1]);
        return;
        paramObject = (Object[])paramObject;
        if (paramObject.length > 3)
        {
          a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue());
          return;
        }
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), false, 0, 0);
        return;
        localObject2 = localObject1;
        j = paramInt;
        str = null;
        localObject1 = paramObject;
        paramInt = i;
        paramObject = str;
        i = j;
        continue;
        localObject1 = null;
        break label1909;
        localObject2 = null;
        i = -1;
        paramObject = null;
        localObject1 = null;
        paramInt = -1;
      }
      localObject2 = localObject1;
      j = paramInt;
      str = null;
      localObject1 = paramObject;
      paramInt = i;
      paramObject = str;
      i = j;
      continue;
      localObject1 = null;
      break label1746;
      localObject2 = null;
      i = -1;
      paramObject = null;
      localObject1 = null;
      paramInt = -1;
    }
  }
  
  protected void a(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3) {}
  
  protected void a(Boolean paramBoolean) {}
  
  protected void a(Boolean paramBoolean, ArrayList paramArrayList, List paramList) {}
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(String paramString1, String paramString2) {}
  
  protected void a(String paramString1, String paramString2, byte paramByte) {}
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  protected void a(String paramString, boolean paramBoolean, List paramList) {}
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProfileActivity.AllInOne paramAllInOne) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList paramArrayList, int paramInt4, int paramInt5) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, TroopRewardInfo paramTroopRewardInfo) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject) {}
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  protected void a(boolean paramBoolean, long paramLong, long[] paramArrayOfLong, String[] paramArrayOfString) {}
  
  protected void a(boolean paramBoolean, RespBatchProcess paramRespBatchProcess) {}
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo) {}
  
  public void a(boolean paramBoolean, TroopShareResp paramTroopShareResp) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3) {}
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2) {}
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, List paramList) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List paramList, int paramInt) {}
  
  protected void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo) {}
  
  protected void b(Boolean paramBoolean) {}
  
  protected void b(String paramString) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List paramList) {}
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void b(boolean paramBoolean, List paramList) {}
  
  protected void c(String paramString) {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void d(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      a(paramBundle.getString("troop_code"), paramBundle.getString("troop_member_uin"), paramBundle.getByte("operation"));
      return;
    }
    paramInt = 0;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("error_code");
    }
    a(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\TroopObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */