import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneClickReport;

public class osb
  implements View.OnClickListener
{
  public osb(PhotoPreviewActivity paramPhotoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.f();
    QZoneClickReport.report(this.a.g, "603", "3", "", this.a.t, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */