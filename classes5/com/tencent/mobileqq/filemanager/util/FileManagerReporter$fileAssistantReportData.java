package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FileManagerReporter$fileAssistantReportData
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public String c;
  public String d;
  private String e;
  
  public FileManagerReporter$fileAssistantReportData()
  {
    this.jdField_a_of_type_JavaLangString = "share_file";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public FileManagerReporter$fileAssistantReportData(String paramString1, int paramInt, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "share_file";
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString2;
    this.jdField_a_of_type_Long = paramLong1;
    this.e = FileManagerUtil.a(paramLong1);
    this.d = paramString3;
    this.jdField_b_of_type_Long = paramLong2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\FileManagerReporter$fileAssistantReportData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */