package com.tencent.mobileqq.nearby.business;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class NearbyCardObserver
  implements BusinessObserver
{
  public NearbyCardObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 9: 
    case 61: 
    case 60: 
      do
      {
        do
        {
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], (List)paramObject[3], (String)paramObject[4], ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), (String)paramObject[7]);
          return;
          paramObject = (Object[])paramObject;
          a();
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (NearbyPeopleCard)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2]);
          return;
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], (List)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
          return;
          Object localObject2 = (Object[])paramObject;
          if ((paramBoolean) && (localObject2 != null) && (localObject2.length == 6))
          {
            long l = ((Long)localObject2[0]).longValue();
            boolean bool1 = ((Boolean)localObject2[1]).booleanValue();
            boolean bool2 = ((Boolean)localObject2[2]).booleanValue();
            paramObject = (byte[])localObject2[3];
            localObject1 = (String)localObject2[4];
            localObject2 = (String)localObject2[5];
            a(paramBoolean, l, bool1, bool2, (byte[])paramObject, (String)localObject1);
            com.tencent.mobileqq.dating.DatingUtil.c = (String)localObject2;
            return;
          }
          a(false, 0L, false, false, null, null);
          return;
        } while ((!paramBoolean) || (!(paramObject instanceof Object[])));
        paramObject = (Object[])paramObject;
        a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), (String)paramObject[8]);
        return;
      } while ((!paramBoolean) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
      a(((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), (String)paramObject[7]);
      return;
    case 51: 
      if ((paramBoolean) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        a(paramBoolean, (NearbyPeopleCard)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
        return;
      }
      a(paramBoolean, (NearbyPeopleCard)paramObject, false);
      return;
    case 46: 
      a(paramBoolean);
      return;
    case 48: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length == 5)) {
        if (!(paramObject[1] instanceof Integer)) {
          break label1234;
        }
      }
      break;
    }
    label854:
    label874:
    label894:
    label1179:
    label1185:
    label1191:
    label1197:
    label1202:
    label1234:
    for (paramInt = ((Integer)paramObject[1]).intValue();; paramInt = -1)
    {
      if ((paramObject[2] instanceof Integer)) {}
      for (int i = ((Integer)paramObject[2]).intValue();; i = -1)
      {
        if ((paramObject[3] instanceof Integer)) {}
        for (int j = ((Integer)paramObject[3]).intValue();; j = -1)
        {
          if ((paramObject[4] instanceof Integer)) {}
          for (int k = ((Integer)paramObject[4]).intValue();; k = -1)
          {
            a(paramBoolean, (ArrayList)paramObject[0], paramInt, i, j, k);
            return;
            a(false, null, -1, -1, -1, -1);
            return;
            if (paramObject != null)
            {
              paramObject = (Object[])paramObject;
              if ((paramObject == null) || (paramObject.length != 5)) {
                break label1202;
              }
              if (!(paramObject[1] instanceof Integer)) {
                break label1197;
              }
              paramInt = ((Integer)paramObject[1]).intValue();
              if (!(paramObject[2] instanceof Integer)) {
                break label1191;
              }
              i = ((Integer)paramObject[2]).intValue();
              if (!(paramObject[3] instanceof Integer)) {
                break label1185;
              }
              j = ((Integer)paramObject[3]).intValue();
              if (!(paramObject[4] instanceof Integer)) {
                break label1179;
              }
              k = ((Integer)paramObject[4]).intValue();
            }
            for (;;)
            {
              b(paramBoolean, (ArrayList)paramObject[0], paramInt, i, j, k);
              return;
              b(false, null, -1, -1, -1, -1);
              return;
              if (paramObject == null) {
                break;
              }
              paramObject = (Object[])paramObject;
              a(paramBoolean, (String)paramObject[0], (mobile_sub_get_cover_rsp)paramObject[1]);
              return;
              if (!(paramObject instanceof Bundle)) {
                break;
              }
              paramObject = (Bundle)paramObject;
              if (((Bundle)paramObject).getInt("favoriteSource") == 43)
              {
                b(paramBoolean, ((Bundle)paramObject).getString("selfUin"), ((Bundle)paramObject).getString("targetUin"), ((Bundle)paramObject).getInt("toplist_type"), ((Bundle)paramObject).getInt("iCount", 0));
                return;
              }
              a(paramBoolean, ((Bundle)paramObject).getString("selfUin"), ((Bundle)paramObject).getString("targetUin"), ((Bundle)paramObject).getInt("iCount", 0), ((Bundle)paramObject).getInt("from", 0));
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
              if ((!paramBoolean) || (paramObject == null)) {
                break;
              }
              paramObject = (Object[])paramObject;
              a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
              return;
              k = -1;
              continue;
              j = -1;
              break label894;
              i = -1;
              break label874;
              paramInt = -1;
              break label854;
              k = -1;
              j = -1;
              i = -1;
              paramInt = -1;
            }
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List paramList1, List paramList2, String paramString1, int paramInt3, int paramInt4, String paramString2) {}
  
  protected void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString) {}
  
  protected void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, String paramString1, List paramList, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\business\NearbyCardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */