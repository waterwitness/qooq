package com.tencent.mobileqq.app;

import EncounterSvc.RespGetEncounterV2;
import NeighborComm.RespHeader;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x683.cmd0x683.RankListInfo;

public class NearbyObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 12;
  public static final int m = 13;
  
  public NearbyObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 1: 
    case 13: 
    case 2: 
    case 12: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      do
      {
        do
        {
          do
          {
            Object[] arrayOfObject;
            do
            {
              do
              {
                do
                {
                  return;
                } while (paramObject == null);
                arrayOfObject = (Object[])paramObject;
                if (NearbyUtils.c()) {
                  break;
                }
              } while (arrayOfObject.length < 3);
              a((FromServiceMsg)arrayOfObject[0], (ToServiceMsg)arrayOfObject[1], (Object[])arrayOfObject[2]);
              return;
            } while (arrayOfObject.length < 5);
            paramObject = null;
            RespGetEncounterV2 localRespGetEncounterV2 = null;
            cmd0x683.RankListInfo localRankListInfo = null;
            ToServiceMsg localToServiceMsg = null;
            List localList = null;
            if ((arrayOfObject[0] instanceof RespHeader)) {
              paramObject = (RespHeader)arrayOfObject[0];
            }
            if ((arrayOfObject[1] instanceof RespGetEncounterV2)) {
              localRespGetEncounterV2 = (RespGetEncounterV2)arrayOfObject[1];
            }
            if ((arrayOfObject[2] instanceof cmd0x683.RankListInfo)) {
              localRankListInfo = (cmd0x683.RankListInfo)arrayOfObject[2];
            }
            if ((arrayOfObject[3] instanceof ToServiceMsg)) {
              localToServiceMsg = (ToServiceMsg)arrayOfObject[3];
            }
            if ((arrayOfObject[4] instanceof List)) {
              localList = (List)arrayOfObject[4];
            }
            if (paramInt == 1)
            {
              a(paramBoolean, (RespHeader)paramObject, localRespGetEncounterV2, localRankListInfo, localToServiceMsg, localList);
              return;
            }
            b(paramBoolean, (RespHeader)paramObject, localRespGetEncounterV2, localRankListInfo, localToServiceMsg, localList);
            return;
            a(paramBoolean, paramObject);
            return;
            a();
            return;
            if ((paramBoolean) && ((paramObject instanceof Object[])))
            {
              a(paramBoolean, (NearbyMyTabCard)((Object[])(Object[])paramObject)[0]);
              return;
            }
            a(false, null);
            return;
            paramObject = (Object[])paramObject;
            if ((paramBoolean) && (paramObject != null))
            {
              b(true, (NearbyMyTabCard)paramObject[0]);
              return;
            }
            b(false, null);
            return;
          } while ((!paramBoolean) || (paramObject == null));
          a(true, (byte[])paramObject);
          return;
          if ((paramBoolean == true) && (paramObject != null))
          {
            paramObject = (Object[])paramObject;
            a(true, new LBSInfo(String.valueOf(paramObject[0]), String.valueOf(paramObject[1]), String.valueOf(paramObject[2]), String.valueOf(paramObject[3]), String.valueOf(paramObject[4]), String.valueOf(paramObject[5]), String.valueOf(paramObject[6]), String.valueOf(paramObject[7]), ((Integer)paramObject[8]).doubleValue(), ((Integer)paramObject[9]).doubleValue(), ((Integer)paramObject[10]).doubleValue(), (String[])paramObject[11]));
            return;
          }
          a(false, null);
          return;
          a(paramBoolean, ((Boolean)paramObject).booleanValue());
          return;
        } while ((!paramBoolean) || (!(paramObject instanceof Object[])));
        paramObject = (Object[])paramObject;
        a(((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), (String)paramObject[7]);
        return;
      } while ((!paramBoolean) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), (String)paramObject[8]);
      return;
    case 10: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (List)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (ArrayList)paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), ((Long)paramObject[3]).longValue(), (String)paramObject[4], ((Boolean)paramObject[5]).booleanValue(), ((Long)paramObject[6]).longValue(), ((Long)paramObject[7]).longValue());
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString) {}
  
  protected void a(boolean paramBoolean, RespHeader paramRespHeader, RespGetEncounterV2 paramRespGetEncounterV2, cmd0x683.RankListInfo paramRankListInfo, ToServiceMsg paramToServiceMsg, List paramList) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo) {}
  
  protected void a(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString1, List paramList, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, byte[] paramArrayOfByte, int paramInt, long paramLong1, String paramString, boolean paramBoolean2, long paramLong2, long paramLong3) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  protected void b(boolean paramBoolean, RespHeader paramRespHeader, RespGetEncounterV2 paramRespGetEncounterV2, cmd0x683.RankListInfo paramRankListInfo, ToServiceMsg paramToServiceMsg, List paramList) {}
  
  public void b(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearbyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */