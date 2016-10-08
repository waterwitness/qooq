import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mvc
  implements Runnable
{
  mvc(mvb parammvb, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopMemberListActivity.a(this.jdField_a_of_type_Mvb.a, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Boolean, 0, 0, this.jdField_b_of_type_JavaLangString, this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */