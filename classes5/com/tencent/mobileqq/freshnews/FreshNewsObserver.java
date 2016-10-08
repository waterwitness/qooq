package com.tencent.mobileqq.freshnews;

import appoint.define.appoint_define.FeedInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class FreshNewsObserver
  implements BusinessObserver
{
  public FreshNewsObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return;
    case 0: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), (List)paramObject[2], ((Boolean)paramObject[3]).booleanValue(), (byte[])paramObject[1], (String)paramObject[0]);
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
      return;
    case 10: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (byte[])paramObject[1], (List)paramObject[2], ((Boolean)paramObject[3]).booleanValue(), ((Boolean)paramObject[4]).booleanValue());
      return;
    case 11: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), (List)paramObject[2]);
      return;
    case 20: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (FreshNewsInfo)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Long)paramObject[4]).longValue());
      return;
    case 21: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1], (List)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
      return;
    case 22: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (List)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
      return;
    case 23: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4]);
      return;
    case 24: 
      a(paramBoolean, (appoint_define.FeedInfo)paramObject);
      return;
    case 25: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), (byte[])paramObject[2], (String)paramObject[3], ((Boolean)paramObject[4]).booleanValue());
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
  }
  
  protected void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, appoint_define.FeedInfo paramFeedInfo) {}
  
  public void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong, List paramList) {}
  
  public void a(boolean paramBoolean, String paramString1, FreshNewsInfo paramFreshNewsInfo, String paramString2, int paramInt, long paramLong) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, List paramList, int paramInt1, int paramInt2, String paramString3) {}
  
  public void a(boolean paramBoolean, String paramString1, List paramList, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(boolean paramBoolean1, String paramString, byte[] paramArrayOfByte, List paramList, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void a(boolean paramBoolean1, List paramList, int paramInt, byte[] paramArrayOfByte, String paramString, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List paramList, boolean paramBoolean4, byte[] paramArrayOfByte, String paramString) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */