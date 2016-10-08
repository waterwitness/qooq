import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.GVideoUpdateUtil.OnGVideoUpdateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class haz
  implements DialogInterface.OnClickListener
{
  public haz(GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener, Context paramContext, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentAvUtilsGVideoUpdateUtil$OnGVideoUpdateListener.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\haz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */