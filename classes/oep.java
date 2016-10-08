import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oep
  implements Runnable
{
  public oep(GamePartyTipsBar paramGamePartyTipsBar, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    GamePartyTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGamePartyTipsBar).setText(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */