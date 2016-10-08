import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import java.util.ArrayList;

public class wgf
  implements Runnable
{
  public wgf(VipFunCallPreviewActivity paramVipFunCallPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if (this.a.jdField_a_of_type_Boolean)
      {
        if ((this.a.g instanceof Button)) {
          ((Button)this.a.g).setText("已设置");
        }
        this.a.g.setEnabled(false);
        return;
      }
      this.a.g.setEnabled(true);
      return;
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.g.setVisibility(0);
      this.a.g.setEnabled(true);
      if ((this.a.g instanceof Button)) {
        ((Button)this.a.g).setText("已设置");
      }
      this.a.g.setEnabled(false);
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.a.f.setVisibility(8);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */