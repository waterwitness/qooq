package com.tencent.mobileqq.app;

import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.FriendAnniver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendListObserver
  implements BusinessObserver
{
  public static final String b = "addDirect";
  public static final int c = 7;
  public static final int d = 9;
  
  public FriendListObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt)
    {
    case 16: 
    case 17: 
    case 20: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 29: 
    case 31: 
    case 32: 
    case 34: 
    case 36: 
    case 40: 
    case 46: 
    case 54: 
    case 55: 
    case 57: 
    case 87: 
    case 88: 
    default: 
    case 1: 
    case 48: 
    case 2: 
    case 64: 
    case 65: 
    case 45: 
    case 104: 
    case 4: 
    case 5: 
    case 6: 
    case 30: 
    case 53: 
    case 3: 
    case 67: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 27: 
    case 28: 
    case 33: 
    case 35: 
    case 37: 
    case 102: 
    case 38: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 47: 
    case 39: 
    case 49: 
    case 73: 
    case 50: 
    case 58: 
    case 59: 
    case 60: 
    case 51: 
    case 61: 
    case 62: 
    case 52: 
    case 56: 
    case 69: 
    case 70: 
    case 63: 
    case 66: 
    case 68: 
    case 18: 
    case 19: 
    case 21: 
    case 22: 
    case 71: 
    case 72: 
    case 76: 
    case 77: 
    case 74: 
    case 75: 
    case 78: 
    case 89: 
    case 79: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    case 80: 
    case 90: 
    case 91: 
    case 85: 
    case 86: 
    case 92: 
    case 108: 
    case 93: 
    case 95: 
    case 94: 
    case 101: 
    case 96: 
    case 97: 
    case 98: 
    case 100: 
    case 99: 
    case 103: 
    case 105: 
    case 106: 
    case 107: 
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
                    if (paramBoolean)
                    {
                      a(paramBoolean, ((Boolean)paramObject).booleanValue());
                      return;
                    }
                    a(paramBoolean, false);
                    return;
                    if (paramBoolean) {}
                    for (bool1 = ((Boolean)paramObject).booleanValue();; bool1 = true)
                    {
                      b(paramBoolean, bool1);
                      return;
                    }
                    a(paramBoolean, (String[])paramObject);
                    return;
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (String[])paramObject[0], (Bundle)paramObject[1]);
                    return;
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (String[])paramObject[0], (Map)paramObject[1]);
                    return;
                    a(paramBoolean, (Setting)paramObject);
                    return;
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
                    return;
                    a(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                    return;
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
                    return;
                    paramObject = (Object[])paramObject;
                    b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
                    return;
                    b(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                    return;
                    paramObject = (Bundle)paramObject;
                    c(paramBoolean, ((Bundle)paramObject).getString("troopUin"), ((Bundle)paramObject).getString("url"));
                    return;
                    a((String)paramObject, paramBoolean);
                    return;
                    a((ArrayList)paramObject, paramBoolean);
                    return;
                    a();
                    return;
                    a(paramBoolean, (HashMap)paramObject);
                    return;
                    if (paramBoolean)
                    {
                      paramObject = (Object[])paramObject;
                      a((String)paramObject[0], ((Byte)paramObject[1]).byteValue(), ((Byte)paramObject[2]).byteValue());
                      return;
                    }
                    a(null, (byte)0, (byte)0);
                    return;
                    if (paramBoolean)
                    {
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                      return;
                    }
                    a(paramBoolean, "", 0);
                    return;
                    paramObject = (Bundle)paramObject;
                    String str = ((Bundle)paramObject).getString("uin");
                    paramInt = ((Bundle)paramObject).getInt("resultCode", 1);
                    bool2 = ((Bundle)paramObject).getBoolean("addDirect", false);
                    if (paramInt == 0) {
                      bool1 = true;
                    }
                    a(paramBoolean, bool1, bool2, str, (Bundle)paramObject);
                    return;
                    a(paramBoolean, (Bundle)paramObject);
                    return;
                    b(paramBoolean, (String[])paramObject);
                    return;
                    f(paramBoolean);
                    return;
                    a(paramBoolean, paramObject);
                    return;
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Byte)paramObject[2]).byteValue());
                    return;
                    b(paramBoolean);
                    return;
                    paramObject = (Bundle)paramObject;
                    str = ((Bundle)paramObject).getString("uin");
                    if (paramBoolean)
                    {
                      a(true, str, ((Bundle)paramObject).getString("nick_name"), ((Bundle)paramObject).getInt("group_id", 0));
                      return;
                    }
                    a(false, str, "", 0);
                    return;
                    bool1 = bool2;
                    if ((paramObject instanceof Object[]))
                    {
                      paramObject = (Object[])paramObject;
                      bool1 = bool2;
                      if (paramObject.length == 1)
                      {
                        bool1 = bool2;
                        if ((paramObject[0] instanceof Boolean)) {
                          bool1 = ((Boolean)paramObject[0]).booleanValue();
                        }
                      }
                    }
                    c(paramBoolean, bool1);
                    return;
                    b(paramBoolean, (ArrayList)paramObject);
                    return;
                    b();
                    return;
                    a(paramBoolean, (Map)paramObject);
                    return;
                    c(paramBoolean, (Map)paramObject);
                    return;
                    d(paramBoolean, (Map)paramObject);
                    return;
                    e(paramBoolean, (Map)paramObject);
                    return;
                    f(paramBoolean, (Map)paramObject);
                    return;
                    b(paramBoolean, (Map)paramObject);
                    return;
                    c(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
                    return;
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, ((Integer)paramObject[0]).intValue(), paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], ((Boolean)paramObject[4]).booleanValue(), ((Long)paramObject[5]).longValue());
                    return;
                    paramObject = (Object[])paramObject;
                    a(((Long)paramObject[0]).longValue(), paramBoolean, paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
                    return;
                    if (paramObject == null)
                    {
                      a(false, null, null);
                      return;
                    }
                    paramObject = (Object[])paramObject;
                    a(paramBoolean, (List)paramObject[0], (List)paramObject[1]);
                    return;
                    b(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
                    return;
                    c(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
                    return;
                    a(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
                    return;
                    paramObject = (Object[])paramObject;
                    d(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                    return;
                    paramObject = (Object[])paramObject;
                    b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                    return;
                    paramObject = (Object[])paramObject;
                    c(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                    return;
                    paramObject = (Object[])paramObject;
                    b(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
                    return;
                  } while (!(paramObject instanceof Object[]));
                  paramObject = (Object[])paramObject;
                  a(((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
                  return;
                  if (paramBoolean)
                  {
                    c(paramBoolean, (ArrayList)paramObject);
                    return;
                  }
                  c(paramBoolean, null);
                  return;
                  g(paramBoolean);
                  return;
                } while ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof String)));
                a((String)paramObject);
                return;
                b(paramBoolean, paramObject);
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
              paramInt = paramObject.length;
              if (paramInt == 2)
              {
                a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], null);
                return;
              }
            } while (paramInt != 3);
            a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (GetOnlineInfoResp)paramObject[2]);
            return;
            a(paramBoolean, (GroupActionResp)paramObject);
            return;
            b(paramBoolean, (GroupActionResp)paramObject);
            return;
            c(paramBoolean, (GroupActionResp)paramObject);
            return;
            d(paramBoolean, (GroupActionResp)paramObject);
            return;
            paramObject = (Bundle)paramObject;
            long l = ((Bundle)paramObject).getLong("uin");
            int j = ((Bundle)paramObject).getInt("safety_flag");
            int i = 146;
            if (paramInt == 72) {
              i = 147;
            }
            a(paramBoolean, l, i, j);
            return;
            d(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            e(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            paramObject = (Bundle)paramObject;
            a(paramBoolean, ((Bundle)paramObject).getString("uin"), ((Bundle)paramObject).getString("nick_name"));
            return;
            c(paramBoolean, paramObject);
            return;
            g(paramBoolean, (Map)paramObject);
            return;
            paramObject = (Object[])paramObject;
            b(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
            return;
            paramObject = (Object[])paramObject;
            a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
            return;
            f(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            i(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            g(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            j(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            h(paramBoolean, ((Boolean)paramObject).booleanValue());
            return;
            b(paramBoolean, (List)paramObject);
            return;
            a(paramBoolean, (List)paramObject);
            return;
            h(paramBoolean);
            return;
            paramObject = (List)paramObject;
            if ((paramObject != null) && (((List)paramObject).size() == 2))
            {
              b(paramBoolean, ((Boolean)((List)paramObject).get(0)).booleanValue(), ((Boolean)((List)paramObject).get(1)).booleanValue());
              return;
            }
            b(false, false, false);
            return;
            d(paramBoolean);
            return;
            e(paramBoolean);
            return;
            d(paramBoolean, (String)paramObject);
            return;
            if (paramBoolean)
            {
              e(true, paramObject);
              return;
            }
            e(false, null);
            return;
            d(paramBoolean, paramObject);
            return;
            c(paramBoolean);
            return;
            a(paramBoolean, (Object[])paramObject);
            return;
            c(paramBoolean, (Object[])paramObject);
            return;
            d(paramBoolean, (Object[])paramObject);
            return;
            b(paramBoolean, (Object[])paramObject);
            return;
            if (paramBoolean)
            {
              paramObject = (Object[])paramObject;
              a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1]);
              return;
            }
            a(false, false, null);
            return;
            c();
            return;
          } while ((paramObject == null) || (!(paramObject instanceof String)));
          e(paramBoolean, (String)paramObject);
          return;
        } while ((paramObject == null) || (!(paramObject instanceof Boolean)));
        a(((Boolean)paramObject).booleanValue());
        return;
      } while ((paramObject == null) || (!(paramObject instanceof ArrayList)));
      a(paramBoolean, (ArrayList)paramObject);
      return;
    }
    a(paramBoolean, (FriendAnniver)paramObject);
  }
  
  protected void a(long paramLong, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2) {}
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Shield", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " isSetOrClear:" + paramBoolean1 + " isSuc:" + paramBoolean2 + " isPush:" + paramBoolean3 + " errMsg:" + paramString);
    }
  }
  
  public void a(String paramString) {}
  
  protected void a(String paramString, byte paramByte1, byte paramByte2) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(ArrayList paramArrayList, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, byte paramByte1, String paramString1, long paramLong, byte paramByte2, byte paramByte3, short paramShort, String paramString2) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp) {}
  
  protected void a(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void a(boolean paramBoolean, FriendAnniver paramFriendAnniver) {}
  
  protected void a(boolean paramBoolean, Setting paramSetting) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void a(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, HashMap paramHashMap) {}
  
  protected void a(boolean paramBoolean, List paramList) {}
  
  protected void a(boolean paramBoolean, List paramList1, List paramList2) {}
  
  public void a(boolean paramBoolean, Map paramMap) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List paramList) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void a(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString, Map paramMap) {}
  
  protected void b() {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {}
  
  protected void b(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void b(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void b(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void b(boolean paramBoolean, List paramList) {}
  
  protected void b(boolean paramBoolean, Map paramMap) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void b(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void c() {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void c(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, String paramString) {}
  
  protected void c(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void c(boolean paramBoolean, ArrayList paramArrayList) {}
  
  protected void c(boolean paramBoolean, Map paramMap) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void d(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, String paramString) {}
  
  protected void d(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void d(boolean paramBoolean, Map paramMap) {}
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void d(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void e(boolean paramBoolean) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, String paramString) {}
  
  protected void e(boolean paramBoolean, Map paramMap) {}
  
  protected void e(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void f(boolean paramBoolean) {}
  
  protected void f(boolean paramBoolean, Map paramMap) {}
  
  protected void f(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void g(boolean paramBoolean) {}
  
  protected void g(boolean paramBoolean, Map paramMap) {}
  
  protected void g(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void h(boolean paramBoolean) {}
  
  protected void h(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void i(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void j(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\FriendListObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */