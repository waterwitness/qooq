package com.tencent.mobileqq.emosm.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;

public class SimpleFloatViewManager
  implements DragSortListView.FloatViewManager
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public SimpleFloatViewManager(XListView paramXListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -16777216;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
  }
  
  public View a(int paramInt)
  {
    View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetXListView.m() + paramInt - this.jdField_a_of_type_ComTencentWidgetXListView.s());
    if (localView == null) {}
    do
    {
      return null;
      localView.setPressed(false);
      localView.setDrawingCacheEnabled(true);
    } while (localView.getDrawingCache() == null);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(localView.getDrawingCache());
    localView.setDrawingCacheEnabled(false);
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentWidgetXListView.getContext());
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new ViewGroup.LayoutParams(localView.getWidth(), localView.getHeight()));
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void a(View paramView)
  {
    ((ImageView)paramView).setImageDrawable(null);
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  public void a(View paramView, Point paramPoint1, Point paramPoint2) {}
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\view\SimpleFloatViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */