package com.tencent.biz.qqstory.base.videoupload.job;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FileUploadRspData
{
  public static final String a = "retcode";
  public static final String b = "tips";
  public static final String c = "result";
  public static final String d = "w";
  public static final String e = "h";
  public static final String f = "url";
  public int a;
  public long a;
  public int b;
  public long b;
  public int c;
  public String g;
  public String h;
  public String i;
  
  public FileUploadRspData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("UploadRspData{");
    localStringBuffer.append("retCode=").append(this.a);
    localStringBuffer.append(", errorMsg='").append(this.g).append('\'');
    localStringBuffer.append(", picWidth=").append(this.b);
    localStringBuffer.append(", picHeight=").append(this.c);
    localStringBuffer.append(", url='").append(this.h).append('\'');
    localStringBuffer.append(", localPath='").append(this.i).append("'");
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\job\FileUploadRspData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */