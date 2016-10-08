import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class aa
  extends DataLineObserver
{
  public aa(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    this.a.runOnUiThread(new ac(this));
  }
  
  protected void a(int paramInt, String paramString, long paramLong)
  {
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (Build.VERSION.SDK_INT < 11)
    {
      this.a.runOnUiThread(new ai(this, paramString, paramInt));
      return;
    }
    this.a.runOnUiThread(new aj(this, paramString, paramInt));
  }
  
  protected void a(long paramLong)
  {
    this.a.runOnUiThread(new ak(this));
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    this.a.runOnUiThread(new ae(this, paramLong, paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
    this.a.runOnUiThread(new af(this, paramInt, paramLong1));
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    super.a(paramBoolean, paramLong);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.a.runOnUiThread(new ad(this, paramBoolean, i, paramLong, paramString));
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong.longValue());
    this.a.runOnUiThread(new ah(this, i));
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
    this.a.runOnUiThread(new ag(this, paramInt, paramLong1));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.a.runOnUiThread(new ab(this, i, paramLong, paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */