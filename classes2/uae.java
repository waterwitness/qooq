import android.text.TextUtils;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy.QueryRecentCallsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uae
  implements QCallProxy.QueryRecentCallsListener
{
  public uae(QCallFacade paramQCallFacade, QCallProxy.QueryRecentCallsListener paramQueryRecentCallsListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy$QueryRecentCallsListener != null)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QCallRecent localQCallRecent = (QCallRecent)paramList.next();
          if (localQCallRecent.type == 3000)
          {
            if ((TextUtils.isEmpty(localQCallRecent.pstnInfo)) || ((!TextUtils.isEmpty(localQCallRecent.pstnInfo)) && (localQCallRecent.pstnInfo.equals("[]")))) {
              localArrayList.add(localQCallRecent);
            }
          }
          else if (localQCallRecent.callType != 2) {
            localArrayList.add(localQCallRecent);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy$QueryRecentCallsListener.a(localArrayList);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */