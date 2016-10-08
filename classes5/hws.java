import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hws
  extends ReadInJoyObserver
{
  public hws(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void b(int paramInt)
  {
    ReadInJoyFeedsActivity.a(this.a, paramInt);
  }
  
  public void c(int paramInt)
  {
    if (ReadInJoyFeedsActivity.a(this.a) == 1)
    {
      ((KandianMergeManager)this.a.app.getManager(161)).a(1);
      return;
    }
    ReadInJoyFeedsActivity.b(this.a, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */