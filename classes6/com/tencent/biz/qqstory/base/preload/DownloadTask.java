package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DownloadTask
  implements Copyable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public long a;
  public Object a;
  public String a;
  public String b;
  public String c;
  public String d;
  public int f;
  public int g;
  
  public DownloadTask()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = 0;
  }
  
  public static DownloadTask a(String paramString1, String paramString2, int paramInt)
  {
    DownloadTask localDownloadTask = new DownloadTask();
    localDownloadTask.jdField_a_of_type_JavaLangString = paramString1;
    localDownloadTask.d = PreloadUtils.a(paramString1, paramInt);
    localDownloadTask.f = paramInt;
    localDownloadTask.b = paramString2;
    return localDownloadTask;
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof DownloadTask))
    {
      this.jdField_a_of_type_JavaLangString = ((DownloadTask)paramObject).jdField_a_of_type_JavaLangString;
      this.g = ((DownloadTask)paramObject).g;
      this.c = ((DownloadTask)paramObject).c;
      this.b = ((DownloadTask)paramObject).b;
      this.f = ((DownloadTask)paramObject).f;
      this.d = ((DownloadTask)paramObject).d;
      this.jdField_a_of_type_Long = ((DownloadTask)paramObject).jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaLangObject = ((DownloadTask)paramObject).jdField_a_of_type_JavaLangObject;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof DownloadTask)) && (this.jdField_a_of_type_JavaLangString.equals(((DownloadTask)paramObject).jdField_a_of_type_JavaLangString));
  }
  
  public String toString()
  {
    return "DownloadTask{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", status=" + this.g + ", downloadPath=" + this.b + ", localPath=" + this.c + ", fileType=" + this.f + ", fileName=" + this.d + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\DownloadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */