package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class HotChatObserver
  implements BusinessObserver
{
  public HotChatObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1042: 
    case 1043: 
    default: 
    case 1031: 
    case 1032: 
    case 1033: 
    case 1034: 
    case 1035: 
    case 1036: 
    case 1037: 
    case 1038: 
    case 1039: 
    case 1040: 
    case 1041: 
    case 1044: 
    case 1045: 
    case 1046: 
    case 1047: 
    case 1048: 
      boolean bool;
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
                  if (paramBoolean) {}
                  for (paramInt = 0;; paramInt = -1)
                  {
                    a(paramInt);
                    return;
                  }
                  if (paramObject == null)
                  {
                    a(null, null, paramBoolean, null, null, null);
                    return;
                  }
                  paramObject = (Object[])paramObject;
                  if (paramBoolean)
                  {
                    a((String)paramObject[2], (String)paramObject[1], paramBoolean, (String)paramObject[0], (String)paramObject[3], (Boolean)paramObject[4]);
                    return;
                  }
                  a("", (String)paramObject[0], paramBoolean, (String)paramObject[1], (String)paramObject[2], null);
                  return;
                } while (!(paramObject instanceof Object[]));
                paramObject = (Object[])paramObject;
                a((String)paramObject[0], paramBoolean, (String)paramObject[1]);
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
              a(paramBoolean, (HotChatInfo)paramObject[0], (Common.WifiPOIInfo)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
              return;
              paramObject = (Object[])paramObject;
              a(paramBoolean, (byte[])paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
              return;
              paramObject = (Object[])paramObject;
              a(paramBoolean, (String)paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4], (List)paramObject[5]);
              return;
              paramObject = (Object[])paramObject;
              a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3]);
              return;
              paramObject = (Object[])paramObject;
              a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
              return;
              paramObject = (Object[])paramObject;
              a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (Long)paramObject[3]);
              return;
              paramObject = (Object[])paramObject;
              b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
              return;
              paramObject = (Object[])paramObject;
              a((String)paramObject[0], (HotChatManager.HotChatStateWrapper)paramObject[1]);
              return;
              paramObject = (Object[])paramObject;
              if (paramBoolean)
              {
                a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (String)paramObject[1], 0, "");
                return;
              }
              a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
              return;
              paramObject = (Object[])paramObject;
              a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), (String)paramObject[5], ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue());
              return;
            } while ((paramObject == null) || (!(paramObject instanceof Object[])));
            paramObject = (Object[])paramObject;
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Long)paramObject[7]).longValue(), (String)paramObject[8]);
            return;
            paramObject = (Object[])paramObject;
          } while (paramObject == null);
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1], (Long)paramObject[2]);
          return;
          paramObject = (Object[])paramObject;
        } while (paramObject == null);
        bool = false;
        if (paramObject.length > 2) {
          bool = ((Boolean)paramObject[2]).booleanValue();
        }
      } while (!bool);
      if (paramObject.length > 3)
      {
        a(paramBoolean, (oidb_0x88d.GroupInfo)paramObject[3]);
        return;
      }
      a(paramBoolean, null);
      return;
    case 1049: 
      if (!paramBoolean)
      {
        paramObject = (Object[])paramObject;
        a(false, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), null, (Boolean)paramObject[2], ((Integer)paramObject[3]).intValue());
        return;
      }
      paramObject = (Object[])paramObject;
      a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (Common.WifiPOIInfo)paramObject[2], (Boolean)paramObject[3], ((Integer)paramObject[4]).intValue());
      return;
    }
    if (!paramBoolean)
    {
      paramObject = (Object[])paramObject;
      a(false, (String)paramObject[0], null, ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    }
    paramObject = (Object[])paramObject;
    a(true, (String)paramObject[0], (Common.WifiPOIInfo)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Boolean)paramObject[3]).booleanValue());
  }
  
  public void a(String paramString, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, String paramString3) {}
  
  protected void a(boolean paramBoolean, int paramInt, List paramList, Long paramLong) {}
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, Common.WifiPOIInfo paramWifiPOIInfo, Boolean paramBoolean1, int paramInt2) {}
  
  public void a(boolean paramBoolean1, String paramString, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List paramList) {}
  
  protected void a(boolean paramBoolean, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt, String paramString2) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\HotChatObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */