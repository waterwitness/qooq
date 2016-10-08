package com.tencent.mobileqq.app;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.qidian.data.BmqqAccountType;
import java.util.ArrayList;
import java.util.List;

public class CardObserver
  implements BusinessObserver
{
  public CardObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    case 7: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 18: 
    case 19: 
    case 30: 
    case 46: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 60: 
    case 61: 
    default: 
    case 1: 
    case 52: 
    case 53: 
    case 35: 
    case 2: 
    case 3: 
    case 5: 
    case 32: 
    case 6: 
    case 42: 
    case 8: 
    case 10: 
    case 11: 
    case 9: 
    case 12: 
    case 22: 
    case 29: 
    case 17: 
    case 20: 
    case 43: 
    case 21: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 41: 
    case 27: 
    case 28: 
    case 31: 
    case 34: 
    case 33: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 69: 
    case 70: 
    case 71: 
    case 54: 
    case 55: 
    case 44: 
    case 45: 
    case 72: 
    case 73: 
    case 47: 
    case 56: 
    case 58: 
    case 57: 
    case 59: 
    case 62: 
    case 63: 
    case 64: 
    case 67: 
    case 66: 
      do
      {
        do
        {
          Object localObject1;
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
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          return;
                                          a(paramBoolean, paramObject);
                                          return;
                                          e(paramBoolean, paramObject);
                                          return;
                                          if (!paramBoolean) {
                                            break;
                                          }
                                        } while (!(paramObject instanceof Object[]));
                                        paramObject = (Object[])paramObject;
                                        a(paramBoolean, (Card)paramObject[0], ((Long)paramObject[1]).longValue());
                                        return;
                                      } while (!(paramObject instanceof Card));
                                      a(paramBoolean, (Card)paramObject, -1L);
                                      return;
                                    } while (!(paramObject instanceof Object[]));
                                    paramObject = (Object[])paramObject;
                                    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (Card)paramObject[2]);
                                    return;
                                    e(paramBoolean, ((Bundle)paramObject).getString("uin"));
                                    return;
                                    if (paramBoolean)
                                    {
                                      c(paramBoolean, (Card)paramObject);
                                      return;
                                    }
                                    c(paramBoolean, null);
                                    return;
                                    f(paramBoolean, ((Bundle)paramObject).getString("targetUin"));
                                    return;
                                  } while (!(paramObject instanceof Bundle));
                                  paramObject = (Bundle)paramObject;
                                  if (((Bundle)paramObject).getInt("favoriteSource") == 43)
                                  {
                                    b(paramBoolean, ((Bundle)paramObject).getString("selfUin"), ((Bundle)paramObject).getString("targetUin"), ((Bundle)paramObject).getInt("toplist_type"), ((Bundle)paramObject).getInt("iCount", 0));
                                    return;
                                  }
                                  a(paramBoolean, ((Bundle)paramObject).getString("selfUin"), ((Bundle)paramObject).getString("targetUin"), ((Bundle)paramObject).getInt("iCount", 0), ((Bundle)paramObject).getInt("from", 0));
                                  return;
                                  Object localObject3;
                                  if (paramBoolean)
                                  {
                                    Object localObject4 = (Object[])paramObject;
                                    paramObject = (Card)localObject4[0];
                                    localObject1 = (Bundle)localObject4[1];
                                    localObject2 = (ArrayList)localObject4[2];
                                    localObject3 = (ArrayList)localObject4[3];
                                    paramInt = ((Integer)localObject4[4]).intValue();
                                    int i = ((Integer)localObject4[5]).intValue();
                                    localObject4 = ((Bundle)localObject1).getString("uin");
                                    l1 = ((Bundle)localObject1).getLong("nextMid");
                                    a(true, (String)localObject4, (ArrayList)localObject2, (ArrayList)localObject3, paramInt, i, ((Bundle)localObject1).getLong("startMid"), l1, ((Bundle)localObject1).getByteArray("strCookie"), (Card)paramObject);
                                    return;
                                  }
                                  a(false, ((Bundle)((Object[])(Object[])paramObject)[1]).getString("uin"), null, null, -1, -1, -1L, -1L, null, null);
                                  return;
                                  if (paramBoolean)
                                  {
                                    localObject2 = (Object[])paramObject;
                                    paramObject = (Card)localObject2[0];
                                    localObject1 = (Bundle)localObject2[1];
                                    localObject2 = (ArrayList)localObject2[2];
                                    localObject3 = ((Bundle)localObject1).getString("uin");
                                    l1 = ((Bundle)localObject1).getLong("nextMid");
                                    a(true, (String)localObject3, (ArrayList)localObject2, ((Bundle)localObject1).getLong("startMid"), l1, ((Bundle)localObject1).getByteArray("strCookie"), (Card)paramObject);
                                    return;
                                  }
                                  a(false, ((Bundle)((Object[])(Object[])paramObject)[1]).getString("uin"), null, -1L, -1L, null, null);
                                  return;
                                  b(paramBoolean, ((Bundle)paramObject).getString("uin"));
                                  return;
                                  if (paramBoolean)
                                  {
                                    paramObject = (Object[])paramObject;
                                    a(true, (Card)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
                                    return;
                                  }
                                  a(false, (Card)paramObject, false);
                                  return;
                                  if (paramBoolean)
                                  {
                                    paramObject = (Object[])paramObject;
                                    localObject1 = (Card)paramObject[0];
                                    b(paramBoolean, null, ((Bundle)paramObject[1]).getInt("retCode", -1), (Card)localObject1);
                                    return;
                                  }
                                  paramInt = -1;
                                  if ((paramObject instanceof Bundle)) {
                                    paramInt = ((Bundle)paramObject).getInt("retCode", -1);
                                  }
                                  b(paramBoolean, null, paramInt, null);
                                  return;
                                } while (!paramBoolean);
                                d(paramBoolean, (Card)paramObject);
                                return;
                                if (paramBoolean)
                                {
                                  localObject1 = (Object[])paramObject;
                                  paramObject = (Bundle)localObject1[0];
                                  localObject1 = (Card)localObject1[1];
                                  ((Bundle)paramObject).getString("uin");
                                  a(paramBoolean, (Card)localObject1, ((Bundle)paramObject).getInt("result", -1), ((Bundle)paramObject).getByteArray("fileKey"));
                                  return;
                                }
                                localObject1 = (Object[])paramObject;
                                paramObject = (Bundle)localObject1[0];
                                localObject1 = (Card)localObject1[1];
                                ((Bundle)paramObject).getString("uin");
                                a(paramBoolean, (Card)localObject1, ((Bundle)paramObject).getInt("result", -1), ((Bundle)paramObject).getByteArray("fileKey"));
                                return;
                                g(paramBoolean, ((Bundle)paramObject).getString("uin"));
                                return;
                                c(paramBoolean, ((Bundle)paramObject).getString("uin"));
                                return;
                              } while (!paramBoolean);
                              paramObject = (Card)paramObject;
                              c(paramBoolean, ((Card)paramObject).uin, (Card)paramObject);
                              return;
                            } while (!paramBoolean);
                            paramObject = (Card)paramObject;
                            a(paramBoolean, ((Card)paramObject).uin, (Card)paramObject);
                            return;
                          } while (!paramBoolean);
                          paramObject = (Card)paramObject;
                          b(true, ((Card)paramObject).uin, (Card)paramObject);
                          return;
                          paramObject = (Bundle)paramObject;
                          a(paramBoolean, ((Bundle)paramObject).getString("uin"), ((Bundle)paramObject).getString("filekey"));
                          return;
                          a(paramBoolean, ((Bundle)paramObject).getString("uin"));
                          return;
                          if (paramBoolean)
                          {
                            e(paramBoolean, (Card)paramObject);
                            return;
                          }
                          e(paramBoolean, null);
                          return;
                          if (paramBoolean)
                          {
                            a(paramBoolean, (Card)paramObject);
                            return;
                          }
                          a(paramBoolean, null);
                          return;
                          paramObject = (Card)paramObject;
                          if (paramBoolean)
                          {
                            f(paramBoolean, (Card)paramObject);
                            return;
                          }
                          f(paramBoolean, (Card)paramObject);
                          return;
                          d(paramBoolean, paramObject);
                          return;
                          paramObject = (Bundle)paramObject;
                          localObject1 = ((Bundle)paramObject).getString("lUin");
                          l1 = ((Bundle)paramObject).getLong("nextMid");
                          Object localObject2 = ((Bundle)paramObject).getByteArray("strCookie");
                          a(paramBoolean, (String)localObject1, ((Bundle)paramObject).getStringArrayList("hexFaceInfo"), l1, (byte[])localObject2);
                          return;
                        } while (!paramBoolean);
                        localObject1 = (Object[])paramObject;
                        paramObject = (Card)localObject1[0];
                        localObject1 = (Bundle)localObject1[1];
                        ((Bundle)localObject1).getString("uin");
                        paramInt = ((Bundle)localObject1).getInt("newVoteCount");
                        c(paramBoolean, ((Bundle)localObject1).getString("voteeUin"), paramInt, (Card)paramObject);
                        return;
                        paramObject = (Object[])paramObject;
                        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (Card)paramObject[1]);
                        return;
                        paramObject = (Bundle)paramObject;
                        a(paramBoolean, ((Bundle)paramObject).getString("uin"), ((Bundle)paramObject).getBoolean("modify_switch_for_near_people"), ((Bundle)paramObject).getBoolean("target_switch"));
                        return;
                        paramObject = (Bundle)paramObject;
                        localObject1 = ((Bundle)paramObject).getString("uin");
                        long l1 = ((Bundle)paramObject).getLong("uCloseNeighborVote", 0L);
                        long l2 = ((Bundle)paramObject).getLong("uColseTimeEntityManager", 0L);
                        boolean bool1;
                        if (l1 == 0L)
                        {
                          bool1 = true;
                          if (l2 != 0L) {
                            break label1524;
                          }
                        }
                        for (boolean bool2 = true;; bool2 = false)
                        {
                          b(paramBoolean, (String)localObject1, bool1, bool2);
                          return;
                          bool1 = false;
                          break;
                        }
                        h(paramBoolean, ((Bundle)paramObject).getString("pttcenter_selfuin"));
                        return;
                        paramObject = (Bundle)paramObject;
                        localObject1 = ((Bundle)paramObject).getString("pttcenter_selfuin");
                        paramInt = ((Bundle)paramObject).getInt("pttcenter_voice_optype");
                        a(paramBoolean, (String)localObject1, ((Bundle)paramObject).getString("pttcenter_filekey"), paramInt);
                        return;
                        f(paramBoolean, ((Boolean)paramObject).booleanValue());
                        return;
                        g(paramBoolean, ((Boolean)paramObject).booleanValue());
                        return;
                      } while (paramObject == null);
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, (String)paramObject[0], (mobile_sub_get_cover_rsp)paramObject[1]);
                      return;
                    } while (paramObject == null);
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (String)paramObject[0], (mobile_sub_get_photo_wall_rsp)paramObject[1], (String)paramObject[2]);
                    return;
                  } while (paramObject == null);
                  d(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                  return;
                } while (paramObject == null);
                b(paramBoolean, paramObject);
                return;
                b(paramBoolean, Boolean.parseBoolean(paramObject.toString()));
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
              a(paramBoolean, Boolean.parseBoolean(paramObject[0].toString()), paramObject[1].toString(), paramObject[2].toString());
              return;
              c(paramBoolean, ((Boolean)paramObject).booleanValue());
              return;
              a(paramBoolean);
              return;
              a(paramBoolean, ((Boolean)paramObject).booleanValue());
              return;
              b(paramBoolean);
              return;
              paramObject = (Object[])paramObject;
              if ((paramObject != null) && (paramObject.length == 2))
              {
                a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
                return;
              }
              a(false, 0, "");
              return;
              a(paramBoolean, ((Integer)paramObject).intValue());
              return;
              d(paramBoolean, ((Boolean)paramObject).booleanValue());
              return;
              e(paramBoolean, ((Boolean)paramObject).booleanValue());
              return;
              h(paramBoolean, ((Boolean)paramObject).booleanValue());
              return;
              a(paramBoolean, (NearbyPeopleCard)paramObject);
              return;
              if ((paramObject != null) && ((paramObject instanceof Card))) {}
              for (paramObject = (Card)paramObject;; paramObject = null)
              {
                b(paramBoolean, (Card)paramObject);
                return;
              }
              c(paramBoolean, paramObject);
              return;
            } while (paramObject == null);
            localObject1 = (Object[])paramObject;
            paramInt = ((Integer)localObject1[0]).intValue();
            paramObject = (Long)localObject1[1];
            localObject1 = (Long)localObject1[2];
          } while ((paramObject == null) || (localObject1 == null));
          a(paramBoolean, paramInt, ((Long)paramObject).toString(), ((Long)localObject1).toString());
          return;
        } while (paramObject == null);
        paramObject = (Object[])paramObject;
      } while (paramObject == null);
      a(paramBoolean, paramObject[0].toString(), (ArrayList)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 65: 
      label1524:
      if ((paramBoolean) && ((paramObject instanceof Object[]))) {
        a(paramBoolean, (NearbyMyTabCard)((Object[])(Object[])paramObject)[0]);
      }
      break;
    }
    for (;;)
    {
      a(paramBoolean, (BmqqAccountType)paramObject);
      return;
      a(false, null);
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt, Card paramCard) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, Card paramCard) {}
  
  protected void a(boolean paramBoolean, Card paramCard, int paramInt, byte[] paramArrayOfByte) {}
  
  public void a(boolean paramBoolean, Card paramCard, long paramLong) {}
  
  protected void a(boolean paramBoolean1, Card paramCard, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, NearbyPeopleCard paramNearbyPeopleCard) {}
  
  protected void a(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  public void a(boolean paramBoolean, BmqqAccountType paramBmqqAccountType) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp) {}
  
  protected void a(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte) {}
  
  protected void a(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard) {}
  
  protected void a(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong, byte[] paramArrayOfByte) {}
  
  protected void a(boolean paramBoolean, String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard) {}
  
  protected void a(boolean paramBoolean, String paramString, List paramList, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2) {}
  
  protected void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, Card paramCard) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void b(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(boolean paramBoolean, Card paramCard) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, String paramString) {}
  
  protected void c(boolean paramBoolean, String paramString, int paramInt, Card paramCard) {}
  
  protected void c(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void d(boolean paramBoolean, Card paramCard) {}
  
  public void d(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, String paramString) {}
  
  protected void d(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void e(boolean paramBoolean, Card paramCard) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, String paramString) {}
  
  protected void e(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void f(boolean paramBoolean, Card paramCard) {}
  
  protected void f(boolean paramBoolean, String paramString) {}
  
  protected void f(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void g(boolean paramBoolean, String paramString) {}
  
  protected void g(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void h(boolean paramBoolean, String paramString) {}
  
  protected void h(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\CardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */