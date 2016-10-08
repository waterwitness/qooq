import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kxe
  implements Runnable
{
  kxe(kxd paramkxd, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ChatHistoryForC2C.c(this.jdField_a_of_type_Kxd.a.a);
    if (this.jdField_a_of_type_Boolean)
    {
      ChatHistoryForC2C.b(this.jdField_a_of_type_Kxd.a.a, false);
      return;
    }
    ChatHistoryForC2C.b(this.jdField_a_of_type_Kxd.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */