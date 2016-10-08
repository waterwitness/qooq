import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import java.util.ArrayList;

class umx
  extends FriendListObserver
{
  umx(umw paramumw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong)
  {
    NetSearchEngine.a(this.a.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine).b(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (umw.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt1 != 88) || (paramBoolean2));
        if (!paramBoolean1) {
          break;
        }
      } while (!(paramObject instanceof ArrayList));
      ThreadManager.a(new umy(this.a.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine, umw.a(this.a), (ArrayList)paramObject, umw.a(this.a)), 10, null, true);
      return;
    } while (umw.a(this.a) == null);
    umw.a(this.a).a(null, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\umx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */