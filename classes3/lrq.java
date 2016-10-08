import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lrq
  extends DownloadIconsListener
{
  public lrq(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("DownloadIconsListener onDownloadSuc, key=").append(paramString).append(", bitmap is null?");
      if (paramBitmap == null)
      {
        bool1 = true;
        QLog.d("Q.lebatab.leba", 2, bool1);
      }
    }
    else
    {
      int j = this.a.a.getCount();
      i = 0;
      bool1 = bool2;
      label72:
      if (i >= j) {
        break label222;
      }
      localObject = (LebaViewItem)this.a.a.getItem(i);
      if ((localObject == null) || (((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (!paramString.equals(((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)) || (paramBitmap == null)) {
        break label242;
      }
      ((LebaViewItem)localObject).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      localObject = LebaUtil.a(this.a.a(), paramString, ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL);
      if ((localObject != null) && (paramBitmap != null) && (BaseApplicationImpl.a != null))
      {
        localObject = "LebaIcon://" + ((File)localObject).getAbsolutePath();
        if (BaseApplicationImpl.a.get(localObject) == null) {
          BaseApplicationImpl.a.put(localObject, paramBitmap);
        }
      }
      bool1 = true;
    }
    label222:
    label242:
    for (;;)
    {
      i += 1;
      break label72;
      bool1 = false;
      break;
      this.a.b(new lrr(this, paramString, paramBitmap, bool1));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */