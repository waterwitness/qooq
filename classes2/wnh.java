import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class wnh
  extends BaseAdapter
{
  public wnh(PhotoWallView paramPhotoWallView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    URLDrawable localURLDrawable = null;
    View localView;
    if (paramView == null)
    {
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904304, paramViewGroup, false);
      paramView = (ImageView)localView.findViewById(2131302246);
      paramViewGroup = new wnj(this.a, null);
      paramViewGroup.a = paramView;
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      ProfilePhotoWall localProfilePhotoWall = (ProfilePhotoWall)this.a.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
      try
      {
        paramView = new URL("qzone_cover", "original", localProfilePhotoWall.getThumbUrl(this.a.jdField_a_of_type_Int));
        if (paramView != null)
        {
          if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.getResources().getDrawable(2131427636);
          }
          localURLDrawable = URLDrawable.getDrawable(paramView, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        paramViewGroup.a.setImageDrawable(localURLDrawable);
        localView.setOnClickListener(new wni(this, localProfilePhotoWall, paramInt));
        return localView;
        paramViewGroup = (wnj)paramView.getTag();
        localView = paramView;
      }
      catch (MalformedURLException paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qzonecover.", 2, paramView.toString());
          }
          paramView = null;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qzonecover.", 2, paramView.toString());
          }
          paramView = null;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wnh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */