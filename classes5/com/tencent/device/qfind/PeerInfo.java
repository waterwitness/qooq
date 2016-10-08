package com.tencent.device.qfind;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class PeerInfo
{
  private static int e;
  public int a;
  public long a;
  public String a;
  public List a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public boolean e;
  public boolean f;
  
  public PeerInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    e += 1;
    this.jdField_a_of_type_Int = e;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.c = 0;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString.replaceAll(":", "") + "0000";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\qfind\PeerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */