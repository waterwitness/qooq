import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StartupTracker;

public class qty
  implements Runnable
{
  public qty(BubbleManager paramBubbleManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StartupTracker.a(null, "AIO_bubble_craete_bubble_info");
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_a_of_type_Int, true);
    StartupTracker.a("AIO_bubble_craete_bubble_info", null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */