import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.HashMap;

public class rtg
  implements Runnable
{
  public rtg(QfileLocalFileBaseExpandableListAdapter paramQfileLocalFileBaseExpandableListAdapter, String paramString, int paramInt1, int paramInt2, int paramInt3, QfileLocalFileBaseExpandableListAdapter.LocalItemHolder paramLocalItemHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_JavaLangString.hashCode();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int != 0) {
          continue;
        }
        if (!FileUtils.b(this.jdField_a_of_type_JavaLangString)) {
          return;
        }
        localBitmap = MediaStoreUtil.a(this.jdField_a_of_type_JavaLangString, this.b, this.c);
        if (localBitmap != null) {
          continue;
        }
        localDrawable = QfileLocalFileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileBaseExpandableListAdapter).getResources().getDrawable(FileManagerUtil.c(this.jdField_a_of_type_Int));
        if (!(localDrawable instanceof BitmapDrawable)) {
          continue;
        }
        localBitmap = ((BitmapDrawable)localDrawable).getBitmap();
      }
      catch (Exception localException)
      {
        Bitmap localBitmap;
        Drawable localDrawable;
        Object localObject = QfileLocalFileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileBaseExpandableListAdapter).getResources().getDrawable(FileManagerUtil.c(this.jdField_a_of_type_Int));
        if (!(localObject instanceof BitmapDrawable)) {
          continue;
        }
        localObject = ((BitmapDrawable)localObject).getBitmap();
        QfileLocalFileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileBaseExpandableListAdapter).put(Integer.valueOf(i), localObject);
        return;
        if (!(localObject instanceof SkinnableBitmapDrawable)) {
          continue;
        }
        localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
        continue;
        localObject = null;
        continue;
        continue;
      }
      QfileLocalFileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileBaseExpandableListAdapter).put(Integer.valueOf(i), localBitmap);
      new Handler(Looper.getMainLooper()).post(new rth(this, localBitmap));
      return;
      if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
        continue;
      }
      localBitmap = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      FileManagerUtil.a(this.jdField_a_of_type_JavaLangString, true, 220, 220, 3, new rti(this, i));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */