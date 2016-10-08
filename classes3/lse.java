import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class lse
  extends DownloadIconsListener
{
  public lse(LebaListMgrActivity paramLebaListMgrActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int k = 0;
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {}
    label226:
    label227:
    for (;;)
    {
      return;
      int m = LebaListMgrActivity.a(this.a).getCount();
      int j = 0;
      int i = k;
      if (j < m)
      {
        Object localObject = LebaListMgrActivity.a(this.a).getItem(j);
        if ((localObject != null) && ((localObject instanceof LebaViewItem)))
        {
          localObject = (LebaViewItem)localObject;
          if ((((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (paramString.equals(((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)))
          {
            ((LebaViewItem)localObject).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
            j = 1;
            localObject = LebaUtil.a(this.a, paramString, ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL);
            i = j;
            if (localObject == null) {
              break label226;
            }
            i = j;
            if (paramBitmap == null) {
              break label226;
            }
            i = j;
            if (BaseApplicationImpl.a == null) {
              break label226;
            }
            localObject = "LebaIcon://" + ((File)localObject).getAbsolutePath();
            if (BaseApplicationImpl.a.get(localObject) == null) {
              BaseApplicationImpl.a.put(localObject, paramBitmap);
            }
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label227;
        }
        this.a.runOnUiThread(new lsf(this, paramString));
        return;
        j += 1;
        break;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */