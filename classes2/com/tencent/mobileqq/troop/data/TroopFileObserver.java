package com.tencent.mobileqq.troop.data;

import java.util.List;

public abstract interface TroopFileObserver
{
  public abstract void a(int paramInt);
  
  public abstract void a(TroopFileInfo paramTroopFileInfo);
  
  public abstract void a(TroopFileInfo paramTroopFileInfo, String paramString);
  
  public abstract void a(List paramList, boolean paramBoolean, String paramString, long paramLong);
  
  public abstract void b(TroopFileInfo paramTroopFileInfo);
  
  public abstract void c(TroopFileInfo paramTroopFileInfo);
  
  public abstract void d(TroopFileInfo paramTroopFileInfo);
  
  public abstract void e(TroopFileInfo paramTroopFileInfo);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFileObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */