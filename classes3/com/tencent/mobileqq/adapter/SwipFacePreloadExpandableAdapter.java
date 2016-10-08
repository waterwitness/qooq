package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.adapter.contacts.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;

public abstract class SwipFacePreloadExpandableAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public ExpandableListView a;
  
  public SwipFacePreloadExpandableAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    ImageUtil.a();
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof SwipFacePreloadExpandableAdapter.ViewHolder)))
      {
        localObject = (SwipFacePreloadExpandableAdapter.ViewHolder)localObject;
        if (paramString != null) {
          break label68;
        }
        a((SwipFacePreloadExpandableAdapter.ViewHolder)localObject, null, false);
      }
      label68:
      while (!paramString.equals(((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
      {
        i += 1;
        break;
      }
      ((SwipFacePreloadExpandableAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) && (paramBitmap != null)) {
      a(paramString, paramBitmap);
    }
  }
  
  protected void a(SwipFacePreloadExpandableAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    a(paramViewHolder, paramBitmap, true);
  }
  
  protected void a(SwipFacePreloadExpandableAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (AppConstants.aj.equals(paramViewHolder.jdField_a_of_type_JavaLangString))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840319);
      return;
    }
    if (AppConstants.ak.equals(paramViewHolder.jdField_a_of_type_JavaLangString))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840317);
      return;
    }
    if (AppConstants.al.equals(paramViewHolder.jdField_a_of_type_JavaLangString))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840322);
      return;
    }
    if (AppConstants.ai.equals(paramViewHolder.jdField_a_of_type_JavaLangString))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838437);
      return;
    }
    Bitmap localBitmap;
    if (paramBitmap == null) {
      if ((AppConstants.aG.equals(paramViewHolder.jdField_a_of_type_JavaLangString)) && ((paramViewHolder instanceof BuddyListFriends.BuddyChildTag)))
      {
        Object localObject = (Friends)((BuddyListFriends.BuddyChildTag)paramViewHolder).a;
        localBitmap = paramBitmap;
        if (localObject != null) {
          if (DeviceHeadMgr.a().a(((Friends)localObject).name))
          {
            localObject = DeviceHeadMgr.a().a(((Friends)localObject).name);
            localBitmap = paramBitmap;
            if (localObject != null) {
              paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
            }
          }
          else
          {
            localBitmap = DeviceHeadMgr.a().a(((Friends)localObject).name);
          }
        }
        paramBitmap = localBitmap;
      }
    }
    for (;;)
    {
      if (paramBitmap == null) {
        if (paramBoolean)
        {
          paramBitmap = ImageUtil.a();
          label217:
          localBitmap = paramBitmap;
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())
          {
            if ((paramViewHolder.jdField_a_of_type_Int != 1) || (!(paramViewHolder.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) || (!(paramViewHolder instanceof BuddyListFriends.BuddyChildTag))) {
              break label398;
            }
            localBitmap = paramBitmap;
            if (((BuddyListFriends.BuddyChildTag)paramViewHolder).b)
            {
              this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_a_of_type_Int, false);
              localBitmap = paramBitmap;
            }
          }
        }
      }
      for (;;)
      {
        if (localBitmap == null) {
          break label428;
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap));
        return;
        if ((paramViewHolder.jdField_a_of_type_Int == 1) && ((paramViewHolder.jdField_a_of_type_AndroidWidgetImageView instanceof DynamicAvatarView)) && ((paramViewHolder instanceof BuddyListFriends.BuddyChildTag)))
        {
          if (!((BuddyListFriends.BuddyChildTag)paramViewHolder).b) {
            ((DynamicAvatarView)paramViewHolder.jdField_a_of_type_AndroidWidgetImageView).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramViewHolder.jdField_a_of_type_JavaLangString, 100, false, true, 1);
          }
          break;
        }
        paramBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString);
        break;
        label398:
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_a_of_type_Int, false);
        localBitmap = paramBitmap;
        continue;
        break label217;
        localBitmap = paramBitmap;
      }
      label428:
      break;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      DynamicFaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      a(null, null);
    }
    DynamicFaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\SwipFacePreloadExpandableAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */