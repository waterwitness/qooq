package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class TroopAioAgent$Message
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public int d;
  
  public TroopAioAgent$Message()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Message a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.jdField_a_of_type_Int = TroopAioAgent.jdField_b_of_type_Int;
    localMessage.jdField_b_of_type_Int = paramInt;
    return localMessage;
  }
  
  public static Message a(int paramInt1, long paramLong, int paramInt2)
  {
    Message localMessage = new Message();
    localMessage.jdField_a_of_type_Int = TroopAioAgent.jdField_a_of_type_Int;
    if ((paramInt1 == 1) || (paramInt1 == 14) || (paramInt1 == 10)) {
      localMessage.jdField_a_of_type_Long = paramLong;
    }
    for (;;)
    {
      localMessage.c = paramInt1;
      localMessage.d = paramInt2;
      return localMessage;
      localMessage.jdField_b_of_type_Long = paramLong;
    }
  }
  
  public static Message b(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.jdField_a_of_type_Int = TroopAioAgent.c;
    localMessage.jdField_b_of_type_Int = paramInt;
    return localMessage;
  }
  
  public long a()
  {
    if ((this.c == 1) || (this.c == 14) || (this.c == 10)) {
      return this.jdField_a_of_type_Long;
    }
    return this.jdField_b_of_type_Long;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopAioAgent$Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */