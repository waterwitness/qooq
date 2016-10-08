package cooperation.readinjoy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyRemoteCommand
  extends RemoteCommand
{
  public static final int a = 1;
  public static final String a;
  public static final int b = 2;
  public static final String b = "com.tencent.qqreadinjoy.readinjoyremotecommand";
  public static final int c = 3;
  public static final String c = "param_data_type";
  public static final int d = 4;
  public static final String d = "param_sp_key";
  public static final int e = 5;
  public static final String e = "param_sp_value_type";
  public static final int f = 6;
  public static final String f = "param_uin";
  public static final int g = 7;
  public static final int h = 8;
  private QQAppInterface a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ReadInJoyRemoteCommand.class.getSimpleName();
  }
  
  public ReadInJoyRemoteCommand(QQAppInterface paramQQAppInterface)
  {
    super("com.tencent.qqreadinjoy.readinjoyremotecommand");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if ((localPluginCommunicationHandler != null) && (!localPluginCommunicationHandler.containsCmd("com.tencent.qqreadinjoy.readinjoyremotecommand"))) {
      localPluginCommunicationHandler.register(this);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
  }
  
  public void b()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if ((localPluginCommunicationHandler != null) && (localPluginCommunicationHandler.containsCmd("com.tencent.qqreadinjoy.readinjoyremotecommand"))) {
      localPluginCommunicationHandler.unregister("com.tencent.qqreadinjoy.readinjoyremotecommand");
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    boolean bool = true;
    int i = paramBundle.getInt("param_data_type", 0);
    paramOnInvokeFinishLinstener = new Bundle();
    switch (i)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          Object localObject;
          do
          {
            SharedPreferences localSharedPreferences;
            do
            {
              do
              {
                return paramOnInvokeFinishLinstener;
                localObject = paramBundle.getString("param_sp_key");
                paramBundle = paramBundle.getString("param_sp_value_type");
                localSharedPreferences = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
              } while (localSharedPreferences == null);
              try
              {
                if (paramBundle.equals("long"))
                {
                  paramOnInvokeFinishLinstener.putString("result_key", Long.toString(localSharedPreferences.getLong((String)localObject, 0L)));
                  return paramOnInvokeFinishLinstener;
                }
              }
              catch (ClassCastException paramBundle)
              {
                paramBundle.printStackTrace();
                return paramOnInvokeFinishLinstener;
              }
              if (paramBundle.equals("boolean"))
              {
                paramOnInvokeFinishLinstener.putString("result_key", Boolean.toString(localSharedPreferences.getBoolean((String)localObject, false)));
                return paramOnInvokeFinishLinstener;
              }
              if (paramBundle.equals("int"))
              {
                paramOnInvokeFinishLinstener.putString("result_key", Integer.toString(localSharedPreferences.getInt((String)localObject, 0)));
                return paramOnInvokeFinishLinstener;
              }
            } while (!paramBundle.equals("String"));
            paramOnInvokeFinishLinstener.putString("result_key", localSharedPreferences.getString((String)localObject, null));
            return paramOnInvokeFinishLinstener;
            paramBundle = paramBundle.getString("param_uin");
            ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
            paramOnInvokeFinishLinstener.putString("result_key", ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle));
            return paramOnInvokeFinishLinstener;
            paramBundle = paramBundle.getString("param_uin");
            paramOnInvokeFinishLinstener.putParcelable("result_key", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBundle, true));
            return paramOnInvokeFinishLinstener;
            paramBundle = paramBundle.getString("param_uin");
            localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          } while ((localObject == null) || (TextUtils.isEmpty(paramBundle)));
          paramBundle = ((FriendsManager)localObject).a(paramBundle);
        } while (paramBundle == null);
        paramOnInvokeFinishLinstener.putString("result_key", Short.toString(paramBundle.shGender));
        return paramOnInvokeFinishLinstener;
        paramBundle = paramBundle.getString("param_uin");
      } while (TextUtils.isEmpty(paramBundle));
      paramOnInvokeFinishLinstener.putString("result_key", Boolean.toString(PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle)));
      return paramOnInvokeFinishLinstener;
    case 6: 
      paramBundle = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((paramBundle != null) && (paramBundle.a == 0)) {}
      for (;;)
      {
        paramOnInvokeFinishLinstener.putString("result_key", Boolean.toString(bool));
        return paramOnInvokeFinishLinstener;
        bool = false;
      }
    case 7: 
      paramOnInvokeFinishLinstener.putString("result_key", ReadInJoyUtils.b());
      return paramOnInvokeFinishLinstener;
    }
    paramBundle = paramBundle.getString("param_uin");
    new PublicAccountUnfollowTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()).a();
    QLog.e(jdField_a_of_type_JavaLangString, 2, "handle remote unfollow public account request ! puin : " + paramBundle);
    paramOnInvokeFinishLinstener.putBoolean("result_key", true);
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\readinjoy\ReadInJoyRemoteCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */