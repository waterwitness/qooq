package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.List;

public class DatingObserver
  implements BusinessObserver
{
  public DatingObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    Object localObject2;
    Object localObject1;
    long l;
    boolean bool1;
    switch (paramInt)
    {
    case 11: 
    case 25: 
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3], (byte[])paramObject[4], (String)paramObject[5]);
      return;
    case 2: 
      a(paramBoolean, (DatingConfig)((Object[])(Object[])paramObject)[0]);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (DatingInfo)paramObject[1], ((Integer)paramObject[2]).intValue());
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 6: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1], (List)paramObject[2], (String)paramObject[3]);
      return;
    case 7: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (DatingInfo)paramObject[2], (byte[])paramObject[3], (String)paramObject[4]);
      return;
    case 8: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
      return;
    case 9: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (List)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), (byte[])paramObject[3], (String)paramObject[4], ((Boolean)paramObject[5]).booleanValue(), ((Boolean)paramObject[6]).booleanValue());
      return;
    case 10: 
      a(paramBoolean);
      return;
    case 12: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1], (String)paramObject[2]);
      return;
    case 14: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1], (String)paramObject[2]);
      return;
    case 13: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
      return;
    case 15: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
      return;
    case 16: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (DatingInfo)paramObject[4]);
      return;
    case 17: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (DatingInfo)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue());
      return;
    case 18: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, (String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
      return;
    case 19: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (DatingInfo)paramObject[3], (String)paramObject[4]);
      return;
    case 20: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
      return;
    case 21: 
      paramObject = (Object[])paramObject;
      if (paramBoolean)
      {
        a(paramBoolean, (List)paramObject[0], (List)paramObject[1], (ByteStringMicro)paramObject[2], ((Boolean)paramObject[3]).booleanValue());
        return;
      }
      a(paramBoolean, null, null, null, true);
      return;
    case 22: 
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 26: 
      localObject2 = (Object[])paramObject;
      paramInt = -1;
      if ((paramBoolean) && (localObject2 != null))
      {
        localObject1 = (List)localObject2[0];
        paramObject = (List)localObject2[1];
        l = ((Long)localObject2[2]).longValue();
        bool1 = ((Boolean)localObject2[3]).booleanValue();
        paramInt = ((Integer)localObject2[4]).intValue();
        bool2 = ((Boolean)localObject2[5]).booleanValue();
      }
      break;
    }
    for (;;)
    {
      a(paramBoolean, (List)localObject1, (List)paramObject, l, bool1, paramInt, bool2);
      return;
      paramObject = (Object[])paramObject;
      bool1 = bool3;
      if (paramObject != null)
      {
        bool1 = bool3;
        if (paramObject.length == 1) {
          if (((Byte)paramObject[0]).byteValue() != 1) {
            break label1141;
          }
        }
      }
      label1141:
      for (bool1 = bool2;; bool1 = false)
      {
        a(paramBoolean, bool1);
        return;
      }
      localObject2 = (Object[])paramObject;
      if ((paramBoolean) && (localObject2 != null) && (localObject2.length == 6))
      {
        l = ((Long)localObject2[0]).longValue();
        bool1 = ((Boolean)localObject2[1]).booleanValue();
        bool2 = ((Boolean)localObject2[2]).booleanValue();
        paramObject = (byte[])localObject2[3];
        localObject1 = (String)localObject2[4];
        localObject2 = (String)localObject2[5];
        a(paramBoolean, l, bool1, bool2, (byte[])paramObject, (String)localObject1);
        DatingUtil.c = (String)localObject2;
        return;
      }
      a(false, 0L, false, false, null, null);
      return;
      paramObject = (Object[])paramObject;
      if ((paramBoolean) && (paramObject != null) && (paramObject.length == 2))
      {
        a(true, (String)paramObject[0], (String)paramObject[1]);
        return;
      }
      a(false, null, null);
      return;
      bool2 = false;
      bool1 = false;
      paramObject = null;
      localObject1 = null;
      l = 0L;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, DatingInfo paramDatingInfo, byte[] paramArrayOfByte, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList, List paramList, String paramString) {}
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString) {}
  
  public void a(boolean paramBoolean, DatingConfig paramDatingConfig) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, DatingInfo paramDatingInfo, String paramString3) {}
  
  public void a(boolean paramBoolean, String paramString, DatingInfo paramDatingInfo, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, DatingInfo paramDatingInfo, String paramString2, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean1, List paramList1, List paramList2, long paramLong, boolean paramBoolean2, int paramInt, boolean paramBoolean3) {}
  
  public void a(boolean paramBoolean1, List paramList1, List paramList2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString, boolean paramBoolean4, boolean paramBoolean5) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt1, int paramInt2, DatingInfo paramDatingInfo) {}
  
  public void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean, int paramInt, ArrayList paramArrayList, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void b(boolean paramBoolean, List paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */