import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sgx
  implements Runnable
{
  sgx(sgw paramsgw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if ((this.a.a.jdField_a_of_type_AndroidWidgetTextView != null) && (this.a.a.b != null))
    {
      this.a.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.a.a.b.setVisibility(8);
    }
    if (TroopLocalVideoFileView.a(this.a.a) != null) {
      TroopLocalVideoFileView.b(this.a.a).a(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */