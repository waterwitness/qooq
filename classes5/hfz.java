import android.os.Bundle;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;
import com.tencent.biz.addContactTroopView.AddContactTroopManage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.BusinessObserver;
import tencent.im.troop_search_searchtab.searchtab.RspBody;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class hfz
  implements BusinessObserver
{
  public hfz(AddContactTroopHandler paramAddContactTroopHandler, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      try
      {
        Object localObject = paramBundle.getByteArray("data");
        if (localObject != null)
        {
          paramBundle = new searchtab.RspBody();
          paramBundle.mergeFrom((byte[])localObject);
          localObject = (AddContactTroopManage)this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler.a.getManager(79);
          troopviewInfo.RspBody localRspBody = ((AddContactTroopManage)localObject).a();
          localRspBody.searchRsb = new searchtab.RspBody();
          localRspBody.searchRsb.set(paramBundle);
          ((AddContactTroopManage)localObject).a(localRspBody);
          this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB.a();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */