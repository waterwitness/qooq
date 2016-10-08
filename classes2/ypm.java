import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.share.QZoneShareActivity;

public class ypm
  implements Runnable
{
  public ypm(QZoneShareActivity paramQZoneShareActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842737);
    this.a.c = true;
    this.a.d = false;
    QZoneShareActivity.a(this.a, this.a.c);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */