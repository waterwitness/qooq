import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sfr
  implements Runnable
{
  sfr(sfq paramsfq, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = "/" + LocalVideoFileView.a(this.jdField_a_of_type_Sfq.a.a, this.jdField_a_of_type_Int);
    LocalVideoFileView.b(this.jdField_a_of_type_Sfq.a.a).setText(str);
    LocalVideoFileView.a(this.jdField_a_of_type_Sfq.a.a).setMax(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */