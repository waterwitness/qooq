import android.app.Dialog;
import android.widget.ImageView;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class req
  implements Runnable
{
  req(rep paramrep)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.b != null) && (this.a.a.b.isShowing()))
    {
      ImageView localImageView1 = (ImageView)this.a.a.b.findViewById(2131302324);
      ImageView localImageView2 = (ImageView)this.a.a.b.findViewById(2131302325);
      ImageView localImageView3 = (ImageView)this.a.a.b.findViewById(2131302326);
      if (localImageView1 != null) {
        localImageView1.setImageResource(2130841147);
      }
      if (localImageView2 != null) {
        localImageView2.setImageResource(2130841148);
      }
      if (localImageView3 != null) {
        localImageView3.setImageResource(2130841149);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */