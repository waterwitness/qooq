import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class mnb
  implements Runnable
{
  public mnb(SubAccountMessageActivity paramSubAccountMessageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SubAccountMessageActivity.a(this.a) != null) {
      SubAccountMessageActivity.a(this.a).H();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */