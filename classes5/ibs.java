import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ibs
  implements Runnable
{
  ibs(ibj paramibj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
    ReadInJoyBaseAdapter.a(this.a.a, this.a.a.a, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */