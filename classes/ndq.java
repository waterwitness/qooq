import com.tencent.mobileqq.activity.aio.PanelAdapter;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ndq
  implements Runnable
{
  public ndq(PlusPanel paramPlusPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    while (i < this.a.a.getCount())
    {
      this.a.a.c(i);
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */