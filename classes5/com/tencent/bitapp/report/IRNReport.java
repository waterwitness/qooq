package com.tencent.bitapp.report;

public abstract interface IRNReport
{
  public abstract void addStageFlag(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void reportStageEnd(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void reportStageStart(String paramString, int paramInt);
  
  public abstract void reportStageStepEnd(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void reportStageStepStart(String paramString, int paramInt1, int paramInt2);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\report\IRNReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */