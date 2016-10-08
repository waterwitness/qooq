import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mca
  implements DialogInterface.OnClickListener
{
  mca(mbz parammbz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.a.jdField_a_of_type_Mby.a.app.a().b(this.a.jdField_a_of_type_Mby.a.a(), 0, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_Mby.a.b();
      return;
    } while (this.a.jdField_a_of_type_Mby.a.jdField_a_of_type_Mby.getCount() <= 0);
    this.a.jdField_a_of_type_Mby.a.app.a().a(this.a.jdField_a_of_type_Mby.a.a(), 0);
    this.a.jdField_a_of_type_Mby.a.jdField_a_of_type_Mby.changeCursor(this.a.jdField_a_of_type_Mby.getCursor());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */