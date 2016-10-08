import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.PokeItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PokeItemBuilder.Holder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nne
  implements Runnable
{
  public nne(PokeItemBuilder paramPokeItemBuilder, PokeItemBuilder.Holder paramHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.b.startAnimation(localAlphaAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */