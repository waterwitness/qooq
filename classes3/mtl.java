import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class mtl
  implements BounceScrollView.OnScrollChangedListener
{
  public mtl(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a.jdField_b_of_type_AndroidWidgetTextView == null) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      Object localObject1;
      if ((paramInt2 > paramInt4) && (paramInt2 >= this.a.I) && (this.a.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
        localObject1 = this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
      }
      while ((localObject1 != null) && (localObject1 != this.a.jdField_b_of_type_AndroidWidgetTextView.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.a.jdField_b_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject1);
        this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation((Animation)localObject1);
        return;
        localObject1 = localObject2;
        if (paramInt2 < paramInt4)
        {
          localObject1 = localObject2;
          if (paramInt2 <= this.a.I)
          {
            localObject1 = localObject2;
            if (this.a.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
              localObject1 = this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */