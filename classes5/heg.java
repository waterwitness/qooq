import com.tencent.biz.JoinGroupHandler;
import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class heg
  extends TroopObserver
{
  public heg(JoinGroupHandler paramJoinGroupHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramLong != this.a.jdField_a_of_type_Long) {
      return;
    }
    this.a.jdField_a_of_type_Long = 0L;
    JoinGroupHandler.a(this.a);
    if (paramBoolean)
    {
      JoinGroupHandler.a(this.a, paramTroopInfo);
      return;
    }
    JoinGroupHandler.a(this.a, 2131368656, 1);
    this.a.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\heg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */