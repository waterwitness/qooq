import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.SystemBarCompact;

public class nyk
  implements Runnable
{
  public nyk(HotChatPie paramHotChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
    if (localObject != null)
    {
      localObject = (ChatFragment)((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      if ((localObject != null) && (((ChatFragment)localObject).a != null))
      {
        ((ChatFragment)localObject).a.a(this.a.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428295));
        ((ChatFragment)localObject).a.b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428295));
      }
      HotChatPie.a(this.a).setBackgroundColor(this.a.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428295));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */