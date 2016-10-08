import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.WifiConversationManager;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class rar
  implements Runnable
{
  public rar(ConfigServlet paramConfigServlet, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    try
    {
      Node localNode = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(this.jdField_a_of_type_JavaLangString.getBytes("utf-8"))).getElementsByTagName("QQHotSpot").item(0);
      if (localNode.getNodeType() == 1)
      {
        Object localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {
          i = 4;
        }
        localObject = ((BaseApplication)localObject).getSharedPreferences("qq_hotspot_config", i);
        localNode = localNode.getFirstChild();
        if (localNode != null)
        {
          if (localNode.getNodeType() == 1)
          {
            if (localNode.getFirstChild() == null) {
              break label202;
            }
            ((SharedPreferences)localObject).edit().putString(localNode.getNodeName(), localNode.getFirstChild().getNodeValue()).commit();
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, "parse QQHotSpotXml xml key :" + localNode.getNodeName() + " value :" + localNode.getFirstChild().getNodeValue());
            }
          }
          for (;;)
          {
            localNode = localNode.getNextSibling();
            break;
            label202:
            ((SharedPreferences)localObject).edit().putString(localNode.getNodeName(), "").commit();
            if (QLog.isColorLevel()) {
              QLog.i("SPLASH_ConfigServlet", 2, "parse QQHotSpotXml xml key :" + localNode.getNodeName() + " value :");
            }
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("SPLASH_ConfigServlet", 2, "parse QQHotSpotXml xml  exception : " + localException.getMessage());
      }
    }
    do
    {
      SharedPreUtils.p(this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime().getApplication(), this.jdField_a_of_type_Int);
    } while (!HotSpotNodeUtil.d());
    WifiConversationManager.a().c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */