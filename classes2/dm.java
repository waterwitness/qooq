import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.ItemHolder;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class dm
  extends BaseAdapter
{
  public static final int a = 3;
  public ItemHolder a;
  public DataLineMsgSet a;
  private AsyncImageView[] jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView;
  private int b;
  private int c;
  
  private dm(DatalineSessionAdapter paramDatalineSessionAdapter, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView = new AsyncImageView[3];
    this.jdField_a_of_type_ComDatalineUtilItemHolder = paramItemHolder;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
    this.b = paramInt;
    this.c = paramInt;
    b();
  }
  
  private void b()
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i] = new AsyncImageView(DatalineSessionAdapter.a(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter));
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setLayoutParams(new AbsListView.LayoutParams(this.b, this.c));
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setAdjustViewBounds(false);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setDefaultImage(2130843492);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setIsDrawRound(false);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setAsyncClipSize(this.b, this.c);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setTag(this.jdField_a_of_type_ComDatalineUtilItemHolder);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setClickable(true);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setLongClickable(true);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnClickListener(DatalineSessionAdapter.a(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter));
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnLongClickListener(DatalineSessionAdapter.a(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter).jdField_a_of_type_AndroidViewView$OnLongClickListener);
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnTouchListener(DatalineSessionAdapter.a(this.jdField_a_of_type_ComDatalineUtilDatalineSessionAdapter).jdField_a_of_type_AndroidViewView$OnTouchListener);
      i += 1;
    }
  }
  
  public void a()
  {
    int i = 0;
    if (i < 3)
    {
      AsyncImageView localAsyncImageView = this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i];
      localAsyncImageView.setTag(this.jdField_a_of_type_ComDatalineUtilItemHolder);
      DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(i);
      if (localDataLineMsgRecord == null) {
        localAsyncImageView.setImageResource(2130843492);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localDataLineMsgRecord.path != null) && (new File(localDataLineMsgRecord.path).exists())) {
          localAsyncImageView.setAsyncImage(localDataLineMsgRecord.path);
        } else if (localDataLineMsgRecord.thumbPath != null) {
          localAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        }
      }
    }
  }
  
  public int getCount()
  {
    return 3;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt >= 3) {
      paramView = null;
    }
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      return paramView;
      paramViewGroup = this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[paramInt];
      paramViewGroup.setTag(this.jdField_a_of_type_ComDatalineUtilItemHolder);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(paramInt);
      if (localDataLineMsgRecord == null)
      {
        paramViewGroup.setImageResource(2130843492);
        return paramViewGroup;
      }
      if ((localDataLineMsgRecord.path != null) && (new File(localDataLineMsgRecord.path).exists()))
      {
        paramViewGroup.setAsyncImage(localDataLineMsgRecord.path);
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (localDataLineMsgRecord.thumbPath == null);
    paramViewGroup.setAsyncImage(localDataLineMsgRecord.thumbPath);
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */