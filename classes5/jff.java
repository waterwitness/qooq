import android.app.Activity;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.biz.troopplugin.PluginJumpManager.BidInfo;
import com.tencent.biz.troopplugin.PluginJumpManager.UrlMappingInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;

public class jff
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public jff(PluginJumpManager paramPluginJumpManager, PluginJumpManager.BidInfo paramBidInfo, Activity paramActivity, String paramString1, String paramString2, String paramString3, long paramLong, PluginJumpManager.UrlMappingInfo paramUrlMappingInfo, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager = paramPluginManagerClient;
    paramPluginManagerClient = this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager.queryPlugin(this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$BidInfo.b);
    int i;
    if (paramPluginManagerClient != null) {
      if (paramPluginManagerClient.mState == 4)
      {
        this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.launchPlugin(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$BidInfo.b, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$BidInfo.c, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$UrlMappingInfo.b, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$UrlMappingInfo.a);
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.openLinkInNewWebView(this.jdField_a_of_type_AndroidAppActivity, this.b, this.d);
      }
      return;
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 0, this.b, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$UrlMappingInfo.b, null, null);
      this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager.installPlugin(this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$BidInfo.b);
      i = 0;
      continue;
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 1, this.b, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$UrlMappingInfo.b, null, null);
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */