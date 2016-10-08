package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TroopFileManager$FileManagerStatus
{
  public int a;
  public long a;
  public ByteStringMicro a;
  public List a;
  public Map a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public int d;
  
  public TroopFileManager$FileManagerStatus(TroopFileManager paramTroopFileManager, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.d = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = ByteStringMicro.copyFromUtf8("");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    if (paramLong == 0L) {
      this.c = 0;
    }
    for (;;)
    {
      this.c = i;
      return;
      i = 3;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileManager$FileManagerStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */