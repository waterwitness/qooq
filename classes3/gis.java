import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo.HeroDetail;
import com.tencent.av.guild.GameHeroesUi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gis
  implements Runnable
{
  public gis(GameHeroesUi paramGameHeroesUi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.a > 0))
    {
      this.a.f();
      this.a.e();
      if (this.a.b)
      {
        this.a.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.a.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.a.g();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */