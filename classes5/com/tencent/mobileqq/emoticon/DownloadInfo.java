package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.net.HttpURLConnection;

public class DownloadInfo
{
  public final int a;
  public final File a;
  public final String a;
  public HttpURLConnection a;
  public boolean a;
  public byte[] a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public DownloadInfo(String paramString, File paramFile, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = -1;
    this.c = -1;
    this.g = "";
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + ".tmp";
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = false;
    this.d = null;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = null;
    this.c = -1;
    this.jdField_e_of_type_Int = 0;
    this.i = null;
    this.j = null;
    this.h = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticon\DownloadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */