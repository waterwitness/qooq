import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopreward.OrientationAdapterImageView;
import com.tencent.mobileqq.troopreward.RewardImageDetailView.RewardImageLoadTask;
import com.tencent.qphone.base.util.QLog;

public class vvu
  implements Runnable
{
  public vvu(RewardImageDetailView.RewardImageLoadTask paramRewardImageLoadTask, View paramView, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTrooprewardRewardImageDetailView$RewardImageLoadTask.g == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward.image", 2, "setBitmap, type=blur");
      }
      TransitionDrawable localTransitionDrawable = new TransitionDrawable(new Drawable[] { new ColorDrawable(Color.parseColor("#00000000")), new BitmapDrawable(this.jdField_a_of_type_AndroidViewView.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap) });
      localTransitionDrawable.setDither(true);
      localTransitionDrawable.setFilterBitmap(true);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localTransitionDrawable);
      localTransitionDrawable.startTransition(150);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward.image", 2, "setBitmap, type=clear");
    }
    ((OrientationAdapterImageView)this.jdField_a_of_type_AndroidViewView).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */