import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.NonMainAppListViewFaceLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class voi
  extends Handler
{
  public voi(NonMainAppListViewFaceLoader paramNonMainAppListViewFaceLoader, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      this.a.a();
    }
    for (;;)
    {
      return;
      if ((paramMessage.what == 1002) && (this.a.jdField_a_of_type_Int == 0)) {
        try
        {
          Object localObject1 = (Bundle)paramMessage.obj;
          paramMessage = (Bitmap)((Bundle)localObject1).getParcelable("bmp");
          localObject1 = ((Bundle)localObject1).getString("uin");
          if (paramMessage != null) {
            this.a.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localObject1, paramMessage);
          }
          if (QLog.isColorLevel()) {
            QLog.d("NonMainAppListViewFaceLoader", 2, "refreshImg, uin:" + (String)localObject1);
          }
          int j = this.a.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
          int i = 0;
          while (i < j)
          {
            Object localObject2 = this.a.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
            if ((localObject2 instanceof FacePreloadBaseAdapter.ViewHolder))
            {
              localObject2 = (FacePreloadBaseAdapter.ViewHolder)localObject2;
              if ((localObject2 != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject2).b != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject2).b.equals(localObject1))) {
                ((FacePreloadBaseAdapter.ViewHolder)localObject2).d.setImageBitmap(paramMessage);
              }
            }
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception paramMessage) {}
      }
    }
    QLog.e("NonMainAppListViewFaceLoader", 2, "refreshImg, exception:" + paramMessage.toString());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\voi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */