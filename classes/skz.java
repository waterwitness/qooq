import android.app.Activity;
import com.dataline.core.DirectForwarder;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class skz
  implements FMDialogUtil.FMDialogInterface
{
  skz(sky paramsky)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    DirectForwarder.b(this.a.a.jdField_a_of_type_AndroidAppActivity, 0);
    this.a.a.jdField_a_of_type_AndroidAppActivity.setResult(0, this.a.a.jdField_a_of_type_AndroidContentIntent);
    this.a.a.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void b()
  {
    this.a.a.jdField_a_of_type_AndroidAppActivity.setResult(0, this.a.a.jdField_a_of_type_AndroidContentIntent);
    this.a.a.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\skz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */