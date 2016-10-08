import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ldc
  extends AVObserver
{
  public ldc(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt, long paramLong)
  {
    paramInt = UITools.b(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
    this.a.s();
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = UITools.b(paramInt);
    this.a.a(8, Long.toString(paramLong1), paramInt);
    this.a.s();
    this.a.b(paramLong1);
    this.a.b(new ldd(this, paramLong1));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, paramInt);
    this.a.b(new ldg(this));
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    this.a.b(new ldi(this));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    this.a.b(new ldh(this));
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a(paramBoolean, paramString);
    }
  }
  
  protected void b(int paramInt, long paramLong)
  {
    paramInt = UITools.b(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
    this.a.s();
  }
  
  protected void b(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.a()).longValue()) {
      this.a.b(new lde(this, paramLong1));
    }
  }
  
  protected void c(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.a()).longValue()) {
      this.a.b(new ldf(this, paramLong1));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */