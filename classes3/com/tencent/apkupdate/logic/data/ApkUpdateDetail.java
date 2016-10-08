package com.tencent.apkupdate.logic.data;

public class ApkUpdateDetail
{
  public static final int UpdateMethod_ByPatch = 4;
  public static final int UpdateMethod_GenPatch = 3;
  public static final int UpdateMethod_NoUpdate = 1;
  public static final int UpdateMethod_NoneRecord = 0;
  public static final int UpdateMethod_Normal = 2;
  public String fileMd5;
  public String newFeature;
  public int newapksize;
  public String packageName;
  public int patchsize;
  public String sigMd5;
  public int updatemethod;
  public String url;
  public int versioncode;
  public String versionname;
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\apkupdate\logic\data\ApkUpdateDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */