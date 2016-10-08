package com.tencent.mobileqq.app;

import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NeighborSvc.RespGetNeighbors;
import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.facetoface.NearbyUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class LBSObserver
  implements BusinessObserver
{
  public LBSObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 8: 
    case 12: 
    case 13: 
    case 14: 
    case 9: 
    case 10: 
    case 11: 
    case 18: 
    case 15: 
    case 16: 
    case 17: 
    case 19: 
    case 25: 
    case 26: 
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
              } while (paramObject == null);
              if (paramBoolean)
              {
                paramObject = (Object[])paramObject;
                a(true, (byte[])paramObject[0], (String)paramObject[1], (String)paramObject[2], (String)paramObject[3]);
                return;
              }
              a(false, (byte[])paramObject, null, null, null);
              return;
              if (!paramBoolean) {
                break;
              }
            } while (paramObject == null);
            paramObject = (Object[])paramObject;
            a(true, (String)paramObject[0], (RespGetNeighbors)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), 0);
            return;
            a(false, null, null, false, -1);
            return;
            b(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            paramObject = (Object[])paramObject;
            paramInt = ((Integer)paramObject[0]).intValue();
            boolean bool = ((Boolean)paramObject[1]).booleanValue();
            paramObject = (RspGetNearbyGroup)paramObject[2];
            if (paramBoolean)
            {
              a(paramInt, true, bool, (RspGetNearbyGroup)paramObject);
              return;
            }
            a(paramInt, false, bool, (RspGetNearbyGroup)paramObject);
            return;
            if (paramBoolean)
            {
              if (paramObject == null)
              {
                a(true, null, false);
                return;
              }
              paramObject = (Object[])paramObject;
              paramBoolean = ((Boolean)paramObject[0]).booleanValue();
              a(true, (RspGetAreaList)paramObject[1], paramBoolean);
              return;
            }
            a(false, null, false);
            return;
            if (paramBoolean)
            {
              if (paramObject == null)
              {
                a(true, null);
                return;
              }
              a(true, (RspGetGroupInArea)((Object[])(Object[])paramObject)[0]);
              return;
            }
            a(false, null);
            return;
            if ((paramBoolean == true) && (paramObject != null))
            {
              paramObject = (Object[])paramObject;
              a(true, ((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue());
              return;
            }
            a(false, 0L, false);
            return;
            a(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            paramObject = (Object[])paramObject;
            if (paramBoolean)
            {
              a(true, ((Integer)paramObject[0]).intValue(), ((Boolean)paramObject[1]).booleanValue());
              return;
            }
            a(false, -1, false);
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
          a(paramBoolean, (Object[])paramObject);
          return;
          b(paramBoolean, (Object[])paramObject);
          return;
          c(paramBoolean, (Object[])paramObject);
          return;
          a(paramBoolean, ((Integer)paramObject).intValue());
          return;
        } while (paramObject == null);
        paramObject = (Object[])paramObject;
        a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
      a((NearbyUser)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 24: 
      d(paramBoolean, (Object[])paramObject);
      return;
    }
    e(paramBoolean, (Object[])paramObject);
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup) {}
  
  public void a(NearbyUser paramNearbyUser, boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo) {}
  
  protected void a(boolean paramBoolean1, String paramString, RespGetNeighbors paramRespGetNeighbors, boolean paramBoolean2, int paramInt) {}
  
  public void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void c(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void d(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void e(boolean paramBoolean, Object[] paramArrayOfObject) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\LBSObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */