package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.ptt.StreamParams;
import com.tencent.mobileqq.transfile.NetworkCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StreamFileInfo
{
  public static final int a = 0;
  public static final int b = 1;
  public long a;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private short jdField_a_of_type_Short;
  boolean jdField_a_of_type_Boolean;
  public long b;
  private short b;
  public final int c;
  private long jdField_c_of_type_Long;
  private short jdField_c_of_type_Short;
  private int d;
  private int e;
  
  public StreamFileInfo(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Short = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt2;
    this.jdField_c_of_type_Int = StreamParams.a(paramQQAppInterface, paramInt1, NetworkCenter.a().a());
    PttBuffer.a(paramString);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public File a()
  {
    return new File(this.jdField_a_of_type_JavaLangString);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public short a()
  {
    return this.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Short = 0;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(short paramShort)
  {
    this.b = paramShort;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      PttBuffer.b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    PttBuffer.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    PttBuffer.a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    PttBuffer.a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte, paramInt);
  }
  
  public int b()
  {
    return this.e;
  }
  
  public short b()
  {
    return this.jdField_c_of_type_Short;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void b(short paramShort)
  {
    this.jdField_c_of_type_Short = paramShort;
  }
  
  public short c()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public void c(short paramShort)
  {
    this.jdField_a_of_type_Short = paramShort;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\streamtransfile\StreamFileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */