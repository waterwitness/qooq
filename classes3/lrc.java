import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lrc
  implements Runnable
{
  lrc(lrb paramlrb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((Leba.a(this.a.a) != null) && (this.a.a.a != null)) {
      this.a.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */