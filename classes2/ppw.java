import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class ppw
  extends Handler
{
  public ppw(ApolloManager paramApolloManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == ApolloManager.a(this.a))
    {
      paramMessage = (VasExtensionHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (paramMessage != null)
      {
        localObject = new ArrayList(ApolloManager.jdField_a_of_type_JavaUtilVector.size());
        try
        {
          Iterator localIterator = ApolloManager.jdField_a_of_type_JavaUtilVector.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!((ArrayList)localObject).contains(str)) {
              ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(str)));
            }
          }
          return;
        }
        catch (Exception localException)
        {
          paramMessage.a((ArrayList)localObject, "troop");
          ApolloManager.jdField_a_of_type_JavaUtilVector.clear();
          localObject = ApolloManager.b.iterator();
          while (((Iterator)localObject).hasNext()) {
            paramMessage.b((String)((Iterator)localObject).next());
          }
          ApolloManager.b.clear();
        }
      }
    }
    while (paramMessage.what != ApolloManager.b(this.a)) {}
    Object localObject = (String)paramMessage.obj;
    if (paramMessage.arg1 == 1) {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!ApolloManager.jdField_a_of_type_JavaUtilVector.contains(localObject)))
      {
        ApolloManager.jdField_a_of_type_JavaUtilVector.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->dress uin:" + (String)localObject);
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(ApolloManager.a(this.a));
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(ApolloManager.a(this.a), 200L);
      return;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!ApolloManager.b.contains(localObject)))
      {
        ApolloManager.b.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->info uin:" + (String)localObject);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ppw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */