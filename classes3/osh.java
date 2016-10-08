import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;

public class osh
  implements View.OnClickListener
{
  public osh(PhotoPreviewActivity paramPhotoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.n) {
      ReportController.b(null, "CliOper", "", "", "0X8004D94", "0X8004D94", 0, 0, "", "", "", "");
    }
    if (("FROM_PHOTO_LIST_FLOW".equals(this.a.j)) && (this.a.l)) {
      this.a.setResult(-1);
    }
    this.a.finish();
    AlbumUtil.a(this.a, true, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */