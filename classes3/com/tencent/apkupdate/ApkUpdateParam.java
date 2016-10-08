package com.tencent.apkupdate;

public class ApkUpdateParam
{
  public int actionFlag;
  public String packageName;
  public int targetGrayVersionCode;
  public int targetVersionCode;
  
  public ApkUpdateParam(String paramString, int paramInt1, int paramInt2)
  {
    this.packageName = paramString;
    this.actionFlag = paramInt1;
    this.targetVersionCode = paramInt2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\apkupdate\ApkUpdateParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */