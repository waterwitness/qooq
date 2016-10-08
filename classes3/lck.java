import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lck
  implements Runnable
{
  lck(lch paramlch, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (Conversation.a(this.jdField_a_of_type_Lch.a) != null)
    {
      Conversation.a(this.jdField_a_of_type_Lch.a).a(this.jdField_a_of_type_Lch.a.a, this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Boolean) {
        Conversation.a(this.jdField_a_of_type_Lch.a).a(true, true, Conversation.a(this.jdField_a_of_type_Lch.a));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */