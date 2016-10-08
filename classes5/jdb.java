import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.biz.apiproxy.QQMusicClient;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.data.DingdongOfficeOpenClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class jdb
  extends Handler
{
  public jdb(TroopMemberApiClient paramTroopMemberApiClient)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Object localObject1;
    int i;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              int j;
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    do
                                                    {
                                                      do
                                                      {
                                                        do
                                                        {
                                                          do
                                                          {
                                                            do
                                                            {
                                                              do
                                                              {
                                                                do
                                                                {
                                                                  do
                                                                  {
                                                                    return;
                                                                    localObject1 = paramMessage.getData();
                                                                  } while (localObject1 == null);
                                                                  i = ((Bundle)localObject1).getInt("seq", -1);
                                                                  switch (paramMessage.what)
                                                                  {
                                                                  case 6: 
                                                                  case 9: 
                                                                  case 10: 
                                                                  case 12: 
                                                                  case 21: 
                                                                  case 22: 
                                                                  case 27: 
                                                                  case 29: 
                                                                  case 30: 
                                                                  case 31: 
                                                                  case 33: 
                                                                  case 34: 
                                                                  case 35: 
                                                                  case 36: 
                                                                  case 37: 
                                                                  case 38: 
                                                                  case 39: 
                                                                  case 40: 
                                                                  case 41: 
                                                                  case 44: 
                                                                  case 46: 
                                                                  case 48: 
                                                                  case 49: 
                                                                  case 50: 
                                                                  case 52: 
                                                                  case 53: 
                                                                  case 61: 
                                                                  default: 
                                                                    return;
                                                                  case 3: 
                                                                    i = ((Bundle)localObject1).getInt("type");
                                                                    boolean bool = ((Bundle)localObject1).getBoolean("isSuccess", false);
                                                                    paramMessage = ((Bundle)localObject1).getSerializable("data");
                                                                    j = ((Bundle)localObject1).getInt("observer_type");
                                                                    localObject1 = this.a.jdField_a_of_type_JavaUtilList.iterator();
                                                                    while (((Iterator)localObject1).hasNext())
                                                                    {
                                                                      localObject2 = (BusinessObserver)((Iterator)localObject1).next();
                                                                      if (((j == 1) && ((localObject2 instanceof LBSObserver))) || ((j == 2) && ((localObject2 instanceof FriendListObserver)))) {
                                                                        ((BusinessObserver)localObject2).a(i, bool, paramMessage);
                                                                      } else if ((j == 3) && ((localObject2 instanceof TroopObserver))) {
                                                                        ((TroopObserver)localObject2).a(i, bool, paramMessage);
                                                                      } else if ((j == 4) && ((localObject2 instanceof BizTroopObserver))) {
                                                                        ((BizTroopObserver)localObject2).a(i, bool, paramMessage);
                                                                      }
                                                                    }
                                                                  }
                                                                } while (i == -1);
                                                                paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
                                                              } while (paramMessage == null);
                                                              paramMessage.a((Bundle)localObject1);
                                                              return;
                                                            } while (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver == null);
                                                            paramMessage = ((Bundle)localObject1).getString("pageUrl");
                                                            localObject2 = ((Bundle)localObject1).getStringArrayList("lstVideoUrl");
                                                            i = ((Bundle)localObject1).getInt("totalTime", 0);
                                                            this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver.a(((Bundle)localObject1).getInt("type"), true, new Object[] { paramMessage, localObject2, Integer.valueOf(i) });
                                                            return;
                                                            this.a.a().a((Bundle)localObject1);
                                                            return;
                                                            localObject2 = (BusinessObserver)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(((Bundle)localObject1).getInt("req_seq"));
                                                          } while (localObject2 == null);
                                                          this.a.jdField_a_of_type_AndroidUtilSparseArray.remove(((Bundle)localObject1).getInt("req_seq"));
                                                          ((BusinessObserver)localObject2).a(paramMessage.what, true, localObject1);
                                                          return;
                                                        } while (localObject1 == null);
                                                        i = ((Bundle)localObject1).getInt("seq1", -1);
                                                      } while (i == -1);
                                                      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
                                                    } while (paramMessage == null);
                                                    paramMessage.a((Bundle)localObject1);
                                                    return;
                                                  } while (localObject1 == null);
                                                  i = ((Bundle)localObject1).getInt("seq", -1);
                                                } while (i == -1);
                                                paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
                                              } while (paramMessage == null);
                                              paramMessage.a((Bundle)localObject1);
                                              return;
                                            } while (localObject1 == null);
                                            i = ((Bundle)localObject1).getInt("seq1", -1);
                                          } while (i == -1);
                                          paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
                                        } while (paramMessage == null);
                                        paramMessage.a((Bundle)localObject1);
                                        return;
                                      } while (localObject1 == null);
                                      i = ((Bundle)localObject1).getInt("seq", -1);
                                    } while (i == -1);
                                    paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
                                  } while (paramMessage == null);
                                  paramMessage.a((Bundle)localObject1);
                                  return;
                                  paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
                                } while ((i == -1) || (paramMessage == null));
                                paramMessage.a((Bundle)localObject1);
                                return;
                                this.a.a().a((Bundle)localObject1);
                                return;
                              } while (localObject1 == null);
                              i = ((Bundle)localObject1).getInt("seq", -1);
                            } while (i == -1);
                            paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
                          } while (paramMessage == null);
                          paramMessage.a((Bundle)localObject1);
                          return;
                        } while (i == -1);
                        paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
                      } while (paramMessage == null);
                      paramMessage.a((Bundle)localObject1);
                      return;
                      paramMessage = ((Bundle)localObject1).getString("FileName");
                      i = ((Bundle)localObject1).getInt("Status");
                    } while ((TroopMemberApiClient.a(this.a) == null) || (paramMessage == null) || (TroopMemberApiClient.a(this.a).get(paramMessage) == null));
                    j = ((Integer)TroopMemberApiClient.a(this.a).get(paramMessage)).intValue();
                  } while (j == -1);
                  paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
                } while (paramMessage == null);
                paramMessage.a((Bundle)localObject1);
              } while (i != 11);
              this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(j));
              return;
              paramMessage = ((Bundle)localObject1).getString("FileName");
            } while ((TroopMemberApiClient.b(this.a) == null) || (paramMessage == null) || (TroopMemberApiClient.b(this.a).get(paramMessage) == null));
            i = ((Integer)TroopMemberApiClient.b(this.a).get(paramMessage)).intValue();
          } while (i == -1);
          paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
        } while (paramMessage == null);
        paramMessage.a((Bundle)localObject1);
        return;
      } while (i == -1);
      paramMessage = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
    } while (paramMessage == null);
    paramMessage.a((Bundle)localObject1);
    return;
    if (i != -1)
    {
      localObject2 = (TroopMemberApiClient.Callback)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (localObject2 != null) {
        ((TroopMemberApiClient.Callback)localObject2).a((Bundle)localObject1);
      }
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */