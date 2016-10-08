package com.tencent.mqp.app.dbfs;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DBStoredFile
{
  Context jdField_a_of_type_AndroidContentContext;
  DBPathNode jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode;
  
  public DBStoredFile(Context paramContext, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode = new DBPathNode(paramContext, paramString);
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a()) {
      return this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a(paramArrayOfByte);
    }
    return 0;
  }
  
  public DBStoredFile.FileInputStream a()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a();
    if (arrayOfByte == null) {
      return null;
    }
    return new DBStoredFile.FileInputStream(this, arrayOfByte);
  }
  
  public DBStoredFile.FileOutputStream a()
  {
    return new DBStoredFile.FileOutputStream(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.b();
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a();
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMqpAppDbfsDBPathNode.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqp\app\dbfs\DBStoredFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */