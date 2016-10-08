import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jkd
  implements Runnable
{
  jkb jdField_a_of_type_Jkb;
  
  public jkd(XChooserActivity paramXChooserActivity, jkb paramjkb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Jkb = paramjkb;
  }
  
  public void run()
  {
    if ((!this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.isFinishing()) && (this.jdField_a_of_type_Jkb.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_Jkb.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.a(this.jdField_a_of_type_Jkb.jdField_a_of_type_AndroidContentPmResolveInfo);
      this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jkd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */