import android.widget.TextView;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;

public class lvh
  extends FriendListObserver
{
  public lvh(ModifyFriendInfoActivity paramModifyFriendInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((paramString != null) && (paramString.equals(this.a.jdField_a_of_type_JavaLangString)))
    {
      this.a.jdField_a_of_type_Int = paramByte1;
      return;
    }
    this.a.a();
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean)
    {
      this.a.c = paramString2;
      this.a.jdField_b_of_type_JavaLangString = ContactUtils.j(this.a.app, this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.c);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */