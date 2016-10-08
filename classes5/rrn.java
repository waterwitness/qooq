import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.IWeiYunImageEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rrn
  implements QfileCloudFileTabView.IWeiYunImageEvent
{
  public rrn(QfileCloudFileTabView paramQfileCloudFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View.OnClickListener a(TextView paramTextView)
  {
    this.a.jdField_c_of_type_AndroidWidgetTextView = paramTextView;
    return new rro(this);
  }
  
  public boolean a()
  {
    return this.a.d;
  }
  
  public boolean b()
  {
    return this.a.jdField_c_of_type_Boolean;
  }
  
  public boolean c()
  {
    return QfileCloudFileTabView.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */