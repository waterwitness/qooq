package com.tencent.mobileqq.app;

import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.Pair;
import java.util.ArrayList;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigObserver
  implements BusinessObserver
{
  public ConfigObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
      return;
    case 2: 
      a(paramBoolean, (GetResourceRespInfo)paramObject);
      return;
    case 3: 
      a(paramBoolean, (String)paramObject);
      return;
    case 4: 
      a(paramBoolean, (UpgradeDetailWrapper)paramObject);
      return;
    case 5: 
      a(paramBoolean, (AppShareID)paramObject);
      return;
    case 6: 
      b(paramBoolean, ((GetResourceRespInfo)paramObject).uiNewVer);
      return;
    case 7: 
      a(paramBoolean, ((Integer)paramObject).intValue());
      return;
    case 8: 
      if ((paramObject != null) && ((paramObject instanceof OperateVoipTipsInfo)))
      {
        paramObject = (OperateVoipTipsInfo)paramObject;
        a(((OperateVoipTipsInfo)paramObject).uin, ((OperateVoipTipsInfo)paramObject).uinType, ((OperateVoipTipsInfo)paramObject).taskList);
      }
    case 9: 
      a(paramBoolean);
      return;
    case 10: 
      paramObject = (Pair)paramObject;
      a(paramBoolean, (String)((Pair)paramObject).first, (String)((Pair)paramObject).second);
      return;
    }
    a(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  protected void a(String paramString, int paramInt, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper) {}
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean, long paramLong) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ConfigObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */