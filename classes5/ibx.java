import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.PrefetchListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ibx
  implements ReadInJoyBaseAdapter.PrefetchListener
{
  public ibx(ReadInJoyListViewGroup paramReadInJoyListViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    ReadInJoyListViewGroup.a(this.a, true);
    this.a.b(ReadInJoyListViewGroup.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */