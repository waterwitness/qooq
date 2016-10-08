import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqn
  implements Runnable
{
  public yqn(RecordSVInteractActivity paramRecordSVInteractActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((!this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity.isFinishing()) && (this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity.getResources().getText(this.jdField_a_of_type_Int).equals(RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).getText()))) {
      RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */