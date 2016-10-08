import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTagsContainer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iby
  extends ReadInJoyObserver
{
  public iby(ReadInJoyListViewGroup paramReadInJoyListViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    ReadInJoyListViewGroup.a(this.a).post(new ibz(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */