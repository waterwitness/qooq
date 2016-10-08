package com.tencent.component.network.module.report;

import android.util.SparseArray;

public class ExtendData
{
  public static final int EXTEND_POS_BUSINESS_REFER = 9;
  public static final int EXTEND_POS_DNS = 6;
  public static final int EXTEND_POS_DOWNLOAD_EXCEPTION = 11;
  public static final int EXTEND_POS_DOWNLOAD_EXTRAINFO = 10;
  public static final int EXTEND_POS_IS_SD_EXIST = 2;
  public static final int EXTEND_POS_IS_USB = 7;
  public static final int EXTEND_POS_MODEL = 0;
  public static final int EXTEND_POS_OS = 1;
  public static final int EXTEND_POS_SD_AVAIL = 4;
  public static final int EXTEND_POS_SD_TOTAL = 3;
  public static final int EXTEND_POS_TASK_STATE = 8;
  public static final int EXTEND_POS_UPLOAD_PATH = 5;
  private SparseArray<String> a = new SparseArray(12);
  
  public String getExtendString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)this.a.get(0, ""));
    int i = 1;
    for (;;)
    {
      if (i >= 12) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append("|");
      localStringBuilder.append((String)this.a.get(i, ""));
      i += 1;
    }
  }
  
  public void put(int paramInt, String paramString)
  {
    this.a.put(paramInt, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\report\ExtendData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */