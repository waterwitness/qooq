import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.HashMap;

class rti
  implements FileManagerUtil.IGetVideoCallback
{
  rti(rtg paramrtg, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    Drawable localDrawable;
    if (paramBitmap == null)
    {
      localDrawable = QfileLocalFileBaseExpandableListAdapter.a(this.jdField_a_of_type_Rtg.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileBaseExpandableListAdapter).getResources().getDrawable(FileManagerUtil.c(this.jdField_a_of_type_Rtg.jdField_a_of_type_Int));
      if (!(localDrawable instanceof BitmapDrawable)) {
        break label94;
      }
      localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
    }
    for (;;)
    {
      QfileLocalFileBaseExpandableListAdapter.a(this.jdField_a_of_type_Rtg.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileBaseExpandableListAdapter).put(Integer.valueOf(this.jdField_a_of_type_Int), localBitmap);
      new Handler(Looper.getMainLooper()).post(new rtj(this, localBitmap));
      return;
      label94:
      localBitmap = paramBitmap;
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */