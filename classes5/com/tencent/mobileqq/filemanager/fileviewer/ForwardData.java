package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ForwardData
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  public ForwardData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ForwardData a(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("targetUin");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("srcDiscGroup");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("peerType", 0);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("rootEntrace", true);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("busiType", 0);
    this.c = paramIntent.getIntExtra("enterfrom", 0);
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\fileviewer\ForwardData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */