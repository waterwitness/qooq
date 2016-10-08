package cooperation.comic;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class PluginRedTouchRemoteCommand
  extends RemoteCommand
{
  public static final String a = "PluginRedTouchRemoteCommand";
  public static final String b = "redtouchipccmd";
  public static final String c = "Remotecall_getRedTouchInfo";
  public static final String d = "Remotecall_getMultiRedTouchInfo";
  public static final String e = "Remotecall_reportRedTouchExposure";
  public static final String f = "Remotecall_reportMultiRedTouchExposure";
  public static final String g = "Remotecall_reportRedTouchClick";
  public static final String h = "Remotecall_isLebaItemOpen";
  public static final String i = "path";
  public static final String j = "pathList";
  public static final String k = "redTouchInfo";
  public static final String l = "redTouchInfoList";
  public static final String m = "appId";
  public static final String n = "isLebaItemOpen";
  private boolean a;
  
  public PluginRedTouchRemoteCommand(String paramString, boolean paramBoolean)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBoolean;
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Object localObject1 = BaseApplicationImpl.a().a();
    if (!(localObject1 instanceof QQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("PluginRedTouchRemoteCommand", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
    }
    Object localObject2;
    do
    {
      return null;
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = paramBundle.getString("redtouchipccmd");
      if (!"Remotecall_getRedTouchInfo".equals(localObject2)) {
        break;
      }
      localObject1 = (RedTouchManager)((QQAppInterface)localObject1).getManager(35);
      paramBundle = paramBundle.getString("path");
    } while ((localObject1 == null) || (paramBundle == null));
    paramBundle = ((RedTouchManager)localObject1).a(paramBundle);
    if (paramBundle != null) {}
    for (paramBundle = RedTouchUtils.a(paramBundle);; paramBundle = null)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelable("redTouchInfo", paramBundle);
      return (Bundle)localObject1;
      if ("Remotecall_getMultiRedTouchInfo".equals(localObject2))
      {
        localObject1 = (RedTouchManager)((QQAppInterface)localObject1).getManager(35);
        localObject2 = paramBundle.getStringArrayList("pathList");
        if ((localObject1 == null) || (localObject2 == null)) {
          break;
        }
        paramBundle = new ArrayList();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject1).a((String)((Iterator)localObject2).next());
          if (localAppInfo != null) {
            paramBundle.add(RedTouchUtils.a(localAppInfo));
          }
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putParcelableArrayList("redTouchInfoList", paramBundle);
        return (Bundle)localObject1;
      }
      if ("Remotecall_reportRedTouchExposure".equals(localObject2))
      {
        localObject1 = (RedTouchManager)((QQAppInterface)localObject1).getManager(35);
        paramBundle = paramBundle.getString("path");
        if ((localObject1 == null) || (paramBundle == null)) {
          break;
        }
        ((RedTouchManager)localObject1).a(((RedTouchManager)localObject1).a(paramBundle));
        return null;
      }
      if ("Remotecall_reportMultiRedTouchExposure".equals(localObject2))
      {
        localObject1 = (RedTouchManager)((QQAppInterface)localObject1).getManager(35);
        paramBundle = paramBundle.getStringArrayList("pathList");
        if ((localObject1 == null) || (paramBundle == null)) {
          break;
        }
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext()) {
          ((RedTouchManager)localObject1).a(((RedTouchManager)localObject1).a((String)paramBundle.next()));
        }
        break;
      }
      if ("Remotecall_reportRedTouchClick".equals(localObject2))
      {
        localObject1 = (RedTouchManager)((QQAppInterface)localObject1).getManager(35);
        paramBundle = paramBundle.getString("path");
        if ((localObject1 == null) || (paramBundle == null)) {
          break;
        }
        ((RedTouchManager)localObject1).b(paramBundle);
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("service_type", 2);
          ((JSONObject)localObject2).put("act_id", 1002);
          ((RedTouchManager)localObject1).b(((RedTouchManager)localObject1).a(paramBundle), ((JSONObject)localObject2).toString());
          return null;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return null;
        }
      }
      int i1;
      if ("Remotecall_isLebaItemOpen".equals(localObject2))
      {
        i1 = paramBundle.getInt("appId", -1);
        paramBundle = LebaShowListManager.a().a();
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label595;
        }
        LebaShowListManager.a().a(((QQAppInterface)localObject1).getApplication().getApplicationContext(), (QQAppInterface)localObject1);
        paramBundle = LebaShowListManager.a().a();
      }
      label593:
      label595:
      for (;;)
      {
        if (paramBundle != null)
        {
          paramBundle = paramBundle.iterator();
          do
          {
            if (!paramBundle.hasNext()) {
              break;
            }
            localObject1 = (LebaViewItem)paramBundle.next();
          } while ((localObject1 == null) || (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != i1));
        }
        for (i1 = ((LebaViewItem)localObject1).jdField_a_of_type_Byte;; i1 = -1)
        {
          if (i1 == -1) {
            break label593;
          }
          paramBundle = new Bundle();
          if (i1 == 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramBundle.putBoolean("isLebaItemOpen", bool);
            return paramBundle;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PluginRedTouchRemoteCommand", 2, "onRemoteInvoke unknow invokeCmd");
          return null;
        }
        break;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = PluginCommunicationHandler.getInstance();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.register(new PluginRedTouchRemoteCommand("redtouchipccmd", true));
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramBundle = a(paramBundle);
    if (paramOnInvokeFinishLinstener != null) {
      paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
    }
    return paramBundle;
  }
  
  public boolean isSynchronized()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\PluginRedTouchRemoteCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */