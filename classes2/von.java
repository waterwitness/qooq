import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;

public class von
  implements View.OnClickListener
{
  public von(TVKTroopVideoManager paramTVKTroopVideoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.h == -1) {
      this.a.b = true;
    }
    if ((this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.a.h != 0) && (this.a.h != 1) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)) {
      TVKTroopVideoManager.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\von.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */