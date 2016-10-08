import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class orz
  implements View.OnClickListener
{
  public orz(PhotoPreviewActivity paramPhotoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.b.isChecked())
    {
      if (this.a.a() > 0)
      {
        QQToast.a(this.a, this.a.getResources().getString(2131370138), 0).b(this.a.getResources().getDimensionPixelSize(2131492908));
        return;
      }
      this.a.b.setChecked(true);
      return;
    }
    this.a.b.setChecked(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\orz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */