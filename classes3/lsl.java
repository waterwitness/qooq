import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;

class lsl
  implements Runnable
{
  lsl(lsk paramlsk, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Lsk.a.b.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_Lsk.a.b.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Lsk.a.b.setOnCheckedChangeListener(this.jdField_a_of_type_Lsk.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */