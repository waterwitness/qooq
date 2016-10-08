import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class hwh
  extends ReadInJoyObserver
{
  public hwh(ReadInJoyChannelViewController paramReadInJoyChannelViewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramBoolean, paramInt, paramList);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void b(int paramInt, List paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).b(paramInt, paramList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hwh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */