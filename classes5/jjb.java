import android.os.Handler;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class jjb
  implements Runnable
{
  jjb(jja paramjja, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (ScannerView.b(this.jdField_a_of_type_Jja.a)))
    {
      if (ScannerView.a(this.jdField_a_of_type_Jja.a) != null) {
        ScannerView.a(this.jdField_a_of_type_Jja.a).a();
      }
      this.jdField_a_of_type_Jja.a.b.sendEmptyMessage(7);
      return;
    }
    this.jdField_a_of_type_Jja.a.b.sendEmptyMessage(8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */