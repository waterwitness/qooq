import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.TouchProxyRelativeLayout;

class mcw
  implements Runnable
{
  mcw(mcv parammcv)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQLSActivity.a(this.a.a).removeView(QQLSActivity.a(this.a.a));
    QQLSActivity.a(this.a.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */